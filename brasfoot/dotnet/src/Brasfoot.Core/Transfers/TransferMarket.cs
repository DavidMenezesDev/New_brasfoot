using Brasfoot.Core.Common;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Transfers;

public enum BuyResult { NotListed = 0, Success = 1, OwnPlayer = 2, SquadFull = 3, PlayerRefuses = 4, NoMoney = 5 }

public enum OfferResult
{
    Rejected = 0, Accepted = 1, PlayerRefuses = 4, PlayerWantsDoubleSalary = 6, CounterOffer = 7,
    /// <summary>Oferta maior que o caixa do comprador.</summary>
    InsufficientCash = 8,
    /// <summary>Vendedor humano: o outro técnico precisa aceitar.</summary>
    NeedsHumanSeller = 9,
}

public enum LoanResult { Invalid = 0, Success = 1, OwnPlayer = 2, LoanLimit = 3, PlayerRefuses = 4, NotLoanable = 5, SquadFull = 6 }

public enum Willingness { Willing = 0, Refuses = 1, WantsDoubleSalary = 2 }

/// <param name="RequiredPrice">Preço que o clube vendedor aceita (a contraproposta, quando houver).</param>
/// <param name="DemandedSalary">Salário exigido pelo jogador (o dobro do atual), quando houver.</param>
public sealed record OfferEvaluation(OfferResult Result, long RequiredPrice, long? DemandedSalary = null);

public enum RenewalResult { Accepted, SalaryAboveLimit, CounterProposal }

/// <param name="MinimumSalary">Salário que o jogador aceita (contraproposta).</param>
public sealed record RenewalEvaluation(RenewalResult Result, long MinimumSalary, long SalaryLimit);

/// <summary>Venda de um jogador humano para a IA após a rodada.</summary>
public sealed record AiPurchase(Player Player, Team From, Team To, long Price, long Fine);

/// <summary>Operações de mercado e contratos (<c>best.l</c>, <c>F.a(ah, …)</c>, <c>a/fy</c>, <c>components.an</c>).</summary>
public sealed class TransferMarket(World world, GameContext ctx)
{
    public const int MaxLoansIn = 4;
    public static readonly int[] RenewalDays = [180, 365, 730, 1095];
    private static readonly int[] RenewalDiscountPct = [1, 3, 5, 12];
    private static readonly int[] RenewalRaisePct = [10, 12, 15, 5];

    private readonly IGameRandom _random = ctx.Random;

    // ---- Disposição do jogador ----

    /// <summary><c>l.c</c>: estrelas de grandes clubes europeus recusam clubes menores ou pedem o dobro do salário.</summary>
    public static Willingness PlayerWillingness(Player p, Team buyer)
    {
        if (buyer.Continent == Continent.Europa) return Willingness.Willing;
        var club = p.Club!;
        if (club.Continent == Continent.Europa && club.Reputation >= 4)
        {
            if (buyer.Reputation >= 4 || buyer.Division == 1) return Willingness.Willing;
            if (buyer.Reputation >= 3) return Willingness.WantsDoubleSalary;
            return Willingness.Refuses;
        }
        if (club.Reputation >= 3 && buyer.Reputation >= 3) return Willingness.Willing;
        if (club.Reputation == 3 && buyer.Reputation is 2 or 1) return Willingness.Willing;
        if (club.Reputation <= 2) return Willingness.Willing;
        return Willingness.Refuses;
    }

    /// <summary><c>l.d</c>: só aceita sem condições.</summary>
    public static bool IsWilling(Player p, Team buyer) => PlayerWillingness(p, buyer) == Willingness.Willing;

    // ---- Compra ----

    /// <summary>"Comprar" pelo preço pedido (<c>l.b</c>).</summary>
    public BuyResult BuyAtAskingPrice(Player p, Team buyer)
    {
        if (!p.IsListed) return BuyResult.NotListed;
        if (buyer == p.Club) return BuyResult.OwnPlayer;
        if (buyer.Cash < p.AskingPrice) return BuyResult.NoMoney;
        if (buyer.Squad.Count >= BuyerSearch.MaxSquad) return BuyResult.SquadFull;
        if (!IsWilling(p, buyer)) return BuyResult.PlayerRefuses;
        Transfer(p, buyer, p.AskingPrice, applyFine: false);
        return BuyResult.Success;
    }

