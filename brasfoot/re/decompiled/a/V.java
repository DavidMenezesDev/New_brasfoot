/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.R;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class V
implements ActionListener {
    final /* synthetic */ R vR;

    V(R r2) {
        this.vR = r2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        R.a(this.vR, 2);
    }
}

