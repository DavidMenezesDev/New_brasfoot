/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iX;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class jb
implements DocumentListener {
    final /* synthetic */ iX Nj;

    jb(iX iX2) {
        this.Nj = iX2;
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        iX.d(this.Nj);
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        iX.d(this.Nj);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        iX.d(this.Nj);
    }
}

