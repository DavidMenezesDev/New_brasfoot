using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

public static class MatchSimulator
{
    /// <summary>
    /// Joga a partida inteira. Sem time humano usa a simulação rápida (<c>I.V()</c>, 45–47 + 46–50
    /// ticks, pênaltis da IA sempre convertidos); com humano usa o ritmo da tela ao vivo
    /// (<c>a/dV</c>, 48 + 51 ticks, pênaltis cobrados). Escalações vazias são preenchidas pela IA.
    /// </summary>
    public static Match Play(Match match, GameContext ctx)
    {
        for (var side = 0; side < 2; side++)
        {
            if (match.OnPitch[side].Count > 0) continue;
            var team = match.TeamOf(side);
            if (!(team.IsHuman && HumanLineup.Apply(team, match, side, ctx)))
                LineupSelector.Select(team, match, side, ctx);
        }

        var engine = new MatchEngine(match, ctx);
        if (!match.InvolvesHuman)
        {
            match.Stoppage[0] = ctx.Random.NextInt(3);
            match.Stoppage[1] = ctx.Random.NextInt(5) + 1;
            for (var minute = 0; minute <= 44 + match.Stoppage[0]; minute++) engine.Tick(1, minute);
            engine.AiSubstitutions(2, 0);
            for (var minute = 0; minute <= 44 + match.Stoppage[1]; minute++) engine.Tick(2, minute);
        }
        else
        {
            for (var minute = 1; minute <= 48; minute++) engine.Tick(1, minute);
            engine.AiSubstitutions(2, 0);
            for (var minute = 0; minute <= 50; minute++) engine.Tick(2, minute);
        }

        if (match.Tie is { ShootoutAllowed: true } && NeedsShootout(match))
        {
            if (match.InvolvesHuman) LiveShootout(match, ctx);
            else QuickShootout(match, ctx);
        }
        match.IsFinished = true;
        return match;
    }

    /// <summary>Joga uma rodada: partidas, efeitos pós-jogo e recuperação de energia de todos os elencos.</summary>
    public static void PlayRound(IReadOnlyList<Match> matches, IEnumerable<Team> allTeams, GameContext ctx)
    {
        foreach (var match in matches) Play(match, ctx);
        foreach (var match in matches) PostMatch.Apply(match, ctx);
        foreach (var p in allTeams.SelectMany(t => t.Squad))
        {
            PostMatch.RecoverEnergy(p);
            p.PlayedThisRound = false;
        }
    }

    /// <summary><c>I.hk()</c>: empate no agregado (e no gol fora, se valer) leva aos pênaltis.</summary>
    public static bool NeedsShootout(Match match)
    {
        var tie = match.Tie!;
        var home = match.Score[0];
        var away = match.Score[1];
        if (tie.FirstLeg is not { } leg1) return home == away;

        var aggHome = home + leg1.Home;
        var aggAway = away + leg1.Away;
        if (aggHome != aggAway) return false;
        // Gols fora: o mandante de hoje marcou fora no jogo de ida; o visitante marca fora hoje.
        if (tie.AwayGoalsRule && leg1.Home != away) return false;
        return true;
    }

    /// <summary>Pênaltis IA x IA (<c>I.V()</c>): sorteio 2..8 x 2..8 sem olhar os times; empate favorece o mandante.</summary>
    private static void QuickShootout(Match match, GameContext ctx)
    {
        var h = ctx.Random.NextInt(7) + 2;
        var a = ctx.Random.NextInt(7) + 2;
        if (h >= a)
        {
            match.ShootoutScore = (h, h - 1);
            match.ShootoutWinner = 0;
        }
        else
        {
            match.ShootoutScore = (h, h + 1);
            match.ShootoutWinner = 1;
        }
    }

    /// <summary>Pênaltis ao vivo (<c>a/bg</c>): 70% por cobrança, mandante começa, melhor de 5 e morte súbita.</summary>
    private static void LiveShootout(Match match, GameContext ctx)
    {
        var takers = new[] { Order(match.OnPitch[0]), Order(match.OnPitch[1]) };
        var goals = new int[2];
        var kicks = new int[2];
        int? winner = null;
        while (winner == null)
        {
            for (var side = 0; side < 2 && winner == null; side++)
            {
                if (ctx.Random.NextInt(100) + 1 <= 70) goals[side]++;
                kicks[side]++;
                winner = Decided(goals, kicks);
            }
        }
        match.ShootoutScore = (goals[0], goals[1]);
        match.ShootoutWinner = winner;

        static List<Player> Order(List<Player> onPitch) => onPitch.OrderByDescending(p => p.Strength).ToList();
    }

    private static int? Decided(int[] goals, int[] kicks)
    {
        if (kicks[0] <= 5 && kicks[1] <= 5)
        {
            var left0 = 5 - kicks[0];
            var left1 = 5 - kicks[1];
            if (goals[0] > goals[1] + left1) return 0;
            if (goals[1] > goals[0] + left0) return 1;
            if (kicks[0] < 5 || kicks[1] < 5) return null;
        }
        if (kicks[0] != kicks[1]) return null;
        return goals[0] > goals[1] ? 0 : goals[1] > goals[0] ? 1 : null;
    }
}
