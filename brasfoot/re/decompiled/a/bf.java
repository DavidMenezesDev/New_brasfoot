/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bb;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class bf
extends MouseAdapter {
    final /* synthetic */ bb zy;

    bf(bb bb2) {
        this.zy = bb2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        bb.a(this.zy, mouseEvent.getComponent());
    }
}

