/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iJ
implements ActionListener {
    final /* synthetic */ iA MV;

    iJ(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iA.a(this.MV).dispose();
    }
}

