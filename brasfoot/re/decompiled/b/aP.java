/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.C;
import best.ap;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aP
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        ap ap2 = (ap)object;
        if (ap2 != null && ap2.x() != null) {
            if (n3 == 0) {
                this.setText(ap2.f());
            } else if (n3 == 1) {
                this.setText(ap2.x().getNome());
            } else if (n3 == 2) {
                if (ap2.ma() >= 0) {
                    this.setText(ap2.mc());
                }
            } else if (n3 == 3) {
                if (ap2.lZ() >= 0) {
                    this.setText(ap2.md());
                }
            } else if (n3 == 4) {
                this.setText(C.a(ap2.lY(), 0));
            }
        }
        return this;
    }
}

