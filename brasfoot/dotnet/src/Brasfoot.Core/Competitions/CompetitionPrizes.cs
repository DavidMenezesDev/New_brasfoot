using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Prêmios em dinheiro por posição final/fase alcançada (<c>f/G.c(int,int,boolean)</c>,
/// <c>f/G.java:103-161</c>, para o mata-mata; <c>ah.c(at,int)</c>, <c>best/ah.java:808-823</c>, para a
/// posição final de ligas/estaduais). Pura: não movimenta dinheiro nem mensagens — apenas calcula os
/// valores que o <c>Ledger</c> (fase 5) vai aplicar.
/// </summary>
/// <remarks>
/// <para>
/// O terceiro parâmetro de <c>f.G.c(int,int,boolean)</c> (<c>bl2</c>) não é lido em nenhum ramo do
/// método — chamado com <c>true</c> na criação da fase e com <c>false</c> ao pagar o vencedor
/// (<c>f/G.java:53,439</c>); por isso não existe no port. O dinheiro só é pago ao <em>vencedor</em> de
/// cada confronto (<c>f/G.java:316,329</c>: <c>this.V(vencedor)</c>), nunca ao perdedor.
/// </para>
/// </remarks>
public static class CompetitionPrizes
{
    // aq.ss, best/aq.java:574 — Copa Nacional, por fase alinhada à final (ver KnockoutRoundPrize).
    private static readonly long[] Ss = [1_000_000, 2_000_000, 4_000_000, 5_000_000, 7_000_000, 15_000_000, 20_000_000, 25_000_000];

    // aq.sr, best/aq.java:573 — Liga Nacional, por divisão (0 = sem liga, sempre zero) e posição final (1ª..6ª).
    private static readonly long[][] Sr =
    [
        [0, 0, 0, 0, 0, 0],
        [5_000_000, 3_500_000, 2_000_000, 1_500_000, 1_000_000, 500_000],
        [2_500_000, 2_000_000, 1_000_000, 500_000, 250_000, 100_000],
        [1_500_000, 1_000_000, 500_000, 300_000, 150_000, 75_000],
        [750_000, 500_000, 300_000, 200_000, 100_000, 50_000],
    ];

    // aq.su, best/aq.java:576 — Estadual, 1ª divisão apenas, posições 1ª..4ª.
    private static readonly long[] Su = [700_000, 500_000, 300_000, 100_000];

    // aq.sw, best/aq.java:577-621 — Internacional 1 (Libertadores/Champions/…), por continente (0..5) e fase (0..4).
    private static readonly long[][] Sw =
    [
        [2_000_000, 5_000_000, 7_000_000, 25_000_000, 30_000_000, 0],
        [2_000_000, 3_500_000, 5_000_000, 20_000_000, 40_000_000, 0],
        [500_000, 1_500_000, 2_000_000, 4_000_000, 40_000_000, 0],
        [500_000, 1_500_000, 2_000_000, 4_000_000, 40_000_000, 0],
        [500_000, 1_500_000, 2_000_000, 4_000_000, 40_000_000, 0],
        [200_000, 500_000, 1_000_000, 2_000_000, 20_000_000, 0],
    ];

    // aq.sx, best/aq.java:622 — Mundial de Clubes, por fase (0..2).
    private static readonly long[] Sx = [2_000_000, 5_000_000, 7_000_000];

    // aq.sy, best/aq.java:623-638 — Internacional 2 (Europa League/Sul-Americana), continente 0/1, fase 0..4.
    private static readonly long[][] Sy =
    [
        [500_000, 700_000, 2_000_000, 2_500_000, 7_000_000, 0],
        [500_000, 1_000_000, 1_500_000, 5_000_000, 5_000_000, 0],
    ];

    // aq.sz[0], best/aq.java:639 — Recopa, valor fixo por fase (sz[1] não é lido por f.G.c).
    private const long Sz0 = 1_000_000;

    // aq.sv, best/aq.java:576 — Regionais, por fase (0..2).
    private static readonly long[] Sv = [100_000, 100_000, 400_000];

    // aq.sA[0], best/aq.java:640 — Supercopa, valor fixo (sA[1] não é lido por f.G.c).
    private const long SA0 = 1_000_000;

    // aq.aeG, best/aq.java:641-656 — Conference League, mesma forma de sy (continente 0/1, fase 0..4).
    private static readonly long[][] AeG =
    [
        [500_000, 700_000, 2_000_000, 2_500_000, 7_000_000, 0],
        [500_000, 1_000_000, 1_500_000, 5_000_000, 5_000_000, 0],
    ];

    /// <summary>
    /// Prêmio pago ao vencedor de um confronto do mata-mata, por tipo de competição e fase
    /// (<c>f/G.c(int,int,boolean)</c>, <c>f/G.java:103-161</c>). <paramref name="continent"/> é
    /// <c>Competition.Continent</c> (<c>at.gg()</c>); <paramref name="code"/> é o código da chave
    /// (<c>f.z.Zg</c>) — só importa para os tipos 4/6/12, que têm faixas de código com valor fixo;
    /// <paramref name="roundIndex"/> é a fase 0-based (<c>f.G.oj</c>) e <paramref name="lastRoundIndex"/>
    /// o índice da última fase do mata-mata (<c>f.z.ZG</c>/<c>zq()</c>), usado só pela Copa Nacional
    /// para alinhar a tabela <c>ss</c> à final.
    /// </summary>
    public static long KnockoutRoundPrize(CompetitionType type, int continent, int code, int roundIndex, int lastRoundIndex)
    {
        switch (type)
        {
            case CompetitionType.CopaNacional: // n2 == 2, f/G.java:105-110
            {
                var index = roundIndex + (Ss.Length - 1 - lastRoundIndex);
                return index >= 0 && index < Ss.Length ? Ss[index] : 0;
            }
            case CompetitionType.Internacional1: // n2 == 4, f/G.java:111-122
            {
                if (code is >= 4101 and <= 4103) return 500_000;
                if (code is >= 4000 and <= 4004) return 1_000_000;
                var c = continent < 0 ? 1 : continent;
                return roundIndex < Sw[0].Length && c < Sw.Length ? Sw[c][roundIndex] : 0;
            }
            case CompetitionType.Mundial: // n2 == 5, f/G.java:123-126
                return roundIndex < Sx.Length ? Sx[roundIndex] : 0;
            case CompetitionType.Internacional2: // n2 == 6, f/G.java:127-138
            {
                if (code == 6100) return 300_000;
                if (code is >= 6000 and <= 6004) return 500_000;
                var c = continent is < 0 or > 1 ? 1 : continent;
                return roundIndex < Sy[0].Length ? Sy[c][roundIndex] : 0;
            }
            case CompetitionType.Recopa: // n2 == 8, f/G.java:139-140
                return Sz0;
            case CompetitionType.Regionais: // n2 == 10, f/G.java:141-144
                return roundIndex < Sv.Length ? Sv[roundIndex] : 0;
            case CompetitionType.Supercopa: // n2 == 11, f/G.java:145-146
                return SA0;
            case CompetitionType.ConferenceLeague: // n2 == 12, f/G.java:147-158
            {
                if (code == 6100) return 300_000;
                if (code is >= 6000 and <= 6004) return 500_000;
                var c = continent is < 0 or > 1 ? 1 : continent;
                return roundIndex < AeG[0].Length ? AeG[c][roundIndex] : 0;
            }
            default:
                return 0;
        }
    }

    /// <summary>
    /// Soma, por time, o prêmio de cada rodada do mata-mata em que ele foi o vencedor (reproduz as
    /// chamadas de <c>f.G.V(vencedor)</c> a cada <c>f.G.b()</c>, <c>f/G.java:316,329</c>). Times
    /// eliminados na primeira fase não recebem nada; o campeão recebe a soma de todas as fases.
    /// </summary>
    public static IReadOnlyDictionary<Team, long> KnockoutPrizes(KnockoutBracket bracket)
    {
        ArgumentNullException.ThrowIfNull(bracket);
        var prizes = new Dictionary<Team, long>();
        for (var r = 0; r < bracket.Rounds.Count; r++)
        {
            var prize = KnockoutRoundPrize(
                bracket.Competition.Type, bracket.Competition.Continent, bracket.Code, r, bracket.LastRoundIndex);
            if (prize <= 0) continue;
            foreach (var pairing in bracket.Rounds[r].Pairings)
            {
                if (pairing.Winner is { } winner)
                    prizes[winner] = prizes.GetValueOrDefault(winner) + prize;
            }
            // A disputa de 3º lugar é anexada à lista de jogos da própria fase final no original
            // (f/G.java:78-80: this.aai.add(...) na mesma lista da decisão) e paga o mesmo prêmio de
            // fase ao seu vencedor.
            if (bracket.Rounds[r].ThirdPlace is { Winner: { } thirdPlaceWinner })
                prizes[thirdPlaceWinner] = prizes.GetValueOrDefault(thirdPlaceWinner) + prize;
        }
        return prizes;
    }

    /// <summary>
    /// Prêmio pago pela posição final de uma liga ou estadual (<c>ah.c(at,int)</c>,
    /// <c>best/ah.java:808-823</c>): Liga Nacional por divisão (<c>aq.sr</c>) ou 1ª divisão estadual
    /// (<c>aq.su</c>). <paramref name="position"/> é 1-based; fora dessas combinações o prêmio é zero
    /// (o original também não paga nada por posição final de copas/internacionais — só o mata-mata
    /// paga, via <see cref="KnockoutRoundPrize"/>).
    /// </summary>
    public static long LeagueFinalPositionPrize(CompetitionType type, int division, int position)
    {
        var index = position - 1;
        if (index < 0) return 0;
        if (type == CompetitionType.Nacional && division >= 0 && division < Sr.Length)
            return index < Sr[division].Length ? Sr[division][index] : 0;
        if (type == CompetitionType.Estadual && division == 1)
            return index < Su.Length ? Su[index] : 0;
        return 0;
    }

    /// <summary>Aplica <see cref="LeagueFinalPositionPrize"/> a toda a lista de posições finais de uma liga.</summary>
    public static IReadOnlyDictionary<Team, long> LeagueFinalPositionPrizes(
        CompetitionType type, int division, IReadOnlyList<(Team Team, int Position)> finalPositions)
    {
        ArgumentNullException.ThrowIfNull(finalPositions);
        var prizes = new Dictionary<Team, long>();
        foreach (var (team, position) in finalPositions)
        {
            var prize = LeagueFinalPositionPrize(type, division, position);
            if (prize > 0) prizes[team] = prize;
        }
        return prizes;
    }
}
