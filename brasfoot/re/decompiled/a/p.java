/*
 * Decompiled with CFR 0.152.
 */
package a;

import best.d;
import java.util.Comparator;

class p
implements Comparator {
    p() {
    }

    public int a(d d2, d d3) {
        int n2 = d2.v();
        int n3 = d3.v();
        int n4 = d2.w();
        int n5 = d3.w();
        if (n2 != n3) {
            return n3 - n2;
        }
        if (n4 != n5) {
            return n4 - n5;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((d)object, (d)object2);
    }
}

