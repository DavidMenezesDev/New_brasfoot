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

        // best.Z.Ar() (Z.java:177): na carreira brasileira completa (bk), a 4ª divisão nasce VAZIA e
        // é preenchida no gancho cD por best.a.m() (Série D, best.w.Q). Aqui ela simplesmente não é
        // criada agora — CreateSerieD a cria no meio da temporada.
        var deferLast = SerieDApplies(session) && national.Divisions.Count >= 4;
        for (var index = 0; index < national.Divisions.Count; index++)
        {
            if (deferLast && index == national.Divisions.Count - 1) continue;
            result.Add(BuildDivision(session, national, index));
        }
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

    /// <summary>
    /// <c>bk()</c> (<c>best/a.java:2256</c>): carreira brasileira "completa" — joga estaduais e o país
    /// tem 4 divisões nacionais. É a condição de <c>best.a.m()</c> (Série D) em vez de <c>best.a.l()</c>
    /// (só Copa do Brasil a partir do país inteiro). Vale só para o Brasil.
    /// </summary>
    public static bool SerieDApplies(GameSession session)
    {
        ArgumentNullException.ThrowIfNull(session);
        if (!session.State.Options.JogaEstadual) return false;
        var national = session.State.World.LeagueOf(Countries.Brasil);
        return national is { Divisions.Count: >= 4 };
    }

    /// <summary>
    /// As divisões nacionais "de cima" (todas menos a última, a Série D): fonte dos clubes da Copa do
    /// Brasil na carreira completa (<c>best.a.m()</c>) e do filtro de elegíveis da Série D.
    /// </summary>
    public static List<List<Team>> NationalTopDivisions(GameSession session)
    {
        var national = session.State.World.LeagueOf(Countries.Brasil);
        if (national is null) return new List<List<Team>>();
        var take = SerieDApplies(session) ? Math.Max(0, national.Divisions.Count - 1) : national.Divisions.Count;
        return national.Divisions.Take(take).ToList();
    }

    /// <summary>
    /// Elegível à Série D: clube brasileiro fora das divisões 1–3 (<c>getDivisao() == 0</c> no original,
    /// onde a 4ª divisão nasce vazia). No port a 4ª divisão carrega os pré-selecionados, então o filtro
    /// é "não está nas divisões de cima".
    /// </summary>
    public static bool EligibleForSerieD(GameSession session, Team team)
    {
        if (team.CountryId != Countries.Brasil) return false;
        foreach (var division in NationalTopDivisions(session))
            if (division.Contains(team)) return false;
        return true;
    }

    /// <summary>
    /// <c>best.w.Q(n)</c> aplicado a uma sessão: monta o quadro da Série D de <paramref name="size"/>
    /// clubes a partir dos clubes livres (<see cref="GameSession.FreeTeams"/>, <c>bY()</c>), dos slots
    /// dos estaduais (<see cref="SerieDSelection.FromFederations"/>) e dos clubes brasileiros
    /// elegíveis (<c>Z.jg()</c> filtrado).
    /// </summary>
    public static List<Team> SelectSerieDField(GameSession session, int size)
    {
        ArgumentNullException.ThrowIfNull(session);
        var slots = SerieDSelection.FromFederations(
            session.StateFederations, team => EligibleForSerieD(session, team));
        var country = session.State.World.Teams
            .Where(t => EligibleForSerieD(session, t))
            .ToList();
        var freeTeams = session.FreeTeams
            .Where(t => t.Division == 0 && EligibleForSerieD(session, t))
            .ToList();
        return SerieDSelection.Select(size, slots, freeTeams, country);
    }

    /// <summary>
    /// Cria a Série D (4ª divisão nacional) no gancho <c>cD</c> (<c>best.a.m()</c>), depois de os
    /// estaduais terem terminado: <c>PhasedCompetition</c> com grupos (default 8×8), ida e volta dentro
    /// do grupo e mata-mata dos classificados (default 4 por grupo = 32), nos dias
    /// <see cref="DayType.Nacional"/>. Quando o formato configurado não cabe no quadro (grupos que não
    /// dividem, mata-mata não potência de dois), cai numa liga de pontos corridos. Devolve
    /// <see langword="null"/> para quadro vazio.
    /// </summary>
    public static PhasedCompetition? CreateSerieD(
        GameSession session, IReadOnlyList<Team> field, ConfigLigaType? config = null)
    {
        ArgumentNullException.ThrowIfNull(session);
        ArgumentNullException.ThrowIfNull(field);
        if (field.Count == 0) return null;

        var national = session.State.World.LeagueOf(Countries.Brasil);
        var division = national?.Divisions.Count ?? 4;
        var competition = new Competition(
            4, $"{national?.Name ?? "Brasileirão"} — {division}ª divisão", CompetitionType.Nacional);

        var phased = new PhasedCompetition(session, competition, field, SerieDFormat(field.Count, config));
        session.Phased.Add(phased);
        return phased;
    }

    /// <summary>
    /// Formato da Série D a partir do <c>.cfg</c> da 4ª divisão (grupos, classificados por grupo, ida e
    /// volta, jogos dentro do grupo). Sem configuração, usa 8 grupos × 4 classificados (a 4ª divisão
    /// brasileira). Se o quadro não comportar grupos + mata-mata potência de dois, devolve liga de
    /// pontos corridos (sem grupos).
    /// </summary>
    private static PhaseOptions SerieDFormat(int pool, ConfigLigaType? config)
    {
        var groups = config?.Groups ?? 8;
        var qualifiers = config?.KnockoutQualifiersPerGroup ?? 4;
        var doubleRound = config?.DoubleRound ?? true;
        var withinGroup = config?.MatchesWithinGroup ?? true;
        var knockout = groups > 1 ? qualifiers * groups : qualifiers;

        var fits = groups > 1
            && pool % groups == 0
            && knockout > 0
            && knockout <= pool
            && (knockout & (knockout - 1)) == 0;

        if (!fits)
            return new PhaseOptions
            {
                Groups = 1,
                DoubleRound = true,
                MatchesWithinGroup = false,
                KnockoutQualifiersPerGroup = 0,
                DayType = DayType.Nacional,
            };

        return new PhaseOptions
        {
            Groups = groups,
            DoubleRound = doubleRound,
            MatchesWithinGroup = withinGroup,
            ContiguousGroups = false,
            KnockoutQualifiersPerGroup = qualifiers,
            KnockoutTwoLegged = false,
            DayType = DayType.Nacional,
        };
    }

    /// <summary>
    /// <c>best.a.m()/l()</c> (<c>best/a.java:649-700</c>): cria, no gancho <c>cD</c> do meio da
    /// temporada, a Copa do Brasil — e, na carreira brasileira completa (<see cref="SerieDApplies"/>),
    /// também a Série D (<c>best.w.Q</c>). Sem carreira completa, cai em <c>l()</c>: a Copa do Brasil a
    /// partir de todos os clubes do país. Devolve <see langword="null"/> quando o grupo não comporta o
    /// formato de potes.
    /// </summary>
    public static CopaDoBrasilCompetition? CreateSerieDAndCopa(GameSession session, ConfigLigaType? serieDConfig = null)
    {
        ArgumentNullException.ThrowIfNull(session);
        var brazilian = session.State.World.LeagueOf(Countries.Brasil);

        if (SerieDApplies(session) && brazilian is not null)
        {
            var size = brazilian.Divisions[^1].Count;
            var field = SelectSerieDField(session, size);
            if (field.Count == size)
            {
                CreateSerieD(session, field, serieDConfig);

                // m(): a Copa do Brasil sai das divisões 1–3 + os extras de eh().
                var pool = NationalTopDivisions(session).SelectMany(d => d).ToList();
                var extras = SerieDSelection.ExtraTeams(SerieDSelection.FromFederations(
                    session.StateFederations, team => EligibleForSerieD(session, team)));
                foreach (var team in extras)
                    if (!pool.Contains(team)) pool.Add(team);
                return CreateCopaDoBrasil(session, pool);
            }
            // Quadro não bateu com o tamanho esperado: cai no ramo de l().
        }

        var all = brazilian is not null
            ? brazilian.Teams.ToList()
            : session.State.World.Teams.Where(t => t.CountryId == Countries.Brasil).ToList();
        return CreateCopaDoBrasil(session, all);
    }

    /// <summary>
    /// Cria a Supercopa da temporada corrente a partir do histórico de campeões da temporada anterior
    /// (<see cref="SeasonArchive"/>): o campeão da liga (divisão 1) de <paramref name="leagueCompetitionName"/>
    /// contra o campeão da copa de <paramref name="cupCompetitionName"/>, com o vice da copa como
    /// alternativa (<see cref="Supercup.SelectOpponent"/>). Devolve <see langword="null"/> quando não há
    /// histórico (primeira temporada) ou adversário válido.
    /// </summary>
    public static CupCompetition? CreateSupercupFromHistory(
        GameSession session,
        string leagueCompetitionName,
        string cupCompetitionName,
        string name = "Supercopa")
    {
        ArgumentNullException.ThrowIfNull(session);
        var previous = session.State.Season - 1;
        if (previous < 1) return null;

        var leagueRecord = SeasonArchive.Find(session.State, previous, leagueCompetitionName);
        if (leagueRecord is null) return null;
        var leagueChampion = FindTeam(session, leagueRecord.TeamId);
        if (leagueChampion is null) return null;

        var cupRecord = SeasonArchive.Find(session.State, previous, cupCompetitionName);
        var cupChampion = cupRecord is null ? null : FindTeam(session, cupRecord.TeamId);
        var cupRunnerUp = cupRecord?.RunnerUpId is { } runnerUpId ? FindTeam(session, runnerUpId) : null;

        return CreateSupercup(session, leagueChampion, cupChampion, cupRunnerUp, name);
    }

    private static Team? FindTeam(GameSession session, int teamId) =>
        session.State.World.Teams.FirstOrDefault(t => t.Id == teamId);

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
