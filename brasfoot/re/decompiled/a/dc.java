/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.da;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dc
implements ActionListener {
    final /* synthetic */ da El;

    dc(da da2) {
        this.El = da2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        da.b(this.El);
    }
}

