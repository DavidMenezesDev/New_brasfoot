/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

class em
extends MouseAdapter {
    final /* synthetic */ eg Iz;

    em(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = eg.c(this.Iz).rowAtPoint(mouseEvent.getPoint());
        int n3 = eg.c(this.Iz).columnAtPoint(mouseEvent.getPoint());
        int n4 = mouseEvent.getClickCount();
        if (n4 >= 2) {
            this.Iz.qC();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            Point point = mouseEvent.getPoint();
            int n2 = eg.c(this.Iz).rowAtPoint(point);
            ListSelectionModel listSelectionModel = eg.c(this.Iz).getSelectionModel();
            listSelectionModel.setSelectionInterval(n2, n2);
        }
    }
}

