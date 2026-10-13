using Brasfoot.Core.Competitions;
using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Season;

/// <summary>
/// Montagem concreta de uma temporada brasileira para o laço de dias: liga nacional (divisões),
/// estaduais, regionais e a Copa do Brasil criada no gancho <c>cD</c> do meio da temporada
/// (<c>best.a.m()/l()</c>). No fim do ano arquiva os campeões (<see cref="SeasonArchive"/>).
/// </summary>
/// <remarks>
/// <para>
/// Substitui os <see langword="null"/> hooks de <see cref="SeasonHooks"/> por uma composição real de
/// <see cref="SeasonBuilder"/>, servindo de ponte para o front-end (Fase 10) e de alvo de testes de
/// temporada inteira. A Copa do Brasil nasce em <see cref="CreateSerieDAndCopa"/> (no primeiro dia
/// Nacional, antes do primeiro dia de Copa Nacional), em vez de no início do ano.
/// </para>
/// <para>
/// As configurações <c>conf_estadual/*.ces</c> são injetadas no construtor (a sessão não as conhece);
/// sem elas, as federações usam a fórmula padrão. A criação da Série D ainda não é portada — este
/// gancho cria apenas a Copa do Brasil.
/// </para>
/// </remarks>
public sealed class FullSeasonHooks : SeasonHooks
{
    private readonly IReadOnlyDictionary<(int State, int Division), ConfigEstadualType>? _stateConfigs;
    private readonly bool _useStandardGroup;

    public FullSeasonHooks(
        IReadOnlyDictionary<(int State, int Division), ConfigEstadualType>? stateConfigs = null,
        int countryId = Countries.Brasil,
        bool useStandardGroup = true)
    {
        _stateConfigs = stateConfigs;
        CountryId = countryId;
        _useStandardGroup = useStandardGroup;
    }

    /// <summary>País cuja liga nacional é montada (default Brasil).</summary>
    public int CountryId { get; }

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
    }

    /// <summary><c>best.a.m()/l()</c> (<c>cD</c>): cria a Copa do Brasil no meio da temporada.</summary>
    public override void CreateSerieDAndCopa(GameSession session) =>
        SeasonBuilder.CreateSerieDAndCopa(session);

    /// <summary><c>best.f.aa()</c>: arquiva os campeões do ano ao virar a temporada.</summary>
    public override void SeasonRollover(GameSession session) => SeasonArchive.Record(session);
}
