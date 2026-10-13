/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aY;
import a.aZ;
import a.ba;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class aX
extends JPanel {
    private JDialog ub;
    private JButton zm;
    private JButton zn;
    private JLabel zo;
    private JLabel zp;
    private JLabel zq;
    private JLabel zr;
    private JLabel zs;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;

    public aX(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        Color[] colorArray = a.SR.getCoresLista();
        JLabel[] jLabelArray = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};
        int n2 = 0;
        while (n2 < jLabelArray.length) {
            jLabelArray[n2].setBackground(colorArray[n2]);
            ++n2;
        }
        this.mH();
    }

    public void mH() {
        JLabel[] jLabelArray = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};
        this.zn.addActionListener(new aY(this));
        this.zm.addActionListener(new aZ(this));
        int n2 = 0;
        while (n2 < jLabelArray.length) {
            jLabelArray[n2].setName("corl" + Integer.toString(n2));
            jLabelArray[n2].addMouseListener(new ba(this));
            ++n2;
        }
    }

    private void nG() {
        JLabel[] jLabelArray = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};
        int n2 = 0;
        while (n2 < jLabelArray.length) {
            Color color = new Color(aq.oZ[n2][0], aq.oZ[n2][1], aq.oZ[n2][2]);
            jLabelArray[n2].setBackground(color);
            ++n2;
        }
    }

    private void nH() {
        JLabel[] jLabelArray = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};
        Color[] colorArray = new Color[5];
        int n2 = 0;
        while (n2 < jLabelArray.length) {
            colorArray[n2] = jLabelArray[n2].getBackground();
            ++n2;
        }
        a.SR.setCoresLista(colorArray);
        a.vM().setCoresLista(colorArray);
        a.vJ();
    }

    private void a(Object object) {
        JLabel jLabel = (JLabel)object;
        Color color = jLabel.getBackground();
        jLabel.setBackground(JColorChooser.showDialog(jLabel, "", color));
    }

    private void mJ() {
        this.zm = new JButton();
        this.zn = new JButton();
        this.ug = new JLabel();
        this.zo = new JLabel();
        this.zp = new JLabel();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.zq = new JLabel();
        this.zr = new JLabel();
        this.ur = new JLabel();
        this.zs = new JLabel();
        this.us = new JLabel();
        this.setBackground(new Color(204, 204, 204));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.zm.setText("setar padr\u00e3o");
        this.zn.setText("ok");
        this.ug.setText("Goleiros:");
        this.zo.setBackground(new Color(255, 0, 102));
        this.zo.setMinimumSize(new Dimension(20, 20));
        this.zo.setOpaque(true);
        this.zo.setPreferredSize(new Dimension(20, 20));
        this.zp.setBackground(new Color(255, 0, 102));
        this.zp.setMinimumSize(new Dimension(20, 20));
        this.zp.setOpaque(true);
        this.zp.setPreferredSize(new Dimension(20, 20));
        this.uh.setText("Laterais:");
        this.a_.setText("Zagueiros:");
        this.zq.setBackground(new Color(255, 0, 102));
        this.zq.setMinimumSize(new Dimension(20, 20));
        this.zq.setOpaque(true);
        this.zq.setPreferredSize(new Dimension(20, 20));
        this.zr.setBackground(new Color(255, 0, 102));
        this.zr.setMinimumSize(new Dimension(20, 20));
        this.zr.setOpaque(true);
        this.zr.setPreferredSize(new Dimension(20, 20));
        this.ur.setText("Meias:");
        this.zs.setBackground(new Color(255, 0, 102));
        this.zs.setMinimumSize(new Dimension(20, 20));
        this.zs.setOpaque(true);
        this.zs.setPreferredSize(new Dimension(20, 20));
        this.us.setText("Atacantes:");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(67, 67, 67).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ug, GroupLayout.Alignment.TRAILING).addComponent(this.uh, GroupLayout.Alignment.TRAILING).addComponent(this.a_, GroupLayout.Alignment.TRAILING).addComponent(this.ur, GroupLayout.Alignment.TRAILING).addComponent(this.us, GroupLayout.Alignment.TRAILING)).addGap(8, 8, 8).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zr, -2, 30, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zq, GroupLayout.Alignment.TRAILING, -2, 30, -2).addComponent(this.zp, GroupLayout.Alignment.TRAILING, -2, 30, -2)).addComponent(this.zs, GroupLayout.Alignment.TRAILING, -2, 30, -2).addComponent(this.zo, GroupLayout.Alignment.TRAILING, -2, 30, -2))).addGroup(groupLayout.createSequentialGroup().addGap(68, 68, 68).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zn, -2, 108, -2).addComponent(this.zm, -2, 109, -2)))).addContainerGap(50, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.ug)).addComponent(this.zo, -2, 30, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.uh)).addComponent(this.zp, -2, 30, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.a_)).addComponent(this.zq, -2, 30, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.ur)).addComponent(this.zr, -2, 30, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.us)).addComponent(this.zs, -2, 30, -2)).addGap(40, 40, 40).addComponent(this.zm).addGap(18, 18, 18).addComponent(this.zn).addContainerGap()));
    }

    static /* synthetic */ void a(aX aX2) {
        aX2.nH();
    }

    static /* synthetic */ JDialog b(aX aX2) {
        return aX2.ub;
    }

    static /* synthetic */ void c(aX aX2) {
        aX2.nG();
    }

    static /* synthetic */ void a(aX aX2, Object object) {
        aX2.a(object);
    }
}

