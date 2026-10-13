/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class is
implements ActionListener {
    final /* synthetic */ ip ME;

    is(ip ip2) {
        this.ME = ip2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ip.c(this.ME);
    }
}

