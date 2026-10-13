/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hE
implements ActionListener {
    final /* synthetic */ hC LD;

    hE(hC hC2) {
        this.LD = hC2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hC.c(this.LD).dispose();
    }
}

