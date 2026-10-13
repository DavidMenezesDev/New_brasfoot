using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Copa do Brasil novo formato (<c>f/f.b</c> + <c>f/f.ad..av</c>, <c>f/f.java:82-282</c>): 8 potes de
/// 10 clubes formam a 1ª fase (80 clubes, jogo único); a cada fase os vencedores são reordenados por
/// força e a competição avança até a final, com 12 clubes "cabeças" entrando já na 3ª fase. As fases
/// são os códigos <c>2129..2729</c>.
/// </summary>
/// <remarks>
/// <para>
/// Fluxo (fases 0..6): 80 → 40 → <b>+12 cabeças</b> → 32 → 16 → 8 → 4 → 2. A 1ª e a 2ª fase são jogo
/// único; da 3ª em diante, ida e volta (<c>blArray2</c>, <c>f/f.java:168-174</c>). Não há gol fora
/// (<c>aag == false</c>) e a 1ª fase (código 2129) decide qualquer empate a favor do visitante
/// (<c>f/G.java:298</c>).
/// </para>
/// <para>
/// A quantidade de clubes vem do estado do mundo (a lista completa de clubes da competição). Aqui o
/// sorteio e as reordenações são funções puras de teste; quando o grupo não comporta o formato
/// (menos de 12 cabeças distintas ou menos de 80 restantes), <see cref="FirstStage"/> devolve vazio e
/// o chamador deve cair no sorteio genérico de <see cref="CupDraw"/>, como no original
/// (<c>f/f.java:181-186</c>).
/// </para>
/// <para>Os "cabeças" originais vêm de <c>a.SR.aF().yy()/yB()</c> (clubes já classificados por outras
/// competições, país 29) e são completados com os primeiros clubes do grupo; aqui entram por
/// <c>preferred</c>.</para>
/// </remarks>
public static class CopaDoBrasil
{
    /// <summary>Número de clubes excluídos da fase de potes (<c>afU</c>).</summary>
    public const int ExcludedCount = 12;

    /// <summary>Número de potes (<c>azArray</c>).</summary>
    public const int PotCount = 8;

    /// <summary>Clubes por pote (<c>nArray</c>).</summary>
    public const int PotSize = 10;

    /// <summary>Códigos das fases (<c>fb</c>), na ordem (<c>f/f.java:180,214,247,256,265,273,280</c>).</summary>
    public static readonly int[] StageCodes = [2129, 2229, 2329, 2429, 2529, 2629, 2729];

    /// <summary>Ida-e-volta por fase: a 1ª e a 2ª são jogo único (<c>blArray2</c>).</summary>
    public static readonly bool[] TwoLeggedByStage = [false, false, true, true, true, true, true];

    /// <summary>Ordem dos potes no chaveamento da 1ª fase (<c>f/f.java:158-165</c>).</summary>
    private static readonly int[] PotOrder = [4, 0, 7, 3, 5, 1, 6, 2];

    /// <summary>
    /// Comparador <c>h.a.abm</c> (<c>h/J.java</c>): nível, depois reputação, depois desempate
    /// (<see cref="Team.RankTiebreak"/>), todos decrescentes — mais forte primeiro.
    /// </summary>
    public static int CompareClubs(Team a, Team b)
    {
        ArgumentNullException.ThrowIfNull(a);
        ArgumentNullException.ThrowIfNull(b);
        if (a.Level != b.Level) return b.Level - a.Level;
        if (a.Reputation != b.Reputation) return b.Reputation - a.Reputation;
        return b.RankTiebreak - a.RankTiebreak;
    }

    /// <summary>
    /// Os 12 clubes excluídos da fase de potes (<c>f/f.b</c>, <c>afU</c>): primeiro os
    /// <paramref name="preferred"/> (os cabeças já classificados), completados com os primeiros
    /// <c>pool[0..12]</c> até 12, truncando se passar. Devolve <c>null</c> se não atingir 12 (sem isso
    /// o formato de potes não existe — <c>Bf</c> só trunca para baixo).
    /// </summary>
    public static IReadOnlyList<Team>? SelectExcluded(IReadOnlyList<Team> pool, IReadOnlyList<Team>? preferred = null)
    {
        ArgumentNullException.ThrowIfNull(pool);

        var excluded = new List<Team>();
        if (preferred is not null)
            foreach (var team in preferred)
                if (!excluded.Contains(team))
                    excluded.Add(team);
        for (var i = 0; i < pool.Count && i <= ExcludedCount; i++)
            if (!excluded.Contains(pool[i]))
                excluded.Add(pool[i]);

        if (excluded.Count > ExcludedCount) excluded.RemoveRange(ExcludedCount, excluded.Count - ExcludedCount);
        return excluded.Count == ExcludedCount ? excluded : null;
    }

