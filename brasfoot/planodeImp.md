# Plano: Brasfoot completo em C# (.NET 10 + Avalonia)

## Contexto
Já existe o port Linux do original, as specs `re/spec-partidas.md` e `re/spec-transferencias.md`, e a
solução `dotnet/` com motor de partidas (`Core/Matches`), mercado (`Core/Transfers`), leitor de
serialização Java + `WorldLoader` (`Data/`), CLI e 33 testes. Falta todo o resto do jogo: calendário,
competições, temporada, finanças, carreira do técnico, evolução de jogadores, seleções, persistência
e a interface gráfica.

Decisões do usuário: front **Avalonia** (desktop MVVM, Linux/Windows); **base fiel + melhorias**
(regras do original como base, livre para corrigir bugs e redesenhar telas); dados **lidos da
instalação original** (nada redistribuído); modos: **single-player**, **Seleções/Copa**, **editor de times**.
Sem multi-humano (hot seat) e sem gating de "versão registrada" (tudo liberado).

Resultado: um executável Avalonia que joga temporadas completas com todas as competições do
original, apontando para a pasta de dados da instalação.

## Fase 0 — Documentação (primeiro passo)
Salvar os três relatórios de engenharia reversa desta sessão como specs, no mesmo padrão das existentes:
- `re/spec-calendario-competicoes.md` — calendário (`best.a`, template `a.g()`), eventos, laço de dias
  `f.ap/at/ax/q`, framework de competições (`at`, `f.s`, `f.z`, `f.G`), tabelas, fixtures, ligas,
  copas, estaduais, regionais, internacionais, seleções, pipeline `f.aa()`, prêmios.
- `re/spec-financas-carreira.md` — livro-caixa `best.C`, bilheteria `v.b`, estádio/obras, empréstimo
  bancário, confiança diretoria/torcida, demissões, ofertas de emprego, reputação, evolução semanal
  `fW/fX/fY`, habilidades individuais, treino, opções, saves, mensagens.
- `re/spec-telas.md` — inventário de telas e fluxos (launcher, hub `eg`, escalação `bz`, ao vivo `dV`,
  resultados `hk`, tabelas `ay`, mercado, histórico, editor `d/n`), assets e sons.

> **Status: concluída.** As três especificações foram escritas (500, 615 e 646 linhas), verificadas
> contra os fontes decompilados (citações `path:line` validadas; conferência de conteúdo por amostragem)
> e estão referenciadas no `dotnet/README.md`. Fase 1 a seguir.

## Arquitetura
```
dotnet/
  src/Brasfoot.Core/        regras puras, sem I/O nem UI
    Common/  Domain/  Matches/  Transfers/                (existentes)
    Calendar/      CalendarDay, SlotType, CalendarTemplate (a.g()), DayEvents
    Competitions/  Competition, LeagueStage, KnockoutStage, KnockoutRound, Table, FixtureGenerator,
                   formatos: NationalLeague, NationalCup, Supercup, StateChampionship, Regional,
                   ContinentalCup(def. data-driven), ClubWorldCup, Recopa, Friendlies, PreseasonTournament
    Season/        SeasonPipeline (f.aa), Awards (time do ano, bola de ouro, hall da fama),
                   AiTransferWindow (ag.jO: jS/jU/jR/jT), SquadRestock (l.a(ah,F)), Retirement, Newgens
    Development/   WeeklyEvolution (fV/fW/fX/fY), IndividualSkills (F.j, f(d), e(d)), Training
    Finance/       Ledger (best.C), Stadium & Attendance (v.b), StadiumExpansion, BankLoan, Salaries, Prizes
    Career/        Manager (best.al), BoardAndFans (al.a), Firing (s.A, ag.jQ), JobMarket (best.ay),
                   Reputation (kk de clube e técnico), ManagerRanking
    NationalTeams/ NationalTeam, CallUp (Z.z), qualifiers/torneios (ciclo f.ac), NationalJobOffers
    Game/          GameState (agregado raiz), GameSession (laço de dias), IHumanDecisions, Inbox
  src/Brasfoot.Data/        leitura da instalação + persistência
    JavaSerialization/ (existente), WorldLoader (+ .ces estaduais, nomes/sobrenomes, idioma)
    Assets/        IAssetProvider: escudos, mini-escudos, camisas 1-3, bandeiras, troféus, sons, imagens
    Saves/         SaveGame (JSON+gzip, versão de formato), SaveSlots (.info próprio)
    Editor/        BanWriter (escrita do formato Java p/ editor) ou export JSON — ver Fase 10
  src/Brasfoot.App/         Avalonia 11 + CommunityToolkit.Mvvm (Views/, ViewModels/, Services/)
  src/Brasfoot.Cli/         (existente) + comandos `temporada`, `carreira` para testes headless
  tests/Brasfoot.Tests/     unidade + integração + simulação de temporadas
```
Princípios:
- **Core sem UI**: toda decisão humana passa por `IHumanDecisions` (escalação, substituições, pênaltis,
  aceitar propostas/empregos, multar jogador). A App implementa com diálogos; testes/CLI com uma
  implementação automática (a própria IA). Isso já resolve o caso dos pênaltis em partida ao vivo.
