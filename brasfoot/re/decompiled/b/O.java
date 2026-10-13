/*
 * Decompiled with CFR 0.152.
 */
package b;

import b.N;
import best.F;
import java.util.Comparator;

class O
implements Comparator {
    O() {
    }

    public int a(F f2, F f3) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (N.vG() == 0) {
            n2 = f2.getPosicao();
            n3 = f3.getPosicao();
            n4 = f2.fi();
            n5 = f3.fi();
        } else {
            n2 = f3.getPosicao();
            n3 = f2.getPosicao();
            n4 = f3.fi();
            n5 = f2.fi();
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

