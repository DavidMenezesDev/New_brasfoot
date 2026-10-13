/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dV;
import components.v;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ef
extends MouseAdapter {
    final /* synthetic */ dV Hu;

    ef(dV dV2) {
        this.Hu = dV2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2 = dV.b(this.Hu).rowAtPoint(mouseEvent.getPoint());
        if (n2 >= 0 && ((v)dV.qo().get(n2)).tR() != null) {
            dV.b(this.Hu, n2);
        }
    }
}

