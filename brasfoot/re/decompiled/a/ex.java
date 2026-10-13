/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ex
implements ActionListener {
    final /* synthetic */ eg Iz;

    ex(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        eg.i(this.Iz).show(eg.j(this.Iz), 0, eg.j(this.Iz).getHeight());
    }
}

