# Brasfoot 22-23: Screens, Menus and Asset Inventory, Behavioral Specification
Source: CFR-decompiled jar at `re/decompiled/`. All refs are `path:line` relative to that directory.

> Scope and method: every top-level window, dialog, and reusable panel reachable from the main
> flow (`best/h2.java` entry point) is inventoried below, grouped by game area. Claims marked
> `[OBS]` were read from decompiled bytecode; `[INF]` are reasonable inferences from surrounding
> structure (label text is baked into PNGs, button semantics are inferred from the action handler
> that opens a known screen, etc.). Obfuscated class/field names are kept verbatim in `code`;
> a human-meaningful name is given on first mention. Assets are cited by listing the referenced
> resource strings/files, not by pixel inspection.

---

## 1. Launcher and configuration (`best/h2.java`, `best/n.java`, `a/gq.java`)

### 1.1 Entry point

`best.h2.main()` is the modern entry point `[OBS] best/h2.java:23`. Startup sequence:

1. Installs a default uncaught-exception handler `[OBS] best/h2.java:25`.
2. Installs the **Nimbus** Look & Feel when available `[OBS] best/h2.java:27-38` (falls back silently on failure).
3. Calls `h2.mg()` (splash bootstrap), then `new M(true)`, then `n.cU()` (initializes the country list) `[OBS] best/h2.java:51-53`.
4. Builds the launcher `new gq()`, packs it, forces `setSize(532, 300)`, centers it, shows it `[OBS] best/h2.java:54-58`.
5. Loads the seven sound files through `c.a.vH()` `[OBS] best/h2.java:59`, `[OBS] c/a.java:64-74`.

`best/h.java` is the legacy Metal-era main class (same launcher) and is also what the launcher
switches the L&F back to; the L&F switcher lives in `best.n.g(String)` `[INF] best/h.java`, `[OBS] best/n.java:65-91`.

### 1.2 Launcher window (`a/gq.java`)

An **undecorated JFrame titled "Brasfoot"** `[OBS] a/gq.java:46-47`, icon `icon16.png`, registered-copy
button icon `iconreg.png` `[OBS] a/gq.java:40,49`. The whole surface is one absolute-layout panel whose
background is `zM` = `tela_inicial.jpg` stretched to `532x300` `[OBS] a/gq.java:59,112-123,150-151`.

Five transparent hotspot `JLabel`s are overlaid. Their positions from the menu art `[OBS] a/gq.java:124-147`:

| Field | Hotspot (x,y,w,h) | Hand cursor | Action `[OBS] a/gq.java:63-67` and handlers |
|---|---|---|---|
| `aft` (Novo Jogo) | `(30,110,140,90)` `a/gq.java:136` | yes | `gr` → `mi()` `a/gq.java:159-161` |
| `afx` (Carregar) | `(210,110,140,90)` `a/gq.java:133` | yes | `gu` → `pW()` `a/gq.java:179` |
| `afs` (Editor) | `(370,110,140,90)` `a/gq.java:139` | yes | `gs` → `rN()` `a/gq.java:167-169` |
| `afu` ("REGISTRAR JOGO") | `(10,210,230,80)` `a/gq.java:126-127` | yes | `gt` → `rP()` `a/gq.java:171-173` |
| `afw` (Sair) | `(420,260,80,30)` `a/gq.java:147` | yes | `gv` → dispose |

The labels themselves are transparent hot zones over the image; the visible texts ("Novo Jogo",
"Carregar", "Editor", "REGISTRAR JOGO", "Sair") are painted in the JPEG `[INF]`. A white
"versão não registrada" label is drawn at `(310,30,150,20)` and hidden on registered copies
`[OBS] a/gq.java:57-62,143-144,84-87`.

Handler semantics (observed):

- `mi()` — Novo Jogo: `new c.a()` (builds game state), `p.dd()`, Metal L&F, then `new S(true)` (the main shell) or `S.aY(0)` if it already exists; disposes the launcher `[OBS] a/gq.java:89-99`.
- `pW()` — Carregar: switches to Metal L&F and opens the load dialog `S.cX()` (→ `dN`) `[OBS] a/gq.java:70-74`.
- `rN()` — Editor: Metal L&F, `n.cV()`, `n.cW()` which constructs and shows the standalone `d.n` editor; the launcher hides `[OBS] a/gq.java:76-82`, `[OBS] best/n.java:93-113`.
- `rP()` — REGISTRAR JOGO: ensures `S` exists (`new S(false)` for an unregistered session) and switches to screen `7` (`da`, the registration screen); disposes the launcher `[OBS] a/gq.java:101-109`.

### 1.3 Session-level configuration

- `c.a` (game singleton): constructs `best.f` (main game state) and `best.ay` (season engine) `[OBS] c/a.java:55-62`.
- Registered-copy gate: `c.a.vL()` returns `ST >= 1920` `[OBS] c/a.java:289-290`. The unregistered-region message seen in config/team-setup screens is the HTML string at `a/hU.java:492` (`[OBS] a/bV.java:421`). "REGISTRAR JOGO" flows to `S.aY(7)` → `da` `[OBS] a/gq.java:101-104`.
- Preferences object `est.Options` is auto-created lazily and persisted to `<user.dir>/options.bcf` `[OBS] c/a.java:57-58,206-230`; see §11.
- Saves live under `<user.dir>/sav/`: `<name>.s22` (Kryo `writeClassAndObject` of the game state snapshot), `<name>.sbck` (backup copy), `<name>.info` (Java-serialized `InfoArquivoSalvoType`), plus a legacy `.sb19` load path `[OBS] c/a.java:95,130-145,164-171,245,267`.

---

## 2. Club office / hub (`a/eg.java`)

The hub is the main in-game screen, mounted as `best.S.aY(2)` with preferred size `(gS, gT)`
(the usable screen size, see §14) `[OBS] best/S.java:133-138`. It is also reachable as
`S.iF()` for cross-screen access `[OBS] best/S.java:207-209`.

### 2.1 Toolbars