- **Partida ao vivo** reaproveita `MatchEngine.Tick(half, minute)` (Core/Matches/MatchEngine.cs):
  a App chama um tick por intervalo de timer; o `MatchSimulator.Play` continua para jogos sem humano.
- **IDs estáveis** (`Player.Id`, `Team.Id`, `Competition.Id`, `Manager.Id`) para persistência e
  referências; o `GameState` é o grafo serializado.
- **Fidelidade**: `RulesOptions.FixOriginalBugs` passa a ser **true por padrão na App** (base +
  melhorias); testes de paridade rodam com false. Cada quirk documentado nas specs vira uma flag
  ou é corrigido com comentário referenciando a spec.

## Fases e algoritmos

### Fase 1 — Fundações do estado de jogo
- `GameState`: mundo (`World` existente), temporada, data atual, calendário, competições, técnicos,
  histórico (campeões, transferências, trocas de técnico, hall da fama), caixa de mensagens, opções.
- Adicionar `Id` a `Player`; `Manager` (best.al) com confiança (95), torcida (85), reputação, histórico.
- Save/load em JSON comprimido (System.Text.Json com `ReferenceHandler.Preserve` ou DTOs por id);
  slots com cabeçalho (time, técnico, temporada, próximo jogo). Autosave conforme opção `autoSalvar`.
- Opções (`est.Options`, spec-financas §4) como `GameOptions` persistidas em JSON do usuário.

> **Status: fundações entregues.** `GameState`, `Manager` (`best.al`), `GameOptions` (defaults de
> `est.Options`), `Player.Id` estável e `SaveGame` (JSON+gzip com referências preservadas) em
> `Brasfoot.Data/Saves`, com 8 testes (`GameStateTests`). O `GameState` recebeu o `SeasonCalendar`
> na Fase 2; as competições/`fixtures` entram na Fase 3.

### Fase 2 — Calendário e laço de dias (spec-calendario §1)
- `CalendarTemplate`: os 250 pares (dia-da-semana, tipo) de `a.g()` → datas do ano; tipos 1..15, 100, 200.
- Eventos por fila (0 pós-jogos, 1 fim do dia): `ds` salários, `aj` evolução semanal, `dJ` juros,
  `cw` cria Mundial, `cD` Série D/Copa do Brasil, `cS/cO/cSempregado` seleção, `cPromocao` ofertas.
  Melhoria: rodar eventos na data certa, não em lote no próximo dia de jogo (quirk §9.2).
- `GameSession.AdvanceToNextMatchDay()` replica `ap → (ao vivo) → at → ax`: escalações IA, jogos do
  dia, pós-jogo (`PostMatch` existente), avanço de fases, demissões, fim de empréstimos,
  compras IA de listados (`TransferMarket.ProcessListedHumanPlayers` existente), obras, filas.

> **Status: núcleo entregue.** `Core/Calendar` (`DayType`, `DayEvent`, `CalendarDay`,
> `CalendarTemplate` com os 250 pares de `a.g()`), `Core/Season` (`SeasonCalendar` com as consultas de
> `best.a`, `SeasonHooks` para os subsistemas das fases seguintes, `GameSession` com
> `BuildSeasonCalendar`/`AdvanceToNextMatchDay`) e `GameState.Calendar`. 12 testes em
> `CalendarTests` (template 2022/2023 incluindo o quirk do índice 0, consultas, sementes semanais e de
> seleções, laço de avanço com jogos injetados, folha salarial). Comando CLI `calendario`.
> Pendente para Fase 3: criação das `fixtures` (hoje os jogos são injetados nas competições) e os
> hooks `cw`/`cD`/`cS`/`cO`/`cSempregado`/`cPromocao`; o processamento em lote dos eventos (§9.2) foi
> mantido fiel ao original.

