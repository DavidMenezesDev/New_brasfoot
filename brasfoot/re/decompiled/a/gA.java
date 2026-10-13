/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gx;
import b.D;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class gA
implements ListSelectionListener {
    final /* synthetic */ gx Kg;

    gA(gx gx2) {
        this.Kg = gx2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && gx.c(this.Kg).getSelectedRow() >= 0) {
            int n2 = gx.c(this.Kg).convertRowIndexToModel(gx.c(this.Kg).getSelectedRow());
            ((D)gx.c(this.Kg).getModel()).et(n2);
        }
    }
}

