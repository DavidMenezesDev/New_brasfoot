/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.a;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class b
implements ActionListener {
    final /* synthetic */ a uj;

    b(a a2) {
        this.uj = a2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        a.a(this.uj).dispose();
    }
}