### Fase 3 — Framework de competições (spec-calendario §2–4)
- `FixtureGenerator`: método do círculo com reordenação de rodadas e alternância do time fixo; 1–4
  turnos; tabelas fixas p/ 3/4/5/6/9/11/19/25 times; regra de turnos para ligas tipo 1.
- `LeagueCompetition`/`GroupStage` (f.s): grupos (pote `i % n` ou blocos), tabela por pontos→vitórias→saldo→gols pró
  (melhoria opcional: confronto direto), fim de fase → classificados → KO com as matrizes de
  cruzamento `Zm..Zz` (`BracketSeeder`), melhores terceiros, posições finais.
- `KnockoutStage/Round` (f.z/f.G): ida/volta, gols fora (CONMEBOL), disputa de pênaltis
  (`KnockoutTie` existente), 3º lugar, chave fixa, nomes das fases, prêmio por confronto.
  Corrigir fallback que compara o time consigo mesmo (melhor campanha avança).
- `Competition` base: campeões (`best.i`), artilharia, estatísticas, pontos de ranking/reputação,
  prêmios (tabelas `sr`, `su`, `ss`, `sw`, `sx`, `sy`, `sv`), títulos.

> **Status: quase completa — falta só o wrapper `f.B` como objeto coeso e alguns casos de borda.** Em
> `Core/Competitions`: `FixtureGenerator` (círculo fiel de `best.t.a` + despacho `f.s`, tabelas fixas
> 3/4/5/6/9/19 transcritas; 11 e 25 caem no genérico corrigido, documentado como não byte-idêntico),
> `LeagueTable` (`h.K`), `LeagueCompetition` (agendamento `f.s.a`, contabilização `f.s.pO`, campeão,
> `FinalPositions`), `SeasonBuilder` (divisões nacionais + `CreateLeague`), `KnockoutTiebreak` (ordem
> fiel de `f.G.b`, incluindo o quirk `f/G.java:305`), `KnockoutPlan` (`f.z`: fases e nomes),
> `KnockoutBracket` (chave, ida/volta por fase, `PlayAll`, decisão de 3º lugar, `FinalPositions`),
> `CupDraw` (sorteio genérico de copa, `f/f.a`), `GroupStage` (grupos + `PlacementsInOrder`/melhores
> terceiros + `SeedKnockoutAuto`). Integração via `GameSession.Leagues`, `SessionHooks.BuildCompetitions`
> e `GameSession.RecordLeagueResults`. CLI: `temporada` e `copa`. 200 testes no total (incl.
> `CompetitionTests` e `CompetitionPrizesTests`). **Entregue em rodadas anteriores:** as matrizes
> `Zm..Zz` (`Competitions/BracketTables.g.cs`, geradas por `re/tools/extract_bracket_tables.py`), o
> seeding fiel grupo→mata-mata `yP`/`yO` (`Competitions/BracketSeeder` +
> `GroupStage.SeedKnockout`/`SeedKnockoutWithThirds`), a fase final nacional `yN`
> (`NationalFinalPhase`) e a estrutura do mata-mata `f.z` (`Competitions/KnockoutPlan`;
> `KnockoutBracket` com ida-e-volta por fase e nomes de fase); o portão `b()`/`yT().gg()` do
> cruzamento alternado 1º/2º (`BracketSeeder.DetermineGroupKnockoutSeeding` + `GroupStage.SeedKnockoutAuto`,
> `f/s.java:852-867`); a decisão de 3º lugar (`Competition.DecisaoTerceiroLugar` = `at.mq()`,
> `KnockoutRound.ThirdPlace`, criada em `f/G.b`/`f/z.zt` — a spec antiga estava errada ao atribuir a
> origem a `ag.b`, que é só a varredura de mercado da IA; corrigido em
> `re/spec-calendario-competicoes.md` §9.13); as posições finais de temporada (`f/s.za`, via
> `KnockoutBracket.FinalPositions`/`LeagueCompetition.FinalPositions`); e acesso/rebaixamento
> (`best.Z.ee()`, caso sem grupos) com os dois playoffs de vaga, código 1099 (`f/B.BQ`) e 1098
> (`f/B.a(B)`), em `Core/Competitions/PromotionRelegation`.
>
> **Entregue nesta rodada:** (1) prêmios em dinheiro (`Core/Competitions/CompetitionPrizes`) —
> `KnockoutRoundPrize`/`KnockoutPrizes` portam `f.G.c(int,int,boolean)` (`f/G.java:103-161`, tabelas
> `aq.sw/sx/sy/sz/sv/sA/aeG` + a Copa Nacional via `aq.ss` alinhada à final; paga só o vencedor de cada
> confronto, inclusive a disputa de 3º lugar) e `LeagueFinalPositionPrize`/`LeagueFinalPositionPrizes`
> portam `ah.c(at,int)` (`best/ah.java:808-823`, tabelas `aq.sr` por divisão da Liga Nacional e `aq.su`
> da 1ª divisão estadual); (2) pontos de ranking/reputação (`Core/Competitions/CompetitionRanking`) —
> `ClubRankingPoints` porta `ah.b(at,int,int)` (`best/ah.java:912-1038`) e `ManagerRankingPoints` porta
> `al.b(at,int,int)` (`best/al.java:792-902`), as duas tabelas de 16 linhas (uma por tipo de
> competição) com os desvios por divisão, Copa do Mundo vs. demais seleções e, só no clube, pelo
> continente do próprio clube; (3) `Core/Competitions/ConfigLigaType` (`est.ConfigLigaType`), agora
> lido por inteiro do `.cfg` por `WorldLoader.LoadLeagueConfigs` (antes só `pais`/`divisao`/`nTimes`/
> `nome`), com `AccessPlayoffPoolSize`/`HasAccessPlayoff`/`HasRelegationPlayoff`/`RelegationPlayoffSlots`
> portando `f/B.BN()`/`BK()`/`BM()`/`BL()` — achado relevante: `BN()`/`Z.K(divisao)` **não é** uma
> tabela por país separada, como a spec sugeria antes; é só o `nRebaixados` da divisão imediatamente
> acima. `PromotionRelegation` ganhou uma sobrecarga `ConfigLigaType` em cada um dos quatro métodos.
>
> **Pendente:** o wrapper `f.B`/`f.z` como objeto coeso (`fc(1802/1803/90)`, hand-off do código 1020)
> — os helpers acima continuam chamados explicitamente por quem monta a temporada, não como métodos de
> um `f.B`/`f.s` portado; o caso de acesso/rebaixamento com grupos (`Zd != 0`); as tabelas fixas de
> 11/25 times byte-fiéis; e os três campos booleanos de ida-e-volta do `.cfg`
> (`duasVoltasMataMata`/`duasVoltasMataMataSobe`/`duasVoltasplayoffReb`), ainda não lidos pelo
> `WorldLoader` (o leitor Java já suporta arrays; falta só o consumidor).