Primary button row `[OBS] a/eg.java:1946-2102` (field — icon resource — meaning):

| Field | Icon | Screen opened (see callers) |
|---|---|---|
| `HR` | `icon02.png` | Agenda (scheduled matches) `[INF]` |
| `afl` | `icon04.png` | Seleção / call-up `[INF]` |
| `HS` | `icon04.png` | Tabelas (`S.b(int,at)` → `a.al`) `[INF]` |
| `HV` | `icon05.png` | Estádio (`cl`) `[INF]` |
| `HW` | `icon09.png` | Juniores (`ds`) `[INF]` |
| `Ib` | `icon06.png` | Times (`S.a(ah,ah,boolean)` → `iA`) `[INF]` |
| `Id` | `icon03.png` | Treino (`iQ`) `[INF]` |
| `yY` | `icon07.png` | Procura de jogadores (`gx`) `[INF]` |
| `Ia` | `icon08.png` | Técnicos (`gX`) `[INF]` |
| `HZ` | `iconhistoria.png` | História (`hC`/`aL`) `[INF]` |
| `HX` | `icon01.png` | "Opções" `[OBS] a/eg.java:2051` |
| `HU` | `tactics.png` | "Escalar Time" `[OBS] a/eg.java:2069`, opens `bz` |

Secondary row `Iv` (with explicit tooltips) `[OBS] a/eg.java:1794-1800`:

- `HT` "Cores da tela" (theme colors),
- `Ie` "Galeria de troféus" (`di`),
- `HY` "Retrospecto do time" (`aL`),
- `Ic` "Jogadores emprestados" (`bs`).

Toolbar action wiring is one listener class per button `[OBS] a/eg.java:993-1015`. A second mini-row
uses `save1.png`, `iconsetup.png`, `iconfire.png` (save / options / sim-fire) `[OBS] a/eg.java:1375-1389`.

### 2.2 Left club panel and status widgets

- Club crest `yt` = `escudo.png` `[OBS] a/eg.java:1911`, `zb` = `iconretrospecto.png` `[OBS] a/eg.java:1912`.
- Money balance `Iw` is formatted money, e.g. "5 milhões 200 mil" (UI default) `[OBS] a/eg.java:709,1927`; `n03.png`/`n04.png` badge icons `[OBS] a/eg.java:1926,1930`.
- Squad count `Ef` shows `<filled>/35` `[OBS] a/eg.java:724`, icon `ic_small_player.png` `[OBS] a/eg.java:2074`.
- The rest of the club panel (manager name, position, confidence, next opponent, message list) is populated from state; field names `ze`, `Bj`, `Hf`/`Ig`, `vz`, `wf` `[INF] a/eg.java`.
- Player list is a table `Iy` plus a reusable player-card component `m` (`If`, constructed at `a/eg.java:1883`).

### 2.3 Hub-launched dialogs (observed creation sites)

| Dialog | Created at | Notes |
|---|---|---|
| `cW` Finanças | `a/eg.java:1142 qT()` | takes `S` shell |
| `iQ` Treino | `a/eg.java:1164 qU()`, `new iQ` at `a/eg.java:1171` | |
| `gx` Procura | `a/eg.java:1183 dn()` | player search |
| `ds` Academia de Juniores | `a/eg.java:1264` | |
| `bz` Escalação pré-jogo | `a/eg.java:1285` (`new bz(jDialog, zu, c.a.SR.bl(), yp)`) | §3 |
| `cl` Estádio (preços) | `a/eg.java:1306` | §6 |
| `iA` Browser de times | `S.a(ah,ah,boolean)` `[OBS] best/S.java:464-488` | §6 |
| `dz` Leilão | `a/eg.java:1054` and `S.aY(8)` `[OBS] best/S.java:161-164` | §5 |
| `bs` Jogadores emprestados | `a/eg.java:1068` | §5 |
| `bn` Central de Mensagens | `a/eg.java:1646` | §6 |
| `aL` Jogos na temporada | `a/eg.java:1555` | §8 |
| `hC` Últimas transferências / trocas | `a/eg.java:1568`, also `a/iA.java:306` | §8 |
| `hc` Ranking de clubes | `a/eg.java:1581` | §8 |
| `jv` Ranking de seleções | `a/eg.java:1594` | §10 |
| `y` Líderes de assistências | `a/eg.java:1607` | §8 |
| `o` Artilheiros | `a/eg.java:1620` | §8 |
| `R` Campeões | `a/eg.java:1633` | §8 |
| `gX` Ranking de técnicos | `a/eg.java:1673`, also `a/iA.java:292` | §8 |
| `ce` Numeração | `a/eg.java:945` | §6 |
| `fw` Salvar arquivo | `a/eg.java:1755` | §9 |

### 2.4 Keyboard shortcuts

The hub registers (via `InputMap/ActionMap on FOCUSED_WHEN_ANCESTOR`) `Enter`/`Space` (open),
`F2 god-mode`-style screen, `F3`, `F4`, `F6`..`F11`, `Ctrl+T`, `Ctrl+F`, mapped to single-method
action classes `eh/es/eD/eO/eZ/fk/ft/fu/fv/ei/ej/ek` `[OBS] a/eg.java:352-381`.

### 2.5 In-hub popups

Message/choice popups `Hx`, `afi`, `Hy`, `Hz`, `HA`, `HB` are dynamic dialogs built in
`AL()`, `AM()`, `rb()` `[INF] a/eg.java`. The coach-dismissal prompt is a `JOptionPane.showConfirmDialog`
"deseja ser demitido do <clube>" with title "Pedido de demissão", which the hub and result screen share
`[OBS] a/hk.java:331`.

---

## 3. Line-up and substitutions (`a/bz.java`, `a/il.java`, `a/cD.java`)

### 3.1 Pre-match line-up (`a/bz`)

Opened from the hub "Escalar Time" `[OBS] a/eg.java:1285`. It is a pitch editor:

