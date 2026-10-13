/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dw
implements ActionListener {
    final /* synthetic */ ds FS;

    dw(ds ds2) {
        this.FS = ds2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.FS.pM();
    }
}

