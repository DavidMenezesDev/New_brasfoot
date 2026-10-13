/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hD;
import a.hE;
import b.W;
import b.X;
import b.aP;
import b.aQ;
import best.ah;
import best.ap;
import best.aq;
import best.u;
import c.a;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class hC
extends JPanel {
    private ArrayList uK = new ArrayList();
    private ArrayList LB = new ArrayList();
    private JDialog ub;
    private ah uk = null;
    private JButton vm;
    private JComboBox GD;
    private JScrollPane ut;
    private JLabel vf;
    private JTable LC;

    public hC(JDialog jDialog, ah ah2, int n2) {
        this.uk = ah2;
        this.ub = jDialog;
        this.mJ();
        if (n2 == 1) {
            this.vf.setText("\u00daltimas trocas de t\u00e9cnicos");
        }
        if (n2 == 0) {
            this.mQ();
            this.mS();
        } else {
            this.GD.setVisible(false);
            int n3 = 0;
            int n4 = 0;
            while (n4 < a.SR.bn().size()) {
                this.LB.add((u)a.SR.bn().get(n4));
                if (++n3 == 100) break;
                ++n4;
            }
            this.sj();
        }
        this.mH();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void mQ() {
        this.GD.addItem("Todos os times");
        this.GD.addItem(this.uk.getNome());
        this.GD.addActionListener(new hD(this));
        this.GD.setSelectedIndex(1);
    }

    private void si() {
        this.uK.clear();
        int n2 = 0;
        if (this.GD.getSelectedIndex() == 0) {
            int n3 = a.SR.bo().size() - 1;
            while (n3 >= 0) {
                if (((ap)a.SR.bo().get(n3)).x() != null) {
                    this.uK.add((ap)a.SR.bo().get(n3));
                    if (++n2 == 200) break;
                }
                --n3;
            }
        } else {
            int n4 = a.SR.bo().size() - 1;
            while (n4 >= 0) {
                if (((ap)a.SR.bo().get(n4)).x() != null && (((ap)a.SR.bo().get(n4)).lZ() == this.uk.lk() || ((ap)a.SR.bo().get(n4)).ma() == this.uk.lk())) {
                    this.uK.add((ap)a.SR.bo().get(n4));
                }
                --n4;
            }
        }
        this.LC.addNotify();
    }

    private void sj() {
        X x2 = new X(this.LB);
        this.LC.setModel(x2);
        int[] nArray = new int[]{30, 120, 120, 120};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.LC.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.LC.setAutoResizeMode(3);
        this.LC.setRowHeight(20);
        this.LC.setShowGrid(false);
        this.LC.setDefaultRenderer(u.class, new aQ());
        this.LC.setAutoCreateRowSorter(false);
        this.LC.getTableHeader().setReorderingAllowed(false);
        this.LC.setIntercellSpacing(new Dimension(0, 0));
        this.LC.setCellSelectionEnabled(false);
        this.LC.setSelectionMode(0);
        this.LC.setRowSelectionAllowed(true);
        this.LC.setSelectionBackground(Color.YELLOW);
        this.LC.setFillsViewportHeight(true);
    }

    private void mS() {
        W w2 = new W(this.uK);
        this.LC.setModel(w2);
        int[] nArray = new int[]{30, 120, 120, 120, 50};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.LC.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.LC.setAutoResizeMode(3);
        this.LC.setRowHeight(20);
        this.LC.setShowGrid(false);
        this.LC.setDefaultRenderer(ap.class, new aP());
        this.LC.setAutoCreateRowSorter(false);
        this.LC.getTableHeader().setReorderingAllowed(false);
        this.LC.setIntercellSpacing(new Dimension(0, 0));
        this.LC.setCellSelectionEnabled(false);
        this.LC.setSelectionMode(0);
        this.LC.setRowSelectionAllowed(true);
        this.LC.setSelectionBackground(Color.YELLOW);
        this.LC.setFillsViewportHeight(true);
    }

    public void mH() {
        this.vm.addActionListener(new hE(this));
    }

    private void mJ() {
        this.ut = new JScrollPane();
        this.LC = new JTable();
        this.vf = new JLabel();
        this.GD = new JComboBox();
        this.vm = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.ut.setViewportView(this.LC);
        this.vf.setFont(new Font("Tahoma", 1, 12));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("\u00daltimas transfer\u00eancias de jogadores");
        this.vm.setText("X");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.vf).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.GD, -2, 152, -2).addGap(59, 59, 59).addComponent(this.vm)).addComponent(this.ut, -2, 657, -2)).addContainerGap(19, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vf).addComponent(this.GD, -2, -1, -2).addComponent(this.vm)).addGap(18, 18, 18).addComponent(this.ut, -2, 429, -2).addContainerGap(20, Short.MAX_VALUE)));
    }

    static /* synthetic */ JComboBox a(hC hC2) {
        return hC2.GD;
    }

    static /* synthetic */ void b(hC hC2) {
        hC2.si();
    }

    static /* synthetic */ JDialog c(hC hC2) {
        return hC2.ub;
    }
}

