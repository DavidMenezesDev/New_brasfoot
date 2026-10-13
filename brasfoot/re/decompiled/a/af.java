/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class af
extends MouseAdapter {
    final /* synthetic */ aa wq;

    af(aa aa2) {
        this.wq = aa2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        aa.b(this.wq, aa.c(this.wq) - 1);
    }
}

