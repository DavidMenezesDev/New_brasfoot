/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class u
implements Comparator {
    u() {
    }

    public int a(F f2, F f3) {
        double d2;
        double d3 = f2.F();
        if (d3 != (d2 = f3.F())) {
            if (d2 > d3) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