- Tactical combo boxes, with labels `[OBS] a/bz.java:929-939`:
  - "Seleção Automática:"
  - "Estilo de jogo:" (populated from `aq.rC` "Equilibrado/Ataque total/Contra-ataque" `[OBS] best/aq.java:545`)
  - "Marcação:" (from `aq.rE` "Leve/Pesada/Muito pesada" `[OBS] best/aq.java:547`)
  - "Concentrar ataques:" (from `aq.rD` "Pelo meio/Pelas laterais" `[OBS] best/aq.java:546`)
- Buttons: "Jogar >>" (`ball.png`), "<< Voltar ao time" (`home.png`), "táticas salvas" (`tactics.png`) `[OBS] a/bz.java:920-927`.
- Pitch canvas uses `campo.png` for the base and per-pitch-type icons from `aq.pc` (`campo2/campo/campo3/campo4`) `[OBS] a/bz.java:188,914`, `[OBS] best/aq.java:109`.
- Shirt 40px icons `camisat40.png` used for player slots `[OBS] a/bz.java:944-952`; `alpha.png` is the kit-blend overlay `[OBS] a/bz.java:158`.
- Player cards can flag a "Falso 9" toggle `[OBS] a/bz.java:712-714`.
- Saved tactics: "escalação padrão" label `[OBS] a/bz.java:911`; the tactics-save list is `il`, created from `bz` at `a/bz.java:692`.

### 3.2 In-match substitutions (`a/cD`)

Opened from the match screen at halftime/full-time `[OBS] a/dV.java:871`, dialog `966x726` `[OBS] a/dV.java:873`:

- Shirt icons `camisav/g40/r40.png`, pitch `campo.png`, bench `campobanco1.png`, "Voltar ao jogo" button with `ball.png` `[OBS] a/cD.java:80-83,937-949`.
- Header "Substituições restantes: N" `[OBS] a/cD.java:205`.
- Three combos `Do/Dp/Dn` bound to `aq.rC` (estilo), `aq.rE` (marcação), `aq.rD` (concentração), read/written through `zu.kj()[1..3]` `[OBS] a/cD.java:798-813,723-725`.
- "Falso 9" toggle dynamic `[OBS] a/cD.java:318-320`.
- Preview text at kickoff: "Primeiro jogo: X x Y" for a two-legged tie `[OBS] a/cD.java:772`.

---

## 4. Match day (`a/dV.java`, `a/C.java`, penalties `a/gh`, `a/gb`, `a/bg`, results `a/hk.java`)

### 4.1 Live match (`a/dV`)

Main shell screen `S.aY(4)`, `1024 x gT` `[OBS] best/S.java:142-146`. Static singleton shell `Br`.

- Events are rendered per-competition through the ticker list `vK` (list of `components.v` wrappers, each wrapping a match `best.I`); rows are built when a human game starts `[INF] a/dV.java:183-244`, `[OBS] static init a/dV.java:117-129`.
- Keyboard `[OBS] a/dV.java:156-174`:
  - `F1`..`F6` → speed presets (`dY/dZ/ea/eb/ec/ed`); the speed arrays differ for human vs non-human games: `aq.rz = {2000,1200,700,450,220,100}` ms vs `aq.rA = {1200,700,300,100,70,30}` ms `[OBS] best/aq.java:542-543`.
  - `Space`/`Enter` → `dW` (pause/advance).
- Scoreboard reads the "human score" when a game wraps `components.v` `[OBS] a/dV.java:775-784`.
- Interval / end-of-match windows open the subs dialog §3.2 and the penalty mini-games §4.2.
- Sounds: `Clip[] He` of size 7 `[OBS] a/dV.java:96,128`, fed by `c.a.dj(n)` file handles `[OBS] c/a.java:76-88`; each `new bg/gh/gb/C` punch-out replays a clip `[OBS] a/dV.java:539-586`.
- Window chrome drawn by the game: `panelh.png` header backdrop `[OBS] a/dV.java:1013`, club crests `escudo.png` `[OBS] a/dV.java:975-977`.

### 4.2 Penalty shootouts

Three-step punch-out sequence inside `dV` `[OBS] a/dV.java`:

1. `bg` — full shootout bracket board, dialog `469x602` `[OBS] a/dV.java:485-494`; kicks are chosen via a grid and the board text flips "Gol!!!"/"Perdeu!" `[OBS] a/bg.java:156-158,316-322`.
2. `gh` — "Penalty - escolha do batedor" taker chooser, dialog `400x350` `[OBS] a/gh.java:106,109`, `[OBS] a/dV.java:788-801`.
3. `gb` — "Penalty" / "Prepara-se" kicker-facing animation window, dialog `402x202` `[OBS] a/gb.java:203,208`, `[OBS] a/dV.java:803-814`.
4. The kick execution view `C` (aiming pane) is `500x519` `[OBS] a/dV.java:497-508`.

In-game penalties use the "Penalty" takes a decision option value `getVerDecisaoPenNaoHumano()` for auto-skip `[OBS] a/dV.java:514-519`.

### 4.3 Result / "fim de jogo" (`a/hk`)

Main shell screen `S.aY(5)`, `1024x748` `[OBS] best/S.java:147-151`.

- Match rows are `components.V` list items inside a table `DG`; competition selector combo `va` `[INF] a/hk.java:146`.
- Per-row stats labels: "finalizações", "erros passes", "posse de bola", "no gol (fora)", with mirrored home/away numeric labels `[OBS] a/hk.java:940-979`.
- Bottom toolbar icons: `iconsetup.png` (options), `icon04.png` (tabelas), `player_shirt_green.png` (Time da Rodada), `iconfire.png` (sim forward) `[OBS] a/hk.java:1035-1042`.
- Primary action `Continuar >>` at `(870,670,140,40)` `[OBS] a/hk.java:927-928`.
- Team dismissal confirm shares the hub's JOptionPane `[OBS] a/hk.java:331` (§2.5).

---

## 5. Transfer market

