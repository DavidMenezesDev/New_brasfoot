using Avalonia.Controls;

namespace Brasfoot.App.Views;

public partial class MenuView : UserControl
{
    public MenuView()
    {
        InitializeComponent();
        ExitButton.Click += (_, _) => (TopLevel.GetTopLevel(this) as Window)?.Close();
    }
}
