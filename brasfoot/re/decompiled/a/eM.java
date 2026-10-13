/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class eM
extends MouseAdapter {
    final /* synthetic */ eg Iz;

    eM(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.Iz.G(eg.p(this.Iz));
    }
}

