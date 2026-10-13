using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Formato de uma competição em duas fases (grupos/liga → mata-mata) como os estaduais
/// (<c>best.w</c> + <c>f.s</c>), regionais (<c>f.F.an</c>) e o Torneio Amistoso (<c>f.L.a</c>).
/// </summary>
public sealed record PhaseOptions
{
    /// <summary>Número de grupos da 1ª fase (<c>nGrupos</c>, <c>aq.sL[n][1]</c>); ≤1 = sem grupos.</summary>
    public int Groups { get; init; }

    /// <summary><c>doisTurnos</c> da 1ª fase (returno dentro do grupo / liga).</summary>
    public bool DoubleRound { get; init; } = true;

    /// <summary><c>jogosDentroGrupo</c>: true roda dentro de cada grupo; false usa a tabela de
    /// cruzamento entre grupos (<c>best.t.a/b</c>, fórmulas 7 e 10).</summary>
    public bool MatchesWithinGroup { get; init; } = true;

    /// <summary>Grupos contíguos (<c>bl3</c> de <c>f/s.j</c>): fatias do quadro em vez de intercalado.</summary>
    public bool ContiguousGroups { get; init; }

    /// <summary>Classificados da 1ª fase por grupo (<c>numeroTimesMataMata</c>, <c>Zd</c>).</summary>
    public int KnockoutQualifiersPerGroup { get; init; }

    /// <summary><c>var0</c>: código da competição (7/10 usam o chaveamento nacional <c>Zs/Zt</c>).</summary>
    public int CompetitionCode { get; init; } = -1;

    /// <summary>Pernas do mata-mata por fase (<c>duasVoltasMataMata</c>; null = todas de <see cref="KnockoutTwoLegged"/>).</summary>
    public IReadOnlyList<bool>? KnockoutTwoLeggedByRound { get; init; }

    /// <summary>Ida-e-volta padrão do mata-mata quando <see cref="KnockoutTwoLeggedByRound"/> é null.</summary>
    public bool KnockoutTwoLegged { get; init; }

    /// <summary>Tipo de dia no calendário (Estadual, Regionais, TorneioAmistoso…).</summary>
    public DayType DayType { get; init; } = DayType.Estadual;
}

/// <summary>
/// Competição em duas fases (<c>f.s</c> com <c>Zj</c> grupos + chave <c>f.z</c>): a 1ª fase é uma liga
/// (por grupo com <see cref="PhaseOptions.MatchesWithinGroup"/>, ou um cruzamento sobre o quadro
/// inteiro); ao terminar, os classificados (<see cref="PhaseOptions.KnockoutQualifiersPerGroup"/> por
/// grupo) viram uma <see cref="CupCompetition"/>. Os dias são reservados na construção: as rodadas da
/// 1ª fase usam os primeiros dias livres do tipo e o mata-mata consome os seguintes
/// (<c>best.a.a(type, pulaDuasDatas)</c> + a contagem de <c>f.z.ZK</c>).
/// </summary>
/// <remarks>
/// Replica o agendamento e a transição de <c>f/s.yP</c>/<c>yO</c>: grupos → <see cref="BracketSeeder"/>
/// com matriz nacional (<c>Zs</c>/<c>Zt</c>) quando <c>var0 == 7 || var0 == 10</c>, senão a matriz por
/// tamanho; sem grupos, os <c>Zd</c> primeiros do geral via <see cref="BracketSeeder.FromList"/>.
/// </remarks>
public sealed class PhasedCompetition
{
    private readonly List<LeagueCompetition> _phase1 = new();
    private readonly List<List<Team>> _groups = new();
    private readonly Queue<int> _knockoutDays = new();
    private readonly int _qualifiersPerGroup;
    private readonly int _phase1Rounds;
    private CupCompetition? _cup;
    private bool _knockoutStarted;

