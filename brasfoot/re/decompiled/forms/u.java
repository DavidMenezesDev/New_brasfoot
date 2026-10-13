/*
 * Decompiled with CFR 0.152.
 */
package forms;

import forms.v;

public class u {
    private double XH = Double.NaN;
    private double XI = 1.0E-9;
    private int XJ = 3000;
    private int XK = 0;
    private double XL = 0.0;
    private double XM = 0.0;
    private double XN = 0.0;
    private int XO = 100;
    private boolean XP = false;
    private boolean XQ = false;
    private boolean XR = false;
    private boolean XS = false;
    private boolean XT = false;
    private boolean XU = false;
    private static int XV = 3000;
    private static int XW = 100;
    private static boolean XX = false;
    private static boolean XY = false;
    private static boolean XZ = false;
    private static boolean Ya = false;
    private static double Yb = 1.0E-14;

    public void u(double d2) {
        this.XM = d2;
    }

    public void v(double d2) {
        this.XL = d2;
    }

    public void xL() {
        this.XT = true;
    }

    public void xM() {
        this.XQ = true;
        if (this.XR) {
            this.XP = true;
        }
    }

    public void xN() {
        this.XR = true;
        if (this.XQ) {
            this.XP = true;
        }
    }

    public void xO() {
        this.XS = true;
    }

    public void xP() {
        this.XS = true;
    }

    public void xQ() {
        this.XT = false;
    }

    public void xR() {
        this.XU = true;
    }

    public void xS() {
        this.XU = true;
    }

    public void xT() {
        this.XU = false;
    }

    public void w(double d2) {
        this.XI = d2;
    }

    public double xU() {
        return this.XI;
    }

    public double a(v v2) {
        return this.a(v2, this.XM, this.XL);
    }

    public double a(v v2, double d2, double d3) {
        this.XM = d2;
        this.XL = d3;
        if (d3 == d2) {
            throw new IllegalArgumentException("upper cannot equal lower");
        }
        if (d3 < d2) {
            double d4 = d3;
            d3 = d2;
            d2 = d4;
        }
        boolean bl2 = true;
        this.XK = 0;
        double d5 = 1.0E300;
        double d6 = v2.m(d3);
        double d7 = v2.m(d2);
        if (Double.isNaN(d7)) {
            if (this.XT) {
                if (!this.XU) {
                    System.out.println("RealRoot: bisect: lower bound returned NaN as the function value - NaN returned as root");
                }
                return Double.NaN;
            }
            throw new ArithmeticException("lower bound returned NaN as the function value");
        }
        if (Double.isNaN(d6)) {
            if (this.XT) {
                if (!this.XU) {
                    System.out.println("RealRoot: bisect: upper bound returned NaN as the function value - NaN returned as root");
                }
                return Double.NaN;
            }
            throw new ArithmeticException("upper bound returned NaN as the function value");
        }
        boolean bl3 = true;
        int n2 = 0;
        double d8 = (d3 - d2) / 2.0;
        while (bl3) {
            if (d6 * d7 <= 0.0) {
                bl3 = false;
                continue;
            }
            if (this.XP) {
                String string = "RealRoot.bisect: root not bounded and no extension to bounds allowed\n";
                string = String.valueOf(string) + "NaN returned";
                if (!this.XU) {
                    System.out.println(string);
                }
                return Double.NaN;
            }
            if (++n2 > this.XO) {
                String string = "RealRoot.bisect: root not bounded and maximum number of extension to bounds allowed, " + this.XO + ", exceeded\n";
                string = String.valueOf(string) + "NaN returned";
                if (!this.XU) {
                    System.out.println(string);
                }
                return Double.NaN;
            }
            if (!this.XQ) {
                d7 = v2.m(d2 -= d8);
            }
            if (this.XR) continue;
            d6 = v2.m(d3 += d8);
        }
        if (d7 == 0.0) {
            this.XH = d2;
            bl2 = false;
        }
        if (d6 == 0.0) {
            this.XH = d3;
            bl2 = false;
        }
        double d9 = (d2 + d3) / 2.0;
        double d10 = 1.0E300;
        double d11 = v2.m(d9);
        while (bl2) {
            if (d11 == 0.0 || d5 < this.XI) {
                bl2 = false;
                this.XH = d9;
            }
            if (d11 * d7 > 0.0) {
                d2 = d9;
                d7 = d11;
            } else {
                d3 = d9;
                d6 = d11;
            }
            d10 = d9;
            d9 = (d2 + d3) / 2.0;
            d11 = v2.m(d9);
            d5 = Math.abs(d9 - d10);
            ++this.XK;
            if (this.XK <= this.XJ) continue;
            if (!this.XS) {
                // empty if block
            }
            this.XH = d9;
            bl2 = false;
        }
        return this.XH;
    }

    public void xV() {
        this.XP = true;
        this.XQ = true;
        this.XR = true;
    }
}

