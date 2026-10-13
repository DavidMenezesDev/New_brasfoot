/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fM
implements ActionListener {
    final /* synthetic */ fB JH;

    fM(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setUsaSons(fB.i(this.JH).isSelected());
        a.vJ();
    }
}

