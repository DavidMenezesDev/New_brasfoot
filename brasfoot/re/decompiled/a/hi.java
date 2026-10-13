/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hi
implements ActionListener {
    final /* synthetic */ hc KL;

    hi(hc hc2) {
        this.KL = hc2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hc.a(this.KL, hc.d(this.KL).getSelectedIndex());
    }
}

