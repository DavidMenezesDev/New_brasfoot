/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.C;
import a.dV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class E
implements ActionListener {
    final /* synthetic */ C vs;

    E(C c2) {
        this.vs = c2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dV.a(C.a(this.vs), C.b(this.vs));
        C.c(this.vs).dispose();
    }
}

