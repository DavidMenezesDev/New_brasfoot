/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fP
implements ActionListener {
    final /* synthetic */ fB JH;

    fP(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setUsaCoresLista(fB.k(this.JH).isSelected());
        a.vJ();
        if (fB.l(this.JH) != null) {
            fB.l(this.JH).addNotify();
        }
    }
}

