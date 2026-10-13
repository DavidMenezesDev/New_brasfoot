/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.at;
import java.io.Serializable;

public class H
implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient at Y = null;
    private int ft = -1;
    private int ca;
    private int cb;
    private int T;
    private int V;
    private int cc;
    private double fu = 0.0;
    private int fv = 0;

    public H() {
    }

    public H(F f2, at at2) {
        this.Y = at2;
    }

    public void i(double d2) {
        ++this.fv;
        this.fu += d2;
    }

    public at gS() {
        return this.Y;
    }

    public void m(at at2) {
        this.Y = at2;
    }

    public boolean gT() {
        return this.ca >= 3 || this.cb >= 1;
    }

    public void gU() {
        if (this.ca >= 3) {
            this.ca = 0;
        } else if (this.cb >= 1) {
            --this.cb;
        }
    }

    public void z() {
        ++this.V;
    }

    public void gV() {
        ++this.cc;
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

    public int[] gW() {
        int[] nArray = new int[]{this.ca, this.cb};
        return nArray;
    }

    public int w() {
        return this.T;
    }

    public int y() {
        return this.V;
    }

    public int gX() {
        return this.ft;
    }

    public void gY() {
        if (this.Y != null && this.Y.gD() >= 0) {
            this.ft = this.Y.gD();
        }
    }

    public int cD() {
        return this.cc;
    }

    public void E(int n2) {
        this.cc = n2;
    }

    public double F() {
        if (this.fv > 0) {
            return this.fu / (double)this.fv;
        }
        return 0.0;
    }

    public int gZ() {
        return this.fv;
    }
}

