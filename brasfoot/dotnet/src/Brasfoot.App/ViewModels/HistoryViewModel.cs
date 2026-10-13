using System.Collections.ObjectModel;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;
using CommunityToolkit.Mvvm.ComponentModel;

namespace Brasfoot.App.ViewModels;

public partial class HistoryViewModel : ObservableObject, IGamePage
{
    private readonly GameSession _session;

    public HistoryViewModel(GameSession session)
    {
        _session = session;
        Refresh();
    }

    public string Title => "Histórico";

    public ObservableCollection<ChampionRow> Champions { get; } = new();

    public void Refresh()
    {
        Champions.Clear();
        foreach (var r in _session.State.Champions.OrderByDescending(c => c.Season).ThenBy(c => c.Competition))
            Champions.Add(new ChampionRow(r.Season, r.Competition, r.TeamName, r.RunnerUpName ?? "—"));
    }
}
