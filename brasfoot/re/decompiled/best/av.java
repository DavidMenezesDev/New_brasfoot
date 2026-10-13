/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.X;
import java.util.Comparator;

class av
implements Comparator {
    av() {
    }

    public int a(X x2, X x3) {
        double d2 = x2.F();
        double d3 = x3.F();
        int n2 = x2.A();
        int n3 = x3.A();
        if (d2 != d3) {
            return Double.compare(d3, d2);
        }
        if (n2 != n3) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((X)object, (X)object2);
    }
}

