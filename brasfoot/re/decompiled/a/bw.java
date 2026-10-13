/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bu;
import components.Y;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bw
implements ActionListener {
    final /* synthetic */ bu Ax;

    bw(bu bu2) {
        this.Ax = bu2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Y)bu.a(this.Ax)).X(true);
    }
}

