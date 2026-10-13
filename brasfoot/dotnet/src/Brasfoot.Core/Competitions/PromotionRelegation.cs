using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Acesso e rebaixamento entre as divisões de uma liga nacional (<c>best.Z.ee()</c>,
/// <c>best/Z.java:453-598</c>) e os dois playoffs de vaga: acesso (código 1099, <c>f/B.BQ()</c>,
/// <c>f/B.java:409-439</c>) e rebaixamento (código 1098, <c>f/B.a(B)</c>, <c>f/B.java:371-407</c>).
/// </summary>
/// <remarks>
/// <para>
/// O original opera sobre <c>f.s</c>/<c>f.B</c>, que também cobrem ligas com grupos e o código 1020.
/// Esta classe porta apenas o caso sem grupos (<c>f.s.Zd == 0</c>) — o único que
/// <c>Core/Competitions/SeasonBuilder</c> produz hoje —, em que os candidatos de acesso/rebaixamento
/// são simplesmente o topo/fundo da tabela (<c>f/s.l</c>/<c>f/s.fG</c>, <c>f/s.java:1189-1196,
/// 1306-1313</c>).
/// </para>
/// <para>
/// As chamadas <c>ah.b(at, flag)</c> do original (<c>best/Z.java:513-514, 575</c>) só marcam o clube
/// para notificação/histórico — a troca de fato é a remoção/inserção nas listas de times
/// (<c>best/Z.java:515-518, 576-580</c>), que é o que os métodos abaixo fazem, devolvendo os pares
/// trocados para quem quiser notificar.
/// </para>
/// </remarks>
public static class PromotionRelegation
{
    /// <summary>
    /// Troca direta entre duas divisões consecutivas (<c>best/Z.java:508-524</c>): os últimos
    /// <paramref name="upperRelegatedCount"/> da tabela de <paramref name="upperDivision"/> trocam de
    /// lugar com os primeiros <paramref name="lowerPromotedCount"/> da tabela de
    /// <paramref name="lowerDivision"/>. Listas mutadas <em>in place</em> (os elencos persistentes de
    /// <c>Domain.League.Divisions</c>). Quirk fiel: se as duas quantidades não baterem, nenhuma troca
    /// ocorre (<c>best/Z.java:508</c>: <c>if (arrayList2.size() == arrayList.size())</c>).
    /// </summary>
    public static IReadOnlyList<(Team Relegated, Team Promoted)> SwapAdjacentDivisions(
        List<Team> upperDivision,
        IReadOnlyList<TeamStanding> upperStanding,
        int upperRelegatedCount,
        List<Team> lowerDivision,
        IReadOnlyList<TeamStanding> lowerStanding,
        int lowerPromotedCount)
    {
        ArgumentNullException.ThrowIfNull(upperDivision);
        ArgumentNullException.ThrowIfNull(upperStanding);
        ArgumentNullException.ThrowIfNull(lowerDivision);
        ArgumentNullException.ThrowIfNull(lowerStanding);

        var relegated = BottomTeams(upperStanding, upperRelegatedCount);
        var promoted = TopTeams(lowerStanding, lowerPromotedCount);
        var swaps = new List<(Team, Team)>();
        if (relegated.Count != promoted.Count || relegated.Count == 0) return swaps;

        for (var i = 0; i < relegated.Count; i++)
        {
            upperDivision.Remove(relegated[i]);
            upperDivision.Add(promoted[i]);
            lowerDivision.Remove(promoted[i]);
            lowerDivision.Add(relegated[i]);
            swaps.Add((relegated[i], promoted[i]));
        }
        return swaps;
    }

    /// <summary>
    /// Troca da última divisão com o grupo de clubes fora da liga simulada (<c>best/Z.java:526-585</c>):
    /// os piores <paramref name="relegatedCount"/> colocados (limitado ao tamanho de
    /// <paramref name="outOfLeaguePool"/>, <c>best/Z.java:539-542</c>) trocam com os primeiros times do
    /// grupo, que entra <em>invertido</em> (<c>Collections.reverse(arrayList)</c>,
    /// <c>best/Z.java:571</c>) antes do pareamento.
    /// </summary>
    public static IReadOnlyList<(Team Relegated, Team Promoted)> SwapLastDivisionWithPool(
        List<Team> lastDivision,
        IReadOnlyList<TeamStanding> lastStanding,
        int relegatedCount,
        List<Team> outOfLeaguePool)
    {
        ArgumentNullException.ThrowIfNull(lastDivision);
        ArgumentNullException.ThrowIfNull(lastStanding);
        ArgumentNullException.ThrowIfNull(outOfLeaguePool);

        var count = Math.Min(relegatedCount, outOfLeaguePool.Count);
        var swaps = new List<(Team, Team)>();
        if (count <= 0) return swaps;

        var relegated = BottomTeams(lastStanding, count);
        var promoted = outOfLeaguePool.Take(count).ToList();
        promoted.Reverse();

        for (var i = 0; i < count; i++)
        {
            lastDivision.Remove(relegated[i]);
            lastDivision.Add(promoted[i]);
            outOfLeaguePool.Remove(promoted[i]);
            outOfLeaguePool.Add(relegated[i]);
            swaps.Add((relegated[i], promoted[i]));
        }
        return swaps;
    }

    /// <summary>
    /// Troca direta entre uma divisão de liga e uma divisão de baixo representada por uma
    /// <see cref="PhasedCompetition"/> (a Série D, <c>best/Z.java:508-524</c>): os últimos
    /// <paramref name="count"/> da tabela de <paramref name="upperDivision"/> trocam com os
    /// <paramref name="count"/> melhores candidatos de <paramref name="lower"/>
    /// (<see cref="PhasedCompetition.PromotionCandidates"/> = <c>f/s.yW()</c>). Devolve as trocas e os
    /// rebaixados (a fonte de <c>bY()</c>). Como no original, só troca quando as contagens batem.
    /// </summary>
    public static (IReadOnlyList<(Team Relegated, Team Promoted)> Swaps, IReadOnlyList<Team> Relegated)
        SwapWithPhasedLower(
            List<Team> upperDivision,
            IReadOnlyList<TeamStanding> upperStanding,
            int count,
            PhasedCompetition lower)
    {
        ArgumentNullException.ThrowIfNull(upperDivision);
        ArgumentNullException.ThrowIfNull(upperStanding);
        ArgumentNullException.ThrowIfNull(lower);

        var relegated = BottomTeams(upperStanding, count);
        var promoted = lower.PromotionCandidates(count);
        var swaps = new List<(Team, Team)>();
        if (relegated.Count != promoted.Count || relegated.Count == 0)
            return (swaps, []);

        for (var i = 0; i < relegated.Count; i++)
        {
            upperDivision.Remove(relegated[i]);
            upperDivision.Add(promoted[i]);
            swaps.Add((relegated[i], promoted[i]));
        }
        return (swaps, relegated);
    }

    /// <summary>
    /// Mesmo que <see cref="SwapLastDivisionWithPool(List{Team},IReadOnlyList{TeamStanding},int,List{Team})"/>,
    /// lendo <c>nRebaixados</c> de <paramref name="lastDivisionConfig"/>.
    /// </summary>
    public static IReadOnlyList<(Team Relegated, Team Promoted)> SwapLastDivisionWithPool(
        List<Team> lastDivision,
        IReadOnlyList<TeamStanding> lastStanding,
        ConfigLigaType lastDivisionConfig,
        List<Team> outOfLeaguePool)
    {
        ArgumentNullException.ThrowIfNull(lastDivisionConfig);
        return SwapLastDivisionWithPool(lastDivision, lastStanding, lastDivisionConfig.Relegated, outOfLeaguePool);
    }

    /// <summary>
    /// Campo do playoff de acesso (código 1099, <c>f/B.BQ()</c>, <c>f/B.java:409-439</c>): a faixa da
    /// própria tabela logo abaixo das vagas de acesso direto — <paramref name="playoffPoolSize"/>
    /// (<c>f/B.BN()</c>, quantas posições da divisão disputam vaga) menos
    /// <paramref name="promotionSlotsFromPlayoff"/> (<c>vagasSobemPeloMataMata</c>), por
    /// <paramref name="fieldSize"/> posições (sempre 4 no original, <c>f/B.java:412</c>). Devolve
    /// <c>null</c> quando a tabela não tem gente suficiente (o original cai de volta para
    /// <c>BO()</c>/<c>BP()</c> sem criar o mata-mata, <c>f/B.java:431-434</c>).
    /// </summary>
    public static IReadOnlyList<Team>? AccessPlayoffField(
        IReadOnlyList<TeamStanding> standing,
        int playoffPoolSize,
        int promotionSlotsFromPlayoff,
        int fieldSize = 4)
    {
        ArgumentNullException.ThrowIfNull(standing);
        var start = playoffPoolSize - promotionSlotsFromPlayoff;
        var end = start + fieldSize;
        if (start < 0 || end > standing.Count) return null;
        return standing.Skip(start).Take(fieldSize).Select(s => s.Team).ToList();
    }

    /// <summary>
    /// Mesmo que <see cref="AccessPlayoffField(IReadOnlyList{TeamStanding},int,int,int)"/>, mas lendo
    /// <paramref name="playoffPoolSize"/>/<paramref name="promotionSlotsFromPlayoff"/> de
    /// <see cref="ConfigLigaType"/> (<c>ConfigLigaType.AccessPlayoffPoolSize</c>,
    /// <c>divisionConfig.PromotionSlotsFromPlayoff</c>) em vez de pedi-los por parâmetro.
    /// </summary>
    public static IReadOnlyList<Team>? AccessPlayoffField(
        IReadOnlyList<TeamStanding> standing,
        ConfigLigaType divisionConfig,
        ConfigLigaType? divisionAboveConfig,
        int fieldSize = 4)
    {
        ArgumentNullException.ThrowIfNull(divisionConfig);
        var poolSize = ConfigLigaType.AccessPlayoffPoolSize(divisionConfig.Division, divisionAboveConfig);
        return AccessPlayoffField(standing, poolSize, divisionConfig.PromotionSlotsFromPlayoff, fieldSize);
    }

    /// <summary>
    /// Campo do playoff de rebaixamento (código 1098, <c>f/B.a(B)</c>, <c>f/B.java:371-407</c>):
    /// intercala quem está na zona de rebaixamento por mata-mata da divisão de cima
    /// (<paramref name="relegatedTotal"/> menos <paramref name="relegatedDirect"/> candidatos, piores
    /// primeiro — <c>f/s.fG</c> + <c>Collections.reverse</c>, <c>f/B.java:377-385</c>) com quem
    /// disputa acesso vindo de baixo (<paramref name="lowerPromotionCandidatesOrPool"/>, também
    /// invertido — <c>f/B.java:388-389</c>): o resultado já é a lista pronta para
    /// <see cref="KnockoutBracket"/> (<c>(cand0Cima, cand0Baixo, cand1Cima, cand1Baixo, …)</c>).
    /// </summary>
    public static IReadOnlyList<Team> RelegationPlayoffField(
        IReadOnlyList<TeamStanding> upperStanding,
        int relegatedTotal,
        int relegatedDirect,
        IReadOnlyList<Team> lowerPromotionCandidatesOrPool)
    {
        ArgumentNullException.ThrowIfNull(upperStanding);
        ArgumentNullException.ThrowIfNull(lowerPromotionCandidatesOrPool);

        var playoffCount = relegatedTotal - relegatedDirect;
        if (playoffCount <= 0) return [];

        var relegationZone = BottomTeams(upperStanding, relegatedTotal).Take(playoffCount).ToList();
        var promotionZone = lowerPromotionCandidatesOrPool.Take(playoffCount).ToList();
        promotionZone.Reverse();

        var count = Math.Min(relegationZone.Count, promotionZone.Count);
        var field = new List<Team>(count * 2);
        for (var i = 0; i < count; i++)
        {
            field.Add(relegationZone[i]);
            field.Add(promotionZone[i]);
        }
        return field;
    }

    /// <summary>
    /// Mesmo que <see cref="RelegationPlayoffField(IReadOnlyList{TeamStanding},int,int,IReadOnlyList{Team})"/>,
    /// mas lendo <c>nRebaixados</c>/<c>rebaixadosDireto</c> de <paramref name="divisionConfig"/>
    /// (<see cref="ConfigLigaType"/>) em vez de pedi-los por parâmetro.
    /// </summary>
    public static IReadOnlyList<Team> RelegationPlayoffField(
        IReadOnlyList<TeamStanding> upperStanding,
        ConfigLigaType divisionConfig,
        IReadOnlyList<Team> lowerPromotionCandidatesOrPool)
    {
        ArgumentNullException.ThrowIfNull(divisionConfig);
        return RelegationPlayoffField(upperStanding, divisionConfig.Relegated, divisionConfig.DirectlyRelegated, lowerPromotionCandidatesOrPool);
    }

    /// <summary>
    /// Troca entre duas divisões (<see cref="SwapAdjacentDivisions(List{Team},IReadOnlyList{TeamStanding},int,List{Team},IReadOnlyList{TeamStanding},int)"/>)
    /// lendo a quantidade de <see cref="ConfigLigaType"/>: tanto quem desce da divisão de cima quanto
    /// quem sobe da de baixo são <c>upperConfig.Relegated</c> times (<c>wantedPromotionCount</c> da
    /// divisão de baixo é o <c>getnRebaixados()</c> da divisão de cima, <c>best/Z.java:457-464</c> — a
    /// divisão de baixo sempre promove exatamente quantos a de cima precisa repor).
    /// </summary>
    public static IReadOnlyList<(Team Relegated, Team Promoted)> SwapAdjacentDivisions(
        List<Team> upperDivision,
        IReadOnlyList<TeamStanding> upperStanding,
        ConfigLigaType upperConfig,
        List<Team> lowerDivision,
        IReadOnlyList<TeamStanding> lowerStanding)
    {
        ArgumentNullException.ThrowIfNull(upperConfig);
        return SwapAdjacentDivisions(
            upperDivision, upperStanding, upperConfig.Relegated,
            lowerDivision, lowerStanding, upperConfig.Relegated);
    }

    /// <summary>Os piores <paramref name="count"/> da tabela, pior primeiro (<c>f/s.fG</c>, ramo <c>Zd == 0</c>, <c>f/s.java:1306-1313</c>).</summary>
    private static List<Team> BottomTeams(IReadOnlyList<TeamStanding> standing, int count) =>
        standing.Skip(Math.Max(0, standing.Count - count))
            .Reverse()
            .Select(s => s.Team)
            .ToList();

    /// <summary>Os melhores <paramref name="count"/> da tabela, melhor primeiro (<c>f/s.l</c>, ramo <c>Zd == 0</c>, <c>f/s.java:1189-1196</c>).</summary>
    private static List<Team> TopTeams(IReadOnlyList<TeamStanding> standing, int count) =>
        standing.Take(count).Select(s => s.Team).ToList();
}
