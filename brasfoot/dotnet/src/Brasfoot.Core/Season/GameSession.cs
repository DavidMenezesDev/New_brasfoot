using Brasfoot.Core.Calendar;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.Core.Season;

/// <summary>
/// Sessão de uma temporada: monta o calendário e executa o laço de dias de <c>best.f</c>
/// (<c>ap</c> → ao vivo → <c>at</c> → <c>ax</c>). Ver <c>re/spec-calendario-competicoes.md</c> §1–2.
/// </summary>
public sealed class GameSession
{
    public GameSession(GameState state, GameContext context, SeasonHooks? hooks = null)
    {
        State = state;
        Context = context;
        Hooks = hooks ?? new SeasonHooks();
        Context.Season = state.Season;
        Context.Today = state.Today;
    }

    public GameState State { get; }
    public GameContext Context { get; }
    public SeasonHooks Hooks { get; }

    public SeasonCalendar Calendar => State.Calendar;
    public IReadOnlyList<CalendarDay> Days => Calendar.Days;

    /// <summary>Dia corrente (<c>SR.J()</c>).</summary>
    public CalendarDay CurrentDay => Calendar.Days[Calendar.CurrentIndex];

    /// <summary>Fim de temporada alcançado (<c>bk</c>): o próximo avanço dispara a virada.</summary>
    public bool SeasonEnded { get; private set; }

    /// <summary>Competições liga agendadas nesta temporada (Fase 3).</summary>
    public List<LeagueCompetition> Leagues { get; } = new();

    /// <summary>
    /// Copas (e Supercopa) agendadas nos dias livres da temporada (Fase 4,
    /// <see cref="Competitions.CupCompetition"/>) — substitui, para o laço de dias, o uso isolado que
    /// o CLI faz de <see cref="CupDraw"/>/<see cref="KnockoutBracket.PlayAll"/>.
    /// </summary>
    public List<CupCompetition> Cups { get; } = new();

    /// <summary>
    /// Competições em duas fases (estaduais, regionais, Torneio Amistoso) agendadas na temporada
    /// (Fase 4, <see cref="Competitions.PhasedCompetition"/>). As ligas da 1ª fase entram em
    /// <see cref="Leagues"/>; o mata-mata é gerenciado pelo próprio objeto.
    /// </summary>
    public List<PhasedCompetition> Phased { get; } = new();

    /// <summary>
    /// Copas do Brasil agendadas na temporada (Fase 4, <see cref="Competitions.CopaDoBrasilCompetition"/>):
    /// formato de potes com reordenação por força entre fases, que <see cref="Cups"/> não cobre.
    /// </summary>
    public List<CopaDoBrasilCompetition> BrasilCup { get; } = new();

    /// <summary>
    /// Federações estaduais ativas da temporada (<c>best.w</c>), criadas por
    /// <see cref="Competitions.SeasonBuilder.CreateStateChampionships"/>. Guardam as divisões para a
    /// liquidação de acesso/rebaixamento no fim da temporada.
    /// </summary>
    public List<StateFederation> StateFederations { get; } = new();

    /// <summary>Ano civil da temporada corrente (<c>op() + ae - 1</c>, <c>best/f.java:1208</c>).</summary>
    public int Year => State.BaseYear + (State.Season - 1);

    // ---- Montagem do calendário (best.f.ah()) -------------------------------

    /// <summary>
    /// Monta o calendário do ano corrente: um dia por data, dia corrente no primeiro domingo de
    /// janeiro, então o template (<c>a.g()</c>) e as sementes semanais/seleções. <c>best.f.r(int)</c>
    /// + <c>a.g()</c> + <c>a.q()</c>.
    /// </summary>
    public void BuildSeasonCalendar()
    {
        SeasonEnded = false;
        var year = Year;
        var days = new List<CalendarDay>();
        for (var date = new DateOnly(year, 1, 1); date.Year == year; date = date.AddDays(1))
            days.Add(new CalendarDay { Date = date });

        var firstSunday = days.FindIndex(d => d.Date.Month == 1 && d.Date.JavaWeekday() == 1);
        if (firstSunday < 0) firstSunday = 0;

        Calendar.Days = days;
        Calendar.CurrentIndex = firstSunday;
        Calendar.Year = year;

        SeedWeeklyEvents();               // aS()
        CalendarTemplate.Apply(days, firstSunday); // a.g()
        SeedNationalTeamEvents();         // a.q()
        Hooks.BuildCompetitions(this);    // criação das competições do ano (Fase 3)

        State.Today = CurrentDay.Date;
        Context.Today = State.Today;
        Context.Season = State.Season;
    }

