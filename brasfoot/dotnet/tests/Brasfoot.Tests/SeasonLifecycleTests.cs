using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;

namespace Brasfoot.Tests;

/// <summary>
/// Ciclo completo da temporada: agendamento de <c>cD</c> (Série D / Copa do Brasil) no laço de dias,
/// arquivamento de campeões (<see cref="SeasonArchive"/>/<c>ChampionRecord</c>), Supercopa a partir do
/// histórico e montagem concreta da temporada brasileira (<see cref="FullSeasonHooks"/>). Fecha a
/// Fase 4 de <c>planodeImp.md</c>.
/// </summary>
public class SeasonLifecycleTests
{
    private const int Brasil = Countries.Brasil;
    private const int Sp = 25;
    private const int Rj = 18;

    // ---- Apoio ---------------------------------------------------------------

    private static GameSession NewSession(
        IEnumerable<Team> teams, GameOptions? options = null, SeasonHooks? hooks = null)
    {
        var world = new World();
        world.Teams.AddRange(teams);
        var state = GameState.FromWorld(world, options ?? new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(), hooks);
        session.BuildSeasonCalendar();
        return session;
    }

    private static void PlayUntil(GameSession session, Func<bool> done, int maxDays = 400)
    {
        var days = 0;
        while (!done() && !session.SeasonEnded && days++ < maxDays)
            session.AdvanceToNextMatchDay();
        Assert.True(done(), $"Condição não atingida em {days} dias (SeasonEnded={session.SeasonEnded}).");
    }

    /// <summary>Ganchos de teste que registram as chamadas do laço de dias.</summary>
    private sealed class RecordingHooks : SeasonHooks
    {
        public int SerieDCopaCalls { get; private set; }
        public List<DayEvent> Dispatched { get; } = new();

        public override void BuildCompetitions(GameSession session)
        {
            var teams = session.State.World.Teams.ToList();
            if (teams.Count >= 2)
                SeasonBuilder.CreateLeague(session, "Liga", CompetitionType.Nacional, teams);
        }

        public override void CreateSerieDAndCopa(GameSession session)
        {
            SerieDCopaCalls++;
            Dispatched.Add(DayEvent.CriaSerieDCopa);
        }
    }

    // ---- Agendamento de cD (best/f.java:543-544) -----------------------------

