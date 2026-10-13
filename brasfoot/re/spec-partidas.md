# Brasfoot 22-23: Match Simulation Engine, Behavioral Specification

Source: CFR-decompiled jar at `re/decompiled/`. All refs are `path:line` relative to that directory.
Obfuscated names are kept in `code` and given a meaningful name (see the mapping table in section 12).

Conventions:
- "side" 0 = home (mandante, `I.fz`), 1 = away (visitante, `I.fA`).
- `rand.nextInt(n)` returns a uniform integer in `[0, n)`. `nextDouble()` returns a uniform value in `[0, 1)`.
- Almost every random draw uses a fresh `new Random()`, which is time-seeded. The engine is therefore not reproducible
  from a seed, and only the probability distributions matter. The possession engine `c/b` owns two long-lived
  `Random`s: `Tn` (weighted picks, kickoff) and `To` (50/50 tackle-vs-misplaced-pass).
- "B-value" means the per-player match strength `c.b.B(F)` (section 3.1). It is roughly 0.1 to 10.

---

## 0. Big picture

```
Matchday (best/f.java:1436-1437)
  ah.kh()                      -> AI teams pick lineup + tactics           (best/ah.java:387, 402)
  I.he()                       -> for every match of the day: I.V()        (best/I.java:345-381)
       I.V(): if NEITHER team is human -> full QUICK simulation (minute loop)
              always: knockout flags, attendance/revenue numbers, quick penalty shootout (AI vs AI)
  [if a human team plays] watched screen a/dV: per tick calls I.q(minute, half) for human matches
       (same per-minute engine, different tick counts, interactive penalties, shootout dialog)
  f.as() post-processing for every match (best/f.java:1477-1517):
       I.hg()  table / head-to-head / team stats / manager confidence
       I.hi()  serve suspensions
       I.hf()  ticket revenue to human home club
       I.hh()  player stats: games, goals, cards -> suspensions, ratings (notas)
       F.fr()  energy recovery for all players
```

The per-minute engine has two independent layers that run on every tick:
1. **Incident layer**, `I.a(I, half, minute)` (best/I.java:517). It handles cards, injuries, fatigue and AI substitutions.
2. **Possession layer**, `c.b.vO()` (c/b.java:126). It handles the midfield duel, attack vs defense, the shot, the goal,
   the goal type, the scorer and the assist.

---

## 1. Data model

### 1.1 Player, `best.F` (best/F.java)

| field | getter/setter | meaning |
|---|---|---|
| `dm` | getNome | name |
| `em` | getIdade/setIdade | age (clamped 16..48, or 16..20 for youth players; default 35/18) (F.java:189-203) |
| `pais` | getPais | nationality id |
| `en` | getPosicao | natural position: 0=G Goleiro, 1=L Lateral, 2=Z Zagueiro, 3=M Meia, 4=A Atacante (`aq.rI`) |
| `er` | getLado | side: 0=Direito, 1=Esquerdo (`aq.rL`) |
| `eq` | `fi()` / `ad()` | **força** (overall strength, roughly 1..100). This is the main match input |
| `ey`,`ez` | getCr1/getCr2 | characteristics, indexes into `aq.qM` (see 1.4) |
| `ex` | `fF()`, computed by `fG()` | tactical role: 0 = defensive, 1 = offensive, 2 = wide forward (F.java:514-526) |
| `eK` | `fp()` / `ai()`, `aj(-)`, `ak(+)` | **energy** 0..100 (init 100). `aj` floors to 1 if it goes negative (F.java:336-348) |
| `eL` | `fs()`/`b(Boolean)` | "played this round" flag (set when put in the XI or subbed on) |
| `ek` | `ff()` / `a(Boolean)` | **Estrela** (star). Forced true if `el` |
| `el` | `gm()` / `j(Boolean)` | **Top Mundial** (world-class) |
| `fb` | `fC()` / `h(Boolean)` | youth player (juvenil). Exempt from career cards/assists |
| `eR` | `fT()` / `as(int)` | **slot** on the pitch (0..25, see 1.3). -1/0 = not on pitch |
| `eI` | `fo()` | injury end timestamp (ms). `fP()` = injured now (F.java:1093) |
| `eJ` | | contract end timestamp |
| `eA,eB,eC,eD,eE,eF,eG` | `gK,gJ,gL,gM,gN,gO,gP` | 7 individual skills (only used if the option "habilidade individual" is on): gK=Goleiro, gJ=Velocidade, gL=Técnica, gM=Passe, gN=Desarme, gO=Armação, gP=Finalização (labels from a/eg.java:530) |
| `es` | `fH()`/`aq()` | potential/"hash" (growth). Not a match input |
| `fg` (transient) | `gi()`, `gj()` ++, `aw(n)` | yellow cards received **in the current match** |
| `fo` (transient) | `gB()` -> `components.s` | per-match stat sheet (1.5) |
| `eN` | `gk()` | last match rating (nota) |
| `eS` | list of `H` | per-competition stats (cards, suspensions, goals, avg rating) |
| `eT` | list of `k` | per-club career stats |
| `eU` | list of `J` | rating history |

`F.gF()` **out of position** (F.java:2909-2924) is true if `fT() <= 0`, or if `aq.sE[slot][0] != getPosicao()`.
Slots 10/17 have a special branch that reduces to the same rule (only Laterais fit there).

### 1.2 Team, `best.ah` (best/ah.java)

| field | getter | meaning |
|---|---|---|
| `mW` | `jZ()` | **controlled by a human** |
| `nc` | getReputacao | reputation 0..5 |
| `hA` | getNivel | level 1..25 |
| `divisao` | getDivisao | division |
| `nd` | `kc()` | squad (elenco) |
| `nq` | `kj()` int[4] | **tactics**: `[0]` formation (index into `aq.sJ`), `[1]` estilo (`aq.rC`: 0 Equilibrado, 1 Ataque total, 2 Contra-ataque), `[2]` marcação (`aq.rE`: 0 Leve, 1 Pesada, 2 Muito pesada), `[3]` jogada (`aq.rD`: 0 Pelo meio, 1 Pelas laterais). UI refs a/cD.java:723-725, 841-843 |
| `nh` | `kd()` | captain (capitão). **Not used by the engine** |
| `ni` | `ke()` | free-kick taker (batedor de faltas). Also takes **penalties** in the engine |
| `nj` | `lq()` | corner taker (batedor de escanteios), used for olímpico goals |
| `nk` | `lr()` | "falso 9" marker. **Not used by the engine** |
| `dH` | `ev()` | home stadium `best.v` |
| `nb` | `kb()` | cash (`v(n,cat)` adds, `w(n,cat)` subtracts) |
| `mZ` | `ka()` | manager/coach `best.al` |
| `nv` | `kf()`/`I(bool)` | "lineup already set this round" |

Menu labels confirming ke/kd/lq/lr: a/bz.java:192-206, 722-744.

### 1.3 Pitch slots (`fT()` values, 1..25) and formations

`aq.sE[slot] = {position, side, row}` (aq.java:660-725). Side: 1/0/-1(any). Row: 0 = defensive, 1 = offensive, 2 = wide, -1 = any.

| slot | role |
|---|---|
| 1 | Goleiro (GK) |
| 2, 9 | full-backs (Lateral) |
| 3..8 | centre-backs (Zagueiro) |
| 10, 17 | wing-backs / alas (Lateral, advanced) |
| 11..13 | defensive midfielders (Meia, row 0) |
| 14..16 | attacking midfielders (Meia, row 1) |
| 18, 25 | wide forwards (Atacante, row 2) |
| 19..24 | strikers (Atacante) |

