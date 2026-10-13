using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.App.ViewModels;

public sealed record PlayerRow(string Name, string Position, int Age, int Strength, long Value, long Salary)
{
    public string ValueText => Value.ToString("N0");
    public string SalaryText => Salary.ToString("N0");
}

public sealed record StandingRow(int Position, string Club, int Points, int Played, int Won, int Drawn, int Lost, int GoalsFor, int GoalsAgainst, int GoalDifference, bool IsMine)
{
    public string DisplayClub => IsMine ? $"▶ {Club}" : Club;

    public static IReadOnlyList<StandingRow> From(IEnumerable<TeamStanding> rows, Team human)
    {
        var list = new List<StandingRow>();
        var pos = 0;
        foreach (var row in rows)
        {
            pos++;
            list.Add(new StandingRow(pos, row.Team.Name, row.Points, row.Played, row.Won, row.Drawn, row.Lost, row.GoalsFor, row.GoalsAgainst, row.GoalDifference, row.Team == human));
        }
        return list;
    }
}

public sealed record MatchRow(string Date, string Competition, string Venue, string Opponent, string Score)
{
    public static MatchRow Scheduled(DateOnly date, Match match, Team human) =>
        new(date.ToString("dd/MM"), match.Competition.Name, VenueOf(match, human), OpponentOf(match, human), "");

    public static MatchRow From(DateOnly date, Match match, Team human) =>
        new(date.ToString("dd/MM"), match.Competition.Name, VenueOf(match, human), OpponentOf(match, human),
            match.Home == human
                ? $"{match.Score[0]} x {match.Score[1]}"
                : $"{match.Score[1]} x {match.Score[0]}");

    private static string VenueOf(Match match, Team human) => match.Home == human ? "Casa" : "Fora";

    private static string OpponentOf(Match match, Team human) => match.Home == human ? match.Away.Name : match.Home.Name;
}

public sealed record CompetitionGroup(string Name, string Status, IReadOnlyList<StandingRow> Rows);

public sealed record ChampionRow(int Season, string Competition, string Champion, string RunnerUp);
