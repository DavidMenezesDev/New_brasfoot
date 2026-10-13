/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fC
implements ActionListener {
    final /* synthetic */ fB JH;

    fC(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fB.a(this.JH);
        fB.b(this.JH).dispose();
    }
}