| Screen | Class | Launcher | Labels (Portuguese, observed) |
|---|---|---|---|
| Procura de jogadores | `gx` | hub `dn()` `a/eg.java:1183` | "Procurar" `a/gx.java:316`, "Resetar filtros" `a/gx.java:313`, empty/found counts `a/gx.java:185-187` |
| Leilão de jogadores | `dz` | hub `dz` `a/eg.java:1054`; `S.aY(8)` `best/S.java:161-164` | offer validation messages: "Sem dinheiro para essa oferta", "valor inválido", "Não há vagas no time", "Oferta maior que seu dinheiro em caixa" `a/dz.java:186-215` |
| Venda em leilão | `iX` | auction panel `an` `components/an.java:72` | "Venda de jogador em leilão" `a/iX.java:232`; "valor inválido", "lance maior que valor em caixa" `a/iX.java:146-161` |
| Definir preço | `jc` | selling flow `[INF]` | "Preço inicial: (em milhares de $)" / "Iniciar leilão", or "Preço fixado: (em milhares de $)" / "Fixar preço" `a/jc.java:63-67` |
| Proposta recebida | `jm` | offer flow `[INF]` | "Oferta de compra" `a/jm.java:121` / "Proposta de empréstimo" + "Aceitar" `a/jm.java:79-81` |
| Proposta pelo jogador | `cz` | buy flow `[INF]` | "Proposta pelo jogador", "Valor maior que dinheiro em caixa", "valor inválido" `a/cz.java:80-190` |
| Novo contrato | `fy` | contract renew `[INF]` | "Novo contrato", "Nome do Jogador", "Duração:", "Novo salário:" `a/fy.java:142-152` |
| Empréstimos | `bs` | hub `bs` `a/eg.java:1068` | "Seus jogadores emprestados em outros times", "Jogadores emprestados no seu time", "limite de empréstimos: X/10", "vagas disponíveis: X/4" `a/bs.java:185-204` |
| Empréstimo bancário | `cW` | hub `qT()` `a/eg.java:1142` | "Empréstimo bancário", "Pegar 500 mil", "Pagar 500 mil", "limite máximo alcançado" `a/cW.java:160,208-228` |
| Academia de Juniores | `ds` | hub `a/eg.java:1264`; team browser `a/iA.java:321` | "Academia de Juniores", "Promover", "Dispensar", "Propor compra" `a/ds.java:259-271` |

Finances bar at the top of the hub club panel: "Finanças - <saldo total>" `[OBS] a/cW.java:57`; bank
state "Dinheiro em caixa / Valor já emprestado / Juros mensais" `[OBS] a/cW.java:71-73`.

The auction is also a modal screen of the shell: `S.aY(8)` creates `dz` at `941x718`
`[OBS] best/S.java:161-164`.

---

## 6. Club business, stadium and staff

### 6.1 Team browser (`a/iA`)

Opened by `S.a(ah, ah, boolean)` `[OBS] best/S.java:464-488` (also used for transfers between clubs).
Size adapts to screen: `1024x718` baseline, `1200x740` on ≥1366px-wide/≥768px-tall displays
`[OBS] best/S.java:470-477`. Contains:

- A `JTabbedPane` with tabs **"Info"** and **"Carreira"** `[OBS] a/iA.java:611,655-657`.
- Info tab: club name + position `a/iA.java:437`, manager name or "interino" `a/iA.java:578-580`, reputation `aq.pZ` `a/iA.java:582`, country and state `a/iA.java:584-588`, money `a/iA.java:560,576`, and "Valor do elenco: <amount>" `a/iA.java:601`.
- Also reachable from here: `hC` (history) `a/iA.java:306`, `ds` (juniores) `a/iA.java:321`, `gX` (manager ranking) `a/iA.java:292`.

### 6.2 Stadium (`cl` prices, `cq` expansion)

- Ticket prices screen `cl` (hub `a/eg.java:1306`): suggested prices "10000" defaults, "Usar sempre os preços sugeridos" `[OBS] a/cl.java:183-202`.
- Expansion `cq` opened from `cl` `[OBS] a/cl.java:153`: "Expansão do estádio", "Digite o número de lugares para construir:", "Custo total:", "Pedir Orçamento" `[OBS] a/cq.java:211-224`.

### 6.3 Numbers (`ce`)

"Selecione um jogador:" + "escolher"; errors "Número já escolhido"/"Selecione um jogador" `[OBS] a/ce.java:137-140,238-239`. Hub launcher `a/eg.java:945`.

### 6.4 Training (`iQ`) and staff

- "Treino" panel with "Foco do treino semanal:", "Habilidades principais", "Habilidades secundárias" `[OBS] a/iQ.java:82-95` (hub `qU()` `a/eg.java:1164-1171`).
- Dismissals "Demissões na Rodada" dialog `bl` via `S.K(ArrayList)` `608x304` `[OBS] best/S.java:254-265`.
- "Central de Mensagens" `bn` (hub `a/eg.java:1646`): "Deseja multar esse jogador em 10% do salário?", "Multado!", "Não Multar" `[OBS] a/bn.java:102,163,183-194`.

### 6.5 Regionals / internationals invites

- Regional invitation `fZ`: choices "Rio-São Paulo", "Sul-Minas", "Copa do Nordeste" `[OBS] a/fZ.java:64-76` (from config `a/hU.java:288`).
- Internationals setup `do`: "Quando possível usar grupos reais", "Sul-Americana", "Primeira Temporada", "Sem times humanos ver jogos:" `[OBS] a/do.java:86-97` (from config `a/hU.java:274`).

---

## 7. Competitions (`a/al.java`, `a/ay.java`, `a/aa.java`, `a/cw.java`, `a/dG.java`)

### 7.1 "Classificação e jogos" (`a/al`)

Opened by `S.b(int, at)` — `883 x min(800, gT)` `[OBS] best/S.java:382-397`. Title
"Classificação e jogos - <year>" `[OBS] a/al.java:177`. Type toggles (national / international /
state / selections / regionals) are the fields `uY/uX/uW/uZ/vi` `[INF] a/al.java`. Phase labels
depend on competition type: "tabela ainda não sorteada", "1ª fase", "2ª fase", "Fase única",
"Repescagem", "Fase Preliminar"/"R1", "Oitavas", "Quartas", "Semi-Final", "Final"
`[OBS] a/al.java:528-560,601-821`. Knockout rounds use `aq.ps` phase names
`[OBS] best/aq.java:126`.

