/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class fx
implements ActionListener {
    final /* synthetic */ fw IB;

    fx(fw fw2) {
        this.IB = fw2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            fw.a(this.IB);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

