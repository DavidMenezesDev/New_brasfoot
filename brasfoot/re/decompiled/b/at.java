/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.C;
import components.j;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class at
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        j j2 = (j)object;
        if (j2 != null) {
            if (j2.isBold()) {
                this.setFont(new Font("Tahoma", 1, 11));
            }
            if (n3 == 0) {
                this.setHorizontalAlignment(4);
                this.setText(j2.sT());
            } else if (n3 == 1 && !j2.tt()) {
                this.setText(C.c(j2.ts()));
            }
        }
        return this;
    }
}