### 7.2 "Tabelas, rodadas, estatísticas" (`a/ay`)

Opened by `S.a(int, at)` — `833x735` `[OBS] best/S.java:369-380`. Fills standings, round bumper,
biggest-win and top-scorer panels, showing placeholder texts "(ainda não definido)",
"(ainda não há jogos)", "(ainda não há goleadas)" `[OBS] a/ay.java:332-353`.

### 7.3 Group standings (`a/aa`)

"Classificação e jogos" group panel with buttons "<< Fase Anterior" / "Próxima Fase>>" and
phase/round labels ("1ª fase", "1ª rodada", "Oitavas de final") `[OBS] a/aa.java:329,541,619-635`.
Built from the group-phase navigation component `bu` `[OBS] a/bu.java:56`, and reused as a
table-cell renderer `[OBS] a/C.java:107`.

### 7.4 League configuration (`cw`, `dG`)

From the config screen (`a/hU.java:305,324`):
- "Configurar Ligas - Brasil - 120 times", division combo labels "1ª/2ª/3ª divisão" `[OBS] a/cw.java:175-187`.
- "Configurar Ligas" variant with "Salvar", "Cancelar alterações", "Usar novo formato na Copa BRA" `[OBS] a/dG.java:199-211`.

---

## 8. History and records

| Class | Title / labels (observed) | Launched by |
|---|---|---|
| `di` | Club trophy gallery, `886 x {219,399,579,762}` depending on `pG()` (trophy count) `[OBS] best/S.java:346-367` | hub "Galeria de troféus" (`Ie`) |
| `dg` | "Galeria de Trofeus Técnico" `971x646` `[OBS] a/dg.java:228-239`, `[OBS] best/S.java:399-410` | `S.e(al)` (manager trophies) |
| `aL` | season matches list (huge-win / stats mode); "0 jogos" empty state, "mostrar" toggle `[OBS] a/aL.java:207-286` | hub `a/eg.java:1555` |
| `hC` | "Últimas trocas de técnicos" / "Últimas transferências de jogadores" `[OBS] a/hC.java:48,163` | hub `a/eg.java:1568`, browser `a/iA.java:306` |
| `L` | "Calendário - <club>" fixed fixture list `[OBS] a/L.java:230` | selection context `a/jv.java:167` |
| `R` | "Campeões" `[OBS] a/R.java:237` | hub `a/eg.java:1633` |
| `o` | "Artilheiros", "mostrar todos >>", "Melhores de sempre de todas competições" `[OBS] a/o.java:238-313` | hub `a/eg.java:1620` |
| `y` | "Líderes de assistências" `[OBS] a/y.java:165` | hub `a/eg.java:1607` |
| `gX` | "Ranking de Técnicos", column "Técnico" `[OBS] a/gX.java:287-297` | hub `a/eg.java:1673`, browser `a/iA.java:292` |
| `hc` | "Ranking Clubes", "troféus e títulos" `[OBS] a/hc.java:299-319` | hub `a/eg.java:1581` |
| `jv` | "Ranking de Seleções" `[OBS] a/jv.java:220` | hub `a/eg.java:1594` |

"Retrospecto" (`HY`) maps to the `aL` family (`a/eg.java:1555` takes the club + opponent).

---

## 9. Season flow: save/load/register, end of season, friendlies (`da`, `dN`, `fw`, `hz`, `cR`, `jH`, `h`, `d`)

### 9.1 Screens of the shell (`best/S.java`)

| `S.aY(n)` | Screen | Size |
|---|---|---|
| 0 / 3 | `hU` Configurações iniciais (both entry and "voltar" reuse the same panel) `best/S.java:126-129,139-141` | shell |
| 1 | `bV` escolha de time/técnicos `best/S.java:130-132` | shell |
| 2 | `eg` hub (pref size `gS x gT`) `best/S.java:133-138` | shell |
| 4 | `dV` match `1024 x gT` `best/S.java:142-146` | shell |
| 5 | `hk` results `1024x748` `best/S.java:147-151` | shell |
| 6 | `cR` end-of-season `1024x718` `best/S.java:152-156` | shell |
| 7 | `da` "registrar jogo" `941x718` `best/S.java:157-160` | shell |
| 8 | `dz` leilão `941x718` `best/S.java:161-164` | shell |
| 10 | `jH` friendly tournament `742x577` `best/S.java:165-168` | shell |

`S.aZ(n)` swaps the shell content pane (optionally inside a `JScrollPane` when `gJ`) and re-runs
`on()` for `bV`/`eg`/`hk` `[OBS] best/S.java:180-201`; `gJ` toggled via `S.iI()` `[OBS] best/S.java:494-496`.

### 9.2 Config start (`a/hU`)

Labels `[OBS] a/hU.java:383-492`:
"Configurações iniciais", "Brasfoot", " Ligas Nacionais" / "configurar", "Competições internacionais",
"Jogar competições de seleções", "Jogar taças internacionais de clubes", "Preferências",
"Usar grupos da Copa do Mundo 2022", " Estaduais / configurar / Jogar regionais / Regionais / Jogar estaduais",
"Sistema de salários:" "Mensal"/"Semanal", "Sistema de força dos jogadores:" "Modo clássico"/"Individual",
"Temporada de início", "<< Voltar ao início", "Iniciar Jogo >>", plus the unregistered-copy HTML banner `a/hU.java:492`.
Hosts the season-config dialogs: `do` (`274`), `fZ` (`288`), `cw` (`305`), `dG` (`324`).

### 9.3 Team/manager setup (`a/bV`)

