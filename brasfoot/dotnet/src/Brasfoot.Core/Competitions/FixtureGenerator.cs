using Brasfoot.Core.Common;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Um confronto de uma tabela de rodízio: índices (base 0) na lista de times passada ao gerador.
/// </summary>
public readonly record struct Fixture(int Home, int Away)
{
    /// <summary>Troca mando de campo (usado no returno e nas tabelas de <c>best.t</c>).</summary>
    public Fixture Swapped() => new(Away, Home);

    public override string ToString() => $"{Home} x {Away}";
}

/// <summary>
/// Fase de uma liga que influencia a regra de turnos do caminho genérico (<c>f.s.Zj</c>).
/// </summary>
public enum LeaguePhase
{
    /// <summary>Fase de grupos / temporada regular (<c>Zj == 0</c>).</summary>
    Regular = 0,

    /// <summary>Fase final (já não é a fase de grupos, <c>Zj != 0</c>).</summary>
    Final = 1,
}

/// <summary>Opções que reproduzem a decisão de tabela e de turnos de <c>f.s.a()</c>.</summary>
public sealed record FixtureOptions
{
    /// <summary>Número de times da liga/grupo.</summary>
    public int TeamCount { get; init; } = 20;

    /// <summary><c>f.s.b() == 1</c>: liga nacional.</summary>
    public bool IsNationalLeague { get; init; } = true;

    /// <summary><c>f.s.var0</c>: identificador da competição (afeta 4 e 20 times e alguns mata-matas).</summary>
    public int CompetitionId { get; init; } = -1;

    /// <summary><c>f.s.Zj</c>: fase corrente.</summary>
    public LeaguePhase Phase { get; init; } = LeaguePhase.Regular;

    /// <summary><c>f.s.numeroTurnos</c>: turnos configurados pela competição (0 = padrão).</summary>
    public int ConfiguredTurns { get; init; }

    /// <summary><c>f.s.doisTurnos</c>: a competição pediu dois turnos.</summary>
    public bool DoubleRound { get; init; } = true;
}

/// <summary>
/// Gerador de tabelas de rodízio. Porta fiel de <c>best.t</c>: o método do círculo genérico
/// (<c>best/t.java:746-878</c>) com reordenação de rodadas e alternância de mando, e as tabelas
/// fixas para 3/4/5/6/9/19 times escolhidas por <c>f.s.a()</c> (<c>f/s.java:603-689</c>).
/// </summary>
/// <remarks>
/// O original constrói as tabelas de 11 e 25 times de forma imperativa e enorme (<c>best.t.dg</c> /
/// <c>best.t.dh</c>); aqui elas caem no caminho genérico corrigido (<see cref="GenericAny"/>), o que
/// produz uma tabela válida mas não byte-idêntica. Ver "Quirks" na spec.
/// </remarks>
public static class FixtureGenerator
{
    // ---- Método do círculo genérico (best.t.a(s, list, turns)) ---------------