Formations, `aq.sJ[k]` = 11 slots in lineup order (aq.java:774). Names come from `aq.rB[k+1]`:
0 = 5-4-1 (dup), 1 = 5-4-1, 2 = 5-3-2, 3 = 4-5-1, 4 = 4-4-2, 5 = 4-4-2 def, 6 = 4-4-2 Ofen., 7 = 4-3-3, 8 = 4-3-3 def,
9 = 3-5-2, 10 = 3-4-3, 11 = 4-2-3-1, 12 = 4-2-3-1 Alas.
**List order matters**: the sector averages in section 3 take the *first N* players of a sector *in on-pitch list order*.

### 1.4 Characteristics (`aq.qM`, aq.java:540)

0 Colocação, 1 Defesa Penalty, 2 Reflexo, 3 Saída Gol, 4 Armação, 5 Cabeceio, 6 Cruzamento, 7 Desarme, 8 Drible,
9 Finalização, 10 Marcação, 11 Passe, 12 Resistência, 13 Velocidade.

Where they matter:
- Scorer weight: 9 Finalização, 5 Cabeceio (section 4.6).
- Assist weight: 11, 4, 8, 13, 6 (section 4.8).
- Rating: 11 and 4 for midfielders (section 8.3).
- Watched penalty: 9 for the taker, 1 for the GK (section 6.1).
- Auto free-kick/penalty taker: 9 (`ah.R`/`kA`, ah.java:1405-1487).
- Role `ex`: 7 and 10 make a player defensive; 4, 8, 9, 11, 13 and 6 make him offensive (F.java:514-526).
- **0, 2, 3 and 12 (Resistência included) have no effect anywhere in match code.**

### 1.5 Per-match player stat sheet, `components.s` (via `F.gB()`)

| field | inc | get | meaning |
|---|---|---|---|
| `V` (+`Pd`) | `z()` | `y()` | goals (see quirk Q2: double counted) |
| `Ph` | `tE()` | `tx()` | own goals |
| `Pi` | `tF()` | `ty()` | penalties missed (watched mode only) |
| `Pj` | `tG()` | `tz()` | yellow cards |
| `Pk` | `tH()` | `tA()` | red cards |
| `cc` | `gV()` | `cD()` | assists |
| `Pl` | `tJ()` | `tI()` | GK penalty saves (watched mode only) |
| `Pe` | `tL()` | `tK()` | shots on target that were saved (shooter) |

Reset at match start for XI and bench (`F.fe()`, c/b.java:101-120).

### 1.6 Match, `best.I` (best/I.java)

| field | accessor | meaning |
|---|---|---|
| `fz`,`fA` | `hc()`,`hd()` | home / away team |
| `fx` | `hy()` | competition (`best.at`). `at.b()` = type (see 1.7) |
| `fw` | `ht()` | stage/phase (`best.L`; `f.z` = knockout) |
| `fB`,`fC` | `hu()`/`hv()`++, `hw()`/`hx()`++ | home / away goals |
| `fF`,`fG` | `hl()`,`hm()` | starting XI (home/away) as selected |
| `fH`,`fI` | `hn()`,`ho()` | bench |
| `fJ`,`fK` | `hp()`,`hq()` | **players currently on the pitch** |
| `fL`,`fM` | `ie()`,`if()` | players subbed ON |
| `fN` | `hE()` | event list (`best.A`) |
| `fR` | `aR()`/`aS()`-- | substitutions left, init `{5,5}` |
| `fS`,`fT`,`fU` | | match totals: yellows, reds, injuries (both teams) |
| `fQ` | `ib()` | `[0]` 1st-half stoppage 0..2, `[1]` 2nd-half stoppage 1..5 (quick sim only) |
| `fW` | `hz()` | possession % `{50,50}` |
| `fX` | `hY()` | possession tick counts |
| `fY` | `hA()` | shots (finalizações) |
| `fZ` | `hZ()` | shots on target |
| `ga` | `ia()` | shots off target |
| `gb` | `hB()` | tackles (desarmes) |
| `gc` | `hC()` | misplaced passes |
| `gd` | `hD()` | fouls (never incremented) |
| `fD`,`fE` | `hT()`,`hN()` | attendance per sector [G,A,Cd,Cm], ticket revenue |
| `dq` | `dX()` | pitch condition 0..3 ("Excelente", "Muito Boa", "Ruim", "Precária", `aq.pb`). **Cosmetic** |
| `ge`,`gf`,`gj` | `hS()`,`hP()`,`hO()` | knockout tie, shootout allowed, is 2nd leg |
| `gg`,`gh` | `hK()`,`hL()` | 1st-leg goals (away-side / home-side of this match) |
| `gi`,`gk` | `hQ()`,`hR()` | shootout score, shootout winner |
| `gm`,`gn` | | AI substitution minutes (section 5.3) |
| `go` | `hW()` | the possession engine `c.b` |

### 1.7 Competition type `at.b()` (`aq.tz`, aq.java:847)
0 Amistoso, 1 Nacional (league), 2 Copa Nacional, 3 Estadual, 4 Internacional 1 (Libertadores/UCL), 5 Mundial (club WC),
6 Internacional 2, 7 Seleções, 8 Recopa, 9 Eliminatórias, 10 Regionais, 11 Supercopa, 12 Conference League, 13 Finalíssima,
14 Liga Nações, 15 Torneio Amistoso.

### 1.8 Event, `best.A` (best/A.java)
`w`=type `b()`, `dz`=goal subtype `el()`, `dA`=minute `em()`, `dB`=half `en()`, `dC`=main player `eo()`,
`dD`=second player `ep()`, `dy`=team `cu()`, `dF`=side `et()`, `dG`=penalty flag `eu()`, `dE`=shown `isDone()`.

Types (`aq.sT`): 1 gol, 2 Amarelo, 3 Ama-Ver (2nd yellow), 4 Vermelho, 5 Contusão, 6 Substituição (eo=out, ep=in),
7 Penalty Perdido, 8 assist record (not in `sT`).
Goal subtypes (`aq.sU`): 1 normal, 2 contra (own goal), 3 penalty, 4 falta (free kick), 5 olímpico, 6 escanteio (never produced).

---

## 2. Match flow and timing

### 2.1 Quick simulation (no human team), `I.V()` (best/I.java:1036-1123)
1. Create the possession engine `b2 = new c.b(this)` (sets kickoff, see 3.0).
2. Knockout handling (z stage): if two-legged and this is leg 2, load the 1st-leg score (`gg`,`gh`) and set `gj = ge = true`.
   If single-leg, set `ge = true`. If `ge`, then `gf = !z.zA()` (zA = special no-shootout Estadual stage).
3. Attendance: `ev().b(this)`, or the neutral venue `il().b(this)` (section 9).
4. **Only if neither team is human**:
   - `fQ[0] = nextInt(3)` (0..2), `fQ[1] = nextInt(5)+1` (1..5).
   - 1st half: for `minute = 0 .. 44+fQ[0]` (45..47 ticks): `I.a(this, 1, minute)`, then `ev = b2.vO()`.
     If an event comes back, stamp minute/half and add it. If it is a goal with an assister, also add a type-8 event.
   - Halftime: `m(2, 0)` (AI halftime subs, 5.3).
   - 2nd half: for `minute = 0 .. 44+fQ[1]` (46..50 ticks), same as above with half=2.
   - Shootout if `ge && gf && hk()` (section 7).
5. `hc().I(false); hd().I(false)` resets "lineup set" so the AI re-picks next round.

**There is no extra time (prorrogação) anywhere.** A drawn knockout tie goes straight to penalties.

### 2.2 Watched simulation (at least one human team), `a/dV` + `I.q()`
- Matches with a human team get `components.v.ei() == true` (components/v.java:24-29) and are simulated live.
  The others were already finished by `I.V()`.
- Ticker `dV.qa()` (a/dV.java:399-420). `GT` is the minute and `dB` the half.
  - Half 1: `GT = 1..48`, and each calls `I.q(GT, 1)`. When `GT` reaches 49, `qg()` runs halftime: `GT=0`, `dB=2`,
    an optional human sub window, `m(2,0)` for every live match, then `q(0, 2)`.
  - Half 2: `q(GT, 2)` for `GT = 0..50`. At `GT = 51` the match ends.
  - The display shows "Acréscimos" from 45'.
