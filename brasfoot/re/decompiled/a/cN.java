/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cN
implements ActionListener {
    final /* synthetic */ cD DI;

    cN(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cD.e(this.DI);
    }
}

