using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;

namespace Brasfoot.Tests;

public class CompetitionPrizesTests
{
    [Theory]
    // f/G.java:111-122 + aq.sw (best/aq.java:589-621): continente 0 (Europa), fases 0..4.
    [InlineData(0, 0, 2_000_000)]
    [InlineData(0, 4, 30_000_000)]
    // continente 1 (América do Sul / Libertadores).
    [InlineData(1, 2, 5_000_000)]
    public void Knockout_round_prize_reads_aq_sw_for_international1(int continent, int round, long expected)
    {
        var prize = CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Internacional1, continent, code: -1, round, lastRoundIndex: 4);
        Assert.Equal(expected, prize);
    }

    [Theory]
    [InlineData(4101, 500_000)]
    [InlineData(4103, 500_000)]
    [InlineData(4000, 1_000_000)]
    [InlineData(4004, 1_000_000)]
    public void Knockout_round_prize_uses_flat_values_for_preliminary_codes(int code, long expected)
    {
        // f/G.java:112-116: faixas de código 4101..4103/4000..4004 ignoram a tabela sw.
        var prize = CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Internacional1, continent: 0, code, roundIndex: 0, lastRoundIndex: 4);
        Assert.Equal(expected, prize);
    }

    [Fact]
    public void Knockout_round_prize_for_the_national_cup_aligns_to_the_final_via_ss()
    {
        // f/G.java:105-110 + aq.ss (best/aq.java:574): a última fase sempre cai no último índice de ss (25M).
        var finalPrize = CompetitionPrizes.KnockoutRoundPrize(CompetitionType.CopaNacional, continent: -1, code: -1, roundIndex: 6, lastRoundIndex: 6);
        Assert.Equal(25_000_000, finalPrize);

        // Um mata-mata de 3 fases (lastRoundIndex=2): fase 0 cai em ss[8-1-2+0] = ss[5] = 15M.
        var firstRoundPrize = CompetitionPrizes.KnockoutRoundPrize(CompetitionType.CopaNacional, continent: -1, code: -1, roundIndex: 0, lastRoundIndex: 2);
        Assert.Equal(15_000_000, firstRoundPrize);
    }

    [Theory]
    [InlineData(0, 2_000_000)]
    [InlineData(1, 5_000_000)]
    [InlineData(2, 7_000_000)]
    public void Knockout_round_prize_for_club_world_cup_reads_aq_sx(int round, long expected) =>
        Assert.Equal(expected, CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Mundial, continent: -1, code: -1, round, lastRoundIndex: 2));

    [Fact]
    public void Knockout_round_prize_for_recopa_and_supercopa_is_flat()
    {
        Assert.Equal(1_000_000, CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Recopa, continent: 0, code: -1, roundIndex: 0, lastRoundIndex: 0));
        Assert.Equal(1_000_000, CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Recopa, continent: 1, code: -1, roundIndex: 3, lastRoundIndex: 3));
        Assert.Equal(1_000_000, CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Supercopa, continent: -1, code: -1, roundIndex: 0, lastRoundIndex: 0));
    }

    [Fact]
    public void Knockout_round_prize_is_zero_for_unmapped_types()
    {
        Assert.Equal(0, CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Nacional, continent: -1, code: -1, roundIndex: 0, lastRoundIndex: 0));
        Assert.Equal(0, CompetitionPrizes.KnockoutRoundPrize(CompetitionType.Eliminatorias, continent: -1, code: -1, roundIndex: 0, lastRoundIndex: 0));
    }

    [Fact]
    public void Knockout_prizes_pay_only_the_winner_of_each_round_and_accumulate_for_the_champion()
    {
        var teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"K{i}", 50)).ToList();
        var competition = new Competition(1, "Mundial de Clubes", CompetitionType.Mundial) { DecisaoTerceiroLugar = true };
        var bracket = new KnockoutBracket(competition, teams, code: -1);
        bracket.PlayAll(TestData.Context(seed: 11));

        var prizes = CompetitionPrizes.KnockoutPrizes(bracket);
        var champion = bracket.Champion!;

        // Mundial de Clubes: sx = {2M (semi), 5M (final)}; o campeão venceu as duas fases.
        Assert.Equal(7_000_000, prizes[champion]);
        // Times eliminados na 1ª fase (perderam a semifinal e a disputa de 3º) não aparecem (prêmio = 0).
        Assert.True(prizes.Values.All(v => v is 2_000_000 or 5_000_000 or 7_000_000));
    }

    [Theory]
    [InlineData(1, 1, 5_000_000)]     // divisão 1, campeão
    [InlineData(1, 6, 500_000)]       // divisão 1, 6º colocado
    [InlineData(2, 1, 2_500_000)]     // divisão 2, campeão
    [InlineData(4, 1, 750_000)]       // divisão 4, campeão
    public void League_final_position_prize_reads_aq_sr_by_division(int division, int position, long expected) =>
        Assert.Equal(expected, CompetitionPrizes.LeagueFinalPositionPrize(CompetitionType.Nacional, division, position));

    [Fact]
    public void League_final_position_prize_is_zero_beyond_the_sixth_position()
    {
        Assert.Equal(0, CompetitionPrizes.LeagueFinalPositionPrize(CompetitionType.Nacional, division: 1, position: 7));
    }

    [Theory]
    [InlineData(1, 700_000)]
    [InlineData(4, 100_000)]
    public void League_final_position_prize_reads_aq_su_for_the_top_state_division(int position, long expected) =>
        Assert.Equal(expected, CompetitionPrizes.LeagueFinalPositionPrize(CompetitionType.Estadual, division: 1, position));

    [Fact]
    public void League_final_position_prize_is_zero_for_lower_state_divisions() =>
        Assert.Equal(0, CompetitionPrizes.LeagueFinalPositionPrize(CompetitionType.Estadual, division: 2, position: 1));
}

