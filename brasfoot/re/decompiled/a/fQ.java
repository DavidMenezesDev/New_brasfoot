/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fQ
implements ActionListener {
    final /* synthetic */ fB JH;

    fQ(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setVerEstaduaisAgrupados(fB.m(this.JH).isSelected());
        a.vJ();
    }
}

