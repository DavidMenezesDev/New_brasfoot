/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class iP
extends MouseAdapter {
    final /* synthetic */ iA MV;

    iP(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        iA.f(this.MV);
    }
}

