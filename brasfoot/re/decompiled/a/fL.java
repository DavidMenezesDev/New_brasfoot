/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fL
implements ActionListener {
    final /* synthetic */ fB JH;

    fL(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setUsaCorPlacar(fB.h(this.JH).isSelected());
        a.vJ();
    }
}

