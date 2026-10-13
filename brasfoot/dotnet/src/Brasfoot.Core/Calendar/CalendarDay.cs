using System.Text.Json.Serialization;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.Core.Calendar;

/// <summary>
/// Um dia do calendário (<c>best.a</c>): data, tipo, flag "usado" e as duas filas de eventos.
/// A lista de jogos/competições do dia é transiente (recriada a cada temporada por <c>clear()</c>).
/// </summary>
public sealed class CalendarDay
{
    public DateOnly Date { get; set; }

    /// <summary>Tipo do dia (<c>w</c> em <c>best/a.java:36</c>); <see cref="DayType.Nenhum"/> = livre.</summary>
    public DayType Type { get; set; }

    /// <summary>Marcado como consumido (<c>v</c>, <c>aM()</c>) — dias pulados até o próximo jogo.</summary>
    public bool Used { get; set; }

    /// <summary>Fila pós-jogo (campo <c>q</c> de <c>best.a</c>, agendada com <c>queue=0</c>).</summary>
    public List<DayEvent> QueueAfterMatch { get; set; } = new();

    /// <summary>Fila de fim de dia (campo <c>r</c>, agendada com <c>queue=1</c>).</summary>
    public List<DayEvent> QueueEndOfDay { get; set; } = new();

    /// <summary>Jogos do dia (<c>s</c>). Transiente: recomposto pelas competições (Fase 3).</summary>
    [JsonIgnore]
    public List<Match> Matches { get; set; } = new();

    /// <summary>Competições liga/KO registradas no dia (<c>t</c>). Transiente (Fase 3).</summary>
    [JsonIgnore]
    public List<object> Leagues { get; set; } = new();

    /// <summary>Competições <c>at</c> registradas no dia (<c>u</c>). Transiente (Fase 3).</summary>
    [JsonIgnore]
    public List<object> Competitions { get; set; } = new();

    /// <summary>Dia livre (sem tipo), <c>best/a.java:86</c>.</summary>
    [JsonIgnore]
    public bool IsFree => Type == DayType.Nenhum;

    /// <summary>
    /// Tipo do primeiro jogo do dia (<c>best.a.i()</c>, <c>best/a.java:506-512</c>); 0 se não há jogos.
    /// </summary>
    [JsonIgnore]
    public DayType FirstMatchType => Matches.Count > 0 ? CompetitionToDay(Matches[0].Competition.Type) : DayType.Nenhum;

    public bool Involves(Team team) => Matches.Any(m => ReferenceEquals(m.Home, team) || ReferenceEquals(m.Away, team));

    public void Clear()
    {
        Matches.Clear();
        Leagues.Clear();
        Competitions.Clear();
    }

    /// <summary>Converte o tipo de competição (<c>at.b()</c>) em tipo de dia; valores 1..15 coincidem.</summary>
    public static DayType CompetitionToDay(CompetitionType type) => (DayType)(int)type;

    public override string ToString() => $"{Date:yyyy-MM-dd} {Type}";
}
