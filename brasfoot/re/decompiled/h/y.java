/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class y
implements Comparator {
    y() {
    }

    public int a(F f2, F f3) {
        int n2 = f2.getPosicao();
        int n3 = f3.getPosicao();
        int n4 = f2.fF();
        int n5 = f3.fF();
        int n6 = f2.fi();
        int n7 = f3.fi();
        boolean bl2 = false;
        boolean bl3 = false;
        if (f2.ff().booleanValue()) {
            bl2 = true;
        }
        if (f3.ff().booleanValue()) {
            bl3 = true;
        }
        if (n2 > n3) {
            return 1;
        }
        if (n2 < n3) {
            return -1;
        }
        if (n4 > n5) {
            return 1;
        }
        if (n4 < n5) {
            return -1;
        }
        if (n6 > n7) {
            return -1;
        }
        if (n6 < n7) {
            return 1;
        }
        if (bl2 > bl3) {
            return -1;
        }
        if (bl2 < bl3) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

