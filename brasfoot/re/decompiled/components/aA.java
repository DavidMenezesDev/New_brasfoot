/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.aq;
import components.aB;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aA
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        aB aB2 = (aB)object;
        if (aB2 != null) {
            if (n3 == 0) {
                if (aB2.getEstado() >= 100) {
                    this.setText(aB2.sT());
                } else if (aB2.getEstado() >= 0) {
                    ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aesticons/" + Integer.toString(aB2.getEstado()) + ".png"));
                    this.setIcon(imageIcon);
                    this.setText(aq.rX[aB2.getEstado()]);
                } else if (!aB2.to()) {
                    if (aB2.et() == 1) {
                        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aeicons/ic_champion.png"));
                        this.setIcon(imageIcon);
                    } else if (aB2.et() == 2) {
                        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aeicons/ic_vice.png"));
                        this.setIcon(imageIcon);
                    } else if (aB2.et() == 3) {
                        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aeicons/ic_art.png"));
                        this.setIcon(imageIcon);
                    } else {
                        this.setText(aB2.sT());
                    }
                }
            } else if (n3 == 1) {
                if (aB2.getEstado() >= 100) {
                    this.setText(aB2.sT());
                } else if (aB2.getEstado() >= 0) {
                    this.setText(aq.rY[aB2.getEstado()]);
                } else if (aB2.to()) {
                    this.setText(aB2.sT());
                    this.setFont(new Font("Tahoma", 1, 11));
                } else if (aB2.cu() != null) {
                    if (aB2.vA() == null) {
                        this.setText(aB2.cu().getNome());
                    } else {
                        this.setText(aB2.vA());
                    }
                    this.setIcon(aB2.cu().kU());
                }
            } else if (n3 == 2) {
                if (aB2.vA() != null) {
                    this.setText(String.valueOf(aB2.vz()) + " gols");
                } else {
                    this.setText(aB2.vz());
                }
            }
        }
        return this;
    }
}

