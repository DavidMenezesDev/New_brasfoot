/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fO
implements ActionListener {
    final /* synthetic */ fB JH;

    fO(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setNegritoCasa(fB.j(this.JH).isSelected());
        a.vJ();
    }
}

