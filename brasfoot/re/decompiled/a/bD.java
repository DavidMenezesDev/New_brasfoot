/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

class bD
implements ActionListener {
    final /* synthetic */ bz Bq;

    bD(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/alpha3.png"));
        bz.b(this.Bq, true);
        bz.i(this.Bq).dispose();
    }
}

