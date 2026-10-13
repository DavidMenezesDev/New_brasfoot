/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ad
extends MouseAdapter {
    final /* synthetic */ aa wq;

    ad(aa aa2) {
        this.wq = aa2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        aa.a(this.wq, aa.b(this.wq) + 1);
    }
}

