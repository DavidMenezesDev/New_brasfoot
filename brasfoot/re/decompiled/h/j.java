/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.ah;
import java.util.Comparator;

class j
implements Comparator {
    j() {
    }

    public int c(ah ah2, ah ah3) {
        int n2;
        int n3 = ah2.jW();
        if (n3 != (n2 = ah3.jW())) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.c((ah)object, (ah)object2);
    }
}