- `I.q(minute, half)` (I.java:998-1022) = `I.a(this, half, minute)` + `b2.vO()`, with the same event handling as quick.
- Differences from quick (see section 11): 99 ticks vs 91..97, penalties resolved interactively,
  human-team injured players stay on the pitch until the user subs them, and the human shootout uses a dialog.

---

## 3. Team strength (computed every tick, from players currently on the pitch)

### 3.1 Player match strength `B(F)` (c/b.java:284-395)
```
n = força (F.fi())
if option habilidadeIndividual:                    (weights on the 7 skills, each rounded to int separately)
  GK (slot 1):        0.6 Gol + 0.15 Téc + 0.15 Vel + 0.1 Pas
  CB (3..8):          0.5 Des + 0.1 Téc + 0.25 Vel + 0.1 Pas + 0.05 Arm
  FB (2, 9):          0.4 Des + 0.1 Vel + 0.1 Téc + 0.3 Pas + 0.05 Arm + 0.05 Fin
  DM (11..13):        0.4 Des + 0.15 Vel + 0.1 Téc + 0.2 Pas + 0.1 Arm + 0.05 Fin
  AM (14..16):        0.05 Des + 0.1 Vel + 0.1 Téc + 0.25 Pas + 0.4 Arm + 0.1 Fin
  Ala (10, 17):       0.05 Des + 0.25 Vel + 0.15 Téc + 0.25 Pas + 0.2 Arm + 0.1 Fin
  ST (19..24):        0.25 Vel + 0.25 Téc + 0.05 Pas + 0.05 Arm + 0.4 Fin
  Wide (18, 25):      0.25 Vel + 0.15 Téc + 0.15 Pas + 0.05 Arm + 0.4 Fin
  (other slot -> 0)
if out of position (gF): n = round(n * 0.5)
if n <= 0: n = 1
competition scaling (each round()):
  type 7 Seleções: for a player whose nationality == home team's country, by HOME reputation:
                   rep<3 x0.65, rep==3 x0.85, rep==4 x0.95. Otherwise, if nationality == away's country, the same with AWAY reputation
  type 4 Intern.1: by player's club rep: <3 x0.75, ==3 x0.85, else if club country == 29 x0.9
  type 5 Mundial:  <3 x0.55, ==3 x0.75, else if club continent (gg) != 0 x0.9
  type 1 Nacional: <3 x0.85, ==3 x0.95
  type 2 or 3:     if home rep<3 and away rep>=3 and the player belongs to the AWAY team: x0.8   (giant-killer help)
return n / 10.0
```
**Energy does not enter B().** Fatigue only acts through substitutions and injury length.

### 3.2 Sector values (side `s`, from on-pitch list `hp()`/`hq()` in list order)
- **Midfield** `ez(s)` (c/b.java:173-197): `(marcBonus + Σ B of the first 5 players with slot 10..17) / 5`, where
  `marcBonus = {0, 0.04, 0.08}[kj()[2]]` (Leve/Pesada/Muito pesada). If fewer than 3 such players, the value is 0.01.
- **Defense** `eE(s)` (c/b.java:263-282): `Σ B of the first 5 players with slot 2..9 / 5`. If fewer than 3, the value is 0.01.
- **Attack** `eA(s)` (c/b.java:199-218): `Σ B of the first 3 players with slot 19..25 / 3`. If there are none, the value is 0.0.
  **Slot 18 is excluded but slot 25 is included** (asymmetry).
- **Goalkeeper** `eB(s)` (c/b.java:220-238): B of the slot-1 player (0.1 if none). If the GK is out of position,
  the value is `(int)round(B*0.2)`, applied on top of the 0.5 already in B.
- **Shooter** `eC(s)` = B(shooter chosen by `vU()`, see 4.6). 0.1 if none.
- **CB count** `eD(s)`: number of on-pitch players with slot 3..8.

Duel helpers:
- `a(x,y) = (x−y)/k1` with `k1 = 8`, or **11 from season 5 on** (`f.H()` = season counter starting at 1). The `>=9 -> 12` branch is unreachable (c/b.java:492-502).
- `b(x,y) = (x−y)/k2` with `k2 = 8`, or **10 from season 5 on** (c/b.java:504-512).

**Home advantage** applies unless the venue is neutral: `I.hX()` = `fx.b()==5 || fx.b()==7` (Mundial or Seleções)
(I.java:1484-1486). The crowd, pitch condition, fan mood and morale have **no** effect on the engine.

**Tactics effects (complete list):** formation acts only through which slots are filled. Marcação acts through
`marcBonus`, the card rates (section 5.1) and assist weights (section 4.8). Estilo (`kj()[1]`) is read once and ignored
(c/b.java:416). Jogada (`kj()[3]`) is never read by the engine.

---

## 4. The possession engine, one tick = `c.b.vO()` (c/b.java:126-156)

### 4.0 State
`TB` = the side "in possession" this tick. Initial value `vN()`: `Tn.nextBoolean()` true -> 0 (home), else 1 (c/b.java:77-83).
**After every tick `TB` flips** (`vP()`, c/b.java:158-164). Each team therefore gets an attacking turn every other
tick, whatever happens. `zA[2]` = goals scored by each side as counted by this engine.

### 4.1 Tick algorithm
```
w = vR()                                   // midfield duel, returns the side that wins it
if w == TB:                                // attacker won midfield
    if vS() == 0:                          // attack beat defense
        shots[TB]++ ; return vT()          // shot (may return a goal event)
    else: if To.nextInt(100) < 50: tackles[other]++ else misplacedPasses[TB]++
else:
    if To.nextInt(100) < 50: tackles[other]++ else misplacedPasses[TB]++
TB = other
```

### 4.2 Midfield duel `vR()` (c/b.java:407-447)
```
mA = ez(TB), mD = ez(other)
d2 = 1 + a(mA, mD);  d3 = 1 + a(mD, mA)
if !neutral && TB == 0: d2 += 0.3
d2 = max(d2, 0.2); d3 = max(d3, 0.2)
pick index with weights {55*d2, 45*d3}       (Tn.nextDouble()*sum, cumulative "<")
index 0 -> TB wins; index 1 -> other wins
winner: possessionTicks[winner]++ and possession% recomputed:
    pct[i] = round(100 * ticks[i] / (ticks0+ticks1))   (each side rounded independently)  (c/b.java:397-405, aq.A)
```

### 4.3 Attack vs defense `vS()` (c/b.java:449-490)
```
D = eE(other); A = eA(TB)
d4 = 1 + a(A, D);  d5 = 1 + a(D, A)
if D == 0: d5 = 0.1              (cannot happen, since eE floors at 0.01)
if !neutral && TB == 0: d4 += 0.3
if A == 0: d4 = 0.1              (no strikers in slots 19..25)
d4 = max(d4,0.2); d5 = max(d5,0.2)
if either team is human:          cb = eD(other); cb==0 -> d5 = 0.1; cb==1 -> d5 = 0.05
pick weights {50*d4, 50*d5}: 0 = attack succeeds (shot), 1 = defense wins
```

