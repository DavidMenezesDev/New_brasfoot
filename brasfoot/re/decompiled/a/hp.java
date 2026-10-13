/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hk;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class hp
extends AbstractAction {
    final /* synthetic */ hk Lt;

    hp(hk hk2) {
        this.Lt = hk2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hk.a(this.Lt);
    }
}