### Fase 4 — Competições nacionais (spec-calendario §5)
- Ligas: divisões por `.cfg` (já lido em `WorldLoader.LoadLeagueConfigs`, completar campos:
  turnos, grupos, mata-mata, sobe por mata-mata, rebaixados diretos/playoff); Série C/D especiais.
- Acesso/rebaixamento `Z.ee()` + playoffs de acesso (1099) e rebaixamento (1098); última divisão
  troca com clubes fora da liga.
- Copa nacional (potes, mandante mais fraco na ida; novo formato Copa do Brasil 2129–2729),
  Supercopa, estaduais (`.ces` + tabela de fórmulas `aq.sL`), regionais (4 regiões), amistosos
  (aceite/cachê) e Torneio Amistoso de pré-temporada.
  - **Feito (rodadas anteriores):** sorteio genérico de copa `f/f.a` em `Core/Competitions/CupDraw`
    (`BracketSize`, `SeedFromPool`), usado pelo CLI `copa`; e a Copa do Brasil novo formato
    (`f/f.b` + `f/f.ad..av`) em `Core/Competitions/CopaDoBrasil` (8 potes de 10, 12 cabeças,
    reordenação por `h.a.abm`, fases 2129..2729) com `KnockoutBracket.PlaySingleRound` para as fases
    de 80/40 clubes; CLI `copadobrasil`.
  - **Feito nesta rodada:** (1) agendamento das copas nos dias livres da temporada pela `GameSession`
    — `Core/Competitions/CupCompetition` reserva, por competição, `RequiredDaySlots` dias livres do
    tipo (uma perna por dia) e avança fase a fase (`AdvanceAfterDay`: cria a volta quando a ida termina,
    ou resolve e agenda a próxima fase) em vez de jogar tudo de uma vez com `PlayAll`; `GameSession.Cups`
    + `RecordCupResults` (análogo a `Leagues`/`RecordLeagueResults`) integram isso ao laço de dias real.
    `SeasonBuilder.CreateNationalCup` monta e agenda a copa nacional genérica (via `CupDraw`). (2)
    Supercopa (`f.I`) — formato verificado linha a linha no decompilado (`f/I.Ab()`/`b(ah,ah)`,
    `f/I.java:37-55`): jogo único, campeão da liga nacional (1ª divisão, temporada anterior) manda
    contra o campeão da copa nacional da temporada anterior, com fallback para o **vice** da copa
    quando o mesmo clube venceu liga e copa. Portado em `Core/Competitions/Supercup`
    (`SelectOpponent` puro + `Create` monta a chave de 2 times, código 11) e agendado via
    `SeasonBuilder.CreateSupercup` (usa `CupCompetition`, 1 dia livre de `SuperCopa` por temporada).
    6 testes novos em `tests/Brasfoot.Tests/CupSchedulingTests.cs` (contagem de dias por perna, copa de
    jogo único e ida-e-volta jogadas até o fim pelo laço de dias real, fallback/ausência da Supercopa).
    206 testes no total.
  - **Feito (estaduais/regionais/amistosos):** (1) estaduais — `Core/Competitions/StateFormulaTable`
    (`aq.sL`/`sN`/`sO`/`rX`/`rY`/`rZ`), `ConfigEstadualType` (`est.ConfigEstadualType`) lido dos
    `conf_estadual/*.ces` por `WorldLoader.LoadStateConfigs`, `PhasedCompetition` (`f.s` grupos → chave
    `f.z`, com cruzamento entre grupos nas fórmulas 7/10 e reserva prévia dos dias de grupos + mata-mata)
    e `StateFederation` (`best.w.dY`/`z`/`ee`: divisões por nível com fallback à fórmula padrão 0,
    grupo padrão paulista, `SettlePromotionRelegation` com `yW`/`yU`). `SeasonBuilder.CreateStateChampionships`
    monta todas as federações com ≥6 clubes. (2) regionais — `SeasonBuilder.CreateRegionalChampionships`
    (`f.F.an`): 4 regiões, 16 clubes ordenados por `abm` (`CompareRegional`) e intercalados por
    `h.a.ad(4,4)` (`InterleaveQuarters`), grupos 4×4 + mata-mata de 8 (3 fases ida-e-volta).
    (3) amistosos — `FriendlyMatch` (`f.a`: aceite/cachê por reputação, tabelas por país/mando, recusa,
    humano aceita de graça) e `FriendlyTournament` (`f.L`: 8 clubes em 2 grupos de 4 + mata-mata de 4
    em jogo único, "Torneio Amistoso"/Juazeiro). `GameSession.Phased`/`StateFederations` + `RecordPhasedResults`
    integram ao laço de dias. CLI: `estadual [--estado SP]`, `regionais`, `amistoso <c> <a>`,
    `amistoso torneio`. 27 testes novos em `tests/Brasfoot.Tests/StateChampionshipTests.cs`. 233 testes no total.
  - **Feito (Copa do Brasil):** o driver dedicado `Core/Competitions/CopaDoBrasilCompetition` (`f/f` +
    `f/f.ad..av`, `f/f.java:82-282`) agenda as sete fases (80→40→+12 cabeças→32→16→8→4→2) nos dias
    livres de Copa Nacional (12: uma perna por fase de jogo único e duas nas de ida e volta), resolve
    cada fase com o código da fase no desempate (a 1ª, 2129, avança o visitante) e reordena os
    vencedores por força entre elas (`SecondStage`/`ThirdStage`/`LaterStage`). `SeasonBuilder.CreateCopaDoBrasil`
    cria/agenda e porta a notificação `Bh` (`BuildHeadsMessage`/`NotifyHeads`, mensagem 23/75 aos técnicos
    de clubes brasileiros); `GameSession.BrasilCup` + `RecordCopaDoBrasilResults` integram ao laço de dias.
    CLI: `copadobrasil --temporada`. 7 testes novos em `tests/Brasfoot.Tests/CopaDoBrasilSchedulingTests.cs`.
    240 testes no total.
  - **Feito (ciclo da temporada):** (1) `cD` plugado ao laço de dias — `GameSession.SeedNationalTeamEvents`
    agenda `DayEvent.CriaSerieDCopa` no primeiro dia Nacional (fila de fim de dia) quando os regionais
    estão ligados (`best/f.java:543-544`; `DayEvents.QueueOf` corrigido para a fila 1, como no original) e
    o `Dispatch` chama `Hooks.CreateSerieDAndCopa`. `SeasonBuilder.CreateSerieDAndCopa`
    (`best.a.m()/l()`) cria a Copa do Brasil no meio da temporada; `Core/Season/FullSeasonHooks` é a
    montagem concreta da temporada brasileira (4 divisões nacionais + estaduais + regionais + Copa do
    Brasil via `cD` + arquivo de campeões). (2) histórico — `SeasonArchive` arquiva campeões **e vices**
    por `(temporada, competição)` em `GameState.Champions` (`ChampionRecord` estendido com
    `RunnerUpId`/`RunnerUpName`, idempotente, pula competições não encerradas e as 1ªs fases
    estaduais/regionais); `SeasonBuilder.CreateSupercupFromHistory` monta a Supercopa da temporada
    seguinte a partir desse histórico (com o fallback do vice da copa); `FullSeasonHooks.BuildCompetitions`
    cria a Supercopa da temporada já com esse histórico. `GameSession.StartNextSeason` (versão mínima da
    virada de `best.f.al()`) garante a virada, avança a temporada, descarta as competições do ano e
    remonta o calendário. 16 testes novos em `tests/Brasfoot.Tests/SeasonLifecycleTests.cs`. 256 testes
    no total.
  - **Feito (Série D):** a 4ª divisão nacional na carreira completa (`bk()`: `JogaEstadual` + 4 divisões)
    nasce no gancho `cD` via `best.a.m()`: `Core/Competitions/SerieDSelection` porta `best.w.Q`
    (clubes livres, 19 passagens pelos grupos `sb..sf` = `w.a`, preenchimento por `Z.jg()`, corte e
    as ordenações por `jW`/`jX` de `ah`, além de `best.w.eh` para os extras da Copa). Os slots de
    estado (`a.SR.bx()`) saem de `FromFederations` (posições finais dos estaduais, filtrando as
    divisões 1–3) e `SeasonBuilder.SelectSerieDField` monta o quadro. `CreateNationalLeagues` deixa
    a 4ª divisão de fora (como `Z.Ar()`, que a cria vazia), e `SeasonBuilder.CreateSerieD` a cria no
    meio da temporada: 8 grupos × 8 (intercalados, ida e volta dentro do grupo) + mata-mata de 32
    (4 classificados por grupo), nos dias Nacionais; sem `FixOriginalBugs`/config o formato cabe no
    quadro, senão cai em pontos corridos. A Copa do Brasil no ramo `m()` sai das divisões 1–3 +
    `eh()`; o ramo `l()` (regionais sem carreira completa) continua usando o país inteiro.
    `FullSeasonHooks` recebe a config `.cfg` da 4ª divisão (default brasileiro 8×4). 20 testes de
    `SerieDSelection` (`tests/Brasfoot.Tests/SerieDTests.cs`) + 1 de criação da Série D; verificado
    com os dados reais (brasfoot-linux: 64 clubes, 8 grupos de 8). 277 testes no total.
  - **Falta:** o acesso/rebaixamento estadual calculado por `SettlePromotionRelegation` ainda não é
    aplicado aos dados do mundo (a federação é reconstruída pelo nível a cada temporada, como no
    original). Os clubes livres (`bY()`) da Série D ainda não têm equivalente (a 1ª etapa de `Q` entra
    vazia; só surgem quando um clube é removido de uma liga). A virada completa (evolução semanal,
    finanças, mercado de técnicos) fica para as Fases 4/5/6.

