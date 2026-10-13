# Brasfoot em C#

Reimplementação da lógica do Brasfoot 22-23 em .NET 10, a partir da engenharia reversa do jogo
original (Java). As especificações de comportamento estão em `../re/spec-partidas.md`,
`../re/spec-transferencias.md`, `../re/spec-financas-carreira.md`,
`../re/spec-calendario-competicoes.md` e `../re/spec-telas.md`, com referências
`arquivo:linha` ao código decompilado em `../re/decompiled/`.

## Projetos

| Projeto | Conteúdo |
|---|---|
| `Brasfoot.Core` | Domínio, motor de partidas (`Matches/`), mercado e contratos (`Transfers/`) |
| `Brasfoot.Data` | Leitor da serialização Java e carga dos `.ban`/`.cfg` originais (`WorldLoader`) |
| `Brasfoot.Cli` | Linha de comando para simular partidas e testar o mercado |
| `Brasfoot.Tests` | Testes (xUnit); os de dados usam `../brasfoot-linux/` se existir |

```
dotnet test
dotnet run --project src/Brasfoot.Cli -- simular palmeiras flarj --seed 7
dotnet run --project src/Brasfoot.Cli -- lote corinthians santos --n 2000
dotnet run --project src/Brasfoot.Cli -- proposta corinthians "Marcos Leonardo" 13000000
```

## Fidelidade

- Fórmulas, constantes e sorteios seguem o original. Uma única fonte de aleatoriedade com semente
  (`GameRandom`) substitui os `new Random()` do Java: mesmas distribuições, partidas reproduzíveis.
- `RulesOptions.FixOriginalBugs` (CLI: `--corrigir`) corrige bugs evidentes do original (gols em dobro
  na súmula, minutos da nota, pesos de assistência, lista errada na troca aleatória, pênalti perdido
  na nota, overflow de int). Desligado = paridade. O ajuste de finalização com mando (quirk Q1) é
  mantido sempre, pois a intenção original não é clara.
- Partidas com time humano usam o ritmo da tela ao vivo (48 + 51 ticks, pênaltis cobrados) e o
  pênalti é resolvido automaticamente; o original abre um diálogo.

## Estado de jogo (Fase 1)

- `GameState` é o agregado raiz (mundo, temporada/data, opções, técnicos, mensagens e históricos);
  `Manager` (`best.al`) reproduz confiança (95), torcida (85), reputação, prestígio e registros por
  temporada; `GameOptions` espelha todos os campos e defaults de `est.Options` (spec-financas §18).
- Persistência em JSON comprimido (gzip) com `ReferenceHandler.Preserve`, preservando as referências
  cruzadas clube ↔ jogador ↔ técnico (`SaveGame`, em `Brasfoot.Data/Saves`); opções do usuário em
  JSON legível. `Player` e `Team` têm `Id` estável para o save.

## Calendário e laço de dias (Fase 2)

- `Core/Calendar`: `DayType` (tipos 1..15/100/200), `DayEvent` (as strings `ds`/`dJ`/`aj`/`cw`/… de
  `best.a`), `CalendarDay` (data, tipo, flag *used* e as duas filas de eventos) e `CalendarTemplate`
  (os 250 pares `(dia-da-semana, tipo)` de `a.g()`, com a primitiva de posicionamento `b(int,int)`).
- `Core/Season`: `SeasonCalendar` (os dias + as consultas de `best.a`: `b/c/d/e/a`, *free days*,
  `az`), `GameSession` (monta o calendário com `BuildSeasonCalendar` e avança com
  `AdvanceToNextMatchDay`, replicando `ap → at → ax` com o pós-jogo de `PostMatch`) e `SeasonHooks`
  (pontos de extensão para competições/evolução/carreira das fases seguintes).
- `GameState.Calendar` guarda o calendário da temporada; nos dias 2 e domingos o original agenda
  salários, juros e evolução semanal, e as convocações de seleção/promoção nos dias tipados.
  Comando de inspeção: `dotnet run --project src/Brasfoot.Cli -- calendario --ano 2022`.

```
dotnet run --project src/Brasfoot.Cli -- calendario --ano 2022   # calendário com tipos e eventos
```

## Competições (Fase 3)

