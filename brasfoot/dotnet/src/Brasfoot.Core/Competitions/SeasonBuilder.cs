using Brasfoot.Core.Calendar;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Monta as competições de uma temporada e as agenda no calendário. Fatia da criação feita por
/// <c>best.Z</c>/<c>f.B</c> (spec-calendario §5): cria uma <see cref="LeagueCompetition"/> para cada
/// divisão da liga nacional de um país, com as tabelas de <see cref="FixtureGenerator"/>.
/// </summary>
public static class SeasonBuilder
{
    /// <summary>
    /// Cria e agenda as divisões da liga nacional de <paramref name="countryId"/>. Cada divisão vira
    /// uma competição do tipo <see cref="CompetitionType.Nacional"/> com jogos nos dias livres desse
    /// tipo (todas as divisões usam os mesmos dias, como no original).
    /// </summary>
    public static List<LeagueCompetition> CreateNationalLeagues(GameSession session, int countryId)
    {
        var result = new List<LeagueCompetition>();
        var national = session.State.World.LeagueOf(countryId);
        if (national is null) return result;

        for (var index = 0; index < national.Divisions.Count; index++)
            result.Add(BuildDivision(session, national, index));
        return result;
    }

    /// <summary>Cria apenas uma divisão da liga nacional (<paramref name="division"/> é 1-based).</summary>
    public static LeagueCompetition? CreateNationalDivision(GameSession session, int countryId, int division)
    {
        var national = session.State.World.LeagueOf(countryId);
        if (national is null || division < 1 || division > national.Divisions.Count) return null;
        return BuildDivision(session, national, division - 1);
    }

    private static LeagueCompetition BuildDivision(GameSession session, Domain.League national, int index)
    {
        var teams = national.Divisions[index].ToList();
        var rounds = FixtureGenerator.ForLeague(
            new FixtureOptions { TeamCount = teams.Count, IsNationalLeague = true, DoubleRound = true },
            session.Context.Random);
        var competition = new Competition(index + 1, $"{national.Name} — {index + 1}ª divisão", CompetitionType.Nacional);
        var league = new LeagueCompetition(competition, teams, rounds);
        league.ScheduleOn(session.State.Calendar, session.Context.Random);
        session.Leagues.Add(league);
        return league;
    }

    /// <summary>
    /// Cria uma única liga a partir de uma lista de times (útil para competições avulsas e testes).
    /// </summary>
    public static LeagueCompetition CreateLeague(
        GameSession session,
        string name,
        CompetitionType type,
        IEnumerable<Team> teams,
        int competitionId = -1,
        bool doubleRound = true)
    {
        var pool = teams.ToList();
        var rounds = FixtureGenerator.ForLeague(
            new FixtureOptions
            {
                TeamCount = pool.Count,
                IsNationalLeague = type == CompetitionType.Nacional,
                CompetitionId = competitionId,
                DoubleRound = doubleRound,
            },
            session.Context.Random);
        var league = new LeagueCompetition(new Competition((int)type + 1, name, type), pool, rounds);
        league.ScheduleOn(session.State.Calendar, session.Context.Random);
        session.Leagues.Add(league);
        return league;
    }

    /// <summary>
    /// Cria a copa nacional de um país com o sorteio genérico (<see cref="CupDraw"/>, <c>f/f.a</c>) e a
    /// agenda nos dias livres de <see cref="DayType.CopaNacional"/> da temporada
    /// (<see cref="CupCompetition"/>), em vez de disputá-la de uma vez só como o CLI `copa` faz.
    /// </summary>
    public static CupCompetition? CreateNationalCup(
        GameSession session, IReadOnlyList<Team> pool, string name = "Copa Nacional", bool twoLegged = false)
    {
        var seeded = CupDraw.SeedFromPool(pool, session.Context.Random);
        if (seeded.Count == 0) return null;

        var competition = new Competition(
            (int)CompetitionType.CopaNacional * 1000 + session.Cups.Count, name, CompetitionType.CopaNacional);
        var bracket = new KnockoutBracket(
            competition, seeded, twoLegged: twoLegged, awayGoalsRule: twoLegged, shootoutAllowed: true);
        var cup = CupCompetition.Create(competition, bracket, session.State.Calendar, session.Context);
        session.Cups.Add(cup);
        return cup;
    }

    /// <summary>
    /// Cria a Supercopa de um país (<see cref="Supercup"/>, <c>f.I</c>) a partir do campeão da liga e
    /// do campeão/vice da copa nacional da temporada anterior, e a agenda no dia livre de
    /// <see cref="DayType.SuperCopa"/> (um só jogo — <c>f/I.b</c>).
    /// </summary>
    public static CupCompetition? CreateSupercup(
        GameSession session, Team leagueChampion, Team? cupChampion, Team? cupRunnerUp, string name = "Supercopa")
    {
        var competition = new Competition(
            (int)CompetitionType.Supercopa * 1000 + session.Cups.Count, name, CompetitionType.Supercopa);
        var bracket = Supercup.Create(competition, leagueChampion, cupChampion, cupRunnerUp);
        if (bracket is null) return null;

        var cup = CupCompetition.Create(competition, bracket, session.State.Calendar, session.Context);
        session.Cups.Add(cup);
        return cup;
    }
}
