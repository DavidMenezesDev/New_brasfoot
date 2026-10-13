/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class O
implements ActionListener {
    final /* synthetic */ L vO;

    O(L l2) {
        this.vO = l2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        L.a(this.vO).dispose();
    }
}

