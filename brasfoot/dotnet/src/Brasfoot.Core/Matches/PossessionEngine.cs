using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

/// <summary>
/// Motor de posse e gols (<c>c.b</c>). Cada tick o lado com a posse disputa o meio-campo,
/// depois ataque contra defesa e, se passar, finaliza. A posse alterna a cada tick.
/// </summary>
public sealed class PossessionEngine
{
    // Pesos base de finalização: gol, defesa do goleiro, para fora. Encolhem com gols marcados.
    private static readonly double[] ShotBase = [5.5, 35.55, 15.0];
    private static readonly double[] ShotBaseAfter3 = [4.5, 40.55, 15.0];
    private static readonly double[] ShotBaseAfter5 = [3.0, 40.55, 15.0];
    private static readonly double[] ShotBaseAfter6 = [0.5, 40.55, 15.0];
    private static readonly double[] MidfieldBase = [55, 45];
    private static readonly double[] AttackBase = [50, 50];
    private static readonly double[] MarkingBonus = [0.0, 0.04, 0.08];

    // Peso por slot: chance de finalizar (Tx), de dar assistência (Ty), de fazer gol contra (Tz).
    private static readonly double[] ShooterWeight =
        [-1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 4, 4, 4, 8, 8, 8, 8, 22, 22, 22, 22, 22, 22, 22, 22];
    private static readonly double[] AssistWeight =
        [1, 1, 10, 2, 2, 2, 2, 2, 2, 10, 10, 4, 4, 4, 20, 20, 20, 10, 10, 10, 10, 10, 10, 10, 10, 10];
    private static readonly double[] OwnGoalWeight =
        [-1, 1, 5, 18, 18, 18, 18, 18, 18, 5, 1, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1];

    private readonly Match _match;
    private readonly GameContext _ctx;
    private readonly IGameRandom _random;
    private readonly bool _neutral;
    private readonly bool _humanInvolved;

    /// <summary>Lado com a posse neste tick (<c>TB</c>).</summary>
    private int _side;

    /// <summary>Gols contados por este motor, por lado (<c>zA</c>).</summary>
    private readonly int[] _goals = new int[2];

    private Player? _shooter;

    public PossessionEngine(Match match, GameContext ctx)
    {
        _match = match;
        _ctx = ctx;
        _random = ctx.Random;
        _side = _random.NextBool() ? 0 : 1;
        _neutral = match.Competition.IsNeutralVenue;
        _humanInvolved = match.InvolvesHuman;

        foreach (var p in match.Lineup[0].Concat(match.Lineup[1]).Concat(match.Bench[0]).Concat(match.Bench[1]))
        {
            p.Sheet.Reset();
            p.YellowsInMatch = 0;
        }
    }

    private int Other => 1 - _side;

    /// <summary>Um tick (<c>vO()</c>). Devolve o evento de gol, se houver.</summary>
    public MatchEvent? Tick()
    {
        MatchEvent? goal = null;
        var winner = MidfieldDuel();
        if (winner == _side && AttackVersusDefense() == 0)
        {
            _match.Shots[_side]++;
            goal = Shot();
        }
        else if (_random.NextInt(100) < 50)
        {
            _match.Tackles[Other]++;
        }
        else
        {
            _match.MisplacedPasses[_side]++;
        }
        _side = Other;
        return goal;
    }

    // ---- Força individual e por setor ----

    /// <summary>Força de partida do jogador, ~0.1..10 (<c>B(F)</c>).</summary>
    public double PlayerStrength(Player p)
    {
        var n = p.Strength;
        if (Pitch.IsOutOfPosition(p)) n = JMath.RoundInt(n * 0.5);
        if (n <= 0) n = 1;

        var home = _match.Home;
        var away = _match.Away;
        var club = p.Club;
        switch (_match.Competition.Type)
        {
            case CompetitionType.Selecoes:
                if (p.Nationality == home.CountryId) n = ScaleByNationalReputation(n, home.Reputation);
                else if (p.Nationality == away.CountryId) n = ScaleByNationalReputation(n, away.Reputation);
                break;
            case CompetitionType.Internacional1 when club != null:
                if (club.Reputation < 3) n = JMath.RoundInt(n * 0.75);
                else if (club.Reputation == 3) n = JMath.RoundInt(n * 0.85);
                else if (club.CountryId == Countries.Brasil) n = JMath.RoundInt(n * 0.9);
                break;
            case CompetitionType.Mundial when club != null:
                if (club.Reputation < 3) n = JMath.RoundInt(n * 0.55);
                else if (club.Reputation == 3) n = JMath.RoundInt(n * 0.75);
                else if (club.Continent != Continent.Europa) n = JMath.RoundInt(n * 0.9);
                break;
            case CompetitionType.Nacional when club != null:
                if (club.Reputation < 3) n = JMath.RoundInt(n * 0.85);
                else if (club.Reputation == 3) n = JMath.RoundInt(n * 0.95);
                break;
            case CompetitionType.Estadual or CompetitionType.CopaNacional:
                // Ajuda ao "gigante" visitante contra pequeno mandante.
                if (home.Reputation < 3 && away.Reputation >= 3 && club == away) n = JMath.RoundInt(n * 0.8);
                break;
        }
        return n / 10.0;
    }

