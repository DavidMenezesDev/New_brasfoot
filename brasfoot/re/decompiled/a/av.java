/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.al;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class av
implements ActionListener {
    final /* synthetic */ al wT;

    av(al al2) {
        this.wT = al2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        al.b(this.wT).dispose();
    }
}

