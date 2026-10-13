using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Acesso e rebaixamento das divisões da liga nacional (<c>best.Z.ee()</c>, <c>best/Z.java:453-598</c>),
/// que a virada de temporada (<c>best.f.aa()</c>, <c>best/f.java:519-539</c>) roda por país.
/// </summary>
/// <remarks>
/// <para>
/// Para cada par de divisões consecutivas, os <c>nRebaixados</c> últimos da divisão de cima trocam com
/// os melhores da de baixo (<see cref="PromotionRelegation.SwapAdjacentDivisions"/>); a última divisão
/// troca com os clubes fora da liga (<c>Z.dt</c>,
/// <see cref="PromotionRelegation.SwapLastDivisionWithPool"/>).
/// </para>
/// <para>
/// Na carreira brasileira completa (<c>bk()</c>: estaduais + 4 divisões), a 4ª divisão é a Série D e é
/// remontada a cada ano por <c>best.w.Q</c> — então o par (3ª, Série D) é tratado à parte: os
/// rebaixados da 3ª divisão viram os clubes livres (<c>bY()</c>, passo 1 de <c>Q</c>) e os melhores da
/// Série D sobem para a 3ª divisão. É o único ponto que popula <c>bY()</c> no original
/// (<c>best/Z.java:499-521</c>); a menção a <c>al.lP()</c> é enganosa (<c>lP()</c> enche <c>bu()</c>,
/// a lista de <em>técnicos</em> desempregados, não <c>bY()</c>).
/// </para>
/// <para>
/// Fiel ao original, a troca só acontece quando as duas listas têm o mesmo tamanho
/// (<c>best/Z.java:508</c>). Não modela os playoffs de acesso/rebaixamento (códigos 1099/1098) — as
/// competições do port hoje não os criam (ver <see cref="PromotionRelegation"/>).
/// </para>
/// </remarks>
public static class NationalPromotionRelegation
{
    /// <summary>Movimentações de uma liquidação de liga nacional, para histórico/telas.</summary>
    /// <param name="Swaps">Pares (rebaixado, promovido) trocados entre divisões.</param>
    /// <param name="FreeTeams">Clubes livres (<c>bY()</c>): rebaixados da 3ª divisão na carreira completa.</param>
    public sealed record Result(
        IReadOnlyList<(Team Relegated, Team Promoted)> Swaps,
        IReadOnlyList<Team> FreeTeams);

    /// <summary>
    /// <c>best.Z.ee()</c> para o país da sessão: liquida o acesso/rebaixamento de todas as divisões e
    /// devolve as movimentações e os clubes livres. As listas de times de
    /// <see cref="Domain.League.Divisions"/> são mutadas <em>in place</em> (são os elencos
    /// persistentes) e <see cref="Team.Division"/> é atualizado.
    /// </summary>
    /// <param name="session">Sessão com as competições da temporada em <see cref="GameSession.Leagues"/>.</param>
    /// <param name="countryId">País (<c>Z.jc()</c>).</param>
    /// <param name="configs">
    /// Configuração <c>.cfg</c> por divisão (1-based), para os <c>nRebaixados</c>. Sem ela, usa o
    /// default de <see cref="ConfigLigaType.Relegated"/> (2) para todas as divisões.
    /// </param>
    /// <param name="serieDApplies">
    /// Carreira brasileira completa (<c>SerieDApplies</c>): a última divisão é a Série D, tratada como
    /// no ramo <c>bk()</c> (rebaixados da 3ª viram clubes livres; melhores da Série D sobem).
    /// </param>
    public static Result Settle(
        GameSession session,
        int countryId,
        IReadOnlyDictionary<int, ConfigLigaType>? configs = null,
        bool serieDApplies = false)
    {
        ArgumentNullException.ThrowIfNull(session);

        var world = session.State.World;
        var league = world.LeagueOf(countryId);
        if (league is null || league.Divisions.Count == 0) return new Result([], []);

        var swaps = new List<(Team Relegated, Team Promoted)>();
        var freeTeams = new List<Team>();

        // Competições da temporada por divisão (o FullSeasonHooks monta só o país da sessão). Exclui as
        // ligas de 1ª fase de competições em fases (os grupos da Série D também são Id 4 e tipo Nacional).
        var phasedLeagues = session.Phased.SelectMany(p => p.Phase1).ToHashSet();
        var leaguesByDivision = new Dictionary<int, LeagueCompetition>();
        foreach (var lc in session.Leagues)
            if (lc.Competition.Type == CompetitionType.Nacional && !phasedLeagues.Contains(lc))
                leaguesByDivision[lc.Competition.Id] = lc;

        var divisions = league.Divisions;
        for (var index = 0; index < divisions.Count; index++)
        {
            if (!leaguesByDivision.TryGetValue(index + 1, out var upper)) continue;

            var config = Config(configs, index + 1);
            var isLast = index + 1 == divisions.Count;

            if (!isLast && leaguesByDivision.TryGetValue(index + 2, out var lower))
            {
                // Par (divisão, divisão+1): troca direta pela tabela.
                swaps.AddRange(PromotionRelegation.SwapAdjacentDivisions(
                    divisions[index], upper.Standing, config,
                    divisions[index + 1], lower.Standing));
                continue;
            }

            if (!isLast && serieDApplies && FindPhased(session, index + 2) is { } lowerPhased)
            {
                // A divisão de baixo é a Série D (phased): rebaixados viram clubes livres (bY()).
                var (serieDSwaps, relegated) = PromotionRelegation.SwapWithPhasedLower(
                    divisions[index], upper.Standing, config.Relegated, lowerPhased);
                swaps.AddRange(serieDSwaps);
                freeTeams.AddRange(relegated);
                continue;
            }

            // Última divisão (ou sem competição de baixo): troca com os clubes fora da liga (Z.dt).
            var pool = world.Teams
                .Where(t => t.CountryId == countryId && t.Division == 0)
                .OrderByDescending(t => t.Level).ThenByDescending(t => t.RankTiebreak)
                .ToList();
            swaps.AddRange(PromotionRelegation.SwapLastDivisionWithPool(
                divisions[index], upper.Standing, config, pool));
        }

        ReassignDivisions(world, countryId, league);
        foreach (var team in freeTeams) team.Division = 0;
        return new Result(swaps, freeTeams);
    }

    private static PhasedCompetition? FindPhased(GameSession session, int division)
    {
        foreach (var phased in session.Phased)
            if (phased.Competition.Id == division) return phased;
        return null;
    }

    private static ConfigLigaType Config(IReadOnlyDictionary<int, ConfigLigaType>? configs, int division)
    {
        if (configs is not null && configs.TryGetValue(division, out var config)) return config;
        return new ConfigLigaType();
    }

    /// <summary>Reatribui <see cref="Team.Division"/> a partir das listas persistentes do país.</summary>
    private static void ReassignDivisions(World world, int countryId, Domain.League league)
    {
        var inDivision = new HashSet<Team>();
        for (var index = 0; index < league.Divisions.Count; index++)
            foreach (var team in league.Divisions[index])
            {
                team.Division = index + 1;
                inDivision.Add(team);
            }
        foreach (var team in world.Teams)
            if (team.CountryId == countryId && !inDivision.Contains(team))
                team.Division = 0;
    }
}
