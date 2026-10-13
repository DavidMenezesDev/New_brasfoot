/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.al;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ao
implements ActionListener {
    final /* synthetic */ al wT;

    ao(al al2) {
        this.wT = al2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (al.e(this.wT).isEnabled()) {
            al.a(this.wT, al.d(this.wT) + 1, null, null);
        }
    }
}

