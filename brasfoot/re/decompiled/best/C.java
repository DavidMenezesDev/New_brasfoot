/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ah;
import java.io.Serializable;

public class C
implements Serializable {
    private static final long serialVersionUID = 1L;
    private long dK;
    private int dL;
    private int dM;
    private long dN;
    private int dO;
    private int dP;
    private int dQ;
    private long dR;
    private long dS;
    private int dT;
    private int dU;
    private int dV;
    private int dW;
    private int dX;
    private static String[] dY = new String[]{" mil", "M", "B", "T"};

    public static void ey() {
    }

    public long ez() {
        return (long)(this.dL + this.dM) + this.dN + (long)this.dO + (long)this.dP;
    }

    public void eA() {
        this.dL = 0;
        this.dN = 0L;
        this.dM = 0;
        this.dO = 0;
        this.dQ = 0;
        this.dS = 0L;
        this.dT = 0;
        this.dU = 0;
        this.dV = 0;
        this.dR = 0L;
    }

    public long eB() {
        return (long)this.dQ + this.dR + this.dS + (long)this.dT + (long)this.dU + (long)this.dV;
    }

    public long eC() {
        long l2 = this.ez();
        long l3 = this.eB();
        return l2 - l3;
    }

    public void h(int n2, int n3) {
        if (n3 == 1) {
            this.dN += (long)n2;
        } else if (n3 == 3) {
            this.dM += n2;
        } else if (n3 == 5) {
            this.dL += n2;
        } else if (n3 == 6) {
            this.dO += n2;
        } else if (n3 == 9) {
            this.dP += n2;
        }
    }

    public void b(long l2) {
        this.dS += l2;
    }

    public void i(int n2, int n3) {
        if (n3 == 1) {
            this.dR += (long)n2;
        } else if (n3 == 4) {
            this.dT += n2;
        } else if (n3 == 7) {
            this.dQ += n2;
        } else if (n3 == 8) {
            this.dV += n2;
        } else {
            this.dU += n2;
        }
    }

    public static String c(long l2) {
        String string = String.valueOf(l2);
        String[] stringArray = new String[]{"mil", "milh\u00e3o", "milh\u00f5es", "bilh\u00e3o", "bilh\u00f5es"};
        String string2 = "";
        String string3 = "";
        if (l2 < 0L) {
            return "-" + C.c(Math.abs(l2));
        }
        if (l2 == 0L) {
            return "0 " + stringArray[0];
        }
        if (l2 <= 999L) {
            return string;
        }
        if (l2 <= 9999L) {
            return String.valueOf(string.substring(0, 1)) + " " + stringArray[0];
        }
        if (l2 <= 99999L) {
            return String.valueOf(string.substring(0, 2)) + " " + stringArray[0];
        }
        if (l2 <= 999999L) {
            return String.valueOf(string.substring(0, 3)) + " " + stringArray[0];
        }
        if (l2 <= 1999999L) {
            string2 = String.valueOf(string.substring(0, 1)) + " " + stringArray[1];
            string3 = String.valueOf(string.substring(1, 4)) + " " + stringArray[0];
        } else if (l2 <= 9999999L) {
            string2 = String.valueOf(string.substring(0, 1)) + " " + stringArray[2];
            string3 = String.valueOf(string.substring(1, 4)) + " " + stringArray[0];
        } else if (l2 <= 99999999L) {
            string2 = String.valueOf(string.substring(0, 2)) + " " + stringArray[2];
            string3 = String.valueOf(string.substring(2, 5)) + " " + stringArray[0];
        } else if (l2 <= 999999999L) {
            string2 = String.valueOf(string.substring(0, 3)) + " " + stringArray[2];
            string3 = String.valueOf(string.substring(3, 6)) + " " + stringArray[0];
        } else if (l2 <= 1999999999L) {
            string2 = String.valueOf(string.substring(0, 1)) + " " + stringArray[3];
            string3 = String.valueOf(string.substring(1, 4)) + " " + stringArray[2];
        } else if (l2 <= 9999999999L) {
            string2 = String.valueOf(string.substring(0, 1)) + " " + stringArray[4];
            string3 = String.valueOf(string.substring(1, 4)) + " " + stringArray[2];
        } else if (l2 <= 99999999999L) {
            string2 = String.valueOf(string.substring(0, 2)) + " " + stringArray[4];
            string3 = String.valueOf(string.substring(2, 5)) + " " + stringArray[2];
        } else {
            return C.a(l2, 0);
        }
        if (string3.length() >= 3 && string3.substring(0, 3).equals("000")) {
            string3 = "";
        }
        if (string3.length() >= 3 && string3.substring(0, 2).equals("00")) {
            string3 = String.valueOf(string3.substring(2, 3)) + " " + stringArray[0];
        }
        if (string3.length() >= 3 && string3.substring(0, 1).equals("0")) {
            string3 = String.valueOf(string3.substring(1, 3)) + " " + stringArray[0];
        }
        return String.valueOf(string2) + " " + string3;
    }

    public static String U(int n2) {
        return null;
    }

    public static String a(double d2, int n2) {
        boolean bl2;
        double d3 = (double)((long)d2 / 100L) / 10.0;
        boolean bl3 = bl2 = d3 * 10.0 % 10.0 == 0.0;
        return d3 < 1000.0 ? (d3 > 99.9 || bl2 || !bl2 && d3 > 9.99 ? Integer.valueOf((int)d3 * 10 / 10) : String.valueOf(d3)) + dY[n2] : C.a(d3, n2 + 1);
    }

    public long eD() {
        return this.dK;
    }

    public int eE() {
        return this.dL;
    }

    public int eF() {
        return this.dM;
    }

    public long eG() {
        return this.dN;
    }

    public int eH() {
        return this.dO;
    }

    public int eI() {
        return this.dQ;
    }

    public long eJ() {
        return this.dR;
    }

    public int eK() {
        return this.dT;
    }

    public int eL() {
        return this.dU;
    }

    public int eM() {
        return this.dV;
    }

    public int eN() {
        return this.dW;
    }

    public long eO() {
        return this.dS;
    }

    public void V(int n2) {
        this.dW = n2;
    }

    public boolean l(ah ah2) {
        if (this.dW > 0 && ah2.kb() >= 500000L) {
            this.dW -= 500000;
            ah2.w(500000, -1);
            this.eP();
            return true;
        }
        return false;
    }

    public boolean m(ah ah2) {
        int[] nArray = new int[]{1000000, 5000000, 3000000, 2000000, 1500000};
        int n2 = ah2.getDivisao() >= 1 && ah2.getDivisao() <= 4 ? nArray[ah2.getDivisao()] : nArray[0];
        if (this.dW < n2) {
            this.dW += 500000;
            ah2.v(500000, -1);
            this.eP();
            return true;
        }
        return false;
    }

    private void eP() {
        this.dX = this.dW > 0 ? Math.round(this.dW * 3 / 100) : 0;
    }

    public int eQ() {
        return this.dX;
    }

    public void W(int n2) {
        this.dX = n2;
    }

    public int eR() {
        return this.dP;
    }

    public void X(int n2) {
        this.dP = n2;
    }
}

