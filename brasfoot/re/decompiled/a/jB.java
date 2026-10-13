/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jB
implements ActionListener {
    final /* synthetic */ jv afy;

    jB(jv jv2) {
        this.afy = jv2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jv.d(this.afy);
    }
}