- `Core/Competitions/FixtureGenerator`: gerador de tabelas fiel a `best.t` (método do círculo com
  embaralhamento, reordenação de rodadas, mando alternado e o returno invertido) e o despacho de
  `f.s`; tabelas fixas de 3/4/5/6/9/19 times transcritas. As de 11 e 25 caem no caminho genérico
  corrigido (válido, mas não byte-idêntico ao original; ver a spec §3.7).
- `Core/Competitions/LeagueTable`: classificação pelo comparador `h.K` (pontos → vitórias → saldo →
  gols pró), com `OrderByHk` reutilizável para ranquear entre grupos.
- `Core/Competitions/LeagueCompetition`: liga de pontos corridos — agenda as rodadas nos dias livres
  do tipo (`f.s.a`), contabiliza os resultados do dia (`f.s.pO`) e coroa o campeão.
- `Core/Competitions/KnockoutTiebreak`: resolução de confronto na ordem fiel de `f.G.b` — vitórias
  por jogo, agregado, gol fora, regra da competição 2129, pênaltis e o quirk do visitante da ida
  (`f/G.java:305`).
- `Core/Competitions/KnockoutPlan`: estrutura do mata-mata (`f/z`) — número de rodadas por
  participantes/`fixedRounds`/código 2029 e os nomes das fases (`aq`), com o quirk `ZG==7→6` e os
  rótulos de preliminar.
- `Core/Competitions/KnockoutBracket`: chave eliminatória (jogo único ou ida-e-volta por fase via
  `twoLeggedByRound` = `f.z.ZK`) que monta as fases, joga as pernas e avança os vencedores; expõe
  `RoundName` na convenção de `f/z.io`.
- `Core/Competitions/GroupStage`: fase de grupos reutilizando `LeagueCompetition`, com classificação
  por grupo, ranqueamento dos "melhores terceiros" e lista de classificados.
- `Core/Competitions/BracketTables` (`BracketTables.g.cs` gerado por `re/tools/extract_bracket_tables.py`):
  as matrizes de permutação `Zm..Zz` do chaveamento, extraídas de `f/s.java`.
- `Core/Competitions/BracketSeeder`: chaveamento fiel de `f/s.yP`/`yO` — achata os classificados
  (`SeedByMatrix`, matriz posição-da-chave → posição na lista), escolhe a matriz por tamanho/idas-e-voltas
  (`FromGroupQualifiers`, `FromGroupQualifiersWithThirds`, `FromList`), ranqueia os melhores terceiros
  (`BestThirdsCount`, `BestExtraPlacementIndex`) e reproduz o cruzamento alternado dos 8 grupos
  (`AlternateFirstsAndSeconds`). `NationalFinalPhase` porta a fase final nacional `yN` (os 8 melhores
  segundos, embaralhados). `GroupStage.SeedKnockout`/`SeedKnockoutWithThirds` entregam a lista já
  posicionada para o `KnockoutBracket`.
- `Core/Competitions/CupDraw`: sorteio de copa genérico (`f/f.a`) — escolhe o quadro (8/16/32/64/128),
  embaralha as duas metades e as intercala (`SeedFromPool`). O CLI `copa` usa esse sorteio.
- `Core/Competitions/CopaDoBrasil`: Copa do Brasil novo formato (`f/f.b` + `f/f.ad..av`) — 8 potes
  sequenciais de 10 intercalados em `[4,0,7,3,5,1,6,2]`, 12 cabeças (`SelectExcluded`) entrando na 3ª
  fase e reordenação por força (`h.a.abm`: nível → reputação → desempate) nas fases 2129..2729.
  `Play` roda a competição inteira de uma vez (`KnockoutBracket.PlaySingleRound` joga fases de 80/40
  clubes, que não são potência de dois); o CLI `copadobrasil` usa esse formato.
