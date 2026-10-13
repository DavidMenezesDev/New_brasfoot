/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.n;
import d.ac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class ad
implements ActionListener {
    final /* synthetic */ ac VG;

    ad(ac ac2) {
        this.VG = ac2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ac.a(this.VG).clear();
        if (!ac.b(this.VG)) {
            this.VG.xc();
        } else {
            this.VG.xd();
        }
        if (ac.a(this.VG).size() == 0) {
            n.da().wo();
            n.da().Uw.dispose();
        } else {
            JOptionPane.showMessageDialog(null, ac.a(this.VG).get(0), "", 0);
        }
    }
}