    public PhasedCompetition(
        GameSession session,
        Competition competition,
        IReadOnlyList<Team> pool,
        PhaseOptions options)
    {
        ArgumentNullException.ThrowIfNull(pool);
        if (pool.Count == 0) throw new ArgumentException("Quadro vazio.", nameof(pool));
        Competition = competition;
        Options = options;
        Pool = pool.ToList();
        DayType = options.DayType;

        _groups.AddRange(SplitGroups(pool, options));
        _qualifiersPerGroup = options.KnockoutQualifiersPerGroup;
        var knockoutSize = KnockoutSize();

        var days = session.State.Calendar.FreeIndexesOfType(DayType);
        var random = session.Context.Random;
        _phase1Rounds = BuildPhase1(session, days, random);
        foreach (var league in _phase1) session.Leagues.Add(league);

        _knockoutStarted = knockoutSize <= 0;
        if (!_knockoutStarted)
        {
            var slots = CupCompetition.RequiredDaySlots(
                knockoutSize, options.KnockoutTwoLeggedByRound, options.KnockoutTwoLegged);
            var reserved = days.Skip(_phase1Rounds).Take(slots).ToList();
            if (reserved.Count < slots)
            {
                throw new InvalidOperationException(
                    $"Calendário tem {reserved.Count} dias livres de {DayType} após a 1ª fase para " +
                    $"{slots} pernas do mata-mata de {Competition.Name}.");
            }
            foreach (var index in reserved) _knockoutDays.Enqueue(index);
        }
    }

    public Competition Competition { get; }
    public PhaseOptions Options { get; }
    public List<Team> Pool { get; }
    public DayType DayType { get; }

    /// <summary>Ligas da 1ª fase (uma por grupo quando <see cref="PhaseOptions.MatchesWithinGroup"/>, senão uma só).</summary>
    public IReadOnlyList<LeagueCompetition> Phase1 => _phase1;

    /// <summary>Grupos da 1ª fase (na ordem do quadro).</summary>
    public IReadOnlyList<IReadOnlyList<Team>> Groups => _groups;

    /// <summary>Mata-mata criado quando a 1ª fase terminou; null até lá (ou sem mata-mata).</summary>
    public CupCompetition? Knockout => _cup;

    /// <summary>Classificação da 1ª fase (geral).</summary>
    public List<TeamStanding> Standing =>
        Options.Groups <= 1 ? _phase1[0].Standing : _phase1.SelectMany(g => g.Standing).ToList();

    /// <summary>Dias de calendário usados (1ª fase + mata-mata), em ordem.</summary>
    public List<int> DayIndexes =>
        _phase1.SelectMany(l => l.DayIndexes).Concat(_cup?.DayIndexes ?? []).ToList();

    /// <summary>Competição terminada (mata-mata encerrado, ou 1ª fase sem mata-mata).</summary>
    public bool IsComplete => _knockoutStarted ? _cup is { IsComplete: true } : _phase1.All(l => l.IsComplete);

    /// <summary>Campeão (mata-mata) ou líder da 1ª fase quando não há fase final.</summary>
    public Team? Champion => _cup?.Champion ?? (_knockoutStarted && _phase1[0].IsComplete ? _phase1[0].Standing.FirstOrDefault()?.Team : null);

    /// <summary>Posições finais de temporada (1ª fase depois mata-mata, na ordem do original).</summary>
    public IReadOnlyList<(Team Team, int Position)> FinalPositions()
    {
        if (_cup is not null) return _cup.Bracket.FinalPositions();
        return _phase1[0].FinalPositions();
    }

    /// <summary>
    /// <c>f/s.yW()</c> = <c>l(count, true)</c>: os melhores <paramref name="count"/> clubes que
    /// subiriam. Com mata-mata (<c>Zc</c>), são os vencedores de cada fase da chave iterados de trás
    /// para frente (campeão, vice, semifinalistas…), completando pela tabela geral
    /// (<c>f/s.java:1247-1276</c>).
    /// </summary>
    public List<Team> PromotionCandidates(int count)
    {
        var result = new List<Team>();
        if (count <= 0) return result;

        var bracket = _cup?.Bracket;
        if (bracket is not null)
            for (var r = bracket.Rounds.Count - 1; r >= 0; r--)
                foreach (var pairing in bracket.Rounds[r].Pairings)
                {
                    if (result.Count >= count) break;
                    if (pairing.Winner is { } winner && !result.Contains(winner)) result.Add(winner);
                }

        foreach (var row in Standing)
        {
            if (result.Count >= count) break;
            if (!result.Contains(row.Team)) result.Add(row.Team);
        }
        return result.Take(Math.Min(count, result.Count)).ToList();
    }

