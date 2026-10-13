/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.v;
import java.io.Serializable;
import java.util.Calendar;

public class B
implements Serializable {
    private static final long serialVersionUID = 1L;
    private v dH = null;
    private Calendar dI = null;
    private int[] dJ = new int[4];

    public v ev() {
        return this.dH;
    }

    public void a(v v2) {
        this.dH = v2;
    }

    public Calendar ew() {
        return this.dI;
    }

    public void c(Calendar calendar) {
        this.dI = calendar;
    }

    public void ex() {
        int n2 = 0;
        while (n2 < this.dJ.length) {
            if (this.dJ[n2] > 0) {
                this.dH.f(n2, this.dJ[n2]);
                this.dJ[n2] = 0;
            }
            ++n2;
        }
    }

    public void c(int[] nArray) {
        this.dJ = nArray;
    }
}

