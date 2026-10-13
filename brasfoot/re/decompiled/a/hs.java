/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hs
implements ActionListener {
    final /* synthetic */ hk Lt;

    hs(hk hk2) {
        this.Lt = hk2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (hk.b(this.Lt).getSelectedIndex() >= 0) {
            hk.a(this.Lt, hk.b(this.Lt).getSelectedIndex());
        }
    }
}

