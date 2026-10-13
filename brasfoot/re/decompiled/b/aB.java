/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import components.ae;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aB
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        ae ae2 = (ae)object;
        if (ae2 != null) {
            if (n3 == 0) {
                this.setText(Integer.toString(n2 + 1));
            } else if (n3 == 1) {
                this.setText(ae2.fg().getNome());
                this.setIcon(ae2.fg().kU());
            } else if (n3 == 2) {
                if (ae2.b() == 0) {
                    this.setText(aq.pZ[ae2.uy()]);
                } else if (ae2.b() == 1) {
                    this.setHorizontalAlignment(0);
                    this.setText("(" + Integer.toString(ae2.uy()) + "/" + Integer.toString(ae2.uz()) + "/" + Integer.toString(ae2.uA()) + ")");
                } else {
                    this.setText(Integer.toString(ae2.uy()));
                }
            }
        }
        return this;
    }
}

