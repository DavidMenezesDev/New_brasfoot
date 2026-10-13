using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;
using CommunityToolkit.Mvvm.ComponentModel;

namespace Brasfoot.App.ViewModels;

public partial class MainViewModel : ObservableObject
{
    [ObservableProperty]
    private ObservableObject _current;

    public MainViewModel()
    {
        _current = new MenuViewModel(this);
    }

    public void ShowMenu() => Current = new MenuViewModel(this);

    public void ShowNewGame() => Current = new NewGameViewModel(this);

    public void ShowShell(GameSession session, Team human) => Current = new ShellViewModel(session, human, ShowMenu);
}