    /// <summary>
    /// 1ª fase (<c>f/f.b</c>): divide os clubes restantes em 8 potes sequenciais de 10, embaralha cada
    /// pote e intercala na ordem <see cref="PotOrder"/>. Devolve vazio se houver menos de 80 restantes
    /// (aí cabe o sorteio genérico).
    /// </summary>
    public static IReadOnlyList<Team> FirstStage(IReadOnlyList<Team> remaining, IGameRandom random)
    {
        ArgumentNullException.ThrowIfNull(remaining);
        ArgumentNullException.ThrowIfNull(random);
        if (remaining.Count < PotCount * PotSize) return [];

        var pots = new List<Team>[PotCount];
        for (var p = 0; p < PotCount; p++)
        {
            var pot = remaining.Skip(p * PotSize).Take(PotSize).ToList();
            random.Shuffle(pot);
            pots[p] = pot;
        }

        var order = new List<Team>(PotCount * PotSize);
        for (var i = 0; i < PotSize; i++)
            foreach (var p in PotOrder)
                order.Add(pots[p][i]);
        return order;
    }

    /// <summary>
    /// 2ª fase (<c>f/f.ad</c>): ordena os 40 vencedores por força e intercala
    /// <c>[fraco, forte]</c> (o cabeça manda o 2º jogo).
    /// </summary>
    public static IReadOnlyList<Team> SecondStage(IReadOnlyList<Team> winners, IGameRandom random)
    {
        ArgumentNullException.ThrowIfNull(winners);
        ArgumentNullException.ThrowIfNull(random);

        var sorted = winners.OrderBy(t => t, Comparer<Team>.Create(CompareClubs)).ToList();
        var half = sorted.Count / 2;
        var stronger = sorted.Take(half).ToList();
        var weaker = sorted.Skip(half).ToList();
        random.Shuffle(stronger);
        random.Shuffle(weaker);

        var order = new List<Team>(sorted.Count);
        for (var i = 0; i < half; i++)
        {
            order.Add(weaker[i]);
            order.Add(stronger[i]);
        }
        return order;
    }

    /// <summary>
    /// 3ª fase (<c>f/f.ao</c>): junta os 20 vencedores aos 12 cabeças, ordena por força e intercala
    /// <c>[forte, fraco]</c>.
    /// </summary>
    public static IReadOnlyList<Team> ThirdStage(
        IReadOnlyList<Team> winners, IReadOnlyList<Team> excluded, IGameRandom random)
    {
        ArgumentNullException.ThrowIfNull(winners);
        ArgumentNullException.ThrowIfNull(excluded);
        ArgumentNullException.ThrowIfNull(random);

        var all = winners.Concat(excluded).OrderBy(t => t, Comparer<Team>.Create(CompareClubs)).ToList();
        var half = all.Count / 2;
        var stronger = all.Take(half).ToList();
        var weaker = all.Skip(half).ToList();
        random.Shuffle(stronger);
        random.Shuffle(weaker);

        var order = new List<Team>(all.Count);
        for (var i = 0; i < half; i++)
        {
            order.Add(stronger[i]);
            order.Add(weaker[i]);
        }
        return order;
    }

    /// <summary>4ª..7ª fases (<c>f/f.as..av</c>): apenas embaralha os vencedores.</summary>
    public static IReadOnlyList<Team> LaterStage(IReadOnlyList<Team> winners, IGameRandom random)
    {
        ArgumentNullException.ThrowIfNull(winners);
        ArgumentNullException.ThrowIfNull(random);
        var order = winners.ToList();
        random.Shuffle(order);
        return order;
    }

    /// <summary>
    /// Roda a Copa do Brasil completa a partir de <paramref name="pool"/> e devolve o campeão.
    /// Devolve <c>null</c> se o grupo não comporta o formato de potes (use <see cref="CupDraw"/>).
    /// </summary>
    public static Team? Play(
        Competition competition,
        IReadOnlyList<Team> pool,
        GameContext ctx,
        IReadOnlyList<Team>? preferred = null)
    {
        ArgumentNullException.ThrowIfNull(competition);
        ArgumentNullException.ThrowIfNull(pool);
        ArgumentNullException.ThrowIfNull(ctx);

        var excluded = SelectExcluded(pool, preferred);
        if (excluded is null) return null;

        var remaining = pool.Where(t => !excluded.Contains(t)).ToList();
        var field = FirstStage(remaining, ctx.Random);
        if (field.Count == 0) return null;

        for (var stage = 0; ; stage++)
        {
            var winners = KnockoutBracket.PlaySingleRound(
                competition, field, TwoLeggedByStage[stage], ctx,
                awayGoalsRule: false, shootoutAllowed: true, tiebreakCompetitionId: StageCodes[stage]);
            if (winners.Count == 1) return winners[0];
            field = stage switch
            {
                0 => SecondStage(winners, ctx.Random),
                1 => ThirdStage(winners, excluded, ctx.Random),
                _ => LaterStage(winners, ctx.Random),
            };
        }
    }
}
