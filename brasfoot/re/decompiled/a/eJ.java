/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class eJ
extends MouseAdapter {
    final /* synthetic */ eg Iz;

    eJ(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        eg.b(this.Iz);
    }
}