### 4.4 Shot `vT()` (c/b.java:520-588)
```
D = eE(other); A = eA(TB)
S = eC(TB)            // also chooses the shooter TE via vU()
G = eB(other)
d6 = 1 + b(G, S)      // "saved" multiplier
d7 = 1 + b(D, A)      // "off target / blocked" multiplier
if either team human: cb = eD(other); cb==0 -> d6 = (int)round(d6*0.2); cb==1 -> d6 = (int)round(d6*0.4)
if !neutral:
    TB==0 (home shoots):  d6 += 0.1; d7 = d6 + 0.1      <- d7 is OVERWRITTEN (see Q1)
    TB==1 (away shoots):  d6 -= 0.1; d7 = d6 - 0.1
base = TU {5.5, 35.55, 15.0}                       (goal, saved, off)
if zA[TB] >= 3: base = TV {4.5, 40.55, 15}
if zA[TB] >= 5: base = TW {3.0, 40.55, 15}
if zA[TB] >= 6: base = TX {0.5, 40.55, 15}
if zA[TB] >= 2 and rep(other) - rep(TB) >= 2: base = TW      (underdog already scored 2)
d6 = max(d6,0.2); d7 = max(d7,0.2)
pick weights {base0*1.0, base1*d6, base2*d7}       (Tn.nextDouble)
0 -> GOAL: onTarget[TB]++, build goal event (4.5)
1 -> saved: onTarget[TB]++, shooter.gB().tL()
2 -> off target: offTarget[TB]++
```
Worked example, equal teams on a non-neutral pitch. Home shot: 5.5 / (5.5 + 35.55·1.1 + 15·1.2) ≈ 8.7% goal.
Away shot: 5.5 / (5.5 + 35.55·0.9 + 15·0.8) ≈ 11.1% goal.

### 4.5 Goal type, scorer and assist: `a(A, F shooter)` (c/b.java:833-908)
```
r = new Random().nextInt(1000)
type = r<900 -> 1 normal | <950 -> 3 penalty | <980 -> 4 falta | <990 -> 2 contra | <995 -> 5 olímpico | else 1
event.type = 1 (goal); event.player = shooter
if shooter == null: shooter = vU()
if type ∉ {3,2}: shooter.goals++                         (first increment)
if type == 1 (i.e. ∉ {2,3,4,5}): assister = C(shooter); if assister != null and != shooter:
      assister.assists++; if !assister.youth: assister career-assist (F.a(8,...)); event.player2 = assister
if type == 5: if team.cornerTaker (lq) is on pitch -> scorer = corner taker
              else if shooter is a natural GK -> type = 1
if type == 2: og = vV() (opponent, weights 4.7); if og: event.player = og, og.ownGoals++
              else: type = 1, shooter.goals++
if type ∈ {3,4}: if team.freeKickTaker (ke) is on pitch -> event.player = ke   (penalties use the FREE-KICK taker)
if type == 3: event.penaltyFlag = true
              if either team human: deferred = true; flag=false   -> goal NOT counted now; resolved by dialog (6.1)
if !deferred: zA[TB]++; match score ++ (hv/hx); shooter.goals++   (second increment; ORIGINAL shooter even for pen/own goal)
event.subtype = type
```
In quick mode (AI vs AI), **every penalty is scored**. Missed penalties only exist in watched mode.

### 4.6 Shooter selection `vU()` (c/b.java:632-684)
Candidates are on-pitch players of `TB` with slot ≠ 1, natural position ≠ GK, and slot in 1..25.
Weight = `Tx[slot]` + bonus:
- `Tx`: slots 2..9 = 1, slot 10 = 8, slots 11..13 = 4, slots 14..17 = 8, slots 18..25 = 22.
- Finalização (cr 9) +4. Otherwise Cabeceio (cr 5) +2, plus another +2 if natural position is Zagueiro.

Draw: `Tn.nextDouble()*Σ`, then the first candidate with `r <= cumulative`. Fallback: the last list element (index > 0).

### 4.7 Own-goal scorer `vV()` (c/b.java:782-807)
Picks from the defending side's on-pitch players with weight `Tz[slot]`:
GK 1; slots 2,9 = 5; 3..8 = 18; 10 = 1; 11..13 = 5; 14..25 = 1.

### 4.8 Assist `C(F scorer)` (c/b.java:686-780)
- First, `new Random().nextInt(100) > 80` returns no assist (19%).
- Candidates are all on-pitch teammates ≠ scorer with slot 1..25 (the GK is included).
- Weight = `Ty[slot]`: GK 1, slot 2 = 10, 3..8 = 2, 9 = 10, 10 = 10, 11..13 = 4, 14..16 = 20, 17 = 10, 18..25 = 10.
- Bonus (first matching branch only):
  - Passe(11): +10, and +5 more if also Armação(4).
  - Armação(4): +2, and +2 more if cr1 == Drible(8).
  - Drible(8): +2, and +2 more if cr1 == Velocidade(13).
  - Velocidade(13): **+1 in the sum pass but +2 in the pick pass** (Q5), and +2 more if Lateral.
  - Cruzamento(6): +5, and +2 more if Lateral.
- Then, if `kj()[2]` (marcação) == 1 and natural position == Lateral: +20 (Q4: probably meant jogada "pelas laterais").
- Draw: `Tn.nextDouble()*Σ`, then the first candidate with `r <= cumulative`.

---

## 5. Incident layer, `I.a(I, half, minute)` (best/I.java:517-596), once per tick before `vO()`

### 5.1 Cards and injuries
```
r = new Random().nextInt(100)
if r > 55: list = home on-pitch, marc = home kj()[2], side 0      (44%)
else:      list = away on-pitch, marc = away kj()[2], side 1      (56%)
marcAdd = {30, 10, 0}[marc]                     (Leve 30, Pesada 10, Muito pesada 0; out of range -> index 0)
b = minute<15 ? 0 : minute<30 ? 1 : 2
if minute % 7 == 0: fatigue tick (5.2)
half 1: Y = {70,40,30}[b] + marcAdd;  R = {1200,900,800}[b];  INJ = {1500,1000,800}[b]
half 2: Y = {45,40,30}[b] + marcAdd;  R = {800,700,550}[b];   INJ = {800,600,600}[b]
if yellowsInMatch(fS) > 5: Y *= 2                (the ">10 -> 1000" branch is unreachable)
if redsInMatch(fT) >= 2:   Y = R * 2
if injuriesInMatch(fU) >= 1: Y = INJ * 5
if   nextInt(Y)   == 1: p = pickYellow(list);  fS++;  if p: yellow(p)
elif nextInt(R)   == 1: p = pickRed(list);     if p: red(p);  fT++
elif nextInt(INJ) == 1: fU++; p = pickInjury(list); if p: injury(p)
elif half == 2 && minute >= 5: AI substitutions m(half, minute)   (5.3)
```
The counters `fS` and `fT` increase even when no eligible player is found.

Player pickers (each draws a slot band, then a random on-pitch player inside it via shuffle, `I.a(list,lo,hi)`, I.java:956-970).
Bands are `aq.sS` (aq.java:843): 0 = 10..13, 1 = 14..17, 2 = 3..8, 3 = 2..3, 4 = 8..9, 5 = 19..24, 6 = GK.

| picker | draw | band thresholds |
|---|---|---|
| yellow `H` (I.java:938) | nextInt(100) | <25 → 0, <40 → 1, <65 → 2, <73 → 3, <82 → 4, <85 → 6 (GK), else 5 |
| red `J` (I.java:972) | nextInt(200) | ==0 → GK, <80 → 0, <110 → 1, <160 → 2, <170 → 3, <190 → 4, else 5 |
| injury `I` (I.java:947) | nextInt(500) | ==0 → GK, <150 → 0, <250 → 1, <320 → 2, <360 → 3, <420 → 4, else 5 |
| own goal (alt) `G` (I.java:929) | nextInt(1000) | ==0 → GK, <150 → 0, <350 → 1, <400 → 2, <450 → 3, <500 → 4, else 5 (used only by the unused event path) |

Note that slots 18 and 25 (wide forwards) are never in any band, so they never get cards or injuries from this layer.

