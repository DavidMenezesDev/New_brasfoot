/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gq;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gr
extends MouseAdapter {
    final /* synthetic */ gq Ke;

    gr(gq gq2) {
        this.Ke = gq2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        gq.a(this.Ke).setCursor(new Cursor(3));
        gq.b(this.Ke);
        gq.a(this.Ke).setCursor(new Cursor(12));
    }
}

