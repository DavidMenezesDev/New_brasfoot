/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.Y;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Z
extends MouseAdapter {
    final /* synthetic */ Y QX;

    Z(Y y2) {
        this.QX = y2;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Y.a(this.QX, mouseEvent);
    }
}

