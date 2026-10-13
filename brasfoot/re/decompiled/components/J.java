/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.H;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class J
implements ActionListener {
    final /* synthetic */ H Qo;

    J(H h3) {
        this.Qo = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        H.b(this.Qo);
    }
}

