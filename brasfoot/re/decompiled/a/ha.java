/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ha
implements ActionListener {
    final /* synthetic */ gX KE;

    ha(gX gX2) {
        this.KE = gX2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gX.a(this.KE);
    }
}

