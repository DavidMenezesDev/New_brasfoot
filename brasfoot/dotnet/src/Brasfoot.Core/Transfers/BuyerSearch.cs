using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Transfers;

/// <summary>Modo da busca: 0 = normal, 1 = venda "para cima" (clubes de reputação), 2 = grandes da Europa.</summary>
public enum BuyerSearchMode { Normal = 0, Upward = 1, BigEuropean = 2 }

/// <summary>
/// Busca de um clube da IA comprador (<c>best.l</c>). O preço do negócio é sempre o informado
/// na criação; clubes da IA não têm caixa de transferências.
/// </summary>
public sealed class BuyerSearch
{
    /// <summary>Força mínima para um clube de liga contratar, por divisão (<c>aq.qg</c>).</summary>
    public static readonly int[] MinStrengthByDivision = [1, 40, 30, 20, 5];

    /// <summary>Força mínima para um clube de reputação contratar (<c>aq.qh</c>).</summary>
    public static readonly int[] MinStrengthByReputation = [1, 10, 20, 40, 50, 55];

    /// <summary>Força máxima que um clube contrata, por reputação (<c>aq.qi</c>).</summary>
    public static readonly int[] MaxStrengthByReputation = [20, 30, 45, 85, 100, 100];

    public const int MaxSquad = 35;

    private readonly World _world;
    private readonly GameContext _ctx;
    private readonly IGameRandom _random;
    private readonly Player _player;
    private readonly Team _seller;
    private readonly BuyerSearchMode _mode;
    private readonly int _squadCap;
    private readonly bool _allowDesperate;

    // cn: ligas preferidas; co: ligas europeias fora de cn; cp: todas as ligas europeias.
    private readonly List<League> _preferred = new();
    private readonly List<League> _otherEuropean = new();
    private readonly List<League> _allEuropean = new();

    // Janela de divisões; mutável entre ligas, como no original.
    private int _minDivision;
    private int _maxDivision;

    public long Price { get; }

    /// <param name="largeSquadCap">Limite de elenco do comprador 35 (em vez de 32); também habilita o comprador "desesperado".</param>
    public BuyerSearch(World world, GameContext ctx, Player player, long price, bool largeSquadCap, BuyerSearchMode mode)
    {
        _world = world;
        _ctx = ctx;
        _random = ctx.Random;
        _player = player;
        _seller = player.Club ?? throw new InvalidOperationException("Jogador sem clube.");
        _mode = mode;
        _squadCap = largeSquadCap ? 35 : 32;
        _allowDesperate = largeSquadCap;
        Price = price;

        var leagues = world.Leagues;
        var sellerContinent = _seller.Continent;
        if (mode == BuyerSearchMode.BigEuropean)
        {
            _preferred.AddRange(leagues.Where(l => l.Continent == Continent.Europa));
            return;
        }

        if (_seller.IsLeagueClub && world.LeagueOf(_seller.CountryId) is { } own) _preferred.Add(own);
        var exportable = _seller.CountryId == Countries.Brasil && player.Strength > 50 && _random.NextInt(100) > 10;
        if (player.IsStar || player.IsWorldClass) exportable = true;
        if (sellerContinent == Continent.Europa || exportable) AddWhere(l => l.Continent == Continent.Europa);

        if (mode == BuyerSearchMode.Upward)
        {
            switch (sellerContinent)
            {
                case Continent.AmericaDoSul: AddWhere(l => l.Continent != Continent.Oceania); break;
                case Continent.Africa: AddWhere(l => l.Continent is Continent.Europa or Continent.Asia); break;
                case Continent.Asia: AddWhere(l => l.Continent is Continent.Asia or Continent.Europa); break;
            }
            if (_seller.CountryId is 131 or 68) AddWhere(l => l.Continent == Continent.Europa); // México, EUA
            else if (sellerContinent == Continent.Concacaf) AddWhere(l => l.Continent == Continent.Concacaf);
            if (sellerContinent == Continent.Oceania) AddWhere(l => l.Continent is Continent.Oceania or Continent.Asia);
        }

        _otherEuropean.AddRange(leagues.Where(l => l.Continent == Continent.Europa && !_preferred.Contains(l)));
        _allEuropean.AddRange(leagues.Where(l => l.Continent == Continent.Europa));

        void AddWhere(Func<League, bool> predicate)
        {
            foreach (var l in leagues)
                if (predicate(l) && !_preferred.Contains(l)) _preferred.Add(l);
        }
    }

