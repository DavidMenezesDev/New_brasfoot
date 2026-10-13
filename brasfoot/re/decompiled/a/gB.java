/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gx;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gB
extends MouseAdapter {
    final /* synthetic */ gx Kg;

    gB(gx gx2) {
        this.Kg = gx2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = gx.c(this.Kg).rowAtPoint(mouseEvent.getPoint());
        int n3 = gx.c(this.Kg).columnAtPoint(mouseEvent.getPoint());
        if (mouseEvent.getClickCount() == 2) {
            this.Kg.rQ();
        }
    }
}

