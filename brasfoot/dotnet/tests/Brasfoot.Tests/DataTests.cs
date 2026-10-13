using Brasfoot.Core.Domain;
using Brasfoot.Data;

namespace Brasfoot.Tests;

/// <summary>Testes com os arquivos do jogo original; pulados se a pasta não existir.</summary>
public class DataTests
{
    private static readonly string? GameDir = Find();

    private static string? Find()
    {
        for (var dir = new DirectoryInfo(AppContext.BaseDirectory); dir != null; dir = dir.Parent)
        {
            var candidate = Path.Combine(dir.FullName, "brasfoot-linux");
            if (Directory.Exists(Path.Combine(candidate, "teams"))) return candidate;
        }
        return null;
    }

    [Fact]
    public void Loads_all_original_teams()
    {
        if (GameDir == null) return; // pasta do jogo ausente
        var teams = WorldLoader.LoadTeams(GameDir!);
        Assert.True(teams.Count > 600);
        var palmeiras = teams.Single(t => t.FileRef == "palmeiras");
        Assert.Equal(Countries.Brasil, palmeiras.CountryId);
        Assert.InRange(palmeiras.Squad.Count, 18, 40);
        Assert.Contains(teams, t => t.FileRef == "puskás_hun"); // nome com acento convertido para UTF-8
    }

    [Fact]
    public void New_game_builds_brazilian_divisions()
    {
        if (GameDir == null) return; // pasta do jogo ausente
        var ctx = TestData.Context();
        var world = WorldLoader.NewGame(GameDir!, ctx, [Countries.Brasil]);
        var league = world.LeagueOf(Countries.Brasil)!;
        Assert.Equal(20, league.Divisions[0].Count);
        Assert.All(league.Divisions[0], t => Assert.Equal(1, t.Division));
        Assert.All(world.Teams.SelectMany(t => t.Squad), p => Assert.InRange(p.Strength, 1, 100));
        Assert.True(league.Divisions[0].Average(t => t.Level) >= league.Divisions[^1].Average(t => t.Level));
    }
}
