/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iC
implements ActionListener {
    final /* synthetic */ iA MV;

    iC(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iA.g(this.MV);
    }
}

