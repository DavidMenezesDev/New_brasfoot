/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aI
implements ActionListener {
    final /* synthetic */ ay yi;

    aI(ay ay2) {
        this.yi = ay2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (ay.b(this.yi).getSelectedIndex() >= 0 && !this.yi.xa) {
            ay.c(this.yi, ay.b(this.yi).getSelectedIndex());
        }
    }
}

