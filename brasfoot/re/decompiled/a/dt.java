/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ds;
import b.N;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class dt
implements ListSelectionListener {
    final /* synthetic */ ds FS;

    dt(ds ds2) {
        this.FS = ds2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && ds.a(this.FS).getSelectedRow() >= 0) {
            int n2 = ds.a(this.FS).convertRowIndexToModel(ds.a(this.FS).getSelectedRow());
            ((N)ds.a(this.FS).getModel()).et(n2);
        }
    }
}

