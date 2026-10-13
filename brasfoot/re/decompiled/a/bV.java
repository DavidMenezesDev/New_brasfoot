/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aJ;
import a.aK;
import a.bW;
import a.bX;
import a.bY;
import a.bZ;
import a.ca;
import a.cb;
import a.cc;
import a.cd;
import best.S;
import best.Z;
import best.ac;
import best.ad;
import best.ah;
import best.aq;
import best.n;
import best.p;
import c.a;
import f.B;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Collections;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class bV
extends JPanel {
    private JFrame Br;
    private Z Bs;
    private ah zu;
    private ah Bt;
    private JComboBox[] Bu = null;
    private JLabel[] Bv = null;
    private static int count = 1;
    private JButton Bw;
    private JButton Bx;
    private JCheckBox By;
    private JComboBox Bz;
    private JComboBox BA;
    private JComboBox BB;
    private JComboBox BC;
    private JComboBox BD;
    private JComboBox ue;
    private JTextField uf;
    private JLabel ug;
    private JLabel a_;
    private JSeparator BE;
    private JSeparator BF;
    private JSeparator BG;
    private JLabel BH;
    private JLabel BI;
    private JLabel BJ;
    private JLabel BK;
    private JLabel BL;
    private JLabel BM;
    private JLabel uF;
    private JLabel vf;
    private JLabel BN;
    private JLabel BO;

    public bV(JFrame jFrame) {
        this.Br = jFrame;
        this.mJ();
        JComboBox[] jComboBoxArray = new JComboBox[]{this.Bz, this.BA, this.BB, this.BC};
        this.Bu = jComboBoxArray;
        JLabel[] jLabelArray = new JLabel[]{this.BH, this.BI, this.BJ, this.BK};
        this.Bv = jLabelArray;
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            this.ue.addItem(((Z)a.SR.N().get(n2)).jp());
            ++n2;
        }
        aJ aJ2 = new aJ();
        aJ2.setPreferredSize(new Dimension(10, 25));
        this.ue.setRenderer(aJ2);
        this.ue.setMaximumRowCount(12);
        this.Bs = (Z)a.SR.N().get(0);
        int n3 = 0;
        while (n3 < ac.jz()) {
            this.BD.addItem(((ad)n.cY().get(n3)).getNome());
            ++n3;
        }
        aJ aJ3 = new aJ();
        aJ3.setPreferredSize(new Dimension(10, 25));
        this.BD.setRenderer(aJ3);
        this.BD.setMaximumRowCount(12);
        this.BD.setSelectedIndex(n.G(29));
        this.ue.addActionListener(new bW(this));
        int n4 = 0;
        while (n4 < this.Bu.length) {
            aK aK2 = new aK();
            aK2.setPreferredSize(new Dimension(10, 25));
            this.Bu[n4].setRenderer(aK2);
            this.Bu[n4].setMaximumRowCount(24);
            ++n4;
        }
        this.ot();
        this.By.addActionListener(new bX(this));
        this.Bu[0].addActionListener(new bY(this));
        this.Bu[1].addActionListener(new bZ(this));
        this.Bu[2].addActionListener(new ca(this));
        this.Bu[3].addActionListener(new cb(this));
        this.Bw.addActionListener(new cc(this));
        this.Bx.addActionListener(new cd(this));
        if (a.vL()) {
            this.ug.setText("");
        } else {
            this.By.setSelected(false);
            this.By.setEnabled(false);
        }
    }

    private void ol() {
        if (this.By.isSelected()) {
            this.BN.setText("Aleat\u00f3rio");
            this.BN.setIcon(null);
            this.Bt = null;
            int n2 = 0;
            if (this.Bu[0].getItemCount() > 0) {
                n2 = 1;
            }
            if (this.Bu[1].getItemCount() > 0) {
                n2 = 2;
            }
            if (this.Bu[2].getItemCount() > 0) {
                n2 = 3;
            }
            if (this.Bu[3].getItemCount() > 0) {
                n2 = 4;
            }
            int n3 = new Random().nextInt(n2);
            int n4 = new Random().nextInt(this.Bu[n3].getItemCount());
            this.Bt = (ah)this.Bu[n3].getItemAt(n4);
        } else {
            this.ou();
        }
    }

    private void om() {
        if (!a.vL()) {
            JOptionPane.showMessageDialog(null, "Somente na vers\u00e3o registrada \u00e9 poss\u00edvel jogarcom mais de um t\u00e9cnico humano.", "T\u00e9cnicos humanos", 2);
        } else {
            String string = this.oo();
            if (string == null) {
                this.or();
                this.vf.setText("Adicionar t\u00e9cnico humano " + Integer.toString(++count));
                this.uf.setText("");
                this.ot();
            } else {
                JOptionPane.showMessageDialog(null, string, "", 0);
            }
        }
    }

    public void on() {
        this.uf.requestFocusInWindow();
    }

    public String oo() {
        String string = null;
        if (this.uf.getText().toString().isEmpty()) {
            string = "Digite um nome para o t\u00e9cnico";
        } else if (this.uf.getText().toString().length() < 2) {
            string = "Nome do t\u00e9cnico muito curto";
        } else if (this.uf.getText().toString().length() > 35) {
            string = "Nome do t\u00e9cnico muito longo";
        } else if (this.zu == null) {
            string = "Selecione um time";
        }
        return string;
    }

    public void pl() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(null, "Deseja criar um torneio Amistoso de in\u00edcio de temporada? ", "Torneio Amistoso", 0);
        if (n2 == 0) {
            S.aY(10);
        } else {
            this.AB();
        }
    }

    public void AB() {
        this.Bw.setCursor(new Cursor(3));
        a.SR.az();
        a.SR.V();
    }

    public void oq() {
        String string = this.oo();
        a.SR.i(true);
        if (count >= 100000) {
            if (string == null) {
                this.or();
            }
            if (a.SR.isJogaRegionais()) {
                p.dh();
            }
            this.pl();
        } else if (string == null) {
            this.or();
            this.Bw.setCursor(new Cursor(3));
            if (a.SR.isJogaRegionais()) {
                p.dh();
            }
            this.pl();
        } else {
            JOptionPane.showMessageDialog(null, string, "", 0);
        }
    }

    public void or() {
        if (!this.By.isSelected() || this.Bt == null) {
            this.zu.b(this.uf.getText().toString(), n.H(this.BD.getSelectedIndex()));
        } else {
            this.Bt.b(this.uf.getText().toString(), n.H(this.BD.getSelectedIndex()));
        }
    }

    public void os() {
        this.Bs = (Z)a.SR.N().get(this.ue.getSelectedIndex());
        this.ot();
    }

    public void cW(int n2) {
        this.zu = (ah)this.Bu[n2].getSelectedItem();
        this.ou();
        this.Bu[n2].setEnabled(true);
        int n3 = 0;
        while (n3 < this.Bv.length) {
            this.Bv[n3].setForeground(new Color(255, 255, 255));
            ++n3;
        }
        this.Bv[n2].setForeground(new Color(255, 255, 0));
        this.on();
    }

    private void ot() {
        this.zu = null;
        int n2 = 0;
        while (n2 < this.Bv.length) {
            this.Bv[n2].setVisible(false);
            this.Bu[n2].setVisible(false);
            this.Bu[n2].removeAllItems();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.Bs.eb().size()) {
            this.cX(n2);
            ++n2;
        }
        if (a.vL()) {
            if (this.Bu[0].getItemCount() > 0) {
                this.cW(0);
            } else if (this.Bu[1].getItemCount() > 0) {
                this.cW(1);
            } else if (this.Bu[2].getItemCount() > 0) {
                this.cW(2);
            } else if (this.Bu[3].getItemCount() > 0) {
                this.cW(3);
            }
        } else {
            n2 = 0;
            while (n2 < this.Bu.length) {
                this.Bu[n2].setEnabled(false);
                ++n2;
            }
            if (this.Bu[3].getItemCount() > 0) {
                this.cW(3);
            } else if (this.Bu[2].getItemCount() > 0) {
                this.cW(2);
            } else if (this.Bu[1].getItemCount() > 0) {
                this.cW(1);
            } else if (this.Bu[0].getItemCount() > 0) {
                this.cW(0);
            }
        }
        if (this.zu == null) {
            this.BN.setText("");
            this.BN.setIcon(null);
        }
        this.on();
    }

    public void ou() {
        this.By.setSelected(false);
        if (this.zu != null) {
            this.BN.setText(this.zu.getNome());
            this.BN.setIcon(this.zu.x(25, 25));
        }
    }

    private void cX(int n2) {
        this.Bv[n2].setVisible(true);
        this.Bu[n2].setVisible(true);
        this.Bu[n2].setEnabled(true);
        Collections.sort(((B)this.Bs.eb().get(n2)).yi().yK(), h.a.VS);
        int n3 = 0;
        boolean bl2 = true;
        if (n2 == 3 && this.Bs.jc() == 29 && a.SR.isJogaEstadual() && a.SR.bk()) {
            bl2 = false;
        }
        if (bl2) {
            int n4 = 0;
            while (n4 < ((B)this.Bs.eb().get(n2)).yi().yK().size()) {
                if (!((ah)((B)this.Bs.eb().get(n2)).yi().yK().get(n4)).jZ().booleanValue()) {
                    this.Bu[n2].addItem(((B)this.Bs.eb().get(n2)).yi().yK().get(n4));
                    ++n3;
                }
                ++n4;
            }
            if (n2 == 3) {
                this.Bv[3].setText("4\u00aa divis\u00e3o");
            }
        } else {
            this.Bv[3].setText("Jogando estaduais:");
            Collections.sort(this.Bs.jg(), h.a.VS);
            int n5 = 0;
            while (n5 < this.Bs.jg().size()) {
                if (!((ah)this.Bs.jg().get(n5)).jZ().booleanValue() && ((ah)this.Bs.jg().get(n5)).getDivisao() == 0 && ((ah)this.Bs.jg().get(n5)).kg()) {
                    this.Bu[n2].addItem(this.Bs.jg().get(n5));
                    ++n3;
                }
                ++n5;
            }
        }
        if (n3 == 0) {
            this.Bv[n2].setVisible(false);
            this.Bu[n2].setVisible(false);
        }
    }

    private void mJ() {
        this.a_ = new JLabel();
        this.vf = new JLabel();
        this.BO = new JLabel();
        this.ue = new JComboBox();
        this.BE = new JSeparator();
        this.Bz = new JComboBox();
        this.BH = new JLabel();
        this.BI = new JLabel();
        this.BA = new JComboBox();
        this.BB = new JComboBox();
        this.BJ = new JLabel();
        this.BC = new JComboBox();
        this.BK = new JLabel();
        this.BF = new JSeparator();
        this.uF = new JLabel();
        this.uf = new JTextField();
        this.BL = new JLabel();
        this.BD = new JComboBox();
        this.BG = new JSeparator();
        this.Bw = new JButton();
        this.Bx = new JButton();
        this.ug = new JLabel();
        this.BM = new JLabel();
        this.BN = new JLabel();
        this.By = new JCheckBox();
        this.setBackground(aq.os);
        this.a_.setFont(new Font("Tahoma", 1, 24));
        this.a_.setForeground(new Color(255, 255, 102));
        this.a_.setHorizontalAlignment(0);
        this.a_.setText("Brasfoot");
        this.vf.setFont(new Font("Tahoma", 1, 18));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setHorizontalAlignment(0);
        this.vf.setText("Adicionar t\u00e9cnico humano");
        this.BO.setFont(new Font("Tahoma", 1, 14));
        this.BO.setForeground(new Color(255, 255, 153));
        this.BO.setHorizontalAlignment(4);
        this.BO.setText("Treinar time do pa\u00eds:");
        this.BH.setFont(new Font("Tahoma", 0, 14));
        this.BH.setForeground(new Color(255, 255, 0));
        this.BH.setHorizontalAlignment(4);
        this.BH.setText("1\u00aa divis\u00e3o:");
        this.BI.setFont(new Font("Tahoma", 0, 14));
        this.BI.setForeground(new Color(255, 255, 255));
        this.BI.setHorizontalAlignment(4);
        this.BI.setText("2\u00aa divis\u00e3o:");
        this.BJ.setFont(new Font("Tahoma", 0, 14));
        this.BJ.setForeground(new Color(255, 255, 255));
        this.BJ.setHorizontalAlignment(4);
        this.BJ.setText("3\u00aa divis\u00e3o:");
        this.BK.setFont(new Font("Tahoma", 0, 14));
        this.BK.setForeground(new Color(255, 255, 255));
        this.BK.setHorizontalAlignment(4);
        this.BK.setText("4\u00aa divis\u00e3o:");
        this.uF.setFont(new Font("Tahoma", 0, 14));
        this.uF.setForeground(new Color(255, 255, 255));
        this.uF.setHorizontalAlignment(4);
        this.uF.setText("Nome:");
        this.BL.setFont(new Font("Tahoma", 0, 14));
        this.BL.setForeground(new Color(255, 255, 255));
        this.BL.setHorizontalAlignment(4);
        this.BL.setText("Nacionalidade:");
        this.Bw.setText("Iniciar Jogo >>");
        this.Bw.setToolTipText("");
        this.Bx.setText("Adicionar e incluir outro");
        this.Bx.setToolTipText("");
        this.ug.setFont(new Font("Tahoma", 0, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("<html>\nVers\u00e3o n\u00e3o registrada do Brasfoot. Sem o registro voc\u00ea s\u00f3 pode iniciar da \u00faltima divis\u00e3o.<br> Na vers\u00e3o registrada, pode iniciar com qualquer time de qualquer divis\u00e3o.\n<br><b>Registre sua c\u00f3pia em www.brasfoot.com</b>\n</html>  ");
        this.BM.setFont(new Font("Tahoma", 0, 14));
        this.BM.setForeground(new Color(255, 255, 255));
        this.BM.setHorizontalAlignment(4);
        this.BM.setText("Time selecionado:");
        this.BN.setFont(new Font("Tahoma", 0, 14));
        this.BN.setForeground(new Color(255, 255, 255));
        this.BN.setHorizontalAlignment(2);
        this.BN.setText("Time selecionado:");
        this.By.setBackground(aq.os);
        this.By.setFont(new Font("Tahoma", 0, 14));
        this.By.setForeground(new Color(255, 255, 255));
        this.By.setText("Escolher um time aleat\u00f3rio");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vf, -1, -1, Short.MAX_VALUE).addComponent(this.ug).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.BF, -2, 308, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(261, 261, 261).addComponent(this.a_)).addGroup(groupLayout.createSequentialGroup().addGap(100, 100, 100).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.BE, -2, 308, -2).addGroup(groupLayout.createSequentialGroup().addComponent(this.BO, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ue, -2, 154, -2)))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(94, 94, 94).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(this.BM, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.BN, -2, 154, -2)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.By).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.BI, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.BA, -2, 154, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.BH, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Bz, -2, 154, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.BJ, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.BB, -2, 154, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.BK, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.BC, -2, 154, -2)).addGroup(groupLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.BL, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.BD, -2, 202, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.uF, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uf, -2, 202, -2)))))).addGap(31, 31, 31))))).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup().addComponent(this.Bx).addGap(18, 18, 18).addComponent(this.Bw, -1, -1, Short.MAX_VALUE)).addComponent(this.BG, -2, 308, -2))).addContainerGap(156, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.a_).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vf).addGap(41, 41, 41).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.BO).addComponent(this.ue, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.BE, -2, 10, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Bz, -2, -1, -2).addComponent(this.BH)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BA, -2, -1, -2).addComponent(this.BI)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BB, -2, -1, -2).addComponent(this.BJ)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BC, -2, -1, -2).addComponent(this.BK)).addGap(18, 18, 18).addComponent(this.By).addGap(7, 7, 7).addComponent(this.BF, -2, 10, -2).addGap(4, 4, 4).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uf, -2, -1, -2).addComponent(this.uF)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BL).addComponent(this.BD, -2, 20, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BN).addComponent(this.BM)).addGap(18, 18, 18).addComponent(this.BG, -2, 10, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Bw, -2, 32, -2).addComponent(this.Bx, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ug, -1, 78, Short.MAX_VALUE).addContainerGap()));
        this.ug.getAccessibleContext().setAccessibleName("<html> Vers\u00e3o n\u00e3o registrada do Brasfoot. Sem o registro voc\u00ea s\u00f3 pode iniciar da \u00faltima divis\u00e3o.<br> Na vers\u00e3o registrada, pode iniciar com qualquer time de qualquer divis\u00e3o. </html>  ");
    }

    static /* synthetic */ void a(bV bV2) {
        bV2.ol();
    }

    static /* synthetic */ void b(bV bV2) {
        bV2.om();
    }
}

