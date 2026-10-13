/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hU;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hX
implements ActionListener {
    final /* synthetic */ hU MA;

    hX(hU hU2) {
        this.MA = hU2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.SR.setJogaRegionais(hU.f(this.MA).isSelected());
        a.vM().setJogaRegionais(hU.f(this.MA).isSelected());
        a.vJ();
    }
}

