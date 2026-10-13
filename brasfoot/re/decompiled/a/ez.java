/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ez
implements ActionListener {
    final /* synthetic */ eg Iz;

    ez(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.Hz.show(eg.m(this.Iz), 0, eg.m(this.Iz).getHeight());
    }
}

