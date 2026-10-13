/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.as;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ar
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        as as2;
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.WHITE);
        super.setBackground(new Color(44, 53, 49));
        Font font = new Font("Arial", 0, 11);
        this.setFont(font);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        if (bl2) {
            super.setBackground(Color.WHITE);
            super.setForeground(Color.BLACK);
        }
        if ((as2 = (as)object) != null) {
            if (!as2.vo()) {
                Font font2 = new Font("Arial", 1, 11);
                this.setFont(font2);
            }
            if (n3 == 0) {
                this.setText(as2.getData());
            } else if (n3 == 1) {
                if (as2.vm() < best.ar.tP.length) {
                    this.setText(String.valueOf(best.ar.tP[as2.vm()]) + " " + as2.vp());
                } else {
                    this.setText("");
                }
            }
        }
        return this;
    }
}

