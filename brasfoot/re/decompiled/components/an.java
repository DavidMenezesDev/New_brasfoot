/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.eg;
import a.iX;
import best.F;
import best.S;
import best.ah;
import best.l;
import c.a;
import java.awt.Dimension;
import javax.swing.JDialog;

public class an {
    private F U;
    private int oq;
    private boolean Rz = false;
    private int RA;
    private ah RB;

    public an(F f2, int n2, boolean bl2, boolean bl3) {
        this.U = f2;
        this.oq = n2;
        int n3 = 0;
        if (!bl3) {
            int n4 = 0;
            while (n4 < a.SR.aN().size()) {
                if (a.SR.aN().get(n4) != f2.fg() && ((ah)a.SR.aN().get(n4)).kb() >= (long)n2) {
                    ++n3;
                }
                ++n4;
            }
        }
        if (n3 == 0) {
            this.Rz = true;
        }
        if (this.uZ()) {
            this.iy();
        }
        if (!bl3) {
            this.vb();
        }
        this.va();
    }

    private boolean uZ() {
        double d2 = eg.qq();
        if (d2 == 0.0) {
            d2 = 0.1;
        }
        int n2 = (int)Math.round((double)this.U.fk() * eg.qq());
        return this.oq <= this.U.fk() + n2;
    }

    private void iy() {
        l l2 = new l(this.U, this.oq, true, false, 0);
        l2.a(false, false);
        this.RB = l2.cK();
        this.RA = l2.cL();
    }

    private void va() {
        if (this.RB != null) {
            this.U.a(this.RB, this.RA, true, false, false);
        }
    }

    private void vb() {
        JDialog jDialog = new JDialog(S.db());
        iX iX2 = new iX(jDialog, this);
        jDialog.add(iX2);
        jDialog.setSize(604, 550);
        jDialog.setPreferredSize(new Dimension(604, 550));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.pack();
        jDialog.setVisible(true);
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

    public boolean vc() {
        return this.Rz;
    }

    public void aE(boolean bl2) {
        this.Rz = bl2;
    }

    public int vd() {
        return this.RA;
    }

    public ah ve() {
        return this.RB;
    }

    public void ei(int n2) {
        this.RA = n2;
    }

    public void I(ah ah2) {
        this.RB = ah2;
    }
}

