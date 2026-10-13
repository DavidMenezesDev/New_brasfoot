namespace Brasfoot.Core.Domain;

using Brasfoot.Core.Season;

/// <summary>
/// Agregado raiz do jogo salvo: mundo, temporada/data, opções, técnicos e históricos.
/// Não contém estado de execução (aleatoriedade, laço de dias) — isso fica em
/// <c>GameContext</c>/sessão. Layout do save: <c>re/spec-financas-carreira.md</c> §19.
/// </summary>
public sealed class GameState
{
    /// <summary>Versão do formato de save (para migrações futuras).</summary>
    public int FormatVersion { get; set; } = SaveFormatVersion;

    public const int SaveFormatVersion = 1;

    /// <summary>Temporada atual, começando em 1 (<c>SR.H()</c>).</summary>
    public int Season { get; set; } = 1;

    /// <summary>Ano-base da temporada 1 (<c>SR.op()</c>, <c>best/f.java:70</c>).</summary>
    public int BaseYear { get; set; } = 2022;

    public DateOnly Today { get; set; } = new(2022, 1, 1);

    public World World { get; set; } = new();

    /// <summary>Calendário da temporada corrente (dias, tipos e filas de eventos).</summary>
    public SeasonCalendar Calendar { get; set; } = new();

    public GameOptions Options { get; set; } = new();

    public List<Manager> Managers { get; set; } = new();

    /// <summary>Caixa de entrada global (mensagens sem técnico atribuído, avisos de sistema).</summary>
    public List<ManagerMessage> Inbox { get; set; } = new();

    /// <summary>Histórico de campeões (<c>at.mn()</c> agregado).</summary>
    public List<ChampionRecord> Champions { get; set; } = new();

    /// <summary>Histórico de trocas/demissões de técnico.</summary>
    public List<ManagerChangeRecord> ManagerChanges { get; set; } = new();

    /// <summary>Próximo id de jogador a distribuir (ids estáveis para o save).</summary>
    public int NextPlayerId { get; set; } = 1;

    /// <summary>Próximo id de técnico a distribuir.</summary>
    public int NextManagerId { get; set; } = 1;

    public Manager? HumanManager => Managers.FirstOrDefault(m => m.IsHuman);

    public Manager? ManagerOf(Team club) => Managers.FirstOrDefault(m => ReferenceEquals(m.Club, club));

    public IEnumerable<Manager> UnemployedManagers => Managers.Where(m => m.IsUnemployed);

    /// <summary>Cria um <see cref="GameState"/> a partir de um mundo já carregado, atribuindo ids de jogador.</summary>
    public static GameState FromWorld(World world, GameOptions? options = null)
    {
        var state = new GameState { World = world, Options = options ?? new GameOptions() };
        foreach (var player in world.Teams.SelectMany(t => t.Squad.Concat(t.Juniors)))
            state.RegisterPlayer(player);
        return state;
    }

    /// <summary>Garante um id estável para o jogador e avança o contador.</summary>
    public Player RegisterPlayer(Player player)
    {
        if (player.Id <= 0) player.Id = NextPlayerId++;
        else if (player.Id >= NextPlayerId) NextPlayerId = player.Id + 1;
        return player;
    }

    /// <summary>Adiciona um técnico com id sequencial.</summary>
    public Manager AddManager(string name, Team? club = null, bool human = false)
    {
        var manager = new Manager { Id = NextManagerId++, Name = name, Club = club, IsHuman = human };
        Managers.Add(manager);
        return manager;
    }
}

/// <summary>
/// Registro de campeão para o histórico (<c>at.mn()</c>). <see cref="RunnerUpId"/>/<c>RunnerUpName</c>
/// são preenchidos nas competições eliminatórias (vice da final) e alimentam a Supercopa do ano
/// seguinte quando o campeão da liga coincide com o da copa (<c>Supercup.SelectOpponent</c>).
/// </summary>
public sealed record ChampionRecord(
    int Season, string Competition, int TeamId, string TeamName,
    int? RunnerUpId = null, string? RunnerUpName = null);

/// <summary>Registro de troca ou demissão de técnico.</summary>
public sealed record ManagerChangeRecord(DateOnly Date, string Club, string? Outgoing, string Incoming, string Reason);
