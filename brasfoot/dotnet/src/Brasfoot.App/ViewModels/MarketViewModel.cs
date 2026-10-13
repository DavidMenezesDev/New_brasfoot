using System.Collections.ObjectModel;
using System.Globalization;
using Brasfoot.Core;
using Brasfoot.Core.Domain;
using Brasfoot.Core.Season;
using Brasfoot.Core.Transfers;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;

namespace Brasfoot.App.ViewModels;

public partial class MarketViewModel : ObservableObject, IGamePage
{
    private const int MaxListings = 200;

    private readonly GameSession _session;
    private readonly Team _team;
    private readonly TransferMarket _market;
    private OfferEvaluation? _pending;
    private Player? _pendingPlayer;

    public MarketViewModel(GameSession session, Team team)
    {
        _session = session;
        _team = team;
        _market = new TransferMarket(session.State.World, session.Context);
        PositionFilters = [new PositionOption(null, "Todas as posições"), .. Enum.GetValues<Position>().Select(p => new PositionOption(p, p.ToString()))];
        _positionFilter = PositionFilters[0];
        Refresh();
    }

    public string Title => "Mercado";

    public IReadOnlyList<PositionOption> PositionFilters { get; }
    public ObservableCollection<ListingRow> Listings { get; } = new();
    public ObservableCollection<SaleRow> Squad { get; } = new();

    [ObservableProperty]
    private PositionOption _positionFilter;

    [ObservableProperty]
    private string _searchText = "";

    [ObservableProperty]
    private ListingRow? _selectedListing;

    [ObservableProperty]
    private SaleRow? _selectedSale;

    [ObservableProperty]
    private string _offerText = "";

    [ObservableProperty]
    private string _salePriceText = "";

    [ObservableProperty]
    private string _status = "";

    [ObservableProperty]
    private string _cash = "";

    [ObservableProperty]
    private bool _hasCounter;

    [ObservableProperty]
    private string _counterText = "";

    partial void OnPositionFilterChanged(PositionOption value) => Refresh();

    partial void OnSearchTextChanged(string value) => Refresh();

    [RelayCommand]
    private void Buy()
    {
        if (SelectedListing is null) return;
        Status = BuyMessage(_market.BuyAtAskingPrice(SelectedListing.Player, _team));
        Refresh();
    }

    [RelayCommand]
    private void Offer()
    {
        if (SelectedListing is null) return;
        if (!TryParseAmount(OfferText, out var amount))
        {
            Status = "Informe um valor válido para a proposta.";
            return;
        }
        var player = SelectedListing.Player;
        var evaluation = _market.MakeOffer(player, _team, amount);
        if (evaluation.Result is OfferResult.CounterOffer or OfferResult.PlayerWantsDoubleSalary)
        {
            _pending = evaluation;
            _pendingPlayer = player;
            HasCounter = true;
            CounterText = evaluation.Result == OfferResult.CounterOffer
                ? $"Contraproposta: {evaluation.RequiredPrice:N0}" + (evaluation.DemandedSalary is { } s ? $" e salário de {s:N0}" : "")
                : $"O jogador quer salário de {evaluation.DemandedSalary:N0}.";
            Status = "";
        }
        else
        {
            Status = OfferMessage(evaluation);
        }
        Refresh();
    }

    [RelayCommand]
    private void AcceptCounter()
    {
        if (_pending is null || _pendingPlayer is null) return;
        try
        {
            _market.AcceptEvaluation(_pendingPlayer, _team, _pending);
            Status = $"Negociação fechada com {_pendingPlayer.Name}.";
        }
        catch (InvalidOperationException ex)
        {
            Status = ex.Message;
        }
        ClearCounter();
        Refresh();
    }

    [RelayCommand]
    private void RequestLoan()
    {
        if (SelectedListing is null) return;
        Status = _market.RequestLoan(SelectedListing.Player, _team) switch
        {
            LoanResult.Success => "Empréstimo acertado.",
            LoanResult.LoanLimit => "Você já tem o máximo de empréstimos permitido.",
            LoanResult.PlayerRefuses => "O jogador recusou o empréstimo.",
            LoanResult.NotLoanable => "Este jogador não está disponível para empréstimo.",
            LoanResult.SquadFull => "Elenco cheio.",
            _ => "Não foi possível pedir o empréstimo.",
        };
        Refresh();
    }

