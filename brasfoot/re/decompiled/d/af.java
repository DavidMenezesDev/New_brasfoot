/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.n;
import d.ac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class af
implements ActionListener {
    final /* synthetic */ ac VG;

    af(ac ac2) {
        this.VG = ac2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (n.H(ac.c(this.VG).getSelectedIndex()) == 29) {
            ac.d(this.VG).setVisible(true);
            ac.e(this.VG).setVisible(true);
        } else {
            ac.d(this.VG).setVisible(false);
            ac.e(this.VG).setVisible(false);
        }
    }
}

