/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ji;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jj
implements ActionListener {
    final /* synthetic */ ji Ns;

    jj(ji ji2) {
        this.Ns = ji2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ji.a(this.Ns).dispose();
    }
}

