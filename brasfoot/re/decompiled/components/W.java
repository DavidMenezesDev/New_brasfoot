/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.V;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class W
extends MouseAdapter {
    final /* synthetic */ V QV;

    W(V v2) {
        this.QV = v2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        V.a(this.QV);
    }
}

