using Brasfoot.Core;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Transfers;
using Brasfoot.Data.JavaSerialization;

namespace Brasfoot.Data;

/// <summary>
/// Monta um <see cref="World"/> a partir da pasta do jogo original: times em <c>teams/*.ban</c>
/// (classe <c>e.t</c> com jogadores <c>e.g</c>) e configuração de ligas em
/// <c>conf_ligas_nacionais/*.cfg</c>. Replica a inicialização de um jogo novo: divisões por
/// nível (<c>Z.Ar()</c>) e força sorteada por clube (<c>F.fI()</c>).
/// </summary>
public static class WorldLoader
{
    /// <summary>Versão do formato dos times aceitos pelo jogo (<c>e.t.vid</c>).</summary>
    private const int SupportedTeamVersion = 185;

    /// <summary>Caixa inicial por divisão (<c>aq.sC</c>); índice 0 = sem liga.</summary>
    private static readonly long[] InitialCashByDivision = [3_500_000, 15_000_000, 12_000_000, 10_000_000, 3_500_000];

    public static IReadOnlyList<Team> LoadTeams(string gameDir)
    {
        var teams = new List<Team>();
        foreach (var file in Directory.GetFiles(Path.Combine(gameDir, "teams"), "*.ban").Order(StringComparer.Ordinal))
        {
            var raw = (JavaObject)JavaObjectReader.ReadSingle(file)!;
            if (raw.Get<int>("vid") != SupportedTeamVersion || !raw.Get<bool>("valid")) continue;
            teams.Add(ToTeam(raw, Path.GetFileNameWithoutExtension(file)));
        }
        return teams;
    }

    private static Team ToTeam(JavaObject t, string fileRef)
    {
        var team = new Team
        {
            Id = t.Get<int>("id"),
            Name = t.GetOrDefault<string>("e") ?? fileRef,
            FileRef = fileRef,
            CountryId = t.Get<int>("a"),
            State = t.Get<int>("b"),
            Level = Math.Clamp(t.Get<int>("c"), 1, 25),
            Stadium = t.GetOrDefault<string>("f") ?? "",
            Capacity = t.Get<int>("g"),
            Coach = t.GetOrDefault<string>("h") ?? "",
            Reputation = Math.Clamp(t.Get<int>("n"), 0, 5),
        };
        foreach (var raw in PlayersOf(t, "l")) team.Squad.Add(ToPlayer(raw, team, junior: false));
        foreach (var raw in PlayersOf(t, "m")) team.Juniors.Add(ToPlayer(raw, team, junior: true));
        return team;
    }

    private static IEnumerable<JavaObject> PlayersOf(JavaObject team, string field) =>
        team.GetOrDefault<JavaObject>(field)?.Annotations.OfType<JavaObject>() ?? [];

    /// <summary>Construtor <c>F(g, junior, clube)</c>.</summary>
    private static Player ToPlayer(JavaObject g, Team club, bool junior)
    {
        var p = new Player
        {
            Name = g.Get<string>("a"),
            IsStar = g.Get<bool>("b"),
            Nationality = g.Get<int>("c"),
            Age = Math.Clamp(g.Get<int>("d"), 16, junior ? 20 : 48),
            Position = (Position)Math.Clamp(g.Get<int>("e"), 0, 4),
            IsStarter = g.Get<int>("f") == 1,
            Cr1 = g.Get<int>("g"),
            Cr2 = g.Get<int>("h"),
            Side = g.Get<int>("i") == 1 ? Side.Esquerdo : Side.Direito,
            Potential = g.Get<int>("hash"),
            IsWorldClass = g.Get<bool>("j"),
            IsJunior = junior,
            Club = club,
        };
        if (p.IsWorldClass) p.IsStar = true;
        if (p.IsStar && p.Potential > 8) p.Potential = 10;
        return p;
    }

