/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.A;
import best.aq;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class as
extends DefaultTableCellRenderer {
    private boolean SP;

    public as(boolean bl2) {
        this.SP = bl2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", 0, 11));
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        A a2 = (A)object;
        if (this.SP) {
            this.setBackground(aq.or);
        }
        if (a2 != null && a2.isDone()) {
            if (n3 == 1) {
                if (a2.b() < 90) {
                    this.setText(a2.er());
                } else if (a2.b() == 91) {
                    this.setText("Gols");
                } else if (a2.b() == 92) {
                    this.setText("Cart\u00f5es");
                } else if (a2.b() == 95) {
                    this.setText("Contus\u00f5es");
                } else if (a2.b() == 96) {
                    this.setText("Substitui\u00e7\u00f5es");
                }
            }
            if (a2.b() > 90) {
                if (n3 == 1) {
                    this.setFont(new Font("Arial", 1, 12));
                    this.setHorizontalAlignment(0);
                    this.setBackground(aq.os);
                }
            } else if (a2.et() == 0) {
                if (n3 == 0) {
                    this.setIcon(a2.es());
                } else if (n3 == 1) {
                    this.setHorizontalAlignment(2);
                }
            } else if (a2.et() == 1) {
                if (n3 == 2) {
                    this.setIcon(a2.es());
                } else if (n3 == 1) {
                    this.setHorizontalAlignment(4);
                }
            }
        }
        return this;
    }
}

