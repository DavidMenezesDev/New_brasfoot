using System.Globalization;
using Brasfoot.Core;
using Brasfoot.Core.Calendar;
using Brasfoot.Core.Common;
using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;
using Brasfoot.Core.Season;
using Brasfoot.Core.Transfers;
using Brasfoot.Data;
using Brasfoot.Data.JavaSerialization;

CultureInfo.CurrentCulture = CultureInfo.GetCultureInfo("pt-BR");

var options = ParseOptions(args, out var positional);
if (positional.Count == 0)
{
    PrintUsage();
    return 1;
}

var gameDir = options.GetValueOrDefault("jogo") ?? FindGameDir();
var seed = options.TryGetValue("seed", out var s) ? int.Parse(s) : (int?)null;
var ctx = new GameContext(new GameRandom(seed), new RulesOptions { FixOriginalBugs = options.ContainsKey("corrigir") });

switch (positional[0])
{
    case "dump":
        DumpJavaObject((JavaObject)JavaObjectReader.ReadSingle(positional[1])!, "");
        return 0;

    case "simular":
    {
        var world = NewWorld();
        var (home, away) = (FindTeam(world, positional[1]), FindTeam(world, positional[2]));
        var match = new Match(home, away, CompetitionFrom(options), ctx.Random);
        MatchSimulator.Play(match, ctx);
        PostMatch.Apply(match, ctx);
        PrintMatch(match);
        return 0;
    }

    case "lote":
    {
        var world = NewWorld();
        var (home, away) = (FindTeam(world, positional[1]), FindTeam(world, positional[2]));
        var n = int.Parse(options.GetValueOrDefault("n") ?? "1000");
        var competition = CompetitionFrom(options);
        int wins = 0, draws = 0, losses = 0, goalsHome = 0, goalsAway = 0, shots = 0, yellows = 0, reds = 0;
        for (var i = 0; i < n; i++)
        {
            foreach (var p in home.Squad.Concat(away.Squad))
            {
                p.Energy = 100;
                p.InjuredUntil = null;
                p.CompetitionStats.Clear();
            }
            var match = MatchSimulator.Play(new Match(home, away, competition, ctx.Random), ctx);
            goalsHome += match.Score[0];
            goalsAway += match.Score[1];
            shots += match.Shots[0] + match.Shots[1];
            yellows += match.Events.Count(e => e.Type is MatchEventType.Amarelo or MatchEventType.AmareloVermelho);
            reds += match.Events.Count(e => e.Type is MatchEventType.Vermelho or MatchEventType.AmareloVermelho);
            if (match.Score[0] > match.Score[1]) wins++;
            else if (match.Score[0] < match.Score[1]) losses++;
            else draws++;
        }
        Console.WriteLine($"{home} x {away} — {n} jogos ({competition.Name})");
        Console.WriteLine($"  Força média titular: {AverageStarterStrength(home):F1} x {AverageStarterStrength(away):F1}");
        Console.WriteLine($"  Vitórias {Pct(wins)} | Empates {Pct(draws)} | Derrotas {Pct(losses)}");
        Console.WriteLine($"  Gols por jogo: {(double)goalsHome / n:F2} x {(double)goalsAway / n:F2}");
        Console.WriteLine($"  Finalizações/jogo {(double)shots / n:F1} | Amarelos/jogo {(double)yellows / n:F2} | Vermelhos/jogo {(double)reds / n:F2}");
        return 0;

        string Pct(int x) => $"{100.0 * x / n:F1}%";
    }

    case "elenco":
    {
        var world = NewWorld();
        var team = FindTeam(world, positional[1]);
        Console.WriteLine($"{team.Name} — {Countries.Get(team.CountryId).Name}, divisão {team.Division}, nível {team.Level}, reputação {team.Reputation}");
        Console.WriteLine($"{"Jogador",-24} Pos Idade Força {"Valor",14} {"Salário",10} Contrato  Flags");
        foreach (var p in team.Squad.OrderBy(p => p.Position).ThenByDescending(p => p.Strength))
        {
            var flags = string.Concat(p.IsWorldClass ? "T" : "", p.IsStar ? "C" : "", p.IsStarter ? "t" : "", p.IsListed ? " à venda" : "");
            Console.WriteLine($"{p.Name,-24} {p.Position.ToString()[0],3} {p.Age,5} {p.Strength,5} {p.Value,14:N0} {p.Salary,10:N0} {p.ContractEnd:dd/MM/yy}  {flags}");
        }
        return 0;
    }

    case "proposta":
    {
        var world = NewWorld(humans: [positional[1]]);
        var buyer = FindTeam(world, positional[1]);
        var player = world.Teams.SelectMany(t => t.Squad)
            .FirstOrDefault(p => p.Name.Equals(positional[2], StringComparison.OrdinalIgnoreCase))
            ?? throw new ArgumentException($"Jogador não encontrado: {positional[2]}");
        var offer = long.Parse(positional[3]);
        var market = new TransferMarket(world, ctx);
        Console.WriteLine($"{player.Name} ({player.Club}) — força {player.Strength}, valor {player.Value:N0}, pedido {player.AskingPrice:N0}{(player.IsListed ? ", à venda" : "")}");
        Console.WriteLine($"Disposição para {buyer}: {TransferMarket.PlayerWillingness(player, buyer)}");
        var result = market.MakeOffer(player, buyer, offer);
        Console.WriteLine($"Oferta de {offer:N0}: {result.Result}, preço exigido {result.RequiredPrice:N0}"
            + (result.DemandedSalary is { } sal ? $", salário exigido {sal:N0}" : ""));
        if (player.Club == buyer) Console.WriteLine($"Contratado. Caixa de {buyer}: {buyer.Cash:N0}");
        return 0;
    }

    case "calendario":
    {
        var world = NewWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        if (options.TryGetValue("ano", out var y)) state.BaseYear = int.Parse(y);
        var session = new GameSession(state, ctx);
        session.BuildSeasonCalendar();
        var cal = session.Calendar;

        var typed = cal.Days.Count(d => d.Type != DayType.Nenhum);
        Console.WriteLine($"Calendário {cal.Year} — {cal.Days.Count} dias, corrente {cal.Days[cal.CurrentIndex].Date:dd/MM/yyyy}, {typed} com competição");
        var counts = cal.Days.Where(d => d.Type != DayType.Nenhum).GroupBy(d => d.Type).OrderBy(g => (int)g.Key);
        Console.WriteLine("  " + string.Join("  ", counts.Select(g => $"{g.Key.DisplayName()}={g.Count()}")));
        Console.WriteLine($"{"Data",-12} {"Dia",-4} {"Tipo",-18} Eventos");
        foreach (var d in cal.Days)
        {
            if (d.Type == DayType.Nenhum && d.QueueAfterMatch.Count == 0 && d.QueueEndOfDay.Count == 0) continue;
            var events = string.Join(",", d.QueueAfterMatch.Concat(d.QueueEndOfDay).Select(DayEvents.OriginalName));
            Console.WriteLine($"{d.Date:dd/MM/yyyy}   {Weekday(d.Date),-4} {d.Type.DisplayName(),-18} {events}");
        }
        return 0;

        static string Weekday(DateOnly date) => date.DayOfWeek switch
        {
            DayOfWeek.Sunday => "dom",
            DayOfWeek.Monday => "seg",
            DayOfWeek.Tuesday => "ter",
            DayOfWeek.Wednesday => "qua",
            DayOfWeek.Thursday => "qui",
            DayOfWeek.Friday => "sex",
            _ => "sáb",
        };
    }

    case "rodada":
    {
        var world = NewWorld();
        var league = world.LeagueOf(Countries.Brasil) ?? throw new InvalidOperationException("Sem liga brasileira.");
        var teams = league.Divisions[0].ToList();
        ctx.Random.Shuffle(teams);
        var competition = new Competition(1, league.Name, CompetitionType.Nacional);
        var matches = Enumerable.Range(0, teams.Count / 2)
            .Select(i => new Match(teams[2 * i], teams[2 * i + 1], competition, ctx.Random)).ToList();
        MatchSimulator.PlayRound(matches, world.Teams, ctx);
        foreach (var m in matches) Console.WriteLine(m);
        return 0;
    }

    case "temporada":
    {
        var world = NewWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        if (options.TryGetValue("ano", out var ty)) state.BaseYear = int.Parse(ty);
        var session = new GameSession(state, ctx);
        session.BuildSeasonCalendar();

        var country = options.TryGetValue("pais", out var pn) ? int.Parse(pn) : Countries.Brasil;
        var division = options.TryGetValue("divisao", out var dv) ? int.Parse(dv) : 1;
        var league = SeasonBuilder.CreateNationalDivision(session, country, division)
            ?? throw new InvalidOperationException("Divisão inexistente.");

        var maxMatchDays = options.TryGetValue("jornadas", out var jn) ? int.Parse(jn) : int.MaxValue;
        var played = 0;
        while (!session.SeasonEnded && played < maxMatchDays && !league.IsComplete)
        {
            session.AdvanceToNextMatchDay();
            played++;
        }

        Console.WriteLine($"{league.Competition.Name} — {league.Rounds.Count} rodadas, {league.TotalMatches} jogos, {league.Standing.Count} clubes");
        Console.WriteLine($"Jornadas processadas: {played}. Completa: {(league.IsComplete ? "sim" : "não")}");
        Console.WriteLine();
        Console.WriteLine($"{"#",3} {"Clube",-28} {"Pts",4} {"J",3} {"V",3} {"E",3} {"D",3} {"GP",4} {"GC",4} {"SG",4}");
        var pos = 0;
        foreach (var row in league.Standing)
        {
            pos++;
            Console.WriteLine($"{pos,3} {row.Team.Name,-28} {row.Points,4} {row.Played,3} {row.Won,3} {row.Drawn,3} {row.Lost,3} {row.GoalsFor,4} {row.GoalsAgainst,4} {row.GoalDifference,4}");
        }
        return 0;
    }

    case "copa":
    {
        var world = NewWorld();
        var country = options.TryGetValue("pais", out var cp) ? int.Parse(cp) : Countries.Brasil;
        var division = options.TryGetValue("divisao", out var cd) ? int.Parse(cd) : 1;
        var league = world.LeagueOf(country) ?? throw new InvalidOperationException("Sem liga nesse país.");
        var pool = league.Divisions[Math.Clamp(division - 1, 0, league.Divisions.Count - 1)];
        var size = int.Parse(options.GetValueOrDefault("times") ?? "8");
        // Sorteio de copa (f/f.a): quadro potência de dois (8..128) e mistura das duas metades.
        var seeded = CupDraw.SeedFromPool(pool.Take(size).ToList(), ctx.Random);
        if (seeded.Count == 0)
        {
            Console.Error.WriteLine("São precisos pelo menos 8 clubes (--times N).");
            return 1;
        }

        var twoLegged = options.ContainsKey("ida-e-volta");
        var bracket = new KnockoutBracket(
            new Competition((int)CompetitionType.CopaNacional + 1, "Copa Nacional", CompetitionType.CopaNacional),
            seeded, twoLegged: twoLegged, awayGoalsRule: twoLegged, shootoutAllowed: true);

        var champion = bracket.PlayAll(ctx);

        for (var r = 0; r < bracket.Rounds.Count; r++)
        {
            Console.WriteLine($"{bracket.RoundName(r)}:");
            foreach (var p in bracket.Rounds[r].Pairings)
            {
                Console.WriteLine($"  {p.FirstLeg!}");
                if (p.SecondLeg is not null) Console.WriteLine($"  {p.SecondLeg}");
                Console.WriteLine($"  -> avança {p.Winner!.Name}");
            }
        }
        Console.WriteLine();
        Console.WriteLine($"Campeão: {champion.Name} ({seeded.Count} clubes, {(twoLegged ? "ida e volta" : "jogo único")})");
        return 0;
    }

    case "copadobrasil":
    {
        var world = NewWorld();
        var country = options.TryGetValue("pais", out var cpb) ? int.Parse(cpb) : Countries.Brasil;
        var league = world.LeagueOf(country);
        var pool = league is null ? world.Teams.ToList() : league.Teams.ToList();

        if (options.ContainsKey("temporada"))
        {
            var state = GameState.FromWorld(world, new GameOptions());
            if (options.TryGetValue("ano", out var cby)) state.BaseYear = int.Parse(cby);
            var session = new GameSession(state, ctx);
            session.BuildSeasonCalendar();

            var cup = SeasonBuilder.CreateCopaDoBrasil(session, pool);
            if (cup is null)
            {
                Console.WriteLine($"Grupo de {pool.Count} clubes não comporta o formato de potes; use `copa`.");
                return 1;
            }
            Console.WriteLine($"Copa do Brasil {session.Year} — {pool.Count} clubes, {cup.Heads.Count} cabeças, {CopaDoBrasilCompetition.RequiredDaySlots()} dias");
            Console.WriteLine($"Cabeças: {string.Join(", ", cup.Heads.Select(h => h.Name))}");

            while (!session.SeasonEnded && !cup.IsComplete)
            {
                var playingDay = session.CurrentDay;
                var stageBefore = cup.Stage;
                session.AdvanceToNextMatchDay();
                var played = playingDay.Matches
                    .Where(m => ReferenceEquals(m.Competition, cup.Competition)).ToList();
                if (played.Count == 0) continue;
                var legs = CopaDoBrasilCompetition.TwoLeggedAt(stageBefore) ? "ida e volta" : "jogo único";
                Console.WriteLine();
                Console.WriteLine($"{playingDay.Date:dd/MM} — fase {stageBefore + 1} ({CopaDoBrasil.StageCodes[stageBefore]}), {legs}");
                foreach (var m in played)
                    Console.WriteLine($"  {m.Home.Name} {m.Score[0]} x {m.Score[1]} {m.Away.Name}");
            }

            Console.WriteLine();
            Console.WriteLine($"Campeão: {cup.Champion?.Name ?? "(não decidido)"}");
            return 0;
        }

        var competition = new Competition(2029, "Copa do Brasil", CompetitionType.CopaNacional);
        var champion = CopaDoBrasil.Play(competition, pool, ctx);
        if (champion is null)
        {
            Console.WriteLine($"Grupo de {pool.Count} clubes não comporta o formato de potes; use `copa`.");
            return 1;
        }
        Console.WriteLine($"Campeão da Copa do Brasil: {champion.Name} ({pool.Count} clubes no grupo)");
        return 0;
    }

    case "estadual":
    {
        var world = NewWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        if (options.TryGetValue("ano", out var ey)) state.BaseYear = int.Parse(ey);
        var session = new GameSession(state, ctx);
        session.BuildSeasonCalendar();

        var stateId = ResolveState(options.GetValueOrDefault("estado") ?? "SP");
        var configs = WorldLoader.LoadStateConfigs(gameDir);
        var federation = StateFederation.Build(session, stateId, configs, state.Options.UsaGrupoPadraoEstadual);
        if (federation.Divisions.Count == 0)
        {
            Console.WriteLine($"{StateFormulaTable.NameOf(stateId)}: menos de 6 clubes; sem campeonato estadual.");
            return 1;
        }

        var totalRounds = federation.Divisions.Sum(d => d.Phased.Phase1.Sum(l => l.Rounds.Count));
        Console.WriteLine($"{StateFormulaTable.DemonymOf(stateId)} {session.Year} — {federation.Divisions.Count} divisões, {totalRounds} rodadas de grupos, {federation.Leftovers.Count} clubes de fora");
        while (!session.SeasonEnded && !federation.Divisions.All(d => d.Phased.IsComplete))
            session.AdvanceToNextMatchDay();

        foreach (var division in federation.Divisions)
        {
            Console.WriteLine();
            Console.WriteLine($"{division.Competition.Name} — {division.Roster.Count} clubes, {division.Phased.Phase1.Sum(l => l.Rounds.Count)} rodadas, {division.Relegated} rebaixados");
            PrintStanding(division.Phased.Standing);
            Console.WriteLine($"Campeão: {division.Phased.Champion?.Name ?? "(não decidido)"}");
        }

        var movements = federation.SettlePromotionRelegation();
        Console.WriteLine();
        Console.WriteLine($"Acesso/rebaixamento: {movements.Movements.Count} movimentações");
        foreach (var (from, to, team) in movements.Movements)
            Console.WriteLine($"  {team.Name}: {DivisionName(federation, from)} → {DivisionName(federation, to)}");
        return 0;
    }

    case "regionais":
    {
        var world = NewWorld();
        var state = GameState.FromWorld(world, new GameOptions());
        if (options.TryGetValue("ano", out var ry)) state.BaseYear = int.Parse(ry);
        var session = new GameSession(state, ctx);
        session.BuildSeasonCalendar();

        var regionais = SeasonBuilder.CreateRegionalChampionships(session);
        if (regionais.Count == 0)
        {
            Console.WriteLine("Nenhuma região com 16 clubes brasileiros; nada a jogar.");
            return 1;
        }

        Console.WriteLine($"{regionais.Count} torneios regionais, {regionais.Sum(r => r.Pool.Count)} clubes");
        while (!session.SeasonEnded && !regionais.All(r => r.IsComplete))
            session.AdvanceToNextMatchDay();

        foreach (var regional in regionais)
        {
            Console.WriteLine();
            Console.WriteLine($"{regional.Competition.Name} — {regional.Pool.Count} clubes em {regional.Groups.Count} grupos");
            PrintStanding(regional.Standing);
            Console.WriteLine($"Campeão: {regional.Champion?.Name ?? "(não decidido)"}");
        }
        return 0;
    }

    case "amistoso":
    {
        var world = NewWorld();
        if (positional.Count >= 2 && positional[1].Equals("torneio", StringComparison.OrdinalIgnoreCase))
        {
            var state = GameState.FromWorld(world, new GameOptions());
            if (options.TryGetValue("ano", out var ty2)) state.BaseYear = int.Parse(ty2);
            var session = new GameSession(state, ctx);
            session.BuildSeasonCalendar();

            var count = int.Parse(options.GetValueOrDefault("times") ?? "8");
            var field = world.Teams.Take(count).ToList();
            var tournament = FriendlyTournament.Create(session, field);
            Console.WriteLine($"{tournament.Competition.Name} — {field.Count} clubes em {tournament.Groups.Count} grupos de {tournament.Groups[0].Count} ({FriendlyTournament.DefaultCity})");
            while (!session.SeasonEnded && !tournament.IsComplete)
                session.AdvanceToNextMatchDay();
            PrintStanding(tournament.Standing);
            Console.WriteLine($"Campeão: {tournament.Champion?.Name ?? "(não decidido)"}");
            return 0;
        }

        var inviter = FindTeam(world, positional[1]);
        var opponent = FindTeam(world, positional[2]);
        var opponentHosts = options.ContainsKey("adversario-manda");
        var response = FriendlyMatch.Respond(inviter, opponent, opponentHosts, opponentHasMatchThatDay: false);
        Console.WriteLine($"{inviter.Name} convida {opponent.Name} ({(opponentHosts ? "adversário manda" : "convidante manda")})");
        Console.WriteLine($"Resposta: {response.Outcome} — cachê {response.Fee:N0}");
        if (response.Outcome is FriendlyOutcome.Refused or FriendlyOutcome.AlreadyScheduledThatDay) return 1;

        var competition = new Competition((int)CompetitionType.Amistoso, "Amistoso", CompetitionType.Amistoso);
        var match = FriendlyMatch.Create(inviter, opponent, opponentHosts, competition, ctx.Random);
        MatchSimulator.Play(match, ctx);
        PostMatch.Apply(match, ctx);
        PrintMatch(match);
        return 0;
    }

    default:
        PrintUsage();
        return 1;
}

static int ResolveState(string value)
{
    if (int.TryParse(value, out var id)) return id;
    for (var i = 0; i < StateFormulaTable.Abbreviations.Length; i++)
        if (StateFormulaTable.Abbreviations[i].Equals(value, StringComparison.OrdinalIgnoreCase)) return i;
    throw new ArgumentException($"Estado desconhecido: {value} (use a sigla, ex.: SP)");
}

static string DivisionName(StateFederation federation, int division) =>
    division == 0 ? "Fora da liga" : federation.Divisions[division - 1].Competition.Name;

static void PrintStanding(IEnumerable<TeamStanding> rows)
{
    Console.WriteLine($"{"#",3} {"Clube",-28} {"Pts",4} {"J",3} {"V",3} {"E",3} {"D",3} {"GP",4} {"GC",4} {"SG",4}");
    var pos = 0;
    foreach (var row in rows)
    {
        pos++;
        Console.WriteLine($"{pos,3} {row.Team.Name,-28} {row.Points,4} {row.Played,3} {row.Won,3} {row.Drawn,3} {row.Lost,3} {row.GoalsFor,4} {row.GoalsAgainst,4} {row.GoalDifference,4}");
    }
}

World NewWorld(IEnumerable<string>? humans = null)
{
    var countries = options.TryGetValue("ligas", out var l) ? l.Split(',').Select(int.Parse) : [Countries.Brasil, 65];
    return WorldLoader.NewGame(gameDir, ctx, countries, humans);
}

static Team FindTeam(World world, string query) =>
    world.Teams.FirstOrDefault(t => t.FileRef.Equals(query, StringComparison.OrdinalIgnoreCase))
    ?? world.Teams.FirstOrDefault(t => t.Name.Equals(query, StringComparison.OrdinalIgnoreCase))
    ?? throw new ArgumentException($"Time não encontrado: {query} (use o nome do arquivo .ban, ex.: flamengo_bra)");

static Competition CompetitionFrom(Dictionary<string, string> options)
{
    var type = options.TryGetValue("competicao", out var c)
        ? Enum.Parse<CompetitionType>(c, ignoreCase: true)
        : CompetitionType.Nacional;
    return new Competition((int)type + 1, type.ToString(), type);
}

static double AverageStarterStrength(Team team) =>
    team.Squad.OrderByDescending(p => p.Strength).Take(11).Average(p => p.Strength);

static void PrintMatch(Match match)
{
    Console.WriteLine(match);
    for (var side = 0; side < 2; side++)
    {
        var team = match.TeamOf(side);
        Console.WriteLine($"\n{team} ({Pitch.FormationNames[team.Tactics.Formation]}, marcação {team.Tactics.Marking}):");
        foreach (var p in match.Lineup[side])
            Console.WriteLine($"  {p.Slot,2} {p.Position.ToString()[0]} {p.Name,-24} força {p.Strength,3}  nota {p.LastRating:F1}");
    }
    Console.WriteLine("\nLances:");
    foreach (var e in match.Events.Where(e => e.Type != MatchEventType.Assistencia)) Console.WriteLine($"  {e}");
    Console.WriteLine($"\nPosse {match.Possession[0]}% x {match.Possession[1]}%");
    Console.WriteLine($"Finalizações {match.Shots[0]} x {match.Shots[1]} (no alvo {match.ShotsOnTarget[0]} x {match.ShotsOnTarget[1]})");
    Console.WriteLine($"Desarmes {match.Tackles[0]} x {match.Tackles[1]} | Passes errados {match.MisplacedPasses[0]} x {match.MisplacedPasses[1]}");
}

static void DumpJavaObject(JavaObject o, string indent)
{
    Console.WriteLine($"{indent}{o.ClassName}");
    foreach (var (k, v) in o.Fields)
    {
        if (v is JavaObject child)
        {
            Console.WriteLine($"{indent}  {k}:");
            DumpJavaObject(child, indent + "    ");
        }
        else Console.WriteLine($"{indent}  {k} = {v}");
    }
    foreach (var a in o.Annotations.OfType<JavaObject>().Take(2)) DumpJavaObject(a, indent + "  - ");
    if (o.Annotations.Count > 0) Console.WriteLine($"{indent}  ({o.Annotations.Count} itens)");
}

static string FindGameDir()
{
    for (var dir = new DirectoryInfo(AppContext.BaseDirectory); dir != null; dir = dir.Parent)
    {
        var candidate = Path.Combine(dir.FullName, "brasfoot-linux");
        if (Directory.Exists(Path.Combine(candidate, "teams"))) return candidate;
    }
    throw new DirectoryNotFoundException("Pasta do jogo não encontrada; use --jogo <pasta com teams/>.");
}

static Dictionary<string, string> ParseOptions(string[] args, out List<string> positional)
{
    var options = new Dictionary<string, string>();
    positional = new List<string>();
    for (var i = 0; i < args.Length; i++)
    {
        if (!args[i].StartsWith("--")) positional.Add(args[i]);
        else if (i + 1 < args.Length && !args[i + 1].StartsWith("--")) options[args[i][2..]] = args[++i];
        else options[args[i][2..]] = "";
    }
    return options;
}

static void PrintUsage()
{
    Console.WriteLine("""
        Uso: brasfoot <comando> [opções]
          simular <mandante> <visitante>       Simula uma partida e mostra lances e notas
          lote <mandante> <visitante> --n N    Simula N partidas e mostra as médias
          rodada                               Joga uma rodada da Série A
          temporada                            Joga a temporada da liga (--pais 1 --divisao 1 --jornadas N)
          copa [--times 8] [--ida-e-volta]     Joga um mata-mata entre clubes da divisão
          copadobrasil [--pais 1] [--temporada]  Copa do Brasil (formato de 8 potes; --temporada agenda no laço de dias)
          estadual [--estado SP] [--ano A]     Joga o campeonato estadual de um estado
          regionais [--ano A]                  Joga os torneios regionais (Rio-SP, Sul-Minas, ...)
          amistoso <time> <adversario>         Convite e amistoso entre dois clubes (--adversario-manda)
          amistoso torneio [--times 8]         Joga o Torneio Amistoso de pré-temporada
          calendario [--ano A]                 Mostra o calendário da temporada (tipos e eventos)
          elenco <time>                        Elenco com força, valor e salário
          proposta <seu-time> <jogador> <valor>  Faz uma proposta por um jogador
          dump <arquivo>                       Mostra um arquivo serializado do jogo
        Opções: --seed N  --competicao Nacional|CopaNacional|Internacional1|...  --corrigir  --jogo <pasta>
                --ligas 29,65 (países com liga simulada)
        Times são identificados pelo nome do arquivo .ban (ex.: flamengo_bra) ou pelo nome.
        """);
}