public class CompetitionRankingTests
{
    [Theory]
    [InlineData(1, 25)]
    [InlineData(2, 10)]
    [InlineData(10, 1)]
    [InlineData(11, 0)]
    public void Manager_ranking_points_for_the_top_national_division(int position, int expected) =>
        Assert.Equal(expected, CompetitionRanking.ManagerRankingPoints(CompetitionType.Nacional, continent: -1, division: 1, position));

    [Theory]
    [InlineData(2, 1, 5)]   // divisão 2, campeão
    [InlineData(3, 1, 2)]   // divisão 3+, campeão
    public void Manager_ranking_points_are_reduced_for_lower_national_divisions(int division, int position, int expected) =>
        Assert.Equal(expected, CompetitionRanking.ManagerRankingPoints(CompetitionType.Nacional, continent: -1, division, position));

    [Fact]
    public void Manager_ranking_points_are_zero_for_state_divisions_below_the_first()
    {
        Assert.Equal(15, CompetitionRanking.ManagerRankingPoints(CompetitionType.Estadual, continent: -1, division: 1, position: 1));
        Assert.Equal(0, CompetitionRanking.ManagerRankingPoints(CompetitionType.Estadual, continent: -1, division: 2, position: 1));
    }

    [Fact]
    public void Manager_ranking_points_for_national_teams_are_reduced_outside_the_world_cup()
    {
        Assert.Equal(35, CompetitionRanking.ManagerRankingPoints(CompetitionType.Selecoes, continent: 7, division: 0, position: 1));
        Assert.Equal(25, CompetitionRanking.ManagerRankingPoints(CompetitionType.Selecoes, continent: 1, division: 0, position: 1));
    }

    [Theory]
    [InlineData(1, 15)]
    [InlineData(10, 1)]
    public void Club_ranking_points_for_the_top_national_division(int position, int expected) =>
        Assert.Equal(expected, CompetitionRanking.ClubRankingPoints(CompetitionType.Nacional, continent: -1, division: 1, clubContinent: 0, position));

    [Fact]
    public void Club_ranking_points_for_international1_are_reduced_outside_europe_and_south_america()
    {
        // best/ah.java:1021-1030: clube com gg() > 1 (fora Europa/América do Sul) usa a tabela reduzida.
        Assert.Equal(20, CompetitionRanking.ClubRankingPoints(CompetitionType.Internacional1, continent: -1, division: 0, clubContinent: 0, position: 1));
        Assert.Equal(18, CompetitionRanking.ClubRankingPoints(CompetitionType.Internacional1, continent: -1, division: 0, clubContinent: 2, position: 1));
    }

