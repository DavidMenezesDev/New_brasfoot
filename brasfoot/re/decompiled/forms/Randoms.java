/*
 * Decompiled with CFR 0.152.
 */
package forms;

import java.util.BitSet;
import java.util.Random;

public class Randoms
extends Random {
    private double XE;
    private boolean XF = false;

    public Randoms(int n2) {
        super(n2);
    }

    public Randoms() {
    }

    public synchronized int q(double d2) {
        int n2 = -1;
        double d3 = Math.exp(-d2);
        double d4 = 1.0;
        while (d4 >= d3) {
            d4 *= this.xH();
            ++n2;
        }
        return n2;
    }

    public synchronized int xG() {
        return this.q(1.0);
    }

    @Override
    public synchronized boolean nextBoolean() {
        return (this.next(32) & 0x8000) != 0;
    }

    public synchronized boolean r(double d2) {
        double d3 = this.xH();
        return d3 < d2;
    }

    public synchronized BitSet a(int n2, double d2) {
        BitSet bitSet = new BitSet(n2);
        int n3 = 0;
        while (n3 < n2) {
            if (this.r(d2)) {
                bitSet.set(n3);
            }
            ++n3;
        }
        return bitSet;
    }

    public synchronized double xH() {
        long l2 = ((long)this.next(26) << 27) + (long)this.next(27);
        return (double)l2 / 9.007199254740992E15;
    }

    public synchronized double e(double d2, double d3) {
        return d2 + (d3 - d2) * this.xH();
    }

    public synchronized int a(double[] dArray) {
        double d2 = 0.0;
        double d3 = this.xH();
        int n2 = 0;
        while (n2 < dArray.length) {
            if ((d2 += dArray[n2]) > d3) {
                return n2;
            }
            ++n2;
        }
        return dArray.length - 1;
    }

    public synchronized int a(double[] dArray, double d2) {
        double d3 = 0.0;
        double d4 = this.xH() * d2;
        int n2 = 0;
        while (n2 < dArray.length) {
            if ((d3 += dArray[n2]) > d4) {
                return n2;
            }
            ++n2;
        }
        return dArray.length - 1;
    }

    @Override
    public synchronized double nextGaussian() {
        if (!this.XF) {
            double d2;
            double d3 = this.xH();
            double d4 = this.xH();
            double d5 = Math.sqrt(-2.0 * Math.log(d3)) * Math.cos(Math.PI * 2 * d4);
            this.XE = d2 = Math.sqrt(-2.0 * Math.log(d3)) * Math.sin(Math.PI * 2 * d4);
            this.XF = true;
            return d5;
        }
        this.XF = false;
        return this.XE;
    }

    public synchronized double f(double d2, double d3) {
        return this.nextGaussian() * Math.sqrt(d3) + d2;
    }

    public synchronized double xI() {
        return this.a(1.0, 1.0, 0.0);
    }

    public synchronized double s(double d2) {
        return this.a(d2, 1.0, 0.0);
    }

    public synchronized double eU(int n2) {
        double d2;
        assert (n2 >= 1);
        if (n2 < 6) {
            d2 = 1.0;
            int n3 = 1;
            while (n3 <= n2) {
                d2 *= this.xH();
                ++n3;
            }
            d2 = -Math.log(d2);
        } else {
            while (true) {
                double d3;
                double d4;
                if ((d4 = 2.0 * this.xH() - 1.0) * d4 + (d3 = 2.0 * this.xH() - 1.0) * d3 > 1.0) {
                    continue;
                }
                double d5 = d3 / d4;
                double d6 = n2 - 1;
                double d7 = Math.sqrt(2.0 * d6 + 1.0);
                d2 = d7 * d5 + d6;
                if (d2 <= 0.0) continue;
                double d8 = (1.0 + d5 * d5) * Math.exp(d6 * Math.log(d2 / d6) - d7 * d5);
                if (!(this.xH() > d8)) break;
            }
        }
        return d2;
    }

    public synchronized double g(double d2, double d3) {
        return this.a(d2, d3, 0.0);
    }

    public synchronized double a(double d2, double d3, double d4) {
        double d5 = 0.0;
        if (d2 <= 0.0 || d3 <= 0.0) {
            throw new IllegalArgumentException("alpha and beta must be strictly positive.");
        }
        if (d2 < 1.0) {
            boolean bl2 = false;
            double d6 = 1.0 + d2 * Math.exp(-1.0);
            while (!bl2) {
                double d7 = d6 * this.xH();
                if (d7 > 1.0) {
                    d5 = -Math.log((d6 - d7) / d2);
                    if (!(this.xH() <= Math.pow(d5, d2 - 1.0))) continue;
                    bl2 = true;
                    continue;
                }
                d5 = Math.pow(d7, 1.0 / d2);
                if (!(this.xH() <= Math.exp(-d5))) continue;
                bl2 = true;
            }
        } else if (d2 == 1.0) {
            d5 = -Math.log(this.xH());
        } else {
            double d8 = -Math.log(this.xH());
            while (this.xH() > Math.pow(d8 * Math.exp(1.0 - d8), d2 - 1.0)) {
                d8 = -Math.log(this.xH());
            }
            d5 = d2 * d8;
        }
        return d3 * d5 + d4;
    }

    public synchronized double xJ() {
        return this.a(1.0, 1.0, 0.0);
    }

    public synchronized double t(double d2) {
        return this.a(1.0, d2, 0.0);
    }

    public synchronized double h(double d2, double d3) {
        return this.a(1.0, d2, d3);
    }

    public synchronized double xK() {
        return this.a(0.5, 2.0, 0.0);
    }

    public synchronized double eV(int n2) {
        return this.a(0.5 * (double)n2, 2.0, 0.0);
    }

    public synchronized double b(int n2, double d2) {
        return this.a(0.5 * (double)n2, 2.0, d2);
    }

    public synchronized double i(double d2, double d3) {
        if (d2 <= 0.0 || d3 <= 0.0) {
            throw new IllegalArgumentException("alpha and beta must be strictly positive.");
        }
        if (d2 == 1.0 && d3 == 1.0) {
            return this.xH();
        }
        if (d2 >= 1.0 && d3 >= 1.0) {
            double d4 = d2 - 1.0;
            double d5 = d3 - 1.0;
            double d6 = d4 + d5;
            double d7 = d6 * Math.log(d6);
            double d8 = d4 / d6;
            double d9 = 0.5 / Math.sqrt(d6);
            double d10 = this.nextGaussian();
            double d11 = d9 * d10 + d8;
            while (d11 < 0.0 || d11 > 1.0) {
                d10 = this.nextGaussian();
                d11 = d9 * d10 + d8;
            }
            double d12 = this.xH();
            while (Math.log(d12) >= d4 * Math.log(d11 / d4) + d5 * Math.log((1.0 - d11) / d5) + d7 + 0.5 * d10 * d10) {
                d10 = this.nextGaussian();
                d11 = d9 * d10 + d8;
                while (d11 < 0.0 || d11 > 1.0) {
                    d10 = this.nextGaussian();
                    d11 = d9 * d10 + d8;
                }
                d12 = this.xH();
            }
            return d11;
        }
        double d13 = Math.pow(this.xH(), 1.0 / d2);
        double d14 = Math.pow(this.xH(), 1.0 / d3);
        while (d13 + d14 > 1.0) {
            d13 = Math.pow(this.xH(), 1.0 / d2);
            d14 = Math.pow(this.xH(), 1.0 / d3);
        }
        return d13 / (d13 + d14);
    }

    public static void main(String[] stringArray) {
        Randoms randoms = new Randoms();
        int n2 = 60;
        int[] nArray = new int[60];
        int[] nArray2 = new int[60];
        int n3 = 10;
        int n4 = 0;
        while (n4 < 10000) {
            double d2 = 4.0;
            int n5 = (int)(randoms.s(d2) / (double)n3 * 60.0) % 60;
            int n6 = (int)(randoms.eU((int)d2) / (double)n3 * 60.0) % 60;
            int n7 = n5;
            nArray[n7] = nArray[n7] + 1;
            int n8 = n6;
            nArray2[n8] = nArray2[n8] + 1;
            ++n4;
        }
        n4 = 0;
        while (n4 < 60) {
            ++n4;
        }
    }
}

