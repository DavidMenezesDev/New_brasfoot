/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import c.a;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class fu
extends AbstractAction {
    final /* synthetic */ eg Iz;

    fu(eg eg2) {
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

