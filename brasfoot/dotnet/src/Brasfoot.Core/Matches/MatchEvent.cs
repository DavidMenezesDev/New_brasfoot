using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Matches;

public enum MatchEventType
{
    Gol = 1, Amarelo = 2, AmareloVermelho = 3, Vermelho = 4, Contusao = 5, Substituicao = 6,
    PenaltyPerdido = 7, Assistencia = 8,
}

public enum GoalType { Normal = 1, Contra = 2, Penalty = 3, Falta = 4, Olimpico = 5 }

/// <summary>Evento da partida (<c>best.A</c>).</summary>
public sealed class MatchEvent(int side)
{
    public int Side { get; } = side;
    public MatchEventType Type { get; set; }
    public GoalType? GoalType { get; set; }
    public int Minute { get; set; }
    public int Half { get; set; }

    /// <summary>Jogador principal (autor do gol, punido, lesionado, quem sai).</summary>
    public Player? Player { get; set; }

    /// <summary>Segundo jogador (assistência, quem entra, goleiro que defendeu o pênalti).</summary>
    public Player? Player2 { get; set; }

    public Team? Team { get; set; }

    /// <summary>Gol de pênalti já contabilizado (<c>A.eu()</c>).</summary>
    public bool PenaltyCounted { get; set; }

    /// <summary>Pênalti em partida com humano: o placar só muda quando a cobrança é resolvida.</summary>
    internal bool PenaltyPending { get; set; }

    public override string ToString()
    {
        var minute = Half == 1 ? Minute : 45 + Minute;
        var who = Player?.Name ?? "?";
        return Type switch
        {
            MatchEventType.Gol => $"{minute}' GOL {Team}: {who}" + (GoalType is { } g and not Matches.GoalType.Normal ? $" ({g})" : "")
                + (Player2 != null ? $" (assist. {Player2.Name})" : ""),
            MatchEventType.Substituicao => $"{minute}' Substituição {Team}: sai {who}, entra {Player2?.Name}",
            MatchEventType.PenaltyPerdido => $"{minute}' Pênalti perdido {Team}: {who}",
            _ => $"{minute}' {Type} {Team}: {who}",
        };
    }
}
