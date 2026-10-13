/*
 * Decompiled with CFR 0.152.
 */
package forms;

import best.Z;
import best.ah;
import c.a;
import f.B;
import forms.h;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class k
implements ActionListener {
    final /* synthetic */ h Xb;

    k(h h3) {
        this.Xb = h3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ah ah2 = (ah)((B)((Z)a.SR.N().get(0)).eb().get(0)).yi().yK().get(0);
        ah2.k(true);
        ah2.ka().k(true);
        a.SR.M().add(ah2.ka());
        a.SR.aN().add(ah2);
        h.a(this.Xb, ah2);
    }
}

