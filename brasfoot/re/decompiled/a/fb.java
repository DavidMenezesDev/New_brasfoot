/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class fb
implements ActionListener {
    final /* synthetic */ eg Iz;

    fb(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            this.Iz.ru();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

