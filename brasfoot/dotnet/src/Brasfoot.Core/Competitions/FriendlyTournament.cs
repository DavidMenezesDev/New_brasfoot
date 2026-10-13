using Brasfoot.Core.Calendar;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Torneio Amistoso de pré-temporada (<c>f.L</c>, chamado por <c>best.f.iY()</c>): 8 clubes em dois
/// grupos de 4, turno único dentro do grupo, e mata-mata de 4 times em jogo único, nos dias
/// <see cref="DayType.TorneioAmistoso"/>. O nome padrão é "Torneio Amistoso" e a cidade-sede
/// "Juazeiro" (<c>f/L.java</c>, <c>best/f.java:597-609</c>).
/// </summary>
public static class FriendlyTournament
{
    public const string DefaultName = "Torneio Amistoso";

    /// <summary>Cidade-sede gravada pelo original (<c>f/L.agn</c>), só para exibição.</summary>
    public const string DefaultCity = "Juazeiro";

    /// <summary>
    /// <c>f.L.a(lista, 0, nome, cidade, false)</c>: cria o torneio com 2 grupos e mata-mata de 4
    /// (2 classificados por grupo, tudo em jogo único). Exige um número par de clubes em cada grupo
    /// (<paramref name="teams"/>.Count deve ser múltiplo de 2 e ≥ 4).
    /// </summary>
    public static PhasedCompetition Create(
        GameSession session, IReadOnlyList<Team> teams, string name = DefaultName)
    {
        ArgumentNullException.ThrowIfNull(session);
        ArgumentNullException.ThrowIfNull(teams);
        if (teams.Count < 4 || teams.Count % 2 != 0)
            throw new ArgumentException("O Torneio Amistoso precisa de um número par de clubes (≥ 4).", nameof(teams));

        var competition = new Competition(
            (int)CompetitionType.TorneioAmistoso * 1000, name, CompetitionType.TorneioAmistoso);
        var options = new PhaseOptions
        {
            Groups = 2,
            DoubleRound = false,
            MatchesWithinGroup = true,
            ContiguousGroups = true,
            KnockoutQualifiersPerGroup = 2,
            CompetitionCode = -1,
            KnockoutTwoLegged = false,
            KnockoutTwoLeggedByRound = [false, false, false, false, false, false, false],
            DayType = DayType.TorneioAmistoso,
        };
        var phased = new PhasedCompetition(session, competition, teams, options);
        session.Phased.Add(phased);
        return phased;
    }

    /// <summary>
    /// Conveniência de <c>best.f.iY()</c>: os primeiros <paramref name="count"/> (padrão 8) clubes da
    /// lista mundial. O original usa a ordem de <c>P()</c> (a lista de clubes carregada), aqui a ordem
    /// de <see cref="World.Teams"/>.
    /// </summary>
    public static PhasedCompetition CreateFromWorld(GameSession session, int count = 8)
    {
        var teams = session.State.World.Teams.Take(count).ToList();
        return Create(session, teams);
    }
}
