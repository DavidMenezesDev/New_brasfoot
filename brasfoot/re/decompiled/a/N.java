/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class N
implements ActionListener {
    final /* synthetic */ L vO;

    N(L l2) {
        this.vO = l2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (L.b(this.vO).getSelectedIndex() >= 0) {
            L.a(this.vO, L.b(this.vO).getSelectedIndex());
        }
    }
}

