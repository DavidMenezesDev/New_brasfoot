using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Season;

/// <summary>
/// Arquiva os campeões (e vices) das competições encerradas em <see cref="GameState.Champions"/>
/// (<c>ChampionRecord</c>), fechando o ciclo da temporada. É o histórico que o original guarda em
/// <c>at.mn()</c>/<c>Y()</c> e que alimenta a Supercopa da temporada seguinte
/// (<see cref="SeasonBuilder.CreateSupercupFromHistory"/>).
/// </summary>
public static class SeasonArchive
{
    /// <summary>
    /// Percorre as competições da sessão e acrescenta um <see cref="ChampionRecord"/> por competição
    /// encerrada ainda não arquivada (idempotente por <c>(temporada, competição)</c>). Devolve os
    /// registros novos.
    /// </summary>
    public static IReadOnlyList<ChampionRecord> Record(GameSession session)
    {
        ArgumentNullException.ThrowIfNull(session);
        var added = new List<ChampionRecord>();
        var season = session.State.Season;

        // As ligas da 1ª fase dos estaduais/regionais vivem em session.Leagues; não são "campeões".
        var phase1 = session.Phased.SelectMany(p => p.Phase1).ToHashSet();

        foreach (var league in session.Leagues)
        {
            if (phase1.Contains(league)) continue;
            Add(added, session, season, league.Competition.Name, league.Champion?.Team,
                league.Standing.Count > 1 ? league.Standing[1].Team : null);
        }

        foreach (var cup in session.Cups)
            Add(added, session, season, cup.Competition.Name, cup.Champion, RunnerUpOf(cup.Bracket));

        foreach (var copa in session.BrasilCup)
            Add(added, session, season, copa.Competition.Name, copa.Champion, FinalLoser(copa.Pairings, copa.Champion));

        foreach (var phased in session.Phased)
        {
            var runnerUp = phased.Knockout is not null
                ? RunnerUpOf(phased.Knockout.Bracket)
                : phased.Standing.Count > 1 ? phased.Standing[1].Team : null;
            Add(added, session, season, phased.Competition.Name, phased.Champion, runnerUp);
        }

        return added;
    }

    /// <summary>Registro da competição numa temporada, ou <see langword="null"/>.</summary>
    public static ChampionRecord? Find(GameState state, int season, string competition)
    {
        ArgumentNullException.ThrowIfNull(state);
        return state.Champions.LastOrDefault(c => c.Season == season && c.Competition == competition);
    }

    private static void Add(
        List<ChampionRecord> added, GameSession session, int season, string competition, Team? champion, Team? runnerUp)
    {
        if (champion is null) return;
        if (session.State.Champions.Any(c => c.Season == season && c.Competition == competition)) return;

        var record = new ChampionRecord(
            season, competition, champion.Id, champion.Name, runnerUp?.Id, runnerUp?.Name);
        session.State.Champions.Add(record);
        added.Add(record);
    }

    /// <summary>Vice da final de uma chave (<c>f.z</c>): o perdedor do único confronto da última fase.</summary>
    private static Team? RunnerUpOf(KnockoutBracket bracket)
    {
        if (bracket.Rounds.Count == 0) return null;
        var final = bracket.Rounds[^1].Pairings;
        if (final.Count != 1 || final[0].Winner is null) return null;
        return final[0].Winner == final[0].Home ? final[0].Away : final[0].Home;
    }

    private static Team? FinalLoser(IReadOnlyList<KnockoutPairing> pairings, Team? champion)
    {
        if (champion is null || pairings.Count != 1) return null;
        var final = pairings[0];
        return champion == final.Home ? final.Away : final.Home;
    }
}
