/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.an;
import java.util.Comparator;

class ax
implements Comparator {
    ax() {
    }

    public int a(an an2, an an3) {
        int n2;
        int n3 = an2.lX();
        if (n3 != (n2 = an3.lX())) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((an)object, (an)object2);
    }
}

