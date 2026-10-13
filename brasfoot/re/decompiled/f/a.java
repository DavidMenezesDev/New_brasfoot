/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.I;
import best.ah;
import best.at;
import java.io.Serializable;
import java.util.ArrayList;

public class a
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int ci = 0;

    public a() {
        this.F(0, 0);
        this.setNome("Amistoso");
    }

    public static boolean d(ah ah2, int n2) {
        ArrayList arrayList = new ArrayList();
        arrayList = ((best.a)c.a.SR.R().get(n2)).h();
        int n3 = 0;
        while (n3 < arrayList.size()) {
            if (((I)arrayList.get(n3)).hc() == ah2 || ((I)arrayList.get(n3)).hd() == ah2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static ArrayList L(ah ah2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = best.a.b(100);
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            if (((best.a)c.a.SR.R().get((Integer)arrayList2.get(n2))).a().after(c.a.SR.bb()) && !a.d(ah2, (Integer)arrayList2.get(n2))) {
                arrayList.add((Integer)arrayList2.get(n2));
            }
            ++n2;
        }
        return arrayList;
    }

    public static ArrayList M(ah ah2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = best.a.b(200);
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            if (((best.a)c.a.SR.R().get((Integer)arrayList2.get(n2))).a().after(c.a.SR.bb()) && !a.d(ah2, (Integer)arrayList2.get(n2))) {
                arrayList.add((Integer)arrayList2.get(n2));
            }
            ++n2;
        }
        return arrayList;
    }

    public static int a(ah ah2, ah ah3, int n2, int n3) {
        ci = 0;
        int[] nArray = new int[6];
        nArray[2] = 10000;
        nArray[3] = 50000;
        nArray[4] = 150000;
        nArray[5] = 250000;
        int[] nArray2 = nArray;
        int[] nArray3 = new int[6];
        nArray3[2] = 20000;
        nArray3[3] = 80000;
        nArray3[4] = 200000;
        nArray3[5] = 450000;
        int[] nArray4 = nArray3;
        int[] nArray5 = new int[6];
        nArray5[2] = 30000;
        nArray5[3] = 100000;
        nArray5[4] = 250000;
        nArray5[5] = 500000;
        int[] nArray6 = nArray5;
        if (a.d(ah3, n3)) {
            return 2;
        }
        if (ah3.jZ().booleanValue()) {
            return 1;
        }
        if (n2 == 0) {
            if (ah3.getReputacao() == 5 && ah2.getReputacao() < 4) {
                ci = 300000;
                return 3;
            }
            if (ah3.getReputacao() == 5 && ah2.getReputacao() < 3) {
                return 0;
            }
            if (ah3.getReputacao() == 4 && ah2.getReputacao() < 2) {
                ci = 200000;
                return 3;
            }
            if (ah3.getReputacao() == 4 && ah2.getReputacao() <= 1) {
                return 0;
            }
            ci = ah2.getPais() == ah3.getPais() ? nArray2[ah3.getReputacao()] : nArray4[ah3.getReputacao()];
        } else {
            if (ah3.getReputacao() == 5 && ah2.getReputacao() != 5) {
                return 0;
            }
            if (ah3.getReputacao() == 4 && ah2.getReputacao() < 2) {
                return 0;
            }
            ci = ah2.getPais() == ah3.getPais() ? nArray4[ah3.getReputacao()] : nArray6[ah3.getReputacao()];
        }
        if (ci > 0) {
            return 3;
        }
        return 1;
    }

    public static void b(ah ah2, ah ah3, int n2, int n3) {
        ah ah4 = ah2;
        ah ah5 = ah3;
        if (n2 == 0) {
            ah4 = ah3;
            ah5 = ah2;
        }
        new I(null, 0, ah4, ah5, n3, c.a.SR.bv(), ah4.ev());
    }

    public static int xY() {
        return ci;
    }
}

