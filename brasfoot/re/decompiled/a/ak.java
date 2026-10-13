/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ak
implements ActionListener {
    final /* synthetic */ aa wq;

    ak(aa aa2) {
        this.wq = aa2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aa.d(this.wq, 2);
    }
}

