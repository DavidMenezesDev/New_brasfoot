using Brasfoot.Core.Calendar;

namespace Brasfoot.Core.Season;

/// <summary>Tipo de convocação das seleções (<c>best.a.b(boolean)</c> e <c>k()</c>, <c>best/a.java:614-647</c>).</summary>
public enum NationalCallUpKind
{
    /// <summary>"cS" — convoca as seleções ainda sem técnico (bl2 = false).</summary>
    Normal,

    /// <summary>"cO" — convoca todas as seleções ativas (k()).</summary>
    All,

    /// <summary>"cSempregado" — convocação forçada de todas as seleções ativas (bl2 = true).</summary>
    Forced,
}

/// <summary>
/// Pontos de extensão do laço de dias para os subsistemas ainda não portados (competições —
/// Fase 3, evolução — Fase 4, finanças — Fase 4/5, carreira — Fase 6). A <see cref="GameSession"/>
/// implementa diretamente o que já depende do domínio pronto (calendário, salários, navegação).
/// </summary>
public class SeasonHooks
{
    /// <summary>
    /// <c>best.f.ah()</c> (fim da montagem do calendário): cria as competições do ano e agenda os
    /// jogos. Implementações concretas usam <c>SeasonBuilder</c> (Fase 3).
    /// </summary>
    public virtual void BuildCompetitions(GameSession session) { }

    /// <summary><c>best.f.aC()/aB()</c>: avança fases das competições cujo dia é hoje (Fase 3).</summary>
    public virtual void AdvanceCompetitions(GameSession session, CalendarDay day) { }

    /// <summary><c>best.f.aT()</c>: evolução semanal dos jogadores (Fase 4).</summary>
    public virtual void WeeklyEvolution(GameSession session) { }

    /// <summary><c>best.a.p()</c>: cria o Mundial de Clubes (<c>cw</c>, Fase 3).</summary>
    public virtual void CreateClubWorldCup(GameSession session) { }

    /// <summary><c>best.a.m()/l()</c>: cria a Série D e a Copa do Brasil (<c>cD</c>, Fase 3).</summary>
    public virtual void CreateSerieDAndCopa(GameSession session) { }

    /// <summary><c>best.a.b(boolean)/k()</c>: convoca seleções (<c>cS</c>/<c>cO</c>/<c>cSempregado</c>, Fase 3).</summary>
    public virtual void NationalTeamCallUps(GameSession session, NationalCallUpKind kind) { }

    /// <summary><c>afQ.zw()</c>: liquida acessos/rebaixamentos e ofertas de promoção (<c>cPromocao</c>, Fase 3/6).</summary>
    public virtual void PromotionSettlement(GameSession session) { }

    /// <summary><c>best.a.o()</c>: cobra juros do empréstimo bancário (<c>dJ</c>, Fase 4).</summary>
    public virtual void LoanInterest(GameSession session) { }

    /// <summary><c>best.f.n(int)</c>: mercado de técnicos no fim do dia (<c>best/f.java:1752</c>, Fase 6).</summary>
    public virtual void ManagerMarket(GameSession session, DayType dayType) { }

    /// <summary><c>best.f.au()/av()/aw()</c>: empréstimos, contratos e demissões no fim do dia (Fase 5/6).</summary>
    public virtual void EndOfDay(GameSession session) { }

    /// <summary><c>best.f.aa()/al()</c>: virada de temporada quando o calendário acaba (Fase 6/7).</summary>
    public virtual void SeasonRollover(GameSession session) { }
}
