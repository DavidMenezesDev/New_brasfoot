/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dn;
import best.ah;
import best.al;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class dm
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private al Fn = null;
    private al Fo = null;
    private int Fp = 0;
    private JButton zK;
    private JLabel ug;
    private JLabel a_;
    private JPanel vd;
    private JLabel Fq;
    private JLabel yA;
    private JLabel yB;
    private JLabel Fr;
    private JLabel Fs;

    public dm(JDialog jDialog, al al2, al al3, ah ah2, int n2) {
        this.ub = jDialog;
        this.Fn = al2;
        this.Fo = al3;
        this.uk = ah2;
        this.Fp = n2;
        this.mJ();
        this.mH();
        this.mK();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void mK() {
        this.Fs.setText(this.Fn.dS());
        this.yA.setText("A raz\u00e3o foi: " + aq.sg[this.Fp]);
        this.Fq.setIcon(this.uk.kP());
        String string = "um interino.";
        if (this.Fo != null) {
            string = this.Fo.dS();
        }
        this.yB.setText("Para o seu lugar foi contratado: " + string);
    }

    public void mH() {
        this.zK.addActionListener(new dn(this));
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.Fs = new JLabel();
        this.a_ = new JLabel();
        this.yA = new JLabel();
        this.yB = new JLabel();
        this.Fr = new JLabel();
        this.zK = new JButton();
        this.Fq = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.vd.setBackground(new Color(44, 53, 49));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Demitido!");
        this.Fs.setFont(new Font("Tahoma", 0, 12));
        this.Fs.setForeground(new Color(255, 255, 255));
        this.Fs.setText("jLabel2");
        this.a_.setFont(new Font("Tahoma", 0, 12));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setText("Voc\u00ea foi demitido. ");
        this.yA.setFont(new Font("Tahoma", 0, 12));
        this.yA.setForeground(new Color(255, 255, 255));
        this.yA.setText("A raz\u00e3o foi:");
        this.yB.setFont(new Font("Tahoma", 0, 12));
        this.yB.setForeground(new Color(255, 255, 255));
        this.yB.setText("Para o seu lugar foi contratado:");
        this.Fr.setFont(new Font("Tahoma", 0, 12));
        this.Fr.setForeground(new Color(255, 255, 255));
        this.Fr.setText("Agora, espere por propostas de outros times.");
        this.zK.setText("Continuar>>");
        this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.zK).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Fr, -2, 407, -2).addComponent(this.yB, -2, 407, -2).addComponent(this.yA, -2, 407, -2))).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Fs, -2, 234, -2).addComponent(this.a_, -2, 173, -2).addComponent(this.ug, -2, 159, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE).addComponent(this.Fq, -2, 75, -2))).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Fs).addGap(18, 18, 18).addComponent(this.a_)).addComponent(this.Fq, -2, 68, -2)).addGap(18, 18, 18).addComponent(this.yA).addGap(18, 18, 18).addComponent(this.yB).addGap(18, 18, 18).addComponent(this.Fr).addGap(27, 27, 27).addComponent(this.zK).addContainerGap(27, Short.MAX_VALUE)));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, -1, -2).addContainerGap(-1, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(dm dm2) {
        return dm2.ub;
    }
}

