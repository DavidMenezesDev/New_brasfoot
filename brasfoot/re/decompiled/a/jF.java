/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gX;
import best.al;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class jF
implements ListSelectionListener {
    final /* synthetic */ gX KE;

    jF(gX gX2) {
        this.KE = gX2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && gX.d(this.KE).getSelectedRow() >= 0) {
            int n2 = gX.d(this.KE).convertRowIndexToModel(gX.d(this.KE).getSelectedRow());
            gX.a(this.KE, (al)gX.e(this.KE).get(n2));
            this.KE.rV();
        }
    }
}

