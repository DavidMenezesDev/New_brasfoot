using Brasfoot.App.Services;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;

namespace Brasfoot.App.ViewModels;

public partial class MenuViewModel : ObservableObject
{
    private readonly MainViewModel _main;

    public MenuViewModel(MainViewModel main)
    {
        _main = main;
        var dir = GameService.FindGameDir();
        DataStatus = dir is null
            ? "Dados do jogo não encontrados. Informe a pasta brasfoot-linux na próxima tela."
            : $"Dados do jogo: {dir}";
        DataFound = dir is not null;
    }

    public string DataStatus { get; }

    public bool DataFound { get; }

    [RelayCommand]
    private void NewGame() => _main.ShowNewGame();
}
