/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import components.ao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bO
implements ActionListener {
    final /* synthetic */ bz Bq;

    bO(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bz.b(this.Bq, ((ao)bz.a(this.Bq).get(bz.b(this.Bq))).x());
    }
}

