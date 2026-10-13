/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.de;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class df
implements ActionListener {
    final /* synthetic */ de Er;

    df(de de2) {
        this.Er = de2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        de.a(this.Er).dispose();
    }
}

