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

public class aw
extends JPanel {
    private JLabel Si;
    private JLabel Sj;
    private JLabel Sk;
    private JLabel Sl;
    private JLabel yE;
    private JLabel uF;
    private JLabel Sm;
    private JLabel Sn;
    private JLabel So;

    public aw(String string) {
        this.mJ();
        this.uF.setText(string);
        if (c.a.vM().getCorTema() == 2) {
            this.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        }
    }

    private void mJ() {
        this.uF = new JLabel();
        this.Sn = new JLabel();
        this.Sk = new JLabel();
        this.Sl = new JLabel();
        this.Si = new JLabel();
        this.Sj = new JLabel();
        this.So = new JLabel();
        this.yE = new JLabel();
        this.Sm = new JLabel();
        this.setBackground(new Color(0, 0, 0));
        this.setPreferredSize(new Dimension(470, 25));
        this.setLayout(new b());
        this.uF.setFont(new Font("Arial", 1, 12));
        this.uF.setForeground(new Color(239, 239, 239));
        this.uF.setHorizontalAlignment(0);
        this.uF.setText("Grupo A");
        this.uF.setOpaque(false);
        this.add((Component)this.uF, new a(0, 0, 210, 25));
        this.Sn.setFont(new Font("Arial", 1, 12));
        this.Sn.setForeground(new Color(239, 239, 239));
        this.Sn.setHorizontalAlignment(0);
        this.Sn.setText("SG");
        this.Sn.setToolTipText("");
        this.Sn.setOpaque(false);
        this.add((Component)this.Sn, new a(435, 0, 30, 25));
        this.Sk.setFont(new Font("Arial", 1, 12));
        this.Sk.setForeground(new Color(239, 239, 239));
        this.Sk.setHorizontalAlignment(0);
        this.Sk.setText("GC");
        this.Sk.setToolTipText("");
        this.Sk.setOpaque(false);
        this.add((Component)this.Sk, new a(400, 0, 30, 25));
        this.Sl.setFont(new Font("Arial", 1, 12));
        this.Sl.setForeground(new Color(239, 239, 239));
        this.Sl.setHorizontalAlignment(0);
        this.Sl.setText("GP");
        this.Sl.setToolTipText("");
        this.Sl.setOpaque(false);
        this.add((Component)this.Sl, new a(365, 0, 30, 25));
        this.Si.setFont(new Font("Arial", 1, 12));
        this.Si.setForeground(new Color(239, 239, 239));
        this.Si.setHorizontalAlignment(0);
        this.Si.setText("D");
        this.Si.setToolTipText("");
        this.Si.setOpaque(false);
        this.add((Component)this.Si, new a(330, 0, 30, 25));
        this.Sj.setFont(new Font("Arial", 1, 12));
        this.Sj.setForeground(new Color(239, 239, 239));
        this.Sj.setHorizontalAlignment(0);
        this.Sj.setText("E");
        this.Sj.setToolTipText("");
        this.Sj.setOpaque(false);
        this.add((Component)this.Sj, new a(300, 0, 30, 25));
        this.So.setFont(new Font("Arial", 1, 12));
        this.So.setForeground(new Color(239, 239, 239));
        this.So.setHorizontalAlignment(0);
        this.So.setText("V");
        this.So.setToolTipText("");
        this.So.setOpaque(false);
        this.add((Component)this.So, new a(270, 0, 30, 25));
        this.yE.setFont(new Font("Arial", 1, 12));
        this.yE.setForeground(new Color(239, 239, 239));
        this.yE.setHorizontalAlignment(0);
        this.yE.setText("J");
        this.yE.setToolTipText("");
        this.yE.setOpaque(false);
        this.add((Component)this.yE, new a(240, 0, 30, 25));
        this.Sm.setFont(new Font("Arial", 1, 12));
        this.Sm.setForeground(new Color(239, 239, 239));
        this.Sm.setHorizontalAlignment(0);
        this.Sm.setText("PG");
        this.Sm.setToolTipText("");
        this.Sm.setOpaque(false);
        this.add((Component)this.Sm, new a(210, 0, 30, 25));
    }
}

