/*
 * Decompiled with CFR 0.152.
 */
package h;

import best.ah;
import best.n;
import java.util.Comparator;

class E
implements Comparator {
    E() {
    }

    public int c(ah ah2, ah ah3) {
        String string;
        String string2 = n.f(ah2.getNome());
        if (!string2.equals(string = n.f(ah3.getNome()))) {
            return string2.compareTo(string);
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.c((ah)object, (ah)object2);
    }
}

