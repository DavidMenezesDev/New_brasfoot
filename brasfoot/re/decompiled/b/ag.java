/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.d;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ag
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        d d2 = (d)object;
        if (object != null) {
            if (d2.sS()) {
                if (n3 == 2) {
                    this.setHorizontalAlignment(2);
                    this.setFont(new Font("Arial", 1, 12));
                    this.setText(d2.sT());
                }
            } else if (d2.sP() != null) {
                if (n3 == 0) {
                    this.setHorizontalAlignment(4);
                    this.setIcon(d2.sP().hc().kU());
                    this.setHorizontalTextPosition(2);
                    this.setText(d2.sP().hc().getNome());
                } else if (n3 == 1) {
                    this.setText("x");
                } else if (n3 == 2) {
                    this.setHorizontalAlignment(2);
                    this.setHorizontalTextPosition(4);
                    this.setIcon(d2.sP().hd().kU());
                    this.setText(d2.sP().hd().getNome());
                } else if (n3 == 4) {
                    if (d2.sP().e()) {
                        this.setText(d2.sP().t(false));
                    } else {
                        this.setText("-x-");
                    }
                } else if (n3 == 5) {
                    if (d2.sQ() != null) {
                        if (d2.sQ().e()) {
                            this.setText(d2.sQ().t(true));
                        } else {
                            this.setText("-x-");
                        }
                    }
                } else if (n3 == 6 && d2.sQ() != null && d2.sQ().e()) {
                    int[] nArray = d2.sP().hQ();
                    if (nArray[0] >= 0 && nArray[1] >= 0) {
                        this.setForeground(Color.BLUE);
                        this.setText(d2.sP().u(false));
                    } else {
                        nArray = d2.sQ().hQ();
                        if (nArray[0] >= 0 && nArray[1] >= 0) {
                            this.setForeground(Color.BLUE);
                            this.setText(d2.sQ().u(true));
                        }
                    }
                }
            }
        }
        return this;
    }
}

