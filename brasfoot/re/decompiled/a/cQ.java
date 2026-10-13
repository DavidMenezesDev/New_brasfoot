/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class cQ
extends MouseMotionAdapter {
    final /* synthetic */ cD DI;

    cQ(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        cD.b(this.DI, mouseEvent, 0);
    }
}

