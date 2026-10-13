using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Tests;

/// <summary>
/// Agendamento de copas/Supercopa nos dias livres da temporada (Fase 4,
/// <see cref="CupCompetition"/>/<see cref="Supercup"/>), via <see cref="GameSession"/> em vez do uso
/// isolado do CLI (`copa`/`copadobrasil`).
/// </summary>
public class CupSchedulingTests
{
    private static (GameSession Session, GameState State) NewSession(int teamCount, int year = 2022)
    {
        var world = new World();
        for (var i = 0; i < teamCount; i++)
            world.Teams.Add(TestData.Team($"Clube {i}", 50 + i));
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = year;
        var session = new GameSession(state, TestData.Context());
        session.BuildSeasonCalendar();
        return (session, state);
    }

    private static void PlayUntil(GameSession session, Func<bool> done, int maxDays = 400)
    {
        var days = 0;
        while (!done() && !session.SeasonEnded && days++ < maxDays)
            session.AdvanceToNextMatchDay();
    }

    [Fact]
    public void RequiredDaySlots_counts_one_day_per_leg()
    {
        // 8 times, jogo único: 3 fases (f/z: 8->3 rodadas), uma perna cada.
        Assert.Equal(3, CupCompetition.RequiredDaySlots(8, twoLeggedByRound: null, twoLegged: false));
        // Ida e volta em todas as fases: duas pernas cada.
        Assert.Equal(6, CupCompetition.RequiredDaySlots(8, twoLeggedByRound: null, twoLegged: true));
        // Só a 1ª fase de ida e volta.
        Assert.Equal(4, CupCompetition.RequiredDaySlots(8, twoLeggedByRound: [true, false, false]));
    }

    [Fact]
    public void National_cup_schedules_onto_free_CopaNacional_days_and_crowns_a_champion()
    {
        var (session, state) = NewSession(8);
        var pool = state.World.Teams.ToList();

        var cup = SeasonBuilder.CreateNationalCup(session, pool);
        Assert.NotNull(cup);
        Assert.Single(session.Cups);

        PlayUntil(session, () => cup!.IsComplete);

        Assert.True(cup!.IsComplete);
        Assert.NotNull(cup.Champion);
        Assert.Contains(cup.Champion, pool);

        // Uma data por fase (3 fases para 8 times, jogo único), todas do tipo Copa Nacional, distintas.
        Assert.Equal(3, cup.DayIndexes.Count);
        Assert.Equal(cup.DayIndexes.Count, cup.DayIndexes.Distinct().Count());
        Assert.All(cup.DayIndexes, i => Assert.Equal(DayType.CopaNacional, state.Calendar.Days[i].Type));

        // As datas de copa agendadas ficam entre os dias livres do tipo no calendário original (14 em 2022).
        Assert.True(cup.DayIndexes.Max() < state.Calendar.Days.Count);
    }

    [Fact]
    public void Two_legged_national_cup_uses_two_days_per_round()
    {
        var (session, state) = NewSession(8);
        var pool = state.World.Teams.ToList();

        var cup = SeasonBuilder.CreateNationalCup(session, pool, twoLegged: true);
        Assert.NotNull(cup);

        PlayUntil(session, () => cup!.IsComplete);

        Assert.True(cup!.IsComplete);
        Assert.Equal(6, cup.DayIndexes.Count); // 3 fases x 2 pernas
    }

    [Fact]
    public void Supercup_SelectOpponent_falls_back_to_runner_up_when_champions_coincide()
    {
        var (_, state) = NewSession(4);
        var teams = state.World.Teams.ToList();
        var leagueChampion = teams[0];
        var cupChampion = teams[1];
        var cupRunnerUp = teams[2];

        Assert.Same(cupChampion, Supercup.SelectOpponent(leagueChampion, cupChampion, cupRunnerUp));
        Assert.Same(cupRunnerUp, Supercup.SelectOpponent(leagueChampion, leagueChampion, cupRunnerUp));
        Assert.Null(Supercup.SelectOpponent(leagueChampion, null, cupRunnerUp));
    }

    [Fact]
    public void Supercup_schedules_a_single_match_on_the_one_free_SuperCopa_day()
    {
        var (session, state) = NewSession(4);
        var teams = state.World.Teams.ToList();

        var supercup = SeasonBuilder.CreateSupercup(session, teams[0], teams[1], teams[2]);
        Assert.NotNull(supercup);
        Assert.Equal(1, state.Calendar.Days.Count(d => d.Type == DayType.SuperCopa));

        PlayUntil(session, () => supercup!.IsComplete);

        Assert.True(supercup!.IsComplete);
        Assert.Single(supercup.DayIndexes);
        Assert.Equal(DayType.SuperCopa, state.Calendar.Days[supercup.DayIndexes[0]].Type);
        Assert.True(ReferenceEquals(supercup.Champion, teams[0]) || ReferenceEquals(supercup.Champion, teams[1]));
    }

    [Fact]
    public void Supercup_is_not_created_without_a_valid_opponent()
    {
        var (session, state) = NewSession(4);
        var teams = state.World.Teams.ToList();

        var supercup = SeasonBuilder.CreateSupercup(session, teams[0], cupChampion: null, cupRunnerUp: null);
        Assert.Null(supercup);
        Assert.Empty(session.Cups);
    }
}
