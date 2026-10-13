/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.I;
import best.ah;
import best.aq;
import f.z;
import java.io.Serializable;
import java.util.Random;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class v
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dm;
    private int[] dn = new int[4];
    private int[] do = new int[]{20, 35, 55, 80};
    private boolean dp = true;
    private int dq = 0;
    private int pais = -1;

    public v() {
    }

    public v(String string, int n2, ah ah2) {
        this.dm = string;
        this.N(n2);
        this.do = v.a(1, ah2);
        this.h(ah2);
        this.pais = ah2.getPais();
    }

    public v(boolean bl2, String string, int n2) {
        this.dm = string;
        this.N(n2);
        this.do = aq.qK[1][1];
    }

    private void h(ah ah2) {
        if (ah2 != null) {
            Random random = new Random();
            if (ah2.getReputacao() >= 4) {
                if (random.nextInt(100) >= 95) {
                    this.dq = 1;
                }
            } else if (ah2.getReputacao() == 3) {
                int n2 = random.nextInt(100);
                if (n2 >= 50) {
                    this.dq = 1;
                } else if (n2 <= 5) {
                    this.dq = 2;
                }
            } else if (ah2.getReputacao() == 2) {
                int n3 = random.nextInt(100);
                if (n3 >= 50) {
                    this.dq = 1;
                } else if (n3 <= 15) {
                    this.dq = 2;
                } else if (n3 == 0) {
                    this.dq = 3;
                }
            } else {
                int n4 = random.nextInt(100);
                this.dq = n4 >= 90 ? 0 : (n4 >= 50 ? 1 : (n4 >= 25 ? 2 : 3));
            }
        }
    }

    public void i(ah ah2) {
        Random random = new Random();
        this.dq = ah2.getReputacao() >= 4 ? (random.nextInt(100) >= 70 ? 1 : 0) : (random.nextInt(100) >= 70 ? 1 : 0);
    }

    private void N(int n2) {
        if (n2 < 1000 || n2 > 120000) {
            n2 = 10000;
        }
        double[] dArray = new double[]{0.15, 0.75, 0.09, 0.009};
        this.dn[0] = (int)Math.round((double)n2 * dArray[0]);
        this.dn[2] = (int)Math.round((double)n2 * dArray[2]);
        this.dn[3] = (int)Math.round((double)n2 * dArray[3]);
        this.dn[1] = n2 - (this.dn[0] + this.dn[2] + this.dn[3]);
    }

    public void b(I i2) {
        int n2;
        int n3;
        boolean bl2 = false;
        int[] nArray = new int[4];
        int n4 = 0;
        int n5 = i2.hy().b();
        int n6 = i2.hy().el();
        int[] nArray2 = v.a(i2.hy().b(), i2.hc());
        int[] nArray3 = new int[4];
        int[] nArray4 = new int[4];
        int n7 = 0;
        while (n7 < nArray4.length) {
            nArray4[n7] = this.dn[n7];
            ++n7;
        }
        int[][] nArrayArray = new int[6][];
        int[] nArray5 = new int[4];
        nArray5[0] = 200;
        nArray5[1] = 500;
        nArray5[2] = 50;
        nArrayArray[0] = nArray5;
        nArrayArray[1] = new int[]{1000, 5000, 1200, 20};
        nArrayArray[2] = new int[]{2000, 10000, 1500, 50};
        nArrayArray[3] = new int[]{4000, 20000, 2500, 300};
        nArrayArray[4] = new int[]{4500, 30000, 3500, 400};
        nArrayArray[5] = new int[]{5000, 40000, 5500, 500};
        int[][] nArrayArray2 = nArrayArray;
        int n8 = i2.hc().getDivisao();
        int n9 = i2.hc().getReputacao();
        int n10 = 0;
        while (n10 < nArray3.length) {
            nArray3[n10] = nArrayArray2[n9][n10];
            ++n10;
        }
        if (n5 == 3 || n5 == 10) {
            n10 = 0;
            while (n10 < nArray3.length) {
                nArray3[n10] = (int)Math.round((double)nArray3[n10] * 0.7);
                ++n10;
            }
        }
        if (n5 == 0) {
            n10 = 0;
            while (n10 < nArray3.length) {
                nArray3[n10] = (int)Math.round((double)nArray3[n10] * 0.4);
                ++n10;
            }
        }
        double d2 = 0.3;
        if (i2.ht() instanceof z) {
            d2 += 0.15;
        }
        if (n5 == 4) {
            d2 += 0.3;
        } else if (n5 == 7 || n5 == 9) {
            d2 += 0.3;
        } else if (n5 == 6 || n5 == 8 || n5 == 11) {
            d2 += 0.15;
        }
        int n11 = 0;
        while (n11 < nArray3.length) {
            nArray3[n11] = nArray3[n11] + (int)Math.round((double)this.dn[n11] * d2);
            ++n11;
        }
        double d3 = 0.0;
        int n12 = i2.hd().getReputacao() - i2.hc().getReputacao();
        double[] dArray = new double[]{0.0, 0.05, 0.1, 0.15, 0.2, 0.25};
        d3 += dArray[Math.abs(n12)];
        if (n12 > 0) {
            n3 = 0;
            while (n3 < nArray3.length) {
                nArray3[n3] = nArray3[n3] + (int)Math.round((double)nArray3[n3] * d3);
                ++n3;
            }
        } else if (n12 < 0) {
            n3 = 0;
            while (n3 < nArray3.length) {
                nArray3[n3] = nArray3[n3] - (int)Math.round((double)nArray3[n3] * d3);
                ++n3;
            }
        }
        n3 = 80;
        if (i2.hc().ka() != null) {
            n3 = i2.hc().ka().lM();
        }
        double d4 = (double)n3 / 100.0;
        int n13 = 0;
        while (n13 < nArray3.length) {
            nArray3[n13] = (int)Math.round((double)nArray3[n13] * d4);
            ++n13;
        }
        int[][] nArrayArray3 = new int[5][];
        int[] nArray6 = new int[4];
        nArray6[0] = 10;
        nArray6[1] = 20;
        nArray6[2] = 5;
        nArrayArray3[0] = nArray6;
        nArrayArray3[1] = new int[]{100, 500, 200, 10};
        nArrayArray3[2] = new int[]{300, 1000, 400, 20};
        nArrayArray3[3] = new int[]{400, 1200, 500, 30};
        nArrayArray3[4] = new int[]{500, 1500, 1000, 50};
        int[][] nArrayArray4 = nArrayArray3;
        int n14 = 0;
        while (n14 < nArray3.length) {
            n2 = nArrayArray4[n8][n14];
            if (n2 > 0) {
                nArray3[n14] = nArray3[n14] + new Random().nextInt(n2);
            }
            ++n14;
        }
        int[] nArray7 = new int[4];
        if (this.dV()) {
            nArray = v.a(i2.hy().b(), i2.hc());
        } else {
            nArray = this.dU();
            n2 = 0;
            while (n2 < nArray.length) {
                nArray7[n2] = nArray2[n2] - nArray[n2];
                if (nArray7[n2] != 0) {
                    int n15 = (int)(Math.round(0.03 * (double)nArray3[n2]) * (long)nArray7[n2]);
                    nArray3[n2] = nArray3[n2] + n15;
                }
                ++n2;
            }
        }
        n2 = 0;
        while (n2 < nArray3.length) {
            if (nArray3[n2] < 0) {
                nArray3[n2] = 0;
            }
            if (nArray3[n2] > this.dn[n2]) {
                nArray3[n2] = this.dn[n2];
            }
            n4 += nArray3[n2] * nArray[n2];
            ++n2;
        }
        if (n5 == 7) {
            n4 = n6 != 7 ? (n4 *= 3) : (n4 *= 5);
        } else if (n5 == 9) {
            n4 *= 2;
        }
        i2.j(nArray3);
        i2.aW(n4);
    }

    public static void c(I i2) {
        i2.ev().b(i2);
    }

    public static int[] a(int n2, ah ah2) {
        int[] nArray = new int[]{10, 25, 35, 50};
        if (n2 == 10) {
            n2 = 2;
        }
        int n3 = ah2.gg();
        int n4 = ah2.getDivisao();
        int n5 = ah2.getReputacao();
        if (n3 > 1) {
            n3 = 1;
        }
        if (n2 == 1) {
            nArray = aq.qK[n2][n4];
        } else if (n2 == 2 || n2 == 3) {
            nArray = aq.qK[n2][n5];
        } else if (n2 == 4 || n2 == 6 || n2 == 8) {
            nArray = aq.qK[n2][n3];
        } else if (n2 == 5 || n2 == 7) {
            nArray = aq.qK[1][n4];
        }
        return nArray;
    }

    public String dS() {
        return this.dm;
    }

    public void i(String string) {
        this.dm = string;
    }

    public int[] dT() {
        return this.dn;
    }

    public void a(int[] nArray) {
        this.dn = nArray;
    }

    public int[] dU() {
        return this.do;
    }

    public void b(int[] nArray) {
        this.do = nArray;
    }

    public boolean dV() {
        return this.dp;
    }

    public void o(boolean bl2) {
        this.dp = bl2;
    }

    public int dW() {
        return this.dn[0] + this.dn[1] + this.dn[2] + this.dn[3];
    }

    public void f(int n2, int n3) {
        this.dn[n2] = this.dn[n2] + n3;
    }

    public int dX() {
        return this.dq;
    }

    public void O(int n2) {
        this.dq = n2;
    }

    public int getPais() {
        return this.pais;
    }
}

