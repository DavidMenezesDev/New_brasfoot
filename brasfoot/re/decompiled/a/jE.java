/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jE
implements ActionListener {
    final /* synthetic */ gX KE;

    jE(gX gX2) {
        this.KE = gX2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gX.c(this.KE);
    }
}

