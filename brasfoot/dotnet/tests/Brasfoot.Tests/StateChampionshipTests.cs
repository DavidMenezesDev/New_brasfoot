using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;
using Brasfoot.Data;

namespace Brasfoot.Tests;

/// <summary>
/// Estaduais (<see cref="StateFederation"/>), regionais (<c>f.F</c>), amistosos de clube
/// (<see cref="FriendlyMatch"/>) e Torneio Amistoso (<see cref="FriendlyTournament"/>) — a Fase 4 de
/// <c>planodeImp.md</c>.
/// </summary>
public class StateChampionshipTests
{
    private const int Sp = 25;
    private const int Brasil = Countries.Brasil;

    // ---- Apoio ---------------------------------------------------------------

    private static GameSession NewSession(IEnumerable<Team> teams, int year = 2022, GameOptions? options = null)
    {
        var world = new World();
        world.Teams.AddRange(teams);
        var state = GameState.FromWorld(world, options ?? new GameOptions());
        state.BaseYear = year;
        var session = new GameSession(state, TestData.Context());
        session.BuildSeasonCalendar();
        return session;
    }

    private static Team Brazilian(string name, int state, int level = 18, int reputation = 3, string? fileRef = null)
    {
        var team = TestData.Team(name, 60, Brasil, reputation);
        team.State = state;
        team.Level = level;
        if (fileRef is not null) team.FileRef = fileRef;
        return team;
    }

    private static void PlayUntil(GameSession session, Func<bool> done, int maxDays = 400)
    {
        var days = 0;
        while (!done() && !session.SeasonEnded && days++ < maxDays)
            session.AdvanceToNextMatchDay();
        Assert.True(done(), $"Condição não atingida em {days} dias (SeasonEnded={session.SeasonEnded}).");
    }

    // ---- Configuração (.ces) -------------------------------------------------

    [Fact]
    public void Config_Create_validates_like_the_original_setters()
    {
        Assert.Equal(-1, ConfigEstadualType.Create(-1, 1, 0).Id);
        Assert.Equal(-1, ConfigEstadualType.Create(27, 1, 0).Id);
        Assert.Equal(26, ConfigEstadualType.Create(26, 1, 0).Id);

        Assert.Equal(-1, ConfigEstadualType.Create(0, 5, 0).Division);
        Assert.Equal(4, ConfigEstadualType.Create(0, 4, 0).Division);

        Assert.Equal(0, ConfigEstadualType.Create(0, 1, -3).Formula);
        Assert.Equal(0, ConfigEstadualType.Create(0, 1, StateFormulaTable.Formulas.Length).Formula);
        Assert.Equal(10, ConfigEstadualType.Create(0, 1, 10).Formula);

        // nRebaixados aceita 1..4; fora disso volta a 2.
        Assert.Equal(1, ConfigEstadualType.Create(0, 1, 0, relegated: 1).Relegated);
        Assert.Equal(4, ConfigEstadualType.Create(0, 1, 0, relegated: 4).Relegated);
        Assert.Equal(2, ConfigEstadualType.Create(0, 1, 0, relegated: 0).Relegated);
        Assert.Equal(2, ConfigEstadualType.Create(0, 1, 0, relegated: 5).Relegated);

        // desempate só aceita 0/1.
        Assert.Equal(1, ConfigEstadualType.Create(0, 1, 0, tiebreak: 1).Tiebreak);
        Assert.Equal(0, ConfigEstadualType.Create(0, 1, 0, tiebreak: 7).Tiebreak);

        // nTimes é derivado da fórmula (aq.sL[formula][0]).
        Assert.Equal(6, ConfigEstadualType.Create(0, 1, 0).Teams);
        Assert.Equal(16, ConfigEstadualType.Create(0, 1, 7).Teams);
    }

    [Fact]
    public void FinalsLegsFormatted_sets_fixed_and_configurable_legs()
    {
        var configurable = ConfigEstadualType.Create(0, 1, 0, finalsLegs: [1, 2, 1]).FinalsLegsFormatted();
        Assert.Equal(7, configurable.Length);
        Assert.False(configurable[0]);
        Assert.True(configurable[1]);
        Assert.False(configurable[2]);
        // As fases 3..6 são sempre de ida e volta.
        Assert.True(configurable[3]);
        Assert.True(configurable[4]);
        Assert.True(configurable[5]);
        Assert.True(configurable[6]);

        var defaults = ConfigEstadualType.Create(0, 1, 0).FinalsLegsFormatted();
        Assert.All(defaults, Assert.True);

        // finaisIdaVolta curto (menos de 3) mantém o default [2,2,2].
        var shortLegs = ConfigEstadualType.Create(0, 1, 0, finalsLegs: [1]).FinalsLegsFormatted();
        Assert.All(shortLegs, Assert.True);
    }

