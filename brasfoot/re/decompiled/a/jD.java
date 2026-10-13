/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jv;
import components.ae;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class jD
implements ListSelectionListener {
    final /* synthetic */ jv afy;

    jD(jv jv2) {
        this.afy = jv2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && jv.f(this.afy).getSelectedRow() >= 0) {
            int n2 = jv.f(this.afy).convertRowIndexToModel(jv.f(this.afy).getSelectedRow());
            jv.a(this.afy, ((ae)jv.g(this.afy).get(n2)).fg());
        }
    }
}

