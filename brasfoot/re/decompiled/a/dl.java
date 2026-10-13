/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dl
implements ActionListener {
    final /* synthetic */ dk Fm;

    dl(dk dk2) {
        this.Fm = dk2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dk.a(this.Fm).dispose();
    }
}

