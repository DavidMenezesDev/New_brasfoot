/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import b.U;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class iG
implements ListSelectionListener {
    final /* synthetic */ iA MV;

    iG(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && iA.k(this.MV).getSelectedRow() >= 0) {
            int n2 = iA.k(this.MV).convertRowIndexToModel(iA.k(this.MV).getSelectedRow());
            ((U)iA.k(this.MV).getModel()).et(n2);
        }
    }
}

