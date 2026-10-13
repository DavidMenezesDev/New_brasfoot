/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class eH
implements ActionListener {
    final /* synthetic */ eg Iz;

    eH(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (a.SR.isHabilidadeIndividual()) {
            eg.a(this.Iz, 2);
        } else {
            eg.a(this.Iz, 1);
        }
    }
}

