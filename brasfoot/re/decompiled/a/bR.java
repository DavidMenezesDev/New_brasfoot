/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bR
implements ActionListener {
    final /* synthetic */ bz Bq;

    bR(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bz.c(this.Bq).getSelectedIndex() > 0) {
            bz.a(this.Bq, bz.c(this.Bq).getSelectedIndex() - 1);
        }
    }
}

