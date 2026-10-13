/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dV;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dX
extends MouseAdapter {
    final /* synthetic */ dV Hu;

    dX(dV dV2) {
        this.Hu = dV2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (dV.c(this.Hu) >= 0) {
            dV.b(this.Hu, dV.c(this.Hu));
        }
    }
}

