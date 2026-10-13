/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aJ;
import a.hd;
import a.he;
import a.hf;
import a.hg;
import a.hh;
import a.hi;
import a.hj;
import b.H;
import b.I;
import b.aB;
import b.aC;
import best.S;
import best.Z;
import best.ah;
import best.aq;
import c.a;
import components.ad;
import components.ae;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class hc
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private ah KF = null;
    private ArrayList KG = new ArrayList();
    private ArrayList KH = new ArrayList();
    private ArrayList Fj = new ArrayList();
    private int vk = -1;
    private int vl = -1;
    private int w = 0;
    public static Comparator KI = new hd();
    public static Comparator KJ = new he();
    private JButton vm;
    private JButton Ie;
    private JComboBox ue;
    private JComboBox KK;
    private JPanel vd;
    private JScrollPane ut;
    private JScrollPane wi;
    private JLabel xI;
    private JLabel uu;
    private JLabel vf;
    private JTable Fl;
    private JTable vn;

    public hc(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.KF = ah2;
        this.mJ();
        this.mH();
        this.mQ();
        this.pq();
        this.w = 2;
        this.KK.setSelectedIndex(2);
        this.vn.setRowSelectionInterval(0, 0);
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.vm.addActionListener(new hf(this));
        this.Ie.addActionListener(new hg(this));
    }

    private void rw() {
        S.v(this.uk);
    }

    private void mQ() {
        this.ue.addItem("Internacional");
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            this.ue.addItem(((Z)a.SR.N().get(n2)).jp());
            if (((Z)a.SR.N().get(n2)).jc() == this.vk) {
                this.vl = n2 + 1;
            }
            ++n2;
        }
        aJ aJ2 = new aJ();
        aJ2.setPreferredSize(new Dimension(10, 25));
        this.ue.setRenderer(aJ2);
        this.ue.setMaximumRowCount(12);
        this.ue.setSelectedIndex(0);
        this.ue.addActionListener(new hh(this));
        this.KK.addItem("Ranking por reputa\u00e7\u00e3o");
        this.KK.addItem("Ranking por pontos corridos");
        this.KK.addItem("Ranking por coloca\u00e7\u00e3o");
        this.KK.addActionListener(new hi(this));
    }

    private void mU() {
        this.dw(this.KK.getSelectedIndex());
    }

    private void dw(int n2) {
        int n3;
        this.w = n2;
        int n4 = this.ue.getSelectedIndex() - 1;
        this.KG.clear();
        if (n4 >= 0) {
            this.vl = ((Z)a.SR.N().get(n4)).jc();
            n3 = 0;
            while (n3 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n3)).getPais() == this.vl) {
                    this.KG.add((ah)a.SR.P().get(n3));
                }
                ++n3;
            }
        } else {
            n3 = 0;
            while (n3 < a.SR.P().size()) {
                this.KG.add((ah)a.SR.P().get(n3));
                ++n3;
            }
        }
        this.KH.clear();
        n3 = 0;
        while (n3 < this.KG.size()) {
            ae ae2 = new ae();
            ae2.n((ah)this.KG.get(n3));
            ae2.a(this.w);
            if (this.w == 0) {
                ae2.dQ(((ah)this.KG.get(n3)).getReputacao());
            } else if (this.w == 1) {
                ae2.m(((ah)this.KG.get(n3)).ld());
            } else if (this.w == 2) {
                ae2.dQ(((ah)this.KG.get(n3)).lb());
            }
            this.KH.add(ae2);
            ++n3;
        }
        if (n2 == 1) {
            Collections.sort(this.KH, KJ);
        } else {
            Collections.sort(this.KH, KI);
        }
        this.dx(this.w);
        this.vn.setRowSelectionInterval(0, 0);
        this.vn.scrollRectToVisible(new Rectangle(this.vn.getCellRect(0, 0, true)));
    }

    private void dx(int n2) {
        H h3 = new H(this.KH, n2);
        this.vn.setModel(h3);
        int[] nArray = new int[]{40, 200, 150, 40};
        int n3 = 0;
        while (n3 < nArray.length) {
            this.vn.getColumnModel().getColumn(n3).setPreferredWidth(nArray[n3]);
            ++n3;
        }
        this.vn.getColumnModel().getColumn(0).setMaxWidth(40);
        this.vn.getColumnModel().getColumn(1).setMaxWidth(200);
        this.vn.getColumnModel().getColumn(2).setMaxWidth(200);
        this.vn.setAutoResizeMode(3);
        this.vn.setRowHeight(20);
        this.vn.setShowGrid(false);
        this.vn.setDefaultRenderer(ae.class, new aB());
        this.vn.setAutoCreateRowSorter(false);
        this.vn.getTableHeader().setReorderingAllowed(false);
        this.vn.setIntercellSpacing(new Dimension(0, 0));
        this.vn.setCellSelectionEnabled(false);
        this.vn.setSelectionMode(0);
        this.vn.setRowSelectionAllowed(true);
        this.vn.setSelectionBackground(Color.YELLOW);
        this.vn.setFillsViewportHeight(true);
        this.vn.getSelectionModel().addListSelectionListener(new hj(this));
    }

    private boolean dy(int n2) {
        if (n2 == 3 && !a.SR.isJogaEstadual()) {
            return false;
        }
        if (n2 == 3 && this.uk.getPais() != 29) {
            return false;
        }
        if (n2 == 4 || n2 == 6 || n2 == 5 || n2 == 8 || n2 == 12) {
            if (!a.SR.isJogaIntClubes()) {
                return false;
            }
            if (n2 == 6 && this.uk.gg() > 1) {
                return false;
            }
            if (n2 == 8 && this.uk.gg() > 1) {
                return false;
            }
            if (n2 == 12 && this.uk.gg() > 0) {
                return false;
            }
        }
        return !aq.fs(n2);
    }

    private void rW() {
        this.uu.setText(this.uk.getNome());
        this.Fj.clear();
        if (this.w == 0) {
            this.xI.setText(aq.pZ[this.uk.getReputacao()]);
        } else if (this.w == 1) {
            int[][] nArray = this.uk.lc();
            int[] nArray2 = this.uk.ld();
            this.xI.setText("PG:" + Integer.toString(nArray2[0]) + " GP:" + Integer.toString(nArray2[1]) + " GC:" + Integer.toString(nArray2[2]));
            int n2 = 1;
            while (n2 <= 14) {
                if (nArray[n2][0] > 0 && this.dy(n2)) {
                    ad ad2 = new ad();
                    ad2.n(this.uk);
                    ad2.a(n2);
                    ad2.m(nArray[n2]);
                    ad2.dR(1);
                    this.Fj.add(ad2);
                }
                ++n2;
            }
        } else if (this.w == 2) {
            int[] nArray = this.uk.la();
            this.xI.setText(String.valueOf(Integer.toString(this.uk.lb())) + " pontos");
            int n3 = 1;
            while (n3 <= 14) {
                if (nArray[n3] > 0 && this.dy(n3)) {
                    ad ad3 = new ad();
                    ad3.n(this.uk);
                    ad3.a(n3);
                    ad3.dQ(nArray[n3]);
                    ad3.dR(2);
                    this.Fj.add(ad3);
                }
                ++n3;
            }
        }
        this.Fl.addNotify();
    }

    private void pq() {
        I i2 = new I(this.Fj, this.w);
        this.Fl.setModel(i2);
        int[] nArray = new int[]{100, 50};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Fl.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Fl.setAutoResizeMode(3);
        this.Fl.setRowHeight(20);
        this.Fl.setShowGrid(false);
        this.Fl.setDefaultRenderer(ad.class, new aC());
        this.Fl.setAutoCreateRowSorter(false);
        this.Fl.getTableHeader().setReorderingAllowed(false);
        this.Fl.setIntercellSpacing(new Dimension(0, 0));
        this.Fl.setCellSelectionEnabled(false);
        this.Fl.setSelectionMode(0);
        this.Fl.setRowSelectionAllowed(true);
        this.Fl.setSelectionBackground(Color.YELLOW);
        this.Fl.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.vf = new JLabel();
        this.ue = new JComboBox();
        this.KK = new JComboBox();
        this.vm = new JButton();
        this.ut = new JScrollPane();
        this.vn = new JTable();
        this.vd = new JPanel();
        this.uu = new JLabel();
        this.xI = new JLabel();
        this.wi = new JScrollPane();
        this.Fl = new JTable();
        this.Ie = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.vf.setFont(new Font("Tahoma", 1, 12));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("Ranking Clubes");
        this.vm.setText("X");
        this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.ut.setViewportView(this.vn);
        this.vd.setBackground(new Color(44, 53, 49));
        this.uu.setFont(new Font("Tahoma", 1, 12));
        this.uu.setForeground(new Color(255, 255, 255));
        this.uu.setText("T\u00e9cnico");
        this.xI.setFont(new Font("Tahoma", 0, 12));
        this.xI.setForeground(new Color(255, 255, 255));
        this.xI.setText("T\u00e9cnico");
        this.xI.setVerticalAlignment(1);
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.uu, -2, 254, -2).addGap(0, 81, Short.MAX_VALUE)).addComponent(this.xI, -1, -1, Short.MAX_VALUE)).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.uu, -1, 24, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.xI, -2, 20, -2)));
        this.wi.setBackground(new Color(255, 255, 255));
        this.Fl.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.wi.setViewportView(this.Fl);
        this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trofeu_s01.png")));
        this.Ie.setText("trof\u00e9us e t\u00edtulos");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(23, 23, 23).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ut, -2, 408, -2).addGroup(groupLayout2.createSequentialGroup().addComponent(this.vf, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.ue, -2, 167, -2))).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.KK, -2, 222, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 71, -2)).addComponent(this.wi, -1, 355, Short.MAX_VALUE).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addComponent(this.Ie, -1, -1, Short.MAX_VALUE)).addContainerGap(21, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(16, 16, 16).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vf).addComponent(this.ue, -2, 23, -2).addComponent(this.KK, -2, 23, -2).addComponent(this.vm)).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout2.createSequentialGroup().addComponent(this.vd, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.wi, -2, 423, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Ie, -1, -1, Short.MAX_VALUE)).addComponent(this.ut, -2, 530, -2)).addContainerGap(21, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(hc hc2) {
        return hc2.ub;
    }

    static /* synthetic */ void b(hc hc2) {
        hc2.rw();
    }

    static /* synthetic */ void c(hc hc2) {
        hc2.mU();
    }

    static /* synthetic */ JComboBox d(hc hc2) {
        return hc2.KK;
    }

    static /* synthetic */ void a(hc hc2, int n2) {
        hc2.dw(n2);
    }

    static /* synthetic */ JTable e(hc hc2) {
        return hc2.vn;
    }

    static /* synthetic */ ArrayList f(hc hc2) {
        return hc2.KH;
    }

    static /* synthetic */ void a(hc hc2, ah ah2) {
        hc2.uk = ah2;
    }

    static /* synthetic */ void g(hc hc2) {
        hc2.rW();
    }
}