- **Yellow** `I.b(...)` (I.java:496): `p.yellowsInMatch++`. If it is now 2, the event is type 3 (Ama-Ver), otherwise type 2.
- **Event creation** `I.a(type, sub, I, team, p, p2, half, minute)` (I.java:646-707):
  - type 2: `tG`. type 4: `tH`. type 3: both.
  - Type 3/4: the player is removed from the pitch. If the team is AI, `p.slot <= 13`, and subs remain,
    a **red-card reshuffle sub** follows. One on-pitch attacker (slots 18..25) is withdrawn, or else an AM (14..17),
    or, if the sent-off player was the GK, any player in 2..25. The best bench player for the **sent-off player's slot**
    comes on in that slot (I.java:709-750).
  - Type 5 (injury): `p.p(team)` sets the injury duration (8.2). If the team is AI, the player is removed and,
    with subs left, replaced by the best bench fit for his slot (a GK may only replace a GK). For a human team the
    injured player stays on the pitch (in watched mode the sub dialog opens).

### 5.2 Fatigue, `I.l(half, minute)` (I.java:787-806) on every tick with `minute % 7 == 0`
Each on-pitch player except the GK loses energy each fatigue tick. The GK loses energy only in the 2nd half.
`F.fq()` (F.java:350-362) amount by age: ≤20 → −1, ≤25 → −2, ≤31 → −3, ≤36 → −4, else −5. If energy would go below 0, it becomes 1.
Resistência has no effect. Fatigue ticks: quick, minutes 0,7,…,42 (7) + 0,7,…,49 depending on stoppage. Watched, 7,…,42 (6) + 0,…,49 (8).

### 5.3 AI substitutions
Planned minutes `hb()` (I.java:208-283), drawn at match construction (2nd-half minutes):
- `gs` = 19..38 shuffled. `gn[0][0..1] = gs[0..1]`, `gn[1][0..1] = gs[2..3]`. `gn[0][2] = gs[4]` if `nextInt(100) > 30`,
  `gn[1][2] = gs[5]` if `nextInt(100) > 30`. These are "chasing the result" minutes.
- `n3 = nextInt(100)` (drawn first). If n3 > 90, list = 5..15. If n3 > 50, list = 16..35. Otherwise list = 36..42.
  The list is shuffled, then `gm[0][0..1] = list[0..1]`, `gm[1][0..1] = list[2..3]`.
- `gw` = 43..47 shuffled. `gm[0][2] = gw[0]` if nextInt(100) > 20, `gm[0][3] = gw[1]` if > 50, `gm[1][2] = gw[2]` if > 20,
  `gm[1][3] = gw[3]` if > 50. These are "energy" sub minutes.

Decision `m(half=2, minute)` (I.java:808-838). It is only for AI teams with subs left, and the away team is skipped if the home team subbed this tick.
- Home: at minute 0 and losing by ≥1, `nextInt(100) > 50` → random sub. At a `gn` minute, losing by ≥1 **or drawing** → random sub.
  At a `gm` minute → energy sub.
- Away: at minute 0 and losing by **≥2** → 50% random sub. At a `gn` minute and losing by ≥1 (not when drawing) → random sub.
  At a `gm` minute → energy sub.

Sub types (`a(kind, side, half, minute, onPitch)`, I.java:840-877):
- Energy (kind 1): threshold 60. If minute > 40, threshold 90 and the scan starts at `nextInt(size)`. The first non-GK with energy < threshold is replaced.
- Random (kind 2): `i = nextInt(size)`. If that player was already subbed on, redraw once. If he is not a GK and not subbed on, replace him.
  Bug Q6: the "already subbed on" check always uses the home list `fL`.
- Replacement: `ah.a(bench, slot, …)` = the strongest bench player fitting the slot (see 10.2). He takes the slot,
  is marked played, subs−1, and a type-6 event is added (I.java:752-785).

`I.o(...)` (I.java:887-927) is an alternative energy-based sub routine (<75 energy, GK <40 in the 2nd half). **No callers found.**

---

## 6. Penalties

### 6.1 In-match penalty in watched mode (any human team)
Goal events with subtype 3 are created but not counted (4.5). When the ticker reaches them, `dV.a(...)` (a/dV.java:704-760)
opens `a/gb`. For a human team, `a/gh` first lets the user choose the taker.
Resolution `gb.nO()` (a/gb.java:99-185):
```
p = 70
if taker has Finalização(9) or is TopMundial: p += 10
if taker is Estrela: p += 5
GK = opponent's slot-1 player:
   GK has Defesa Penalty(1): p -= 10;  GK TopMundial: p -= 10;  GK Estrela: p -= 5
goal if nextInt(100)+1 <= p
goal: score++, shots++, onTarget++, taker.goals++ (and zA++)
miss: shots++, taker.penMissed++ (tF); flavor n=nextInt(7): n∈{2,6} -> offTarget++, else onTarget++;
      event type -> 7 "Penalty Perdido"; if n∈{0,3,5}: GK credited a save (tJ, player2 = GK)
```
In quick mode, AI-vs-AI penalties always score (4.5).

### 6.2 Penalty shootout
- Quick (AI vs AI) in `I.V()` (I.java:1104-1117): `h = nextInt(7)+2`, `a = nextInt(7)+2` (2..8). If `h >= a`, home wins
  `h x (h−1)`. Otherwise away wins, shown as `h x (h+1)`. So home wins 28/49 ≈ 57%, and the strength of either team is ignored.
- Watched (human in the match, or "ver decisão de pênaltis não humano" option) dialog `a/bg` (a/bg.java:160-262):
  - Takers are the on-pitch players sorted by comparator `h.A`.
  - Home kicks first and kicks alternate. Each kick scores if `nextInt(100)+1 <= 70` (flat 70%).
  - Best of 5 with early decision; after 5 each, sudden death decided after each away kick.
  - The result is stored in `gi`, the winner in `gk`.

### 6.3 Is a shootout needed? `I.hk()` (I.java:1125-1180)
Count legs won (this match, plus leg 1 if 2nd leg). If tied, compare aggregate goals. If still tied and the away-goals rule
is on (`z.zv()`), compare away goals (home side's leg-1 goals vs away side's leg-2 goals). If still tied and stage id == 2129,
there is no shootout (returns false). Otherwise tied → shootout.

---

## 7. Knockout flags (summary)
`ge` = this match decides a tie. `gf` = a shootout is allowed (`!z.zA()`). `gj` = 2nd leg. See 2.1 step 2 and 6.3.

---

## 8. Post-match effects

### 8.1 Order (best/f.java:1477-1517, `f.as()`)
For each match of the day: `hg()`, `hi()`, `hf()`, `hh()`, then reset lineup flags. Then **all players** `F.fr()` energy
recovery, and the free-agent list (`SR.Q()`) gets energy set to 100.

### 8.2 Injury duration `F.p(ah)` (F.java:2117-2164)
```
a = nextInt(14); b = 5 + nextInt(20)
e = (energy<10) ? 5 : (energy<50 ? 1 : 0)
days = age<=20 ? a                         (energy term discarded)
     : age<=25 ? e+a+1 : age<=30 ? e+a+2 : age<=35 ? e+a+3
     : age<=45 ? e+a+b : e+a+10+b
if age >= 35: força -= 5 (permanent; if <0 -> 1)
r = nextInt(100): r==1 -> +70; r<4 -> +40; r<10 -> +20
if days > 0: injuredUntil = currentDate + days
career injury counter++ ; human club gets a message (text bucket by days)
```

### 8.3 Cards → suspensions
`I.hh()` processes events (I.java:452-464). Type 2/3/4 call `F.a(type, comp, team)` (F.java:2166-2216).
Friendlies (`SR.bv()`) and youth players are skipped. Per-competition stats `H` (best/H.java):
- yellow: `ca++`.
- Ama-Ver: `ca++` **and** `cb++` (1-match ban, plus a yellow added).
- red: matches = `nextInt(1000)`: <700 → 1, <900 → 2, <970 → 3, ≤990 → 5, else 10. `cb += matches`.
- Suspended if `ca >= 3 || cb >= 1` (`gT`).
- `I.hi()` (I.java:468-486), run **before** the new cards are applied: for every squad player of both teams, reset the in-match
  yellow counter, and if suspended in this competition, serve one match: if `ca >= 3`, `ca = 0`, else `cb--` (`H.gU`).

