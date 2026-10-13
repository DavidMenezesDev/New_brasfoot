/*
 * Decompiled with CFR 0.152.
 */
package a;

import best.ad;
import best.n;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class aJ
extends JLabel
implements ListCellRenderer {
    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        String string = (String)object;
        if (bl2) {
            this.setBackground(jList.getSelectionBackground());
            this.setForeground(jList.getSelectionForeground());
        } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
        }
        if (object != null) {
            String string2 = "";
            ImageIcon imageIcon = null;
            if (object.equals("Internacional")) {
                string2 = "Internacional";
                imageIcon = new ImageIcon(this.getClass().getResource("/aicons/worldflag.png"));
            } else if (!object.equals("Qualquer")) {
                imageIcon = ((ad)n.cY().get(n.h(string))).jD();
                string2 = ((ad)n.cY().get(n.h(string))).getNome();
            } else {
                string2 = "Qualquer";
            }
            this.setIcon(imageIcon);
            this.setText(string2);
        }
        return this;
    }
}

