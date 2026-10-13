/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import components.ad;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aC
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        ad ad2 = (ad)object;
        if (ad2 != null) {
            if (n3 == 0) {
                if (ad2.fg() != null) {
                    this.setText(aq.y(ad2.b(), ad2.fg().getPais()));
                }
            } else if (n3 == 1) {
                if (ad2.uC() == 1) {
                    this.setText("(" + Integer.toString(ad2.uy()) + "/" + Integer.toString(ad2.uz()) + "/" + Integer.toString(ad2.uA()) + ")");
                } else if (ad2.uC() == 2) {
                    this.setText(Integer.toString(ad2.uy()));
                }
            }
        }
        return this;
    }
}

