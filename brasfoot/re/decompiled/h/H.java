/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.F;
import java.util.Comparator;

class H
implements Comparator {
    H() {
    }

    public int a(F f2, F f3) {
        String string = "";
        String string2 = "";
        if (f2.fg() != null) {
            string = f2.fg().getNome();
        }
        if (f3.fg() != null) {
            string2 = f3.fg().getNome();
        }
        if (!string.equals(string2)) {
            return string.compareTo(string2);
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((F)object, (F)object2);
    }
}

