/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.C;
import best.F;
import best.ac;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ay
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
        if (n3 == 0) {
            this.setHorizontalAlignment(0);
            this.setText(aq.rI[f2.getPosicao()]);
        } else if (n3 == 1) {
            this.setHorizontalAlignment(2);
            String string = ac.valueOf("P" + f2.getPais()).jA();
            this.setText(string);
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + f2.getPais() + ".png"));
            this.setIcon(imageIcon);
        } else if (n3 == 2) {
            this.setHorizontalAlignment(2);
            this.setText(f2.getNome());
            if (f2.gm().booleanValue()) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrelared.png")));
            } else if (f2.ff().booleanValue()) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrela.png")));
            }
        } else if (n3 == 3) {
            this.setHorizontalAlignment(2);
            if (f2.fg() != null) {
                this.setText(f2.fg().getNome());
            }
        } else if (n3 == 4) {
            this.setHorizontalAlignment(0);
            this.setText(aq.rK[f2.getLado()]);
        }
        if (!a.SR.isHabilidadeIndividual()) {
            if (n3 == 5) {
                this.setText(Integer.toString(f2.fi()));
            } else if (n3 == 6) {
                this.setText(C.a(f2.fj(), 0));
            } else if (n3 == 7) {
                this.setText(C.a(f2.fk(), 0));
            } else if (n3 == 8) {
                this.setText(String.valueOf(aq.qN[f2.getCr1()]) + "/" + aq.qN[f2.getCr2()]);
            } else if (n3 == 9) {
                this.setText(Integer.toString(f2.gy()));
            } else if (n3 == 10) {
                this.setText(Integer.toString(f2.getIdade()));
            } else if (n3 == 11) {
                if (f2.ft().booleanValue()) {
                    this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
                }
            } else if (n3 == 12 && f2.fz().booleanValue()) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
            }
        } else if (n3 == 5) {
            this.setText(Integer.toString(f2.gK()));
        } else if (n3 == 6) {
            this.setText(Integer.toString(f2.gN()));
        } else if (n3 == 7) {
            this.setText(Integer.toString(f2.gO()));
        } else if (n3 == 8) {
            this.setText(Integer.toString(f2.gP()));
        } else if (n3 == 9) {
            this.setText(Integer.toString(f2.gJ()));
        } else if (n3 == 10) {
            this.setText(Integer.toString(f2.gL()));
        } else if (n3 == 11) {
            this.setText(Integer.toString(f2.gM()));
        } else if (n3 == 12) {
            this.setText(C.a(f2.fj(), 0));
        } else if (n3 == 13) {
            this.setText(C.a(f2.fk(), 0));
        } else if (n3 == 14) {
            this.setText(String.valueOf(aq.qN[f2.getCr1()]) + "/" + aq.qN[f2.getCr2()]);
        } else if (n3 == 15) {
            this.setText(Integer.toString(f2.gy()));
        } else if (n3 == 16) {
            this.setText(Integer.toString(f2.getIdade()));
        } else if (n3 == 17) {
            if (f2.ft().booleanValue()) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
            }
        } else if (n3 == 18 && f2.fz().booleanValue()) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
        }
        return this;
    }
}

