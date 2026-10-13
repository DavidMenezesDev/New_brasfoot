/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bS
implements ActionListener {
    final /* synthetic */ bz Bq;

    bS(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bz.d(this.Bq).getSelectedIndex() >= 0) {
            bz.e((bz)this.Bq).kj()[1] = bz.d(this.Bq).getSelectedIndex();
        }
    }
}

