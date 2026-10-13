/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jj;
import a.jk;
import best.F;
import best.ah;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class ji
extends JPanel {
    private ah zu;
    private F uz = null;
    private JDialog ub;
    private static boolean Ag = false;
    private JButton Np;
    private JButton BZ;
    private JComboBox Nq;
    private JTextField Nr;
    private JLabel ug;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JLabel vx;
    private JLabel vy;
    private JLabel uF;

    public static boolean nX() {
        return Ag;
    }

    public ji(JDialog jDialog, ah ah2, F f2) {
        this.ub = jDialog;
        this.zu = ah2;
        this.uz = f2;
        Ag = false;
        this.mJ();
        this.mH();
        this.uF.setText(this.uz.getNome());
        int n2 = 0;
        while (n2 < aq.rI.length) {
            this.Nq.addItem(aq.rI[n2]);
            ++n2;
        }
        this.Nq.addItem("Aleat\u00f3rio");
        this.Nq.setSelectedIndex(this.uz.getPosicao());
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.BZ.addActionListener(new jj(this));
        this.Np.addActionListener(new jk(this));
    }

    public void qW() {
        String string = null;
        if (!this.Nr.getText().toString().isEmpty() && this.Nr.getText().toString().length() > 1 && this.Nr.getText().toString().length() < 35) {
            string = this.Nr.getText().toString();
        }
        int n2 = -1;
        n2 = this.Nq.getSelectedIndex() < 5 ? this.Nq.getSelectedIndex() : -1;
        this.uz.a(string, n2, false);
        Ag = true;
        this.ub.dispose();
    }

    private void mJ() {
        this.ug = new JLabel();
        this.BZ = new JButton();
        this.uF = new JLabel();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.Nr = new JTextField();
        this.vx = new JLabel();
        this.Nq = new JComboBox();
        this.vy = new JLabel();
        this.Np = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Aposentar jogador");
        this.BZ.setFont(new Font("Tahoma", 1, 11));
        this.BZ.setText("X");
        this.uF.setFont(new Font("Arial", 1, 12));
        this.uF.setForeground(new Color(255, 255, 153));
        this.uF.setText("nomeJogador");
        this.a_.setFont(new Font("Arial", 1, 12));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("<html>Se n\u00e3o houver vaga nos Juniores, ele ser\u00e1 promovido ao time principal.</html> ");
        this.a_.setVerticalAlignment(1);
        this.ur.setFont(new Font("Arial", 1, 12));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("<html>Ao aposentar um jogador voc\u00ea ganha a oportunidade de receber um novo jogador na Academia de Juniores do seu time. Voc\u00ea pode escolher a posi\u00e7\u00e3o e como ser\u00e1 chamado o novo jogador.</html> ");
        this.ur.setVerticalAlignment(1);
        this.us.setFont(new Font("Arial", 1, 12));
        this.us.setForeground(new Color(255, 255, 153));
        this.us.setText("Escolha um nome:");
        this.vx.setFont(new Font("Arial", 0, 12));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setText("(deixe em branco para um nome autom\u00e1tico)");
        this.vy.setFont(new Font("Arial", 1, 12));
        this.vy.setForeground(new Color(255, 255, 153));
        this.vy.setText("Posi\u00e7\u00e3o:");
        this.Np.setText("Aposentar");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(41, 41, 41).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.uF, -2, 274, -2).addContainerGap(-1, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addComponent(this.ug, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.BZ, -2, 47, -2).addGap(32, 32, 32)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ur, -2, 337, -2).addComponent(this.a_, -2, 337, -2).addComponent(this.vx, -2, 275, -2).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Nr, -2, 244, -2).addComponent(this.us, -2, 202, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vy, -2, 75, -2).addComponent(this.Nq, 0, -1, Short.MAX_VALUE)))).addGap(0, 24, Short.MAX_VALUE)))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addComponent(this.Np, -2, 142, -2).addGap(121, 121, 121)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BZ).addComponent(this.ug)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uF).addGap(20, 20, 20).addComponent(this.ur, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.a_, -2, 47, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.us).addComponent(this.vy, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Nr, -2, -1, -2).addComponent(this.Nq, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.vx).addGap(18, 18, 18).addComponent(this.Np).addContainerGap(31, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(ji ji2) {
        return ji2.ub;
    }
}

