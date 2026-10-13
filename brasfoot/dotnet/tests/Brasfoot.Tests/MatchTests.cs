using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.Tests;

public class MatchTests
{
    private static readonly Competition League = new(1, "Liga", CompetitionType.Nacional);

    [Fact]
    public void Ai_lineup_fields_eleven_with_one_goalkeeper()
    {
        var ctx = TestData.Context();
        var home = TestData.Team("Casa", 50);
        var match = new Match(home, TestData.Team("Fora", 50), League, ctx.Random);
        LineupSelector.Select(home, match, 0, ctx);
        Assert.Equal(11, match.Lineup[0].Count);
        Assert.Single(match.Lineup[0], p => p.Slot == Pitch.Goalkeeper);
        Assert.Equal(Position.Goleiro, match.Lineup[0].Single(p => p.Slot == 1).Position);
        Assert.NotEmpty(match.Bench[0]);
        Assert.Empty(match.Lineup[0].Intersect(match.Bench[0]));
    }

    [Fact]
    public void Injured_and_suspended_players_are_not_picked()
    {
        var ctx = TestData.Context();
        var home = TestData.Team("Casa", 50);
        var injured = home.Squad.First(p => p.Position == Position.Atacante);
        injured.InjuredUntil = ctx.Today.AddDays(10);
        var suspended = home.Squad.Last(p => p.Position == Position.Atacante);
        suspended.StatsFor(League).BanMatches = 1;
        var match = new Match(home, TestData.Team("Fora", 50), League, ctx.Random);
        LineupSelector.Select(home, match, 0, ctx);
        Assert.DoesNotContain(injured, match.Lineup[0].Concat(match.Bench[0]));
        Assert.DoesNotContain(suspended, match.Lineup[0].Concat(match.Bench[0]));
    }

    [Fact]
    public void Same_seed_gives_same_match()
    {
        string Run()
        {
            var ctx = TestData.Context(seed: 123);
            var m = MatchSimulator.Play(new Match(TestData.Team("A", 50), TestData.Team("B", 45), League, ctx.Random), ctx);
            return $"{m.Score[0]}x{m.Score[1]} {m.Shots[0]}/{m.Shots[1]} {m.Events.Count}";
        }
        Assert.Equal(Run(), Run());
    }

    [Fact]
    public void Stronger_team_wins_more_and_scores_are_realistic()
    {
        var ctx = TestData.Context(seed: 9);
        var strong = TestData.Team("Forte", 70);
        var weak = TestData.Team("Fraco", 35);
        int strongWins = 0, weakWins = 0, goals = 0;
        const int n = 400;
        for (var i = 0; i < n; i++)
        {
            foreach (var p in strong.Squad.Concat(weak.Squad))
            {
                p.Energy = 100;
                p.InjuredUntil = null;
            }
            var m = MatchSimulator.Play(new Match(weak, strong, League, ctx.Random), ctx);
            goals += m.Score[0] + m.Score[1];
            if (m.Score[1] > m.Score[0]) strongWins++;
            else if (m.Score[0] > m.Score[1]) weakWins++;
        }
        Assert.True(strongWins > weakWins * 3, $"forte {strongWins} x fraco {weakWins}");
        Assert.InRange(goals / (double)n, 1.5, 5.0);
    }

    [Fact]
    public void Score_matches_goal_events()
    {
        var ctx = TestData.Context(seed: 77);
        for (var i = 0; i < 50; i++)
        {
            var m = MatchSimulator.Play(new Match(TestData.Team("A", 55), TestData.Team("B", 50), League, ctx.Random), ctx);
            for (var side = 0; side < 2; side++)
                Assert.Equal(m.Score[side], m.Events.Count(e => e.Type == MatchEventType.Gol && e.Side == side));
            Assert.All(m.OnPitch, list => Assert.InRange(list.Count, 7, 11));
        }
    }

    [Fact]
    public void Human_match_resolves_penalties_and_keeps_score_consistent()
    {
        var ctx = TestData.Context(seed: 5);
        for (var i = 0; i < 100; i++)
        {
            var human = TestData.Team("Humano", 50);
            human.IsHuman = true;
            var m = MatchSimulator.Play(new Match(human, TestData.Team("IA", 50), League, ctx.Random), ctx);
            for (var side = 0; side < 2; side++)
                Assert.Equal(m.Score[side], m.Events.Count(e => e.Type == MatchEventType.Gol && e.Side == side));
            Assert.DoesNotContain(m.Events, e => e.GoalType == GoalType.Penalty && e.Type == MatchEventType.Gol && !e.PenaltyCounted);
        }
    }

    [Fact]
    public void Red_card_suspends_and_three_yellows_suspend()
    {
        var ctx = TestData.Context(seed: 11);
        var home = TestData.Team("Casa", 50);
        var away = TestData.Team("Fora", 50);
        var match = new Match(home, away, League, ctx.Random);
        MatchSimulator.Play(match, ctx);
        var p = home.Squad[0];
        var rec = p.StatsFor(League);
        rec.Yellows = 3;
        Assert.True(rec.IsSuspended);

        PostMatch.Apply(match, ctx); // cumpre a suspensão: zera os amarelos
        Assert.Equal(0, rec.Yellows);
    }

    [Theory]
    [InlineData(1, 1, null, null, true)]          // jogo único empatado
    [InlineData(2, 1, null, null, false)]
    [InlineData(1, 0, 0, 1, true)]                 // ida 0x1 (mandante de hoje perdeu fora), volta 1x0
    public void Shootout_needed_on_aggregate_tie(int home, int away, int? legHome, int? legAway, bool expected)
    {
        var ctx = TestData.Context();
        var tie = new KnockoutTie(legHome is { } h ? (h, legAway!.Value) : null);
        var match = new Match(TestData.Team("A", 50), TestData.Team("B", 50), League, ctx.Random, tie);
        match.Score[0] = home;
        match.Score[1] = away;
        Assert.Equal(expected, MatchSimulator.NeedsShootout(match));
    }

    [Fact]
    public void Knockout_draw_always_has_a_winner()
    {
        var ctx = TestData.Context(seed: 3);
        for (var i = 0; i < 100; i++)
        {
            var m = MatchSimulator.Play(new Match(TestData.Team("A", 50), TestData.Team("B", 50), League, ctx.Random, new KnockoutTie()), ctx);
            Assert.NotNull(m.Winner);
        }
    }

    [Fact]
    public void Energy_recovery_is_capped()
    {
        var club = TestData.Team("Clube", 50);
        var p = club.Squad[0];
        p.Energy = 90;
        p.PlayedThisRound = true;
        PostMatch.RecoverEnergy(p);
        Assert.Equal(100, p.Energy);
    }
}
