/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class iw
implements ActionListener {
    final /* synthetic */ iu MI;

    iw(iu iu2) {
        this.MI = iu2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (iu.b(this.MI).getItemCount() > 0) {
            iu.c(this.MI);
        }
    }
}

