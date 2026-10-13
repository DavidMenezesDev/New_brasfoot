/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.hk;
import best.Z;
import best.aq;
import best.at;
import best.w;
import f.f;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ak
extends JLabel
implements ListCellRenderer {
    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        if (object != null) {
            this.setIcon(null);
            if (bl2) {
                this.setBackground(Color.YELLOW);
                this.setForeground(jList.getSelectionForeground());
            } else {
                this.setBackground(jList.getBackground());
                this.setForeground(jList.getForeground());
            }
            if (object != null && object instanceof w) {
                w w2 = (w)object;
                this.setIcon(new ImageIcon(this.getClass().getResource("/aesticons/" + w2.getEstado() + ".png")));
                String string = aq.rY[w2.getEstado()];
                this.setText(string);
            } else if (object != null && object instanceof f) {
                f f2 = (f)object;
                if (hk.sf() == 1) {
                    this.setText(f2.yg().jf());
                } else {
                    this.setText(f2.getNome());
                }
                this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + f2.yg().jc() + ".png")));
            } else if (object != null && object instanceof Z) {
                Z z2 = (Z)object;
                if (hk.sf() == 1) {
                    this.setText(z2.jf());
                } else {
                    this.setText(z2.jq().getNome());
                }
                this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + z2.jc() + ".png")));
            } else if (object != null) {
                at at2 = (at)object;
                String string = at2.getNome();
                this.setText(string);
                this.setIcon(at2.es());
            }
        }
        return this;
    }
}

