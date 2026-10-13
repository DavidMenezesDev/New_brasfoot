/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;

public class X {
    private F U = null;
    private double ab = 0.0;
    private int W = 0;

    public X() {
    }

    public X(F f2, double d2, int n2) {
        this.U = f2;
        this.ab = d2;
        this.W = n2;
    }

    public F x() {
        return this.U;
    }

    public double F() {
        return this.ab;
    }

    public void c(double d2) {
        this.ab = d2;
    }

    public String cE() {
        if (this.ab > 0.0) {
            if (this.ab == 10.0) {
                return "10";
            }
            return String.format("%.2f", this.ab);
        }
        return "--";
    }

    public int A() {
        return this.W;
    }
}

