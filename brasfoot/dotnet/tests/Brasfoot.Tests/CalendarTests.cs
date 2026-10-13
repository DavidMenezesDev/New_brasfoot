using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Tests;

public class CalendarTests
{
    private static (GameSession Session, GameState State) NewSession(int year = 2022, bool mensal = true)
    {
        var world = new World();
        world.Teams.Add(TestData.Team("Casa", 60));
        world.Teams.Add(TestData.Team("Fora", 55));
        var state = GameState.FromWorld(world, new GameOptions { SalarioMensal = mensal });
        state.BaseYear = year;
        var session = new GameSession(state, TestData.Context());
        session.BuildSeasonCalendar();
        return (session, state);
    }

    [Fact]
    public void Template_2022_matches_original_quirk()
    {
        var (session, _) = NewSession(2022);
        var days = session.Days;

        Assert.Equal(365, days.Count);
        Assert.Equal(1, session.Calendar.CurrentIndex);           // 1º domingo = 02/01/2022
        Assert.Equal(new DateOnly(2022, 1, 2), days[1].Date);
        Assert.Equal(250, days.Count(d => d.Type != DayType.Nenhum));
        Assert.Equal(115, days.Count(d => d.Type == DayType.Nenhum));
        Assert.Equal(DayType.AmistosoClube, days[1].Type);
        Assert.Equal(359, session.Calendar.LastIndexOfType(DayType.Mundial));

        var counts = days.Where(d => d.Type != DayType.Nenhum)
            .GroupBy(d => d.Type).ToDictionary(g => g.Key, g => g.Count());
        Assert.Equal(54, counts[DayType.Nacional]);
        Assert.Equal(14, counts[DayType.CopaNacional]);
        Assert.Equal(23, counts[DayType.Estadual]);
        Assert.Equal(23, counts[DayType.Internacional1]);
        Assert.Equal(3, counts[DayType.Mundial]);
        Assert.Equal(20, counts[DayType.Internacional2]);
        Assert.Equal(8, counts[DayType.Selecoes]);
        Assert.Equal(2, counts[DayType.Recopa]);
        Assert.Equal(28, counts[DayType.Eliminatorias]);
        Assert.Equal(12, counts[DayType.Regionais]);
        Assert.Equal(1, counts[DayType.SuperCopa]);
        Assert.Equal(23, counts[DayType.ConferenceLeague]);
        Assert.Equal(2, counts[DayType.Finalissima]);
        Assert.Equal(10, counts[DayType.LigaNacoes]);
        Assert.Equal(5, counts[DayType.TorneioAmistoso]);
        Assert.Equal(11, counts[DayType.AmistosoClube]);
        Assert.Equal(11, counts[DayType.AmistosoSelecao]);
    }

    [Fact]
    public void Template_index_zero_is_never_typed()
    {
        // 2023 começa num domingo: o índice 0 nunca é tipado (quirk de b(int,int) com `found > 0`).
        var (session, _) = NewSession(2023);
        Assert.Equal(0, session.Calendar.CurrentIndex);
        Assert.Equal(DayType.Nenhum, session.Days[0].Type);
        Assert.Equal(249, session.Days.Count(d => d.Type != DayType.Nenhum));
        Assert.Equal(DayType.TorneioAmistoso, session.Days[1].Type); // 02/01/2023 (segunda)
    }

    [Fact]
    public void Calendar_queries_match_best_a()
    {
        var (session, _) = NewSession(2022);
        var cal = session.Calendar;

        Assert.Equal(cal.IndexesOfType(DayType.CopaNacional)[1], cal.NthIndexOfType(DayType.CopaNacional, 2));
        Assert.Equal(cal.IndexesOfType(DayType.Estadual)[0], cal.FirstIndexOfType(DayType.Estadual));
        Assert.Equal(cal.IndexesOfType(DayType.Mundial)[^1], cal.LastIndexOfType(DayType.Mundial));
        Assert.Equal(-1, cal.NthIndexOfType(DayType.SuperCopa, 2));
        Assert.Equal(12, cal.IndexesOnDayOfMonth2().Count);       // um dia 2 por mês
        Assert.All(cal.IndexesOnDayOfMonth2(), i => Assert.Equal(2, cal.Days[i].Date.Day));
        Assert.All(cal.IndexesOfWeekday(1), i => Assert.Equal(DayOfWeek.Sunday, cal.Days[i].Date.DayOfWeek));
    }

