/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.y;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class A
implements ActionListener {
    final /* synthetic */ y vo;

    A(y y2) {
        this.vo = y2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        y.a(this.vo);
    }
}

