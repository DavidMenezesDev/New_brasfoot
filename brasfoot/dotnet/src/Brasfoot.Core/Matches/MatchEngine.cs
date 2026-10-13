using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

/// <summary>
/// Executa os ticks de uma partida: camada de incidentes (<c>I.a(I, half, minute)</c>) seguida
/// do motor de posse (<c>c.b.vO()</c>).
/// </summary>
public sealed class MatchEngine
{
    // Faixas de slots para cartões e lesões (aq.sS). Slots 18 e 25 nunca aparecem (quirk Q10).
    private static readonly (int From, int To)[] Bands = [(10, 13), (14, 17), (3, 8), (2, 3), (8, 9), (19, 24), (1, 1)];
    private static readonly int[] MarkingYellowBonus = [30, 10, 0];

    private readonly Match _match;
    private readonly GameContext _ctx;
    private readonly IGameRandom _random;

    public MatchEngine(Match match, GameContext ctx)
    {
        _match = match;
        _ctx = ctx;
        _random = ctx.Random;
        Possession = new PossessionEngine(match, ctx);
    }

    public PossessionEngine Possession { get; }

    /// <summary>Um minuto de jogo (<c>I.q(minute, half)</c>).</summary>
    public void Tick(int half, int minute)
    {
        Incidents(half, minute);
        var goal = Possession.Tick();
        if (goal == null) return;

        goal.Minute = minute;
        goal.Half = half;
        _match.Events.Add(goal);
        if (goal.PenaltyPending) ResolvePenalty(goal);
        if (goal.Type == MatchEventType.Gol && goal.Player2 != null)
        {
            _match.Events.Add(new MatchEvent(goal.Side)
            {
                Type = MatchEventType.Assistencia, Minute = minute, Half = half, Player = goal.Player2, Team = goal.Team,
            });
        }
    }

    // ---- Camada de incidentes ----

    private void Incidents(int half, int minute)
    {
        int side = _random.NextInt(100) > 55 ? 0 : 1;
        var list = _match.OnPitch[side];
        var marking = (int)_match.TeamOf(side).Tactics.Marking;
        if (marking >= MarkingYellowBonus.Length) marking = 0;

        var band = minute < 15 ? 0 : minute < 30 ? 1 : 2;
        if (minute % 7 == 0) Fatigue(half);

        int yellow, red, injury;
        if (half == 1)
        {
            yellow = new[] { 70, 40, 30 }[band] + MarkingYellowBonus[marking];
            red = new[] { 1200, 900, 800 }[band];
            injury = new[] { 1500, 1000, 800 }[band];
        }
        else
        {
            yellow = new[] { 45, 40, 30 }[band] + MarkingYellowBonus[marking];
            red = new[] { 800, 700, 550 }[band];
            injury = new[] { 800, 600, 600 }[band];
        }
        if (_match.YellowCount > 5) yellow *= 2;
        if (_match.RedCount >= 2) yellow = red * 2;
        if (_match.InjuryCount >= 1) yellow = injury * 5; // quirk Q9: amarelos quase somem após a 1ª lesão

        if (_random.NextInt(yellow) == 1)
        {
            var p = PickYellow(list);
            _match.YellowCount++;
            if (p != null)
            {
                p.YellowsInMatch++;
                CreateEvent(p.YellowsInMatch == 2 ? MatchEventType.AmareloVermelho : MatchEventType.Amarelo, side, p, null, half, minute);
            }
        }
        else if (_random.NextInt(red) == 1)
        {
            var p = PickRed(list);
            if (p != null) CreateEvent(MatchEventType.Vermelho, side, p, null, half, minute);
            _match.RedCount++;
        }
        else if (_random.NextInt(injury) == 1)
        {
            _match.InjuryCount++;
            var p = PickInjury(list);
            if (p != null) CreateEvent(MatchEventType.Contusao, side, p, null, half, minute);
        }
        else if (half == 2 && minute >= 5)
        {
            AiSubstitutions(half, minute);
        }
    }

    private Player? PickYellow(List<Player> list)
    {
        var n = _random.NextInt(100);
        var band = n < 25 ? 0 : n < 40 ? 1 : n < 65 ? 2 : n < 73 ? 3 : n < 82 ? 4 : n < 85 ? 6 : 5;
        return PickInBand(list, band);
    }

    private Player? PickRed(List<Player> list)
    {
        var n = _random.NextInt(200);
        var band = n == 0 ? 6 : n < 80 ? 0 : n < 110 ? 1 : n < 160 ? 2 : n < 170 ? 3 : n < 190 ? 4 : 5;
        return PickInBand(list, band);
    }

    private Player? PickInjury(List<Player> list)
    {
        var n = _random.NextInt(500);
        var band = n == 0 ? 6 : n < 150 ? 0 : n < 250 ? 1 : n < 320 ? 2 : n < 360 ? 3 : n < 420 ? 4 : 5;
        return PickInBand(list, band);
    }

