/*
 * Decompiled with CFR 0.152.
 */
package a;

import best.aq;
import components.i;
import java.util.Comparator;

class hl
implements Comparator {
    hl() {
    }

    public int a(i i2, i i3) {
        int n2 = 0;
        int n3 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        n2 = aq.sE[i2.fb().fT()][0];
        if (n2 != (n3 = aq.sE[i3.fb().fT()][0])) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((i)object, (i)object2);
    }
}

