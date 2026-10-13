/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.D;
import best.F;
import best.Z;
import c.a;
import forms.t;
import java.util.ArrayList;

public class af {
    private String nome = null;
    private int md = -1;
    private int me = -1;
    private int mf = -1;
    private int mg = -1;
    private int mh = -1;
    private int mi = -1;
    private int mj = -1;
    private int mk = -1;
    private int ml = -1;
    private int mm = -1;
    private int mn = -1;
    private int mo = -1;
    private int mp = -1;
    private int mq = -1;
    private int mr = -1;
    private int ms = -1;
    private int mt = -1;
    private int mu = -1;
    private int mv = -1;
    private int mw = -1;
    private int mx = -1;
    private int my = -1;
    private int mz = -1;
    private int mA = -1;
    private int mB = -1;
    private int mC = -1;
    private int mD = -1;
    private int mE = -1;
    private int mF = -1;
    private int mG = -1;
    private int mH = -1;
    private int mI = -1;
    private int mJ = -1;
    private int mK = -1;
    private boolean mL = false;
    private boolean mM = false;
    private boolean mN = false;
    private boolean mO = false;
    private int[][] mP = new int[][]{{1, 10}, {11, 30}, {31, 50}, {51, 70}, {71, 100}};
    private int[][] mQ = new int[][]{{16, 25}, {26, 36}, {37, 60}};
    private int[][] mR = new int[][]{{1, 100999}, {101000, 500999}, {501000, 1000000}, {1000001, 3000000}, {3000001, 5000000}, {5000001, 10000000}, {10000000, 1000000000}};
    private ArrayList mS = new ArrayList();

    public ArrayList D(boolean bl2) {
        int n2;
        ArrayList<F> arrayList = new ArrayList<F>();
        if (this.ml >= 0) {
            this.mS.clear();
            n2 = 0;
            while (n2 < a.SR.N().size()) {
                this.mS.add(((Z)a.SR.N().get(n2)).jc());
                ++n2;
            }
        }
        n2 = 0;
        while (n2 < a.SR.O().size()) {
            if (this.i((F)a.SR.O().get(n2))) {
                arrayList.add((F)a.SR.O().get(n2));
            }
            ++n2;
        }
        if (bl2) {
            n2 = 0;
            while (n2 < a.SR.bN().size()) {
                if (this.i((F)a.SR.bN().get(n2))) {
                    arrayList.add((F)a.SR.bN().get(n2));
                }
                ++n2;
            }
        }
        return arrayList;
    }

    public void b(String string, int n2, int n3) {
        if (string.equals("gol")) {
            this.mq = 0;
            this.mr = n2;
            this.ms = n3;
        } else if (string.equals("des")) {
            this.mC = 0;
            this.mD = n2;
            this.mE = n3;
        } else if (string.equals("vel")) {
            this.mt = 0;
            this.mu = n2;
            this.mv = n3;
        } else if (string.equals("fin")) {
            this.mF = 0;
            this.mG = n2;
            this.mH = n3;
        } else if (string.equals("arm")) {
            this.mw = 0;
            this.mx = n2;
            this.my = n3;
        } else if (string.equals("tec")) {
            this.mI = 0;
            this.mJ = n2;
            this.mK = n3;
        } else if (string.equals("pas")) {
            this.mz = 0;
            this.mA = n2;
            this.mB = n3;
        }
    }