    /// <summary>Busca completa (<c>l.a(bool, bool)</c>).</summary>
    public Team? Find()
    {
        var direct = true;
        if (_player.Strength > 30 && _seller.IsHuman && _random.NextInt(100) > 60) direct = false;
        if (_player.IsStar && _seller.IsHuman) direct = false;
        if (_player.IsWorldClass) direct = false;

        Team? buyer = null;
        if (direct)
        {
            buyer = SearchLeagues(_preferred);
            if (buyer == null && _seller.Reputation > 2) buyer = SearchLeagues(_otherEuropean);
        }
        else
        {
            if (_player.IsWorldClass) buyer = SearchBigEuropeanClubs();
            if (buyer == null && _player.IsWorldClass) buyer = SearchLeagues(_allEuropean);
            if (buyer == null && _player.IsStar) buyer = SearchLeagues(_allEuropean);
            if (buyer == null && _seller.Reputation > 2) buyer = SearchLeagues(_otherEuropean);
            if (buyer == null) buyer = SearchLeagues(_preferred);
        }
        buyer ??= SearchReputationClubs();
        if (buyer == null && _ctx.Season > 2 && _allowDesperate && Price < _player.Value) buyer = SearchDesperate();
        return buyer;
    }

    /// <summary>Somente clubes de reputação (<c>l.k()</c>).</summary>
    public Team? FindReputationClubOnly() => SearchReputationClubs();

    private bool IsBasicCandidate(Team t, int squadCap) =>
        t != _seller && !t.IsHuman && t.Squad.Count < squadCap && t.Id != _player.PreviousClubId;

    /// <summary>Clubes das ligas dadas dentro da janela de divisões (<c>l.a(list, bool)</c>).</summary>
    private Team? SearchLeagues(List<League> leagues)
    {
        _minDivision = _seller.Division - 1;
        _maxDivision = _seller.Division + 1;
        if (_seller.Division == 1) _minDivision = 1;
        if (_mode == BuyerSearchMode.Upward)
        {
            _minDivision = 1;
            _maxDivision = 2;
            if (_seller.Continent == Continent.Europa && _seller.Reputation >= 4 && _player.Strength >= 40) _maxDivision = 1;
        }

        var candidates = new List<Team>();
        foreach (var league in leagues)
        {
            if (_player.Strength <= 5)
            {
                _minDivision = 0;
                _maxDivision = league.DivisionCount;
            }
            else if (_player.Strength <= 20)
            {
                _maxDivision = league.DivisionCount;
            }
            if (_player.Strength <= 20) _minDivision = 0;

            candidates.AddRange(league.Teams.Where(t =>
                IsBasicCandidate(t, _squadCap) && t.Division <= _maxDivision && t.Division >= _minDivision));
        }
        _random.Shuffle(candidates);

        var positionCap = !_seller.IsHuman;
        return _mode switch
        {
            BuyerSearchMode.Upward => candidates.FirstOrDefault(t => AcceptsSimple(t, _player)),
            BuyerSearchMode.BigEuropean => candidates.FirstOrDefault(t => t.Squad.Count < MaxSquad && t.Reputation >= 4),
            _ => candidates.FirstOrDefault(t => Accepts(t, _player, positionCap)),
        };
    }

