/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hz;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class hA
extends AbstractAction {
    final /* synthetic */ hz LA;

    hA(hz hz2) {
        this.LA = hz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hz.a(this.LA).dispose();
    }
}

