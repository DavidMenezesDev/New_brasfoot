using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Tests;

public class FixtureGeneratorTests
{
    private static GameRandom Rng() => new(12345);

    /// <summary>Valida ausência de folgas/duplicatas na rodada e a contagem de confrontos.</summary>
    private static void AssertRoundRobin(List<List<Fixture>> rounds, int teams, int meetingsPerPair)
    {
        foreach (var round in rounds)
        {
            var seen = new HashSet<int>();
            foreach (var f in round)
            {
                Assert.NotEqual(f.Home, f.Away);
                Assert.True(f.Home >= 0 && f.Home < teams, $"mando inválido: {f.Home}");
                Assert.True(f.Away >= 0 && f.Away < teams, $"visitante inválido: {f.Away}");
                Assert.True(seen.Add(f.Home), $"time {f.Home} duas vezes na rodada");
                Assert.True(seen.Add(f.Away), $"time {f.Away} duas vezes na rodada");
            }
        }

        var counts = new Dictionary<(int, int), int>();
        foreach (var round in rounds)
            foreach (var f in round)
            {
                var key = (Math.Min(f.Home, f.Away), Math.Max(f.Home, f.Away));
                counts[key] = counts.GetValueOrDefault(key) + 1;
            }

        Assert.Equal(teams * (teams - 1) / 2, counts.Count);
        Assert.All(counts.Values, c => Assert.Equal(meetingsPerPair, c));
    }

    [Theory]
    [InlineData(4)]
    [InlineData(6)]
    [InlineData(10)]
    [InlineData(20)]
    public void Generic_double_round_robin_is_balanced(int teams)
    {
        var rounds = FixtureGenerator.Generic(teams, 2, Rng());

        Assert.Equal((teams - 1) * 2, rounds.Count);
        Assert.All(rounds, r => Assert.Equal(teams / 2, r.Count));
        AssertRoundRobin(rounds, teams, meetingsPerPair: 2);

        // No returno cada confronto se inverte: um jogo em cada mando.
        var directed = rounds.SelectMany(r => r).ToList();
        foreach (var f in directed)
            Assert.Contains(directed, g => g.Home == f.Away && g.Away == f.Home);
    }

    [Fact]
    public void Generic_single_round_robin_meets_each_pair_once()
    {
        var rounds = FixtureGenerator.Generic(8, 1, Rng());
        Assert.Equal(7, rounds.Count);
        AssertRoundRobin(rounds, 8, meetingsPerPair: 1);
    }

    [Fact]
    public void Generic_turns_multiply_the_schedule()
    {
        Assert.Equal(7, FixtureGenerator.Generic(8, 1, Rng()).Count);
        Assert.Equal(21, FixtureGenerator.Generic(8, 3, Rng()).Count);
        Assert.Equal(28, FixtureGenerator.Generic(8, 4, Rng()).Count);
    }

    [Fact]
    public void Twenty_team_national_league_has_38_rounds_and_380_matches()
    {
        var rounds = FixtureGenerator.ForLeague(new FixtureOptions { TeamCount = 20, IsNationalLeague = true }, Rng());

        Assert.Equal(38, rounds.Count);
        Assert.Equal(380, rounds.Sum(r => r.Count));
        AssertRoundRobin(rounds, 20, meetingsPerPair: 2);
    }

    [Fact]
    public void Fixed_tables_three_to_nine_teams()
    {
        AssertRoundRobin(FixtureGenerator.ThreeTeams(doubleRound: true), 3, 2);
        AssertRoundRobin(FixtureGenerator.FourTeams(), 4, 1);
        AssertRoundRobin(FixtureGenerator.FiveTeams(doubleRound: false), 5, 1);
        AssertRoundRobin(FixtureGenerator.FiveTeams(doubleRound: true), 5, 2);
        AssertRoundRobin(FixtureGenerator.SixTeams(), 6, 2);
        AssertRoundRobin(FixtureGenerator.NineTeams(doubleRound: true), 9, 2);
    }

    [Fact]
    public void Fixed_table_nineteen_teams_is_two_turns()
    {
        var rounds = FixtureGenerator.NineteenTeams();
        Assert.Equal(38, rounds.Count);
        Assert.All(rounds, r => Assert.Equal(9, r.Count));
        AssertRoundRobin(rounds, 19, 2);
    }

    [Theory]
    [InlineData(11)]
    [InlineData(25)]
    public void Odd_counts_without_a_fixed_table_fall_back_to_a_valid_round_robin(int teams)
    {
        // 11 e 25 não têm tabela fixa transcrita (best.t.dg/dh): o despacho cai no gerador
        // corrigido, que produz um rodízio válido (documentado como não byte-idêntico).
        var rounds = FixtureGenerator.ForLeague(
            new FixtureOptions { TeamCount = teams, IsNationalLeague = true }, Rng());
        AssertRoundRobin(rounds, teams, meetingsPerPair: 2);
    }

    [Fact]
    public void Dispatcher_matches_the_original_turn_rule()
    {
        // f/s.java:644-660
        Assert.Equal(2, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 20, IsNationalLeague = true }));
        Assert.Equal(1, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 20, IsNationalLeague = true, CompetitionId = 1020 }));
        Assert.Equal(4, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 8, IsNationalLeague = true }));
        Assert.Equal(4, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 10, IsNationalLeague = true }));
        Assert.Equal(2, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 10, IsNationalLeague = true, ConfiguredTurns = 2 }));
        Assert.Equal(3, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 12, IsNationalLeague = true }));
        Assert.Equal(2, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 12, IsNationalLeague = true, ConfiguredTurns = 2 }));
        Assert.Equal(1, FixtureGenerator.ResolveGenericTurns(new FixtureOptions { TeamCount = 30, IsNationalLeague = true }));
    }
}

public class LeagueTableTests
{
    private static (Team A, Team B, Team C) Teams()
    {
        var a = TestData.Team("A", 60);
        var b = TestData.Team("B", 60);
        var c = TestData.Team("C", 60);
        return (a, b, c);
    }

    [Fact]
    public void Apply_accumulates_points_goals_and_record()
    {
        var (a, b, _) = Teams();
        var table = new LeagueTable([a, b]);
        table.Apply(a, 2, b, 1);
        table.Apply(b, 3, a, 3);

        var rowA = table.Get(a);
        Assert.Equal(2, rowA.Played);
        Assert.Equal(1, rowA.Won);
        Assert.Equal(1, rowA.Drawn);
        Assert.Equal(4, rowA.Points);
        Assert.Equal(5, rowA.GoalsFor);
        Assert.Equal(4, rowA.GoalsAgainst);
        Assert.Equal(1, rowA.GoalDifference);
    }

