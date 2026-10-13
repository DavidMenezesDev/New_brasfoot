/*
 * Decompiled with CFR 0.152.
 */
package forms;

import forms.Randoms;
import forms.t;
import forms.x;
import java.util.Random;

public class a {
    public static void xl() {
        int n2;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n5 < 1000) {
            n2 = a.eN(50);
            if (n2 < 25) {
                ++n3;
            } else {
                ++n4;
            }
            ++n5;
        }
        n3 = 0;
        n4 = 0;
        n5 = 0;
        while (n5 < 1000) {
            n2 = a.eM(50);
            if (n2 < 25) {
                ++n3;
            } else {
                ++n4;
            }
            ++n5;
        }
        n3 = 0;
        n4 = 0;
        n5 = 0;
        while (n5 < 1000) {
            n2 = a.eP(50);
            if (n2 < 25) {
                ++n3;
            } else {
                ++n4;
            }
            ++n5;
        }
        System.out.println("");
        System.out.println("contnrmenosNormal: " + n3);
        System.out.println("contnr: " + n4);
    }

    public static int eM(int n2) {
        boolean bl2 = false;
        double d2 = 0.0;
        Randoms randoms = new Randoms();
        while (d2 <= 0.0 || d2 >= 1.0) {
            d2 = randoms.xI();
        }
        int n3 = (int)Math.round((double)bl2 + (double)n2 * d2);
        return n3;
    }

    public static int eN(int n2) {
        boolean bl2 = false;
        double d2 = 0.0;
        t t2 = new t();
        d2 = x.a(1.0, 1, 1, new Random().nextLong())[0];
        while (d2 <= 0.0 || d2 >= 1.0) {
            d2 = x.a(1.0, 1, 1, new Random().nextLong())[0];
        }
        int n3 = (int)Math.round((double)bl2 + (double)n2 * d2);
        return n3;
    }

    public static int eO(int n2) {
        boolean bl2 = false;
        double d2 = 0.0;
        Random random = new Random();
        d2 = random.nextDouble();
        while (d2 <= 0.0 || d2 >= 1.0) {
            d2 = random.nextDouble();
        }
        int n3 = (int)Math.round((double)bl2 + (double)n2 * d2);
        return n3;
    }

    public static int eP(int n2) {
        boolean bl2 = false;
        double d2 = 0.0;
        Randoms randoms = new Randoms();
        d2 = randoms.nextGaussian();
        while (d2 <= 0.0 || d2 >= 1.0) {
            d2 = randoms.nextGaussian();
        }
        int n3 = (int)Math.round((double)bl2 + (double)n2 * d2);
        return n3;
    }

    public static void xm() {
        Double[] doubleArray = new Double[]{58.0, 18.0};
        Double[] doubleArray2 = new Double[]{82.0, 22.0};
        Double[] doubleArray3 = new Double[]{70.0, 10.0};
        Double[] doubleArray4 = new Double[]{40.0, 20.0};
        int n2 = 0;
        int n3 = 1;
        int n4 = 0;
        int[] nArray = new int[2];
        int[] nArray2 = new int[2];
        int n5 = 0;
        while (n5 < 100) {
            n4 = a.a(n2, n3, doubleArray, doubleArray2, doubleArray3, doubleArray4);
            if (n4 == 3) {
                int n6 = n2;
                nArray[n6] = nArray[n6] + 1;
                int n7 = n2;
                nArray2[n7] = nArray2[n7] + 1;
            }
            if (n4 == 2) {
                int n8 = n2;
                nArray2[n8] = nArray2[n8] + 1;
            }
            n2 = n2 == 0 ? 1 : 0;
            ++n5;
        }
    }

    public static int a(int n2, int n3, Double[] doubleArray, Double[] doubleArray2, Double[] doubleArray3, Double[] doubleArray4) {
        int n4 = 0;
        if (a.a(doubleArray2[n2], doubleArray2[n3])) {
            n4 = 1;
            if (a.a(doubleArray3[n2], doubleArray[n3])) {
                if (a.a(doubleArray3[n2], doubleArray[n3])) {
                    n4 = 3;
                }
            } else {
                n4 = 2;
            }
        }
        return n4;
    }

    public static boolean a(Double d2, Double d3) {
        int n2 = (int)Math.round(d2);
        int n3 = (int)Math.round(d3);
        return a.eM(n2) > a.eM(n3);
    }
}

