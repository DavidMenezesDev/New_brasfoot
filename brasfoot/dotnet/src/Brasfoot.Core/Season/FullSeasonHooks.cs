using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Season;

/// <summary>
/// Montagem concreta de uma temporada brasileira para o laço de dias: liga nacional (divisões),
/// estaduais, regionais, a Supercopa do histórico da temporada anterior e a Copa do Brasil criada no
/// gancho <c>cD</c> do meio da temporada (<c>best.a.m()/l()</c>). No fim do ano arquiva os campeões
/// (<see cref="SeasonArchive"/>).
/// </summary>
/// <remarks>
/// <para>
/// Substitui os <see langword="null"/> hooks de <see cref="SeasonHooks"/> por uma composição real de
/// <see cref="SeasonBuilder"/>, servindo de ponte para o front-end (Fase 10) e de alvo de testes de
/// temporada inteira. A Copa do Brasil nasce em <see cref="CreateSerieDAndCopa"/> (no primeiro dia
/// Nacional, antes do primeiro dia de Copa Nacional), em vez de no início do ano; a Supercopa nasce em
/// <see cref="BuildCompetitions"/> a partir de <see cref="SeasonBuilder.CreateSupercupFromHistory"/>.
/// </para>
/// <para>
/// As configurações <c>conf_estadual/*.ces</c> e <c>conf_ligas_nacionais/*.cfg</c> são injetadas no
/// construtor (a sessão não as conhece); sem elas, as federações usam a fórmula padrão e a Série D usa
/// o formato brasileiro padrão (8 grupos × 4 classificados).
/// </para>
/// </remarks>
public sealed class FullSeasonHooks : SeasonHooks
{
    private readonly IReadOnlyDictionary<(int State, int Division), ConfigEstadualType>? _stateConfigs;
    private readonly bool _useStandardGroup;

    public FullSeasonHooks(
        IReadOnlyDictionary<(int State, int Division), ConfigEstadualType>? stateConfigs = null,
        int countryId = Countries.Brasil,
        bool useStandardGroup = true,
        ConfigLigaType? serieDConfig = null)
    {
        _stateConfigs = stateConfigs;
        CountryId = countryId;
        _useStandardGroup = useStandardGroup;
        SerieDConfig = serieDConfig;
    }

    /// <summary>País cuja liga nacional é montada (default Brasil).</summary>
    public int CountryId { get; }

    /// <summary>
    /// Configuração <c>.cfg</c> da 4ª divisão (Série D) usada no gancho <c>cD</c> quando a carreira
    /// brasileira é completa; sem ela, <see cref="SerieDFormat"/> usa o formato brasileiro padrão.
    /// </summary>
    public ConfigLigaType? SerieDConfig { get; }

    /// <summary>
    /// <c>best.f.ah()</c>: cria as divisões da liga nacional de <see cref="CountryId"/> e, no Brasil,
    /// as federações estaduais e os torneios regionais.
    /// </summary>
    public override void BuildCompetitions(GameSession session)
    {
        SeasonBuilder.CreateNationalLeagues(session, CountryId);
        if (CountryId != Countries.Brasil) return;

        if (session.State.Options.JogaEstadual)
            SeasonBuilder.CreateStateChampionships(session, _stateConfigs, _useStandardGroup);
        if (session.State.Options.JogaRegionais)
            SeasonBuilder.CreateRegionalChampionships(session);

        // best.f.Z() passo 9 (f/I): a Supercopa da temporada nasce do histórico da anterior —
        // campeão da 1ª divisão × campeão da Copa do Brasil (vice se coincidirem). Sem histórico
        // (1ª temporada) não é criada.
        var national = session.State.World.LeagueOf(Countries.Brasil);
        if (national is not null)
            SeasonBuilder.CreateSupercupFromHistory(
                session, $"{national.Name} — 1ª divisão", "Copa do Brasil");
    }

    /// <summary><c>best.a.m()/l()</c> (<c>cD</c>): cria a Série D e a Copa do Brasil no meio da temporada.</summary>
    public override void CreateSerieDAndCopa(GameSession session) =>
        SeasonBuilder.CreateSerieDAndCopa(session, SerieDConfig);

    /// <summary><c>best.f.aa()</c>: arquiva os campeões do ano ao virar a temporada.</summary>
    public override void SeasonRollover(GameSession session) => SeasonArchive.Record(session);
}
