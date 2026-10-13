/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import best.S;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

class iH
extends MouseAdapter {
    final /* synthetic */ iA MV;

    iH(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = iA.k(this.MV).rowAtPoint(mouseEvent.getPoint());
        int n3 = iA.k(this.MV).columnAtPoint(mouseEvent.getPoint());
        int n4 = mouseEvent.getClickCount();
        if (n4 >= 2) {
            S.a(iA.l(this.MV), null);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            Point point = mouseEvent.getPoint();
            int n2 = iA.k(this.MV).rowAtPoint(point);
            ListSelectionModel listSelectionModel = iA.k(this.MV).getSelectionModel();
            listSelectionModel.setSelectionInterval(n2, n2);
        }
    }
}

