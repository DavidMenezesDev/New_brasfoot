/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gl;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class gp
extends MouseMotionAdapter {
    final /* synthetic */ gl JZ;

    gp(gl gl2) {
        this.JZ = gl2;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        gl.c(this.JZ, mouseEvent);
    }
}