- `Core/Competitions/CopaDoBrasilCompetition` (Fase 4): o driver dedicado que agenda a Copa do Brasil
  no laço de dias (`f/f` com `f/f.ad..av`, `f/f.java:82-282`) — reserva `RequiredDaySlots()` (12) dias
  livres de Copa Nacional, joga uma fase por vez (`AdvanceAfterDay`: cria a volta nas fases de ida e
  volta, resolve com o código da fase no desempate — a 1ª, 2129, avança o visitante — e reordena os
  vencedores por força antes de montar a fase seguinte). `SeasonBuilder.CreateCopaDoBrasil` cria/agenda
  e porta a notificação `Bh` (`BuildHeadsMessage`/`NotifyHeads`: mensagem 23/75 aos técnicos de clubes
  brasileiros); `GameSession.BrasilCup` + `RecordCopaDoBrasilResults` integram ao laço de dias. CLI:
  `copadobrasil --temporada`. Testado em `tests/Brasfoot.Tests/CopaDoBrasilSchedulingTests.cs`.
- `Core/Competitions/CupCompetition` (Fase 4): agenda um `KnockoutBracket` nos dias livres do tipo da
  competição, uma perna por dia (em vez de `PlayAll` de uma vez), análogo a `LeagueCompetition` para
  mata-matas soltos — `GameSession.Cups` guarda as instâncias, contabilizadas e avançadas a cada dia
  por `GameSession.RecordCupResults` (cria a volta da fase corrente quando a ida termina, ou resolve e
  agenda a fase seguinte). Reserva `RequiredDaySlots` dias livres do tipo (uma por perna) na criação.
  A Copa do Brasil, que reordena os vencedores entre fases, usa o driver dedicado
  `CopaDoBrasilCompetition` (ver acima).
- `Core/Competitions/Supercup` (Fase 4, `f.I`): jogo único entre o campeão da liga (1ª divisão) e o
  campeão da copa nacional da temporada anterior, com fallback para o vice da copa quando os dois
  títulos coincidiram no mesmo clube (`f/I.Ab()`, verificado linha a linha). `SelectOpponent` é puro;
  `Create` monta a chave de 2 times (código 11, sem ida-e-volta nem gol fora).
- `Core/Competitions/SeasonBuilder`: monta as divisões nacionais (ou uma divisão/liga avulsa) e as
  registra em `GameSession.Leagues`; a sessão contabiliza os resultados de todas as ligas a cada dia.
  `CreateNationalCup`/`CreateSupercup` (Fase 4) criam e agendam a copa nacional (sorteio `CupDraw`) e a
  Supercopa em `GameSession.Cups`.
- `BracketSeeder.DetermineGroupKnockoutSeeding`/`GroupStage.SeedKnockoutAuto`: o portão que escolhe,
  a partir do tipo e continente da competição (`at.b()`/`yT().gg()`), entre a matriz por tamanho
  (`SeedKnockout`) e o cruzamento alternado 1º/2º de 8 grupos (`f/s.yP`, `f/s.java:852-867`) — tipo 4
  (`liga*`) com continente 0 usa embaralhamento, com continentes 1/2/3 usa ranqueamento por `h.K` (e
  continente 1 também liga o gol fora da Conmebol); tipo 6 com continente 0 (Liga Europa) embaralha;
  qualquer outro par cai na matriz. Não é mais uma chamada manual de `AlternateFirstsAndSeconds`.
- `Competition.DecisaoTerceiroLugar`/`Competition.Continent`: os dois campos que faltavam no registro
  de competição para os portões acima e para a decisão de 3º lugar; `DecisaoTerceiroLugar` espelha
  `at.mq()`/`O(bool)` (ligado nas seleções e no Mundial de Clubes, nunca em ligas/copas de clube).
- `KnockoutBracket`: ao montar a fase final (2 times), se `Competition.DecisaoTerceiroLugar` está
  ligado, cria `KnockoutRound.ThirdPlace` com os dois perdedores da última fase de exatamente 2
  confrontos (`f/z.zt`, `f/G.java:78-80`) — jogo único, disputado junto com a ida da final. Também
  expõe `FinalPositions()` (classificação final pós-mata-mata, varrendo as fases de trás para frente —
  `f/s.za`, ramo com `Zc`); `LeagueCompetition.FinalPositions()` cobre o ramo sem mata-mata (ordem da
  tabela).
