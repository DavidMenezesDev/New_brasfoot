using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Chaveamento do mata-mata a partir dos classificados (subconjunto fiel de <c>f/s.yP</c> e
/// <c>f/s.yO</c>): aplica as matrizes de permutação <c>Zm..Zz</c> (<see cref="BracketTables"/>) e
/// devolve a ordem da chave. O emparelhamento é consecutivo — (0,1), (2,3), … — como em
/// <c>f/G.a</c> (<c>f/G.java:64</c>), então <see cref="KnockoutBracket"/> consome o resultado direto.
/// </summary>
/// <remarks>
/// <para>
/// Convenção das listas de entrada (igual ao original): por grupo, os classificados na ordem de
/// posição (1º, 2º, …); a lista achatada fica
/// <c>(G1-1º, G1-2º, …, G2-1º, G2-2º, …)</c> — ver <c>f/s.java:870-877</c>. A matriz mapeia
/// <em>posição na chave → posição na lista</em>: <c>chave[i] = lista[matriz[i]]</c>
/// (<c>f/s.java:837, 911, 985</c>).
/// </para>
/// <para>
/// Os "melhores terceiros" (<c>yO</c>) entram <em>no fim</em> da lista, já ranqueados por
/// <c>h.K</c> (<see cref="LeagueTable.OrderByHk"/>), em quantidade
/// <see cref="BestThirdsCount"/> — <c>f/s.java:805-823</c>.
/// </para>
/// <para>
/// Quirks preservados: em <c>yO</c> a escolha da matriz <em>ignora</em> as duas voltas para 16 e 32
/// times (usa <c>Zw</c>/<c>Zz</c> direto — <c>f/s.java:824-833</c>); para 16 times em <c>yP</c> a
/// ida-e-volta usa <c>Zx</c>; para 4/2 times em <c>yP</c> sem grupos usa <c>Zo/Zp</c> e <c>Zm/Zn</c>.
/// O caso nacional (<c>var0 == 7 || var0 == 10</c>) usa <c>Zs</c>/<c>Zt</c> independentemente do
/// tamanho (<c>f/s.java:878-882</c>).
/// </para>
/// <para>
/// O portão que escolhe o chaveamento alternado 1º/2º (<c>f/s.java:852-867</c>, campo <c>b()</c> =
/// tipo da competição, <c>yT().gg()</c> = continente do país-dono) é derivado em
/// <see cref="DetermineGroupKnockoutSeeding"/>; <see cref="AlternateFirstsAndSeconds"/> continua
/// disponível como primitiva de baixo nível para quem já tem as duas listas prontas.
/// </para>
/// </remarks>
public static class BracketSeeder
{
    // f/s.java:931-948 (nArray2/nArray4), usados no caminho alternativo de 8 grupos.
    private static readonly int[] AlternateFirstIndex = [0, 7, 3, 4, 1, 6, 2, 5];
    private static readonly int[] AlternateSecondIndex = [7, 0, 4, 3, 6, 1, 5, 2];

    /// <summary>
    /// Verifica a matriz (<c>chave[i] = lista[matriz[i]]</c>) e devolve a lista reposicionada
    /// (<c>f/s.java:837, 911, 951, 985</c>).
    /// </summary>
    public static IReadOnlyList<Team> SeedByMatrix(IReadOnlyList<Team> teams, IReadOnlyList<int> matrix)
    {
        ArgumentNullException.ThrowIfNull(teams);
        ArgumentNullException.ThrowIfNull(matrix);
        if (matrix.Count != teams.Count)
            throw new ArgumentException(
                $"Matriz de {matrix.Count} posições para {teams.Count} times.", nameof(matrix));

        var seeded = new Team[teams.Count];
        for (var i = 0; i < teams.Count; i++)
        {
            var source = matrix[i];
            if (source < 0 || source >= teams.Count)
                throw new ArgumentOutOfRangeException(
                    nameof(matrix), source, $"Índice fora da lista de {teams.Count} times.");
            seeded[i] = teams[source];
        }
        return seeded;
    }

    /// <summary>
    /// Achata os classificados na ordem do original: por grupo (na ordem recebida), as
    /// <paramref name="perGroup"/> primeiras posições (<c>f/s.java:768-775</c>).
    /// </summary>
    public static List<Team> FlattenQualifiers(IReadOnlyList<IReadOnlyList<Team>> groups, int perGroup)
    {
        ArgumentNullException.ThrowIfNull(groups);
        if (perGroup < 0) throw new ArgumentOutOfRangeException(nameof(perGroup));

        var qualifiers = new List<Team>();
        foreach (var group in groups)
            for (var place = 0; place < perGroup && place < group.Count; place++)
                qualifiers.Add(group[place]);
        return qualifiers;
    }

    /// <summary>
    /// Classificados de grupos posicionados na chave (<c>f/s.yP</c>, caminho principal
    /// <c>!bl3 &amp;&amp; n2 == 0</c>). <paramref name="groups"/> já vem com os times ordenados por
    /// posição dentro de cada grupo.
    /// </summary>
    public static IReadOnlyList<Team> FromGroupQualifiers(
        IReadOnlyList<IReadOnlyList<Team>> groups,
        int perGroup,
        bool twoLegged,
        bool nationalPhase = false)
    {
        var qualifiers = FlattenQualifiers(groups, perGroup);
        var matrix = GroupMatrix(qualifiers.Count, twoLegged, nationalPhase);
        return matrix is null ? qualifiers : SeedByMatrix(qualifiers, matrix);
    }

    /// <summary>
    /// Classificados de grupos + melhores extras posicionados na chave (<c>f/s.yO</c>).
    /// <paramref name="extraRanked"/> é a lista da posição extra (terceiros, ou segundos em
    /// <c>Zj == 17</c>) já ranqueada por <c>h.K</c>; as <paramref name="extraCount"/> melhores entram
    /// no fim antes do chaveamento (<c>f/s.java:817-839</c>).
    /// </summary>
    public static IReadOnlyList<Team> FromGroupQualifiersWithThirds(
        IReadOnlyList<IReadOnlyList<Team>> groups,
        int perGroup,
        IReadOnlyList<TeamStanding> extraRanked,
        int extraCount,
        bool twoLegged)
    {
        ArgumentNullException.ThrowIfNull(extraRanked);
        var qualifiers = FlattenQualifiers(groups, perGroup);
        qualifiers.AddRange(extraRanked.Take(extraCount).Select(s => s.Team));
        var matrix = ExtraMatrix(qualifiers.Count, twoLegged);
        return matrix is null ? qualifiers : SeedByMatrix(qualifiers, matrix);
    }

    /// <summary>
    /// Lista simples (<c>f/s.yP</c>, caminho sem grupos / <c>classificaPeloGeral</c>:
    /// <c>f/s.java:956-988</c>).
    /// </summary>
    public static IReadOnlyList<Team> FromList(IReadOnlyList<Team> teams, bool twoLegged)
    {
        var matrix = ListMatrix(teams.Count, twoLegged);
        return matrix is null ? teams : SeedByMatrix(teams, matrix);
    }

    /// <summary>
    /// Quantidade de melhores extras (terceiros) que avançam, conforme <c>Zj</c>/<c>var0</c>
    /// (<c>f/s.java:805-816</c> e <c>1099-1113</c>).
    /// </summary>
    public static int BestThirdsCount(int groupCount, int competitionId) =>
        groupCount == 10 && competitionId == 1403 ? 6
        : groupCount == 3 ? 2
        : groupCount == 6 ? 4
        : groupCount == 12 ? 8
        : groupCount == 17 ? 15
        : 0;

    /// <summary>
    /// Posição (0-based) de onde saem os extras em <c>yO</c>: 2 = terceiros; 1 = segundos para
    /// <c>Zj == 17</c> e para <c>Zj == 10 &amp;&amp; var0 == 1403</c> (<c>f/s.java:776-791</c>).
    /// </summary>
    public static int BestExtraPlacementIndex(int groupCount, int competitionId) =>
        groupCount == 17 || (groupCount == 10 && competitionId == 1403) ? 1 : 2;

    /// <summary>
    /// Fase final nacional (código 90, <c>f/s.yN</c>): os segundos colocados de cada grupo,
    /// ranqueados por <c>h.K</c>, viram os 8 melhores e são <em>embaralhados</em> num mata-mata de 8
    /// (<c>f/s.java:733-759</c>).
    /// </summary>
    public static IReadOnlyList<Team> NationalFinalPhase(
        IReadOnlyList<TeamStanding> secondsRanked,
        Random random)
    {
        ArgumentNullException.ThrowIfNull(secondsRanked);
        ArgumentNullException.ThrowIfNull(random);

        var field = secondsRanked.Take(8).Select(s => s.Team).ToList();
        Shuffle(field, random);
        return field;
    }

    /// <summary>Embaralha in-place (Fisher–Yates), equivalente a <c>Collections.shuffle</c>.</summary>
    public static void Shuffle<T>(IList<T> list, Random random)
    {
        ArgumentNullException.ThrowIfNull(list);
        ArgumentNullException.ThrowIfNull(random);
        for (var i = list.Count - 1; i > 0; i--)
        {
            var j = random.Next(i + 1);
            (list[i], list[j]) = (list[j], list[i]);
        }
    }

    /// <summary>
    /// Caminho alternativo do chaveamento com grupos (<c>f/s.java:915-955</c>): intercala os
    /// segundos e primeiros colocados dos 8 grupos. Os dois arrays são fixos de 8 posições, então
    /// só vale para 8 grupos (16 times). <paramref name="firsts"/> e <paramref name="seconds"/> devem
    /// vir na ordem desejada (ranqueada por <c>h.K</c> ou embaralhada).
    /// </summary>
    public static IReadOnlyList<Team> AlternateFirstsAndSeconds(
        IReadOnlyList<Team> firsts,
        IReadOnlyList<Team> seconds)
    {
        ArgumentNullException.ThrowIfNull(firsts);
        ArgumentNullException.ThrowIfNull(seconds);
        if (firsts.Count != 8 || seconds.Count != 8)
            throw new ArgumentException("O cruzamento alternado usa exatamente 8 grupos (16 times).");

        var seeded = new List<Team>(16);
        for (var i = 0; i < 8; i++)
        {
            seeded.Add(seconds[AlternateSecondIndex[i]]);
            seeded.Add(firsts[AlternateFirstIndex[i]]);
        }
        return seeded;
    }

    /// <summary>
    /// Resultado do portão de <c>f/s.yP</c> (<c>f/s.java:852-867</c>): se o cruzamento deve ser o
    /// alternado 1º/2º (<see cref="AlternateFirstsAndSeconds"/>) em vez da matriz por tamanho
    /// (<see cref="FromGroupQualifiers"/>), se as duas filas (1ºs/2ºs) entram ranqueadas por
    /// <c>h.K</c> em vez de embaralhadas, e se o confronto usa gol-fora.
    /// </summary>
    public readonly record struct GroupKnockoutSeeding(bool Alternate, bool RankedNotShuffled, bool AwayGoals);

    /// <summary>
    /// Deriva o portão de <c>f/s.yP</c> a partir do tipo (<c>at.b()</c>) e do continente do país-dono
    /// (<c>at.gg()</c>), sem precisar de uma chamada manual (<c>f/s.java:852-867</c>):
    /// <list type="bullet">
    /// <item>tipo 4 (continental "liga*"), continente 0 (Europa) → alternado, embaralhado;</item>
    /// <item>tipo 4, continentes 1/2/3 (América do Sul/África/Ásia) → alternado, ranqueado por <c>h.K</c>;</item>
    /// <item>tipo 4 ou 6, continente 1 → gol fora habilitado (Conmebol);</item>
    /// <item>tipo 6 (segunda divisão continental), continente 0 (Europa League) → alternado, embaralhado;</item>
    /// <item>qualquer outro par → matriz por tamanho (<see cref="FromGroupQualifiers"/>).</item>
    /// </list>
    /// </summary>
    public static GroupKnockoutSeeding DetermineGroupKnockoutSeeding(CompetitionType competitionType, int continent)
    {
        var type = (int)competitionType;
        var rankedChampionsFirst = type == 4 && continent is 1 or 2 or 3;
        var shuffleBranch = (type == 4 && continent == 0) || (type == 6 && continent == 0);
        var awayGoals = (type == 4 || type == 6) && continent == 1;
        return new GroupKnockoutSeeding(
            Alternate: shuffleBranch || rankedChampionsFirst,
            RankedNotShuffled: rankedChampionsFirst,
            AwayGoals: awayGoals);
    }

    private static IReadOnlyList<int>? GroupMatrix(int count, bool twoLegged, bool nationalPhase)
    {
        if (nationalPhase) return twoLegged ? BracketTables.Zt : BracketTables.Zs;
        return count switch
        {
            32 => BracketTables.Zy,
            16 => twoLegged ? BracketTables.Zx : BracketTables.Zw,
            8 => twoLegged ? BracketTables.Zv : BracketTables.Zu,
            4 => twoLegged ? BracketTables.Zr : BracketTables.Zq,
            2 => twoLegged ? BracketTables.Zn : BracketTables.Zm,
            _ => null,
        };
    }

    private static IReadOnlyList<int>? ExtraMatrix(int count, bool twoLegged) => count switch
    {
        32 => BracketTables.Zz,
        16 => BracketTables.Zw,
        8 => twoLegged ? BracketTables.Zv : BracketTables.Zu,
        _ => null,
    };

    private static IReadOnlyList<int>? ListMatrix(int count, bool twoLegged) => count switch
    {
        16 => BracketTables.Zw,
        8 => twoLegged ? BracketTables.Zv : BracketTables.Zu,
        4 => twoLegged ? BracketTables.Zp : BracketTables.Zo,
        2 => twoLegged ? BracketTables.Zn : BracketTables.Zm,
        _ => null,
    };
}
