/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dz;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class dF
implements DocumentListener {
    final /* synthetic */ dz Gn;

    dF(dz dz2) {
        this.Gn = dz2;
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        dz.e(this.Gn);
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        dz.e(this.Gn);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        dz.e(this.Gn);
    }
}

