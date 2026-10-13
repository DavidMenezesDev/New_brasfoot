/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ey
implements ActionListener {
    final /* synthetic */ eg Iz;

    ey(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        eg.k(this.Iz).show(eg.l(this.Iz), 0, eg.l(this.Iz).getHeight());
    }
}

