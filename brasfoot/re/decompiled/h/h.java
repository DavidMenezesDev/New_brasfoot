/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class h
implements Comparator {
    h() {
    }

    public int a(F f2, F f3) {
        int n2 = f2.fp();
        int n3 = f3.fp();
        int n4 = f2.getPosicao();
        int n5 = f3.getPosicao();
        if (n2 == 0) {
            n2 = 100;
        }
        if (n3 == 0) {
            n3 = 100;
        }
        if (n2 != n3) {
            return n3 - n2;
        }
        if (n4 != n5) {
            return n4 - n5;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

