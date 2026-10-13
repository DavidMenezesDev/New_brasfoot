using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

/// <summary>Confronto eliminatório decidido nesta partida (<c>I.ge/gf/gj</c>).</summary>
/// <param name="FirstLeg">Placar do jogo de ida, do ponto de vista do mandante DESTA partida (gols dele, gols do adversário); null se jogo único.</param>
/// <param name="AwayGoalsRule">Gol fora como critério de desempate.</param>
/// <param name="ShootoutAllowed">Empate vai para pênaltis (falso em fases especiais de estaduais).</param>
public sealed record KnockoutTie((int Home, int Away)? FirstLeg = null, bool AwayGoalsRule = false, bool ShootoutAllowed = true);

/// <summary>Partida (<c>best.I</c>). Lado 0 = mandante, 1 = visitante.</summary>
public sealed class Match
{
    public Match(Team home, Team away, Competition competition, IGameRandom random, KnockoutTie? tie = null)
    {
        Home = home;
        Away = away;
        Competition = competition;
        Tie = tie;
        DrawSubstitutionMinutes(random);
    }

    public Team Home { get; }
    public Team Away { get; }
    public Competition Competition { get; }
    public KnockoutTie? Tie { get; }

    public Team TeamOf(int side) => side == 0 ? Home : Away;
    public int SideOf(Team team) => team == Home ? 0 : 1;
    public bool InvolvesHuman => Home.IsHuman || Away.IsHuman;

    public List<Player>[] Lineup { get; } = [new(), new()];
    public List<Player>[] Bench { get; } = [new(), new()];

    /// <summary>Jogadores em campo agora, na ordem em que entraram (a ordem afeta as médias por setor).</summary>
    public List<Player>[] OnPitch { get; } = [new(), new()];

    public List<Player>[] SubbedOn { get; } = [new(), new()];
    public List<MatchEvent> Events { get; } = new();

    public int[] Score { get; } = new int[2];
    public int[] SubsLeft { get; } = [5, 5];

    // Totais da partida usados pela camada de incidentes (fS, fT, fU)
    public int YellowCount { get; set; }
    public int RedCount { get; set; }
    public int InjuryCount { get; set; }

    // Estatísticas
    public int[] Possession { get; } = [50, 50];
    public int[] PossessionTicks { get; } = new int[2];
    public int[] Shots { get; } = new int[2];
    public int[] ShotsOnTarget { get; } = new int[2];
    public int[] ShotsOffTarget { get; } = new int[2];
    public int[] Tackles { get; } = new int[2];
    public int[] MisplacedPasses { get; } = new int[2];

    /// <summary>Acréscimos sorteados (simulação rápida): [0] 1º tempo 0..2, [1] 2º tempo 1..5.</summary>
    public int[] Stoppage { get; } = new int[2];

    /// <summary>Minutos do 2º tempo em que a IA mexe se estiver perdendo (<c>gn</c>); 0 = não sorteado.</summary>
    internal int[,] ChaseSubMinutes { get; } = new int[2, 3];

    /// <summary>Minutos do 2º tempo de troca por cansaço (<c>gm</c>); 0 = não sorteado.</summary>
    internal int[,] EnergySubMinutes { get; } = new int[2, 4];

    public bool IsFinished { get; internal set; }
    public (int Home, int Away)? ShootoutScore { get; internal set; }
    public int? ShootoutWinner { get; internal set; }

    /// <summary>Lado vencedor considerando pênaltis; null em empate.</summary>
    public int? Winner => ShootoutWinner ?? (Score[0] > Score[1] ? 0 : Score[1] > Score[0] ? 1 : null);

    /// <summary><c>I.hb()</c>: sorteia os minutos planejados de substituição da IA.</summary>
    private void DrawSubstitutionMinutes(IGameRandom random)
    {
        var chase = Enumerable.Range(19, 20).ToList(); // 19..38
        random.Shuffle(chase);
        var r = random.NextInt(100);
        ChaseSubMinutes[0, 0] = chase[0];
        ChaseSubMinutes[0, 1] = chase[1];
        ChaseSubMinutes[1, 0] = chase[2];
        ChaseSubMinutes[1, 1] = chase[3];
        if (random.NextInt(100) > 30) ChaseSubMinutes[0, 2] = chase[4];
        if (random.NextInt(100) > 30) ChaseSubMinutes[1, 2] = chase[5];

        var energy = r > 90 ? Enumerable.Range(5, 11).ToList()   // 5..15
            : r > 50 ? Enumerable.Range(16, 20).ToList()           // 16..35
            : Enumerable.Range(36, 7).ToList();                    // 36..42
        random.Shuffle(energy);
        EnergySubMinutes[0, 0] = energy[0];
        EnergySubMinutes[0, 1] = energy[1];
        EnergySubMinutes[1, 0] = energy[2];
        EnergySubMinutes[1, 1] = energy[3];

        var late = Enumerable.Range(43, 5).ToList();               // 43..47
        random.Shuffle(late);
        if (random.NextInt(100) > 20) EnergySubMinutes[0, 2] = late[0];
        if (random.NextInt(100) > 50) EnergySubMinutes[0, 3] = late[1];
        if (random.NextInt(100) > 20) EnergySubMinutes[1, 2] = late[2];
        if (random.NextInt(100) > 50) EnergySubMinutes[1, 3] = late[3];
    }

    public override string ToString() =>
        $"{Home} {Score[0]} x {Score[1]} {Away}" + (ShootoutScore is { } s ? $" (pên. {s.Home} x {s.Away})" : "");
}
