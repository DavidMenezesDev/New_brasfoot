/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import a.eg;
import a.gF;
import a.gG;
import a.gH;
import a.gI;
import a.gJ;
import a.gK;
import a.gL;
import a.gM;
import a.hw;
import b.aT;
import b.aV;
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
import java.awt.Insets;
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

public class gE
extends JPanel {
    private JDialog ub = null;
    private al Es = null;
    private ah Em = null;
    private ArrayList aeL = new ArrayList();
    private int w = 0;
    private JButton HR;
    private JButton aeM;
    private JButton Kj;
    private JButton HY;
    private JButton aeN;
    private JButton uZ;
    private JButton Ib;
    private ButtonGroup Kl;
    private JLabel ug;
    private JPanel vd;
    private JScrollPane zf;
    private JToolBar ve;
    private JToolBar Iv;
    private JLabel zh;
    private JLabel uu;
    private JLabel zP;
    private JTable vn;

    public gE(JDialog jDialog, al al2) {
        this.ub = jDialog;
        this.Es = al2;
        this.mJ();
        this.zP.setText("");
        this.zh.setText("");
        this.mH();
        this.mG();
        this.fu(0);
    }

    private ArrayList Ax() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.w == 0) {
            arrayList.addAll(a.afQ.Ap());
            if (arrayList.size() == 0) {
                a.afQ.zj();
                arrayList.addAll(a.afQ.Ap());
            }
        } else {
            arrayList.addAll(a.afQ.Aq());
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        ArrayList<ah> arrayList6 = new ArrayList<ah>();
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (((ah)arrayList.get(n2)).getReputacao() == 1) {
                arrayList3.add((ah)arrayList.get(n2));
            } else if (((ah)arrayList.get(n2)).getReputacao() == 2) {
                arrayList4.add((ah)arrayList.get(n2));
            } else if (((ah)arrayList.get(n2)).getReputacao() == 3) {
                arrayList5.add((ah)arrayList.get(n2));
            } else if (((ah)arrayList.get(n2)).getReputacao() == 4) {
                arrayList6.add((ah)arrayList.get(n2));
            } else if (((ah)arrayList.get(n2)).getReputacao() == 5) {
                arrayList7.add((ah)arrayList.get(n2));
            }
            ++n2;
        }
        if (this.w == 0) {
            if (this.Es.getReputacao() == 5) {
                this.a(arrayList2, arrayList7, 1);
                this.a(arrayList2, arrayList6, 1);
                this.a(arrayList2, arrayList5, 2);
                this.a(arrayList2, arrayList4, 1);
                this.a(arrayList2, arrayList3, 1);
            } else if (this.Es.getReputacao() == 4) {
                this.a(arrayList2, arrayList6, 1);
                this.a(arrayList2, arrayList5, 1);
                this.a(arrayList2, arrayList4, 2);
                this.a(arrayList2, arrayList3, 1);
            } else if (this.Es.getReputacao() == 3) {
                this.a(arrayList2, arrayList5, 1);
                this.a(arrayList2, arrayList4, 2);
                this.a(arrayList2, arrayList3, 1);
            } else if (this.Es.getReputacao() == 2) {
                this.a(arrayList2, arrayList5, 2);
                this.a(arrayList2, arrayList4, 2);
                this.a(arrayList2, arrayList3, 1);
            } else {
                this.a(arrayList2, arrayList4, 2);
                this.a(arrayList2, arrayList3, 2);
            }
        } else if (this.Es.getReputacao() == 5) {
            this.a(arrayList2, arrayList7, 1);
            this.a(arrayList2, arrayList6, 2);
            this.a(arrayList2, arrayList5, 3);
            this.a(arrayList2, arrayList4, 3);
            this.a(arrayList2, arrayList3, 3);
        } else if (this.Es.getReputacao() == 4) {
            this.a(arrayList2, arrayList6, 2);
            this.a(arrayList2, arrayList5, 2);
            this.a(arrayList2, arrayList4, 3);
            this.a(arrayList2, arrayList3, 3);
        } else if (this.Es.getReputacao() == 3) {
            this.a(arrayList2, arrayList5, 2);
            this.a(arrayList2, arrayList4, 3);
            this.a(arrayList2, arrayList3, 3);
        } else if (this.Es.getReputacao() == 2) {
            this.a(arrayList2, arrayList5, 2);
            this.a(arrayList2, arrayList4, 3);
            this.a(arrayList2, arrayList3, 3);
        } else {
            this.a(arrayList2, arrayList4, 3);
            this.a(arrayList2, arrayList3, 3);
        }
        return arrayList2;
    }

    public void a(ArrayList arrayList, ArrayList arrayList2, int n2) {
        int[] nArray = new int[6];
        nArray[1] = 1;
        nArray[2] = 2;
        nArray[3] = 3;
        nArray[4] = 4;
        nArray[5] = 5;
        int[] nArray2 = nArray;
        int n3 = n2;
        if (this.w == 1) {
            int n4 = 0;
            while (n4 < nArray2.length) {
                n3 = n2;
                int n5 = 0;
                while (n5 < arrayList2.size()) {
                    if (nArray2[n4] == ((ah)arrayList2.get(n5)).gg() && !arrayList.contains(arrayList2.get(n5))) {
                        arrayList.add((ah)arrayList2.get(n5));
                        --n3;
                    }
                    if (n3 <= 0) break;
                    ++n5;
                }
                ++n4;
            }
        } else {
            int n6 = 0;
            while (n6 < a.SR.N().size()) {
                int n7 = ((Z)a.SR.N().get(n6)).eb().size();
                int n8 = ((Z)a.SR.N().get(n6)).jc();
                int n9 = 0;
                while (n9 < n7) {
                    int n10 = 0;
                    while (n10 < arrayList2.size()) {
                        if (((ah)arrayList2.get(n10)).getPais() == n8 && ((ah)arrayList2.get(n10)).getDivisao() == n9 + 1) {
                            arrayList.add((ah)arrayList2.get(n10));
                        }
                        ++n10;
                    }
                    ++n9;
                }
                ++n6;
            }
        }
    }

    private void Ay() {
        aT aT2 = new aT(this.aeL);
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
        this.vn.setIntercellSpacing(new Dimension(0, 0));
        this.vn.setCellSelectionEnabled(false);
        this.vn.setSelectionMode(0);
        this.vn.setRowSelectionAllowed(true);
        this.vn.setSelectionBackground(Color.YELLOW);
        this.vn.setFillsViewportHeight(true);
        this.vn.setTableHeader(null);
        this.vn.getSelectionModel().addListSelectionListener(new gF(this));
    }

    private void rW() {
        String string = "";
        ImageIcon imageIcon = null;
        if (this.Em != null) {
            if (this.w == 0) {
                string = this.Em.getNome();
                imageIcon = this.Em.kU();
            } else {
                string = ac.valueOf("P" + this.Em.getPais()).getNome();
                imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.Em.getPais() + ".png"));
            }
        }
        this.zP.setText(string);
        this.zP.setIcon(imageIcon);
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void Az() {
        if (this.Em != null) {
            if (this.w == 0) {
                if (this.Es.fg() != null) {
                    this.Es.fg().kE();
                }
                a.SR.a(this.Em, this.Em.ka(), this.Es);
                eg.aQ(true);
                this.ub.dispose();
                a.SR.g(true);
                a.SR.ap();
            } else {
                Z z2 = a.SR.s(this.Em.getPais());
                if (z2 != null && this.Es != null) {
                    z2.g(this.Es);
                    eg.aR(true);
                    eg.aQ(true);
                    this.ub.dispose();
                } else {
                    this.ub.dispose();
                }
            }
        }
    }

    public void mH() {
        this.aeM.addActionListener(new gG(this));
        this.Kj.addActionListener(new gH(this));
        this.HR.addActionListener(new gI(this));
        this.aeN.addActionListener(new gJ(this));
        this.HY.addActionListener(new gK(this));
        this.Ib.addActionListener(new gL(this));
        this.uZ.addActionListener(new gM(this));
    }

    private void ft(int n2) {
        this.fu(n2);
    }

    private void fu(int n2) {
        this.Em = null;
        this.w = n2;
        this.aeL.clear();
        this.aeL.addAll(this.Ax());
        this.Ay();
        if (this.aeL.size() > 0) {
            this.vn.setRowSelectionInterval(0, 0);
        }
        if (n2 == 0) {
            this.a(this.Ib, this.uZ);
            this.aeM.setText("Assumir time");
        } else {
            this.a(this.uZ, this.Ib);
            this.aeM.setText("Assumir Sele\u00e7\u00e3o");
        }
        this.rW();
    }

    private void a(JButton jButton, JButton jButton2) {
        jButton.setFont(new Font("Tahoma", 1, 14));
        jButton.setForeground(new Color(255, 255, 153));
        jButton2.setFont(new Font("Tahoma", 0, 12));
        jButton2.setForeground(new Color(255, 255, 255));
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

    private void AA() {
        this.aeN.setCursor(new Cursor(3));
        S.a(0, null);
        this.aeN.setCursor(new Cursor(12));
    }

    private void mJ() {
        this.Kl = new ButtonGroup();
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.Kj = new JButton();
        this.ve = new JToolBar();
        this.HR = new JButton();
        this.HY = new JButton();
        this.aeN = new JButton();
        this.uu = new JLabel();
        this.zf = new JScrollPane();
        this.vn = new JTable();
        this.aeM = new JButton();
        this.Iv = new JToolBar();
        this.Ib = new JButton();
        this.uZ = new JButton();
        this.zh = new JLabel();
        this.zP = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.vd.setBackground(new Color(44, 53, 49));
        this.ug.setBackground(new Color(255, 255, 255));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Central de Empregos");
        this.ug.setToolTipText("");
        this.Kj.setFont(new Font("Tahoma", 0, 12));
        this.Kj.setForeground(new Color(0, 102, 0));
        this.Kj.setText("X");
        this.ve.setBackground(new Color(0, 51, 51));
        this.ve.setRollover(true);
        this.ve.setBorderPainted(false);
        this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
        this.HR.setBorderPainted(false);
        this.HR.setFocusable(false);
        this.HR.setHorizontalTextPosition(0);
        this.HR.setMargin(new Insets(2, 2, 2, 7));
        this.HR.setOpaque(false);
        this.HR.setVerticalTextPosition(3);
        this.ve.add(this.HR);
        this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
        this.HY.setBorderPainted(false);
        this.HY.setFocusable(false);
        this.HY.setHorizontalTextPosition(0);
        this.HY.setMargin(new Insets(2, 0, 2, 7));
        this.HY.setMaximumSize(new Dimension(31, 31));
        this.HY.setOpaque(false);
        this.HY.setVerticalTextPosition(3);
        this.ve.add(this.HY);
        this.aeN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tabel.png")));
        this.aeN.setBorderPainted(false);
        this.aeN.setFocusable(false);
        this.aeN.setHorizontalTextPosition(0);
        this.aeN.setMargin(new Insets(2, 16, 2, 14));
        this.aeN.setMaximumSize(new Dimension(31, 31));
        this.aeN.setOpaque(false);
        this.aeN.setVerticalTextPosition(3);
        this.ve.add(this.aeN);
        this.uu.setForeground(new Color(255, 255, 255));
        this.uu.setHorizontalAlignment(0);
        this.uu.setText("(Voc\u00ea pode se candidatar a assumir times ou sele\u00e7\u00f5es da lista que buscam novos t\u00e9cnicos)");
        this.uu.setToolTipText("");
        this.zf.setViewportView(this.vn);
        this.aeM.setFont(new Font("Tahoma", 1, 12));
        this.aeM.setForeground(new Color(0, 51, 0));
        this.aeM.setText("Assumir sele\u00e7\u00e3o");
        this.Iv.setBackground(new Color(35, 28, 14));
        this.Iv.setFloatable(false);
        this.Iv.setRollover(true);
        this.Iv.setBorderPainted(false);
        this.Ib.setFont(new Font("Tahoma", 1, 14));
        this.Ib.setForeground(new Color(255, 255, 153));
        this.Ib.setText("Times");
        this.Ib.setBorderPainted(false);
        this.Ib.setContentAreaFilled(false);
        this.Ib.setFocusable(false);
        this.Ib.setHorizontalTextPosition(0);
        this.Ib.setMargin(new Insets(0, 0, 0, 0));
        this.Ib.setMaximumSize(new Dimension(79, 45));
        this.Ib.setMinimumSize(new Dimension(79, 45));
        this.Ib.setPreferredSize(new Dimension(79, 45));
        this.Ib.setVerticalTextPosition(3);
        this.Iv.add(this.Ib);
        this.uZ.setFont(new Font("Tahoma", 0, 12));
        this.uZ.setForeground(new Color(255, 255, 255));
        this.uZ.setText("Sele\u00e7\u00f5es");
        this.uZ.setBorderPainted(false);
        this.uZ.setContentAreaFilled(false);
        this.uZ.setFocusable(false);
        this.uZ.setHorizontalTextPosition(0);
        this.uZ.setMargin(new Insets(0, 0, 0, 0));
        this.uZ.setMaximumSize(new Dimension(79, 45));
        this.uZ.setMinimumSize(new Dimension(79, 45));
        this.uZ.setPreferredSize(new Dimension(79, 45));
        this.uZ.setVerticalTextPosition(3);
        this.Iv.add(this.uZ);
        this.zh.setForeground(new Color(255, 255, 255));
        this.zh.setText("\"Sele\u00e7\u00e3o\"");
        this.zh.setToolTipText("");
        this.zP.setForeground(new Color(255, 255, 255));
        this.zP.setText("\"Sele\u00e7\u00e3o\"");
        this.zP.setToolTipText("");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ug, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.uu, -2, 593, -2).addGap(0, 0, Short.MAX_VALUE))).addGap(18, 18, 18).addComponent(this.Kj, -2, 47, -2).addGap(11, 11, 11)).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zh, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.Iv, -2, 437, -2).addGap(0, 0, Short.MAX_VALUE)))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.aeM, -2, 173, -2).addComponent(this.zP, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE).addComponent(this.ve, GroupLayout.Alignment.TRAILING, -1, 216, Short.MAX_VALUE)))).addContainerGap()).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.zf, -2, 435, -2).addContainerGap(234, Short.MAX_VALUE))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.Kj, -2, 31, -2)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uu))).addGap(14, 14, 14).addComponent(this.Iv, -2, 33, -2).addGap(12, 12, 12).addComponent(this.ve, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE).addComponent(this.zP).addGap(22, 22, 22).addComponent(this.aeM, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.zh).addContainerGap()).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(107, Short.MAX_VALUE).addComponent(this.zf, -2, 500, -2).addGap(34, 34, 34))));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, 679, Short.MAX_VALUE).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, -1, -2).addContainerGap(14, Short.MAX_VALUE)));
    }

    static /* synthetic */ JTable a(gE gE2) {
        return gE2.vn;
    }

    static /* synthetic */ ArrayList b(gE gE2) {
        return gE2.aeL;
    }

    static /* synthetic */ void a(gE gE2, ah ah2) {
        gE2.Em = ah2;
    }

    static /* synthetic */ void c(gE gE2) {
        gE2.rW();
    }

    static /* synthetic */ void d(gE gE2) {
        gE2.Az();
    }

    static /* synthetic */ JDialog e(gE gE2) {
        return gE2.ub;
    }

    static /* synthetic */ ah f(gE gE2) {
        return gE2.Em;
    }

    static /* synthetic */ void g(gE gE2) {
        gE2.sD();
    }

    static /* synthetic */ void h(gE gE2) {
        gE2.AA();
    }

    static /* synthetic */ void i(gE gE2) {
        gE2.qP();
    }

    static /* synthetic */ void a(gE gE2, int n2) {
        gE2.ft(n2);
    }
}

