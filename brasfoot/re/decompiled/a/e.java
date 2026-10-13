/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.d;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class e
implements ActionListener {
    final /* synthetic */ d ux;

    e(d d2) {
        this.ux = d2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        d.a(this.ux).dispose();
    }
}

