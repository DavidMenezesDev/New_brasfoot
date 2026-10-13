using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Seleção do quadro da Série D (<c>best.w.Q</c>, <c>best/w.java:468-511</c>) e dos clubes extras da
/// Copa do Brasil (<c>best.w.eh</c>, <c>best/w.java:406-451</c>), com as divisões regionais de
/// <c>best.ah.jW()/jX()</c> (<c>best/ah.java:218/235</c>).
/// </summary>
/// <remarks>
/// <para>
/// O original parte dos "slots" de estado (<c>a.SR.bx()</c>, lista de <c>components.aD</c>), montados
/// por <c>f/s.za()</c> (<c>f/s.java:1562-1640</c>) com os clubes que disputaram o estadual sem divisão
/// nacional (na prática, todos os que não estão nas divisões 1–3, porque a 4ª divisão nasce vazia —
/// <c>Z.Ar()</c>). Cada slot é <c>(estado, divisão estadual, clube, posição)</c>, ordenado por
/// <c>best.x</c> = <c>dx</c> (estado asc, divisão asc, posição asc).
/// </para>
/// <para>
/// <c>Q(n)</c>: (1) clubes livres de <c>bY()</c> com divisão 0 e sem técnico; (2) 19 passagens pelos
/// grupos de estados <c>sb..sf</c> (cada passagem pega o melhor slot ainda não usado de cada estado
/// do grupo); (3) se faltar, completa com <c>Z.jg()</c> (todos os clubes do país) na ordem do mundo;
/// (4) corta em <c>n</c>; (5) se <c>n == 68</c> põe os clubes livres na frente e ordena o resto por
/// <c>jW()</c>; se <c>n == 64</c> ordena tudo por <c>jX()</c>.
/// </para>
/// <para>
/// Os clubes livres (<c>bY()</c>) ainda não têm equivalente no port (só surgem quando um clube é
/// removido de uma liga, <c>al.lP()</c>); a primeira temporada os tem vazios, como o original.
/// </para>
/// </remarks>
public static class SerieDSelection
{
    /// <summary>Um clube que disputou o estadual sem divisão nacional (<c>components.aD</c>).</summary>
    /// <param name="State">Estado (<c>getEstado()</c>).</param>
    /// <param name="Division">Divisão estadual em que jogou (<c>co()</c>).</param>
    /// <param name="Team">Clube (<c>vD()</c>).</param>
    /// <param name="Position">Posição final na divisão estadual (<c>vE()</c>), 1-based.</param>
    public readonly record struct StateSlot(int State, int Division, Team Team, int Position);

    /// <summary><c>aq.sb</c>: SP, RJ, MG, RS.</summary>
    public static readonly int[] Sb = [25, 18, 10, 22];

    /// <summary><c>aq.sc</c>: PR, SC, BA, PE, ES.</summary>
    public static readonly int[] Sc = [17, 23, 4, 15, 5];

    /// <summary><c>aq.sd</c>: GO, AL, DF, MS, MT, SE, CE.</summary>
    public static readonly int[] Sd = [8, 1, 13, 11, 9, 19, 14];

    /// <summary><c>aq.se</c>: RN, AC, RO, TO, AP, AM.</summary>
    public static readonly int[] Se = [24, 0, 16, 12, 2, 6];

    /// <summary><c>aq.sf</c>: PA, MA, PI, RR, PB.</summary>
    public static readonly int[] Sf = [7, 26, 20, 3, 21];

    /// <summary>
    /// As 19 passagens de <c>Q(n)</c> (<c>best/w.java:487-507</c>): <c>sb, sc, sd, se, sf</c> e então
    /// <c>sb, sb, sb, sc, sc, sd, se, sb, sb, sb, sc, sc, sd, se</c>.
    /// </summary>
    private static readonly int[][] FieldPasses =
    [
        Sb, Sc, Sd, Se, Sf,
        Sb, Sb, Sb, Sc, Sc, Sd, Se,
        Sb, Sb, Sb, Sc, Sc, Sd, Se,
    ];

    // best/ah.java:218 (jW) e :235 (jX): índice da região que contém o estado do clube.
    private static readonly int[][] RegionsOne =
    [
        [25, 18, 10, 22],
        [17, 23, 4, 15, 5],
        [8, 1, 13, 11, 9, 19, 14],
        [24, 0, 16, 12, 2, 6],
        [7, 26, 20, 3, 21],
    ];

    private static readonly int[][] RegionsTwo =
    [
        [18, 25, 17, 22, 23],
        [10],
        [1, 4, 5, 9, 14, 15, 16, 19, 24],
        [6, 7, 8, 11, 12, 26],
        [0, 2, 3, 13, 20, 21],
    ];

