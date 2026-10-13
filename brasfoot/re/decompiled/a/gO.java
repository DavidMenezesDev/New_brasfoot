/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import a.gP;
import a.gQ;
import a.gR;
import a.gS;
import a.gT;
import a.gU;
import a.hw;
import b.U;
import b.aO;
import b.aT;
import b.aV;
import best.F;
import best.S;
import best.Z;
import best.ac;
import best.ah;
import best.al;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class gO
extends JPanel {
    private JDialog ub = null;
    private al Es = null;
    private ah Em = null;
    private ArrayList Kh = new ArrayList();
    private ArrayList uK = new ArrayList();
    private int w = 0;
    private JButton Ki;
    private JButton HR;
    private JButton Kj;
    private JButton HY;
    private JButton aeN;
    private ButtonGroup Kl;
    private JLabel ug;
    private JLabel uh;
    private JLabel ur;
    private JPanel vd;
    private JScrollPane ut;
    private JScrollPane wi;
    private JToolBar ve;
    private JLabel Fs;
    private JLabel uu;
    private JTable zj;
    private JTable vn;

    public gO(JDialog jDialog, ArrayList arrayList, al al2, int n2) {
        this.ub = jDialog;
        this.Kh = arrayList;
        this.Es = al2;
        this.w = n2;
        this.mJ();
        this.Fs.setText(this.Es.dS());
        this.Ay();
        this.mH();
        this.AP();
        if (this.Kh.size() > 0) {
            this.vn.setRowSelectionInterval(0, 0);
        }
    }

    private void AP() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
        if (this.w == 0) {
            this.ug.setText("Convites para ser t\u00e9cnico");
            this.Ki.setText("Assumir time");
            this.uh.setText("Equipe atual");
        }
    }

    public void mH() {
        this.Ki.addActionListener(new gP(this));
        this.Kj.addActionListener(new gQ(this));
        this.HR.addActionListener(new gR(this));
        this.aeN.addActionListener(new gS(this));
        this.HY.addActionListener(new gT(this));
    }

    private void qP() {
        this.HY.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.ub);
        hw hw2 = new hw(jDialog, this.Em);
        jDialog.add(hw2);
        jDialog.setSize(740, 684);
        jDialog.setPreferredSize(new Dimension(740, 684));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HY.setCursor(new Cursor(12));
    }

    private void AA() {
        this.aeN.setCursor(new Cursor(3));
        S.a(0, null);
        this.aeN.setCursor(new Cursor(12));
    }

    private void sD() {
        this.HR.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.ub);
        L l2 = new L(jDialog, this.Em);
        jDialog.add(l2);
        jDialog.setSize(820, 600);
        jDialog.setPreferredSize(new Dimension(820, 600));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HR.setCursor(new Cursor(12));
    }

    private void rT() {
        if (this.w == 0) {
            if (this.Es.fg() != null) {
                this.Es.fg().kE();
            }
            a.SR.a(this.Em, this.Em.ka(), this.Es);
            this.ub.dispose();
        } else {
            Z z2 = a.SR.s(this.Em.getPais());
            if (z2 != null && this.Es != null) {
                z2.g(this.Es);
            } else {
                this.ub.dispose();
            }
        }
    }

    private void rW() {
        String string = "";
        ImageIcon imageIcon = null;
        if (this.w == 0) {
            string = this.Em.getNome();
            imageIcon = this.Em.kU();
        } else {
            string = ac.valueOf("P" + this.Em.getPais()).getNome();
            imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.Em.getPais() + ".png"));
        }
        this.uu.setText(string);
        this.uu.setIcon(imageIcon);
        this.uK.clear();
        this.uK.addAll(this.Em.kc());
        this.nE();
    }

    private void Ay() {
        aT aT2 = new aT(this.Kh);
        this.vn.setModel(aT2);
        int[] nArray = new int[]{40, 200, 200};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vn.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vn.getColumnModel().getColumn(0).setMaxWidth(40);
        this.vn.getColumnModel().getColumn(1).setMaxWidth(200);
        this.vn.getColumnModel().getColumn(2).setMaxWidth(200);
        this.vn.setAutoResizeMode(3);
        this.vn.setRowHeight(20);
        this.vn.setShowGrid(false);
        this.vn.setDefaultRenderer(ah.class, new aV(this.w));
        this.vn.setAutoCreateRowSorter(false);
        this.vn.getTableHeader().setReorderingAllowed(false);
        this.vn.setIntercellSpacing(new Dimension(0, 0));
        this.vn.setCellSelectionEnabled(false);
        this.vn.setSelectionMode(0);
        this.vn.setRowSelectionAllowed(true);
        this.vn.setSelectionBackground(Color.YELLOW);
        this.vn.setFillsViewportHeight(true);
        this.vn.setTableHeader(null);
        this.vn.getSelectionModel().addListSelectionListener(new gU(this));
    }

    private void nE() {
        U u2 = new U(this.uK);
        this.zj.setModel(u2);
        int[] nArray = new int[12];
        nArray[0] = 22;
        nArray[1] = 22;
        nArray[2] = 55;
        nArray[3] = 140;
        nArray[4] = 22;
        nArray[5] = 22;
        nArray[6] = 50;
        nArray[7] = 50;
        nArray[8] = 55;
        nArray[9] = 30;
        int[] nArray2 = nArray;
        int[] nArray3 = new int[19];
        nArray3[0] = 20;
        nArray3[1] = 15;
        nArray3[2] = 20;
        nArray3[3] = 130;
        nArray3[4] = 20;
        nArray3[5] = 22;
        nArray3[6] = 22;
        nArray3[7] = 22;
        nArray3[8] = 22;
        nArray3[9] = 22;
        nArray3[10] = 22;
        nArray3[11] = 22;
        nArray3[12] = 50;
        nArray3[13] = 50;
        nArray3[14] = 50;
        nArray3[15] = 20;
        nArray3[16] = 30;
        int[] nArray4 = nArray3;
        if (a.SR.isHabilidadeIndividual()) {
            nArray2 = nArray4;
            this.zj.getColumnModel().getColumn(18).setMinWidth(0);
            this.zj.getColumnModel().getColumn(18).setMaxWidth(0);
            this.zj.getColumnModel().getColumn(18).setWidth(0);
            this.zj.getColumnModel().getColumn(19).setMinWidth(0);
            this.zj.getColumnModel().getColumn(19).setMaxWidth(0);
            this.zj.getColumnModel().getColumn(19).setWidth(0);
        } else {
            try {
                this.zj.getColumnModel().getColumn(12).setMinWidth(0);
                this.zj.getColumnModel().getColumn(12).setMaxWidth(0);
                this.zj.getColumnModel().getColumn(12).setWidth(0);
                this.zj.getColumnModel().getColumn(13).setMinWidth(0);
                this.zj.getColumnModel().getColumn(13).setMaxWidth(0);
                this.zj.getColumnModel().getColumn(13).setWidth(0);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        int n2 = 0;
        while (n2 < nArray2.length) {
            this.zj.getColumnModel().getColumn(n2).setPreferredWidth(nArray2[n2]);
            ++n2;
        }
        this.zj.setAutoResizeMode(3);
        this.zj.setRowHeight(20);
        this.zj.setShowGrid(false);
        this.zj.setDefaultRenderer(F.class, new aO());
        this.zj.setAutoCreateRowSorter(false);
        this.zj.getTableHeader().setReorderingAllowed(false);
        this.zj.setIntercellSpacing(new Dimension(0, 0));
        this.zj.setCellSelectionEnabled(false);
        this.zj.setSelectionMode(0);
        this.zj.setRowSelectionAllowed(true);
        this.zj.setSelectionBackground(Color.YELLOW);
        this.zj.setFillsViewportHeight(true);
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.zj.getModel());
        this.zj.setRowSorter(tableRowSorter);
        tableRowSorter.setComparator(0, h.a.abe);
        tableRowSorter.setComparator(2, h.a.cL);
        tableRowSorter.setComparator(3, h.a.abk);
        tableRowSorter.setComparator(4, h.a.aba);
        if (!a.SR.isHabilidadeIndividual()) {
            tableRowSorter.setComparator(5, h.a.aaJ);
            tableRowSorter.setComparator(6, h.a.aaZ);
            tableRowSorter.setComparator(7, h.a.aaW);
            tableRowSorter.setComparator(9, h.a.abd);
            tableRowSorter.setComparator(10, h.a.VU);
        } else {
            tableRowSorter.setComparator(5, h.a.aaK);
            tableRowSorter.setComparator(6, h.a.aaM);
            tableRowSorter.setComparator(7, h.a.aaL);
            tableRowSorter.setComparator(8, h.a.aaN);
            tableRowSorter.setComparator(9, h.a.aaP);
            tableRowSorter.setComparator(10, h.a.aaO);
            tableRowSorter.setComparator(11, h.a.aaQ);
            tableRowSorter.setComparator(12, h.a.aaZ);
            tableRowSorter.setComparator(13, h.a.aaW);
            tableRowSorter.setComparator(15, h.a.abd);
            tableRowSorter.setComparator(16, h.a.VU);
        }
    }

    private void mJ() {
        this.Kl = new ButtonGroup();
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.Fs = new JLabel();
        this.wi = new JScrollPane();
        this.vn = new JTable();
        this.Ki = new JButton();
        this.Kj = new JButton();
        this.ve = new JToolBar();
        this.HR = new JButton();
        this.aeN = new JButton();
        this.HY = new JButton();
        this.ur = new JLabel();
        this.uu = new JLabel();
        this.ut = new JScrollPane();
        this.zj = new JTable();
        this.uh = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setPreferredSize(new Dimension(774, 724));
        this.vd.setBackground(new Color(44, 53, 49));
        this.ug.setBackground(new Color(255, 255, 255));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Convites para ser t\u00e9cnico de sele\u00e7\u00e3o");
        this.ug.setToolTipText("");
        this.Fs.setBackground(new Color(255, 255, 255));
        this.Fs.setFont(new Font("Tahoma", 1, 11));
        this.Fs.setForeground(new Color(255, 255, 204));
        this.Fs.setHorizontalAlignment(0);
        this.Fs.setText("tecnico nome");
        this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.wi.setViewportView(this.vn);
        this.Ki.setFont(new Font("Tahoma", 0, 12));
        this.Ki.setForeground(new Color(0, 102, 0));
        this.Ki.setText("Assumir sele\u00e7\u00e3o");
        this.Kj.setFont(new Font("Tahoma", 0, 12));
        this.Kj.setForeground(new Color(0, 102, 0));
        this.Kj.setText("Rejeitar todos");
        this.ve.setBackground(new Color(0, 51, 51));
        this.ve.setRollover(true);
        this.ve.setBorderPainted(false);
        this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
        this.HR.setBorderPainted(false);
        this.HR.setFocusable(false);
        this.HR.setHorizontalTextPosition(0);
        this.HR.setOpaque(false);
        this.HR.setVerticalTextPosition(3);
        this.ve.add(this.HR);
        this.aeN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tabel.png")));
        this.aeN.setBorderPainted(false);
        this.aeN.setFocusable(false);
        this.aeN.setHorizontalTextPosition(0);
        this.aeN.setOpaque(false);
        this.aeN.setVerticalTextPosition(3);
        this.ve.add(this.aeN);
        this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
        this.HY.setBorderPainted(false);
        this.HY.setFocusable(false);
        this.HY.setHorizontalTextPosition(0);
        this.HY.setMaximumSize(new Dimension(31, 31));
        this.HY.setOpaque(false);
        this.HY.setVerticalTextPosition(3);
        this.ve.add(this.HY);
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setText("Comvites recebidos:");
        this.ur.setToolTipText("");
        this.uu.setForeground(new Color(255, 255, 255));
        this.uu.setHorizontalAlignment(2);
        this.uu.setText("\"Sele\u00e7\u00e3o\"");
        this.uu.setToolTipText("");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(24, 24, 24).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ur, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.wi, -2, 424, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ve, -2, 234, -2).addComponent(this.uu, -2, 246, -2).addComponent(this.Kj, -2, 173, -2).addComponent(this.Ki, -2, 173, -2)).addGap(0, 1, Short.MAX_VALUE)))).addGroup(groupLayout.createSequentialGroup().addGap(226, 226, 226).addComponent(this.Fs, -2, 261, -2).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Fs).addGap(40, 40, 40).addComponent(this.ur).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(groupLayout.createSequentialGroup().addComponent(this.ve, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.uu).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Ki, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Kj, -2, 31, -2)).addComponent(this.wi, -2, 287, -2)).addContainerGap(22, Short.MAX_VALUE)));
        this.zj.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.ut.setViewportView(this.zj);
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText("\u00daltima convoca\u00e7\u00e3o:");
        this.uh.setToolTipText("");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.vd, -2, -1, -2).addGap(29, 29, 29)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uh, -2, 729, -2).addComponent(this.ut, -2, 719, -2)).addGap(20, 20, 20)))));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(21, 21, 21).addComponent(this.vd, -2, -1, -2).addGap(18, 18, 18).addComponent(this.uh).addGap(18, 18, 18).addComponent(this.ut, -2, 206, -2).addContainerGap(24, Short.MAX_VALUE)));
    }

    static /* synthetic */ void a(gO gO2) {
        gO2.rT();
    }

    static /* synthetic */ JDialog b(gO gO2) {
        return gO2.ub;
    }

    static /* synthetic */ void c(gO gO2) {
        gO2.sD();
    }

    static /* synthetic */ void d(gO gO2) {
        gO2.AA();
    }

    static /* synthetic */ void e(gO gO2) {
        gO2.qP();
    }

    static /* synthetic */ JTable f(gO gO2) {
        return gO2.vn;
    }

    static /* synthetic */ ArrayList g(gO gO2) {
        return gO2.Kh;
    }

    static /* synthetic */ void a(gO gO2, ah ah2) {
        gO2.Em = ah2;
    }

    static /* synthetic */ void h(gO gO2) {
        gO2.rW();
    }
}

