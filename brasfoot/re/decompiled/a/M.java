/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class M
extends AbstractAction {
    final /* synthetic */ L vO;

    M(L l2) {
        this.vO = l2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        L.a(this.vO).dispose();
    }
}

