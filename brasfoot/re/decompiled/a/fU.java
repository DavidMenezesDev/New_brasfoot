/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fU
implements ActionListener {
    final /* synthetic */ fB JH;

    fU(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fB.c(this.JH, 1);
    }
}

