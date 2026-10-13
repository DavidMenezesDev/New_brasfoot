/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ap;
import d.n;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class A
implements ListSelectionListener {
    final /* synthetic */ n Vh;

    A(n n2) {
        this.Vh = n2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && n.g(this.Vh).getSelectedRow() >= 0) {
            int n2 = n.g(this.Vh).convertRowIndexToModel(n.g(this.Vh).getSelectedRow());
            ((ap)n.g(this.Vh).getModel()).et(n2);
        }
    }
}

