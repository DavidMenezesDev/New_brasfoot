/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iQ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iU
implements ActionListener {
    final /* synthetic */ iQ MZ;

    iU(iQ iQ2) {
        this.MZ = iQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iQ.d(this.MZ);
    }
}

