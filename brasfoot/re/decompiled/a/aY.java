/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aY
implements ActionListener {
    final /* synthetic */ aX zt;

    aY(aX aX2) {
        this.zt = aX2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aX.a(this.zt);
        aX.b(this.zt).dispose();
    }
}

