/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ah
implements ActionListener {
    final /* synthetic */ aa wq;

    ah(aa aa2) {
        this.wq = aa2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (aa.d(this.wq).getSelectedIndex() >= 0) {
            aa.c(this.wq, aa.d(this.wq).getSelectedIndex());
        }
    }
}

