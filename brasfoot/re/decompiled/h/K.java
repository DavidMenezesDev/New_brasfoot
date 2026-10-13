/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.ah;
import f.s;
import java.util.Comparator;

class K
implements Comparator {
    K() {
    }

    public int c(ah ah2, ah ah3) {
        int[] nArray = ah2.d(s.Zl);
        int[] nArray2 = ah3.d(s.Zl);
        int n2 = nArray[0];
        int n3 = nArray2[0];
        int n4 = nArray[2];
        int n5 = nArray2[2];
        int n6 = nArray[7];
        int n7 = nArray2[7];
        int n8 = nArray[5];
        int n9 = nArray2[5];
        if (n2 != n3) {
            return n3 - n2;
        }
        if (n4 != n5) {
            return n5 - n4;
        }
        if (n6 != n7) {
            return n7 - n6;
        }
        if (n8 != n9) {
            return n9 - n8;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.c((ah)object, (ah)object2);
    }
}

