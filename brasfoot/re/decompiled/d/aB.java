/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ay;
import e.t;
import java.util.Comparator;

class aB
implements Comparator {
    aB() {
    }

    public int a(t t2, t t3) {
        String string = "";
        String string2 = "";
        if (ay.xj() == -1) {
            string = t3.getNome();
            string2 = t2.getNome();
        } else {
            string = t2.getNome();
            string2 = t3.getNome();
        }
        if (!string.equals(string2)) {
            return string.compareTo(string2);
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((t)object, (t)object2);
    }
}