    [RelayCommand]
    private void ListForSale()
    {
        if (SelectedSale is null) return;
        if (!TryParseAmount(SalePriceText, out var price) || price <= 0)
        {
            Status = "Informe um preço válido para colocar à venda.";
            return;
        }
        _market.ListForSale(SelectedSale.Player, price);
        Status = $"{SelectedSale.Name} à venda por {price:N0}.";
        Refresh();
    }

    [RelayCommand]
    private void Unlist()
    {
        if (SelectedSale is null || !SelectedSale.Player.IsListed) return;
        _market.Unlist(SelectedSale.Player);
        Status = $"{SelectedSale.Name} saiu da lista de vendas.";
        Refresh();
    }

    public void Refresh()
    {
        Cash = $"Caixa: {_team.Cash:N0}";
        Listings.Clear();
        var term = SearchText.Trim();
        var listed = _session.State.World.Teams
            .Where(t => t != _team)
            .SelectMany(t => t.Squad)
            .Where(p => p.IsListed && (PositionFilter.Value is null || p.Position == PositionFilter.Value))
            .Where(p => term.Length == 0 || p.Name.Contains(term, StringComparison.OrdinalIgnoreCase))
            .OrderByDescending(p => p.Strength)
            .Take(MaxListings);
        foreach (var p in listed)
        {
            Listings.Add(new ListingRow(p, p.Name, p.Position.ToString(), p.Strength, p.Age, p.Club?.Name ?? "",
                p.AskingPrice.ToString("N0"), WillingnessText(TransferMarket.PlayerWillingness(p, _team))));
        }

        Squad.Clear();
        foreach (var p in _team.Squad.OrderByDescending(p => p.Strength))
            Squad.Add(new SaleRow(p, p.Name, p.Position.ToString(), p.Strength, p.Value.ToString("N0"),
                p.IsListed ? p.AskingPrice.ToString("N0") : "—", p.IsListed));
    }

    private void ClearCounter()
    {
        _pending = null;
        _pendingPlayer = null;
        HasCounter = false;
        CounterText = "";
    }

    private static bool TryParseAmount(string text, out long amount) =>
        long.TryParse(text.Replace(".", "").Replace(",", "").Trim(), NumberStyles.Integer, CultureInfo.InvariantCulture, out amount);

    private static string WillingnessText(Willingness w) => w switch
    {
        Willingness.Willing => "aceita",
        Willingness.WantsDoubleSalary => "pede salário dobrado",
        _ => "recusa",
    };

    private static string BuyMessage(BuyResult r) => r switch
    {
        BuyResult.Success => "Jogador contratado.",
        BuyResult.NotListed => "O jogador não está à venda.",
        BuyResult.OwnPlayer => "Este jogador já é do seu clube.",
        BuyResult.SquadFull => "Elenco cheio.",
        BuyResult.PlayerRefuses => "O jogador recusou a transferência.",
        BuyResult.NoMoney => "Caixa insuficiente para o preço pedido.",
        _ => "Não foi possível concluir a compra.",
    };

    private static string OfferMessage(OfferEvaluation e) => e.Result switch
    {
        OfferResult.Accepted => "Proposta aceita.",
        OfferResult.Rejected => $"Proposta recusada. Preço exigido: {e.RequiredPrice:N0}.",
        OfferResult.PlayerRefuses => "O jogador recusou a transferência.",
        OfferResult.InsufficientCash => "A oferta é maior que o seu caixa.",
        OfferResult.NeedsHumanSeller => "Este jogador pertence a outro técnico humano; a negociação não é possível.",
        _ => "Proposta não aceita.",
    };
}

public sealed record PositionOption(Position? Value, string Name);

public sealed record ListingRow(Player Player, string Name, string Position, int Strength, int Age, string Club, string Asking, string Willingness);

public sealed record SaleRow(Player Player, string Name, string Position, int Strength, string Value, string Asking, bool Listed);
