using System.Text.Json.Serialization;

namespace Brasfoot.Core.Domain;

/// <summary>Clube (<c>best.ah</c>).</summary>
public sealed class Team
{
    public int Id { get; set; }
    public required string Name { get; set; }

    /// <summary>Nome do arquivo de origem; também identifica escudo e camisas.</summary>
    public string FileRef { get; set; } = "";

    public int CountryId { get; set; }
    public int State { get; set; }

    /// <summary>Nível 1..25.</summary>
    public int Level { get; set; } = 10;

    /// <summary>Reputação 0..5 (o que vale para clubes fora de liga).</summary>
    public int Reputation { get; set; }

    /// <summary>Divisão (1 = elite); 0 para clubes fora de uma liga simulada.</summary>
    public int Division { get; set; }

    /// <summary>Clube de uma liga nacional simulada (<c>ah.kn()</c>), em oposição aos "clubes de reputação".</summary>
    public bool IsLeagueClub { get; set; }

    public bool IsHuman { get; set; }
    public long Cash { get; set; }

    public string Stadium { get; set; } = "";
    public int Capacity { get; set; }
    public string Coach { get; set; } = "";

    public List<Player> Squad { get; set; } = new();
    public List<Player> Juniors { get; set; } = new();

    public Tactics Tactics { get; set; } = new();
    public Player? FreeKickTaker { get; set; }
    public Player? CornerTaker { get; set; }

    /// <summary>Desempate aleatório 1..1000 ao ordenar clubes de mesmo nível (<c>ah.hr</c>).</summary>
    public int RankTiebreak { get; set; }

    [JsonIgnore]
    public Continent Continent => Countries.Get(CountryId).Continent;
    [JsonIgnore]
    public bool IsInTopFiveLeague => Countries.TopFive.Contains(CountryId);

    /// <summary>
    /// Folha salarial completa (<c>ah.kK()</c>, <c>best/ah.java:1717-1727</c>): soma de
    /// <see cref="Player.Salary"/> do elenco e dos juniores. O valor já embute o ×4 do salário mensal.
    /// </summary>
    [JsonIgnore]
    public long Payroll => Squad.Sum(p => p.Salary) + Juniors.Sum(p => p.Salary);

    public override string ToString() => Name;
}

/// <summary>Táticas (<c>ah.kj()</c>): formação, estilo, marcação, jogada.</summary>
public sealed record Tactics(int Formation = 4, Style Style = Style.Equilibrado, Marking Marking = Marking.Leve, Play Play = Play.PeloMeio);

public sealed record Competition(int Id, string Name, CompetitionType Type)
{
    [JsonIgnore]
    public bool IsFriendly => Type is CompetitionType.Amistoso or CompetitionType.TorneioAmistoso;

    /// <summary><c>I.hX()</c>: Mundial de clubes e Seleções são jogados em campo neutro.</summary>
    [JsonIgnore]
    public bool IsNeutralVenue => Type is CompetitionType.Mundial or CompetitionType.Selecoes;

    /// <summary>
    /// Continente (<c>at.gg()</c>, <c>best/at.java:72,491-494</c>): 0 Europa, 1 América do Sul,
    /// 2 África, 3 Ásia, 4 Concacaf, 5 Oceania, 7 seleções/mundo. -1 quando não se aplica (competições
    /// domésticas). Junto com <see cref="Type"/> (= <c>at.b()</c>) decide o cruzamento de grupos→mata-mata
    /// em <see cref="BracketSeeder.DetermineGroupKnockoutSeeding"/>.
    /// </summary>
    public int Continent { get; init; } = -1;

    /// <summary>
    /// Disputa de 3º lugar (<c>at.mq()</c>/<c>at.O(bool)</c>, <c>best/at.java:40,178-182</c>): ligada
    /// nas competições de seleções e no Mundial de Clubes (<c>f/A,c,d,e,g,h,M,N,p,q</c>, todas com
    /// <c>this.O(true)</c> no construtor), nunca em ligas/copas de clube. Consumida por
    /// <see cref="KnockoutBracket"/> ao montar a fase final (<c>f/G.java:78</c>).
    /// </summary>
    public bool DecisaoTerceiroLugar { get; init; }
}
