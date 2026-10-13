/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fK
implements ActionListener {
    final /* synthetic */ fB JH;

    fK(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setAutoRenovaContrato(fB.g(this.JH).isSelected());
        a.vJ();
    }
}

