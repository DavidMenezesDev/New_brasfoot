using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Sorteio do mata-mata "de copa" (<c>f/f.a</c>, <c>f/f.java:42-80</c>): com um grupo de clubes,
/// escolhe o maior quadro potência de dois entre 8 e 128 que cabe, divide a lista em duas metades,
/// embaralha cada metade e as intercala (<c>segunda[i], primeira[i]</c>) para montar a chave. Os
/// pares consecutivos ficam, portanto, <c>(2ª metade, 1ª metade)</c> — o que define quem manda o
/// primeiro jogo.
/// </summary>
/// <remarks>
/// <para>
/// A escolha do quadro é feita só pelo tamanho da lista (<c>f/f.java:49-59</c>); a lista de entrada
/// não é truncada do lado de dentro — só as primeiras <c>quadro</c> posições são usadas.
/// </para>
/// <para>
/// A ida-e-volta por fase (<c>boolean[]</c> = <c>f.z.ZK</c>) é decidida pela competição; este sorteio
/// só produz a ordem. O formato de potes da Copa do Brasil 2029 (<c>f/f.b</c>) é portado em
/// <see cref="CopaDoBrasil"/>; quando o grupo não comporta esse formato, o chamador cai aqui.
/// </para>
/// </remarks>
public static class CupDraw
{
    /// <summary>
    /// Maior quadro (8/16/32/64/128) que cabe em <paramref name="poolSize"/>; 0 quando nem 8 clubes
    /// (<c>f/f.java:49-59</c>).
    /// </summary>
    public static int BracketSize(int poolSize) => poolSize switch
    {
        >= 128 => 128,
        >= 64 => 64,
        >= 32 => 32,
        >= 16 => 16,
        >= 8 => 8,
        _ => 0,
    };

    /// <summary>
    /// Ordem da chave a partir do grupo (<c>f/f.java:61-74</c>). Devolve lista vazia se não houver
    /// pelo menos 8 clubes. <paramref name="random"/> é usado nas duas metades.
    /// </summary>
    public static IReadOnlyList<Team> SeedFromPool(IReadOnlyList<Team> pool, IGameRandom random)
    {
        ArgumentNullException.ThrowIfNull(pool);
        ArgumentNullException.ThrowIfNull(random);

        var size = BracketSize(pool.Count);
        if (size == 0) return [];

        var half = size / 2;
        var firsts = new List<Team>(half);
        var seconds = new List<Team>(half);
        for (var i = 0; i < half; i++)
        {
            firsts.Add(pool[i]);
            seconds.Add(pool[half + i]);
        }
        random.Shuffle(firsts);
        random.Shuffle(seconds);

        var seeded = new List<Team>(size);
        for (var i = 0; i < half; i++)
        {
            seeded.Add(seconds[i]);
            seeded.Add(firsts[i]);
        }
        return seeded;
    }
}
