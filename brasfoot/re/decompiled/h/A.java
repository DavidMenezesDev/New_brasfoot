/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class A
implements Comparator {
    A() {
    }

    public int a(F f2, F f3) {
        int n2;
        int n3 = f2.fi();
        int n4 = f3.fi();
        int n5 = f2.fp();
        int n6 = f3.fp();
        int n7 = f2.getPosicao();
        if (n7 > (n2 = f3.getPosicao())) {
            return -1;
        }
        if (n3 > n4) {
            return -1;
        }
        if (n3 < n4) {
            return 1;
        }
        if (n5 > n6) {
            return -1;
        }
        if (n5 < n6) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

