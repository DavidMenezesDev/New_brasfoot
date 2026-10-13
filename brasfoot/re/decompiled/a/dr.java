/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dq;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dr
implements ActionListener {
    final /* synthetic */ dq FK;

    dr(dq dq2) {
        this.FK = dq2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dq.a(this.FK).dispose();
    }
}

