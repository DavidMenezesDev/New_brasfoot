/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.I;
import c.a;
import java.io.Serializable;

public class J
implements Serializable {
    private static final long serialVersionUID = 1L;
    private double Z = 0.0;
    private int fy = -1;
    private int gx = -1;

    public J() {
    }

    public J(I i2, double d2) {
        this.Z = d2;
        this.fy = a.SR.J();
        int n2 = 0;
        while (n2 < a.SR.S().size()) {
            if (a.SR.S().get(n2) == i2) {
                this.gx = n2;
                break;
            }
            ++n2;
        }
    }

    public double C() {
        return this.Z;
    }

    public void j(double d2) {
        this.Z = d2;
    }

    public int hM() {
        return this.fy;
    }

    public int im() {
        return this.gx;
    }
}

