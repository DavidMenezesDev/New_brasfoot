/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class fk
extends AbstractAction {
    final /* synthetic */ eg Iz;

    fk(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Iz.ad(false);
    }
}

