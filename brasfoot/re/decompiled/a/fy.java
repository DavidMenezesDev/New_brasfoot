/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fA;
import a.fz;
import best.C;
import best.F;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;

public class fy
extends JPanel {
    private JDialog ub = null;
    private F CY = null;
    private int IC = 0;
    private JButton uC;
    private JButton ID;
    private JComboBox Bf;
    private JLabel ug;
    private JPanel vd;
    private JLabel uF;
    private JLabel uG;
    private JLabel uH;
    private JLabel Ec;
    private JLabel uI;
    private JSpinner IE;

    public fy(JDialog jDialog, F f2) {
        this.ub = jDialog;
        this.CY = f2;
        this.mJ();
        this.mH();
        String[] stringArray = new String[]{"6 meses", "1 ano", "2 anos", "3 anos"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            this.Bf.addItem(stringArray[n2]);
            ++n2;
        }
        this.uF.setText(this.CY.getNome());
        this.uG.setText("Contrato at\u00e9: " + this.CY.fQ());
        this.Ec.setText("Sal\u00e1rio atual: " + C.c(this.CY.fj()));
        this.Bf.setSelectedIndex(0);
        this.IE.setModel(new SpinnerNumberModel(this.CY.fj(), 1, 100000000, 1000));
    }

    public void mH() {
        this.uC.addActionListener(new fz(this));
        this.ID.addActionListener(new fA(this));
    }

    private void rE() {
        int n2 = -1;
        int n3 = (Integer)this.IE.getValue();
        if (n3 > 0 && n3 < this.rF()) {
            if (this.dr(n3)) {
                this.dq(n3);
            } else {
                String string;
                if (this.IC > this.rF()) {
                    this.IC = this.rF();
                }
                if ((n2 = JOptionPane.showConfirmDialog(this.ub, "O sal\u00e1rio n\u00e3o foi aceito.\nO jogador quer um sal\u00e1rio de:\n" + (string = Integer.toString(this.IC)), "Sal\u00e1rio recusado", 0)) == 0) {
                    this.dq(this.IC);
                }
            }
        } else if (n3 >= this.rF()) {
            String string = C.c(this.rF());
            JOptionPane.showMessageDialog(this.ub, "Sal\u00e1rio maior que o limite para esse jogador. Limite \u00e9 " + string, "Sal\u00e1rio", 2);
        }
    }

    private void dq(int n2) {
        this.CY.c(false);
        this.CY.fm();
        int n3 = this.Bf.getSelectedIndex();
        int[] nArray = new int[]{180, 365, 730, 1095};
        this.CY.a((long)nArray[n3], false);
        this.CY.ae(n2);
        this.ub.dispose();
    }

    private boolean dr(int n2) {
        int n3 = this.Bf.getSelectedIndex();
        int[] nArray = new int[]{1, 3, 5, 12};
        int[] nArray2 = new int[]{10, 12, 15, 5};
        int n4 = this.CY.fj() - Math.round(this.CY.fj() * nArray[n3] / 100);
        int n5 = this.CY.fj() + Math.round(this.CY.fj() * nArray2[n3] / 100);
        if (this.CY.fR() < 60) {
            this.IC = n4;
            if (n2 < n4) {
                return false;
            }
        } else {
            this.IC = n5;
            if (n2 < n5) {
                return false;
            }
        }
        return true;
    }

    private int rF() {
        return (int)Math.round((double)this.CY.fk() * 0.25);
    }

    private boolean ds(int n2) {
        int n3 = (int)Math.round((double)this.CY.fk() * 0.25);
        return n2 <= n3;
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.uF = new JLabel();
        this.uH = new JLabel();
        this.uI = new JLabel();
        this.uG = new JLabel();
        this.Ec = new JLabel();
        this.IE = new JSpinner();
        this.Bf = new JComboBox();
        this.uC = new JButton();
        this.ID = new JButton();
        this.setBackground(new Color(42, 64, 29));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.vd.setBackground(new Color(84, 127, 59));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Novo contrato");
        this.uF.setFont(new Font("Tahoma", 0, 12));
        this.uF.setForeground(new Color(255, 255, 255));
        this.uF.setHorizontalAlignment(0);
        this.uF.setText("Nome do Jogador");
        this.uH.setForeground(new Color(255, 255, 255));
        this.uH.setHorizontalAlignment(2);
        this.uH.setText("Dura\u00e7\u00e3o:");
        this.uI.setForeground(new Color(255, 255, 255));
        this.uI.setHorizontalAlignment(2);
        this.uI.setText("Novo sal\u00e1rio:");
        this.uG.setForeground(new Color(255, 255, 255));
        this.uG.setText("");
        this.Ec.setForeground(new Color(255, 255, 255));
        this.Ec.setText("");
        this.uC.setText("Cancelar");
        this.ID.setText("Oferecer");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.ug, -2, 317, -2).addGap(0, 0, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Ec, -2, 256, -2).addComponent(this.uG, -2, 256, -2)).addGap(8, 8, 8)))).addGroup(groupLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.uF, -1, -1, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.IE, -2, 192, -2).addComponent(this.uI, -2, 264, -2).addComponent(this.uH, -2, 63, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.uC, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ID, -2, 90, -2))))).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addGap(124, 124, 124).addComponent(this.Bf, -2, 131, -2).addContainerGap(-1, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uF).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.uG).addGap(9, 9, 9).addComponent(this.Ec).addGap(18, 18, 18).addComponent(this.uI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.IE, -2, 27, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Bf, -2, -1, -2).addComponent(this.uH)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uC).addComponent(this.ID)).addGap(23, 23, 23)));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.vd, -2, 314, -2).addContainerGap(21, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(19, 19, 19).addComponent(this.vd, -2, -1, -2).addContainerGap(21, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(fy fy2) {
        return fy2.ub;
    }

    static /* synthetic */ void b(fy fy2) {
        fy2.rE();
    }
}

