/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aF
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        if (n3 == 0) {
            String string = aq.rY[(Integer)object];
            this.setText(string);
        } else if (n3 == 1) {
            this.setIcon(null);
        }
        return this;
    }
}

