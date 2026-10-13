/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.n;
import d.ai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class an
implements ActionListener {
    final /* synthetic */ ai VN;

    an(ai ai2) {
        this.VN = ai2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (ai.b(this.VN).getSelectedRow() >= 0) {
            if (ai.d(this.VN).getJogadores().size() >= 30) {
                ai.c(this.VN).setText("O time de destino n\u00e3o tem vaga");
            } else {
                if (n.da().wL() != null && n.da().wK() && n.da().wI() != ai.d(this.VN)) {
                    ai.d(this.VN).getJogadores().add(n.da().wL());
                    n.da().wI().getJogadores().remove(n.da().wL());
                } else {
                    ai.c(this.VN).setText("N\u00e3o foi poss\u00edvel transferir");
                }
                n.da().a(null);
                n.da().wJ().setRowSelectionInterval(0, 0);
                n.da().wJ().addNotify();
                n.da().Uw.dispose();
                n.da().c(ai.d(this.VN));
            }
        }
    }
}

