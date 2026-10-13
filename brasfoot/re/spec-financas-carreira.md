# Brasfoot 22-23: Finances, Stadium, Manager Career and Player Development, Behavioral Specification
Source: CFR-decompiled jar at `re/decompiled/`. All refs are `path:line` relative to that directory.

## 1. Scope, sources and conventions

This document specifies the behaviors of **club finances**, **the stadium**, **manager careers** (confidence, fans, dismissals, job market) and **player development** (weekly evolution, juniors, individual skills, training) of Brasfoot 22-23, as reconstructed from the CFR-decompiled sources in `re/decompiled/`.

- Companion documents: `re/spec-partidas.md` (match engine, and §9 attendance/revenue) and `re/spec-transferencias.md` (transfer market, values/salaries, §7 season-change, §10 salaries/finances).
- The primary classes are `best/C.java` (cash ledger), `best/ah.java` (club), `best/al.java` (manager), `best/ay.java` (job market), `best/ag.java` (end-of-season club maintenance), `best/F.java` (player), `best/v.java` (stadium), `best/B.java` (expansion order), `a/cq.java` (expansion dialog), `a/iQ.java` (training dialog), `est/Options.java` (options), `components/as.java` + `est/InfoArquivoSalvoType.java` (messages / save metadata).
- Naming conventions follow the other specs: obfuscated identifiers quoted in `code`, and semantic names are proposed in §21.
- **Distinction kept throughout**: statements marked *observed* are directly backed by the cited code; statements marked *inferred* are conclusions drawn from the code, and items that could not be verified are listed under open questions (§22).
- `c.a.SR` is the singleton `best.f` ("saving room"), so `best/f.java` fields such as `salarioMensal`, `autoSalvar`, `habilidadeIndividual` are the persisted game-state copies of the `est.Options` values.

### 1.1 Money units and display

- All money is stored as integers in R$ (Brazilian reais); `long` fields are used for balances and season totals, `int` for per-day/per-season sub-totals (`best/C.java:12-25`).
- `C.c(long)` formats values with Portuguese magnitude words: `"mil"`, `"milhão"`, `"milhões"`, `"bilhão"`, `"bilhões"`, plus the short suffixes `{" mil","M","B","T"}` used by `C.a(double,int)` (`best/C.java:26,90-147,153-158`).

## 2. Cash ledger `best.C`

The ledger is a `Serializable` per-club object owned by the club (`best/ah.java:87`, `nx`). It only records entries for the **human-managed club** (see `best/ah.java:1671-1688`); AI clubs share the same cash model but never write ledger entries.

### 2.1 Fields and accessors

| Field | Type | Accessor | Stored value (*observed*) | Line |
|---|---|---|---|---|
| `dK` | `long` | `eD()` | undisclosed total (only getter, no writer found in this area) | `best/C.java:12,160-162` |
| `dL` | `int` | `eE()` | income bucket 5 | `best/C.java:13,164-166` |
| `dM` | `int` | `eF()` | income bucket 3 | `best/C.java:14,168-170` |
| `dN` | `long` | `eG()` | income bucket 1 | `best/C.java:15,172-174` |
| `dO` | `int` | `eH()` | income bucket 6 | `best/C.java:16,176-178` |
| `dP` | `int` | `eR()` | income bucket 9 | `best/C.java:17,246-248` |
| `dQ` | `int` | `eI()` | expense bucket 7 | `best/C.java:18,180-182` |
| `dR` | `long` | `eJ()` | expense bucket 1 | `best/C.java:19,184-186` |
| `dS` | `long` | `eO()` | salaries paid | `best/C.java:20,204-206` |
| `dT` | `int` | `eK()` | expense bucket 4 | `best/C.java:21,188-190` |
| `dU` | `int` | `eL()` | expense bucket "other" | `best/C.java:22,192-194` |
| `dV` | `int` | `eM()` | expense bucket 8 | `best/C.java:23,196-198` |
| `dW` | `int` | `eN()` | outstanding loan balance | `best/C.java:24,200-202` |
| `dX` | `int` | `eQ()` | current monthly interest | `best/C.java:25,238-240` |

### 2.2 Income and expense recording

- `h(n, cat)` (*observed*) — income, with category mapping `1→dN`, `3→dM`, `5→dL`, `6→dO`, `9→dP`; any other category is silently ignored (`best/C.java:58-70`).
- `i(n, cat)` (*observed*) — expense, with category mapping `1→dR`, `4→dT`, `7→dQ`, `8→dV`; any other category (including `-1`) goes to `dU` ("outros") (`best/C.java:76-88`).
- `b(long)` (*observed*) — adds to `dS` (salaries) (`best/C.java:72-74`).
- `ez()` total income = `(dL+dM)+dN+dO+dP`; `eB()` total expenses = `dQ+dR+dS+dT+dU+dV`; `eC()` season balance = income − expenses (`best/C.java:31-56`).
- `eA()` resets all season buckets to zero (`dL,dN,dM,dO,dQ,dS,dT,dU,dV,dR`); `dW` (loan) and `dX` (interest) are **not** cleared (`best/C.java:35-46`). Called once per season by `ah.kI()` (`best/ah.java:1708-1712`, invoked from `best/f.java:518-523` during `aa()`).

### 2.3 Who writes each bucket (*observed* usages)

| Bucket | Trigger | Code |
|---|---|---|
| income 5 (`dL`) | match-day ticket revenue for home club | `best/I.java:383-387` (`hf()` calls `hc().v(this.fE, 5)`) — see §8 |
| income 3 (`dM`) | (used by prize/structure code, no caller found in this area → open question) | `best/C.java:61-62` |
| income 1 (`dN`) | (no caller found in this area → open question) | `best/C.java:59-60` |
| income 6 (`dO`) | season verba paid by the game | `best/ah.java:1695` (`v(aq.sD[div][0],6)`), `best/ah.java:1705` |
| income 9 (`dP`) | (used via `X(int)` setter; caller untraced → open question) | `best/C.java:250-252` |
| expense 7 (`dQ`) | stadium expansion cost | `a/cq.java:150` (`zu.w(Ct,7)`) |
| expense 1 (`dR`) | (no caller found in this area → open question) | `best/C.java:77-78` |
| salaries (`dS`) | wage payments | `best/ah.java:1683-1688` (`f(long)` → `nx.b(l2)`) |
| expense 4 (`dT`) | bank interest on the loan | `best/a.java:712-720` (`o()` → `w(eQ(),4)`) |
| expense 8 (`dV`) | (no caller found in this area → open question) | `best/C.java:83-84` |
| expense other (`dU`) | loan repayments (`cat=-1`) — *inferred* | `best/C.java:85-87`, `best/C.java:212-220` |

## 3. Club money API (`best.ah`)

