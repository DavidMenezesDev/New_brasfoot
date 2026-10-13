/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.H;
import best.Z;
import best.ah;
import best.at;
import c.a;
import java.io.Serializable;

public class k
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ae = 0;
    private int bW = -1;
    private int ca = 0;
    private int cb = 0;
    private int T = 0;
    private int cc = 0;
    private int V = 0;
    private int cd = 0;
    private int ce = 0;
    private double ab = 0.0;
    transient int cf = -1;
    transient ah cg = null;
    transient String ch = "";

    public k() {
    }

    public String ck() {
        int n2;
        String string = null;
        if (string == null) {
            n2 = 0;
            while (n2 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n2)).lk() == this.bW) {
                    string = ((ah)a.SR.P().get(n2)).getNome();
                    this.cg = (ah)a.SR.P().get(n2);
                    return string;
                }
                ++n2;
            }
        }
        if (string == null) {
            n2 = 0;
            while (n2 < a.SR.aG().size()) {
                if (((Z)a.SR.aG().get(n2)).jn() != null && ((Z)a.SR.aG().get(n2)).jn().lk() == this.bW) {
                    string = ((Z)a.SR.aG().get(n2)).jn().getNome();
                    this.cg = ((Z)a.SR.aG().get(n2)).jn();
                    return string;
                }
                ++n2;
            }
        }
        return string;
    }

    public ah cu() {
        int n2;
        if (this.cg == null) {
            n2 = 0;
            while (n2 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n2)).lk() == this.bW) {
                    this.cg = (ah)a.SR.P().get(n2);
                    return (ah)a.SR.P().get(n2);
                }
                ++n2;
            }
        }
        if (this.cg == null) {
            n2 = 0;
            while (n2 < a.SR.aG().size()) {
                if (((Z)a.SR.aG().get(n2)).jn() != null && ((Z)a.SR.aG().get(n2)).jn().lk() == this.bW) {
                    this.cg = ((Z)a.SR.aG().get(n2)).jn();
                    return this.cg;
                }
                ++n2;
            }
        }
        return this.cg;
    }

    public k(F f2, ah ah2) {
        this.ae = a.SR.H();
        this.bW = ah2.lk();
    }

    public k(boolean bl2, int[] nArray) {
        this.ae = -1;
        this.T = nArray[0];
        this.V = nArray[1];
        this.ca = nArray[2];
        this.cb = nArray[3];
        this.cd = nArray[4];
        this.cc = nArray[5];
    }

    public int H() {
        return this.ae;
    }

    public int cv() {
        return this.ca;
    }

    public int cw() {
        return this.cb;
    }

    public int w() {
        return this.T;
    }

    public int y() {
        return this.V;
    }

    public int cx() {
        return this.cd;
    }

    public void cy() {
        ++this.cd;
    }

    public void z() {
        ++this.V;
    }

    public void cl() {
        ++this.T;
    }

    public void cz() {
        ++this.ca;
    }

    public void cA() {
        ++this.cb;
    }

    public void cB() {
        ++this.ca;
        ++this.cb;
    }

    public void a(F f2, at at2) {
        if (at2 != null && f2 != null && !f2.fC().booleanValue()) {
            ++this.cc;
            H h3 = f2.h(at2);
            h3.gV();
        }
    }

    public void k(int n2) {
        this.ae = n2;
    }

    public int ct() {
        return this.bW;
    }

    public int cC() {
        return this.cf;
    }

    public void D(int n2) {
        this.cf = n2;
    }

    public int cD() {
        return this.cc;
    }

    public void E(int n2) {
        this.cc = n2;
    }

    public double F() {
        return this.ab;
    }

    public String cE() {
        String string = "--";
        double d2 = 0.0;
        if (this.ce > 0) {
            d2 = this.ab / (double)this.ce;
            string = String.format("%.2f", d2);
        } else if (this.ce == 0) {
            string = "--";
        }
        return string;
    }

    public void b(double d2) {
        if (d2 >= 2.0) {
            this.ab += d2;
            ++this.ce;
        }
    }

    public void c(double d2) {
        this.ab = d2;
    }

    public int cF() {
        return this.ce;
    }

    public String cG() {
        return this.ch;
    }

    public void e(String string) {
        this.ch = string;
    }
}

