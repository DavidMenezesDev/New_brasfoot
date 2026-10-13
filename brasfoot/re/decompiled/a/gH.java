/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gH
implements ActionListener {
    final /* synthetic */ gE aeO;

    gH(gE gE2) {
        this.aeO = gE2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gE.e(this.aeO).dispose();
    }
}

