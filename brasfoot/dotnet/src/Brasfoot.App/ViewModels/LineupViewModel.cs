using System.Collections.ObjectModel;
using Avalonia;
using Avalonia.Media;
using Brasfoot.App.Services;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;

namespace Brasfoot.App.ViewModels;

public partial class LineupViewModel : ObservableObject, IGamePage
{
    private readonly GameSession _session;
    private readonly Team _team;
    private Player? _selected;

    public LineupViewModel(GameSession session, Team team)
    {
        _session = session;
        _team = team;
        Formations = Enumerable.Range(1, 12).Select(i => new FormationOption(i, Pitch.FormationNames[i])).ToList();
        StyleOptions = Enum.GetValues<Style>();
        MarkingOptions = Enum.GetValues<Marking>();
        PlayOptions = Enum.GetValues<Play>();
        _selectedFormation = Formations.FirstOrDefault(f => f.Index == team.Tactics.Formation) ?? Formations[0];
        _selectedStyle = team.Tactics.Style;
        _selectedMarking = team.Tactics.Marking;
        _selectedPlay = team.Tactics.Play;
        Refresh();
    }

    public string Title => "Escalação";

    public IReadOnlyList<FormationOption> Formations { get; }
    public IReadOnlyList<Style> StyleOptions { get; }
    public IReadOnlyList<Marking> MarkingOptions { get; }
    public IReadOnlyList<Play> PlayOptions { get; }
    public ObservableCollection<PitchCard> Starters { get; } = new();
    public ObservableCollection<PitchCard> Bench { get; } = new();
    public ObservableCollection<PitchCard> Outside { get; } = new();

    [ObservableProperty]
    private FormationOption _selectedFormation;

    [ObservableProperty]
    private Style _selectedStyle;

    [ObservableProperty]
    private Marking _selectedMarking;

    [ObservableProperty]
    private Play _selectedPlay;

    [ObservableProperty]
    private string _problems = "";

    [ObservableProperty]
    private bool _hasProblems;

    [ObservableProperty]
    private string _status = "";

    [ObservableProperty]
    private bool _hasSelection;

    [ObservableProperty]
    private string _selectedName = "";

    [ObservableProperty]
    private string _selectedInfo = "";

    [ObservableProperty]
    private bool _selectedIsStarter;

    [ObservableProperty]
    private double _teamRating;

    partial void OnSelectedFormationChanged(FormationOption value)
    {
        if (value.Index == _team.Tactics.Formation) return;
        HumanLineup.SetFormation(_team, value.Index, _session.Context);
        _selected = null;
        Status = "Formação alterada: titulares reorganizados.";
        Refresh();
    }

    partial void OnSelectedStyleChanged(Style value)
    {
        if (value != _team.Tactics.Style) _team.Tactics = _team.Tactics with { Style = value };
    }

    partial void OnSelectedMarkingChanged(Marking value)
    {
        if (value != _team.Tactics.Marking) _team.Tactics = _team.Tactics with { Marking = value };
    }

    partial void OnSelectedPlayChanged(Play value)
    {
        if (value != _team.Tactics.Play) _team.Tactics = _team.Tactics with { Play = value };
    }

    [RelayCommand]
    private void AutoFill()
    {
        HumanLineup.AutoFill(_team, _session.Context);
        _selected = null;
        Status = "Escalação automática montada.";
        Refresh();
    }

    [RelayCommand]
    private void SelectCard(PitchCard? card)
    {
        if (card is null) return;
        if (_selected is null)
        {
            _selected = card.Player;
            Status = "Escolha outro jogador para trocar de lugar, ou use os botões ao lado.";
        }
        else if (ReferenceEquals(_selected, card.Player))
        {
            _selected = null;
            Status = "";
        }
        else
        {
            HumanLineup.Swap(_team, _selected, card.Player);
            _selected = null;
            Status = "";
        }
        Refresh();
    }

    [RelayCommand]
    private void SendToField()
    {
        if (_selected is null) return;
        if (_selected.Slot > 0) return;
        Status = HumanLineup.ToggleStarter(_team, _selected, _session.Context)
            ? ""
            : "Não há posição livre compatível, ou os 11 titulares já estão escolhidos.";
        Refresh();
    }

    [RelayCommand]
    private void SendToBench()
    {
        if (_selected is null) return;
        if (_selected.Slot > 0) HumanLineup.ToggleStarter(_team, _selected, _session.Context);
        Status = HumanLineup.ToggleBench(_team, _selected)
            ? ""
            : "O banco está cheio.";
        Refresh();
    }

    public void Refresh()
    {
        if (_selected is not null && !_team.Squad.Contains(_selected)) _selected = null;

        var layout = PitchLayout.For(_team.Tactics.Formation);
        Starters.Clear();
        foreach (var p in HumanLineup.Starters(_team))
            Starters.Add(Card(p, PitchLayout.MarginFor(layout[p.Slot])));

        Bench.Clear();
        foreach (var p in HumanLineup.Bench(_team)) Bench.Add(Card(p, default));

        Outside.Clear();
        foreach (var p in _team.Squad.Where(p => p.Slot <= 0 && p.BenchOrder < 0).OrderByDescending(p => p.Strength))
            Outside.Add(Card(p, default));

        var starters = HumanLineup.Starters(_team);
        TeamRating = starters.Count == 0 ? 0 : starters.Average(p => p.Strength);

        var problems = HumanLineup.Problems(_team, _session.Context);
        Problems = string.Join("  ", problems);
        HasProblems = problems.Count > 0;

        HasSelection = _selected is not null;
        SelectedName = _selected?.Name ?? "";
        SelectedIsStarter = _selected is { Slot: > 0 };
        SelectedInfo = _selected is null
            ? ""
            : $"{ShortPosition(_selected.Position)} · força {_selected.Strength}" +
              (_selected.IsInjured(_session.Context.Today) ? " · lesionado" : "");
    }

    private PitchCard Card(Player p, Thickness margin)
    {
        var today = _session.Context.Today;
        return new PitchCard(
            p,
            LastName(p.Name),
            ShortPosition(p.Position),
            p.Strength,
            margin,
            TierBrush(p.Strength),
            ReferenceEquals(_selected, p),
            Pitch.IsOutOfPosition(p) && p.Slot > 0,
            p.IsInjured(today));
    }

    private static string LastName(string name)
    {
        var parts = name.Split(' ', StringSplitOptions.RemoveEmptyEntries);
        return parts.Length == 0 ? name : parts[^1];
    }

    private static string ShortPosition(Position position) => position switch
    {
        Position.Goleiro => "GOL",
        Position.Lateral => "LAT",
        Position.Zagueiro => "ZAG",
        Position.Meia => "MEI",
        _ => "ATA",
    };

    private static IBrush TierBrush(int strength) => new SolidColorBrush(Color.Parse(strength switch
    {
        >= 80 => "#D9B44A",
        >= 70 => "#B9C4CC",
        _ => "#A8714A",
    }));
}

public sealed record FormationOption(int Index, string Name);

public sealed record PitchCard(
    Player Player,
    string Name,
    string Position,
    int Strength,
    Thickness Margin,
    IBrush Tier,
    bool IsSelected,
    bool OutOfPosition,
    bool Injured);
