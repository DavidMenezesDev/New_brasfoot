/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ab;
import a.ac;
import a.ad;
import a.ae;
import a.af;
import a.ag;
import a.ah;
import a.ai;
import a.aj;
import a.ak;
import b.l;
import b.m;
import b.n;
import best.D;
import best.G;
import best.I;
import best.aq;
import best.at;
import c.a;
import components.b;
import components.d;
import components.e;
import components.w;
import f.B;
import f.o;
import f.s;
import f.z;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.prefs.Preferences;
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
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class aa
extends JPanel {
    private static final long serialVersionUID = 1L;
    private JDialog ub;
    private ArrayList cS = new ArrayList();
    private ArrayList vS = new ArrayList();
    private ArrayList vT = new ArrayList();
    private ArrayList vU = new ArrayList();
    private ArrayList vV = new ArrayList();
    private s vW = null;
    private at vX = null;
    private z vY = null;
    private ImageIcon uL = new ImageIcon(this.getClass().getResource("/aiconsb/b0.png"));
    private ImageIcon uM = new ImageIcon(this.getClass().getResource("/aiconsb/b1.png"));
    private ImageIcon uN = new ImageIcon(this.getClass().getResource("/aiconsb/b2.png"));
    private ImageIcon uO = new ImageIcon(this.getClass().getResource("/aiconsb/b3.png"));
    private ImageIcon uQ = new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png"));
    private ImageIcon uR = new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png"));
    private ImageIcon uS = new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png"));
    private ImageIcon uT = new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png"));
    private int vZ = -1;
    private int wa = -1;
    private at wb = null;
    private String wc = "";
    private int wd = 0;
    private JButton uW;
    private JButton vm;
    private JButton uX;
    private JButton uY;
    private JButton uZ;
    private JComboBox va;
    private JPanel vd;
    private JPanel we;
    private JPanel wf;
    private JPanel wg;
    private JPanel wh;
    private JScrollPane ut;
    private JScrollPane wi;
    private JToolBar ve;
    private JLabel wj;
    private JLabel wk;
    private JLabel wl;
    private JLabel wm;
    private JLabel wn;
    private JLabel wo;
    private JLabel vf;
    private JTable wp;
    private JTable vN;

    public void t(at at2) {
        this.vS.clear();
        this.vV.clear();
        this.vX = at2;
    }

    public void a(String string, Long l2) {
        Preferences preferences = Preferences.userRoot();
        Preferences preferences2 = preferences.node("systemacxyz22");
        String string2 = D.eW();
        preferences2.put("n", string2);
        preferences2.putInt("nr", this.b(D.eX(), string2));
    }

    public static int G(int n2, int n3) {
        String string = String.valueOf(n2);
        if (string.charAt(0) == '-') {
            ++n3;
        }
        return Character.getNumericValue(string.charAt(n3 - 1));
    }

    private void cF(int n2) {
        int n3;
        this.wi.setVisible(false);
        this.wg.setVisible(false);
        this.wj.setVisible(false);
        this.wl.setVisible(false);
        this.wo.setVisible(false);
        if (this.vY == null && this.vW != null && this.vW.yX() > 0) {
            this.vY = this.vW.yY();
            if (this.vY == null) {
                n3 = 0;
                n3 = this.vW.yQ().size() > 0 ? this.vW.yX() * this.vW.yQ().size() : this.vW.yX();
                this.vY = new z(this.vW, n3, this.vW.b(), 0, this.vW.getDuasVoltasMataMata(), this.vX, -1);
            }
        }
        if ((n2 > -1 || this.vW == null) && n2 >= 0 && this.vY != null && n2 <= this.vY.zq()) {
            this.vT.clear();
            n3 = this.vY.zq();
            int n4 = this.vY.zb();
            boolean bl2 = false;
            if (n3 == 0) {
                bl2 = true;
            }
            this.wa = n2 == -1 ? n4 : n2;
            int n5 = aq.ps.length - 1 - n3;
            int n6 = n5 + this.wa;
            int n7 = 1;
            String string = aq.pu[n6];
            if (bl2) {
                string = aq.pu[0];
            }
            if (this.wa < this.vY.zp().size()) {
                this.y(string);
            } else {
                int[] nArray = new int[]{64, 32, 16, 8, 4, 2, 1};
                String string2 = n6 >= 1 ? "vencedor " + aq.pu[n6 - 1] : "vencedor ";
                int n8 = 0;
                while (n8 < nArray[n6]) {
                    d d2 = new d();
                    d2.ai(true);
                    d2.aj(true);
                    this.vT.add(d2);
                    d d3 = new d();
                    d3.ah(true);
                    d3.E(String.valueOf(string) + Integer.toString(n8 + 1));
                    d3.aj(true);
                    d3.E(String.valueOf(string) + Integer.toString(n8 + 1));
                    this.vT.add(d3);
                    d d4 = new d();
                    d4.F(String.valueOf(string2) + n7);
                    d4.G(String.valueOf(string2) + (n7 + 1));
                    d4.aj(true);
                    this.vT.add(d4);
                    boolean[] blArray = this.vY.zz();
                    if (blArray[n6]) {
                        d3.H(String.valueOf(string2) + (n7 + 1));
                        d3.I(String.valueOf(string2) + n7);
                        d4.H(String.valueOf(string2) + (n7 + 1));
                        d4.I(String.valueOf(string2) + n7);
                    }
                    n7 += 2;
                    ++n8;
                }
            }
            if (bl2) {
                this.wm.setText(aq.ps[0]);
            } else {
                this.wm.setText(aq.ps[n5 + this.wa]);
            }
            this.nd();
        }
    }

    private int b(int n2, String string) {
        char c2 = string.charAt(0);
        int n3 = c2 * 31348;
        return n2 - n3;
    }

    public aa() {
        this.a("", 0L);
    }

    private void y(String string) {
        int n2 = 0;
        while (n2 < ((f.G)this.vY.zp().get(this.wa)).zW().size()) {
            d d2 = new d();
            d2.ai(true);
            this.vT.add(d2);
            d d3 = new d();
            d3.l((I)((f.G)this.vY.zp().get(this.wa)).zW().get(n2));
            d3.ah(true);
            d3.E(String.valueOf(string) + Integer.toString(n2 + 1));
            this.vT.add(d3);
            d d4 = new d();
            d4.l((I)((f.G)this.vY.zp().get(this.wa)).zW().get(n2));
            this.vT.add(d4);
            if (((f.G)this.vY.zp().get(this.wa)).hO()) {
                d3.m((I)((f.G)this.vY.zp().get(this.wa)).zX().get(n2));
                d4.m((I)((f.G)this.vY.zp().get(this.wa)).zX().get(n2));
            }
            ++n2;
        }
    }

    private void h(s s2) {
        Object object;
        Object object2;
        int[] nArray = new int[8];
        int[] nArray2 = new int[8];
        String string = "";
        int n2 = -1;
        if (s2.b() == 1 && s2.getDivisao() > 1) {
            n2 = ((B)s2.iq().eb().get(s2.getDivisao() - 2)).yi().getnRebaixados();
        } else if (s2.b() == 3 && s2.getDivisao() > 1) {
            n2 = ((o)s2.ir().eb().get(s2.getDivisao() - 2)).yi().getnRebaixados();
        }
        if (s2.yQ().size() == 0) {
            e e2 = new e();
            e2.setInfo("topo");
            this.vS.add(e2);
            object2 = new ArrayList();
            object2 = s2.yK();
            int n3 = 0;
            while (n3 < ((ArrayList)object2).size()) {
                object = new e();
                ((e)object).n((best.ah)((ArrayList)object2).get(n3));
                nArray = ((best.ah)((ArrayList)object2).get(n3)).d(s2);
                ((e)object).l(nArray);
                if (n3 == 0) {
                    string = "1\u00ba";
                } else if (n3 > 0) {
                    nArray2 = ((best.ah)((ArrayList)object2).get(n3 - 1)).d(s2);
                    string = nArray[0] != nArray2[0] || nArray[2] != nArray2[2] || nArray[5] != nArray2[5] || nArray[7] != nArray2[7] ? String.valueOf(Integer.toString(n3 + 1)) + "\u00ba" : "";
                }
                if (s2.yX() > 0) {
                    if (n3 < s2.yX()) {
                        ((e)object).dF(1);
                    }
                } else if (n2 > 0 && n3 < n2) {
                    ((e)object).dF(1);
                }
                if (n3 >= ((ArrayList)object2).size() - s2.getnRebaixados()) {
                    ((e)object).dF(3);
                }
                ((e)object).J(string);
                this.vS.add(object);
                ++n3;
            }
        } else {
            int n4 = 0;
            while (n4 < s2.yQ().size()) {
                if (n4 > 0) {
                    object2 = new e();
                    ((e)object2).setInfo("");
                    ((e)object2).ak(true);
                    this.vS.add(object2);
                }
                object2 = new e();
                ((e)object2).setInfo("Grupo " + Integer.toString(n4 + 1));
                ((e)object2).ak(true);
                this.vS.add(object2);
                e e3 = new e();
                e3.setInfo("topo");
                this.vS.add(e3);
                object = new ArrayList();
                object = ((G)s2.yQ().get(n4)).gR();
                int n5 = 0;
                while (n5 < ((ArrayList)object).size()) {
                    e e4 = new e();
                    e4.n((best.ah)((ArrayList)object).get(n5));
                    nArray = ((best.ah)((ArrayList)object).get(n5)).d(s2);
                    e4.l(nArray);
                    if (n5 == 0) {
                        string = "1\u00ba";
                    } else if (n5 > 0) {
                        nArray2 = ((best.ah)((ArrayList)object).get(n5 - 1)).d(s2);
                        string = nArray[0] != nArray2[0] || nArray[2] != nArray2[2] || nArray[5] != nArray2[5] || nArray[7] != nArray2[7] ? String.valueOf(Integer.toString(n5 + 1)) + "\u00ba" : "";
                    }
                    e4.J(string);
                    if (n5 < s2.yX()) {
                        e4.dF(1);
                    }
                    int n6 = 0;
                    if (s2.zc() && s2.yQ().size() > 0) {
                        n6 = Math.round(s2.getnRebaixados() / s2.yQ().size());
                        if (n5 >= ((ArrayList)object).size() - n6) {
                            e4.dF(3);
                        }
                    } else {
                        n6 = s2.getnRebaixados();
                        if (s2.R((best.ah)((ArrayList)object).get(n5)) >= s2.yK().size() - n6) {
                            e4.dF(3);
                        }
                    }
                    this.vS.add(e4);
                    ++n5;
                }
                ++n4;
            }
        }
        this.wk.setVisible(true);
        this.wn.setVisible(true);
        this.wm.setVisible(true);
        this.wm.setText("1\u00aa fase");
        if (this.vW.yX() == 0) {
            this.wk.setVisible(false);
            this.wn.setVisible(false);
            this.wm.setVisible(false);
        }
        int n7 = 0;
        while (n7 < a.SR.R().size()) {
            int n8 = 0;
            while (n8 < ((best.a)a.SR.R().get(n7)).t().size()) {
                if (((best.a)a.SR.R().get(n7)).t().get(n8) == this.vX) {
                    this.vV.add((best.a)a.SR.R().get(n7));
                    break;
                }
                ++n8;
            }
            ++n7;
        }
        this.cG(this.vZ);
    }

    private void cG(int n2) {
        if (n2 == -1) {
            n2 = this.vW.zb() - 1;
        }
        boolean bl2 = false;
        if (this.vW.yZ()) {
            bl2 = true;
        }
        this.vZ = n2;
        if (!bl2) {
            this.wa = -1;
            this.vU.clear();
            this.vV.size();
            this.wo.setText(String.valueOf(n2 + 1) + "\u00aa rodada");
            this.wj.setVisible(true);
            this.wl.setVisible(true);
            if (n2 == 0) {
                this.wj.setVisible(false);
            } else if (n2 == this.vW.yG() - 1) {
                this.wl.setVisible(false);
            }
            this.vN.addNotify();
        } else {
            this.cF(this.wa);
        }
    }

    private void nc() {
        m m2 = new m(this.vS);
        this.wp.setModel(m2);
        this.wp.setTableHeader(null);
        int[] nArray = new int[]{20, 5, 140, 20, 20, 20, 20, 20, 20, 20, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.wp.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.wp.getColumnModel().getColumn(0).setMaxWidth(20);
        this.wp.getColumnModel().getColumn(1).setMaxWidth(5);
        this.wp.setAutoResizeMode(3);
        this.wp.setRowHeight(24);
        this.wp.setShowGrid(false);
        this.wp.setDefaultRenderer(e.class, new b.a());
        this.wp.setAutoCreateRowSorter(false);
        this.wp.setIntercellSpacing(new Dimension(0, 0));
        this.wp.setCellSelectionEnabled(false);
        this.wp.setRowSelectionAllowed(false);
        this.wp.setFillsViewportHeight(true);
    }

    private void nd() {
        n n2 = new n(this.vT);
        this.wp.setModel(n2);
        this.wp.setTableHeader(null);
        int[] nArray = new int[]{90, 40, 90, 100, 90, 40, 90};
        int n3 = 0;
        while (n3 < nArray.length) {
            this.wp.getColumnModel().getColumn(n3).setPreferredWidth(nArray[n3]);
            ++n3;
        }
        this.wp.setRowHeight(24);
        this.wp.setShowGrid(false);
        this.wp.setDefaultRenderer(d.class, new b.b());
        this.wp.setAutoCreateRowSorter(false);
        this.wp.setIntercellSpacing(new Dimension(0, 0));
        this.wp.setCellSelectionEnabled(false);
        this.wp.setRowSelectionAllowed(false);
        this.wp.setFillsViewportHeight(true);
    }

    private void ne() {
        l l2 = new l(this.vU);
        this.vN.setModel(l2);
        this.vN.setTableHeader(null);
        int[] nArray = new int[]{90, 40, 90};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vN.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vN.setRowHeight(20);
        this.vN.setShowGrid(false);
        this.vN.setDefaultRenderer(w.class, new b.af());
        this.vN.setAutoCreateRowSorter(false);
        this.vN.setIntercellSpacing(new Dimension(0, 0));
        this.vN.setCellSelectionEnabled(false);
        this.vN.setRowSelectionAllowed(false);
        this.vN.setFillsViewportHeight(true);
    }

    public void mH() {
        this.vm.addActionListener(new ab(this));
        this.wn.addMouseListener(new ad(this));
        this.wk.addMouseListener(new ae(this));
        this.wj.addMouseListener(new af(this));
        this.wl.addMouseListener(new ag(this));
    }

    private void cC(int n2) {
        this.vZ = -1;
        this.wa = 0;
        this.vY = null;
        this.wi.setVisible(true);
        this.wj.setVisible(true);
        this.wl.setVisible(true);
        this.wo.setVisible(true);
        this.nc();
        this.ne();
        if (this.cS.size() > 0) {
            this.t((at)this.va.getSelectedItem());
        }
    }

    private void mQ() {
        b.aj aj2 = new b.aj();
        this.va.setPreferredSize(new Dimension(10, 25));
        this.va.setRenderer(aj2);
        this.va.setMaximumRowCount(24);
        this.va.addActionListener(new ah(this));
    }

    private void mO() {
        if (!a.SR.isJogaEstadual()) {
            this.uW.setVisible(false);
        }
        if (!a.SR.isJogaSelecoesAll()) {
            this.uZ.setVisible(false);
        }
        if (!a.SR.isJogaIntClubes()) {
            this.uX.setVisible(false);
        }
    }

    private void mP() {
        this.uY.addActionListener(new ai(this));
        this.uX.addActionListener(new aj(this));
        this.uW.addActionListener(new ak(this));
        this.uZ.addActionListener(new ac(this));
    }

    private void cA(int n2) {
        JButton[] jButtonArray = new JButton[]{this.uY, this.uX, this.uW, this.uZ};
        ImageIcon[] imageIconArray = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO};
        ImageIcon[] imageIconArray2 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT};
        int n3 = 0;
        while (n3 < jButtonArray.length) {
            jButtonArray[n3].setIcon(imageIconArray[n3]);
            ++n3;
        }
        jButtonArray[n2].setIcon(imageIconArray2[n2]);
    }

    private void cB(int n2) {
        this.cA(n2);
        this.cS = at.a(n2, false, 0);
        this.va.removeAllItems();
        int n3 = 0;
        while (n3 < this.cS.size()) {
            this.va.addItem(this.cS.get(n3));
            ++n3;
        }
        this.va.setSelectedItem(this.wb);
    }

    private void mJ() {
        this.vf = new JLabel();
        this.vd = new JPanel();
        this.va = new JComboBox();
        this.ve = new JToolBar();
        this.uY = new JButton();
        this.uX = new JButton();
        this.uW = new JButton();
        this.uZ = new JButton();
        this.ut = new JScrollPane();
        this.wp = new JTable();
        this.wi = new JScrollPane();
        this.vN = new JTable();
        this.we = new JPanel();
        this.vm = new JButton();
        this.wf = new JPanel();
        this.wg = new JPanel();
        this.wj = new JLabel();
        this.wo = new JLabel();
        this.wl = new JLabel();
        this.wh = new JPanel();
        this.wm = new JLabel();
        this.wn = new JLabel();
        this.wk = new JLabel();
        this.setBackground(new Color(204, 204, 204));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.vf.setFont(new Font("Tahoma", 1, 12));
        this.vf.setText("Classifica\u00e7\u00e3o e jogos");
        this.vd.setBackground(new Color(255, 204, 51));
        this.vd.setPreferredSize(new Dimension(483, 40));
        this.vd.setLayout(new b());
        this.vd.add((Component)this.va, new components.a(420, 10, 290, 25));
        this.ve.setBackground(new Color(255, 205, 26));
        this.ve.setFloatable(false);
        this.ve.setRollover(true);
        this.ve.setBorderPainted(false);
        this.uY.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0.png")));
        this.uY.setBorderPainted(false);
        this.uY.setContentAreaFilled(false);
        this.uY.setFocusable(false);
        this.uY.setHorizontalTextPosition(0);
        this.uY.setMargin(new Insets(0, 0, 0, 0));
        this.uY.setMaximumSize(new Dimension(79, 45));
        this.uY.setMinimumSize(new Dimension(79, 45));
        this.uY.setPreferredSize(new Dimension(79, 45));
        this.uY.setPressedIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
        this.uY.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
        this.uY.setVerticalTextPosition(3);
        this.ve.add(this.uY);
        this.uX.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1.png")));
        this.uX.setBorderPainted(false);
        this.uX.setContentAreaFilled(false);
        this.uX.setFocusable(false);
        this.uX.setHorizontalTextPosition(0);
        this.uX.setMargin(new Insets(0, 0, 0, 0));
        this.uX.setMaximumSize(new Dimension(79, 45));
        this.uX.setMinimumSize(new Dimension(79, 45));
        this.uX.setPreferredSize(new Dimension(79, 45));
        this.uX.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png")));
        this.uX.setVerticalTextPosition(3);
        this.ve.add(this.uX);
        this.uW.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2.png")));
        this.uW.setBorderPainted(false);
        this.uW.setContentAreaFilled(false);
        this.uW.setFocusable(false);
        this.uW.setHorizontalTextPosition(0);
        this.uW.setMargin(new Insets(0, 0, 0, 0));
        this.uW.setMaximumSize(new Dimension(79, 45));
        this.uW.setMinimumSize(new Dimension(79, 45));
        this.uW.setPreferredSize(new Dimension(79, 45));
        this.uW.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png")));
        this.uW.setVerticalTextPosition(3);
        this.ve.add(this.uW);
        this.uZ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3.png")));
        this.uZ.setBorderPainted(false);
        this.uZ.setContentAreaFilled(false);
        this.uZ.setFocusable(false);
        this.uZ.setHorizontalTextPosition(0);
        this.uZ.setMargin(new Insets(0, 0, 0, 0));
        this.uZ.setMaximumSize(new Dimension(79, 45));
        this.uZ.setMinimumSize(new Dimension(79, 45));
        this.uZ.setPreferredSize(new Dimension(79, 45));
        this.uZ.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png")));
        this.uZ.setVerticalTextPosition(3);
        this.ve.add(this.uZ);
        this.vd.add((Component)this.ve, new components.a(0, 0, 340, 40));
        this.wp.setModel(new DefaultTableModel(new Object[][]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.ut.setViewportView(this.wp);
        this.vN.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.wi.setViewportView(this.vN);
        this.we.setOpaque(false);
        GroupLayout groupLayout = new GroupLayout(this.we);
        this.we.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 509, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        this.vm.setText("X");
        this.wf.setOpaque(false);
        GroupLayout groupLayout2 = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 9, Short.MAX_VALUE));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        this.wg.setOpaque(false);
        this.wj.setText("<<");
        this.wo.setFont(new Font("Tahoma", 0, 12));
        this.wo.setHorizontalAlignment(0);
        this.wo.setText("1\u00aa rodada");
        this.wo.setHorizontalTextPosition(0);
        this.wl.setText(">>");
        GroupLayout groupLayout3 = new GroupLayout(this.wg);
        this.wg.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(74, 74, 74).addComponent(this.wj).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.wo, -2, 111, -2).addGap(18, 18, 18).addComponent(this.wl).addContainerGap(-1, Short.MAX_VALUE)));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.wj).addComponent(this.wo).addComponent(this.wl)).addGap(0, 0, Short.MAX_VALUE)));
        this.wh.setOpaque(false);
        this.wm.setFont(new Font("Tahoma", 0, 12));
        this.wm.setHorizontalAlignment(0);
        this.wm.setText("Oitavas de final");
        this.wn.setFont(new Font("Tahoma", 0, 12));
        this.wn.setHorizontalAlignment(4);
        this.wn.setText("Pr\u00f3xima Fase>>");
        this.wk.setFont(new Font("Tahoma", 0, 12));
        this.wk.setHorizontalAlignment(2);
        this.wk.setText("<< Fase Anterior");
        GroupLayout groupLayout4 = new GroupLayout(this.wh);
        this.wh.setLayout(groupLayout4);
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addComponent(this.wk, -2, 101, -2).addGap(53, 53, 53).addComponent(this.wm, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE).addComponent(this.wn, -2, 105, -2)));
        groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.wm).addComponent(this.wn).addComponent(this.wk)));
        GroupLayout groupLayout5 = new GroupLayout(this);
        this.setLayout(groupLayout5);
        groupLayout5.setHorizontalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout5.createSequentialGroup().addComponent(this.vf, -2, 293, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE).addComponent(this.vm, -2, 52, -2)).addGroup(groupLayout5.createSequentialGroup().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addGap(2, 2, 2)).addGroup(groupLayout5.createSequentialGroup().addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addComponent(this.ut).addGap(6, 6, 6)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout5.createSequentialGroup().addComponent(this.wh, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wi, -2, 0, Short.MAX_VALUE).addGroup(groupLayout5.createSequentialGroup().addComponent(this.wg, -1, -1, Short.MAX_VALUE).addGap(2, 2, 2))))).addGap(8, 8, 8).addComponent(this.wf, -2, -1, -2)));
        groupLayout5.setVerticalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGap(11, 11, 11).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGap(3, 3, 3).addComponent(this.vf)).addComponent(this.vm)).addGap(11, 11, 11).addComponent(this.vd, -2, -1, -2).addGap(18, 18, 18).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.wg, -1, -1, Short.MAX_VALUE).addComponent(this.wh, -1, -1, Short.MAX_VALUE)).addGap(6, 6, 6).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wi, -1, 602, Short.MAX_VALUE).addComponent(this.ut)).addGap(16, 16, 16)).addComponent(this.wf, -1, -1, Short.MAX_VALUE))));
    }

    static /* synthetic */ JDialog a(aa aa2) {
        return aa2.ub;
    }

    static /* synthetic */ int b(aa aa2) {
        return aa2.wa;
    }

    static /* synthetic */ void a(aa aa2, int n2) {
        aa2.cF(n2);
    }

    static /* synthetic */ int c(aa aa2) {
        return aa2.vZ;
    }

    static /* synthetic */ void b(aa aa2, int n2) {
        aa2.cG(n2);
    }

    static /* synthetic */ JComboBox d(aa aa2) {
        return aa2.va;
    }

    static /* synthetic */ void c(aa aa2, int n2) {
        aa2.cC(n2);
    }

    static /* synthetic */ void d(aa aa2, int n2) {
        aa2.cB(n2);
    }
}

