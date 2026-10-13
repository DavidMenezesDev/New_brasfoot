/*
 * Decompiled with CFR 0.152.
 */
package a;

import components.ae;
import java.util.Comparator;

class jw
implements Comparator {
    jw() {
    }

    public int a(ae ae2, ae ae3) {
        int n2;
        int n3 = ae2.uy();
        if (n3 != (n2 = ae3.uy())) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((ae)object, (ae)object2);
    }
}

