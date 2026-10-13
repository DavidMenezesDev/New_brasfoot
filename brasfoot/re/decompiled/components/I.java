/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.H;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class I
implements ActionListener {
    final /* synthetic */ H Qo;

    I(H h3) {
        this.Qo = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        H.a(this.Qo);
    }
}

