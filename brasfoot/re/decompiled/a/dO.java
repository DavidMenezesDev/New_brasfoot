/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dN;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dO
implements ActionListener {
    final /* synthetic */ dN GR;

    dO(dN dN2) {
        this.GR = dN2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dN.a(this.GR).setCursor(new Cursor(3));
        dN.b(this.GR);
    }
}

