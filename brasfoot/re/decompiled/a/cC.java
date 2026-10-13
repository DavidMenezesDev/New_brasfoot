/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cz;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class cC
implements DocumentListener {
    final /* synthetic */ cz Da;

    cC(cz cz2) {
        this.Da = cz2;
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        cz.c(this.Da);
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        cz.c(this.Da);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        cz.c(this.Da);
    }
}

