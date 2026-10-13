/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.e;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ab
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        e e2 = (e)object;
        if (n3 == 0) {
            this.setText(Integer.toString(n2 + 1));
        } else if (n3 == 1) {
            this.setText(e2.x().getNome());
        } else if (n3 == 2) {
            if (e2.x().fg() != null) {
                this.setText(e2.x().fg().getNome());
            }
        } else if (n3 == 3) {
            this.setText(String.format("%.2f", e2.F()));
        } else if (n3 == 4) {
            Double d2 = e2.D();
            int n4 = d2.intValue();
            this.setText(Integer.toString(n4));
        }
        return this;
    }
}

