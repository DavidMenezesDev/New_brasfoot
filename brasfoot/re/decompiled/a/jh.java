/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jh
implements ActionListener {
    final /* synthetic */ jc No;

    jh(jc jc2) {
        this.No = jc2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jc.c(this.No);
    }
}

