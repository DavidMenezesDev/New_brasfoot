/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.Z;
import best.ac;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aw
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        Z z2 = (Z)object;
        if (n3 == 0) {
            try {
                ImageIcon imageIcon = z2.jr() ? new ImageIcon(this.getClass().getResource("/aicons/ballsel.png")) : new ImageIcon(this.getClass().getResource("/aicons/balldesel.png"));
                this.setIcon(imageIcon);
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.setText(null);
            this.setHorizontalAlignment(0);
        } else if (n3 == 1) {
            String string = ac.valueOf("P" + z2.jc()).getNome();
            this.setText(string);
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + z2.jc() + ".png"));
            this.setIcon(imageIcon);
        }
        return this;
    }
}

