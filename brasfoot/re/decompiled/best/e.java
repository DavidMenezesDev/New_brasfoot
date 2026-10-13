/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.at;
import java.io.Serializable;

public class e
implements Serializable {
    private static final long serialVersionUID = 1L;
    F U = null;
    at Y = null;
    double Z = 0.0;
    double aa = 0.0;
    double ab = 0.0;
    int ac = 0;

    public e() {
    }

    public e(at at2, F f2) {
        this.Y = at2;
        this.U = f2;
    }

    public F x() {
        return this.U;
    }

    public void a(F f2) {
        this.U = f2;
    }

    public double C() {
        return this.Z;
    }

    public void a(double d2) {
        this.Z += d2;
        this.aa += 1.0;
        this.ab = this.Z / this.aa;
    }

    public double D() {
        return this.aa;
    }

    public int E() {
        return this.ac;
    }

    public void j(int n2) {
        this.ac = n2;
    }

    public double F() {
        return this.ab;
    }
}

