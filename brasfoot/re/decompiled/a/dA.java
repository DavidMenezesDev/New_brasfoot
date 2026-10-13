/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dz;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class dA
extends AbstractAction {
    final /* synthetic */ dz Gn;

    dA(dz dz2) {
        this.Gn = dz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dz.a(this.Gn);
    }
}

