/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aO
implements ActionListener {
    final /* synthetic */ aL yJ;

    aO(aL aL2) {
        this.yJ = aL2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (aL.b(this.yJ).getSelectedIndex() >= 0) {
            aL.b(this.yJ, false);
        }
    }
}

