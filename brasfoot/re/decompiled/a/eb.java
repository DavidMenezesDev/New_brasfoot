/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dV;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class eb
extends AbstractAction {
    final /* synthetic */ dV Hu;

    eb(dV dV2) {
        this.Hu = dV2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dV.a(this.Hu, 3);
    }
}

