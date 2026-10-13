namespace Brasfoot.Core.Competitions;

/// <summary>
/// Estrutura do mata-mata derivada de <c>f.z</c>: número de fases e os nomes de cada fase
/// (<c>f/z.zB</c>/<c>f/z.io</c>, com as tabelas <c>aq.ps..pD</c>, <c>aq.pX</c> e <c>aq.abY</c>).
/// </summary>
/// <remarks>
/// <para>
/// O índice da última fase é <c>ZG = rodadas - 1</c> (<c>f/z.java:38-71</c>): por número de
/// participantes (128→7, 64→6, 32→5, 16→4, 8→3, 4→2, 2→1), código 2029 → 7, ou <c>fixedRounds</c>
/// quando informado.
/// </para>
/// <para>
/// Nomes (<c>f/z.java:239-264, 342-371</c>): o array vem do código (1068 → <c>pX</c>, 6006 →
/// <c>abY</c>) ou de <c>ZG</c>; o índice dentro do array é <c>(nomes.length - 1 - ZG) + rodada</c>.
/// Quirk: <c>ZG == 7</c> é rebaixado para 6 antes do cálculo. Há rótulos especiais de preliminar
/// para <c>tR == 4</c>/<c>5</c> com poucas rodadas. Rodadas de ida e volta recebem o sufixo
/// <c>" - Nº jogo"</c>.
/// </para>
/// </remarks>
public static class KnockoutPlan
{
    // best/aq.java:126-158.
    private static readonly string[] Ps = ["Preliminar 1", "Preliminar 2", "Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"];
    private static readonly string[] Px = ["Fase Preliminar", "Primeira Fase", "Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"];
    private static readonly string[] Py = ["Primeira Fase", "Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"];
    private static readonly string[] Pz = ["Pré-Oitavas", "Oitavas", "Quartas", "Semifinal", "Final"];
    private static readonly string[] Pa = ["Oitavas", "Quartas", "Semifinal", "Final"];
    private static readonly string[] Pb = ["Quartas", "Semifinal", "Final"];
    private static readonly string[] Pc = ["Semifinal", "Final"];
    private static readonly string[] Pd = ["Decisão"];
    private static readonly string[] PX = ["Decisão da Vaga"];   // código 1068
    private static readonly string[] AbY = ["Pré-Oitavas"];      // código 6006

    /// <summary>
    /// Número de rodadas do mata-mata (<c>f/z.java:38-71</c>). <paramref name="fixedRounds"/> é o
    /// <c>fixedRounds</c> do construtor de <c>f/z</c>; <paramref name="code"/> é <c>Zg</c>.
    /// </summary>
    public static int RoundCount(int participants, int fixedRounds = 0, int code = -1)
    {
        if (fixedRounds > 0) return fixedRounds;
        if (code == 2029) return 7;
        return participants switch
        {
            128 => 7,
            64 => 6,
            32 => 5,
            16 => 4,
            8 => 3,
            4 => 2,
            2 => 1,
            _ => 1,
        };
    }

    /// <summary>Array de nomes das fases para o índice da última fase (<c>f/z.zB</c>).</summary>
    public static string[] RoundNames(int lastRoundIndex, int code = -1)
    {
        if (code == 1068) return PX;
        if (code == 6006) return AbY;
        return lastRoundIndex switch
        {
            6 => Px,
            5 => Py,
            4 => Pz,
            3 => Pa,
            2 => Pb,
            1 => Pc,
            0 => Pd,
            _ => Ps,
        };
    }

    /// <summary>
    /// Nome da rodada (<c>f/z.io</c>). <paramref name="lastRoundIndex"/> = <c>ZG</c>;
    /// <paramref name="roundIndex"/> = <c>Zf</c>; <paramref name="bracketType"/> = <c>tR</c>;
    /// <paramref name="leg"/> = <c>ZH</c> (1 ou 2) quando se quer o sufixo de jogo de ida/volta —
    /// <c>0</c> omite o sufixo.
    /// </summary>
    public static string RoundName(
        int lastRoundIndex,
        int roundIndex,
        int code = -1,
        int bracketType = 0,
        int leg = 0,
        bool twoLegged = false)
    {
        var names = RoundNames(lastRoundIndex, code);
        if (lastRoundIndex == 7) lastRoundIndex = 6;

        var offset = names.Length - 1 - lastRoundIndex;
        var index = offset + roundIndex;
        var name = index >= 0 && index < names.Length ? names[index] : names[0];

        if (lastRoundIndex == 0 && roundIndex == 0 && (bracketType == 4 || bracketType == 5))
            name = names[0];
        if (lastRoundIndex == 1 && roundIndex == 0 && bracketType == 4)
            name = "Preliminar R1";
        if (lastRoundIndex == 1 && roundIndex == 1 && bracketType == 4)
            name = "Preliminar R2";

        return twoLegged && leg > 0 ? $"{name} - {leg}º jogo" : name;
    }
}
