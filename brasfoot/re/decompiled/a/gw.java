/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dJ;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gw
extends MouseAdapter {
    final /* synthetic */ dJ aeK;

    gw(dJ dJ2) {
        this.aeK = dJ2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        dJ.a(this.aeK).dispose();
    }
}

