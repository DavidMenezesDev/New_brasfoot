/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gI
implements ActionListener {
    final /* synthetic */ gE aeO;

    gI(gE gE2) {
        this.aeO = gE2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (gE.f(this.aeO) != null) {
            gE.g(this.aeO);
        }
    }
}

