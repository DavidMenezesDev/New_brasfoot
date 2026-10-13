/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class F
implements ActionListener {
    final /* synthetic */ C vs;

    F(C c2) {
        this.vs = c2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        C.a(this.vs, 1);
    }
}

