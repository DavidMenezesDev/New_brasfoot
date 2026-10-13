/*
 * Decompiled with CFR 0.152.
 */
package h;

import e.t;
import java.util.Comparator;

class b
implements Comparator {
    b() {
    }

    public int a(t t2, t t3) {
        String string = "";
        String string2 = "";
        string = t2.getNomep();
        string2 = t3.getNomep();
        int n2 = t2.getNivel();
        int n3 = t3.getNivel();
        if (!string.equals(string2)) {
            return string.compareTo(string2);
        }
        if (n2 != n3) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((t)object, (t)object2);
    }
}

