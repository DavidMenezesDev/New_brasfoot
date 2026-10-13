/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dh
implements ActionListener {
    final /* synthetic */ dg EP;

    dh(dg dg2) {
        this.EP = dg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dg.a(this.EP).dispose();
    }
}