- `Core/Competitions/PromotionRelegation`: acesso e rebaixamento entre divisões (`best.Z.ee()`, caso
  sem grupos) — `SwapAdjacentDivisions` troca o fundo de uma divisão com o topo da divisão abaixo,
  `SwapLastDivisionWithPool` troca a última divisão com o grupo de clubes fora da liga (ordem
  invertida, fiel ao `Collections.reverse` do original). `AccessPlayoffField`/`RelegationPlayoffField`
  montam os campos dos dois playoffs de vaga (código 1099 de acesso, `f/B.BQ()`; código 1098 de
  rebaixamento, `f/B.a(B)`) para alimentar um `KnockoutBracket`. As quatro funções têm também uma
  sobrecarga que recebe `ConfigLigaType` diretamente (ver abaixo) em vez de números soltos.
- `Core/Competitions/ConfigLigaType`: a configuração de formato de uma divisão (`est.ConfigLigaType`),
  lida do `.cfg` do país por `Brasfoot.Data.WorldLoader.LoadLeagueConfigs` — turnos, grupos, mata-mata,
  quantos sobem pelo mata-mata, rebaixados diretos/totais, formato do playoff de rebaixamento. Os
  métodos `AccessPlayoffPoolSize`/`HasAccessPlayoff`/`HasRelegationPlayoff`/`RelegationPlayoffSlots`
  portam `f/B.BN()`/`BK()`/`BM()`/`BL()` — `BN()` (quantas posições da própria tabela disputam o
  playoff de acesso) não é uma tabela por país separada como a spec antiga sugeria: é simplesmente o
  `nRebaixados` da divisão imediatamente acima (`Z.K(divisao)`, `best/Z.java:1278-1283`).
- `Core/Competitions/CompetitionPrizes`: prêmio em dinheiro por fase do mata-mata
  (`KnockoutRoundPrize`/`KnockoutPrizes`, `f/G.c(int,int,boolean)` — pago só ao vencedor de cada
  confronto, inclusive o da disputa de 3º lugar) e por posição final de liga/estadual
  (`LeagueFinalPositionPrize`/`LeagueFinalPositionPrizes`, `ah.c(at,int)` — Liga Nacional por divisão,
  1ª divisão estadual). Puro: só calcula os valores (`aq.sr/su/ss/sw/sx/sy/sz/sv/sA/aeG`); quem aplica
  ao caixa do clube é o `Ledger` da Fase 5.
- `Core/Competitions/CompetitionRanking`: pontos de ranking/reputação de clube
  (`ClubRankingPoints`, `ah.b(at,int,int)`, acumulado no original em `nB[tipo]`) e de técnico
  (`ManagerRankingPoints`, `al.b(at,int,int)`, acumulado em `oc`/`lI()`) por posição final — duas
  tabelas de 16 linhas (uma por tipo de competição) com desvios por divisão (Liga Nacional/Estadual),
  por "é a Copa do Mundo ou não" (Seleções) e, só para o clube, pelo continente do próprio clube
  (Internacional 1). Quem acumula nos registros de clube/técnico é a Fase 6 (Reputation/ManagerRanking).

```
dotnet run --project src/Brasfoot.Cli -- temporada                 # Série A completa (--jornadas N limita)
dotnet run --project src/Brasfoot.Cli -- temporada --divisao 2
dotnet run --project src/Brasfoot.Cli -- copa --times 8 --ida-e-volta
dotnet run --project src/Brasfoot.Cli -- copadobrasil
```

## Competições nacionais e Supercopa (Fase 4, agendamento na temporada)

- `GameSession.Cups` + `Core/Competitions/CupCompetition`: a copa nacional (sorteio genérico) e a
  Supercopa agora entram no laço de dias real — jogos caem nos dias livres do tipo da competição
  (`CalendarDay.CompetitionToDay`), são disputados pelo motor junto com as ligas e contabilizados a
  cada dia (`GameSession.RecordCupResults`), em vez de jogados de uma vez isoladamente pelo CLI.
  `SeasonBuilder.CreateNationalCup`/`.CreateSupercup` registram a competição. Testado em
  `tests/Brasfoot.Tests/CupSchedulingTests.cs` (6 testes: contagem de dias por perna, copa de jogo
  único e de ida-e-volta rodadas até o fim pelo laço de dias, fallback da Supercopa para o vice da
  copa, Supercopa não criada sem adversário válido).
