/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iQ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iT
implements ActionListener {
    final /* synthetic */ iQ MZ;

    iT(iQ iQ2) {
        this.MZ = iQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iQ.d(this.MZ);
    }
}

