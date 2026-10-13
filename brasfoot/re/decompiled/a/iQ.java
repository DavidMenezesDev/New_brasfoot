/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iR;
import a.iS;
import a.iT;
import a.iU;
import best.ah;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

public class iQ
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private JButton vm;
    private ButtonGroup Kl;
    private JRadioButton MW;
    private JRadioButton MX;
    private JLabel ug;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JCheckBox MY;

    public iQ(JDialog jDialog, ah ah2) {
        this.uk = ah2;
        this.ub = jDialog;
        this.mJ();
        this.mH();
        if (ah2.ll()) {
            this.MY.setSelected(true);
        }
        if (ah2.lm() == 0) {
            this.MW.setSelected(true);
        } else {
            this.MX.setSelected(true);
        }
    }

    private void sI() {
        if (this.MW.isSelected()) {
            this.uk.bZ(0);
        } else {
            this.uk.bZ(1);
        }
    }

    private void mH() {
        this.vm.addActionListener(new iR(this));
        this.MY.addActionListener(new iS(this));
        this.MW.addActionListener(new iT(this));
        this.MX.addActionListener(new iU(this));
    }

    private void mJ() {
        this.Kl = new ButtonGroup();
        this.ug = new JLabel();
        this.vm = new JButton();
        this.a_ = new JLabel();
        this.MW = new JRadioButton();
        this.MX = new JRadioButton();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.MY = new JCheckBox();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.ug.setFont(new Font("Tahoma", 1, 24));
        this.ug.setForeground(new Color(255, 255, 153));
        this.ug.setText("Treino");
        this.vm.setText("X");
        this.a_.setFont(new Font("Tahoma", 0, 12));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Foco do treino semanal:");
        this.MW.setBackground(new Color(44, 53, 49));
        this.Kl.add(this.MW);
        this.MW.setForeground(new Color(255, 255, 255));
        this.MW.setText("Habilidades principais\n");
        this.MX.setBackground(new Color(44, 53, 49));
        this.Kl.add(this.MX);
        this.MX.setForeground(new Color(255, 255, 255));
        this.MX.setText("Habilidades secund\u00e1rias");
        this.ur.setFont(new Font("Tahoma", 0, 12));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("(gol/des/arm/fin)");
        this.us.setFont(new Font("Tahoma", 0, 12));
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setHorizontalAlignment(2);
        this.us.setText("(vel/tec/pas)");
        this.MY.setBackground(new Color(44, 53, 49));
        this.MY.setForeground(new Color(255, 255, 255));
        this.MY.setText("Deixar auxiliar t\u00e9cnico decidir semanalmente");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(30, 30, 30).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.ug, -2, 237, -2).addGap(64, 64, 64).addComponent(this.vm, -2, 50, -2)).addGroup(groupLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.MY, -1, -1, Short.MAX_VALUE).addComponent(this.a_, -2, 240, -2).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.MW).addGroup(groupLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.ur, -2, 122, -2))).addGap(33, 33, 33).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.us, -2, 122, -2)).addComponent(this.MX)))))).addContainerGap(28, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm, -1, -1, Short.MAX_VALUE)).addGap(33, 33, 33).addComponent(this.a_).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.MW).addComponent(this.MX)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ur).addComponent(this.us)).addGap(37, 37, 37).addComponent(this.MY).addContainerGap(30, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(iQ iQ2) {
        return iQ2.ub;
    }

    static /* synthetic */ ah b(iQ iQ2) {
        return iQ2.uk;
    }

    static /* synthetic */ JCheckBox c(iQ iQ2) {
        return iQ2.MY;
    }

    static /* synthetic */ void d(iQ iQ2) {
        iQ2.sI();
    }
}

