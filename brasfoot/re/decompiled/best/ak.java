/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ah;
import f.s;
import java.io.Serializable;

public class ak
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s nS = null;
    private int nT = 0;
    private int T = 0;
    private int bX = 0;
    private int d = 0;
    private int nK = 0;
    private int nL = 0;

    public ak() {
    }

    public void lA() {
        this.nT = 0;
        this.T = 0;
        this.bX = 0;
        this.d = 0;
        this.nK = 0;
        this.nL = 0;
    }

    public ak(ah ah2, s s2) {
        this.nS = s2;
    }

    public void a(components.ah ah2) {
        this.nT += ah2.lD();
        this.T += ah2.w();
        this.bX += ah2.cm();
        this.d += ah2.co();
        this.nK += ah2.ls();
        this.nL += ah2.lt();
    }

    public int[] lB() {
        int[] nArray = new int[]{this.nT, this.T, this.bX, this.T - (this.bX + this.d), this.d, this.nK, this.nL, this.nK - this.nL};
        return nArray;
    }

    public s lC() {
        return this.nS;
    }

    public void f(s s2) {
        this.nS = s2;
    }

    public int lD() {
        return this.nT;
    }

    public void cf(int n2) {
        this.nT += n2;
    }

    public int w() {
        return this.T;
    }

    public void cl() {
        ++this.T;
    }

    public int co() {
        return this.d;
    }

    public void cp() {
        ++this.d;
    }

    public int cm() {
        return this.bX;
    }

    public void cn() {
        ++this.bX;
    }

    public int lt() {
        return this.nL;
    }

    public void cb(int n2) {
        this.nL += n2;
    }

    public int ls() {
        return this.nK;
    }

    public void ca(int n2) {
        this.nK += n2;
    }
}

