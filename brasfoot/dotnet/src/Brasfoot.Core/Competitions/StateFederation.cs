using Brasfoot.Core.Calendar;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Uma divisão de um campeonato estadual (<c>f.o</c>): o formato (<see cref="PhasedCompetition"/>),
/// o nome ("Paulista" / "Paulista - 2ª divisão") e quantos clubes caem por temporada
/// (<c>getnRebaixados</c>). <see cref="Roster"/> é a lista corrente de clubes da divisão e é trocada
/// no fim da temporada por <see cref="StateFederation.SettlePromotionRelegation"/>.
/// </summary>
public sealed class StateDivision
{
    internal StateDivision(int division, Competition competition, PhasedCompetition phased, List<Team> roster, int relegated)
    {
        Division = division;
        Competition = competition;
        Phased = phased;
        Roster = roster;
        Relegated = relegated;
    }

    /// <summary>Divisão 1-based.</summary>
    public int Division { get; }

    public Competition Competition { get; }

    public PhasedCompetition Phased { get; }

    /// <summary>Clubes da divisão nesta temporada (mutável no fim dela).</summary>
    public List<Team> Roster { get; }

    /// <summary>Quantos clubes descem nesta divisão (<c>getnRebaixados</c>).</summary>
    public int Relegated { get; }

    /// <summary>
    /// <c>f/s.yU()</c> = <c>fG(nRebaixados)</c>: para os estaduais (<c>zc()</c> falso), os
    /// <see cref="Relegated"/> últimos da classificação geral (<c>Zb</c>).
    /// </summary>
    public List<Team> RelegatedBottom() =>
        Phased.Standing.TakeLast(Math.Min(Relegated, Phased.Standing.Count)).Select(s => s.Team).ToList();

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

        var bracket = Phased.Knockout?.Bracket;
        if (bracket is not null)
        {
            for (var r = bracket.Rounds.Count - 1; r >= 0; r--)
                foreach (var pairing in bracket.Rounds[r].Pairings)
                {
                    if (result.Count >= count) break;
                    if (pairing.Winner is { } winner && !result.Contains(winner)) result.Add(winner);
                }
        }

        foreach (var row in Phased.Standing)
        {
            if (result.Count >= count) break;
            if (!result.Contains(row.Team)) result.Add(row.Team);
        }
        return result.Take(Math.Min(count, result.Count)).ToList();
    }
}

/// <summary>
/// Movimentações de acesso/rebaixamento de uma federação estadual (<c>best.w.ee</c>), para histórico
/// e para a montagem da próxima temporada.
/// </summary>
public sealed record StatePromotionResult(
    int StateId,
    IReadOnlyList<(int FromDivision, int ToDivision, Team Team)> Movements);

/// <summary>
/// Federação estadual (<c>best.w</c>): monta as divisões do campeonato de um estado a partir dos
/// clubes brasileiros daquele estado, dividindo por nível (<c>cN</c>) e pela configuração
/// <c>conf_estadual/*.ces</c> (<see cref="ConfigEstadualType"/> + <see cref="StateFormulaTable"/>),
/// e liquida acesso/rebaixamento no fim da temporada.
/// </summary>
/// <remarks>
/// <para>
/// <c>best.w.dY()</c>: ordena o pool por <c>cN</c> (nível desc, desempate desc) e, enquanto houver
/// ao menos 6 clubes, forma a divisão <c>1..4</c> com o número de times da fórmula configurada.
/// Quando não há configuração para a divisão, ou a fórmula pede mais times que o pool inicial
/// (<c>aq.sL[f][0] &gt; n3</c>), cai na fórmula padrão 0 (6 times, 2 classificados, 2 rebaixados).
/// São Paulo divisão 1 com a opção "grupo padrão" ligada usa os 16 clubes de <c>aq.sO</c> em vez da
/// ordem de nível. O que sobra vai para <see cref="Leftovers"/> (<c>dt</c>).
/// </para>
/// <para>
/// <c>best.w.ee()</c> (<see cref="SettlePromotionRelegation"/>): troca os rebaixados de cada divisão
/// pelos melhores candidatos (<c>yW</c>) da divisão de baixo; a última divisão troca com os clubes
/// fora da liga. A troca só acontece quando as duas listas têm o mesmo tamanho, como no original.
/// </para>
/// </remarks>
public sealed class StateFederation
{
    private readonly List<StateDivision> _divisions = new();

