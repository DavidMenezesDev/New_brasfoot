using System.Globalization;
using Avalonia;
using Avalonia.Wayland;

namespace Brasfoot.App;

internal static class Program
{
    [STAThread]
    public static void Main(string[] args)
    {
        CultureInfo.CurrentCulture = CultureInfo.GetCultureInfo("pt-BR");
        BuildAvaloniaApp().StartWithClassicDesktopLifetime(args);
    }

    public static AppBuilder BuildAvaloniaApp()
    {
        var builder = AppBuilder.Configure<BrasfootApp>().UsePlatformDetect();
        if (OperatingSystem.IsLinux()) builder = builder.UseWayland();
        return builder.LogToTrace();
    }
}
