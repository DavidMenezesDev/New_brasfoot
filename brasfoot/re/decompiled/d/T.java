/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.n;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class T
implements ActionListener {
    final /* synthetic */ n Vh;

    T(n n2) {
        this.Vh = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        n.h(this.Vh);
    }
}

