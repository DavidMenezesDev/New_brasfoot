/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.I;
import a.J;
import a.K;
import a.aJ;
import best.Z;
import best.aq;
import components.a;
import components.at;
import components.b;
import f.B;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class H
extends JPanel {
    private JDialog ub;
    private Z vt = null;
    private B vu = null;
    private JButton vm;
    private JComboBox vv;
    private JComboBox ue;
    private JLabel ug;
    private JLabel vw;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JLabel vx;
    private JLabel vy;
    private JLabel vz;
    private JLabel vA;
    private at vB;
    private at vC;
    private at vD;
    private at vE;
    private at vF;
    private at vG;
    private at vH;
    private at vI;

    public H(JDialog jDialog, B b2, Z z2) {
        this.ub = jDialog;
        this.vu = b2;
        this.vt = z2;
        this.mK();
        this.mJ();
        this.mH();
        this.mW();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 1));
    }

    private void mK() {
        this.vu.zL();
        this.vB = new at(this.vu.fj(0));
        this.vC = new at(this.vu.fj(1));
        this.vD = new at(this.vu.fj(2));
        this.vE = new at(this.vu.fj(3));
        this.vF = new at(this.vu.fj(6));
        this.vG = new at(this.vu.fj(5));
        this.vH = new at(this.vu.zG());
        this.vI = new at(this.vu.fj(4));
    }

    public void mW() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < c.a.SR.N().size()) {
            this.ue.addItem(((Z)c.a.SR.N().get(n3)).jp());
            if (this.vt == c.a.SR.N().get(n3)) {
                n2 = n3;
            }
            ++n3;
        }
        aJ aJ2 = new aJ();
        aJ2.setPreferredSize(new Dimension(12, 25));
        this.ue.setRenderer(aJ2);
        this.ue.setMaximumRowCount(12);
        this.ue.setSelectedIndex(n2);
        int n4 = 0;
        while (n4 < this.vt.eb().size()) {
            this.vv.addItem(String.valueOf(Integer.toString(n4 + 1)) + "\u00aa divis\u00e3o");
            ++n4;
        }
        if (this.vu != null && this.vu.yi().getDivisao() < this.vv.getItemCount()) {
            this.vv.setSelectedIndex(this.vu.yi().getDivisao() - 1);
        }
        this.vv.addActionListener(new I(this));
        this.ue.addActionListener(new J(this));
    }

    private void mU() {
        this.vt = (Z)c.a.SR.N().get(this.ue.getSelectedIndex());
        this.vv.removeAllItems();
        int n2 = 0;
        while (n2 < this.vt.eb().size()) {
            this.vv.addItem(String.valueOf(Integer.toString(n2 + 1)) + "\u00aa divis\u00e3o");
            ++n2;
        }
        this.vv.setSelectedIndex(0);
    }

    private void mX() {
        if (this.vv.getSelectedIndex() < this.vt.eb().size()) {
            this.vu = (B)this.vt.eb().get(this.vv.getSelectedIndex());
        }
        this.vu.zL();
        this.vB.ac(this.vu.fj(0));
        this.vC.ac(this.vu.fj(1));
        this.vD.ac(this.vu.fj(2));
        this.vE.ac(this.vu.fj(3));
        this.vF.ac(this.vu.fj(6));
        this.vG.ac(this.vu.fj(5));
        this.vH.ac(this.vu.zG());
        this.vI.ac(this.vu.fj(4));
    }

    public void mH() {
        this.vm.addActionListener(new K(this));
    }

    private void mJ() {
        this.ug = new JLabel();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.vx = new JLabel();
        this.vy = new JLabel();
        this.vz = new JLabel();
        this.vA = new JLabel();
        this.vw = new JLabel();
        this.vm = new JButton();
        this.vv = new JComboBox();
        this.ue = new JComboBox();
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setBackground(new Color(104, 120, 100));
        this.setLayout(new b());
        this.ug.setBackground(new Color(0, 0, 0));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Goleiro");
        this.ug.setOpaque(true);
        this.add((Component)this.ug, new a(10, 12, 325, 22));
        this.add((Component)this.vB, new a(10, 40, 325, 180));
        this.add((Component)this.vC, new a(10, 266, 325, 180));
        this.uh.setBackground(new Color(0, 0, 0));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(0);
        this.uh.setText("Lateral Direito");
        this.uh.setOpaque(true);
        this.add((Component)this.uh, new a(10, 238, 325, 22));
        this.add((Component)this.vD, new a(10, 485, 325, 180));
        this.a_.setBackground(new Color(0, 0, 0));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(0);
        this.a_.setText("Zagueiro");
        this.a_.setOpaque(true);
        this.add((Component)this.a_, new a(10, 457, 325, 22));
        this.add((Component)this.vE, new a(345, 485, 325, 180));
        this.ur.setBackground(new Color(0, 0, 0));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(0);
        this.ur.setText("Meia Ofensivo");
        this.ur.setOpaque(true);
        this.add((Component)this.ur, new a(345, 457, 325, 22));
        this.add((Component)this.vF, new a(345, 266, 325, 180));
        this.us.setBackground(new Color(0, 0, 0));
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setHorizontalAlignment(0);
        this.us.setText("Volante");
        this.us.setOpaque(true);
        this.add((Component)this.us, new a(345, 238, 325, 22));
        this.add((Component)this.vG, new a(345, 40, 325, 180));
        this.vx.setBackground(new Color(0, 0, 0));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(0);
        this.vx.setText("Lateral Esquerdo");
        this.vx.setOpaque(true);
        this.add((Component)this.vx, new a(345, 12, 325, 22));
        this.vy.setBackground(new Color(255, 204, 0));
        this.vy.setHorizontalAlignment(0);
        this.vy.setText("Bola de Ouro");
        this.vy.setOpaque(true);
        this.add((Component)this.vy, new a(680, 457, 325, 22));
        this.add((Component)this.vH, new a(680, 485, 325, 180));
        this.add((Component)this.vI, new a(680, 266, 325, 180));
        this.vz.setBackground(new Color(0, 0, 0));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(0);
        this.vz.setText("Atacante");
        this.vz.setOpaque(true);
        this.add((Component)this.vz, new a(680, 238, 325, 22));
        this.add((Component)this.vA, new a(688, 12, 317, -1));
        this.vw.setIcon(new ImageIcon(this.getClass().getResource("/aicons/bolaouro.png")));
        this.add((Component)this.vw, new a(770, 20, 150, 120));
        this.vm.setText("X");
        this.add((Component)this.vm, new a(950, 20, 50, -1));
        this.add((Component)this.vv, new a(770, 190, 160, -1));
        this.add((Component)this.ue, new a(770, 160, 160, -1));
    }

    static /* synthetic */ JComboBox a(H h3) {
        return h3.vv;
    }

    static /* synthetic */ void b(H h3) {
        h3.mX();
    }

    static /* synthetic */ void c(H h3) {
        h3.mU();
    }

    static /* synthetic */ JDialog d(H h3) {
        return h3.ub;
    }
}

