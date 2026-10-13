/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.ac;
import best.ah;
import best.aq;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aV
extends DefaultTableCellRenderer {
    private int w = 0;

    public aV(int n2) {
        this.w = n2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        ah ah2 = (ah)object;
        if (ah2 != null) {
            if (this.w < 2) {
                if (n3 == 0) {
                    this.setText(Integer.toString(n2 + 1));
                } else if (n3 == 1) {
                    this.setText(ah2.getNome());
                    this.setIcon(ah2.kU());
                } else if (n3 == 2) {
                    if (this.w == 0) {
                        this.setText(String.valueOf(String.valueOf(ah2.getDivisao())) + "\u00aa div.");
                        super.setToolTipText(ac.bl(ah2.getPais()));
                        this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + ah2.getPais() + ".png")));
                    } else {
                        this.setText(aq.aeH[ah2.gg()]);
                    }
                }
            } else if (this.w == 2) {
                if (n3 == 0) {
                    this.setText(Integer.toString(n2 + 1));
                } else if (n3 == 1) {
                    this.setText(ah2.getNome());
                    this.setIcon(ah2.kU());
                } else if (n3 == 2) {
                    if (ah2.Au() == 0) {
                        this.setText("Grupo A");
                    } else if (ah2.Au() == 1) {
                        this.setText("Grupo B");
                    } else {
                        this.setText("");
                    }
                }
                if (ah2.Au() >= 0) {
                    super.setForeground(Color.BLACK);
                } else {
                    super.setForeground(new Color(165, 18, 36));
                }
            }
        }
        return this;
    }
}

