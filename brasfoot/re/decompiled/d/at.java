/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import e.g;
import java.util.Comparator;

class at
implements Comparator {
    at() {
    }

    public int a(g g2, g g3) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (ap.xj() == 0) {
            n2 = g2.getStatus();
            n3 = g3.getStatus();
        } else {
            n2 = g3.getStatus();
            n3 = g2.getStatus();
        }
        n4 = g2.getPosicao();
        n5 = g2.getPosicao();
        if (n2 != n3) {
            return n3 - n2;
        }
        if (n4 != n5) {
            return n5 - n4;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((g)object, (g)object2);
    }
}

