/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import b.i;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Q
implements ListSelectionListener {
    final /* synthetic */ L vO;

    Q(L l2) {
        this.vO = l2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && L.c(this.vO).getSelectedRow() >= 0) {
            int n2 = L.c(this.vO).convertRowIndexToModel(L.c(this.vO).getSelectedRow());
            L.a(this.vO, ((i)L.c(this.vO).getModel()).es(n2));
        }
    }
}

