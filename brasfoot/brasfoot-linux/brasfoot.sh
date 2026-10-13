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
