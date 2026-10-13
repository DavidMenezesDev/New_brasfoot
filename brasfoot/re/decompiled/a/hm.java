/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hk;
import best.S;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hm
implements ActionListener {
    final /* synthetic */ hk Lt;

    hm(hk hk2) {
        this.Lt = hk2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hk.e(this.Lt).setCursor(new Cursor(3));
        S.a(null, hk.f(this.Lt), 0);
        hk.e(this.Lt).setCursor(new Cursor(12));
    }
}

