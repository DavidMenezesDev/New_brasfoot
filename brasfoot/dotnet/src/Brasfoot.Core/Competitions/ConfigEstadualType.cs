namespace Brasfoot.Core.Competitions;

/// <summary>
/// Configuração de formato de uma divisão de campeonato estadual (<c>est.ConfigEstadualType</c>,
/// campos e regras de validação em <c>est/ConfigEstadualType.java:11-136</c>), lida dos
/// <c>conf_estadual/*.ces</c> por <c>Brasfoot.Data.WorldLoader.LoadStateConfigs</c>.
/// </summary>
/// <remarks>
/// <para>
/// Os setters originais validam (e às vezes ignoram) os valores; <see cref="Create"/> reproduz esses
/// limites: <c>id</c> só aceita 0..26 (senão -1), <c>divisao</c> só aceita ≤4, <c>formula</c> precisa
/// ser menor que <c>aq.sL.length</c> (senão 0), <c>nRebaixados</c> só aceita 1..4 e <c>desempate</c> só
/// 0/1. <c>finaisIdaVolta[3]</c> é aceito sem validação, como no construtor de array
/// (<c>est/ConfigEstadualType.java:28-35</c>).
/// </para>
/// <para>
/// <see cref="Teams"/> é derivado da fórmula (<c>getnTimes()</c> = <c>aq.sL[formula][0]</c>), nunca
/// armazenado. <see cref="FinalsLegsFormatted"/> monta o <c>boolean[7]</c> de duas voltas do mata-mata
/// (<c>getFinaisIdaVoltaFormatado()</c>): as fases 3..6 são sempre de ida e volta e as fases 0..2 também
/// quando a perna correspondente vale 2.
/// </para>
/// </remarks>
public sealed record ConfigEstadualType
{
    /// <summary>Estado (id 0..26, índice de <c>aq.rX</c>); -1 quando inválido (<c>id</c>).</summary>
    public int Id { get; init; } = -1;

    /// <summary>Divisão, 1-based (<c>divisao</c>).</summary>
    public int Division { get; init; } = -1;

    /// <summary>Fórmula de disputa (<c>formula</c>), índice de <see cref="StateFormulaTable.Formulas"/>.</summary>
    public int Formula { get; init; }

    /// <summary>Rebaixados por temporada (<c>nRebaixados</c>, 1..4).</summary>
    public int Relegated { get; init; } = 2;

    /// <summary>Critério de desempate (0 ou 1, <c>desempate</c>).</summary>
    public int Tiebreak { get; init; }

    /// <summary>Pernas da final/idas e voltas por fase (<c>finaisIdaVolta[3]</c>, default <c>{2,2,2}</c>).</summary>
    public int[] FinalsLegs { get; init; } = [2, 2, 2];

    /// <summary>Número de times da divisão (<c>getnTimes()</c> = <c>aq.sL[formula][0]</c>).</summary>
    public int Teams => StateFormulaTable.Formulas[Formula][0];

    /// <summary>
    /// <c>getFinaisIdaVoltaFormatado()</c>: array de 7 booleanos de duas voltas por fase. As fases
    /// 3..6 valem sempre; as fases 0..2 valem quando <see cref="FinalsLegs"/> marca 2.
    /// </summary>
    public bool[] FinalsLegsFormatted()
    {
        var flags = new bool[7];
        flags[3] = true;
        flags[4] = true;
        flags[5] = true;
        flags[6] = true;
        if (FinalsLegs[0] == 2) flags[0] = true;
        if (FinalsLegs[1] == 2) flags[1] = true;
        if (FinalsLegs[2] == 2) flags[2] = true;
        return flags;
    }

    /// <summary>
    /// Cria uma configuração validando os campos como os setters originais. <paramref name="finalsLegs"/>
    /// aceita qualquer inteiro (sem validação), como o construtor de array.
    /// </summary>
    public static ConfigEstadualType Create(
        int id,
        int division,
        int formula,
        int relegated = 2,
        int tiebreak = 0,
        IReadOnlyList<int>? finalsLegs = null)
    {
        var legs = new[] { 2, 2, 2 };
        if (finalsLegs is { Count: >= 3 })
        {
            legs[0] = finalsLegs[0];
            legs[1] = finalsLegs[1];
            legs[2] = finalsLegs[2];
        }

        return new ConfigEstadualType
        {
            Id = id is >= 0 and <= 26 ? id : -1,
            Division = division <= 4 ? division : -1,
            Formula = formula >= 0 && formula < StateFormulaTable.Formulas.Length ? formula : 0,
            Relegated = relegated is > 0 and <= 4 ? relegated : 2,
            Tiebreak = tiebreak is 0 or 1 ? tiebreak : 0,
            FinalsLegs = legs,
        };
    }
}
