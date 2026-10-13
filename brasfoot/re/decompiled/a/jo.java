/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jo
implements ActionListener {
    final /* synthetic */ jm Ny;

    jo(jm jm2) {
        this.Ny = jm2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jm.b(this.Ny).dispose();
    }
}

