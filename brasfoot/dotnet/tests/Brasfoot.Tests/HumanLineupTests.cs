using Brasfoot.Core.Domain;
using Brasfoot.Core.Matches;

namespace Brasfoot.Tests;

public class HumanLineupTests
{
    private static readonly Competition Nacional = new(1, "Teste", CompetitionType.Nacional);

    [Fact]
    public void AutoFillEscolheOnzeTitularesComGoleiroEBanco()
    {
        var ctx = TestData.Context();
        var team = TestData.Team("Casa", 60);

        HumanLineup.AutoFill(team, ctx);

        Assert.Equal(HumanLineup.StarterCount, HumanLineup.Starters(team).Count);
        Assert.Contains(HumanLineup.Starters(team), p => p.Slot == Pitch.Goalkeeper);
        Assert.Equal(Pitch.BenchSlots.Length, HumanLineup.Bench(team).Count);
        Assert.Empty(HumanLineup.Problems(team, ctx));
    }

    [Fact]
    public void ApplyUsaAEscalacaoSalvaNaPartida()
    {
        var ctx = TestData.Context();
        var home = TestData.Team("Casa", 60);
        var away = TestData.Team("Fora", 60);
        HumanLineup.AutoFill(home, ctx);
        var starters = HumanLineup.Starters(home).ToList();

        var match = new Match(home, away, Nacional, ctx.Random);
        Assert.True(HumanLineup.Apply(home, match, 0, ctx));

        Assert.Equal(starters, match.Lineup[0]);
        Assert.Equal(starters, match.OnPitch[0]);
    }

    [Fact]
    public void ApplyNaoAlteraAPartidaQuandoHaTitularLesionado()
    {
        var ctx = TestData.Context();
        var home = TestData.Team("Casa", 60);
        var away = TestData.Team("Fora", 60);
        HumanLineup.AutoFill(home, ctx);
        HumanLineup.Starters(home)[0].InjuredUntil = ctx.Today.AddDays(10);

        var match = new Match(home, away, Nacional, ctx.Random);

        Assert.False(HumanLineup.Apply(home, match, 0, ctx));
        Assert.Empty(match.OnPitch[0]);
    }

    [Fact]
    public void TitularNaoVaiParaOBancoSemSairDoCampo()
    {
        var ctx = TestData.Context();
        var team = TestData.Team("Casa", 60);
        HumanLineup.AutoFill(team, ctx);
        foreach (var reserve in HumanLineup.Bench(team).ToList()) HumanLineup.ToggleBench(team, reserve);
        var starter = HumanLineup.Starters(team)[0];

        Assert.False(HumanLineup.ToggleBench(team, starter));
        Assert.True(HumanLineup.ToggleStarter(team, starter, ctx));
        Assert.True(HumanLineup.ToggleBench(team, starter));
        Assert.Equal(0, starter.BenchOrder);
    }

    [Fact]
    public void TrocarFormacaoRefazOsTitulares()
    {
        var ctx = TestData.Context();
        var team = TestData.Team("Casa", 60);
        HumanLineup.AutoFill(team, ctx);

        HumanLineup.SetFormation(team, 7, ctx);

        Assert.Equal(7, team.Tactics.Formation);
        Assert.Equal(HumanLineup.StarterCount, HumanLineup.Starters(team).Count);
        Assert.All(HumanLineup.Starters(team), p => Assert.Contains(p.Slot, Pitch.Formations[7]));
    }

    [Fact]
    public void TrocaTitularComReservaMantemOnzeTitulares()
    {
        var ctx = TestData.Context();
        var team = TestData.Team("Casa", 60);
        HumanLineup.AutoFill(team, ctx);
        var starter = HumanLineup.Starters(team)[3];
        var reserve = HumanLineup.Bench(team)[0];
        var slot = starter.Slot;

        HumanLineup.Swap(team, starter, reserve);

        Assert.Equal(slot, reserve.Slot);
        Assert.Equal(-1, starter.Slot);
        Assert.Equal(0, starter.BenchOrder);
        Assert.Equal(HumanLineup.StarterCount, HumanLineup.Starters(team).Count);
        Assert.Empty(HumanLineup.Problems(team, ctx));
    }

    [Fact]
    public void SimulacaoUsaAEscalacaoDoHumano()
    {
        var ctx = TestData.Context();
        var home = TestData.Team("Casa", 60);
        var away = TestData.Team("Fora", 60);
        home.IsHuman = true;
        HumanLineup.AutoFill(home, ctx);
        var starters = HumanLineup.Starters(home).ToList();

        var match = MatchSimulator.Play(new Match(home, away, Nacional, ctx.Random), ctx);

        Assert.Equal(starters, match.Lineup[0].Take(HumanLineup.StarterCount));
    }
}
