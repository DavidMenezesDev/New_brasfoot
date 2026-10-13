/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.di;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dj
implements ActionListener {
    final /* synthetic */ di Fi;

    dj(di di2) {
        this.Fi = di2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        di.a(this.Fi).dispose();
    }
}