    /// <summary>
    /// Proposta livre (<c>a/cz.oL()</c> + <c>l.a(F, ah, int)</c>). Determinística: o preço exigido
    /// depende de quantos jogadores o vendedor tem na posição. Quando a resposta é
    /// <see cref="OfferResult.Accepted"/> a transferência já foi feita; contraproposta e pedido de
    /// salário dobrado precisam de <see cref="AcceptEvaluation"/>.
    /// </summary>
    public OfferEvaluation MakeOffer(Player p, Team buyer, long offer)
    {
        if (offer > buyer.Cash) return new OfferEvaluation(OfferResult.InsufficientCash, 0);
        if (p.Club!.IsHuman) return new OfferEvaluation(OfferResult.NeedsHumanSeller, offer);
        if (p.IsListed && offer >= p.AskingPrice)
        {
            var bought = BuyAtAskingPrice(p, buyer);
            return bought == BuyResult.Success
                ? new OfferEvaluation(OfferResult.Accepted, p.AskingPrice)
                : new OfferEvaluation(bought == BuyResult.PlayerRefuses ? OfferResult.PlayerRefuses : OfferResult.Rejected, p.AskingPrice);
        }

        var evaluation = EvaluateOffer(p, buyer, offer);
        if (evaluation.Result == OfferResult.Accepted) Transfer(p, buyer, offer, applyFine: false);
        return evaluation;
    }

    /// <summary><c>l.a(F, ah, int)</c> sem executar a transferência.</summary>
    public OfferEvaluation EvaluateOffer(Player p, Team buyer, long offer)
    {
        var fix = ctx.Options.FixOriginalBugs;
        var pos = (int)p.Position;
        var count = BuyerSearch.PositionCounts(p.Club!, includeLoaned: false)[pos];
        int[] depth = [3, 4, 4, 5, 4];
        double[] lastOne = [1.5, 1.5, 1.5, 1.5, 2.0];
        double[] few = [1.0, 1.0, 1.0, 1.0, 1.5];
        double[] premium = [0.5, 0.2, 0.2, 0.2, 0.5];
        int[] discountPct = [15, 20, 20, 10, 10];
        var value = p.Value;

        long required;
        if (count >= depth[pos])
        {
            required = p.Strength < 30 || p.Age > 35
                ? value - (fix ? value * discountPct[pos] / 100 : unchecked((int)value * discountPct[pos]) / 100)
                : value + JMath.Round(value * premium[pos]);
        }
        else if (count == 1)
        {
            required = value + JMath.Round(value * lastOne[pos]);
        }
        else
        {
            required = value + JMath.Round(value * few[pos]);
        }

        if (offer >= required)
        {
            return PlayerWillingness(p, buyer) switch
            {
                Willingness.Refuses => new OfferEvaluation(OfferResult.PlayerRefuses, required),
                Willingness.WantsDoubleSalary => new OfferEvaluation(OfferResult.PlayerWantsDoubleSalary, offer, p.Salary * 2),
                _ => new OfferEvaluation(OfferResult.Accepted, offer),
            };
        }
        if (buyer.Cash >= required)
        {
            var w = PlayerWillingness(p, buyer);
            if (w != Willingness.Refuses)
                return new OfferEvaluation(OfferResult.CounterOffer, required, w == Willingness.WantsDoubleSalary ? p.Salary * 2 : null);
        }
        return new OfferEvaluation(OfferResult.Rejected, required);
    }

    /// <summary>O comprador aceita a contraproposta ou o salário exigido.</summary>
    public void AcceptEvaluation(Player p, Team buyer, OfferEvaluation evaluation)
    {
        if (evaluation.Result is not (OfferResult.CounterOffer or OfferResult.PlayerWantsDoubleSalary))
            throw new InvalidOperationException($"Nada a aceitar em {evaluation.Result}.");
        if (evaluation.DemandedSalary is { } salary) p.Salary = salary;
        Transfer(p, buyer, evaluation.RequiredPrice, applyFine: false);
    }

