/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dp;
import c.a;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class do
extends JPanel {
    private JDialog ub = null;
    private JButton Fu;
    private JCheckBox CS;
    private JCheckBox Fv;
    private JCheckBox Fw;
    private JCheckBox Fx;
    private JCheckBox Fy;
    private JCheckBox Fz;
    private JCheckBox FA;
    private JCheckBox FB;
    private JCheckBox FC;
    private JCheckBox FD;
    private JLabel vf;
    private JLabel FE;

    public do(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.FD.setSelected(a.SR.isJogaIntano1());
        this.CS.setSelected(a.SR.isGruposIntPadrao());
        boolean[] blArray = a.SR.getVerJint();
        this.Fv.setSelected(blArray[0]);
        this.Fw.setSelected(blArray[1]);
        this.FB.setSelected(blArray[2]);
        this.Fy.setSelected(blArray[3]);
        this.Fz.setSelected(blArray[4]);
        this.FA.setSelected(blArray[5]);
        this.FC.setSelected(blArray[6]);
        this.Fx.setSelected(blArray[7]);
        this.Fu.addActionListener(new dp(this));
        this.FD.setVisible(false);
    }

    public void nH() {
        boolean[] blArray = new boolean[]{this.Fv.isSelected(), this.Fw.isSelected(), this.FB.isSelected(), this.Fy.isSelected(), this.Fz.isSelected(), this.FA.isSelected(), this.FC.isSelected(), this.Fx.isSelected()};
        int n2 = 0;
        while (n2 < blArray.length) {
            a.vM().setVerJint(blArray[n2], n2);
            ++n2;
        }
        a.SR.setGruposIntPadrao(this.CS.isSelected());
        a.vM().setJogaIntano1(this.FD.isSelected());
        a.vM().setGruposIntPadrao(this.CS.isSelected());
        a.vJ();
        this.ub.dispose();
    }

    private void mJ() {
        this.CS = new JCheckBox();
        this.Fx = new JCheckBox();
        this.vf = new JLabel();
        this.FE = new JLabel();
        this.FD = new JCheckBox();
        this.Fv = new JCheckBox();
        this.Fw = new JCheckBox();
        this.Fz = new JCheckBox();
        this.Fy = new JCheckBox();
        this.FA = new JCheckBox();
        this.Fu = new JButton();
        this.FB = new JCheckBox();
        this.FC = new JCheckBox();
        this.setBackground(new Color(45, 51, 38));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        this.CS.setFont(new Font("Tahoma", 0, 14));
        this.CS.setForeground(new Color(255, 255, 255));
        this.CS.setText("Quando poss\u00edvel usar grupos reais");
        this.CS.setOpaque(false);
        this.Fx.setFont(new Font("Tahoma", 0, 14));
        this.Fx.setForeground(new Color(255, 255, 255));
        this.Fx.setText("Sul-Americana");
        this.Fx.setOpaque(false);
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("Primeira Temporada");
        this.FE.setFont(new Font("Tahoma", 1, 14));
        this.FE.setForeground(new Color(255, 255, 255));
        this.FE.setText("Sem times humanos ver jogos:");
        this.FD.setFont(new Font("Tahoma", 0, 14));
        this.FD.setForeground(new Color(255, 255, 255));
        this.FD.setText("");
        this.FD.setToolTipText("");
        this.FD.setOpaque(false);
        this.Fv.setFont(new Font("Tahoma", 0, 14));
        this.Fv.setForeground(new Color(255, 255, 255));
        this.Fv.setText("Liga dos Campe\u00f5es");
        this.Fv.setOpaque(false);
        this.Fw.setFont(new Font("Tahoma", 0, 14));
        this.Fw.setForeground(new Color(255, 255, 255));
        this.Fw.setText("Libertadores");
        this.Fw.setOpaque(false);
        this.Fz.setFont(new Font("Tahoma", 0, 14));
        this.Fz.setForeground(new Color(255, 255, 255));
        this.Fz.setText("Liga Concacaf");
        this.Fz.setOpaque(false);
        this.Fy.setFont(new Font("Tahoma", 0, 14));
        this.Fy.setForeground(new Color(255, 255, 255));
        this.Fy.setText("Liga Asi\u00e1tica");
        this.Fy.setOpaque(false);
        this.FA.setFont(new Font("Tahoma", 0, 14));
        this.FA.setForeground(new Color(255, 255, 255));
        this.FA.setText("Liga Oceania");
        this.FA.setOpaque(false);
        this.Fu.setText("OK");
        this.FB.setFont(new Font("Tahoma", 0, 14));
        this.FB.setForeground(new Color(255, 255, 255));
        this.FB.setText("Liga Africana");
        this.FB.setOpaque(false);
        this.FC.setFont(new Font("Tahoma", 0, 14));
        this.FC.setForeground(new Color(255, 255, 255));
        this.FC.setText("Liga Europa");
        this.FC.setOpaque(false);
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vf, -2, 303, -2).addComponent(this.CS, -2, 320, -2).addComponent(this.FE, -2, 334, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(groupLayout.createSequentialGroup().addComponent(this.FC, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Fx, -2, 165, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.FB, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.FA, -2, 165, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.Fw, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Fz, -2, 165, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.Fv, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Fy, -2, 165, -2)).addComponent(this.FD, GroupLayout.Alignment.LEADING, -2, 356, -2))).addContainerGap(11, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addComponent(this.Fu, -2, 91, -2).addGap(154, 154, 154)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.vf).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.FD).addGap(3, 3, 3).addComponent(this.CS).addGap(18, 18, 18).addComponent(this.FE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Fv).addComponent(this.Fy)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Fw).addComponent(this.Fz)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.FB).addComponent(this.FA)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.FC).addComponent(this.Fx)).addGap(28, 28, 28).addComponent(this.Fu).addGap(15, 15, 15)));
    }
}