    [Fact]
    public void Ordering_is_points_then_wins_then_goal_difference_then_goals_for()
    {
        var (a, b, c) = Teams();
        var table = new LeagueTable([a, b, c]);

        // A: 3pts (1V), B: 3pts (1V), C: 0. Same points/wins -> goal difference decides.
        table.Apply(a, 1, c, 0);   // A 3pts, +1
        table.Apply(b, 5, c, 0);   // B 3pts, +5
        var ordered = table.Ordered();
        Assert.Same(b, ordered[0].Team);
        Assert.Same(a, ordered[1].Team);
        Assert.Same(c, ordered[2].Team);

        Assert.Equal(1, table.PositionOf(b));
        Assert.Equal(2, table.PositionOf(a));
        table.Apply(b, 1, a, 0);   // B now 6pts, first
        Assert.Equal(1, table.PositionOf(b));
        Assert.Equal(2, table.PositionOf(a));
        Assert.Equal(3, table.PositionOf(c));
    }
}

public class LeagueIntegrationTests
{
    private static GameSession NewSession(int teamCount)
    {
        var world = new World();
        for (var i = 0; i < teamCount; i++)
            world.Teams.Add(TestData.Team($"T{i:00}", 60));
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(seed: 7));
        session.BuildSeasonCalendar();
        return session;
    }

    [Fact]
    public void Twenty_team_league_schedules_all_rounds_on_national_days()
    {
        var session = NewSession(20);
        var league = SeasonBuilder.CreateLeague(session, "Brasileirão", CompetitionType.Nacional, session.State.World.Teams);

        Assert.Equal(38, league.Rounds.Count);
        Assert.Equal(380, league.TotalMatches);
        Assert.Equal(38, league.DayIndexes.Distinct().Count());
        Assert.All(league.DayIndexes, i => Assert.Equal(DayType.Nacional, session.Days[i].Type));
        Assert.All(league.DayIndexes, i => Assert.Equal(10, session.Days[i].Matches.Count(m => ReferenceEquals(m.Competition, league.Competition))));
    }

    [Fact]
    public void League_records_results_once_per_match()
    {
        var session = NewSession(20);
        var league = SeasonBuilder.CreateLeague(session, "Brasileirão", CompetitionType.Nacional, session.State.World.Teams);
        var day = session.Days[league.DayIndexes[0]];

        foreach (var match in day.Matches) MatchSimulator.Play(match, session.Context);
        Assert.Equal(10, league.RecordResults(day));
        Assert.Equal(0, league.RecordResults(day)); // idempotente
        Assert.All(league.Standing.Select(s => s.Played), p => Assert.Equal(1, p));
    }

    [Fact]
    public void Small_league_plays_a_complete_season_and_crowns_a_champion()
    {
        var session = NewSession(6);
        var league = SeasonBuilder.CreateLeague(session, "Liga", CompetitionType.Nacional, session.State.World.Teams);

        var guard = 0;
        while (!session.SeasonEnded && guard++ < 5000)
            session.AdvanceToNextMatchDay();

        Assert.True(league.IsComplete, "a liga não completou todos os jogos");
        Assert.Equal(30, league.TotalMatches);              // 6 times, 10 rodadas x 3 jogos
        Assert.All(league.Standing.Select(s => s.Played), p => Assert.Equal(10, p));
        Assert.NotNull(league.Champion);
        Assert.Equal(league.Standing[0].Team, league.Champion!.Team);
    }
}

public class KnockoutTiebreakTests
{
    private static (Team A, Team B) Teams()
    {
        var a = TestData.Team("A", 60);
        var b = TestData.Team("B", 60);
        return (a, b);
    }

    private static Match Leg(Team home, Team away, int hg, int ag, int? shootoutWinner = null)
    {
        var match = new Match(home, away, new Competition(1, "Copa", CompetitionType.CopaNacional), new GameRandom(1));
        match.Score[0] = hg;
        match.Score[1] = ag;
        match.ShootoutWinner = shootoutWinner;
        return match;
    }

    [Fact]
    public void Single_leg_is_decided_by_the_score()
    {
        var (a, b) = Teams();
        Assert.Equal(0, KnockoutTiebreak.Resolve(Leg(a, b, 2, 1)));
        Assert.Equal(1, KnockoutTiebreak.Resolve(Leg(a, b, 0, 3)));
    }

    [Fact]
    public void Single_leg_draw_goes_to_the_shootout_winner()
    {
        var (a, b) = Teams();
        Assert.Equal(0, KnockoutTiebreak.Resolve(Leg(a, b, 1, 1, shootoutWinner: 0)));
        Assert.Equal(1, KnockoutTiebreak.Resolve(Leg(a, b, 1, 1, shootoutWinner: 1)));
    }

    [Fact]
    public void Aggregate_decides_a_two_legged_tie()
    {
        var (a, b) = Teams();
        // A 2x1 B na ida; B 0x0 A na volta -> A 2x1 no agregado.
        Assert.Equal(0, KnockoutTiebreak.Resolve(Leg(a, b, 2, 1), Leg(b, a, 0, 0)));
        // A 0x1 B na ida; B 0x0 A na volta -> B 1x0 no agregado.
        Assert.Equal(1, KnockoutTiebreak.Resolve(Leg(a, b, 0, 1), Leg(b, a, 0, 0)));
    }

    [Fact]
    public void Winning_both_legs_advances()
    {
        var (a, b) = Teams();
        // A vence a ida em casa 1x0 e a volta fora 1x0: avança com folga.
        Assert.Equal(0, KnockoutTiebreak.Resolve(Leg(a, b, 1, 0), Leg(b, a, 0, 1)));
    }

    [Fact]
    public void Away_goals_break_a_two_legged_draw()
    {
        var (a, b) = Teams();
        // A 2x2 B na ida (B marca 2 fora); B 0x0 A na volta. Agregado 2x2; B tem mais gols fora.
        Assert.Equal(1, KnockoutTiebreak.Resolve(Leg(a, b, 2, 2), Leg(b, a, 0, 0), awayGoalsRule: true));
        // Sem a regra do gol fora, o confronto vai para os pênaltis (lado 1 da volta = A avança).
        var leg1 = Leg(a, b, 2, 2);
        var leg2 = Leg(b, a, 0, 0, shootoutWinner: 1);
        Assert.Equal(0, KnockoutTiebreak.Resolve(leg1, leg2, awayGoalsRule: false));
    }

