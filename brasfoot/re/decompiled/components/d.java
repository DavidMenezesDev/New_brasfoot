/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.I;
import java.util.ArrayList;

public class d {
    private I NB = null;
    private I NC = null;
    private boolean ND = false;
    private boolean NE = false;
    private boolean NF = false;
    private String NG = "";
    private String NH = "";
    private String NI = "";
    private String NJ = "";
    private String NK = null;
    private String NL = null;
    private int w = 0;

    public I sP() {
        return this.NB;
    }

    public void l(I i2) {
        this.NB = i2;
    }

    public I sQ() {
        return this.NC;
    }

    public void m(I i2) {
        this.NC = i2;
    }

    public boolean sR() {
        return this.ND;
    }

    public void ah(boolean bl2) {
        this.ND = bl2;
    }

    public boolean sS() {
        return this.NE;
    }

    public void ai(boolean bl2) {
        this.NE = bl2;
    }

    public String sT() {
        return this.NG;
    }

    public void D(String string) {
        this.NG = string;
    }

    public String sU() {
        return this.NH;
    }

    public void E(String string) {
        this.NH = string;
    }

    public String sV() {
        return this.NI;
    }

    public void F(String string) {
        this.NI = string;
    }

    public String sW() {
        return this.NJ;
    }

    public void G(String string) {
        this.NJ = string;
    }

    public String sX() {
        return this.NK;
    }

    public void H(String string) {
        this.NK = string;
    }

    public String sY() {
        return this.NL;
    }

    public void I(String string) {
        this.NL = string;
    }

    public boolean sZ() {
        return this.NF;
    }

    public void aj(boolean bl2) {
        this.NF = bl2;
    }

    public static ArrayList a(int n2, boolean bl2, String string, String string2, ArrayList arrayList, boolean bl3) {
        int n3 = 1;
        String string3 = "Time ";
        if (string2 != "") {
            string3 = "Vencedor " + string2;
        }
        ArrayList<d> arrayList2 = new ArrayList<d>();
        int n4 = 0;
        while (n4 < n2) {
            d d2 = new d();
            d2.ai(true);
            d2.aj(true);
            arrayList2.add(d2);
            d d3 = new d();
            d3.ah(true);
            d3.E(String.valueOf(string) + Integer.toString(n4 + 1));
            d3.aj(true);
            if (bl3 && n4 == 0) {
                d3.E("Decis\u00e3o");
            } else if (bl3 && n4 == 1) {
                d3.E("Decis\u00e3o 3\u00ba lugar");
            }
            if (n2 == 1) {
                d3.E(string);
            }
            arrayList2.add(d3);
            String string4 = String.valueOf(string3) + n3;
            String string5 = String.valueOf(string3) + (n3 + 1);
            if (arrayList != null) {
                if (n3 - 1 < arrayList.size()) {
                    string4 = (String)arrayList.get(n3 - 1);
                }
                if (n3 < arrayList.size()) {
                    string5 = (String)arrayList.get(n3);
                }
            }
            d d4 = new d();
            d4.F(string4);
            d4.G(string5);
            d4.aj(true);
            arrayList2.add(d4);
            if (bl2) {
                d3.H(string5);
                d3.I(string4);
                d4.H(string5);
                d4.I(string4);
            }
            n3 += 2;
            ++n4;
        }
        return arrayList2;
    }

    public int b() {
        return this.w;
    }

    public void a(int n2) {
        this.w = n2;
    }
}

