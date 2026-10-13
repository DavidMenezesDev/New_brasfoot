/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.O;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class U
implements ActionListener {
    final /* synthetic */ O QR;

    U(O o2) {
        this.QR = o2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        O.a(this.QR);
    }
}

