/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class du
implements ActionListener {
    final /* synthetic */ ds FS;

    du(ds ds2) {
        this.FS = ds2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ds.b(this.FS).dispose();
    }
}