### Fase 5 — Finanças e estádio (spec-financas §1)
- `Ledger` por temporada com categorias; salários (mensal dia 2 ×4 ou semanal domingo, só em meses
  com jogo), juros mensais 3%, empréstimo de 500 mil com teto por divisão, verba de temporada `sD`.
- Bilheteria `v.b` (base por reputação, ocupação, rivalidade, satisfação da torcida, preço manual ±3%
  por unidade) — mover a lógica de público hoje ausente; preços sugeridos `qK`.
- Expansão de estádio: custo por faixa + 100 mil, prazo 15–40 dias, conclusão no laço de dias
  (melhoria: liberar tiers `pa[2]/pa[3]` com a temporada).
- Caixa negativo: penalidade na confiança e motivo de demissão (sem falência dura).

### Fase 6 — Carreira do técnico (spec-financas §2)
- Confiança/torcida por jogo (tabelas por competição, faixa na tabela, mandante, goleada), bônus de
  título, reset +50 na temporada, < 20 de torcida → −3 de confiança.
- Demissões: humano com confiança < 10 (motivo financeiro/torcida/resultados); IA idem fora do G6;
  fim de temporada IA `rand(90)+1 > %vitórias`. Substituto `kE()` por reputação/país.
- Ofertas de emprego (`ay.b`), Central de Empregos, pedir demissão, assumir clube (contratos 180 dias,
  confiança 95/85). Reputação e ranking de técnicos; troféus do técnico.

