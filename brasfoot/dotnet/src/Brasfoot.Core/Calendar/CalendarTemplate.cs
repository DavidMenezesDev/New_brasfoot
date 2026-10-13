namespace Brasfoot.Core.Calendar;

/// <summary>
/// Template anual do calendário: a sequência de pares (dia da semana, tipo) de <c>best.a.g()</c>
/// (<c>best/a.java:249-500</c>) e a primitiva de posicionamento <c>b(int,int)</c>
/// (<c>best/a.java:222-247</c>). Ver spec-calendario §1.2.
/// </summary>
public static class CalendarTemplate
{
    /// <summary>
    /// As 250 chamadas <c>a.b(weekday, type)</c> de <c>g()</c>, na ordem exata do bytecode.
    /// Cada par reserva a próxima ocorrência livre daquele dia da semana.
    /// </summary>
    private static readonly (int Weekday, DayType Type)[] Sequence =
    [
        (1, DayType.AmistosoClube), (2, DayType.TorneioAmistoso), (3, DayType.TorneioAmistoso),
        (4, DayType.Regionais), (5, DayType.Regionais), (6, DayType.TorneioAmistoso),
        (7, DayType.Regionais), (1, DayType.Regionais), (2, DayType.Regionais),
        (3, DayType.Regionais), (4, DayType.Regionais), (5, DayType.Regionais),
        (6, DayType.TorneioAmistoso), (7, DayType.Regionais), (1, DayType.TorneioAmistoso),
        (2, DayType.Regionais), (3, DayType.AmistosoClube), (4, DayType.Regionais),
        (5, DayType.AmistosoClube), (6, DayType.Regionais), (7, DayType.AmistosoClube),
        (1, DayType.Estadual), (3, DayType.Estadual), (5, DayType.Estadual),
        (1, DayType.Estadual), (3, DayType.Estadual), (5, DayType.Estadual),
        (7, DayType.SuperCopa), (1, DayType.Estadual), (3, DayType.Estadual),
        (5, DayType.Estadual), (7, DayType.AmistosoSelecao), (1, DayType.Estadual),
        (3, DayType.Estadual), (5, DayType.Estadual), (1, DayType.Estadual),
        (3, DayType.Estadual), (5, DayType.Estadual), (1, DayType.Estadual),
        (3, DayType.Estadual), (4, DayType.Internacional1), (5, DayType.Estadual),
        (1, DayType.Estadual), (3, DayType.Estadual), (5, DayType.Internacional1),
        (1, DayType.Estadual), (3, DayType.Estadual), (5, DayType.Internacional1),
        (1, DayType.Estadual), (3, DayType.AmistosoClube), (4, DayType.Internacional1),
        (5, DayType.AmistosoSelecao), (1, DayType.Nacional), (2, DayType.AmistosoClube),
        (4, DayType.Internacional1), (6, DayType.ConferenceLeague),
        (1, DayType.Nacional), (2, DayType.AmistosoSelecao), (4, DayType.Internacional1),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (4, DayType.Internacional1),
        (6, DayType.Eliminatorias), (1, DayType.Nacional), (2, DayType.LigaNacoes),
        (4, DayType.Internacional1), (5, DayType.LigaNacoes), (6, DayType.ConferenceLeague),
        (7, DayType.AmistosoSelecao), (1, DayType.Nacional), (2, DayType.LigaNacoes),
        (3, DayType.CopaNacional), (5, DayType.Internacional1), (6, DayType.ConferenceLeague),
        (1, DayType.Nacional), (4, DayType.CopaNacional), (6, DayType.ConferenceLeague),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (4, DayType.Internacional1),
        (5, DayType.Internacional2), (1, DayType.Nacional), (4, DayType.Internacional1),
        (5, DayType.Internacional2), (7, DayType.AmistosoSelecao), (1, DayType.Nacional),
        (2, DayType.Eliminatorias), (4, DayType.Internacional1), (5, DayType.ConferenceLeague),
        (6, DayType.Eliminatorias), (1, DayType.Nacional), (3, DayType.CopaNacional),
        (4, DayType.Internacional1), (5, DayType.Internacional2), (6, DayType.LigaNacoes),
        (1, DayType.Nacional), (2, DayType.LigaNacoes), (3, DayType.CopaNacional),
        (5, DayType.Internacional2), (6, DayType.ConferenceLeague), (7, DayType.LigaNacoes),
        (1, DayType.Nacional), (3, DayType.AmistosoClube), (4, DayType.Internacional1),
        (5, DayType.Internacional2), (1, DayType.Nacional), (2, DayType.Eliminatorias),
        (4, DayType.Internacional1), (5, DayType.Internacional2), (7, DayType.AmistosoSelecao),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (4, DayType.CopaNacional),
        (5, DayType.ConferenceLeague), (6, DayType.Eliminatorias), (1, DayType.Nacional),
        (2, DayType.ConferenceLeague), (3, DayType.CopaNacional), (4, DayType.Internacional1),
        (5, DayType.Internacional2), (7, DayType.AmistosoSelecao), (1, DayType.Nacional),
        (2, DayType.Eliminatorias), (3, DayType.Internacional1), (4, DayType.Internacional2),
        (5, DayType.Selecoes), (7, DayType.Selecoes), (2, DayType.Selecoes),
        (4, DayType.Selecoes), (6, DayType.Selecoes), (1, DayType.Selecoes),
        (4, DayType.Selecoes), (1, DayType.Selecoes), (4, DayType.Nacional),
        (6, DayType.ConferenceLeague), (1, DayType.Nacional), (2, DayType.Finalissima),
        (3, DayType.AmistosoClube), (4, DayType.Internacional1), (5, DayType.Internacional2),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (3, DayType.CopaNacional),
        (5, DayType.Internacional2), (6, DayType.ConferenceLeague), (7, DayType.AmistosoSelecao),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (3, DayType.CopaNacional),
        (5, DayType.Internacional2), (6, DayType.ConferenceLeague), (7, DayType.Eliminatorias),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (4, DayType.Internacional1),
        (5, DayType.Internacional2), (6, DayType.Eliminatorias), (7, DayType.AmistosoSelecao),
        (1, DayType.Nacional), (2, DayType.Finalissima), (4, DayType.Internacional1),
        (5, DayType.Eliminatorias), (6, DayType.ConferenceLeague), (7, DayType.Eliminatorias),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (3, DayType.AmistosoClube),
        (4, DayType.Internacional1), (5, DayType.Nacional), (6, DayType.Eliminatorias),
        (1, DayType.Nacional), (2, DayType.LigaNacoes), (3, DayType.CopaNacional),
        (4, DayType.Internacional1), (5, DayType.Internacional2), (6, DayType.LigaNacoes),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (3, DayType.CopaNacional),
        (4, DayType.Internacional1), (5, DayType.Internacional2), (6, DayType.Eliminatorias),
        (1, DayType.Nacional), (2, DayType.Eliminatorias), (4, DayType.CopaNacional),
        (5, DayType.Internacional2), (6, DayType.ConferenceLeague), (7, DayType.AmistosoSelecao),
        (1, DayType.Nacional), (2, DayType.ConferenceLeague), (4, DayType.CopaNacional),
        (5, DayType.Internacional2), (6, DayType.ConferenceLeague), (1, DayType.Nacional),
        (2, DayType.ConferenceLeague), (4, DayType.CopaNacional), (2, DayType.LigaNacoes),
        (6, DayType.ConferenceLeague), (7, DayType.LigaNacoes), (1, DayType.Nacional),
        (2, DayType.Eliminatorias), (4, DayType.CopaNacional), (5, DayType.Internacional2),
        (6, DayType.ConferenceLeague), (1, DayType.Nacional), (2, DayType.Eliminatorias),
        (3, DayType.Recopa), (4, DayType.ConferenceLeague), (5, DayType.Nacional),
        (6, DayType.Eliminatorias), (1, DayType.Nacional), (3, DayType.Recopa),
        (4, DayType.Internacional2), (5, DayType.Nacional), (6, DayType.ConferenceLeague),
        (7, DayType.AmistosoSelecao), (1, DayType.Nacional), (2, DayType.Eliminatorias),
        (3, DayType.AmistosoClube), (4, DayType.Internacional2), (5, DayType.Nacional),
        (6, DayType.Eliminatorias), (1, DayType.Nacional), (2, DayType.Eliminatorias),
        (3, DayType.AmistosoClube), (4, DayType.Internacional2), (5, DayType.Nacional),
        (6, DayType.ConferenceLeague), (1, DayType.Nacional), (2, DayType.ConferenceLeague),
        (3, DayType.Nacional), (4, DayType.Eliminatorias), (5, DayType.Nacional),
        (6, DayType.ConferenceLeague), (7, DayType.Nacional), (1, DayType.Nacional),
        (2, DayType.Nacional), (3, DayType.Nacional), (4, DayType.Nacional),
        (5, DayType.Nacional), (6, DayType.Nacional), (7, DayType.Nacional),
        (1, DayType.Nacional), (2, DayType.Nacional), (3, DayType.Nacional),
        (4, DayType.Nacional), (5, DayType.Nacional), (6, DayType.Mundial),
        (7, DayType.Mundial), (2, DayType.Mundial),
    ];

