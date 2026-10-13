using Brasfoot.Core.Common;

namespace Brasfoot.Core;

/// <summary>Estado global que as regras consultam (temporada, data, opções, aleatoriedade).</summary>
public sealed class GameContext(IGameRandom random, RulesOptions? options = null)
{
    public IGameRandom Random { get; } = random;
    public RulesOptions Options { get; } = options ?? new RulesOptions();

    /// <summary>Temporada atual, começando em 1 (<c>SR.H()</c>).</summary>
    public int Season { get; set; } = 1;

    public DateOnly Today { get; set; } = new(2022, 1, 1);
}

public sealed record RulesOptions
{
    /// <summary>
    /// Corrige bugs evidentes do original (gols contados em dobro na súmula, minutos da nota,
    /// pesos inconsistentes de assistência, lista errada na substituição aleatória, pênaltis
    /// perdidos na nota, overflow de int). Desligado = paridade com o jogo original.
    /// </summary>
    public bool FixOriginalBugs { get; init; }

    /// <summary>Opção "salário mensal": salários armazenados ×4.</summary>
    public bool MonthlySalary { get; init; }

    /// <summary>Opção "atualizar automaticamente contratos encerrados" (padrão ligado).</summary>
    public bool AutoRenewExpiredContracts { get; init; } = true;
}
