/*
 * Decompiled with CFR 0.152.
 */
package forms;

import c.a;
import forms.h;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class l
implements ActionListener {
    final /* synthetic */ h Xb;

    l(h h3) {
        this.Xb = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2 = 0;
        int n3 = 1;
        h.a(this.Xb);
        a.SR.aO(true);
        while (a.SR.H() < 1 || !((best.a)a.SR.R().get(342)).e() && !a.SR.bN) {
            n2 = a.SR.H();
            if (n3 != n2) {
                n3 = n2;
                System.out.println("ano: " + Integer.toString(n2));
            }
            a.SR.V();
        }
        System.out.println("done");
    }
}

