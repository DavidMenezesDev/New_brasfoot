/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bT
implements ActionListener {
    final /* synthetic */ bz Bq;

    bT(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bz.f(this.Bq).getSelectedIndex() >= 0) {
            bz.e((bz)this.Bq).kj()[2] = bz.f(this.Bq).getSelectedIndex();
        }
    }
}

