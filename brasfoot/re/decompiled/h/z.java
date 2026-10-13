/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class z
implements Comparator {
    z() {
    }

    public int a(F f2, F f3) {
        int n2;
        int n3 = f2.getPosicao();
        if (n3 > (n2 = f3.getPosicao())) {
            return 1;
        }
        if (n3 < n2) {
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

