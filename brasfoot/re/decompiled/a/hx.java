/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hx
implements ActionListener {
    final /* synthetic */ hw Ly;

    hx(hw hw2) {
        this.Ly = hw2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hw.a(this.Ly).dispose();
    }
}

