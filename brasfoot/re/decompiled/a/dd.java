/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.da;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dd
implements ActionListener {
    final /* synthetic */ da El;

    dd(da da2) {
        this.El = da2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        da.c(this.El);
    }
}

