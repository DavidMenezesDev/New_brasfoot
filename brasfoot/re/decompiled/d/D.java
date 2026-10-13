/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.n;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class D
extends MouseAdapter {
    final /* synthetic */ n Vh;

    D(n n2) {
        this.Vh = n2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.Vh.wA();
    }
}

