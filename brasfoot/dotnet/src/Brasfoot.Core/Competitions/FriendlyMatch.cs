using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Resposta de um convite de amistoso (<c>f.a.a</c>): 0 recusado, 1 agendado sem cachê, 2 já há jogo
/// nesse dia e 3 agendado com cachê (<c>f.a.xY()</c>).
/// </summary>
public enum FriendlyOutcome
{
    Refused = 0,
    Scheduled = 1,
    AlreadyScheduledThatDay = 2,
    ScheduledWithFee = 3,
}

/// <summary>Resultado de um convite de amistoso: o desfecho e o cachê pedido (<c>f.a.a</c>/<c>xY</c>).</summary>
public sealed record FriendlyResult(FriendlyOutcome Outcome, int Fee);

/// <summary>
/// Amistosos de clube (<c>f.a</c>): avaliação do convite (aceite ou cachê por reputação) e criação do
/// jogo num dia <see cref="DayType.AmistosoClube"/>. O mandante depende de quem convida:
/// <c>n2 == 0</c> (cachê mais barato) manda o adversário em casa; caso contrário, o convidante manda.
/// </summary>
/// <remarks>
/// Tabelas de <c>f/a.java:64-81</c>, indexadas pela reputação (0..5) do adversário:
/// <list type="bullet">
/// <item>adversário manda (<c>n2 == 0</c>): mesmo país <c>[0,0,10000,50000,150000,250000]</c>,
/// países diferentes <c>[0,0,20000,80000,200000,450000]</c>;</item>
/// <item>convidante manda (<c>n2 != 0</c>): mesmo país <c>[0,0,20000,80000,200000,450000]</c>,
/// países diferentes <c>[0,0,30000,100000,250000,500000]</c>.</item>
/// </list>
/// Reputação 5 do adversário força cachê de 300000 (ou recusa se o convidante tiver reputação &lt; 4);
/// reputação 4 força 200000 (ou recusa se o convidante tiver reputação &lt; 2). Adversário humano
/// sempre aceita de graça (<c>jZ()</c>).
/// </remarks>
public static class FriendlyMatch
{
    /// <summary>Adversário manda, mesmo país (<c>nArray2</c>).</summary>
    public static readonly int[] OpponentHostsSameCountry = [0, 0, 10000, 50000, 150000, 250000];

    /// <summary>Convidante manda, mesmo país (<c>nArray4</c>).</summary>
    public static readonly int[] InviterHostsSameCountry = [0, 0, 20000, 80000, 200000, 450000];

    /// <summary>Convidante manda, países diferentes (<c>nArray6</c>).</summary>
    public static readonly int[] InviterHostsOtherCountry = [0, 0, 30000, 100000, 250000, 500000];

    /// <summary>
    /// <c>f.a.a(convidante, adversário, n2, dia)</c>: avalia o convite. <paramref name="opponentHosts"/>
    /// é <c>n2 == 0</c>; <paramref name="opponentHasMatchThatDay"/> substitui <c>a.d(ah3, dia)</c>.
    /// </summary>
    public static FriendlyResult Respond(Team inviter, Team opponent, bool opponentHosts, bool opponentHasMatchThatDay)
    {
        ArgumentNullException.ThrowIfNull(inviter);
        ArgumentNullException.ThrowIfNull(opponent);

        if (opponentHasMatchThatDay) return new FriendlyResult(FriendlyOutcome.AlreadyScheduledThatDay, 0);
        if (opponent.IsHuman) return new FriendlyResult(FriendlyOutcome.Scheduled, 0);

        var inviterRep = inviter.Reputation;
        var opponentRep = opponent.Reputation;
        var sameCountry = inviter.CountryId == opponent.CountryId;
        var fee = 0;

        if (opponentHosts)
        {
            if (opponentRep == 5 && inviterRep < 4) return new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 300000);
            if (opponentRep == 5 && inviterRep < 3) return new FriendlyResult(FriendlyOutcome.Refused, 0);
            if (opponentRep == 4 && inviterRep < 2) return new FriendlyResult(FriendlyOutcome.ScheduledWithFee, 200000);
            if (opponentRep == 4 && inviterRep <= 1) return new FriendlyResult(FriendlyOutcome.Refused, 0);
            fee = sameCountry ? Fee(OpponentHostsSameCountry, opponentRep) : Fee(InviterHostsSameCountry, opponentRep);
        }
        else
        {
            if (opponentRep == 5 && inviterRep != 5) return new FriendlyResult(FriendlyOutcome.Refused, 0);
            if (opponentRep == 4 && inviterRep < 2) return new FriendlyResult(FriendlyOutcome.Refused, 0);
            fee = sameCountry ? Fee(InviterHostsSameCountry, opponentRep) : Fee(InviterHostsOtherCountry, opponentRep);
        }

        return new FriendlyResult(
            fee > 0 ? FriendlyOutcome.ScheduledWithFee : FriendlyOutcome.Scheduled, fee);
    }

    /// <summary>
    /// <c>f.a.b(convidante, adversário, n2, dia)</c>: cria o jogo já aceito. <paramref name="opponentHosts"/>
    /// é <c>n2 == 0</c> (adversário manda). O jogo pertence a uma competição
    /// <see cref="CompetitionType.Amistoso"/>.
    /// </summary>
    public static Match Create(
        Team inviter, Team opponent, bool opponentHosts, Competition competition, IGameRandom random)
    {
        var (home, away) = opponentHosts ? (opponent, inviter) : (inviter, opponent);
        return new Match(home, away, competition, random);
    }

    /// <summary>
    /// <c>f.a.L(time)</c>: índices dos dias <see cref="DayType.AmistosoClube"/> posteriores a
    /// <paramref name="today"/> em que o clube ainda não tem jogo.
    /// </summary>
    public static List<int> AvailableDays(SeasonCalendar calendar, Team team, DateOnly today)
    {
        ArgumentNullException.ThrowIfNull(calendar);
        var result = new List<int>();
        foreach (var index in calendar.IndexesOfType(DayType.AmistosoClube))
        {
            var day = calendar.Days[index];
            if (day.Date <= today) continue;
            if (!day.Involves(team)) result.Add(index);
        }
        return result;
    }

    private static int Fee(int[] table, int reputation) =>
        reputation >= 0 && reputation < table.Length ? table[reputation] : 0;
}
