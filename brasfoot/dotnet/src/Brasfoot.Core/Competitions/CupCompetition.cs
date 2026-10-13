using Brasfoot.Core.Calendar;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Agenda um <see cref="KnockoutBracket"/> nos dias livres do tipo da competição, uma perna por dia,
/// em vez de jogar tudo de uma vez (<see cref="KnockoutBracket.PlayAll"/>). Substitui, para o laço de
/// dias de <see cref="GameSession"/>, o uso isolado que o CLI (<c>copa</c>/<c>copadobrasil</c>) faz do
/// mata-mata: os jogos entram em <c>CalendarDay.Matches</c> do dia reservado e são disputados pelo
/// motor junto com o resto da rodada, como as ligas (<see cref="LeagueCompetition"/>).
/// </summary>
/// <remarks>
/// Reserva, na criação, uma fatia fixa de dias livres do tipo da competição — uma por perna de cada
/// fase (<see cref="RequiredDaySlots"/>) — e os consome em ordem conforme as fases avançam
/// (<see cref="AdvanceAfterDay"/>). Isso replica o agendamento de <c>f.s.a()</c> (<c>f/s.java:672-688</c>)
/// para os mata-matas que, no original, moram dentro de um <c>f.z</c> solto (copa nacional, Supercopa)
/// em vez de um <c>f.s</c> com rodadas. Não serve para a Copa do Brasil (<see cref="CopaDoBrasil"/>),
/// cujas fases reordenam os vencedores por força entre uma fase e outra.
/// </remarks>
public sealed class CupCompetition
{
    private readonly Queue<int> _pendingDays;
    private readonly HashSet<Match> _recorded = new();

    public CupCompetition(Competition competition, KnockoutBracket bracket, IReadOnlyList<int> reservedDayIndexes)
    {
        ArgumentNullException.ThrowIfNull(competition);
        ArgumentNullException.ThrowIfNull(bracket);
        ArgumentNullException.ThrowIfNull(reservedDayIndexes);
        Competition = competition;
        Bracket = bracket;
        _pendingDays = new Queue<int>(reservedDayIndexes);
    }

    public Competition Competition { get; }
    public KnockoutBracket Bracket { get; }

    /// <summary>Dias de calendário já usados por esta competição, na ordem em que foram ocupados.</summary>
    public List<int> DayIndexes { get; } = new();

    public bool IsComplete => Bracket.IsComplete;
    public Team? Champion => Bracket.Champion;

    /// <summary>
    /// Quantos dias livres do tipo são necessários para o mata-mata inteiro: uma perna por dia, duas
    /// pernas nas fases marcadas em <paramref name="twoLeggedByRound"/> (<c>f.z.ZK</c>).
    /// </summary>
    public static int RequiredDaySlots(int teamCount, IReadOnlyList<bool>? twoLeggedByRound, bool twoLegged = false)
    {
        var rounds = KnockoutPlan.RoundCount(teamCount);
        var slots = 0;
        for (var r = 0; r < rounds; r++)
        {
            var legs = twoLeggedByRound is { } flags && r < flags.Count ? flags[r] : twoLegged;
            slots += legs ? 2 : 1;
        }
        return slots;
    }

    /// <summary>
    /// Reserva os <see cref="RequiredDaySlots"/> dias livres do tipo da competição, do calendário,
    /// na ordem em que aparecem a partir de hoje, e cria a primeira fase.
    /// </summary>
    public static CupCompetition Create(
        Competition competition,
        KnockoutBracket bracket,
        SeasonCalendar calendar,
        GameContext ctx,
        bool skipTwoDays = false)
    {
        ArgumentNullException.ThrowIfNull(bracket);
        ArgumentNullException.ThrowIfNull(calendar);

        var slots = RequiredDaySlots(bracket.Seeded.Count, null, bracket.TwoLegged);
        var dayType = CalendarDay.CompetitionToDay(competition.Type);
        var free = calendar.FreeIndexesOfType(dayType, skipTwoDays);
        if (free.Count < slots)
        {
            throw new InvalidOperationException(
                $"Calendário tem {free.Count} dias livres de {dayType} para {slots} pernas de {competition.Name}.");
        }

        var cup = new CupCompetition(competition, bracket, free.Take(slots).ToList());
        cup.PlaceOn(calendar, bracket.CreateFirstLegs(ctx));
        return cup;
    }

    /// <summary>
    /// Coloca os jogos de ida da primeira fase no primeiro dia reservado (passado no construtor).
    /// Usado por <see cref="PhasedCompetition"/> para adiar a criação do mata-mata até a fase de
    /// grupos terminar, mantendo os dias já reservados no começo da temporada.
    /// </summary>
    public void Begin(SeasonCalendar calendar, GameContext ctx) => PlaceOn(calendar, Bracket.CreateFirstLegs(ctx));

    /// <summary>
    /// Chamado a cada dia processado pela sessão (<see cref="GameSession"/>, análogo a
    /// <c>LeagueCompetition.RecordResults</c>+<c>pO()</c>): cria a volta da fase corrente quando a ida
    /// já foi disputada, ou resolve a fase e agenda a próxima. Idempotente — não faz nada se a fase
    /// corrente ainda está pendente ou se a chave já terminou.
    /// </summary>
    public void AdvanceAfterDay(SeasonCalendar calendar, GameContext ctx)
    {
        if (IsComplete) return;

        var secondLegs = Bracket.CreateSecondLegs(ctx);
        if (secondLegs.Count > 0)
        {
            PlaceOn(calendar, secondLegs);
            return;
        }

        if (Bracket.ResolveRound())
            PlaceOn(calendar, Bracket.CreateFirstLegs(ctx));
    }

    /// <summary>Contabiliza (uma única vez) os jogos desta competição disputados no dia.</summary>
    public int RecordResults(CalendarDay day)
    {
        var counted = 0;
        foreach (var match in day.Matches)
        {
            if (!ReferenceEquals(match.Competition, Competition)) continue;
            if (!match.IsFinished) continue;
            if (_recorded.Add(match)) counted++;
        }
        return counted;
    }

    private void PlaceOn(SeasonCalendar calendar, List<Match> matches)
    {
        if (matches.Count == 0) return;
        if (_pendingDays.Count == 0)
        {
            throw new InvalidOperationException(
                $"Sem dias livres reservados para a próxima perna de {Competition.Name}.");
        }

        var index = _pendingDays.Dequeue();
        DayIndexes.Add(index);
        var day = calendar.Days[index];
        if (!day.Leagues.Contains(this)) day.Leagues.Add(this);
        day.Matches.AddRange(matches);
    }
}
