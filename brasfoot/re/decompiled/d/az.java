/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ay;
import e.t;
import java.util.Comparator;

class az
implements Comparator {
    az() {
    }

    public int a(t t2, t t3) {
        int n2 = 0;
        int n3 = 0;
        if (ay.vG() == 0) {
            n2 = t2.getNivel();
            n3 = t3.getNivel();
        } else {
            n2 = t3.getNivel();
            n3 = t2.getNivel();
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

