/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class c
extends JLabel
implements ListCellRenderer {
    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        if (bl2) {
            this.setBackground(jList.getSelectionBackground());
            this.setForeground(jList.getSelectionForeground());
        }
        int n3 = (Integer)object;
        this.setText(aq.rX[n3]);
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aesticons/" + Integer.toString(n3) + ".png"));
        this.setIcon(imageIcon);
        return this;
    }
}

