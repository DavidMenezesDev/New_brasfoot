using System.Text;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Driver dedicado da Copa do Brasil novo formato (<c>f/f</c>, <c>f/f.java:82-282</c>): agenda as
/// sete fases nos dias livres de <see cref="DayType.CopaNacional"/> e avança dia a dia, reordenando os
/// vencedores por força entre uma fase e outra — o que <see cref="CupCompetition"/> não faz, porque o
/// chaveamento automático de <see cref="KnockoutBracket.ResolveRound"/> não conhece os emparelhamentos
/// de <c>f/f.ad</c>/<c>ao</c>/<c>as..av</c>.
/// </summary>
/// <remarks>
/// <para>
/// Fluxo (fases 0..6): 80 → 40 → <b>+12 cabeças</b> → 32 → 16 → 8 → 4 → 2. A 1ª e a 2ª fase são jogo
/// único; da 3ª em diante, ida e volta (<see cref="CopaDoBrasil.TwoLeggedByStage"/>). O desempate usa o
/// código da fase (<see cref="CopaDoBrasil.StageCodes"/>), porque a 1ª fase (2129) sempre avança o
/// visitante (<c>f/G.java:298</c>). Não há gol fora.
/// </para>
/// <para>
/// As 12 "cabeças" (<c>afU</c>) são decididas na criação por <see cref="CopaDoBrasil.SelectExcluded"/>;
/// quando o grupo não comporta o formato de potes (menos de 12 cabeças distintas ou menos de 80
/// restantes) a criação devolve <see langword="null"/> e o chamador cai no sorteio genérico de
/// <see cref="CupDraw"/>, como o original (<c>f/f.java:181-186</c>).
/// </para>
/// </remarks>
public sealed class CopaDoBrasilCompetition
{
    private readonly Queue<int> _pendingDays;
    private readonly HashSet<Match> _recorded = new();
    private readonly List<Team> _heads;
    private List<KnockoutPairing> _pairings;
    private int _stage;
    private bool _secondLegsCreated;

    private CopaDoBrasilCompetition(
        Competition competition,
        IReadOnlyList<Team> heads,
        List<KnockoutPairing> pairings,
        IReadOnlyList<int> reservedDayIndexes)
    {
        Competition = competition;
        _heads = heads.ToList();
        _pairings = pairings;
        _pendingDays = new Queue<int>(reservedDayIndexes);
    }

    public Competition Competition { get; }

    /// <summary>As 12 "cabeças" que entram já na 3ª fase (<c>afU</c>).</summary>
    public IReadOnlyList<Team> Heads => _heads;

    /// <summary>Índice da fase corrente, 0..6 (0 = fase de 80 clubes).</summary>
    public int Stage => _stage;

    /// <summary>Código da fase corrente (<c>f/f.java:180,214,…</c>).</summary>
    public int StageCode => CopaDoBrasil.StageCodes[_stage];

    /// <summary>Dias de calendário já usados, na ordem em que foram ocupados.</summary>
    public List<int> DayIndexes { get; } = new();

    /// <summary>Confrontos da fase corrente, na ordem de chaveamento.</summary>
    public IReadOnlyList<KnockoutPairing> Pairings => _pairings;

    public bool IsComplete { get; private set; }

    public Team? Champion { get; private set; }

    /// <summary>
    /// Quantos dias livres do tipo são necessários para a competição inteira: uma perna por fase de
    /// jogo único e duas nas fases de ida e volta (12 dias no formato de 80 clubes).
    /// </summary>
    public static int RequiredDaySlots()
    {
        var slots = 0;
        foreach (var twoLegged in CopaDoBrasil.TwoLeggedByStage)
            slots += twoLegged ? 2 : 1;
        return slots;
    }

    /// <summary>A fase é de ida e volta (<c>blArray2</c>, <c>f/f.java:168-174</c>).</summary>
    public static bool TwoLeggedAt(int stage) => CopaDoBrasil.TwoLeggedByStage[stage];

    /// <summary>
    /// Prepara a competição (<c>f.b</c>, <c>f/f.java:82-187</c>): escolhe os 12 cabeças, sorteia a
    /// fase de potes e reserva os dias livres do tipo. Devolve <see langword="null"/> quando o grupo não
    /// comporta o formato (use <see cref="CupDraw"/>).
    /// </summary>
    public static CopaDoBrasilCompetition? Create(
        Competition competition,
        IReadOnlyList<Team> pool,
        SeasonCalendar calendar,
        GameContext ctx,
        IReadOnlyList<Team>? preferred = null)
    {
        ArgumentNullException.ThrowIfNull(competition);
        ArgumentNullException.ThrowIfNull(pool);
        ArgumentNullException.ThrowIfNull(calendar);
        ArgumentNullException.ThrowIfNull(ctx);

        var heads = CopaDoBrasil.SelectExcluded(pool, preferred);
        if (heads is null) return null;

        var remaining = pool.Where(t => !heads.Contains(t)).ToList();
        var field = CopaDoBrasil.FirstStage(remaining, ctx.Random);
        if (field.Count == 0) return null;

        var slots = RequiredDaySlots();
        var dayType = CalendarDay.CompetitionToDay(competition.Type);
        var free = calendar.FreeIndexesOfType(dayType);
        if (free.Count < slots)
        {
            throw new InvalidOperationException(
                $"Calendário tem {free.Count} dias livres de {dayType} para {slots} pernas de {competition.Name}.");
        }

        var copa = new CopaDoBrasilCompetition(competition, heads, BuildPairings(field), free.Take(slots).ToList());
        copa.PlaceOn(calendar, copa.CreateFirstLegs(ctx));
        return copa;
    }

