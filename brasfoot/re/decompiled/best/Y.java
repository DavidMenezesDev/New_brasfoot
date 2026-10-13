/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import java.util.Random;

public class Y {
    private F U;
    private double Z;
    private int hq;
    private int hr = new Random().nextInt(100);
    private static boolean hs = false;

    public F x() {
        return this.U;
    }

    public void a(F f2) {
        this.U = f2;
    }

    public double C() {
        return this.Z;
    }

    public void j(double d2) {
        this.Z = d2;
    }

    public int iR() {
        return this.hq;
    }

    public void bi(int n2) {
        this.hq = n2;
    }

    public int iS() {
        return this.hr;
    }

    public static void x(boolean bl2) {
        hs = bl2;
    }
}

