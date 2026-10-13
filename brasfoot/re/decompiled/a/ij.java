/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hU;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ij
implements ActionListener {
    final /* synthetic */ hU MA;

    ij(hU hU2) {
        this.MA = hU2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.SR.setJogaIntClubes(hU.c(this.MA).isSelected());
        a.vM().setJogaIntClubes(hU.c(this.MA).isSelected());
        a.vJ();
    }
}