    /// <summary>
    /// <c>best.f.aS()</c> (<c>best/f.java:1944-1964</c>): agenda salários (dia 2 se mensal, senão
    /// domingos), juros (dia 2) e evolução semanal (domingos), todos na fila pós-jogo.
    /// </summary>
    public void SeedWeeklyEvents()
    {
        var day2 = Calendar.IndexesOnDayOfMonth2();
        var sundays = Calendar.IndexesOfWeekday(1);
        var salaryDays = State.Options.SalarioMensal ? day2 : sundays;

        foreach (var i in salaryDays) Calendar.Schedule(i, DayEvent.Salarios);
        foreach (var i in day2) Calendar.Schedule(i, DayEvent.JurosEmprestimo);
        foreach (var i in sundays) Calendar.Schedule(i, DayEvent.EvolucaoSemanal);
    }

    /// <summary>
    /// <c>best.a.q()</c> (<c>best/a.java:735-764</c>): agenda convocações de seleções e a promoção,
    /// na fila de fim de dia. Requer o template já aplicado (depende dos tipos).
    /// </summary>
    public void SeedNationalTeamEvents()
    {
        if (State.Options.JogaSelecoesAll)
        {
            if (State.Options.JogaEstadual)
            {
                var estadual4 = Calendar.NthIndexOfType(DayType.Estadual, 4);
                if (estadual4 > 0) Calendar.Schedule(estadual4, DayEvent.ConvocacaoSelecao);
            }

            var nacional1 = Calendar.NthIndexOfType(DayType.Nacional, 1);
            if (nacional1 > 0) Calendar.Schedule(nacional1, DayEvent.ConvocacaoForcada);

            var selecoes1 = Calendar.FirstIndexOfType(DayType.Selecoes);
            if (selecoes1 > 0)
            {
                Calendar.Schedule(selecoes1, DayEvent.ConvocacaoSelecao);
                Calendar.Schedule(selecoes1, DayEvent.ConvocacaoTodasSelecoes);
            }

            var nacional12 = Calendar.NthIndexOfType(DayType.Nacional, 12);
            if (nacional12 > 0) Calendar.Schedule(nacional12, DayEvent.ConvocacaoSelecao);

            var nacional18 = Calendar.NthIndexOfType(DayType.Nacional, 18);
            if (nacional18 > 0) Calendar.Schedule(nacional18, DayEvent.ConvocacaoSelecao);
        }

        var nacional20 = Calendar.NthIndexOfType(DayType.Nacional, 20);
        if (nacional20 > 0) Calendar.Schedule(nacional20, DayEvent.Promocao);

        // best/f.java:543-544: com os regionais ligados (ou a carreira completa, bc), a criação da
        // Série D / Copa do Brasil ("cD") cai no primeiro dia Nacional, na fila de fim de dia.
        if (State.Options.JogaRegionais)
        {
            var primeiroNacional = Calendar.FirstIndexOfType(DayType.Nacional);
            if (primeiroNacional > 0) Calendar.Schedule(primeiroNacional, DayEvent.CriaSerieDCopa);
        }
    }

    // ---- Laço de dias --------------------------------------------------------

    /// <summary>
    /// Avança um dia de jogo. <c>best.f.V()</c>: se a temporada acabou, dispara a virada; senão
    /// executa <c>ap()</c>.
    /// </summary>
    public void AdvanceToNextMatchDay()
    {
        if (SeasonEnded)
        {
            Hooks.SeasonRollover(this);
            return;
        }
        AdvanceDay();
    }

    /// <summary><c>best.f.ap()</c>: posiciona o dia e o joga (sem a parte de interface humana).</summary>
    private void AdvanceDay()
    {
        State.Today = CurrentDay.Date;
        Context.Today = State.Today;

        At();
    }

    /// <summary>
    /// <c>best.f.at()</c> (<c>best/f.java:1524-1536</c>): joga os jogos do dia, marca os dias
    /// consumidos, avança as competições e roda a fila pós-jogo; em seguida <c>ax()</c>.
    /// </summary>
    private void At()
    {
        PlayDay();
        Calendar.MarkUsedThroughCurrent();
        RecordLeagueResults();
        RecordCupResults();
        RecordPhasedResults();
        RecordCopaDoBrasilResults();
        Hooks.AdvanceCompetitions(this, CurrentDay);
        DispatchQueue(afterMatch: true);
        Ax();
    }

    /// <summary>
    /// <c>f.s.pO()</c> (<c>f/s.java:1006-1012</c>): contabiliza nos classificadores os jogos do dia e
    /// reordena as tabelas. Fase 3.
    /// </summary>
    public void RecordLeagueResults()
    {
        foreach (var league in Leagues) league.RecordResults(CurrentDay);
    }

    /// <summary>
    /// Contabiliza os jogos do dia das copas/Supercopa agendadas e avança suas chaves (cria a volta da
    /// fase corrente, ou resolve e agenda a fase seguinte). Fase 4: análogo a
    /// <see cref="RecordLeagueResults"/>, mas para <see cref="Competitions.CupCompetition"/>.
    /// </summary>
    public void RecordCupResults()
    {
        foreach (var cup in Cups)
        {
            cup.RecordResults(CurrentDay);
            cup.AdvanceAfterDay(Calendar, Context);
        }
    }

