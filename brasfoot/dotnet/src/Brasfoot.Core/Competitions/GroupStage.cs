using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Fase de grupos de uma competição (subconjunto de <c>best.G</c> + <c>best.t</c>): cada grupo é uma
/// liga de pontos corridos (reusa <see cref="LeagueCompetition"/>), todas agendadas nos mesmos dias
/// livres do tipo da competição. Expõe a classificação de cada grupo, o ranqueamento entre grupos
/// (para os "melhores terceiros") e os classificados.
/// </summary>
/// <remarks>
/// <see cref="Qualifiers"/> entrega os classificados na ordem crua (posição, grupo). Para a ordem
/// <em>fiel do chaveamento</em> — matrizes <c>Zm..Zz</c> de <c>f/s.yP</c>/<c>yO</c> — use
/// <see cref="SeedKnockout"/> e <see cref="SeedKnockoutWithThirds"/>. As transições de fase de
/// <c>f.B</c> ainda são pendentes.
/// </remarks>
public sealed class GroupStage
{
    private readonly List<LeagueCompetition> _groups = new();

    public GroupStage(
        GameSession session,
        Competition competition,
        IReadOnlyList<IReadOnlyList<Team>> groups,
        bool doubleRound = false)
    {
        Competition = competition;
        for (var i = 0; i < groups.Count; i++)
        {
            var teams = groups[i].ToList();
            if (teams.Count < 2) throw new ArgumentException($"Grupo {i + 1} tem menos de 2 times.", nameof(groups));

            var rounds = FixtureGenerator.ForLeague(
                new FixtureOptions { TeamCount = teams.Count, IsNationalLeague = false, DoubleRound = doubleRound },
                session.Context.Random);
            var groupCompetition = competition with { Name = $"{competition.Name} — Grupo {GroupLetter(i)}" };
            var league = new LeagueCompetition(groupCompetition, teams, rounds);
            league.ScheduleOn(session.State.Calendar, session.Context.Random);
            session.Leagues.Add(league);
            _groups.Add(league);
        }
    }

    public Competition Competition { get; }
    public IReadOnlyList<LeagueCompetition> Groups => _groups;

    public bool IsComplete => _groups.Count > 0 && _groups.All(g => g.IsComplete);

    /// <summary>Classificação de um grupo (0-based), na ordem de <c>h.K</c>.</summary>
    public List<TeamStanding> StandingsOf(int groupIndex) => _groups[groupIndex].Standing;

    /// <summary>
    /// Times que terminaram na posição <paramref name="place"/> (1-based) em cada grupo, ranqueados
    /// entre si por <c>h.K</c> — base dos "melhores terceiros".
    /// </summary>
    public List<TeamStanding> PlacementsInOrder(int place)
    {
        var contenders = new List<TeamStanding>();
        foreach (var group in _groups)
        {
            var row = group.Standing.ElementAtOrDefault(place - 1);
            if (row is not null) contenders.Add(row);
        }
        return LeagueTable.OrderByHk(contenders);
    }

    /// <summary>
    /// Classificados: os <paramref name="directPerGroup"/> primeiros de cada grupo, mais os
    /// <paramref name="bestAlso"/> melhores entre os que terminaram na posição
    /// <paramref name="bestAlsoPlace"/>. A ordem é por posição e, dentro dela, pelos grupos.
    /// </summary>
    public List<Team> Qualifiers(int directPerGroup, int bestAlso = 0, int bestAlsoPlace = 3)
    {
        var qualifiers = new List<Team>();
        for (var place = 1; place <= directPerGroup; place++)
        {
            foreach (var group in _groups)
                if (group.Standing.ElementAtOrDefault(place - 1) is { } row)
                    qualifiers.Add(row.Team);
        }
        if (bestAlso > 0)
            qualifiers.AddRange(PlacementsInOrder(bestAlsoPlace).Take(bestAlso).Select(row => row.Team));
        return qualifiers;
    }

    /// <summary>
    /// Classificados (topo de cada grupo) já posicionados na chave pelas matrizes <c>Zm..Zz</c>
    /// (<c>f/s.yP</c>). Alimenta <see cref="KnockoutBracket"/> diretamente.
    /// </summary>
    public IReadOnlyList<Team> SeedKnockout(int perGroup, bool twoLegged, bool nationalPhase = false) =>
        BracketSeeder.FromGroupQualifiers(GroupsInStandingOrder(), perGroup, twoLegged, nationalPhase);

    /// <summary>
    /// Classificados de grupos posicionados na chave, escolhendo automaticamente entre a matriz por
    /// tamanho (<see cref="SeedKnockout"/>) e o cruzamento alternado 1º/2º, conforme o tipo e o
    /// continente da própria <see cref="Competition"/> (<c>f/s.yP</c> completo,
    /// <see cref="BracketSeeder.DetermineGroupKnockoutSeeding"/>, <c>f/s.java:846-955</c>). O caminho
    /// alternado só existe para exatamente 8 grupos (<c>f/s.java:931-948</c>); com outra quantidade,
    /// cai sempre na matriz por tamanho.
    /// </summary>
    public IReadOnlyList<Team> SeedKnockoutAuto(bool twoLegged, Random random, bool nationalPhase = false)
    {
        ArgumentNullException.ThrowIfNull(random);
        var mode = BracketSeeder.DetermineGroupKnockoutSeeding(Competition.Type, Competition.Continent);
        if (!mode.Alternate || _groups.Count != 8)
            return SeedKnockout(perGroup: 2, twoLegged, nationalPhase);

        var firsts = _groups.Select(g => g.Standing[0]).ToList();
        var seconds = _groups.Select(g => g.Standing[1]).ToList();
        List<Team> firstTeams, secondTeams;
        if (mode.RankedNotShuffled)
        {
            firstTeams = LeagueTable.OrderByHk(firsts).Select(s => s.Team).ToList();
            secondTeams = LeagueTable.OrderByHk(seconds).Select(s => s.Team).ToList();
        }
        else
        {
            firstTeams = firsts.Select(s => s.Team).ToList();
            secondTeams = seconds.Select(s => s.Team).ToList();
            BracketSeeder.Shuffle(firstTeams, random);
            BracketSeeder.Shuffle(secondTeams, random);
        }
        return BracketSeeder.AlternateFirstsAndSeconds(firstTeams, secondTeams);
    }

    /// <summary>
    /// Classificados + melhores extras posicionados na chave (<c>f/s.yO</c>). Use
    /// <see cref="BracketSeeder.BestExtraPlacementIndex"/> para <paramref name="extraPlace"/> e
    /// <see cref="BracketSeeder.BestThirdsCount"/> para <paramref name="extraCount"/>.
    /// </summary>
    public IReadOnlyList<Team> SeedKnockoutWithThirds(
        int perGroup,
        int extraPlace,
        int extraCount,
        bool twoLegged) =>
        BracketSeeder.FromGroupQualifiersWithThirds(
            GroupsInStandingOrder(), perGroup, PlacementsInOrder(extraPlace), extraCount, twoLegged);

    private List<IReadOnlyList<Team>> GroupsInStandingOrder() =>
        _groups.Select(g => (IReadOnlyList<Team>)g.Standing.Select(s => s.Team).ToList()).ToList();

    private static string GroupLetter(int index) =>
        index < 26 ? ((char)('A' + index)).ToString() : $"G{index + 1}";
}
