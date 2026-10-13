/*
 * Decompiled with CFR 0.152.
 */
package best;

import components.aD;
import java.util.Comparator;

class x
implements Comparator {
    x() {
    }

    public int a(aD aD2, aD aD3) {
        int n2 = aD2.getId();
        int n3 = aD3.getId();
        int n4 = aD2.co();
        int n5 = aD3.co();
        int n6 = aD2.vE();
        int n7 = aD3.vE();
        if (n2 != n3) {
            return n2 - n3;
        }
        if (n4 != n5) {
            return n4 - n5;
        }
        if (n6 != n7) {
            return n6 - n7;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((aD)object, (aD)object2);
    }
}

