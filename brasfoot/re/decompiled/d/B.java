/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import d.n;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

class B
extends MouseAdapter {
    final /* synthetic */ n Vh;

    B(n n2) {
        this.Vh = n2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = n.g(this.Vh).rowAtPoint(mouseEvent.getPoint());
        int n3 = n.g(this.Vh).columnAtPoint(mouseEvent.getPoint());
        int n4 = mouseEvent.getClickCount();
        if (n4 == 1 && n3 == 0) {
            int n5 = n.e(this.Vh) ? n.f(this.Vh).getNumeroTitulares() : n.f(this.Vh).getNumeroTitularesJuniores();
            int n6 = n.g(this.Vh).convertRowIndexToModel(n2);
            ((ap)n.g(this.Vh).getModel()).Z(n6, n5);
            this.Vh.wo();
            n.g(this.Vh).addNotify();
            if (n.e(this.Vh)) {
                n.m(this.Vh).setText(Integer.toString(n.f(this.Vh).getNumeroTitulares()));
            } else {
                n.m(this.Vh).setText(Integer.toString(n.f(this.Vh).getNumeroTitularesJuniores()));
            }
        } else if (n4 >= 2) {
            this.Vh.wC();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            Point point = mouseEvent.getPoint();
            int n2 = n.g(this.Vh).rowAtPoint(point);
            ListSelectionModel listSelectionModel = n.g(this.Vh).getSelectionModel();
            listSelectionModel.setSelectionInterval(n2, n2);
        }
    }
}