    [Fact]
    public void Special_competition_always_advances_the_second_team()
    {
        var (a, b) = Teams();
        // Nível no agregado e nos gols fora -> a competição 2129 manda o visitante da ida (B) avançar.
        Assert.Equal(1, KnockoutTiebreak.Resolve(Leg(a, b, 1, 1), Leg(b, a, 1, 1),
            competitionId: KnockoutTiebreak.AwayAlwaysAdvancesCompetition));
    }

    [Fact]
    public void Without_penalties_the_second_team_advances_on_the_tiebreak_quirk()
    {
        var (a, b) = Teams();
        // Dois 1x1: agregado 2x2, gols fora iguais e sem pênaltis -> quirk de f/G.java:305 avança B.
        Assert.Equal(1, KnockoutTiebreak.Resolve(Leg(a, b, 1, 1), Leg(b, a, 1, 1)));
    }
}

public class KnockoutBracketTests
{
    private static Competition Cup => new(6, "Copa do Brasil", CompetitionType.CopaNacional);

    [Fact]
    public void Single_leg_bracket_crowns_a_champion_in_two_rounds()
    {
        var ctx = TestData.Context(seed: 7);
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"B{i}", 55)).ToList();
        var bracket = new KnockoutBracket(Cup, teams);

        var champion = bracket.PlayAll(ctx);

        Assert.Contains(champion, teams);
        Assert.Equal(2, bracket.Rounds.Count);
        Assert.All(bracket.Rounds[0].Pairings, p => Assert.NotNull(p.FirstLeg));
        Assert.All(bracket.Rounds[0].Pairings, p => Assert.Null(p.SecondLeg));
        Assert.Equal(3, bracket.Rounds.Sum(r => r.Pairings.Count));   // 2 jogos + 1 final
        Assert.Equal(champion, bracket.Rounds[1].Pairings[0].Winner);
    }

    [Fact]
    public void Two_legged_bracket_plays_both_legs_for_every_tie()
    {
        var ctx = TestData.Context(seed: 9);
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"C{i}", 55)).ToList();
        var bracket = new KnockoutBracket(Cup, teams, twoLegged: true, awayGoalsRule: true);

        var champion = bracket.PlayAll(ctx);

        Assert.Contains(champion, teams);
        Assert.All(bracket.Rounds[0].Pairings, p =>
        {
            Assert.NotNull(p.FirstLeg);
            Assert.NotNull(p.SecondLeg);
            Assert.Equal(p.FirstLeg!.Away, p.SecondLeg!.Home);   // a volta inverte o mando
            Assert.Equal(p.FirstLeg.Home, p.SecondLeg.Away);
            Assert.True(p.FirstLeg.IsFinished);
            Assert.True(p.SecondLeg.IsFinished);
        });
        Assert.NotNull(bracket.Rounds[1].Pairings[0].FirstLeg);
        Assert.NotNull(bracket.Rounds[1].Pairings[0].SecondLeg);
        Assert.Equal(6, bracket.Rounds.Sum(r => r.Pairings.Count) * 2);   // (2 + 1) x ida e volta
    }

    [Fact]
    public void Winner_is_always_one_of_the_two_teams_of_the_tie()
    {
        var ctx = TestData.Context(seed: 13);
        for (var run = 0; run < 20; run++)
        {
            var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"D{run}_{i}", 50)).ToList();
            var bracket = new KnockoutBracket(Cup, teams, twoLegged: true);
            bracket.PlayAll(ctx);
            foreach (var round in bracket.Rounds)
                foreach (var pairing in round.Pairings)
                    Assert.Contains(pairing.Winner, new[] { pairing.Home, pairing.Away });
        }
    }

    [Fact]
    public void Bracket_rejects_a_non_power_of_two()
    {
        var teams = Enumerable.Range(0, 3).Select(i => TestData.Team($"E{i}", 50)).ToList();
        Assert.Throws<ArgumentException>(() => new KnockoutBracket(Cup, teams));
    }

    [Fact]
    public void Per_round_two_legged_flags_drive_each_round()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"R{i}", 60)).ToList();
        var bracket = new KnockoutBracket(
            Cup, teams, twoLeggedByRound: [true, false, false]);

        bracket.PlayAll(TestData.Context(seed: 3));

        Assert.All(bracket.Rounds[0].Pairings, p => Assert.NotNull(p.SecondLeg));   // quartas: ida e volta
        Assert.All(bracket.Rounds[1].Pairings, p => Assert.Null(p.SecondLeg));      // semi: jogo único
        Assert.Null(bracket.Rounds[2].Pairings[0].SecondLeg);                       // final: jogo único
        Assert.Equal(8, bracket.Rounds[0].Pairings.Count * 2);                       // 4 confrontos x 2 jogos
    }

    [Fact]
    public void Round_names_follow_fz()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"S{i}", 60)).ToList();
        var bracket = new KnockoutBracket(Cup, teams);
        Assert.Equal("Quartas", bracket.RoundName(0));
        Assert.Equal("Semifinal", bracket.RoundName(1));
        Assert.Equal("Final", bracket.RoundName(2));

        var twoLeg = new KnockoutBracket(Cup, teams, twoLegged: true);
        Assert.Equal("Quartas - 1º jogo", twoLeg.RoundName(0, leg: 1));
        Assert.Equal("Quartas - 2º jogo", twoLeg.RoundName(0, leg: 2));
    }
}

public class KnockoutPlanTests
{
    [Theory]
    [InlineData(2, 0, -1, 1)]
    [InlineData(4, 0, -1, 2)]
    [InlineData(8, 0, -1, 3)]
    [InlineData(16, 0, -1, 4)]
    [InlineData(32, 0, -1, 5)]
    [InlineData(64, 0, -1, 6)]
    [InlineData(128, 0, -1, 7)]
    [InlineData(200, 0, 2029, 7)]
    [InlineData(3, 3, -1, 3)]
    public void Round_count_matches_the_original(int participants, int fixedRounds, int code, int expected) =>
        Assert.Equal(expected, KnockoutPlan.RoundCount(participants, fixedRounds, code));

    [Fact]
    public void Round_names_pick_the_right_array()
    {
        Assert.Equal(["Quartas", "Semifinal", "Final"], KnockoutPlan.RoundNames(2));
        Assert.Equal(["Decisão"], KnockoutPlan.RoundNames(0));
        Assert.Equal(["Decisão da Vaga"], KnockoutPlan.RoundNames(3, code: 1068));
        Assert.Equal("Preliminar 1", KnockoutPlan.RoundName(7, 0));   // ZG==7 desce para 6, mas ps é o array   // quirk: ZG 7 -> 6
    }

