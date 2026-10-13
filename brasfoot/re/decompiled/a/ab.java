/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ab
implements ActionListener {
    final /* synthetic */ aa wq;

    ab(aa aa2) {
        this.wq = aa2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aa.a(this.wq).dispose();
    }
}

