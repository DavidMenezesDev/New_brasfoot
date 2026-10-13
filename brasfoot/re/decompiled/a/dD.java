/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dz;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dD
extends MouseAdapter {
    final /* synthetic */ dz Gn;

    dD(dz dz2) {
        this.Gn = dz2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        dz.c(this.Gn);
    }
}

