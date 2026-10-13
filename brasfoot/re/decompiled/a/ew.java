/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ew
implements ActionListener {
    final /* synthetic */ eg Iz;

    ew(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.Hy.show(eg.h(this.Iz), 0, eg.h(this.Iz).getHeight());
    }
}