- Formato da Supercopa verificado no decompilado (`f/I.Ab()`/`b(ah,ah)`): jogo único, campeão da liga
  (temporada anterior) manda contra o campeão da copa nacional (idem), com fallback para o vice da copa
  quando o mesmo clube venceu os dois títulos — ver `Core/Competitions/Supercup` e
  `re/spec-calendario-competicoes.md` §6.3.

## Estaduais, regionais e amistosos (Fase 4)

- `Core/Competitions/StateFormulaTable`: dados fixos de `best.aq` — a tabela de fórmulas (`sL`), os
  rótulos (`sN`), o grupo padrão de São Paulo (`sO`) e sigla/nome/gentílico dos 27 estados (`rX`/`rY`/`rZ`).
- `Core/Competitions/ConfigEstadualType`: a configuração de uma divisão estadual (`est.ConfigEstadualType`),
  lida dos `conf_estadual/*.ces` por `WorldLoader.LoadStateConfigs` (chave `(estado, divisão)`), com as
  validações dos setters originais e `FinalsLegsFormatted` (`getFinaisIdaVoltaFormatado`).
- `Core/Competitions/PhasedCompetition` (`f.s` com grupos + chave `f.z`): competição em duas fases —
  1ª fase como liga(s) de grupo (ou um único cruzamento entre grupos para as fórmulas 7/10), e mata-mata
  criado ao fim dela com `BracketSeeder` (`FromGroupQualifiers`/`FromList`, matriz nacional para 7/10).
  Os dias de 1ª fase e de mata-mata são reservados de antemão nos dias livres do tipo e consumidos em
  ordem (`CupCompetition` interno, criado preguiçosamente em `AdvanceAfterDay`).
- `Core/Competitions/StateFederation` (federação estadual, `best.w`): monta as divisões de um estado a
  partir dos clubes brasileiros daquele estado (ordem de nível/desempate, `w.dY`), com fallback para a
  fórmula padrão 0 quando não há `.ces` ou a fórmula pede mais clubes que o pool, o grupo padrão paulista
  (`w.z`) e a liquidação de acesso/rebaixamento (`w.ee`) em `SettlePromotionRelegation`
  (`yW`/`yU`: candidatos a subir pela chave e rebaixados pelo fundo da tabela).
- `Core/Competitions/SeasonBuilder`: `CreateStateChampionships` (todas as federações com ≥6 clubes,
  como `w.dZ`) e `CreateRegionalChampionships` (`f.F.an`): cada região (Rio-SP, Sul-Minas, Copa do
  Nordeste, Copa Verde) reúne os 16 primeiros clubes das suas federações, ordenados por `abm`
  (`CompareRegional`) e intercalados por `h.a.ad(4,4)` (`InterleaveQuarters`); fase de grupos 4×4 e
  mata-mata de 8 (três fases de ida e volta). `GameSession.StateFederations`/`.Phased` guardam tudo.
- `Core/Competitions/FriendlyMatch` (`f.a`): convite de amistoso — aceite/cachê por reputação do
  adversário (tabelas por país e por quem manda), recusa para clubes grandes, adversário humano aceita
  de graça — e criação do jogo. `FriendlyTournament` (`f.L`/"Torneio Amistoso"): 8 clubes em 2 grupos de
  4 e mata-mata de 4 em jogo único, nos dias `TorneioAmistoso` (`CreateFromWorld` aproxima a ordem de
  `P()` por `World.Teams`). `GameSession.RecordPhasedResults` contabiliza e avança essas competições a
  cada dia. Testado em `tests/Brasfoot.Tests/StateChampionshipTests.cs`.

```
dotnet run --project src/Brasfoot.Cli -- estadual --estado SP
dotnet run --project src/Brasfoot.Cli -- regionais
dotnet run --project src/Brasfoot.Cli -- amistoso saopaulo_bra corinthians_bra
dotnet run --project src/Brasfoot.Cli -- amistoso torneio --times 8
```

## Ciclo da temporada: `cD` e histórico de campeões (Fase 4)

