# Brasfoot 22-23: Transfer Market and Contracts, Behavioral Spec

Source: CFR-decompiled code in `re/decompiled`. All paths below are relative to that directory.
Notation: `rand(n)` means `new java.util.Random().nextInt(n)` (uniform 0..n-1). The game creates a new `Random` for almost every draw. `aq.cu(n)` uses one shared static `Random` and also returns 0..n-1. `round(x)` means Java `Math.round` (half-up to long or int). Integer expressions such as `a*b/100` use Java **int** arithmetic, so they truncate and can overflow.
Global state: `c.a.SR` is the single game-state object (class `best.f`). In the text it is written `SR`.

---

## 0. Enumerations and constants

| Concept | Values | Ref |
|---|---|---|
| Position (`F.en`, `getPosicao`) | 0=G goleiro, 1=L lateral, 2=Z zagueiro, 3=M meia, 4=A atacante | `best/aq.java:550` (`rI = {"G","L","Z","M","A"}`) |
| Continent (`ac.gg()`, `ah.gg()`, `Z.gg()`, `F.gg()`) | 0=Europe, 1=South America, 2=Africa, 3=Asia, 4=CONCACAF, 5=Oceania | `best/ac.java` (enum args: name, code, id, continent, nivel, ...) |
| Country ids used in rules | 1 AFS, 3 ALE, 9 ARS, 10 ALG, 11 ARG, 21 BEL, 29 BRA, 42 CHI, 43 CHN, 46 COL, 49 CRS, 51 CSR, 57 EGI, 59 EMI, 65 ESP, 68 EUA, 72 FRA, 84 HAI, 85 HOL, 97 ING, 98 IRA, 104 ITA, 107 JAP, 129 MAR, 131 MEX, 141 NIG, 143 NOZ, 150 PAR, 151 PER, 154 POR, 162 RUS, 169 SEN, 174 SIR, 190 TUN, 195 URU | `best/ac.java` |
| "Top-5 leagues" `aq.rW` | {3 ALE, 72 FRA, 104 ITA, 97 ING, 65 ESP} | `best/aq.java:553` |
| Min strength to be signed by a league club, by division `aq.qg` | {1, 40, 30, 20, 5} (index = division 0..4) | `best/aq.java:172` |
| Min strength to be signed by a non-league club, by reputation `aq.qh` | {1, 10, 20, 40, 50, 55} (index = reputation 0..5) | `best/aq.java:173` |
| Max strength any club will sign, by reputation `aq.qi` | {20, 30, 45, 85, 100, 100} | `best/aq.java:174` |
| Initial cash by division `aq.sC[div][0]` | {3.5M, 15M, 12M, 10M, 3.5M} | `best/aq.java:658` |
| Season income by division `aq.sD[div][0]` | {3.5M, 6M, 4.5M, 2.5M, 2M} | `best/aq.java:659` |
| Season index `SR.H()` | starts at 1 and is incremented at each new season | `best/f.java:331-341` |

There are two kinds of club. The flag `ah.kn()` is true for **league clubs**, which are clubs inside a simulated national league with divisions and are flagged in `best/Z.java:117`. The others are **reputation clubs**: foreign clubs with no league, rated only by `reputacao` 0..5. Many formulas branch on this flag.

---

## 1. Data model

### 1.1 Player (`best.F`, Serializable)
Fields at `best/F.java:44-110`; getters and setters follow them.

| Field | Accessor | Meaning |
|---|---|---|
| `dm` | `getNome` | name |
| `ek` | `ff()` / `a(Boolean)` | **craque** (star). Forced true if `el` is true (`F.java:167-172`) |
| `el` | `gm()` / `j(Boolean)` | **top mundial** (world-class) |
| `em` | `getIdade` / `setIdade` | age. `setIdade` clamps to 16..48 (or 16..20 for juniors), with a fallback of 35 or 18 (`F.java:194-203`) |
| `pais` | `getPais` | nationality id |
| `en` | `getPosicao` | position 0..4 |
| `eo` / `bW` | `fg()` / `n(ah)` | current club (object / club id). -1 or null means no club |
| `eq` | `fi()` / `ad(int)` | **força** (strength, 1..100) |
| `er` | `getLado` | side 0/1 |
| `es` | `fH()` / `aq(int)` | **potencial** (hidden potential 1..10; the DB calls it "hash"). If the player is a star and `es>8`, it is set to 10 |
| `et` | `fj()` / `ae(int)` | **salário** (per payment period: monthly if the "salário mensal" option is on, else weekly) |
| `eu` | `fk()` / `af(int)` | **valor do passe** (market value) |
| `ev` | `fl()` / `ag(int)`, `fm()` sets `ev=eu` | **preço pedido** (asking price) |
| `status` | `getStatus` | 1 = starter (titular) in the DB. This raises initial strength and value |
| `ew` | `fn()` | reset to 0 on transfer (unknown counter) |
| `ex` | `fF()` | derived role or side for L/M/A, computed from characteristics (`fG()`, `F.java:514-526`) |
| `ey`,`ez` | `getCr1/2` | characteristics (0..13) |
| `eA..eG` | `gJ..gP` | individual skills (only used with the "habilidade individual" option) |
| `eI` | `fo()` | injury or suspension end (epoch ms). `fP()` returns true while it is active |
| `eJ` | `fQ()`, `fR()` | **contract end date** (epoch ms). `fR()` = whole days remaining, minimum 0 (`F.java:1105-1120`) |
| `eK` | `fp()` | energy 0..100 |
| `eM` | `fu()` | strength-evolution accumulator |
| `eP` | `fw()` | set when both buying and selling clubs are human (purpose unknown) |
| `eW` | `fz()` / `g(Boolean)` | **available for loan** (emprestável) |
| `eX` | `gl()` / `i(Boolean)` | **currently on loan** (emprestado) |
| `eY` | `ft()` / `c(Boolean)` | **transfer-listed** (à venda) |
| `eZ` | `fA()` / `am(int)` | id of the **previous club**. The player can never be sold straight back to it |
| `fb` | `fC()` / `h(Boolean)` | **junior** (youth squad) |
| `fc` | `fD()` | displayed (noisy) potential |
| `fd` | `fE()` | junior **development %** (0..100) |
| `fe` | | junior development accumulator |
| `ff` | `fL()` / `ar(int)` | **season promoted from juniors** (drives the value discount) |
| `fh`, `fi` | `gy()`, `gz()` | career stats (games / goals), used for the hall of fame |
| `fp` (transient) | `gC()` / `ay(int)` | counter for selection into the season's best team, used for "top mundial" promotion |
| `fq` (transient) | `gG()` / `aB(int)` | cached contract days |
| `fr` (transient) | `gQ()` / `r(boolean)` | "contract-ending warning already sent" |