### Fase 7 — Jogadores ao longo do tempo (spec-financas §3, spec-transferencias §7)
- Evolução semanal: crescimento `fW` (taxa por nível/idade/jogou/força/potencial/continente, teto por
  clube e por país), declínio `fX` (≥32, piso por divisão), juniores `fY`/`ga`/`fZ`.
- Habilidades individuais (opção): geração `F.j`, crescimento por foco de treino, uso em
  `PossessionEngine.PlayerStrength` (pesos por slot já especificados em spec-partidas §3.1).
- Treino (foco principal/secundário, auxiliar decide).
- Virada de temporada `f.aa()` completa: prêmios (time do ano, melhor jogador → estrela, top mundial),
  envelhecimento, aposentadoria (tabela §7.2), técnico ex-jogador, newgens (potencial por nível,
  estrangeiros), promoção de juniores, recálculo de valor/salário (`PlayerEconomics.Recalculate`),
  mercado IA×IA `ag.jO` (jS/jU vendas por posição na tabela, jR reposição, jT grandes europeus),
  reposição do vendedor `l.a(ah,F)` (corrigindo o bug da posição), demissões IA, hall da fama.
- Recursos restantes do mercado: leilões (`components.an`, `best.N`, `a/dz`), compra de juniores,
  propostas não solicitadas da IA (1% compra / 50% empréstimo).

