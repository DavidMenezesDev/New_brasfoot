/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.f;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class m
implements ActionListener {
    final /* synthetic */ f Ut;

    m(f f2) {
        this.Ut = f2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        f.b(this.Ut);
    }
}