    [Fact]
    public void Preliminar_labels_and_leg_suffix()
    {
        // best/aq.pC = { Semifinal, Final }; tR == 4 vira "Preliminar R1/R2".
        Assert.Equal("Preliminar R1", KnockoutPlan.RoundName(1, 0, bracketType: 4));
        Assert.Equal("Preliminar R2", KnockoutPlan.RoundName(1, 1, bracketType: 4));
        Assert.Equal("Decisão da Vaga", KnockoutPlan.RoundName(0, 0, code: 1068));
    }
}

public class GroupStageTests
{
    private static GameSession NewSession(int teamCount)
    {
        var world = new World();
        for (var i = 0; i < teamCount; i++)
            world.Teams.Add(TestData.Team($"G{i:00}", 60));
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(seed: 5));
        session.BuildSeasonCalendar();
        return session;
    }

    [Fact]
    public void Groups_share_the_same_national_days()
    {
        var session = NewSession(8);
        var competition = new Competition(1, "Copa", CompetitionType.Nacional);
        var groups = new List<IReadOnlyList<Team>>
        {
            session.State.World.Teams.Take(4).ToList(),
            session.State.World.Teams.Skip(4).Take(4).ToList(),
        };
        var stage = new GroupStage(session, competition, groups);

        Assert.Equal(2, stage.Groups.Count);
        Assert.Equal(3, stage.Groups[0].DayIndexes.Count);   // 4 times -> 3 rodadas
        Assert.Equal(stage.Groups[0].DayIndexes, stage.Groups[1].DayIndexes);
        Assert.All(stage.Groups[0].DayIndexes, i => Assert.Equal(DayType.Nacional, session.Days[i].Type));
        var day = session.Days[stage.Groups[0].DayIndexes[0]];
        Assert.Equal(4, day.Matches.Count);   // 2 jogos de cada grupo no mesmo dia
        Assert.Equal(2, day.Matches.Count(m => ReferenceEquals(m.Competition, stage.Groups[0].Competition)));
        Assert.Equal(2, day.Matches.Count(m => ReferenceEquals(m.Competition, stage.Groups[1].Competition)));
    }

    [Fact]
    public void Qualifiers_take_the_top_of_each_group_plus_the_best_thirds()
    {
        var session = NewSession(12);
        var competition = new Competition(1, "Copa", CompetitionType.Nacional);
        var all = session.State.World.Teams;
        var groups = new List<IReadOnlyList<Team>>();
        for (var g = 0; g < 3; g++) groups.Add(all.Skip(g * 4).Take(4).ToList());
        var stage = new GroupStage(session, competition, groups);

        var guard = 0;
        while (!session.SeasonEnded && guard++ < 5000) session.AdvanceToNextMatchDay();

        Assert.True(stage.IsComplete);
        var qualifiers = stage.Qualifiers(directPerGroup: 2, bestAlso: 1, bestAlsoPlace: 3);
        Assert.Equal(7, qualifiers.Count);   // 2 x 3 grupos + 1 melhor terceiro
        foreach (var group in stage.Groups)
            for (var place = 0; place < 2; place++)
                Assert.Contains(group.Standing[place].Team, qualifiers);
        Assert.Equal(stage.PlacementsInOrder(3)[0].Team, qualifiers[^1]);
    }
}

public class BracketSeederTests
{
    private static List<Team> Teams(int count) =>
        Enumerable.Range(0, count).Select(i => TestData.Team($"T{i:00}", 60)).ToList();

    private static List<IReadOnlyList<Team>> Groups(List<Team> all, int groupCount, int perGroup)
    {
        var groups = new List<IReadOnlyList<Team>>();
        for (var g = 0; g < groupCount; g++)
            groups.Add(all.Skip(g * perGroup).Take(perGroup).ToList());
        return groups;
    }

    [Fact]
    public void SeedByMatrix_reads_each_key_position_from_the_matrix()
    {
        var teams = Teams(8);
        var seeded = BracketSeeder.SeedByMatrix(teams, BracketTables.Zu);

        for (var i = 0; i < 8; i++) Assert.Same(teams[BracketTables.Zu[i]], seeded[i]);
    }

    [Fact]
    public void SeedByMatrix_rejects_a_mismatched_matrix()
    {
        var teams = Teams(8);
        Assert.Throws<ArgumentException>(() => BracketSeeder.SeedByMatrix(teams, BracketTables.Zy));
    }

    [Fact]
    public void Group_path_uses_Zw_for_16_and_Zx_when_two_legged()
    {
        var all = Teams(32);
        var groups = Groups(all, 8, 4);   // 8 grupos x 2 = 16

        var oneLeg = BracketSeeder.FromGroupQualifiers(groups, perGroup: 2, twoLegged: false);
        var twoLeg = BracketSeeder.FromGroupQualifiers(groups, perGroup: 2, twoLegged: true);
        var flattened = BracketSeeder.FlattenQualifiers(groups, 2);

        Assert.Equal(16, oneLeg.Count);
        for (var i = 0; i < 16; i++)
        {
            Assert.Same(flattened[BracketTables.Zw[i]], oneLeg[i]);
            Assert.Same(flattened[BracketTables.Zx[i]], twoLeg[i]);
        }
    }

    [Fact]
    public void Group_path_uses_Zy_for_32_and_honors_the_national_phase()
    {
        var all = Teams(64);
        var groups = Groups(all, 16, 4);   // 16 grupos x 2 = 32
        var flattened = BracketSeeder.FlattenQualifiers(groups, 2);

        var seeded = BracketSeeder.FromGroupQualifiers(groups, perGroup: 2, twoLegged: false);
        Assert.Equal(32, seeded.Count);
        for (var i = 0; i < 32; i++) Assert.Same(flattened[BracketTables.Zy[i]], seeded[i]);

        // Fase nacional (var0 == 7/10): é de 8 times; Zs é a identidade e Zt troca os pares.
        var groups8 = Groups(Teams(16), 4, 4);   // 4 grupos x 2 = 8
        var flat8 = BracketSeeder.FlattenQualifiers(groups8, 2);
        var natOne = BracketSeeder.FromGroupQualifiers(groups8, 2, twoLegged: false, nationalPhase: true);
        var natTwo = BracketSeeder.FromGroupQualifiers(groups8, 2, twoLegged: true, nationalPhase: true);
        for (var i = 0; i < 8; i++)
        {
            Assert.Same(flat8[BracketTables.Zs[i]], natOne[i]);
            Assert.Same(flat8[BracketTables.Zt[i]], natTwo[i]);
        }
    }

