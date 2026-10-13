/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bd
implements ActionListener {
    final /* synthetic */ bb zy;

    bd(bb bb2) {
        this.zy = bb2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bb.b(this.zy).dispose();
    }
}