    private Player? PickInBand(List<Player> list, int band) => PickInSlots(list, Bands[band].From, Bands[band].To);

    /// <summary>Jogador aleatório em campo com slot na faixa (<c>I.a(list, lo, hi)</c>).</summary>
    private Player? PickInSlots(List<Player> list, int from, int to)
    {
        var candidates = list.Where(p => p.Slot >= from && p.Slot <= to).ToList();
        _random.Shuffle(candidates);
        return candidates.FirstOrDefault();
    }

    /// <summary>Cansaço a cada 7 minutos: todos menos o goleiro (que só cansa no 2º tempo).</summary>
    private void Fatigue(int half)
    {
        foreach (var p in _match.OnPitch[0].Concat(_match.OnPitch[1]))
        {
            if (p.Slot != Pitch.Goalkeeper || half == 2) LoseEnergy(p);
        }
    }

    /// <summary><c>F.fq()</c>: perda de energia por idade.</summary>
    private static void LoseEnergy(Player p)
    {
        var loss = p.Age <= 20 ? 1 : p.Age <= 25 ? 2 : p.Age <= 31 ? 3 : p.Age <= 36 ? 4 : 5;
        p.Energy -= loss;
        if (p.Energy < 0) p.Energy = 1;
    }

    /// <summary>Cria e aplica um evento disciplinar, de lesão ou de substituição (<c>I.a(type, …)</c>).</summary>
    private MatchEvent CreateEvent(MatchEventType type, int side, Player player, Player? player2, int half, int minute)
    {
        var team = _match.TeamOf(side);
        var ev = new MatchEvent(side) { Type = type, Player = player, Player2 = player2, Team = team, Half = half, Minute = minute };
        _match.Events.Add(ev);

        switch (type)
        {
            case MatchEventType.Amarelo:
                player.Sheet.Yellows++;
                break;
            case MatchEventType.Vermelho:
                player.Sheet.Reds++;
                break;
            case MatchEventType.AmareloVermelho:
                player.Sheet.Yellows++;
                player.Sheet.Reds++;
                break;
        }

        if (type is MatchEventType.AmareloVermelho or MatchEventType.Vermelho)
        {
            _match.OnPitch[side].Remove(player);
            if (player.Slot <= 13 && !team.IsHuman && _match.SubsLeft[side] > 0)
                ReplacePlayer(side, player, reshuffle: true, injury: false, half, minute);
        }
        else if (type == MatchEventType.Contusao)
        {
            PostMatch.Injure(player, _ctx);
            if (!team.IsHuman)
            {
                _match.OnPitch[side].Remove(player);
                if (_match.SubsLeft[side] > 0) ReplacePlayer(side, player, reshuffle: false, injury: true, half, minute);
            }
        }
        return ev;
    }

    /// <summary>
    /// Repõe um jogador (<c>I.a(side, reshuffle, I, F, half, minute, injury)</c>). Após expulsão
    /// a IA sacrifica um atacante (ou meia) para recompor a posição do expulso.
    /// </summary>
    private void ReplacePlayer(int side, Player lost, bool reshuffle, bool injury, int half, int minute)
    {
        var onPitch = _match.OnPitch[side];
        Player? leaving;
        if (reshuffle)
        {
            leaving = PickInSlots(onPitch, 18, 25) ?? PickInSlots(onPitch, 14, 17);
            if (leaving == null && lost.Slot == Pitch.Goalkeeper) leaving = PickInSlots(onPitch, 2, 25);
        }
        else
        {
            leaving = lost;
        }
        if (leaving == null || lost.Slot < 0) return;

        var incoming = LineupSelector.BestFit(_match.Bench[side], lost.Slot);
        if (incoming == null) return;
        // Na lesão, goleiro só entra no lugar de goleiro.
        if (injury && !(leaving.Position == Position.Goleiro || incoming.Position != Position.Goleiro)) return;
        Substitute(side, leaving, incoming, half, minute, lost.Slot);
    }

    /// <summary>Efetua a troca (<c>I.a(side, out, in, half, minute, slot)</c>).</summary>
    public MatchEvent Substitute(int side, Player leaving, Player incoming, int half, int minute, int slot = 0)
    {
        incoming.Slot = slot > 0 ? slot : leaving.Slot;
        _match.SubsLeft[side]--;
        _match.OnPitch[side].Remove(leaving);
        _match.OnPitch[side].Add(incoming);
        _match.SubbedOn[side].Add(incoming);
        incoming.PlayedThisRound = true;
        _match.Bench[side].Remove(incoming);
        return CreateEvent(MatchEventType.Substituicao, side, leaving, incoming, half, minute);
    }

    // ---- Substituições da IA (I.m) ----

