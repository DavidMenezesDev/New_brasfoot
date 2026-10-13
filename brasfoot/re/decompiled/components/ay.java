/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.hw;
import components.a;
import components.af;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ay
extends JPanel {
    hw Sv = null;
    private JPanel vd;
    private JLabel Sw;
    private JLabel Si;
    private JLabel Sj;
    private JLabel wm;
    private JLabel Sk;
    private JLabel Sl;
    private JLabel yE;
    private JLabel Sx;
    private JLabel So;

    public ay(int n2, af af2, hw hw2) {
        this.Sv = hw2;
        if (n2 == 1) {
            this.mJ();
            if (af2 != null) {
                this.b(af2);
            }
        }
        if (n2 == 2) {
            this.vy();
            if (af2 != null) {
                this.a(af2);
            }
        } else if (n2 == 0) {
            this.ui();
        }
    }

    private void us() {
        this.Sv.a(this);
    }

    public void aI(boolean bl2) {
        if (bl2) {
            this.setBackground(new Color(211, 191, 22));
        } else {
            this.setBackground(new Color(228, 227, 227));
        }
    }

    private void a(af af2) {
        this.wm.setText("Total em " + af2.uD() + ":");
        this.yE.setText(Integer.toString(af2.w()));
        this.So.setText(Integer.toString(af2.cm()));
        this.Sj.setText(Integer.toString(af2.uF()));
        this.Si.setText(Integer.toString(af2.co()));
        this.Sl.setText(Integer.toString(af2.ls()));
        this.Sk.setText(Integer.toString(af2.lt()));
    }

    private void b(af af2) {
        this.Sw.setText(af2.uD());
        this.Sx.setText(af2.tZ());
        this.wm.setText(af2.uG());
        this.yE.setText(Integer.toString(af2.w()));
        this.So.setText(Integer.toString(af2.cm()));
        this.Sj.setText(Integer.toString(af2.uF()));
        this.Si.setText(Integer.toString(af2.co()));
        this.Sl.setText(Integer.toString(af2.ls()));
        this.Sk.setText(Integer.toString(af2.lt()));
        if (af2.lw() == 1) {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_sobe.png")));
        } else if (af2.lw() == 0) {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_desce.png")));
        } else if (af2.lx()) {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_ch.png")));
        } else if (af2.ly()) {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_vice.png")));
        } else if (af2.lz()) {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_eli.png")));
        } else if (af2.ly()) {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_vice.png")));
        } else {
            this.wm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_nulo.png")));
        }
    }

    private void mJ() {
        this.wm = new JLabel();
        this.Sw = new JLabel();
        this.Si = new JLabel();
        this.yE = new JLabel();
        this.So = new JLabel();
        this.Sj = new JLabel();
        this.Sk = new JLabel();
        this.Sl = new JLabel();
        this.Sx = new JLabel();
        this.setBackground(new Color(228, 227, 227));
        this.setPreferredSize(new Dimension(680, 25));
        this.setLayout(new b());
        this.wm.setFont(new Font("Arial", 1, 12));
        this.wm.setText("");
        this.add((Component)this.wm, new a(250, 0, 180, 25));
        this.Sw.setFont(new Font("Arial", 1, 12));
        this.Sw.setHorizontalAlignment(0);
        this.Sw.setText("2022");
        this.add((Component)this.Sw, new a(0, 0, 50, 25));
        this.Si.setFont(new Font("Arial", 1, 12));
        this.Si.setHorizontalAlignment(0);
        this.Si.setText("100");
        this.Si.setToolTipText("");
        this.add((Component)this.Si, new a(550, 0, 30, 25));
        this.yE.setFont(new Font("Arial", 1, 12));
        this.yE.setHorizontalAlignment(0);
        this.yE.setText("100");
        this.yE.setToolTipText("");
        this.add((Component)this.yE, new a(450, 0, 30, 25));
        this.So.setFont(new Font("Arial", 1, 12));
        this.So.setHorizontalAlignment(0);
        this.So.setText("100");
        this.So.setToolTipText("");
        this.add((Component)this.So, new a(490, 0, 30, 25));
        this.Sj.setFont(new Font("Arial", 1, 12));
        this.Sj.setHorizontalAlignment(0);
        this.Sj.setText("100");
        this.Sj.setToolTipText("");
        this.add((Component)this.Sj, new a(520, 0, 30, 25));
        this.Sk.setBackground(new Color(233, 239, 240));
        this.Sk.setFont(new Font("Arial", 1, 12));
        this.Sk.setHorizontalAlignment(0);
        this.Sk.setText("100");
        this.Sk.setToolTipText("");
        this.Sk.setOpaque(true);
        this.add((Component)this.Sk, new a(620, 0, 30, 25));
        this.Sl.setBackground(new Color(239, 231, 227));
        this.Sl.setFont(new Font("Arial", 1, 12));
        this.Sl.setHorizontalAlignment(0);
        this.Sl.setText("100");
        this.Sl.setToolTipText("");
        this.Sl.setOpaque(true);
        this.add((Component)this.Sl, new a(580, 0, 30, 25));
        this.Sx.setFont(new Font("Arial", 1, 12));
        this.Sx.setText("");
        this.add((Component)this.Sx, new a(60, 0, 170, 25));
    }

    private void ui() {
        this.vd = new JPanel();
        this.Sw = new JLabel();
        this.Sx = new JLabel();
        this.wm = new JLabel();
        this.yE = new JLabel();
        this.So = new JLabel();
        this.Sj = new JLabel();
        this.Si = new JLabel();
        this.Sl = new JLabel();
        this.Sk = new JLabel();
        this.setBackground(new Color(0, 0, 0));
        this.setPreferredSize(new Dimension(480, 25));
        this.setLayout(new b());
        this.vd.setBackground(new Color(0, 0, 0));
        this.vd.setPreferredSize(new Dimension(690, 25));
        this.vd.setLayout(new b());
        this.Sw.setFont(new Font("Arial", 1, 12));
        this.Sw.setForeground(new Color(239, 239, 239));
        this.Sw.setHorizontalAlignment(0);
        this.Sw.setText("Ano");
        this.vd.add((Component)this.Sw, new a(0, 0, 50, 25));
        this.Sx.setFont(new Font("Arial", 1, 12));
        this.Sx.setForeground(new Color(239, 239, 239));
        this.Sx.setText("Competi\u00e7\u00e3o");
        this.vd.add((Component)this.Sx, new a(60, 0, 170, 25));
        this.wm.setFont(new Font("Arial", 1, 12));
        this.wm.setForeground(new Color(239, 239, 239));
        this.wm.setText("Coloca\u00e7\u00e3o");
        this.vd.add((Component)this.wm, new a(250, 0, 180, 25));
        this.yE.setFont(new Font("Arial", 1, 12));
        this.yE.setForeground(new Color(239, 239, 239));
        this.yE.setHorizontalAlignment(0);
        this.yE.setText("J");
        this.yE.setToolTipText("");
        this.vd.add((Component)this.yE, new a(450, 0, 30, 25));
        this.So.setFont(new Font("Arial", 1, 12));
        this.So.setForeground(new Color(239, 239, 239));
        this.So.setHorizontalAlignment(0);
        this.So.setText("V");
        this.So.setToolTipText("");
        this.vd.add((Component)this.So, new a(490, 0, 30, 25));
        this.Sj.setFont(new Font("Arial", 1, 12));
        this.Sj.setForeground(new Color(239, 239, 239));
        this.Sj.setHorizontalAlignment(0);
        this.Sj.setText("E");
        this.Sj.setToolTipText("");
        this.vd.add((Component)this.Sj, new a(520, 0, 30, 25));
        this.Si.setFont(new Font("Arial", 1, 12));
        this.Si.setForeground(new Color(239, 239, 239));
        this.Si.setHorizontalAlignment(0);
        this.Si.setText("D");
        this.Si.setToolTipText("");
        this.vd.add((Component)this.Si, new a(550, 0, 30, 25));
        this.Sl.setFont(new Font("Arial", 1, 12));
        this.Sl.setForeground(new Color(239, 239, 239));
        this.Sl.setHorizontalAlignment(0);
        this.Sl.setText("GP");
        this.Sl.setToolTipText("");
        this.vd.add((Component)this.Sl, new a(580, 0, 30, 25));
        this.Sk.setFont(new Font("Arial", 1, 12));
        this.Sk.setForeground(new Color(239, 239, 239));
        this.Sk.setHorizontalAlignment(0);
        this.Sk.setText("GC");
        this.Sk.setToolTipText("");
        this.vd.add((Component)this.Sk, new a(620, 0, 30, 25));
        this.add((Component)this.vd, new a(0, 0, -1, -1));
    }

    private void vy() {
        this.wm = new JLabel();
        this.Si = new JLabel();
        this.yE = new JLabel();
        this.So = new JLabel();
        this.Sj = new JLabel();
        this.Sk = new JLabel();
        this.Sl = new JLabel();
        this.setBackground(new Color(228, 227, 227));
        this.setPreferredSize(new Dimension(670, 25));
        this.setLayout(new b());
        this.wm.setFont(new Font("Arial", 1, 12));
        this.wm.setHorizontalAlignment(4);
        this.wm.setText("Total:");
        this.add((Component)this.wm, new a(250, 0, 180, 25));
        this.Si.setFont(new Font("Arial", 1, 12));
        this.Si.setHorizontalAlignment(0);
        this.Si.setText("100");
        this.Si.setToolTipText("");
        this.add((Component)this.Si, new a(550, 0, 30, 25));
        this.yE.setFont(new Font("Arial", 1, 12));
        this.yE.setHorizontalAlignment(0);
        this.yE.setText("100");
        this.yE.setToolTipText("");
        this.add((Component)this.yE, new a(450, 0, 30, 25));
        this.So.setFont(new Font("Arial", 1, 12));
        this.So.setHorizontalAlignment(0);
        this.So.setText("100");
        this.So.setToolTipText("");
        this.add((Component)this.So, new a(490, 0, 30, 25));
        this.Sj.setFont(new Font("Arial", 1, 12));
        this.Sj.setHorizontalAlignment(0);
        this.Sj.setText("100");
        this.Sj.setToolTipText("");
        this.add((Component)this.Sj, new a(520, 0, 30, 25));
        this.Sk.setBackground(new Color(233, 239, 240));
        this.Sk.setFont(new Font("Arial", 1, 12));
        this.Sk.setHorizontalAlignment(0);
        this.Sk.setText("100");
        this.Sk.setToolTipText("");
        this.Sk.setOpaque(true);
        this.add((Component)this.Sk, new a(620, 0, 30, 25));
        this.Sl.setBackground(new Color(239, 231, 227));
        this.Sl.setFont(new Font("Arial", 1, 12));
        this.Sl.setHorizontalAlignment(0);
        this.Sl.setText("100");
        this.Sl.setToolTipText("");
        this.Sl.setOpaque(true);
        this.add((Component)this.Sl, new a(580, 0, 30, 25));
    }
}

