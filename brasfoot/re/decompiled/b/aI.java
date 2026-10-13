/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.C;
import best.F;
import best.ac;
import best.aq;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aI
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        F f2 = (F)object;
        if (f2 != null) {
            if (n3 == 0) {
                this.setIcon(f2.fS());
            } else if (n3 == 1) {
                this.setHorizontalAlignment(0);
                this.setText(aq.rI[f2.getPosicao()]);
            } else if (n3 == 2) {
                this.setHorizontalAlignment(2);
                String string = ac.valueOf("P" + f2.getPais()).jA();
                this.setText(string);
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + f2.getPais() + ".png"));
                this.setIcon(imageIcon);
            } else if (n3 == 3) {
                this.setHorizontalAlignment(2);
                this.setText(f2.getNome());
            } else if (n3 == 4) {
                this.setText(Integer.toString(f2.getIdade()));
            }
            if (n3 == 5) {
                this.setHorizontalAlignment(0);
                this.setText(aq.rK[f2.getLado()]);
            } else if (n3 == 6) {
                return f2.go();
            }
            if (n3 == 7) {
                this.setHorizontalAlignment(0);
                if (f2.fD() <= 1) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e1.png")));
                } else if (f2.fD() == 2) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e1.png")));
                } else if (f2.fD() == 3) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e15.png")));
                } else if (f2.fD() == 4) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e2.png")));
                } else if (f2.fD() == 5) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e25.png")));
                } else if (f2.fD() == 6) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e3.png")));
                } else if (f2.fD() == 7) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e35.png")));
                } else if (f2.fD() == 8) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e4.png")));
                } else if (f2.fD() == 9) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e45.png")));
                } else if (f2.fD() == 10) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e5.png")));
                }
            } else if (n3 == 8) {
                this.setText(String.valueOf(aq.qN[f2.getCr1()]) + "/" + aq.qN[f2.getCr2()]);
            } else if (n3 == 9) {
                this.setText(C.a(f2.fk(), 0));
            } else if (n3 == 10) {
                this.setText(C.a(f2.fj(), 0));
            }
        }
        return this;
    }
}

