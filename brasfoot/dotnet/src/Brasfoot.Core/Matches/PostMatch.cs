using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

/// <summary>Efeitos depois da partida (<c>f.as()</c>: <c>hi</c>, <c>hh</c>, <c>F.fr</c>) e lesões (<c>F.p</c>).</summary>
public static class PostMatch
{
    private static readonly int[] DefaultSlotByPosition = [1, 2, 7, 15, 23];

    /// <summary>Aplica suspensões cumpridas, cartões, gols, jogos e notas de uma partida encerrada.</summary>
    public static void Apply(Match match, GameContext ctx)
    {
        ServeSuspensions(match);
        RecordStats(match, ctx);
    }

    /// <summary><c>I.hi()</c>: zera amarelos da partida e desconta um jogo de quem estava suspenso.</summary>
    private static void ServeSuspensions(Match match)
    {
        foreach (var p in match.Home.Squad.Concat(match.Away.Squad))
        {
            p.YellowsInMatch = 0;
            if (!p.CompetitionStats.TryGetValue(match.Competition.Id, out var rec) || !rec.IsSuspended) continue;
            if (rec.Yellows >= 3) rec.Yellows = 0;
            else rec.BanMatches--;
        }
    }

    /// <summary><c>I.hh()</c>: jogos, notas, gols e cartões.</summary>
    private static void RecordStats(Match match, GameContext ctx)
    {
        for (var side = 0; side < 2; side++)
        {
            foreach (var p in match.Lineup[side].Concat(match.SubbedOn[side]))
            {
                p.StatsFor(match.Competition).Games++;
                Rate(p, match, side, ctx);
            }
        }

        foreach (var ev in match.Events)
        {
            if (ev.Player == null) continue;
            if (ev.Type == MatchEventType.Gol && ev.GoalType != GoalType.Contra)
                ev.Player.StatsFor(match.Competition).Goals++;
            else if (ev.Type is MatchEventType.Amarelo or MatchEventType.AmareloVermelho or MatchEventType.Vermelho)
                ApplyCard(ev.Player, ev.Type, match.Competition, ctx);
        }
    }

    /// <summary><c>F.a(type, comp, team)</c>: 3 amarelos ou vermelho geram suspensão (amistosos e juniores não contam).</summary>
    private static void ApplyCard(Player p, MatchEventType type, Competition competition, GameContext ctx)
    {
        if (competition.IsFriendly || p.IsJunior) return;
        var rec = p.StatsFor(competition);
        switch (type)
        {
            case MatchEventType.Amarelo:
                rec.Yellows++;
                break;
            case MatchEventType.AmareloVermelho:
                rec.Yellows++;
                rec.BanMatches++;
                break;
            case MatchEventType.Vermelho:
                var r = ctx.Random.NextInt(1000);
                rec.BanMatches += r < 700 ? 1 : r < 900 ? 2 : r < 970 ? 3 : r <= 990 ? 5 : 10;
                break;
        }
    }

