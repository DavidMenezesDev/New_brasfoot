using System.Collections.ObjectModel;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;
using CommunityToolkit.Mvvm.ComponentModel;

namespace Brasfoot.App.ViewModels;

public partial class CompetitionsViewModel : ObservableObject, IGamePage
{
    private readonly GameSession _session;
    private readonly Team _human;

    public CompetitionsViewModel(GameSession session, Team human)
    {
        _session = session;
        _human = human;
        Refresh();
    }

    public string Title => "Competições";

    public ObservableCollection<CompetitionGroup> Groups { get; } = new();

    public void Refresh()
    {
        Groups.Clear();
        foreach (var league in _session.Leagues)
            Add(league.Competition.Name, league.Standing, league.Champion?.Team, league.IsComplete);
        foreach (var phased in _session.Phased)
            Add(phased.Competition.Name, phased.Standing, phased.Champion, phased.IsComplete);
        foreach (var federation in _session.StateFederations)
            foreach (var division in federation.Divisions)
                Add(division.Competition.Name, division.Phased.Standing, division.Phased.Champion, division.Phased.IsComplete);
        foreach (var cup in _session.Cups)
            Add(cup.Competition.Name, [], cup.Champion, cup.IsComplete);
        foreach (var cup in _session.BrasilCup)
            Add(cup.Competition.Name, [], cup.Champion, cup.IsComplete);
    }

    private void Add(string name, IEnumerable<TeamStanding> rows, Team? champion, bool complete)
    {
        var status = champion is not null ? $"Campeão: {champion.Name}" : complete ? "Encerrada" : "Em andamento";
        Groups.Add(new CompetitionGroup(name, status, StandingRow.From(rows, _human)));
    }
}
