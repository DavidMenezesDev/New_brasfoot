using System.Text.Json.Serialization;

namespace Brasfoot.Core.Domain;

/// <summary>Liga nacional simulada de um país (<c>best.Z</c>), com até 4 divisões.</summary>
public sealed class League(int countryId, string name)
{
    public int CountryId { get; } = countryId;
    public string Name { get; } = name;
    public List<List<Team>> Divisions { get; set; } = new();

    [JsonIgnore]
    public Continent Continent => Countries.Get(CountryId).Continent;
    [JsonIgnore]
    public int DivisionCount => Divisions.Count;
    [JsonIgnore]
    public IEnumerable<Team> Teams => Divisions.SelectMany(d => d);
}

/// <summary>Todos os clubes e ligas de um jogo salvo.</summary>
public sealed class World
{
    public List<Team> Teams { get; set; } = new();
    public List<League> Leagues { get; set; } = new();
    public List<TransferRecord> TransferHistory { get; set; } = new();
    public List<Loan> Loans { get; set; } = new();

    public League? LeagueOf(int countryId) => Leagues.FirstOrDefault(l => l.CountryId == countryId);
    public IEnumerable<Team> HumanTeams => Teams.Where(t => t.IsHuman);
}

/// <summary>Registro de transferência (<c>best.ap</c>).</summary>
public sealed record TransferRecord(DateOnly Date, Player Player, Team From, Team To, long Price, bool IsLoan);

/// <summary>Empréstimo em andamento (<c>components.t</c>).</summary>
public sealed record Loan(Player Player, Team Owner, DateOnly Ends);
