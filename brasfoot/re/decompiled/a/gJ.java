/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gJ
implements ActionListener {
    final /* synthetic */ gE aeO;

    gJ(gE gE2) {
        this.aeO = gE2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (gE.f(this.aeO) != null) {
            gE.h(this.aeO);
        }
    }
}

