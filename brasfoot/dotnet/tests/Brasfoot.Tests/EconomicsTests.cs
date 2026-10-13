using Brasfoot.Core.Domain;
using Brasfoot.Core.Transfers;

namespace Brasfoot.Tests;

public class EconomicsTests
{
    [Fact]
    public void Value_matches_original_formula()
    {
        var ctx = TestData.Context();
        var club = TestData.Team("Clube", 50);
        club.Level = 20;
        var p = TestData.Player(club, Position.Atacante, 50, age: 24);
        // base 600 (nível 20) → atacante round(1.3*600)=780 → idade 24: (32-24)*22=176 → 956
        // (2*50)² = 10000 → valor 9.560.000
        Assert.Equal(9_560_000, PlayerEconomics.MarketValue(p, ctx));
    }

    [Fact]
    public void Value_of_recently_promoted_junior_is_discounted()
    {
        var ctx = TestData.Context();
        ctx.Season = 3;
        var club = TestData.Team("Clube", 50);
        var p = TestData.Player(club, Position.Meia, 40, age: 20);
        var full = PlayerEconomics.MarketValue(p, ctx);
        p.PromotedSeason = 2; // segunda temporada após subir: 35%
        Assert.Equal((long)Math.Floor(full * 0.35 + 0.5), PlayerEconomics.MarketValue(p, ctx));
    }

    [Fact]
    public void Salary_matches_original_formula()
    {
        var ctx = TestData.Context();
        var club = TestData.Team("Clube", 50);
        club.Level = 18;
        var p = TestData.Player(club, Position.Zagueiro, 60, age: 34);
        // divisão 1 fora do top 5: 600; zagueiro -40 → 560 → *0.5 = 280
        // 60*2*280 = 33600; idade 34: -(2*300) = 33000
        Assert.Equal(33_000, PlayerEconomics.Salary(p, ctx));
    }

    [Fact]
    public void Salary_has_floor_of_500()
    {
        var ctx = TestData.Context();
        var club = TestData.Team("Clube", 1);
        var p = TestData.Player(club, Position.Goleiro, 1, age: 40);
        Assert.Equal(500, PlayerEconomics.Salary(p, ctx));
    }

    [Fact]
    public void Initial_strength_grows_with_division_and_status()
    {
        var ctx = TestData.Context();
        var top = TestData.Team("Top", 0, division: 1);
        var low = TestData.Team("Baixo", 0, division: 3);
        top.Level = low.Level = 15;
        var a = TestData.Player(top, Position.Meia, 0);
        a.IsStarter = true;
        var b = TestData.Player(low, Position.Meia, 0);
        PlayerEconomics.AssignInitialStrength(a, ctx);
        PlayerEconomics.AssignInitialStrength(b, ctx);
        Assert.InRange(a.Strength, 15 + 20 + 8, 15 + 20 + 2 + 8 + 1); // nível + divisão + rand(3) + titular
        Assert.InRange(b.Strength, 15 + 5, 15 + 5 + 2);
        Assert.True(a.Value > 0 && a.Salary > 0);
    }
}
