/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.K;
import best.Z;
import best.ah;
import c.a;
import components.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class l {
    private F U;
    private int ci;
    private boolean cj;
    private ah ck;
    private ah cl;
    private int cm;
    private ArrayList cn;
    private ArrayList co;
    private ArrayList cp;
    private int cq;
    private boolean cr;
    private int cs;
    private static ah ct = null;
    private static int cu = 0;
    private static int cv = 0;
    private static boolean cw = false;
    private int cx;

    public l(F f2, int n2, boolean bl2, boolean bl3, int n3) {
        block44: {
            block45: {
                int n4;
                int n5;
                block43: {
                    int n6;
                    this.U = null;
                    this.ci = 0;
                    this.cj = false;
                    this.ck = null;
                    this.cl = null;
                    this.cm = 0;
                    this.cn = new ArrayList();
                    this.co = new ArrayList();
                    this.cp = new ArrayList();
                    this.cq = -1;
                    this.cr = false;
                    this.cs = 0;
                    this.cx = 32;
                    this.cs = n3;
                    if (bl2) {
                        this.cx = 35;
                    }
                    this.U = f2;
                    this.ci = n2;
                    this.cj = bl2;
                    this.ck = f2.fg();
                    n5 = f2.fg().getPais();
                    if (this.ck != null) {
                        this.cq = this.ck.gg();
                    }
                    if (n3 != 0) break block43;
                    if (this.ck != null && this.ck.kn().booleanValue()) {
                        this.cn.add(a.SR.o(n5));
                    }
                    boolean bl4 = false;
                    if (this.ck.getPais() == 29 && this.U.fi() > 50 && new Random().nextInt(100) > 10) {
                        bl4 = true;
                    }
                    if (this.U.ff().booleanValue() || this.U.gm().booleanValue()) {
                        bl4 = true;
                    }
                    if (this.cq == 0 || bl4) {
                        n6 = 0;
                        while (n6 < a.SR.N().size()) {
                            if (((Z)a.SR.N().get(n6)).gg() == 0 && !this.cn.contains(a.SR.N().get(n6))) {
                                this.cn.add((Z)a.SR.N().get(n6));
                            }
                            ++n6;
                        }
                    }
                    n6 = 0;
                    while (n6 < a.SR.N().size()) {
                        if (((Z)a.SR.N().get(n6)).gg() == 0 && !this.cn.contains(a.SR.N().get(n6))) {
                            this.co.add((Z)a.SR.N().get(n6));
                        }
                        ++n6;
                    }
                    n6 = 0;
                    while (n6 < a.SR.N().size()) {
                        if (((Z)a.SR.N().get(n6)).gg() == 0) {
                            this.cp.add((Z)a.SR.N().get(n6));
                        }
                        ++n6;
                    }
                    break block44;
                }
                if (n3 != 1) break block45;
                if (this.ck != null && this.ck.kn().booleanValue()) {
                    this.cn.add(a.SR.o(n5));
                }
                boolean bl5 = false;
                if (this.ck.getPais() == 29 && this.U.fi() > 50 && new Random().nextInt(100) > 10) {
                    bl5 = true;
                }
                if (this.U.ff().booleanValue() || this.U.gm().booleanValue()) {
                    bl5 = true;
                }
                if (this.cq == 0 || bl5) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (((Z)a.SR.N().get(n4)).gg() == 0 && !this.cn.contains(a.SR.N().get(n4))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                }
                if (this.cq == 1) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (((Z)a.SR.N().get(n4)).gg() != 5 && !this.cn.contains(a.SR.N().get(n4))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                }
                if (this.cq == 2) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (!(((Z)a.SR.N().get(n4)).gg() != 0 && ((Z)a.SR.N().get(n4)).gg() != 3 || this.cn.contains(a.SR.N().get(n4)))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                }
                if (this.cq == 3) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (!(((Z)a.SR.N().get(n4)).gg() != 3 && ((Z)a.SR.N().get(n4)).gg() != 0 || this.cn.contains(a.SR.N().get(n4)))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                }
                if (this.ck.getPais() == 131 || this.ck.getPais() == 68) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (((Z)a.SR.N().get(n4)).gg() == 0 && !this.cn.contains(a.SR.N().get(n4))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                } else if (this.cq == 4) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (((Z)a.SR.N().get(n4)).gg() == 4 && !this.cn.contains(a.SR.N().get(n4))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                }
                if (this.cq == 5) {
                    n4 = 0;
                    while (n4 < a.SR.N().size()) {
                        if (!(((Z)a.SR.N().get(n4)).gg() != 5 && ((Z)a.SR.N().get(n4)).gg() != 3 || this.cn.contains(a.SR.N().get(n4)))) {
                            this.cn.add((Z)a.SR.N().get(n4));
                        }
                        ++n4;
                    }
                }
                n4 = 0;
                while (n4 < a.SR.N().size()) {
                    if (((Z)a.SR.N().get(n4)).gg() == 0 && !this.cn.contains(a.SR.N().get(n4))) {
                        this.co.add((Z)a.SR.N().get(n4));
                    }
                    ++n4;
                }
                n4 = 0;
                while (n4 < a.SR.N().size()) {
                    if (((Z)a.SR.N().get(n4)).gg() == 0) {
                        this.cp.add((Z)a.SR.N().get(n4));
                    }
                    ++n4;
                }
                break block44;
            }
            if (n3 != 2) break block44;
            int n7 = 0;
            while (n7 < a.SR.N().size()) {
                if (((Z)a.SR.N().get(n7)).gg() == 0 && !this.cn.contains(a.SR.N().get(n7))) {
                    this.cn.add((Z)a.SR.N().get(n7));
                }
                ++n7;
            }
        }
    }

    public ah a(boolean bl2, boolean bl3) {
        ah ah2 = null;
        boolean bl4 = true;
        if (this.U.fi() > 30 && this.ck.jZ().booleanValue() && new Random().nextInt(100) > 60) {
            bl4 = false;
        }
        if (this.U.ff().booleanValue() && this.ck.jZ().booleanValue()) {
            bl4 = false;
        }
        if (this.U.gm().booleanValue()) {
            bl4 = false;
        }
        if (bl4) {
            if (this.cn != null) {
                ah2 = this.a(this.cn, bl2);
            }
            if (this.cl == null && this.ck.getReputacao() > 2) {
                ah2 = this.a(this.co, bl2);
            }
        } else {
            if (this.cl == null && this.U.gm().booleanValue()) {
                ah2 = this.cI();
            }
            if (this.cl == null && this.U.gm().booleanValue()) {
                ah2 = this.a(this.cp, bl2);
            }
            if (this.cl == null && this.U.ff().booleanValue()) {
                ah2 = this.a(this.cp, bl2);
            }
            if (this.cl == null && this.ck.getReputacao() > 2) {
                ah2 = this.a(this.co, bl2);
            }
            if (this.cl == null && this.cn != null) {
                ah2 = this.a(this.cn, bl2);
            }
        }
        if (this.cl == null) {
            ah2 = this.cH();
        }
        if (this.cl == null && a.SR.H() > 2 && this.cj && this.ci < this.U.fk()) {
            ah2 = this.cJ();
        }
        return ah2;
    }

    public ah k(boolean bl2) {
        ah ah2 = null;
        ah2 = this.cH();
        return ah2;
    }

    private ah cH() {
        ah ah2;
        block14: {
            int n2;
            int n3;
            ArrayList<ah> arrayList;
            block15: {
                ah2 = null;
                arrayList = new ArrayList<ah>();
                n3 = 0;
                while (n3 < a.SR.P().size()) {
                    if (!((ah)a.SR.P().get(n3)).kn().booleanValue() && a.SR.P().get(n3) != this.U.fg() && !((ah)a.SR.P().get(n3)).jZ().booleanValue() && ((ah)a.SR.P().get(n3)).kc().size() < this.cx && ((ah)a.SR.P().get(n3)).lk() != this.U.fA()) {
                        arrayList.add((ah)a.SR.P().get(n3));
                    }
                    n3 += 1;
                }
                Collections.shuffle(arrayList);
                n3 = 1;
                if (this.ck.jZ().booleanValue()) {
                    n3 = 0;
                }
                boolean bl2 = true;
                boolean bl3 = false;
                if ((this.U.gg() == 1 || this.U.gg() == 4) && new Random().nextInt(100) > 15) {
                    bl3 = true;
                }
                if (this.cs == 2) {
                    n2 = 0;
                    while (n2 < arrayList.size()) {
                        if (!((ah)arrayList.get(n2)).lh() && ((ah)arrayList.get(n2)).gg() == 0 && ((ah)arrayList.get(n2)).getReputacao() >= 4) {
                            ah2 = (ah)arrayList.get(n2);
                            this.b((ah)arrayList.get(n2), this.ci);
                            break;
                        }
                        ++n2;
                    }
                }
                if (ah2 == null && this.cs != 2 && bl3) {
                    n2 = 0;
                    while (n2 < arrayList.size()) {
                        if (((ah)arrayList.get(n2)).getPais() == this.U.getPais() && ((ah)arrayList.get(n2)).a(this.U, n3 != 0)) {
                            ah2 = (ah)arrayList.get(n2);
                            this.b((ah)arrayList.get(n2), this.ci);
                            break;
                        }
                        ++n2;
                    }
                }
                if (ah2 != null || this.cs == 2 || !bl2) break block15;
                n2 = 0;
                while (n2 < arrayList.size()) {
                    if (((ah)arrayList.get(n2)).gg() == this.ck.gg() && ((ah)arrayList.get(n2)).a(this.U, n3 != 0)) {
                        ah2 = (ah)arrayList.get(n2);
                        this.b((ah)arrayList.get(n2), this.ci);
                        break block14;
                    }
                    ++n2;
                }
                break block14;
            }
            if (ah2 != null || this.cs == 2) break block14;
            n2 = 0;
            while (n2 < arrayList.size()) {
                if (((ah)arrayList.get(n2)).a(this.U, n3 != 0)) {
                    ah2 = (ah)arrayList.get(n2);
                    this.b((ah)arrayList.get(n2), this.ci);
                    break;
                }
                ++n2;
            }
        }
        return ah2;
    }

    private ah cI() {
        ah ah2 = null;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (((ah)a.SR.P().get(n2)).getReputacao() >= 4 && a.SR.P().get(n2) != this.U.fg() && !((ah)a.SR.P().get(n2)).jZ().booleanValue() && ((ah)a.SR.P().get(n2)).kc().size() < this.cx && ((ah)a.SR.P().get(n2)).lk() != this.U.fA()) {
                arrayList.add((ah)a.SR.P().get(n2));
            }
            ++n2;
        }
        Collections.shuffle(arrayList);
        n2 = 1;
        if (this.ck.jZ().booleanValue()) {
            n2 = 0;
        }
        if (ah2 == null) {
            int n3 = 0;
            while (n3 < arrayList.size()) {
                if (((ah)arrayList.get(n3)).gg() == 0 && ((ah)arrayList.get(n3)).a(this.U, n2 != 0)) {
                    ah2 = (ah)arrayList.get(n3);
                    this.b((ah)arrayList.get(n3), this.ci);
                    break;
                }
                ++n3;
            }
        }
        return ah2;
    }

    private ah cJ() {
        int n2;
        ah ah2 = null;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n3 = 0;
        while (n3 < a.SR.P().size()) {
            if (a.SR.P().get(n3) != this.U.fg() && !((ah)a.SR.P().get(n3)).jZ().booleanValue() && ((ah)a.SR.P().get(n3)).kc().size() < 35 && ((ah)a.SR.P().get(n3)).lk() != this.U.fA()) {
                arrayList.add((ah)a.SR.P().get(n3));
            }
            ++n3;
        }
        Collections.shuffle(arrayList);
        n3 = 1;
        if (this.ck.jZ().booleanValue()) {
            n3 = 0;
        }
        boolean bl2 = true;
        boolean bl3 = false;
        if ((this.U.gg() == 1 || this.U.gg() == 4) && new Random().nextInt(100) > 15) {
            bl3 = true;
        }
        if (ah2 == null && this.cs != 2 && bl3) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                if (((ah)arrayList.get(n2)).getPais() == this.U.getPais() && ((ah)arrayList.get(n2)).a(this.U, false)) {
                    ah2 = (ah)arrayList.get(n2);
                    this.b((ah)arrayList.get(n2), this.ci);
                    break;
                }
                ++n2;
            }
        }
        if (ah2 == null && this.cs != 2 && bl2) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                if (((ah)arrayList.get(n2)).gg() == this.ck.gg() && ((ah)arrayList.get(n2)).a(this.U, false)) {
                    ah2 = (ah)arrayList.get(n2);
                    this.b((ah)arrayList.get(n2), this.ci);
                    break;
                }
                ++n2;
            }
        } else if (ah2 == null && this.cs != 2) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                if (((ah)arrayList.get(n2)).a(this.U, false)) {
                    ah2 = (ah)arrayList.get(n2);
                    this.b((ah)arrayList.get(n2), this.ci);
                    break;
                }
                ++n2;
            }
        }
        if (ah2 == null) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                if (((ah)arrayList.get(n2)).a(this.U, false)) {
                    ah2 = (ah)arrayList.get(n2);
                    this.b((ah)arrayList.get(n2), this.ci);
                    break;
                }
                ++n2;
            }
            if (ah2 == null && arrayList.size() > 0) {
                ah2 = (ah)arrayList.get(0);
                this.b((ah)arrayList.get(0), this.ci);
            }
        }
        return ah2;
    }

    private ah a(ArrayList arrayList, boolean bl2) {
        int n2;
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n3 = this.ck.getDivisao() - 1;
        int n4 = this.ck.getDivisao() + 1;
        int[] nArray = new int[]{4, 5, 5, 10, 6, 5};
        if (this.ck.getDivisao() == 1) {
            n3 = 1;
        }
        if (this.cs == 1) {
            n3 = 1;
            n4 = 2;
            if (this.ck.gg() == 0 && this.ck.getReputacao() >= 4 && this.U.fi() >= 40) {
                n4 = 1;
            }
        }
        int n5 = 0;
        while (n5 < arrayList.size()) {
            int[] nArray2;
            if (this.U.fi() <= 5) {
                n3 = 0;
                n4 = ((Z)arrayList.get(n5)).js();
            } else if (this.U.fi() <= 20) {
                n4 = ((Z)arrayList.get(n5)).js();
            }
            if (this.U.fi() <= 20) {
                n3 = 0;
            }
            if (this.cs == 0) {
                n2 = 0;
                while (n2 < ((Z)arrayList.get(n5)).jg().size()) {
                    if (((Z)arrayList.get(n5)).jg().get(n2) != this.U.fg() && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).getDivisao() <= n4 && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).lk() != this.U.fA() && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).getDivisao() >= n3 && ((Z)arrayList.get(n5)).jg().get(n2) != this.ck && !((ah)((Z)arrayList.get(n5)).jg().get(n2)).jZ().booleanValue() && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).kc().size() < this.cx) {
                        nArray2 = ((ah)((Z)arrayList.get(n5)).jg().get(n2)).J(true);
                        arrayList2.add((ah)((Z)arrayList.get(n5)).jg().get(n2));
                    }
                    ++n2;
                }
            } else {
                n2 = 0;
                while (n2 < ((Z)arrayList.get(n5)).jg().size()) {
                    if (((Z)arrayList.get(n5)).jg().get(n2) != this.U.fg() && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).getDivisao() <= n4 && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).lk() != this.U.fA() && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).getDivisao() >= n3 && ((Z)arrayList.get(n5)).jg().get(n2) != this.ck && !((ah)((Z)arrayList.get(n5)).jg().get(n2)).jZ().booleanValue() && ((ah)((Z)arrayList.get(n5)).jg().get(n2)).kc().size() < this.cx) {
                        nArray2 = ((ah)((Z)arrayList.get(n5)).jg().get(n2)).J(true);
                        arrayList2.add((ah)((Z)arrayList.get(n5)).jg().get(n2));
                    }
                    ++n2;
                }
            }
            ++n5;
        }
        Collections.shuffle(arrayList2);
        ah ah2 = null;
        n2 = 1;
        if (this.ck.jZ().booleanValue()) {
            n2 = 0;
        }
        if (this.cs == 1) {
            int n6 = 0;
            while (n6 < arrayList2.size()) {
                if (((ah)arrayList2.get(n6)).b(this.U, n2 != 0)) {
                    ah2 = (ah)arrayList2.get(n6);
                    break;
                }
                ++n6;
            }
        } else if (this.cs == 2) {
            int n7 = 0;
            while (n7 < arrayList2.size()) {
                if (!((ah)arrayList2.get(n7)).lh() && ((ah)arrayList2.get(n7)).getReputacao() >= 4) {
                    ah2 = (ah)arrayList2.get(n7);
                    break;
                }
                ++n7;
            }
        } else {
            int n8 = 0;
            while (n8 < arrayList2.size()) {
                if (((ah)arrayList2.get(n8)).a(this.U, n2 != 0)) {
                    ah2 = (ah)arrayList2.get(n8);
                    break;
                }
                ++n8;
            }
        }
        this.b(ah2, this.ci);
        return ah2;
    }

    private void b(ah ah2, int n2) {
        this.cl = ah2;
        this.cm = n2;
    }

    public static int a(F f2, ah ah2) {
        if (f2 == null || ah2 == null) {
            return 0;
        }
        if (!f2.fz().booleanValue()) {
            return 5;
        }
        if (ah2 == f2.fg()) {
            return 2;
        }
        if (ah2.kc().size() >= 35) {
            return 6;
        }
        int n2 = 4;
        int n3 = 0;
        int n4 = 0;
        while (n4 < a.SR.bt().size()) {
            if (((t)a.SR.bt().get(n4)).x().fg() != null && ((t)a.SR.bt().get(n4)).x().fg() == ah2) {
                ++n3;
            }
            ++n4;
        }
        if (n3 >= n2) {
            return 3;
        }
        if (!l.d(f2, ah2)) {
            return 4;
        }
        f2.q(ah2);
        return 1;
    }

    public static int b(F f2, ah ah2) {
        cw = false;
        if (f2 == null || ah2 == null || !f2.ft().booleanValue()) {
            return 0;
        }
        if (ah2 == f2.fg()) {
            return 2;
        }
        if (ah2.kb() < (long)f2.fl()) {
            return 5;
        }
        if (ah2.kc().size() >= 35) {
            return 3;
        }
        if (!l.d(f2, ah2)) {
            return 4;
        }
        f2.a(ah2, f2.fl(), false, false, false);
        cw = true;
        return 1;
    }

    public static int a(F f2, ah ah2, int n2) {
        int n3;
        cw = false;
        ct = f2.fg();
        cu = 0;
        int[] nArray = ct.J(false);
        int[] nArray2 = new int[]{3, 4, 4, 5, 4};
        double[] dArray = new double[]{1.5, 1.5, 1.5, 1.5, 2.0, 1.0};
        double[] dArray2 = new double[]{1.0, 1.0, 1.0, 1.0, 1.5, 2.0};
        double[] dArray3 = new double[]{0.5, 0.2, 0.2, 0.2, 0.5, 1.0};
        int[] nArray3 = new int[]{15, 20, 20, 10, 10, 2};
        int n4 = 0;
        if (nArray[f2.getPosicao()] >= nArray2[f2.getPosicao()]) {
            if (f2.fi() < 30 || f2.getIdade() > 35) {
                n4 = f2.fk() - Math.round(f2.fk() * nArray3[f2.getPosicao()] / 100);
            } else {
                n3 = (int)Math.round((double)f2.fk() * dArray3[f2.getPosicao()]);
                n4 = f2.fk() + n3;
            }
        } else if (nArray[f2.getPosicao()] == 1) {
            n3 = (int)Math.round((double)f2.fk() * dArray[f2.getPosicao()]);
            n4 = f2.fk() + n3;
        } else {
            n3 = (int)Math.round((double)f2.fk() * dArray2[f2.getPosicao()]);
            n4 = f2.fk() + n3;
        }
        if (n2 >= n4) {
            n3 = l.c(f2, ah2);
            if (n3 == 1) {
                return 4;
            }
            if (n3 == 2) {
                return 6;
            }
        } else {
            if (ah2.kb() >= (long)n4 && ((n3 = l.c(f2, ah2)) == 0 || n3 == 2)) {
                cv = n4;
                return 7;
            }
            return 0;
        }
        return 1;
    }

    public static int c(F f2, ah ah2) {
        if (ah2.gg() == 0) {
            return 0;
        }
        if (f2.gh() == 0 && f2.fg().getReputacao() >= 4) {
            if (ah2.getReputacao() >= 4 || ah2.getDivisao() == 1) {
                return 0;
            }
            if (ah2.getReputacao() >= 3 || ah2.getDivisao() == 1) {
                cu = f2.fj() * 2;
                return 2;
            }
        } else {
            if (f2.fg().getReputacao() >= 3 && ah2.getReputacao() >= 3) {
                return 0;
            }
            if (f2.fg().getReputacao() == 3 && ah2.getReputacao() == 2) {
                return 0;
            }
            if (f2.fg().getReputacao() == 3 && ah2.getReputacao() == 1) {
                return 0;
            }
            if (f2.fg().getReputacao() <= 2) {
                return 0;
            }
        }
        return 1;
    }

    public static boolean d(F f2, ah ah2) {
        if (ah2.gg() == 0) {
            return true;
        }
        if (f2.gh() == 0 && f2.fg().getReputacao() >= 4) {
            if (ah2.getReputacao() >= 4 || ah2.getDivisao() == 1) {
                return true;
            }
        } else {
            if (f2.fg().getReputacao() >= 3 && ah2.getReputacao() >= 3) {
                return true;
            }
            if (f2.fg().getReputacao() == 3 && ah2.getReputacao() == 2) {
                return true;
            }
            if (f2.fg().getReputacao() == 3 && ah2.getReputacao() == 1) {
                return true;
            }
            if (f2.fg().getReputacao() <= 2) {
                return true;
            }
        }
        return false;
    }

    public static void a(ah ah2, F f2) {
        int[] nArray = ah2.J(false);
        int[] nArray2 = new int[]{2, 3, 3, 5, 3, 2};
        int n2 = 0;
        while (n2 <= 4) {
            if (nArray[n2] < nArray2[n2]) {
                int[] nArray3 = new int[]{f2.getPosicao(), f2.fi()};
                l.a(ah2, nArray3);
            }
            ++n2;
        }
    }

    public static void a(ah ah2, int[] nArray) {
        int n2 = ah2.getReputacao();
        int n3 = n2 - 2;
        int n4 = n2 + 1;
        if (n3 < 0) {
            n3 = 0;
        }
        Z z2 = null;
        F f2 = null;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        if (ah2.kn().booleanValue()) {
            z2 = a.SR.o(ah2.getPais());
            if (z2 != null) {
                int n5 = 0;
                while (n5 < z2.jg().size()) {
                    if (!((ah)z2.jg().get(n5)).jZ().booleanValue() && z2.jg().get(n5) != ah2 && n3 <= ((ah)z2.jg().get(n5)).getReputacao() && n4 >= ((ah)z2.jg().get(n5)).getReputacao()) {
                        arrayList.add((ah)z2.jg().get(n5));
                    }
                    ++n5;
                }
                Collections.shuffle(arrayList);
                f2 = l.a(arrayList, nArray);
            }
        } else {
            n3 = n2 - 1;
            n4 = n2 + 1;
            if (n3 < 0) {
                n3 = 0;
            }
            int n6 = 0;
            while (n6 < a.SR.P().size()) {
                if (!((ah)a.SR.P().get(n6)).jZ().booleanValue() && a.SR.P().get(n6) != ah2 && ((ah)a.SR.P().get(n6)).gg() == ah2.gg() && n3 <= ((ah)a.SR.P().get(n6)).getReputacao() && n4 >= ((ah)a.SR.P().get(n6)).getReputacao()) {
                    arrayList.add((ah)a.SR.P().get(n6));
                }
                ++n6;
            }
            Collections.shuffle(arrayList);
            f2 = l.a(arrayList, nArray);
        }
        if (f2 != null) {
            f2.a(ah2, f2.fk(), false, false, false);
        } else {
            f2 = F.a(ah2, nArray[0], null, 0, null, false);
            if (f2 != null) {
                K.a(false, f2, ah2);
            }
        }
    }

    public static F a(ArrayList arrayList, int[] nArray) {
        int n2 = nArray[1] - 5;
        int n3 = nArray[1] + 5;
        int n4 = nArray[0];
        F f2 = null;
        int[] nArray2 = new int[]{3, 4, 4, 6, 4, 3};
        if (n2 < 5) {
            n2 = 5;
        }
        if (n3 > 100) {
            n3 = 100;
        }
        int n5 = 0;
        ArrayList arrayList2 = new ArrayList();
        int n6 = 0;
        while (n6 < arrayList.size()) {
            arrayList2.clear();
            arrayList2.addAll(((ah)arrayList.get(n6)).kc());
            Collections.shuffle(arrayList2);
            n5 = 0;
            int n7 = 0;
            while (n7 < arrayList2.size()) {
                if (((F)arrayList2.get(n7)).getPosicao() == n4) {
                    ++n5;
                }
                if (f2 == null && ((F)arrayList2.get(n7)).getPosicao() == n4 && ((F)arrayList2.get(n7)).fi() >= n2 && ((F)arrayList2.get(n7)).fi() <= n3 && !((F)arrayList2.get(n7)).ff().booleanValue() && !((F)arrayList2.get(n7)).gm().booleanValue()) {
                    f2 = (F)arrayList2.get(n7);
                }
                ++n7;
            }
            if (f2 != null && n5 >= nArray2[n4]) break;
            f2 = null;
            ++n6;
        }
        return f2;
    }

    public ah cK() {
        return this.cl;
    }

    public void g(ah ah2) {
        this.cl = ah2;
    }

    public int cL() {
        return this.cm;
    }

    public void F(int n2) {
        this.cm = n2;
    }

    public static int cM() {
        return cu;
    }

    public static int cN() {
        return cv;
    }

    public static boolean cO() {
        return cw;
    }

    public static void l(boolean bl2) {
        cw = bl2;
    }

    public boolean cP() {
        return this.cr;
    }

    public void m(boolean bl2) {
        this.cr = bl2;
    }
}

