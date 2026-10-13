/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.X;
import d.ay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ab
implements ActionListener {
    final /* synthetic */ X Vm;

    ab(X x2) {
        this.Vm = x2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2 = this.Vm.table.getSelectedRow();
        ((ay)this.Vm.table.getModel()).removeRow(n2);
        this.Vm.table.addNotify();
    }
}

