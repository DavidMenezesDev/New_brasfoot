/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ek
extends AbstractAction {
    final /* synthetic */ eg Iz;

    ek(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.rl();
    }
}

