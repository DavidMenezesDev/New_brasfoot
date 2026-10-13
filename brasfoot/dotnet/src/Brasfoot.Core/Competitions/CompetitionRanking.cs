using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Pontos de ranking/reputação de clube e técnico concedidos por posição final/campanha em uma
/// competição (<c>ah.b(at,int,int)</c>, <c>best/ah.java:912-1038</c>, para o clube — acumulado em
/// <c>nB[tipo]</c> — e <c>al.b(at,int,int)</c>, <c>best/al.java:792-902</c>, para o técnico —
/// acumulado em <c>oc</c>/<c>lI()</c>). Pura: apenas calcula os pontos; quem acumula no clube/técnico
/// é responsabilidade de fases futuras (Reputation/ManagerRanking).
/// </summary>
/// <remarks>
/// O terceiro parâmetro das duas tabelas originais (<c>n3</c>, a fase/round-hint de <c>f/s.za</c>) só
/// alimenta <c>ah.d(int,int,int)</c> (crescimento de torcida/confiança do campeão — fase 6, não
/// portado aqui) e não entra no cálculo de pontos; por isso não existe nos métodos abaixo.
/// </remarks>
public static class CompetitionRanking
{
    // best/ah.java:924-1038 — pontos de ranking do CLUBE por tipo de competição (índice = CompetitionType) e posição (1-based).
    private static readonly int[][] ClubBase =
    [
        [0],                                   // 0 Amistoso
        [0, 15, 10, 8, 7, 6, 5, 4, 3, 2, 1],    // 1 Nacional
        [0, 12, 7, 3, 3],                       // 2 CopaNacional
        [0, 5, 3],                              // 3 Estadual
        [0, 20, 15, 7, 7, 3, 3],                // 4 Internacional1
        [0, 10, 5],                             // 5 Mundial
        [0, 12, 10, 5, 5],                      // 6 Internacional2
        [0, 50, 35, 10, 5],                     // 7 Selecoes (base; ver override abaixo)
        [0, 3],                                 // 8 Recopa
        [0],                                    // 9 Eliminatorias
        [0, 2, 1],                              // 10 Regionais
        [0, 2],                                 // 11 Supercopa
        [0, 10, 8, 4, 4],                       // 12 ConferenceLeague
        [0],                                    // 13 Finalissima
        [0, 15, 10, 5],                         // 14 LigaNacoes
        [0],                                    // 15 TorneioAmistoso
    ];

    // best/ah.java:998-1002 — Selecoes fora da Copa do Mundo (continent != 7).
    private static readonly int[] ClubSelecoesNotWorldCup = [0, 20, 15, 10, 5];

    // best/ah.java:1003-1016 — Nacional, divisão 2 e divisão 3+.
    private static readonly int[] ClubNacionalDivision2 = [0, 5, 3, 2, 1];
    private static readonly int[] ClubNacionalDivision3Plus = [0, 2, 1];

    // best/ah.java:1021-1030 — Internacional1, clube de continente != Europa/América do Sul (gg() > 1).
    private static readonly int[] ClubInternacional1OutsideTopContinents = [0, 18, 12, 3, 3, 1, 1];

    // best/al.java:793-888 — pontos de ranking do TÉCNICO por tipo de competição e posição (1-based).
    private static readonly int[][] ManagerBase =
    [
        [0],                                    // 0 Amistoso
        [0, 25, 10, 8, 7, 6, 5, 4, 3, 2, 1],     // 1 Nacional
        [0, 20, 7, 3, 3],                        // 2 CopaNacional
        [0, 15, 3],                              // 3 Estadual
        [0, 30, 15, 7, 7],                        // 4 Internacional1
        [0, 25, 5],                              // 5 Mundial
        [0, 20, 10, 5, 5],                       // 6 Internacional2
        [0, 35, 20, 10, 5],                      // 7 Selecoes (base; ver override abaixo)
        [0, 3],                                  // 8 Recopa
        [0],                                     // 9 Eliminatorias
        [0, 5, 3],                               // 10 Regionais
        [0, 2],                                  // 11 Supercopa
        [0, 18, 8, 4, 4],                        // 12 ConferenceLeague
        [0, 20, 10],                              // 13 Finalissima
        [0, 25, 15, 7, 3],                       // 14 LigaNacoes
        [0],                                     // 15 TorneioAmistoso
    ];