    /// <summary>Decisões de substituição da IA no 2º tempo (também chamada no intervalo com minuto 0).</summary>
    public void AiSubstitutions(int half, int minute)
    {
        if (half != 2) return;
        var homeSubbed = false;
        if (!_match.Home.IsHuman && _match.SubsLeft[0] > 0)
        {
            if (minute == 0 && Losing(0, 1))
            {
                if (_random.NextInt(100) > 50) homeSubbed = RandomSub(0, half, minute);
            }
            else if (IsChaseMinute(0, minute))
            {
                if (Losing(0, 1) || _match.Score[0] == _match.Score[1]) homeSubbed = RandomSub(0, half, minute);
            }
            else if (IsEnergyMinute(0, minute))
            {
                homeSubbed = EnergySub(0, half, minute);
            }
        }
        if (homeSubbed || _match.Away.IsHuman || _match.SubsLeft[1] <= 0) return;

        if (minute == 0 && Losing(1, 2))
        {
            if (_random.NextInt(100) > 50) RandomSub(1, half, minute);
        }
        else if (IsChaseMinute(1, minute))
        {
            if (Losing(1, 1)) RandomSub(1, half, minute);
        }
        else if (IsEnergyMinute(1, minute))
        {
            EnergySub(1, half, minute);
        }
    }

    private bool Losing(int side, int by) => _match.Score[1 - side] - _match.Score[side] >= by;

    // Minutos não sorteados valem 0, então coincidem com a chamada do intervalo (minuto 0), como no original.
    private bool IsChaseMinute(int side, int minute) =>
        minute == _match.ChaseSubMinutes[side, 0] || minute == _match.ChaseSubMinutes[side, 1] || minute == _match.ChaseSubMinutes[side, 2];

    private bool IsEnergyMinute(int side, int minute) =>
        minute == _match.EnergySubMinutes[side, 0] || minute == _match.EnergySubMinutes[side, 1]
        || minute == _match.EnergySubMinutes[side, 2] || minute == _match.EnergySubMinutes[side, 3];

    /// <summary>Troca o primeiro jogador de linha com energia abaixo do limite (60; 90 após os 40').</summary>
    private bool EnergySub(int side, int half, int minute)
    {
        var list = _match.OnPitch[side];
        var threshold = 60;
        var start = 0;
        if (minute > 40)
        {
            threshold = 90;
            if (list.Count > 0) start = _random.NextInt(list.Count);
        }
        for (var i = start; i < list.Count; i++)
        {
            if (list[i].Slot != Pitch.Goalkeeper && list[i].Energy < threshold)
            {
                ReplacePlayer(side, list[i], reshuffle: false, injury: false, half, minute);
                return true;
            }
        }
        return false;
    }

    /// <summary>Troca um jogador de linha aleatório que ainda não tenha entrado.</summary>
    private bool RandomSub(int side, int half, int minute)
    {
        var list = _match.OnPitch[side];
        if (list.Count == 0) return false;
        // Quirk Q6: o original sempre consulta a lista de quem entrou do mandante.
        var subbedOn = _ctx.Options.FixOriginalBugs ? _match.SubbedOn[side] : _match.SubbedOn[0];
        var i = _random.NextInt(list.Count);
        if (subbedOn.Contains(list[i])) i = _random.NextInt(list.Count);
        if (list[i].Slot == Pitch.Goalkeeper || subbedOn.Contains(list[i])) return false;
        ReplacePlayer(side, list[i], reshuffle: false, injury: false, half, minute);
        return true;
    }

    // ---- Pênaltis ----

    /// <summary>
    /// Cobrança de pênalti em partida com humano (<c>a/gb.nO()</c>): 70% base, ±10/±5 por
    /// Finalização, Top Mundial e Estrela do batedor, Defesa Penalty, Top Mundial e Estrela do goleiro.
    /// </summary>
    private void ResolvePenalty(MatchEvent ev)
    {
        ev.PenaltyPending = false;
        var side = ev.Side;
        var taker = ev.Player;
        if (taker == null) return;
        var keeper = _match.OnPitch[1 - side].FirstOrDefault(p => p.Slot == Pitch.Goalkeeper);

        var chance = 70;
        if (taker.Has(Characteristic.Finalizacao) || taker.IsWorldClass) chance += 10;
        if (taker.IsStar) chance += 5;
        if (keeper != null)
        {
            if (keeper.Has(Characteristic.DefesaPenalty)) chance -= 10;
            if (keeper.IsWorldClass) chance -= 10;
            if (keeper.IsStar) chance -= 5;
        }

        _match.Shots[side]++;
        if (_random.NextInt(100) + 1 <= chance)
        {
            _match.Score[side]++;
            _match.ShotsOnTarget[side]++;
            taker.Sheet.Goals++;
            ev.PenaltyCounted = true;
            Possession.CountDeferredPenalty(side);
            return;
        }

        taker.Sheet.PenaltiesMissed++;
        var flavor = _random.NextInt(7);
        if (flavor is 2 or 6) _match.ShotsOffTarget[side]++;
        else _match.ShotsOnTarget[side]++;
        ev.Type = MatchEventType.PenaltyPerdido;
        if (flavor is 0 or 3 or 5 && keeper != null)
        {
            keeper.Sheet.PenaltySaves++;
            ev.Player2 = keeper;
        }
    }
}
