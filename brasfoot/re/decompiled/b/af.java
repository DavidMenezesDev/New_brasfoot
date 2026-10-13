/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.w;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class af
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        super.setVerticalAlignment(1);
        this.setIcon(null);
        this.setText("");
        w w2 = (w)object;
        if (object != null) {
            if (!w2.to()) {
                if (n3 == 0) {
                    this.setHorizontalAlignment(4);
                    this.setHorizontalTextPosition(2);
                    this.setText(w2.tR().hc().getNome());
                    this.setIcon(w2.tR().hc().kU());
                } else if (n3 == 2) {
                    this.setHorizontalAlignment(2);
                    this.setHorizontalTextPosition(4);
                    this.setText(w2.tR().hd().getNome());
                    this.setIcon(w2.tR().hd().kU());
                }
                if (n3 == 1) {
                    if (w2.tR().e()) {
                        String string = "";
                        string = Integer.toString(w2.tR().hu());
                        String string2 = "";
                        string2 = Integer.toString(w2.tR().hw());
                        this.setText(String.valueOf(string) + "x" + string2);
                    } else {
                        this.setText("x");
                    }
                }
            } else if (n3 == 0) {
                this.setFont(new Font("Arial", 1, 12));
                this.setText(w2.sT());
            }
        }
        return this;
    }
}