- The club's real-time balance is `nb` (`long`), initialized `0L` (`best/ah.java:61`); `kb()` returns it (unobfuscated getter, used everywhere).
- Income primitive `v(n, cat)` — adds to `nb` and, **only if the club is human** (`jZ()` true and ledger `nx` non-null), records `nx.h(n, cat)` (`best/ah.java:1669-1674`).
- Expense primitive `w(n, cat)` — subtracts from `nb`, records `nx.i(n, cat)` for humans (`best/ah.java:1676-1681`).
- Salary/contract payment `f(long)` — subtracts from `nb` unconditionally, records `nx.b(l2)` only for humans (`best/ah.java:1683-1688`). Therefore **AI clubs pay wages from real cash but produce no ledger entry** (*observed*; corrects an earlier reading — see §4).
- `kK()` total payroll = sum of `F.fj()` (wage) over the senior squad `nd` and the junior list `ne` (`best/ah.java:1718-1731`; rosters: `kc()`/`nd` at `best/ah.java:300-302`, `ky()`/`ne` at `best/ah.java:1309-1311`).
- `kJ()` pays the payroll: `f(kK())` (`best/ah.java:1714-1716`).

## 4. Salaries

### 4.1 Schedule

- Event registration happens when the calendar for a year is built (`f.r(int)` at `best/f.java:1923-1942` ends with `this.aS()`).
- `aS()` (*observed*, `best/f.java:1944-1964`):
  - `a.d()` = list of all days with day-of-month `== 2` (`best/a.java:122-132`).
  - `a.c(1)` = list of all days with weekday `== 1` (Sunday) (`best/a.java:106-116`).
  - `payDays = salarioMensal ? a.d() : a.c(1)` — wages are paid on the **2nd of every month** (option `salarioMensal = true`) or **every Sunday** (`false`).
  - broadcast `b(dayIndex, 2, 0)` ("ds") on each payday, `b(dayIndex, 5, 0)` ("dJ") on every 2nd-of-month day (interest), `b(dayIndex, 3, 0)` ("aj") on every Sunday (weekly evolution).
- Event names (`best/a.java:533-565`): `1`="cw", `2`="ds", `3`="aj", `4`="cD", `5`="dJ", `6`="cS", `7`="cO", `8`="cSempregado", `9`="cPromocao", `10`="criaMataMataAscenso", `11`="criaplayOffRebaixamento".
- Dispatch `f(int)` (*observed*, `best/a.java:567-612`): `"ds"` → `n()` pay salaries; `"dJ"` → `o()` pay interest; `"aj"` → `c.a.SR.aT()` run weekly evolution; `"cw"` → `p()` (sponsor/unknown, see open questions); `"cD"` → regional/estadual match generation (`m()`/`l()` depending on options `bk()`/`X()`); `"cS"`/`"cSempregado"` → national-team player selection; `"cPromocao"` → run promotion job market (`afQ.zw()`); the final `else` only evaluates `criaplayOffRebaixamento` without acting (dead branch, `best/a.java:605-607`).

### 4.2 Payment rule

