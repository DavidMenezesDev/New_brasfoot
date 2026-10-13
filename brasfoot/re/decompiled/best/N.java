/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.ah;
import best.l;
import c.a;
import java.util.ArrayList;
import java.util.Collections;

public class N {
    ah gD = null;
    F gE = null;

    public N() {
        this.ix();
        if (this.gE != null) {
            this.iy();
        }
    }

    private void ix() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a.SR.P());
        Collections.shuffle(arrayList);
        int n2 = 0;
        while (n2 < arrayList.size()) {
            F f2;
            if (!((ah)arrayList.get(n2)).jZ().booleanValue() && ((ah)arrayList.get(n2)).kw() >= 21 && (f2 = ((ah)arrayList.get(n2)).kv()) != null) {
                this.gE = f2;
                break;
            }
            ++n2;
        }
    }

    private void iy() {
        l l2 = new l(this.gE, this.gE.fk(), true, false, 0);
        l2.a(false, false);
        this.gD = l2.cK();
    }

    public ah iz() {
        return this.gD;
    }

    public F iA() {
        return this.gE;
    }
}

