/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dN;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dR
implements ActionListener {
    final /* synthetic */ dN GR;

    dR(dN dN2) {
        this.GR = dN2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.c(dN.d(this.GR), false);
        dN.a(this.GR).dispose();
    }
}

