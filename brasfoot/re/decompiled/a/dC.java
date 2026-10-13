/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dz;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dC
extends MouseAdapter {
    final /* synthetic */ dz Gn;

    dC(dz dz2) {
        this.Gn = dz2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        dz.b(this.Gn);
    }
}

