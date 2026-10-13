/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.X;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aq
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        X x2 = (X)object;
        if (x2 != null) {
            if (x2.et() == 1) {
                if (x2.ut() >= 0 && n3 == 0) {
                    ImageIcon imageIcon;
                    if (x2.ut() == 0) {
                        imageIcon = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_vermelha.png"));
                        this.setIcon(imageIcon);
                    }
                    if (x2.ut() == 1) {
                        imageIcon = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_verde.png"));
                        this.setIcon(imageIcon);
                    }
                }
                if (n3 == 1) {
                    this.setHorizontalAlignment(2);
                    this.setText(x2.x().getNome());
                }
            } else if (x2.et() == 2) {
                if (x2.ut() >= 0 && n3 == 3) {
                    ImageIcon imageIcon;
                    if (x2.ut() == 0) {
                        imageIcon = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_vermelha.png"));
                        this.setIcon(imageIcon);
                    }
                    if (x2.ut() == 1) {
                        imageIcon = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_verde.png"));
                        this.setIcon(imageIcon);
                    }
                }
                if (n3 == 2) {
                    this.setHorizontalAlignment(4);
                    this.setText(x2.x().getNome());
                }
            }
        }
        return this;
    }
}

