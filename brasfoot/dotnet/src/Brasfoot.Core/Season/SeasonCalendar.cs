using System.Text.Json.Serialization;
using Brasfoot.Core.Calendar;

namespace Brasfoot.Core.Season;

/// <summary>
/// Calendário de uma temporada (<c>best.f.as</c> / lista <c>R()</c> de <c>best.a</c>): os dias do ano
/// com seus tipos e as consultas de posicionamento de <c>best.a</c> (<c>best/a.java:94-247</c>).
/// </summary>
public sealed class SeasonCalendar
{
    /// <summary>Dias do ano, em ordem cronológica (um <c>best.a</c> por dia).</summary>
    public List<CalendarDay> Days { get; set; } = new();

    /// <summary>Dia corrente (<c>SR.af</c>, <c>best.f.l(int)</c>).</summary>
    public int CurrentIndex { get; set; }

    /// <summary>Ano civil dos dias.</summary>
    public int Year { get; set; }

    [JsonIgnore]
    public int Count => Days.Count;

    [JsonIgnore]
    public CalendarDay? Current => CurrentIndex >= 0 && CurrentIndex < Days.Count ? Days[CurrentIndex] : null;

    // ---- Consultas (best.a) --------------------------------------------------

    /// <summary><c>best.a.b(int)</c>: índices cujo tipo é <paramref name="type"/>.</summary>
    public List<int> IndexesOfType(DayType type) =>
        Enumerable.Range(0, Days.Count).Where(i => Days[i].Type == type).ToList();

    /// <summary><c>best.a.c(int)</c>: índices cujo dia da semana é <paramref name="weekday"/> (1=domingo..7=sábado).</summary>
    public List<int> IndexesOfWeekday(int weekday) =>
        Enumerable.Range(0, Days.Count).Where(i => Days[i].Date.JavaWeekday() == weekday).ToList();

    /// <summary><c>best.a.d()</c>: índices no dia 2 de cada mês.</summary>
    public List<int> IndexesOnDayOfMonth2() =>
        Enumerable.Range(0, Days.Count).Where(i => Days[i].Date.Day == 2).ToList();

    /// <summary><c>best.a.d(int)</c>: último índice com o tipo, ou -1.</summary>
    public int LastIndexOfType(DayType type)
    {
        for (var i = Days.Count - 1; i >= 0; i--)
            if (Days[i].Type == type) return i;
        return -1;
    }

    /// <summary><c>best.a.e(int)</c>: primeiro índice com o tipo, ou -1.</summary>
    public int FirstIndexOfType(DayType type)
    {
        for (var i = 0; i < Days.Count; i++)
            if (Days[i].Type == type) return i;
        return -1;
    }

    /// <summary><c>best.a.a(int,int)</c>: n-ésimo (1-based) índice do tipo, ou -1.</summary>
    public int NthIndexOfType(DayType type, int n)
    {
        var seen = 1;
        for (var i = 0; i < Days.Count; i++)
        {
            if (Days[i].Type != type) continue;
            if (seen == n) return i;
            seen++;
        }
        return -1;
    }

    /// <summary>
    /// <c>best.a.a(int,boolean)</c>: índices livres (não usados) do tipo; se
    /// <paramref name="skipTwo"/> pula os dois primeiros.
    /// </summary>
    public List<int> FreeIndexesOfType(DayType type, bool skipTwo = false)
    {
        var result = new List<int>();
        var skip = skipTwo ? 2 : 0;
        for (var i = 0; i < Days.Count; i++)
        {
            if (Days[i].Type != type || Days[i].Used) continue;
            if (skip <= 0) result.Add(i);
            if (skip > 0) skip--;
        }
        return result;
    }

    // ---- Mutação -------------------------------------------------------------

    /// <summary><c>best.a.aM()</c>: marca como usados todos os dias de 0 a <see cref="CurrentIndex"/>.</summary>
    public void MarkUsedThroughCurrent()
    {
        for (var i = 0; i <= CurrentIndex && i < Days.Count; i++) Days[i].Used = true;
    }

    /// <summary>
    /// <c>best.f.az()</c> (<c>best/f.java:1687-1697</c>): primeiro dia a partir do corrente que
    /// não está usado, tem tipo e jogos. Move <see cref="CurrentIndex"/> e devolve o índice, ou 0 se acabou.
    /// </summary>
    public int NextMatchIndex()
    {
        for (var i = CurrentIndex; i < Days.Count; i++)
        {
            var day = Days[i];
            if (day.Used || day.Type == DayType.Nenhum || day.Matches.Count == 0) continue;
            CurrentIndex = i;
            return i;
        }
        return 0;
    }

    /// <summary><c>best.a.b(int,int,int)</c>: agenda o evento na fila do dia, na fila definida por <see cref="DayEvents.QueueOf"/>.</summary>
    public void Schedule(int index, DayEvent dayEvent)
    {
        if (index < 0 || index >= Days.Count) return;
        (DayEvents.QueueOf(dayEvent) == 0 ? Days[index].QueueAfterMatch : Days[index].QueueEndOfDay).Add(dayEvent);
    }
}
