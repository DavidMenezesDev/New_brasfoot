/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.Y;
import java.util.Comparator;

class C
implements Comparator {
    C() {
    }

    public int a(Y y2, Y y3) {
        double d2 = y2.C();
        double d3 = y3.C();
        int n2 = y2.iS();
        int n3 = y3.iS();
        if (Double.compare(d3, d2) != 0) {
            return Double.compare(d3, d2);
        }
        if (n2 != n3) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((Y)object, (Y)object2);
    }
}