### 8.4 Player stats and ratings, `I.hh()`
For every starter (`fF/fG`) and every sub-on (`fL/fM`): games played `F.b(at,team)`, then rating `F.a(at, I, side, opp, team)` (F.java:2290-2483).
Goals: event type 1 with subtype ≠ 2 → `F.a(at,team)`: competition goals, top-scorer table (`at.p(F).z()`), career.

Rating (nota):
```
mins = 90; for each event in match order:   (last match wins, see Q3)
   if event.player == me:  mins = half1 ? minute : 48+minute
   if event.player2 == me: mins = half1 ? 48+(50-minute) : 50-minute
res = win/draw/loss for my side; GF/GA for my side
slot = my slot; if <1: slot = {1,2,7,15,23}[naturalPosition]
base (by força):  draw ≤30 5.5 | ≤60 5.8 | ≤90 6.2 | else 6.8
                  win  6.0 | 6.0 | 6.7 | 7.2
                  loss 5.0 | 5.2 | 5.5 | 6.0
out of position: −1.5 (GK slot: another −1.5)
slots 10..17 (midfield) by possession%:  more: 1/3 → +0.3, else +0.8; role defensive +0.3; cr1 Passe/Armação +0.5
                                          less: 1/3 → −0.3, else −0.8; role defensive −0.5
+0.9·goals  −1.5·ownGoals  −1.2·ownGoals (Q7: meant missed pens)  −0.2·yellows  −0.8·reds  +0.4·assists
slots 1..13 by tackles (desarmes):  more: 1/3 → +0.9 else +0.6; slots 2..9 1/3 → +0.6; 11..13 1/3 → +0.6
                                    less: −0.5; slots 3..8 1/4 → −0.6; 11..13 1/4 → −0.6
+0.3·(shots on target saved, tK)
GK (slot 1): −0.8 + 0.2·oppShotsOnTarget + 1.2·penSaves; oppShots>10 → +0.2;
             conceded ≥5 −2.0 | ≥4 −1.5 | ≥2 −1.0 | ≥1 −0.5 | 0 +1.0; oppShotsOnTarget==0 → −1.5
slots 1..13: clean sheet +0.5 (+0.5 more for 2..9; 11..13 1/3 → +0.5); conceded >1 → −0.1·GA
slots 2..13: 1/3 → −0.4
Estrela +0.4, TopMundial +0.6
clamp: >10 → 10; <0 → 1
mins <15 → −2.5; mins <45 → −1.5
floor 2.0; if mins <20 and rating <= 2.0 → rating = 0 (no rating)
store: last rating, history, club-career avg, competition avg (if >0), award trackers (type f.B)
```
Every "1/3" is `new Random().nextInt(3)==1` and every "1/4" is `nextInt(4)==1`.

### 8.5 Energy recovery `F.fr()` (F.java:364-404), once per round for every player
- Played (`eL`) and the club is human: ≤20 +13, ≤25 +24, ≤31 +37, ≤36 +40, else +30.
- Played and the club is AI: +20, +30, +50, +52, +42 (same age bands).
- Did not play: <20 +30, <26 +30, <33 +35, <45 +35, else +30.
- Capped at 100. `eL` is reset in `F.fV()` (periodic development step).

### 8.6 Table, team and manager effects `I.hg()` (I.java:390-422)
- Head-to-head record `best.T` (by club id).
- `ah.e(I)` team stats per competition (`aj`): games, GF, GA, W/L, plus a points ledger (+3 win, +1 draw) (ah.java:1043-1073).
- Manager `al.a(I, false, -1)` (al.java:162-509) for competition types 1, 2, 3, 4, 5, 6, 8 and 10 (also AI managers).
  It adjusts **board confidence** `of` (`cj`) and **fan satisfaction** `og` (`ck`), both 0..100.
  - Board: delta tables by competition type and league-position bucket.
  - Fans: draw ±1, win +3/+4 (+4/+5 more if by ≥3 goals), loss −5/−4 (−7/−5 more if by ≥3). Away results are treated more gently.
  - Extra: −3 to the board if fans < 20; −10/−5 to the board if the human club has negative cash.
  - Fan satisfaction feeds attendance (9). There is no player-morale variable in the match code.

### 8.7 Revenue `I.hf()` (I.java:383-388)
If the competition type ∉ {5, 7} and the **home club is human**, then `home.cash += fE` (ticket revenue, ledger category 5).
AI clubs receive nothing here.

---

## 9. Attendance and ticket revenue `v.b(I)` (best/v.java:94-226)
Stadium capacity split `N(cap)` (cap outside 1000..120000 → 10000): Geral 15%, Cadeira 9%, Camarote 0.9%,
Arquibancada = the rest. Sector order `[G, A, Cd, Cm]`.
```
demand[s] = baseTable[homeRep][s]
   rep0 {200,500,50,0}  rep1 {1000,5000,1200,20}  rep2 {2000,10000,1500,50}
   rep3 {4000,20000,2500,300}  rep4 {4500,30000,3500,400}  rep5 {5000,40000,5500,500}
type 3 or 10: ×0.7 ; type 0: ×0.4                                   (each round())
f = 0.3 (+0.15 knockout stage) (+0.3 type 4) (+0.3 type 7/9) (+0.15 type 6/8/11)
demand[s] += round(capacity[s] × f)
diff = awayRep − homeRep; k = {0,.05,.1,.15,.2,.25}[|diff|]; demand ±= round(demand×k) (+ if away is bigger)
demand ×= fanSatisfaction(home manager og, default 80)/100
demand[s] += nextInt(randTable[homeDivision][s]) if >0
   div0 {10,20,5,0} div1 {100,500,200,10} div2 {300,1000,400,20} div3 {400,1200,500,30} div4 {500,1500,1000,50}
prices: if "use default prices": default table v.a(type, home) (aq.qK);
        else set prices; demand[s] += round(0.03·demand[s]) × (default[s] − price[s])
clamp 0..capacity[s]; revenue = Σ demand·price
type 7: revenue ×3 (×5 if el()==7, World Cup); type 9: ×2
I.fD = demand (attendance), I.fE = revenue
```
Pitch condition `dq` is rolled per stadium by reputation (v.java:43-68). It is display only.

---

## 10. AI lineup and tactics `ah.a(team, I, side, forcedFormation, chooseTactics)` (best/ah.java:402-496)

### 10.1 Procedure
1. Eligible players: `F.a(I,false)`, which means not injured, not suspended in this competition (non-friendly),
   and for human clubs a valid contract. Sort by força descending, then energy descending (`h.B`).
2. Formation: `r = nextInt(100)+1`, mapped to a formation index:

   | r | formation |
   |---|---|
   | 1-2 | 1 (5-4-1) |
   | 3-4 | 2 (5-3-2) |
   | 5-7 | 3 (4-5-1) |
   | 8-38 | 4 (4-4-2) |
   | 39-49 | 5 (4-4-2 def) |
   | 50-60 | 6 (4-4-2 Ofen.) |
   | 61-65 | 7 (4-3-3) |
   | 66-72 | 8 (4-3-3 def) |
   | 73-90 | 9 (3-5-2) |
   | 91-92 | 10 (3-4-3) |
   | 93-100 | 11 (4-2-3-1) |

   A forced formation overrides this. Formation 12 (4-2-3-1 Alas) is never chosen by the AI.
3. For each slot in `aq.sJ[f]`, pick `ah.a(list, slot)` (10.2). The player gets the slot and is marked played,
   and is added to XI and on-pitch.
