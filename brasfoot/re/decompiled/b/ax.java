/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.F;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ax
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
            this.setText(f2.getNome());
        } else if (n3 == 2) {
            if (!a.SR.isHabilidadeIndividual()) {
                this.setText(Integer.toString(f2.fi()));
            } else {
                this.setText(Integer.toString(f2.gP()));
            }
        } else {
            if (n3 == 3) {
                return f2.a(Color.black);
            }
            if (n3 == 4) {
                this.setText(String.valueOf(aq.qN[f2.getCr1()]) + "/" + aq.qN[f2.getCr2()]);
            }
        }
        return this;
    }
}

