/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bI
implements ActionListener {
    final /* synthetic */ bz Bq;

    bI(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bz.e(this.Bq).bV(2);
        bz.a(this.Bq, bz.e(this.Bq).kS());
        bz.b(this.Bq, -1);
        bz.c(this.Bq, -1);
    }
}

