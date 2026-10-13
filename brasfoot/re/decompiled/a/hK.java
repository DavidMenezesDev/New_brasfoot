/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hK
implements ActionListener {
    final /* synthetic */ hF Ma;

    hK(hF hF2) {
        this.Ma = hF2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hF.b(this.Ma, 1000);
    }
}

