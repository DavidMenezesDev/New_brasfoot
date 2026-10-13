/*
 * Decompiled with CFR 0.152.
 */
package forms;

import b.aS;
import forms.d;
import forms.u;
import java.io.Serializable;
import java.util.Random;

public class t
implements Serializable {
    private static final long serialVersionUID = 1L;
    private long Xd;
    private long Xe;
    private int Xf = 1;
    private int Xg = 1;
    private Random Xh = null;
    private int Xi = 1;
    private long Xj = 16807L;
    private long Xk = Integer.MAX_VALUE;
    private double Xl = 1.0 / (double)this.Xk;
    private long Xm = 127773L;
    private long Xn = 2836L;
    private int Xo = 32;
    private long Xp = 1L + (this.Xk - 1L) / (long)this.Xo;
    private double Xq = 1.2E-7;
    private double Xr = 1.0 - this.Xq;
    private long Xs = 0L;
    private long[] Xt = new long[this.Xo];
    private static int[] Xu = new int[231];
    private static int[] Xv = new int[7];
    private int Xw = 0;
    private double Xx = 0.0;
    private long Xy = 1L;
    private long Xz = 2L;
    private long XA = 16L;
    private long XB = 131072L;
    private static aS XC = new aS();
    private long XD = this.Xy + this.Xz + this.XA;

    public t() {
        this.Xe = this.Xd = System.currentTimeMillis();
        this.Xh = new Random(this.Xd);
    }

    public t(long l2) {
        this.Xd = l2;
        this.Xe = l2;
        this.Xh = new Random(this.Xd);
    }

    public void setSeed(long l2) {
        this.Xd = l2;
        if (this.Xf == 1) {
            this.Xh = new Random(this.Xd);
        }
    }

    public double[] a(double d2, double d3, double d4, int n2) {
        double[] dArray = new double[n2];
        d d5 = new d();
        d5.Ws = d2;
        d5.Wt = d3;
        d5.Wu = d4;
        double d6 = Math.sqrt(d4) * d3;
        double d7 = 1.0E-10;
        double d8 = d2 + 5.0 * d6;
        double d9 = d2;
        if (d8 <= d9) {
            d8 += d6;
        }
        int n3 = 0;
        while (n3 < n2) {
            u u2 = new u();
            u2.xM();
            u2.w(d7);
            u2.xL();
            u2.xO();
            u2.xS();
            boolean bl2 = true;
            int n4 = 0;
            int n5 = 10;
            while (bl2) {
                d5.Wv = this.nextDouble();
                double d10 = u2.a(d5, d9, d8);
                if (!Double.isNaN(d10)) {
                    bl2 = false;
                    dArray[n3] = d10;
                    continue;
                }
                if (n4 > n5) {
                    dArray[n3] = Double.NaN;
                    bl2 = false;
                    continue;
                }
                ++n4;
            }
            ++n3;
        }
        return dArray;
    }

    public double nextDouble() {
        if (this.Xf == 1) {
            return this.Xh.nextDouble();
        }
        return this.xF();
    }

    public double nextDouble(double d2) {
        return d2 * this.nextDouble();
    }

    public double nextDouble(double d2, double d3) {
        return (d3 - d2) * this.nextDouble() + d2;
    }

    public double xF() {
        double d2;
        int n2 = 0;
        long l2 = 0L;
        double d3 = 0.0;
        this.Xs = 0L;
        if (this.Xd <= 0L || this.Xs != 0L) {
            this.Xd = -this.Xd < 1L ? 1L : -this.Xd;
            int n3 = this.Xo + 7;
            while (n3 >= 0) {
                l2 = this.Xd / this.Xm;
                this.Xd = this.Xj * (this.Xd - l2 * this.Xm) - this.Xn * l2;
                if (this.Xd < 0L) {
                    this.Xd += this.Xk;
                }
                if (n3 < this.Xo) {
                    this.Xt[n3] = this.Xd;
                }
                --n3;
            }
            this.Xs = this.Xt[0];
        }
        l2 = this.Xd / this.Xm;
        this.Xd = this.Xj * (this.Xd - l2 * this.Xm) - this.Xn * l2;
        if (this.Xd < 0L) {
            this.Xd += this.Xk;
        }
        n2 = (int)(this.Xs / this.Xp);
        this.Xs = this.Xt[n2];
        this.Xt[n2] = this.Xd;
        d3 = this.Xl * (double)this.Xs;
        if (d2 > this.Xr) {
            return this.Xr;
        }
        return d3;
    }

    public double d(double d2, int n2) {
        return this.a(0.0, 1.0 / d2, n2);
    }

    public double a(double d2, double d3, double d4) {
        double d5 = 0.0;
        d d6 = new d();
        d6.Ws = d2;
        d6.Wt = d3;
        d6.Wu = d4;
        double d7 = Math.sqrt(d4) * d3;
        double d8 = 1.0E-10;
        double d9 = d2 + 5.0 * d7;
        double d10 = d2;
        if (d9 <= d10) {
            d9 += d7;
        }
        u u2 = new u();
        u2.xM();
        u2.w(d8);
        u2.xL();
        u2.xO();
        u2.xS();
        boolean bl2 = true;
        int n2 = 0;
        int n3 = 10;
        while (bl2) {
            d6.Wv = this.nextDouble();
            d5 = u2.a(d6, d10, d9);
            if (!Double.isNaN(d5)) {
                bl2 = false;
                continue;
            }
            if (n2 > n3) {
                d5 = Double.NaN;
                bl2 = false;
                continue;
            }
            ++n2;
        }
        return d5;
    }

    public static void aa(int n2, int n3) {
        t.Xu[n2] = n3;
    }

    public static void i(int n2, int n3, int n4) {
        t.Xv[n2] = Xu[n3] + n4;
    }

    public static int eT(int n2) {
        return Xv[n2];
    }
}

