using Avalonia;
using Brasfoot.Core.Domain;

namespace Brasfoot.App.Services;

public static class PitchLayout
{
    public const double Width = 520;
    public const double Height = 680;
    public const double CardWidth = 92;
    public const double CardHeight = 104;

    private const double MinSpacing = 0.20;

    private static readonly double[] LineY = [0.90, 0.70, 0.46, 0.22];

    private static readonly double[] SideOffsetByPosition = [0.0, 0.36, 0.16, 0.30, 0.18];

    /// <summary>Posição (0..1) de cada slot titular da formação, em coordenadas do campo.</summary>
    public static IReadOnlyDictionary<int, (double X, double Y)> For(int formation)
    {
        var result = new Dictionary<int, (double X, double Y)>();
        foreach (var line in Pitch.Formations[formation].GroupBy(slot => LineOf(Pitch.Slots[slot].Position)))
        {
            var slots = line
                .Select(slot => (Slot: slot, Target: Target(slot), Row: Pitch.Slots[slot].Row))
                .OrderBy(s => s.Target)
                .ThenBy(s => s.Row)
                .ToList();
            var xs = Spread(slots.Select(s => s.Target).ToArray());
            for (var i = 0; i < slots.Count; i++)
            {
                var row = slots[i].Row;
                var y = LineY[line.Key] + (row == 1 ? -0.04 : row == 0 ? 0.04 : 0.0);
                result[slots[i].Slot] = (xs[i], y);
            }
        }
        return result;
    }

    public static Thickness MarginFor((double X, double Y) point) =>
        new(point.X * Width - CardWidth / 2, point.Y * Height - CardHeight / 2, 0, 0);

    private static int LineOf(int position) => position switch
    {
        0 => 0,
        1 or 2 => 1,
        3 => 2,
        _ => 3,
    };

    private static double Target(int slot)
    {
        var (position, side, _) = Pitch.Slots[slot];
        var direction = side switch { 1 => -1.0, 0 => 1.0, _ => 0.0 };
        return 0.5 + direction * SideOffsetByPosition[Math.Clamp(position, 0, 4)];
    }

    /// <summary>Afasta posições coladas numa mesma linha e centraliza o conjunto.</summary>
    private static double[] Spread(double[] targets)
    {
        var xs = targets.OrderBy(x => x).ToArray();
        for (var i = 1; i < xs.Length; i++)
            xs[i] = Math.Max(xs[i], xs[i - 1] + MinSpacing);
        if (xs.Length == 1) return xs;
        var shift = 0.5 - (xs[0] + xs[^1]) / 2;
        return xs.Select(x => x + shift).ToArray();
    }
}