    [Fact]
    public void Thirds_path_uses_Zz_for_32_and_Zu_or_Zv_for_8()
    {
        var extras = RankedExtras(Teams(20));

        // 12 grupos x 2 = 24 + 8 terceiros = 32 -> Zz (ignora ida e volta, quirk f/s.java:824).
        var groups32 = Groups(Teams(64), 12, 4);
        var combined32 = BracketSeeder.FlattenQualifiers(groups32, 2);
        combined32.AddRange(extras.Take(8).Select(s => s.Team));
        var seeded32 = BracketSeeder.FromGroupQualifiersWithThirds(groups32, 2, extras, 8, twoLegged: true);
        Assert.Equal(32, seeded32.Count);
        for (var i = 0; i < 32; i++) Assert.Same(combined32[BracketTables.Zz[i]], seeded32[i]);

        // 3 grupos x 2 = 6 + 2 terceiros = 8 -> Zu (jogo único) / Zv (ida e volta).
        var groups8 = Groups(Teams(24), 3, 4);
        var combined8 = BracketSeeder.FlattenQualifiers(groups8, 2);
        combined8.AddRange(extras.Take(2).Select(s => s.Team));
        var oneLeg = BracketSeeder.FromGroupQualifiersWithThirds(groups8, 2, extras, 2, twoLegged: false);
        var twoLeg = BracketSeeder.FromGroupQualifiersWithThirds(groups8, 2, extras, 2, twoLegged: true);
        for (var i = 0; i < 8; i++)
        {
            Assert.Same(combined8[BracketTables.Zu[i]], oneLeg[i]);
            Assert.Same(combined8[BracketTables.Zv[i]], twoLeg[i]);
        }
    }

    [Theory]
    [InlineData(3, -1, 2)]
    [InlineData(6, -1, 4)]
    [InlineData(12, -1, 8)]
    [InlineData(17, -1, 15)]
    [InlineData(10, 1403, 6)]
    [InlineData(10, -1, 0)]
    [InlineData(4, -1, 0)]
    public void Best_thirds_count_matches_the_original_table(int groups, int competitionId, int expected) =>
        Assert.Equal(expected, BracketSeeder.BestThirdsCount(groups, competitionId));

    [Theory]
    [InlineData(10, 1403, 1)]
    [InlineData(17, -1, 1)]
    [InlineData(12, -1, 2)]
    [InlineData(3, -1, 2)]
    public void Extra_placement_index_matches_the_original(int groups, int competitionId, int expected) =>
        Assert.Equal(expected, BracketSeeder.BestExtraPlacementIndex(groups, competitionId));

    [Fact]
    public void Alternate_seeding_interleaves_seconds_and_firsts()
    {
        var firsts = Enumerable.Range(0, 8).Select(i => TestData.Team($"F{i}", 60)).ToList();
        var seconds = Enumerable.Range(0, 8).Select(i => TestData.Team($"S{i}", 60)).ToList();

        var seeded = BracketSeeder.AlternateFirstsAndSeconds(firsts, seconds);

        var expected = new[]
        {
            seconds[7], firsts[0], seconds[0], firsts[7], seconds[4], firsts[3], seconds[3], firsts[4],
            seconds[6], firsts[1], seconds[1], firsts[6], seconds[5], firsts[2], seconds[2], firsts[5],
        };
        Assert.Equal(expected, seeded);
    }

    [Fact]
    public void National_final_phase_takes_and_shuffles_the_eight_best_seconds()
    {
        var ranked = RankedExtras(Teams(12));   // 12 segundos, já ordenados por h.K
        var seeded = BracketSeeder.NationalFinalPhase(ranked, new Random(1));

        Assert.Equal(8, seeded.Count);
        Assert.Equal(ranked.Take(8).Select(s => s.Team).OrderBy(t => t.Name).ToList(),
                     seeded.OrderBy(t => t.Name).ToList());
        Assert.Contains(seeded[0], ranked.Take(8).Select(s => s.Team));
    }

    [Fact]
    public void FromList_uses_the_no_group_matrices()
    {
        var teams = Teams(4);
        var oneLeg = BracketSeeder.FromList(teams, twoLegged: false);
        var twoLeg = BracketSeeder.FromList(teams, twoLegged: true);

        for (var i = 0; i < 4; i++)
        {
            Assert.Same(teams[BracketTables.Zo[i]], oneLeg[i]);
            Assert.Same(teams[BracketTables.Zp[i]], twoLeg[i]);
        }
    }

    [Fact]
    public void Test_seed_feeds_a_playable_bracket()
    {
        var session = new GameSession(
            GameState.FromWorld(WorldOf(8), new GameOptions()),
            TestData.Context(seed: 7));
        session.State.BaseYear = 2022;
        session.BuildSeasonCalendar();

        var competition = new Competition(1, "Copa", CompetitionType.Nacional);
        var groups = Groups(session.State.World.Teams, 2, 4);
        var stage = new GroupStage(session, competition, groups);

        var guard = 0;
        while (!session.SeasonEnded && guard++ < 5000) session.AdvanceToNextMatchDay();

        var seeded = stage.SeedKnockout(perGroup: 2, twoLegged: false);
        Assert.Equal(4, seeded.Count);
        var bracket = new KnockoutBracket(competition, seeded);
        var champion = bracket.PlayAll(TestData.Context(seed: 11));
        Assert.Contains(champion, seeded);
    }

    private static List<TeamStanding> RankedExtras(List<Team> teams)
    {
        var table = new LeagueTable(Enumerable.Empty<Team>());
        var rows = teams.Select(t => table.Add(t)).ToList();
        for (var i = 0; i < rows.Count; i++) rows[i].Won = rows.Count - i;   // força uma ordem
        return LeagueTable.OrderByHk(rows);
    }

    private static World WorldOf(int count)
    {
        var world = new World();
        for (var i = 0; i < count; i++) world.Teams.Add(TestData.Team($"W{i:00}", 60));
        return world;
    }
}

public class CupDrawTests
{
    [Theory]
    [InlineData(7, 0)]
    [InlineData(8, 8)]
    [InlineData(15, 8)]
    [InlineData(16, 16)]
    [InlineData(100, 64)]
    [InlineData(127, 64)]
    [InlineData(128, 128)]
    [InlineData(300, 128)]
    public void Bracket_size_is_the_largest_power_of_two_that_fits(int pool, int expected) =>
        Assert.Equal(expected, CupDraw.BracketSize(pool));

    [Fact]
    public void Pool_with_fewer_than_eight_teams_seeds_nothing()
    {
        var pool = Teams(7);
        Assert.Empty(CupDraw.SeedFromPool(pool, TestData.Context(seed: 1).Random));
    }

