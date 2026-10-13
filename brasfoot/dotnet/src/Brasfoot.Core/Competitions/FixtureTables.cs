namespace Brasfoot.Core.Competitions;

/// <summary>
/// Tabelas de rodízio pequenas de <c>best.t</c> que o decompilador monta de forma imperativa no
/// bloco <c>static</c> (por isso não saem de <c>extract_fixture_tables.py</c>). Índices base 0,
/// no formato original <c>[rodada][jogo][0=mando,1=visitante]</c>.
/// </summary>
internal static partial class FixtureTables
{
    /// <summary>3 times, turno único (<c>best.t.Jd</c>, 3 rodadas x 1 jogo).</summary>
    public static readonly int[][] Jd =
    {
        new[] { 2, 0 },
        new[] { 1, 2 },
        new[] { 1, 0 },
    };

    /// <summary>3 times, dois turnos (<c>best.t.dc</c>, 6 rodadas x 1 jogo).</summary>
    public static readonly int[][] dc =
    {
        new[] { 2, 0 },
        new[] { 1, 2 },
        new[] { 1, 0 },
        new[] { 0, 2 },
        new[] { 2, 1 },
        new[] { 0, 1 },
    };

    /// <summary>4 times, turno único (<c>best.t.Je</c>, 3 rodadas x 2 jogos).</summary>
    public static readonly int[][][] Je =
    {
        new[] { new[] { 0, 1 }, new[] { 2, 3 } },
        new[] { new[] { 0, 2 }, new[] { 3, 1 } },
        new[] { new[] { 3, 0 }, new[] { 1, 2 } },
    };

    /// <summary>5 times, 10 rodadas x 2 jogos (<c>best.t.de</c>): as 5 primeiras são o turno único.</summary>
    public static readonly int[][][] de =
    {
        new[] { new[] { 3, 2 }, new[] { 1, 0 } },
        new[] { new[] { 1, 4 }, new[] { 0, 2 } },
        new[] { new[] { 2, 1 }, new[] { 4, 3 } },
        new[] { new[] { 0, 3 }, new[] { 2, 4 } },
        new[] { new[] { 4, 0 }, new[] { 3, 1 } },
        new[] { new[] { 2, 3 }, new[] { 0, 1 } },
        new[] { new[] { 4, 1 }, new[] { 2, 0 } },
        new[] { new[] { 1, 2 }, new[] { 3, 4 } },
        new[] { new[] { 3, 0 }, new[] { 4, 2 } },
        new[] { new[] { 0, 4 }, new[] { 1, 3 } },
    };

    /// <summary>6 times, dois turnos (<c>best.t.Jf</c>, 10 rodadas x 3 jogos).</summary>
    public static readonly int[][][] Jf =
    {
        new[] { new[] { 2, 1 }, new[] { 0, 4 }, new[] { 5, 3 } },
        new[] { new[] { 2, 0 }, new[] { 5, 1 }, new[] { 3, 4 } },
        new[] { new[] { 2, 5 }, new[] { 3, 0 }, new[] { 4, 1 } },
        new[] { new[] { 2, 4 }, new[] { 1, 3 }, new[] { 0, 5 } },
        new[] { new[] { 2, 3 }, new[] { 4, 5 }, new[] { 1, 0 } },
        new[] { new[] { 1, 2 }, new[] { 4, 0 }, new[] { 3, 5 } },
        new[] { new[] { 0, 2 }, new[] { 1, 5 }, new[] { 4, 3 } },
        new[] { new[] { 5, 2 }, new[] { 0, 3 }, new[] { 1, 4 } },
        new[] { new[] { 4, 2 }, new[] { 3, 1 }, new[] { 5, 0 } },
        new[] { new[] { 3, 2 }, new[] { 5, 4 }, new[] { 0, 1 } },
    };
}
