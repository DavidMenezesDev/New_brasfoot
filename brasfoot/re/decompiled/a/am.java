/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.al;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class am
implements ActionListener {
    final /* synthetic */ al wT;

    am(al al2) {
        this.wT = al2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (al.a(this.wT).getSelectedIndex() >= 0) {
            al.a(this.wT, al.a(this.wT).getSelectedIndex());
        }
    }
}

