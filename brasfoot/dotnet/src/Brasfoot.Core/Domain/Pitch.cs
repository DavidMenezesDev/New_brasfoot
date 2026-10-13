namespace Brasfoot.Core.Domain;

/// <summary>Slots do campo, formações e preferências (<c>aq.sE</c>, <c>aq.sJ</c>, <c>aq.sH</c>, <c>aq.sI</c>).</summary>
public static class Pitch
{
    public const int Goalkeeper = 1;

    /// <summary>Slot → (posição, lado (-1 = qualquer), linha (-1 = qualquer; 0 defensiva, 1 ofensiva, 2 aberta)).</summary>
    public static readonly (int Position, int Side, int Row)[] Slots =
    [
        (0, -1, -1), (0, -1, -1), (1, 1, -1), (2, 1, -1), (2, -1, -1), (2, 0, -1), (2, 1, -1), (2, -1, -1),
        (2, 0, -1), (1, 0, -1), (1, 1, 1), (3, 1, 0), (3, -1, 0), (3, 0, 0), (3, 1, 1), (3, -1, 1),
        (3, 0, 1), (1, 1, 0), (4, 1, 2), (4, 1, -1), (4, -1, -1), (4, 0, -1), (4, 1, -1), (4, -1, -1),
        (4, 0, -1), (4, 0, 2),
    ];

    /// <summary>Ordem de preferência de posição ao preencher um slot, por posição do slot.</summary>
    public static readonly int[][] PositionPreference =
    [
        [0, 2, 1, 3, 4], [1, 3, 2, 4, 0], [2, 1, 3, 4, 0], [3, 1, 2, 4, 0], [4, 3, 1, 2, 0],
    ];

    /// <summary>Slots do banco: 2 G, 1 L, 2 Z, 1 volante, 2 meias, 3 atacantes.</summary>
    public static readonly int[] BenchSlots = [1, 1, 2, 4, 4, 12, 15, 15, 20, 20, 23];

    public static readonly string[] FormationNames =
    [
        "5-4-1", "5-4-1", "5-3-2", "4-5-1", "4-4-2", "4-4-2 def", "4-4-2 Ofen.", "4-3-3", "4-3-3 def",
        "3-5-2", "3-4-3", "4-2-3-1", "4-2-3-1 Alas",
    ];

    /// <summary>Formações: 11 slots na ordem de escalação (a ordem importa para as médias de setor).</summary>
    public static readonly int[][] Formations =
    [
        [1, 20, 11, 13, 14, 16, 2, 9, 6, 4, 8],
        [1, 20, 11, 13, 14, 16, 2, 9, 6, 4, 8],
        [1, 22, 24, 12, 14, 16, 2, 9, 6, 4, 8],
        [1, 23, 11, 13, 15, 2, 9, 6, 8, 10, 17],
        [1, 22, 24, 11, 13, 14, 16, 2, 9, 3, 5],
        [1, 19, 21, 11, 12, 13, 15, 2, 9, 6, 8],
        [1, 22, 24, 12, 14, 15, 16, 2, 9, 6, 8],
        [1, 22, 23, 24, 12, 14, 16, 2, 9, 6, 8],
        [1, 19, 20, 21, 11, 13, 15, 2, 9, 6, 8],
        [1, 22, 24, 11, 13, 15, 4, 6, 8, 10, 17],
        [1, 18, 25, 23, 11, 13, 4, 6, 8, 10, 17],
        [1, 23, 14, 16, 15, 13, 11, 2, 9, 6, 8],
        [1, 20, 10, 17, 15, 13, 11, 2, 9, 6, 8],
    ];

    /// <summary><c>F.gF()</c>: fora de posição se não está em campo ou a posição natural difere da do slot.</summary>
    public static bool IsOutOfPosition(Player p) => p.Slot <= 0 || Slots[p.Slot].Position != (int)p.Position;
}
