/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cV
implements ActionListener {
    final /* synthetic */ cR DV;

    cV(cR cR2) {
        this.DV = cR2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.DV.pm();
    }
}

