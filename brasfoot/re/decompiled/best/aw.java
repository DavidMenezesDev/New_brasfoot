/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.e;
import java.util.Comparator;

class aw
implements Comparator {
    aw() {
    }

    public int a(e e2, e e3) {
        double d2 = e2.F();
        double d3 = e3.F();
        double d4 = e2.D();
        double d5 = e3.D();
        if (d2 != d3) {
            return Double.compare(d3, d2);
        }
        if (d4 != d5) {
            return Double.compare(d5, d4);
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((e)object, (e)object2);
    }
}

