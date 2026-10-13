/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.n;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C
extends MouseAdapter {
    final /* synthetic */ n Vh;

    C(n n2) {
        this.Vh = n2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() >= 2 && n.f(this.Vh) != null) {
            this.Vh.wA();
        }
    }
}

