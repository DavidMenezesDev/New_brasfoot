/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.ah;
import java.util.Comparator;

class k
implements Comparator {
    k() {
    }

    public int c(ah ah2, ah ah3) {
        int n2;
        int n3 = ah2.jX();
        if (n3 != (n2 = ah3.jX())) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.c((ah)object, (ah)object2);
    }
}

