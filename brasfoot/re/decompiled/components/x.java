/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.I;
import best.J;
import c.a;

public class x {
    private double Z = 0.0;
    private I zz = null;

    public x(J j2) {
        this.Z = j2.C();
        int n2 = j2.hM();
        int n3 = j2.im();
        if (n2 >= 0 && n3 >= 0 && a.SR.m(n2) != null && n3 < a.SR.m(n2).size()) {
            this.zz = (I)a.SR.m(n2).get(n3);
        }
    }

    public double C() {
        return this.Z;
    }

    public void j(double d2) {
        this.Z = d2;
    }

    public I tR() {
        return this.zz;
    }

    public void n(I i2) {
        this.zz = i2;
    }
}

