/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hQ
implements ActionListener {
    final /* synthetic */ hF Ma;

    hQ(hF hF2) {
        this.Ma = hF2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (hF.b(this.Ma) != null) {
            hF.c(this.Ma);
        }
    }
}