    [Fact]
    public void CriaSerieDCopa_is_scheduled_on_the_first_national_day_end_of_day_queue()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 60)).ToList();
        var session = NewSession(teams, hooks: new RecordingHooks());

        var firstNacional = session.Calendar.FirstIndexOfType(DayType.Nacional);
        Assert.True(firstNacional > 0);

        // best/f.java:543-544: a.b(n2, 4, 1) → fila de fim de dia (queue 1).
        Assert.Contains(DayEvent.CriaSerieDCopa, session.Days[firstNacional].QueueEndOfDay);
        Assert.DoesNotContain(DayEvent.CriaSerieDCopa, session.Days[firstNacional].QueueAfterMatch);
    }

    [Fact]
    public void CriaSerieDCopa_is_not_scheduled_when_regionais_are_off()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 60)).ToList();
        var session = NewSession(teams, new GameOptions { JogaRegionais = false });

        Assert.DoesNotContain(
            session.Days.SelectMany(d => d.QueueEndOfDay).ToList(), e => e == DayEvent.CriaSerieDCopa);
    }

    [Fact]
    public void Dispatch_invokes_the_CreateSerieDAndCopa_hook_on_the_first_national_day()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 60)).ToList();
        var hooks = new RecordingHooks();
        var session = NewSession(teams, hooks: hooks);

        Assert.Equal(0, hooks.SerieDCopaCalls);
        PlayUntil(session, () => hooks.SerieDCopaCalls > 0);

        Assert.Equal(1, hooks.SerieDCopaCalls);
        Assert.Equal(DayEvent.CriaSerieDCopa, Assert.Single(hooks.Dispatched));
    }

    // ---- Arquivo de campeões (ChampionRecord) --------------------------------

    [Fact]
    public void SeasonArchive_records_a_league_champion_and_runner_up()
    {
        var teams = Enumerable.Range(0, 10).Select(i => TestData.Team($"T{i}", 50 + i)).ToList();
        var session = NewSession(teams);
        var league = SeasonBuilder.CreateLeague(session, "Liga Teste", CompetitionType.Nacional, teams);

        PlayUntil(session, () => league.IsComplete);

        var added = SeasonArchive.Record(session);
        var record = Assert.Single(added);
        Assert.Equal(1, record.Season);
        Assert.Equal("Liga Teste", record.Competition);
        Assert.Equal(league.Champion!.Team.Id, record.TeamId);
        Assert.Equal(league.Champion.Team.Name, record.TeamName);
        Assert.Equal(league.Standing[1].Team.Id, record.RunnerUpId);
        Assert.Equal(league.Standing[1].Team.Name, record.RunnerUpName);
    }

    [Fact]
    public void SeasonArchive_records_a_knockout_cup_champion_and_final_loser()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"C{i}", 50 + i)).ToList();
        var session = NewSession(teams);

        var competition = new Competition(9000, "Copa Teste", CompetitionType.CopaNacional);
        var bracket = new KnockoutBracket(
            competition, teams, twoLegged: false, awayGoalsRule: false, shootoutAllowed: true);
        var cup = CupCompetition.Create(competition, bracket, session.State.Calendar, session.Context);
        session.Cups.Add(cup);

        PlayUntil(session, () => cup.IsComplete);

        var added = SeasonArchive.Record(session);
        var record = Assert.Single(added);
        Assert.Equal("Copa Teste", record.Competition);
        Assert.Equal(cup.Champion!.Id, record.TeamId);
        Assert.NotNull(record.RunnerUpId);
        Assert.NotEqual(record.TeamId, record.RunnerUpId);
        Assert.Contains(teams, t => t.Id == record.RunnerUpId);
    }

    [Fact]
    public void SeasonArchive_Record_is_idempotent_per_season_and_competition()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 50 + i)).ToList();
        var session = NewSession(teams);
        var league = SeasonBuilder.CreateLeague(session, "Liga", CompetitionType.Nacional, teams);
        PlayUntil(session, () => league.IsComplete);

        var first = SeasonArchive.Record(session);
        Assert.Single(first);

        var second = SeasonArchive.Record(session);
        Assert.Empty(second);
        Assert.Single(session.State.Champions);
    }

    [Fact]
    public void SeasonArchive_Find_matches_season_and_competition()
    {
        var team = TestData.Team("A", 60);
        var state = GameState.FromWorld(new World { Teams = { team } });
        state.Champions.Add(new ChampionRecord(1, "Liga", team.Id, team.Name));

        Assert.NotNull(SeasonArchive.Find(state, 1, "Liga"));
        Assert.Null(SeasonArchive.Find(state, 2, "Liga"));
        Assert.Null(SeasonArchive.Find(state, 1, "Copa"));
    }

    [Fact]
    public void SeasonArchive_skips_unfinished_competitions()
    {
        var teams = Enumerable.Range(0, 8).Select(i => TestData.Team($"T{i}", 50 + i)).ToList();
        var session = NewSession(teams);
        SeasonBuilder.CreateLeague(session, "Liga", CompetitionType.Nacional, teams);

        // Nada jogado ainda: nenhuma competição encerrada.
        Assert.Empty(SeasonArchive.Record(session));
        Assert.Empty(session.State.Champions);
    }

    // ---- Supercopa a partir do histórico -------------------------------------

    private static GameSession NewHistorySession(
        out List<Team> teams, out GameState state, int season = 2)
    {
        teams = Enumerable.Range(0, 4).Select(i => TestData.Team($"H{i}", 60)).ToList();
        var world = new World();
        world.Teams.AddRange(teams);
        state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        state.Season = season;
        var session = new GameSession(state, TestData.Context());
        session.BuildSeasonCalendar();
        return session;
    }

    [Fact]
    public void CreateSupercupFromHistory_pits_the_league_champion_against_the_cup_champion()
    {
        var session = NewHistorySession(out var teams, out var state);
        var leagueChampion = teams[0];
        var cupChampion = teams[1];
        var cupRunnerUp = teams[2];

        state.Champions.Add(new ChampionRecord(1, "Brasileirão", leagueChampion.Id, leagueChampion.Name));
        state.Champions.Add(new ChampionRecord(
            1, "Copa do Brasil", cupChampion.Id, cupChampion.Name, cupRunnerUp.Id, cupRunnerUp.Name));

        var supercup = SeasonBuilder.CreateSupercupFromHistory(session, "Brasileirão", "Copa do Brasil");

        Assert.NotNull(supercup);
        Assert.Same(leagueChampion, supercup!.Bracket.Seeded[0]);
        Assert.Same(cupChampion, supercup.Bracket.Seeded[1]);
        Assert.Equal(CompetitionType.Supercopa, supercup.Competition.Type);
    }

    [Fact]
    public void CreateSupercupFromHistory_falls_back_to_the_cup_runner_up_when_champions_coincide()
    {
        var session = NewHistorySession(out var teams, out var state);
        var champion = teams[0];
        var cupRunnerUp = teams[1];

        state.Champions.Add(new ChampionRecord(1, "Brasileirão", champion.Id, champion.Name));
        state.Champions.Add(new ChampionRecord(
            1, "Copa do Brasil", champion.Id, champion.Name, cupRunnerUp.Id, cupRunnerUp.Name));

        var supercup = SeasonBuilder.CreateSupercupFromHistory(session, "Brasileirão", "Copa do Brasil");

        Assert.NotNull(supercup);
        Assert.Same(champion, supercup!.Bracket.Seeded[0]);
        Assert.Same(cupRunnerUp, supercup.Bracket.Seeded[1]);
    }

    [Fact]
    public void CreateSupercupFromHistory_returns_null_without_history_or_first_season()
    {
        var session = NewHistorySession(out var teams, out var state, season: 1);

        // Sem histórico algum.
        Assert.Null(SeasonBuilder.CreateSupercupFromHistory(session, "Brasileirão", "Copa do Brasil"));

        // Só há histórico da 1ª temporada; na 1ª temporada não existe "temporada anterior".
        state.Champions.Add(new ChampionRecord(1, "Brasileirão", teams[0].Id, teams[0].Name));
        Assert.Null(SeasonBuilder.CreateSupercupFromHistory(session, "Brasileirão", "Copa do Brasil"));

        // Campeão da liga sem copa: ainda cria (adversário = campeão da copa, ausente → null).
        state.Season = 2;
        Assert.Null(SeasonBuilder.CreateSupercupFromHistory(session, "Brasileirão", "Copa do Brasil"));
    }

    // ---- Montagem concreta da temporada (FullSeasonHooks) --------------------

    [Fact]
    public void FullSeasonHooks_builds_the_national_leagues_state_and_regional_championships()
    {
        var world = BuildBrazilianWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(), new FullSeasonHooks());
        session.BuildSeasonCalendar();

        // 4 divisões nacionais de 24 clubes.
        Assert.Equal(4, session.State.World.LeagueOf(Brasil)!.Divisions.Count);
        Assert.Equal(4, session.Leagues.Count(l => l.Competition.Type == CompetitionType.Nacional));

        // Estaduais: SP e RJ com 8 clubes cada (1 divisão de 6 + 2 de fora).
        Assert.Equal(2, session.StateFederations.Count);
        Assert.All(session.StateFederations, f => Assert.Single(f.Divisions));

        // Regionais: só o Rio-SP tem 16 clubes.
        Assert.Single(session.Phased, p => p.Competition.Type == CompetitionType.Regionais);

        // A Copa do Brasil ainda não existe no início: nasce no gancho cD.
        Assert.Empty(session.BrasilCup);
    }

    [Fact]
    public void FullSeasonHooks_plays_a_whole_season_and_archives_the_champions()
    {
        var world = BuildBrazilianWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(), new FullSeasonHooks());
        session.BuildSeasonCalendar();

        var days = 0;
        while (!session.SeasonEnded && days++ < 500)
            session.AdvanceToNextMatchDay();

        Assert.True(session.SeasonEnded, $"Temporada não terminou em {days} dias.");

        // A Copa do Brasil foi criada no meio da temporada (primeiro dia Nacional).
        var copa = Assert.Single(session.BrasilCup);
        Assert.True(copa.IsComplete);
        Assert.All(copa.DayIndexes, i => Assert.Equal(DayType.CopaNacional, state.Calendar.Days[i].Type));

        // O avanço seguinte dispara a virada, que arquiva os campeões.
        Assert.Empty(state.Champions);
        session.AdvanceToNextMatchDay();

        Assert.Contains(state.Champions, c => c.Competition == "Copa do Brasil" && c.TeamId == copa.Champion!.Id);
        Assert.Contains(state.Champions, c => c.Competition.EndsWith("1ª divisão"));
        Assert.Contains(state.Champions, c => c.Competition == "Paulista");
        Assert.Contains(state.Champions, c => c.Competition == "Carioca");
        Assert.Contains(state.Champions, c => c.Competition == "Rio-SP");
    }

    // ---- Virada de temporada (GameSession.StartNextSeason) -------------------

    private static void PlayWholeSeason(GameSession session)
    {
        var days = 0;
        while (!session.SeasonEnded && days++ < 500)
            session.AdvanceToNextMatchDay();
        Assert.True(session.SeasonEnded, $"Temporada não terminou em {days} dias.");
    }

    [Fact]
    public void StartNextSeason_resets_the_competition_lists_and_advances_the_season()
    {
        var world = BuildBrazilianWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(), new FullSeasonHooks());
        session.BuildSeasonCalendar();

        var season1Leagues = session.Leagues.ToList();
        Assert.Equal(4, season1Leagues.Count(l => l.Competition.Type == CompetitionType.Nacional));

        PlayWholeSeason(session);
        session.AdvanceToNextMatchDay(); // arquiva os campeões
        session.StartNextSeason();

        Assert.Equal(2, state.Season);
        Assert.Equal(2023, session.Year);
        Assert.False(session.SeasonEnded);

        // Nenhuma competição da temporada anterior sobrevive por referência.
        Assert.All(season1Leagues, l => Assert.DoesNotContain(l, session.Leagues));
        Assert.Equal(4, session.Leagues.Count(l => l.Competition.Type == CompetitionType.Nacional));
        Assert.Equal(2, session.StateFederations.Count);
    }

    [Fact]
    public void StartNextSeason_without_a_completed_season_creates_no_supercup()
    {
        var world = BuildBrazilianWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(), new FullSeasonHooks());
        session.BuildSeasonCalendar();

        session.StartNextSeason();

        Assert.Equal(2, state.Season);
        Assert.Empty(state.Champions);
        Assert.Empty(session.Cups);
    }

    [Fact]
    public void FullSeasonHooks_seeds_the_supercup_from_the_previous_season()
    {
        var world = BuildBrazilianWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        state.BaseYear = 2022;
        var session = new GameSession(state, TestData.Context(), new FullSeasonHooks());
        session.BuildSeasonCalendar();

        // Temporada 1: sem histórico, sem Supercopa.
        Assert.Empty(session.Cups);
        PlayWholeSeason(session);
        session.AdvanceToNextMatchDay();

        var leagueRecord = SeasonArchive.Find(state, 1, "Brasileirão — 1ª divisão");
        var cupRecord = SeasonArchive.Find(state, 1, "Copa do Brasil");
        Assert.NotNull(leagueRecord);
        Assert.NotNull(cupRecord);

        // Temporada 2: a Supercopa nasce do histórico (campeão da liga × campeão/vice da copa).
        session.StartNextSeason();

        var supercup = Assert.Single(session.Cups);
        Assert.Equal(CompetitionType.Supercopa, supercup.Competition.Type);
        Assert.Empty(session.BrasilCup); // a Copa do Brasil nasce depois, no gancho cD

        Assert.Same(
            state.World.Teams.First(t => t.Id == leagueRecord!.TeamId),
            supercup.Bracket.Seeded[0]);
        var opponent = supercup.Bracket.Seeded[1];
        if (leagueRecord!.TeamId == cupRecord!.TeamId)
            Assert.Equal(cupRecord.RunnerUpId, opponent.Id); // mesmo campeão: entra o vice da copa
        else
            Assert.Equal(cupRecord.TeamId, opponent.Id);
    }

    /// <summary>
    /// Mundo sintético com 96 clubes brasileiros: 4 divisões nacionais de 24, 8 em SP e 8 no RJ
    /// (para estaduais e o regional Rio-SP) e os demais sem estado (fora de estaduais/regionais).
    /// 96 clubes bastam para o formato de potes da Copa do Brasil (12 cabeças + 80).
    /// </summary>
    private static World BuildBrazilianWorld()
    {
        var world = new World();
        var teams = new List<Team>();
        for (var i = 0; i < 96; i++)
        {
            var state = i < 8 ? Sp : i < 16 ? Rj : -1;
            var team = TestData.Team($"Clube {i:D2}", 40 + (i % 40), Brasil, reputation: i % 6);
            team.State = state;
            team.Division = i / 24 + 1;
            teams.Add(team);
            world.Teams.Add(team);
        }

        var league = new League(Brasil, "Brasileirão");
        for (var d = 0; d < 4; d++)
            league.Divisions.Add(teams.Skip(d * 24).Take(24).ToList());
        world.Leagues.Add(league);
        return world;
    }
}
