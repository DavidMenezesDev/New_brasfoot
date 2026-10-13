/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ay;
import d.n;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Q
implements ListSelectionListener {
    final /* synthetic */ n Vh;

    Q(n n2) {
        this.Vh = n2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && this.Vh.Vg.getSelectedRow() >= 0) {
            n.a(this.Vh, true);
            int n2 = this.Vh.Vg.convertRowIndexToModel(this.Vh.Vg.getSelectedRow());
            ((ay)this.Vh.Vg.getModel()).et(n2);
            n.g(this.Vh).addNotify();
        }
    }
}