    /// <summary>
    /// Contabiliza e avança as competições em duas fases (<see cref="PhasedCompetition"/>): a 1ª fase é
    /// registrada pelas ligas em <see cref="RecordLeagueResults"/>; aqui o mata-mata é contabilizado e,
    /// quando a fase de grupos termina, a chave é criada e agendada nos dias já reservados.
    /// </summary>
    public void RecordPhasedResults()
    {
        foreach (var phased in Phased)
        {
            phased.RecordResults(CurrentDay);
            phased.AdvanceAfterDay(Calendar, Context);
        }
    }

    /// <summary>
    /// Contabiliza e avança as Copas do Brasil (<see cref="CopaDoBrasilCompetition"/>): análogo a
    /// <see cref="RecordCupResults"/>, mas com a reordenação por força entre as fases.
    /// </summary>
    public void RecordCopaDoBrasilResults()
    {
        foreach (var copa in BrasilCup)
        {
            copa.RecordResults(CurrentDay);
            copa.AdvanceAfterDay(Calendar, Context);
        }
    }

    /// <summary><c>best.f.as()</c>: joga os jogos do dia (motor + pós-jogo + recuperação).</summary>
    private void PlayDay()
    {
        if (CurrentDay.Matches.Count > 0)
            MatchSimulator.PlayRound(CurrentDay.Matches, State.World.Teams, Context);
    }

    /// <summary>
    /// <c>best.f.ax()</c> (<c>best/f.java:1628-1658</c>): mercado de técnicos no tipo 1/3, escolhe o
    /// próximo dia de jogo (<c>az()</c>), roda a fila de fim de dia e marca o fim da temporada.
    /// </summary>
    private void Ax()
    {
        var type = CurrentDay.FirstMatchType;
        if (type is DayType.Nacional or DayType.Estadual)
            Hooks.ManagerMarket(this, type);

        var next = Calendar.NextMatchIndex();
        Hooks.EndOfDay(this);
        DispatchQueue(afterMatch: false);

        if (next == 0) SeasonEnded = true;

        State.Today = CurrentDay.Date;
        Context.Today = State.Today;
    }

    /// <summary>
    /// <c>best.f.q(int)</c> (<c>best/f.java:1860-1878</c>): percorre os dias 0..corrente e dispara a
    /// fila escolhida, limpando-a. Replica o processamento "em lote" do original.
    /// </summary>
    private void DispatchQueue(bool afterMatch)
    {
        for (var i = 0; i <= Calendar.CurrentIndex && i < Calendar.Days.Count; i++)
        {
            var day = Calendar.Days[i];
            var queue = afterMatch ? day.QueueAfterMatch : day.QueueEndOfDay;
            if (queue.Count == 0) continue;

            foreach (var dayEvent in queue.ToList()) Dispatch(day, dayEvent);
            queue.Clear();
        }
    }

    /// <summary><c>best.a.f(int)</c> (<c>best/a.java:567-612</c>): despacha um evento do dia.</summary>
    private void Dispatch(CalendarDay day, DayEvent dayEvent)
    {
        switch (dayEvent)
        {
            case DayEvent.CriaMundial:
                Hooks.CreateClubWorldCup(this);
                break;
            case DayEvent.Salarios:
                PaySalaries(day);
                break;
            case DayEvent.EvolucaoSemanal:
                Hooks.WeeklyEvolution(this);
                break;
            case DayEvent.CriaSerieDCopa:
                Hooks.CreateSerieDAndCopa(this);
                break;
            case DayEvent.JurosEmprestimo:
                Hooks.LoanInterest(this);
                break;
            case DayEvent.ConvocacaoSelecao:
                Hooks.NationalTeamCallUps(this, NationalCallUpKind.Normal);
                break;
            case DayEvent.ConvocacaoTodasSelecoes:
                Hooks.NationalTeamCallUps(this, NationalCallUpKind.All);
                break;
            case DayEvent.ConvocacaoForcada:
                Hooks.NationalTeamCallUps(this, NationalCallUpKind.Forced);
                break;
            case DayEvent.Promocao:
                Hooks.PromotionSettlement(this);
                break;
            case DayEvent.CriaMataMataAscenso:
            case DayEvent.CriaPlayoffRebaixamento:
            default:
                break; // eventos mortos no original
        }
    }

    // ---- Eventos implementados ----------------------------------------------

    /// <summary>
    /// <c>best.a.n()</c> (<c>best/a.java:702-710</c>): todo clube com jogo no mês do dia paga a
    /// folha salarial inteira (<c>ah.bY</c> + <c>ah.kJ</c>).
    /// </summary>
    public void PaySalaries(CalendarDay day)
    {
        foreach (var team in State.World.Teams)
        {
            if (HasMatchInMonth(team, day.Date.Month))
                team.Cash -= team.Payroll;
        }
    }

    /// <summary><c>ah.bY(int)</c> (<c>best/ah.java:2224</c>): o clube tem algum jogo no mês indicado.</summary>
    public bool HasMatchInMonth(Team team, int month) =>
        Calendar.Days.Any(d => d.Date.Month == month && d.Involves(team));
}
