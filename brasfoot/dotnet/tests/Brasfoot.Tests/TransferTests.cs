using Brasfoot.Core.Domain;
using Brasfoot.Core.Transfers;

namespace Brasfoot.Tests;

public class TransferTests
{
    private static (World, TransferMarket, Team Seller, Team Buyer) Setup(int seed = 1)
    {
        var ctx = TestData.Context(seed);
        var world = new World();
        var seller = TestData.Team("Vendedor", 50);
        var buyer = TestData.Team("Comprador", 50);
        buyer.IsHuman = true;
        buyer.Cash = 100_000_000;
        world.Teams.AddRange([seller, buyer]);
        return (world, new TransferMarket(world, ctx), seller, buyer);
    }

    [Fact]
    public void Offer_requirement_depends_on_seller_depth()
    {
        var (_, market, seller, buyer) = Setup();
        // Vendedor tem 5 atacantes (>= 4): pede valor + 50%.
        var forward = seller.Squad.First(p => p.Position == Position.Atacante);
        var eval = market.EvaluateOffer(forward, buyer, 1_000_000);
        Assert.Equal(1_500_000, eval.RequiredPrice);
        Assert.Equal(OfferResult.CounterOffer, eval.Result);

        // Último goleiro: valor + 150%.
        seller.Squad.RemoveAll(p => p.Position == Position.Goleiro && p != seller.Squad.First(q => q.Position == Position.Goleiro));
        var keeper = seller.Squad.First(p => p.Position == Position.Goleiro);
        Assert.Equal(2_500_000, market.EvaluateOffer(keeper, buyer, 0).RequiredPrice);
    }

    [Fact]
    public void Accepted_offer_moves_player_and_money()
    {
        var (world, market, seller, buyer) = Setup();
        var forward = seller.Squad.First(p => p.Position == Position.Atacante);
        var result = market.MakeOffer(forward, buyer, 1_500_000);
        Assert.Equal(OfferResult.Accepted, result.Result);
        Assert.Same(buyer, forward.Club);
        Assert.Contains(forward, buyer.Squad);
        Assert.DoesNotContain(forward, seller.Squad);
        Assert.Equal(100_000_000 - 1_500_000, buyer.Cash);
        Assert.Single(world.TransferHistory);
    }

    [Fact]
    public void Offer_above_cash_is_refused()
    {
        var (_, market, seller, buyer) = Setup();
        buyer.Cash = 10;
        Assert.Equal(OfferResult.InsufficientCash, market.MakeOffer(seller.Squad[0], buyer, 1_000).Result);
    }

    [Theory]
    [InlineData(0, 0)]
    [InlineData(20, 0.12)]
    [InlineData(45, 0.20)]
    [InlineData(80, 0.22)]
    [InlineData(150, 0.25)]
    [InlineData(400, 0.30)]
    public void Rescission_fine_by_days_left(int days, double rate) =>
        Assert.Equal(rate, TransferMarket.RescissionFineRate(days));

    [Fact]
    public void Human_seller_pays_rescission_fine()
    {
        var (_, market, seller, buyer) = Setup();
        seller.IsHuman = true;
        seller.Cash = 0;
        var p = seller.Squad[5];
        p.ContractEnd = new DateOnly(2022, 1, 21); // 20 dias → 12%
        var fine = market.Transfer(p, buyer, 1_000_000, applyFine: true);
        Assert.Equal(120_000, fine);
        Assert.Equal(880_000, seller.Cash);
    }

    [Fact]
    public void Stars_of_big_european_clubs_refuse_small_clubs()
    {
        var big = TestData.Team("Grande", 80, country: 65, reputation: 5);
        var star = big.Squad[0];
        Assert.Equal(Willingness.Refuses, TransferMarket.PlayerWillingness(star, TestData.Team("Pequeno", 30, reputation: 2, division: 2)));
        Assert.Equal(Willingness.WantsDoubleSalary, TransferMarket.PlayerWillingness(star, TestData.Team("Médio", 30, reputation: 3, division: 2)));
        Assert.Equal(Willingness.Willing, TransferMarket.PlayerWillingness(star, TestData.Team("Europeu", 30, country: 97, reputation: 1)));
    }

    [Fact]
    public void Renewal_asks_raise_unless_contract_is_ending()
    {
        var (_, market, seller, _) = Setup();
        var p = seller.Squad[0];
        p.Value = 10_000_000;
        p.Salary = 100_000;
        p.ContractEnd = new DateOnly(2023, 1, 1); // muitos dias: aumento de 12% para 1 ano
        var eval = market.EvaluateRenewal(p, 1, 100_000);
        Assert.Equal(RenewalResult.CounterProposal, eval.Result);
        Assert.Equal(112_000, eval.MinimumSalary);

        p.ContractEnd = new DateOnly(2022, 2, 1); // menos de 60 dias: aceita 3% de corte
        Assert.Equal(RenewalResult.Accepted, market.EvaluateRenewal(p, 1, 97_000).Result);
        Assert.Equal(RenewalResult.SalaryAboveLimit, market.EvaluateRenewal(p, 1, 2_500_000).Result);
    }

    [Fact]
    public void Buyer_search_finds_ai_club_in_league()
    {
        var ctx = TestData.Context(5);
        var world = new World();
        var league = new League(Countries.Brasil, "Teste");
        var seller = TestData.Team("Vendedor", 45);
        var a = TestData.Team("A", 45);
        var b = TestData.Team("B", 45);
        league.Divisions.Add([seller, a, b]);
        world.Leagues.Add(league);
        world.Teams.AddRange([seller, a, b]);
        a.Squad.RemoveAll(p => p.Position == Position.Meia); // A precisa de meias
        b.Squad.RemoveAll(p => p.Position == Position.Meia);
        var player = seller.Squad.First(p => p.Position == Position.Meia);

        var buyer = new BuyerSearch(world, ctx, player, player.Value, largeSquadCap: true, BuyerSearchMode.Normal).Find();
        Assert.NotNull(buyer);
        Assert.NotSame(seller, buyer);
    }

    [Fact]
    public void Club_acceptance_respects_strength_limits()
    {
        var club = TestData.Team("Clube", 50, reputation: 2, league: false);
        var weak = TestData.Player(club, Position.Meia, 10);
        var good = TestData.Player(club, Position.Meia, 30);
        var tooGood = TestData.Player(club, Position.Meia, 60);
        Assert.False(BuyerSearch.Accepts(club, weak, false));   // < qh[2] = 20
        Assert.True(BuyerSearch.Accepts(club, good, false));
        Assert.False(BuyerSearch.Accepts(club, tooGood, false)); // > qi[2] = 45
    }
}
