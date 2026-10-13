/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import best.S;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class eZ
extends AbstractAction {
    final /* synthetic */ eg Iz;

    eZ(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        S.a(eg.c(this.Iz));
    }
}

