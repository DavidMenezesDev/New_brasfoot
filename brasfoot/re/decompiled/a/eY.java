/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class eY
implements ActionListener {
    final /* synthetic */ eg Iz;

    eY(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        eg.v(this.Iz);
    }
}

