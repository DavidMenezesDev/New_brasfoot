/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import c.a;
import components.v;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aG
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        this.setForeground(Color.white);
        this.setBackground(aq.ot);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        v v2 = (v)object;
        if (v2.tR() != null) {
            if (n3 == 0) {
                this.setHorizontalAlignment(0);
                if (v2.tR().ev() != null) {
                    this.setText(String.valueOf(v2.tR().ev().dS()) + " | " + Integer.toString(v2.hU()));
                } else if (v2.ik() != null) {
                    this.setText(v2.ik());
                }
            } else if (n3 == 1) {
                this.setHorizontalAlignment(2);
                this.setBackground(v2.tR().hc().kB());
                this.setForeground(v2.tR().hc().kC());
                this.setText(v2.tR().hc().getNome());
                this.setIcon(v2.tR().hc().kU());
            } else if (n3 == 2) {
                this.setHorizontalAlignment(0);
                if (v2.ei() && a.SR.isUsaCorPlacar()) {
                    int n4 = a.SR.getCorPlacar();
                    int[] nArray = aq.oY[n4];
                    this.setBackground(new Color(nArray[0], nArray[1], nArray[2]));
                } else {
                    this.setBackground(new Color(84, 127, 59));
                }
                this.setForeground(Color.WHITE);
                this.setText(Integer.toString(v2.tT()));
            } else if (n3 == 3) {
                this.setHorizontalAlignment(0);
                if (v2.ei() && a.SR.isUsaCorPlacar()) {
                    int n5 = a.SR.getCorPlacar();
                    int[] nArray = aq.oY[n5];
                    this.setBackground(new Color(nArray[0], nArray[1], nArray[2]));
                } else {
                    this.setBackground(new Color(84, 127, 59));
                }
                this.setForeground(Color.WHITE);
                this.setText(Integer.toString(v2.tU()));
            } else if (n3 == 4) {
                this.setHorizontalAlignment(2);
                this.setBackground(v2.tR().hd().kB());
                this.setForeground(v2.tR().hd().kC());
                this.setText(v2.tR().hd().getNome());
                this.setIcon(v2.tR().hd().kU());
            } else if (n3 == 5) {
                this.setHorizontalAlignment(2);
                if (v2.tV() != null) {
                    if (v2.tV().et() == 0 && a.SR.isNegritoCasa()) {
                        super.setFont(new Font("Tahoma", 1, 11));
                    }
                    boolean bl4 = true;
                    if (v2.tV().b() == 6 && !v2.tR().hc().jZ().booleanValue() && !v2.tR().hd().jZ().booleanValue()) {
                        bl4 = false;
                    }
                    if (v2.tV().b() == 1 && v2.tV().el() == 3) {
                        bl4 = v2.tV().eu();
                    }
                    if (bl4) {
                        this.setText(v2.tV().er());
                        this.setIcon(v2.tV().es());
                    }
                }
            }
        } else if (n3 == 0 && v2.tS() != "") {
            this.setBackground(aq.ou);
            this.setHorizontalAlignment(2);
            this.setText(v2.tS());
        }
        return this;
    }
}