- `n()` (*observed*, `best/a.java:702-710`): on a payday, every club that `bY(month)` (has at least one scheduled match in that month — `best/ah.java:2226-2235`) pays `kJ()` (full payroll). Clubs without a match that month skip payment.
- Frequency effect on total outflow: with monthly wages the wage figure is `n3*4` (a quarter's worth), with weekly wages it is the raw figure (`best/F.java:972` in `fJ()`). So the yearly burden is the same in both modes; the option only changes **when** cash leaves — *inferred*: see §22 for the transferencias-spec value formula.

## 5. Interest and loans

### 5.1 Interest

- `eP()` (*observed*, `best/C.java:234-236`): after any loan change, `dX = dW > 0 ? round(dW*3/100) : 0`. The 3% is a hard-coded monthly rate.
- `o()` (*observed*, `best/a.java:712-720`): on every "dJ" day (2nd of each month), every club with a ledger with positive interest pays `w(dX, 4)` (category 4, `dT`). Only clubs with a ledger (humans) are affected at the ledger level; AI clubs do not hold the ledger object (the check `kL()!=null`).

### 5.2 Borrowing and repayment

- Repayment `l(ah)` (*observed*, `best/C.java:212-220`): if the club owes money (`dW > 0`) **and** cash `>= 500000`, the ledger reduces `dW` by 500000, the club pays `w(500000, -1)` (expense "other", `dU`), and interest is recomputed. Returns `true` on success.
- Borrowing `m(ah)` (*observed*, `best/C.java:222-232`): caps by division — `{1000000, 5000000, 3000000, 2000000, 1500000}[div]` (division 1→5M, 2→3M, 3→2M, 4→1.5M; every other value, e.g. division 0, uses index 0 = 1M). If the outstanding `dW` is below the cap, the club borrows another 500000 (credit `v(500000,-1)`), `dW += 500000`, interest recomputed.
- **Sign convention quirk** (*observed*): income category `-1` is ignored by `h` (no income entry), so borrowing **increases** `nb` without any income ledger row, while repayment shows up as an expense in `dU`.
- No bankruptcy exists in this area: the credit is granted whenever cash is below the requested value and the cap is not reached, regardless of debt size.

## 6. Season verba, grants and first-season cash

- `aq.sC` (constraints, `long[5][2]`, `best/aq.java:658`): `{3500000,2000000}`, `{15000000,12000000}`, `{12000000,10000000}`, `{10000000,7000000}`, `{3500000,3000000}` — index 0 = a first bound, index 1 = a lower bound (see `kH()` and open questions).
- `aq.sD` (grants, `int[5][2]`, `best/aq.java:659`): `{3500000,3500000}`, `{6000000,6000000}`, `{4500000,4500000}`, `{2500000,2500000}`, `{2000000,2000000}` — index 0 is the season verba banked via category 6 (`dO`).
- Human grant `kG()` (*observed*, `best/ah.java:1690-1697`): if the club is **not** Brazilian (`pais != 29`) and the estadual competition is on, the club receives `+3.2 * payroll` on top of the current balance (`nb += 3.2*kK()`); then, for division 0..4, credits `v(aq.sD[div][0], 6)` (verba, income bucket 6).
- AI-club setup `kH()` (*observed*, `best/ah.java:1699-1706`): sets **cash exactly** to `aq.sC[div][0]` (e.g. division 0 → 15M, division 3 → 10M), then adds `3.2*payroll` for non-Brazilian clubs with estadual on, and records the verba `sD[div][0]` into the ledger (for human players' viewing).
- New-game `f.aU()` (*observed*, `best/f.java:2002-2019`): all existing players get `fI()` (initial value/wage adjustment), and every AI club runs `kp()` (squad balancing, §17) plus `kH()`.

## 7. Stadium model (`best.v`)

### 7.1 Structure and capacity split

- A stadium has 4 sectors in order `[0]` Geral (stands), `[1]` Arquibancada, `[2]` Cadeira, `[3]` Camarote (labels in `a/cq.java:86`).
- Fields (*observed*, `best/v.java:19-24`): `dm` name; `dn[4]` current capacities; `do[4]` current ticket prices; `dp` flag (false ⇒ prices are "custom" and auto-adjusted, see §8); `dq` stadium "type" code 0..3; `pais`.
- Capacity split `N(int total)` (*observed*, `best/v.java:78-87`): if total is outside 1000..120000 it is forced to 10000; sector fractions are `0.15 / 0.75 / 0.09 / 0.009`, with Arquibancada as remainder: `dn[1] = total - (dn[0]+dn[2]+dn[3])`.
- Total `dW()` = sum of all sectors (`best/v.java:294-296`); `f(sector, delta)` adds seats (used when an expansion completes) (`best/v.java:298-300`); `dT()` returns `dn` (`best/v.java:270-272`).
- Default prices are chosen in the constructor: `do = v.a(1, club)` (league prices by division) for the club constructor, or `aq.qK[1][1]` for the free/empty-stadium constructor (`best/v.java:29-41`).
- Stadium "type" `dq` is PRNG-chosen from reputation: rep≥4 → 5% large; rep 3 → 50% medium / 5% large; rep 2 → 50% medium / 15% large / 1% extra; else spread among 0..3 (`best/v.java:43-71`). `i(ah)` re-rolls it on relocation (70% medium, else small — both branches identical: `rep>=4 ? (70?1:0) : (70?1:0)`) (`best/v.java:73-76`) — see open questions.

### 7.2 Ticket prices by competition (`aq.qK`)

- `v.a(compType, club)` picks a 4-sector price array (*observed*, `best/v.java:239-260`), default `{10,25,35,50}`; type `10` is normalized to `2`; continent `gg()` > 1 is flattened to 1. Dispatch:
  - type `1` (Nacional league): `aq.qK[1][division]`
  - types `2` (Copa) / `3` (Estadual): `aq.qK[type][reputation]`
  - types `4`/`6`/`8` (Int1, Int2, Recopa): `aq.qK[type][continent]`
  - types `5` (Mundial) / `7` (Seleções): `aq.qK[1][division]`
  - anything else: `{10,25,35,50}`
- `aq.qK` table (`best/aq.java:539`), each inner row is `[Geral, Arquibancada, Cadeira, Camarote]`:

| Index | Used for | Rows (selector) | Values |
|---|---|---|---|
| 0 | Amistoso | 1 | `{5,15,20,30}` |
| 1 | league / Mundial / Seleções | 5 (division 0..4) | `{3,12,15,30}`, `{10,15,25,80}`, `{7,13,20,70}`, `{5,12,17,40}`, `{3,12,15,30}` |
| 2 | Copa | 6 (reputation 0..5) | `{3,12,15,30}`×3, `{7,13,20,70}`, `{10,15,25,80}`×2 |
| 3 | Estadual | 6 (reputation 0..5) | `{3,5,12,20}`, `{3,12,15,30}`×2, `{5,12,20,50}`, `{10,15,25,70}`×2 |
| 4 | International 1 | 2 (continent) | `{30,45,65,200}`, `{20,35,55,150}` |
| 5 | Mundial | 1 | all zeros |
| 6 | International 2 | 2 (continent) | `{20,25,45,150}`, `{20,25,40,120}` |
| 7 | Seleções | 1 | all zeros |
| 8 | Recopa | 2 (continent) | `{20,25,45,150}`, `{20,25,40,120}` |

### 7.3 Expansion capacity horizons (`aq.pa`)

`aq.pa` (`best/aq.java:107`) = `{Geral,Arquibancada,Cadeira,Camarote}` maxima per tier:

| Tier | Geral | Arquibancada | Cadeira | Camarote |
|---|---|---|---|---|
| 0 (default) | 18000 | 80000 | 9000 | 700 |
| 1 | 20000 | 100000 | 10000 | 800 |
| 2 | 22000 | 110000 | 10000 | 900 |
| 3 | 25000 | 120000 | 10000 | 1200 |

The argparse in the expansion dialog selects the horizon with `if H() >= 2 → pa[1] else if H() >= 6 → pa[2] else if H() >= 10 → pa[3]` (`a/cq.java:69-75`) — an **else-if bug**, see §9 and §22.

## 8. Attendance and match-day revenue

Full simulation lives in `re/spec-partidas.md` §9; what follows is only the part that touches finances.

- `v.b(I)` computes, per sector, the attendees `nArray3` and banks the total revenue on the match object (`best/v.java:89-233`):
  - per-sector base attendance by home **reputation** rows `{200,500,50,0}`, `{1000,5000,1200,20}`, `{2000,10000,1500,50}`, `{4000,20000,2500,300}`, `{4500,30000,3500,400}`, `{5000,40000,5500,500}` (`best/v.java:105-123`);
  - attendance multiplier `d2`: base `0.3`; `+0.15` when the match format is knockout (`i2.ht() instanceof z`); `+0.3` for types 4 (Int1), 7 (Seleções), 9 (Eliminatórias); `+0.15` for types 6, 8, 11 (Int2, Recopa, Supercopa); venues capped at capacity (`best/v.java:138-153,220-222`);
  - Estadual (3) / Regional (10) matches: `*0.7`; Amistoso (0): `*0.4` (`best/v.java:124-137`);
  - opponent-reputation adjustment `d3` from `{0,.05,.1,.15,.2,.25}[|Δrep|]`: if the home team is stronger all sectors gain that percentage, weaker lose it (`best/v.java:154-170`);
  - home-manager popularity `al.lM()` (fans) scales all sectors by `fans/100` (`best/v.java:171-180`);
  - random noise `+rand(0..n2)` per sector, `n2` from a division table `{10,20,5,0}`, `{100,500,200,10}`, `{300,1000,400,20}`, `{400,1200,500,30}`, `{500,1500,1000,50}` (`best/v.java:181-199`);
  - custom-price adjustment: when `dp` is false, current `do` prices are compared against the desired `v.a(...)` prices and each sector's price moves by `round(0.03 * price) * diff` in the matching direction (`best/v.java:200-214`);
  - revenue `n4 = Σ attendees*price`; Seleções (7) `*3`, or `*5` when `el() == 7`; Eliminatórias (9) `*2` (`best/v.java:226-230`); stored via `i2.aW(n4)` (`best/v.java:231-232`, `best/I.java:1456-1458`).
- Banking: `I.hf()` credits `hc().v(fE, 5)` (income bucket 5) **except** for Mundial (5) and Seleções (7) matches (`best/I.java:383-387`).

## 9. Stadium expansion (`a.cq`, `best.B`, `best/f.ax/aw`)

### 9.1 Ordering an expansion

- Dialog inputs: 4 `JSpinner`s (one per sector), each limited to `0..(horizon[i] − current[i])` (`a/cq.java:79-106`).
- Quote `oH()` (*observed*, `a/cq.java:114-139`): if all spinners are 0 → aborted; otherwise `Ct = Σ I(sector, added) + 100000` and duration `days = cZ(totalAdded)`; the dialog shows `C.c(Ct)` and the projected finish date.
- Sector cost `I(sector, added)` (*observed*, `a/cq.java:169-184`): unit price depends on the **tier reached by the new total** `n4 = current + added` (first tier boundary `≥ n4`):

| Sector | Unit prices per tier (0..4) | Tier boundaries |
|---|---|---|
| Geral | `{80,160,240,500,700}` | `{1000,2500,3500,10000,18000}` |
| Arquibancada | `{120,380,640,700,1400}` | `{5000,15000,30000,60000,80000}` |
| Cadeira | `{300,600,750,800,1200}` | `{1000,2000,3000,5000,9000}` |
| Camarote | `{1500,3500,4000,6000,6400}` | `{100,200,500,600,700}` |

  cost = `unitPrice[tier] * added`.
- Duration `cZ(totalAdded)` (*observed*, `a/cq.java:156-167`): `<1000` → 15 days, `<10000` → 20, `<30000` → 30, else 40.
- Confirmation `oI()` (*observed*, `a/cq.java:141-154`): if cash `< Ct` → message "Sem dinheiro para essa expansão" and aborts; else creates a `best.B` job (stadium ref, completion `Calendar`, `[4]` added seats), pushes it onto `SR.bw()`, debits `w(Ct, 7)` (expense bucket 7).

### 9.2 Completion

- `best/B.java` stores `{v, Calendar, int[4] seats}`; `ex()` adds the pending seats to the stadium via `v.f(sector, n)` and zeroes them (`best/B.java:13-46`).
- `f.aw()` (*observed*, `best/f.java:1606-1626`): every day, all jobs whose deadline is **before** the current date complete (`ex()` then removed from `aw`).
- `f.ax()` (*observed*, `best/f.java:1628-1658`): the daily routine that among other things calls `aw()` when jobs exist (`best/f.java:1640-1642`).

### 9.3 Known defect

The horizon selection `if H>=2 … else if H>=6 … else if H>=10` (`a/cq.java:69-75`) means the `pa[2]` and `pa[3]` horizons are unreachable: for any season ≥ 2 the dialog always caps at `pa[1]`. *Inferred* intent was successive unlocks (season 2, 6, 10). See §22.

## 10. Negative cash

There is **no bankruptcy or forced-sale mechanism** anywhere in this area. Being in debt has exactly these consequences (*observed*):

1. **Manager confidence penalties** on match day, only when the human manager's club is in debt (`fg().kb() < 0`): `-10` confidence for Nacional (type 1), `-5` for Estadual/Regionais (types 3 and 10), `-5` for Int1/Int2 (types 4/6), `-5` for everything else (`best/al.java:256-258,306-308,355-357,404-406`).
2. **Firing reason** when dismissed: a human manager whose club is in debt gets reason `"você estava levando o clube para o abismo financeiro."` (`f/s.java:1727`, strings `aq.sg[1]` at `best/aq.java:570`).
3. **Balancing check** `w/v/f` do not prevent the balance going negative.

## 11. Manager career (`best.al`)

### 11.1 State

| Field | Getter | Meaning (*observed / inferred*) | Line |
|---|---|---|---|
| `of` | `lL()` | confidence, default 95, clamped 0..100 | `best/al.java:43,677-679,144-151` |
| `og` | `lM()` | fan support, default 85, clamped 0..100 | `best/al.java:44,685-687,153-159` |
| `oi` | `lR()` | seasons at the current club (incremented each season-end) | `best/al.java:49,1044-1054,1052-1054` |
| `oc` | `lI()` | career points tally (prizes + match coefficients) | `best/al.java:39,661-663` |
| `W` | `A()` | career matches | `best/al.java:40,665-667` |
| `od` / `oe` | `lJ()` / `lK()` | career wins / losses | `best/al.java:41-42,669-675` |
| `nc` | `getReputacao()` | manager reputation 0..5 | `best/al.java:45,693-695` |
| `nu` | — | prize-money / prestige accumulator (drives reputation) | `best/al.java:46` (`al.a(...)` / `kk()`) |
| `cA` | `cT()` | trophy history (`ao` records) | `best/al.java:47,995-997` |
| `ob` | `lO()` | per-season records (`best.j`, keyed by club+season) | `best/al.java:38,788-790` |
| `oh` | — | message list (`components.as`) | `best/al.java:48` |
| `hy` / `jo()` | | club of the national team being managed | `best/al.java:36,999-1001` |

### 11.2 Match-day confidence/fan deltas (`a(I, bl2, n2)`, `best/al.java:162-530`)

- Determines who the manager manages (home `hc` vs away `hd`), computes the manager's club result and whether home (`bl5`).
- Draw handling: if the manager's team is at least as strong (`n6 >= 0`) and not away → `cj(-1)` confidence and `ck(-1)` fans; if weaker home → `cj(+1)` (`best/al.java:217-223`). Losses: at home vs equal/stronger → `cj(-3), ck(-3)`; loss away vs equal/stronger → `cj(-1)` (`best/al.java:224-231`).
- Position band: for league/estadual types (1, 3), `n8 = nArray[1]` from `ah.p(at)` (`best/ah.java:1582-1614`): 1 champion, 2 top zone, 3 mid-table, 4 lower-mid, 5 relegation zone; `nArray[2] == -1` when the club is not in a table. For no-table/manual-result cases (`bl2`, `n2>=1`) the code substitutes band 1 (`best/al.java:232-253`).
- Per-type confidence tables indexed by `[result 0=draw,1=win,2=loss][band]` (`best/al.java:254-453`):

| Type | Win (band 1..5) | Draw (band 1..5) | Loss (band 1..5) |
|---|---|---|---|
| 1 league | `{0,5,4,1,1,0}` | `{0,2,1,-1,-1,-3}` | `{0,-2,-2,-3,-5,-7}` |
| 3 / 10 estadual-regional | `{0,2,2,1,1,1}` | `{0,1,1,0,0,-1}` | `{0,-2,-2,-3,-3,-5}` |
| 4 / 6 international | `{0,5,4,3,3,3}` | `{0,2,1,0,-1,-3}` | `{0,-2,-2,-3,-3,-5}` |
| other (2,5,7,8,9,11..) | `{0,5,4,1,1,0}` | `{0,2,1,-1,-1,-3}` | `{0,-2,-2,-3,-5,-7}` |

  Home (away) uses the home (away) table of columns; a 3+ goal margin adds fan deltas: win home `+4`/away `+5`, loss home `-7`/away `-5` and can trigger message `as(27,81,...)`/`as(6,46,...)` (`best/al.java:480-516`).
- Additional rules (*observed*): fans `< 20` → confidence `-3`; final clamp 0..100 (`best/al.java:517-529`). Negative cash penalties from §10 are applied here too.

### 11.3 Match record coefficient (`e(I)`, `best/al.java:538-659`)

For each managed match the manager gains career points `oc` via `j.B(winCoef)` + match counters. Win coefficients by competition type: league 1st→4 down to 5th→1, copa 4, estadual 2/1, Int1 5, Mundial 7, Int2 4, Seleções 8, Recopa 4, Regionais 2, Supercopa 2, Conference 3, Eliminatórias 2, Finalíssima 5, Liga Nações 6; away wins and certain draws add 1 (`best/al.java:572-654`). Draw coefficients are generally smaller (1..2).

### 11.4 Season record and club firing threshold

- Per-season records `lO()` are keyed by club and season (`best/al.java:126-142`).
- End of season, fired/non-human filtering uses the previous season's record `j`: win rate `n4 = wins*100/games` (`best/ag.java:64-72`).

### 11.5 Trophies (`b(at, position, ...)` and `q(at)`)

- Prize points by competition type and final position table (`best/al.java:792-912`); champion → `q(at)`.
- `q(at)` (*observed*, `best/al.java:920-993`): league/estadual title → `ck(+20), cj(+15)`; league champion additionally repeats `ck(+20)`, `cj(+15)`; non-champion podium → `ck(+20), cj(+10)`; Copa (2) / Int1 (4) / Mundial (5) / Int2,Conference (6,12) winner → `ck(+30), cj(+30)`; Supercopa (11) → `ck(+10)`; Seleções world titles also award via the international branch. Records an `ao` record into `cA` and emits messages `as(24/25, 76..78, ...)` for humans (`best/al.java:970-992`).

### 11.6 Manager reputation (`a(n2,n3,n4,bl2,n5)` and `kk()`)

- Prize/prestige points `nu` accumulate from a table keyed by manager-reputation row (`best/al.java:1064-1106`): league 600/150, copa 500/150, estadual 30/5, Int1 6000/1000, Mundial 10000/1000, Int2 2000/500, Eliminatórias 500, Regionais 50, Supercopa 100, Conference 3000/300, Finalíssima 3000/500, Liga Nações 20000; only the top reputation row uses high values; if `n6 > 1000` and not some flag and `n5 > 1` → `*0.6`; league division > 1 → 50. Note several cells use index quirks (see open questions).
- `kk()` (*observed*, `best/al.java:1108-1149`) — reputation drift: tiers decay daily (rep 5 → −6000/day down to rep 2 −5/day only when the club is `kn()`), promotion `nu>22000→5`, `>10000→4`, `>1000→3`, `>100→2`, `>10→1`, never demoting below current.

### 11.7 Take-club, resign, retire

- `E(ah)` take a club (*observed*, `best/al.java:761-782`): binds manager↔club; resets `of=95`, `og=85`, `oi=0`; human: club added to the global club list, all senior players get `a(180, true)` (180-day contracts, `best/F.java:1171+` region — contract extension semantics); stadium prices re-initialized with `ev().i(ah)`; welcome message `as(0,74,clubName,"")`.
- `i(al)` leave/resign (*observed*, `best/al.java:732-759`): builds a transfer `u` order, records `this` in `SR.bn()` (the "sem clube" listing), resets country/division via `lN()`, and if human removes the club from the human-controlled set and marks it AI (`M(true)`).
- `D(ah)` + `bZ` counts a club change-over (used in `f.jA` promotions), `best/al.java:532-536`.

## 12. Firings and replacement

### 12.1 Firing trigger (`f/s.A`, `f/s.java:1720-1741`)

For each team in a division table with a human/AI manager whose confidence `lL() < 10`:
- **Human** manager: fired always; reason `n3 = cash < 0 ? 1 : rand(2)+2` → `aq.sg[n3]` (1 = "abismo financeiro", 2 = "pressão da torcida", 3 = "resultados"); initial value is 2 then overwritten (`best/s.java` no — `f/s.java:1725-1731`); replacement via `ah.kE()`; an `h` report is queued.
- **AI** manager: only if the team index `n2 > 5` (outside the top 6 of the listing); reason `rand(3)+1`; replacement via `ah.kE()` (`f/s.java:1732-1737`).
- Hazard note: the human branch fires **even when confidence is back above 10** if it was `<10` at read time — the check is one-shot per call.

### 12.2 Season-end routine (`ag.jQ()`, `best/ag.java:50-79`)

Clears `bn()` (unemployed list), increments each employed manager's `oi` (`lS()`), then for every AI manager free of a club? No — *observed*: for every manager with a club that is not human with `lR()>=1`, computes last season win rate from `lO()` and fires them when `rand(90)+1 > winRate` (i.e., a coin flip inversely weighted by the previous season's winning percentage), replacing via `kE()` (`best/ag.java:61-76`).

### 12.3 Replacement (`ah.kE()`, `best/ah.java:1616-1646`)

Tries, in order: `SR.a(club, 0)` (same country), `SR.a(club, 1)` (same continent), `SR.a(club, 2)` if `nc <= 3` (any, low budget), `SR.bh()` for humans (free agent with best reputation); for AI-only clubs it may swap managers between clubs found via `afQ.b(...)`.

### 12.4 The "no club" flow

Unemployed human managers receive offers generated by `ay.b(al, bl2)` (`best/ay.java:200-236`) and `ay.zw()` picks them up (`best/ay.java:238-247`); the dismissal message `as(...)` records the outcome. Season-change instrumentation: `f.aa()` calls `c.a.afQ.zi()/zj()` (rebuild unemployed/job pools) and `ag.jO()/jQ()` (`best/f.java:551-554`).

## 13. Job market (`best.ay`)

- Per-country offering lists `Jg` (national job categories) / `Jh` populated from every AI club's country (`best/ay.java:25-35`), rebuilt each season via `zi()` (`best/ay.java:37-42`) and extended at `zj()` with the lower half of each division table (`best/ay.java:164-198`).
- Offer selection `a(al, bl2)` weighs clubs by the manager's reputation with the fixed pattern `{{2,1,1,1,1},{2,2,1,1,1},{3,2,2,1,1},{4,3,2,2,1},{5,4,5,3,2},{5,4,4,3,2}}` — the desired club reputation per offer count, modulated by continent and the previous club's pull (reputation of the club he currently manages if higher) (`best/ay.java:44-155`).
- `c(al, bl2)` (static) builds the market candidate list from each country's top division (`zd()`) with quotas per continent, plus meta (promotion/relegation) windows (`best/ay.java:249-400+`).

## 14. Weekly player development (`best/F`)

### 14.1 Entry point

`f.aT()` (*observed*, `best/f.java:1974-2000`) runs on the weekly "aj" event:
- if individual skills are on and the training mode counter `bO() == 3`, each AI club re-rolls its per-position training focus (`lj()`);
- every senior player in `ag` runs `fV()`; every junior in `ah` (the youth list) runs `fY()`;
- if individual skills are on, the training-mode counter advances (`bP()`) or resets to 0 when it reaches 3 (`A(0)`).

### 14.2 Growth `fV()` (seniors, `best/F.java:1211-1220`) and `fW()` (the actual growth, `best/F.java:1314-1443`)

- Growth rate base `d0 = 50` and `nivel` from the club; for non-`kn()` clubs level is remapped from reputation (≥4 → 20, 3 → 18, else 12) and a club bonus `+0.03` is added (`best/F.java:1315-1324,1383-1385`).
- Per-age-band multipliers `/d0` (`best/F.java:1325-1326`):

| Club level | <18 | 18-20 | 21-28 | ≥29 |
|---|---|---|---|---|
| ≥19 | 8 | 6 | 5 | 4 |
| 15-18 | 6 | 5 | 4 | 3 |
| 11-14 | 5 | 4 | 3 | 2 |
| ≤10 | 4 | 3 | 2 | 1 |

- `+0.04` when the player played in the last week (`eL`) (`best/F.java:1327-1329`); ability-band penalties `−0.02/0.03/0.04/0.05` for `eq` 30..40/41..50/51..70/71..100 (`best/F.java:1330-1338`); junior-list penalty `-0.05/<50` or `-0.02/<70`, with `+0.07`/`+0.05` for potential ≥9/≥7 (`best/F.java:1339-1350`); `+0.02` for stars / `+0.01` for top World players (`best/F.java:1351-1355`); continental modifiers (Africa/Asia capped `-0.02`, Oceania `-0.04`, Concacaf `-0.03`, South America `-0.02`, top Europe `+0.01`) (`best/F.java:1356-1382`); floor `0.01`.
- Accumulator `eM += d4`; applied with two caps: a club cap (league/division × reputation matrix, or rep-based `100/100/70/40/30/20`) and a country cap (per-continent; e.g. Brazil 95, Germany/France 90, England 80, Spain 70, top-of-Europe 95) — the player only gains when `eq < min(cap)` (`best/F.java:1389-1442`). Junior potential (base skill ≥60) pushes the cap up by 5..30 depending on potential tier (`best/F.java:1390-1431`; also mirrored in `b(...)` at `best/F.java:1263-1312`).
- Displayed potential `fZ()`: 15% exact, 45% minus 1, 40% plus 1, clamped 1..10 (`best/F.java:1524-1535`).

### 14.3 Individual skills path (`e(double)`, `f(double)`, `b(...)`)

When `habilidadeIndividual` is on, the weekly gain is apportioned through the per-skill vectors `eA..eG` (GK handling, defense, midfield, attack, speed, technique, passing) rather than a single `eq` (`best/F.java:1386-1388`, `1476-1478`, `1222-1261`). Each skill only advances when its acceptance test `b(d2, skill)` passes (skill < cap) with the same caps as `eq` (including the rep-based club cap and country cap, and the junior potential boost) (`best/F.java:1263-1312`).

### 14.4 Decline `fX()` (age ≥ 32, `best/F.java:1445-1487`)

- Intensity by ability: `eq` 1..50 → `0.7×(age−31)`, 51..70 → `1.0×`, 71..100 → `1.2×`; participation level `d5 = age−31`, `−2` at level ≥20 clubs; divided by 50; floors by division/rep: division 1 → 35, division 2 → 25, division 3 → 10, non-`kn()` rep<2 → 1 (`best/F.java:1451-1474`). The weekly skill decrement happens when `eM > 1 && eq > floor` (`best/F.java:1475-1482`).

### 14.5 Juniors (`fY()`, `best/F.java:1489-1522`)

Only for players ≤ 20. Weekly rate 0.01 plus by age `20/40` (≤17), `15/40` (18), `14/40` (19), `5/40` (20); potential tiers add `+0.03`(≤3), `+0.04`(≤6), `+0.07`(≤8), `+0.1`(9), `+0.11`(10) (`best/F.java:1491-1512`). `fd` only grows when the junior accumulator `fe > 1` (`best/F.java:1513-1521`).

### 14.6 Junior base (`ga()`, `best/F.java:1537-1558`)

Initial `fd`: age 16 → 15, 17 → 35, 18 → 55, 19 → 70, 20 → 75; `+rand(5)+1`; `+potential`; clamped 1..95.

### 14.7 Retirement and aging (`ge()`, `a(String,int,bool)`, `F.a(...)`)

- `ge()` (*observed*, `best/F.java:1588-1656`): for players > 32, an effective age `n3` reduced by −1 for top players, −3 for stars, −3 for GK position; random threshold by band — 32: `rand>99`, 33-34: `>90`, 35: `>55`, 36: `>30`, 37-38: `>15`, 39: `>5`, 40: `>3`, 41-42: `>2`, 43-48: `>1`, ≥49: always; on retirement: AI players removed, human-club players send message `as(34,89,name,"")` (retirement notice) and are removed via `a(null,-1,true)`.
- `a(String,int,bool)` (*observed*, `best/F.java:1658-1749`): removes a player from his club; AI players may randomly convert to a new manager (`al`) on retirement; junior regen follows `bS` (senior count) templates `{2,3,3,6,4}` and youth size checks; retirement entry into news history `b(...)` on age thresholds; the club immediately tries to replace via `F.a(club, ...)` when following rules (`kx()>=20` etc.). Regen registration goes into `SR.bz` (seniors) or `SR.bA` (juniors) lists.
- Aging pipeline at season end: `af()` (`best/f.java:1050-1103`) ages every senior (`gd()`) and junior (`gf()`), then recomputes value and wage (`fK()`, `fJ()`) for all free agents.
- `a(...)` newgen factory (`best/F.java:1780-1897`): potential roll 1..10 weighted by club level/reputation; `fd` via `ga()`; position via `F.at(position)`; name via `F.au(pais)`; starting wage/value via `fJ()/fK()` (see §22 mapping to `PlayerEconomics.Recalculate`).

## 15. Individual skills and training

### 15.1 Skill vectors and generation

- Senior skill set: `eA` (GK), `eB` (def), `eC` (mid/attack centrepiece), `eD` (attack), `eE` (speed), `eF` (technique), `eG` (passing) — exposed by accessors `gK/gJ/gL/gM/gN/gO/gP` at `best/F.java:3087-3141` (`gK`→`eA`, `gJ`→`eB`, `gL`→`eC`, `gM`→`eD`, `gN`→`eE`, `gO`→`eF`, `gP`→`eG`, each with a matching `a*` setter). The overall ability getter is `fi()` (`best/F.java:244-246`). Note `gI()` also exists but returns `ej`, a different field, not a skill vector (`best/F.java:2938-2940`).

- `F.j(n2,n3)` (*observed*, `best/F.java:685-913`) generates all seven skills from the positional pair `(n2=def component, n3=att component)`, per position (`en` 0..4) with position-role adjustments keyed on `ey/ez` role codes (0 GK, 1..13 field roles), clamping each to 100. This runs whenever a player is created/recalibrated while individual skills are enabled (`best/F.java:677-679`, inside the same constructor).
- Skills displayed instead of a single overall where the option is active (`components/ao.java:329-331`).

### 15.2 Training focus

- Per-club state: `nB` (per-position focus `1..3`) and `nC` (`[pos][3]` accumulated weekly focus weights) (`best/ah.java:91-92`); `u(pos, value)` is the writer (`best/ah.java:698`).
- Auto mode: when `habilidadeIndividual && bO()==3` each AI club re-rolls focus with `lj()`: for each of the 5 outfield positions, `u(pos, 1+rand(3))` (`best/ah.java:2210-2216`). Human clubs keep the focus chosen in the training dialog.
- Training dialog `a/iQ.java`: `MY` checkbox = auto (`ll()` → `nt`), radio = focus mode (`lm()` → `ns`: 0 for primary abilities, 1 for secondary) (`a/iQ.java:38-59`). The `ll()` (auto) and `lm()` (mode) getters are `best/ah.java:2237-2247`.
- The training-mode counter `bO()` (`bh`) increments weekly and resets every 3 weeks (`best/f.java:2727-2737`, `1974-2000`).

### 15.3 Effect on weekly growth

Within `fW()`/`fX()`, when `bO()==3` the code routes growth through `c(d2*10, n2)` — the "universal training applies 10×" path for auto focus — vs the standard single-ability `h(d2)` path (`best/F.java:1222-1261`, `1245-1252`). Secondary-skill mode applies `×2` per skill (`best/F.java:1251`). See open questions for the exact multiplier semantics.

## 16. Season turnover pipeline (`best/f.aa()`)

Order of operations at season start (*observed*, `best/f.java:518-584`):

1. every club `kI()` — resets the ledger season buckets (`best/f.java:520-523`, `best/ah.java:1708-1712`);
2. international club competitions `ai()` if `jogaIntClubes`;
3. national teams `jw()` if `jogaSelecoesAll`;
4. `ah()` (season calendar/architecture), `ag()` (human club re-grant `kG()`; grant at `best/f.java:1195` region + `best/ah.java:1690-1697`);
5. `iZ()`, then `ae()` (club intl) if `jogaIntClubes`, `Y()` (estadual), `Z()`, `am()`, `ak()`, `aj()` (regionals if enabled);
6. playoff/knockout generation when enabled (`a.b(u,4,1)` at `best/f.java:543-545`);
7. `a.q()` (prize/trophy bookkeeping for the previous season);
8. `af()` — aging/retirement/regen and `fK()/fJ()` for free agents (`best/f.java:547`, `1050-1103`);
9. `W()` when season ≥ 5 — purge of stale market/history entries (`best/f.java:548-550`);
10. `ag.jO()` (AI roster maintenance, see below), `ag.jQ()` (manager firings) (`best/f.java:551-554`);
11. national-team rebuild, `ay` pools rebuild, transfer-window bookkeeping (`best/f.java:555-559`);
12. agenda/messages routing when a human manager exists (`best/f.java:560-583`).

### 16.1 `ag.jO()` = `jS`, `jU`, `jR`, `jP`, `jT` (`best/ag.java:22-28`)

- `jS()` — AI league-club reinforcement by table position (`best/ag.java:91-107`): each AI club gets `position<=1 ? 1 : position<=5 ? 2 : position<=10 ? 3 : 4` signings twice (strength and filler, via `ag.a(...)`).
- `jU()` — AI clubs not in the national top flight and not `kn()` receive `1..4` replacements (`best/ag.java:161-169`).
- `jR()` — squad restocking `ku()` for AI clubs below minimum size (thresholds `aq.qg[div]` for league clubs / `aq.qh[rep]` for others) (`best/ag.java:81-89`, `best/ah.java:1243-1256`); `aq.qg={1,40,30,20,5}`, `aq.qh={1,10,20,40,50,55}` (`best/aq.java:172-173`).
- `jP()` — AI squad trimming/transfer-listing (`best/ag.java:30-48`).
- `jT()` — AI sells surplus potential prospects (age <31, skill >50, not `kn`/rep≥5) to other clubs, at face value, twice with relaxed terms on failure (`best/ag.java:119-159`).

## 17. New-game initialization

- `f.aU()` (*observed*): `fI()` (wage/value recalc) for every player; then for every AI club `kp()` then `kH()` (`best/f.java:2002-2019`).
- `kp()` (*observed*, `best/ah.java:1153-1175`): AI squad balancing — demotes/exchanges surplus players when a position is over the target `{2,3,3,5,4}` with 50%+ chance, promoting juniors with 70% bias.
- New players are produced by `F.a(club, ..., ageFlag, ...)` (regen factory, `best/F.java:1780-1897`) with positional pair from `F.at(position)` (`best/F.java:1899-1926`), name from country lists `F.au/av` (`best/F.java:1928-2046`).

## 18. `est.Options` defaults

All defaults *observed* in the constructor (`est/Options.java:51-96`) and field declarations (`est/Options.java:13-49`):

| Option | Default | Notes |
|---|---|---|
| `jogaEstadual` | true | state championship on |
| `jogaRegionais` | true | regional cups on |
| `usaGrupoPadraoEstadual` | true | standard estadual groups |
| `jogaIntClubes` | true | club international competitions on |
| `jogaSelecoesAll` | true | national teams on |
| `jogaSelecoes[7]` | all true | per-competition toggle |
| `salarioMensal` | true | monthly wage payments |
| `habilidadeIndividual` | true | individual skill model |
| `jogaIntano1` | true | internationals in season 1 |
| `gruposIntPadrao` | false | standard intl groups |
| `verJint[21]` | true at 0,1,6..14,16..20; false at 2..5,15 | visibility of match views |
| `autoSalvar` | 0 | 0 off, 1 every 3 advances, 2 daily, 3 when flag set (`best/f.java:1371-1408`) |
| `velocidade` / `velocidadeNH` | 4 | sim speed human / non-human |
| `verDecisaoPenNaoHumano` | 0 |
| `verMudancaTecnicos` | 1 | view manager changes |
| `verJanelaSubs` | 1 | view transfer window |
| `avisoTerminoContrato` | 0 | contract expiry warning |
| `autoRenovaContrato` | true |
| `usaCorPlacar` | true, `corPlacar=0` |
| `usaSons` | true |
| `negritoCasa` | true |
| `usaCoresLista` | false, `coresLista=null` (5 beige defaults elsewhere) |
| `verEstaduaisAgrupados` | false |
| `ignoraLigas` / `ignoraEstadual` | true / true |
| `UsarGruposReaisCopa` | false |
| `jogaRegionaisTodos[4]` | all true |
| `conviteRegionais` | false |
| `regionaisSemHumanos` | 0 |
| `verMundias` / `verSuperCopas` | false / false |
| `novoFormatoCopa` | true |
| `corTema` | 0 |
| `verLeiloes` | false |

Options propagate into the game-state `best.f` at load (`best/f.java:297` region uses `c.a.vM().isHabilidadeIndividual()` etc.).

## 19. Saves, metadata, and messages

### 19.1 Save file layout

- Current saves: serialized via **Kryo** into `sav/<name>.s22`; `save/load` flows in `c/a.java:ae` (write) and the `.info` metadata (`c/a.java:90-106`) hold `InfoArquivoSalvoType`. Loading mirrors the same two streams (`c/a.java:241-270`).
- Save dialog validates a name of 1..15 characters and writes `sav/<name>.s22` (`a/fw.java:40-60`); legacy `.sav` detection exists (`a/fw.java:62-65`).
- `InfoArquivoSalvoType` fields: name, team (tc), season (a), and a string (`est/InfoArquivoSalvoType.java:11-46`).
- Autosave: `best/f.ap()` (`best/f.java:1371-1408`) writes on the advance counter while in a race when option 1, every advance when option 2, and when a separately toggled flag `bF()` is set under option 3.
- Files written every season change? At `best/f.java:551-552` `afQ.zi()/zj()` and message routing complete the cycle; the `.info` metadata is refreshed alongside game saves (`c/a.java:118-135`).

### 19.2 Messages (`components/as`)

- Message model `as` (*observed*, `components/as.java:13-58`): `RU` (type code), `RV` (tone/description code), `RW`/`RX` (text slot), `data` (creation date string from `a.SR.T()`), flags `RY`, `RZ`, `Se`, player name `Sa`, player-value code `oq` (`round(fj()*0.1)`), `Sc`, `Sc`/`Sd` codes, `Sb` text.
- Messages are appended to the manager's list `lQ()` when constructed (`components/as.java:47-58`).
- Occurrences relevant to this area: retirement `as(34,89,...)` (`best/F.java:1651`), humiliation `as(27,81,...)` (`best/al.java:488`), heavy loss `as(6,46,...)` / `as(5,47|48,...)` (`best/al.java:505-509`), new-club `as(0,74,...)` (`best/al.java:772`), achievements `as(25,76,...)`, `as(24,77,...)`, `as(25,78,...)` (`best/al.java:986-991`), future star notices `as(3,23..43,...)` (`best/F.java:2141-2157`).

## 20. Remaining `aq` resources in this area

Constants not covered by the other two specs but consumed by the systems above (*observed* values):

| Constant | Line | Value(s) | Used by |
|---|---|---|---|
| `aq.sD` | `best/aq.java:659` | season verba per division (see §6) | `ah.kG/kH` |
| `aq.sC` | `best/aq.java:658` | AI first-cash / lower bound per division | `ah.kH` |
| `aq.qK` | `best/aq.java:539` | default ticket prices per competition (see §7.2) | `v.a` |
| `aq.pa` | `best/aq.java:107` | expansion capacity horizons (see §7.3) | `a/cq` |
| `aq.qg` / `aq.qh` | `best/aq.java:172-173` | minimum squad size thresholds | `ah.ku` |
| `aq.sg` | `best/aq.java:570` | dismissal reasons (4 strings) | `f/s.java` |
| `aq.pY` | `best/aq.java:164` | regional cup names | regionals UI |
| `aq.tz` | `best/aq.java:848` | competition display names by type | match/UI |

## 21. Obfuscated name mapping

- `best.f` == `c.a.SR`, the persistent game state ("saving room").
- Money: `ah.nb` ≡ current cash (`kb()`), `ah.nx` ≡ ledger (`kL()`), `ah.v/w/f(long)` ≡ income/expense/salary primitives; `F.fj()` ≡ wage, `F.fk()` ≡ market value.
- Ledger: `C.h/i/b` ≡ income/expense/salary recorders; `C.dW/dX` ≡ loan balance / monthly interest; `C.eP()` ≡ `RecalculateInterest`; bucket fields see §2.1.
- Manager: `al.of` ≡ confidence; `al.og` ≡ fan support; `al.oi` ≡ seasons-at-club; `al.oc` ≡ career points; `al.W/od/oe` ≡ games/wins/losses; `al.nc` ≡ reputation; `al.nu` ≡ prestige accumulator; `al.cj/ck` ≡ delta confidence / delta fans.
- Player development: `F.fV/fW` ≡ weekly growth (senior); `F.fX` ≡ decline; `F.fY` ≡ junior growth; `F.fZ` ≡ displayed potential; `F.ga` ≡ junior initial potential; `F.j(int,int)` ≡ regenerate individual skills; `F.fd/fe` ≡ junior (potential) value / accumulator; `F.eq` ≡ overall skill; `eA..eG` ≡ GK/Def/Mid/Att/Spe/Tec/Pas; `eM` ≡ growth accumulator.
- Training: `ah.nB/nC` ≡ per-position focus / weekly accumulation (`u(pos,val)`); `ah.nt/ns` ≡ auto/primary-secondary focus flag; `f.bh` ≡ training-mode week counter (`bO/bP/A`).
- Stadium: `v.dn` ≡ capacities; `v.do` ≡ current prices; `v.dp` ≡ "use default prices" flag; `v.dq` ≡ stadium type; `B.dJ` ≡ pending seats.
- Career plumbing: `f.aa()` ≡ `PlayerEconomics.Recalculate` wire-up is *not* present in Java; the port's `PlayerEconomics.Recalculate` maps to `F.fK()`/`F.fJ()` (value/wage recalculation) run in `best/f.java:1098-1101` and inside newgen `best/F.java:1893-1895`.
- Contract days: `F.a(180, true)` ≡ extend contract by 180 days (`best/al.java:778`); `F.fR()` ≡ days remaining (`best/F.java:1117-1120`).

## 22. Quirks and open questions

- **Expansion horizon else-if bug** (*observed*): `a/cq.java:69-75` means `pa[2]` and `pa[3]` can never be selected; *inferred* intent is season unlocks at years 2/6/10.
- **AI wage payment** (*observed*): `a.n()` pays every club and `ah.f(long)` reduces `nb` for AI too (`best/ah.java:1683-1688`); only human clubs get a ledger row. Earlier notes said "AI never pays" — that is wrong; AI cash is reduced but untraceable.
- **Loan accounting asymmetry** (*observed*): borrow is `v(500000,-1)` (income cat `-1` ignored by `C.h`, invisible in the ledger), repayment is `w(500000,-1)` (goes to `dU` "outros"). The loan itself is only visible via `dW`/`eN()`.
- **Interest edge** (*observed*): `dX` is recomputed only on `l/m/eP`; it can also be set externally via `W(int)` (`best/C.java:242-244`) — weekly vs monthly schedules are never re-based, so a mid-month loan change shifts the payment list silently.
- **No bankruptcy** (*observed*): negative cash affects confidence and dismissal reasons only (§10).
- **`aq.sC[div][1]`** is never read in this area — *open question*: what consumes the second column ("lower bound")?
- **Dead `else` in `f(int)`** (*observed*): `criaplayOffRebaixamento` (`11`) is evaluated but not executed (`best/a.java:605-607`).
- **`C.dK`/`dN`/`dR`/`dV`/`dP` writers** not found in this area — *open question* which subsystems fill income buckets 1/9 and expense buckets 1/8.
- **`ck` draws at home/away**, the margin message conditions and the `i2.ic()` flags: kept as observed numbers; the *semantic* of message codes (RV values) is conjectural (e.g. 81 "humiliation", 89 "retirement", 74 "new club" — from context).
- **`v.i(ah)` both branches identical** (`best/v.java:73-76`) — probably a decompiler artifact or placeholder; the stadium-type change for relocated clubs is thus effectively constant — *open question*.
- **Season 1 league/regional grants**: the human grant `kG()` runs inside `aa()` but the exact pipeline position (`ag()` step) and whether `sD[div][1]` ever applies requires save-time observation — see `best/f.java:531` and `best/ah.java:1690-1705`.
- **Training multipliers 10× / 2×** at `best/F.java:1231` and `1251` are distilled from decompiled expressions (`d2*10`, `d2*2`); their exact accumulation semantics against `nB/nC` and the auto-focus cadence are *inferred* and are prime validation targets for the port.
- **`as` message "type" vs "tone"** fields (`RU/RV`): only the *pairs* used by each site are recorded; the full catalog of `RV` codes is *open*.
- **Weekly vs monthly wage totals**: both modes pay, in expectation, the same yearly figure because `fJ()` computes `wage*4` for monthly mode; confirmation of the editor/payroll totals belongs to `spec-transferencias.md` §10.
- **`bD()`/`bF()`/`yL()` booleans** are opaque flags controlling some season-end branches (`best/f.java:2528-2550,2979-2985`); the autosave option 3 gate `bF()` is not documented elsewhere in the code.
- **`C.a(double,int)`** magnitude suffixes `{" mil","M","B","T"}` shrink a number by factors of 1000 per rank; values ≥ 100 billions are printed compactly; this can truncate the displayed millions for very large figures — cosmetic quirk, not a balance concern.