/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gq;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gu
extends MouseAdapter {
    final /* synthetic */ gq Ke;

    gu(gq gq2) {
        this.Ke = gq2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        gq.f(this.Ke).setCursor(new Cursor(3));
        gq.g(this.Ke);
        gq.f(this.Ke).setCursor(new Cursor(12));
    }
}

