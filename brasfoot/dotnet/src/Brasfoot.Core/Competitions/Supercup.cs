using Brasfoot.Core.Domain;

namespace Brasfoot.Core.Competitions;

/// <summary>
/// Supercopa de um país (<c>f.I</c>, <c>f/I.java:25-45</c>): jogo único entre o campeão da liga
/// nacional (1ª divisão) e o campeão da copa nacional, ambos da <b>temporada anterior</b> — ou o
/// vice-campeão da copa, quando liga e copa tiveram o mesmo campeão.
/// </summary>
/// <remarks>
/// Verificado em <c>f/I.b(ah,ah)</c>/<c>Ab()</c> (<c>f/I.java:37-50</c>) chamado por
/// <c>best.f.Z()</c> (<c>best/f.java:492-514</c>, passo 9 da virada de temporada, §2.7):
/// <c>ah2 = ((B)Z.eb().get(0)).cv(SR.H()-1)</c> é o campeão da 1ª divisão na temporada anterior;
/// <c>ahArray = Z.bk(SR.H()-1)</c> é <c>{campeão, vice}</c> da copa nacional do país na mesma
/// temporada (<c>best.Z.bk</c>, <c>best/Z.java:355-365</c>, lido do registro <c>best.i</c> da copa);
/// <c>ah3 = ah2 != ahArray[0] ? ahArray[0] : ahArray[1]</c> escolhe o vice quando o mesmo clube venceu
/// os dois. O par vira um <c>f.z</c> de 2 times, jogo único, código 11 (<c>f/I.java:49-50</c>): o
/// campeão da liga manda o jogo (<c>cE.add(ah2)</c> antes de <c>ah3</c>).
/// </remarks>
public static class Supercup
{
    /// <summary>
    /// O adversário do campeão da liga (<c>f/I.Ab()</c>): o campeão da copa, ou o vice se coincidir
    /// com o campeão da liga. <c>null</c> quando falta algum dado da temporada anterior — a Supercopa
    /// simplesmente não é criada nesse caso (<c>f/I.b</c> só monta a chave quando os dois clubes são
    /// não nulos).
    /// </summary>
    public static Team? SelectOpponent(Team leagueChampion, Team? cupChampion, Team? cupRunnerUp)
    {
        ArgumentNullException.ThrowIfNull(leagueChampion);
        if (cupChampion is null) return null;
        return ReferenceEquals(leagueChampion, cupChampion) ? cupRunnerUp : cupChampion;
    }

    /// <summary>
    /// Monta a chave de jogo único da Supercopa (<c>f/I.b</c>): campeão da liga manda, código 11,
    /// sem gol fora nem ida e volta. Devolve <c>null</c> quando não há adversário válido
    /// (ver <see cref="SelectOpponent"/>).
    /// </summary>
    public static KnockoutBracket? Create(
        Competition competition, Team leagueChampion, Team? cupChampion, Team? cupRunnerUp)
    {
        ArgumentNullException.ThrowIfNull(competition);
        var opponent = SelectOpponent(leagueChampion, cupChampion, cupRunnerUp);
        if (opponent is null) return null;

        return new KnockoutBracket(
            competition,
            [leagueChampion, opponent],
            twoLegged: false,
            awayGoalsRule: false,
            shootoutAllowed: true,
            code: 11,
            bracketType: (int)CompetitionType.Supercopa);
    }
}
