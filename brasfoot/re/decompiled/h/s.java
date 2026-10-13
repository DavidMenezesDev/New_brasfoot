/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class s
implements Comparator {
    s() {
    }

    public int a(F f2, F f3) {
        int n2;
        int n3 = f2.gA();
        if (n3 != (n2 = f3.gA())) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