    // ---- Venda ----

    public void ListForSale(Player p, long price)
    {
        p.IsListed = true;
        p.AskingPrice = price;
    }

    public void Unlist(Player p)
    {
        p.IsListed = false;
        p.AskingPrice = p.Value;
    }

    /// <summary>Multa rescisória paga pelo vendedor humano, pelos dias de contrato restantes.</summary>
    public static double RescissionFineRate(int daysLeft) => daysLeft switch
    {
        <= 0 => 0,
        <= 30 => 0.12,
        <= 60 => 0.20,
        <= 90 => 0.22,
        <= 180 => 0.25,
        _ => 0.30,
    };

    /// <summary>
    /// Depois de cada rodada, com 49% de chance, a IA tenta comprar cada jogador à venda dos
    /// clubes humanos (<c>f.java:1592</c>, <c>components.an</c>), se o preço não passar de
    /// valor +10% (+15% em 19% das vezes).
    /// </summary>
    public List<AiPurchase> ProcessListedHumanPlayers()
    {
        var sales = new List<AiPurchase>();
        if (_random.NextInt(100) <= 50) return sales;
        var listed = world.HumanTeams.SelectMany(t => t.Squad).Where(p => p.IsListed).ToList();
        foreach (var p in listed)
        {
            var margin = _random.NextInt(100) > 80 ? 0.15 : 0.10;
            if (p.AskingPrice > p.Value + JMath.Round(p.Value * margin)) continue;
            var buyer = new BuyerSearch(world, ctx, p, p.AskingPrice, largeSquadCap: true, BuyerSearchMode.Normal).Find();
            if (buyer == null) continue;
            var from = p.Club!;
            var fine = Transfer(p, buyer, p.AskingPrice, applyFine: true);
            sales.Add(new AiPurchase(p, from, buyer, p.AskingPrice, fine));
        }
        return sales;
    }

    // ---- Transferência ----

    /// <summary>
    /// Move o jogador (<c>F.a(ah, price, multa, loan, loanReturn)</c>). Só clubes humanos
    /// movimentam dinheiro. Devolve a multa paga pelo vendedor.
    /// </summary>
    public long Transfer(Player p, Team to, long price, bool applyFine, bool loan = false, bool loanReturn = false)
    {
        var from = p.Club!;
        p.PreviousClubId = from.Id;
        p.Club = to;
        if (from == to) return 0;

        p.IsLoanable = false;
        p.IsListed = false;
        if (loan && !loanReturn) p.IsOnLoan = true;
        if (loanReturn) p.IsOnLoan = false;

        long fine = 0;
        if (!loan && !loanReturn)
        {
            if (applyFine) fine = JMath.Round(price * RescissionFineRate(p.ContractDaysLeft(ctx.Today)));
            if (from.IsHuman)
            {
                from.Cash += price;
                from.Cash -= fine;
            }
            if (to.IsHuman) to.Cash -= price;
        }

        p.ContractEnd = ctx.Today.AddDays(loan ? 365 : 180);
        p.AskingPrice = p.Value;
        if (from.FreeKickTaker == p) from.FreeKickTaker = null;
        if (from.CornerTaker == p) from.CornerTaker = null;

        world.TransferHistory.Add(new TransferRecord(ctx.Today, p, from, to, price, loan));
        from.Squad.Remove(p);
        to.Squad.Add(p);
        return fine;
    }

    // ---- Empréstimos ----

    /// <summary>Pedir emprestado (<c>l.a(F, ah)</c>): sem custo, 366 dias, no máximo 4 emprestados no clube.</summary>
    public LoanResult RequestLoan(Player p, Team borrower)
    {
        if (!p.IsLoanable) return LoanResult.NotLoanable;
        if (borrower == p.Club) return LoanResult.OwnPlayer;
        if (borrower.Squad.Count >= BuyerSearch.MaxSquad) return LoanResult.SquadFull;
        if (world.Loans.Count(l => l.Player.Club == borrower) >= MaxLoansIn) return LoanResult.LoanLimit;
        if (!IsWilling(p, borrower)) return LoanResult.PlayerRefuses;
        LoanOut(p, borrower);
        return LoanResult.Success;
    }