### 1.2 Team (`best.ah`, Serializable)
Fields at `best/ah.java:48-101`.

| Field | Accessor | Meaning |
|---|---|---|
| `mU` | `lk()` | club id |
| `dm` / `mV` | `getNome` / `jY` | name / short name |
| `mW` | `jZ()` | **human-controlled** |
| `mX` | `kn()` | **league club** (see §0) |
| `pais`, `dr` | `getPais`, `getEstado` | country, state |
| `divisao` | `getDivisao` | division (1 = top; 0 for clubs outside a league) |
| `hA` | `getNivel` | club **level** 1..25 (`setNivel` clamps, default 10) |
| `nc` | `getReputacao` | **reputation** 0..5 |
| `nb` | `kb()` / `e(long)` | **cash (caixa)** |
| `nd` | `kc()`, `kw()`=size | senior squad |
| `ne` | `ky()`, `kx()`=size | junior squad |
| `mZ` | `ka()` | manager (`best.al`) |
| `nx` | `kL()` | finance ledger (`best.C`) |
| `nr[5]` | `bQ(pos)` | per-position training value |

Money movement: `v(n,cat)` adds cash (`ah.java:1669`) and `w(n,cat)` removes it (`ah.java:1676`). Both write to the ledger only for human clubs. Ledger categories (`best/C.java:58-88`): income 1=transfers, 3, 5, 6=season grant, 9. Expense 1=transfers, 4, 7, 8=**rescission fine (multa)**, other. Salaries are booked separately through `f(long)`.

**Important: AI clubs have no transfer finances.** In `F.a(ah,int,...)` money moves only when a club is human (`F.java:2572-2580`), and AI buyers are never checked for cash.

### 1.3 Other classes
- `best.l`: the transfer engine (buyer search and the human offer evaluation).
- `best.ag`: the AI-to-AI transfer pass at season change.
- `best.N`: one AI auction lot.
- `components.an`: a sale of a human player to an AI club (fixed price or auction).
- `components.t`: a loan record.
- `best.ap`: a transfer history entry.
- `best.K`: promotion of juniors to seniors.
- `a.cz`, `a.jc`, `a.fy`, `a.jm`, `a.iX`, `a.dz`, `a.iA`, `a.ds`, `a.eg`: UI dialogs (see mapping table).

---

## 2. Market value and salary

Value and salary are **recomputed only** in these places:
- at the start of a new game (`fI()` → `fK()`, `fJ()`; `best/f.java:2002`, `best/p.java:162`);
- at every season change, for all senior players (`best/f.java:1097-1101`);
- when a junior is promoted (`best/K.java:95-96`) or a newgen is created (`F.java:1893-1894`).

Weekly strength changes therefore do **not** affect value or salary until the next season.

### 2.1 Value `F.fK()` (`best/F.java:975-1023`)
```
lvl  = club ? club.nivel : 10
P    = (2*forca)^2
base = lvl>=21 ? 750 : lvl>=20 ? 600 : lvl>=18 ? 500 : lvl>=12 ? 400 : 366
cont = continent of the player's NATIONALITY
if craque:  base = (lvl>=22 && cont==0) ? base*3 : (lvl>=21 && cont==0) ? base*2 : round(1.7*base)
if topMundial: base = round(1.6*base)
if pos==4 (A): base = round(1.3*base)
if status==1:  base = round(base + 0.2*base)
if age<16: age = 16                       // side effect
ageAdj = age<20 ? (32-age)*27 : age<=25 ? (32-age)*22 : age<32 ? (32-age)*15
       : age<34 ? (34-age)*10 : -(age-34)*50
base += ageAdj ; if base<=0: base = 60
value = P * base                          // int
if junior:                       value = round(value*0.03) * potencial
else if ff>0 && H()==ff:          value = round(value*0.18); if value>askingPrice && askingPrice>0: value = askingPrice
else if ff>0 && H()-1==ff:        value = round(value*0.35)
else if ff>0 && H()-2==ff:        value = round(value*0.65)
if junior && potencial==10:       value = round(value*1.5)
```
So a player promoted from the juniors is valued at 18%, then 35%, then 65% of full value during his first three seasons.

### 2.2 Salary `F.fJ()` (`best/F.java:915-973`)
```
b = 350
if club:
  if club country in TOP5 (ah.ki()):  b = div1 750 | div2 550 | div3 500 | div4/5 450 | else 350
  else:                                b = div1 600 | div2 500 | div3 450 | div4/5 400 | else 350
  if club.nivel > 20: b += 50
b -= {G:70, L:30, Z:40, M:0, A:50}[pos]
b  = round(0.5*b)
s  = forca*2*b
starBonus = (craque || top) ? forca*250 : 0
sal = age<32 ? s + starBonus : s - (age-32)*300 + starBonus
sal = max(sal, 500)
if top:    sal = round(sal*1.4)
if junior: sal = round(sal*0.1)
stored salary = optionMonthly ? sal*4 : sal
```

### 2.3 Initial strength from club level `F.fI()` (`best/F.java:539-683`), run at new game for every player
```
league club: (d,k) = div1 (20,7) | div2 (15,3) | div3 (5,1) | else (1,1)
reputation club: rep5 (22,7) | rep4 (15,4) | rep3..1 (5,1) | else (1,1)
L = nivel<=15 ? nivel : {16:17,17:18,18:19,19:21,20:25,21:26,22:27,23:28,24:29,25:30}[nivel]
f = L + d + rand(3)
if titular: f += 8 + rand(2)
if craque or top: f += 9 + rand(3)
if junior: f -= 23 (if <5 then 10); also call ga() and fZ()
if countryNivel(club.pais) <= 13: f = round(f * (nivel<=5 ? 0.4 : nivel<10 ? 0.65 : 0.75))
else if nivel<3: f*=0.5 ; nivel<5: f*=0.6 ; nivel<10: f*=0.7   (rounded)
f = min(f,100)
contract = today + (210 + rand(30)) days
then fK(), fJ()
```

