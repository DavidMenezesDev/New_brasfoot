/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gq;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gs
extends MouseAdapter {
    final /* synthetic */ gq Ke;

    gs(gq gq2) {
        this.Ke = gq2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        gq.c(this.Ke).setCursor(new Cursor(3));
        gq.d(this.Ke);
        gq.c(this.Ke).setCursor(new Cursor(12));
    }
}

