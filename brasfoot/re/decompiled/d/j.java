/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.F;
import best.aq;
import d.f;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class j
implements ActionListener {
    final /* synthetic */ f Ut;

    j(f f2) {
        this.Ut = f2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        f.d(this.Ut).removeAllItems();
        f.e(this.Ut).removeAllItems();
        int[] nArray = F.at(f.f(this.Ut).getSelectedIndex());
        f.eH(f.f(this.Ut).getSelectedIndex());
        if (f.f(this.Ut).getSelectedIndex() == 0) {
            int n2 = 0;
            while (n2 <= 3) {
                f.d(this.Ut).addItem(aq.qM[n2]);
                f.e(this.Ut).addItem(aq.qM[n2]);
                ++n2;
            }
            f.d(this.Ut).setSelectedIndex(nArray[0]);
            f.e(this.Ut).setSelectedIndex(nArray[1]);
        } else {
            int n3 = 4;
            while (n3 < aq.qM.length) {
                f.d(this.Ut).addItem(aq.qM[n3]);
                f.e(this.Ut).addItem(aq.qM[n3]);
                ++n3;
            }
            f.d(this.Ut).setSelectedIndex(nArray[0] - 4);
            f.e(this.Ut).setSelectedIndex(nArray[1] - 4);
        }
    }
}

