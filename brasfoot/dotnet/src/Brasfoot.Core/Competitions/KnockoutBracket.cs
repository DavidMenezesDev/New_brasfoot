using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Um confronto de uma fase eliminatória (<c>f.G</c>): dois clubes e os jogos realizados. Em jogo
/// único só há <see cref="FirstLeg"/>; em ida e volta há também <see cref="SecondLeg"/> (mandante
/// invertido).
/// </summary>
public sealed class KnockoutPairing
{
    public KnockoutPairing(Team home, Team away)
    {
        Home = home;
        Away = away;
    }

    /// <summary>Mandante do 1º jogo (em jogo único, o mandante).</summary>
    public Team Home { get; }

    /// <summary>Visitante do 1º jogo (em jogo único, o visitante).</summary>
    public Team Away { get; }

    public Match? FirstLeg { get; internal set; }
    public Match? SecondLeg { get; internal set; }

    /// <summary>Vencedor do confronto depois de resolvido (<see cref="KnockoutBracket.ResolveRound"/>).</summary>
    public Team? Winner { get; internal set; }
}

/// <summary>Uma fase do mata-mata: os confrontos e seus vencedores.</summary>
public sealed class KnockoutRound
{
    internal KnockoutRound(List<KnockoutPairing> pairings) => Pairings = pairings;

    public IReadOnlyList<KnockoutPairing> Pairings { get; }

    /// <summary>
    /// Disputa de 3º lugar (<c>f/G.java:78</c>): criada junto com a fase final quando a competição
    /// marca <see cref="Competition.DecisaoTerceiroLugar"/> — jogo único entre os dois perdedores da
    /// semifinal, jogado junto com a ida da final (ver <see cref="KnockoutBracket.ResolveRound"/>).
    /// </summary>
    public KnockoutPairing? ThirdPlace { get; internal set; }

    /// <summary>Todos os confrontos já têm vencedor.</summary>
    public bool IsComplete => Pairings.Count > 0 && Pairings.All(p => p.Winner is not null);
}

/// <summary>
/// Chave eliminatória (<c>f.z</c> + <c>f.G</c>). Os times são emparelhados na ordem dada
/// (<c>f/G.java:64-76</c>: <c>(0,1),(2,3),…</c>) e os vencedores avançam para a fase seguinte. Cada
/// confronto é jogo único ou ida-e-volta; o desempate é resolvido por <see cref="KnockoutTiebreak"/>
/// (vitórias por jogo, agregado, gol fora, regra da competição 2129, pênaltis e, por fim, o quirk do
/// visitante da ida).
/// </summary>
/// <remarks>
/// <para>
/// A ida-e-volta é <em>por fase</em> (<c>duasVoltasMataMata[7]</c> = <c>f.z.ZK</c>): informe
/// <c>twoLeggedByRound</c> para reproduzir o agendamento do original; sem ele todas as fases seguem
/// <c>twoLegged</c>. O número de fases e os nomes saem de <see cref="KnockoutPlan"/>
/// (<c>f/z.java:38-71, 239-264, 342-371</c>).
/// </para>
/// <para>A posição explícita em <c>seeded</c> é o resultado de <see cref="BracketSeeder"/>. As
/// posições finais de temporada (<c>f/z.z</c>), a decisão de 3º lugar e o wrapper de prêmios de
/// <c>f.B</c> ainda não são portados.</para>
/// </remarks>
public sealed class KnockoutBracket
{
    private readonly bool[] _twoLegged;

    public KnockoutBracket(
        Competition competition,
        IReadOnlyList<Team> seeded,
        bool twoLegged = false,
        bool awayGoalsRule = false,
        bool shootoutAllowed = true,
        IReadOnlyList<bool>? twoLeggedByRound = null,
        int code = -1,
        int bracketType = 0)
    {
        if (seeded.Count < 2 || (seeded.Count & (seeded.Count - 1)) != 0)
            throw new ArgumentException("O mata-mata exige um número de times potência de 2 (>= 2).", nameof(seeded));
        Competition = competition;
        Seeded = seeded;
        TwoLegged = twoLegged;
        AwayGoalsRule = awayGoalsRule;
        ShootoutAllowed = shootoutAllowed;
        Code = code;
        BracketType = bracketType;
        LastRoundIndex = KnockoutPlan.RoundCount(seeded.Count) - 1;

        _twoLegged = new bool[LastRoundIndex + 1];
        for (var i = 0; i < _twoLegged.Length; i++)
            _twoLegged[i] = twoLeggedByRound is { } legs && i < legs.Count ? legs[i] : twoLegged;

        Rounds = [new KnockoutRound(BuildPairings(seeded))];
    }