    private StateFederation(int stateId) => StateId = stateId;

    /// <summary>Id do estado (índice de <see cref="StateFormulaTable.StateNames"/>).</summary>
    public int StateId { get; }

    public IReadOnlyList<StateDivision> Divisions => _divisions;

    /// <summary>Clubes do estado fora das divisões da liga estadual (<c>dt</c>).</summary>
    public List<Team> Leftovers { get; } = new();

    /// <summary>Gentílico do estado (<c>ea()</c>).</summary>
    public string Demonym => StateFormulaTable.DemonymOf(StateId);

    /// <summary>
    /// Constrói a federação do estado <paramref name="stateId"/> e cria/agenda as divisões como
    /// <see cref="PhasedCompetition"/> (tipo de dia <see cref="DayType.Estadual"/>). Só cria divisão
    /// onde houver ao menos 6 clubes brasileiros do estado, como <c>best.w.dZ()</c>.
    /// </summary>
    /// <param name="configs">
    /// Configurações <c>.ces</c> por <c>(estado, divisão)</c>; quando ausentes, usa a fórmula padrão 0.
    /// </param>
    /// <param name="useStandardGroup">
    /// Opção "usa grupo padrão estadual": habilita o grupo fixo de São Paulo (fórmula 7).
    /// </param>
    public static StateFederation Build(
        GameSession session,
        int stateId,
        IReadOnlyDictionary<(int State, int Division), ConfigEstadualType>? configs = null,
        bool useStandardGroup = true)
    {
        ArgumentNullException.ThrowIfNull(session);
        var federation = new StateFederation(stateId);

        var pool = session.State.World.Teams
            .Where(t => t.CountryId == Countries.Brasil && t.State == stateId)
            .OrderByDescending(t => t.Level)
            .ThenByDescending(t => t.RankTiebreak)
            .ToList();
        if (pool.Count < 6) return federation;

        var initialCount = pool.Count;
        for (var division = 1; division <= 4 && pool.Count >= 6; division++)
        {
            ConfigEstadualType? config = null;
            configs?.TryGetValue((stateId, division), out config);
            var useDefault = config is null
                || StateFormulaTable.Formulas[config.Formula][0] > initialCount;

            int formula, groups, qualifiers, relegated, times;
            bool doubleRound, contiguous;
            bool[] knockoutLegs;

            if (useDefault)
            {
                formula = StateFormulaTable.DefaultFormula;
                times = StateFormulaTable.Formulas[formula][0];
                groups = StateFormulaTable.Formulas[formula][1];
                qualifiers = StateFormulaTable.Formulas[formula][2];
                doubleRound = StateFormulaTable.Formulas[formula][3] == 1;
                relegated = 2;
                knockoutLegs = [true, true, true, true, true, true, true];
            }
            else
            {
                formula = config!.Formula;
                times = StateFormulaTable.Formulas[formula][0];
                groups = StateFormulaTable.Formulas[formula][1];
                qualifiers = StateFormulaTable.Formulas[formula][2];
                doubleRound = StateFormulaTable.Formulas[formula][3] == 1;
                relegated = StateFormulaTable.Formulas[formula][4];
                knockoutLegs = config.FinalsLegsFormatted();
            }

            List<Team> participants;
            contiguous = false;
            if (formula == 7 && division == 1 && stateId == 25 && useStandardGroup)
            {
                var standard = StandardGroupOfSaoPaulo(pool);
                if (standard.Count == 16)
                {
                    participants = standard;
                    contiguous = true;
                }
                else
                {
                    participants = pool.Take(times).ToList();
                }
            }
            else
            {
                participants = pool.Take(times).ToList();
            }

            foreach (var team in participants) pool.Remove(team);

            var name = division == 1
                ? federation.Demonym
                : $"{federation.Demonym} - {division}ª divisão";
            var competition = new Competition(
                3000 + stateId * 10 + division, name, CompetitionType.Estadual);

            var options = new PhaseOptions
            {
                Groups = groups,
                DoubleRound = doubleRound,
                MatchesWithinGroup = formula is not (7 or 10),
                ContiguousGroups = contiguous,
                KnockoutQualifiersPerGroup = qualifiers,
                CompetitionCode = formula,
                KnockoutTwoLegged = false,
                KnockoutTwoLeggedByRound = knockoutLegs,
                DayType = DayType.Estadual,
            };

            var phased = new PhasedCompetition(session, competition, participants, options);
            session.Phased.Add(phased);
            federation._divisions.Add(new StateDivision(division, competition, phased, participants, relegated));
        }

        federation.Leftovers.AddRange(pool);
        return federation;
    }

