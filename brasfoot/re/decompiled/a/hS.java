/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hS
implements ActionListener {
    final /* synthetic */ hF Ma;

    hS(hF hF2) {
        this.Ma = hF2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (hF.b(this.Ma) != null) {
            hF.a(this.Ma, 2);
        }
    }
}