### 2.4 Strength evolution (drives value at the next season)
This runs weekly (on the Sunday calendar event "aj", see `best/f.java:1944-1963`, `1974-2000`) through `F.fV()` (`F.java:1211`). Ages below 32 use `fW()` (growth, `F.java:1314-1443`) and ages from 32 use `fX()` (decline, `F.java:1445-1487`). Strength changes by ±1 each time the accumulator `eM` exceeds 1.0. Growth is capped by a club-quality ceiling: league clubs use the matrix `[div][rep]`, reputation clubs use rep5/4 → 100, rep3 → 65 (70 in `b()`), rep2 → 40, rep1 → 30, else 20. A per-country cap also applies, and juniors with high potential get a bonus. Decline stops at a floor: div1 35, div2 25, div3 10, otherwise 1. Juniors develop `fd` weekly through `fY()` (`F.java:1489-1522`).

---

## 3. Contracts

- **Length on transfer:** every permanent transfer, and every return from loan, sets the contract to **today + 180 days**. A loan sets it to **today + 365 days** (`F.java:2584-2588`; `a(long,true)` at `F.java:2505-2515`).
- **New game:** 210..239 days (§2.3). **Promoted junior:** 180 days (`K.java:94`).
- **Renewal dialog** (`a/fy.java`), opened from the "Propor contrato" menu (`a/eg.java:178`, `1127`):
  - Lengths are 6m, 1y, 2y or 3y, which is {180, 365, 730, 1095} days. They are added to the **current contract end date**, not to today (`a(days,false)`, `F.java:2507-2509`; `fy.java:85-93`).
  - Salary cap: the offered salary must be `< round(value*0.25)` (`fy.java:115-117`, `66-82`).
  - Acceptance (`fy.java:95-113`), using int arithmetic:
    - If `fR() < 60` days remain, the minimum is `sal - sal*{1,3,5,12}[len]/100`, a discount the player accepts.
    - Otherwise the minimum is `sal + sal*{10,12,15,5}[len]/100`, a raise.
    - If the offer is below the minimum, the player counter-asks for the minimum (capped at the salary cap) and the user can accept it.
  - Renewal also clears the transfer listing and resets the asking price to the value.
  - **Caveat:** because salary is recomputed from the formula at every season change (§2), a negotiated salary lasts only until the end of the season.
- **Expiry (human clubs only)**, checked on the team screen (`a/eg.java:441-479`):
  - If the "Atualizar automaticamente contratos encerrados" option is on (the default is true, `est/Options.java:77`), every expired contract is extended by 180 days from today at the same salary.
  - Otherwise there are warnings: "Contrato encerrado" (option 1) or "termina em menos de 1 mês" when fewer than 31 days remain (option 2).
  - **A human club's player with an expired contract cannot be fielded** (`F.a(I,bool)`, `F.java:1055-1072`).
- AI clubs ignore contracts completely. No code was found that releases a player when his contract expires, so **there is no free-agent pool**.

---

## 4. Human manager buying

### 4.1 Where and when
- Buying happens from the player search dialog `a/iA.java` (buttons at `iA.java:537-546`). Buttons are disabled for your own club's players, for players on loan, and in read-only mode (`yp`).
- **There is no transfer window.** Buying, selling and loans are allowed at any time from the management screen. No date gate was found.
- Squad limit: **35 seniors**. The UI messages say "30" or "32", but the code tests `>= 35` everywhere (`l.java:530,563`; `iA.java:244`).
- Junior limit: **20** (`a/ds.java:158`).
- There is no foreign-player limit.

### 4.2 "Comprar" at the asking price, `l.b(F,ah)` (`best/l.java:552-572`)
| Code | Condition |
|---|---|
| 0 "Não está à venda" | player not listed (`ft()==false`) |
| 2 | player already at your club |
| 5 "Sem dinheiro" | `cash < askingPrice` |
| 3 "Limite" | squad ≥ 35 |
| 4 "Não deseja se transferir" | `l.d(player,buyer)==false` (§4.4) |
| 1 | transfer at `askingPrice`, with no fine (`F.a(buyer, fl, false,false,false)`) |

### 4.3 Free-price offer, `a/cz.oL()` (`a/cz.java:90-163`) and `l.a(F,ah,int)` (`best/l.java:574-616`)
The offer is entered in thousands. Making an offer on a player who is not listed is a feature of the registered version only (`iA.java:239-241`). Flow:
1. If the offer exceeds cash: "Valor maior que dinheiro em caixa".
2. If the seller is **human** (hot-seat): the other human is asked to accept. If he does, the transfer goes through at the offered price.
3. Else if the player is listed and `offer >= askingPrice` (not in junior mode), use §4.2.
4. Else evaluate with `l.a(F,ah,offer)`:
```
c   = seller.J(false)          // count per position, excluding loaned-in players
min = {3,4,4,5,4}[pos]
v   = value
if c[pos] >= min:                                   // seller has depth
   if forca<30 || age>35: required = v - v*{15,20,20,10,10}[pos]/100     (int math)
   else:                  required = v + round(v*{0.5,0.2,0.2,0.2,0.5}[pos])
elif c[pos] == 1:         required = v + round(v*{1.5,1.5,1.5,1.5,2.0}[pos])
else:                     required = v + round(v*{1.0,1.0,1.0,1.0,1.5}[pos])
cu = 0
if offer >= required:
    w = l.c(player,buyer)   // 0 willing, 1 refuses, 2 wants double salary
    w==1 -> 4 "Não deseja se transferir"
    w==2 -> 6 : "player wants salary 2*currentSalary" -> if user accepts: salary := 2*sal, transfer at offer
    else -> 1 : transfer at offer
else:
    if buyer.cash >= required && (w = l.c(...)) in {0,2}:
        -> 7 COUNTER-OFFER: club accepts `required` (and, if w==2, salary 2*sal); if user accepts, transfer at `required`
    else -> 0 "Oferta recusada"
```
After a successful senior purchase, the seller restocks with `l.a(seller, player)` (§6.4).

There is **no randomness** in this acceptance decision. It is deterministic given the squad counts.

### 4.4 Player willingness `l.c` / `l.d` (`best/l.java:618-670`)
```
if buyer.continent == Europe -> 0 (willing)
if player.club.continent == Europe && player.club.rep >= 4:
     buyer.rep>=4 || buyer.div==1 -> 0
     buyer.rep>=3               -> 2 (wants 2x salary)          [c only]
     else                        -> 1 (refuses)
else:
     club.rep>=3 && buyer.rep>=3 -> 0
     club.rep==3 && buyer.rep in {1,2} -> 0
     club.rep<=2                 -> 0
     else                        -> 1
```
`l.d` returns true only in the 0 case. It is used for buy-at-asking-price, for loans, and as a pre-check for free offers (`iA.java:242`).

