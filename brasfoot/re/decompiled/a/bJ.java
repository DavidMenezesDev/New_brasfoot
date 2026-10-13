/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

class bJ
extends MouseAdapter {
    final /* synthetic */ bz Bq;

    bJ(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            bz.a(this.Bq, mouseEvent);
        }
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            bz.b(this.Bq, mouseEvent);
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            bz.c(this.Bq, mouseEvent);
        }
    }
}

