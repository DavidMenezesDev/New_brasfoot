using System.Collections.ObjectModel;
using Brasfoot.App.Services;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;
using CommunityToolkit.Mvvm.ComponentModel;

namespace Brasfoot.App.ViewModels;

public partial class ClubViewModel : ObservableObject, IGamePage
{
    private readonly GameSession _session;
    private readonly Team _team;

    public ClubViewModel(GameSession session, Team human)
    {
        _session = session;
        _team = human;
        Squad = human.Squad
            .OrderBy(p => p.Position)
            .ThenByDescending(p => p.Strength)
            .Select(p => new PlayerRow(p.Name, p.Position.ToString(), p.Age, p.Strength, p.Value, p.Salary))
            .ToList();
        Info = $"Estádio {_team.Stadium} · capacidade {_team.Capacity:N0} · técnico {_team.Coach} · reputação {_team.Reputation} · folha {_team.Payroll:N0}";
        Refresh();
    }

    public string Title => "Clube";

    [ObservableProperty]
    private string _leagueName = "";

    [ObservableProperty]
    private string _info = "";

    public ObservableCollection<MatchRow> Upcoming { get; } = new();
    public ObservableCollection<StandingRow> Standing { get; } = new();
    public IReadOnlyList<PlayerRow> Squad { get; }

    public void Refresh()
    {
        Upcoming.Clear();
        foreach (var d in GameService.UpcomingMatchDays(_session, _team, 5))
        {
            var match = d.Matches.First(m => m.Home == _team || m.Away == _team);
            Upcoming.Add(MatchRow.Scheduled(d.Date, match, _team));
        }

        Standing.Clear();
        var league = GameService.LeagueOf(_session, _team);
        LeagueName = league?.Competition.Name ?? "Sem liga nacional";
        if (league is not null)
            foreach (var row in StandingRow.From(league.Standing, _team)) Standing.Add(row);
    }
}
