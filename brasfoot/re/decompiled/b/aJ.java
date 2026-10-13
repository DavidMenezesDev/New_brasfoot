/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.ac;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aJ
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        if (n3 == 0) {
            int n4 = 0;
            if (object instanceof Integer) {
                n4 = (Integer)object;
            } else if (object instanceof String) {
                n4 = Integer.parseInt((String)object);
            }
            ImageIcon imageIcon = n4 == 1 ? new ImageIcon(this.getClass().getResource("/aicons/ballsel.png")) : new ImageIcon(this.getClass().getResource("/aicons/balldesel.png"));
            this.setIcon(imageIcon);
            this.setText(null);
            this.setHorizontalAlignment(0);
        } else if (n3 == 1) {
            String string = ac.valueOf("P" + object).getNome();
            this.setText(string);
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + object + ".png"));
            this.setIcon(imageIcon);
        } else if (n3 == 2) {
            this.setIcon(null);
        }
        return this;
    }
}

