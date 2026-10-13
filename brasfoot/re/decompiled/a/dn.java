/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dn
implements ActionListener {
    final /* synthetic */ dm Ft;

    dn(dm dm2) {
        this.Ft = dm2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dm.a(this.Ft).dispose();
    }
}

