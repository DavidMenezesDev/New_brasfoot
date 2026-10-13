/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fs
implements ActionListener {
    final /* synthetic */ eg Iz;

    fs(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.do(1);
    }
}

