/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aQ
implements ActionListener {
    final /* synthetic */ aP zl;

    aQ(aP aP2) {
        this.zl = aP2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aP.a(this.zl);
    }
}

