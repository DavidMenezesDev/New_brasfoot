using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;
using Brasfoot.Data;

namespace Brasfoot.App.Services;

public static class GameService
{
    public static string? FindGameDir()
    {
        for (var dir = new DirectoryInfo(AppContext.BaseDirectory); dir != null; dir = dir.Parent)
        {
            var candidate = Path.Combine(dir.FullName, "brasfoot-linux");
            if (Directory.Exists(Path.Combine(candidate, "teams"))) return candidate;
        }
        return null;
    }

    public static IReadOnlyList<Team> BrazilianTeams(string gameDir) =>
        WorldLoader.LoadTeams(gameDir)
            .Where(t => t.CountryId == Countries.Brasil)
            .OrderByDescending(t => t.Level)
            .ThenBy(t => t.Name)
            .ToList();

    public static GameSession StartNewGame(string gameDir, string teamFileRef)
    {
        var ctx = new GameContext(new GameRandom(null), new RulesOptions { FixOriginalBugs = true });
        var world = WorldLoader.NewGame(gameDir, ctx, [Countries.Brasil], [teamFileRef]);
        var state = GameState.FromWorld(world, new GameOptions());
        var leagueConfigs = WorldLoader.LoadLeagueConfigs(gameDir);
        var serieDConfig = leagueConfigs.TryGetValue(Countries.Brasil, out var brazil)
            && brazil.TryGetValue(4, out var fourth) ? fourth : null;
        var hooks = new FullSeasonHooks(
            WorldLoader.LoadStateConfigs(gameDir),
            serieDConfig: serieDConfig,
            leagueConfigs: brazil);
        var session = new GameSession(state, ctx, hooks);
        session.BuildSeasonCalendar();
        return session;
    }

    public static Team HumanTeam(GameSession session) =>
        session.State.World.Teams.First(t => t.IsHuman);

    public static (DateOnly Date, IReadOnlyList<Match> Matches) PlayNextDay(GameSession session, Team human)
    {
        var day = session.CurrentDay;
        session.AdvanceToNextMatchDay();
        return (day.Date, day.Matches.Where(m => m.Home == human || m.Away == human).ToList());
    }

    public static IEnumerable<CalendarDay> UpcomingMatchDays(GameSession session, Team human, int count) =>
        session.Days.Skip(session.Calendar.CurrentIndex).Where(d => d.Involves(human)).Take(count);

    public static LeagueCompetition? LeagueOf(GameSession session, Team human) =>
        session.Leagues.FirstOrDefault(l => l.Teams.Contains(human));
}
