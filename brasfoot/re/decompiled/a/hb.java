/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hb
implements ActionListener {
    final /* synthetic */ gX KE;

    hb(gX gX2) {
        this.KE = gX2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gX.b(this.KE).dispose();
    }
}

