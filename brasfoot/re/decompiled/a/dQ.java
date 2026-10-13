/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dQ
implements ActionListener {
    final /* synthetic */ dN GR;

    dQ(dN dN2) {
        this.GR = dN2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dN.c(this.GR);
    }
}