    [Fact]
    public void Free_days_skip_used_and_optional_first_two()
    {
        var (session, _) = NewSession(2022);
        var cal = session.Calendar;
        var all = cal.IndexesOfType(DayType.Nacional);

        Assert.Equal(all, cal.FreeIndexesOfType(DayType.Nacional));
        Assert.Equal(all.Skip(2), cal.FreeIndexesOfType(DayType.Nacional, skipTwo: true));

        cal.Days[all[0]].Used = true;
        var free = cal.FreeIndexesOfType(DayType.Nacional);
        Assert.DoesNotContain(all[0], free);
        Assert.Equal(all.Count - 1, free.Count);
    }

    [Fact]
    public void Weekly_seed_places_salary_interest_and_evolution()
    {
        var (session, _) = NewSession(2022, mensal: true);
        var cal = session.Calendar;

        // mensal: salários no dia 2; juros no dia 2; evolução nos domingos — tudo na fila pós-jogo.
        foreach (var i in cal.IndexesOnDayOfMonth2())
        {
            Assert.Contains(DayEvent.Salarios, cal.Days[i].QueueAfterMatch);
            Assert.Contains(DayEvent.JurosEmprestimo, cal.Days[i].QueueAfterMatch);
        }
        foreach (var i in cal.IndexesOfWeekday(1))
            Assert.Contains(DayEvent.EvolucaoSemanal, cal.Days[i].QueueAfterMatch);

        // salário semanal: cai exatamente nos domingos (que podem coincidir com o dia 2).
        var (weekly, _) = NewSession(2022, mensal: false);
        foreach (var day in weekly.Calendar.Days)
        {
            var salary = day.QueueAfterMatch.Contains(DayEvent.Salarios);
            Assert.Equal(day.Date.DayOfWeek == DayOfWeek.Sunday, salary);
        }
        Assert.Contains(weekly.Calendar.Days[1].QueueAfterMatch, e => e == DayEvent.Salarios); // 02/01 é domingo
    }

    [Fact]
    public void National_team_seed_places_events_on_end_of_day_queue()
    {
        var (session, _) = NewSession(2022);
        var cal = session.Calendar;

        var selecoes = cal.FirstIndexOfType(DayType.Selecoes);
        Assert.Contains(DayEvent.ConvocacaoSelecao, cal.Days[selecoes].QueueEndOfDay);
        Assert.Contains(DayEvent.ConvocacaoTodasSelecoes, cal.Days[selecoes].QueueEndOfDay);

        var nacional1 = cal.NthIndexOfType(DayType.Nacional, 1);
        Assert.Contains(DayEvent.ConvocacaoForcada, cal.Days[nacional1].QueueEndOfDay);

        var nacional20 = cal.NthIndexOfType(DayType.Nacional, 20);
        Assert.Contains(DayEvent.Promocao, cal.Days[nacional20].QueueEndOfDay);

        Assert.All(cal.Days, d => Assert.DoesNotContain(DayEvent.ConvocacaoSelecao, d.QueueAfterMatch));
    }