- `DayEvent.CriaSerieDCopa` (`cD`) entra no laço de dias pelo gancho `SeasonHooks.CreateSerieDAndCopa`:
  `GameSession.SeedNationalTeamEvents` agenda o evento no primeiro dia Nacional (fila de **fim de dia**,
  como o `a.b(n2, 4, 1)` de `best/f.java:543-544`, condicionado aos regionais ligados) e o `Dispatch`
  o encaminha ao hook. `SeasonBuilder.CreateSerieDAndCopa` (`best.a.m()/l()`) cria a Copa do Brasil a
  partir do grupo de clubes brasileiros no meio da temporada.
- `Core/Season/FullSeasonHooks`: a montagem concreta da temporada brasileira sobre `SeasonBuilder` —
  divisões da liga nacional + estaduais + regionais em `BuildCompetitions`, a Copa do Brasil em
  `CreateSerieDAndCopa` (nascendo no `cD`, não no início do ano) e o arquivo de campeões em
  `SeasonRollover`. É a ponte para o front-end (Fase 10). A Série D propriamente dita (elenco via
  `best.w.Q`) ainda não é criada.
- `Core/Season/SeasonArchive` + `GameState.Champions`: arquiva campeões **e vices** de todas as
  competições encerradas (`ChampionRecord` ganhou `RunnerUpId`/`RunnerUpName`), idempotente por
  `(temporada, competição)`, pulando as 1ªs fases estaduais/regionais (que vivem em `session.Leagues`).
  `SeasonBuilder.CreateSupercupFromHistory` usa esse histórico para montar a Supercopa da temporada
  seguinte (campeão da liga × campeão da copa, com o vice da copa como fallback).
- Testado em `tests/Brasfoot.Tests/SeasonLifecycleTests.cs` (13 testes): agendamento/dispatch do `cD`,
  arquivo de liga e de copa (campeão + vice), idempotência, `Find`, Supercopa a partir do histórico
  (incluindo o fallback do vice) e uma temporada inteira sintética (96 clubes) jogada pelo
  `FullSeasonHooks` até o arquivo dos campeões.

## Ainda não portado

- Copa do Brasil: o driver (`CopaDoBrasilCompetition`), a notificação `Bh` e o gancho `cD`
  (`CreateSerieDAndCopa`) **foram portados** (ver acima). Falta a Série D propriamente dita (elenco via
  `best.w.Q`, fase classificatória + mata-mata), que `CreateSerieDAndCopa` hoje deixa de fora.
- Histórico de campeões por temporada **foi portado** (`SeasonArchive` + `ChampionRecord` alimentado
  pelas competições, ver acima). Falta ainda a persistência das divisões estaduais entre temporadas (a
  `StateFederation` reconstrói os quadros a partir dos clubes a cada ano; o acesso/rebaixamento calculado
  não é aplicado aos dados do mundo ainda).
- Mata-mata: o wrapper `f.B`/`f.z` como objeto coeso (`fc(1802/1803/90)`, hand-off do código 1020) —
  os novos `PromotionRelegation` e `BracketSeeder.DetermineGroupKnockoutSeeding` são chamados
  explicitamente por quem monta a temporada, não são métodos de um `f.B`/`f.s` portado (spec §3.7).
  Cruzamento alternado, decisão de 3º lugar e posições finais do mata-mata **foram portados** em
  rodada anterior; prêmios (`c(int,int,boolean)`) e pontos de ranking/reputação **foram portados**
  nesta rodada (`CompetitionPrizes`/`CompetitionRanking`, ver seção acima).
- Acesso/rebaixamento: portado para o caso sem grupos (`SwapAdjacentDivisions`,
  `SwapLastDivisionWithPool`, `AccessPlayoffField`, `RelegationPlayoffField`, cada uma com sobrecarga
  `ConfigLigaType`); falta o caso com grupos (`Zd != 0`) e as tabelas fixas de 11/25 times
  byte-fiéis (§3.3/§3.7 da spec).
- Virada de temporada: aposentadorias, novos juniores, promoção, mercado IA×IA (`best/ag.java`) e
  reposição de elenco do vendedor (`l.a(ah, F)`).
- Leilões, compra de juniores, propostas não solicitadas da IA, pagamento de salários e livro-caixa
  (juros/empréstimo são `SeasonHooks`), opção "habilidade individual", evolução semanal de força.
