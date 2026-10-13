/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ce;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cf
implements ActionListener {
    final /* synthetic */ ce BW;

    cf(ce ce2) {
        this.BW = ce2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ce.a(this.BW).dispose();
    }
}

