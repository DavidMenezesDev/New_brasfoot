using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

/// <summary>
/// Escalação escolhida pelo técnico humano. Titulares ficam em <see cref="Player.Slot"/> (slot do
/// campo na formação de <see cref="Tactics.Formation"/>) e reservas em <see cref="Player.BenchOrder"/>.
/// Se a escalação salva não for válida no dia do jogo, <see cref="Apply"/> não altera a partida e a
/// escalação automática da IA é usada.
/// </summary>
public static class HumanLineup
{
    public const int StarterCount = 11;

    public static bool IsAvailable(Player p, GameContext ctx) =>
        !p.IsInjured(ctx.Today) && p.ContractDaysLeft(ctx.Today) > 0;

    public static IReadOnlyList<Player> Starters(Team team) =>
        team.Squad.Where(p => p.Slot > 0).OrderBy(p => FormationOrder(team, p.Slot)).ToList();

    public static IReadOnlyList<Player> Bench(Team team) =>
        team.Squad.Where(p => p.BenchOrder >= 0).OrderBy(p => p.BenchOrder).ToList();

    public static void Clear(Team team)
    {
        foreach (var p in team.Squad)
        {
            p.Slot = -1;
            p.BenchOrder = -1;
        }
    }

    public static void SetFormation(Team team, int formation, GameContext ctx)
    {
        team.Tactics = team.Tactics with { Formation = formation };
        foreach (var p in team.Squad) p.Slot = -1;
        FillStarters(team, ctx);
    }

    /// <summary>Escolhe titulares e banco pela mesma regra da IA, respeitando a formação atual.</summary>
    public static void AutoFill(Team team, GameContext ctx)
    {
        Clear(team);
        FillStarters(team, ctx);

        var available = Available(team, ctx, excluding: Starters(team));
        foreach (var slot in Pitch.BenchSlots)
        {
            if (available.Count == 0) break;
            var p = LineupSelector.BestFit(available, slot);
            if (p is null) continue;
            p.BenchOrder = CountBench(team);
            available.Remove(p);
        }
    }

    /// <summary>Alterna o titular: tira do campo ou coloca no primeiro slot livre compatível.</summary>
    public static bool ToggleStarter(Team team, Player p, GameContext ctx)
    {
        if (p.Slot > 0)
        {
            p.Slot = -1;
            return true;
        }
        if (!team.Squad.Contains(p) || Starters(team).Count >= StarterCount) return false;

        foreach (var slot in Pitch.Formations[team.Tactics.Formation])
        {
            if (team.Squad.Any(q => q.Slot == slot)) continue;
            if (LineupSelector.BestFit([p], slot) is null) continue;
            p.Slot = slot;
            p.BenchOrder = -1;
            Renumber(team);
            return true;
        }
        return false;
    }

    /// <summary>Alterna o reserva. Titular precisa sair do campo antes de ir para o banco.</summary>
    public static bool ToggleBench(Team team, Player p)
    {
        if (p.BenchOrder >= 0)
        {
            p.BenchOrder = -1;
            Renumber(team);
            return true;
        }
        if (p.Slot > 0 || !team.Squad.Contains(p) || CountBench(team) >= Pitch.BenchSlots.Length) return false;
        p.BenchOrder = CountBench(team);
        return true;
    }

    /// <summary>
    /// Troca os papéis de dois jogadores (titular, reserva ou fora). Como só se trocam posições e
    /// ordens do banco, o número de titulares e a ordem do banco continuam válidos.
    /// </summary>
    public static void Swap(Team team, Player a, Player b)
    {
        if (ReferenceEquals(a, b) || !team.Squad.Contains(a) || !team.Squad.Contains(b)) return;
        (a.Slot, b.Slot) = (b.Slot, a.Slot);
        (a.BenchOrder, b.BenchOrder) = (b.BenchOrder, a.BenchOrder);
    }

    public static IReadOnlyList<string> Problems(Team team, GameContext ctx)
    {
        var problems = new List<string>();
        var starters = Starters(team);
        if (starters.Count != StarterCount) problems.Add($"Escolha {StarterCount} titulares (há {starters.Count}).");
        if (starters.Count > 0 && !starters.Any(p => p.Slot == Pitch.Goalkeeper))
            problems.Add("Falta um goleiro titular.");
        foreach (var p in starters.Where(p => !IsAvailable(p, ctx)))
            problems.Add($"{p.Name} não pode jogar (lesão ou contrato).");
        return problems;
    }

    /// <summary>
    /// Preenche a partida com a escalação salva. Retorna false, sem alterar a partida, se a escalação
    /// não estiver completa ou algum titular estiver suspenso ou indisponível.
    /// </summary>
    public static bool Apply(Team team, Match match, int side, GameContext ctx)
    {
        if (Problems(team, ctx).Count > 0) return false;
        var starters = Starters(team);
        if (starters.Any(p => !LineupSelector.IsEligible(p, match, ctx))) return false;

        var bench = Bench(team).Where(p => LineupSelector.IsEligible(p, match, ctx)).ToList();
        match.Lineup[side].Clear();
        match.OnPitch[side].Clear();
        match.Bench[side].Clear();
        foreach (var p in starters)
        {
            p.PlayedThisRound = true;
            match.Lineup[side].Add(p);
            match.OnPitch[side].Add(p);
        }
        match.Bench[side].AddRange(bench);
        return true;
    }

    private static void FillStarters(Team team, GameContext ctx)
    {
        var available = Available(team, ctx, excluding: team.Squad.Where(p => p.BenchOrder >= 0));
        foreach (var slot in Pitch.Formations[team.Tactics.Formation])
        {
            var p = LineupSelector.BestFit(available, slot);
            if (p is null) continue;
            p.Slot = slot;
            p.BenchOrder = -1;
            available.Remove(p);
        }
    }

    private static List<Player> Available(Team team, GameContext ctx, IEnumerable<Player> excluding)
    {
        var skip = excluding.ToHashSet();
        return team.Squad
            .Where(p => !skip.Contains(p) && IsAvailable(p, ctx))
            .OrderByDescending(p => p.Strength)
            .ThenByDescending(p => p.Energy)
            .ToList();
    }

    private static int CountBench(Team team) => team.Squad.Count(p => p.BenchOrder >= 0);

    private static void Renumber(Team team)
    {
        var order = 0;
        foreach (var p in Bench(team)) p.BenchOrder = order++;
    }

    private static int FormationOrder(Team team, int slot)
    {
        var index = Array.IndexOf(Pitch.Formations[team.Tactics.Formation], slot);
        return index < 0 ? int.MaxValue : index;
    }
}
