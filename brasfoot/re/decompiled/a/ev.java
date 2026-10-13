/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ev
implements ActionListener {
    final /* synthetic */ eg Iz;

    ev(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        eg.g(this.Iz);
    }
}

