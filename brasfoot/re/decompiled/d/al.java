/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.D;
import d.ai;
import d.ay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class al
implements ActionListener {
    final /* synthetic */ ai VN;

    al(ai ai2) {
        this.VN = ai2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!ai.a(this.VN).getText().isEmpty()) {
            ((ay)ai.b(this.VN).getModel()).aj(D.f(ai.a(this.VN).getText()));
        }
    }
}

