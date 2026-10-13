/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iE
implements ActionListener {
    final /* synthetic */ iA MV;

    iE(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iA.i(this.MV);
    }
}

