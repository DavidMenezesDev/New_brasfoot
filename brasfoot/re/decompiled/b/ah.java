/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.e;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ah
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        e e2 = (e)object;
        if (e2.fg() != null) {
            this.setBackground(e2.getCorF());
            if (n3 == 1) {
                this.setIcon(e2.fg().kU());
            } else if (n3 == 2) {
                this.setHorizontalAlignment(2);
                this.setText(e2.fg().getNome());
            } else if (n3 == 3) {
                this.setText(Integer.toString(e2.ta()[0]));
            } else if (n3 == 4) {
                this.setText(Integer.toString(e2.ta()[1]));
            }
        } else {
            if (n3 < 3) {
                this.setBackground(Color.WHITE);
            } else {
                this.setBackground(e2.getCorF());
            }
            if (n3 == 3) {
                this.setText("PG");
            }
            if (n3 == 4) {
                this.setText("J");
            }
        }
        return this;
    }
}

