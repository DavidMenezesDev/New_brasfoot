# Brasfoot 22-23: Calendar, Day Loop and Competitions, Behavioral Specification

Source: CFR-decompiled jar at `re/decompiled/`. All refs are `path:line` relative to that directory.

This specification documents the calendar / day-loop machinery and the competition (league, cup, knockout, national-team) engine of the Brasfoot 22-23 C#-port target, as reconstructed from the decompiled Java. Only one section of the codebase is covered: how days are built, typed, and played (`best/a.java`, `best/f.java`), and how the dozens of competition classes (`f/*.java`, `best/Z.java`, `best/w.java`, `best/at.java`, `est/*`) hook into that loop.

Throughout, obfuscated names are kept verbatim in inline `code` so that claims can be verified against the sources; the mapping table in §8 decodes the important ones. Every non-obvious claim carries a `path:line` citation. Behaviour that is *implied* by the code but not demonstrated directly is marked "[inferred]".

---

## 0. Orientation: what is "a match", "a day", "a competition"

- A **day** is an instance of `best.a` (`best/a.java`). One instance exists per calendar date of the season year (`best/f.java:1923`). Each day carries: a date, a day-type (`w`, `best/a.java:36`), two scheduled-event queues (`q`/`r`, `best/a.java:30-31`), a list of `I` matches (`s`), a list of league/KO objects `L`/`z` (`t`), a list of `at` competitions (`u`), and a "used" flag `v` (`best/a.java:35`).
- A **match** is `best.I`; it references the two `ah` (club/team) participants, the owning competition (`hy()`), an optional sub-round/leg, and the assigned day.
- A **competition** is an `best.at` (league/cup base) or one of its concrete subclasses (`f/s` league, `f/z` knockout bracket, `f/G` knockout round, `best/i` single decisive match, etc.). Every competition declares a `(type, continent)` pair via `at.F(int,int)` (`best/at.java:76`); `b()` returns the type and `gg()` returns the continent (`best/at.java:72,491`).
- The whole simulation state is the singleton `SR`, an instance of `best.f` held by `c.a.SR` (`c/a.java:57`). A second global, `afQ` (`c.a.afQ`, `c/a.java:58`), provides finance/league helpers.

---

## 1. The calendar template

### 1.1 Day-type and weekday constants (`best/a.java:36-60`)

Weekdays (`Calendar.get(7)` numbering, 1=Sunday…7=Saturday):

| constant | value | meaning |
|---|---|---|
| `DOM` | 1 | Sunday |
| `z` | 2 | Monday |
| `A` | 3 | Tuesday |
| `B` | 4 | Wednesday |
| `C` | 5 | Thursday |
| `D` | 6 | Friday |
| `F` | 7 | Saturday |

Day types:

| constant | value | semantic (display name) |
|---|---|---|
| `G` | 1 | Nacional (national league) |
| `H` | 2 | Copa Nacional (national cup) |
| `I` | 3 | Estadual (state league) |
| `J` | 4 | Internacional 1 |
| `K` | 5 | Mundial (Club World Cup) |
| `L` | 6 | Internacional 2 |
| `M` | 7 | Seleções (national teams) |
| `N` | 8 | Recopa |
| `O` | 9 | Eliminatórias (world qualifiers) |
| `P` | 10 | Regionais (regional competitions) |
| `Q` | 11 | SuperCopa |
| `ht` | 12 | Conference League |
| `hx` | 13 | Finalíssima |
| `ov` | 14 | Liga Nações |
| `ow` | 15 | Torneio Amistoso |
| `R` | 100 | Amistoso Clube |
| `S` | 200 | Amistoso Seleção |

The display-name array is `aq.tz[16]` at `best/aq.java:848`; note that index 15 is `"Torneio Amistoso"`, which resolves the day type `ow=15`. Types 12-15 have no dedicated constants (they reuse the enum values `ht`, `hx`, `ov`, `ow`).

### 1.2 Filling the year: `b(int,int)` and the yearly template `g()`

`best.a.b(int n2, int n3)` (`best/a.java:222-247`) is the primitive used to template a calendar year. For a given *weekday* `n2` (1..7) it scans forward from the last day that already has a type (or from the current day, whichever is later; `best/a.java:228-232`), finds the **first free day** whose weekday matches, and assigns type `n3` to it (`best/a.java:237-246`).

The yearly template `best.a.g()` (`best/a.java:249-500`) is a flat sequence of ~250 such calls, all of the form `b(weekday, type)`. Each call reserves the *next* free occurrence of that weekday for the given type. Reading the sequence (in order), the resulting calendar pattern for a season is, roughly:

1. Early January fills with `100` (clube amistosos), `15` (Torneio Amistoso), and `10` (Regionais) on weekdays 1-7 (`best/a.java:250-265`).
2. `3` (Estadual) then appears repeatedly on Sundays/Tuesdays/Thursdays, with `11` (Supercopa) on a Saturday and `200` (seleção amistosos) on Saturdays (`best/a.java:266-281`).
3. From roughly mid-season the template schedules `4` (Int 1) on Wednesdays and `1` (Nacional) on Sundays/Mondays, interleaving `2` (Copa Nacional), `9` (Eliminatórias), `14` (Liga Nações), `12` (Conference League), `6` (Int 2), and `8` (Recopa) on the appropriate weekdays (`best/a.java:281-373`).
4. Late season adds `7` (Seleções) concentrated in a window, `13` (Finalíssima), and finally the last weeks become `5` (Mundial) — first on Fridays/Saturdays, then a closing run of `1` (Nacional) and `5` (`best/a.java:374-499`).

Because placement depends on the day-of-week *layout* of each concrete year, the same template produces different absolute dates in different seasons; the template is weekday-relative, not date-relative. The pattern is observed directly; the mapping "this phase of the sequence ≈ these months" is [inferred].

Two helper observables used all over the engine:

- `best.a.b(int)` — indexes of all days of a given type (`best/a.java:99-104`).
- `best.a.c(int)` — indexes of all days with a given weekday (`best/a.java:106-120`).
- `best.a.d()` — indexes of all days whose day-of-month is 2 (`best/a.java:122-131`).
- `best.a.d(int)` — **last** day index with a type (`best/a.java:134-143`); `best.a.e(int)` — **first** day of a type (`best/a.java:145-153`).
- `best.a.a(int,int)` — index of the *n*-th day of a type, 1-based (`best/a.java:156-169`).
- `best.a.a(int,boolean)` — indexes of **free** days (not yet "used", `!e()`) of a type; skips the first two free days when the flag is set (`best/a.java:171-190`). This is the method used to schedule league matchdays (see §3.4).

### 1.3 The season year and day index

- `SR.H()` returns the running season counter `ae` (starts at 1; `best/f.java:331-341`).
- `SR.J()` returns the current day index `af` (`best/f.java:343-349`).
- The season's calendar year is `SR.op() + (ae - 1)` (used in `ah()` at `best/f.java:1203`, `iU()` at `best/f.java:457`).
- `best.f.r(int year)` (`best/f.java:1923-1942`) builds one `best.a` per calendar day of `year`, appends them all to `R()` (the global day list `as`), sets the current day `SR.l(idx)` to the **first Sunday of January** (`best/f.java:1938-1940`), and then runs the weekly seed `aS()` (§2.5).
- `best.f.aM()` (`best/f.java:1852-1858`) marks every day `0..SR.af` as *used* after a simulated day (flag `v`), which is how the template's "free-day" queries advance.

---

## 2. The day loop and its events (`best/f.java`)

### 2.1 The driver `V()`

`best.f.V()` (`best/f.java:446-452`):

```
if (!bk) ap(); else aa();
```

- if the season is not finished (`!bk`), `ap()` plays the current matchday;
- otherwise `aa()` runs the full season rollover (§2.7).

`bk` is the season-end flag; it is set to true in `ax()` when no more days remain (§2.4) and cleared to `false` again at the end of `aa()` (`best/f.java:579`).

### 2.2 The matchday `ap()` (`best/f.java:1371-1447`)

`ap()` decides, for the current day, whether the human manager must watch a match or everything is simulated:

- If the current match day involves the human-managed team (`f.ay()`, `best/f.java:1622-1644` area — it scans the day's `I` list for a match whose home/away is managed and not yet played), the game routes to the match screen `S.aY(2)` and applies auto-save rules (tiers `1`/`2`/`3` of `autoSalvar`, plus random "news" popups; `best/f.java:1379-1418`).
- Otherwise it applies *skip/fast-sim* conditions, each of which sets `bH` (skip flag):
  - `isIgnoraLigas()` and the day has one match of type 1 and no final (`!s.dG()`) → skip (`best/f.java:1419-1423`).
  - `isIgnoraEstadual()` and day type is 3 (Estadual) → skip, unless the state config says its week `J(3)` matters (`best/f.java:1424-1428`).
  - `isIgnoraEstadual()` and day type is 10 (Regionais) → skip unless week matters (`s.J(10)`) (`best/f.java:1429-1430`).
  - Regionais specifically: if some-but-not-all of the 4 regional spots (`aq()`, `best/f.java:1449-1459`) are active and the fed daily check `!s.dH()` says skip, or if no human team participates (`ar()` false) and the option "regionais sem humanos" is off, skip (`best/f.java:1431-1436`).
- The simulated path then runs `best.ah.kh()` (squad/line-up bookkeeping) and `I.he()` (per-day match helper), and finally either forces the visible match screen (`s.dw()`/`s.dx()`, `best/f.java:1438-1441`) or calls `at()`.

### 2.3 Post-match `at()` and `as()` (`best/f.java:1524-1536`, `1479-1522`)

`at()` is the "one day executed" sequence:

1. `as()` — play every `I` of the current day (`best/f.java:1482-1500`: sets the day used, plays legs via `hg/hi/hf/hh`, resets home/away flags), then club transfer windows `fr()` and `ai(100)` over the club lists (`best/f.java:1501-1508`), extra `fr()` for unregistered national-team players when the day type is 7 or 9 (`best/f.java:1509-1520`), and resorts the manager list (`best/f.java:1522`).
2. `f.an()` (static, `best/f.java:1352`) — match-review bookkeeping.
3. `aM()` — mark days `0..af` used (`best/f.java:1852`).
4. `aC()` — for each league/KO object registered on the current day, run its stage-advance `pO()`: `f.s` leagues and `f.z` brackets (`best/f.java:1712-1724`).
5. `aB()` — for each `at` competition registered on the day, run `mx()`, which clears its transient day state (`best/f.java:1702-1710`, `best/at.java:387-389`).
6. `q(0)` — dispatch the day's scheduled events from queue `q` (§2.4).
7. If human and not skipped → post-match screen `S.aY(5)`, else `ax()`.

### 2.4 End of day `ax()` + `az()` + event dispatch `q(int)`

`ax()` (`best/f.java:1628-1657`):

1. Get the day type via the first match's competition: `i()` (`best/a.java:506-512`). If it is 1 or 3, run `n(type)` — the manager-market step: propose coaches to managed clubs without coaches (`afQ.b` + dialog `S.a(...)`, unless auto), and collect manager job offers from all countries (type 1) or all state feds (type 3) via `Z.A(list)`/`w.A(list)`; shows `S.K(list)` when the option `verMudancaTecnicos==1` and human & not auto (`best/f.java:1726-1758`).
2. `int az()` (`best/f.java:1687-1697`) — search forward from the current day for the next day that is not used, has a type (`b()>0`) **and** matches registered; that becomes the new current day `SR.l(idx)`. Returns `0` when none remains.
3. Perform periodical events while `av` non-empty → `au()` (squad age/normalization?); random 50% `av()`; `aw()` when non-empty — these three are the cycling "match-review/notification" steps (`best/f.java:1638-1644`; exact semantics of `au/av/aw` are not fully mapped).
4. `q(1)` — dispatch scheduled events from the day's queue `r` (`best/f.java:1860-1878`).
5. If `az()` found no day → `bk = true`. Then:
   - if human-managed (`bs`): if season over → `afQ.zw()` (finance/wages), `al()` (season cut), and `S.aY(6)` season-end screen; else continue with `ap()` (`best/f.java:1647-1654`);
   - if not human-managed and season over → `al()` only.

**Event dispatch internals.** `q(int q)` (`best/f.java:1860-1878`) walks all days `0..af`, and for each day whose queue-`q` getter returns a non-empty list calls `a.f(0)` (queue 0) or `a.f(1)` (queue 1). (Two "queue reads": the getters in `best/a.java:766-772` are misnamed — `r()` returns field `q` and `s()` returns field `r`; the pair is functionally `(queue0, queue1)`.)

The per-day dispatcher `best.a.f(int)` (`best/a.java:567-612`) maps event-string → action:

| scheduled string | created by code arg | action |
|---|---|---|
| `"cw"` | 1 | `p()` — Club World Cup `A.zC()` (`best/a.java:722-725`) |
| `"ds"` | 2 | `n()` — salary day: each managed club `ah.bY(day)` → `kJ()` (`best/a.java:702-710`) |
| `"aj"` | 3 | `SR.aT()` — weekly evolution (`best/a.java:578-579`) |
| `"cD"` | 4 | if `SR.bk()` → `m()` (create Série D + Copa do Brasil), else if `SR.X()` (regionais) → `l()` (Copa do Brasil after regionais) (`best/a.java:580-585`, `649-700`) |
| `"dJ"` | 5 | `o()` — loan interest/payment: for each club in `aN()` with loan `kL().eQ()>0` → `w(eQ,4)` (`best/a.java:712-720`) |
| `"cS"` | 6 | `b(false)` — seleção call-ups (clubs with no coach) (`best/a.java:584`, `626-647`) |
| `"cO"` | 7 | `k()` — seleção call-up when all-seleções mode (`best/a.java:614-624`) |
| `"cSempregado"` | 8 | `b(true)` — forced call-ups (`best/a.java:611`, `626-647`) |
| `"cPromocao"` | 9 | `afQ.zw()` — finance/promotional settlement (`best/a.java:610-611`) |
| `"criaMataMataAscenso"` | 10 | **no-op** — falls into the final `else` which merely evaluates `string11.equals(...)` (`best/a.java:605-606`) |
| `"criaplayOffRebaixamento"` | 11 | **no-op** (same line) |

Events 10 and 11 are thus scheduled in the calendar but never acted on; the relegation/promotion playoffs they reference are instead created directly by `f/B` when each league issues its final classification (see §5).

The seeds that sprinkle these events over the calendar are described in §2.6.

### 2.5 The weekly seed `aS()` (`best/f.java:1944-1964`)

Called once per season by `r(int)` (`best/f.java:1942`). It books three recurring events on queue `q` (arg 0 of `a.b(dayIdx, code, 0)`):

- **salaries** (`"ds"`, code 2): on every day-of-month-2 if `salarioMensal` is on, otherwise on every Sunday; the choice is `this.salarioMensal ? a.d() : a.c(1)` (`best/f.java:1946-1955`).
- **loan interest** (`"dJ"`, code 5): on **every** day-of-month-2 (`a.d()`) (`best/f.java:1956-1960`).
- **weekly evolution** (`"aj"`, code 3): on every Sunday (`a.c(1)`) (`best/f.java:1961-1963`).

(All three lists consist of day indexes; `a.b(idx, code, 0)` puts the event string on that day's queue `q` — `best/a.java:560-564`.)

### 2.6 The seleção-event seed `a.q()` (`best/a.java:735-764`)

Schedules national-team call-up events, always on queue `r` (arg 1):

- if all-seleções mode: `cS` (code 6) on the **4th Estadual day** (`a.a(3,4)`), `cSempregado` (code 8) on the **1st Nacional day** (`a.a(1,1)`), `cS` on the **1st Seleções day** (`a.e(7)`), `cO` (code 7) also on the 1st Seleções day, `cS` on the 12th and 18th Nacional days (`a.a(1,12)`, `a.a(1,18)`) (`best/a.java:737-755`);
- unconditionally `cPromocao` (code 9) on the 20th Nacional day (`a.a(1,20)`) (`best/a.java:757-760`).

`a.q()` is invoked from the season pipeline at `best/f.java:544`.

### 2.7 Season rollover `aa()` (`best/f.java:518-584`)

Runs when `bk` is true (season finished). Sequence (abbreviated, in order):

1. Every club `kI()` — season-stat reset (`best/f.java:519-522`).
2. If `jogaIntClubes` → `ai()`: cross-links the European/South-American club competitions — Europa League ↔ Champions `aK().cS()/aI().T(...)`, Sul-Americana ↔ Libertadores `aH().cS()/aF().O(...)`, Europa League ↔ Conference `aK().ab(...)` (`best/f.java:1212-1228`).
3. If `jogaSelecoesAll` → `jw()` (empty in this build; `best/f.java:1230-1238` shows only an empty method body).
4. `ah()` — rebuild the calendar: increment season (`I()`), clear every day, rebuild `r(op()+ae-1)` and apply `a.g()` template (`best/f.java:1200-1209`).
5. `ag()` — daily resets: clear per-club lists, manager reset `kk()`, skill refresh, restore morale `cj(50)/ck(50)` (`best/f.java:1177-1198`).
6. `iZ()` — manager/coach re-sign segment (`best/f.java:1169-1175`).
7. If `jogaIntClubes` → `ae()` (§6.5).
8. `Y()` — Copa do Brasil pot seeding for Brazil (`Z.y(true)`, `best/f.java:478-489`).
9. `Z()` — Supercups: if not created yet, one `f.I(country)` per country (champion vs best non-champion from previous season via `jq().cv(H()-1)` and `bk(H()-1)`), stored in `ar`, seeded `Ab()`; else re-seed/play existing ones (`best/f.java:492-514`).
10. `am()` and `ak()` — two preparation steps (contents not mapped in detail; `ak()` touches country-wide state).
11. If `jogaRegionais` → `aj()` — (re)build the four "regionais" federations.
12. If (`bk` or regionais-active) and a Nacional day exists → schedule `"cD"` (code 4) on that day in queue `r`: `a.b(a.e(1), 4, 1)` (`best/f.java:541-543`).
13. `a.q()` — the seleção seed of §2.6 (`best/f.java:544`).
14. `af()` — club-list churn: run generational update markers `gc/gd/gf` over the three club lists, apply keeps/removals, run youth regen `c(true)` (batch by reputation in pre-season), and per-club `fK()/fJ()` (`best/f.java:1050-1102`; `c(boolean)` at `best/f.java:1105-1167`).
15. If `H() >= 5` → `W()` — purge news older than 10 seasons (`best/f.java:458-476`).
16. `afQ.zi()`, `afQ.zj()`, `ag.jO()`, `ag.jQ()` — finance/sponsor and league re-evaluation hooks.
17. If `jogaSelecoesAll` → `ac()` — the national-team year cycle (§7.1).
18. `yn().xZ()` and `yn().clear()` — reset the friendly-tournament handle (`f.L`) (`best/f.java:551-552`).
19. If human & not auto and some seleção has a coach, show a schedule prompt (`cR.pl()`); if `SR.yL()`, auto-create the season-opening friendly tournament `iY()` (first 8 teams of `P()`, i.e. by rating, as an 8-team KO `"Torneio Amistoso"` starting in Juazeiro) (`best/f.java:553-575`, `597-609`). The interactive offer dialog is `iX()` at `best/f.java:586-595`.
20. `bk = false`; then either `cR.AC()` if a schedule prompt is pending, else `SR.az(); V()` to continue into the new season (`best/f.java:579-584`).

---

## 3. The competition framework

### 3.1 Base class `best.at`

`best/at.java` is the abstract base of every competition. Key behaviour:

- `F(int type, int continent)` stores the pair `(tR, dz)`; `b()` and `gg()` return them (`best/at.java:60-75, 76-81, 491-494`).
- Season records: `mn()` (list of `i`, season winner records), `cS()` (winner of the *current* season), `cv(int)` (winner of a given season), `mo()` (current record) (`best/at.java:85-120`).
- `mx()` clears the transient per-matchday state `tV/tW` — invoked daily by `best.f.aB()` (§2.3 step 5) (`best/at.java:387-389`).

Concrete competition types live in package `f` and in `best`:

- `best.L` is the serializable base of leagues (name + type `w` at `best/L.java:10-18`); `f.s extends L`.
- `best.G` is a group table.
- `best.i` is the single-match final ("decisão").
- `f.z` is a knockout bracket, `f.G` one knockout round.
- `f.B` is a national-division container.
- `best.Z` is a country; `best.w` a state federation.

### 3.2 The league builder `f.s` — constructor and options

`f/s.java:31-78` declares the league's fields: participating teams `Zb`, the containing `at` (`YY`), the country `Z` (`RT`), group tables `best.G` (`yQ()`), the optional knockout `z` (`Zc`), phase counters (`Zd` = how many teams pass per group, `Zf` = played round, `Ze` = last round, `Zj` = ranking mode), a competition code `var0`, an alternate code `Zg`, the `LoadLigaOptions`-derived knobs (`doisTurnos`, `nTimes`, `nGrupos`, `jogosDentroGrupo`, `melhoresTerceiros`, `numeroTurnos`, `pulaDuasDatas`, `duasVoltasMataMata[7]`).

The main constructor `s(LoadLigaOptions, ...)` (`f/s.java:245-470`) *builds the knockout-draw matrices inline*: `Zm..Zz` (fields at `f/s.java:65-78`) are permutation tables that map seeded bracket positions. The matrices themselves are assembled from literal arrays:
- `Zm`/`Zn` (2 teams, home-first / away-first),
- `Zo..Zr` (4 teams, two variants),
- `Zs`/`Zt` (8 teams, two variants),
- `Zu`/`Zv` (8 teams, second variants),
- `Zw`/`Zx` (16 teams),
- `Zy` (32 teams),
- `Zz`.

Groups are then created by:

- `a(int n2, int[] nArray)` (`f/s.java:528-545`) — split `Zb` into `n2` groups whose per-group sizes come from `nArray`, create a `best.G` per group, and schedule intra-group fixtures.
- `j(int n2, boolean bl2)` (`f/s.java:547-601`) — distribute `Zb` into `n2` equal groups (row/column-major depending on a flag), create `best.G` per group, schedule intra-group fixtures when `jogosDentroGrupo` (or, for type-7 competitions, always — both branches of the type-7 check call the same schedule, a tautology), otherwise schedule a cross-group pairing via `a(Zb, doisTurnos, true, Za)`.

### 3.3 Fixture generation `a(ArrayList, boolean, boolean, ArrayList)` (`f/s.java:603-689`)

Dispatch to the static generators in `best/t.java`:

| team count | condition | generator |
|---|---|---|
| 4 | `var0==7700` | `t.v(list)` (`f/s.java:613-615`) |
| 3 | `doisTurnos` | `t.a(s, list)` (`f/s.java:616-617`) |
| 3 | single | `t.g(s, list)` (`f/s.java:618-619`) |
| 5 | `!doisTurnos` | `t.y(list)` (`f/s.java:620-621`) |
| 5 | `doisTurnos` | `t.b(s, list)` (`f/s.java:622-623`) |
| 6 | `doisTurnos` | `t.h(s, list)` (`f/s.java:624-625`) |
| 9 | — | `t.a(s, list, true)` (`f/s.java:626-627`) |
| 11 | — | `t.c(s, list)` |
| 19 | — | `t.e(s, list)` |
| 25 | — | `t.d(s, list)` |
| else | single-league & no ranking mode | special `numeroTurnos` logic (see below) |

The generic path (`best/t.java:746-790`), used with an explicit turn count, implements the classic circle method: shuffle the team list, pad odd counts with a `null` bye, then rotate the table for `teams-1` rounds, alternating home/away; the result is a `[round][pair][4]` array where indexes `0`/`3` are used as home/away.

For single-league (`b()==1`, no groups) competitions the round factor `n2` is chosen from team count: 20 teams with code 1020 → 1 turn; 8 → 4 turns; 10 → 4 turns (2 if `numeroTurnos==2`, 3 if 3); 12 → 3 (2 if 2); 14 → 3 (2 if 2); otherwise `bl2 ? 2 : 1` (`f/s.java:644-660`).

With `bl3` (cross-group) the two special cases `var0==7` and `var0==10` use `t.a(list, other)` / `t.b(list, other)` (`f/s.java:665-669`).

Finally (`f/s.java:672-686`): the matchday map is `best.a.a(dayType, pulaDuasDatas)` — i.e. the free days of the competition's type, skipping the first two free days when `pulaDuasDatas` is set — and each scheduled fixture becomes a `new I(this, round, home, away, dayIndex, at2, null)` assigned to that day. (This is how leagues land on the right day types of the §1 template.)

The tournament formats data that drives these builders is configuration-as-data in `est/LoadLigaOptions.java` (includes the `pulaDuasDatas`, `decisaoTerceiroLugar`, `multiplosTurnos`, `numeroTurnos` switches) and `est/ConfigLigaType.java:11-33` (league format per division; see §5.1).

### 3.4 Group-to-knockout transitions

After the regular phase finishes, `f/s.pO()` (§3.5) routes to one of:

- `yN()` (`f/s.java:733-759`) — *national final-phase decider* (code 90): registers every group winner with the containing `at`, then takes the sorted 2nd-placed teams, keeps the best 8 (if ≥8), **shuffles** them, builds an 8-team knockout `z` (`Zc.fc(90)`).
- `yO()` (`f/s.java:761-844`) — *best third-placed fall-in*: collects the automatic qualifiers (`Zd` per group) plus third-placed teams (`gR().get(2)`, or `.get(1)` for `Zj==17`), sorts, keeps the best `n3` where `n3` depends on `Zj` (10/1403 → 6, 3 → 2, 6 → 4, 12 → 8, 17 → 15) (`f/s.java:803-817`), then places them via the bracket matrices (`Zz` for 32, `Zw` for 16, `Zu`/`Zv` for 8) and builds the `z`.
- `yP()` (`f/s.java:846-1002`) — *group→knockout*:
  - decides the *seeding mode* from the competition type: type 4 with continent 1/2/3 → champions-first (`n2=1`), type 4 with continent 0 → shuffle (Europe), type 6 with continent 0 → shuffle (`bl3`) (`f/s.java:860-869`);
  - sets the **away-goals flag** `bl2` when the competition type is 4 or 6 and the country's continent is 1, i.e. South America (`f/s.java:870-871`);
  - without groups: takes the top `Zd` teams and seeds via matrices by count (16→`Zw`, 8→`Zu`/`Zv`, 4→`Zo`/`Zp`, 2→`Zm`/`Zn`) (`f/s.java:926-949`);
  - with groups: gathers `Zd` qualifiers from each group and seeds via `Zs`/`Zt` (codes 7/10), `Zy` (32), `Zw`/`Zx` (16), `Zu`/`Zv` (8), `Zq`/`Zr` (4), `Zm`/`Zn` (2); champion+runner-up interleave path for `n2`/`bl3` modes (`f/s.java:878-928`);
  - builds the `z` with code `-1`, then overrides `fc(1802)`/`fc(1803)` for those estadual codes, or hands the list to `((B)this.YY).a(list, this, this.var0)` for code 1020 (`f/s.java:950-1001`; the 1020 branch is at `f/s.java:997-998`).

**The exact `yP()` gate, verified line-by-line (`f/s.java:852-867`).** Two booleans (`n2` reused as an int flag, `bl3`) and the away-goals flag `bl2` are derived from `this.b()` (competition type) and `this.yT().gg()` (continent of the owning country):

```
n2 = 0; bl3 = false; bl2 = false
if b() == 4:
    if gg() in {1, 2, 3}: n2 = 1
    elif gg() == 0:       bl3 = true
if (b() == 4 or b() == 6) and gg() == 1: bl2 = true     # away goals
if b() == 6 and gg() == 0:               bl3 = true
# the alternate crossing runs when (bl3 || n2 != 0); otherwise the size matrix runs
```

| type (`b()`) | continent (`gg()`) | branch taken | ranked or shuffled | away goals |
|---|---|---|---|---|
| 4 (`liga*`, Champions-style) | 0 Europe | alternate (`else` branch, `f/s.java:915-955`) | shuffled (`Collections.shuffle`) | no |
| 4 | 1 South America (Libertadores) | alternate | ranked (`Collections.sort(…, h.a.abn)`) | **yes** |
| 4 | 2 Africa / 3 Asia | alternate | ranked | no |
| 4 | 4 Concacaf / 5 Oceania | size matrix (`Zw/Zu/Zv/Zo/Zp/Zm/Zn`, `f/s.java:883-905`) | — | no |
| 6 (`liga*`, second tier) | 0 Europe (Europa League) | alternate | shuffled | no |
| 6 | 1 South America (Sul-Americana) | size matrix | — | **yes** |
| any other `(type, continent)` | — | size matrix | — | no |

The "alternate" branch sorts/shuffles the flattened per-group champions and runners-up separately, then interleaves them with two fixed 8-entry tables (`nArray2 = {0,7,3,4,1,6,2,5}` for the champions, `nArray4 = {7,0,4,3,6,1,5,2}` for the runners-up, `f/s.java:931-948`) — it only exists for exactly 8 groups (16 teams), since both tables are hard-coded to length 8. Ported as `BracketSeeder.DetermineGroupKnockoutSeeding(CompetitionType, continent)` (the pure gate) plus `GroupStage.SeedKnockoutAuto` (wires it to real standings — ranks with `LeagueTable.OrderByHk`/`h.K` when "ranked", shuffles with `BracketSeeder.Shuffle` otherwise, then calls `BracketSeeder.AlternateFirstsAndSeconds`); falls back to `GroupStage.SeedKnockout` (the size-matrix path) whenever the gate says "no" or there aren't exactly 8 groups.

### 3.5 The daily advance `pO()` (`f/s.java:1004-1088`)

For a league/KO registered on the current day (called from `best.f.aC()`):

1. Accumulate results: for every match of the day owned by this competition, `hc().a(I, this)` / `hd().a(I, this)` (team-stat bookkeeping) (`f/s.java:1006-1012`).
2. Sort the table (`h.a.abn`) and each group table (`f/s.java:1013-1020`).
3. Advance the round counter `Zf` (`f/s.java:1022`).
4. If this is a single-league final round and no knockout phase: trigger `afQ.zj()` and `ag.b(this)` (`f/s.java:1023-1026`). **Correction (verified against `best/ag.java:109-117`):** `ag.b(s)` is *not* league/prize wrapping — it is the AI squad-market sweep, the same routine `ag.jS()` runs over every club of every division (`best/ag.java:91-107`): for every non-human club in the league, `ag.a(ah, index, true)` evaluates whether that club's players should be listed for transfer. It has nothing to do with `decisaoTerceiroLugar` or with prizes; see §9.13 for where the third-place decision is actually wired.
5. When the phase is complete (`Zf > Ze`): if groups existed, `ag.b(this)` (same AI squad-market sweep as step 4, not a "wrap"); if a knockout phase follows, assign final table positions `ah.bW(pos)` (`f/s.java:1027-1033`).
6. **Dispatch on `var0`** (the full table, `f/s.java:1039-1084`):

   | `var0` | action | semantic |
   |---|---|---|
   | 14001 | `a.SR.sq().yt()` | Liga Nações Europa → final phase |
   | 14401 | `a.SR.ym().yt()` | Liga Nações Concacaf → final phase |
   | 14003 | `a.SR.sq().BB()` | Liga Nações Europa → relegation playoff |
   | 4005 | `a.SR.aI().yt()` | Liga dos Campeões Europa → KO |
   | 6005 | `a.SR.aK().Be()` | Liga Europa → KO |
   | 4104 | `a.SR.aF().yt()` | Copa Libertadores → KO |
   | 12005 | `a.SR.mj().Be()` | Conference League → KO |
   | 6105 | `a.SR.aH().yt()` | Copa Sul-Americana → KO |
   | 7700 | `a.SR.aY().yt()` | Copa do Mundo group phase → KO |
   | 7701 | `a.SR.bQ().Bn()` | Asia qualifier repescagem |
   | 9001 | `a.SR.bL().Bk()` | Europa qualifier |
   | 9400 | `a.SR.bR().Bp()` | Concacaf qualifier |
   | 9402 | `a.SR.bR().Bm()` | Concacaf qualifier (phase 2) |
   | 9500 | `a.SR.bS().Bq()` | Oceania qualifier |
   | 9501 | `a.SR.bS().yt()` | Oceania qualifier (phase 2) |
   | 9100 | `a.SR.bK().Bm()` | South-American qualifier |
   | 90 (with `Zd==0`) | `this.yN()` | national final-phase playoff |
   | 9201 | `a.SR.bM().Bk()` | Africa qualifier |
   | 9301 | `a.SR.bQ().yt()` | Asia qualifier group phase → KO |
   | 9302 | `a.SR.bQ().Bm()` | Asia qualifier (phase 2) |
   | groups + `melhoresTerceiros` | `this.yO()` | third-placed fall-in |
   | groups | `this.yP()` | group→KO |
   | otherwise | `new i(YY, this, 1st, 2nd)` | single decisive final |

The codes 14002/14004/14402/14403 (secondary Liga Nações and final-phase leagues) are explicitly excluded from this chain (`f/s.java:1044-1045`).

### 3.6 Attachment and rounds

- `za()` (`f/s.java:1562-1614`) attaches final classification positions to the participating clubs (`ah.a(at, position, roundHint)`) — used for qualification bookkeeping and the promotion/relegation logic. Two branches:
  - **no knockout** (`Zc == null`, `f/s.java:1569-1577`): position = table index + 1 (1-based), `roundHint = -1`.
  - **with knockout** (`f/s.java:1578-1614`): walks `Zc.zp()` (the bracket's rounds) **backward**, last round first; for every match of a round, the winner (member of that round's `zY()`, the "advanced" set) gets the next sequential position if not already assigned, then the loser gets the position right after. `roundHint` counts rounds from the end (0 = final). Because the walk is strictly sequential and skips already-assigned clubs, a round's participants that already got a position from a later round (i.e. advanced further) are skipped — only *that round's own eliminated* contribute new positions. When the final round also carries a third-place match (see §4.2/§9.13), that match is part of the same round's match list, so its winner lands in 3rd and its loser in 4th automatically, *before* the semifinal round is visited. Ported as `KnockoutBracket.FinalPositions()` (no-knockout case: `LeagueCompetition.FinalPositions()`, the table order).
- `zk()` (`f/s.java:1841-1849`) computes expected rounds: `(N-1)*2` for a single double round-robin league, or `round(N/Zj)*2 - 1` for grouped competitions. Used for minutes/stats thresholds elsewhere (e.g. `f/B.fi`), not by `za()`/promotion — not ported (out of scope for this pass).
- `zf()` returns `Zg` (`f/s.java:1747`); `zl` static pointer is set to the last-played `s` (`f/s.java:62`).

### 3.6.1 Promotion and relegation (`best.Z.ee()`, `f/B.BQ()`/`f/B.a(B)`)

`best.Z.ee()` (`best/Z.java:453-598`) is the per-country orchestrator, run once per season rollover (see §2.7 step indirectly through `f/B.BJ()`/`BO()`/`BP()`, called from each division's own `pO()`-adjacent bookkeeping). Before the main loop it caches, for every division `n`, the promotion/relegation candidate pools via `f.B.yi().ah(wantedPromotionCount, ownRelegatedCount)` → `f/s.ah(int,int)` (`f/s.java:1349-1354`), which sets:

- `wK` (promotion candidates, `f/s.yW()`) = `f/s.l(wantedPromotionCount, true)` — for a group-less league (`Zd == 0`, the only case this port's `SeasonBuilder` produces) this is simply the **top `n` of the table** (`f/s.java:1189-1196`);
- `xc` (relegation candidates, `f/s.yU()`) = `f/s.fG(ownRelegatedCount)` — for `Zd == 0` this is the **bottom `n` of the table, worst-placed first** (`f/s.java:1301-1313`, the loop runs `Zb.size()-1` downto `Zb.size()-n`).

`wantedPromotionCount` for division `n` is **division `n-1`'s** `getnRebaixados()` (so division `n` offers exactly as many promotion candidates as the division above needs replacements); division 0 gets `wantedPromotionCount = 0` (`best/Z.java:457-464`).

The main loop (`best/Z.java:465-589`), for each division `n` from the top down:

- **not the last division** (`best/Z.java:468-525`): `desce` = division `n`'s own relegation candidates (`xc`/`yU()`); `sobe` = division `n+1`'s promotion candidates (`wK`/`yW()`). If the two lists have the **same size**, each pair is swapped — `desce[i]` moves from `n`'s roster to `n+1`'s, `sobe[i]` moves the other way (`best/Z.java:508-524`); unequal sizes → **no swap at all** (quirk, faithfully reproduced). A per-club bookkeeping call `ah.b(at, flag)` (0 = relegated, 1 = promoted, not modelled — UI/history only) precedes the actual list mutation, except for the special case `agB` (a relegation-playoff bracket still pending) which skips swapping a club still contesting it (`f/B.ac(ah)`, `f/B.java:334-336`, guarded at `best/Z.java:512`).
- **the last division** (`best/Z.java:526-589`): `desce` = the first `min(nRebaixados, dt.size())` entries of that division's relegation candidates (`dt` = the country's out-of-league club pool); `sobe` = the first same-count entries of `dt`, **reversed** (`Collections.reverse`, `best/Z.java:571`). Swapped the same way, moving relegated clubs into `dt` (`setDivisao(0)`) and pulling replacements out of it.

Two playoff brackets *feed* these candidate pools before `ee()` runs, both created by `f.B` (the division wrapper), not by `f.s`/`ag`:

- **Access/promotion playoff**, code **1099** — `f/B.BQ()` (`f/B.java:409-439`). Gated by `BK()` (`f/B.java:291-294`): `BN() > 0 && vagasSobemPeloMataMata > 0`, where `BN()` (`f/B.java:314-319`) is `KR.K(divisao)` — a per-country config value, "how many of this division's own table positions feed the playoff". Field = the **own-division table positions** `[BN() - vagasSobemPeloMataMata, BN() - vagasSobemPeloMataMata + 4)` — always a **fixed window of 4** (`f/B.java:412-424`); aborts (falls through to `BO()`) if the table doesn't have enough rows. Two-legged flags come from `duasVoltasMataMataSobe[7]`.
- **Relegation playoff**, code **1098** — `f/B.a(B otherDivision)` (`f/B.java:371-407`). Gated by `BM()` (`f/B.java:303-312`): `nRebaixados > 0 && nRebaixados != rebaixadosDireto` (i.e. some relegation slots are contested, not direct) — with a Brazil-specific carve-out (`divisao == 4 && country == 29 && SR.bk()`) that forces `rebaixadosDireto = nRebaixados` instead (no playoff that season). Field interleaves the **own division's relegation-zone table positions beyond direct relegation** (`fG(nRebaixados)`, reversed — worst first) with the candidate division's **promotion contenders** (`otherDivision.yi().l(nRebaixados, true)`, also reversed) or, when no sibling division is given, the country's out-of-league pool (`KR.ek()`). Pair count = `nRebaixados - rebaixadosDireto`.

Ported in `Core/Competitions/PromotionRelegation`: `SwapAdjacentDivisions`/`SwapLastDivisionWithPool` for the `ee()` main loop (group-less case only), `AccessPlayoffField`/`RelegationPlayoffField` to build the two playoff fields (the caller still builds the actual `KnockoutBracket` with code 1099/1098). Both numeric-parameter overloads remain (for tests and ad-hoc use) and now have `ConfigLigaType`-based overloads (`Core/Competitions/ConfigLigaType`, populated by `Brasfoot.Data.WorldLoader.LoadLeagueConfigs` from the `.cfg`): `Z.K(divisao)` (`best/Z.java:1278-1283`) turned out **not** to be a separate per-country table — it is simply `(divisao-1)`'s `ConfigLigaType.nRebaixados` (`Z.ds[divisao-2].getnRebaixados()`), ported as the static helper `ConfigLigaType.AccessPlayoffPoolSize(division, divisionAbove)`. `vagasSobemPeloMataMata`/`nRebaixados`/`rebaixadosDireto` are read straight from the loaded `ConfigLigaType` via `AccessPlayoffField(standing, config, divisionAbove)`/`RelegationPlayoffField(standing, config, pool)`/`SwapAdjacentDivisions(upper, upperStanding, upperConfig, lower, lowerStanding)`/`SwapLastDivisionWithPool(last, lastStanding, lastConfig, pool)`.

### 3.7 Port status (Fase 3, `dotnet/src/Brasfoot.Core/Competitions`)

Delivered and covered by tests (200 in the solution):

| spec item | port |
|---|---|
| fixture circle method + fixed tables (§3.3) | `FixtureGenerator` (`Generic`, `GenericAny`, fixed 3/4/5/6/9/19, `ForLeague`, turn rule) + generated `FixtureTables.g.cs` |
| league table `h.K` (§3.5 step 2) | `LeagueTable` / `TeamStanding` (`OrderByHk`) |
| daily accumulate + champion (§3.5 steps 1/3/4) | `LeagueCompetition` (`ScheduleOn` = `f.s.a`, `RecordResults` = `f.s.pO`) |
| national divisions (§5.1) | `SeasonBuilder.CreateNationalLeagues` / `CreateNationalDivision` / `CreateLeague` |
| group stage (§3.4) | `GroupStage` (one `LeagueCompetition` per group, shared free days, `PlacementsInOrder`, `Qualifiers`) |
| knockout seeding matrices `Zm..Zz` (§3.2) | `Competitions/BracketTables.g.cs`, generated by `re/tools/extract_bracket_tables.py` from the `f/s` constructor (the two constructors agree) |
| group→KO seeding `yP`/`yO` (§3.4) | `BracketSeeder` (`SeedByMatrix`, `FromGroupQualifiers`, `FromGroupQualifiersWithThirds`, `FromList`, `BestThirdsCount`, `BestExtraPlacementIndex`, `AlternateFirstsAndSeconds`, `NationalFinalPhase`, `Shuffle`, `DetermineGroupKnockoutSeeding`) + `GroupStage.SeedKnockout`/`SeedKnockoutWithThirds`/`SeedKnockoutAuto` |
| bracket structure/rounds (§4.1) | `KnockoutPlan` (round count `f/z:38-71`, round names `f/z.zB`/`io` with the `ZG==7→6` quirk and preliminar labels), `KnockoutBracket` with per-round `twoLeggedByRound` (`f.z.ZK`) |
| knockout resolution order + quirk (§3.4/§4.2) | `KnockoutTiebreak.Resolve` (leg wins → aggregate → away goals → code 2129 → shootout → away-team fallback) |
| bracket / rounds (§4.1/§4.2) | `KnockoutBracket` / `KnockoutPairing` / `KnockoutRound` (seeded pairing, per-round 1 or 2 legs, `PlayAll`) |
| group→KO alternate-crossing gate (§3.4) | `BracketSeeder.DetermineGroupKnockoutSeeding(CompetitionType, continent)` (pure gate, `f/s.java:852-867`) + `GroupStage.SeedKnockoutAuto` (wires it to real standings) |
| third-place decision (§4.2/§9.13) | `Competition.DecisaoTerceiroLugar` (`at.mq()`/`O(bool)`) + `KnockoutBracket.ResolveRound`/`KnockoutRound.ThirdPlace` (`f/G.java:78`, `f/z.zt`) |
| final positions (§3.6) | `KnockoutBracket.FinalPositions()` (with-knockout branch of `f/s.za`) and `LeagueCompetition.FinalPositions()` (no-knockout branch) |
| promotion/relegation + playoffs (§3.6.1/§5.1) | `Core/Competitions/PromotionRelegation`: `SwapAdjacentDivisions`/`SwapLastDivisionWithPool` (`best.Z.ee()`, group-less case), `AccessPlayoffField`/`RelegationPlayoffField` (codes 1099/1098, `f/B.BQ()`/`f/B.a(B)`); `ConfigLigaType` overloads of all four reading the division's config directly |
| league format config (§3.3/§5.1) | `Core/Competitions/ConfigLigaType` (`est.ConfigLigaType`, `est/ConfigLigaType.java:11-33`), loaded by `Brasfoot.Data.WorldLoader.LoadLeagueConfigs` from the `.cfg`; `AccessPlayoffPoolSize`/`HasAccessPlayoff`/`HasRelegationPlayoff`/`RelegationPlayoffSlots` port `f/B.BN()`/`BK()`/`BM()`/`BL()` |
| prize money (§9.14) | `Core/Competitions/CompetitionPrizes`: `KnockoutRoundPrize`/`KnockoutPrizes` (`f/G.c`), `LeagueFinalPositionPrize`/`LeagueFinalPositionPrizes` (`ah.c`) |
| ranking/reputation points (§9.14) | `Core/Competitions/CompetitionRanking`: `ClubRankingPoints`/`ManagerRankingPoints` (`ah.b`/`al.b`), plus list-of-final-positions overloads |
| generic cup draw (§5) | `CupDraw` (`BracketSize` + `SeedFromPool` = `f/f.a`: quadro 8..128, metades embaralhadas e intercaladas); CLI `copa` usa o sorteio |
| Copa do Brasil novo formato (§5) | `CopaDoBrasil` (`f/f.b` + `f/f.ad..av`): 8 potes de 10, 12 cabeças, reordenação por `h.a.abm` (nível/reputação/desempate) e fases 2129..2729; `KnockoutBracket.PlaySingleRound` joga as fases de 80/40 clubes (não potência de dois); CLI `copadobrasil` |
| session integration | `GameSession.Leagues`, `SessionHooks.BuildCompetitions`, `GameSession.RecordLeagueResults` |
| CLI | `brasfoot temporada`, `brasfoot copa` |

Pending fidelity gaps (also tracked in `planodeImp.md`):

- The `f.B` wrapper (`fc(1802/1803/90)`, code-1020 hand-off) is still not ported as a cohesive object — the port plays `KnockoutBracket` directly from the seeded list, and the new `PromotionRelegation`/`DetermineGroupKnockoutSeeding` helpers are called explicitly by whoever builds the season rather than being methods *on* a ported `f.B`/`f.s` object. Prizes and ranking/reputation points (the other two items previously listed here) **are now ported** — see §9.14 and the table above.
- Quirks faithfully reproduced (covered by tests): `yO` ignores two-leggedness at 16/32 teams (`Zw`/`Zz`, `f/s.java:824-833`); `yP` uses `Zo`/`Zp` for 4 without groups; the national phase (codes 7/10) uses the 8-team `Zs`/`Zt` regardless of size; `f/G.java:305`'s tie-break bug; `ee()`'s no-swap-on-size-mismatch and `agB`-pending skip (§3.6.1).
- The 11- and 25-team fixed tables (`best.t.dg`/`dh`) fall back to the corrected generic builder (§3.3): valid but not byte-identical, and documented as such.
- Promotion/relegation is only ported for the group-less division case (`Zd == 0`, what `SeasonBuilder` produces today); `ConfigLigaType` itself is now fully read from the `.cfg` and wired into `PromotionRelegation` (see above), but the grouped case (`Zd != 0`) is not.
- Fase 4 cups: as estaduais (`aq.sL`), as regionais e as amistosas ainda não são portadas.
  O agendamento da copa nacional (sorteio genérico `f/f.a` → `CupDraw`) e da Supercopa (`f.I`) nos dias
  livres da temporada, pela `GameSession`, **foi portado nesta rodada** —
  `Core/Competitions/CupCompetition` (uma perna por dia livre do tipo da competição, driblando
  `KnockoutBracket` fase a fase em vez de `PlayAll` de uma vez) e `Core/Competitions/Supercup`
  (formato verificado acima); `SeasonBuilder.CreateNationalCup`/`.CreateSupercup` registram a
  competição em `GameSession.Cups`, contabilizada e avançada a cada dia por
  `GameSession.RecordCupResults` (análogo a `RecordLeagueResults`/`f.s.pO()` das ligas). A Copa do
  Brasil novo formato (`CopaDoBrasil`, 8 potes de 10, 12 cabeças, reordenação por `h.a.abm`, fases
  2129..2729) **ainda não** usa esse agendamento — suas fases reordenam os vencedores por força entre
  uma fase e outra (`SecondStage`/`ThirdStage`/`LaterStage`), o que o `KnockoutBracket` automático de
  `CupCompetition` não reproduz; precisa de um driver dedicado equivalente
  (`CopaDoBrasilSchedule`, não escrito ainda). A notificação `Bh` também não foi portada.

---

## 4. Knockout tournaments (`f/z`, `f/G`)

### 4.1 Bracket `f.z`

- Constructor `z(s, teams, type, fixedRounds, bool[7], at, code)` derives round count from participant count: `Zg==2029` (Copa do Brasil) → 7 rounds; 128→7, 64→6, 32→5, 16→4, 8→3, 4→2, 2→1; or uses `fixedRounds-1` directly (`f/z.java:39-75`).
- `pO()` (`f/z.java:110-121`) advances the bracket: leg 1 of a single-leg round or any leg-2 round advances via `zs()`; otherwise the flag for leg 2 is set.
- `zs()` (`f/z.java:123-145`): if the current round is the last (`Zf == ZG`) or the code is 2029, calls `zx()` (final-round resolution); otherwise plays the current round `G.b(false,false)`, builds the next `f.G` with the *next* round's two-legged flag from `ZK[Zf+1]`, and increments `Zf`.
- `BH()` (`f/z.java:169-171`) advances the bracket without playing (used by some final phases).
- Round **names**: `io()` builds the label (`f/z.java:239-264`) — type 4 with 1 round named "Preliminar R1"/"Preliminar R2", and appends `" - Nº jogo"` for two-legged rounds (`fh`); `zB()` (`f/z.java:342-371`) picks the name array: code 1068 → `aq.pX`, code 6006 → `aq.abY`, else by number of rounds remaining (`aq.px..pD`, and `aq.ps` default).
- `z(at)` (`f/z.java:308-340`) assigns placement (`ah.a(at, pos, roundIdx)`) to every participant across all rounds — the "who reached which stage" record.

### 4.2 Knockout round `f.G`

- Flags: `aag` (away-goals enabled) is set from the constructor's `bl3` argument (`f/G.java:30,49-51`); `hO()` signals two-legged (`f/G.java:183`); `ze()` returns the bracket code (`f/G.java:459`).
- The decisive method `b(boolean bl2, boolean bl3)` (`f/G.java:238-436`) resolves each tie in this order:
  1. leg wins (n6/n7) if two-legged (`f/G.java:265-278`);
  2. aggregate goals `n9/n10` (`f/G.java:279-284`);
  3. **away goals** when `aag` and two-legged, comparing first-leg-*away* goals (`f/G.java:285-291`);
  4. if `ze()==2129` (Copa do Brasil final) — **always the away team** as a fixed tie-break (`f/G.java:292-294`);
  5. otherwise penalty shootout when the winning marker `hP` and shootout record `hR` are set — winner is the one whose shootout against the opponent (`hc()`) is recorded (`f/G.java:295-300`);
  6. **fallback** — `hc().lf() < hc().lf() ? 1 : 2`, i.e. a value compared against itself, which is always `false`, so the **away team advances** (`f/G.java:305`). This is an outright bug in the original bytecode (the two operands are the same expression), which the C# port presumably must reproduce deliberately.
- Winner/advance bookkeeping and the "champion recorded" step also live in `b(...)` (`f/G.java:306-334`): winners are stored in `aak/aal`, medals/history are written, and if the bracket's owning competition type `zf()` is 90-95 the championship feeds the world-cup handle via `a.SR.aY().a(...)` (`f/G.java:319-322`).
- Prizes: `c(int,int,boolean)` at `f/G.java:103-161` distributes prize money per the competition's prize tables (see `aq.sr..aeG`, §8, and the full breakdown in §9.14 — verified line-by-line and ported as `Core/Competitions/CompetitionPrizes`).
- **Third-place decision**, built while constructing a `G` round (`G.b(z, list, round, twoLegged, …)`, `f/G.java:40-81`): right after the new round is appended to the bracket (`z2.zp().add(this)`, line 77), if this new round has **exactly one match** (`aai.size() == 1`, i.e. it is the final, 2 teams) **and** the owning competition's `at2.mq()` (`decisaoTerceiroLugar`, `best/at.java:40,178-182`) is true **and** `z2.zt()` (`f/z.java:150-169`) returns exactly 2 teams, a third match is appended to the **same round's** home-leg list (`aai`), home/away = `zt()[0]`/`zt()[1]`, same day index as the main final match (`f/G.java:78-80`). `zt()` scans the bracket's rounds from the last back to the first and collects the losers (non-`zY()` participants) of the **first round it finds with exactly 2 matches** — in a standard power-of-two bracket that is always the semifinal. See §9.13.

---

## 5. National competitions

### 5.1 National leagues (`best.Z.Ar`, `f.B`, `est/ConfigLigaType`)

`best.Z.Ar()` (`best/Z.java:111-227`) builds the 4 national divisions of a country:

1. Sort clubs by rating (`h.a.cN`).
2. For each division 1..4:
   - Load `ConfigLigaType` via `Z.t(pais, divisao)` (`best/Z.java:124,166`). Missing/invalid configs or `nTimes` exceeding available teams fall back to hardcoded sizes: 20 (with 4 or 2 relegated), 18, 16, 14, 12, 10, with league name `ad.br(pais)` (`best/Z.java:127-147`).
   - Otherwise copy every config knob: `doisTurnos`, `nGrupos`, `jogosDentroGrupo`, `numeroTimesMataMata`, `nRebaixados`, `duasVoltasMataMata[7]`, `desempate`, `classificaPeloGeral`, `melhoresTerceiros`, `numeroTurnos=formula` (`best/Z.java:148-169`). Clamp: `nTimes<=10 && nRebaixados>2 → nRebaixados=2`.
   - When enough teams: **Brazil's 4th division is suppressed** (flag set via `SR.e(true)`) when `jogaEstadual` is on, since Série D is handled by the state feds (`best/Z.java:176-178`); otherwise take the top `nTimes` teams.
   - Create `f.B` (division container) with the config (including `rebaixadoPeloGrupo`, `rebaixadosDireto`, `vagasSobemPeloMataMata`, playoff legs flags; and if `versaoArquivo != 22` the direct relegation is forced to the configured count), then create the type-1 league `new s(options, teams, 0, … , b2)` and remove the consumed teams (`best/Z.java:181-215`).
3. After the four divisions: create the national cup if not suppressed — suppression for Brazil when any of {season over, regionais, `NovoFormatoCopa`, no estadual+no regionais} holds; otherwise `a(arrayList2, false, "criaLigas")` (`best/Z.java:218-229`). Brazil-with-estadual additionally runs `w.dZ()` (prime the state calendar).

The on-disk/format-driven part is `est/ConfigLigaType.java:11-33` (fields listed in §3.3) plus `est/LoadLigaOptions`.

Promotion/relegation runs in `best.Z.ee()` (`best/Z.java:453-598`): per division, direct promotion/demotion plus the two playoff brackets (promotion `f/B.BQ()` code 1099, relegation `f/B.a(B)` code 1098). `f/B` stores those brackets in `agA`/`agB` (`f/B.java:48-49`); `BQ()` only fires when `divisao>1 && agA==null && BK()` (`f/B.java:409-430`), and the relegation playoff only when `BM() && agB==null` (`f/B.java:372-404`).

**Port note.** `WorldLoader.LoadLeagueConfigs` (`Brasfoot.Data`) now reads every scalar field of `ConfigLigaType` from the `.cfg` (confirmed present in the serialized stream of `brasfoot-linux/conf_ligas_nacionais/*.cfg` by inspecting the field-name table CFR/Java writes ahead of the data: `pais`, `divisao`, `formula`, `desempate`, `nTimes`, `doisTurnos`, `nGrupos`, `jogosDentroGrupo`, `rebaixadoPeloGrupo`, `numeroTimesMataMata`, `valido`, `nRebaixados`, `duasVoltasMataMata`, `classificaPeloGeral`, `melhoresTerceiros`, `nome`, `nomeDivisao`, `playoffRebaixamento`, `duasVoltasplayoffReb`, `duasVoltasMataMataSobe`, `vagasSobemPeloMataMata`, `rebaixadosDireto`, `versaoArquivo`) into `Core/Competitions/ConfigLigaType`. The three `boolean[7]`/`boolean[3]` two-legged-flag fields (`duasVoltasMataMata`, `duasVoltasMataMataSobe`, `duasVoltasplayoffReb`) are **not yet** parsed — `JavaObjectReader` already supports arrays (`object?[]` of boxed elements), but no consumer needs them yet since `KnockoutBracket.twoLeggedByRound` is still set by hand at the call site. `ConfigLigaType.AccessPlayoffPoolSize`/`HasAccessPlayoff`/`HasRelegationPlayoff`/`RelegationPlayoffSlots` port `f/B.BN()`/`BK()`/`BM()`/`BL()` directly off the loaded fields; `PromotionRelegation`'s four methods each gained a `ConfigLigaType`-based overload so callers no longer have to extract the numbers by hand.

The cup slots: `jd()` (`best/Z.java:371-387`) assembles the cup-qualifier pool from division-1 `yV()` plus division-2 qualifiers (or `je()` = ranked list as fallback); `a(int, ArrayList, ArrayList, boolean)` (`best/Z.java:388-404`) reserves a slot for the previous champion automatically, then fills from the pool.

### 5.2 The Copa do Brasil (`f/f.java`)

- `a(f, list, bool[7])` (`f/f.java:42-80`) — generic cup for ≥8 teams, with halves shuffle.
- `b(f, list, bool[7])` (`f/f.java:82-187`) — the real Copa do Brasil when ≥91 teams and `NovoFormatoCopa`: 12 privileged clubs (state/regional champions first; `afU`), 8 pots of 10 drawn, 80 teams enter a first round whose knockout code is **2029** (`f/f.java:176`); subsequent rounds carry codes `fb(2129..2729)` (round names in `yh()` at `f/f.java:406-429`).
- The 2029 special-casing everywhere - `f/G.b` fixed tie-break (§4.2) returns the *away* team, and `f/z.zs` handles 2029 as an always-final round — is the mark of this competition.

### 5.3 State leagues (`best/w.java`, `f/o.java`, `est/ConfigEstadualType`)

- `best.w` is a state federation (`dr` = state id, `ds` = division container list; `best/w.java:40-46`). Divisions are built from a `ConfigEstadualType` per division (`dY()` at `best/w.java:54-160`): the config's `formula` indexes `aq.sL` (the 11 formula templates, `best/aq.java:776-836`), giving `nTimes`, `nGrupos`, `numeroTimesMataMata`, `doisTurnos`; default is 6 teams double round-robin. Formula 7/10 variants disable `jogosDentroGrupo`.
- São Paulo (`dr==25`) with `usaGrupoPadraoEstadual` and formula 7 division 1 uses the fixed "grupo padrão" club list (`w.z()` over `aq.sO` club ids) (`best/w.java:111-115`).
- The `conf_estadual` XML/CSV config is loaded by `ds()` (`best/w.java:190`, a regex 8-int parse in `j(String)` at `best/w.java:219`) and looked up via `g(id, div)` (`best/w.java:233`); `ef()` (`best/w.java:365`) is another config hook.
- `best.w.ee()` (`best/w.java:264-342`) does promotion/relegation between divisions and the unranked pool `dt`.
- State-level round naming lives in `f/o.eX(int)` (`f/o.java:74-111`, codes 318/319, 1802/1803, 14).
- `eh()` (`best/w.java:406-451`) returns the "all-important" club list for Copa do Brasil qualification; `Q(int)` (`best/w.java:468-538`) returns the 64/68 Série D participants per state, sorted — consumed by `best.a.m()` (`best/a.java:659-700`) which, on the `"cD"` event, fills the 4th division (via `best.w.Q(n2)`) and builds the Copa do Brasil field.
- Validation limits in `est/ConfigEstadualType`: `id` must be 0-26 (else `-1`) (`est/ConfigEstadualType.java:81`); divisions ≤4 and formulas bounded by `aq.sL.length`; `finaisIdaVolta[3]` defaults `{2,2,2}`.

### 5.4 Regionais

Four regional competitions over Brazilian states, driven by `SR` flags (`jogaRegionais`, `jogaRegionaisTodos`, `usaGrupoPadraoEstadual`). Created in `best.f.aj()` (called from `aa()`, `best/f.java:540`); `SR.X()` reflects `jogaRegionais` (`best/f.java:477`). Their day type is 10 (`Regionais`). This section's run-loop integration (skip rules, `aq()`/`ar()` guards) is described in §2.2; the internal format mirrors the estadual builder (`best/w.java` + `f/o`), sharing the 4-competition slot array `aZ[4]` (`best/f.java:116`).

---

## 6. International club competitions

### 6.1 The continental "type 4" championships (the six `liga*`)

Each is an `f.*` class calling `F(4, continent)`:

| continent | class | create-line | name source (`aq.tA`, `best/aq.java:849`) | primary code(s) |
|---|---|---|---|---|
| 0 Europe | `f/v` | `f/v.java:44` | `ligaC` (Liga dos Campeões) | 4005 → `yt()` |
| 1 South America | `f/r` | `f/r.java:41` | `lib` (Libertadores) | 4104 → `yt()` |
| 2 Africa | `f/t` | `f/t.java:35` | `ligaCaf` (Liga África) | — |
| 3 Asia | `f/u` | `f/u.java:32` | `ligaAfc` (Liga Ásia) | 1403 group |
| 4 Concacaf | `f/w` | `f/w.java:32` | `ligaConcacaf` | — |
| 5 Oceania | `f/y` | `f/y.java:31` | `ligaOfc` (Liga OFC) | — |

Each class hard-codes the participating club list in `yo()` (`f/v.java:46-86`, `f/r.java:46-…`, `f/t.java:40-…`) using `am(countryCode, countryId, slots)` records. `f/v` also carries the `Z`-bag for host seeding (`yq()`).

### 6.2 Second-tier continental cups (type 6)

- `f/x = F(6,0)` (Europa) — "Liga Europa", `ligaE` (`f/x.java:44-45`; name source `aq.tB[0]`, `best/aq.java:850`); league code 6005 → `Be()`.
- `f/H = F(6,1)` (South America) — "Copa Sul-Americana", `csa` (`f/H.java:40-41`); league code 6105 → `yt()`.

### 6.3 Third-tier (type 12) and other club trophies

- `f/J = F(12,0)` — Conference League (`f/J.java:44`; `aq.aeI[0]` = `"Conference League"`, `best/aq.java:852`); code 12005 → `Be()`.
- `f/A = F(5,7)` — Mundial de Clubes (`f/A.java:33`, name `"mundialclubes"`): six continental champions (`ZO..ZT` slots), random 4-team semi `ZM`, then the 4-team playoff `ZN`; kicked off by event `"cw"` (`best/a.java:722-725`) and its bracket code is **1068**. Creation is lazy: `aR()` builds one only when `isJogaIntClubes()` (`best/f.java:1912-1916`).
- `f/E = F(8,1)` — Recopa **Sul-Americana** (`f/E.java:25`): Libertadores champion (`aF().yz()`) vs Sul-Americana champion (`aH().yz()`), single `z` final created by `zR()` (`f/E.java:34-51`).
- `f/D = F(8,0)` — Recopa **Europa** (`f/D.java:25`): Champions champion (`aI().yz()`) vs Europa League champion (`aK().yz()`).
- `f/I = F(11, n2)` — SuperCopa (one per country; name `"Supercopa - <league>"` at `f/I.java:33`). Getters: `bW()` list and per-cup `Ab()`/`mw()` in `best.f.Z()` (§2.7 step 9).
  **Verified format (`f/I.Ab()`/`b(ah,ah)`, `f/I.java:37-55`)**: single match, previous-season **national
  league division-1 champion** (`((B)Z.eb().get(0)).cv(SR.H()-1)`, home, `cE.add(ah2)` first) vs
  previous-season **national cup champion** (`Z.bk(SR.H()-1)[0]`, from `best.Z.bk`,
  `best/Z.java:355-365`, which reads the cup's own `at.mn()` decisive-match record), **falling back to
  the cup runner-up** (`bk(...)[1]`) when the league champion and the cup champion are the same club
  (`ah2 != ahArray[0] ? ahArray[0] : ahArray[1]`, `f/I.java:40-45`). No away-goals, no two legs, bracket
  code 11. The Supercopa is skipped entirely (not created) when either club is unresolved — `b(ah,ah)`
  only builds the `z`/`G` pair when both arguments are non-null (`f/I.java:49-50`). Ported as
  `Core/Competitions/Supercup.SelectOpponent`/`.Create` (pure, takes the three teams as plain
  arguments — the previous-season bookkeeping itself is out of scope for this round, see §3.7/Fase 4).

### 6.4 The continental-champion slot provider

`f.s.fd(int n2)` (`f/s.java:1803-1835`) answers "who is the continental champion/runner-up of the country `RT`" for a given slot `n2`:

- continent 1 → `aF().cS()` (n2=1, Libertadores) / `aH().cS()` (n2=2, Sul-Americana);
- continent 0 → `aI().cS()` / `aK().cS()`;
- continent 2 → `aO().cS()`; 3 → `aL().cS()`; 4 → `aP().cS()`; 5 → `aQ().cS()`.

(`cS()` = current-season champion, `best/at.java:85-94`.)

### 6.5 The per-season club hook `ae()` (`best/f.java:950-1031`)

- For every country `Z` in `aG()`: `jy()` (season prep) (`best/f.java:952-956`).
- In order, `yq()` (establish participants) and `mw()` (open the competition) for the type-4/6/12 handles: `aP(), aF(), aI(), aO(), aL(), aQ(), aH(), aK(), mj(), aR()` — note `aH()` and `aK()` run `mw()` twice (`best/f.java:957-985`).
- National-team *club* promotions: `aR()` (Copa América) and friends also receive `mw()` (`aR()`, `aT/аU/aV/aW` when set, `aY()`, `ba()`, `aZ()`) (`best/f.java:986-996`).
- Qualifier handles `aT/aU/aV/aW` get `xZ()+mw()` (`best/f.java:997-1004`).
- Schedule leg-2 continental round: if a 4th day of type 4 exists (`a.d(4)`) schedule `"cw"` on it in queue `r` (`best/f.java:1005-1007`).
- Ensure the two Recopas exist (`new E()` driver via `aV()`, `new D()` via `aW()`) and `zR()` + `mw()` them (`best/f.java:1008-1029`).

### 6.6 The friendly tournament (`f.L` handle `yn()`)

`SR.yn()` is an `f.L` reserved for the season-opening "Torneio Amistoso". `iY()` (`best/f.java:597-609`) fills it with the 8 strongest clubs of `P()` and runs `yn().a(list, 0, "Torneio Amistoso", "Juazeiro", false)`, creating an 8-team KO. It is reset every rollover (`yn().xZ(); yn().clear()`, `best/f.java:551-552`).

---

## 7. National teams

### 7.1 The year cycle `ac()` (`best/f.java:703-939`)

Called each rollover from `aa()`. Sequence:

1. `ad()` — per-country daily/yearly updates (`jm()`, `jj()`) over all `Z` (`best/f.java:941-948`).
2. Reset (`xZ()`) and open (`mw()`) every NT competition handle that exists: `aK` (f.q), `aS` (f.p), `aR` (f.d), `aT` (f.c), `aU` (f.e), `aV` (f.h), `aW` (f.g), `IX` (f.K), `GC` (f.M), `GI` (f.N), plus the six qualifiers `aL/aM/aN/aQ/aO/aP` (`best/f.java:706-760`).
3. Season-countdown gates (`best/f.java:781-936`):

   | gate | season action | cadence |
   |---|---|---|
   | `bl == ae` | open Copa do Mundo (`aK.ya()`) | `bl += 4` (`best/f.java:781-789`) |
   | `bm-1 == ae` | start Europe qualifiers (`aM.fF(0)`) | — |
   | `bl-1 == ae` | start all six confederation qualifiers (`aN/aM/aN…` `ya()`/`fF(7)`/`Bj()`) | — |
   | `bm == ae` | Eurocopa (`aS.ya()`) | `bm += 4` (+ else-branch keeps `aS.p(null)`) |
   | `bn == ae` | Copa América (`aR.ya()`) | `bn += 4` |
   | `bo == ae` | Copa África (`aT.ya()`) | `bo += 4` |
   | `bp == ae` | Copa Ásia (`aU.ya()`) | `bp += 4` |
   | `br == ae` | Copa Ouro (`aV.ya()`) | `br += 2` |
   | `bq == ae` | Copa OFC (`aW.ya()`) | `bq += 4` |
   | `IZ == ae` | Finalíssima (`IX.Bs()`) | `IZ += 4` |
   | `Ja == ae` | Liga Nações Europa (`GC.Ar()`) | `Ja += 2` |
   | `Jb == ae` | Liga Nações Concacaf (`GI.Ar()`) | `Jb += 2` |

   Initial counters are set in `rU()` at `best/f.java:2934-2947` (`bl=4, bm=2, bn=2, IZ=3, bo=1, bp=1, bq=3, br=1, Ja=1, Jb=1`). The non-`bl-1` branches also keep the interim phases "open but idle" (`else if handle != null → p(null)`).

### 7.2 The continental cups (`f/*`, type 7)

| trophy | class | `F(...)` | create-line | name |
|---|---|---|---|---|
| Eurocopa | `f/p` | (7,0) | `f/p.java:30` | `"cro"` |
| Copa América | `f/d` | (7,1) | `f/d.java:38` | `"cam"` |
| Copa África | `f/c` | (7,2) | `f/c.java:38` | `"nCAfr"` |
| Copa Ásia | `f/e` | (7,3) | `f/e.java:38` | `"nCAsi"` |
| Copa Ouro (Concacaf) | `f/h` | (7,4) | `f/h.java:41` | `"nCOuro"` |
| Copa OFC | `f/g` | (7,5) | `f/g.java:29` | `"nCopaOFC"` |
| Copa do Mundo | `f/q` | (7,7) | `f/q.java:62` | `"ncm"` |
| Finalíssima | `f/K` | (13,7) | `f/K.java:30` | — (friendly-style single match) |

All `type 7` cups use the group builder with `nGrupos`/`melhoresTerceiros` flags (Eurocopa: 6 groups × 4, best thirds — `f/p.java:71-76`). The Eurocopa host rotates from a 10-country list: `yb()` at `f/p.java:105-116` returns `a.SR.s(nArray[(YH-1)%10])` with `{72, 3, 104, 97, 65, 154, 162, 193, 78, 152}` and `null` for index 0. Names come from `aq.tD` (`best/aq.java:853`, index 7 = Copa do Mundo).

### 7.3 The Copa do Mundo (`f/q`, code 7700 chain)

- World-cup years: `ya()` (`f/q.java:43-205`) computes per-confederation slots array (`nArray3` with entries ~{13,4,5,4,3}; a random `<=70` gate decides between the 4th/5th confederation extra slot, `f/q.java:108-111`), draws `Z.a(true, confed, slot, …)` over confederations 0-5, tops up to 32 teams when short (`f/q.java:113-130`), and creates the **32-team, 8-group phase** (`nTimes=32, nGrupos=8, duasVoltasMataMata=false-full`, `var0=7700`, `new s(...)`) (`f/q.java:159-179`). With "grupos reais" enabled the 32 drawn teams are placed in fixed real-fixed order, otherwise interleaved (`h.a.ad(8,4)`).
- `Bu()` (`f/q.java:210-261`) is the pre-phase variant producing a 48-team/16-group stage (also code 7700) — the current build keeps both paths, one triggered per format option.
- When the group phase completes, `pO()` dispatches 7700 → `aY().yt()` (`f/q.java` `yt()`, at `f/q.java:262-297`): take the top 2 of every group, seed via `Zw`-style matrix into a `z`, with away-goals disabled for the world final phase.

### 7.4 The qualifiers (type 9, codes 90xx/93xx/77xx)

Six confederation classes, all `F(9, continent)`:

| confederation | class | `F(...)` | create-line | seeds | league codes | continuation |
|---|---|---|---|---|---|---|
| South America | `f/n` | (9,1) | `f/n.java:28` | `ya()` | 9100 | `Bm()` |
| Europa | `f/l` | (9,0) / (9,70) | `f/l.java:30,47` | `ya()`, `fF(n)` | 9001 (+ `"Classificatório Eurocopa"` mode 70) | `Bk()` |
| África | `f/i` | (9,2) | `f/i.java:31` | `Bj()` | 9201 | `Bk()` |
| Ásia | `f/j` | (9,3) | `f/j.java:33` | `Bj()` | 9301, 9302, playoffs z 9300/9303, repescagem s 7701 | `yt()`, `Bm()`, `Bn()` |
| Concacaf | `f/k` | (9,4) | `f/k.java:31` | `Bj()` | 9400, 9402 | `Bp()`, `Bm()` |
| Oceania | `f/m` | (9,5) | `f/m.java:31` | `Bj()` | 9500, 9501 | `Bq()`, `yt()` |

`f/j.Bj()` (`f/j.java:49-…`): assembles all countries of continent 3, splits: 34 straight in (`YF`), 6+6 into a preliminary playoff `z` (code 9300), then group phase (code 9301), a 12-team two-group final phase (code 9302, `yt()`), a pré-repescagem `z` (code 9303), and the 6-team "Eliminatórias - Repescagem" `s` (code 7701, `Bn()`), whose 6 slots come from `bK/bR/bM/bS` champions plus a reserved `aga` team (`f/j.java:266-273`).

### 7.5 Liga Nações (`f/M`, `f/N`)

- `f/M = F(14,0)` — "Liga Nações Europa": four leagues (`Ar()` at `f/M.java:45`), codes **14001-14004**; winners of the top league run the final phase `yt()` (`f/M.java:116`); last-placed teams run the relegation playoff bracket `z` code **14006** (`BB()`, `f/M.java:130-140`); `xZ()` (`f/M.java:254`) swaps promoted/relegated teams between leagues using `ah.b(this, side)`.
- `f/N = F(14,4)` — "Liga Nações Concacaf": three leagues, codes **14401-14403** (`f/N.java:66-68`), `yt()` at `f/N.java:104`, `xZ()` at `f/N.java:261`.

### 7.6 Squad handling

`best.ah` (team) and `afQ` (helpers) provide the call-ups:

- `b(String,int)` at `best/ah.java:2017-2035` — create the coach record.
- `a(F, boolean)` at `best/ah.java:2142-2171` — player eligibility (≥35-player squads when full; skill gates `aq.qg/qh/qi`; position quotas via `J(boolean)` counts {{3 defenders, 5 mids, 5 forwards, 10 overall}} [inferred]); `lh()` builds the full squad.
- `bY(int)` at `best/ah.java:2226-2235` — salary-day check for managed teams (used by event `"ds"`).

---

## 8. Obfuscated name mapping

### 8.1 Competitions: `best.f` getters (the handle object is `SR`)

| method | line | class created | type/continent | competition |
|---|---|---|---|---|
| `aQ()` | `best/f.java:1900` | `f.y` | (4,5) | Liga dos Campeões da Oceania |
| `aP()` | `best/f.java:1896` | `f.w` | (4,4) | Liga dos Campeões da Concacaf |
| `aO()` | `best/f.java:1888` | `f.t` | (4,2) | Liga África |
| `aL()` | `best/f.java:1844` | `f.u` | (4,3) | Liga dos Campeões da Ásia |
| `aF()` | `best/f.java:1770` | `f.r` | (4,1) | Copa Libertadores |
| `aI()` | `best/f.java:1820` | `f.v` | (4,0) | Liga dos Campeões da Europa |
| `aH()` | `best/f.java:1804` | `f.H` | (6,1) | Copa Sul-Americana |
| `aK()` | `best/f.java:1836` | `f.x` | (6,0) | Liga Europa |
| `mj()` | `best/f.java:2918` | `f.J` | (12,0) | Conference League |
| `aR()` | `best/f.java:1912` | `f.A` | (5,7) | Mundial de Clubes (lazy) |
| `aV()` | `best/f.java:2021` | `f.E` | (8,1) | Recopa Sul-Americana |
| `aW()` | `best/f.java:2029` | `f.D` | (8,0) | Recopa Europa |
| `aY()` | `best/f.java:2052` | `f.q` | (7,7) | Copa do Mundo (+7780 repescagem) |
| `aZ()` | `best/f.java:2060` | `f.d` | (7,1) | Copa América |
| `sq()` | `best/f.java:2947` | `f.M` | (14,0) | Liga Nações Europa |
| `ym()` | `best/f.java:2963` | `f.N` | (14,4) | Liga Nações Concacaf |
| `yl()` | `best/f.java:2971` | `f.K` | (13,7) | Finalíssima |
| `bK()` | `best/f.java:2687` | `f.n` | (9,1) | Eliminatórias Sul-América |
| `bL()` | `best/f.java:2695` | `f.l` | (9,0/70) | Eliminatórias/Classificatório Europa |
| `bM()` | `best/f.java:2703` | `f.i` | (9,2) | Eliminatórias África |
| `bQ()` | `best/f.java:2747` | `f.j` | (9,3) | Eliminatórias Ásia |
| `bR()` | `best/f.java:2762` | `f.k` | (9,4) | Eliminatórias Concacaf |
| `bS()` | `best/f.java:2770` | `f.m` | (9,5) | Eliminatórias Oceania |
| `aR()`/`aV()`/`aW()` | (above) | `f.E/D` | (8,1)/(8,0) | Recopa Sul-Americana / Europa |

Note the *field-vs-getter* naming mismatches that must be preserved: field `aI` holds the `f.E` Recopa, field `aJ` holds `f.D`; getter `aV()` reads field `aI`, `aW()` reads `aJ`.

### 8.2 Event codes (`best/a.java`)

| `b(idx, code, queue)` code | string | dispatcher action |
|---|---|---|
| 1 | `"cw"` | `p()` — Mundial de Clubes |
| 2 | `"ds"` | `n()` — salaries |
| 3 | `"aj"` | `SR.aT()` — weekly evolution |
| 4 | `"cD"` | `m()`/`l()` — Série D / Copa do Brasil |
| 5 | `"dJ"` | `o()` — loan interest |
| 6 | `"cS"` | `b(false)` — call-ups |
| 7 | `"cO"` | `k()` — call-ups (all-seleções) |
| 8 | `"cSempregado"` | `b(true)` — forced call-ups |
| 9 | `"cPromocao"` | `afQ.zw()` — finances |
| 10 | `"criaMataMataAscenso"` | (no-op) |
| 11 | `"criaplayOffRebaixamento"` | (no-op) |

`b(idx, code, 0)` writes to the day's `q` queue; `b(idx, code, 1)` to `r` (`best/a.java:556-563`). `f(0)` dispatch reads the `q` list; `f(1)` reads `r` (`best/a.java:570`). The exposed getters are swapped: `r()` returns field `q`, `s()` returns field `r` (`best/a.java:766-772`).

### 8.3 Competition codes

| code | meaning | reference |
|---|---|---|
| 90..95 | national final-phase/decisão brackets | `f/s.java:1072`, `f/G.java:319-322` |
| 150 | Mundial de Clubes group phase | `f/A.java` (see §6.3) |
| 2029 | Copa do Brasil first round | `f/f.java:176`, `f/z.java:43` |
| 2129..2729 | Copa do Brasil round names / final tie-break | `f/f.java`, `f/G.java:292` |
| 1020 | national-league decider (20 teams, 1 turn) | `f/s.java:644,997` |
| 1068 | Mundial de Clubes bracket | `f/z.java:344` (`aq.pX`) |
| 1098 / 1099 | relegation / promotion playoff brackets | `f/B.java:402,428` |
| 4005 / 4104 | Champions / Libertadores phase-complete | `f/s.java:1046,1050` |
| 6005 / 6105 | Europa League / Sul-Americana phase-complete | `f/s.java:1048,1054` |
| 7700 / 7701 | Copa do Mundo group phase / repescagem | `f/q.java:164,227`; `f/j.java:271` |
| 9001 / 9100 / 9201 / 9300-9303 / 9400 / 9402 / 9500 / 9501 | confederational qualifiers | §7.4 |
| 12005 | Conference League phase-complete | `f/s.java:1052` |
| 14001-14004 / 14006 / 14401-14403 | Liga Nações | `f/M.java:76-79,140`; `f/N.java:66-68` |
| 1802 / 1803 | estadual final phase designs | `f/s.java:965-966` |
| 6006 | (recopa-style) bracket label | `f/z.java:345` (`aq.abY`) |

### 8.4 Day types → display settings

`best.f.ae(int,int)` (`best/f.java:2987-3022`) maps a day type (and mode) to the `verJint` settings index (0..20) used by UI toggles: 2→8, 3→9, 4→`n3`, 6→6/7, 12→14, 10→10, 8→12, 11→13, 15→15, 7→11/16, 9→17, 14→18, 5→19, 13→20.

### 8.5 Miscellaneous clean-name translations

| obfuscated | meaning | source |
|---|---|---|
| `c.a.SR` | the one `best.f` simulation singleton | `c/a.java:57` |
| `c.a.afQ` | global league/finance helper | `c/a.java:58` |
| `best.f.H()` / `J()` | season counter / current day index | `best/f.java:331,343` |
| `best.f.R()` / `S()` | day list / current-day matches | `best/f.java:423,427` |
| `best.f.N()` / `O()` / `P()` / `Q()` | countries / clubs / teams(by rating) / extra clubs | `best/f.java:367-407` |
| `best.f.aN()` | current-day matches (used by `as()`/`n()`) | `best/f.java:1880` |
| `best/a.java` day fields `s/t/u` | matches / league-KOs / at-competitions | `best/a.java:502,517,774` |
| `f.s.Zb / Zd / Zf / Ze / Zj / var0 / Zg` | teams / per-group qualifiers / round / last round / ranking mode / code / alt code | `f/s.java:39-52` |
| `f.z.Zf / ZG / ZH / ZK / Zg` | current round / last round / leg / leg-flags / code | `f/z.java:34-43` |
| `f.G.aai / aaj / aag` | first-leg ties / second-leg ties / away-goals flag | `f/G.java:30,238-291` |
| `est.ConfigLigaType`/`ConfigEstadualType` | league/state format data | `est/ConfigLigaType.java:11`, `est/ConfigEstadualType.java:81` |

---

## 9. Quirks and open questions

1. **The `f/G.java:305` tie-break bug.** The final fallback compares `hc().lf()` with itself; the expression is always false, so the away team is chosen whenever a tie reaches that branch. Deliberately reproduces the anomaly of the original binary. (No other tie-break in the same method has this defect; away-goals and penalties come first.)
2. **Scheduled-but-dead events.** `"criaMataMataAscenso"` (10) and `"criaplayOffRebaixamento"` (11) are written by `b(int,int,int)` into the calendars but the dispatcher `f(int)` never acts on them (`best/a.java:605-606`). The promotion/relegation playoffs are created elsewhere (`f/B`), so these strings are dead weight.
3. **Getter name swap.** In `best/a.java` the getter `r()` returns field `q` and `s()` returns field `r` (`best/a.java:766-772`). Any code using `best.a.r()`/`s()` must honor the swap; the day-loop queue read at `best/f.java:1860-1878` goes through these getters.
4. **`best/t.java` vs `f/t.java`.** `best/t.java` holds the static fixture generators (circle method etc.) *and* its own `t`-typed league class; `f/t.java` is the Liga África class. `f/s` imports `best.t` for the generators. Easy to confuse in a port.
5. **Type 15 (Torneio Amistoso)** is scheduled by the template (`b(2,15)` etc. at `best/a.java:250-`), has a display label (`aq.tz[15]`), but is *omitted from* the debug day printer `u()` (`best/a.java:803-930`). It is consum-ed by `f.L` via `iY()` (§6.6).
6. **Tautologies and redundant branches.** `j(int,boolean)` (`f/s.java:547-601`) has `if (b()!=7) a(...) else if (b()==7) a(...)` (`f/s.java:592-596`) — the same call in both arms. `yO()` uses `Zj==10 && var0==1403` to select which third-placed stream (§3.4). In `ac()` (`best/f.java:703`), `bn` increments itself twice (`best/f.java:864,873`) — `bn = ae==1 ? bn+4 : bn+4` is a no-op distinction.
7. **2/3/4-leg flags arrays.** `duasVoltasMataMata` is always a 7-element array; only a few indexes are ever read (`[0]` most prominently). `ConfigEstadualType.finaisIdaVolta[3]` defaults `{2,2,2}` but only subset values are honored where referenced.
8. **`ConfigEstadualType` clamps** state ids to 0-26 and rid the "SP" special case only for `dr==25` — new states or renamed ids beyond 26 are rejected.
9. **The Recopa vs Eurocopa field confusion.** The getter `aV()` returns the *South-American* Recopa (`f.E`) even though `v`-prefixed names otherwise suggest Europe; `aV` reads the field that happens to be named `aI`. Preserve the field-getter wiring exactly.
10. **`ae()` double-`mw()`.** `aH()` (Copa Sul-Americana) and `aK()` (Liga Europa) are opened twice per season in `ae()` (`best/f.java:971, 976, 980, 984`). Matches aren't duplicated (the second call is idempotent in practice), but a port should keep the sequence to match timing of `mw()` side effects.
11. **Open questions for confirmation.** (a) The three end-of-day helpers `au()/av()/aw()` (`best/f.java:1538,1592,1606`) are only partially mapped — their exact UI/notification roles matter for screen flow. (b) `f.s.B()`/`at` type-to-round-names wiring for codes 6006 (`aq.abY`) beyond the two special cases seen. (c) Whether the 48-team `Bu()` world-cup path is ever reachable in the shipped configuration or is dead legacy. (d) Exact semantics of the `verJint` indexes surfaced by `ae(int,int)` (§8.4) are for UI gating and are not observable in the simulation loop.
12. **Line-number drift.** A few decompiled artifacts in the task brief differ from the current decompilation (e.g. `aaa()` `aa()` body lines). All citations above were re-verified against the actual files; where a helper spans multiple lines the opening line cited is the method declaration.
13. **`decisaoTerceiroLugar` is not created by `ag.b` (correction of an earlier draft of this spec).** `best.ag.b(s)` (`best/ag.java:109-117`) is the AI squad-market sweep (same as `ag.jS()`, `best/ag.java:91-107`) — it has no relationship to the third-place decision. The flag is a plain field on `best.at` (getter `mq()`, setter `O(boolean)`, `best/at.java:40,178-182`), turned on in the constructors of the ten competitions that actually play a third-place match: `f/A` (Mundial de Clubes), `f/c` (Copa África), `f/d` (Copa América), `f/e` (Copa Ásia), `f/g` (Copa OFC), `f/h` (Copa Ouro/Concacaf), `f/M` (Liga Nações Europa), `f/N` (Liga Nações Concacaf), `f/p` (Eurocopa) and `f/q` (Copa do Mundo) — all ten call `this.O(true)` in their constructor (grep for `\.O(true)` across `f/*.java`). No domestic league/cup class sets it. The match is actually *created* in `f.G.b` (the round-constructor method, `f/G.java:78-80`, see §4.2), reading `z2.zt()` (`f/z.java:150-169`) for the two semifinal losers.
14. **Prize money and ranking/reputation points, verified line-by-line.** Three independent mechanisms exist; none of them share code.
    - **Knockout round prize**, `f.G.c(int n2, int n3, boolean)` (`f/G.java:103-161`): `n2` is the bracket's *competition type* (`f.z.tR`, i.e. `at.b()`), `n3` is the current round index (`f.G.oj`, 0-based). The third boolean parameter is read nowhere in the method body (both call sites — `f/G.java:53` at round construction and `f/G.java:439` at payout — pass different literals, `true`/`false`, with no observable difference); the port (`CompetitionPrizes.KnockoutRoundPrize`) drops it. Money is paid **only to the winner** of each match in the round (`f/G.java:316,329`: `this.V(vencedor)`, which re-reads `c(...)` and calls `ah.v(prize, 3)`), never to the loser. Per type: 2 (Copa Nacional) → `aq.ss` (8 entries: 1M/2M/4M/5M/7M/15M/20M/25M, `best/aq.java:574`), index shifted so the **last** round always lands on `ss[^1]` (`n3 += ss.length-1-zq()`, where `zq()`/`f.z.ZG` is the bracket's last round index); 4 (Internacional1 — Champions/Libertadores/etc.) → flat 500k for bracket codes 4101-4103, flat 1M for codes 4000-4004, else `aq.sw[continent][round]` (continent clamped to 1 only when negative, `best/aq.java:589-621`); 5 (Mundial de Clubes) → `aq.sx` (2M/5M/7M, `best/aq.java:622`); 6 (Internacional2 — Europa League/Sul-Americana) → flat 300k for code 6100, flat 500k for 6000-6004, else `aq.sy[continent clamped 0/1][round]` (`best/aq.java:623-638`); 8 (Recopa) → flat `aq.sz[0]` = 1M regardless of round (`sz[1]`=1.5M is never read by `c()`); 10 (Regionais) → `aq.sv` (100k/100k/400k, `best/aq.java:576`); 11 (Supercopa) → flat `aq.sA[0]` = 1M (`sA[1]`=500k never read); 12 (Conference League) → same code gate as type 6, table `aq.aeG` (`best/aq.java:641-656`, numerically identical to `sy` — a literal duplicate, not a bug, just copy-pasted data). Types 1 (Nacional), 3 (Estadual), 7 (Seleções), 9 (Eliminatórias), 13/14 have **no** branch in `c()` — they don't pay a round-by-round knockout prize this way. Ported as `Core/Competitions/CompetitionPrizes.KnockoutRoundPrize` (per-round lookup) and `.KnockoutPrizes(KnockoutBracket)` (walks every round's winners *and* the third-place match's winner — `f/G.java:78-80` appends that match to the same round's list, so it is paid the same round's prize).
    - **League/state final-position prize**, `ah.c(at2, n2)` (`private`, `best/ah.java:808-823`), called from `ah.a(at,n2,n3)` (the same method that assigns final positions, §3.6/`za()`) only when `n2 <= 10` and the club has a manager (`jZ()`, true for every real club once a coach is assigned, `best/ah.java:2029`). Type 1 (Nacional) → `aq.sr[divisão][posição-1]` (5 rows: division 0 all-zero, divisions 1-4 with 6 positions each, `best/aq.java:573`, e.g. division 1 champion = 5M, 6th place = 500k); type 3 (Estadual) **only when `at2.ip()==1`** (top state division) → `aq.su[posição-1]` (700k/500k/300k/100k, `best/aq.java:576`). No other competition type pays a position-based prize this way (copas and internationals only pay via the knockout-round mechanism above). Ported as `CompetitionPrizes.LeagueFinalPositionPrize`.
    - **Ranking/reputation points**, two *separate* 16-row tables (index = competition type 0-15, row = points by 1-based final position), both populated from the same `ah.a(at,n2,n3)` call: the **club**'s table is `ah.b(at2,n2,n3)` (`private`, `best/ah.java:912-1038`), accumulated into `nB[tipo]` (a per-type breakdown, presumably for a club-ranking screen); the **manager**'s table is `al.b(at2,n2,n3)` (`best/al.java:792-902`), accumulated into a single running total `oc` (getter `lI()`). The third parameter (`n3`, the round-hint from `za()`) is read by neither table — it only reaches `ah.d(int,int,int)` (fan-count/confidence growth for the champion, a small separate table not ported here, in scope for Fase 6) via `ah.b(at,n2,n3)`'s own first few lines, unrelated to the point tables. Both tables are checked against `tipo <= 14` (type 15, Torneio Amistoso, never scores) and the position bound (`posição < tabela.length`, implicitly capping payout at position 10 since no row has more than 11 slots). Base values (position 1→…→4/5/6, zero past the row's length): Nacional club `{15,10,8,7,6,5,4,3,2,1}` / manager `{25,10,8,7,6,5,4,3,2,1}`; CopaNacional club `{12,7,3,3}` / manager `{20,7,3,3}`; Estadual club `{5,3}` / manager `{15,3}`; Internacional1 club `{20,15,7,7,3,3}` / manager `{30,15,7,7}`; Mundial club `{10,5}` / manager `{25,5}`; Internacional2 club `{12,10,5,5}` / manager `{20,10,5,5}`; Seleções (base, world-cup only — see override) club `{50,35,10,5}` / manager `{35,20,10,5}`; Recopa club `{3}` / manager `{3}`; Regionais club `{2,1}` / manager `{5,3}`; Supercopa club `{2}` / manager `{2}`; ConferenceLeague club `{10,8,4,4}` / manager `{18,8,4,4}`; Finalíssima club `{}` (zero) / manager `{20,10}`; LigaNações club `{15,10,5}` / manager `{25,15,7,3}`. Overrides: Seleções with the competition's own continent (`at2.gg()`/`el()`) **≠ 7** (i.e. not the World Cup, which is `F(7,7)`) → club `{20,15,10,5}` / manager `{25,15,5,3}`; Nacional with division > 1 → division 2 uses club `{5,3,2,1}` / manager `{5,3,2,1}` (identical for both roles), division 3+ uses club `{2,1}` / manager `{2,1}`; Estadual with division > 1 → zero for both; Internacional1 **club table only**, when the *club's own* continent (`ah.gg()`, not the competition's) is outside Europe/South America (`> 1`) → `{18,12,3,3,1,1}` (the manager table has no such override — a genuine, deliberate asymmetry between the two tables). Ported as `Core/Competitions/CompetitionRanking.ClubRankingPoints`/`ManagerRankingPoints` (both the per-team lookup and the list-of-final-positions convenience overloads).

---

*End of specification. Coverage: calendar template (§1), day loop & events (§2), generic competition framework (§3), knockout (§4), national competitions (§5), international club competitions (§6), national teams (§7), name mapping (§8), quirks (§9). Gaps: exact screens/flows behind `S.aY` and `cR` bindings, full `au/av/aw` semantics, and translation-table contents of `aq.sL` are intentionally out of scope and flagged in §9.11.*