    /// <summary>
    /// <c>best.w.Q(n)</c>: monta o quadro da Série D de <paramref name="size"/> clubes. Os clubes
    /// <paramref name="freeTeams"/> e <paramref name="countryTeams"/> já devem vir filtrados pelo
    /// chamador (o filtro original é <c>getDivisao() == 0</c>, equivalente a "fora das divisões 1–3"
    /// no port, onde a 4ª divisão do mundo carrega os pré-selecionados).
    /// </summary>
    public static List<Team> Select(
        int size,
        IReadOnlyList<StateSlot> slots,
        IReadOnlyList<Team> freeTeams,
        IReadOnlyList<Team> countryTeams)
    {
        ArgumentNullException.ThrowIfNull(slots);
        ArgumentNullException.ThrowIfNull(freeTeams);
        ArgumentNullException.ThrowIfNull(countryTeams);

        var ordered = SortSlots(slots);
        var result = new List<Team>();
        var freeAdded = new List<Team>();

        foreach (var team in freeTeams)
        {
            if (result.Contains(team)) continue;
            result.Add(team);
            freeAdded.Add(team);
        }

        foreach (var states in FieldPasses) Pick(states, result, ordered);

        if (result.Count < size)
            foreach (var team in countryTeams)
            {
                if (result.Count >= size) break;
                if (!result.Contains(team)) result.Add(team);
            }

        if (result.Count > size) result = result.Take(size).ToList();

        if (size == 68)
        {
            var rest = result.Where(t => !freeAdded.Contains(t)).ToList();
            rest = rest.OrderBy(t => RegionOne(t.State)).ToList();
            rest.InsertRange(0, freeAdded);
            result = rest;
        }
        else if (size == 64)
        {
            result = result.OrderBy(t => RegionTwo(t.State)).ToList();
        }

        return result;
    }

    /// <summary>
    /// <c>best.w.eh()</c> (<c>best/w.java:406-451</c>): os clubes extras da Copa do Brasil, tirados dos
    /// slots de estado por 14 + 5 + 15 passagens.
    /// </summary>
    public static List<Team> ExtraTeams(IReadOnlyList<StateSlot> slots)
    {
        ArgumentNullException.ThrowIfNull(slots);
        var ordered = SortSlots(slots);
        var result = new List<Team>();

        int[][] first = [Sb, Sc, Sd, Se, Sf, Sb, Sc, Sd, Sb, Sc, Sd, Sb, Sc, Sd];
        int[][] second = [Se, Sf, Sb, Sc, Sd];
        int[][] third = [Se, Sf, Sb, Sc, Sd, Se, Sf, Sb, Sc, Sd, Se, Sf, Sb, Sc, Sd];

        foreach (var states in first) Pick(states, result, ordered);
        var count = result.Count;
        if (count < 128)
            foreach (var states in second) Pick(states, result, ordered);
        if (count < 128)
            foreach (var states in third) Pick(states, result, ordered);

        return result;
    }

    /// <summary>
    /// <c>best.w.a(int[], ArrayList)</c> (<c>best/w.java:453-466</c>): para cada estado, acrescenta o
    /// primeiro slot (na ordem de <c>dx</c>) daquele estado cujo clube ainda não está na lista.
    /// </summary>
    public static void Pick(int[] states, List<Team> list, IReadOnlyList<StateSlot> slots)
    {
        ArgumentNullException.ThrowIfNull(states);
        ArgumentNullException.ThrowIfNull(list);
        ArgumentNullException.ThrowIfNull(slots);

        foreach (var state in states)
            foreach (var slot in slots)
            {
                if (slot.State != state) continue;
                if (list.Contains(slot.Team)) continue;
                list.Add(slot.Team);
                break;
            }
    }

    /// <summary>
    /// Monta os slots de estado (<c>a.SR.bx()</c>) a partir das federações estaduais da temporada:
    /// para cada divisão, as posições finais (<see cref="PhasedCompetition.FinalPositions"/>, ramo
    /// com mata-mata de <c>f/s.za()</c>) seguidas do restante da tabela, ficando só os clubes
    /// <paramref name="isEligible"/>.
    /// </summary>
    public static List<StateSlot> FromFederations(
        IReadOnlyList<StateFederation> federations, Func<Team, bool> isEligible)
    {
        ArgumentNullException.ThrowIfNull(federations);
        ArgumentNullException.ThrowIfNull(isEligible);

        var slots = new List<StateSlot>();
        foreach (var federation in federations)
            foreach (var division in federation.Divisions)
            {
                var seen = new HashSet<Team>();
                var position = 0;

                void Add(Team team)
                {
                    position++;
                    if (!seen.Add(team)) return;
                    if (isEligible(team))
                        slots.Add(new StateSlot(federation.StateId, division.Division, team, position));
                }

                foreach (var (team, _) in division.Phased.FinalPositions()) Add(team);
                foreach (var row in division.Phased.Standing) Add(row.Team);
            }
        return slots;
    }

    /// <summary><c>best.ah.jW()</c>: índice da região (1ª tabela) que contém <paramref name="state"/>.</summary>
    public static int RegionOne(int state) => RegionOf(RegionsOne, state);

    /// <summary><c>best.ah.jX()</c>: índice da região (2ª tabela) que contém <paramref name="state"/>.</summary>
    public static int RegionTwo(int state) => RegionOf(RegionsTwo, state);

    private static int RegionOf(int[][] regions, int state)
    {
        for (var i = 0; i < regions.Length; i++)
            if (Array.IndexOf(regions[i], state) >= 0) return i;
        return -1;
    }

    private static List<StateSlot> SortSlots(IReadOnlyList<StateSlot> slots) =>
        slots.OrderBy(s => s.State).ThenBy(s => s.Division).ThenBy(s => s.Position).ToList();
}
