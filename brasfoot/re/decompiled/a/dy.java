/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dy
implements ActionListener {
    final /* synthetic */ ds FS;

    dy(ds ds2) {
        this.FS = ds2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ds.d(this.FS);
    }
}

