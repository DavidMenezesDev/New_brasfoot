/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gh;
import b.B;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class gk
implements ListSelectionListener {
    final /* synthetic */ gh JW;

    gk(gh gh2) {
        this.JW = gh2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && gh.c(this.JW).getSelectedRow() >= 0) {
            int n2 = gh.c(this.JW).convertRowIndexToModel(gh.c(this.JW).getSelectedRow());
            ((B)gh.c(this.JW).getModel()).et(n2);
        }
    }
}