    private static int ScaleByNationalReputation(int n, int reputation) => reputation switch
    {
        < 3 => JMath.RoundInt(n * 0.65),
        3 => JMath.RoundInt(n * 0.85),
        4 => JMath.RoundInt(n * 0.95),
        _ => n,
    };

    /// <summary>Soma da força dos primeiros <paramref name="max"/> jogadores em campo nos slots dados.</summary>
    private (double Sum, int Count) SectorSum(int side, int fromSlot, int toSlot, int max)
    {
        double sum = 0;
        var count = 0;
        foreach (var p in _match.OnPitch[side])
        {
            if (count < max && p.Slot >= fromSlot && p.Slot <= toSlot)
            {
                sum += PlayerStrength(p);
                count++;
            }
        }
        return (sum, count);
    }

    private double Midfield(int side)
    {
        var marking = (int)_match.TeamOf(side).Tactics.Marking;
        if (marking >= MarkingBonus.Length) marking = 2;
        var (sum, count) = SectorSum(side, 10, 17, 5);
        return count < 3 ? 0.01 : (MarkingBonus[marking] + sum) / 5.0;
    }

    private double Defense(int side)
    {
        var (sum, count) = SectorSum(side, 2, 9, 5);
        return count < 3 ? 0.01 : sum / 5.0;
    }

    /// <summary>Ataque: slots 19..25 (o 18 fica de fora e o 25 entra, como no original).</summary>
    private double Attack(int side)
    {
        var (sum, count) = SectorSum(side, 19, 25, 3);
        return count < 1 ? 0.0 : sum / 3.0;
    }

    private double Goalkeeper(int side)
    {
        var gk = _match.OnPitch[side].FirstOrDefault(p => p.Slot == Pitch.Goalkeeper);
        if (gk == null) return 0.1;
        var value = PlayerStrength(gk);
        return Pitch.IsOutOfPosition(gk) ? JMath.RoundInt(value * 0.2) : value;
    }

    private int CentreBacks(int side) => _match.OnPitch[side].Count(p => p.Slot is >= 3 and <= 8);

    private double DuelDiff(double x, double y) => (x - y) / (_ctx.Season >= 5 ? 11 : 8);
    private double ShotDiff(double x, double y) => (x - y) / (_ctx.Season >= 5 ? 10 : 8);

    // ---- Etapas do tick ----

    /// <summary>Disputa de meio-campo (<c>vR()</c>). Devolve o lado vencedor.</summary>
    private int MidfieldDuel()
    {
        var mine = Midfield(_side);
        var theirs = Midfield(Other);
        var d2 = 1.0 + DuelDiff(mine, theirs);
        var d3 = 1.0 + DuelDiff(theirs, mine);
        if (!_neutral && _side == 0) d2 += 0.3;
        d2 = Math.Max(d2, 0.2);
        d3 = Math.Max(d3, 0.2);

        var winner = PickStrict(MidfieldBase, [d2, d3]) == 0 ? _side : Other;
        _match.PossessionTicks[winner]++;
        var total = _match.PossessionTicks[0] + _match.PossessionTicks[1];
        _match.Possession[0] = JMath.RoundInt(100.0 * _match.PossessionTicks[0] / total);
        _match.Possession[1] = JMath.RoundInt(100.0 * _match.PossessionTicks[1] / total);
        return winner;
    }

    /// <summary>Ataque contra defesa (<c>vS()</c>). 0 = o ataque passa e finaliza.</summary>
    private int AttackVersusDefense()
    {
        var defense = Defense(Other);
        var attack = Attack(_side);
        var d4 = 1.0 + DuelDiff(attack, defense);
        var d5 = 1.0 + DuelDiff(defense, attack);
        if (defense == 0.0) d5 = 0.1;
        if (!_neutral && _side == 0) d4 += 0.3;
        if (attack == 0.0) d4 = 0.1;
        d4 = Math.Max(d4, 0.2);
        d5 = Math.Max(d5, 0.2);
        if (_humanInvolved)
        {
            var cb = CentreBacks(Other);
            if (cb == 0) d5 = 0.1;
            else if (cb == 1) d5 = 0.05;
        }
        return PickStrict(AttackBase, [d4, d5]);
    }

