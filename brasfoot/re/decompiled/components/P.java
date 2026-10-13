/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.O;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class P
implements ActionListener {
    final /* synthetic */ O QR;

    P(O o2) {
        this.QR = o2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        O.a(this.QR);
    }
}

