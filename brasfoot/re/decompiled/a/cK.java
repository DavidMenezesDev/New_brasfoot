/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class cK
extends AbstractAction {
    final /* synthetic */ cD DI;

    cK(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cD.b(this.DI);
    }
}

