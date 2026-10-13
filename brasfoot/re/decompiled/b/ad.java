/*
 * Decompiled with CFR 0.152.
 */
package b;

import c.a;
import components.ap;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ad
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
        if (ap2 != null) {
            if (ap2.tt()) {
                if (n3 == 0) {
                    this.setHorizontalAlignment(4);
                    ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + ap2.vl().jc() + ".png"));
                    this.setIcon(imageIcon);
                } else if (n3 == 1) {
                    this.setFont(new Font("Helvetica", 1, 12));
                    if (ap2.vl() != null) {
                        this.setText(ap2.vl().jf());
                    }
                }
            } else if (n3 == 0) {
                this.setHorizontalAlignment(0);
                this.setText(Integer.toString(ap2.H() + a.SR.iU()));
            } else if (n3 == 1) {
                this.setIcon(ap2.ce().kU());
                this.setText(ap2.ce().getNome());
            } else if (n3 == 2) {
                this.setIcon(ap2.cf().kU());
                this.setText(ap2.cf().getNome());
            } else if (n3 == 3) {
                String string = "";
                if (ap2.ch() != null) {
                    this.setIcon(ap2.ch().kU());
                    string = "(" + ap2.ch().getNome() + ")";
                }
                if (ap2.cg() != null) {
                    this.setText(String.valueOf(ap2.cg()) + string + " - " + Integer.toString(ap2.y()) + " g");
                }
            } else if (n3 == 4 && ap2.ci() != null) {
                this.setText(ap2.ci().dS());
            }
        }
        return this;
    }
}

