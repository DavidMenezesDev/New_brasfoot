/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hD
implements ActionListener {
    final /* synthetic */ hC LD;

    hD(hC hC2) {
        this.LD = hC2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (hC.a(this.LD).getItemCount() > 0) {
            hC.b(this.LD);
        }
    }
}

