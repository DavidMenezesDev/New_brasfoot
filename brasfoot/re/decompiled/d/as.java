/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import e.g;
import java.util.Comparator;

class as
implements Comparator {
    as() {
    }

    public int a(g g2, g g3) {
        String string = "";
        String string2 = "";
        if (ap.xi() == -1) {
            string = g3.getNome();
            string2 = g2.getNome();
        } else {
            string = g2.getNome();
            string2 = g3.getNome();
        }
        if (!string.equals(string2)) {
            return string.compareTo(string2);
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((g)object, (g)object2);
    }
}