    /// <summary>
    /// Cria (sem jogar) os jogos de ida da fase corrente que ainda não existem
    /// (<c>f/G.a(z, lista, fase, duasVoltas, …)</c>).
    /// </summary>
    private List<Match> CreateFirstLegs(GameContext ctx)
    {
        var twoLegged = TwoLeggedAt(_stage);
        var created = new List<Match>();
        foreach (var pairing in _pairings)
        {
            if (pairing.FirstLeg is not null) continue;
            pairing.FirstLeg = new Match(pairing.Home, pairing.Away, Competition, ctx.Random,
                new KnockoutTie(FirstLeg: null, AwayGoalsRule: false, ShootoutAllowed: !twoLegged));
            created.Add(pairing.FirstLeg);
        }
        return created;
    }

    /// <summary>Cria (sem jogar) os jogos de volta da fase corrente, quando ela é de ida e volta.</summary>
    private List<Match> CreateSecondLegs(GameContext ctx)
    {
        var created = new List<Match>();
        foreach (var pairing in _pairings)
        {
            if (pairing.SecondLeg is not null || pairing.FirstLeg is null) continue;
            var tie = new KnockoutTie(
                FirstLeg: (pairing.FirstLeg.Score[1], pairing.FirstLeg.Score[0]),
                AwayGoalsRule: false,
                ShootoutAllowed: true);
            pairing.SecondLeg = new Match(pairing.Away, pairing.Home, Competition, ctx.Random, tie);
            created.Add(pairing.SecondLeg);
        }
        return created;
    }

    /// <summary>
    /// Chamado a cada dia processado pela sessão (<see cref="GameSession"/>): cria a volta quando a ida
    /// já foi disputada, ou resolve a fase, reordena os vencedores e agenda a fase seguinte. Idempotente.
    /// </summary>
    public void AdvanceAfterDay(SeasonCalendar calendar, GameContext ctx)
    {
        if (IsComplete) return;

        if (TwoLeggedAt(_stage) && !_secondLegsCreated)
        {
            if (!AllFirstLegsFinished()) return;
            var secondLegs = CreateSecondLegs(ctx);
            if (secondLegs.Count > 0) PlaceOn(calendar, secondLegs);
            _secondLegsCreated = true;
            return;
        }

        if (!LegFinished()) return;
        ResolveStage();

        if (_stage == CopaDoBrasil.TwoLeggedByStage.Length - 1)
        {
            Champion = _pairings[0].Winner;
            IsComplete = true;
            return;
        }

        var winners = _pairings.Select(p => p.Winner!).ToList();
        var field = NextField(_stage, winners, ctx.Random);
        _stage++;
        _pairings = BuildPairings(field);
        _secondLegsCreated = false;
        PlaceOn(calendar, CreateFirstLegs(ctx));
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

    /// <summary>
    /// Texto da notificação <c>Bh</c> (<c>f/f.java:318-340</c>): os nomes dos 12 cabeças no formato
    /// <c>"A, B, …, K e L."</c>. Devolve vazio se não houver exatamente 12.
    /// </summary>
    public static string BuildHeadsMessage(IReadOnlyList<Team> heads)
    {
        ArgumentNullException.ThrowIfNull(heads);
        if (heads.Count != 12) return "";

        var sb = new StringBuilder();
        for (var i = 0; i < heads.Count; i++)
        {
            var name = heads[i].Name;
            if (i == 10) sb.Append(name);
            else if (i == 11) sb.Append(" e ").Append(name).Append('.');
            else sb.Append(name).Append(", ");
        }
        return sb.ToString();
    }

    /// <summary>
    /// Notifica os técnicos de clubes brasileiros dos 12 cabeças (<c>f.Bh</c>, <c>f/f.java:333-338</c>):
    /// uma mensagem de tipo 23 / tom 75 para cada técnico com clube do Brasil.
    /// </summary>
    public void NotifyHeads(GameState state)
    {
        ArgumentNullException.ThrowIfNull(state);
        if (_heads.Count != 12) return;

        var text = BuildHeadsMessage(_heads);
        foreach (var manager in state.Managers)
        {
            if (manager.Club is not { CountryId: Countries.Brasil }) continue;
            manager.Messages.Add(new ManagerMessage { Type = 23, Tone = 75, Text = text, Date = state.Today });
        }
    }

    // ---- Internos ------------------------------------------------------------

    private IReadOnlyList<Team> NextField(int fromStage, IReadOnlyList<Team> winners, IGameRandom random) =>
        fromStage switch
        {
            0 => CopaDoBrasil.SecondStage(winners, random),
            1 => CopaDoBrasil.ThirdStage(winners, _heads, random),
            _ => CopaDoBrasil.LaterStage(winners, random),
        };

    private bool AllFirstLegsFinished() =>
        _pairings.All(p => p.FirstLeg is { IsFinished: true });

    private bool LegFinished() =>
        TwoLeggedAt(_stage)
            ? _secondLegsCreated && _pairings.All(p => p.SecondLeg is { IsFinished: true })
            : AllFirstLegsFinished();

    private void ResolveStage()
    {
        var twoLegged = TwoLeggedAt(_stage);
        foreach (var pairing in _pairings)
        {
            if (pairing.Winner is not null) continue;
            var side = KnockoutTiebreak.Resolve(
                pairing.FirstLeg!, twoLegged ? pairing.SecondLeg : null,
                awayGoalsRule: false, competitionId: StageCode);
            pairing.Winner = side == 0 ? pairing.Home : pairing.Away;
        }
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

    private static List<KnockoutPairing> BuildPairings(IReadOnlyList<Team> teams)
    {
        var pairings = new List<KnockoutPairing>();
        for (var i = 0; i + 1 < teams.Count; i += 2)
            pairings.Add(new KnockoutPairing(teams[i], teams[i + 1]));
        return pairings;
    }
}
