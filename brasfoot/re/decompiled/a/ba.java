/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aX;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ba
extends MouseAdapter {
    final /* synthetic */ aX zt;

    ba(aX aX2) {
        this.zt = aX2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        aX.a(this.zt, mouseEvent.getComponent());
    }
}

