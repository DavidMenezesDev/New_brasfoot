/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ix
implements ActionListener {
    final /* synthetic */ iu MI;

    ix(iu iu2) {
        this.MI = iu2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        iu.d(this.MI);
    }
}

