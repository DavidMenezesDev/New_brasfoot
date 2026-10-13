/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aE
implements ActionListener {
    final /* synthetic */ ay yi;

    aE(ay ay2) {
        this.yi = ay2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ay.b(this.yi, 1);
    }
}

