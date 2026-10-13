namespace Brasfoot.Core.Common;

/// <summary>Semântica de arredondamento do Java, usada em todas as fórmulas do jogo.</summary>
public static class JMath
{
    /// <summary><c>Math.round(double)</c>: meio arredonda para cima (floor(x + 0.5)).</summary>
    public static long Round(double value) => (long)Math.Floor(value + 0.5);

    public static int RoundInt(double value) => (int)Round(value);
}
