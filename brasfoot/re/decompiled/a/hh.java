/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hh
implements ActionListener {
    final /* synthetic */ hc KL;

    hh(hc hc2) {
        this.KL = hc2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hc.c(this.KL);
    }
}

