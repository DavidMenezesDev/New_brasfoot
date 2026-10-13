/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.ai;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class az
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        ai ai2 = (ai)object;
        if (object != null) {
            if (n3 == 0) {
                this.setFont(new Font("Tahoma", 1, 11));
                this.setHorizontalAlignment(4);
                this.setText(ai2.uJ());
            }
            if (n3 == 1) {
                this.setText(ai2.uK());
            }
        }
        return this;
    }
}

