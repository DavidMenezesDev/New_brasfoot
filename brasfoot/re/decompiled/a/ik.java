/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hU;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ik
implements ActionListener {
    final /* synthetic */ hU MA;

    ik(hU hU2) {
        this.MA = hU2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.SR.setJogaSelecoesAll(hU.d(this.MA).isSelected());
        a.vM().setJogaSelecoesAll(hU.d(this.MA).isSelected());
        a.vJ();
    }
}

