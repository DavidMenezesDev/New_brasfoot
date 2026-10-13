/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.n;
import java.util.Comparator;

class o
implements Comparator {
    final /* synthetic */ n Vh;

    o(n n2) {
        this.Vh = n2;
    }

    public int a(Integer n2, Integer n3) {
        if (n2 != n3) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((Integer)object, (Integer)object2);
    }
}

