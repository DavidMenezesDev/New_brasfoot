using Brasfoot.Core.Domain;
using Brasfoot.Data.Saves;

namespace Brasfoot.Tests;

public class GameStateTests
{
    [Fact]
    public void GameOptions_defaults_match_original()
    {
        var o = new GameOptions();
        Assert.True(o.JogaEstadual);
        Assert.True(o.JogaRegionais);
        Assert.True(o.UsaGrupoPadraoEstadual);
        Assert.True(o.JogaIntClubes);
        Assert.True(o.JogaSelecoesAll);
        Assert.All(o.JogaSelecoes, Assert.True);
        Assert.True(o.SalarioMensal);
        Assert.True(o.HabilidadeIndividual);
        Assert.True(o.JogaIntAno1);
        Assert.False(o.GruposIntPadrao);
        Assert.Equal(0, o.AutoSalvar);
        Assert.Equal(4, o.Velocidade);
        Assert.Equal(4, o.VelocidadeNH);
        Assert.Equal(0, o.VerDecisaoPenNaoHumano);
        Assert.Equal(1, o.VerMudancaTecnicos);
        Assert.Equal(1, o.VerJanelaSubs);
        Assert.True(o.AutoRenovaContrato);
        Assert.True(o.UsaCorPlacar);
        Assert.True(o.UsaSons);
        Assert.True(o.NegritoCasa);
        Assert.False(o.UsaCoresLista);
        Assert.Null(o.CoresLista);
        Assert.True(o.IgnoraLigas);
        Assert.True(o.IgnoraEstadual);
        Assert.False(o.UsarGruposReaisCopa);
        Assert.All(o.JogaRegionaisTodos, Assert.True);
        Assert.False(o.ConviteRegionais);
        Assert.False(o.VerMundiais);
        Assert.False(o.VerSuperCopas);
        Assert.True(o.NovoFormatoCopa);
        Assert.False(o.VerLeiloes);
    }

    [Fact]
    public void GameOptions_verJint_defaults_match_original()
    {
        var v = new GameOptions().VerJint;
        Assert.Equal(21, v.Length);
        // índices ligados por padrão: 0,1,6..14,16..20
        bool[] expected =
        [
            true, true, false, false, false, false, true, true,
            true, true, true, true, true, true, true, false,
            true, true, true, true, true,
        ];
        Assert.Equal(expected, v);
    }

    [Fact]
    public void Manager_starts_at_defaults_and_clamps()
    {
        var m = new Manager { Name = "Zé" };
        Assert.Equal(95, m.Confidence);
        Assert.Equal(85, m.FanSupport);
        Assert.True(m.IsUnemployed);

        m.AdjustConfidence(-200);
        Assert.Equal(0, m.Confidence);
        m.AdjustConfidence(500);
        Assert.Equal(100, m.Confidence);

        m.AdjustFans(-1000);
        Assert.Equal(0, m.FanSupport);
    }

    [Fact]
    public void Manager_take_club_resets_confidence_and_fans()
    {
        var club = TestData.Team("Clube", 50);
        var m = new Manager { Name = "Zé", Confidence = 10, FanSupport = 5, SeasonsAtClub = 7 };
        m.TakeClub(club);
        Assert.Same(club, m.Club);
        Assert.Equal(95, m.Confidence);
        Assert.Equal(85, m.FanSupport);
        Assert.Equal(0, m.SeasonsAtClub);
        Assert.False(m.IsUnemployed);
    }

    [Fact]
    public void GameState_from_world_assigns_stable_player_ids()
    {
        var world = new World();
        var clubA = TestData.Team("A", 50);
        var clubB = TestData.Team("B", 50);
        world.Teams.Add(clubA);
        world.Teams.Add(clubB);

        var state = GameState.FromWorld(world);

        var players = world.Teams.SelectMany(t => t.Squad.Concat(t.Juniors)).ToList();
        Assert.All(players, p => Assert.True(p.Id > 0));
        Assert.Equal(players.Count, players.Select(p => p.Id).Distinct().Count());
        Assert.Equal(players.Max(p => p.Id) + 1, state.NextPlayerId);
    }

    [Fact]
    public void AddManager_assigns_sequential_ids()
    {
        var state = new GameState();
        var a = state.AddManager("A");
        var b = state.AddManager("B", human: true);
        Assert.Equal(1, a.Id);
        Assert.Equal(2, b.Id);
        Assert.Same(b, state.HumanManager);
    }

    [Fact]
    public void GameState_survives_json_gzip_roundtrip_with_references()
    {
        var world = new World();
        var club = TestData.Team("Clube", 60);
        world.Teams.Add(club);

        var state = GameState.FromWorld(world);
        state.Season = 3;
        state.Today = new DateOnly(2024, 7, 15);
        var manager = state.AddManager("Treinador", club, human: true);
        manager.AdjustConfidence(-13);
        manager.SeasonRecords.Add(new SeasonRecord(club.Id, club.Name, 2, 20, 5, 3, 1));
        state.Inbox.Add(new ManagerMessage { Type = 24, Tone = 77, Text = "Campeão!", Date = state.Today });

        var bytes = SaveGame.Serialize(state);
        var loaded = SaveGame.Deserialize(bytes);

        Assert.Equal(3, loaded.Season);
        Assert.Equal(new DateOnly(2024, 7, 15), loaded.Today);
        Assert.Single(loaded.Managers);
        Assert.Equal("Treinador", loaded.Managers[0].Name);
        Assert.Equal(82, loaded.Managers[0].Confidence);
        Assert.Equal(71, loaded.Managers[0].WinRateFor(2)); // 20/28 → 71%
        Assert.Single(loaded.Inbox);
        Assert.Equal("Campeão!", loaded.Inbox[0].Text);
        Assert.Equal(state.NextPlayerId, loaded.NextPlayerId);

        // referência técnico ↔ clube preservada (mesma instância após o roundtrip)
        var loadedClub = Assert.Single(loaded.World.Teams);
        Assert.Same(loadedClub, loaded.Managers[0].Club);
        Assert.All(loadedClub.Squad, p => Assert.Same(loadedClub, p.Club));
    }

    [Fact]
    public void GameOptions_roundtrip_via_user_json()
    {
        var path = Path.Combine(Path.GetTempPath(), $"brasfoot-options-{Guid.NewGuid():N}.json");
        try
        {
            var options = new GameOptions { SalarioMensal = false, UsaSons = false, AutoSalvar = 2, Velocidade = 7 };
            options.VerJint[15] = true;

            SaveGame.SaveOptions(path, options);
            var loaded = SaveGame.LoadOptions(path);

            Assert.False(loaded.SalarioMensal);
            Assert.False(loaded.UsaSons);
            Assert.Equal(2, loaded.AutoSalvar);
            Assert.Equal(7, loaded.Velocidade);
            Assert.True(loaded.VerJint[15]);
            Assert.True(loaded.JogaEstadual); // default preservado
        }
        finally
        {
            File.Delete(path);
        }
    }
}
