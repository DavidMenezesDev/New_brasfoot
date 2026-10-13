/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class B
implements Comparator {
    B() {
    }

    public int a(F f2, F f3) {
        int n2 = f2.fi();
        int n3 = f3.fi();
        int n4 = f2.fp();
        int n5 = f3.fp();
        if (n2 > n3) {
            return -1;
        }
        if (n2 < n3) {
            return 1;
        }
        if (n4 > n5) {
            return -1;
        }
        if (n4 < n5) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

