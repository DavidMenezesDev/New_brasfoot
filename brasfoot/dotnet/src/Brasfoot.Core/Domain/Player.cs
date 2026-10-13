using System.Text.Json.Serialization;

namespace Brasfoot.Core.Domain;

/// <summary>Jogador (<c>best.F</c>).</summary>
public sealed class Player
{
    /// <summary>Identificador estável para persistência e referências cruzadas no save.</summary>
    public int Id { get; set; }

    public required string Name { get; set; }
    public int Nationality { get; set; }
    public Position Position { get; set; }
    public Side Side { get; set; }

    /// <summary>Características (0..13, ver <see cref="Characteristic"/>); -1 quando ausente.</summary>
    public int Cr1 { get; set; } = -1;
    public int Cr2 { get; set; } = -1;

    public int Age { get; set; }
    public bool IsStar { get; set; }
    public bool IsWorldClass { get; set; }

    /// <summary>Titular no banco de dados original (<c>status == 1</c>); aumenta força e valor.</summary>
    public bool IsStarter { get; set; }

    public bool IsJunior { get; set; }

    /// <summary>Potencial oculto 1..10 (o "hash" do arquivo).</summary>
    public int Potential { get; set; }

    /// <summary>Força 1..100: a principal entrada do motor de partidas.</summary>
    public int Strength { get; set; }

    /// <summary>Energia 0..100; só afeta substituições e duração de lesões.</summary>
    public int Energy { get; set; } = 100;

    public Team? Club { get; set; }

    // Economia
    public long Salary { get; set; }
    public long Value { get; set; }
    public long AskingPrice { get; set; }
    public DateOnly ContractEnd { get; set; }
    public bool IsListed { get; set; }
    public bool IsLoanable { get; set; }
    public bool IsOnLoan { get; set; }
    public int? PreviousClubId { get; set; }

    /// <summary>Temporada em que subiu dos juniores (0 = nunca); reduz o valor nas 3 temporadas seguintes.</summary>
    public int PromotedSeason { get; set; }

    // Condição
    public DateOnly? InjuredUntil { get; set; }
    public bool PlayedThisRound { get; set; }
    public double LastRating { get; set; }

    // Estado de partida (transiente)
    public int Slot { get; set; } = -1;

    /// <summary>Ordem no banco escolhida pelo técnico humano (-1 = fora do banco).</summary>
    public int BenchOrder { get; set; } = -1;
    public int YellowsInMatch { get; set; }
    public MatchSheet Sheet { get; set; } = new();

    public Dictionary<int, CompetitionRecord> CompetitionStats { get; set; } = new();

    [JsonIgnore]
    public PlayerRole Role => ComputeRole();

    public bool Has(Characteristic c) => Cr1 == (int)c || Cr2 == (int)c;
    public bool Cr1Is(Characteristic c) => Cr1 == (int)c;

    public bool IsInjured(DateOnly today) => InjuredUntil is { } d && d > today;

    public int ContractDaysLeft(DateOnly today) => Math.Max(0, ContractEnd.DayNumber - today.DayNumber);

    public CompetitionRecord StatsFor(Competition competition)
    {
        if (!CompetitionStats.TryGetValue(competition.Id, out var record))
            CompetitionStats[competition.Id] = record = new CompetitionRecord();
        return record;
    }

    /// <summary><c>F.fG()</c>: papel tático a partir da posição e das características.</summary>
    private PlayerRole ComputeRole()
    {
        int a = Cr1, b = Cr2;
        return Position switch
        {
            Position.Goleiro or Position.Zagueiro => PlayerRole.Defensivo,
            Position.Lateral =>
                a is 13 or 6 ? PlayerRole.Ofensivo
                : a is 7 or 10 ? PlayerRole.Defensivo
                : b == 13 || a == 6 ? PlayerRole.Ofensivo
                : b is 7 or 10 ? PlayerRole.Defensivo
                : a is 8 or 9 or 11 or 4 ? PlayerRole.Ofensivo : PlayerRole.Defensivo,
            Position.Meia =>
                a is 11 or 9 or 8 or 4 ? PlayerRole.Ofensivo
                : a is 7 or 10 ? PlayerRole.Defensivo
                : b is 11 or 9 or 8 or 4 ? PlayerRole.Ofensivo
                : b is 7 or 10 ? PlayerRole.Defensivo : PlayerRole.Ofensivo,
            Position.Atacante =>
                a is 7 or 10 ? PlayerRole.Defensivo
                : a is 8 or 13 or 6 ? PlayerRole.Ponta : PlayerRole.Ofensivo,
            _ => PlayerRole.Defensivo,
        };
    }

    public override string ToString() => $"{Name} ({Position.ToString()[0]}, {Strength})";
}

/// <summary>Súmula individual da partida em andamento (<c>components.s</c>).</summary>
public sealed class MatchSheet
{
    public int Goals { get; set; }
    public int OwnGoals { get; set; }
    public int PenaltiesMissed { get; set; }
    public int Yellows { get; set; }
    public int Reds { get; set; }
    public int Assists { get; set; }
    public int PenaltySaves { get; set; }
    public int ShotsSaved { get; set; }

    public void Reset()
    {
        Goals = OwnGoals = PenaltiesMissed = Yellows = Reds = Assists = PenaltySaves = ShotsSaved = 0;
    }
}

/// <summary>Estatísticas do jogador numa competição (<c>best.H</c>).</summary>
public sealed class CompetitionRecord
{
    public int Games { get; set; }
    public int Goals { get; set; }

    /// <summary>Amarelos acumulados (suspensão no 3º).</summary>
    public int Yellows { get; set; }

    /// <summary>Jogos de suspensão a cumprir.</summary>
    public int BanMatches { get; set; }

    public double RatingSum { get; set; }
    public int RatedGames { get; set; }

    public bool IsSuspended => Yellows >= 3 || BanMatches >= 1;
    public double AverageRating => RatedGames == 0 ? 0 : RatingSum / RatedGames;
}
