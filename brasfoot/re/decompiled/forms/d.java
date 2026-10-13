/*
 * Decompiled with CFR 0.152.
 */
package forms;

import forms.v;
import forms.x;

class d
implements v {
    public double Ws = 0.0;
    public double Wt = 0.0;
    public double Wu = 0.0;
    public double Wv = 0.0;

    d() {
    }

    @Override
    public double m(double d2) {
        double d3 = this.Wv - x.a(this.Ws, this.Wt, this.Wu, d2);
        return d3;
    }
}

