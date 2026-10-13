/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iQ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iR
implements ActionListener {
    final /* synthetic */ iQ MZ;

    iR(iQ iQ2) {
        this.MZ = iQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iQ.a(this.MZ).dispose();
    }
}

