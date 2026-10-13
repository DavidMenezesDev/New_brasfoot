/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ds;
import a.m;
import a.n;
import best.F;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class l
extends JPanel {
    private F uz = null;
    private ds uA;
    private JDialog uB;
    private JButton uC;
    private JButton uD;
    private JTextField uE;
    private JLabel ug;
    private JLabel uF;
    private JLabel uG;
    private JLabel uH;
    private JLabel uI;

    public l(JDialog jDialog, ds ds2, F f2) {
        this.uB = jDialog;
        this.uA = ds2;
        this.uz = f2;
        this.mJ();
        this.mH();
        this.uH.setVisible(false);
        this.uF.setText(f2.getNome());
    }

    private void mN() {
        String string = null;
        if (this.uE.getText().toString().isEmpty() || this.uE.getText().toString().length() < 2) {
            this.uH.setText("Apelido muito curto");
            this.uH.setVisible(true);
        } else if (this.uE.getText().toString().length() > 32) {
            this.uH.setText("Apelido muito longo");
            this.uH.setVisible(true);
        } else {
            string = this.uE.getText().toString();
            this.uz.setNome(string);
            this.uB.dispose();
            this.uA.pO();
        }
    }

    public void mH() {
        this.uC.addActionListener(new m(this));
        this.uD.addActionListener(new n(this));
    }

    private void mJ() {
        this.ug = new JLabel();
        this.uF = new JLabel();
        this.uH = new JLabel();
        this.uE = new JTextField();
        this.uI = new JLabel();
        this.uG = new JLabel();
        this.uC = new JButton();
        this.uD = new JButton();
        this.setBackground(new Color(44, 53, 49));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Definir apelido");
        this.uF.setFont(new Font("Tahoma", 0, 12));
        this.uF.setForeground(new Color(255, 255, 255));
        this.uF.setHorizontalAlignment(0);
        this.uF.setText("Nome do Jogador");
        this.uH.setForeground(new Color(255, 255, 204));
        this.uH.setHorizontalAlignment(2);
        this.uH.setText("Pre\u00e7o inicial:");
        this.uI.setForeground(new Color(255, 255, 255));
        this.uI.setHorizontalAlignment(2);
        this.uI.setText("que ser\u00e1 mostrado no lugar do nome:");
        this.uG.setForeground(new Color(255, 255, 255));
        this.uG.setText("Voc\u00ea pode escolher um apelido para o j\u00fanior");
        this.uC.setText("Cancelar");
        this.uD.setText("Definir");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uI, -2, 264, -2).addComponent(this.uH, -2, 237, -2).addComponent(this.uG, -2, 256, -2).addComponent(this.uE, -2, 249, -2))).addComponent(this.uF, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.uC, -2, 91, -2).addGap(31, 31, 31).addComponent(this.uD, -2, 94, -2)).addComponent(this.ug, -2, 317, -2)).addGap(0, 0, Short.MAX_VALUE))).addGap(28, 28, 28)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.uF).addGap(40, 40, 40).addComponent(this.uG).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.uE, -2, -1, -2).addGap(18, 18, 18).addComponent(this.uH).addGap(22, 22, 22).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uC).addComponent(this.uD)).addContainerGap(49, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(l l2) {
        return l2.uB;
    }

    static /* synthetic */ void b(l l2) {
        l2.mN();
    }
}