Labels `[OBS] a/bV.java:124-433`: dynamic "Adicionar técnico humano N", "Treinar time do país:",
"1ª/2ª/3ª/4ª divisão:" (or "Jogando estaduais:"), "Nome:", "Nacionalidade:", "Time selecionado:",
"Aleatório"/"Escolher um time aleatório", "Iniciar Jogo >>", "Adicionar e incluir outro",
plus the unregistered warning `a/bV.java:421`.

### 9.4 End of season (`a/cR`)

"Fim da temporada" with action rows "Nacionais", "Internacionais", "Regionais/estaduais"
`[OBS] a/cR.java:296-305`.

### 9.5 Registration (`da`), load (`dN`), save (`fw`), splash (`hz`)

- `da` is `S.aY(7)` `[OBS] best/S.java:157-160`; "REGISTRAR JOGO" path enters it directly `[OBS] a/gq.java:101-108`.
- `dN` load dialog `407x354`, opened by `S.cX()` `[OBS] best/S.java:280-291` and by the launcher `[OBS] a/gq.java:70-74`.
- Save-to-file `fw` from the hub `[OBS] a/eg.java:1755`.
- Modal splash `hz` `353x103`: "Carregando..."; long-save note "Salvando jogo... isso poder demorar um pouco..."
  `[OBS] best/S.java:293-305`, `[OBS] a/hz.java:41,85`; the current splash is exposed by `S.iH()` `[OBS] best/S.java:490-492`.

### 9.6 Friendlies

- Club friendly `h` `565x575` via `S.w(ah)` `[OBS] best/S.java:438-449`: "Marcar amistoso", "Escolha uma data disponível:", "Escolha um adversário:", "Time selecionado:" `[OBS] a/h.java:201-211`.
- National-team friendly `d` `565x575` via `S.x(ah)` `[OBS] best/S.java:451-462` (same labels) `[OBS] a/d.java:180-190`.
- Friendly tournament `jH`: "Torneio Amistoso", "Escolha os participantes:", "Fórmula:", "Iniciar" `[OBS] a/jH.java:323-334`.

---

## 10. National teams

- Call-up screen `aP` `948x706` via `S.a(ah, boolean)` `[OBS] best/S.java:320-331`: "Convocação automática", "Desconvocar todos", empty/count feedback "Nenhum jogador encontrado"/"1 jogador encontrado" `[OBS] a/aP.java:313-315,443-445`.
- Selections ranking `jv` ("Ranking de Seleções") `[OBS] a/jv.java:220`, hub `a/eg.java:1594`.
- The hub top row has the call-up shortcut (`afl`, icon `icon04`) `[INF] a/eg.java:1959`.

---

## 11. Preferences (`est/Options.java`, `a/fB.java`)

### 11.1 Model (`est.Options`)

Persisted to `<user.dir>/options.bcf` `[OBS] c/a.java:206-230`. Defaults `[OBS] est/Options.java:70-93`:

| Field | Default | Meaning |
|---|---|---|
| `autoSalvar` | 0 | auto-save cadence |
| `velocidade` | 4 | human match speed |
| `velocidadeNH` | 4 | non-human match speed |
| `verDecisaoPenNaoHumano` | 0 | penalties without humans |
| `verMudancaTecnicos` | 1 | show coach changes |
| `verJanelaSubs` | 1 | show halftime sub window |
| `avisoTerminoContrato` | 0 | contract-end notice |
| `autoRenovaContrato` | true | auto-renew expired contracts |
| `usaCorPlacar` | true / `corPlacar`=0 | scoreboard colors |
| `usaSons` | true | event sounds |
| `negritoCasa` | true | bold home events |
| `ignoraLigas` / `ignoraEstadual` | true | hide non-human competitions |
| `regionaisSemHumanos` | 0 | regional viewer mode |
| `novoFormatoCopa` | true | new BRA cup format |

Season toggles (start flags): `jogaEstadual`, `jogaRegionais`, `usaGrupoPadraoEstadual`,
`jogaIntClubes`, `jogaSelecoesAll`, `salarioMensal`, `habilidadeIndividual`, `jogaIntano1`
`[OBS] est/Options.java:13-21` (the `blArray[0..20]` mask preserves which national leagues are active
`[OBS] est/Options.java:53-68`).

### 11.2 Dialog (`a/fB`)

`867x620`, opened by `S.a(JTable)` `[OBS] best/S.java:425-436` (the JTable selects the source league
list; also used to edit league rows from the standings). Labels `[OBS] a/fB.java:529-653`:
"Salvar automaticamente:", "Velocidade do Jogo:", "Velocidade sem jogos humanos:",
"Disputas de pênaltis sem humanos:", "Mudanças de técnicos:", "Janela de substituição no intervalo:",
"Aviso de término de contrato:", "Atualizar automaticamente contratos encerrados",
"Cor nos placares humanos:", "Sons nos eventos dos jogos", "Destaque nos eventos do time da casa",
"Usar cores na lista de jogadores", "Tema de cores das janelas:", "Ver leilão de jogadores",
"Visualizar partidas das ligas mesmo sem times humanos:", "Ver só resultados",
"Ver todos os estaduais agrupados", "Fora do Brasil não mostrar estaduais/regionais",
"Não mostrar rodadas das ligas nacionais não-humanas",
"Não mostrar regionais que não tiveram humanos", "Competições sem times humanos:", "Ver partidas",
page arrows "<<" / ">>" `yZ/yV`.

Champion-card dialog `dJ` ("É campeão!", trophy art, `306x413`) is the celebration popup
`[OBS] a/dJ.java:79,107`, `[OBS] best/S.java:215-226`.

---

## 12. Editor (`d/n.java` + `d/b.java` + dialogs `d/ac`, `d/f`)

Standalone JFrame "Editor Brasfoot" created and shown through `n.cW()` `[OBS] best/n.java:103-113`,
reached from the launcher `[OBS] a/gq.java:76-82`. Editor state model `d/ap` (teams), `d/ay` (players).

- Main window: full layout labels (início, sair jogo, adicionar/editar/deletar, Principal/Juniores,
  Procurar time/jogador, escudo, camisas `UR/US/UT`, capacity/level, reputação/Nível)
  `[OBS] d/n.java`.
