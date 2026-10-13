/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gK
implements ActionListener {
    final /* synthetic */ gE aeO;

    gK(gE gE2) {
        this.aeO = gE2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (gE.f(this.aeO) != null) {
            gE.i(this.aeO);
        }
    }
}

