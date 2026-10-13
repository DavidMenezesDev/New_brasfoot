/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hG;
import a.hH;
import a.hI;
import a.hJ;
import a.hK;
import a.hL;
import a.hM;
import a.hN;
import a.hO;
import a.hP;
import a.hQ;
import a.hR;
import a.hS;
import a.hT;
import best.A;
import best.I;
import best.Z;
import best.ah;
import best.aq;
import c.a;
import c.b;
import f.B;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class hF
extends JPanel {
    private JDialog ub;
    private ArrayList um = new ArrayList();
    private ah LF = null;
    private ah LG = null;
    private ah uk = null;
    private JButton BZ;
    private JButton LH;
    private JButton LI;
    private JButton LJ;
    private JButton LK;
    private JButton LL;
    private JButton LM;
    private JButton LN;
    private JButton LO;
    private JCheckBox LP;
    private JCheckBox LQ;
    private JComboBox Bf;
    private JComboBox LR;
    private JComboBox LS;
    private JComboBox LT;
    private JComboBox Bg;
    private JComboBox Bh;
    private JComboBox Bi;
    private JComboBox LU;
    private JComboBox LV;
    private JComboBox LW;
    private JComboBox LX;
    private JComboBox LY;
    private JPanel vd;
    private JScrollPane ut;
    private JScrollPane wi;
    private JScrollPane zf;
    private JScrollPane zg;
    private JLabel yA;
    private JLabel yB;
    private JLabel Fr;
    private JLabel GJ;
    private JLabel LZ;
    private JLabel Hn;
    private JTree uw;

    public hF(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
        this.mM();
        this.mW();
        this.og();
    }

    public void og() {
        this.Bf.addActionListener(new hG(this));
        this.Bg.addActionListener(new hM(this));
        this.Bh.addActionListener(new hN(this));
        this.Bi.addActionListener(new hO(this));
    }

    private void dA(int n2) {
        long l2 = 0L;
        long l3 = 0L;
        l2 = System.currentTimeMillis();
        int[] nArray = new int[2];
        int[] nArray2 = new int[2];
        int[] nArray3 = new int[2];
        int[] nArray4 = new int[2];
        int[] nArray5 = new int[2];
        int[] nArray6 = new int[2];
        int[] nArray7 = new int[2];
        int[] nArray8 = new int[2];
        int[] nArray9 = new int[2];
        int n3 = 0;
        int n4 = -1;
        if (this.Bf.getSelectedIndex() > 0) {
            n4 = this.Bf.getSelectedIndex();
        }
        int n5 = -1;
        if (this.LW.getSelectedIndex() > 0) {
            n5 = this.LW.getSelectedIndex();
        }
        int n6 = 0;
        while (n6 < n2) {
            Object object;
            I i2 = new I(this.LF, this.LG, this.LQ.isSelected());
            ah.a(i2.hc(), i2, 1, n4, false);
            ah.a(i2.hd(), i2, 2, n5, false);
            b b2 = new b(i2);
            i2.a(b2);
            int[] nArray10 = new int[]{new Random().nextInt(3), new Random().nextInt(5) + 1};
            int n7 = 0;
            while (n7 < 45 + nArray10[0]) {
                object = null;
                object = b2.vO();
                if (object != null) {
                    ((A)object).S(n7);
                    ((A)object).T(1);
                    i2.hE().add(object);
                }
                ++n7;
            }
            n7 = 0;
            while (n7 < 45 + nArray10[1]) {
                object = null;
                object = b2.vO();
                if (object != null) {
                    ((A)object).S(n7);
                    ((A)object).T(2);
                    i2.hE().add(object);
                }
                ++n7;
            }
            nArray2[0] = nArray2[0] + b2.vX()[0];
            nArray2[1] = nArray2[1] + b2.vX()[1];
            if (b2.vX()[0] > b2.vX()[1]) {
                nArray[0] = nArray[0] + 1;
            } else if (b2.vX()[1] > b2.vX()[0]) {
                nArray[1] = nArray[1] + 1;
            } else {
                ++n3;
            }
            if (b2.vX()[0] > nArray9[0]) {
                nArray9[0] = b2.vX()[0];
            }
            if (b2.vX()[1] > nArray9[1]) {
                nArray9[1] = b2.vX()[1];
            }
            nArray3[0] = nArray3[0] + b2.vY()[0];
            nArray3[1] = nArray3[1] + b2.vY()[1];
            nArray4[0] = nArray4[0] + b2.hY()[0];
            nArray4[1] = nArray4[1] + b2.hY()[1];
            nArray5[0] = nArray5[0] + b2.wf()[0];
            nArray5[1] = nArray5[1] + b2.wf()[1];
            nArray6[0] = nArray6[0] + b2.we()[0];
            nArray6[1] = nArray6[1] + b2.we()[1];
            nArray7[0] = nArray7[0] + b2.wg()[0];
            nArray7[1] = nArray7[1] + b2.wg()[1];
            nArray8[0] = nArray8[0] + b2.wh()[0];
            nArray8[1] = nArray8[1] + b2.wh()[1];
            if (n6 == n2 - 1) {
                int[] nArray11 = b2.vX();
                this.GJ.setText(String.valueOf(i2.hc().getNome()) + Integer.toString(nArray11[0]) + " x " + Integer.toString(nArray11[1]) + i2.hd().getNome());
                object = "<html>";
                object = String.valueOf(object) + "<br>Placar:" + Integer.toString(b2.vX()[0]) + " x " + Integer.toString(b2.vX()[1]);
                object = String.valueOf(object) + "<br>Venceu meio: " + Integer.toString(b2.hY()[0]) + "/" + Integer.toString(b2.hY()[1]);
                object = String.valueOf(object) + "<br>Avancos no meio: " + Integer.toString(b2.wf()[0]) + "/" + Integer.toString(b2.wf()[1]);
                object = String.valueOf(object) + "<br>Desarmes no meio: " + Integer.toString(b2.wg()[0]) + "/" + Integer.toString(b2.wg()[1]);
                object = String.valueOf(object) + "<br>Avancos Ataque:" + Integer.toString(b2.we()[0]) + "/" + Integer.toString(b2.we()[1]);
                object = String.valueOf(object) + "<br>Desarmes defesa:" + Integer.toString(b2.wh()[0]) + "/" + Integer.toString(b2.wh()[1]);
                object = String.valueOf(object) + "<br>Chutes totais:" + Integer.toString(b2.vY()[0]) + "/" + Integer.toString(b2.vY()[1]);
                object = String.valueOf(object) + "</html>";
                this.yA.setText((String)object);
                String string = "<html>";
                int n8 = 0;
                while (n8 < i2.hE().size()) {
                    string = String.valueOf(string) + ((A)i2.hE().get(n8)).eo().getNome() + " " + aq.rI[((A)i2.hE().get(n8)).eo().getPosicao()] + " " + Integer.toString(((A)i2.hE().get(n8)).em()) + "' - " + Integer.toString(((A)i2.hE().get(n8)).en()) + "\u00ba " + ((A)i2.hE().get(n8)).cu().getNome() + "<br>";
                    ++n8;
                }
                string = String.valueOf(string) + "</html>";
                this.yB.setText(string);
            }
            String string = "<html>";
            string = String.valueOf(string) + "<br>Vit\u00f3rias:" + Integer.toString(nArray[0]) + "/" + Integer.toString(nArray[1]);
            string = String.valueOf(string) + "<br>Empates:" + Integer.toString(n3);
            string = String.valueOf(string) + "<br>Gols:" + Integer.toString(nArray2[0]) + "(" + aq.D(nArray2[0], nArray3[0]) + "%)/" + Integer.toString(nArray2[1]) + "(" + aq.D(nArray2[1], nArray3[1]) + "%)";
            string = String.valueOf(string) + "<br>Chutes:" + Integer.toString(nArray3[0]) + "/" + Integer.toString(nArray3[1]);
            string = String.valueOf(string) + "<br>Venceu meio:" + Integer.toString(nArray4[0]) + "/" + Integer.toString(nArray4[1]);
            string = String.valueOf(string) + "<br>Avanco meio:" + Integer.toString(nArray5[0]) + "/" + Integer.toString(nArray5[1]);
            string = String.valueOf(string) + "<br>Avanco ataque:" + Integer.toString(nArray6[0]) + "/" + Integer.toString(nArray6[1]);
            string = String.valueOf(string) + "<br>Desarme meio:" + Integer.toString(nArray7[0]) + "/" + Integer.toString(nArray7[1]);
            string = String.valueOf(string) + "<br>Desarme defesa:" + Integer.toString(nArray8[0]) + "/" + Integer.toString(nArray8[1]);
            string = String.valueOf(string) + "<br>Maior n gols:" + Integer.toString(nArray9[0]) + "/" + Integer.toString(nArray9[1]);
            string = String.valueOf(string) + "</html>";
            this.Fr.setText(string);
            ++n6;
        }
        l3 = System.currentTimeMillis() - l2;
    }

    private void mW() {
        String[] stringArray = new String[]{"random", "5-4-1", "5-3-2", "4-5-1", "4-4-2", "4-4-2 def", "4-4-2 Ofen.", "4-3-3", "4-3-3 def", "3-5-2", "3-4-3"};
        String[] stringArray2 = aq.rC;
        String[] stringArray3 = aq.rD;
        String[] stringArray4 = aq.rE;
        int n2 = 0;
        while (n2 < stringArray.length) {
            this.Bf.addItem(stringArray[n2]);
            ++n2;
        }
        n2 = 0;
        while (n2 < stringArray2.length) {
            this.Bg.addItem(stringArray2[n2]);
            ++n2;
        }
        this.Bg.setSelectedIndex(0);
        n2 = 0;
        while (n2 < stringArray4.length) {
            this.Bh.addItem(stringArray4[n2]);
            ++n2;
        }
        this.Bh.setSelectedIndex(0);
        n2 = 0;
        while (n2 < stringArray3.length) {
            this.Bi.addItem(stringArray3[n2]);
            ++n2;
        }
        this.Bi.setSelectedIndex(0);
        n2 = 0;
        while (n2 < stringArray.length) {
            this.LW.addItem(stringArray[n2]);
            ++n2;
        }
        n2 = 0;
        while (n2 < stringArray2.length) {
            this.LX.addItem(stringArray2[n2]);
            ++n2;
        }
        this.LX.setSelectedIndex(0);
        n2 = 0;
        while (n2 < stringArray4.length) {
            this.LY.addItem(stringArray4[n2]);
            ++n2;
        }
        this.LY.setSelectedIndex(0);
        n2 = 0;
        while (n2 < stringArray3.length) {
            this.LR.addItem(stringArray3[n2]);
            ++n2;
        }
        this.LR.setSelectedIndex(0);
    }

    public void mH() {
        this.BZ.addActionListener(new hP(this));
        this.LH.addActionListener(new hQ(this));
        this.LN.addActionListener(new hR(this));
        this.LO.addActionListener(new hS(this));
        this.LI.addActionListener(new hT(this));
        this.LJ.addActionListener(new hH(this));
        this.LK.addActionListener(new hI(this));
        this.LL.addActionListener(new hJ(this));
        this.LM.addActionListener(new hK(this));
    }

    private void dB(int n2) {
        if (n2 == 1) {
            this.LF.kj()[1] = this.Bg.getSelectedIndex();
            this.LF.kj()[2] = this.Bh.getSelectedIndex();
            this.LF.kj()[3] = this.Bi.getSelectedIndex();
        }
        if (n2 == 2) {
            this.LG.kj()[1] = this.LX.getSelectedIndex();
            this.LG.kj()[2] = this.LY.getSelectedIndex();
            this.LG.kj()[3] = this.LR.getSelectedIndex();
        }
    }

    private void sk() {
        this.LF = this.uk;
        this.LZ.setText(this.uk.getNome());
        this.LZ.setIcon(this.uk.kU());
    }

    private void sl() {
        this.LG = this.uk;
        this.Hn.setText(this.uk.getNome());
        this.Hn.setIcon(this.uk.kU());
    }

    private void mM() {
        this.uw.getSelectionModel().setSelectionMode(1);
        this.uw.addTreeSelectionListener(new hL(this));
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (!((ah)a.SR.P().get(n2)).kn().booleanValue()) {
                this.um.add((ah)a.SR.P().get(n2));
                Collections.sort(this.um, h.a.VS);
            }
            ++n2;
        }
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Times");
        this.a(defaultMutableTreeNode);
        this.uw.setModel(new DefaultTreeModel(defaultMutableTreeNode));
    }

    private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = null;
        DefaultMutableTreeNode defaultMutableTreeNode3 = null;
        DefaultMutableTreeNode defaultMutableTreeNode4 = null;
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            defaultMutableTreeNode2 = new DefaultMutableTreeNode(((Z)a.SR.N().get(n2)).jp());
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            int n3 = 0;
            while (n3 < ((Z)a.SR.N().get(n2)).eb().size()) {
                if (((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().size() > 0) {
                    defaultMutableTreeNode3 = new DefaultMutableTreeNode(((B)((Z)a.SR.N().get(n2)).eb().get(n3)).getNome());
                    defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                    int n4 = 0;
                    while (n4 < ((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().size()) {
                        defaultMutableTreeNode4 = new DefaultMutableTreeNode(((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().get(n4));
                        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
                        ++n4;
                    }
                }
                ++n3;
            }
            if (((Z)a.SR.N().get(n2)).ek().size() > 0) {
                defaultMutableTreeNode3 = new DefaultMutableTreeNode("Regionais");
                defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                n3 = 0;
                while (n3 < ((Z)a.SR.N().get(n2)).ek().size()) {
                    defaultMutableTreeNode4 = new DefaultMutableTreeNode(((Z)a.SR.N().get(n2)).ek().get(n3));
                    defaultMutableTreeNode3.add(defaultMutableTreeNode4);
                    ++n3;
                }
            }
            ++n2;
        }
        if (this.um.size() > 0) {
            defaultMutableTreeNode2 = new DefaultMutableTreeNode("Internacionais");
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            n2 = 0;
            while (n2 < this.um.size()) {
                defaultMutableTreeNode4 = new DefaultMutableTreeNode(this.um.get(n2));
                defaultMutableTreeNode2.add(defaultMutableTreeNode4);
                ++n2;
            }
        }
    }

    public void F(ah ah2) {
        this.uk = ah2;
    }

    private void mJ() {
        this.BZ = new JButton();
        this.LH = new JButton();
        this.LI = new JButton();
        this.vd = new JPanel();
        this.GJ = new JLabel();
        this.ut = new JScrollPane();
        this.yB = new JLabel();
        this.wi = new JScrollPane();
        this.yA = new JLabel();
        this.zf = new JScrollPane();
        this.Fr = new JLabel();
        this.LJ = new JButton();
        this.LK = new JButton();
        this.LL = new JButton();
        this.LM = new JButton();
        this.LZ = new JLabel();
        this.Hn = new JLabel();
        this.Bf = new JComboBox();
        this.Bg = new JComboBox();
        this.Bh = new JComboBox();
        this.Bi = new JComboBox();
        this.LU = new JComboBox();
        this.LV = new JComboBox();
        this.LP = new JCheckBox();
        this.LN = new JButton();
        this.LW = new JComboBox();
        this.LX = new JComboBox();
        this.LY = new JComboBox();
        this.LR = new JComboBox();
        this.LS = new JComboBox();
        this.LT = new JComboBox();
        this.LO = new JButton();
        this.LQ = new JCheckBox();
        this.zg = new JScrollPane();
        this.uw = new JTree();
        this.setBackground(new Color(84, 127, 59));
        this.BZ.setText("sair");
        this.LH.setText("set 1");
        this.LI.setText("set 2");
        this.GJ.setFont(new Font("Tahoma", 1, 11));
        this.GJ.setText("t1 x t2");
        this.yB.setText("jLabel1");
        this.yB.setVerticalAlignment(1);
        this.ut.setViewportView(this.yB);
        this.yA.setForeground(new Color(0, 51, 51));
        this.yA.setText("jLabel2");
        this.yA.setVerticalAlignment(1);
        this.wi.setViewportView(this.yA);
        this.Fr.setForeground(new Color(0, 51, 51));
        this.Fr.setText("jLabel2");
        this.Fr.setVerticalAlignment(1);
        this.zf.setViewportView(this.Fr);
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.GJ, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.wi, -1, 183, Short.MAX_VALUE).addComponent(this.zf)).addGap(18, 18, 18).addComponent(this.ut, -2, 216, -2).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.GJ, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.wi, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.zf)).addGroup(groupLayout.createSequentialGroup().addComponent(this.ut, -2, 329, -2).addGap(0, 8, Short.MAX_VALUE))).addContainerGap()));
        this.LJ.setText("r1");
        this.LK.setText("r10");
        this.LL.setText("r100");
        this.LM.setText("r1000");
        this.LZ.setForeground(new Color(255, 255, 255));
        this.LZ.setText("jLabel1");
        this.Hn.setForeground(new Color(255, 255, 255));
        this.Hn.setText("jLabel1");
        this.LP.setText("jogo fora");
        this.LN.setText("sT1");
        this.LO.setText("sT1");
        this.LQ.setText("campo neutro");
        this.zg.setViewportView(this.uw);
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout2.createSequentialGroup().addComponent(this.LH, -2, 89, -2).addGap(37, 37, 37).addComponent(this.LI, -2, 89, -2)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.LZ, -2, 111, -2).addGap(18, 18, 18).addComponent(this.Hn, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.LQ, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.LP, GroupLayout.Alignment.LEADING, -1, 189, Short.MAX_VALUE)).addComponent(this.zg)).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.LN).addGap(0, 0, Short.MAX_VALUE)).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.LJ, -2, 66, -2).addGap(18, 18, 18).addComponent(this.LK, -2, 66, -2).addGap(18, 18, 18).addComponent(this.LL, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.LM, -2, 75, -2)).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.Bg, GroupLayout.Alignment.LEADING, 0, 123, Short.MAX_VALUE).addComponent(this.Bf, GroupLayout.Alignment.LEADING, 0, -1, Short.MAX_VALUE)).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Bh, -2, 123, -2).addComponent(this.Bi, -2, 123, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.LU, -2, 123, -2).addComponent(this.LV, -2, 123, -2)))).addContainerGap(-1, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.LEADING, groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.LX, GroupLayout.Alignment.LEADING, 0, -1, Short.MAX_VALUE).addComponent(this.LW, GroupLayout.Alignment.LEADING, -2, 123, -2)).addComponent(this.LO)).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.BZ, -2, 112, -2).addGap(25, 25, 25)).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.LY, -2, 123, -2).addComponent(this.LR, -2, 123, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.LS, -2, 123, -2).addComponent(this.LT, -2, 123, -2)).addGap(0, 144, Short.MAX_VALUE))))).addGap(15, 15, 15)))));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.zg, -2, 346, -2).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.LH).addComponent(this.LI))).addComponent(this.vd, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.LJ).addComponent(this.LK).addComponent(this.LL).addComponent(this.LM))).addGroup(groupLayout2.createSequentialGroup().addGap(6, 6, 6).addComponent(this.LZ)).addGroup(groupLayout2.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Hn))).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.LP)).addGroup(groupLayout2.createSequentialGroup().addGap(11, 11, 11).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Bh, -2, -1, -2).addComponent(this.LU, -2, -1, -2))).addGroup(groupLayout2.createSequentialGroup().addGap(7, 7, 7).addComponent(this.Bf, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Bg, -2, -1, -2).addComponent(this.Bi, -2, -1, -2).addComponent(this.LV, -2, -1, -2)))).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.LN)).addGroup(groupLayout2.createSequentialGroup().addGap(1, 1, 1).addComponent(this.LQ))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(4, 4, 4).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.LS, -2, -1, -2).addComponent(this.LY, -2, -1, -2))).addGroup(groupLayout2.createSequentialGroup().addComponent(this.LW, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.LX, -2, -1, -2).addComponent(this.LT, -2, -1, -2).addComponent(this.LR, -2, -1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.LO).addGap(24, 24, 24)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.BZ).addContainerGap()))));
    }

    static /* synthetic */ JDialog a(hF hF2) {
        return hF2.ub;
    }

    static /* synthetic */ ah b(hF hF2) {
        return hF2.uk;
    }

    static /* synthetic */ void c(hF hF2) {
        hF2.sk();
    }

    static /* synthetic */ void a(hF hF2, int n2) {
        hF2.dB(n2);
    }

    static /* synthetic */ void d(hF hF2) {
        hF2.sl();
    }

    static /* synthetic */ void b(hF hF2, int n2) {
        hF2.dA(n2);
    }

    static /* synthetic */ JTree e(hF hF2) {
        return hF2.uw;
    }
}

