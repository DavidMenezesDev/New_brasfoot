/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.aq;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ax
extends JPanel {
    private JLabel uF;

    public ax(String string) {
        this.mJ();
        this.uF.setText(string);
        if (c.a.vM().getCorTema() == 2) {
            this.uF.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        }
    }

    private void mJ() {
        this.uF = new JLabel();
        this.setBackground(new Color(0, 0, 0));
        this.setPreferredSize(new Dimension(470, 25));
        this.setLayout(new b());
        this.uF.setBackground(new Color(0, 0, 0));
        this.uF.setFont(new Font("Arial", 1, 12));
        this.uF.setForeground(new Color(239, 239, 239));
        this.uF.setHorizontalAlignment(0);
        this.uF.setText("Grupo A");
        this.uF.setOpaque(true);
        this.add((Component)this.uF, new a(0, 0, 470, 25));
    }
}

