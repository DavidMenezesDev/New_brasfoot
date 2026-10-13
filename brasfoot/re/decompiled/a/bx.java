/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class bx
extends MouseAdapter {
    final /* synthetic */ bu Ax;

    bx(bu bu2) {
        this.Ax = bu2;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        bu.a(this.Ax, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        bu.b(this.Ax, mouseEvent);
    }
}

