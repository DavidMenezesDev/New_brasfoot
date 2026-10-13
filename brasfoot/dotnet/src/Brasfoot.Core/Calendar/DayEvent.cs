namespace Brasfoot.Core.Calendar;

/// <summary>
/// Evento agendado num dia (<c>best.a.b(idx, code, queue)</c>; spec-calendario §2.4/§2.6).
/// Os códigos coincidem com o argumento <c>code</c> do original.
/// </summary>
public enum DayEvent
{
    CriaMundial = 1,             // "cw"
    Salarios = 2,                // "ds"
    EvolucaoSemanal = 3,         // "aj"
    CriaSerieDCopa = 4,          // "cD"
    JurosEmprestimo = 5,         // "dJ"
    ConvocacaoSelecao = 6,       // "cS"
    ConvocacaoTodasSelecoes = 7, // "cO"
    ConvocacaoForcada = 8,       // "cSempregado"
    Promocao = 9,                // "cPromocao"
    CriaMataMataAscenso = 10,    // "criaMataMataAscenso" (no-op no original)
    CriaPlayoffRebaixamento = 11,// "criaplayOffRebaixamento" (no-op no original)
}

public static class DayEvents
{
    /// <summary>Fila em que o evento é agendado (<c>queue</c>): 0 = pós-jogo, 1 = fim do dia.</summary>
    public static int QueueOf(DayEvent e) => e switch
    {
        DayEvent.ConvocacaoSelecao or DayEvent.ConvocacaoTodasSelecoes or
            DayEvent.ConvocacaoForcada or DayEvent.Promocao => 1,
        _ => 0,
    };

    /// <summary>Nome em string do original (<c>best/a.java:534-557</c>).</summary>
    public static string OriginalName(DayEvent e) => e switch
    {
        DayEvent.CriaMundial => "cw",
        DayEvent.Salarios => "ds",
        DayEvent.EvolucaoSemanal => "aj",
        DayEvent.CriaSerieDCopa => "cD",
        DayEvent.JurosEmprestimo => "dJ",
        DayEvent.ConvocacaoSelecao => "cS",
        DayEvent.ConvocacaoTodasSelecoes => "cO",
        DayEvent.ConvocacaoForcada => "cSempregado",
        DayEvent.Promocao => "cPromocao",
        DayEvent.CriaMataMataAscenso => "criaMataMataAscenso",
        DayEvent.CriaPlayoffRebaixamento => "criaplayOffRebaixamento",
        _ => "",
    };
}