    /// <summary>Os <paramref name="count"/> últimos da classificação geral (<c>f/s.yU()</c>, <c>fG</c>).</summary>
    public List<Team> RelegatedBottom(int count) =>
        Standing.TakeLast(Math.Min(count, Standing.Count)).Select(s => s.Team).ToList();

    /// <summary>Contabiliza os jogos do dia (1ª fase via ligas; mata-mata via copa).</summary>
    public int RecordResults(CalendarDay day)
    {
        if (!_knockoutStarted || _cup is null) return 0;
        return _cup.RecordResults(day);
    }

    /// <summary>
    /// Transição e avanço diário: quando a 1ª fase termina, monta a chave <see cref="KnockoutBracket"/>
    /// (chaveamento de <c>f/s.yP</c>) e a agenda nos dias reservados; depois delega a
    /// <see cref="CupCompetition.AdvanceAfterDay"/>.
    /// </summary>
    public void AdvanceAfterDay(SeasonCalendar calendar, GameContext ctx)
    {
        if (!_knockoutStarted)
        {
            if (!_phase1.All(l => l.IsComplete)) return;
            _knockoutStarted = true;
            if (_qualifiersPerGroup <= 0) return;

            var seeded = SeedKnockout();
            var twoLegged = Options.KnockoutTwoLegged;
            var brackets = new KnockoutBracket(
                Competition, seeded, twoLegged: twoLegged,
                twoLeggedByRound: Options.KnockoutTwoLeggedByRound,
                code: Options.CompetitionCode);
            _cup = new CupCompetition(Competition, brackets, _knockoutDays.ToList());
            _cup.Begin(calendar, ctx);
            return;
        }

        _cup?.AdvanceAfterDay(calendar, ctx);
    }

    /// <summary>Classificados da 1ª fase, por grupo, na ordem de posição (nutre o chaveamento).</summary>
    public List<Team> Qualifiers()
    {
        var result = new List<Team>();
        if (Options.Groups > 1)
        {
            foreach (var group in _phase1)
                result.AddRange(group.Standing.Take(_qualifiersPerGroup).Select(s => s.Team));
        }
        else
        {
            result.AddRange(Standing.Take(Math.Max(_qualifiersPerGroup, _qualifiersPerGroup)).Select(s => s.Team));
        }
        return result;
    }

    // ---- Construção ---------------------------------------------------------

    private int BuildPhase1(GameSession session, IReadOnlyList<int> days, IGameRandom random)
    {
        List<List<Fixture>>? rounds = null;
        if (Options.Groups > 1 && !Options.MatchesWithinGroup)
        {
            rounds = BuildCrossGroupRounds();
            var league = new LeagueCompetition(Competition, Pool, rounds);
            league.ScheduleOnDays(session.State.Calendar, days, random);
            _phase1.Add(league);
            return rounds.Count;
        }

        if (Options.Groups > 1 && Options.MatchesWithinGroup)
        {
            // Cada grupo é uma liga; todas jogam nos mesmos dias (como as divisões nacionais).
            var groupRounds = new List<List<Fixture>>();
            foreach (var (group, i) in _groups.Select((g, i) => (g, i)))
            {
                var groupRounds_i = FixtureGenerator.ForLeague(
                    new FixtureOptions
                    {
                        TeamCount = group.Count,
                        IsNationalLeague = false,
                        DoubleRound = Options.DoubleRound,
                    },
                    random);
                if (groupRounds.Count == 0) groupRounds = groupRounds_i;
                else if (groupRounds.Count != groupRounds_i.Count)
                {
                    throw new InvalidOperationException("Grupos com número diferente de rodadas.");
                }
                var groupCompetition = Competition with { Name = $"{Competition.Name} — Grupo {GroupLabel(i)}" };
                var league = new LeagueCompetition(groupCompetition, group, groupRounds_i);
                league.ScheduleOnDays(session.State.Calendar, days, random);
                _phase1.Add(league);
            }
            return groupRounds.Count;
        }

        rounds = FixtureGenerator.ForLeague(
            new FixtureOptions
            {
                TeamCount = Pool.Count,
                IsNationalLeague = false,
                DoubleRound = Options.DoubleRound,
                CompetitionId = Options.CompetitionCode,
            },
            random);
        var plain = new LeagueCompetition(Competition, Pool, rounds);
        plain.ScheduleOnDays(session.State.Calendar, days, random);
        _phase1.Add(plain);
        return rounds.Count;
    }

