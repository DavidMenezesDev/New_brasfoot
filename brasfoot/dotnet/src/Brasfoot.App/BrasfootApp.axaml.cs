using Avalonia;
using Avalonia.Controls.ApplicationLifetimes;
using Avalonia.Markup.Xaml;
using Brasfoot.App.ViewModels;

namespace Brasfoot.App;

public partial class BrasfootApp : Application
{
    public override void Initialize() => AvaloniaXamlLoader.Load(this);

    public override void OnFrameworkInitializationCompleted()
    {
        if (ApplicationLifetime is IClassicDesktopStyleApplicationLifetime desktop)
        {
            var main = new MainViewModel();
            desktop.MainWindow = new MainWindow { DataContext = main };
        }
        base.OnFrameworkInitializationCompleted();
    }
}
