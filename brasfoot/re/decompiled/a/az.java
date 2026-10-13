/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class az
implements ActionListener {
    final /* synthetic */ ay yi;

    az(ay ay2) {
        this.yi = ay2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ay.a(this.yi).dispose();
    }
}