    public static int SequenceLength => Sequence.Length;

    /// <summary>
    /// Aplica o template a um ano já montado (um <see cref="CalendarDay"/> por dia do ano),
    /// a partir do índice <paramref name="startIndex"/> (primeiro domingo de janeiro,
    /// <c>SR.J()</c> no momento da montagem). Replica <c>best.a.g()</c> + <c>b(int,int)</c>.
    /// </summary>
    public static void Apply(IReadOnlyList<CalendarDay> days, int startIndex)
    {
        foreach (var (weekday, type) in Sequence)
        {
            // n5 = último índice já tipado (busca do fim), com piso em SR.J().
            var last = -1;
            for (var i = days.Count - 1; i > 0; i--)
            {
                if (days[i].Type != DayType.Nenhum)
                {
                    last = i;
                    break;
                }
            }
            if (last < startIndex) last = startIndex;

            // primeiro dia livre do dia da semana pedido a partir de n5.
            var found = -1;
            for (var i = last; i < days.Count; i++)
            {
                if (days[i].Type == DayType.Nenhum && days[i].Date.JavaWeekday() == weekday)
                {
                    found = i;
                    break;
                }
            }

            // o original só atribui quando o índice encontrado é > 0 (quirk: índice 0 nunca é tipado).
            if (found > 0) days[found].Type = type;
        }
    }
}
