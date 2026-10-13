/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class eA
implements ActionListener {
    final /* synthetic */ eg Iz;

    eA(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.HA.show(eg.n(this.Iz), 0, eg.n(this.Iz).getHeight());
    }
}