- The player table has a `JPopupMenu`: **Adicionar Jogador / Editar Jogador / Deletar Jogador / Transferir Jogador**
  `[OBS] d/n.java:438-455`.
- Team dialog `d/ac`: "Adicionar/Editar Time", "Nome:", "Nome do Técnico:", "Nome do Estádio:",
  "Capacidade:", "Nível inicial:", "Reputação:", "Pais do time:", "Estado:", "Cor de Texto:"
  `[OBS] d/ac.java:73-146`.
- Player dialog `d/f`: "Adicionar/Editar Jogador", "Nome:", "Posição:", "Lado:", "Pais:", "Caract:",
  "Idade:", "Top Mundial", "OK" `[OBS] d/f.java:77-164`.
- Serialization `d/b`: team file extension `.b16`/`.b18`, Java `ObjectOutputStream` on `e.t` rows;
  hardcoded team folder `E:/java/Brasfoot2017_editor/teams` `[OBS] d/b.java:31-32,35-76`.
- XML import in `d/b` parses tag sets (`p`,`es`,`nv`,`n`,`e`,`ec`,`t`,`cf`,`ct`,`r`,`cb`,`jog`)
  with attributes `no,s,pa,i,p,t,l,c1,c2,tl,ju` `[INF] d/b.java`.
- Data classes: `e/t` = editable team, `e/g` = editable player `[OBS] e/t.java`, `[OBS] e/g.java`.

---

## 13. Audio and asset inventory

### 13.1 Sounds

Seven WAV files in `<user.dir>/sons/` `[OBS] c/a.java:65,77`:

| Index | File |
|---|---|
| 0 | `intervalo.wav` (half-time) |
| 1 | `fimjogo.wav` |
| 2 | `gol1.wav` (home goal) |
| 3 | `goladv.wav` (away goal) |
| 4 | `penalty.wav` |
| 5 | `expulsao.wav` (red card) |
| 6 | `contusao.wav` (injury) |

Loaded through `c.a.vH()` at startup and `c.a.dj(n)` per event `[OBS] c/a.java:64-88`; the match
screen keeps `Clip[7]` `[OBS] a/dV.java:96,128,539-586`.

### 13.2 Image resources (bundled in jar classpath)

- `/aicons/` — main game icons: `icon01..icon11`, `escudo.png`, `campo.png`, `campo2/3/4.png` (via
  `aq.pc`), `campobanco1.png`, `ball.png`, `home.png`, `tactics.png`, `camisav/g/r/t.png`,
  `camisav/g/r/t40.png`, `alpha.png`, `trsmall.png`, `campeao.png`, `save1.png`, `iconsetup.png`,
  `iconfire.png`, `iconhistoria.png`, `iconcolorpicker.png`, `iconretrospecto.png`,
  `iconemprestados.png`, `ic_small_player.png`, `n03.png`, `n04.png` — cited at the `getResource`
  sites listed in this document (e.g. `a/eg.java:1946-2102`, `a/hk.java:1035-1044`, `a/dV.java:1013`,
  `a/dJ.java:93,107`, `a/bz.java:76-82`, `a/cD.java:80-83`).
- `/aiconsj/` — launcher art: `tela_inicial.jpg`, `iconreg.png`, `panelh.png` `[OBS] a/gq.java:59,49`, `[OBS] a/dV.java:1013`.
- `/aiconsb/` — scoreboard/half tiles `b0..b4.png` (and `results04.png`) `[OBS] a/hk.java:1044`, `[INF]`.
- `/aflags/<país>.png` — country flags, used with `ac.valueof("P<n>")` names `[INF] best/n.java:35-63`.

### 13.3 Shipping asset folders (under `brasfoot-linux/`)

| Folder | Count | Contents |
|---|---|---|
| `img/` | 2 | `f01.jpg`, `f02.jpg` (splash). |
| `sons/` | 7 | the WAVs of §13.1. |
| `trofeus/` | 72 | `tr_*.png` trophy images. |
| `teams/` | 708 | `.ban` club crest files (one per club). |
| `selecoes/` | 3 subfolders | `escudos/`, `camisas/`, `camisas2/` national-team art. |
| `conf_estadual/` | 25 | `*.ces` state-config files for Brazilian UFs (AC..TO). |
| `conf_ligas_nacionais/` | 2 | `BRA.cfg`, `ESP.cfg` league configs. |

`re/assets/` (exported alongside the decompile) holds the same runtime data + `arquivos/names` and
`arquivos/surnames` name lists (444 files total) used for generated player names `[OBS] file inventory`.

---

## 14. Global layout and rendering conventions

- **Everything is an undecorated, modal, non-resizable `JDialog` (or the shell `S` JFrame), each
  holding exactly one `JPanel` fitted to the dialog size.** This is enforced in every `S` factory
  (§1, §9.1) and in `dV`'s punch-outs (§4.2).
- **Absolute layout**: the custom `components.b` `LayoutManager2` places each child at `(x,y)` from
  a `components.a` constraint; a `-1` width/height means "use preferred size"
  `[OBS] components/a.java:10-41`, `[OBS] components/b.java:15-128`. Ports should reproduce this
  coordinate/inset scheme with an equivalent absolute/fixed layout container.
- **Backgrounds/theme**: the shell content uses a solid green `new Color(36,91,45)`; panel
  backgrounds and borders come from `best.aq.E(c.a.vM().getCorTema(), n)`; club colors via `ah.kB()/kC()` `[INF]`.
- **Scroll strategy**: the shell may mount screens inside a `JScrollPane` (`gJ` flag) `[OBS] best/S.java:182-188`.
- **Fonts**: Tahoma sizes 11-14 for UI text; title bars are Tahoma bold; colors are tuned for the
  dark-green/khaki theme (e.g. `Color(44,53,49)` champion panel, `Color(0,51,204)`/`Color(153,0,0)`
  scoreboard slabs `[OBS] a/dJ.java:66-79`, `[OBS] a/hk.java:1009-1025`).