    [Fact]
    public void State_tables_expose_names_and_gentilic()
    {
        Assert.Equal(27, StateFormulaTable.StateCount);
        Assert.Equal("SP", StateFormulaTable.AbbreviationOf(Sp));
        Assert.Equal("São Paulo", StateFormulaTable.NameOf(Sp));
        Assert.Equal("Paulista", StateFormulaTable.DemonymOf(Sp));
        Assert.Equal("?", StateFormulaTable.AbbreviationOf(99));
        Assert.Equal("?", StateFormulaTable.NameOf(-1));
        Assert.Equal("?", StateFormulaTable.DemonymOf(99));
    }

    // ---- Federação estadual (best.w) -----------------------------------------

    [Fact]
    public void StandardGroupOfSaoPaulo_follows_the_fixed_order()
    {
        var pool = new List<Team>();
        foreach (var fileRef in StateFormulaTable.SaoPauloStandardGroup.Reverse())
            pool.Add(Brazilian(fileRef, Sp, fileRef: fileRef));

        var ordered = StateFederation.StandardGroupOfSaoPaulo(pool);

        Assert.Equal(16, ordered.Count);
        Assert.Equal(StateFormulaTable.SaoPauloStandardGroup, ordered.Select(t => t.FileRef).ToArray());
    }

    [Fact]
    public void Federation_builds_default_divisions_and_leftovers()
    {
        var teams = Enumerable.Range(0, 20).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);

        var federation = StateFederation.Build(session, Sp);

        Assert.Equal(3, federation.Divisions.Count);
        Assert.All(federation.Divisions, d => Assert.Equal(6, d.Roster.Count));
        Assert.Equal(2, federation.Leftovers.Count);
        Assert.Equal("Paulista", federation.Divisions[0].Competition.Name);
        Assert.Equal("Paulista - 2ª divisão", federation.Divisions[1].Competition.Name);
        Assert.Equal("Paulista - 3ª divisão", federation.Divisions[2].Competition.Name);
        Assert.Equal(3, session.Phased.Count);

