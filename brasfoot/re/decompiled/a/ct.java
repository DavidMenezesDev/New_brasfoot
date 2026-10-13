/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cq;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ct
implements ActionListener {
    final /* synthetic */ cq CE;

    ct(cq cq2) {
        this.CE = cq2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cq.c(this.CE);
    }
}

