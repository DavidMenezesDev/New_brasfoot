/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jc;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class jf
implements DocumentListener {
    final /* synthetic */ jc No;

    jf(jc jc2) {
        this.No = jc2;
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        jc.a(this.No);
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        jc.a(this.No);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        jc.a(this.No);
    }
}

