/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.al;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aw
implements ActionListener {
    final /* synthetic */ al wT;

    aw(al al2) {
        this.wT = al2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        al.c(this.wT, -1);
    }
}

