/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jz
implements ActionListener {
    final /* synthetic */ jv afy;

    jz(jv jv2) {
        this.afy = jv2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jv.b(this.afy).dispose();
    }
}

