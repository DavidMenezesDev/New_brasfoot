/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dN;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class dT
implements ListSelectionListener {
    final /* synthetic */ dN GR;

    dT(dN dN2) {
        this.GR = dN2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && dN.e(this.GR).getSelectedRow() >= 0) {
            int n2 = dN.e(this.GR).convertRowIndexToModel(dN.e(this.GR).getSelectedRow());
            dN.a(this.GR, (String)dN.f(this.GR).get(n2));
            dN.g(this.GR);
        }
    }
}

