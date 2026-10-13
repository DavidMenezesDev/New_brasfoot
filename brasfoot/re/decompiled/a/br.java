/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bn;
import b.u;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class br
implements ListSelectionListener {
    final /* synthetic */ bn Ae;

    br(bn bn2) {
        this.Ae = bn2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && bn.b(this.Ae).getSelectedRow() >= 0) {
            int n2 = bn.b(this.Ae).convertRowIndexToModel(bn.b(this.Ae).getSelectedRow());
            bn.a(this.Ae, ((u)bn.b(this.Ae).getModel()).ew(n2));
        }
    }
}