    [Fact]
    public void Seed_interleaves_the_two_halves()
    {
        var pool = Teams(16);
        var random = TestData.Context(seed: 5).Random;
        var seeded = CupDraw.SeedFromPool(pool, random);

        Assert.Equal(16, seeded.Count);
        Assert.Equal(pool.OrderBy(t => t.Name).ToList(), seeded.OrderBy(t => t.Name).ToList());
        for (var i = 0; i < 8; i++)
        {
            // Pares consecutivos = (2ª metade, 1ª metade): o mando do 1º jogo fica definido.
            Assert.Contains(seeded[2 * i], pool.Skip(8));
            Assert.Contains(seeded[2 * i + 1], pool.Take(8));
        }
    }

    private static List<Team> Teams(int count) =>
        Enumerable.Range(0, count).Select(i => TestData.Team($"C{i:00}", 60)).ToList();
}

public class CopaDoBrasilTests
{
    /// <summary>Ordem de potes de <c>f/f.java:158-165</c> (espelhada do privado).</summary>
    private static readonly int[] PotOrder = [4, 0, 7, 3, 5, 1, 6, 2];

    private static List<Team> Clubs(int count, int levelBase = 0) =>
        Enumerable.Range(0, count)
            .Select(i => new Team { Id = 3000 + i, Name = $"CB{i:000}", FileRef = $"cb{i:000}", Level = levelBase + i })
            .ToList();

    private static List<Team> SortDescending(IEnumerable<Team> teams) =>
        teams.OrderBy(t => t, Comparer<Team>.Create(CopaDoBrasil.CompareClubs)).ToList();

    [Fact]
    public void Club_comparator_is_level_then_reputation_then_tiebreak()
    {
        var a = new Team { Name = "a", Level = 10, Reputation = 5, RankTiebreak = 1 };
        var b = new Team { Name = "b", Level = 11, Reputation = 1, RankTiebreak = 1 };
        var c = new Team { Name = "c", Level = 10, Reputation = 6, RankTiebreak = 0 };
        var d = new Team { Name = "d", Level = 10, Reputation = 5, RankTiebreak = 9 };

        var ordered = SortDescending([a, b, c, d]);
        Assert.Equal(["b", "c", "d", "a"], ordered.Select(t => t.Name));
    }

    [Fact]
    public void Excluded_is_the_first_twelve_of_the_pool()
    {
        var pool = Clubs(100);
        var excluded = CopaDoBrasil.SelectExcluded(pool);
        Assert.NotNull(excluded);
        Assert.Equal(12, excluded!.Count);
        Assert.Equal(pool.Take(12), excluded);
    }

    [Fact]
    public void Excluded_prefers_the_given_head_seeds()
    {
        var pool = Clubs(100);
        var preferred = new[] { pool[50], pool[51], pool[52] };
        var excluded = CopaDoBrasil.SelectExcluded(pool, preferred)!;
        Assert.Equal([pool[50], pool[51], pool[52], pool[0], pool[1], pool[2], pool[3], pool[4], pool[5], pool[6], pool[7], pool[8]],
                     excluded);
    }

    [Fact]
    public void Excluded_needs_twelve_clubs() =>
        Assert.Null(CopaDoBrasil.SelectExcluded(Clubs(5)));

    [Fact]
    public void First_stage_needs_eighty_clubs()
    {
        Assert.Empty(CopaDoBrasil.FirstStage(Clubs(79), TestData.Context(seed: 1).Random));
        Assert.Equal(80, CopaDoBrasil.FirstStage(Clubs(80), TestData.Context(seed: 1).Random).Count);
    }

    [Fact]
    public void First_stage_interleaves_eight_pots()
    {
        var remaining = Clubs(80);
        var order = CopaDoBrasil.FirstStage(remaining, TestData.Context(seed: 4).Random);

        Assert.Equal(remaining.OrderBy(t => t.Name), order.OrderBy(t => t.Name));
        var pots = Enumerable.Range(0, 8).Select(p => remaining.Skip(p * 10).Take(10).ToList()).ToList();
        for (var i = 0; i < 10; i++)
            for (var j = 0; j < 8; j++)
                Assert.Contains(order[8 * i + j], pots[PotOrder[j]]);
    }

    [Fact]
    public void Second_stage_pairs_weak_team_first()
    {
        var winners = Clubs(40);
        var order = CopaDoBrasil.SecondStage(winners, TestData.Context(seed: 2).Random);
        var sorted = SortDescending(winners);
        var stronger = sorted.Take(20).ToHashSet();
        var weaker = sorted.Skip(20).ToHashSet();

        Assert.Equal(40, order.Count);
        for (var i = 0; i < 20; i++)
        {
            Assert.Contains(order[2 * i], weaker);
            Assert.Contains(order[2 * i + 1], stronger);
        }
    }

    [Fact]
    public void Third_stage_pairs_strong_against_weak()
    {
        var winners = Clubs(20);
        var excluded = Clubs(12, levelBase: 100);
        var order = CopaDoBrasil.ThirdStage(winners, excluded, TestData.Context(seed: 2).Random);

        var all = SortDescending(winners.Concat(excluded));
        var stronger = all.Take(16).ToHashSet();
        var weaker = all.Skip(16).ToHashSet();
        Assert.Equal(32, order.Count);
        for (var i = 0; i < 16; i++)
        {
            Assert.Contains(order[2 * i], stronger);
            Assert.Contains(order[2 * i + 1], weaker);
        }
    }

    [Fact]
    public void Stage_table_matches_the_original()
    {
        Assert.Equal([2129, 2229, 2329, 2429, 2529, 2629, 2729], CopaDoBrasil.StageCodes);
        Assert.Equal([false, false, true, true, true, true, true], CopaDoBrasil.TwoLeggedByStage);
        Assert.Equal([4, 0, 7, 3, 5, 1, 6, 2], PotOrder);
    }

    [Fact]
    public void Full_course_crowns_a_champion_from_the_pool()
    {
        var pool = Enumerable.Range(0, 100).Select(i => TestData.Team($"T{i:000}", 60)).ToList();
        var champion = CopaDoBrasil.Play(
            new Competition(2029, "Copa do Brasil", CompetitionType.CopaNacional),
            pool, TestData.Context(seed: 9));

        Assert.NotNull(champion);
        Assert.Contains(champion, pool);
    }

    [Fact]
    public void Small_pool_has_no_pot_format() =>
        Assert.Null(CopaDoBrasil.Play(
            new Competition(2029, "Copa do Brasil", CompetitionType.CopaNacional),
            Clubs(50), TestData.Context(seed: 3)));
}

