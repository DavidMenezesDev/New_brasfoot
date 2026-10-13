/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bq
implements ActionListener {
    final /* synthetic */ bn Ae;

    bq(bn bn2) {
        this.Ae = bn2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bn.a(this.Ae, 2);
    }
}

