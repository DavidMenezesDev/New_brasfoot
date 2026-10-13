/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aU
implements ActionListener {
    final /* synthetic */ aP zl;

    aU(aP aP2) {
        this.zl = aP2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aP.e(this.zl);
    }
}