    public Competition Competition { get; }
    public IReadOnlyList<Team> Seeded { get; }

    /// <summary>Ida-e-volta padrão (usada quando <c>twoLeggedByRound</c> não é informado).</summary>
    public bool TwoLegged { get; }

    public bool AwayGoalsRule { get; }
    public bool ShootoutAllowed { get; }

    /// <summary>Código da chave (<c>f.z.Zg</c>) — regras/nomes específicos (90, 1020, 1802…).</summary>
    public int Code { get; }

    /// <summary>Tipo da chave (<c>f.z.tR</c> / <c>b()</c>) — usado nos rótulos de preliminar.</summary>
    public int BracketType { get; }

    /// <summary>Índice da última fase (0-based; <c>f.z.ZG</c>).</summary>
    public int LastRoundIndex { get; }

    public List<KnockoutRound> Rounds { get; }

    /// <summary>Fase corrente (a última criada).</summary>
    public KnockoutRound CurrentRound => Rounds[^1];

    /// <summary>Campeão, quando a chave terminou.</summary>
    public Team? Champion
    {
        get
        {
            var last = Rounds[^1];
            return last.Pairings.Count == 1 ? last.Pairings[0].Winner : null;
        }
    }

    public bool IsComplete => Champion is not null;

    /// <summary>
    /// Nome da fase (0-based) na convenção de <c>f/z.io</c>. <paramref name="leg"/> &gt; 0 acrescenta
    /// o sufixo de jogo (ida/volta) quando a fase é de ida e volta.
    /// </summary>
    public string RoundName(int roundIndex, int leg = 0) =>
        KnockoutPlan.RoundName(LastRoundIndex, roundIndex, Code, BracketType, leg, TwoLeggedFor(roundIndex));

    /// <summary>Cria (sem jogar) os jogos de ida da fase corrente que ainda não existem.</summary>
    public List<Match> CreateFirstLegs(GameContext ctx)
    {
        var twoLegged = TwoLeggedFor(Rounds.Count - 1);
        var created = new List<Match>();
        foreach (var pairing in CurrentRound.Pairings)
        {
            if (pairing.FirstLeg is not null) continue;
            // No jogo de ida de um confronto de ida-e-volta não há pênaltis: quem eventualmente
            // vai à marca é a volta, depois do agregado.
            pairing.FirstLeg = new Match(pairing.Home, pairing.Away, Competition, ctx.Random, new KnockoutTie(
                FirstLeg: null, AwayGoalsRule: false, ShootoutAllowed: !twoLegged && ShootoutAllowed));
            created.Add(pairing.FirstLeg);
        }

        // Decisão de 3º lugar: jogo único, disputado junto com a ida da final (f/G.java:78-80).
        var thirdPlace = CurrentRound.ThirdPlace;
        if (thirdPlace is not null && thirdPlace.FirstLeg is null)
        {
            thirdPlace.FirstLeg = new Match(thirdPlace.Home, thirdPlace.Away, Competition, ctx.Random,
                new KnockoutTie(FirstLeg: null, AwayGoalsRule: false, ShootoutAllowed: ShootoutAllowed));
            created.Add(thirdPlace.FirstLeg);
        }
        return created;
    }

    /// <summary>
    /// Cria (sem jogar) os jogos de volta da fase corrente que ainda não existem. Só produz jogos
    /// quando a fase corrente é de ida e volta.
    /// </summary>
    public List<Match> CreateSecondLegs(GameContext ctx)
    {
        if (!TwoLeggedFor(Rounds.Count - 1)) return [];
        var created = new List<Match>();
        foreach (var pairing in CurrentRound.Pairings)
        {
            if (pairing.SecondLeg is not null || pairing.FirstLeg is null) continue;
            // O placar da ida, do ponto de vista do mandante da volta (o visitante da ida).
            var tie = new KnockoutTie(
                FirstLeg: (pairing.FirstLeg.Score[1], pairing.FirstLeg.Score[0]),
                AwayGoalsRule: AwayGoalsRule,
                ShootoutAllowed: ShootoutAllowed);
            pairing.SecondLeg = new Match(pairing.Away, pairing.Home, Competition, ctx.Random, tie);
            created.Add(pairing.SecondLeg);
        }
        return created;
    }

