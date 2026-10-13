/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hU;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ia
implements ActionListener {
    final /* synthetic */ hU MA;

    ia(hU hU2) {
        this.MA = hU2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.SR.setUsarGruposReaisCopa(hU.h(this.MA).isSelected());
        a.vM().setUsarGruposReaisCopa(hU.h(this.MA).isSelected());
        a.vJ();
    }
}

