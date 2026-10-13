/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import components.ao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bL
implements ActionListener {
    final /* synthetic */ bz Bq;

    bL(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bz.a(this.Bq, ((ao)bz.a(this.Bq).get(bz.b(this.Bq))).x());
    }
}

