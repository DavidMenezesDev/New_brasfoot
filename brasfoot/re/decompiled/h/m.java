/*
 * Decompiled with CFR 0.152.
 */
package h;

import e.t;
import java.util.Comparator;

class m
implements Comparator {
    m() {
    }

    public int a(t t2, t t3) {
        int n2;
        int n3 = t2.getNivel();
        if (n3 != (n2 = t3.getNivel())) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((t)object, (t)object2);
    }
}

