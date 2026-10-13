/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.o;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class v
implements ActionListener {
    final /* synthetic */ o vj;

    v(o o2) {
        this.vj = o2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (o.a(this.vj).getSelectedIndex() >= 0) {
            o.b(this.vj, o.a(this.vj).getSelectedIndex());
        }
    }
}

