/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cX
implements ActionListener {
    final /* synthetic */ cW Ee;

    cX(cW cW2) {
        this.Ee = cW2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cW.a(this.Ee).dispose();
    }
}

