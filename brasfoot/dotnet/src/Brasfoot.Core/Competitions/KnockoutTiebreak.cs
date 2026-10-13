using Brasfoot.Core.Matches;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Resolução de um confronto eliminatório. Porta de <c>f.G.b</c> (<c>f/G.java:250-333</c>), na ordem
/// fiel do original:
/// <list type="number">
///   <item>número de jogos vencidos por cada lado (<c>n6 x n7</c>);</item>
///   <item>saldo agregado (<c>n9 x n10</c>);</item>
///   <item>gols fora, quando a regra vale e há dois jogos (<c>aag</c>);</item>
///   <item>regra especial da competição <c>2129</c> (avança o visitante do 1º jogo);</item>
///   <item>pênaltis (<c>gk</c>);</item>
///   <item>quirk de <c>f/G.java:305</c>: a comparação de desempate compara o clube consigo mesmo, então
///         sem pênaltis o visitante do 1º jogo sempre avança.</item>
/// </list>
/// </summary>
public static class KnockoutTiebreak
{
    /// <summary>Competição cujo desempate favorece o visitante do 1º jogo (<c>ze() == 2129</c>).</summary>
    public const int AwayAlwaysAdvancesCompetition = 2129;

    /// <summary>
    /// Decide o confronto. Devolve <c>0</c> se avançar o mandante do 1º jogo (<paramref name="firstLeg"/>)
    /// ou <c>1</c> se avançar o visitante. <paramref name="secondLeg"/> é o jogo de volta (mandante =
    /// visitante da ida), ou <c>null</c> em jogo único.
    /// </summary>
    public static int Resolve(Match firstLeg, Match? secondLeg = null, bool awayGoalsRule = false, int competitionId = -1)
    {
        // 1. Jogos vencidos. No 2º jogo o "time 1" (mandante da ida) é o visitante.
        var legs1 = 0;
        var legs2 = 0;
        CountLeg(firstLeg.Score[0], firstLeg.Score[1], ref legs1, ref legs2);
        if (secondLeg is not null)
            CountLeg(secondLeg.Score[1], secondLeg.Score[0], ref legs1, ref legs2);

        // 2. Agregado.
        var goals1 = firstLeg.Score[0] + (secondLeg?.Score[1] ?? 0);
        var goals2 = firstLeg.Score[1] + (secondLeg?.Score[0] ?? 0);

        if (legs1 > legs2) return 0;
        if (legs2 > legs1) return 1;
        if (goals1 > goals2) return 0;
        if (goals2 > goals1) return 1;

        // 3. Gols fora: o time 1 marcou fora no 2º jogo; o time 2 marcou fora no 1º.
        if (secondLeg is not null && awayGoalsRule)
        {
            var away1 = secondLeg.Score[1];
            var away2 = firstLeg.Score[1];
            if (away1 != away2) return away1 > away2 ? 0 : 1;
        }

        // 4. Regra especial da competição.
        if (competitionId == AwayAlwaysAdvancesCompetition) return 1;

        // 5. Pênaltis.
        var deciding = secondLeg ?? firstLeg;
        if (deciding.ShootoutWinner is { } side)
            return ReferenceEquals(deciding.TeamOf(side), firstLeg.Home) ? 0 : 1;

        // 6. Quirk: sem pênaltis o visitante do 1º jogo avança.
        return 1;
    }

    private static void CountLeg(int team1Goals, int team2Goals, ref int won1, ref int won2)
    {
        if (team1Goals > team2Goals) won1++;
        else if (team2Goals > team1Goals) won2++;
    }
}
