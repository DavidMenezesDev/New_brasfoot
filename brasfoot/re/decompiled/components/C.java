/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.B;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C
implements ActionListener {
    final /* synthetic */ B PA;

    C(B b2) {
        this.PA = b2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        B.a(this.PA).dispose();
    }
}