    /// <summary>
    /// Resolve os confrontos já jogados e, se a fase terminou, monta a fase seguinte a partir dos
    /// vencedores (na ordem dos confrontos). Devolve <c>true</c> se uma nova fase foi criada.
    /// </summary>
    public bool ResolveRound()
    {
        var round = CurrentRound;
        var twoLegged = TwoLeggedFor(Rounds.Count - 1);
        foreach (var pairing in round.Pairings)
        {
            if (pairing.Winner is not null) continue;
            if (pairing.FirstLeg is null || !pairing.FirstLeg.IsFinished) continue;
            if (twoLegged && (pairing.SecondLeg is null || !pairing.SecondLeg.IsFinished)) continue;
            var side = KnockoutTiebreak.Resolve(
                pairing.FirstLeg, twoLegged ? pairing.SecondLeg : null, AwayGoalsRule, Competition.Id);
            pairing.Winner = side == 0 ? pairing.Home : pairing.Away;
        }

        if (round.ThirdPlace is { Winner: null } thirdPlace && thirdPlace.FirstLeg is { IsFinished: true })
        {
            var side = KnockoutTiebreak.Resolve(thirdPlace.FirstLeg, null, awayGoalsRule: false, Competition.Id);
            thirdPlace.Winner = side == 0 ? thirdPlace.Home : thirdPlace.Away;
        }

        if (!round.IsComplete || round.Pairings.Count <= 1) return false;
        var newRound = new KnockoutRound(BuildPairings(round.Pairings.Select(p => p.Winner!).ToList()));
        Rounds.Add(newRound);

        // decisaoTerceiroLugar (at.mq(), f/G.java:78): quando a nova fase é a final (2 times), os dois
        // perdedores da última fase com exatamente 2 confrontos (a semifinal, f/z.zt(), f/z.java:150-169)
        // disputam o 3º lugar junto com ela.
        if (newRound.Pairings.Count == 1 && Competition.DecisaoTerceiroLugar)
        {
            var semifinal = Rounds.Take(Rounds.Count - 1).LastOrDefault(r => r.Pairings.Count == 2);
            if (semifinal is not null)
            {
                var losers = semifinal.Pairings
                    .Select(p => ReferenceEquals(p.Winner, p.Home) ? p.Away : p.Home)
                    .ToList();
                if (losers.Count == 2)
                    newRound.ThirdPlace = new KnockoutPairing(losers[0], losers[1]);
            }
        }
        return true;
    }

    /// <summary>
    /// Posições finais da temporada (<c>f/s.za</c>, <c>f/s.java:1578-1614</c>): percorre as fases de
    /// trás para frente, atribuindo posições sequenciais — vencedor antes do perdedor de cada
    /// confronto — pulando quem já recebeu posição numa fase posterior. Quando há decisão de 3º lugar
    /// ela entra na mesma varredura da fase final, então o vencedor fica em 3º e o perdedor em 4º; só
    /// funciona depois de <see cref="PlayAll"/> (confrontos sem <see cref="KnockoutPairing.Winner"/>
    /// são ignorados).
    /// </summary>
    public IReadOnlyList<(Team Team, int Position)> FinalPositions()
    {
        var positions = new List<(Team, int)>();
        var assigned = new HashSet<Team>();
        var next = 1;
        for (var i = Rounds.Count - 1; i >= 0; i--)
        {
            var round = Rounds[i];
            var pairings = round.Pairings.AsEnumerable();
            if (round.ThirdPlace is not null) pairings = pairings.Append(round.ThirdPlace);
            foreach (var pairing in pairings)
            {
                if (pairing.Winner is null) continue;
                var loser = ReferenceEquals(pairing.Winner, pairing.Home) ? pairing.Away : pairing.Home;
                if (assigned.Add(pairing.Winner)) positions.Add((pairing.Winner, next++));
                if (assigned.Add(loser)) positions.Add((loser, next++));
            }
        }
        return positions;
    }

