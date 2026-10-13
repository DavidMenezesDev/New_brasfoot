/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.I;
import best.ah;
import java.util.ArrayList;

public class m {
    private double cy = 0.0;
    private int V;
    private int W;
    private I cz = null;
    private ArrayList cA = new ArrayList();
    private ah cB = null;

    public m() {
    }

    public m(double d2, int n2, int n3, I i2, ah ah2, ArrayList arrayList) {
        this.cy = d2;
        this.V = n2;
        this.W = n3;
        this.cz = i2;
        this.cB = ah2;
        this.cA = arrayList;
    }

    public String cQ() {
        if (this.cy > 0.0) {
            return String.format("%.1f", this.cy);
        }
        return "--";
    }

    public int y() {
        return this.V;
    }

    public int A() {
        return this.W;
    }

    public I cR() {
        return this.cz;
    }

    public ah cS() {
        return this.cB;
    }

    public ArrayList cT() {
        return this.cA;
    }
}

