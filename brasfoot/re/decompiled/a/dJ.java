/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gw;
import best.ah;
import best.aq;
import best.at;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dJ
extends JPanel {
    private JDialog ub = null;
    private at aeJ = null;
    private JLabel ug;
    private JLabel uh;
    private JLabel zM;
    private JLabel Sx;
    private JLabel Fs;
    private JLabel uu;
    private JLabel Ow;

    public dJ(JDialog jDialog, ah ah2, at at2, int n2) {
        this.ub = jDialog;
        this.aeJ = at2;
        this.mJ();
        this.mH();
        this.uu.setText(ah2.getNome());
        this.uu.setIcon(ah2.kU());
        if (ah2.ka() != null) {
            this.Fs.setText(ah2.ka().dS());
        }
        this.Sx.setText(at2.getNome());
        this.nq();
    }

    private void nq() {
        String[] stringArray = this.aeJ.mA();
        ImageIcon imageIcon = aq.a(aq.x(stringArray[0]), 60, 82);
        this.Ow.setIcon(imageIcon);
    }

    public void mH() {
        this.uh.addMouseListener(new gw(this));
    }

    private void mJ() {
        this.uh = new JLabel();
        this.ug = new JLabel();
        this.uu = new JLabel();
        this.Sx = new JLabel();
        this.Ow = new JLabel();
        this.Fs = new JLabel();
        this.zM = new JLabel();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setLayout(new b());
        this.uh.setBackground(new Color(51, 51, 51));
        this.uh.setFont(new Font("Tahoma", 1, 12));
        this.uh.setForeground(new Color(255, 255, 204));
        this.uh.setHorizontalAlignment(0);
        this.uh.setText("X");
        this.uh.setOpaque(true);
        this.add((Component)this.uh, new a(250, 30, 40, 40));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("\u00c9 campe\u00e3o!");
        this.add((Component)this.ug, new a(611, 21, 375, -1));
        this.uu.setFont(new Font("Tahoma", 0, 12));
        this.uu.setForeground(new Color(255, 255, 255));
        this.uu.setHorizontalAlignment(0);
        this.uu.setText("Nome:");
        this.add((Component)this.uu, new a(40, 140, 221, -1));
        this.Sx.setFont(new Font("Tahoma", 0, 14));
        this.Sx.setForeground(new Color(255, 255, 255));
        this.Sx.setHorizontalAlignment(0);
        this.Sx.setText("Nacionalidade:");
        this.add((Component)this.Sx, new a(20, 90, 260, -1));
        this.Ow.setForeground(new Color(255, 255, 255));
        this.Ow.setHorizontalAlignment(0);
        this.Ow.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
        this.Ow.setToolTipText("");
        this.Ow.setVerticalAlignment(3);
        this.Ow.setMaximumSize(new Dimension(50, 82));
        this.Ow.setMinimumSize(new Dimension(50, 82));
        this.Ow.setName("");
        this.Ow.setPreferredSize(new Dimension(50, 82));
        this.Ow.setRequestFocusEnabled(false);
        this.add((Component)this.Ow, new a(130, 210, -1, 100));
        this.Fs.setFont(new Font("Tahoma", 0, 12));
        this.Fs.setForeground(new Color(255, 255, 255));
        this.Fs.setHorizontalAlignment(0);
        this.Fs.setText("Nome:");
        this.add((Component)this.Fs, new a(40, 170, 221, -1));
        this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campeao.png")));
        this.zM.setMaximumSize(new Dimension(306, 413));
        this.zM.setMinimumSize(new Dimension(306, 413));
        this.add((Component)this.zM, new a(0, 0, 310, 410));
    }

    static /* synthetic */ JDialog a(dJ dJ2) {
        return dJ2.ub;
    }
}

