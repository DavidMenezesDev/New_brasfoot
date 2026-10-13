/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jt
implements ActionListener {
    final /* synthetic */ eg Iz;

    jt(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        eg.b(this.Iz, actionEvent);
    }
}

