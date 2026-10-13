/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jK
implements ActionListener {
    final /* synthetic */ jH afI;

    jK(jH jH2) {
        this.afI = jH2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jH.b(this.afI, actionEvent);
    }
}

