/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ja
implements ActionListener {
    final /* synthetic */ iX Nj;

    ja(iX iX2) {
        this.Nj = iX2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iX.c(this.Nj);
    }
}

