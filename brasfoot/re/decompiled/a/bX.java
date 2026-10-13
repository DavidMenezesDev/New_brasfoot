/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bX
implements ActionListener {
    final /* synthetic */ bV BP;

    bX(bV bV2) {
        this.BP = bV2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        bV.a(this.BP);
    }
}

