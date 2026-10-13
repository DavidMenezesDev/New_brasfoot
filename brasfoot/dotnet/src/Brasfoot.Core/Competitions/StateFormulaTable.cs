namespace Brasfoot.Core.Competitions;

/// <summary>
/// Dados fixos dos campeonatos estaduais e regionais (<c>best.aq</c>): a tabela de fórmulas
/// (<c>aq.sL</c>, <c>best/aq.java:776-836</c>), os nomes das fórmulas (<c>aq.sN</c>), o grupo padrão de
/// São Paulo (<c>aq.sO</c>, <c>best/aq.java:839</c>) e as tabelas de estado
/// (<c>aq.rX</c> sigla, <c>aq.rY</c> nome, <c>aq.rZ</c> gentílico; <c>best/aq.java:555-557</c>).
/// </summary>
public static class StateFormulaTable
{
    /// <summary>
    /// <c>aq.sL</c>: cada linha é <c>[nTimes, nGrupos, numeroTimesMataMata, doisTurnos, nRebaixados]</c>.
    /// <c>doisTurnos</c> é 1/0 (o original usa <c>== 1</c>). O índice é o valor <c>formula</c> do
    /// <c>ConfigEstadualType</c>.
    /// </summary>
    public static readonly int[][] Formulas =
    [
        [6, 0, 2, 1, 2],
        [8, 0, 4, 1, 2],
        [10, 0, 4, 0, 2],
        [11, 0, 4, 0, 2],
        [12, 0, 4, 0, 2],
        [12, 0, 8, 0, 2],
        [14, 0, 8, 0, 2],
        [16, 4, 2, 0, 2],
        [16, 0, 4, 0, 2],
        [16, 0, 8, 0, 2],
        [20, 4, 2, 0, 4],
    ];

    /// <summary><c>aq.sN</c>: rótulo de exibição de cada fórmula.</summary>
    public static readonly string[] FormulaNames =
    [
        "6 times - padrão", "8 times - 4 classificados", "10 times - 4 classificados",
        "11 times - 4 classificados", "12 times - 4 classificados", "12 times - 8 classificados",
        "14 times - 8 classificados", "16 times - 4 grupos - SP 2021", "16 times - 4 classificados",
        "16 times - 8 classificados", "20 times - 4 grupos",
    ];

    /// <summary>Fórmula usada quando não há configuração para a divisão (<c>best.w.dY</c>).</summary>
    public const int DefaultFormula = 0;

    /// <summary>
    /// <c>aq.sO</c>: os 16 clubes do "grupo padrão" paulista, na ordem em que <c>w.z</c> os colhe
    /// (<c>best/w.java:153-167</c>). Casados por <c>FileRef</c> (<c>ah.jY()</c>).
    /// </summary>
    public static readonly string[] SaoPauloStandardGroup =
    [
        "corinthians_bra", "santoandre_sp", "interlimeirasp_bra", "botafogosp_bra",
        "saopaulo_bra", "ferroviaria_sp", "pontepreta_bra", "saobento_bra",
        "bragantino_bra", "palmeiras", "ituano_sp", "novorinzontino_sp",
        "miirassol_sp", "santos", "guaranisp_bra", "saocaetano_bra",
    ];

    /// <summary><c>aq.rX</c>: sigla do estado (índice = id do estado, 0..26).</summary>
    public static readonly string[] Abbreviations =
    [
        "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB",
        "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO",
    ];

    /// <summary><c>aq.rY</c>: nome do estado (índice = id do estado).</summary>
    public static readonly string[] StateNames =
    [
        "Acre", "Alagoas", "Amazonas", "Amapá", "Bahia", "Ceará", "Distrito Federal",
        "Espírito Santo", "Goiás", "Maranhão", "Minas Gerais", "Mato Grosso Sul", "Mato Grosso",
        "Pará", "Paraíba", "Pernambuco", "Piauí", "Paraná", "Rio de Janeiro", "Rio Grande Norte",
        "Rondonia", "Roraima", "Rio Grande Sul", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins",
    ];

    /// <summary><c>aq.rZ</c>: gentílico do estado (<c>ea()</c>, usado no nome da competição).</summary>
    public static readonly string[] Demonyms =
    [
        "Acreano", "Alagoano", "Amazonense", "Amapaense", "Baiano", "Cearense", "Brasiliense",
        "Capixaba", "Goiano", "Maranhense", "Mineiro", "Sul-matogrossense", "Matogrossense",
        "Paraense", "Paraibano", "Pernambucano", "Piauiense", "Paranaense", "Carioca", "Potiguar",
        "Rondonense", "Roraimense", "Gaúcho", "Catarinense", "Sergipano", "Paulista", "Tocantinense",
    ];

    /// <summary>Total de estados (27: 26 estados + DF).</summary>
    public const int StateCount = 27;

    /// <summary>Sigla do estado, ou <c>"?"</c> quando fora da faixa.</summary>
    public static string AbbreviationOf(int state) =>
        state >= 0 && state < Abbreviations.Length ? Abbreviations[state] : "?";

    /// <summary>Nome do estado, ou <c>"?"</c> quando fora da faixa.</summary>
    public static string NameOf(int state) =>
        state >= 0 && state < StateNames.Length ? StateNames[state] : "?";

    /// <summary>Gentílico do estado, ou <c>"?"</c> quando fora da faixa.</summary>
    public static string DemonymOf(int state) =>
        state >= 0 && state < Demonyms.Length ? Demonyms[state] : "?";
}
