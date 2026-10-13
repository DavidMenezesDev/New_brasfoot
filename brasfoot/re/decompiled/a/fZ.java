/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ga;
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

public class fZ
extends JPanel {
    private JDialog ub = null;
    private JButton Fu;
    private JCheckBox JI;
    private JCheckBox JJ;
    private JCheckBox JK;
    private JCheckBox JL;
    private JCheckBox JM;
    private JLabel vf;

    public fZ(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        boolean[] blArray = a.SR.getJogaRegionaisTodos();
        blArray = a.SR.getJogaRegionaisTodos();
        this.JJ.setSelected(blArray[0]);
        this.JK.setSelected(blArray[1]);
        this.JL.setSelected(blArray[2]);
        this.JM.setSelected(blArray[3]);
        this.JI.setSelected(a.vM().isConviteRegionais());
        this.Fu.addActionListener(new ga(this));
    }

    public void nH() {
        boolean[] blArray = new boolean[]{this.JJ.isSelected(), this.JK.isSelected(), this.JL.isSelected(), this.JM.isSelected()};
        a.SR.setJogaRegionaisTodos(blArray);
        a.vM().setJogaRegionaisTodos(blArray);
        a.vM().setConviteRegionais(this.JI.isSelected());
        a.vJ();
        this.ub.dispose();
    }

    private void mJ() {
        this.vf = new JLabel();
        this.JJ = new JCheckBox();
        this.JK = new JCheckBox();
        this.Fu = new JButton();
        this.JL = new JCheckBox();
        this.JM = new JCheckBox();
        this.JI = new JCheckBox();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setForeground(new Color(255, 255, 153));
        this.vf.setText("Jogar:");
        this.JJ.setFont(new Font("Tahoma", 0, 14));
        this.JJ.setForeground(new Color(255, 255, 255));
        this.JJ.setText("Rio-S\u00e3o Paulo");
        this.JJ.setOpaque(false);
        this.JK.setFont(new Font("Tahoma", 0, 14));
        this.JK.setForeground(new Color(255, 255, 255));
        this.JK.setText("Sul-Minas");
        this.JK.setOpaque(false);
        this.Fu.setText("OK");
        this.JL.setFont(new Font("Tahoma", 0, 14));
        this.JL.setForeground(new Color(255, 255, 255));
        this.JL.setText("Copa do Nordeste");
        this.JL.setOpaque(false);
        this.JM.setFont(new Font("Tahoma", 0, 14));
        this.JM.setForeground(new Color(255, 255, 255));
        this.JM.setText("Copa Verde");
        this.JM.setOpaque(false);
        this.JI.setBackground(new Color(44, 53, 49));
        this.JI.setFont(new Font("Tahoma", 0, 14));
        this.JI.setForeground(new Color(255, 255, 255));
        this.JI.setText("Sempre ser convidado para jogar os regionais");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JI, -1, 332, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JM, -2, 165, -2).addComponent(this.JL, -2, 165, -2).addComponent(this.JK, -2, 165, -2).addComponent(this.JJ, -2, 165, -2).addComponent(this.vf, -2, 305, -2)).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addGap(134, 134, 134).addComponent(this.Fu, -2, 103, -2).addContainerGap(-1, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.vf).addGap(18, 18, 18).addComponent(this.JJ).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JK).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JL).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JM).addGap(18, 18, 18).addComponent(this.JI).addGap(18, 18, 18).addComponent(this.Fu).addContainerGap(27, Short.MAX_VALUE)));
    }
}

