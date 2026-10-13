/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gm
implements ActionListener {
    final /* synthetic */ gl JZ;

    gm(gl gl2) {
        this.JZ = gl2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gl.a(this.JZ).setVisible(false);
    }
}

