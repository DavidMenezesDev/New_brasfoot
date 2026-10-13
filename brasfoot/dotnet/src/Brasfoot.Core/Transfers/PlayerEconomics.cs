using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Transfers;

/// <summary>Força inicial, valor de mercado e salário (<c>F.fI</c>, <c>F.fK</c>, <c>F.fJ</c>).</summary>
public static class PlayerEconomics
{
    private static readonly Dictionary<int, int> LevelBoost = new()
    {
        [16] = 17, [17] = 18, [18] = 19, [19] = 21, [20] = 25, [21] = 26, [22] = 27, [23] = 28, [24] = 29, [25] = 30,
    };

    /// <summary>
    /// <c>F.fI()</c>: sorteia a força do jogador a partir do clube (divisão ou reputação, nível e
    /// nível do país) no início do jogo, define o contrato (210..239 dias) e recalcula valor e salário.
    /// </summary>
    public static void AssignInitialStrength(Player p, GameContext ctx)
    {
        var club = p.Club ?? throw new InvalidOperationException("Jogador sem clube.");
        var random = ctx.Random;
        var level = club.Level;

        int bonus = 1;
        if (club.IsLeagueClub)
        {
            bonus = club.Division switch { 1 => 20, 2 => 15, 3 => 5, _ => 1 };
        }
        else
        {
            bonus = club.Reputation switch { 5 => 22, 4 => 15, 3 or 2 or 1 => 5, _ => 1 };
        }

        var effectiveLevel = level <= 15 ? level : LevelBoost.GetValueOrDefault(level, level);
        var f = effectiveLevel + bonus + random.NextInt(3);
        if (p.IsStarter) f = f + 8 + random.NextInt(2);
        if (p.IsStar || p.IsWorldClass) f = f + 9 + random.NextInt(3);
        if (p.IsJunior)
        {
            f -= 23;
            if (f < 5) f = 10;
        }

        if (Countries.Get(club.CountryId).Level <= 13)
            f = JMath.RoundInt(f * (level <= 5 ? 0.4 : level < 10 ? 0.65 : 0.75));
        else if (level < 3)
            f = JMath.RoundInt(f * 0.5);
        else if (level < 5)
            f = JMath.RoundInt(f * 0.6);
        else if (level < 10)
            f = JMath.RoundInt(f * 0.7);
        p.Strength = Math.Min(f, 100);

        p.ContractEnd = ctx.Today.AddDays(random.NextInt(30) + 210);
        Recalculate(p, ctx);
    }

    public static void Recalculate(Player p, GameContext ctx)
    {
        p.Value = MarketValue(p, ctx);
        p.Salary = Salary(p, ctx);
    }

    /// <summary><c>F.fK()</c>: (2·força)² × base, onde a base depende do nível do clube, craque, idade…</summary>
    public static long MarketValue(Player p, GameContext ctx)
    {
        var level = p.Club?.Level ?? 10;
        var european = Countries.Get(p.Nationality).Continent == Continent.Europa;
        var power = p.Strength * 2;
        power *= power;

        int b = level >= 21 ? 750 : level >= 20 ? 600 : level >= 18 ? 500 : level >= 12 ? 400 : 366;
        if (p.IsStar)
            b = level >= 22 && european ? b * 3 : level >= 21 && european ? b * 2 : JMath.RoundInt(1.7 * b);
        if (p.IsWorldClass) b = JMath.RoundInt(1.6 * b);
        if (p.Position == Position.Atacante) b = JMath.RoundInt(1.3 * b);
        if (p.IsStarter) b = JMath.RoundInt(b + 0.2 * b);

        if (p.Age < 16) p.Age = 16;
        var age = p.Age;
        b += age < 20 ? (32 - age) * 27
            : age <= 25 ? (32 - age) * 22
            : age < 32 ? (32 - age) * 15
            : age < 34 ? (34 - age) * 10
            : -(age - 34) * 50;
        if (b <= 0) b = 60;

        long value = ctx.Options.FixOriginalBugs ? (long)power * b : unchecked(power * b);
        var season = ctx.Season;
        if (p.IsJunior)
        {
            value = JMath.Round(value * 0.03) * p.Potential;
        }
        else if (p.PromotedSeason > 0 && season == p.PromotedSeason)
        {
            value = JMath.Round(value * 0.18);
            if (value > p.AskingPrice && p.AskingPrice > 0) value = p.AskingPrice;
        }
        else if (p.PromotedSeason > 0 && season - 1 == p.PromotedSeason)
        {
            value = JMath.Round(value * 0.35);
        }
        else if (p.PromotedSeason > 0 && season - 2 == p.PromotedSeason)
        {
            value = JMath.Round(value * 0.65);
        }
        if (p.IsJunior && p.Potential == 10) value = JMath.Round(value * 1.5);
        return value;
    }

    /// <summary><c>F.fJ()</c>: força × 2 × base da divisão/posição, ajustes por idade e estrela; mínimo 500.</summary>
    public static long Salary(Player p, GameContext ctx)
    {
        var b = 350;
        if (p.Club is { } club)
        {
            b = club.IsInTopFiveLeague
                ? club.Division switch { 1 => 750, 2 => 550, 3 => 500, 4 or 5 => 450, _ => 350 }
                : club.Division switch { 1 => 600, 2 => 500, 3 => 450, 4 or 5 => 400, _ => 350 };
            if (club.Level > 20) b += 50;
        }
        b -= p.Position switch { Position.Goleiro => 70, Position.Lateral => 30, Position.Zagueiro => 40, Position.Atacante => 50, _ => 0 };
        b = JMath.RoundInt(0.5 * b);

        var s = p.Strength * 2 * b;
        var starBonus = p.IsStar || p.IsWorldClass ? p.Strength * 250 : 0;
        var salary = p.Age < 32 ? s + starBonus : s - (p.Age - 32) * 300 + starBonus;
        if (salary < 500) salary = 500;
        if (p.IsWorldClass) salary = JMath.RoundInt(salary * 1.4);
        if (p.IsJunior) salary = JMath.RoundInt(salary * 0.1);
        return ctx.Options.MonthlySalary ? salary * 4L : salary;
    }
}
