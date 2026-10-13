/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import b.A;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class fV
extends MouseAdapter {
    final /* synthetic */ fB JH;

    fV(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = fB.e(this.JH).rowAtPoint(mouseEvent.getPoint());
        int n3 = fB.e(this.JH).columnAtPoint(mouseEvent.getPoint());
        int n4 = mouseEvent.getClickCount();
        if (n4 == 1 && n3 == 0) {
            int n5 = fB.e(this.JH).convertRowIndexToModel(n2);
            ((A)fB.e(this.JH).getModel()).ex(n5);
            fB.e(this.JH).addNotify();
        }
    }
}

