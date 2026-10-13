/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aN
implements ActionListener {
    final /* synthetic */ aL yJ;

    aN(aL aL2) {
        this.yJ = aL2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aL.a(this.yJ, true);
    }
}

