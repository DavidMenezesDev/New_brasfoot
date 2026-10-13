/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cw;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cx
implements ActionListener {
    final /* synthetic */ cw CX;

    cx(cw cw2) {
        this.CX = cw2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.SR.setUsaGrupoPadraoEstadual(cw.a(this.CX).isSelected());
        a.vM().setUsaGrupoPadraoEstadual(cw.a(this.CX).isSelected());
        a.vJ();
    }
}

