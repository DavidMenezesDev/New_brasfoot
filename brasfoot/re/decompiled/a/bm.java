/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bm
implements ActionListener {
    final /* synthetic */ bl zW;

    bm(bl bl2) {
        this.zW = bl2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bl.a(this.zW).dispose();
    }
}