    private List<List<Fixture>> BuildCrossGroupRounds()
    {
        var perGroup = Pool.Count / Options.Groups;
        var table = (Options.Groups, perGroup) switch
        {
            (4, 4) => FixtureTables.cY,
            (4, 5) => FixtureTables.cZ,
            _ => throw new InvalidOperationException(
                $"Cruzamento entre grupos só modela 4x4 (cY) ou 4x5 (cZ); veio {Options.Groups}x{perGroup}."),
        };
        var groupIndexes = _groups.Select(g => g.Select(t => Pool.IndexOf(t)).ToList()).ToList();
        return FixtureGenerator.CrossGroup(groupIndexes, table, Pool.Count);
    }

    private List<List<Team>> SplitGroups(IReadOnlyList<Team> pool, PhaseOptions options)
    {
        var result = new List<List<Team>>();
        if (options.Groups <= 1)
        {
            result.Add(pool.ToList());
            return result;
        }
        if (pool.Count % options.Groups != 0)
        {
            throw new InvalidOperationException(
                $"{pool.Count} times não dividem igualmente em {options.Groups} grupos.");
        }
        var size = pool.Count / options.Groups;
        for (var g = 0; g < options.Groups; g++)
        {
            var group = new List<Team>();
            for (var i = 0; i < size; i++)
                group.Add(options.ContiguousGroups ? pool[g * size + i] : pool[i * options.Groups + g]);
            result.Add(group);
        }
        return result;
    }

    private int KnockoutSize()
    {
        if (_qualifiersPerGroup <= 0) return 0;
        var size = Options.Groups > 1 ? _qualifiersPerGroup * Options.Groups : _qualifiersPerGroup;
        if (size > Pool.Count) size = Pool.Count;
        if (size > 0 && (size & (size - 1)) != 0)
        {
            throw new InvalidOperationException(
                $"Mata-mata de {size} times não é potência de dois em {Competition.Name}.");
        }
        return size;
    }

    private IReadOnlyList<Team> SeedKnockout()
    {
        var twoLegged = Options.KnockoutTwoLeggedByRound is { } legs && legs.Count > 0 ? legs[0] : Options.KnockoutTwoLegged;
        var nationalPhase = Options.CompetitionCode is 7 or 10;
        if (Options.Groups > 1)
        {
            // Em cruzamento (fórmulas 7/10) a 1ª fase é uma liga só: a classificação de cada grupo
            // deriva do geral (<c>Zb</c>) filtrado pela filiação.
            List<IReadOnlyList<Team>> groups;
            if (Options.MatchesWithinGroup)
            {
                groups = _groups.Select((set, gi) => (IReadOnlyList<Team>)
                    _phase1[gi].Standing.Select(s => s.Team).ToList()).ToList();
            }
            else
            {
                var overall = _phase1[0].Standing;
                groups = _groups.Select(set =>
                    (IReadOnlyList<Team>)overall.Where(s => set.Contains(s.Team)).Select(s => s.Team).ToList()).ToList();
            }
            return BracketSeeder.FromGroupQualifiers(groups, _qualifiersPerGroup, twoLegged, nationalPhase);
        }
        return BracketSeeder.FromList(Qualifiers(), twoLegged);
    }

    private static string GroupLabel(int index) =>
        index < 26 ? ((char)('A' + index)).ToString() : $"G{index + 1}";
}