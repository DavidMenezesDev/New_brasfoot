using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
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

    /// <summary>
    /// Cria a Copa do Brasil no novo formato de potes (<see cref="CopaDoBrasilCompetition"/>, <c>f/f</c>)
    /// e a agenda nos dias livres de <see cref="DayType.CopaNacional"/>. Devolve <see langword="null"/>
    /// quando o grupo não comporta o formato de potes (o chamador cai no sorteio genérico de
    /// <see cref="CupDraw"/>).
    /// </summary>
    public static CopaDoBrasilCompetition? CreateCopaDoBrasil(
        GameSession session,
        IReadOnlyList<Team> pool,
        IReadOnlyList<Team>? preferred = null,
        string name = "Copa do Brasil")
    {
        var competition = new Competition(2029, name, CompetitionType.CopaNacional);
        var copa = CopaDoBrasilCompetition.Create(competition, pool, session.State.Calendar, session.Context, preferred);
        if (copa is null) return null;
        copa.NotifyHeads(session.State); // f.b → Bh(): avisa os técnicos brasileiros dos 12 cabeças.
        session.BrasilCup.Add(copa);
        return copa;
    }

    // ---- Estaduais e regionais (best.w / f.F) -------------------------------

    /// <summary>
    /// Cria as federações estaduais de todos os estados com ao menos 6 clubes brasileiros, como
    /// <c>best.w.dZ()</c>. Cada federação monta suas divisões (fórmulas <c>aq.sL</c> + configurações
    /// <c>.ces</c>, <see cref="StateFederation"/>) e agenda as competições nos dias
    /// <see cref="DayType.Estadual"/>. As federações também entram em
    /// <see cref="GameSession.StateFederations"/>.
    /// </summary>
    public static List<StateFederation> CreateStateChampionships(
        GameSession session,
        IReadOnlyDictionary<(int State, int Division), ConfigEstadualType>? configs = null,
        bool useStandardGroup = true)
    {
        var federations = new List<StateFederation>();
        var counts = new int[StateFormulaTable.StateCount];
        foreach (var team in session.State.World.Teams)
            if (team.CountryId == Countries.Brasil && team.State is >= 0 and < StateFormulaTable.StateCount)
                counts[team.State]++;

        for (var state = 0; state < counts.Length; state++)
        {
            if (counts[state] < 6) continue;
            var federation = StateFederation.Build(session, state, configs, useStandardGroup);
            if (federation.Divisions.Count == 0) continue;
            federations.Add(federation);
            session.StateFederations.Add(federation);
        }
        return federations;
    }

    /// <summary>
    /// Estados de cada região dos torneios regionais (<c>f/F.an</c>): Rio-SP, Sul-Minas, Copa do
    /// Nordeste e Copa Verde (<c>aq.pY</c>).
    /// </summary>
    public static readonly int[][] RegionalStates =
    [
        [18, 25],                                                          // Rio-SP
        [10, 17, 22, 23],                                                  // Sul-Minas
        [1, 4, 5, 9, 14, 15, 16, 19, 24],                                  // Copa do Nordeste
        [0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26],                        // Copa Verde
    ];

    /// <summary>Nomes das regiões (<c>aq.pY</c>).</summary>
    public static readonly string[] RegionalNames = ["Rio-SP", "Sul-Minas", "Copa do Nordeste", "Copa Verde"];

    /// <summary>
    /// Cria os torneios regionais habilitados (<c>f.F</c>, <c>best.p.an</c>): cada região reúne os
    /// primeiros 16 clubes brasileiros das suas federações de estado, ordenados por <c>abm</c> (nível,
    /// reputação e desempate) e intercalados por <c>h.a.ad(4,4)</c>. Fase de grupos (4×4, ida e
    /// volta, grupos contíguos) e mata-mata de 8 times com três fases de ida e volta, nos dias
    /// <see cref="DayType.Regionais"/>.
    /// </summary>
    public static List<PhasedCompetition> CreateRegionalChampionships(GameSession session)
    {
        var result = new List<PhasedCompetition>();
        var brazilian = session.State.World.LeagueOf(Countries.Brasil);
        var pool = brazilian is not null
            ? brazilian.Divisions.SelectMany(d => d).ToList()
            : session.State.World.Teams.Where(t => t.CountryId == Countries.Brasil).ToList();
        if (pool.Count == 0) return result;

        var options = session.State.Options;
        for (var region = 0; region < 4; region++)
        {
            if (!options.JogaRegionaisTodos[region]) continue;
            var filtered = pool.Where(t => RegionalStates[region].Contains(t.State)).ToList();
            if (filtered.Count < 16) continue;

            var selected = filtered.Take(16).ToList();
            selected.Sort(RegionalComparer);
            var arranged = InterleaveQuarters(selected, session.Context.Random);

            var competition = new Competition(
                (int)CompetitionType.Regionais * 1000 + region, RegionalNames[region], CompetitionType.Regionais);
            var phaseOptions = new PhaseOptions
            {
                Groups = 4,
                DoubleRound = true,
                MatchesWithinGroup = true,
                ContiguousGroups = true,
                KnockoutQualifiersPerGroup = 2,
                CompetitionCode = 10,
                KnockoutTwoLeggedByRound = [true, true, true, false, false, false, false],
                DayType = DayType.Regionais,
            };
            var phased = new PhasedCompetition(session, competition, arranged, phaseOptions);
            session.Phased.Add(phased);
            result.Add(phased);
        }
        return result;
    }

    /// <summary>
    /// <c>h/J</c> (<c>abm</c>): nível desc, reputação desc, desempate desc.
    /// </summary>
    public static int CompareRegional(Team a, Team b)
    {
        if (a.Level != b.Level) return b.Level - a.Level;
        if (a.Reputation != b.Reputation) return b.Reputation - a.Reputation;
        return b.RankTiebreak - a.RankTiebreak;
    }

    private static readonly Comparison<Team> RegionalComparer = CompareRegional;

    /// <summary>
    /// <c>h.a.ad(4,4)</c>: embaralha cada quarto da lista e intercala <c>q0[i], q2[i], q1[i], q3[i]</c>,
    /// como o arranjo de grupos dos regionais.
    /// </summary>
    public static List<Team> InterleaveQuarters(IReadOnlyList<Team> teams, IGameRandom random)
    {
        if (teams.Count != 16)
            throw new ArgumentException("O arranjo de quartos exige exatamente 16 clubes.", nameof(teams));

        var quarters = new List<int>[4];
        for (var q = 0; q < 4; q++)
        {
            quarters[q] = Enumerable.Range(q * 4, 4).ToList();
            random.Shuffle(quarters[q]);
        }

        var arranged = new List<Team>(16);
        for (var i = 0; i < 4; i++)
        {
            arranged.Add(teams[quarters[0][i]]);
            arranged.Add(teams[quarters[2][i]]);
            arranged.Add(teams[quarters[1][i]]);
            arranged.Add(teams[quarters[3][i]]);
        }
        return arranged;
    }
}
