/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cT
implements ActionListener {
    final /* synthetic */ cR DV;

    cT(cR cR2) {
        this.DV = cR2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cR.a(this.DV);
    }
}