4. Bench: slots `aq.sI = {1,1,2,4,4,12,15,15,20,20,23}`, each the best fit (2 GKs, 1 FB, 2 CBs, 1 DM, 2 AMs, 3 strikers).
5. Tactics (if requested):
   - estilo: 1-70 → 0, 71-80 → 1, 81-100 → 2.
   - marcação: 1-5 → 2, 6-70 → 0, 71-100 → 1.
   - jogada: 1-70 → 0, 71-100 → 1.
   - Each uses a separate `nextInt(100)+1`.

### 10.2 Best fit for slot `ah.a(list, slot, …)` (ah.java:624-681)
Wanted = `{pos, side, row}` from `aq.sE[slot]` (side −1 = any, row −1 = any, row ignored for slots ≥ 18).
For position preference order `aq.sH[pos]` (GK: G,Z,L,M,A; L: L,M,Z,A,G; Z: Z,L,M,A,G; M: M,L,Z,A,G; A: A,M,L,Z,G),
make three passes over the strength-sorted list:
- strict side and role;
- any side;
- any side and any role.

Return the first match. The 4th pass ("any position", guarded by `bl3`) is unreachable.

---

## 11. Quick vs watched: differences

| aspect | quick `I.V()` | watched `dV` + `I.q()` |
|---|---|---|
| ticks 1st half | 45..47 (minutes 0..) | 48 (minutes 1..48) |
| ticks 2nd half | 46..50 | 51 (minutes 0..50) |
| fatigue ticks | 7 + 7/8 | 6 + 8 |
| penalties | always scored (AI vs AI) | interactive 70%±mods, can be missed (any human match, both teams) |
| CB-count penalty (4.3/4.4) | never (no human) | applied (either team human) |
| injured player (human team) | n/a | stays on pitch until the user subs him |
| AI subs of human team | n/a | never (human manages) |
| shootout | random 2..8 vs 2..8, home wins ties | 70% per kick dialog |
| engine | identical `I.a` + `c.b.vO()` | identical |

Dev tool `a/hF.dA()` (a/hF.java:104-200) batch-simulates N matches with `c.b.vO()` only (no incident layer) and
prints averages. Its `I(ah,ah,bool)` constructor leaves `fx` null, so `B()`/`hX()` would NPE as decompiled.

---

## 12. Obfuscated name mapping

### Classes
| obf | meaning |
|---|---|
| `best.F` | Jogador (Player) |
| `best.ah` | Time/Clube (Team) |
| `best.I` | Partida (Match fixture + incident layer) |
| `c.b` | MotorPartida (possession/goal engine) |
| `best.A` | EventoPartida (match event) |
| `best.aq` | Constantes (global constants) |
| `best.at` | Competição (base) |
| `best.L` | Fase/Etapa (stage). `f.z` = knockout stage, `f.s`/`f.G` = rounds/ties |
| `best.v` | Estádio (stadium, attendance) |
| `best.al` | Técnico/Treinador (manager; confidence/fans) |
| `best.H` | EstatísticaJogadorCompetição (cards, suspensions, goals, avg rating) |
| `best.k` | EstatísticaJogadorClube (career per club) |
| `best.J` | NotaHistórico (rating history entry) |
| `best.T` | Confronto (head-to-head record) |
| `best.aj` / `best.ak` | team stats per competition / per stage |
| `best.c` | artilharia entry (top-scorer per competition) |
| `best.f` | Jogo/SaveGame (global state; `c.a.SR` is the singleton) |
| `best.a` | Rodada/DiaJogos (matchday: date + list of matches) |
| `components.s` | EstatísticaPartidaJogador (per-match player sheet) |
| `components.v` | linha de jogo na tela ao vivo (live match row) |
| `a.dV` | TelaPartidas (live match-day screen) |
| `a.gb` | DiálogoPênalti (in-match penalty) |
| `a.gh` | EscolherBatedor (choose penalty taker) |
| `a.bg` | DisputaPênaltis (shootout dialog) |
| `a.hF` | SimuladorTeste (dev batch simulator) |
| `a.bz`/`a.cD` | Escalação/Táticas screens |
| `best.W`, `e.g` | player import records (W: `hl` = estrela, `hm` = topMundial) |
| `h.B` | comparator força desc, energia desc |
| `h.A` | comparator used for shootout order |
| `best.ai` | comparator força desc, idade asc |
| `f.a` | Amistosos (friendlies competition) |

### `best.F` (Player)
| obf | meaning |
|---|---|
| `eq`/`fi()`/`ad()` | força |
| `em`/getIdade | idade |
| `en`/getPosicao | posição natural (0..4) |
| `er`/getLado | lado |
| `ey`,`ez`/getCr1,getCr2 | características |
| `ex`/`fF()`/`fG()` | papel tático (0 def, 1 ofens, 2 aberto), recompute |
| `eK`/`fp()`/`ai()`/`aj()`/`ak()` | energia get/set/sub/add |
| `fq()` | perder energia (tick de cansaço) |
| `fr()` | recuperar energia pós-rodada |
| `eL`/`fs()`/`b(Boolean)` | jogou na rodada |
| `ek`/`ff()`/`a(Boolean)` | estrela |
| `el`/`gm()`/`j(Boolean)` | top mundial |
| `fb`/`fC()`/`h(Boolean)` | juvenil |
| `eR`/`fT()`/`as()` | slot em campo |
| `gF()` | fora de posição |
| `fU()` | força×energia (int-division bug; only used by dead code) |
| `eI`/`fo()`/`fP()` | fim da contusão / está contundido |
| `eJ`/`fR()` | fim do contrato / dias restantes |
| `fg`/`gi()`/`gj()`/`aw()` | amarelos na partida |
| `fo`/`gB()`/`fe()` | ficha da partida / reset |
| `eN`/`gk()` | última nota |
| `eS`/`h(at)`/`g(at)` | stats por competição (get-or-create / get) |
| `eT`/`o(ah)` | stats por clube |
| `c(at)` | suspenso na competição |
| `f(at)` | cumprir suspensão |
| `a(I,boolean)` | apto para escalar |
| `p(ah)` | aplicar contusão |
| `a(int,at,ah)` | registrar cartão (2 Am, 3 AmVer, 4 Verm) |
| `a(at,ah)` | registrar gol |
| `b(at,ah)` | registrar jogo |
| `a(at,I,int,int,ah)` | calcular nota |
| `eA..eG`/`gK,gJ,gL,gM,gN,gO,gP` | Goleiro, Velocidade, Técnica, Passe, Desarme, Armação, Finalização |
| `fh`,`fi`(int) | total goals / total games |

### `best.ah` (Team)
| obf | meaning |
|---|---|
| `jZ()` | humano |
| `getReputacao()` | reputação |
| `getNivel()` | nível |
| `getDivisao()` | divisão |
| `kc()` | elenco |
| `kj()`/`k(int[])` | táticas [formação, estilo, marcação, jogada] |
| `kd()`/`j(F)` | capitão |
| `ke()`/`k(F)` | batedor de faltas (also penalties) |
| `lq()`/`n(F)` | batedor de escanteios |
| `lr()`/`o(F)` | falso 9 |
| `ka()` | técnico |
| `ev()` | estádio |
| `kb()`/`v(n,c)`/`w(n,c)` | caixa / receita / despesa |
| `kf()`/`I(bool)` | escalação definida |
| `static a(ah,I,int,int,bool)` | escalar IA |
| `static a(ArrayList,int,bool,bool)` | melhor jogador para slot |
| `static a(I,ah,int)` | força por setor (dead code) |
| `kh()` | escalar todos os times IA da rodada |
| `e(I)` | registrar resultado |
| `R/kA` | auto-escolher batedor de faltas |
| `P/kz` | auto-escolher capitão |

