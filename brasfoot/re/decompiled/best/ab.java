/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.Z;
import java.util.Comparator;

class ab
implements Comparator {
    ab() {
    }

    public int a(Z z2, Z z3) {
        int n2 = Z.b(z2);
        int n3 = Z.b(z3);
        int n4 = Z.c(z2);
        int n5 = Z.c(z3);
        if (n2 != n3) {
            return n3 - n2;
        }
        if (n4 != n5) {
            return n5 - n4;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((Z)object, (Z)object2);
    }
}

