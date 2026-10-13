/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import e.g;
import java.util.Comparator;

class aq
implements Comparator {
    aq() {
    }

    public int a(g g2, g g3) {
        int n2 = 0;
        int n3 = 0;
        if (ap.vG() == 0) {
            n2 = g2.getPosicao();
            n3 = g3.getPosicao();
        } else {
            n2 = g3.getPosicao();
            n3 = g2.getPosicao();
        }
        if (n2 != n3) {
            return n3 - n2;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((g)object, (g)object2);
    }
}

