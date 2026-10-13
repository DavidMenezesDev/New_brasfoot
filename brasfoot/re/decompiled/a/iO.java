/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iO
implements ActionListener {
    final /* synthetic */ iA MV;

    iO(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iA.e(this.MV);
    }
}