    // best/al.java:889-897 — Selecoes fora da Copa do Mundo (gg() != 7).
    private static readonly int[] ManagerSelecoesNotWorldCup = [0, 25, 15, 5, 3];

    // best/al.java:871-886 — Nacional, divisão 2 e divisão 3+.
    private static readonly int[] ManagerNacionalDivision2 = [0, 5, 3, 2, 1];
    private static readonly int[] ManagerNacionalDivision3Plus = [0, 2, 1];

    // best/al.java:887-890 — Estadual, divisão 2+: zero pontos.
    private static readonly int[] Zero = [0];

    /// <summary>
    /// Pontos de ranking do clube (<c>ah.b(at,int,int)</c>, <c>best/ah.java:912-1038</c>).
    /// <paramref name="continent"/> é <c>Competition.Continent</c> (usado só no tipo Seleções, para
    /// distinguir a Copa do Mundo — continente 7 — das demais); <paramref name="division"/> é
    /// <c>at.ip()</c> (divisão da Liga Nacional ou do Estadual); <paramref name="clubContinent"/> é o
    /// continente do próprio clube (<c>ah.gg()</c>, <see cref="Team.Continent"/>), usado só no tipo
    /// Internacional1. Competições tipo 15 (Torneio Amistoso) não concedem pontos no original (o
    /// índice do tipo é checado contra <c>&lt;= 14</c> antes de somar).
    /// </summary>
    public static int ClubRankingPoints(CompetitionType type, int continent, int division, int clubContinent, int position)
    {
        var table = ClubBase[(int)type];
        if (type == CompetitionType.Selecoes && continent != 7) table = ClubSelecoesNotWorldCup;
        else if (type == CompetitionType.Nacional && division > 1) table = division == 2 ? ClubNacionalDivision2 : ClubNacionalDivision3Plus;
        else if (type == CompetitionType.Estadual && division > 1) table = Zero;
        else if (type == CompetitionType.Internacional1 && clubContinent > 1) table = ClubInternacional1OutsideTopContinents;

        return type <= CompetitionType.LigaNacoes && position >= 0 && position < table.Length ? table[position] : 0;
    }

    /// <summary>
    /// Pontos de ranking do técnico (<c>al.b(at,int,int)</c>, <c>best/al.java:792-902</c>). Mesmos
    /// parâmetros de <see cref="ClubRankingPoints"/> exceto <c>clubContinent</c> — a tabela do técnico
    /// não distingue pelo continente do clube, só pelo da competição (Internacional1 não tem variante
    /// reduzida aqui, ao contrário da tabela do clube).
    /// </summary>
    public static int ManagerRankingPoints(CompetitionType type, int continent, int division, int position)
    {
        var table = ManagerBase[(int)type];
        if (type == CompetitionType.Selecoes && continent != 7) table = ManagerSelecoesNotWorldCup;
        else if (type == CompetitionType.Nacional && division > 1) table = division == 2 ? ManagerNacionalDivision2 : ManagerNacionalDivision3Plus;
        else if (type == CompetitionType.Estadual && division > 1) table = Zero;

        return type <= CompetitionType.LigaNacoes && position >= 0 && position < table.Length ? table[position] : 0;
    }

    /// <summary>Aplica <see cref="ClubRankingPoints"/> a toda a lista de posições finais de uma competição.</summary>
    public static IReadOnlyDictionary<Team, int> ClubRankingPoints(
        CompetitionType type, int continent, int division, IReadOnlyList<(Team Team, int Position)> finalPositions)
    {
        ArgumentNullException.ThrowIfNull(finalPositions);
        var points = new Dictionary<Team, int>();
        foreach (var (team, position) in finalPositions)
        {
            var value = ClubRankingPoints(type, continent, division, (int)team.Continent, position);
            if (value > 0) points[team] = value;
        }
        return points;
    }

    /// <summary>Aplica <see cref="ManagerRankingPoints"/> a toda a lista de posições finais de uma competição.</summary>
    public static IReadOnlyDictionary<Team, int> ManagerRankingPoints(
        CompetitionType type, int continent, int division, IReadOnlyList<(Team Team, int Position)> finalPositions)
    {
        ArgumentNullException.ThrowIfNull(finalPositions);
        var points = new Dictionary<Team, int>();
        foreach (var (team, position) in finalPositions)
        {
            var value = ManagerRankingPoints(type, continent, division, position);
            if (value > 0) points[team] = value;
        }
        return points;
    }
}
