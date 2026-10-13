/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.ak;
import java.io.Serializable;

public class ah
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int mU = -1;
    private int nT = 0;
    private int T = 0;
    private int bX = 0;
    private int d = 0;
    private int nK = 0;
    private int nL = 0;

    public ah() {
    }

    public ah(ak ak2, int n2) {
        this.mU = n2;
        if (ak2 != null) {
            this.nT = ak2.lD();
            this.T = ak2.w();
            this.bX = ak2.cm();
            this.d = ak2.co();
            this.nK = ak2.ls();
            this.nL = ak2.lt();
        }
    }

    public void lA() {
        this.nT = 0;
        this.T = 0;
        this.bX = 0;
        this.d = 0;
        this.nK = 0;
        this.nL = 0;
    }

    public int lk() {
        return this.mU;
    }

    public void bX(int n2) {
        this.mU = n2;
    }

    public int lD() {
        return this.nT;
    }

    public void dW(int n2) {
        this.nT = n2;
    }

    public int w() {
        return this.T;
    }

    public void h(int n2) {
        this.T = n2;
    }

    public int cm() {
        return this.bX;
    }

    public void dS(int n2) {
        this.bX = n2;
    }

    public int co() {
        return this.d;
    }

    public void dT(int n2) {
        this.d = n2;
    }

    public int ls() {
        return this.nK;
    }

    public void dU(int n2) {
        this.nK = n2;
    }

    public int lt() {
        return this.nL;
    }

    public void dV(int n2) {
        this.nL = n2;
    }
}

