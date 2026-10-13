/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class P
extends MouseAdapter {
    final /* synthetic */ L vO;

    P(L l2) {
        this.vO = l2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            this.vO.mZ();
        }
    }
}

