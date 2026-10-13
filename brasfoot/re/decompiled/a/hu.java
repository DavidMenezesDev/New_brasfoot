/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class hu
implements ActionListener {
    final /* synthetic */ hk Lt;

    hu(hk hk2) {
        this.Lt = hk2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        hk.c(this.Lt);
    }
}

