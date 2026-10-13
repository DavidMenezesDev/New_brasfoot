namespace Brasfoot.Core.Calendar;

/// <summary>
/// Tipo de dia/competição agendada no calendário (<c>best.a</c> constantes <c>G..S</c>;
/// spec-calendario §1.1). Os valores 1..15 coincidem com <c>Best.CompetitionType</c>/<c>at.b()</c>.
/// </summary>
public enum DayType
{
    Nenhum = 0,
    Nacional = 1,
    CopaNacional = 2,
    Estadual = 3,
    Internacional1 = 4,
    Mundial = 5,
    Internacional2 = 6,
    Selecoes = 7,
    Recopa = 8,
    Eliminatorias = 9,
    Regionais = 10,
    SuperCopa = 11,
    ConferenceLeague = 12,
    Finalissima = 13,
    LigaNacoes = 14,
    TorneioAmistoso = 15,
    AmistosoClube = 100,
    AmistosoSelecao = 200,
}

/// <summary>Nome de exibição do tipo (<c>aq.tz</c>, <c>best/aq.java:848</c>).</summary>
public static class DayTypes
{
    private static readonly string[] Display =
    [
        "Amistoso", "Nacional", "Copa Nacional", "Estadual", "Internacional 1", "Mundial",
        "Internacional 2", "Seleções", "Recopa", "Eliminatórias", "Regionais", "Supercopa",
        "Conference League", "Finalíssima", "Liga Nações", "Torneio Amistoso",
    ];

    public static string DisplayName(this DayType type) => type switch
    {
        DayType.Nenhum => "",
        DayType.AmistosoClube or DayType.AmistosoSelecao => Display[0],
        _ => (int)type >= 1 && (int)type <= 15 ? Display[(int)type] : type.ToString(),
    };

    /// <summary>Número do dia da semana no padrão <c>Calendar.get(7)</c>: 1=domingo..7=sábado.</summary>
    public static int JavaWeekday(this DateOnly date) => (int)date.DayOfWeek + 1;
}
