/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ir
implements ActionListener {
    final /* synthetic */ ip ME;

    ir(ip ip2) {
        this.ME = ip2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ip.b(this.ME);
    }
}

