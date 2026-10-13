using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

/// <summary>Escalação e táticas da IA (<c>ah.a(ah, I, side, formation, tactics)</c>).</summary>
public static class LineupSelector
{
    /// <summary>Probabilidade acumulada (1..100) de cada formação escolhida pela IA.</summary>
    private static readonly (int UpTo, int Formation)[] FormationOdds =
        [(2, 1), (4, 2), (7, 3), (38, 4), (49, 5), (60, 6), (65, 7), (72, 8), (90, 9), (92, 10), (100, 11)];

    /// <summary>Jogador apto: sem lesão, sem suspensão na competição e (clube humano) com contrato válido.</summary>
    public static bool IsEligible(Player p, Match match, GameContext ctx)
    {
        if (p.IsInjured(ctx.Today)) return false;
        if (!match.Competition.IsFriendly && p.CompetitionStats.TryGetValue(match.Competition.Id, out var rec) && rec.IsSuspended)
            return false;
        if (p.Club is { IsHuman: true } && p.ContractDaysLeft(ctx.Today) <= 0) return false;
        return true;
    }

    /// <param name="forcedFormation">Índice de formação a usar, ou null para sortear.</param>
    public static void Select(Team team, Match match, int side, GameContext ctx, int? forcedFormation = null, bool chooseTactics = true)
    {
        var random = ctx.Random;
        var available = new List<Player>();
        foreach (var p in team.Squad)
        {
            p.Slot = -1;
            if (IsEligible(p, match, ctx)) available.Add(p);
        }
        // Força desc, energia desc; ordenação estável como Collections.sort.
        available = available.OrderByDescending(p => p.Strength).ThenByDescending(p => p.Energy).ToList();

        match.Lineup[side].Clear();
        match.OnPitch[side].Clear();
        match.Bench[side].Clear();

        var roll = random.NextInt(100) + 1;
        var formation = FormationOdds.First(o => roll <= o.UpTo).Formation;
        if (forcedFormation is > 0) formation = forcedFormation.Value;

        foreach (var slot in Pitch.Formations[formation])
        {
            var p = BestFit(available, slot);
            if (p == null) continue;
            p.Slot = slot;
            p.PlayedThisRound = true;
            match.Lineup[side].Add(p);
            match.OnPitch[side].Add(p);
            available.Remove(p);
        }

        foreach (var slot in Pitch.BenchSlots)
        {
            var p = BestFit(available, slot);
            if (p == null) continue;
            match.Bench[side].Add(p);
            available.Remove(p);
        }

        if (chooseTactics)
        {
            var styleRoll = random.NextInt(100) + 1;
            var style = styleRoll <= 70 ? Style.Equilibrado : styleRoll <= 80 ? Style.AtaqueTotal : Style.ContraAtaque;
            var markRoll = random.NextInt(100) + 1;
            var marking = markRoll <= 5 ? Marking.MuitoPesada : markRoll <= 70 ? Marking.Leve : Marking.Pesada;
            var playRoll = random.NextInt(100) + 1;
            var play = playRoll <= 70 ? Play.PeloMeio : Play.PelasLaterais;
            team.Tactics = new Tactics(formation, style, marking, play);
        }
    }

    /// <summary>
    /// Melhor jogador da lista (já ordenada por força) para o slot (<c>ah.a(list, slot, …)</c>).
    /// Port literal: lado e linha desejados são variáveis reaproveitadas entre jogadores e
    /// passadas, exatamente como no original.
    /// </summary>
    public static Player? BestFit(IReadOnlyList<Player> list, int slot)
    {
        var (slotPosition, side, row) = Pitch.Slots[slot];
        var anySide = side == -1;
        var anyRow = row == -1;
        if (slot >= 18) row = -1;

        for (var pref = 0; pref <= 4; pref++)
        {
            var wantedPosition = Pitch.PositionPreference[slotPosition][pref];
            for (var pass = 1; pass <= 3; pass++)
            {
                foreach (var p in list)
                {
                    if (anySide) side = (int)p.Side;
                    if (anyRow) row = (int)p.Role;
                    if (pass == 2) side = (int)p.Side;
                    if (pass == 3)
                    {
                        side = (int)p.Side;
                        row = (int)p.Role;
                    }
                    if (wantedPosition == (int)p.Position && side == (int)p.Side && row == (int)p.Role)
                        return p;
                }
            }
        }
        return null;
    }
}
