/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.i;
import a.j;
import a.k;
import best.C;
import best.Z;
import best.ah;
import best.aq;
import c.a;
import f.B;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class h
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private ah ul = null;
    private ArrayList um = new ArrayList();
    ArrayList un = new ArrayList();
    private JButton ud;
    private JButton uo;
    private JComboBox up;
    private JComboBox uq;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JScrollPane ut;
    private JLabel uu;
    private JPanel uv;
    private JTree uw;

    public h(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.ul = ah2;
        this.mJ();
        this.mM();
        this.mH();
        this.uu.setText(String.valueOf(ah2.getNome()) + " - marcar amistoso");
        this.uu.setIcon(ah2.kU());
        this.mK();
        String[] stringArray = new String[]{"Fora", "Casa"};
        this.uq.addItem(stringArray[0]);
        this.uq.addItem(stringArray[1]);
        this.uq.setSelectedIndex(0);
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.uv.setBackground(aq.E(a.vM().getCorTema(), 2));
    }

    private void mK() {
        this.un = f.a.L(this.ul);
        int n2 = 0;
        while (n2 < this.un.size()) {
            this.up.addItem(((best.a)a.SR.R().get((Integer)this.un.get(n2))).f());
            ++n2;
        }
    }

    private void mH() {
        this.ud.addActionListener(new i(this));
        this.uo.addActionListener(new j(this));
    }

    private void mL() {
        if (this.up.getSelectedIndex() < 0 || this.un.size() == 0) {
            JOptionPane.showMessageDialog(this.ub, "N\u00e3o h\u00e1 datas dispon\u00edveis", "Amistoso", 2);
        } else if (this.uk == null) {
            JOptionPane.showMessageDialog(this.ub, "Selecione um advers\u00e1rio", "Amistoso", 2);
        } else if (this.ul != this.uk) {
            int n2 = -1;
            n2 = f.a.a(this.ul, this.uk, this.uq.getSelectedIndex(), (Integer)this.un.get(this.up.getSelectedIndex()));
            String[] stringArray = new String[]{"Amistoso recusado", "Amistoso marcado", String.valueOf(this.uk.getNome()) + " j\u00e1 tem um amistoso nesta data", "Quer um valor de " + C.c(f.a.xY()) + "\n Deseja aceitar?"};
            if (n2 >= 0 && n2 < 3) {
                JOptionPane.showMessageDialog(this.ub, stringArray[n2], "Amistoso", 2);
            } else if (n2 == 3) {
                int n3 = -1;
                n3 = JOptionPane.showConfirmDialog(this.ub, stringArray[3], "Amistoso", 0);
                if (n3 == 0) {
                    n2 = 1;
                    this.ul.w(f.a.xY(), -1);
                }
            }
            if (n2 == 1) {
                f.a.b(this.ul, this.uk, this.uq.getSelectedIndex(), (Integer)this.un.get(this.up.getSelectedIndex()));
                this.un.clear();
                this.up.removeAllItems();
                this.mK();
            }
        }
    }

    public void F(ah ah2) {
        this.uk = ah2;
        this.ur.setText("Selecionado: " + this.uk.getNome());
        this.ur.setIcon(this.uk.kU());
    }

    private void mM() {
        this.uw.getSelectionModel().setSelectionMode(1);
        this.uw.addTreeSelectionListener(new k(this));
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

    private void mJ() {
        this.uu = new JLabel();
        this.uv = new JPanel();
        this.uh = new JLabel();
        this.up = new JComboBox();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.uq = new JComboBox();
        this.uo = new JButton();
        this.ut = new JScrollPane();
        this.uw = new JTree();
        this.ud = new JButton();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.uu.setFont(new Font("Tahoma", 1, 12));
        this.uu.setForeground(new Color(255, 255, 102));
        this.uu.setText("Marcar amistoso");
        this.uv.setBackground(new Color(104, 120, 100));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(4);
        this.uh.setText("Escolha uma data dispon\u00edvel:");
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(4);
        this.a_.setText("Escolha um advers\u00e1rio:");
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Time selecionado:");
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setHorizontalAlignment(4);
        this.us.setText("Local do jogo:");
        this.uo.setText("Propor amistoso");
        this.ut.setViewportView(this.uw);
        GroupLayout groupLayout = new GroupLayout(this.uv);
        this.uv.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.uh, -2, 164, -2).addGap(18, 18, 18).addComponent(this.up, -2, 141, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.a_, -2, 164, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ur, -2, 234, -2).addComponent(this.ut, -2, 243, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(this.us, -2, 164, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uo, -2, 180, -2).addComponent(this.uq, -2, 141, -2)))).addContainerGap(56, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.up, -2, -1, -2).addComponent(this.uh)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a_).addComponent(this.ut, -2, 248, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ur).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.us).addComponent(this.uq, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE).addComponent(this.uo).addGap(42, 42, 42)));
        this.ud.setText("X");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(27, 27, 27).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uv, -2, -1, -2).addGroup(groupLayout2.createSequentialGroup().addComponent(this.uu, -2, 434, -2).addGap(18, 18, 18).addComponent(this.ud, -2, 52, -2))).addContainerGap(23, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uu).addComponent(this.ud)).addGap(18, 18, 18).addComponent(this.uv, -2, -1, -2).addContainerGap(27, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(h h3) {
        return h3.ub;
    }

    static /* synthetic */ void b(h h3) {
        h3.mL();
    }

    static /* synthetic */ JTree c(h h3) {
        return h3.uw;
    }
}

