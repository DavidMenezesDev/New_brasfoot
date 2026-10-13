using Brasfoot.App.Services;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;

namespace Brasfoot.App.ViewModels;

public partial class ShellViewModel : ObservableObject
{
    private readonly GameSession _session;
    private readonly Team _human;
    private readonly Action _returnToMenu;

    public ShellViewModel(GameSession session, Team human, Action returnToMenu)
    {
        _session = session;
        _human = human;
        _returnToMenu = returnToMenu;

        Pages =
        [
            new ClubViewModel(session, human),
            new LineupViewModel(session, human),
            new PlaceholderViewModel("Dia de jogo", "Partida ao vivo, pênaltis e resultados: em breve."),
            new MarketViewModel(session, human),
            new CompetitionsViewModel(session, human),
            new HistoryViewModel(session),
            new PlaceholderViewModel("Carreira", "Ofertas de emprego e demissão: em breve (Fase 6)."),
            new PlaceholderViewModel("Seleção", "Convocações e seleção: em breve (Fase 9)."),
            new PlaceholderViewModel("Preferências", "Velocidades, sons e autosave: em breve."),
        ];
        _selectedPage = Pages[0];
        _current = Pages[0];
        RefreshHeader();
    }

    public IReadOnlyList<IGamePage> Pages { get; }

    public string Badge => _human.Name[..1].ToUpperInvariant();

    [ObservableProperty]
    private IGamePage? _selectedPage;

    [ObservableProperty]
    private object? _current;

    [ObservableProperty]
    private string _title = "";

    [ObservableProperty]
    private string _currentDate = "";

    [ObservableProperty]
    private string _cash = "";

    [ObservableProperty]
    private string _status = "";

    [ObservableProperty]
    private bool _seasonEnded;

    partial void OnSelectedPageChanged(IGamePage? value)
    {
        if (value is not null) Current = value;
    }

    [RelayCommand]
    private void AdvanceDay()
    {
        if (SeasonEnded) return;
        var (date, played) = GameService.PlayNextDay(_session, _human);
        Status = played.Count == 0
            ? $"{date:dd/MM}: nenhum jogo seu neste dia."
            : $"{date:dd/MM}: " + string.Join("  |  ", played.Select(m => $"{m.Home.Name} {m.Score[0]} x {m.Score[1]} {m.Away.Name}"));
        RefreshHeader();
        foreach (var page in Pages) page.Refresh();
    }

    [RelayCommand]
    private void NextSeason()
    {
        if (!SeasonEnded) return;
        _session.StartNextSeason();
        Status = $"Temporada {_session.Year} iniciada.";
        RefreshHeader();
        foreach (var page in Pages) page.Refresh();
    }

    [RelayCommand]
    private void ReturnToMenu() => _returnToMenu();

    private void RefreshHeader()
    {
        SeasonEnded = _session.SeasonEnded;
        Title = $"{_human.Name} — temporada {_session.Year}";
        CurrentDate = _session.CurrentDay.Date.ToString("dddd, dd/MM/yyyy");
        Cash = $"Caixa: {_human.Cash:N0}";
    }
}
