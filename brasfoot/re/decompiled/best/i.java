/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.L;
import best.S;
import best.ah;
import best.al;
import best.at;
import best.c;
import c.a;
import f.B;
import java.io.Serializable;

public class i
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ae;
    private int bQ = -1;
    private int bR = -1;
    private String bS = null;
    private int bT = -1;
    private int V;
    private int bU = -1;
    private int bV = -1;

    public i() {
    }

    public i(at at2, L l2, ah ah2, ah ah3) {
        this.ae = a.SR.H();
        if (ah2 != null) {
            this.bQ = ah2.lk();
        }
        if (ah2 != null && ah2.ka() != null) {
            this.bU = ah2.ka().lT();
        }
        if (ah3 != null) {
            this.bR = ah3.lk();
        }
        if (ah3 != null && ah3.ka() != null) {
            this.bV = ah3.ka().lT();
        }
        int n2 = 0;
        c c2 = null;
        c2 = at2.mu();
        at2.mn().add(this);
        if (at2 != null) {
            at2.mr();
            n2 = at2.b();
        }
        if (c2 != null) {
            F f2 = c2.x();
            this.V = c2.y();
            if (f2 != null) {
                this.bS = f2.getNome();
            }
            if (f2 != null && f2.fg() != null) {
                this.bT = f2.fg().lk();
            }
            if (l2 != null && l2.b() == 1 && l2.ip() == 1) {
                c2.x().a(true);
            }
        }
        if (ah2 != null && ah2.jZ().booleanValue() && at2 != null) {
            S.a(ah2, at2, n2);
        }
        if (n2 == 1 && at2 instanceof B) {
            ((B)at2).BQ();
        }
    }

    public int H() {
        return this.ae;
    }

    public ah ce() {
        if (this.bQ >= 0) {
            return a.SR.x(this.bQ);
        }
        return null;
    }

    public ah cf() {
        if (this.bR >= 0) {
            return a.SR.x(this.bR);
        }
        return null;
    }

    public String cg() {
        return this.bS;
    }

    public ah ch() {
        if (this.bT >= 0) {
            return a.SR.x(this.bT);
        }
        return null;
    }

    public int y() {
        return this.V;
    }

    public al ci() {
        if (this.bU == -1) {
            return null;
        }
        return a.SR.y(this.bU);
    }

    public al cj() {
        if (this.bV == -1) {
            return null;
        }
        return a.SR.y(this.bV);
    }
}

