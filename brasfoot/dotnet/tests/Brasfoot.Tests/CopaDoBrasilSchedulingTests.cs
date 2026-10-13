using Brasfoot.Core.Calendar;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Tests;

/// <summary>
/// Driver dedicado da Copa do Brasil (Fase 4, <see cref="CopaDoBrasilCompetition"/>): agendamento nos
/// dias livres de Copa Nacional, reordenação por força entre as fases, notificação <c>Bh</c> e
/// integração ao laço de dias via <see cref="GameSession"/>.
/// </summary>
public class CopaDoBrasilSchedulingTests
{
    private static (GameSession Session, GameState State, List<Team> Pool) NewSession(
        int teamCount, int year = 2022)
    {
        var world = new World();
        var pool = new List<Team>();
        for (var i = 0; i < teamCount; i++)
        {
            // Reputação variada para o comparador de força (h.a.abm) ter o que ordenar.
            var team = TestData.Team($"Clube {i:D2}", 50 + (i % 30), reputation: i % 6);
            world.Teams.Add(team);
            pool.Add(team);
        }
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = year;
        var session = new GameSession(state, TestData.Context());
        session.BuildSeasonCalendar();
        return (session, state, pool);
    }

    private static void PlayUntil(GameSession session, Func<bool> done, int maxDays = 400)
    {
        var days = 0;
        while (!done() && !session.SeasonEnded && days++ < maxDays)
            session.AdvanceToNextMatchDay();
    }

    [Fact]
    public void RequiredDaySlots_is_one_per_single_leg_plus_two_per_two_legged()
    {
        // 2 fases de jogo único + 5 fases de ida e volta = 2 + 10 = 12.
        Assert.Equal(12, CopaDoBrasilCompetition.RequiredDaySlots());
        Assert.Equal([false, false, true, true, true, true, true],
            CopaDoBrasil.TwoLeggedByStage);
        for (var s = 0; s < CopaDoBrasil.TwoLeggedByStage.Length; s++)
            Assert.Equal(CopaDoBrasil.TwoLeggedByStage[s], CopaDoBrasilCompetition.TwoLeggedAt(s));
    }

    [Fact]
    public void BuildHeadsMessage_joins_the_twelve_heads_like_the_original()
    {
        var (_, _, pool) = NewSession(12);
        var text = CopaDoBrasilCompetition.BuildHeadsMessage(pool);
        Assert.Equal(
            "Clube 00, Clube 01, Clube 02, Clube 03, Clube 04, Clube 05, Clube 06, Clube 07, " +
            "Clube 08, Clube 09, Clube 10 e Clube 11.",
            text);
        // Sem exatamente 12 cabeças não há mensagem.
        Assert.Equal("", CopaDoBrasilCompetition.BuildHeadsMessage(pool.Take(11).ToList()));
    }

    [Fact]
    public void Create_returns_null_when_the_pool_cannot_host_the_pot_format()
    {
        var (session, _, pool) = NewSession(11);
        var cup = SeasonBuilder.CreateCopaDoBrasil(session, pool);
        Assert.Null(cup);
        Assert.Empty(session.BrasilCup);
    }

    [Fact]
    public void Driver_plays_the_whole_cup_through_the_day_loop_and_crowns_a_champion()
    {
        var (session, state, pool) = NewSession(96);

        var cup = SeasonBuilder.CreateCopaDoBrasil(session, pool);
        Assert.NotNull(cup);
        Assert.Single(session.BrasilCup);
        Assert.Equal(12, cup!.Heads.Count);

        PlayUntil(session, () => cup.IsComplete);

        Assert.True(cup.IsComplete);
        Assert.NotNull(cup.Champion);
        Assert.Contains(cup.Champion, pool);

        // Uma data por perna, todas do tipo Copa Nacional e distintas.
        Assert.Equal(12, cup.DayIndexes.Count);
        Assert.Equal(cup.DayIndexes.Count, cup.DayIndexes.Distinct().Count());
        Assert.All(cup.DayIndexes, i => Assert.Equal(DayType.CopaNacional, state.Calendar.Days[i].Type));
    }

    [Fact]
    public void Stage_sizes_follow_80_40_32_16_8_4_2_and_the_heads_enter_at_the_round_of_32()
    {
        var (session, _, pool) = NewSession(96);
        var cup = SeasonBuilder.CreateCopaDoBrasil(session, pool)!;
        var heads = cup.Heads.ToHashSet();

        // Tamanho de cada fase observado pelo número de confrontos (equipe/2).
        var byStage = new Dictionary<int, int>();
        var stage2Teams = new HashSet<Team>();
        byStage[cup.Stage] = cup.Pairings.Count * 2;
        var days = 0;
        while (!cup.IsComplete && !session.SeasonEnded && days++ < 400)
        {
            session.AdvanceToNextMatchDay();
            var teams = cup.Pairings.Count * 2;
            byStage[cup.Stage] = teams;
            if (cup.Stage == 2)
                foreach (var pairing in cup.Pairings) { stage2Teams.Add(pairing.Home); stage2Teams.Add(pairing.Away); }
        }

        Assert.Equal(80, byStage[0]);
        Assert.Equal(40, byStage[1]);
        Assert.Equal(32, byStage[2]);
        Assert.Equal(16, byStage[3]);
        Assert.Equal(8, byStage[4]);
        Assert.Equal(4, byStage[5]);
        Assert.Equal(2, byStage[6]);

        // As 12 cabeças entram já na 3ª fase (round of 32).
        Assert.Equal(32, stage2Teams.Count);
        Assert.All(heads, h => Assert.Contains(h, stage2Teams));
    }

    [Fact]
    public void NotifyHeads_posts_a_message_to_brazilian_managers_only()
    {
        var (session, state, pool) = NewSession(96);
        var cup = SeasonBuilder.CreateCopaDoBrasil(session, pool)!;

        var brazilian = state.AddManager("Técnico BR", pool[0]);
        var foreignClub = TestData.Team("Rival", 60, country: 65);
        var foreign = state.AddManager("Técnico de Fora", foreignClub);

        cup.NotifyHeads(state);

        var message = Assert.Single(brazilian.Messages);
        Assert.Equal(23, message.Type);
        Assert.Equal(75, message.Tone);
        Assert.Contains(pool[0].Name, message.Text);
        Assert.Empty(foreign.Messages);
        Assert.Equal(12, cup.Heads.Count);
    }

    [Fact]
    public void CreateCopaDoBrasil_notifies_existing_brazilian_managers_at_setup()
    {
        var (session, state, pool) = NewSession(96);
        var manager = state.AddManager("Técnico BR", pool[0]);

        var cup = SeasonBuilder.CreateCopaDoBrasil(session, pool);

        Assert.NotNull(cup);
        var message = Assert.Single(manager.Messages);
        Assert.Equal(23, message.Type);
        Assert.Contains(pool[1].Name, message.Text);
    }
}
