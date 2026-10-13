namespace Brasfoot.Core.Competitions;

/// <summary>
/// Configuração de formato de uma divisão de liga nacional, lida do <c>.cfg</c> do país
/// (<c>est.ConfigLigaType</c>, campos em <c>est/ConfigLigaType.java:11-33</c>, carregada por
/// <c>Brasfoot.Data.WorldLoader.LoadLeagueConfigs</c>). Os nomes dos campos seguem os getters
/// originais (<c>getnTimes</c>, <c>isDoisTurnos</c>, …) para facilitar a conferência cruzada.
/// </summary>
/// <remarks>
/// Campos de ida-e-volta (<c>duasVoltasMataMata[7]</c>, <c>duasVoltasMataMataSobe</c>,
/// <c>duasVoltasplayoffReb</c>) e <c>formula</c>/<c>desempate</c>/<c>classificaPeloGeral</c> não são
/// portados ainda — não são necessários para o acesso/rebaixamento sem grupos
/// (<see cref="PromotionRelegation"/>) nem para o agendamento de <see cref="LeagueCompetition"/>, que
/// são os dois consumidores atuais. Ver <c>re/spec-calendario-competicoes.md</c> §3.6.1/§5.1.
/// </remarks>
public sealed record ConfigLigaType
{
    /// <summary>País (<c>pais</c>).</summary>
    public int Country { get; init; } = -1;

    /// <summary>Divisão, 1-based (<c>divisao</c>).</summary>
    public int Division { get; init; } = -1;

    /// <summary>Nome da liga (<c>nome</c>).</summary>
    public string Name { get; init; } = "";

    /// <summary>Número de times da divisão (<c>nTimes</c>).</summary>
    public int Teams { get; init; }

    /// <summary>Turno e returno (<c>doisTurnos</c>).</summary>
    public bool DoubleRound { get; init; } = true;

    /// <summary>Número de grupos, 0 = pontos corridos sem grupos (<c>nGrupos</c>).</summary>
    public int Groups { get; init; }

    /// <summary>Se os confrontos de grupo são só dentro do próprio grupo (<c>jogosDentroGrupo</c>).</summary>
    public bool MatchesWithinGroup { get; init; } = true;

    /// <summary>Quantos times de cada grupo avançam ao mata-mata (<c>numeroTimesMataMata</c> = <c>f.s.Zd</c>).</summary>
    public int KnockoutQualifiersPerGroup { get; init; }

    /// <summary>Melhores terceiros entram no mata-mata (<c>melhoresTerceiros</c>).</summary>
    public bool BestThirdPlaced { get; init; }

    /// <summary>Rebaixamento decidido pela posição no grupo, não na tabela geral (<c>rebaixadoPeloGrupo</c>).</summary>
    public bool RelegationByGroup { get; init; }

    /// <summary>Total de rebaixados da divisão por temporada (<c>nRebaixados</c>, <c>f/B.getnRebaixados</c>).</summary>
    public int Relegated { get; init; } = 2;

    /// <summary>Quantos dos rebaixados caem direto, sem disputar o playoff de permanência (<c>rebaixadosDireto</c>).</summary>
    public int DirectlyRelegated { get; init; } = 2;

    /// <summary>Quantas vagas de acesso o playoff de promoção (código 1099) vale (<c>vagasSobemPeloMataMata</c>).</summary>
    public int PromotionSlotsFromPlayoff { get; init; }

    /// <summary>Formato do playoff de rebaixamento, 0 = nenhum (<c>playoffRebaixamento</c>).</summary>
    public int RelegationPlayoffFormat { get; init; }

    /// <summary>Versão do arquivo de configuração (<c>versaoArquivo</c>) — ver o quirk do Brasil em §3.6.1.</summary>
    public int FileVersion { get; init; }

    /// <summary>
    /// Quantas posições da própria tabela disputam o playoff de acesso (<c>f/B.BN()</c> =
    /// <c>Z.K(divisao)</c>, <c>best/Z.java:1278-1283</c>): o <c>nRebaixados</c> da divisão
    /// imediatamente <em>acima</em> — é quantas vagas ela precisa repor. Divisão 1 não tem playoff de
    /// acesso (retorna 0); sem a configuração da divisão de cima também retorna 0 (<c>f/B.java:412-417</c>
    /// cai de volta ao acesso direto quando a tabela não tem gente suficiente).
    /// </summary>
    public static int AccessPlayoffPoolSize(int division, ConfigLigaType? divisionAbove) =>
        division > 1 ? divisionAbove?.Relegated ?? 0 : 0;

    /// <summary>
    /// Há playoff de acesso (<c>f/B.BK()</c>, <c>f/B.java:291-294</c>): a divisão de cima oferece vagas
    /// de reposição (<see cref="AccessPlayoffPoolSize"/> &gt; 0) e esta divisão tem
    /// <see cref="PromotionSlotsFromPlayoff"/> &gt; 0.
    /// </summary>
    public bool HasAccessPlayoff(ConfigLigaType? divisionAbove) =>
        AccessPlayoffPoolSize(Division, divisionAbove) > 0 && PromotionSlotsFromPlayoff > 0;

    /// <summary>
    /// Há playoff de rebaixamento (<c>f/B.BM()</c>, <c>f/B.java:302-312</c>): existem vagas de
    /// rebaixamento (<see cref="Relegated"/> &gt; 0) e nem todas caem direto
    /// (<see cref="Relegated"/> != <see cref="DirectlyRelegated"/>). O carve-out do Brasil
    /// (divisão 4, torneio de acesso via estaduais, <c>SR.bk()</c>) não é modelado aqui — é estado de
    /// sessão, não da configuração.
    /// </summary>
    public bool HasRelegationPlayoff => Relegated > 0 && Relegated != DirectlyRelegated;

    /// <summary>Quantas vagas o playoff de rebaixamento disputa (<c>f/B.BL()</c>).</summary>
    public int RelegationPlayoffSlots => Relegated > 0 ? Relegated - DirectlyRelegated : 0;
}
