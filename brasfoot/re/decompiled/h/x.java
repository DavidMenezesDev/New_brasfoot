/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.n;
import e.t;
import java.util.Comparator;

class x
implements Comparator {
    x() {
    }

    public int a(t t2, t t3) {
        String string;
        String string2 = n.f(t2.getNome());
        if (!string2.equals(string = n.f(t3.getNome()))) {
            return string2.compareTo(string);
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((t)object, (t)object2);
    }
}

