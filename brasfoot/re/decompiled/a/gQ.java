/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gQ
implements ActionListener {
    final /* synthetic */ gO Kz;

    gQ(gO gO2) {
        this.Kz = gO2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gO.b(this.Kz).dispose();
    }
}