    /// <summary>Nota do jogador na partida (<c>F.a(at, I, side, opp, team)</c>).</summary>
    public static double Rate(Player p, Match match, int side, GameContext ctx)
    {
        var random = ctx.Random;
        var fix = ctx.Options.FixOriginalBugs;
        var other = 1 - side;

        var minutes = 90;
        foreach (var ev in match.Events)
        {
            // Quirk Q3: qualquer evento (gol, cartão…) define os minutos, não só substituições.
            if (fix && ev.Type != MatchEventType.Substituicao && ev.Type != MatchEventType.AmareloVermelho
                && ev.Type != MatchEventType.Vermelho) continue;
            if (ev.Player == p) minutes = ev.Half == 1 ? ev.Minute : 48 + ev.Minute;
            if (ev.Player2 == p) minutes = ev.Half == 1 ? 48 + (50 - ev.Minute) : 50 - ev.Minute;
        }

        var goalsFor = match.Score[side];
        var goalsAgainst = match.Score[other];
        var result = goalsFor > goalsAgainst ? 1 : goalsFor < goalsAgainst ? 2 : 0;

        var slot = p.Slot;
        if (slot < 1) p.Slot = slot = DefaultSlotByPosition[(int)p.Position];

        var s = p.Strength;
        var rating = result switch
        {
            0 => s <= 30 ? 5.5 : s <= 60 ? 5.8 : s <= 90 ? 6.2 : 6.8,
            1 => s <= 30 ? 6.0 : s <= 60 ? 6.0 : s <= 90 ? 6.7 : 7.2,
            _ => s <= 30 ? 5.0 : s <= 60 ? 5.2 : s <= 90 ? 5.5 : 6.0,
        };
        if (Pitch.IsOutOfPosition(p))
        {
            rating -= 1.5;
            if (p.Slot == Pitch.Goalkeeper) rating -= 1.5;
        }

        if (slot is >= 10 and <= 17)
        {
            if (match.Possession[side] > match.Possession[other])
            {
                rating += random.NextInt(3) == 1 ? 0.3 : 0.8;
                if (p.Role == PlayerRole.Defensivo) rating += 0.3;
                if (p.Cr1Is(Characteristic.Passe) || p.Cr1Is(Characteristic.Armacao)) rating += 0.5;
            }
            else if (match.Possession[side] < match.Possession[other])
            {
                rating -= random.NextInt(3) == 1 ? 0.3 : 0.8;
                if (p.Role == PlayerRole.Defensivo) rating -= 0.5;
            }
        }

        var sheet = p.Sheet;
        rating += sheet.Goals * 0.9;
        rating -= sheet.OwnGoals * 1.5;
        if (sheet.PenaltiesMissed > 0) rating -= (fix ? sheet.PenaltiesMissed : sheet.OwnGoals) * 1.2; // quirk Q7
        rating -= sheet.Yellows * 0.2;
        rating -= sheet.Reds * 0.8;
        rating += sheet.Assists * 0.4;

        if (slot is >= 1 and <= 13)
        {
            if (match.Tackles[side] > match.Tackles[other])
            {
                rating += random.NextInt(3) == 1 ? 0.9 : 0.6;
                if (slot is >= 2 and <= 9 && random.NextInt(3) == 1) rating += 0.6;
                if (slot is >= 11 and <= 13 && random.NextInt(3) == 1) rating += 0.6;
            }
            else if (match.Tackles[side] < match.Tackles[other])
            {
                rating -= 0.5;
                if (slot is >= 3 and <= 8 && random.NextInt(4) == 1) rating -= 0.6;
                if (slot is >= 11 and <= 13 && random.NextInt(4) == 1) rating -= 0.6;
            }
        }
        rating += sheet.ShotsSaved * 0.3;

        if (slot == Pitch.Goalkeeper)
        {
            rating -= 0.8;
            var oppOnTarget = match.ShotsOnTarget[other];
            rating += oppOnTarget * 0.2;
            rating += sheet.PenaltySaves * 1.2;
            if (match.Shots[other] > 10) rating += 0.2;
            rating += goalsAgainst switch { >= 5 => -2.0, >= 4 => -1.5, >= 2 => -1.0, >= 1 => -0.5, _ => 1.0 };
            if (oppOnTarget == 0) rating -= 1.5;
        }

        if (slot is >= 1 and <= 13)
        {
            if (goalsAgainst == 0)
            {
                rating += 0.5;
                if (slot is >= 2 and <= 9) rating += 0.5;
                if (slot is >= 11 and <= 13 && random.NextInt(3) == 1) rating += 0.5;
            }
            else if (goalsAgainst > 1)
            {
                rating -= 0.1 * goalsAgainst;
            }
            if (slot is >= 2 and <= 13 && random.NextInt(3) == 1) rating -= 0.4;
        }

        if (p.IsStar) rating += 0.4;
        if (p.IsWorldClass) rating += 0.6;
        if (rating > 10.0) rating = 10.0;
        if (rating < 0.0) rating = 1.0;
        if (minutes < 15) rating -= 2.5;
        else if (minutes < 45) rating -= 1.5;
        if (rating < 2.0) rating = 2.0;
        if (minutes < 20 && rating <= 2.0) rating = 0.0;

        p.LastRating = rating;
        if (rating > 0.0 && match.Competition.Type != CompetitionType.Amistoso)
        {
            var rec = p.StatsFor(match.Competition);
            rec.RatingSum += rating;
            rec.RatedGames++;
        }
        return rating;
    }

    /// <summary>
    /// Lesão (<c>F.p(ah)</c>): dias por idade, energia e azar; jogadores de 35+ perdem 5 de força.
    /// </summary>
    public static int Injure(Player p, GameContext ctx)
    {
        var random = ctx.Random;
        var a = random.NextInt(14);
        var b = 5 + random.NextInt(20);
        var e = p.Energy < 10 ? 5 : p.Energy < 50 ? 1 : 0;
        var days = p.Age <= 20 ? a
            : p.Age <= 25 ? e + a + 1
            : p.Age <= 30 ? e + a + 2
            : p.Age <= 35 ? e + a + 3
            : p.Age <= 45 ? e + a + b
            : e + a + 10 + b;
        if (p.Age >= 35)
        {
            p.Strength -= 5;
            if (p.Strength < 0) p.Strength = 1;
        }
        var r = random.NextInt(100);
        if (r == 1) days += 70;
        else if (r < 4) days += 40;
        else if (r < 10) days += 20;
        if (days > 0) p.InjuredUntil = ctx.Today.AddDays(days);
        return days;
    }

    /// <summary><c>F.fr()</c>: recuperação de energia por rodada, para todos os jogadores.</summary>
    public static void RecoverEnergy(Player p)
    {
        int gain;
        var age = p.Age;
        if (p.PlayedThisRound)
        {
            gain = p.Club is { IsHuman: true }
                ? age <= 20 ? 13 : age <= 25 ? 24 : age <= 31 ? 37 : age <= 36 ? 40 : 30
                : age <= 20 ? 20 : age <= 25 ? 30 : age <= 31 ? 50 : age <= 36 ? 52 : 42;
        }
        else
        {
            gain = age < 20 ? 30 : age < 26 ? 30 : age < 33 ? 35 : age < 45 ? 35 : 30;
        }
        p.Energy = Math.Min(100, p.Energy + gain);
    }
}
