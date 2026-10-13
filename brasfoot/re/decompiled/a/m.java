/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.l;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class m
implements ActionListener {
    final /* synthetic */ l uJ;

    m(l l2) {
        this.uJ = l2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        l.a(this.uJ).dispose();
    }
}

