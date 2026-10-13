using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;

namespace Brasfoot.Tests;

/// <summary>
/// Testes de <see cref="SerieDSelection"/> — a seleção da Série D (<c>best.w.Q</c>), os extras da Copa
/// (<c>best.w.eh</c>) e as divisões regionais de <c>best.ah.jW()/jX()</c>.
/// </summary>
public class SerieDTests
{
    private static readonly int Brasil = Countries.Brasil;
    private static int _id = 7000;

    private static Team Team(int state, string name = "T")
    {
        var team = new Team { Id = _id++, Name = $"{name}{_id}", FileRef = name, CountryId = Brasil, State = state };
        return team;
    }

    // ---- Divisões regionais (jW / jX) ----------------------------------------

    [Theory]
    [InlineData(25, 0)] // SP
    [InlineData(18, 0)] // RJ
    [InlineData(1, 2)]  // AL
    [InlineData(24, 3)] // RN
    [InlineData(7, 4)]  // PA
    public void RegionOne_matches_the_ah_jW_table(int state, int region) =>
        Assert.Equal(region, SerieDSelection.RegionOne(state));

    [Theory]
    [InlineData(18, 0)] // RJ
    [InlineData(10, 1)] // MG
    [InlineData(1, 2)]  // AL
    [InlineData(6, 3)]  // AM
    [InlineData(0, 4)]  // AC
    public void RegionTwo_matches_the_ah_jX_table(int state, int region) =>
        Assert.Equal(region, SerieDSelection.RegionTwo(state));

    [Fact]
    public void Region_helpers_return_minus_one_for_unknown_states()
    {
        Assert.Equal(-1, SerieDSelection.RegionOne(-1));
        Assert.Equal(-1, SerieDSelection.RegionTwo(-1));
    }

    // ---- w.a / Pick ----------------------------------------------------------

    [Fact]
    public void Pick_adds_the_best_slot_per_state_and_skips_teams_already_chosen()
    {
        var sp1 = Team(25);
        var sp2 = Team(25);
        var rj1 = Team(18);
        var slots = new List<SerieDSelection.StateSlot>
        {
            new(25, 1, sp1, 1),
            new(25, 1, sp2, 2),
            new(18, 1, rj1, 1),
        };

        var list = new List<Team>();
        SerieDSelection.Pick(SerieDSelection.Sb, list, slots);

        Assert.Equal(new[] { sp1, rj1 }, list);

        // Uma 2ª passagem pega o próximo slot ainda não usado de SP.
        SerieDSelection.Pick(SerieDSelection.Sb, list, slots);
        Assert.Equal(new[] { sp1, rj1, sp2 }, list);
    }

    [Fact]
    public void Pick_ignores_states_without_slots()
    {
        var slots = new List<SerieDSelection.StateSlot> { new(25, 1, Team(25), 1) };
        var list = new List<Team>();
        SerieDSelection.Pick(SerieDSelection.Sc, list, slots);
        Assert.Empty(list);
    }

    // ---- Q ------------------------------------------------------------------

    [Fact]
    public void Select_takes_one_team_per_state_on_the_first_state_pass()
    {
        var slots = new List<SerieDSelection.StateSlot>
        {
            new(25, 1, Team(25), 1),
            new(18, 1, Team(18), 1),
            new(10, 1, Team(10), 1),
            new(22, 1, Team(22), 1),
        };

        var field = SerieDSelection.Select(4, slots, [], []);

        Assert.Equal(4, field.Count);
        Assert.Equal(new[] { 25, 18, 10, 22 }, field.Select(t => t.State));
    }

    [Fact]
    public void Select_fills_the_remainder_from_the_country_teams()
    {
        var slots = new List<SerieDSelection.StateSlot> { new(25, 1, Team(25, "Slot"), 1) };
        var extras = new[] { Team(10, "A"), Team(22, "B"), Team(25, "C") };
        var slotTeam = slots[0].Team;

        var field = SerieDSelection.Select(4, slots, [], extras.ToList());

        Assert.Equal(4, field.Count);
        Assert.Same(slotTeam, field[0]);
        Assert.Contains(field, t => ReferenceEquals(t, extras[0]));
        Assert.Contains(field, t => ReferenceEquals(t, extras[1]));
        Assert.Contains(field, t => ReferenceEquals(t, extras[2]));
    }

    [Fact]
    public void Select_puts_the_free_teams_first_and_sorts_the_rest_by_region_for_68()
    {
        var free = Team(25, "Free");
        // Estados de regiões 1ª tabela diferentes; ordenação esperada por jW asc.
        var c = Team(7);   // região 4
        var a = Team(1);   // região 2
        var b = Team(8);   // região 2
        var slots = new List<SerieDSelection.StateSlot>
        {
            new(c.State, 1, c, 1),
            new(a.State, 1, a, 1),
            new(b.State, 1, b, 1),
        };

        // 68 não preenche até o tamanho (o original devolve o que coletou); validamos a ordenação.
        var field = SerieDSelection.Select(68, slots, [free], [c, a, b]);

        Assert.Same(free, field[0]);
        Assert.Equal(4, field.Count);
        // O restante vem ordenado por jW crescente (as regiões não decrescem).
        var regions = field.Skip(1).Select(t => SerieDSelection.RegionOne(t.State)).ToList();
        Assert.True(regions.Zip(regions.Skip(1)).All(p => p.First <= p.Second));
    }

    [Fact]
    public void Select_sorts_the_whole_field_by_region_for_64()
    {
        var teams = new[] { Team(0), Team(25), Team(6), Team(10), Team(1), Team(18) };
        var slots = teams.Select(t => new SerieDSelection.StateSlot(t.State, 1, t, 1)).ToList();

        var field = SerieDSelection.Select(64, slots, [], teams.ToList());

        Assert.Equal(6, field.Count);
        var regions = field.Select(t => SerieDSelection.RegionTwo(t.State)).ToList();
        Assert.True(regions.Zip(regions.Skip(1)).All(p => p.First <= p.Second));
    }

    [Fact]
    public void Select_does_not_duplicate_a_free_team_that_also_has_a_slot()
    {
        var team = Team(25);
        var slots = new List<SerieDSelection.StateSlot> { new(25, 1, team, 1) };

        var field = SerieDSelection.Select(4, slots, [team], [team]);

        Assert.Single(field, t => ReferenceEquals(t, team));
    }

    // ---- eh -----------------------------------------------------------------

    [Fact]
    public void ExtraTeams_collects_state_teams_up_to_the_first_passes()
    {
        var slots = new List<SerieDSelection.StateSlot>
        {
            new(25, 1, Team(25), 1),
            new(25, 1, Team(25), 2),
            new(18, 1, Team(18), 1),
            new(17, 1, Team(17), 1),
            new(8, 1, Team(8), 1),
        };

        var extras = SerieDSelection.ExtraTeams(slots);

        Assert.Equal(5, extras.Count);
        Assert.Equal(5, extras.Distinct().Count());
    }

    [Fact]
    public void ExtraTeams_is_empty_without_slots() =>
        Assert.Empty(SerieDSelection.ExtraTeams([]));
}
