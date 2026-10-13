/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.ac;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ao
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        if (n3 == 0) {
            ImageIcon imageIcon = (Integer)object == 1 ? new ImageIcon(this.getClass().getResource("/aicons/player_shirt_greensmall.png")) : new ImageIcon(this.getClass().getResource("/aicons/player_shirt_graysmall.png"));
            this.setIcon(imageIcon);
            this.setText(null);
        } else if (n3 == 1) {
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/estrela.png"));
            ImageIcon imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/estrelared.png"));
            if ((Integer)object == 0) {
                this.setIcon(null);
                this.setText(null);
            } else if ((Integer)object == 1) {
                this.setIcon(imageIcon);
                this.setText(null);
            } else if ((Integer)object == 2) {
                this.setIcon(imageIcon2);
                this.setText(null);
            }
        } else if (n3 == 2) {
            this.setText((String)object);
            this.setIcon(null);
        } else if (n3 == 4) {
            String string = ac.valueOf("P" + object).jA();
            this.setText(string);
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + object + ".png"));
            this.setIcon(imageIcon);
        } else if (n3 == 5) {
            this.setHorizontalAlignment(0);
            this.setIcon(null);
        } else {
            this.setIcon(null);
        }
        return this;
    }
}

