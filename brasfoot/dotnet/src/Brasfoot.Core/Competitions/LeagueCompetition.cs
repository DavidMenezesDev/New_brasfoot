using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Uma liga de pontos corridos (subconjunto de <c>f.s</c>): times, tabela de rodízio, classificação
/// e agendamento das rodadas nos dias livres do tipo da competição. A montagem dos jogos no
/// calendário reproduz <c>f.s.a()</c> (<c>f/s.java:672-688</c>) e a acumulação de resultados,
/// <c>f.s.pO()</c> (<c>f/s.java:1006-1012</c>).
/// </summary>
public sealed class LeagueCompetition
{
    private readonly HashSet<Match> _recorded = new();

    public LeagueCompetition(Competition competition, IEnumerable<Team> teams, List<List<Fixture>> rounds)
    {
        Competition = competition;
        Teams = teams.ToList();
        Rounds = rounds;
        Table = new LeagueTable(Teams);
        TotalMatches = rounds.Sum(r => r.Count);
    }

    public Competition Competition { get; }
    public List<Team> Teams { get; }
    public List<List<Fixture>> Rounds { get; }
    public LeagueTable Table { get; }

    /// <summary><c>f.s.yF()</c>: índice de calendário de cada rodada, na ordem em que foi agendada.</summary>
    public List<int> DayIndexes { get; } = new();

    public int TotalMatches { get; }

    /// <summary>Todas as partidas da competição já foram disputadas e contabilizadas.</summary>
    public bool IsComplete => TotalMatches > 0 && _recorded.Count >= TotalMatches;

    /// <summary>Classificação corrente (<c>f.s.Zb</c> ordenado por <c>h.K</c>).</summary>
    public List<TeamStanding> Standing => Table.Ordered();

    /// <summary>Campeão, quando a competição terminou.</summary>
    public TeamStanding? Champion => IsComplete ? Standing.FirstOrDefault() : null;

    /// <summary>
    /// Posições finais da temporada para uma liga sem mata-mata (<c>f/s.za</c>, ramo sem
    /// <c>Zc</c>/knockout — <c>f/s.java:1569-1577</c>): a posição na tabela (1-based), na ordem de
    /// <c>h.K</c>.
    /// </summary>
    public IReadOnlyList<(Team Team, int Position)> FinalPositions() =>
        Standing.Select((row, i) => (row.Team, i + 1)).ToList();

    /// <summary>
    /// Agenda as rodadas nos dias livres do tipo da competição (<c>best.a.a(type, pulaDuasDatas)</c>),
    /// criando um <see cref="Match"/> por confronto no dia correspondente.
    /// </summary>
    public void ScheduleOn(SeasonCalendar calendar, IGameRandom random, bool skipTwoDays = false)
    {
        var dayType = CalendarDay.CompetitionToDay(Competition.Type);
        var days = calendar.FreeIndexesOfType(dayType, skipTwoDays);
        if (days.Count < Rounds.Count)
        {
            throw new InvalidOperationException(
                $"Calendário tem {days.Count} dias livres de {dayType} para {Rounds.Count} rodadas de {Competition.Name}.");
        }

        for (var r = 0; r < Rounds.Count; r++)
        {
            var index = days[r];
            DayIndexes.Add(index);
            var day = calendar.Days[index];
            if (!day.Leagues.Contains(this)) day.Leagues.Add(this);

            foreach (var fixture in Rounds[r])
                day.Matches.Add(new Match(Teams[fixture.Home], Teams[fixture.Away], Competition, random));
        }
    }

    /// <summary>
    /// Contabiliza os resultados dos jogos deste dia (<c>ah.a(I, s)</c>). Cada partida é contada uma
    /// única vez, mesmo que o dia seja processado em lote por várias datas.
    /// </summary>
    public int RecordResults(CalendarDay day)
    {
        var counted = 0;
        foreach (var match in day.Matches)
        {
            if (!ReferenceEquals(match.Competition, Competition)) continue;
            if (!match.IsFinished) continue;
            if (!_recorded.Add(match)) continue;
            Table.Apply(match.Home, match.Score[0], match.Away, match.Score[1]);
            counted++;
        }
        return counted;
    }

    /// <summary>Marca a competição no dia de cada rodada, para o despacho de <c>best.f.aB()</c>.</summary>
    public IEnumerable<int> ScheduledDays => DayIndexes;
}
