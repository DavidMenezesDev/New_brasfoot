using System.IO.Compression;
using System.Text.Json;
using System.Text.Json.Serialization;
using Brasfoot.Core.Domain;

namespace Brasfoot.Data.Saves;

/// <summary>
/// Persistência do <see cref="GameState"/> em JSON comprimido (gzip), preservando referências
/// cruzadas (clubes ↔ jogadores, técnicos ↔ clubes) via <see cref="ReferenceHandler.Preserve"/>.
/// O formato é próprio do port (não é o <c>.s22</c> Kryo do original) — ver
/// <c>re/spec-financas-carreira.md</c> §19.1.
/// </summary>
public static class SaveGame
{
    public static readonly JsonSerializerOptions JsonOptions = new()
    {
        ReferenceHandler = ReferenceHandler.Preserve,
        DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,
        WriteIndented = false,
    };

    public static byte[] Serialize(GameState state)
    {
        var json = JsonSerializer.SerializeToUtf8Bytes(state, JsonOptions);
        using var output = new MemoryStream();
        using (var gzip = new GZipStream(output, CompressionLevel.Optimal, leaveOpen: true))
            gzip.Write(json, 0, json.Length);
        return output.ToArray();
    }

    public static GameState Deserialize(byte[] data)
    {
        using var input = new MemoryStream(data);
        using var gzip = new GZipStream(input, CompressionMode.Decompress);
        using var json = new MemoryStream();
        gzip.CopyTo(json);
        return JsonSerializer.Deserialize<GameState>(json.ToArray(), JsonOptions)
               ?? throw new InvalidDataException("Save vazio ou inválido.");
    }

    public static void Save(string path, GameState state)
    {
        Directory.CreateDirectory(Path.GetDirectoryName(Path.GetFullPath(path))!);
        File.WriteAllBytes(path, Serialize(state));
    }

    public static GameState Load(string path) => Deserialize(File.ReadAllBytes(path));

    /// <summary>Opções do usuário em JSON legível (não vão no save; valem para todos os jogos).</summary>
    public static readonly JsonSerializerOptions OptionsJson = new()
    {
        WriteIndented = true,
        DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,
    };

    public static void SaveOptions(string path, GameOptions options)
    {
        Directory.CreateDirectory(Path.GetDirectoryName(Path.GetFullPath(path))!);
        File.WriteAllText(path, JsonSerializer.Serialize(options, OptionsJson));
    }

    public static GameOptions LoadOptions(string path) =>
        File.Exists(path)
            ? JsonSerializer.Deserialize<GameOptions>(File.ReadAllText(path), OptionsJson) ?? new GameOptions()
            : new GameOptions();
}

/// <summary>Cabeçalho de um slot de save (<c>est.InfoArquivoSalvoType</c>, <c>c/a.java:90-106</c>).</summary>
public sealed record SaveSlotInfo(string Name, string Team, int Season, string Summary)
{
    public override string ToString() => $"{Name}: {Team} — temporada {Season}";
}
