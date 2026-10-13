/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.at;
import f.B;
import f.I;
import f.f;
import f.o;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class aj
extends JLabel
implements ListCellRenderer {
    private int w = 0;

    public aj(int n2) {
        this.w = n2;
    }

    public aj() {
    }

    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        this.setIcon(null);
        if (bl2) {
            this.setBackground(Color.YELLOW);
            this.setForeground(jList.getSelectionForeground());
        } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
        }
        if (object != null && object instanceof o) {
            o o2 = (o)object;
            this.setIcon(new ImageIcon(this.getClass().getResource("/aesticons/" + o2.yk() + ".png")));
            String string = o2.getNome();
            this.setText(string);
        } else if (object != null && object instanceof f) {
            f f2 = (f)object;
            String string = f2.getNome();
            this.setText(string);
            this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + f2.yg().jc() + ".png")));
        } else if (object != null && object instanceof B) {
            B b2 = (B)object;
            String string = b2.getNome();
            this.setText(string);
            this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + b2.zO() + ".png")));
        } else if (object != null && object instanceof I) {
            String string = "Supercopa";
            this.setText(string);
            this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_ligas.png")));
        } else if (object != null) {
            at at2 = (at)object;
            String string = at2.getNome();
            this.setText(string);
            this.setIcon(at2.es());
            if (this.w == 1 && at2.b() == 15) {
                this.setText("Torneio Amistoso");
            }
        }
        return this;
    }
}

