/*
 * Decompiled with CFR 0.152.
 */
package forms;

import best.n;
import forms.h;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class r
implements ActionListener {
    final /* synthetic */ h Xb;

    r(h h3) {
        this.Xb = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        n.cV();
        n.cW();
        h.b(this.Xb).setVisible(false);
    }
}

