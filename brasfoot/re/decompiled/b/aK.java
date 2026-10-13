/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.ac;
import e.t;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aK
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        t t2 = (t)object;
        if (t2 != null) {
            if (n3 == 0) {
                if (t2.isMark()) {
                    super.setForeground(Color.RED);
                }
                this.setText(t2.getNome());
            } else if (n3 == 1) {
                String string = ac.valueOf("P" + t2.getPais()).getNome();
                this.setText(string);
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + t2.getPais() + ".png"));
                this.setIcon(imageIcon);
            } else if (n3 == 2) {
                this.setText(Integer.toString(t2.getNivel()));
            }
        }
        return this;
    }
}

