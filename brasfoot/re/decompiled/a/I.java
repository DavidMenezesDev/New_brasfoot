/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.H;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class I
implements ActionListener {
    final /* synthetic */ H vJ;

    I(H h3) {
        this.vJ = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (H.a(this.vJ).getItemCount() > 0) {
            H.b(this.vJ);
        }
    }
}

