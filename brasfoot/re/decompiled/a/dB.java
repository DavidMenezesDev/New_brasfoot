/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dz;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dB
extends MouseAdapter {
    final /* synthetic */ dz Gn;

    dB(dz dz2) {
        this.Gn = dz2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        dz.a(this.Gn);
    }
}

