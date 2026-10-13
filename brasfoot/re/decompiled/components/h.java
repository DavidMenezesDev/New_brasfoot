/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.ah;
import best.al;

public class h {
    private ah cg = null;
    private al Oi = null;
    private al Oj = null;
    private int Fp = 1;

    public h(ah ah2, al al2, al al3, int n2) {
        this.cg = ah2;
        this.Oi = al2;
        this.Oj = al3;
        this.Fp = n2;
    }

    public ah fg() {
        return this.cg;
    }

    public void n(ah ah2) {
        this.cg = ah2;
    }

    public al tj() {
        return this.Oi;
    }

    public void j(al al2) {
        this.Oi = al2;
    }

    public al tk() {
        return this.Oj;
    }

    public void k(al al2) {
        this.Oj = al2;
    }

    public int tl() {
        return this.Fp;
    }

    public void dH(int n2) {
        this.Fp = n2;
    }
}

