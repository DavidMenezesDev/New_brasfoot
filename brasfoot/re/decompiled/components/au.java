/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.ac;
import components.a;
import components.b;
import components.e;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class au
extends JPanel {
    private JLabel Sg;
    private JLabel Sh;
    private JLabel Si;
    private JLabel Sj;
    private JLabel Sk;
    private JLabel Sl;
    private JLabel yE;
    private JLabel uF;
    private JLabel Sm;
    private JLabel Sn;
    private JLabel So;

    public au(e e2) {
        this.mJ();
        this.Sg.setText(e2.tc());
        if (e2.fg() != null) {
            this.uF.setText(e2.fg().getNome());
            this.uF.setIcon(e2.fg().kU());
            if (e2.b() == 4 || e2.b() == 6 || e2.b() == 12) {
                this.uF.setToolTipText(ac.bl(e2.fg().getPais()));
            }
        }
        int[] nArray = e2.ta();
        this.Sm.setText(Integer.toString(nArray[0]));
        this.yE.setText(Integer.toString(nArray[1]));
        this.So.setText(Integer.toString(nArray[2]));
        this.Sj.setText(Integer.toString(nArray[3]));
        this.Si.setText(Integer.toString(nArray[4]));
        this.Sl.setText(Integer.toString(nArray[5]));
        this.Sk.setText(Integer.toString(nArray[6]));
        this.Sn.setText(Integer.toString(nArray[7]));
        if (e2.td() == 1) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verde.png")));
        } else if (e2.td() == 3) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verm.png")));
        } else if (e2.td() == 4) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/azul.png")));
        } else if (e2.td() == 5) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/azul2.png")));
        } else if (e2.td() == 2) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/amarelo.png")));
        } else if (e2.td() == 6) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/amarelo2.png")));
        } else if (e2.td() == 301) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/vermazul.png")));
        } else if (e2.td() == 302) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/vermazulclaro.png")));
        } else if (e2.td() == 306) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/vermamarelo.png")));
        } else if (e2.td() == 101) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verdeazul.png")));
        } else if (e2.td() == 102) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verdeazulclaro.png")));
        } else if (e2.td() == 106) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/verdeamarelo.png")));
        } else if (e2.td() == 12000) {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/rosa.png")));
        } else {
            this.Sh.setIcon(new ImageIcon(this.getClass().getResource("/aiconsc/cinza.png")));
        }
    }

    private void mJ() {
        this.Sh = new JLabel();
        this.uF = new JLabel();
        this.Sg = new JLabel();
        this.Si = new JLabel();
        this.Sn = new JLabel();
        this.yE = new JLabel();
        this.So = new JLabel();
        this.Sj = new JLabel();
        this.Sm = new JLabel();
        this.Sl = new JLabel();
        this.Sk = new JLabel();
        this.setBackground(new Color(228, 227, 227));
        this.setPreferredSize(new Dimension(470, 25));
        this.setLayout(new b());
        this.add((Component)this.Sh, new a(25, 0, 5, 25));
        this.uF.setFont(new Font("Arial", 1, 12));
        this.uF.setText("Internacional de Limeira");
        this.add((Component)this.uF, new a(40, 0, 170, 25));
        this.Sg.setFont(new Font("Arial", 1, 12));
        this.Sg.setHorizontalAlignment(0);
        this.Sg.setText("10");
        this.add((Component)this.Sg, new a(0, 0, 20, 25));
        this.Si.setFont(new Font("Arial", 1, 12));
        this.Si.setHorizontalAlignment(0);
        this.Si.setText("0");
        this.Si.setToolTipText("");
        this.add((Component)this.Si, new a(330, 0, 30, 25));
        this.Sn.setFont(new Font("Arial", 1, 12));
        this.Sn.setHorizontalAlignment(0);
        this.Sn.setText("0");
        this.Sn.setToolTipText("");
        this.add((Component)this.Sn, new a(435, 0, 30, 25));
        this.yE.setFont(new Font("Arial", 1, 12));
        this.yE.setHorizontalAlignment(0);
        this.yE.setText("0");
        this.yE.setToolTipText("");
        this.add((Component)this.yE, new a(240, 0, 30, 25));
        this.So.setFont(new Font("Arial", 1, 12));
        this.So.setHorizontalAlignment(0);
        this.So.setText("0");
        this.So.setToolTipText("");
        this.add((Component)this.So, new a(270, 0, 30, 25));
        this.Sj.setFont(new Font("Arial", 1, 12));
        this.Sj.setHorizontalAlignment(0);
        this.Sj.setText("0");
        this.Sj.setToolTipText("");
        this.add((Component)this.Sj, new a(300, 0, 30, 25));
        this.Sm.setFont(new Font("Arial", 1, 12));
        this.Sm.setHorizontalAlignment(0);
        this.Sm.setText("0");
        this.Sm.setToolTipText("");
        this.Sm.setOpaque(true);
        this.add((Component)this.Sm, new a(210, 0, 30, 25));
        this.Sl.setFont(new Font("Arial", 1, 12));
        this.Sl.setHorizontalAlignment(0);
        this.Sl.setText("0");
        this.Sl.setToolTipText("");
        this.Sl.setOpaque(true);
        this.add((Component)this.Sl, new a(365, 0, 30, 25));
        this.Sk.setFont(new Font("Arial", 1, 12));
        this.Sk.setHorizontalAlignment(0);
        this.Sk.setText("0");
        this.Sk.setToolTipText("");
        this.add((Component)this.Sk, new a(400, 0, 30, 25));
    }
}

