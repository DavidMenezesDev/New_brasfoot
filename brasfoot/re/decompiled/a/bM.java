/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class bM
extends MouseAdapter {
    final /* synthetic */ bz Bq;

    bM(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        bz.b(this.Bq, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        bz.c(this.Bq, mouseEvent);
    }
}