public class GroupKnockoutSeedingGateTests
{
    // f/s.java:852-867: type 4 ("liga*") + continente 0 (Europa, Champions) -> alternado, embaralhado.
    [Theory]
    [InlineData(CompetitionType.Internacional1, 0, true, false, false)]
    // type 4 + continente 1/2/3 (América do Sul/África/Ásia) -> alternado, ranqueado; continente 1 também liga gol fora.
    [InlineData(CompetitionType.Internacional1, 1, true, true, true)]
    [InlineData(CompetitionType.Internacional1, 2, true, true, false)]
    [InlineData(CompetitionType.Internacional1, 3, true, true, false)]
    // type 4 + continente 4/5 (Concacaf/Oceania) -> matriz por tamanho (não alternado).
    [InlineData(CompetitionType.Internacional1, 4, false, false, false)]
    [InlineData(CompetitionType.Internacional1, 5, false, false, false)]
    // type 6 ("liga*" de segunda divisão) + continente 0 (Europa League) -> alternado, embaralhado.
    [InlineData(CompetitionType.Internacional2, 0, true, false, false)]
    // type 6 + continente 1 (Sul-Americana) -> matriz por tamanho, mas com gol fora (Conmebol).
    [InlineData(CompetitionType.Internacional2, 1, false, false, true)]
    // Qualquer outro tipo não participa do portão (sempre matriz por tamanho).
    [InlineData(CompetitionType.Nacional, 0, false, false, false)]
    [InlineData(CompetitionType.CopaNacional, 1, false, false, false)]
    public void Determine_seeding_matches_fs_yP_gate(
        CompetitionType type, int continent, bool alternate, bool ranked, bool awayGoals)
    {
        var mode = BracketSeeder.DetermineGroupKnockoutSeeding(type, continent);
        Assert.Equal(alternate, mode.Alternate);
        Assert.Equal(ranked, mode.RankedNotShuffled);
        Assert.Equal(awayGoals, mode.AwayGoals);
    }
}

public class GroupStageAutoSeedingTests
{
    private static GameSession NewSession(int teamCount)
    {
        var world = new World();
        for (var i = 0; i < teamCount; i++)
            world.Teams.Add(TestData.Team($"A{i:00}", 60));
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(seed: 17));
        session.BuildSeasonCalendar();
        return session;
    }

    private static GroupStage PlayedEightGroupsOfTwo(GameSession session, Competition competition)
    {
        var groups = new List<IReadOnlyList<Team>>();
        for (var g = 0; g < 8; g++) groups.Add(session.State.World.Teams.Skip(g * 2).Take(2).ToList());
        var stage = new GroupStage(session, competition, groups);

        var guard = 0;
        while (!session.SeasonEnded && guard++ < 5000) session.AdvanceToNextMatchDay();
        Assert.True(stage.IsComplete);
        return stage;
    }

    [Fact]
    public void Libertadores_style_competition_uses_the_alternate_crossing()
    {
        var session = NewSession(16);
        // tipo 4 (Internacional1), continente 1 (América do Sul) -> f/s.java:856-864: alternado + ranqueado.
        var competition = new Competition(1, "Libertadores", CompetitionType.Internacional1) { Continent = 1 };
        var stage = PlayedEightGroupsOfTwo(session, competition);

        var seeded = stage.SeedKnockoutAuto(twoLegged: true, new Random(1));
        var matrixSeeded = stage.SeedKnockout(perGroup: 2, twoLegged: true);

        Assert.Equal(16, seeded.Count);
        Assert.Equal(seeded.OrderBy(t => t.Name).ToList(), matrixSeeded.OrderBy(t => t.Name).ToList());
        Assert.NotEqual(matrixSeeded, seeded);   // o chaveamento alternado reordena o mesmo conjunto
    }

    [Fact]
    public void National_league_style_competition_keeps_the_size_matrix()
    {
        var session = NewSession(16);
        var competition = new Competition(1, "Copa", CompetitionType.Nacional);
        var stage = PlayedEightGroupsOfTwo(session, competition);

        var seeded = stage.SeedKnockoutAuto(twoLegged: false, new Random(1));
        var matrixSeeded = stage.SeedKnockout(perGroup: 2, twoLegged: false);

        Assert.Equal(matrixSeeded, seeded);
    }
}

public class ThirdPlaceAndFinalPositionsTests
{
    private static Competition WithThirdPlace(bool decisao) =>
        new(7, "Copa América", CompetitionType.Selecoes) { DecisaoTerceiroLugar = decisao };

    [Fact]
    public void Decisao_terceiro_lugar_creates_a_match_between_the_two_semifinal_losers()
    {
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"F{i}", 55)).ToList();
        var bracket = new KnockoutBracket(WithThirdPlace(true), teams);
        var ctx = TestData.Context(seed: 21);

        bracket.PlayAll(ctx);

        var semifinal = bracket.Rounds[0];
        var final = bracket.Rounds[1];
        var semifinalLosers = semifinal.Pairings
            .Select(p => ReferenceEquals(p.Winner, p.Home) ? p.Away : p.Home)
            .ToList();

        Assert.NotNull(final.ThirdPlace);
        Assert.Contains(final.ThirdPlace!.Home, semifinalLosers);
        Assert.Contains(final.ThirdPlace.Away, semifinalLosers);
        Assert.NotNull(final.ThirdPlace.Winner);
        Assert.NotNull(final.ThirdPlace.FirstLeg);
        Assert.Null(final.ThirdPlace.SecondLeg);
    }

    [Fact]
    public void Without_the_flag_no_third_place_match_is_created()
    {
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"G{i}", 55)).ToList();
        var bracket = new KnockoutBracket(WithThirdPlace(false), teams);
        bracket.PlayAll(TestData.Context(seed: 23));

        Assert.Null(bracket.Rounds[1].ThirdPlace);
    }

    [Fact]
    public void Final_positions_rank_champion_runner_up_then_third_and_fourth()
    {
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"H{i}", 55)).ToList();
        var bracket = new KnockoutBracket(WithThirdPlace(true), teams);
        bracket.PlayAll(TestData.Context(seed: 25));

        var positions = bracket.FinalPositions();
        var champion = bracket.Champion!;
        var runnerUp = bracket.Rounds[1].Pairings[0].Away == champion
            ? bracket.Rounds[1].Pairings[0].Home
            : bracket.Rounds[1].Pairings[0].Away;
        var thirdPlaceWinner = bracket.Rounds[1].ThirdPlace!.Winner!;
        var thirdPlaceLoser = ReferenceEquals(thirdPlaceWinner, bracket.Rounds[1].ThirdPlace!.Home)
            ? bracket.Rounds[1].ThirdPlace!.Away
            : bracket.Rounds[1].ThirdPlace!.Home;

        Assert.Equal(4, positions.Count);
        Assert.Equal((champion, 1), positions[0]);
        Assert.Equal((runnerUp, 2), positions[1]);
        Assert.Equal((thirdPlaceWinner, 3), positions[2]);
        Assert.Equal((thirdPlaceLoser, 4), positions[3]);
    }

    [Fact]
    public void Final_positions_without_decisao_still_ranks_every_round_sequentially()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"I{i}", 55)).ToList();
        var bracket = new KnockoutBracket(WithThirdPlace(false), teams);
        bracket.PlayAll(TestData.Context(seed: 27));

        var positions = bracket.FinalPositions();

        Assert.Equal(8, positions.Count);
        Assert.Equal(Enumerable.Range(1, 8), positions.Select(p => p.Position));
        Assert.Equal(positions.Select(p => p.Team).Distinct().Count(), positions.Count);
        Assert.Equal(bracket.Champion, positions[0].Team);
    }

    [Fact]
    public void League_final_positions_follow_the_table_order()
    {
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"J{i}", 50 + i * 5)).ToList();
        var competition = new Competition(1, "Liga", CompetitionType.Nacional);
        var rounds = FixtureGenerator.ForLeague(
            new FixtureOptions { TeamCount = 4, IsNationalLeague = true, DoubleRound = true },
            new GameRandom(3));
        var league = new LeagueCompetition(competition, teams, rounds);
        var ctx = TestData.Context(seed: 29);
        foreach (var round in league.Rounds)
        {
            var day = new CalendarDay { Type = DayType.Nacional };
            foreach (var fixture in round)
                day.Matches.Add(new Match(teams[fixture.Home], teams[fixture.Away], competition, ctx.Random));
            MatchSimulator.PlayRound(day.Matches, teams, ctx);
            league.RecordResults(day);
        }

        var positions = league.FinalPositions();

        Assert.Equal(4, positions.Count);
        Assert.Equal(league.Standing.Select((s, i) => (s.Team, i + 1)), positions);
    }
}

