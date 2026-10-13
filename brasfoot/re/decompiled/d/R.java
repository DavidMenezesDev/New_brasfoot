/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import d.n;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

class R
implements ActionListener {
    final /* synthetic */ n Vh;

    R(n n2) {
        this.Vh = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        n.b(this.Vh).setIcon(new ImageIcon(this.getClass().getResource("/aicons/greencheck.png")));
        n.c(this.Vh).setIcon(null);
        n.d(this.Vh).setText("");
        if (!n.e(this.Vh)) {
            n.a(this.Vh, true);
            ap ap2 = new ap();
            best.n.da().wJ().setModel(ap2);
            best.n.da().wH();
            if (n.f(this.Vh).getJogadores().size() > 0) {
                best.n.da().wJ().setRowSelectionInterval(0, 0);
            }
            this.Vh.wq();
            n.g(this.Vh).addNotify();
        }
    }
}

