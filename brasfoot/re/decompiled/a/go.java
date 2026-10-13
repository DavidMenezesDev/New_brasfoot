/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class go
extends MouseAdapter {
    final /* synthetic */ gl JZ;

    go(gl gl2) {
        this.JZ = gl2;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        gl.a(this.JZ, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        gl.b(this.JZ, mouseEvent);
    }
}

