/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gi
implements ActionListener {
    final /* synthetic */ gh JW;

    gi(gh gh2) {
        this.JW = gh2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gh.a(this.JW).dispose();
    }
}

