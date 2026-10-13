/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.R;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class S
implements ActionListener {
    final /* synthetic */ R vR;

    S(R r2) {
        this.vR = r2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        R.a(this.vR).dispose();
    }
}

