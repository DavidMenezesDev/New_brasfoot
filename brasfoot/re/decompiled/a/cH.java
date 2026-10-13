/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class cH
extends MouseAdapter {
    final /* synthetic */ cD DI;

    cH(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        cD.a(this.DI, 1);
    }
}

