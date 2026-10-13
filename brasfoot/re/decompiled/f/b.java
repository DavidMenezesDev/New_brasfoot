/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.Z;
import best.ah;
import c.a;
import components.al;
import components.am;
import java.util.ArrayList;

public final class b {
    public static void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, boolean bl2) {
        Z z2 = null;
        int n2 = 0;
        while (n2 < arrayList.size()) {
            z2 = (Z)a.SR.aG().get(((am)arrayList.get(n2)).uW());
            if (((am)arrayList.get(n2)).uY()) {
                bl2 = true;
            }
            z2.a(((am)arrayList.get(n2)).uX(), arrayList2, arrayList3, bl2);
            ++n2;
        }
    }

    public static void a(ArrayList arrayList, ArrayList arrayList2, int n2, ArrayList arrayList3) {
        if (arrayList.size() < n2) {
            ArrayList<am> arrayList4 = new ArrayList<am>();
            int n3 = 0;
            while (n3 < arrayList2.size()) {
                if (arrayList.size() >= n2) break;
                arrayList4.clear();
                arrayList4.add(new am("mesmo pais", ((am)arrayList2.get(n3)).uW(), 1));
                b.a(arrayList4, arrayList, arrayList3, false);
                ++n3;
            }
        }
    }

    public static void a(int n2, int n3, ArrayList arrayList, ArrayList arrayList2, int n4, al al2) {
        int n5 = 0;
        int n6 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        int n7 = 0;
        while (n7 < arrayList.size()) {
            if (((am)arrayList.get(n7)).uW() == n4) {
                n5 += ((am)arrayList.get(n7)).uX();
                if (((am)arrayList.get(n7)).uY()) {
                    bl2 = true;
                }
            }
            ++n7;
        }
        if (arrayList2 != null) {
            n7 = 0;
            while (n7 < arrayList2.size()) {
                if (((am)arrayList2.get(n7)).uW() == n4) {
                    n6 += ((am)arrayList2.get(n7)).uX();
                    if (((am)arrayList2.get(n7)).uY()) {
                        bl3 = true;
                    }
                }
                ++n7;
            }
        }
        if (n2 == 1 && n3 == 1) {
            ah ah2 = a.SR.aF().cS();
            ah ah3 = a.SR.aH().cS();
            if (ah2 != null && ah2 == ah3 && n4 == ah2.getPais()) {
                ++n5;
            }
        }
        if (bl2) {
            --n5;
        }
        if (bl3) {
            --n6;
        }
        if (n3 == 1) {
            al2.ea(n5);
            al2.eb(n6);
            if (bl2) {
                al2.ee(1);
            }
            if (bl3) {
                al2.ef(1);
            }
        } else if (n3 == 2) {
            al2.ec(n5);
            al2.ed(n6);
            if (bl2) {
                al2.eg(1);
            }
            if (bl3) {
                al2.eh(1);
            }
        } else if (n3 == 3) {
            al2.fA(n5);
            al2.fB(n6);
            if (bl2) {
                al2.fC(1);
            }
            if (bl3) {
                al2.fD(1);
            }
        }
    }
}