    /// <summary>Joga a chave inteira (idas, voltas e fases seguintes) e devolve o campeão.</summary>
    public Team PlayAll(GameContext ctx)
    {
        while (!IsComplete)
        {
            PlayBatch(CreateFirstLegs(ctx), ctx);
            PlayBatch(CreateSecondLegs(ctx), ctx);
            ResolveRound();
        }
        return Champion!;
    }

    /// <summary>
    /// Joga uma única fase eliminatória sobre <paramref name="field"/> (tamanho par arbitrário — a
    /// Copa do Brasil tem fases de 80 e 40 clubes, que não são potência de dois): emparelha os
    /// consecutivos, cria a ida (e a volta, quando for o caso) e resolve. Devolve os vencedores na
    /// ordem dos confrontos, para a fase seguinte ser reordenada (como <c>f/f.ad..av</c>).
    /// </summary>
    /// <param name="tiebreakCompetitionId">
    /// Id usado no desempate. A Copa do Brasil passa o código da fase (2129..2729), porque a fase
    /// <c>2129</c> avança sempre o visitante (<c>f/G.java:298</c>).
    /// </param>
    public static IReadOnlyList<Team> PlaySingleRound(
        Competition competition,
        IReadOnlyList<Team> field,
        bool twoLegged,
        GameContext ctx,
        bool awayGoalsRule = false,
        bool shootoutAllowed = true,
        int? tiebreakCompetitionId = null)
    {
        ArgumentNullException.ThrowIfNull(competition);
        ArgumentNullException.ThrowIfNull(field);
        ArgumentNullException.ThrowIfNull(ctx);
        if (field.Count == 0 || field.Count % 2 != 0)
            throw new ArgumentException("A fase precisa de um número par de clubes.", nameof(field));

        var id = tiebreakCompetitionId ?? competition.Id;
        var pairings = BuildPairings(field);

        foreach (var pairing in pairings)
        {
            pairing.FirstLeg = new Match(pairing.Home, pairing.Away, competition, ctx.Random, new KnockoutTie(
                FirstLeg: null, AwayGoalsRule: false, ShootoutAllowed: !twoLegged && shootoutAllowed));
        }
        PlayBatch(pairings.Select(p => p.FirstLeg!).ToList(), ctx);

        if (twoLegged)
        {
            foreach (var pairing in pairings)
            {
                var tie = new KnockoutTie(
                    FirstLeg: (pairing.FirstLeg!.Score[1], pairing.FirstLeg.Score[0]),
                    AwayGoalsRule: awayGoalsRule,
                    ShootoutAllowed: shootoutAllowed);
                pairing.SecondLeg = new Match(pairing.Away, pairing.Home, competition, ctx.Random, tie);
            }
            PlayBatch(pairings.Select(p => p.SecondLeg!).ToList(), ctx);
        }

        var winners = new List<Team>(pairings.Count);
        foreach (var pairing in pairings)
        {
            var side = KnockoutTiebreak.Resolve(
                pairing.FirstLeg!, twoLegged ? pairing.SecondLeg : null, awayGoalsRule, id);
            pairing.Winner = side == 0 ? pairing.Home : pairing.Away;
            winners.Add(pairing.Winner);
        }
        return winners;
    }

    private bool TwoLeggedFor(int roundIndex) =>
        roundIndex >= 0 && roundIndex < _twoLegged.Length && _twoLegged[roundIndex];

    private static List<KnockoutPairing> BuildPairings(IReadOnlyList<Team> teams)
    {
        var pairings = new List<KnockoutPairing>();
        for (var i = 0; i + 1 < teams.Count; i += 2)
            pairings.Add(new KnockoutPairing(teams[i], teams[i + 1]));
        return pairings;
    }

    private static void PlayBatch(List<Match> matches, GameContext ctx)
    {
        if (matches.Count == 0) return;
        var teams = matches.SelectMany(m => new[] { m.Home, m.Away }).Distinct().ToList();
        MatchSimulator.PlayRound(matches, teams, ctx);
    }
}
