using CommunityToolkit.Mvvm.ComponentModel;

namespace Brasfoot.App.ViewModels;

public partial class PlaceholderViewModel(string title, string description) : ObservableObject, IGamePage
{
    public string Title { get; } = title;

    public string Description { get; } = description;

    public void Refresh()
    {
    }
}
