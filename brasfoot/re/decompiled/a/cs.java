/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cq;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cs
implements ActionListener {
    final /* synthetic */ cq CE;

    cs(cq cq2) {
        this.CE = cq2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cq.b(this.CE);
    }
}

