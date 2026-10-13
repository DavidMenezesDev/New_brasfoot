/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class o
implements Comparator {
    o() {
    }

    public int a(F f2, F f3) {
        boolean bl2;
        boolean bl3 = f2.fz();
        if (bl3 != (bl2 = f3.fz().booleanValue())) {
            if (bl3) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