    /// <summary>
    /// Configuração de divisões por país lida dos <c>.cfg</c> (país → divisão → <see cref="ConfigLigaType"/>),
    /// replicando os campos de <c>est.ConfigLigaType</c> (<c>est/ConfigLigaType.java:11-33</c>) usados
    /// por <see cref="Competitions.PromotionRelegation"/> e pelo agendamento de divisões.
    /// </summary>
    public static Dictionary<int, SortedDictionary<int, ConfigLigaType>> LoadLeagueConfigs(string gameDir)
    {
        var configs = new Dictionary<int, SortedDictionary<int, ConfigLigaType>>();
        var dir = Path.Combine(gameDir, "conf_ligas_nacionais");
        if (!Directory.Exists(dir)) return configs;
        foreach (var file in Directory.GetFiles(dir, "*.cfg"))
        {
            var root = (JavaObject)JavaObjectReader.ReadSingle(file)!;
            foreach (var cfg in root.Get<JavaObject>("a").Annotations.OfType<JavaObject>())
            {
                var country = cfg.Get<int>("pais");
                if (!configs.TryGetValue(country, out var divisions)) configs[country] = divisions = new();
                var division = cfg.Get<int>("divisao");
                divisions[division] = new ConfigLigaType
                {
                    Country = country,
                    Division = division,
                    Name = cfg.GetOrDefault<string>("nome") ?? "",
                    Teams = cfg.Get<int>("nTimes"),
                    DoubleRound = cfg.Get<bool>("doisTurnos"),
                    Groups = cfg.Get<int>("nGrupos"),
                    MatchesWithinGroup = cfg.Get<bool>("jogosDentroGrupo"),
                    KnockoutQualifiersPerGroup = cfg.Get<int>("numeroTimesMataMata"),
                    BestThirdPlaced = cfg.Get<bool>("melhoresTerceiros"),
                    RelegationByGroup = cfg.Get<bool>("rebaixadoPeloGrupo"),
                    Relegated = cfg.Get<int>("nRebaixados"),
                    DirectlyRelegated = cfg.Get<int>("rebaixadosDireto"),
                    PromotionSlotsFromPlayoff = cfg.Get<int>("vagasSobemPeloMataMata"),
                    RelegationPlayoffFormat = cfg.Get<int>("playoffRebaixamento"),
                    FileVersion = cfg.Get<int>("versaoArquivo"),
                };
            }
        }
        return configs;
    }

    /// <summary>
    /// Cria um jogo novo: carrega os times, monta as ligas dos países escolhidos e sorteia a força
    /// inicial de todos os jogadores.
    /// </summary>
    public static World NewGame(string gameDir, GameContext ctx, IEnumerable<int> leagueCountries, IEnumerable<string>? humanTeams = null)
    {
        var world = new World();
        world.Teams.AddRange(LoadTeams(gameDir));
        foreach (var team in world.Teams) team.RankTiebreak = ctx.Random.NextInt(1000) + 1;

        var configs = LoadLeagueConfigs(gameDir);
        foreach (var country in leagueCountries) BuildLeague(world, country, configs.GetValueOrDefault(country));

        var humans = new HashSet<string>(humanTeams ?? [], StringComparer.OrdinalIgnoreCase);
        foreach (var team in world.Teams)
        {
            team.IsHuman = humans.Contains(team.FileRef);
            team.Cash = InitialCashByDivision[Math.Clamp(team.Division, 0, InitialCashByDivision.Length - 1)];
            foreach (var p in team.Squad.Concat(team.Juniors)) PlayerEconomics.AssignInitialStrength(p, ctx);
            foreach (var p in team.Squad) p.AskingPrice = p.Value;
        }

        var market = new TransferMarket(world, ctx);
        foreach (var team in world.Teams.Where(t => !t.IsHuman)) market.ListAiSurplus(team);
        return world;
    }

    /// <summary>
    /// <c>Z.Ar()</c>: ordena os clubes do país por nível (desempate aleatório) e preenche até 4
    /// divisões com o número de times configurado (padrão: 20, 18, …, 10 conforme houver clubes).
    /// </summary>
    private static void BuildLeague(World world, int country, SortedDictionary<int, ConfigLigaType>? config)
    {
        var pool = world.Teams.Where(t => t.CountryId == country)
            .OrderByDescending(t => t.Level).ThenByDescending(t => t.RankTiebreak).ToList();
        if (pool.Count == 0) return;
        foreach (var team in pool) team.IsLeagueClub = true;

        var league = new League(country, config?.Values.FirstOrDefault()?.Name is { Length: > 0 } n ? n : Countries.Get(country).Name);
        for (var division = 1; division <= 4; division++)
        {
            int size;
            if (config != null && config.TryGetValue(division, out var cfg) && cfg.Teams <= pool.Count)
                size = cfg.Teams;
            else
                size = pool.Count >= 20 ? 20 : pool.Count >= 18 ? 18 : pool.Count >= 16 ? 16
                    : pool.Count >= 14 ? 14 : pool.Count >= 12 ? 12 : pool.Count >= 10 ? 10 : 20;
            if (pool.Count < size) break;

            var teams = pool.Take(size).ToList();
            pool.RemoveRange(0, size);
            foreach (var team in teams) team.Division = division;
            league.Divisions.Add(teams);
        }
        if (league.Divisions.Count > 0) world.Leagues.Add(league);
    }
}