    /// <summary>
    /// <c>best.w.z()</c>: os 16 clubes do "grupo padrão" paulista (<c>aq.sO</c>) presentes no pool,
    /// na ordem de <c>aq.sO</c>, casando por <c>FileRef</c>.
    /// </summary>
    public static List<Team> StandardGroupOfSaoPaulo(IReadOnlyList<Team> pool)
    {
        var result = new List<Team>();
        foreach (var fileRef in StateFormulaTable.SaoPauloStandardGroup)
            foreach (var team in pool)
                if (team.State == 25 && team.FileRef.Equals(fileRef, StringComparison.Ordinal))
                    result.Add(team);
        return result;
    }

    /// <summary>
    /// <c>best.w.ee()</c>: liquida acesso/rebaixamento. Para cada divisão (menos a última), troca os
    /// <c>nRebaixados</c> últimos pelos melhores candidatos da divisão de baixo, quando as contagens
    /// batem; a última divisão troca com <see cref="Leftovers"/>. Atualiza os <see cref="StateDivision.Roster"/>
    /// em memória e devolve as movimentações para o chamador persistir/historiar.
    /// </summary>
    public StatePromotionResult SettlePromotionRelegation()
    {
        var movements = new List<(int FromDivision, int ToDivision, Team Team)>();

        // ah(): candidatos a subir (wK) e rebaixados (xc) de cada divisão, já com as contagens certas.
        var relegated = new List<List<Team>>();
        var promoted = new List<List<Team>>();
        for (var i = 0; i < _divisions.Count; i++)
        {
            var aboveRelegated = i == 0 ? 0 : _divisions[i - 1].Relegated;
            promoted.Add(_divisions[i].PromotionCandidates(aboveRelegated));
            relegated.Add(_divisions[i].RelegatedBottom());
        }

        for (var i = 0; i < _divisions.Count; i++)
        {
            if (i + 1 < _divisions.Count)
            {
                var down = relegated[i];
                var up = promoted[i + 1];
                if (down.Count != up.Count) continue;

                foreach (var team in down)
                {
                    _divisions[i].Roster.Remove(team);
                    _divisions[i + 1].Roster.Add(team);
                    movements.Add((i + 1, i + 2, team));
                }
                foreach (var team in up)
                {
                    _divisions[i + 1].Roster.Remove(team);
                    _divisions[i].Roster.Add(team);
                    movements.Add((i + 2, i + 1, team));
                }
            }
            else
            {
                var n = Math.Min(_divisions[i].Relegated, Leftovers.Count);
                if (n <= 0) continue;

                var down = relegated[i].Take(n).ToList();
                var up = Leftovers.Take(n).ToList();
                if (down.Count != up.Count) continue;

                foreach (var team in down)
                {
                    _divisions[i].Roster.Remove(team);
                    Leftovers.Add(team);
                    movements.Add((i + 1, 0, team));
                }
                foreach (var team in up)
                {
                    Leftovers.Remove(team);
                    _divisions[i].Roster.Add(team);
                    movements.Add((0, i + 1, team));
                }
            }
        }

        return new StatePromotionResult(StateId, movements);
    }
}
