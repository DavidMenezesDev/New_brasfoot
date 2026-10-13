/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.f;
import c.a;
import java.io.Serializable;
import java.util.ArrayList;

public class ap
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int d = 0;
    private int on = 0;
    private int y = 0;
    private transient F U = null;
    private int ei = -1;
    private int ej = -1;
    private int oo = -1;
    private int op = -1;
    private int oq = 0;

    public int getY() {
        return this.y;
    }

    public void cp(int n2) {
        this.y = n2;
    }

    public void f(int n2, int n3, int n4) {
        this.d = n2;
        this.on = n3 + 1;
        this.y = n4;
    }

    public F x() {
        return this.U;
    }

    public void a(F f2) {
        this.U = f2;
    }

    public int lY() {
        return this.oq;
    }

    public void cq(int n2) {
        this.oq = n2;
    }

    public String f() {
        return String.valueOf(Integer.toString(this.d)) + "/" + Integer.toString(this.on) + "/" + Integer.toString(this.y);
    }

    public int lZ() {
        return this.op;
    }

    public void cr(int n2) {
        this.op = n2;
    }

    public int ma() {
        return this.oo;
    }

    public void cs(int n2) {
        this.oo = n2;
    }

    public int gD() {
        return this.ei;
    }

    public void mb() {
        if (this.U != null) {
            this.ei = this.U.gD();
            this.ej = this.U.gI();
        } else {
            this.ei = -1;
        }
    }

    public String mc() {
        return f.z(this.oo);
    }

    public String md() {
        return f.z(this.op);
    }

    public void me() {
        if (this.ei >= 0) {
            ArrayList arrayList = null;
            if (this.ej == 1) {
                arrayList = a.SR.O();
            } else if (this.ej == 2) {
                arrayList = a.SR.Q();
            }
            if (arrayList != null) {
                int n2 = 0;
                while (n2 < arrayList.size()) {
                    if (this.ei == ((F)arrayList.get(n2)).gD()) {
                        this.U = (F)arrayList.get(n2);
                        break;
                    }
                    ++n2;
                }
            }
        }
    }
}

