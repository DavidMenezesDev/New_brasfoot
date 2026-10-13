using System.Collections.ObjectModel;
using Brasfoot.App.Services;
using Brasfoot.Core.Domain;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;

namespace Brasfoot.App.ViewModels;

public partial class NewGameViewModel : ObservableObject
{
    private readonly MainViewModel _main;

    public NewGameViewModel(MainViewModel main)
    {
        _main = main;
        _gameDir = GameService.FindGameDir() ?? "";
        LoadTeams();
    }

    [ObservableProperty]
    private string _gameDir;

    [ObservableProperty]
    private string? _error;

    [ObservableProperty]
    private Team? _selectedTeam;

    [ObservableProperty]
    private bool _busy;

    public ObservableCollection<Team> Teams { get; } = new();

    [RelayCommand]
    private void Back() => _main.ShowMenu();

    [RelayCommand]
    private void LoadTeams()
    {
        Error = null;
        Teams.Clear();
        if (string.IsNullOrWhiteSpace(GameDir) || !Directory.Exists(GameDir))
        {
            Error = "Pasta de dados do jogo não encontrada. Informe a pasta brasfoot-linux da instalação.";
            return;
        }
        foreach (var team in GameService.BrazilianTeams(GameDir)) Teams.Add(team);
    }

    [RelayCommand(CanExecute = nameof(CanStart))]
    private async Task StartAsync()
    {
        if (SelectedTeam is null) return;
        Busy = true;
        Error = null;
        try
        {
            var dir = GameDir;
            var fileRef = SelectedTeam.FileRef;
            var session = await Task.Run(() => GameService.StartNewGame(dir, fileRef));
            _main.ShowShell(session, GameService.HumanTeam(session));
        }
        catch (Exception ex)
        {
            Error = $"Não foi possível iniciar o jogo: {ex.Message}";
        }
        finally
        {
            Busy = false;
        }
    }

    private bool CanStart() => SelectedTeam is not null && !Busy;

    partial void OnSelectedTeamChanged(Team? value) => StartCommand.NotifyCanExecuteChanged();

    partial void OnBusyChanged(bool value) => StartCommand.NotifyCanExecuteChanged();
}
