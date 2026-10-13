/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.j;
import c.a;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aM
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
            if (n3 == 0) {
                this.setText(Integer.toString(j2.H() + a.SR.iU()));
            } else if (n3 == 1) {
                this.setText(j2.ck());
            } else if (n3 == 2) {
                this.setText(Integer.toString(j2.w()));
            } else if (n3 == 3) {
                this.setText(Integer.toString(j2.cm()));
            } else if (n3 == 4) {
                this.setText(Integer.toString(j2.co()));
            } else if (n3 == 5) {
                int n4 = (int)((float)j2.cm() * 100.0f / (float)j2.w());
                this.setText(String.valueOf(Integer.toString(n4)) + "%");
            } else if (n3 == 6) {
                this.setText(Integer.toString(j2.cq()));
            } else if (n3 == 7) {
                this.setText(Integer.toString(j2.cr()));
            }
        }
        return this;
    }
}

