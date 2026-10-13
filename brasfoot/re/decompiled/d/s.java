/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import d.n;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class s
extends MouseAdapter {
    final /* synthetic */ n Vh;

    s(n n2) {
        this.Vh = n2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = n.g(this.Vh).columnAtPoint(mouseEvent.getPoint());
        String string = n.g(this.Vh).getColumnName(n2);
        if (n2 == 0) {
            ((ap)n.g(this.Vh).getModel()).i(0, false);
            n.g(this.Vh).addNotify();
        } else if (n2 == 2) {
            ((ap)n.g(this.Vh).getModel()).i(2, false);
            n.g(this.Vh).addNotify();
        } else if (n2 == 3) {
            ((ap)n.g(this.Vh).getModel()).i(3, false);
            n.g(this.Vh).addNotify();
        } else if (n2 == 5) {
            ((ap)n.g(this.Vh).getModel()).i(5, false);
            n.g(this.Vh).addNotify();
        }
    }
}

