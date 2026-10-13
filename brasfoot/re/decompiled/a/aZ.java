/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aZ
implements ActionListener {
    final /* synthetic */ aX zt;

    aZ(aX aX2) {
        this.zt = aX2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aX.c(this.zt);
    }
}

