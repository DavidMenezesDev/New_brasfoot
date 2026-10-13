/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ac;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;

class ag
extends MouseAdapter {
    final /* synthetic */ ac VG;

    ag(ac ac2) {
        this.VG = ac2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Color color = ac.f(this.VG).getBackground();
        color = JColorChooser.showDialog(ac.f(this.VG), "", ac.f(this.VG).getBackground());
        if (color != null) {
            ac.f(this.VG).setBackground(color);
        }
    }
}