    /// <summary>Finalização (<c>vT()</c>): gol, defesa ou para fora.</summary>
    private MatchEvent? Shot()
    {
        var defense = Defense(Other);
        var attack = Attack(_side);
        _shooter = PickShooter();
        var shooterStrength = _shooter == null ? 0.1 : PlayerStrength(_shooter);
        var keeper = Goalkeeper(Other);

        var saved = 1.0 + ShotDiff(keeper, shooterStrength);
        var off = 1.0 + ShotDiff(defense, attack);
        if (_humanInvolved)
        {
            var cb = CentreBacks(Other);
            if (cb == 0) saved = JMath.RoundInt(saved * 0.2);
            else if (cb == 1) saved = JMath.RoundInt(saved * 0.4);
        }
        if (!_neutral)
        {
            // Original: o fator defesa x ataque é descartado em todo jogo com mando (quirk Q1).
            if (_side == 0) off = (saved += 0.1) + 0.1;
            else off = (saved -= 0.1) - 0.1;
        }

        var weights = _goals[_side] >= 6 ? ShotBaseAfter6
            : _goals[_side] >= 5 ? ShotBaseAfter5
            : _goals[_side] >= 3 ? ShotBaseAfter3
            : ShotBase;
        if (_goals[_side] >= 2 && _match.TeamOf(Other).Reputation - _match.TeamOf(_side).Reputation >= 2)
            weights = ShotBaseAfter5;
        saved = Math.Max(saved, 0.2);
        off = Math.Max(off, 0.2);

        switch (PickStrict(weights, [1.0, saved, off]))
        {
            case 0:
                var goal = new MatchEvent(_side) { Team = _match.TeamOf(_side) };
                BuildGoal(goal, _shooter);
                _match.ShotsOnTarget[_side]++;
                return goal;
            case 1:
                _match.ShotsOnTarget[_side]++;
                if (_shooter != null) _shooter.Sheet.ShotsSaved++;
                return null;
            default:
                _match.ShotsOffTarget[_side]++;
                return null;
        }
    }

    /// <summary>Tipo do gol, autor e assistência (<c>a(A, F)</c>).</summary>
    private void BuildGoal(MatchEvent ev, Player? shooter)
    {
        var fix = _ctx.Options.FixOriginalBugs;
        var onPitch = _match.OnPitch[_side];
        var team = _match.TeamOf(_side);
        ev.Type = MatchEventType.Gol;
        ev.Player = shooter;

        var roll = _random.NextInt(1000);
        var type = roll < 900 ? GoalType.Normal
            : roll < 950 ? GoalType.Penalty
            : roll < 980 ? GoalType.Falta
            : roll < 990 ? GoalType.Contra
            : roll < 995 ? GoalType.Olimpico
            : GoalType.Normal;

        shooter ??= PickShooter();
        if (!fix && shooter != null && type is not (GoalType.Penalty or GoalType.Contra)) shooter.Sheet.Goals++;

        if (type == GoalType.Normal)
        {
            var assister = PickAssister(shooter);
            if (assister != null && assister != shooter)
            {
                assister.Sheet.Assists++;
                ev.Player2 = assister;
            }
        }
        if (shooter != null && type == GoalType.Olimpico)
        {
            if (team.CornerTaker != null && onPitch.Contains(team.CornerTaker)) ev.Player = team.CornerTaker;
            else if (shooter.Position == Position.Goleiro) type = GoalType.Normal;
        }
        if (type == GoalType.Contra)
        {
            var ownGoal = PickOwnGoalScorer();
            if (ownGoal != null)
            {
                ev.Player = ownGoal;
                ownGoal.Sheet.OwnGoals++;
            }
            else
            {
                type = GoalType.Normal;
                if (!fix && shooter != null) shooter.Sheet.Goals++;
            }
        }
        if (type is GoalType.Penalty or GoalType.Falta && team.FreeKickTaker != null && onPitch.Contains(team.FreeKickTaker))
            ev.Player = team.FreeKickTaker;

        var deferred = false;
        if (type == GoalType.Penalty)
        {
            ev.PenaltyCounted = true;
            if (_humanInvolved)
            {
                // Com humano em campo o pênalti é cobrado "ao vivo" e só depois conta.
                deferred = true;
                ev.PenaltyCounted = false;
                ev.PenaltyPending = true;
            }
        }
        if (!deferred)
        {
            _goals[_side]++;
            _match.Score[_side]++;
            if (fix)
            {
                if (type != GoalType.Contra && ev.Player != null) ev.Player.Sheet.Goals++;
            }
            else if (shooter != null)
            {
                shooter.Sheet.Goals++; // quirk Q2: segundo incremento, sempre no finalizador original
            }
        }
        ev.GoalType = type;
    }

