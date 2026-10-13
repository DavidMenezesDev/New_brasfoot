/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hU;
import b.P;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class hV
extends MouseAdapter {
    final /* synthetic */ hU MA;

    hV(hU hU2) {
        this.MA = hU2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = hU.a(this.MA).rowAtPoint(mouseEvent.getPoint());
        int n3 = hU.a(this.MA).columnAtPoint(mouseEvent.getPoint());
        int n4 = mouseEvent.getClickCount();
        if (n4 == 1 && n3 == 0) {
            int n5 = hU.a(this.MA).convertRowIndexToModel(n2);
            ((P)hU.a(this.MA).getModel()).ex(n5);
            hU.a(this.MA).addNotify();
        }
    }
}

