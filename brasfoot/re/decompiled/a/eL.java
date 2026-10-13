/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class eL
extends MouseAdapter {
    final /* synthetic */ eg Iz;

    eL(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.Iz.rh();
    }
}

