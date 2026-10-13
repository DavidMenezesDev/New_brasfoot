/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class fI
extends MouseAdapter {
    final /* synthetic */ fB JH;

    fI(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        fB.b(this.JH, 4);
    }
}

