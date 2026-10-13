using Brasfoot.Core;
using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Tests;

internal static class TestData
{
    public static GameContext Context(int seed = 42, bool fix = false) =>
        new(new GameRandom(seed), new RulesOptions { FixOriginalBugs = fix });

    private static int _nextId = 1000;

    /// <summary>Elenco completo: 3 G, 4 L, 5 Z, 8 M, 5 A, todos com a mesma força.</summary>
    public static Team Team(string name, int strength, int country = Countries.Brasil, int reputation = 3, int division = 1, bool league = true)
    {
        var team = new Team
        {
            Id = _nextId++, Name = name, FileRef = name.ToLowerInvariant(), CountryId = country, Level = 18,
            Reputation = reputation, Division = division, IsLeagueClub = league,
        };
        (Position Pos, int Count)[] shape = [(Position.Goleiro, 3), (Position.Lateral, 4), (Position.Zagueiro, 5), (Position.Meia, 8), (Position.Atacante, 5)];
        var n = 0;
        foreach (var (pos, count) in shape)
        {
            for (var i = 0; i < count; i++)
            {
                team.Squad.Add(new Player
                {
                    Name = $"{name} {pos} {i}", Position = pos, Side = (Side)(i % 2), Strength = strength, Age = 25,
                    Nationality = country, Club = team, Potential = 5,
                    Cr1 = pos == Position.Atacante ? (int)Characteristic.Finalizacao : (int)Characteristic.Passe,
                    Cr2 = (int)Characteristic.Velocidade, Value = 1_000_000, Salary = 10_000,
                    ContractEnd = new DateOnly(2023, 1, 1),
                });
                n++;
            }
        }
        return team;
    }

    public static Player Player(Team club, Position position, int strength, int age = 25) => new()
    {
        Name = "Teste", Position = position, Strength = strength, Age = age, Nationality = club.CountryId, Club = club,
        Potential = 5,
    };
}
