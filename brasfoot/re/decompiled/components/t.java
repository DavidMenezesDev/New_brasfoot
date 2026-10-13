/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.F;
import best.ah;
import c.a;
import java.io.Serializable;

public class t
implements Serializable {
    private static final long serialVersionUID = 1L;
    private F U = null;
    private long Pm = 0L;
    private ah Pn = null;
    private boolean Po = false;

    public t() {
    }

    public t(F f2, ah ah2) {
        this.U = f2;
        this.Pn = ah2;
        a.SR.bt().add(this);
        long l2 = 366L;
        this.Pm = a.SR.bc() + (l2 *= 86400000L);
    }

    public boolean tM() {
        return this.Pm < a.SR.bc();
    }

    public boolean tN() {
        boolean bl2 = false;
        if (this.Pn != null) {
            if (this.Pn.jZ().booleanValue()) {
                if (this.Pn.kw() < 35) {
                    this.U.r(this.Pn);
                    bl2 = true;
                }
            } else {
                this.U.r(this.Pn);
                bl2 = true;
            }
        }
        return bl2;
    }

    public F x() {
        return this.U;
    }

    public long tO() {
        return this.Pm;
    }

    public ah tP() {
        return this.Pn;
    }

    public boolean tQ() {
        return this.Po;
    }

    public void au(boolean bl2) {
        this.Po = bl2;
    }
}

