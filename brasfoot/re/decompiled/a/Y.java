/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.R;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Y
implements ActionListener {
    final /* synthetic */ R vR;

    Y(R r2) {
        this.vR = r2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (R.b(this.vR).getSelectedIndex() >= 0) {
            R.b(this.vR, R.b(this.vR).getSelectedIndex());
        }
    }
}

