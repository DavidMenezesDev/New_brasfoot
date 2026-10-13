/*
 * Decompiled with CFR 0.152.
 */
package b;

import c.a;
import components.af;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class aE
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        af af2 = (af)object;
        if (af2 != null) {
            if (af2.tt()) {
                this.setFont(new Font("Helvetica", 1, 11));
                MatteBorder matteBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
                super.setBorder(matteBorder);
            }
            if (n3 == 0 && !af2.tt()) {
                this.setHorizontalAlignment(2);
                this.setText(Integer.toString(af2.H() + a.SR.iU()));
            } else if (n3 == 1 && !af2.tt()) {
                this.setHorizontalAlignment(2);
                this.setText(af2.tZ());
            } else if (n3 == 2 && !af2.tt()) {
                this.setHorizontalAlignment(2);
                this.setText(af2.uG());
            } else if (n3 == 2 && af2.tt()) {
                this.setHorizontalAlignment(4);
                this.setText("Total em " + Integer.toString(af2.H() + a.SR.iU()) + ":");
            } else if (n3 == 3) {
                this.setText(Integer.toString(af2.w()));
            } else if (n3 == 4) {
                this.setText(Integer.toString(af2.cm()));
            } else if (n3 == 5) {
                this.setText(Integer.toString(af2.co()));
            } else if (n3 == 6) {
                this.setText(Integer.toString(af2.uF()));
            } else if (n3 == 7) {
                this.setText(Integer.toString(af2.ls()));
            } else if (n3 == 8) {
                this.setText(Integer.toString(af2.lt()));
            } else if (n3 == 9) {
                this.setHorizontalAlignment(2);
                this.setText(af2.uE());
            }
        }
        return this;
    }
}