### `best.I` (Match)
| obf | meaning |
|---|---|
| `hc()/hd()` | mandante/visitante |
| `hy()` | competição |
| `ht()` | fase |
| `hu()/hv()`, `hw()/hx()` | gols mandante/visitante get/inc |
| `hl()/hm()` | titulares |
| `hn()/ho()` | reservas |
| `hp()/hq()` | em campo |
| `ie()/if()` | entraram |
| `hE()` | eventos |
| `aR()/aS()` | substituições restantes / consumir |
| `fS,fT,fU` | amarelos, vermelhos, contusões na partida |
| `ib()` (`fQ`) | acréscimos |
| `hz()` | posse % |
| `hY()` | posse ticks |
| `hA()` | finalizações |
| `hZ()` | no gol |
| `ia()` | fora |
| `hB()` | desarmes |
| `hC()` | passes errados |
| `hD()` | faltas |
| `hT()/hN()` | público por setor / renda |
| `dX()` | condição do gramado |
| `hX()` | campo neutro |
| `hS()/hP()/hO()` | é mata-mata decisivo / permite pênaltis / é jogo de volta |
| `hK()/hL()` | gols do jogo de ida |
| `hQ()/hR()` | placar pênaltis / vencedor |
| `ic()` | clássico (rivals in `aq.pe`) |
| `he()` | simular rodada rápida |
| `V()` | simulação rápida |
| `q(min,half)` | tick ao vivo |
| `a(I,half,min)` | camada de incidentes |
| `l()` | cansaço |
| `m()` | substituições IA |
| `a(int,int,int,int,list)` | executar sub IA |
| `hb()` | sortear minutos de sub |
| `a(int,int,I,ah,F,F,int,int)` | criar evento |
| `a(int,bool,I,F,int,int,bool)` | sub forçada |
| `a(int,F,F,int,int,int)` | executar substituição |
| `H/J/I/G(list)` | sorteio jogador p/ amarelo/vermelho/contusão/gol contra |
| `hk()` | precisa de pênaltis |
| `hg/hi/hf/hh` | pós-jogo: tabela/suspensões/renda/estatísticas |
| `hF()` | recontar placar a partir dos eventos |
| `aT(1/2)` | goleiro em campo |

### `c.b` (Engine)
| obf | meaning |
|---|---|
| `TB` | lado com a posse no tick |
| `vN()` | sorteio saída de bola |
| `vO()` | tick |
| `vP()` | trocar posse |
| `vQ()` | outro lado |
| `vR()` | duelo meio-campo |
| `vS()` | ataque × defesa |
| `vT()` | finalização |
| `ez` | força meio |
| `eE` | força defesa |
| `eA` | força ataque |
| `eB` | força goleiro |
| `eC` | força finalizador |
| `eD` | nº zagueiros |
| `B(F)` | força do jogador na partida |
| `a(d,d)`, `b(d,d)` | diferença normalizada (/8→/11, /8→/10) |
| `a/b(double[],double[])` | sorteio ponderado |
| `vU()` | escolher finalizador |
| `C(F)` | escolher assistente |
| `vV()` | escolher autor do gol contra |
| `a(A,F)` | tipo de gol e autoria |
| `eF()` | atualizar posse |
| `zA` | gols contados pelo motor |
| `TD` | campo neutro |
| `Tx/Ty/Tz` | pesos por slot: finalização / assistência / gol contra |
| `Tg {55,45}`, `Th {50,50}` | pesos base dos duelos |
| `TU/TV/TW/TX` | pesos base de finalização (gol, defesa, fora) |
| `TY` | template 4-4-2 (unused `vW()`) |

### Constants in `best.aq`
| obf | meaning |
|---|---|
| `qM`/`qN` | característica names/abbrev |
| `sT` | event names |
| `sU` | goal type names |
| `sE` | slot → {pos, side, row} |
| `sF` | slot → sector ids (dead code) |
| `sH` | position preference order |
| `sI` | bench slots |
| `sJ` | formations (slot lists) |
| `sK` | formation short names |
| `rB` | formation menu names |
| `rC` | estilo |
| `rD` | jogada |
| `rE` | marcação |
| `rI` | position letters |
| `rL`/`rK` | lado |
| `sS` | card/injury slot bands |
| `tz` | competition type names |
| `pb` | pitch conditions |
| `pe` | clássicos |
| `qK` | default ticket prices |
| `rz`/`rA` | ticker speeds |
| `A(a,b)` | round(100·a/b) |
| `sV..td`, `te..tj` | event-type / goal-type int constants (inlined by javac, hence no references) |

---

## 13. Quirks and open questions

- **Q1** `vT()` home/away shot adjustment (c/b.java:538-545): `d7 = (d6 ± 0.1) ± 0.1` discards the defense-vs-attack factor
  for every non-neutral match. It also raises the "saved" weight for the *home* shooter. The bytecode clearly does this,
  so it is reproduced as-is. It is probably a bug (intended `d6 += 0.1; d7 += 0.1`?). Net effect: per shot, away teams
  convert better (≈11% vs ≈9% for equal teams), while home teams get more shots via +0.3 in both duels.
- **Q2** Goals are added to the match sheet twice for normal, free-kick and olímpico goals (c/b.java:849 and 904).
  For penalties and own goals, the second increment goes to the original *shooter*, not to the taker or the own-goal scorer.
  This only affects the per-match rating (+0.9 per counted goal). Official goal stats come from events in `hh()`.
- **Q3** Rating minutes (`F.a(at,I,...)`, F.java:2297-2306) are taken from *any* event involving the player (goals, cards, assists),
  not only substitutions. A player who scores at 10' with no later event is treated as having played 10 minutes
  (−2.5, and possibly no rating).
- **Q4** The assist bonus +20 for laterais is keyed on marcação == Pesada (`kj()[2]`). The intent was likely jogada == "Pelas laterais" (`kj()[3]`).
- **Q5** In `C()` the Velocidade bonus is +1 in the sum loop and +2 in the pick loop, so the weights are inconsistent.
  Selection stays well-defined but slightly biased towards later list entries.
- **Q6** `I.a(2, side, ...)` uses `fL` (home subs-on) to test "already subbed" for both teams (`n3 == 2` never true).
- **Q7** Rating: `if (ty() > 0) d2 -= tx()*1.2` uses own goals instead of missed penalties.
- **Q8** `I.hX()` neutral venue = `(fx != null && type==5) || type==7`. The second part dereferences `fx` without a null check.
- **Q9** The yellow-card rate collapses after the first injury of the match (`Y = INJ*5`, 3000..7500), or after 2 reds (`Y = R*2`). This looks unintended.
- **Q10** Slots 18 and 25 never receive cards or injuries. Slot 18 never counts for the attack average while slot 25 does.
- **Q11** Estilo (Ataque total/Contra-ataque) and Jogada (meio/laterais) have no effect on the simulation.
  Captain, falso 9, pitch condition, crowd, home fan mood, energy (except subs/injuries) and Resistência also have none.
- **Q12** `ah.a(I,ah,int)` (sector strength sum with `sF`) and `I.a(F,int,int)` (alternative goal-type roll with a 50% yellow
  / 10% red for a defender on penalties) have no callers in this build.
- **Q13** Quick shootout ignores team strength and favours home 57/43. The displayed loser score is derived from the
  home draw (e.g. away win shows `h x h+1`).
- **Q14** `G.o(I)` (first-leg score orientation) and `z.zA()`/`z.zv()`/stage id 2129 were not traced in depth. The
  away-goals and no-shootout semantics are inferred from usage in `I.hk()`.
- **Q15** `F.fV()` (which resets the "played" flag and runs development) runs on the calendar action "aj" (best/a.java:587).
  Whether that runs every round, which affects energy recovery tiers, was not verified.
- **Q16** Human-team penalties in watched mode: when the dialog is skipped or the UI is not shown (e.g. sim speed
  `SR.bD()`), the penalty event has `el()==3` and the goal is not counted until `gb` runs. `dV.qe()` re-counts the score
  from events (`I.hF()`) at the end.
