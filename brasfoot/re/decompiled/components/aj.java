/*
 * Decompiled with CFR 0.152.
 */
package components;

public class aj {
    private String[] Rl = new String[9];
    private String[] Rm = new String[9];
    private int[] Rn = new int[9];

    public String[] uL() {
        return this.Rl;
    }

    public String dX(int n2) {
        return this.Rl[n2];
    }

    public void d(String string, int n2) {
        this.Rl[n2] = string;
    }

    public String[] uM() {
        return this.Rm;
    }

    public String dY(int n2) {
        return this.Rm[n2];
    }

    public void e(String string, int n2) {
        this.Rm[n2] = string;
    }

    public int[] uN() {
        return this.Rn;
    }

    public int dZ(int n2) {
        return this.Rn[n2];
    }

    public void R(int n2, int n3) {
        this.Rn[n3] = n2;
    }
}

