/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.R;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Z
implements ActionListener {
    final /* synthetic */ R vR;

    Z(R r2) {
        this.vR = r2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (R.c(this.vR).getSelectedIndex() >= 0) {
            R.d(this.vR);
        }
    }
}

