/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import c.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ju
implements ActionListener {
    final /* synthetic */ fB JH;

    ju(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.vM().setIgnoraEstadual(fB.o(this.JH).isSelected());
        a.vJ();
    }
}