    /// <summary>Conta um pênalti adiado que foi convertido (<c>a/gb</c>).</summary>
    internal void CountDeferredPenalty(int side) => _goals[side]++;

    /// <summary>Quem finaliza (<c>vU()</c>): peso por slot, +4 Finalização, +2 Cabeceio (+2 se zagueiro).</summary>
    private Player? PickShooter()
    {
        var list = _match.OnPitch[_side];
        double Weight(Player p)
        {
            var w = ShooterWeight[p.Slot];
            if (p.Has(Characteristic.Finalizacao)) w += 4;
            else if (p.Has(Characteristic.Cabeceio))
            {
                w += 2;
                if (p.Position == Position.Zagueiro) w += 2;
            }
            return w;
        }
        bool Candidate(Player p) => p.Slot != Pitch.Goalkeeper && p.Position != Position.Goleiro && p.Slot > 0 && p.Slot < ShooterWeight.Length;

        var total = list.Where(Candidate).Sum(Weight);
        var r = _random.NextDouble() * total;
        double acc = 0;
        foreach (var p in list)
        {
            if (Candidate(p)) acc += Weight(p);
            if (r <= acc) return p;
        }
        return list.Count > 1 ? list[^1] : null;
    }

    /// <summary>Assistência (<c>C(F)</c>): 19% sem assistência; pesos por slot e características.</summary>
    private Player? PickAssister(Player? scorer)
    {
        if (_random.NextInt(100) > 80) return null;
        var list = _match.OnPitch[_side];
        var marking = _match.TeamOf(_side).Tactics.Marking;
        var fix = _ctx.Options.FixOriginalBugs;

        double Weight(Player p, double velocidadeBonus)
        {
            var w = AssistWeight[p.Slot];
            if (p.Has(Characteristic.Passe))
            {
                w += 10;
                if (p.Has(Characteristic.Armacao)) w += 5;
            }
            else if (p.Has(Characteristic.Armacao))
            {
                w += 2;
                if (p.Cr1Is(Characteristic.Drible)) w += 2;
            }
            else if (p.Has(Characteristic.Drible))
            {
                w += 2;
                if (p.Cr1Is(Characteristic.Velocidade)) w += 2;
            }
            else if (p.Has(Characteristic.Velocidade))
            {
                w += velocidadeBonus;
                if (p.Position == Position.Lateral) w += 2;
            }
            else if (p.Has(Characteristic.Cruzamento))
            {
                w += 5;
                if (p.Position == Position.Lateral) w += 2;
            }
            // Quirk Q4: o bônus de lateral depende da marcação (provavelmente era a jogada "pelas laterais").
            if (marking == Marking.Pesada && p.Position == Position.Lateral) w += 20;
            return w;
        }
        bool Candidate(Player p) => p != scorer && p.Slot > 0 && p.Slot < AssistWeight.Length;

        // Quirk Q5: Velocidade vale +1 na soma e +2 no sorteio.
        var total = list.Where(Candidate).Sum(p => Weight(p, fix ? 2 : 1));
        var r = _random.NextDouble() * total;
        double acc = 0;
        foreach (var p in list)
        {
            if (Candidate(p)) acc += Weight(p, 2);
            if (r <= acc) return p;
        }
        return null;
    }

    /// <summary>Autor do gol contra, do time que defende (<c>vV()</c>).</summary>
    private Player? PickOwnGoalScorer()
    {
        var list = _match.OnPitch[Other];
        bool Candidate(Player p) => p.Slot >= 0 && p.Slot < OwnGoalWeight.Length;
        var total = list.Where(Candidate).Sum(p => OwnGoalWeight[p.Slot]);
        var r = _random.NextDouble() * total;
        double acc = 0;
        foreach (var p in list)
        {
            if (Candidate(p)) acc += OwnGoalWeight[p.Slot];
            if (r <= acc) return p;
        }
        return null;
    }

    /// <summary>Sorteio ponderado com comparação estrita (<c>r &lt; acumulado</c>).</summary>
    private int PickStrict(double[] baseWeights, double[] multipliers)
    {
        var weights = new double[baseWeights.Length];
        double total = 0;
        for (var i = 0; i < weights.Length; i++)
        {
            weights[i] = baseWeights[i] * multipliers[i];
            total += weights[i];
        }
        var r = _random.NextDouble() * total;
        double acc = 0;
        for (var i = 0; i < weights.Length; i++)
        {
            acc += weights[i];
            if (r < acc) return i;
        }
        return weights.Length;
    }
}