### 4.5 Buying juniors from other clubs (`a/ds.java:152-176`)
- This uses the same `cz` dialog with `CZ=true`.
- The flow is the same as §4.3, but step 3 is skipped and execution goes through `F.c(ah,int)` (`F.java:2525-2545`).
- `F.c` moves the player between the junior lists, with the seller credited and the buyer debited. The contract is unchanged and the asking price is set to the price paid.

### 4.6 Buying your own loaned-in player (`a/eg.java:860-884`)
- Allowed if your cash is at least the player's value.
- The loan is ended (the player returns to his owner), then a transfer at `value` with no fine.

---

## 5. Human selling

### 5.1 Listing (`a/jc.java`, menu "Vender Jogador")
- **Fixed price** (`dD`, `jc.java:116-120`): sets `listed=true` and `askingPrice=price`.
- **Auction** (`dE`, `jc.java:122-139`):
```
start = price
if price < value: d = rand(100)>50 ? 0.15 : 0.10 ; start = max(price, value - round(value*d))
new an(player, start, multaApplies=true, silent=false)
```
- The dialog shows an estimated fine: `fR()<=0` → 0%, ≤30 days → 12%, ≤60 → 20%, ≤90 → 22%, ≤180 → 25%, ≤722 → 30%, else 35% (`jc.java:83-86`).
- Unlisting (`eg.qR`, `eg.java:1117`) clears the flag and resets the asking price to the value.

### 5.2 Background AI purchases of listed human players (`best/f.java:1592-1604`, `1628-1641`)
- After each round, with probability `rand(100)>50` (49%), every listed player of every human club gets `new an(player, askingPrice, true, silent=true)`.
- `components.an` (`components/an.java`):
  - **Price gate** `uZ()`: proceed only if `askingPrice <= value + round(value*HL)`. `HL` is 0.10, or 0.15 with probability 19% (`rand(100)>80`). It is re-rolled every time the team screen opens (`a/eg.java:481-486`).
  - **Buyer search:** `new l(player, askingPrice, cj=true, ..., mode 0).a(false,false)` (§6.2).
  - **Execution:** `player.a(buyer, askingPrice, multa=true, ...)`.
- **Rescission fine (multa)**, paid by the human seller (`F.java:2563-2576`):
  - `days = fR()`. Rate: `days<=0` → 0; ≤30 → 0.12; ≤60 → 0.20; ≤90 → 0.22; ≤180 → 0.25; else 0.30.
  - The seller receives the price (category 1) and pays `round(price*rate)` (category 8).

### 5.3 Auction of a human player (`components/an.java`, `a/iX.java`)
- `an` with `silent=false` first gets an AI buyer, as in §5.2, at the start price.
- If any other human club has `cash > start`, dialog `iX` collects one bid from each of them (`iX.java:83-200`). The highest human bid wins if it is above the AI price.
  - Bug in `iX.nO()`: the "max" loop never updates the comparison value, so the winner is the *last* bid greater than the first bid.
- If no human can bid, the result is shown directly. When there is no buyer the message is "tente com um preço menor".
- The sale executes with the fine applied.

### 5.4 Unsolicited AI offers for human players (`best/f.java:1409-1415`, `a/eg.java:383-438`)
- When the game reaches a day with a human match (`f.ay()`), `bs` is set, and the team screen is not read-only, one of these happens:
  - `rand(100)==1` (1%): a **purchase offer**.
    - A random non-loaned player is chosen.
    - The buyer is found with `l(player, value, cj=true, ..., 0).a(true,false)`.
    - Offer = `value + round(value*0.3)`.
    - Accepting transfers him at that price with **no fine** (`a/jm.java:63-70`).
  - Else `rand(2)==1` (50% of the rest): a **loan request**.
    - Requires at least one player marked emprestável (`kr()>0`).
    - A random emprestável, non-loaned player is chosen and the buyer search is the same.
    - Accepting loans him out (`F.q`).
- If the candidate list is empty, `nextInt(0)` would throw. The code guards this only for loans.

---

## 6. AI transfer engine (`best/l.java`)

