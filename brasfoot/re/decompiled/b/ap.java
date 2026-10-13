/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import components.h;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ap
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        h h3 = (h)object;
        if (h3 != null) {
            if (n3 == 0) {
                this.setIcon(h3.fg().kU());
                if (h3.fg() != null) {
                    this.setText(h3.fg().getNome());
                }
            } else if (n3 == 1) {
                if (h3.tj() != null) {
                    this.setText(h3.tj().dS());
                }
            } else if (n3 == 2) {
                if (h3.tk() != null) {
                    this.setText(h3.tk().dS());
                }
            } else if (n3 == 3) {
                this.setText(aq.sh[h3.tl()]);
            }
        }
        return this;
    }
}