    [Fact]
    public void AdvanceToNextMatchDay_plays_matches_and_ends_season()
    {
        var (session, state) = NewSession(2022);
        var cal = session.Calendar;
        var comp = new Competition(1, "Brasileirão", CompetitionType.Nacional);

        // injeta jogos no dia corrente (02/01, índice 1) e num dia tipado à frente (Fase 3 fará isso).
        var later = cal.IndexesOfType(DayType.Nacional)[10];
        cal.Days[1].Matches.Add(new Match(state.World.Teams[0], state.World.Teams[1], comp, TestData.Context().Random));
        cal.Days[later].Matches.Add(new Match(state.World.Teams[1], state.World.Teams[0], comp, TestData.Context().Random));

        Assert.False(session.SeasonEnded);
        session.AdvanceToNextMatchDay();
        Assert.True(cal.Days[1].Matches[0].IsFinished);
        Assert.Equal(later, cal.CurrentIndex);           // az() saltou para o próximo dia com jogo
        Assert.False(session.SeasonEnded);
        Assert.Equal(cal.Days[later].Date, state.Today);

        session.AdvanceToNextMatchDay();
        Assert.True(cal.Days[later].Matches[0].IsFinished);
        Assert.True(session.SeasonEnded);
    }

    [Fact]
    public void AdvanceWithNoMatches_ends_season_immediately()
    {
        var (session, _) = NewSession(2022);
        Assert.False(session.SeasonEnded);
        session.AdvanceToNextMatchDay();
        Assert.True(session.SeasonEnded);
    }

    [Fact]
    public void Salary_event_charges_payroll_only_when_club_plays_that_month()
    {
        var (session, state) = NewSession(2022, mensal: true);
        var cal = session.Calendar;
        var comp = new Competition(1, "Brasileirão", CompetitionType.Nacional);
        var home = state.World.Teams[0];
        var away = state.World.Teams[1];

        // jogo em 02/01 (índice 1) — os dois clubes jogam em janeiro.
        cal.Days[1].Matches.Add(new Match(home, away, comp, TestData.Context().Random));

        var homeBefore = home.Cash;
        var awayBefore = away.Cash;
        session.AdvanceToNextMatchDay();

        Assert.Equal(homeBefore - home.Payroll, home.Cash);
        Assert.Equal(awayBefore - away.Payroll, away.Cash);
        Assert.DoesNotContain(DayEvent.Salarios, cal.Days[1].QueueAfterMatch); // fila consumida
    }

    [Fact]
    public void Payroll_sums_senior_and_junior_salaries()
    {
        var team = TestData.Team("Clube", 50);
        team.Juniors.Add(TestData.Player(team, Position.Meia, 40));
        team.Juniors[0].Salary = 7_500;
        Assert.Equal(team.Squad.Sum(p => p.Salary) + 7_500, team.Payroll);
    }

    [Fact]
    public void DayType_display_and_weekday_follow_original()
    {
        Assert.Equal("Nacional", DayType.Nacional.DisplayName());
        Assert.Equal("Conference League", DayType.ConferenceLeague.DisplayName());
        Assert.Equal("Amistoso", DayType.AmistosoClube.DisplayName());
        Assert.Equal("", DayType.Nenhum.DisplayName());
        Assert.Equal(1, new DateOnly(2022, 1, 2).JavaWeekday());  // domingo
        Assert.Equal(7, new DateOnly(2022, 1, 1).JavaWeekday());  // sábado
    }

    [Fact]
    public void Calendar_survives_save_roundtrip()
    {
        var (session, state) = NewSession(2022);
        var bytes = Brasfoot.Data.Saves.SaveGame.Serialize(state);
        var loaded = Brasfoot.Data.Saves.SaveGame.Deserialize(bytes);

        Assert.Equal(365, loaded.Calendar.Days.Count);
        Assert.Equal(session.Calendar.CurrentIndex, loaded.Calendar.CurrentIndex);
        Assert.Equal(250, loaded.Calendar.Days.Count(d => d.Type != DayType.Nenhum));
        Assert.Equal(DayType.AmistosoClube, loaded.Calendar.Days[1].Type);
        Assert.Contains(DayEvent.Salarios, loaded.Calendar.Days[1].QueueAfterMatch);
        var selecoes = session.Calendar.FirstIndexOfType(DayType.Selecoes);
        Assert.Contains(DayEvent.ConvocacaoTodasSelecoes, loaded.Calendar.Days[selecoes].QueueEndOfDay);
    }
}
