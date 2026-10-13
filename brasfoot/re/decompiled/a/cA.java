/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cA
implements ActionListener {
    final /* synthetic */ cz Da;

    cA(cz cz2) {
        this.Da = cz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cz.a(this.Da).dispose();
    }
}

