/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fW
implements ActionListener {
    final /* synthetic */ fB JH;

    fW(fB fB2) {
        this.JH = fB2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fB.b(this.JH, actionEvent.getSource());
    }
}

