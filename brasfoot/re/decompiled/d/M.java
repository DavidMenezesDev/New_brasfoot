/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.n;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class M
implements ActionListener {
    final /* synthetic */ n Vh;

    M(n n2) {
        this.Vh = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.Vh.wp();
    }
}

