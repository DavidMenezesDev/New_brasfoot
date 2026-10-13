/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ip;
import best.al;
import c.a;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class it
implements ListSelectionListener {
    final /* synthetic */ ip ME;

    it(ip ip2) {
        this.ME = ip2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && ip.d(this.ME).getSelectedRow() >= 0) {
            int n2 = ip.d(this.ME).convertRowIndexToModel(ip.d(this.ME).getSelectedRow());
            ip.a(this.ME, (al)a.SR.M().get(n2));
        }
    }
}

