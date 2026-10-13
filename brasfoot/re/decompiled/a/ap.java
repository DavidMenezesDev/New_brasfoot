/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.al;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ap
implements ActionListener {
    final /* synthetic */ al wT;

    ap(al al2) {
        this.wT = al2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        al.f(this.wT).getSelectedIndex();
    }
}

