/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.H;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class J
implements ActionListener {
    final /* synthetic */ H vJ;

    J(H h3) {
        this.vJ = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        H.c(this.vJ);
    }
}

