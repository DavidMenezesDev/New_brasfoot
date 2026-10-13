/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gP
implements ActionListener {
    final /* synthetic */ gO Kz;

    gP(gO gO2) {
        this.Kz = gO2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gO.a(this.Kz);
        gO.b(this.Kz).dispose();
    }
}

