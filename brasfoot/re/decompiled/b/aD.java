/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import components.i;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aD
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.WHITE);
        super.setBackground(aq.or);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        this.setFont(new Font("Arial", 0, 12));
        this.setHorizontalTextPosition(4);
        i i2 = (i)object;
        String string = "";
        if (i2 != null && i2.fb() != null) {
            if (n3 == 0) {
                String string2 = "";
                if (i2.tq()) {
                    string2 = " (" + i2.tp() + ")";
                }
                if (i2.fb().fT() >= 0) {
                    string = aq.rI[aq.sE[i2.fb().fT()][0]];
                }
                this.setText(String.valueOf(string) + " - " + i2.fb().getNome() + string2);
                if (i2.tm() > 0) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/esubs.png")));
                }
                if (i2.tq()) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/arrowright.png")));
                    this.setBackground(aq.os);
                } else if (i2.tr()) {
                    this.setHorizontalAlignment(4);
                    this.setHorizontalTextPosition(2);
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/arrowlfet.png")));
                }
            } else if (n3 == 1) {
                int n4;
                String string3 = "";
                if (i2.fb().gB() != null && (n4 = i2.fb().gB().cD()) > 0) {
                    String string4 = Integer.toString(n4);
                    if (n4 < 8) {
                        this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_chuteira" + string4 + ".png")));
                    } else {
                        this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_chuteira1.png")));
                    }
                }
            } else if (n3 == 2 && !i2.tr()) {
                if (i2.fb().gk() < 2.0) {
                    this.setText("sn");
                } else if (i2.fb().gk() < 10.0) {
                    this.setText(String.format("%.1f", i2.fb().gk()));
                } else if (i2.fb().gk() == 10.0) {
                    this.setText("10");
                }
            }
        } else if (i2.to() && n3 == 0) {
            this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.yellow));
            this.setText("Substitui\u00e7\u00f5es");
        }
        return this;
    }
}

