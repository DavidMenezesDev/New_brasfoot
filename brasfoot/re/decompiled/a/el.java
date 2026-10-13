/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eg;
import b.Q;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class el
implements ListSelectionListener {
    final /* synthetic */ eg Iz;

    el(eg eg2) {
        this.Iz = eg2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && eg.c(this.Iz).getSelectedRow() >= 0) {
            int n2 = eg.c(this.Iz).convertRowIndexToModel(eg.c(this.Iz).getSelectedRow());
            ((Q)eg.c(this.Iz).getModel()).et(n2);
        }
    }
}

