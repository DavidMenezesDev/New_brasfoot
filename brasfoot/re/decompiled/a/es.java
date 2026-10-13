/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;

class es
extends AbstractAction {
    final /* synthetic */ eg Iz;

    es(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            this.Iz.ru();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

