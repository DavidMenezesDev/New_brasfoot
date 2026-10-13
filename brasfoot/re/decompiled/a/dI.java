/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dI
implements ActionListener {
    final /* synthetic */ dG Gu;

    dI(dG dG2) {
        this.Gu = dG2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dG.a(this.Gu).dispose();
    }
}

