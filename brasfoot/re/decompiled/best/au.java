/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.c;
import java.util.Comparator;

class au
implements Comparator {
    au() {
    }

    public int a(c c2, c c3) {
        int n2 = c2.y();
        int n3 = c3.y();
        int n4 = c2.A();
        int n5 = c3.A();
        if (n2 != n3) {
            return n3 - n2;
        }
        if (n4 != n5) {
            return n4 - n5;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((c)object, (c)object2);
    }
}