public class PromotionRelegationTests
{
    private static List<Team> Teams(string prefix, int count) =>
        Enumerable.Range(0, count).Select(i => TestData.Team($"{prefix}{i}", 60)).ToList();

    private static List<TeamStanding> Standing(List<Team> teams)
    {
        // Pontuação decrescente: teams[0] é o 1º colocado, teams[^1] o lanterna.
        var table = new LeagueTable(teams);
        for (var i = 0; i < teams.Count; i++) table.Get(teams[i]).Won += teams.Count - i;
        return table.Ordered();
    }

    [Fact]
    public void Swap_adjacent_divisions_moves_the_bottom_of_upper_with_the_top_of_lower()
    {
        var upper = Teams("U", 4);
        var lower = Teams("L", 4);
        var upperStanding = Standing(upper);
        var lowerStanding = Standing(lower);

        var swaps = PromotionRelegation.SwapAdjacentDivisions(upper, upperStanding, 2, lower, lowerStanding, 2);

        Assert.Equal(2, swaps.Count);
        Assert.Equal(4, upper.Count);
        Assert.Equal(4, lower.Count);
        // Os 2 últimos da divisão de cima saíram dela e entraram na de baixo.
        foreach (var (relegated, promoted) in swaps)
        {
            Assert.DoesNotContain(relegated, upper);
            Assert.Contains(relegated, lower);
            Assert.DoesNotContain(promoted, lower);
            Assert.Contains(promoted, upper);
        }
    }

    [Fact]
    public void Swap_adjacent_divisions_is_a_no_op_when_counts_differ()
    {
        var upper = Teams("U", 4);
        var lower = Teams("L", 4);
        var swaps = PromotionRelegation.SwapAdjacentDivisions(
            upper, Standing(upper), 2, lower, Standing(lower), 1);

        Assert.Empty(swaps);
        Assert.Equal(4, upper.Count);
        Assert.Equal(4, lower.Count);
    }

    [Fact]
    public void Swap_with_pool_is_capped_by_the_pool_size_and_reverses_the_promoted_order()
    {
        var last = Teams("D", 4);
        var pool = Teams("P", 1);   // só 1 clube fora da liga, embora nRebaixados peça 2
        var standing = Standing(last);

        var swaps = PromotionRelegation.SwapLastDivisionWithPool(last, standing, relegatedCount: 2, pool);

        Assert.Single(swaps);
        Assert.DoesNotContain(swaps[0].Relegated, last);
        Assert.Contains(swaps[0].Relegated, pool);
        Assert.Contains(swaps[0].Promoted, last);
    }

    [Fact]
    public void Access_playoff_field_is_the_range_just_below_direct_promotion()
    {
        var teams = Teams("K", 8);
        var standing = Standing(teams);   // standing[i] = i-ésimo colocado

        // BN()=6 vagas disputam mata-mata, vagasSobemPeloMataMata=2 -> começa em 6-2=4, 4 times.
        var field = PromotionRelegation.AccessPlayoffField(standing, playoffPoolSize: 6, promotionSlotsFromPlayoff: 2);

        Assert.NotNull(field);
        Assert.Equal(standing.Skip(4).Take(4).Select(s => s.Team), field);
    }

    [Fact]
    public void Access_playoff_field_is_null_when_the_table_is_too_small()
    {
        var teams = Teams("K", 4);
        var standing = Standing(teams);
        Assert.Null(PromotionRelegation.AccessPlayoffField(standing, playoffPoolSize: 6, promotionSlotsFromPlayoff: 2));
    }

    [Fact]
    public void Relegation_playoff_field_interleaves_relegation_zone_with_promotion_candidates()
    {
        var upper = Teams("U", 6);
        var upperStanding = Standing(upper);   // nRebaixados=4, rebaixadosDireto=2 -> 2 no mata-mata
        var lowerCandidates = Teams("L", 2);

        var field = PromotionRelegation.RelegationPlayoffField(upperStanding, relegatedTotal: 4, relegatedDirect: 2, lowerCandidates);

        Assert.Equal(4, field.Count);
        // Zona de rebaixamento = os 4 piores (best/Z.java); dentro dela, o mata-mata pega os 2 piores
        // de todos, pior primeiro (f/s.fG, f/s.java:1306-1313): o lanterna (último da tabela) primeiro.
        var expectedUpper = upperStanding.TakeLast(4).Reverse().Take(2).Select(s => s.Team).ToList();
        Assert.Equal(expectedUpper[0], field[0]);
        Assert.Equal(expectedUpper[1], field[2]);
        Assert.Contains(field[1], lowerCandidates);
        Assert.Contains(field[3], lowerCandidates);
    }

    [Fact]
    public void Relegation_playoff_field_is_empty_without_a_playoff_quota() =>
        Assert.Empty(PromotionRelegation.RelegationPlayoffField(Standing(Teams("U", 4)), relegatedTotal: 2, relegatedDirect: 2, Teams("L", 2)));
}