    private boolean i(F f2) {
        if (this.md >= 0 && f2.getPosicao() != this.md) {
            return false;
        }
        if (this.me >= 0 && f2.getLado() != this.me) {
            return false;
        }
        if (this.mf >= 0 && (f2.fi() < this.mm || f2.fi() > this.mn)) {
            return false;
        }
        if (this.mg >= 0 && (f2.getIdade() < this.mo || f2.getIdade() > this.mp)) {
            return false;
        }
        if (this.mq >= 0 && (f2.gK() < this.mr || f2.gK() > this.ms)) {
            return false;
        }
        if (this.mw >= 0 && (f2.gO() < this.mx || f2.gO() > this.my)) {
            return false;
        }
        if (this.mI >= 0 && (f2.gL() < this.mJ || f2.gL() > this.mK)) {
            return false;
        }
        if (this.mt >= 0 && (f2.gJ() < this.mu || f2.gJ() > this.mv)) {
            return false;
        }
        if (this.mF >= 0 && (f2.gP() < this.mG || f2.gP() > this.mH)) {
            return false;
        }
        if (this.mC >= 0 && (f2.gN() < this.mD || f2.gN() > this.mE)) {
            return false;
        }
        if (this.mz >= 0 && (f2.gM() < this.mA || f2.gM() > this.mB)) {
            return false;
        }
        if (this.mh >= 0 && (f2.fk() < this.mR[this.mh][0] || f2.fk() > this.mR[this.mh][1])) {
            return false;
        }
        if (this.mi >= 0 && f2.getCr1() != this.mi) {
            return false;
        }
        if (this.mj >= 0 && f2.getCr2() != this.mj) {
            return false;
        }
        if (this.mk >= 0 && f2.getPais() != this.mk) {
            return false;
        }
        if (this.ml >= 0 && f2.fg() != null && this.ml < this.mS.size() && f2.fg().getPais() != ((Integer)this.mS.get(this.ml)).intValue()) {
            return false;
        }
        if (this.mL && !f2.ff().booleanValue()) {
            return false;
        }
        if (this.mM && !f2.gm().booleanValue()) {
            return false;
        }
        if (this.mN && !f2.fz().booleanValue()) {
            return false;
        }
        if (this.mO && !f2.ft().booleanValue()) {
            return false;
        }
        return this.nome == null || this.nome.isEmpty() || this.nome.length() <= 0 || this.nome.length() <= f2.getNome().length() && this.nome.equalsIgnoreCase(D.f(f2.getNome()).substring(0, this.nome.length()));
    }

    public void setNome(String string) {
        if (string != null && !string.isEmpty()) {
            string = D.f(string);
        }
        this.nome = string;
    }

    public void bv(int n2) {
        this.md = n2;
    }

    public void bw(int n2) {
        this.me = n2;
    }

    public void bx(int n2) {
        this.mf = n2;
    }

    public void by(int n2) {
        this.mg = n2;
    }

    public void bz(int n2) {
        this.mh = n2;
    }

    public void bA(int n2) {
        this.mi = n2;
    }

    public void bB(int n2) {
        this.mj = n2;
    }

    public void bC(int n2) {
        this.mk = n2;
    }

    public void bD(int n2) {
        this.ml = n2;
    }

    public void E(boolean bl2) {
        this.mL = bl2;
    }

    public void F(boolean bl2) {
        this.mM = bl2;
    }

    public void G(boolean bl2) {
        this.mN = bl2;
    }

    public void H(boolean bl2) {
        this.mO = bl2;
    }

    public static int bE(int n2) {
        return t.eT(n2);
    }

    public int jH() {
        return this.mq;
    }

    public void bF(int n2) {
        this.mq = n2;
    }

    public int jI() {
        return this.mt;
    }

    public void bG(int n2) {
        this.mt = n2;
    }

    public int jJ() {
        return this.mw;
    }

    public void bH(int n2) {
        this.mw = n2;
    }

    public int jK() {
        return this.mz;
    }

    public void bI(int n2) {
        this.mz = n2;
    }

    public int jL() {
        return this.mC;
    }

    public void bJ(int n2) {
        this.mC = n2;
    }

    public int jM() {
        return this.mF;
    }

    public void bK(int n2) {
        this.mF = n2;
    }

    public int jN() {
        return this.mI;
    }

    public void bL(int n2) {
        this.mI = n2;
    }

    public void bM(int n2) {
        this.mm = n2;
    }

    public void bN(int n2) {
        this.mn = n2;
    }

    public void bO(int n2) {
        this.mo = n2;
    }

    public void bP(int n2) {
        this.mp = n2;
    }
}

