/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jq;
import c.a;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class jp
extends JPanel {
    private JDialog ub;
    private JButton vm;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JLabel vx;
    private JLabel vy;

    public jp(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
        if (a.vL()) {
            this.vx.setVisible(false);
        }
    }

    public void mH() {
        this.vm.addActionListener(new jq(this));
    }

    private void mJ() {
        this.ug = new JLabel();
        this.uh = new JLabel();
        this.vm = new JButton();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.vx = new JLabel();
        this.vy = new JLabel();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.ug.setFont(new Font("Tahoma", 1, 24));
        this.ug.setForeground(new Color(255, 255, 153));
        this.ug.setText("Brasfoot");
        this.uh.setFont(new Font("Tahoma", 1, 12));
        this.uh.setForeground(new Color(255, 255, 153));
        this.uh.setText("www.brasfoot.com");
        this.vm.setText("X");
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setText("Beta Testers: J\u00e9ferson Santos; Jean V. Silva; Dom Rubem; Galba Novaes.");
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setText("");
        this.ur.setToolTipText("");
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setText("Jogo criado por Emmanuel Santos. Todos os direitos reservados.");
        this.us.setToolTipText("");
        this.vx.setFont(new Font("Tahoma", 1, 12));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setText("C\u00f3pia n\u00e3o registrada");
        this.vy.setForeground(new Color(255, 255, 153));
        this.vy.setText("");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(26, 26, 26).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a_, -2, 447, -2).addComponent(this.uh, -2, 171, -2)).addContainerGap(20, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.vx, -2, 207, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.ug, -2, 237, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 50, -2))).addGap(32, 32, 32)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vy).addComponent(this.us, -2, 447, -2).addComponent(this.ur, -2, 447, -2)).addGap(0, 0, Short.MAX_VALUE)))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.vm, -1, -1, Short.MAX_VALUE).addComponent(this.ug, -1, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uh).addComponent(this.vx)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vy).addGap(4, 4, 4).addComponent(this.a_).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ur).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.us).addContainerGap(23, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(jp jp2) {
        return jp2.ub;
    }
}

