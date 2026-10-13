/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cZ
implements ActionListener {
    final /* synthetic */ cW Ee;

    cZ(cW cW2) {
        this.Ee = cW2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cW.a(this.Ee, -1);
    }
}

