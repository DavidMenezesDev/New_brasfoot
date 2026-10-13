/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.aq;
import components.e;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class a
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        MatteBorder matteBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
        super.setBorder(matteBorder);
        e e2 = (e)object;
        if (e2.fg() != null || e2.te()) {
            if (n3 == 0) {
                this.setHorizontalAlignment(2);
                this.setText(e2.tc());
            } else if (n3 == 1) {
                if (e2.fg() != null) {
                    ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aiconsc/" + aq.pr[e2.td()] + ".png"));
                    this.setIcon(imageIcon);
                }
            } else if (n3 == 2) {
                if (e2.fg() != null) {
                    this.setIcon(e2.fg().kU());
                    this.setHorizontalAlignment(2);
                    this.setText(e2.fg().getNome());
                } else {
                    this.setText(e2.getInfo());
                }
            } else if (n3 >= 3) {
                this.setText(Integer.toString(e2.ta()[n3 - 3]));
            }
        } else if (e2.tb()) {
            if (n3 == 2) {
                this.setHorizontalAlignment(2);
                super.setFont(new Font("Tahoma", 1, 12));
                this.setText(e2.getInfo());
            }
        } else if (e2.tg()) {
            if (n3 == 2) {
                this.setHorizontalAlignment(2);
                this.setText(e2.tc());
            }
        } else if (e2.tf() != null) {
            if (n3 == 2) {
                this.setHorizontalAlignment(2);
                this.setText(e2.tf().getNome());
                this.setIcon(e2.tf().kU());
            }
        } else {
            String[] stringArray = new String[]{"", "", "", "PG", "J", "V", "E", "D", "GP", "GC", "SG"};
            if (n3 < stringArray.length) {
                this.setText(stringArray[n3]);
            }
        }
        return this;
    }
}

