/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gE;
import best.ah;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class gF
implements ListSelectionListener {
    final /* synthetic */ gE aeO;

    gF(gE gE2) {
        this.aeO = gE2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && gE.a(this.aeO).getSelectedRow() >= 0) {
            int n2 = gE.a(this.aeO).convertRowIndexToModel(gE.a(this.aeO).getSelectedRow());
            gE.a(this.aeO, (ah)gE.b(this.aeO).get(n2));
            gE.c(this.aeO);
        }
    }
}

