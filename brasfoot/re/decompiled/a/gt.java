/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gq;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gt
extends MouseAdapter {
    final /* synthetic */ gq Ke;

    gt(gq gq2) {
        this.Ke = gq2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        gq.e(this.Ke);
    }
}

