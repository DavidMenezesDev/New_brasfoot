/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.u;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aQ
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        u u2 = (u)object;
        if (u2 != null) {
            if (n3 == 0) {
                this.setText(u2.f());
            } else if (n3 == 1) {
                if (u2.ct() >= 0) {
                    this.setText(u2.dR());
                }
            } else if (n3 == 2) {
                if (u2.dP() != null) {
                    this.setText(u2.dP().dS());
                }
            } else if (n3 == 3 && u2.dO() != null) {
                this.setText(u2.dO().dS());
            }
        }
        return this;
    }
}

