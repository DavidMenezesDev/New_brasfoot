/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class iI
extends AbstractAction {
    final /* synthetic */ iA MV;

    iI(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iA.a(this.MV).dispose();
    }
}

