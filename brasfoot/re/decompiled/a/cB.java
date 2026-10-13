/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cB
implements ActionListener {
    final /* synthetic */ cz Da;

    cB(cz cz2) {
        this.Da = cz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cz.b(this.Da);
    }
}

