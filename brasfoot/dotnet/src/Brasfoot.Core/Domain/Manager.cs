namespace Brasfoot.Core.Domain;

/// <summary>Técnico de clube (<c>best.al</c>). Spec: <c>re/spec-financas-carreira.md</c> §11.</summary>
public sealed class Manager
{
    /// <summary>Confiança padrão da diretoria ao assumir um clube (<c>of</c>).</summary>
    public const int DefaultConfidence = 95;

    /// <summary>Apoio padrão da torcida ao assumir um clube (<c>og</c>).</summary>
    public const int DefaultFanSupport = 85;

    /// <summary>Identificador estável para persistência.</summary>
    public int Id { get; set; }

    public required string Name { get; set; }

    /// <summary>Confiança da diretoria, 0..100 (<c>of</c>, <c>best/al.java:43</c>).</summary>
    public int Confidence { get; set; } = DefaultConfidence;

    /// <summary>Apoio da torcida, 0..100 (<c>og</c>, <c>best/al.java:44</c>).</summary>
    public int FanSupport { get; set; } = DefaultFanSupport;

    /// <summary>Temporadas no clube atual (<c>oi</c>).</summary>
    public int SeasonsAtClub { get; set; }

    /// <summary>Pontos de carreira acumulados por partidas e títulos (<c>oc</c>).</summary>
    public int CareerPoints { get; set; }

    /// <summary>Partidas na carreira (<c>W</c>).</summary>
    public int CareerMatches { get; set; }

    /// <summary>Vitórias na carreira (<c>od</c>).</summary>
    public int CareerWins { get; set; }

    /// <summary>Derrotas na carreira (<c>oe</c>).</summary>
    public int CareerLosses { get; set; }

    /// <summary>Reputação do técnico, 0..5 (<c>nc</c>, <c>best/al.java:45</c>).</summary>
    public int Reputation { get; set; }

    /// <summary>Acumulador de prestígio/prêmios que alimenta a reputação (<c>nu</c>, <c>kk()</c>).</summary>
    public long Prestige { get; set; }

    /// <summary>Clube atual; <see langword="null"/> quando desempregado (<c>best/al.java:36</c>).</summary>
    public Team? Club { get; set; }

    public bool IsHuman { get; set; }

    public List<TrophyRecord> Trophies { get; set; } = new();
    public List<SeasonRecord> SeasonRecords { get; set; } = new();
    public List<ManagerMessage> Messages { get; set; } = new();

    [System.Text.Json.Serialization.JsonIgnore]
    public bool IsUnemployed => Club is null;

    /// <summary>Vitórias / partidas da temporada informada (usado no limiar de demissão, <c>best/ag.java:64-72</c>).</summary>
    public int WinRateFor(int season)
    {
        var record = SeasonRecords.FirstOrDefault(r => r.Season == season);
        return record is { Games: > 0 } ? record.Wins * 100 / record.Games : 0;
    }

    public SeasonRecord? LastSeasonRecord => SeasonRecords.Count == 0 ? null : SeasonRecords[^1];

    /// <summary>Aplica um delta de confiança com trava 0..100 (<c>cj(...)</c>).</summary>
    public void AdjustConfidence(int delta) => Confidence = Math.Clamp(Confidence + delta, 0, 100);

    /// <summary>Aplica um delta de apoio da torcida com trava 0..100 (<c>ck(...)</c>).</summary>
    public void AdjustFans(int delta) => FanSupport = Math.Clamp(FanSupport + delta, 0, 100);

    /// <summary><c>E(ah)</c>: assume um clube, reiniciando confiança/torcida (<c>best/al.java:761-782</c>).</summary>
    public void TakeClub(Team club)
    {
        Club = club;
        Confidence = DefaultConfidence;
        FanSupport = DefaultFanSupport;
        SeasonsAtClub = 0;
    }

    public override string ToString() => Club is null ? $"{Name} (sem clube)" : $"{Name} ({Club.Name})";
}

/// <summary>Registro de uma temporada de um técnico num clube (<c>best.j</c>).</summary>
public sealed record SeasonRecord(int ClubId, string ClubName, int Season, int Wins, int Draws, int Losses, int Position)
{
    [System.Text.Json.Serialization.JsonIgnore]
    public int Games => Wins + Draws + Losses;
}

/// <summary>Título/campanha registrada na carreira do técnico (<c>best.ao</c> via <c>cT()</c>).</summary>
public sealed record TrophyRecord(int CompetitionId, string CompetitionName, CompetitionType Type, int Season, int Position);

/// <summary>Mensagem da caixa de entrada do técnico (<c>components.as</c>).</summary>
public sealed class ManagerMessage
{
    /// <summary>Tipo (<c>RU</c>); ver <c>re/spec-financas-carreira.md</c> §19.2.</summary>
    public int Type { get; set; }

    /// <summary>Tom/descrição (<c>RV</c>).</summary>
    public int Tone { get; set; }

    /// <summary>Texto principal (<c>Sb</c>).</summary>
    public string Text { get; set; } = "";

    public DateOnly Date { get; set; }

    /// <summary>Nome do jogador envolvido, quando houver (<c>Sa</c>).</summary>
    public string? PlayerName { get; set; }

    /// <summary>Código de valor do jogador (<c>oq</c>).</summary>
    public int ValueCode { get; set; }

    /// <summary>Clube relacionado, quando houver.</summary>
    public int ClubId { get; set; }

    public bool Read { get; set; }

    public override string ToString() => $"[{Type}/{Tone}] {Text}";
}
