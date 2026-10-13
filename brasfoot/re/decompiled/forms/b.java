/*
 * Decompiled with CFR 0.152.
 */
package forms;

import forms.e;

class b
implements e {
    private double Wa = 0.0;
    private double Wb = 0.0;

    b() {
    }

    @Override
    public double m(double d2) {
        double d3 = -d2 + (this.Wa - 1.0) * Math.log(d2) - this.Wb;
        d3 = Math.exp(d3);
        return d3;
    }

    public void n(double d2) {
        this.Wa = d2;
    }

    public void o(double d2) {
        this.Wb = d2;
    }
}

