/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.h;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class i
implements ActionListener {
    final /* synthetic */ h uy;

    i(h h3) {
        this.uy = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        h.a(this.uy).dispose();
    }
}

