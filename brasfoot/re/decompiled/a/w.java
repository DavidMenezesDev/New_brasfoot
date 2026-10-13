/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.o;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class w
implements ActionListener {
    final /* synthetic */ o vj;

    w(o o2) {
        this.vj = o2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        o.b(this.vj).dispose();
    }
}

