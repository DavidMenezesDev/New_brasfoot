/*
 * Decompiled with CFR 0.152.
 */
package forms;

import forms.c;
import forms.e;
import java.util.ArrayList;

public class f {
    private e Ww = null;
    private boolean Wx = false;
    private double Wy = 0.0;
    private double Wz = 0.0;
    private boolean WA = false;
    private int WB = 0;
    private boolean WC = false;
    private int WD = 0;
    private boolean WE = false;
    private double WF = 0.0;
    private double WG = 0.0;
    private double WH = 0.0;
    private boolean WI = false;
    private boolean WJ = false;
    private ArrayList WK = new ArrayList();
    private ArrayList WL = new ArrayList();
    private double[] WM = null;
    private ArrayList WN = new ArrayList();
    private double[] WO = null;
    private double WP = 3.0E-11;
    private double WQ = 0.0;
    private double WR = 0.0;
    private static double WS = 0.0;
    private int WT = 0;
    private int WU = 1;
    private static int WV = 1;

    public f() {
    }

    public f(e e2) {
        this.Ww = e2;
        this.Wx = true;
    }

    public f(e e2, double d2, double d3) {
        this.Ww = e2;
        this.Wx = true;
        this.Wy = d2;
        this.Wz = d3;
        this.WA = true;
    }

    public void d(double d2, double d3) {
        this.Wy = d2;
        this.Wz = d3;
        this.WA = true;
    }

    public double xn() {
        if (!this.WC) {
            throw new IllegalArgumentException("Number of points not set");
        }
        if (!this.WA) {
            throw new IllegalArgumentException("One limit or both limits not set");
        }
        if (!this.Wx) {
            throw new IllegalArgumentException("No integral function has been set");
        }
        this.WM = new double[this.WB];
        this.WO = new double[this.WB];
        boolean bl2 = true;
        int n2 = -1;
        if (!this.WK.isEmpty()) {
            int n3 = 0;
            while (n3 < this.WK.size()) {
                Integer n4 = (Integer)this.WK.get(n3);
                if (n4 == this.WB) {
                    bl2 = false;
                    n2 = n3;
                }
                ++n3;
            }
        }
        if (bl2) {
            this.eR(this.WB);
            this.WK.add(new Integer(this.WB));
            this.WL.add(this.WM);
            this.WN.add(this.WO);
        } else {
            this.WM = (double[])this.WL.get(n2);
            this.WO = (double[])this.WN.get(n2);
        }
        double d2 = 0.0;
        double d3 = 0.5 * (this.Wz + this.Wy);
        double d4 = 0.5 * (this.Wz - this.Wy);
        double d5 = 0.0;
        int n5 = 0;
        while (n5 < this.WB) {
            d5 = d4 * this.WM[n5];
            d2 += this.WO[n5] * this.Ww.m(d3 + d5);
            ++n5;
        }
        this.WF = d2 * d4;
        this.WI = true;
        return this.WF;
    }

    public void eR(int n2) {
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = -1.0;
        double d9 = 1.0;
        int n3 = (n2 + 1) / 2;
        double d10 = 0.5 * (d9 + d8);
        double d11 = 0.5 * (d9 - d8);
        int n4 = 1;
        while (n4 <= n3) {
            d2 = Math.cos(Math.PI * ((double)n4 - 0.25) / ((double)n2 + 0.5));
            do {
                d4 = 1.0;
                d5 = 0.0;
                int n5 = 1;
                while (n5 <= n2) {
                    d6 = d5;
                    d5 = d4;
                    d4 = ((2.0 * (double)n5 - 1.0) * d2 * d5 - ((double)n5 - 1.0) * d6) / (double)n5;
                    ++n5;
                }
            } while (Math.abs((d2 = (d3 = d2) - d4 / (d7 = (double)n2 * (d2 * d4 - d5) / (d2 * d2 - 1.0))) - d3) > this.WP);
            this.WM[n4 - 1] = d10 - d11 * d2;
            this.WM[n2 - n4] = d10 + d11 * d2;
            this.WO[n4 - 1] = 2.0 * d11 / ((1.0 - d2 * d2) * d7 * d7);
            this.WO[n2 - n4] = this.WO[n4 - 1];
            ++n4;
        }
    }

    public static void a(double[] dArray, double[] dArray2, int n2) {
        f f2 = new f();
        f2.eR(n2);
        dArray = f2.xo();
        dArray2 = f2.xp();
    }

    public double[] xo() {
        return this.WM;
    }

    public double[] xp() {
        return this.WO;
    }

    public double eS(int n2) {
        this.WB = n2;
        this.WC = true;
        return this.xn();
    }

    public static double a(e e2, double d2, double d3, int n2) {
        f f2 = new f(e2, d2, d3);
        return f2.eS(n2);
    }

    public ArrayList xq() {
        if (!this.WC) {
            throw new IllegalArgumentException("Number of points not set");
        }
        if (!this.WA) {
            throw new IllegalArgumentException("One limit or both limits not set");
        }
        if (!this.Wx) {
            throw new IllegalArgumentException("No integral function has been set");
        }
        this.WM = new double[this.WB];
        this.WO = new double[this.WB];
        double d2 = 0.5 * (this.Wz + this.Wy);
        double d3 = 0.5 * (this.Wz - this.Wy);
        boolean bl2 = true;
        int n2 = -1;
        if (!this.WK.isEmpty()) {
            int n3 = 0;
            while (n3 < this.WK.size()) {
                Integer n4 = (Integer)this.WK.get(n3);
                if (n4 == this.WB) {
                    bl2 = false;
                    n2 = n3;
                }
                ++n3;
            }
        }
        if (bl2) {
            this.eR(this.WB);
            this.WK.add(new Integer(this.WB));
            this.WL.add(this.WM);
            this.WN.add(this.WO);
        } else {
            this.WM = (double[])this.WL.get(n2);
            this.WO = (double[])this.WN.get(n2);
        }
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = 0.0;
        int n5 = 0;
        while (n5 < this.WB) {
            d8 = d3 * this.WM[n5];
            d6 = d2 + d8;
            d5 = this.WO[n5] * this.Ww.m(d6);
            d4 += d5;
            d7 += d5 * d6;
            ++n5;
        }
        this.WF = d4 * d3;
        this.WG = d7 / d4;
        double d9 = 0.0;
        int n6 = 0;
        while (n6 < this.WB) {
            d8 = d3 * this.WM[n6];
            d6 = d2 + d8;
            d5 = this.WO[n6] * this.Ww.m(d6);
            d9 += c.p(d6 - this.WG) * d5;
            ++n6;
        }
        this.WH = Math.sqrt(d9 / d4);
        ArrayList<Double> arrayList = new ArrayList<Double>();
        arrayList.add(new Double(this.WF));
        arrayList.add(new Double(this.WG));
        arrayList.add(new Double(this.WH));
        this.WJ = true;
        this.WI = true;
        return arrayList;
    }
}