    /// <summary>
    /// Gera a tabela de rodízio para <paramref name="count"/> times (par) por <paramref name="turns"/>
    /// turnos (1..4). Reproduz o embaralhamento, a reordenação de rodadas (intercalando as duas
    /// metades) e os quirks do original: em cada rodada ímpar só o <b>primeiro</b> jogo troca o mando
    /// (<c>best/t.java:802-808</c>), e o returno inteiro é invertido (<c>best/t.java:809-818</c>).
    /// </summary>
    public static List<List<Fixture>> Generic(int count, int turns, IGameRandom rng)
    {
        ArgumentOutOfRangeException.ThrowIfLessThan(count, 2);
        if (turns is < 1 or > 4) throw new ArgumentOutOfRangeException(nameof(turns));
        if (count % 2 != 0) throw new ArgumentException("O caminho genérico de best.t exige número par de times.", nameof(count));

        var order = Enumerable.Range(0, count).ToList();
        rng.Shuffle(order);

        var n6 = count;                          // comprimento original
        var arr = order.ToList();
        // n7 = arr.Count - 1; n5 = arr.Count / 2; mod = n6 - 1; fixo = arr[n6 - 1].
        var n7 = arr.Count - 1;
        var pairs = arr.Count / 2;
        var mod = n6 - 1;

        var first = new List<List<Fixture>>(n7);
        for (var r = 0; r < n7; r++)
        {
            var round = new List<Fixture>(pairs);
            for (var i = 0; i < pairs; i++)
            {
                var home = arr[(r + i) % mod];
                var away = i == 0 ? arr[n6 - 1] : arr[((n6 - 1 - i + r) % mod + mod) % mod];
                round.Add(new Fixture(home, away));
            }
            first.Add(round);
        }

        // Reordenação: rodada par puxa da primeira metade, ímpar da segunda; e troca o mando
        // do primeiro jogo das rodadas ímpares (mutação in-loco no original).
        var reordered = new List<List<Fixture>>(n7);
        var lo = 0;
        var hi = arr.Count / 2;
        for (var i = 0; i < first.Count; i++)
        {
            if (i % 2 == 0)
            {
                reordered.Add(first[lo++]);
            }
            else
            {
                var round = new List<Fixture>(first[hi]);
                for (var m = 0; m < round.Count; m++)
                    round[m] = m == 0 ? round[m].Swapped() : round[m];
                reordered.Add(round);
                hi++;
            }
        }

        // Returno: cada jogo invertido, a partir das rodadas já reordenadas.
        var second = reordered.Select(r => r.Select(f => f.Swapped()).ToList()).ToList();

        return turns switch
        {
            4 => Concat(reordered, second, reordered, second),
            3 => Concat(reordered, second, reordered),
            2 => Concat(reordered, second),
            _ => reordered,
        };
    }

    /// <summary>
    /// Caminho genérico corrigido para qualquer número de times (inclusive ímpar), usado como
    /// substituto quando não há tabela fixa fiel. Embaralha e aplica o método do círculo clássico
    /// com um "folga" quando ímpar; gera a tabela de turno único e a duplica (invertendo o mando)
    /// quando <paramref name="doubleRound"/>. Não é byte-idêntico ao original.
    /// </summary>
    public static List<List<Fixture>> GenericAny(int count, bool doubleRound, IGameRandom rng)
    {
        ArgumentOutOfRangeException.ThrowIfLessThan(count, 2);
        var order = Enumerable.Range(0, count).ToList();
        rng.Shuffle(order);

        var slots = order.ToList();
        if (slots.Count % 2 == 1) slots.Add(-1);          // bye
        var n = slots.Count;
        var rounds = new List<List<Fixture>>();
        for (var r = 0; r < n - 1; r++)
        {
            var round = new List<Fixture>();
            for (var i = 0; i < n / 2; i++)
            {
                var a = slots[i];
                var b = slots[n - 1 - i];
                if (a < 0 || b < 0) continue;
                round.Add(r % 2 == 0 ? new Fixture(a, b) : new Fixture(b, a));
            }
            rounds.Add(round);
            // Rotaciona todos menos o primeiro.
            var last = slots[n - 1];
            slots.RemoveAt(n - 1);
            slots.Insert(1, last);
        }

        if (!doubleRound) return rounds;
        var second = rounds.Select(r => r.Select(f => f.Swapped()).ToList()).ToList();
        return Concat(rounds, second);
    }

    // ---- Tabelas fixas (best.t.g/a/v/y/b/h/a(9)/c/e/d) -----------------------

    public static List<List<Fixture>> ThreeTeams(bool doubleRound) =>
        FromTable(doubleRound ? FixtureTables.dc : FixtureTables.Jd, oneBased: false);

    public static List<List<Fixture>> FourTeams() =>
        FromTable(FixtureTables.Je, oneBased: false);

    /// <summary>5 times: turno único usa as 5 primeiras rodadas de <c>de</c>; dois turnos usam as 10.</summary>
    public static List<List<Fixture>> FiveTeams(bool doubleRound) =>
        FromTable(FixtureTables.de, oneBased: false, limit: doubleRound ? 0 : 5);

    public static List<List<Fixture>> SixTeams() =>
        FromTable(FixtureTables.Jf, oneBased: false);

