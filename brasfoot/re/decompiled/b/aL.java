/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.al;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aL
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        al al2 = (al)object;
        if (al2 != null) {
            if (n3 == 0) {
                this.setText(al2.dS());
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + al2.lE() + ".png"));
                this.setIcon(imageIcon);
            } else if (n3 == 1 && al2.fg() != null) {
                this.setText(al2.fg().getNome());
                this.setIcon(al2.fg().kU());
            }
        }
        return this;
    }
}