    /// <summary><c>F.q(ah)</c>: registra o empréstimo e move o jogador.</summary>
    public void LoanOut(Player p, Team borrower)
    {
        world.Loans.Add(new Loan(p, p.Club!, ctx.Today.AddDays(366)));
        Transfer(p, borrower, 0, applyFine: false, loan: true);
    }

    /// <summary>Encerra empréstimos vencidos (<c>f.au()</c>); dono humano com elenco cheio adia a volta.</summary>
    public void ProcessLoanReturns()
    {
        foreach (var loan in world.Loans.Where(l => l.Ends <= ctx.Today).ToList())
        {
            if (loan.Owner.IsHuman && loan.Owner.Squad.Count >= BuyerSearch.MaxSquad) continue;
            ReturnLoan(loan);
        }
    }

    public void ReturnLoan(Loan loan)
    {
        world.Loans.Remove(loan);
        Transfer(loan.Player, loan.Owner, 0, applyFine: false, loanReturn: true);
    }

    // ---- Contratos ----

    /// <summary>
    /// Renovação (<c>a/fy</c>). <paramref name="lengthIndex"/>: 0 = 6 meses, 1 = 1 ano, 2 = 2 anos,
    /// 3 = 3 anos, somados ao fim do contrato atual. Teto de salário: 25% do valor.
    /// </summary>
    public RenewalEvaluation EvaluateRenewal(Player p, int lengthIndex, long offeredSalary)
    {
        var limit = JMath.Round(p.Value * 0.25);
        if (offeredSalary >= limit) return new RenewalEvaluation(RenewalResult.SalaryAboveLimit, 0, limit);

        var salary = p.Salary;
        long minimum = p.ContractDaysLeft(ctx.Today) < 60
            ? salary - salary * RenewalDiscountPct[lengthIndex] / 100
            : salary + salary * RenewalRaisePct[lengthIndex] / 100;
        if (offeredSalary >= minimum) return new RenewalEvaluation(RenewalResult.Accepted, minimum, limit);
        return new RenewalEvaluation(RenewalResult.CounterProposal, Math.Min(minimum, limit), limit);
    }

    /// <summary>Fecha a renovação com o salário dado.</summary>
    public void Renew(Player p, int lengthIndex, long salary)
    {
        Unlist(p);
        p.ContractEnd = p.ContractEnd.AddDays(RenewalDays[lengthIndex]);
        p.Salary = salary;
    }

    /// <summary>Contratos vencidos de clubes humanos são renovados por 180 dias (opção padrão).</summary>
    public void AutoRenewExpiredContracts(Team team)
    {
        if (!ctx.Options.AutoRenewExpiredContracts) return;
        foreach (var p in team.Squad.Where(p => p.ContractDaysLeft(ctx.Today) <= 0))
            p.ContractEnd = ctx.Today.AddDays(180);
    }

    // ---- IA ----

    /// <summary>
    /// <c>ah.kp()</c>: a IA põe à venda até um reserva por posição com excesso de jogadores
    /// (50% de chance por posição); alguns fracos ficam disponíveis para empréstimo.
    /// </summary>
    public void ListAiSurplus(Team team)
    {
        foreach (var p in team.Squad)
        {
            p.IsListed = false;
            p.IsLoanable = false;
        }
        var squad = team.Squad.ToList();
        _random.Shuffle(squad);
        int[] keep = [2, 3, 3, 5, 4];
        var counts = BuyerSearch.PositionCounts(team, includeLoaned: true);
        for (var pos = 0; pos <= 4; pos++)
        {
            if (counts[pos] <= keep[pos] || _random.NextInt(100) <= 50) continue;
            var candidate = squad.FirstOrDefault(p =>
                (int)p.Position == pos && !p.IsStarter && !p.IsStar && !p.IsWorldClass && !p.IsOnLoan);
            if (candidate == null) continue;
            candidate.AskingPrice = candidate.Value;
            candidate.IsListed = true;
            if (_random.NextInt(100) > 70 && candidate.Strength < 42) candidate.IsLoanable = true;
        }
    }
}
