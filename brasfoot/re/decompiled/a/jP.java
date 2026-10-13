/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jP
implements ActionListener {
    final /* synthetic */ jH afI;

    jP(jH jH2) {
        this.afI = jH2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jH.a(this.afI, -1);
    }
}

