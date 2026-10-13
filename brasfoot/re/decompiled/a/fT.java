/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fT
implements ActionListener {
    final /* synthetic */ fB JH;

    fT(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fB.c(this.JH, 0);
    }
}

