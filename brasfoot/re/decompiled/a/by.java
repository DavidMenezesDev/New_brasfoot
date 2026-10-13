/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class by
extends MouseMotionAdapter {
    final /* synthetic */ bu Ax;

    by(bu bu2) {
        this.Ax = bu2;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        bu.c(this.Ax, mouseEvent);
    }
}