### Fase 8 — Competições internacionais de clubes (spec-calendario §6)
- Preenchimento de vagas por país (campeão da copa, ordem da liga, países sem liga com probabilidade).
- Formatos como dados (lista de fases: preliminares, grupos, KO, ida/volta, gols fora, sede neutra):
  Champions/Libertadores/CAF/AFC/Concacaf/OFC, Europa League, Sul-Americana, Conference, Mundial de
  Clubes, Recopas; quedas entre torneios (perdedores da prévia → torneio menor; 3º de grupo → EL).

### Fase 9 — Seleções e Copa (spec-calendario §7)
- Seleção como `Team` sintético; convocação IA (cota de 23 por posição/lado; geração de jogadores se
  faltar) e humana (mín. 2 G + 15 de linha).
- Ciclo de 4 anos: Copa (32 times/8 grupos no ano 1, depois 48/16×3), Eliminatórias das 6
  confederações (incl. repescagem), Euro, Copa América, Copa Africana/Asiática, Gold Cup, OFC,
  Liga das Nações, Finalíssima; datas SEL/ELIM/LNAC/FINALIS; recuperação de energia nesses dias.
- Técnico de seleção: ofertas por reputação, acumular clube + seleção, amistosos da seleção.

### Fase 10 — Front-end Avalonia (spec-telas)
Shell com navegação lateral persistente (melhoria sobre os popups do original), tema escuro/claro
com as cores do clube, escudos/camisas/bandeiras via `IAssetProvider` (fallbacks do original).
| Área | Telas |
|---|---|
| Início | Launcher (novo/carregar/editor), configurar jogo (ligas, estaduais, regionais, internacionais, seleções, salário, sistema de força, ano), escolher time e técnico, carregar/salvar |
| Hub do time | Painel do clube (caixa, mensagens, confiança, próximo jogo), elenco (DataGrid ordenável com colunas do original), cartão do jogador, menu de contexto (contrato, vender, aposentar, número, histórico, empréstimo) |
| Escalação | Campo com arrastar-e-soltar nos 25 slots + banco, formações, estilo/marcação/jogada, capitão/batedores/falso 9, táticas salvas, camisa 1-3 |
| Dia de jogo | Ao vivo (placar em foco, ticker por competição, velocidades `rz/rA`, sons, abre táticas/substituições, intervalo), pênaltis (escolher batedor, ordem da disputa), resultados da rodada (detalhes, estatísticas, notas, time da rodada) |
| Mercado | Procura com filtros, navegador de times (árvore país/liga), proposta, venda (preço fixo/leilão), leilões, ofertas recebidas, empréstimos |
| Clube | Juniores, estádio/preços/obras, finanças/empréstimo, treino, cores, numeração, mensagens, calendário/amistosos, retrospecto |
| Competições | Tabelas (nacionais/internacionais/estaduais/seleções/regionais), rodadas, estatísticas |
| Histórico | Campeões, artilheiros (+ hall da fama), assistências, rankings clubes/seleções/técnicos, galeria de troféus, time do ano, Bola de Ouro, transferências, trocas de técnicos, confrontos |
| Carreira | Ofertas/Central de empregos, demissão, fim de temporada, "É campeão!" |
| Seleção | Convocação, calendário e amistosos da seleção |
| Preferências | Velocidades, sons, janela de substituição, autosave, contratos, exibição de rodadas sem humanos, tema |
- Áudio: `ISoundPlayer` (WAVs da instalação) com implementação multiplataforma leve.
- Pasta de dados: detectada (`brasfoot-linux`) ou escolhida no primeiro uso e guardada nas preferências.

