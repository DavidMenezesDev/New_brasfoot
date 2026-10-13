/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fl
implements ActionListener {
    final /* synthetic */ eg Iz;

    fl(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.rl();
    }
}

