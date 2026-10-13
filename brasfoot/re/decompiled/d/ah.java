/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.ac;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;

class ah
extends MouseAdapter {
    final /* synthetic */ ac VG;

    ah(ac ac2) {
        this.VG = ac2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Color color = ac.g(this.VG).getBackground();
        color = JColorChooser.showDialog(ac.g(this.VG), "", ac.g(this.VG).getBackground());
        if (color != null) {
            ac.g(this.VG).setBackground(color);
        }
    }
}