    /// <summary>Clubes fora de liga (<c>cH()</c>).</summary>
    private Team? SearchReputationClubs()
    {
        var candidates = _world.Teams.Where(t => !t.IsLeagueClub && IsBasicCandidate(t, _squadCap)).ToList();
        _random.Shuffle(candidates);
        var positionCap = !_seller.IsHuman;
        var playerContinent = Countries.Get(_player.Nationality).Continent;
        var sameCountryFirst = playerContinent is Continent.AmericaDoSul or Continent.Concacaf && _random.NextInt(100) > 15;

        if (_mode == BuyerSearchMode.BigEuropean)
            return candidates.FirstOrDefault(t => t.Squad.Count < MaxSquad && t.Continent == Continent.Europa && t.Reputation >= 4);

        Team? buyer = null;
        if (sameCountryFirst)
            buyer = candidates.FirstOrDefault(t => t.CountryId == _player.Nationality && Accepts(t, _player, positionCap));
        return buyer ?? candidates.FirstOrDefault(t => t.Continent == _seller.Continent && Accepts(t, _player, positionCap));
    }

    /// <summary>Grandes clubes europeus (<c>cI()</c>).</summary>
    private Team? SearchBigEuropeanClubs()
    {
        var candidates = _world.Teams.Where(t => t.Reputation >= 4 && IsBasicCandidate(t, _squadCap)).ToList();
        _random.Shuffle(candidates);
        var positionCap = !_seller.IsHuman;
        return candidates.FirstOrDefault(t => t.Continent == Continent.Europa && Accepts(t, _player, positionCap));
    }

    /// <summary>Último recurso (<c>cJ()</c>): no fim, qualquer clube com vaga leva o jogador.</summary>
    private Team? SearchDesperate()
    {
        var candidates = _world.Teams.Where(t => IsBasicCandidate(t, MaxSquad)).ToList();
        _random.Shuffle(candidates);
        var playerContinent = Countries.Get(_player.Nationality).Continent;
        var sameCountryFirst = playerContinent is Continent.AmericaDoSul or Continent.Concacaf && _random.NextInt(100) > 15;

        Team? buyer = null;
        if (_mode != BuyerSearchMode.BigEuropean)
        {
            if (sameCountryFirst)
                buyer = candidates.FirstOrDefault(t => t.CountryId == _player.Nationality && Accepts(t, _player, false));
            buyer ??= candidates.FirstOrDefault(t => t.Continent == _seller.Continent && Accepts(t, _player, false));
        }
        buyer ??= candidates.FirstOrDefault(t => Accepts(t, _player, false));
        return buyer ?? candidates.FirstOrDefault();
    }

    /// <summary>Clube aceita contratar (<c>ah.a(F, posCap)</c>): vaga, faixa de força e, se pedido, limite por posição.</summary>
    public static bool Accepts(Team club, Player p, bool positionCap)
    {
        if (club.Squad.Count >= MaxSquad) return false;
        if (!AcceptsStrength(club, p)) return false;
        if (p.Strength > MaxStrengthByReputation[club.Reputation]) return false;
        if (!positionCap) return true;
        var count = PositionCounts(club, includeLoaned: false)[(int)p.Position];
        return p.Position switch
        {
            Position.Goleiro => count <= 3,
            Position.Lateral or Position.Zagueiro or Position.Atacante => count <= 5,
            _ => count <= 10,
        };
    }

    /// <summary><c>ah.b(F)</c>: só vaga e força mínima.</summary>
    public static bool AcceptsSimple(Team club, Player p) => club.Squad.Count < MaxSquad && AcceptsStrength(club, p);

    private static bool AcceptsStrength(Team club, Player p) => club.IsLeagueClub
        ? p.Strength >= MinStrengthByDivision[Math.Clamp(club.Division, 0, MinStrengthByDivision.Length - 1)]
        : p.Strength >= MinStrengthByReputation[club.Reputation];

    /// <summary><c>ah.J(bool)</c>: jogadores por posição (sem ou com os emprestados ao clube).</summary>
    public static int[] PositionCounts(Team club, bool includeLoaned)
    {
        var counts = new int[5];
        foreach (var p in club.Squad)
            if (includeLoaned || !p.IsOnLoan) counts[(int)p.Position]++;
        return counts;
    }
}
