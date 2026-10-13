/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.C;
import best.I;
import best.a;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ac
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.WHITE);
        super.setFont(new Font("Arial", 0, 12));
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        super.setHorizontalTextPosition(11);
        I i2 = (I)object;
        if (object != null) {
            if (n3 == 0) {
                this.setText(((a)c.a.SR.R().get(i2.hM())).f());
            } else if (n3 == 1) {
                this.setHorizontalAlignment(4);
                super.setHorizontalTextPosition(2);
                this.setText(i2.hc().getNome());
                this.setIcon(i2.hc().kU());
            } else if (n3 == 3) {
                super.setHorizontalTextPosition(4);
                this.setHorizontalAlignment(2);
                this.setText(i2.hd().getNome());
                this.setIcon(i2.hd().kU());
            } else if (n3 == 4) {
                this.setHorizontalAlignment(4);
                this.setText(i2.hy().getNome());
            }
            if (i2.e()) {
                if (n3 == 2) {
                    String string = "";
                    string = Integer.toString(i2.hu());
                    String string2 = "";
                    string2 = Integer.toString(i2.hw());
                    int[] nArray = i2.hQ();
                    if (nArray[0] >= 0 && nArray[1] >= 0) {
                        string = String.valueOf(string) + "(" + Integer.toString(nArray[0]) + ") ";
                        string2 = String.valueOf(string2) + "(" + Integer.toString(nArray[1]) + ") ";
                    }
                    this.setText(String.valueOf(string) + "x" + string2);
                } else if (n3 == 5) {
                    if (i2.hU() > 0) {
                        this.setText(Integer.toString(i2.hU()));
                    }
                } else if (n3 == 6 && i2.hN() > 0) {
                    this.setText(C.a(i2.hN(), 0));
                }
            } else if (n3 == 2) {
                this.setText("x");
            }
        }
        return this;
    }
}

