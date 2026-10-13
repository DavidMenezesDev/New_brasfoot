/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class co
implements ActionListener {
    final /* synthetic */ cl Cm;

    co(cl cl2) {
        this.Cm = cl2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cl.c(this.Cm);
    }
}

