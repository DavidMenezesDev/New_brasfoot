/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cf;
import a.cg;
import a.ch;
import a.ci;
import a.cj;
import a.ck;
import best.F;
import best.ah;
import best.aq;
import c.a;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ce
extends JPanel {
    private JDialog ub;
    private ah ul = null;
    private ArrayList BQ = new ArrayList();
    private F yK = null;
    private JButton yW;
    private JButton ud;
    private JButton BR;
    private JButton BS;
    private JButton BT;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JPanel vd;
    private JScrollPane ut;
    private JLabel zh;
    private JSpinner BU;
    private JTree BV;

    public ce(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.ul = ah2;
        this.mJ();
        this.mM();
        this.mH();
        this.BU.setModel(new SpinnerNumberModel(this.oz(), 1, 99, 1));
        this.zh.setText("");
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.vd.setBackground(aq.E(a.vM().getCorTema(), 2));
    }

    private void mH() {
        this.ud.addActionListener(new cf(this));
        this.BT.addActionListener(new cg(this));
        this.yW.addActionListener(new ch(this));
        this.BR.addActionListener(new ci(this));
        this.BS.addActionListener(new cj(this));
    }

    private void ov() {
        int n2 = 0;
        while (n2 < this.ul.kc().size()) {
            ((F)this.ul.kc().get(n2)).ah(0);
            ++n2;
        }
        this.ox();
    }

    private void ow() {
        if (this.yK != null) {
            this.yK.ah(0);
        }
        this.ox();
    }

    private void nz() {
        int n2 = 0;
        while (n2 < this.ul.kc().size()) {
            ((F)this.ul.kc().get(n2)).ah(0);
            ++n2;
        }
        int[][] nArrayArray = new int[][]{{1, 12, 22}, {2, 6, 13, 16}, {3, 4, 14, 15}, {7, 10, 19, 20}, {9, 11, 21, 23}, {5, 8, 17, 18}};
        int[] nArray = new int[6];
        int n3 = 0;
        while (n3 < this.ul.kc().size()) {
            int n4 = ((F)this.ul.kc().get(n3)).getPosicao();
            if (n4 == 3 && ((F)this.ul.kc().get(n3)).fF() == 0) {
                n4 = 5;
            }
            if (nArray[n4] < nArrayArray[n4].length) {
                ((F)this.ul.kc().get(n3)).ah(nArrayArray[n4][nArray[n4]]);
                int n5 = n4;
                nArray[n5] = nArray[n5] + 1;
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < this.ul.kc().size()) {
            if (((F)this.ul.kc().get(n3)).fn() <= 0) {
                ((F)this.ul.kc().get(n3)).ah(this.oz());
            }
            ++n3;
        }
        this.ox();
    }

    private void ox() {
        this.BV.removeAll();
        this.BQ.clear();
        this.mM();
    }

    private void oy() {
        this.zh.setText("");
        if (this.yK != null) {
            int n2 = (Integer)this.BU.getValue();
            if (n2 > 0 && n2 <= 99 && !this.cY(n2)) {
                this.yK.ah(n2);
                this.ox();
            } else {
                this.zh.setText("N\u00famero j\u00e1 escolhido");
            }
        } else {
            this.zh.setText("Selecione um jogador");
        }
    }

    private int oz() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n2 = 1;
        int n3 = 0;
        while (n3 < this.ul.kc().size()) {
            if (((F)this.ul.kc().get(n3)).fn() > 0) {
                arrayList.add(((F)this.ul.kc().get(n3)).fn());
            }
            ++n3;
        }
        n3 = 1;
        while (n3 < 100) {
            boolean bl2 = false;
            int n4 = 0;
            while (n4 < arrayList.size()) {
                if (((Integer)arrayList.get(n4)).equals(n3)) {
                    bl2 = true;
                    break;
                }
                ++n4;
            }
            if (!bl2) {
                n2 = n3;
                break;
            }
            ++n3;
        }
        return n2;
    }

    private boolean cY(int n2) {
        int n3 = 0;
        while (n3 < this.ul.kc().size()) {
            if (((F)this.ul.kc().get(n3)).fn() == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public void y(F f2) {
    }

    private void mM() {
        this.BV.getSelectionModel().setSelectionMode(1);
        this.BV.addTreeSelectionListener(new ck(this));
        int n2 = 0;
        while (n2 < this.ul.kc().size()) {
            this.BQ.add((F)this.ul.kc().get(n2));
            ++n2;
        }
        Collections.sort(this.BQ, h.a.aaR);
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Elenco");
        this.a(defaultMutableTreeNode);
        this.BV.setModel(new DefaultTreeModel(defaultMutableTreeNode));
        this.BV.setRootVisible(false);
        this.BV.expandRow(0);
    }

    private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = null;
        Object var3_3 = null;
        DefaultMutableTreeNode defaultMutableTreeNode3 = null;
        if (this.BQ.size() > 0) {
            defaultMutableTreeNode2 = new DefaultMutableTreeNode("Jogadores");
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            int n2 = 0;
            while (n2 < this.BQ.size()) {
                defaultMutableTreeNode3 = new DefaultMutableTreeNode(this.BQ.get(n2));
                defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                ++n2;
            }
        }
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ut = new JScrollPane();
        this.BV = new JTree();
        this.uh = new JLabel();
        this.BT = new JButton();
        this.a_ = new JLabel();
        this.yW = new JButton();
        this.zh = new JLabel();
        this.BU = new JSpinner();
        this.BR = new JButton();
        this.BS = new JButton();
        this.ug = new JLabel();
        this.ud = new JButton();
        this.setBackground(new Color(42, 64, 29));
        this.vd.setBackground(new Color(84, 127, 59));
        this.ut.setViewportView(this.BV);
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText("Selecione um jogador:");
        this.BT.setText("escolher");
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setText("Escolha um n\u00famero entre 1 e 99:");
        this.yW.setText("escolha autom\u00e1tica");
        this.zh.setForeground(new Color(255, 204, 153));
        this.zh.setHorizontalAlignment(0);
        this.zh.setText("jLabel4");
        this.BR.setText("limpar todos");
        this.BS.setText("limpa selecionado");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ut).addComponent(this.uh).addGroup(groupLayout.createSequentialGroup().addComponent(this.yW).addGap(18, 18, 18).addComponent(this.BR, -2, 117, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a_, GroupLayout.Alignment.TRAILING).addComponent(this.BU, GroupLayout.Alignment.TRAILING, -2, 91, -2).addComponent(this.BT, GroupLayout.Alignment.TRAILING, -2, 91, -2).addComponent(this.zh, GroupLayout.Alignment.TRAILING, -2, 164, -2).addComponent(this.BS, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.uh).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ut, -2, 0, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(41, 41, 41).addComponent(this.a_).addGap(18, 18, 18).addComponent(this.BU, -2, -1, -2).addGap(18, 18, 18).addComponent(this.BT).addGap(18, 18, 18).addComponent(this.zh).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE).addComponent(this.BS))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.yW).addComponent(this.BR)).addGap(15, 15, 15)));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setText("Numera\u00e7\u00e3o do elenco");
        this.ud.setText("X");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ug, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.ud, -2, 49, -2)).addComponent(this.vd, -2, -1, -2)).addContainerGap(20, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(17, 17, 17).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.ud)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vd, -2, -1, -2).addContainerGap(24, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(ce ce2) {
        return ce2.ub;
    }

    static /* synthetic */ void b(ce ce2) {
        ce2.oy();
    }

    static /* synthetic */ void c(ce ce2) {
        ce2.nz();
    }

    static /* synthetic */ void d(ce ce2) {
        ce2.ov();
    }

    static /* synthetic */ void e(ce ce2) {
        ce2.ow();
    }

    static /* synthetic */ JTree f(ce ce2) {
        return ce2.BV;
    }

    static /* synthetic */ void a(ce ce2, F f2) {
        ce2.yK = f2;
    }
}