        // As divisões e os clubes de fora particionam o pool, sem repetição.
        var all = federation.Divisions.SelectMany(d => d.Roster).Concat(federation.Leftovers).ToList();
        Assert.Equal(20, all.Count);
        Assert.Equal(20, all.Distinct().Count());
    }

    [Fact]
    public void Federation_falls_back_to_default_formula_when_configured_is_too_large()
    {
        var teams = Enumerable.Range(0, 8).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);
        // Fórmula 4 pede 12 clubes; há 8 no estado → cai na fórmula padrão 0 (6 clubes).
        var configs = new Dictionary<(int, int), ConfigEstadualType>
        {
            [(Sp, 1)] = ConfigEstadualType.Create(Sp, 1, formula: 4),
        };

        var federation = StateFederation.Build(session, Sp, configs);

        Assert.Single(federation.Divisions);
        Assert.Equal(6, federation.Divisions[0].Roster.Count);
        Assert.Equal(2, federation.Divisions[0].Relegated);
        Assert.Equal(2, federation.Leftovers.Count);
    }

    [Fact]
    public void Federation_uses_configured_formula_and_relegation_count()
    {
        var teams = Enumerable.Range(0, 16).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);
        var configs = new Dictionary<(int, int), ConfigEstadualType>
        {
            // O nRebaixados do .ces é ignorado: best/w.java:95 usa a coluna 4 da fórmula (aqui, 2).
            [(Sp, 1)] = ConfigEstadualType.Create(Sp, 1, formula: 1, relegated: 3),
        };

        var federation = StateFederation.Build(session, Sp, configs);

        Assert.Equal(2, federation.Divisions.Count);
        Assert.Equal(8, federation.Divisions[0].Roster.Count);
        Assert.Equal(2, federation.Divisions[0].Relegated);
        Assert.Equal(2, federation.Divisions[1].Relegated);
        Assert.Equal(8, federation.Divisions[0].Phased.Phase1[0].Teams.Count);
        Assert.Equal(2, federation.Leftovers.Count);
    }

    [Fact]
    public void Federation_relegation_follows_the_formula_column()
    {
        var teams = Enumerable.Range(0, 24).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);
        // Formula 10 = [20, 4, 2, 0, 4]: 20 clubes e 4 rebaixados.
        var configs = new Dictionary<(int, int), ConfigEstadualType>
        {
            [(Sp, 1)] = ConfigEstadualType.Create(Sp, 1, formula: 10),
        };

        var federation = StateFederation.Build(session, Sp, configs);

        Assert.Single(federation.Divisions);
        Assert.Equal(20, federation.Divisions[0].Roster.Count);
        Assert.Equal(4, federation.Divisions[0].Relegated);
        Assert.Equal(4, federation.Leftovers.Count);
        Assert.Equal(4, federation.Divisions[0].Phased.Groups.Count);
    }

    [Fact]
    public void Federation_standard_group_sao_paulo_uses_contiguous_groups()
    {
        // Extras primeiro para que o "take" do pool difira da ordem fixa do grupo padrão.
        var teams = Enumerable.Range(0, 4).Select(i => Brazilian($"Extra {i}", Sp)).ToList();
        foreach (var fileRef in StateFormulaTable.SaoPauloStandardGroup)
            teams.Add(Brazilian(fileRef, Sp, fileRef: fileRef));
        var configs = new Dictionary<(int, int), ConfigEstadualType>
        {
            [(Sp, 1)] = ConfigEstadualType.Create(Sp, 1, formula: 7),
        };

        var standardSession = NewSession(teams);
        var withStandard = StateFederation.Build(standardSession, Sp, configs, useStandardGroup: true);
        Assert.Single(withStandard.Divisions);
        Assert.Equal(16, withStandard.Divisions[0].Roster.Count);
        Assert.True(withStandard.Divisions[0].Phased.Options.ContiguousGroups);
        Assert.Equal(7, withStandard.Divisions[0].Phased.Options.CompetitionCode);
        Assert.Equal(
            StateFormulaTable.SaoPauloStandardGroup,
            withStandard.Divisions[0].Roster.Select(t => t.FileRef).ToArray());
        Assert.Equal(4, withStandard.Leftovers.Count);

        var plainSession = NewSession(teams);
        var withoutStandard = StateFederation.Build(plainSession, Sp, configs, useStandardGroup: false);
        Assert.Single(withoutStandard.Divisions);
        Assert.Equal(16, withoutStandard.Divisions[0].Roster.Count);
        Assert.False(withoutStandard.Divisions[0].Phased.Options.ContiguousGroups);
        Assert.NotEqual(
            StateFormulaTable.SaoPauloStandardGroup,
            withoutStandard.Divisions[0].Roster.Select(t => t.FileRef).ToArray());
    }

    [Fact]
    public void Federation_needs_at_least_six_clubs()
    {
        var teams = Enumerable.Range(0, 5).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);

        var federation = StateFederation.Build(session, Sp);

        Assert.Empty(federation.Divisions);
        Assert.Empty(session.Phased);
    }

    [Fact]
    public void Federation_promotion_candidates_prefer_knockout_winners()
    {
        var teams = Enumerable.Range(0, 20).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);
        var federation = StateFederation.Build(session, Sp);

        PlayUntil(session, () => federation.Divisions.All(d => d.Phased.IsComplete));

        var division = federation.Divisions[0];
        var candidates = division.PromotionCandidates(2);

        Assert.Equal(2, candidates.Count);
        Assert.Equal(2, candidates.Distinct().Count());
        Assert.Same(division.Phased.Champion, candidates[0]);
    }

    [Fact]
    public void Federation_settles_promotion_and_relegation()
    {
        var teams = Enumerable.Range(0, 20).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);
        var federation = StateFederation.Build(session, Sp);

        PlayUntil(session, () => federation.Divisions.All(d => d.Phased.IsComplete));

        var before = federation.Divisions
            .SelectMany(d => d.Roster)
            .Concat(federation.Leftovers)
            .ToHashSet();

        var result = federation.SettlePromotionRelegation();

        // Duas quedas+duas subidas entre cada par de divisões, e a última troca com os clubes de fora.
        Assert.Equal(12, result.Movements.Count);
        Assert.All(federation.Divisions, d => Assert.Equal(6, d.Roster.Count));
        Assert.Equal(2, federation.Leftovers.Count);

        var after = federation.Divisions
            .SelectMany(d => d.Roster)
            .Concat(federation.Leftovers)
            .ToHashSet();
        Assert.Equal(20, after.Count);
        Assert.True(before.SetEquals(after));

        // Cada movimento termina na lista de destino esperada.
        foreach (var (_, toDivision, team) in result.Movements)
        {
            var destination = toDivision == 0 ? federation.Leftovers : federation.Divisions[toDivision - 1].Roster;
            Assert.Contains(team, destination);
        }
    }

    // ---- Regional (f.F.an) ---------------------------------------------------

    [Fact]
    public void InterleaveQuarters_spreads_quarters_across_groups()
    {
        var teams = new List<Team>();
        var quarterOf = new Dictionary<Team, int>();
        for (var q = 0; q < 4; q++)
            for (var i = 0; i < 4; i++)
            {
                var team = TestData.Team($"Q{q}{i}", 60);
                teams.Add(team);
                quarterOf[team] = q;
            }

        var arranged = SeasonBuilder.InterleaveQuarters(teams, TestData.Context(seed: 7).Random);

        Assert.Equal(16, arranged.Count);
        Assert.Equal(16, arranged.Distinct().Count());

        // Contíguos (ContiguousGroups): cada fatia de 4 tem um clube de cada quarto.
        for (var g = 0; g < 4; g++)
        {
            var quarters = arranged.Skip(g * 4).Take(4).Select(t => quarterOf[t]).OrderBy(q => q).ToArray();
            Assert.Equal(new[] { 0, 1, 2, 3 }, quarters);
        }
    }

    [Fact]
    public void InterleaveQuarters_requires_sixteen_teams()
    {
        var teams = Enumerable.Range(0, 15).Select(i => TestData.Team($"T{i}", 60)).ToList();
        Assert.Throws<ArgumentException>(() => SeasonBuilder.InterleaveQuarters(teams, TestData.Context().Random));
    }

    [Fact]
    public void CompareRegional_orders_by_level_reputation_then_tiebreak()
    {
        var weak = TestData.Team("Fraco", 60);
        weak.Level = 10;
        weak.Reputation = 3;
        weak.RankTiebreak = 100;

        var strong = TestData.Team("Forte", 60);
        strong.Level = 20;
        strong.Reputation = 1;
        strong.RankTiebreak = 1;

        var popularSameLevel = TestData.Team("Popular", 60);
        popularSameLevel.Level = 10;
        popularSameLevel.Reputation = 5;
        popularSameLevel.RankTiebreak = 1;

        var tiebreakSameLevel = TestData.Team("Desempate", 60);
        tiebreakSameLevel.Level = 10;
        tiebreakSameLevel.Reputation = 3;
        tiebreakSameLevel.RankTiebreak = 500;

        var sorted = new List<Team> { weak, strong, popularSameLevel, tiebreakSameLevel };
        sorted.Sort(SeasonBuilder.CompareRegional);

        Assert.Equal(
            new[] { "Forte", "Popular", "Desempate", "Fraco" },
            sorted.Select(t => t.Name).ToArray());
    }

    [Fact]
    public void Regional_needs_sixteen_clubs_in_the_region()
    {
        var teams = Enumerable.Range(0, 10).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);

        var regionais = SeasonBuilder.CreateRegionalChampionships(session);

        Assert.Empty(regionais);
        Assert.Empty(session.Phased);
    }

    [Fact]
    public void Regional_creates_groups_and_crowns_a_champion()
    {
        var teams = Enumerable.Range(0, 16).Select(i => Brazilian($"SP {i}", Sp)).ToList();
        var session = NewSession(teams);

        var regionais = SeasonBuilder.CreateRegionalChampionships(session);

        var regional = Assert.Single(regionais);
        Assert.Equal("Rio-SP", regional.Competition.Name);
        Assert.Equal(CompetitionType.Regionais, regional.Competition.Type);
        Assert.Equal(4, regional.Groups.Count);
        Assert.All(regional.Groups, g => Assert.Equal(4, g.Count));
        Assert.Single(session.Phased);

        PlayUntil(session, () => regional.IsComplete);

        Assert.True(regional.IsComplete);
        Assert.NotNull(regional.Champion);
        Assert.Contains(regional.Champion, teams);
    }

    // ---- Amistosos de clube (f.a) --------------------------------------------

    private static Team FriendlyTeam(
        string name, int reputation, bool human = false, int country = Brasil)
    {
        var team = TestData.Team(name, 60, country, reputation);
        team.IsHuman = human;
        return team;
    }

    [Fact]
    public void Friendly_respond_uses_the_fee_tables()
    {
        var inviter = FriendlyTeam("Convidante", 3);

        // Adversário manda (n2 == 0), mesmo país.
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 10000),
            FriendlyMatch.Respond(inviter, FriendlyTeam("Adv", 2), opponentHosts: true, opponentHasMatchThatDay: false));
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 150000),
            FriendlyMatch.Respond(inviter, FriendlyTeam("Adv", 4), opponentHosts: true, opponentHasMatchThatDay: false));
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 250000),
            FriendlyMatch.Respond(FriendlyTeam("Rico", 5), FriendlyTeam("Adv", 5), opponentHosts: true, opponentHasMatchThatDay: false));

        // Reputações 0/1 não cobram cachê.
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.Scheduled, 0),
            FriendlyMatch.Respond(inviter, FriendlyTeam("Adv", 1), opponentHosts: true, opponentHasMatchThatDay: false));

        // Convidante manda (n2 != 0), mesmo país e país diferente.
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 80000),
            FriendlyMatch.Respond(inviter, FriendlyTeam("Adv", 3), opponentHosts: false, opponentHasMatchThatDay: false));
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 100000),
            FriendlyMatch.Respond(inviter, FriendlyTeam("Adv", 3, country: 3), opponentHosts: false, opponentHasMatchThatDay: false));
    }

    [Fact]
    public void Friendly_respond_refuses_big_clubs_when_the_inviter_is_small()
    {
        var big = FriendlyTeam("Grande", 5);
        var small = FriendlyTeam("Pequeno", 3);

        // Adversário manda e é reputação 5: cachê forçado de 300000 quando o convidante tem < 4.
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 300000),
            FriendlyMatch.Respond(small, big, opponentHosts: true, opponentHasMatchThatDay: false));

        // O convidante manda e o adversário tem reputação 5: recusa, a menos que o convidante também seja 5.
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.Refused, 0),
            FriendlyMatch.Respond(small, big, opponentHosts: false, opponentHasMatchThatDay: false));
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 450000),
            FriendlyMatch.Respond(FriendlyTeam("Grande 2", 5), big, opponentHosts: false, opponentHasMatchThatDay: false));

        // Reputação 4 exige cachê de 200000 quando o convidante tem < 2.
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 200000),
            FriendlyMatch.Respond(FriendlyTeam("Minusculo", 1), FriendlyTeam("Adv", 4), opponentHosts: true, opponentHasMatchThatDay: false));
        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.Refused, 0),
            FriendlyMatch.Respond(FriendlyTeam("Minusculo", 1), FriendlyTeam("Adv", 4), opponentHosts: false, opponentHasMatchThatDay: false));
    }

    [Fact]
    public void Friendly_respond_human_opponent_accepts_free()
    {
        var inviter = FriendlyTeam("Convidante", 0);
        var human = FriendlyTeam("Humano", 5, human: true);

        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.Scheduled, 0),
            FriendlyMatch.Respond(inviter, human, opponentHosts: true, opponentHasMatchThatDay: false));
    }

    [Fact]
    public void Friendly_respond_reports_a_clash_before_anything_else()
    {
        var inviter = FriendlyTeam("Convidante", 0);
        var opponent = FriendlyTeam("Adv", 5);

        Assert.Equal(
            new FriendlyResult(FriendlyOutcome.AlreadyScheduledThatDay, 0),
            FriendlyMatch.Respond(inviter, opponent, opponentHosts: true, opponentHasMatchThatDay: true));
    }

    [Fact]
    public void Friendly_create_sets_home_and_away_by_host()
    {
        var inviter = FriendlyTeam("Convidante", 3);
        var opponent = FriendlyTeam("Adv", 3);
        var competition = new Competition((int)CompetitionType.Amistoso, "Amistoso", CompetitionType.Amistoso);
        var random = TestData.Context().Random;

        var opponentHosts = FriendlyMatch.Create(inviter, opponent, opponentHosts: true, competition, random);
        Assert.Same(opponent, opponentHosts.Home);
        Assert.Same(inviter, opponentHosts.Away);
        Assert.Same(competition, opponentHosts.Competition);

        var inviterHosts = FriendlyMatch.Create(inviter, opponent, opponentHosts: false, competition, random);
        Assert.Same(inviter, inviterHosts.Home);
        Assert.Same(opponent, inviterHosts.Away);
    }

    [Fact]
    public void Friendly_available_days_skips_past_and_busy_days()
    {
        var team = Brazilian("SP", Sp);
        var session = NewSession([team, Brazilian("SP 2", Sp)]);
        var calendar = session.State.Calendar;

        var free = FriendlyMatch.AvailableDays(calendar, team, session.CurrentDay.Date);
        Assert.NotEmpty(free);
        Assert.All(free, i => Assert.Equal(DayType.AmistosoClube, calendar.Days[i].Type));
        Assert.All(free, i => Assert.True(calendar.Days[i].Date > session.CurrentDay.Date));

        // Ocupa um dia futuro de amistoso: ele deixa de aparecer.
        var busyIndex = free[0];
        var competition = new Competition((int)CompetitionType.Amistoso, "Amistoso", CompetitionType.Amistoso);
        var opponent = Brazilian("Outro", Sp);
        calendar.Days[busyIndex].Matches.Add(new Match(team, opponent, competition, session.Context.Random));

        var afterBusy = FriendlyMatch.AvailableDays(calendar, team, session.CurrentDay.Date);
        Assert.DoesNotContain(busyIndex, afterBusy);
    }

    // ---- Torneio Amistoso (f.L) ----------------------------------------------

    [Fact]
    public void FriendlyTournament_rejects_odd_or_tiny_fields()
    {
        var session = NewSession(Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 60)));
        var teams = session.State.World.Teams.ToList();

        Assert.Throws<ArgumentException>(() => FriendlyTournament.Create(session, teams.Take(3).ToList()));
        Assert.Throws<ArgumentException>(() => FriendlyTournament.Create(session, teams.Take(5).ToList()));
    }

    [Fact]
    public void FriendlyTournament_create_groups_and_crowns_a_champion()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 60)).ToList();
        var session = NewSession(teams);

        var tournament = FriendlyTournament.Create(session, teams);

        Assert.Equal(FriendlyTournament.DefaultName, tournament.Competition.Name);
        Assert.Equal(CompetitionType.TorneioAmistoso, tournament.Competition.Type);
        Assert.Equal(2, tournament.Groups.Count);
        Assert.All(tournament.Groups, g => Assert.Equal(4, g.Count));
        Assert.Single(session.Phased);

        PlayUntil(session, () => tournament.IsComplete);

        Assert.True(tournament.IsComplete);
        Assert.NotNull(tournament.Champion);
        Assert.Contains(tournament.Champion, teams);
    }

    [Fact]
    public void FriendlyTournament_create_from_world_takes_the_first_clubs()
    {
        var teams = Enumerable.Range(0, 10).Select(i => TestData.Team($"T{i}", 60)).ToList();
        var session = NewSession(teams);

        var tournament = FriendlyTournament.CreateFromWorld(session, count: 8);

        Assert.Equal(8, tournament.Pool.Count);
        Assert.Equal(teams.Take(8), tournament.Pool);
    }

    // ---- Configuração real (.ces) --------------------------------------------

    [Fact]
    public void LoadStateConfigs_reads_the_four_divisions_per_file()
    {
        var gameDir = FindGameDir();
        if (gameDir == null) return; // pasta do jogo ausente

        var configs = WorldLoader.LoadStateConfigs(gameDir);

        // 25 arquivos (falta o Piauí) x 4 divisões.
        Assert.Equal(100, configs.Count);
        Assert.Equal(7, configs[(Sp, 1)].Formula);
        Assert.Equal(0, configs[(Sp, 2)].Formula);
        Assert.Equal(2, configs[(4, 1)].Formula); // Bahia
        Assert.All(configs.Values, c => Assert.InRange(c.Division, 1, 4));
        Assert.All(configs.Values, c => Assert.InRange(c.Id, 0, 26));
    }

    private static string? FindGameDir()
    {
        for (var dir = new DirectoryInfo(AppContext.BaseDirectory); dir != null; dir = dir.Parent)
        {
            var candidate = Path.Combine(dir.FullName, "brasfoot-linux");
            if (Directory.Exists(Path.Combine(candidate, "teams"))) return candidate;
        }
        return null;
    }
}
