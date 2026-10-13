/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bt
implements ActionListener {
    final /* synthetic */ bs Ar;

    bt(bs bs2) {
        this.Ar = bs2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bs.a(this.Ar).dispose();
    }
}

