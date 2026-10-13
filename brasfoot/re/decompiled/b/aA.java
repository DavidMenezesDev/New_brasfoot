/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.al;
import best.aq;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aA
extends DefaultTableCellRenderer {
    private int w = 0;

    public aA(int n2) {
        this.w = n2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        al al2 = (al)object;
        if (al2 != null) {
            if (n3 == 0) {
                this.setText(Integer.toString(n2 + 1));
            } else if (n3 == 1) {
                this.setText(al2.dS());
            } else if (n3 == 2) {
                if (al2.fg() != null) {
                    this.setText(al2.fg().getNome());
                }
            } else if (n3 == 3) {
                if (this.w == 0) {
                    this.setText(Integer.toString(al2.lI()));
                } else if (al2.getReputacao() < aq.pZ.length) {
                    this.setText(aq.pZ[al2.getReputacao()]);
                }
            } else if (n3 == 4 && this.w == 0) {
                this.setText(Integer.toString(al2.cr()));
            }
        }
        return this;
    }
}

