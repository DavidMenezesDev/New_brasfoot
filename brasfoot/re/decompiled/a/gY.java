/*
 * Decompiled with CFR 0.152.
 */
package a;

import best.al;
import java.util.Comparator;

class gY
implements Comparator {
    gY() {
    }

    public int b(al al2, al al3) {
        int n2;
        int n3 = al2.getReputacao();
        if (n3 != (n2 = al3.getReputacao())) {
            return n2 - n3;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.b((al)object, (al)object2);
    }
}

