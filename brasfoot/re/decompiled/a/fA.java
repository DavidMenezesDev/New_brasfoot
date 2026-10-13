/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class fA
implements ActionListener {
    final /* synthetic */ fy IF;

    fA(fy fy2) {
        this.IF = fy2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fy.b(this.IF);
    }
}

