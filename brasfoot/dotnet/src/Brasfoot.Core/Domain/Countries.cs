namespace Brasfoot.Core.Domain;

/// <param name="Level">Nível do futebol do país; influencia a força inicial dos jogadores.</param>
public sealed record Country(int Id, string Code, string Name, Continent Continent, int Level);

public static partial class Countries
{
    public const int Brasil = 29;

    /// <summary>As cinco grandes ligas (<c>aq.rW</c>): Alemanha, França, Itália, Inglaterra, Espanha.</summary>
    public static readonly IReadOnlySet<int> TopFive = new HashSet<int> { 3, 72, 104, 97, 65 };

    // Lazy: a ordem de inicialização estática entre arquivos partial não é garantida.
    private static readonly Lazy<Dictionary<int, Country>> ById = new(() => All.ToDictionary(c => c.Id));

    public static Country Get(int id) => ById.Value[id];
    public static Country? Find(int id) => ById.Value.GetValueOrDefault(id);
    public static IReadOnlyCollection<Country> List => All;
}