    /// <summary>9 times: <c>dd</c> (base 1); o returno inverte o mando de todos os jogos.</summary>
    public static List<List<Fixture>> NineTeams(bool doubleRound) =>
        FromTable(FixtureTables.dd, oneBased: true, reverseSecondHalf: doubleRound);

    /// <summary>19 times: <c>cX</c> (base 1) sempre em dois turnos (<c>best.t.e</c>).</summary>
    public static List<List<Fixture>> NineteenTeams() =>
        FromTable(FixtureTables.cX, oneBased: true, reverseSecondHalf: true);

    // ---- Despachante (f.s.a) -------------------------------------------------

    /// <summary>
    /// Escolhe a tabela como <c>f.s.a()</c> (<c>f/s.java:603-689</c>): casos fixos para 3/4/5/6/9/19
    /// e o genérico com a regra de turnos <c>f/s.java:630-665</c> nos demais.
    /// </summary>
    public static List<List<Fixture>> ForLeague(FixtureOptions options, IGameRandom rng)
    {
        var n = options.TeamCount;
        switch (n)
        {
            case 4 when options.CompetitionId == 7700:
                return FourTeams();
            case 3:
                return ThreeTeams(options.DoubleRound);
            case 5:
                return FiveTeams(options.DoubleRound);
            case 6 when options.DoubleRound:
                return SixTeams();
            case 9:
                return NineTeams(doubleRound: true);
            case 19:
                return NineteenTeams();
        }

        var turns = ResolveGenericTurns(options);
        return turns > 0 && n % 2 == 0
            ? Generic(n, turns, rng)
            : GenericAny(n, options.DoubleRound, rng);
    }

    /// <summary>
    /// Regra de turnos do caminho genérico (<c>f/s.java:630-665</c>). Devolve 0 quando deve cair no
    /// gerador corrigido (ex.: número ímpar sem tabela fixa).
    /// </summary>
    public static int ResolveGenericTurns(FixtureOptions options)
    {
        var n = options.TeamCount;
        var bl2 = options.IsNationalLeague
            ? n != 30 && n != 26 && n != 28 && n != 36
            : options.DoubleRound;

        if (!options.IsNationalLeague) return bl2 ? 2 : 1;

        if (options.Phase != LeaguePhase.Regular) return bl2 ? 2 : 1;
        if (n == 20 && options.CompetitionId == 1020) return 1;
        if (n == 8) return 4;
        if (n == 10) return options.ConfiguredTurns switch { 2 => 2, 3 => 3, _ => 4 };
        if (n == 12) return options.ConfiguredTurns == 2 ? 2 : 3;
        if (n == 14) return options.ConfiguredTurns == 2 ? 2 : 3;
        return bl2 ? 2 : 1;
    }

    // ---- Internos ------------------------------------------------------------

    private static List<List<Fixture>> FromTable(
        int[][][] table, bool oneBased, bool reverseSecondHalf = false, int limit = 0)
    {
        var rounds = new List<List<Fixture>>();
        var rows = limit > 0 ? Math.Min(limit, table.Length) : table.Length;
        for (var r = 0; r < rows; r++)
        {
            var round = new List<Fixture>(table[r].Length);
            for (var p = 0; p < table[r].Length; p++)
                round.Add(new Fixture(table[r][p][0] - (oneBased ? 1 : 0), table[r][p][1] - (oneBased ? 1 : 0)));
            rounds.Add(round);
        }
        if (reverseSecondHalf)
        {
            var extra = rounds.Select(r => r.Select(f => f.Swapped()).ToList()).ToList();
            rounds.AddRange(extra);
        }
        return rounds;
    }

    private static List<List<Fixture>> FromTable(int[][] table, bool oneBased)
    {
        var rounds = new List<List<Fixture>>();
        foreach (var row in table)
            rounds.Add(new List<Fixture> { new(row[0] - (oneBased ? 1 : 0), row[1] - (oneBased ? 1 : 0)) });
        return rounds;
    }

    private static int Mod(int a, int m) => ((a % m) + m) % m;

    private static List<List<Fixture>> Concat(params List<List<Fixture>>[] parts)
    {
        var result = new List<List<Fixture>>();
        foreach (var part in parts) result.AddRange(part);
        return result;
    }
}
