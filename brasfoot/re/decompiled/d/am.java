/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ai;
import d.ay;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class am
implements ListSelectionListener {
    final /* synthetic */ ai VN;

    am(ai ai2) {
        this.VN = ai2;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting() && ai.b(this.VN).getSelectedRow() >= 0) {
            int n2 = ai.b(this.VN).convertRowIndexToModel(ai.b(this.VN).getSelectedRow());
            ((ay)ai.b(this.VN).getModel()).eJ(n2);
            ai.c(this.VN).setText("Transferir para " + ai.d(this.VN).getNome());
            ai.e(this.VN).setEnabled(true);
        }
    }
}

