/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.e;
import a.f;
import a.g;
import best.I;
import best.Z;
import best.ac;
import best.ad;
import best.ah;
import best.aq;
import best.n;
import c.a;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
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

public class d
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

    public d(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.ul = ah2;
        this.mJ();
        this.uu.setText(String.valueOf(ah2.getNome()) + "  - marcar amistosos");
        this.uu.setIcon(ah2.kU());
        this.mM();
        this.mH();
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
        this.un = f.a.M(this.ul);
        int n2 = 0;
        while (n2 < this.un.size()) {
            this.up.addItem(((best.a)a.SR.R().get((Integer)this.un.get(n2))).f());
            ++n2;
        }
    }

    private void mH() {
        this.ud.addActionListener(new e(this));
        this.uo.addActionListener(new f(this));
    }

    public static boolean d(ah ah2, int n2) {
        ArrayList arrayList = new ArrayList();
        arrayList = ((best.a)a.SR.R().get(n2)).h();
        int n3 = 0;
        while (n3 < arrayList.size()) {
            if (((I)arrayList.get(n3)).hc() == ah2 || ((I)arrayList.get(n3)).hd() == ah2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private void mL() {
        if (this.up.getSelectedIndex() < 0 || this.un.size() == 0) {
            JOptionPane.showMessageDialog(this.ub, "N\u00e3o h\u00e1 datas dispon\u00edveis", "Amistoso", 2);
        } else if (this.uk == null) {
            JOptionPane.showMessageDialog(this.ub, "Selecione um advers\u00e1rio", "Amistoso", 2);
        } else if (d.d(this.uk, (Integer)this.un.get(this.up.getSelectedIndex()))) {
            JOptionPane.showMessageDialog(this.ub, "A sele\u00e7\u00e3o advers\u00e1ria j\u00e1 tem um jogo nesta data", "Amistoso", 2);
        } else if (this.ul != this.uk) {
            JOptionPane.showMessageDialog(this.ub, "Amistoso marcado.", "Amistoso", 2);
            f.a.b(this.ul, this.uk, this.uq.getSelectedIndex(), (Integer)this.un.get(this.up.getSelectedIndex()));
            if (!this.uk.jZ().booleanValue()) {
                Z z2 = a.SR.s(this.uk.getPais());
                z2.z(false);
            }
            this.un.clear();
            this.up.removeAllItems();
            this.mK();
        }
    }

    public void F(ah ah2) {
        this.uk = ah2;
        this.ur.setText("Selecionado: " + this.uk.getNome());
        this.ur.setIcon(this.uk.kU());
    }

    private void mM() {
        this.uw.getSelectionModel().setSelectionMode(1);
        this.uw.addTreeSelectionListener(new g(this));
        int n2 = 0;
        while (n2 < ac.jz()) {
            int n3 = ((ad)n.cY().get(n2)).getPais();
            Z z2 = a.SR.s(n3);
            if (z2.jl() && z2.jo() != this.ul) {
                this.um.add(z2.jo());
            }
            ++n2;
        }
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Times");
        this.a(defaultMutableTreeNode);
        this.uw.setModel(new DefaultTreeModel(defaultMutableTreeNode));
        this.uw.setRootVisible(false);
        this.uw.expandRow(0);
    }

    private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = null;
        Object var3_3 = null;
        DefaultMutableTreeNode defaultMutableTreeNode3 = null;
        if (this.um.size() > 0) {
            defaultMutableTreeNode2 = new DefaultMutableTreeNode("Sele\u00e7\u00f5es");
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            int n2 = 0;
            while (n2 < this.um.size()) {
                defaultMutableTreeNode3 = new DefaultMutableTreeNode(this.um.get(n2));
                defaultMutableTreeNode2.add(defaultMutableTreeNode3);
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

    static /* synthetic */ JDialog a(d d2) {
        return d2.ub;
    }

    static /* synthetic */ void b(d d2) {
        d2.mL();
    }

    static /* synthetic */ JTree c(d d2) {
        return d2.uw;
    }
}

