/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hc;
import components.ae;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class hj
implements ListSelectionListener {
    final /* synthetic */ hc KL;

    hj(hc hc2) {
        this.KL = hc2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && hc.e(this.KL).getSelectedRow() >= 0) {
            int n2 = hc.e(this.KL).convertRowIndexToModel(hc.e(this.KL).getSelectedRow());
            hc.a(this.KL, ((ae)hc.f(this.KL).get(n2)).fg());
            hc.g(this.KL);
        }
    }
}

