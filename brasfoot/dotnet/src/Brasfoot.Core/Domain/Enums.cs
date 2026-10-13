namespace Brasfoot.Core.Domain;

public enum Position { Goleiro = 0, Lateral = 1, Zagueiro = 2, Meia = 3, Atacante = 4 }

public enum Side { Direito = 0, Esquerdo = 1 }

public enum Continent { Europa = 0, AmericaDoSul = 1, Africa = 2, Asia = 3, Concacaf = 4, Oceania = 5 }

public enum Characteristic
{
    Colocacao = 0, DefesaPenalty = 1, Reflexo = 2, SaidaGol = 3, Armacao = 4, Cabeceio = 5, Cruzamento = 6,
    Desarme = 7, Drible = 8, Finalizacao = 9, Marcacao = 10, Passe = 11, Resistencia = 12, Velocidade = 13,
}

/// <summary>Papel tático derivado das características (<c>F.fG()</c>).</summary>
public enum PlayerRole { Defensivo = 0, Ofensivo = 1, Ponta = 2 }

public enum CompetitionType
{
    Amistoso = 0, Nacional = 1, CopaNacional = 2, Estadual = 3, Internacional1 = 4, Mundial = 5,
    Internacional2 = 6, Selecoes = 7, Recopa = 8, Eliminatorias = 9, Regionais = 10, Supercopa = 11,
    ConferenceLeague = 12, Finalissima = 13, LigaNacoes = 14, TorneioAmistoso = 15,
}

public enum Style { Equilibrado = 0, AtaqueTotal = 1, ContraAtaque = 2 }

public enum Marking { Leve = 0, Pesada = 1, MuitoPesada = 2 }

public enum Play { PeloMeio = 0, PelasLaterais = 1 }
