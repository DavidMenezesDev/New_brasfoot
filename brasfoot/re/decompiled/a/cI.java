/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class cI
extends MouseAdapter {
    final /* synthetic */ cD DI;

    cI(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        cD.a(this.DI, 2);
    }
}