    [Fact]
    public void Ranking_points_lists_apply_to_every_final_position()
    {
        var teams = Enumerable.Range(0, 3).Select(i => TestData.Team($"R{i}", 50)).ToList();
        var positions = teams.Select((t, i) => (Team: t, Position: i + 1)).ToList();

        var club = CompetitionRanking.ClubRankingPoints(CompetitionType.Nacional, continent: -1, division: 1, positions);
        var manager = CompetitionRanking.ManagerRankingPoints(CompetitionType.Nacional, continent: -1, division: 1, positions);

        Assert.Equal(15, club[teams[0]]);
        Assert.Equal(10, club[teams[1]]);
        Assert.Equal(25, manager[teams[0]]);
        Assert.Equal(10, manager[teams[1]]);
    }
}

public class ConfigLigaTypeTests
{
    [Fact]
    public void Access_playoff_pool_size_is_the_relegation_count_of_the_division_above()
    {
        var above = new ConfigLigaType { Division = 1, Relegated = 4 };
        Assert.Equal(4, ConfigLigaType.AccessPlayoffPoolSize(division: 2, above));
        Assert.Equal(0, ConfigLigaType.AccessPlayoffPoolSize(division: 1, divisionAbove: null));
    }

    [Fact]
    public void Has_access_playoff_requires_both_a_pool_and_playoff_slots()
    {
        var above = new ConfigLigaType { Division = 1, Relegated = 4 };
        var config = new ConfigLigaType { Division = 2, PromotionSlotsFromPlayoff = 2 };
        Assert.True(config.HasAccessPlayoff(above));

        var noSlots = new ConfigLigaType { Division = 2, PromotionSlotsFromPlayoff = 0 };
        Assert.False(noSlots.HasAccessPlayoff(above));
    }

    [Fact]
    public void Has_relegation_playoff_requires_some_but_not_all_relegation_to_be_direct()
    {
        var full = new ConfigLigaType { Relegated = 4, DirectlyRelegated = 2 };
        Assert.True(full.HasRelegationPlayoff);
        Assert.Equal(2, full.RelegationPlayoffSlots);

        var allDirect = new ConfigLigaType { Relegated = 2, DirectlyRelegated = 2 };
        Assert.False(allDirect.HasRelegationPlayoff);
        Assert.Equal(0, allDirect.RelegationPlayoffSlots);
    }

    [Fact]
    public void Access_playoff_field_can_be_built_directly_from_config()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"C{i}", 50)).ToList();
        var table = new LeagueTable(teams);
        for (var i = 0; i < teams.Count; i++) table.Get(teams[i]).Won += teams.Count - i;
        var standing = table.Ordered();

        var above = new ConfigLigaType { Division = 1, Relegated = 6 };
        var config = new ConfigLigaType { Division = 2, PromotionSlotsFromPlayoff = 2 };

        var field = PromotionRelegation.AccessPlayoffField(standing, config, above);

        Assert.NotNull(field);
        Assert.Equal(standing.Skip(4).Take(4).Select(s => s.Team), field);
    }

    [Fact]
    public void Swap_adjacent_divisions_can_be_built_directly_from_config()
    {
        var upper = Enumerable.Range(0, 4).Select(i => TestData.Team($"SU{i}", 60)).ToList();
        var lower = Enumerable.Range(0, 4).Select(i => TestData.Team($"SL{i}", 60)).ToList();
        var upperTable = new LeagueTable(upper);
        for (var i = 0; i < upper.Count; i++) upperTable.Get(upper[i]).Won += upper.Count - i;
        var lowerTable = new LeagueTable(lower);
        for (var i = 0; i < lower.Count; i++) lowerTable.Get(lower[i]).Won += lower.Count - i;

        var upperConfig = new ConfigLigaType { Division = 1, Relegated = 2 };

        var swaps = PromotionRelegation.SwapAdjacentDivisions(upper, upperTable.Ordered(), upperConfig, lower, lowerTable.Ordered());

        Assert.Equal(2, swaps.Count);
        foreach (var (relegated, promoted) in swaps)
        {
            Assert.DoesNotContain(relegated, upper);
            Assert.Contains(relegated, lower);
            Assert.Contains(promoted, upper);
            Assert.DoesNotContain(promoted, lower);
        }
    }
}