### 6.1 Constructor `l(F player, int price, bool cj, bool unused, int mode)` (`l.java:35-201`)
- `cx` (the buyer's squad cap) is 32, or **35** when `cj` is true.
- It builds three league lists of `Z` (country leagues, `SR.N()`):
  - `cn`, the preferred leagues;
  - `co`, the European leagues not in `cn`;
  - `cp`, all European leagues.

`sc` means the seller club's continent, and `X` is computed as follows:
```
X = (seller.pais==29 BRA && forca>50 && rand(100)>10) || craque || top
mode 0: cn = [own country league if seller is league club] + (all Europe if sc==0 || X)
mode 1: same start, then by sc:
        sc==1: all leagues except Oceania ; sc==2: Europe+Asia ; sc==3: Asia+Europe ;
        seller in MEX(131)/USA(68): Europe ; else sc==4: CONCACAF ; sc==5: Oceania+Asia
mode 2: cn = all Europe
```

### 6.2 Buyer search `a(bool,bool)` (`l.java:203-246`)
```
direct = true
if forca>30 && seller human && rand(100)>60: direct=false
if craque && seller human: direct=false
if top: direct=false
if direct: try leagues(cn); if none && seller.rep>2: try leagues(co)
else:      if top: try cI() ; if top: leagues(cp) ; if craque: leagues(cp) ;
           if seller.rep>2: leagues(co) ; leagues(cn)       (each only if still none)
if none: cH()
if none && H()>2 && cj && price < value: cJ()
```
- **`leagues(list)`** (`l.java:428-513`):
  - The candidates are the teams of every league in the list. They must not be the seller or the previous club, must not be human, must have a squad below `cx`, and must sit in a division window `[lo,hi]`.
  - The window is `[div-1, div+1]`, with `lo=1` when the seller is in division 1.
  - In mode 1 the window is `[1,2]`, narrowed to `[1,1]` if the seller is European, rep≥4 and the player has forca≥40.
  - If forca≤5 the window is `[0, numDivisions]`. If forca≤20 then `lo=0` and `hi=numDivisions`.
  - The candidates are shuffled and the first acceptable one is taken:
    - mode 0: `ah.a(player, posCap)`;
    - mode 1: `ah.b(player)`, which checks only space and min strength;
    - mode 2: squad<35 and rep≥4, with no strength check.
- **`cH()`** (`l.java:254-326`): the candidates are all *reputation* (non-league) clubs that are not human, have space (`<cx`), and are not the seller or the previous club.
  - Shuffle. If the player's nationality continent is South America or CONCACAF and `rand(100)>15`, first try clubs of the player's own country.
  - Then try clubs on the seller's continent.
  - A third "any club" loop exists but is unreachable.
  - In mode 2, take the first European club with rep≥4 and space.
- **`cI()`** (`l.java:328-355`): the first European club with rep≥4 and space that passes `ah.a`.
- **`cJ()`** (`l.java:357-426`), a "desperate" fallback: any non-human club with fewer than 35 players.
  - Try the same country if the player is from South America or CONCACAF (84%), then the same continent, then anyone passing `a()`.
  - **Finally it takes the first shuffled club unconditionally.**
  - So from season 3 on, a human listing priced below value always finds a buyer if one has space.
- The deal price is always the `price` passed to the constructor (`cL()`).

### 6.3 Club acceptance `ah.a(F, posCap)` (`best/ah.java:2142-2171`)
```
squad >= 35 -> no
league club: forca < qg[div] -> no ; reputation club: forca < qh[rep] -> no
forca > qi[rep] -> no
if posCap (seller is AI): no if current count (excluding loaned) G>3, L>5, Z>5, M>10, A>5
```
`ah.b(F)` (`ah.java:2177-2182`) checks only the squad and the minimum strength.

### 6.4 Seller restocking `l.a(ah seller, F sold)` and `l.a(ah,int[])` (`l.java:672-769`)
- For each position p in 0..4 where `seller.count[p] < {2,3,3,5,3}[p]`, call `l.a(seller, [sold.pos, sold.forca])`.
  - Bug: it uses the sold player's position, not p.
- `l.a(club, [pos, f])` picks a source pool:
  - league club: same-country league clubs, not human, with reputation in `[rep-2, rep+1]`;
  - otherwise: all same-continent clubs, not human, with reputation in `[rep-1, rep+1]`.
- The pool is shuffled. The pick is the first player with this position, `forca` in `[max(5,f-5), min(100,f+5)]`, not a star and not top, from a club that has at least `{3,4,4,6,4}` players at that position.
- If one is found: transfer at value (no money moves between AI clubs).
- Otherwise: create a newgen junior of that position (§7.3) and promote him at once (§7.4).

---

## 7. Season-change pipeline (`best/f.aa()`, `best/f.java:518-584`)
The order matters:
1. `ah()`: season +1 and a new calendar.
2. `ag()` (`f.java:1177-1198`): for every AI club, `kp()` relists players (§7.1). Every human club gets its season grant `kG()`.
3. `af()` (`f.java:1050-1103`):
   - all seniors: `gd()`, which is age +1 and the retirement check `ge()` (§7.2);
   - all juniors: `gf()`, which is age +1 and promotion (§7.4);
   - `c(true)` generates new juniors (§7.3);
   - finally **every senior's value and salary are recomputed** (`fK`, `fJ`).
4. `W()`: transfer history older than 10 seasons is purged (`f.java:458-472`).
5. **`ag.jO()`**, the AI-to-AI market (§7.5).
6. `ag.jQ()`: manager changes (not transfer-related).

### 7.1 AI listing `ah.kp()` (`best/ah.java:1153-1175`), also run at new game (`f.java:2002-2018`)
```
unlist all (listed=false, loanable=false); shuffle squad
for pos in 0..4: if count[pos] > {2,3,3,5,4}[pos] && rand(100)>50:
    first player with that pos, status==0, not craque, not top, not on loan:
        askingPrice=value; listed=true
        if rand(100) > 70 && forca < 42: loanable=true
        (only one per position)
```
In `ge()`, human clubs' players are automatically **unlisted** at each season change (`F.java:1590-1592`).

### 7.2 Retirement `F.ge()` (`best/F.java:1588-1656`)
- Only for age > 32, and not on loan.
- Effective age `a = age - (craque?1:0) - (top?3:0) - (GK?3:0)`. Roll `r = aq.cu(100)+1` (1..100).

| a | retire if |
|---|---|
| <32 | never |
| 32 | r>99 |
| 33-34 | r>90 |
| 35 | r>55 |
| 36 | r>30 |
| 37-38 | r>15 |
| 39 | r>5 |
| 40 | r>3 |
| 41-42 | r>2 |
| 43-48 | r>1 |
| >48 | always |

- On an AI club the player is removed with `F.a(null,-1,true)`. On a human club the game only sends the message "Desejo de aposentadoria". A human can retire a player manually if he is over 32 (`eg.java:540-546`).
- **Removal `F.a(String,int,bool)`** (`F.java:1658-1749`):
  - **Becoming a coach:** if the club is a league club, roll `rand(N)==1` with N = div0 120, div1 25, div2 50, div3 60, div4 100, else 125. Use N=5 for a star and N=2 for a top player. On success the player becomes a coach (`new al(name)`).
  - **Replacement junior:** one is generated in the same position unless `juniors >= 20 - m` (m is 2, or 5 if div>2 or rep<3, or 0 if human) and no urgent need exists.
  - **Immediate promotion:** the replacement is promoted at once if the position count minus 1 is below `{2,3,3,6,4}`, or the squad is under 16 (AI only), or the club is human with at least 20 juniors.
  - A hall-of-fame record is written when career stats pass thresholds.

### 7.3 Newgen generation `F.a(ah,pos,F,int,String,Boolean)` (`best/F.java:1780-1897`)
- **Potential** comes from roll `p = rand(100)+1`.
  - Clubs with `nivel>=19 || rep>3`: ≤2→1, ≤5→2, ≤10→4, ≤25→5, ≤60→6, ≤80→7, ≤90→8, ≤98→9, else 10.
  - Clubs with nivel≥15: ≤2→1, ≤5→2, ≤10→4, ≤30→5, ≤65→6, ≤90→7, ≤95→8, ≤98→9, else 10.
  - Others: ≤4→1, ≤8→2, ≤15→3, ≤25→4, ≤50→5, ≤75→6, ≤95→7, ≤98→8, ≤99→9, else 10.
  - In the first two tables the branch "≤4→3" is unreachable.
- **Craque** if `p==1`. **Age** `16+rand(4)`.
- **Position** (if not forced): new roll q, ≤10 G, ≤30 L, ≤50 Z, ≤80 M, else A.
- **Foreign nationality:** if `q==1 && nivel>=18`, with `k=rand(6)`:
  - Brazil: {ARG, CHN, URU, PAR, HAI, random 0..199}[k];
  - top-5 countries or POR or HOL: {ALE, POR, HOL, ITA, SIR, FRA}[k].
  - A foreign newgen gets potential `7+rand(4)`.
- Then `ga()` sets development: {16:15, 17:35, 18:55, 19:70, 20:75} + 1..5 + potential (capped). Then `fI()`, `fJ()`, and `fZ()` for the displayed potential (15% exact, 45% one less, 40% one more).
- **Yearly junior intake** `f.c(true)` (`f.java:1137-1165`):
  - Only clubs with fewer than 15 juniors.
  - n = league club ? `2+rand(3)` : `rand(3)` (+1 if nivel≥20).
  - If `n + juniors >= 20`, then `n = 20 - juniors - 2`.
  - The loop is `for i=0..n` inclusive, so it creates **n+1** juniors.
- **New game** `c(false)`: league clubs with rep≥3 and fewer than 12 juniors get 6 juniors (positions 0,1,2,3,3,4). Others with fewer than 5 get 5 juniors (positions 0..4).

### 7.4 Junior aging and promotion `F.gf()` (`best/F.java:1751-1778`) and `K.a()` (`best/K.java:21-129`)
- When a junior is age ≥ 20 at a club, use threshold `t = {1,4,5,6,6,6}[club.rep]`.
- He is promoted if `potencial >= t` **and** the senior count at his position (including loaned) is below `{3,5,5,8,6}`.
  - If promoted and the squad is under 32: promote, and generate a new junior if the club has fewer than 20.
  - If not promoted on an AI club, the same object is **recycled as a new newgen**. On a human club he stays.
- **Promotion strength:**
  - `b` = league club: div1 22, div2 17, div3 14, else 7 (5 if div<1); reputation club: rep5 20, rep4 15, rep3 12, rep2 7, else 5.
  - Add 5 if the club is European, then add `rand(5)`.
  - `forca = potencial + round(b * min(fd,100)/100)`, plus `rand(10)` more if potential ≥ 9.
- On promotion: contract 180 days, `ff = H()`, then value and salary are recomputed.
  - A craque stays craque only with probability 1/3. A top player becomes craque and loses top status.
  - Anyone else becomes craque with probability 1/200. A craque gets potential ≥ 8.

### 7.5 AI-to-AI market `ag.jO()` (`best/ag.java:22-28`)
The order is `jS()`, `jU()`, `jR()`, `jP()` (cleanup), `jT()`.
- **`jS()`** (league clubs, `ag.java:91-107`):
  - For each country league, each division, each AI club at list index `i` (the division's team list, probably ordered by final table): `k = i<=1 ? 1 : i<=5 ? 2 : i<=10 ? 3 : 4`.
  - Run `k` "surplus" sales (`ag.a(club, leagueFlag=true, surplus=true)`) and then `k` "excess" sales (`surplus=false`).
- **`jU()`** (reputation clubs, `ag.java:161-169`): the same, where i is the club's index in the global team list.
- **One sale `ag.a(ah, leagueFlag, surplus)`** (`ag.java:186-313`). Counts are `J(true)`, which include loaned players.
```
positions shuffled
surplus: pick first pos with count >= {4,5,5,10,8}; else first with count >= {3,4,4,8,6}
else:    pick first pos with count >  {3,4,4,6,4}
allowStars = rand(100)>10
candidate = random player at pos, not on loan, and (not craque OR allowStars)
leagueFlag: full=true unless (forca<40 && rand(100)>90)           ; mode 0
else (reputation club): full=false, mode 0, unless
        craque && rand(100)>30 | forca>=90 && rand>30 | 80-89 && rand>35 |
        70-79 && rand>45 | 60-69 && rand>75 | <60 && rand>95   -> full=true, mode 1
l = new l(player, value, cj=false, _, mode)
buyer = full ? l.a(false,false) : l.k(false)   // k() = cH() only
if buyer: player.a(buyer, value, false,false,false)
```
- **`jR()`** (`ag.java:81-89`): every AI club runs `ah.ku()` (`ah.java:1243-1256`). For each position with count (excluding loaned) below `{2,3,3,5,3}`, it calls `l.a(club, [pos, league ? qg[div] : qh[rep]])` to buy from a similar-reputation club or create and promote a newgen (§6.4).
- **`jT()`**, poaching of stars by big European clubs (`ag.java:119-159`):
  - The sellers are AI clubs that are either non-European with rep<5 or European with rep<4.
  - Each craque with forca>50 and age<31 qualifies with probability `rand(100)>25`.
  - Search mode 2 (European leagues, rep≥4, space), then a fallback through `k()`.
  - The transfer is at value.

### 7.6 In-season AI auctions (`best/N.java`, `a/hk.java:274-300`, `a/dz.java`)
- These are created only if the "Ver leilão de jogadores" option is on (default off, `est/Options.java:95`) and the round's competition type `w ∈ {1,3,10}`.
- `rand(4)` lots (0..3). Each lot:
  - picks a random AI club with at least 21 players;
  - calls `kv()`, which takes a random non-loaned non-star player from a position with count > `{2,3,3,5,3}`;
  - finds an AI buyer through `l(player, value, cj=true, _, 0).a(false,false)`.
- Human bidding (`dz.java:206-290`):
  - minimum bid `FW = round(value*0.5)`;
  - each human club with cash > 0 and squad < 35 bids once; a bid must be below cash.
- **Resolution** (`dz.pT`, `dz.java:240-277`):
```
r = rand(100); d = r>60 ? 0.62 : 0.45      // the "r>80 -> 0.82" branch is unreachable
aiPrice = round(FW*d) + bestBid + FW
if bestBid < FW: sold to AI buyer at aiPrice (or "não houve compradores")
else if bestBid < round(FW*2.5) && r>50 && AI buyer exists: sold to AI at aiPrice
else: sold to best human bidder at bestBid
```
If the dialog is not shown, for example when no human has money, the lots are simply discarded.

---

## 8. Loans (`components/t.java`, `best/l.java:520-550`, `F.q/F.r`)
- **The human borrows** (`iA.sz`, `iA.java:215-225`, and `l.a(F,ah)`):
  - Code 5 if the player is not `emprestável` (AI marks these in §7.1).
  - Code 2 if he is your own player. Code 6 if your squad is at 35 or more.
  - Code 3 if your club already has at least **4** loaned-in players (counted over `SR.bt()` by the player's current club).
  - Code 4 if `l.d` is false. Otherwise the loan is made (1).
  - **No fee and no salary change.**
- **Loan record** `t(player, ownerClub)`:
  - Ends at today + **366 days** (`t.java:21-27`).
  - The player moves with `F.a(borrower, 0, false, loan=true, false)`: `eX=true`, contract 365 days, no money.
- **The human lends out:**
  - Mark a player emprestável. At most 10 can be marked or out on loan (`eg.java:841-858`).
  - AI requests arrive through §5.4.
- **End of loan** (`f.au()`, `f.java:1538-1573`, run every round):
  - Expired loans return the player through `t.tN()` (`F.r(owner)`, contract 180 days).
  - If the owner is human with 35 or more players, the return is postponed (a one-time message) and retried every round.
- **Early recall** by the owner (`eg.qG`, `eg.java:886-901`) uses the same `tN()`.
- **The borrower buys outright:** see §4.6.
- **AI-to-AI loans do not exist.**

---

## 9. Transfer side effects `F.a(ah to, int price, bool multa, bool loan, bool loanReturn)` (`best/F.java:2547-2618`)
- `prevClub = from.id`.
- Reset: `ew=0`, `loanable=false`, `listed=false`. A loan sets `onLoan=true`; a return clears it.
- Money:
  - from human: `from.v(price,1)`, then pay the fine (§5.2) if `multa`;
  - to human: `to.w(price,1)`;
  - no money for loans or returns.
- Contract: 180 days, or 365 for a loan. `askingPrice = value`.
- Clear the captain and penalty slots if they pointed to this player. If both clubs are human, set `eP` and `from.I(false)`.
- Append `ap` (date, from, to, price) to `SR.bo()` and move the player between squads.
- **Salary does not change**, except for the 2x demand in §4.3.

---

## 10. Salaries paid and finances (context)
- Salaries are paid only by **human** clubs, through `kJ()` (`ah.java:1714-1731`). The total covers senior and junior salaries.
- They are paid on calendar event "ds": monthly on day 2, or weekly on Sunday (`f.java:1944-1963`).
- They are paid **only in months in which the club has a match** (`a.n()`, `best/a.java:702-710`, `ah.bY`).
- Initial cash `kH()` is `sC[div][0]`. For clubs outside Brazil with the state championship on, add `3.2 × payroll` (`ah.java:1699-1706`).
- Season grant: `kG()` adds `sD[div][0]` (`ah.java:1690-1697`).

---

## 11. Open questions
1. `F.fd()` / `ay(0)` (`F.java:115-128`, `2882-2887`; `f.java:1269-1294`): the counter is reset just before it is incremented. It looks impossible to reach the "≥2 selections" needed to become *top mundial*, unless a player appears more than once in `zM()`. This needs runtime confirmation.
2. Country id 1 (AFS, South Africa) is listed among the "big" European countries in `F.fd()`. It may be a typo.
3. The meaning of `ew`, `eP` and `ex`. Whether the list index `i` in `ag.jS` is the final table order (it depends on what `B.yi().yK()` contains at season change).
4. `SR.bs`, used in `f.ap()` to gate unsolicited offers, is probably "humans present / single machine". Not verified.
5. `SR.cd()` (whether the auction dialog is shown) is not inspected.
6. The int overflow in `v*{15..}/100` (`l.java:588`) and in `sal*{..}/100` (`fy.java:99-100`) for very large values. Decide whether C# should replicate it.
7. `jc` auction default mode: the `w` field defaults to 0, so whether "Leilão" is really selected at start depends on the radio-button listeners `jd`/`je` (not read).
8. A season-change detail: `ag()` runs before `af()`, so AI listing uses pre-recalculation values. Confirm the intended order if you want parity.

---

## 12. Obfuscated name → meaning

### Classes
| Obfuscated | Meaning |
|---|---|
| `best.F` | Jogador (Player) |
| `best.ah` | Time/Clube (Team) |
| `best.l` | NegociacaoTransferencia (buyer search + human offer evaluation) |
| `best.ag` | MercadoIA (season AI-to-AI market) |
| `best.N` | LoteLeilao (AI auction lot) |
| `best.K` | PromocaoJuniores (junior→senior promotion; also bulk generic player gen `r`) |
| `best.Z` | PaisLiga (country with simulated league; `jg()` teams, `js()` #divisions, `jn()` national team, `gg()` continent) |
| `best.ac` | enum Pais (country: id, abbreviation, continent `gg()`, nivel `getNivel()`) |
| `best.aq` | Constantes (tables qg/qh/qi/sC/sD/rI/rW; `cu(n)` shared RNG) |
| `best.C` | Financas/Ledger + money formatting `C.c(long)` |
| `best.ap` | HistoricoTransferencia (date, from id, to id, price) |
| `best.al` | Treinador (manager/coach) |
| `best.a` | DiaCalendario (calendar day; events "ds" salary, "aj" weekly evolution) |
| `best.f` | EstadoJogo / GameState (`c.a.SR`) |
| `best.I` | Partida (match) |
| `best.W` / `e.g` | DB player record |
| `best.b` | Hall of fame entry |
| `components.t` | Emprestimo (loan) |
| `components.an` | VendaParaIA (sale/auction of human player) |
| `components.as` | Mensagem (inbox message) |
| `a.cz` | DialogPropostaCompra |
| `a.jc` | DialogVenderJogador (fixed price / auction) |
| `a.iX` | DialogLeilaoVendaHumano |
| `a.dz` | DialogLeilaoIA |
| `a.jm` | DialogPropostaRecebida (buy/loan offer from AI) |
| `a.fy` | DialogNovoContrato |
| `a.iA` | DialogBuscaJogadores (buy/loan/offer buttons) |
| `a.ds` | TelaJuniores |
| `a.eg` | TelaPrincipalTime (team screen; offers, contract checks, loans) |
| `a.hk` | TelaResultadosRodada (triggers auctions) |
| `est.Options` | Opções (salarioMensal, autoRenovaContrato, avisoTerminoContrato, verLeiloes) |

### Player `best.F` fields/methods
| Name | Meaning |
|---|---|
| `dm` | nome |
| `ek` / `ff()` / `a(Boolean)` | craque |
| `el` / `gm()` / `j(Boolean)` | topMundial |
| `em` / `getIdade` | idade |
| `en` / `getPosicao` | posicao |
| `eo`,`bW` / `fg()` / `n(ah)` | clube |
| `eq` / `fi()` / `ad()` | forca |
| `es` / `fH()` / `aq()` | potencial |
| `et` / `fj()` / `ae()` | salario |
| `eu` / `fk()` / `af()` | valorPasse |
| `ev` / `fl()` / `ag()` ; `fm()` | precoPedido ; resetPrecoPedido |
| `status` | titular(1) |
| `eI` / `fo()` / `fP()` | fimContusaoSuspensao / estaIndisponivel |
| `eJ` / `fQ()` / `fR()` | fimContrato / textoContrato / diasContrato |
| `eK` / `fp()` | energia |
| `eM` | acumuladorEvolucao |
| `eW` / `fz()` / `g()` | disponivelEmprestimo |
| `eX` / `gl()` / `i()` | emprestado |
| `eY` / `ft()` / `c()` | aVenda |
| `eZ` / `fA()` / `am()` | clubeAnteriorId |
| `fb` / `fC()` / `h()` | junior |
| `fc` / `fD()` | potencialExibido |
| `fd` / `fE()` ; `fe` | desenvolvimentoJunior ; acumuladorJunior |
| `ff` / `fL()` / `ar()` | temporadaPromocao |
| `fp` / `gC()` / `ay()` | contagemSelecaoTemporada |
| `fr` / `gQ()` / `r(bool)` | avisoContratoEnviado |
| `fI()` | inicializaForcaPorNivelClube |
| `fJ()` | calculaSalario |
| `fK()` | calculaValor |
| `fV()`/`fW()`/`fX()` | evolucaoSemanal / crescimento / declinio |
| `fY()` | evolucaoJunior |
| `fZ()` | sorteiaPotencialExibido |
| `ga()` | inicializaDesenvolvimentoJunior |
| `gd()` / `ge()` | envelhecerTemporada / checaAposentadoria |
| `gf()` | envelhecerJunior/promocao |
| `a(String,int,bool)` | aposentar/remover + repor junior |
| `static a(ah,int,F,int,String,Boolean)` | gerarNewgenJunior |
| `a(long,bool)` | definirContrato(dias, aPartirDeHoje) |
| `a(ah,int,bool,bool,bool)` | transferir(destino, preco, aplicaMulta, emprestimo, retornoEmprestimo) |
| `c(ah,int)` | transferirJunior |
| `q(ah)` / `r(ah)` | emprestarPara / retornarDeEmprestimo |
| `a(I,bool)` | podeJogar (expired contract blocks human-club players) |
| `gg()` / `gh()` | continenteNacionalidade / continenteClube |

### Team `best.ah` fields/methods
| Name | Meaning |
|---|---|
| `mU`/`lk()` | id |
| `mW`/`jZ()` | humano |
| `mX`/`kn()` | clubeDeLiga |
| `divisao`, `hA`/`getNivel`, `nc`/`getReputacao` | divisão, nível, reputação |
| `nb`/`kb()`/`e(long)` | caixa |
| `nd`/`kc()`/`kw()` | elenco / tamanho |
| `ne`/`ky()`/`kx()` | juniores / tamanho |
| `mZ`/`ka()` | treinador |
| `nx`/`kL()` | ledger |
| `v(n,cat)` / `w(n,cat)` / `f(long)` | credito / debito / debitoSalarios |
| `kG()` / `kH()` | verbaTemporada / caixaInicial |
| `kJ()` / `kK()` | pagarSalarios / folhaSalarial |
| `ki()` | paisTop5 |
| `gg()` | continente |
| `J(bool)` / `kt()` / `bS(pos)` | contagemPorPosicao (true = incl. emprestados) |
| `kp()` / `ks()` | listarJogadoresIA / limparListagens |
| `kr()` | numEmprestaveis |
| `kq()` | numEmprestadosParaFora |
| `ku()` | completarElencoIA |
| `kv()` | escolherJogadorExcedente (auction) |
| `a(F,bool)` | aceitaContratar(jogador, aplicaLimitePosicao) |
| `b(F,bool)` | aceitaContratarSimples |
| `lh()` | elencoCheio (>=35) |
| `bY(mes)` | temJogoNoMes |

### `best.l` methods
| Name | Meaning |
|---|---|
| ctor `l(F,int,bool,bool,int)` | (jogador, preco, compradorCap35, _, modo 0/1/2) |
| `a(bool,bool)` | buscarComprador |
| `k(bool)` | buscarCompradorSoClubesSemLiga (=`cH`) |
| `a(ArrayList,bool)` | buscarEmLigas |
| `cH()`/`cI()`/`cJ()` | buscarClubesSemLiga / buscarGrandesEuropeus / buscarQualquer |
| `cK()`/`cL()` | comprador / preco |
| `static a(F,ah)` | pedirEmprestimo |
| `static b(F,ah)` | comprarPeloPrecoPedido |
| `static a(F,ah,int)` | avaliarProposta |
| `static c(F,ah)` / `d(F,ah)` | disposicaoJogador / jogadorAceita |
| `static a(ah,F)` / `a(ah,int[])` / `a(ArrayList,int[])` | reporElenco / comprarReposicao / acharJogadorSimilar |
| `cM()`/`cN()`/`cO()` | salarioExigido / valorContraproposta / houveTransacao |

### `best.f` (GameState) members used
| Name | Meaning |
|---|---|
| `H()` | temporadaAtual (1-based) |
| `O()`/`Q()`/`P()`/`N()`/`aN()` | jogadores / juniores / times / paisesComLiga / timesHumanos |
| `bt()` | emprestimos |
| `bo()` | historicoTransferencias |
| `aa()` | viradaDeTemporada |
| `af()` | envelhecimentoERecalculo |
| `ag()` | inicioTemporadaClubes |
| `c(bool)` | gerarJuniores |
| `ap()` | antesDaRodada (unsolicited offers) |
| `ax()` | aposRodada (loans end, AI purchases of listed human players) |
| `av()` / `au()` | vendasIAdeListados / fimEmprestimos |
| `aT()` | evolucaoSemanal |
| `aU()` | inicializacaoNovoJogo |
| `W()` | limparHistoricoAntigo |
