/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cO
implements ActionListener {
    final /* synthetic */ cD DI;

    cO(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cD.f(this.DI);
    }
}

