/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dx
implements ActionListener {
    final /* synthetic */ ds FS;

    dx(ds ds2) {
        this.FS = ds2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ds.c(this.FS);
    }
}

