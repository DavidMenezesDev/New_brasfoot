using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Campanha de um clube numa competição (<c>best.ak</c>/<c>components.ah</c>). Campos alinhados com
/// o array de <c>best.ak.lB()</c>: pontos, jogos, vitórias, empates, derrotas, gols pró/contra.
/// </summary>
public sealed class TeamStanding
{
    public TeamStanding(Team team) => Team = team;

    public Team Team { get; }
    public int Played { get; internal set; }
    public int Won { get; internal set; }
    public int Drawn { get; internal set; }
    public int Lost { get; internal set; }
    public int GoalsFor { get; internal set; }
    public int GoalsAgainst { get; internal set; }

    /// <summary>Pontos (<c>ak.nT</c>): 3 por vitória, 1 por empate.</summary>
    public int Points => Won * 3 + Drawn;

    /// <summary>Saldo de gols (<c>ak.lB()[7]</c> = gols pró − gols contra).</summary>
    public int GoalDifference => GoalsFor - GoalsAgainst;

    public override string ToString() =>
        $"{Team.Name} {Points}pts {Played}j {Won}v {Drawn}e {Lost}d {GoalsFor}:{GoalsAgainst}";
}

/// <summary>
/// Classificação de uma liga/grupo. A ordenação reproduz o comparador <c>h.K</c> (<c>h/K.java</c>),
/// usado por <c>f.s.pO()</c> via <c>h.a.abn</c>: pontos, vitórias, saldo de gols e gols pró, todos
/// decrescentes. Empates totais mantêm a ordem de inserção (o comparador devolve 0 e o sort do
/// original é estável).
/// </summary>
public sealed class LeagueTable
{
    private readonly List<TeamStanding> _order = new();
    private readonly Dictionary<Team, TeamStanding> _byTeam = new();

    public LeagueTable(IEnumerable<Team> teams)
    {
        foreach (var team in teams) Add(team);
    }

    public IReadOnlyList<TeamStanding> Rows => _order;

    public TeamStanding Add(Team team)
    {
        if (_byTeam.TryGetValue(team, out var existing)) return existing;
        var row = new TeamStanding(team);
        _byTeam[team] = row;
        _order.Add(row);
        return row;
    }

    public TeamStanding Get(Team team) => _byTeam[team];

    /// <summary>Registra o resultado de uma partida terminada (<c>ah.a(I, s)</c>, <c>best/ah.java:1075</c>).</summary>
    public void Apply(Team home, int homeGoals, Team away, int awayGoals)
    {
        var h = Add(home);
        var a = Add(away);

        h.Played++;
        a.Played++;
        h.GoalsFor += homeGoals;
        h.GoalsAgainst += awayGoals;
        a.GoalsFor += awayGoals;
        a.GoalsAgainst += homeGoals;

        if (homeGoals > awayGoals)
        {
            h.Won++;
            a.Lost++;
        }
        else if (homeGoals < awayGoals)
        {
            a.Won++;
            h.Lost++;
        }
        else
        {
            h.Drawn++;
            a.Drawn++;
        }
    }

    /// <summary>Classificação corrente, na ordem de <c>h.K</c>.</summary>
    public List<TeamStanding> Ordered() => OrderByHk(_order);

    /// <summary>
    /// Ordena classificações pelo comparador <c>h.K</c> (pontos, vitórias, saldo e gols pró,
    /// decrescentes). Empates totais preservam a ordem de entrada (útil para ranquear os melhores
    /// terceiros entre grupos).
    /// </summary>
    public static List<TeamStanding> OrderByHk(IEnumerable<TeamStanding> rows) =>
        rows
            .OrderByDescending(s => s.Points)
            .ThenByDescending(s => s.Won)
            .ThenByDescending(s => s.GoalDifference)
            .ThenByDescending(s => s.GoalsFor)
            .ToList();

    /// <summary>Posição (1-based) do clube na classificação corrente, ou 0 se ausente.</summary>
    public int PositionOf(Team team)
    {
        var ordered = Ordered();
        for (var i = 0; i < ordered.Count; i++)
            if (ReferenceEquals(ordered[i].Team, team)) return i + 1;
        return 0;
    }
}
