/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bi
implements ActionListener {
    final /* synthetic */ bg zT;

    bi(bg bg2) {
        this.zT = bg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bg.a(this.zT).dispose();
    }
}

