#!/usr/bin/env bash
# Monta um port nativo para Linux do Brasfoot a partir do instalador Windows.
#
# O que a engenharia reversa (REA + CFR) mostrou:
#   - brasfoot22-23.exe  = instalador NSIS com os dados do jogo.
#   - bf22-23.exe        = stub Launch4j + JAR Java (Main: best.h2, bytecode Java 7).
#   - O jogo é 100% Java/Swing, sem DLLs. Caminhos usam "/" relativos a user.dir.
#   - Saves usam Kryo 4 (reflexão) -> roda num JRE 8, o mesmo alvo do original.
#   - 18 arquivos têm nomes em Windows-1252 e precisam virar UTF-8.
#
# Uso: ./build-linux-port.sh [instalador.exe] [diretório-destino]
set -euo pipefail

HERE="$(cd "$(dirname "$0")" && pwd)"
INSTALLER="$(realpath "${1:-$HERE/brasfoot22-23.exe}")"
DEST="$(realpath -m "${2:-$HERE/brasfoot-linux}")"
WORK="$(mktemp -d "$HERE/.build.XXXXXX")"
trap 'rm -rf "$WORK"' EXIT

SEVENZIP_URL="https://github.com/ip7z/7zip/releases/download/24.09/7z2409-linux-x64.tar.xz"
JRE_URL="https://api.adoptium.net/v3/binary/latest/8/ga/linux/x64/jre/hotspot/normal/eclipse"

echo ">> Baixando 7-Zip (para abrir o instalador NSIS)"
mkdir -p "$WORK/7z"
curl -fsSL "$SEVENZIP_URL" | tar xJ -C "$WORK/7z"

echo ">> Extraindo instalador"
"$WORK/7z/7zz" x -y -bso0 -o"$WORK/inst" "$INSTALLER"
rm -rf "$WORK/inst/\$PLUGINSDIR"

echo ">> Convertendo nomes de arquivo Windows-1252 -> UTF-8"
python3 -I - "$WORK/inst" <<'PY'
import os, sys, unicodedata
root = os.fsencode(sys.argv[1])
for d, dirs, files in os.walk(root, topdown=False):
    for name in files + dirs:
        try:
            name.decode("utf-8")
            continue
        except UnicodeDecodeError:
            pass
        fixed = unicodedata.normalize("NFC", name.decode("cp1252")).encode("utf-8")
        os.rename(os.path.join(d, name), os.path.join(d, fixed))
        print("   ", fixed.decode())
PY

echo ">> Extraindo ícone original do executável"
"$WORK/7z/7zz" e -y -bso0 -tPE -o"$WORK/ico" "$WORK/inst/bf22-23.exe" ".rsrc/ICON/1.ico"

echo ">> Extraindo o JAR do wrapper Launch4j"
mkdir -p "$WORK/jar"
# unzip retorna 1 por causa dos bytes do stub antes do ZIP; é esperado.
unzip -qo "$WORK/inst/bf22-23.exe" -d "$WORK/jar" || [ $? -eq 1 ]
rm "$WORK/inst/bf22-23.exe"

echo ">> Montando diretório $DEST"
mkdir -p "$DEST"
cp -a "$WORK/inst/." "$DEST/"
python3 -I - "$WORK/jar" "$DEST/brasfoot.jar" <<'PY'
import os, sys, zipfile
src, out = sys.argv[1], sys.argv[2]
with zipfile.ZipFile(out, "w", zipfile.ZIP_DEFLATED) as z:
    z.write(os.path.join(src, "META-INF/MANIFEST.MF"), "META-INF/MANIFEST.MF")
    for d, _, files in os.walk(src):
        for f in sorted(files):
            full = os.path.join(d, f)
            rel = os.path.relpath(full, src)
            if rel != "META-INF/MANIFEST.MF":
                z.write(full, rel)
PY

if [ ! -x "$DEST/jre/bin/java" ]; then
    echo ">> Baixando JRE 8 (Temurin)"
    mkdir -p "$WORK/jre"
    curl -fsSL "$JRE_URL" | tar xz -C "$WORK/jre"
    rm -rf "$DEST/jre"
    mv "$WORK/jre"/* "$DEST/jre"
fi

echo ">> Ícone"
# Converte a maior imagem do .ico para PNG (PNG embutido ou DIB BGRA de 32 bits).
python3 -I - "$WORK/ico/1.ico" "$DEST/brasfoot.png" <<'PY'
import struct, sys, zlib
data = open(sys.argv[1], "rb").read()
count = struct.unpack_from("<HHH", data, 0)[2]
entries = [struct.unpack_from("<BBBBHHII", data, 6 + 16 * i) for i in range(count)]
best = max(entries, key=lambda e: ((e[0] or 256) * (e[1] or 256), e[5]))
blob = data[best[7]:best[7] + best[6]]
if not blob.startswith(b"\x89PNG"):
    hdr, w, h2, _, bpp = struct.unpack_from("<IiiHH", blob, 0)
    assert bpp == 32, "ícone de %d bits não suportado" % bpp
    h = h2 // 2
    rows = []
    for y in range(h - 1, -1, -1):  # DIB é gravado de baixo para cima
        row = blob[hdr + y * w * 4: hdr + (y + 1) * w * 4]
        rgba = bytearray(row)
        rgba[0::4], rgba[2::4] = row[2::4], row[0::4]
        rows.append(b"\0" + bytes(rgba))
    chunk = lambda t, c: struct.pack(">I", len(c)) + t + c + struct.pack(">I", zlib.crc32(t + c))
    blob = (b"\x89PNG\r\n\x1a\n"
            + chunk(b"IHDR", struct.pack(">IIBBBBB", w, h, 8, 6, 0, 0, 0))
            + chunk(b"IDAT", zlib.compress(b"".join(rows), 9))
            + chunk(b"IEND", b""))
open(sys.argv[2], "wb").write(blob)
PY

echo ">> Lançador"
cat > "$DEST/brasfoot.sh" <<'SH'
#!/usr/bin/env bash
# O jogo resolve todos os arquivos a partir do diretório de trabalho.
cd "$(dirname "$(readlink -f "$0")")"
# Nomes de arquivo com acento exigem um locale UTF-8 para a JVM.
case "${LC_ALL:-${LC_CTYPE:-${LANG:-}}}" in
    *[Uu][Tt][Ff]-8*|*[Uu][Tt][Ff]8*) ;;
    *) export LC_ALL=C.UTF-8 ;;
esac
JAVA=./jre/bin/java
[ -x "$JAVA" ] || JAVA=java
exec "$JAVA" -Dfile.encoding=UTF-8 -Dawt.useSystemAAFontSettings=on \
    -Dsun.java2d.uiScale="${BRASFOOT_SCALE:-1}" \
    -jar brasfoot.jar "$@"
SH
chmod +x "$DEST/brasfoot.sh"

cat > "$DEST/brasfoot.desktop" <<EOF
[Desktop Entry]
Type=Application
Name=Brasfoot 22-23
Comment=Gerenciador de futebol
Exec="$DEST/brasfoot.sh"
Path=$DEST
Icon=$DEST/brasfoot.png
Terminal=false
Categories=Game;SportsGame;
EOF

echo ">> Pronto: $DEST/brasfoot.sh"
echo "   Para adicionar ao menu: cp '$DEST/brasfoot.desktop' ~/.local/share/applications/"
