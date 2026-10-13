/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hk;
import best.S;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hv
implements ActionListener {
    final /* synthetic */ hk Lt;

    hv(hk hk2) {
        this.Lt = hk2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hk.d(this.Lt).setCursor(new Cursor(3));
        S.a(null);
        hk.d(this.Lt).setCursor(new Cursor(12));
    }
}