- **Money formatting** `C.c(...)`: "5 milhões 200 mil", "12(10)" shots-on-target notation
  `[OBS] a/eg.java:709,1927`, `[OBS] a/hk.java:975-979`, `[OBS] a/cW.java:71-73`.

---

## 15. Obfuscation map (package `a` and friends)

| Class | Screen / role |
|---|---|
| `a/gq` | launcher window |
| `a/gr..gv` | launcher hotspot mouse listeners |
| `best/S` | shell frame + ~20 static dialog factories |
| `a/eg` | hub/club office |
| `a/m`, `a/wf`, `a/Iy` (fields) | hub player card / club panel / player table |
| `a/hU` | initial configuration |
| `a/bV` | team & coaches setup |
| `a/cR` | end of season |
| `a/da` | register copy |
| `a/dN` | load game |
| `a/fw` | save to `.s22` |
| `a/hz` | modal splash (load/save) |
| `a/dV` | live match; also hosts `a/C` (penalty kick), `a/gh`, `a/gb`, `a/bg` |
| `a/hk` | result / fim-de-jogo |
| `a/bz` | pre-match line-up |
| `a/cD` | in-match subs |
| `a/il` | saved tactics |
| `a/al`, `a/ay`, `a/aa`, `a/bu` | standings, tables, group phases |
| `a/gx` | player search |
| `a/dz`, `a/iX`, `components/an` | auctions |
| `a/jc`, `a/jm`, `a/cz`, `a/fy` | price / offers / contract |
| `a/bs` | loans |
| `a/cW` | finances & bank loan |
| `a/ds` | youth academy |
| `a/iQ` | training focus |
| `a/cq`, `a/cl` | stadium expansion / prices |
| `a/ce` | shirt numbers |
| `a/bn` | message center / fines |
| `a/bl` | weekly dismissals |
| `a/iA` | team browser (Info/Carreira) |
| `a/di`, `a/dg` | trophy galleries |
| `a/gX`, `a/hc`, `a/jv` | manager / club / selection rankings |
| `a/o`, `a/y`, `a/R` | top scorers / assists / champions |
| `a/aL`, `a/hC`, `a/L` | season games / transfers / calendar |
| `a/h`, `a/d`, `a/jH` | friendly / friendly tournament |
| `a/aP` | national-team call-up |
| `a/fB`, `est/Options` | preferences |
| `a/fZ`, `a/do`, `a/cw`, `a/dG` | regional / international / league config |
| `a/dJ` | champion celebration |
| `a/as` | generic message/notice dialog (`new as(club, type, id, name)`) `[INF]` |
| `a/hF` | debug match simulator (`S.iG()`, 799x664) `[OBS] best/S.java:307-318` |
| `d/n`, `d/ac`, `d/f`, `d/b`, `d/ap`, `d/ay`, `e/t`, `e/g` | standalone editor |
| `best/h2`, `best/h`, `best/n` | mains + L&F / editor launch |
| `c/a` | game singleton (state, saves, sounds, registration) |

Supporting data: `best/f` (game state), `best/ah` (club), `best/at` (competition, with
`decisaoTerceiroLugar`), `best/F` (player), `best/I` (match), `best/A` (match event), `best/Z`
(selection/confederation), `best/N` (auction bid), `components/v` (match UI wrapper, `tR()`→`I`),
`components/V` (match row), `best/aq` (string/velocity tables) `[OBS] class reads`.

---

## 16. Quirks and open questions

1. **Launcher labels are baked into art.** The five clickable zones are transparent `JLabel`s over
   `tela_inicial.jpg`; there is no `setText` for "Novo Jogo"/"Carregar"/"Editor"/"Sair" — a port must
   either ship the image or re-compose the menu with real widgets `a/gq.java:124-147`.
2. **Two main classes coexist.** `best.h2` (Nimbus) is current; `best.h` (Metal) still exists, and
   each launcher action that spawns a real window calls `n.g("Metal")`, i.e. the "game windows" run
   under Metal while the shell boots under Nimbus `[OBS] best/h2.java:30-38`, `[OBS] a/gq.java:70-79`.
3. **The editor hardcodes a development path** `E:/java/Brasfoot2017_editor/teams` for its team
   folder (`d/b.java:31-32`) — an unavoidable Windows-machine artifact of the original build.
4. **Two serialization formats for saves**: Kryo `.s22`/`.sbck` for game state plus a Java-serialized
   `.info` manifest, and a legacy `.sb19` read path `c/a.java:95,130-145,171,267`.
5. **Registration is a pixel-size check** `ST >= 1920` (`c/a.java:289-290`): the game infers its
   registration from the graphics device resolution it was started on, rather than from a license file.
6. **Window sizing derives from the usable screen bounds** at first dialog creation
   (`SunGraphicsEnvironment.getUsableBounds`, `S.a(ah,ah,boolean)` `best/S.java:464-477`); hub and
   match screens are then fixed to those measurements.
7. **Duplicate field-name collisions across classes** — e.g. `L` in `a/jv`, `aL` in
   `a/ip`, `aP`/`d` renderers — mean a decompile-level name is not a stable identifier; behavior was
   attributed by dialog title + argument types, not by name.
8. **`a/as` is a single generic popup** used for many in-hub notifications (message boxes built as
   `new as(club, type, id, name)`); its full call-site catalog was not exhaustively collected here
   — a dedicated pass over `new as(` occurrences is still open.
9. **Open question — hub "Agenda" and "Time da Rodada" mapping**: the toolbar row order
   (`icon02..icon09`) is strongly correlated with menu order in the shipped screenshots, but the
   per-button action classes (`ew..eS`) were not each traced to their target screen; several rows in
   §2.1 are marked `[INF]` on that basis.
10. **Open question — penalty arcade parameters**: `a/bg` renders the shootout bracket and results
    ("Gol!!!", "Perdeu!"), but the aiming/timing math lives in `a/C`/`aq` helpers that were not
    deeply inventoried; reconstructing the exact timing feel needs a playback/behavior pass on `a/C`.