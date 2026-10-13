/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.d;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Z
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        d d2 = (d)object;
        if (n3 == 1) {
            this.setText(d2.getNome());
        } else if (n3 == 2) {
            if (d2.B() != null) {
                this.setText(d2.B().getNome());
            }
        } else if (n3 == 3) {
            this.setText(Integer.toString(d2.v()));
        } else if (n3 == 4) {
            this.setText(Integer.toString(d2.w()));
        }
        return this;
    }
}

