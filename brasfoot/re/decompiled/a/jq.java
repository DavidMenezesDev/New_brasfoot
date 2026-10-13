/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jq
implements ActionListener {
    final /* synthetic */ jp Nz;

    jq(jp jp2) {
        this.Nz = jp2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jp.a(this.Nz).dispose();
    }
}

