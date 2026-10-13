/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bB
implements ActionListener {
    final /* synthetic */ bz Bq;

    bB(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bz.a(this.Bq, !bz.h(this.Bq));
        this.Bq.oe();
    }
}

