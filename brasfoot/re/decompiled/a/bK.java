/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bz;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class bK
extends MouseMotionAdapter {
    final /* synthetic */ bz Bq;

    bK(bz bz2) {
        this.Bq = bz2;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        bz.d(this.Bq, mouseEvent);
    }
}

