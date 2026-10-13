/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.v;
import java.util.Comparator;

class i
implements Comparator {
    i() {
    }

    public int a(v v2, v v3) {
        int n2;
        int n3 = v2.dW();
        if (n3 != (n2 = v3.dW())) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((v)object, (v)object2);
    }
}