### Fase 11 — Editor de times
Tela Avalonia com os campos do `d/n` original (time: nome, arquivo, estado, país, estádio, capacidade,
técnico, reputação, nível, cores; jogador: nome, país, posição, lado, idade, características, estrela,
top mundial; transferir). Gravação em formato próprio (JSON "overlay" sobre a instalação) para não
alterar os `.ban` originais; `WorldLoader` aplica o overlay.

### Fase 12 — Empacotamento
`dotnet publish` self-contained single-file para linux-x64 e win-x64; `.desktop` + ícone (reusar o
script `build-linux-port.sh` como referência).

## Ordem sugerida de entrega
1 → 2 → 3 → 4 (temporada nacional jogável no CLI) → 5 → 6 → 7 (carreira multi-temporada no CLI) →
10 em paralelo a partir da Fase 4 (telas do dia de jogo primeiro: hub, escalação, ao vivo, resultados,
tabelas) → 8 → 9 → 11 → 12.

## Verificação
- **Unitários por algoritmo** com exemplos numéricos das specs (como `EconomicsTests`): gerador de
  rodadas (cada par se enfrenta o nº certo de vezes, mandos equilibrados), desempates, cruzamentos de
  KO, acesso/rebaixamento, prêmios, bilheteria, evolução semanal, confiança/demissão, vagas continentais.
- **Simulação headless de temporadas** (`brasfoot temporada --anos 3 --seed N` e teste xUnit): invariantes
  — todo jogo agendado é jogado, cada time joga o nº esperado de partidas, campeões definidos em todas
  as competições, contagem de acessos = rebaixamentos, elencos entre limites, caixa = soma do livro-caixa,
  nenhuma exceção em 10 temporadas com Brasil+Espanha+internacionais+seleções.
- **Paridade estatística** (modo `FixOriginalBugs=false`): comparar distribuições (gols/jogo, % mandante,
  cartões, valores de mercado) com as do original; opcionalmente usar o harness headless do próprio jogo
  (`best.h.main`, rodando no JRE 8 do port) para gerar números de referência.
- **Save/load**: ida-e-volta de um jogo no meio da temporada gera estado idêntico (hash do JSON).
- **App**: rodar `dotnet run --project src/Brasfoot.App`, criar jogo, jogar uma rodada ao vivo, fazer uma
  transferência, salvar/carregar, avançar até o fim da temporada.
