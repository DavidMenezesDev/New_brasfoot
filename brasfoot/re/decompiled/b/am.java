/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.at;
import f.I;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class am
extends JLabel
implements ListCellRenderer {
    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        this.setIcon(null);
        if (bl2) {
            this.setBackground(Color.YELLOW);
            this.setForeground(jList.getSelectionForeground());
        } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
        }
        if (object != null && object instanceof I) {
            I i2 = (I)object;
            String string = i2.getNome();
            this.setText(string);
            this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + i2.getPais() + ".png")));
        } else if (object != null) {
            at at2 = (at)object;
            String string = at2.getNome();
            this.setText(string);
            this.setIcon(at2.es());
        }
        return this;
    }
}

