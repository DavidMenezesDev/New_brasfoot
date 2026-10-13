namespace Brasfoot.Core.Common;

/// <summary>
/// Fonte de aleatoriedade do jogo. O original cria um <c>java.util.Random</c> novo a cada
/// sorteio (semente pelo relógio); aqui um único gerador com semente opcional mantém as mesmas
/// distribuições e permite reproduzir partidas em testes.
/// </summary>
public interface IGameRandom
{
    /// <summary>Inteiro uniforme em [0, bound), como <c>Random.nextInt(bound)</c>.</summary>
    int NextInt(int bound);

    /// <summary>Real uniforme em [0, 1).</summary>
    double NextDouble();

    bool NextBool();
}

public sealed class GameRandom(int? seed = null) : IGameRandom
{
    private readonly Random _random = seed is { } s ? new Random(s) : new Random();

    public int NextInt(int bound) => _random.Next(bound);
    public double NextDouble() => _random.NextDouble();
    public bool NextBool() => _random.Next(2) == 1;
}

public static class RandomExtensions
{
    /// <summary>Embaralhamento uniforme (equivalente a <c>Collections.shuffle</c>).</summary>
    public static void Shuffle<T>(this IGameRandom random, IList<T> list)
    {
        for (var i = list.Count - 1; i > 0; i--)
        {
            var j = random.NextInt(i + 1);
            (list[i], list[j]) = (list[j], list[i]);
        }
    }
}
