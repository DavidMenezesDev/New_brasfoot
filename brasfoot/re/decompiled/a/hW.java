/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hU;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hW
implements ActionListener {
    final /* synthetic */ hU MA;

    hW(hU hU2) {
        this.MA = hU2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.SR.setJogaEstadual(hU.e(this.MA).isSelected());
        a.vM().setJogaEstadual(hU.e(this.MA).isSelected());
        a.vJ();
    }
}

