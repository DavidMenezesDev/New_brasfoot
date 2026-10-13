/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.y;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class B
implements ActionListener {
    final /* synthetic */ y vo;

    B(y y2) {
        this.vo = y2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        y.b(this.vo).dispose();
    }
}

