/*
 * Decompiled with CFR 0.152.
 */
package d;

import e.g;
import java.util.Comparator;

class ar
implements Comparator {
    ar() {
    }

    public int a(g g2, g g3) {
        int n2;
        int n3 = g2.getPosicao();
        if (n3 != (n2 = g3.getPosicao())) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((g)object, (g)object2);
    }
}

