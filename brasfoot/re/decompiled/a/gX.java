/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aJ;
import a.gY;
import a.gZ;
import a.ha;
import a.hb;
import a.jE;
import a.jF;
import a.jl;
import b.G;
import b.aA;
import b.aM;
import best.S;
import best.Z;
import best.ah;
import best.al;
import best.aq;
import best.j;
import c.a;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class gX
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private al Es = null;
    private al KA = null;
    private int vk = -1;
    private int vl = -1;
    private int KB = -1;
    private ArrayList KC = new ArrayList();
    private ArrayList Fj = new ArrayList();
    public static Comparator KJ = new gY();
    private JButton Ie;
    private JButton vm;
    private JComboBox ue;
    private JComboBox KK;
    private JLabel ug;
    private JPanel vd;
    private JScrollPane ut;
    private JScrollPane wi;
    private JLabel xI;
    private JLabel Fs;
    private JTable Fl;
    private JTable KD;

    public gX(JDialog jDialog, al al2) {
        this.ub = jDialog;
        this.KA = al2;
        if (al2 != null) {
            this.vk = al2.fg() != null ? al2.fg().getPais() : al2.bz();
        }
        this.mJ();
        this.mH();
        this.mQ();
        this.mS();
        this.pq();
        if (this.vk >= 0 && this.vl >= 0) {
            this.ue.setSelectedIndex(this.vl);
        } else {
            this.ue.setSelectedIndex(0);
        }
        if (this.KA != null && this.KB >= 0 && this.KB < this.KC.size()) {
            this.KD.setRowSelectionInterval(this.KB, this.KB);
            if (this.KB > 20) {
                JViewport jViewport = (JViewport)this.KD.getParent();
                Rectangle rectangle = this.KD.getCellRect(this.KB - 10, 0, true);
                Point point = jViewport.getViewPosition();
                rectangle.setLocation(rectangle.x - point.x, rectangle.y - point.y);
                this.KD.scrollRectToVisible(rectangle);
            }
        } else {
            this.KD.setRowSelectionInterval(0, 0);
        }
        this.KD.requestFocusInWindow();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
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
        this.ue.addActionListener(new gZ(this));
        this.KK.addItem("Ranking por pontos");
        this.KK.addItem("Ranking por reputa\u00e7\u00e3o");
        this.KK.addActionListener(new ha(this));
    }

    private void AR() {
        int n2;
        int n3 = this.ue.getSelectedIndex() - 1;
        int n4 = -1;
        int n5 = -1;
        this.KC.clear();
        if (n3 >= 0) {
            if (n3 < a.SR.N().size() && n3 >= 0) {
                n4 = ((Z)a.SR.N().get(n3)).jc();
            }
            n2 = 0;
            while (n2 < a.SR.L().size()) {
                n5 = -1;
                n5 = ((al)a.SR.L().get(n2)).fg() != null ? ((al)a.SR.L().get(n2)).fg().getPais() : ((al)a.SR.L().get(n2)).bz();
                if (n5 == n4) {
                    this.KC.add((al)a.SR.L().get(n2));
                    if (a.SR.L().get(n2) == this.KA) {
                        this.KB = this.KC.size() - 1;
                    }
                }
                ++n2;
            }
        } else {
            n2 = 0;
            while (n2 < a.SR.L().size()) {
                this.KC.add((al)a.SR.L().get(n2));
                if (a.SR.L().get(n2) == this.KA) {
                    this.KB = this.KC.size() - 1;
                }
                ++n2;
            }
        }
        if (this.KK.getSelectedIndex() == 1) {
            Collections.sort(this.KC, KJ);
        }
        this.mS();
        this.KD.setRowSelectionInterval(0, 0);
        this.KD.scrollRectToVisible(new Rectangle(this.KD.getCellRect(0, 0, true)));
        this.KD.requestFocusInWindow();
        n2 = this.KD.convertRowIndexToModel(this.KD.getSelectedRow());
        if (n2 >= 0) {
            this.Es = (al)this.KC.get(n2);
            this.rV();
        }
    }

    public void mH() {
        this.vm.addActionListener(new hb(this));
        this.Ie.addActionListener(new jE(this));
    }

    private void rw() {
        this.Ie.setCursor(new Cursor(3));
        S.e(this.Es);
        this.Ie.setCursor(new Cursor(12));
    }

    private void mS() {
        G g2 = new G(this.KC, this.KK.getSelectedIndex());
        this.KD.setModel(g2);
        int[] nArray = new int[]{40, 125, 125, 50, 50};
        if (this.KK.getSelectedIndex() == 1) {
            int[] nArray2 = new int[5];
            nArray2[0] = 40;
            nArray2[1] = 125;
            nArray2[2] = 125;
            nArray2[3] = 150;
            int[] nArray3 = nArray2;
            nArray = nArray3;
        }
        int n2 = 0;
        while (n2 < nArray.length) {
            this.KD.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.KD.setAutoResizeMode(3);
        this.KD.setRowHeight(20);
        this.KD.setShowGrid(false);
        this.KD.setDefaultRenderer(al.class, new aA(this.KK.getSelectedIndex()));
        this.KD.setAutoCreateRowSorter(false);
        this.KD.getTableHeader().setReorderingAllowed(false);
        this.KD.setIntercellSpacing(new Dimension(0, 0));
        this.KD.setCellSelectionEnabled(false);
        this.KD.setSelectionMode(0);
        this.KD.setRowSelectionAllowed(true);
        this.KD.setSelectionBackground(Color.YELLOW);
        this.KD.setFillsViewportHeight(true);
        this.KD.getSelectionModel().addListSelectionListener(new jF(this));
    }

    public void rV() {
        int[] nArray = new int[5];
        if (this.Es != null) {
            String string = "";
            if (this.Es.getReputacao() < aq.pZ.length) {
                string = aq.pZ[this.Es.getReputacao()];
            }
            this.Fs.setText(String.valueOf(this.Es.dS()) + "       (reputa\u00e7\u00e3o: " + string + ")");
            this.Fj.clear();
            int n2 = this.Es.lO().size() - 1;
            while (n2 >= 0) {
                this.Fj.add((j)this.Es.lO().get(n2));
                --n2;
            }
            this.Fl.addNotify();
            n2 = this.Es.lO().size() - 1;
            while (n2 >= 0) {
                nArray[0] = nArray[0] + ((j)this.Es.lO().get(n2)).w();
                nArray[1] = nArray[1] + ((j)this.Es.lO().get(n2)).cm();
                nArray[2] = nArray[2] + ((j)this.Es.lO().get(n2)).co();
                nArray[3] = nArray[3] + ((j)this.Es.lO().get(n2)).cq();
                nArray[4] = nArray[4] + ((j)this.Es.lO().get(n2)).cr();
                --n2;
            }
            this.xI.setText(String.valueOf(Integer.toString(nArray[0])) + " J, " + Integer.toString(nArray[1]) + " V, " + Integer.toString(nArray[2]) + " D, " + Integer.toString(nArray[3]) + " Pontos, " + Integer.toString(nArray[4]) + " T\u00edtulos");
        }
    }

    private void pq() {
        jl jl2 = new jl(this.Fj);
        this.Fl.setModel(jl2);
        int[] nArray = new int[]{20, 120, 20, 20, 20, 20, 20, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Fl.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Fl.setAutoResizeMode(3);
        this.Fl.setRowHeight(20);
        this.Fl.setShowGrid(false);
        this.Fl.setDefaultRenderer(j.class, new aM());
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
        this.ug = new JLabel();
        this.ue = new JComboBox();
        this.vm = new JButton();
        this.ut = new JScrollPane();
        this.KD = new JTable();
        this.vd = new JPanel();
        this.Fs = new JLabel();
        this.xI = new JLabel();
        this.Ie = new JButton();
        this.wi = new JScrollPane();
        this.Fl = new JTable();
        this.KK = new JComboBox();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Ranking de T\u00e9cnicos");
        this.vm.setText("X");
        this.KD.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.ut.setViewportView(this.KD);
        this.vd.setBackground(new Color(44, 53, 49));
        this.Fs.setFont(new Font("Tahoma", 1, 12));
        this.Fs.setForeground(new Color(255, 255, 102));
        this.Fs.setText("T\u00e9cnico");
        this.xI.setFont(new Font("Tahoma", 0, 12));
        this.xI.setForeground(new Color(255, 255, 102));
        this.xI.setText("T\u00e9cnico");
        this.xI.setVerticalAlignment(1);
        this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
        this.Ie.setBorderPainted(false);
        this.Ie.setFocusable(false);
        this.Ie.setHorizontalTextPosition(0);
        this.Ie.setOpaque(false);
        this.Ie.setVerticalTextPosition(3);
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.xI, -1, -1, Short.MAX_VALUE).addComponent(this.Fs, -1, 328, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Ie, -2, 41, -2).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.Fs, -1, -1, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.xI).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Ie, -2, 41, -2).addContainerGap(19, Short.MAX_VALUE)));
        this.wi.setBackground(new Color(255, 255, 255));
        this.Fl.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.wi.setViewportView(this.Fl);
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.ug, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.ue, -2, 217, -2)).addGroup(groupLayout2.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE).addComponent(this.ut, -2, 404, -2))).addGap(16, 16, 16).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.KK, -2, 222, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 52, -2)).addComponent(this.vd, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE).addComponent(this.wi, -1, 422, Short.MAX_VALUE)).addGap(18, 18, 18)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(16, 16, 16).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.ue, -2, 23, -2).addComponent(this.vm).addComponent(this.KK, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout2.createSequentialGroup().addComponent(this.vd, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.wi)).addComponent(this.ut, -2, 588, -2)).addContainerGap(23, Short.MAX_VALUE)));
        this.ug.getAccessibleContext().setAccessibleName("Ranking T\u00e9cnicos");
        this.ug.getAccessibleContext().setAccessibleDescription("");
    }

    static /* synthetic */ void a(gX gX2) {
        gX2.AR();
    }

    static /* synthetic */ JDialog b(gX gX2) {
        return gX2.ub;
    }

    static /* synthetic */ void c(gX gX2) {
        gX2.rw();
    }

    static /* synthetic */ JTable d(gX gX2) {
        return gX2.KD;
    }

    static /* synthetic */ ArrayList e(gX gX2) {
        return gX2.KC;
    }

    static /* synthetic */ void a(gX gX2, al al2) {
        gX2.Es = al2;
    }
}

