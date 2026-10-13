/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cu;
import best.aq;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cv
implements ActionListener {
    final /* synthetic */ cu CO;

    cv(cu cu2) {
        this.CO = cu2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2 = aq.sL[cu.a(this.CO).getSelectedIndex()][0];
        cu.a(this.CO, cu.a(this.CO).getSelectedIndex());
        cu.b(this.CO).J(cu.c(this.CO), n2);
        cu.b(this.CO).oJ();
    }
}

