namespace Brasfoot.Core.Domain;

/// <summary>
/// Opções do usuário (<c>est.Options</c>); os defaults replicam o construtor original
/// (<c>est/Options.java:51-96</c>). Spec: <c>re/spec-financas-carreira.md</c> §18.
/// Nomes entre parênteses são os campos ofuscados/originais.
/// </summary>
public sealed class GameOptions
{
    // --- Competições ligadas/desligadas ---
    public bool JogaEstadual { get; set; } = true;                 // jogaEstadual
    public bool JogaRegionais { get; set; } = true;                // jogaRegionais
    public bool UsaGrupoPadraoEstadual { get; set; } = true;       // usaGrupoPadraoEstadual
    public bool JogaIntClubes { get; set; } = true;                // jogaIntClubes
    public bool JogaSelecoesAll { get; set; } = true;              // jogaSelecoesAll

    /// <summary>Sete seleções habilitadas (índice = continente/slot); default todas ligadas.</summary>
    public bool[] JogaSelecoes { get; set; } = [true, true, true, true, true, true, true];

    /// <summary>Salário pago mensalmente (dia 2) em vez de semanalmente (domingo).</summary>
    public bool SalarioMensal { get; set; } = true;                // salarioMensal

    public bool HabilidadeIndividual { get; set; } = true;         // habilidadeIndividual
    public bool JogaIntAno1 { get; set; } = true;                  // jogaIntano1
    public bool GruposIntPadrao { get; set; } = false;             // gruposIntPadrao

    /// <summary>
    /// 21 flags de visibilidade de tipos de dia (<c>verJint</c>). Defaults:
    /// índices 0,1,6..14,16..20 ligados; 2,3,4,5,15 desligados (<c>est/Options.java:52-68</c>).
    /// </summary>
    public bool[] VerJint { get; set; } =
    [
        true, true, false, false, false, false, true, true,
        true, true, true, true, true, true, true, false,
        true, true, true, true, true,
    ];

    // --- Save / velocidade ---
    /// <summary>0 = desligado, 1 = só em partida, 2 = a cada avanço, 3 = conforme flag extra (<c>best/f.ap()</c>).</summary>
    public int AutoSalvar { get; set; } = 0;
    public int Velocidade { get; set; } = 4;                       // velocidade
    public int VelocidadeNH { get; set; } = 4;                     // velocidadeNH

    // --- Exibição ---
    public int VerDecisaoPenNaoHumano { get; set; } = 0;           // verDecisaoPenNaoHumano
    public int VerMudancaTecnicos { get; set; } = 1;              // verMudancaTecnicos
    public int VerJanelaSubs { get; set; } = 1;                   // verJanelaSubs
    public int AvisoTerminoContrato { get; set; } = 0;            // avisoTerminoContrato
    public bool AutoRenovaContrato { get; set; } = true;          // autoRenovaContrato
    public bool UsaCorPlacar { get; set; } = true;                // usaCorPlacar
    public int CorPlacar { get; set; } = 0;                       // corPlacar
    public bool UsaSons { get; set; } = true;                     // usaSons
    public bool NegritoCasa { get; set; } = true;                 // negritoCasa
    public bool UsaCoresLista { get; set; } = false;              // usaCoresLista

    /// <summary>Pares de cores personalizados da lista; <see langword="null"/> = padrão (<c>coresLista</c>).</summary>
    public int[]? CoresLista { get; set; }

    public bool VerEstaduaisAgrupados { get; set; } = false;      // verEstaduaisAgrupados
    public bool IgnoraLigas { get; set; } = true;                 // ignoraLigas
    public bool IgnoraEstadual { get; set; } = true;              // ignoraEstadual
    public bool UsarGruposReaisCopa { get; set; } = false;        // UsarGruposReaisCopa

    /// <summary>Quatro flags de região dos regionais; default todas ligadas.</summary>
    public bool[] JogaRegionaisTodos { get; set; } = [true, true, true, true];

    public bool ConviteRegionais { get; set; } = false;           // conviteRegionais
    public int RegionaisSemHumanos { get; set; } = 0;             // regionaisSemHumanos
    public bool VerMundiais { get; set; } = false;                // verMundias
    public bool VerSuperCopas { get; set; } = false;              // verSuperCopas
    public bool NovoFormatoCopa { get; set; } = true;             // novoFormatoCopa
    public int CorTema { get; set; } = 0;                         // corTema
    public bool VerLeiloes { get; set; } = false;                 // verLeiloes
}
