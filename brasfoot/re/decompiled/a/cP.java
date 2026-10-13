/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

class cP
extends MouseAdapter {
    final /* synthetic */ cD DI;

    cP(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            cD.a(this.DI, mouseEvent);
        }
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            cD.b(this.DI, mouseEvent);
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            cD.a(this.DI, mouseEvent, 0);
        }
    }
}

