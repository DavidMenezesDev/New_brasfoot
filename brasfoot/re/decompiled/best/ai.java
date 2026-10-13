/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import java.util.Comparator;

class ai
implements Comparator {
    ai() {
    }

    public int a(F f2, F f3) {
        int n2 = f2.fi();
        int n3 = f3.fi();
        int n4 = f2.getIdade();
        int n5 = f3.getIdade();
        if (n2 == n3) {
            return n5 - n4;
        }
        return n3 - n2;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

