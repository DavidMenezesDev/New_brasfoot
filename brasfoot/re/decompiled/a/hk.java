/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dV;
import a.dz;
import a.eg;
import a.hl;
import a.hm;
import a.hn;
import a.ho;
import a.hp;
import a.hq;
import a.hr;
import a.hs;
import a.ht;
import a.hu;
import a.hv;
import b.J;
import b.aD;
import b.ak;
import b.as;
import b.v;
import best.A;
import best.C;
import best.F;
import best.I;
import best.N;
import best.S;
import best.Z;
import best.ah;
import best.al;
import best.at;
import best.s;
import best.w;
import c.a;
import components.V;
import components.b;
import components.i;
import components.u;
import components.z;
import f.o;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

public class hk
extends JPanel {
    private JFrame Br;
    private ArrayList cP = new ArrayList();
    private ArrayList cQ = new ArrayList();
    private ArrayList KM = new ArrayList();
    private ArrayList KN = new ArrayList();
    private ArrayList vK = new ArrayList();
    private ArrayList KO = new ArrayList();
    private ArrayList KP = new ArrayList();
    private ArrayList KQ = new ArrayList();
    private int w;
    private Z KR = null;
    private I KS = null;
    private static int KT = 0;
    private static Timer Dk;
    private JPanel xb = null;
    private int xh = 0;
    private int xi = 0;
    private ArrayList KU = new ArrayList();
    private int KV = -1;
    private Color KW = new Color(211, 191, 22);
    private Color KX = new Color(228, 227, 227);
    private I KY = null;
    public static Comparator KZ;
    private JButton HS;
    private JButton La;
    private JButton zK;
    private JButton Lb;
    private JButton Lc;
    private JComboBox va;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JPanel vd;
    private JScrollPane ut;
    private JScrollPane wi;
    private JScrollPane zf;
    private JScrollPane zg;
    private JLabel Ld;
    private JLabel Le;
    private JLabel Lf;
    private JLabel Lg;
    private JLabel Fq;
    private JLabel yu;
    private JLabel Cg;
    private JLabel Lh;
    private JLabel Li;
    private JLabel Lj;
    private JLabel Lk;
    private JLabel Ll;
    private JLabel Lm;
    private JLabel Ln;
    private JLabel Lo;
    private JLabel Dy;
    private JLabel Dz;
    private JLabel Lp;
    private JLabel Lq;
    private JLabel zO;
    private JLabel zP;
    private JTable DG;
    private JTable Lr;
    private JTable Ls;

    static {
        KZ = new hl();
    }

    public void oR() {
        Dk = new Timer();
        Dk.schedule((TimerTask)new ho(this), 0L);
    }

    public hk(JFrame jFrame) {
        this.Br = jFrame;
        this.mJ();
        this.rY();
        this.rX();
        this.mH();
        this.rZ();
        this.ut.setBorder(BorderFactory.createEmptyBorder());
        this.zf.setBorder(BorderFactory.createEmptyBorder());
        this.zg.setBorder(BorderFactory.createEmptyBorder());
        this.mY();
        this.sd();
        if (a.SR.bD()) {
            this.oR();
        }
    }

    private void mY() {
        this.a(this);
        this.a(this.zK);
        this.a(this.wi);
        this.a(this.va);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("st", new hp(this));
    }

    private void b(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(38, 0), "upLinha");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("upLinha", new hq(this));
    }

    private void c(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(40, 0), "downLinha");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("downLinha", new hr(this));
    }

    private void nt() {
        this.KU.clear();
        this.xb = new JPanel(new b());
        this.xh = 0;
        this.xi = 0;
        this.a(this.xb);
        this.b(this.xb);
        this.c(this.xb);
    }

    private void a(u u2) {
        int n2 = 0;
        V v2 = new V(u2, this);
        this.xb.add((Component)v2, new components.a(0, this.xh, 295, 26));
        if (u2.tR() != null) {
            this.KU.add(v2);
        }
        this.xh = this.xh + 27 + n2;
    }

    public void on() {
        this.zK.requestFocusInWindow();
    }

    private void rX() {
        J j2 = new J(this.KP);
        this.Lr.setModel(j2);
        this.Lr.setTableHeader(null);
        int[] nArray = new int[]{180, 20, 25};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Lr.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Lr.setAutoResizeMode(3);
        this.Lr.setRowHeight(20);
        this.Lr.setShowGrid(false);
        this.Lr.setDefaultRenderer(i.class, new aD());
        this.Lr.setAutoCreateRowSorter(false);
        this.Lr.setCellSelectionEnabled(false);
        this.Lr.setRowSelectionAllowed(false);
        this.Lr.setBackground(this.getBackground());
        this.Lr.setFillsViewportHeight(true);
        J j3 = new J(this.KQ);
        this.Ls.setModel(j3);
        this.Ls.setTableHeader(null);
        int n3 = 0;
        while (n3 < nArray.length) {
            this.Ls.getColumnModel().getColumn(n3).setPreferredWidth(nArray[n3]);
            ++n3;
        }
        this.Ls.setAutoResizeMode(3);
        this.Ls.setRowHeight(20);
        this.Ls.setShowGrid(false);
        this.Ls.setDefaultRenderer(i.class, new aD());
        this.Ls.setAutoCreateRowSorter(false);
        this.Ls.setCellSelectionEnabled(false);
        this.Ls.setRowSelectionAllowed(false);
        this.Ls.setBackground(this.getBackground());
        this.Ls.setFillsViewportHeight(true);
    }

    private void rY() {
        v v2 = new v(this.KO);
        this.DG.setModel(v2);
        this.DG.setTableHeader(null);
        int[] nArray = new int[]{20, 180, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.DG.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.DG.setAutoResizeMode(3);
        this.DG.setRowHeight(20);
        this.DG.setShowGrid(false);
        this.DG.setDefaultRenderer(A.class, new as(true));
        this.DG.setAutoCreateRowSorter(false);
        this.DG.setCellSelectionEnabled(false);
        this.DG.setRowSelectionAllowed(false);
        this.DG.setBackground(this.getBackground());
        this.DG.setFillsViewportHeight(true);
    }

    private void nx() {
        this.zK.setCursor(new Cursor(3));
        if (a.SR.isUsaSons()) {
            dV.qb();
        }
        boolean bl2 = false;
        eg.aQ(false);
        if (a.SR.isVerLeiloes() && this.KS != null && (this.w == 1 || this.w == 3 || this.w == 10)) {
            ArrayList<N> arrayList = new ArrayList<N>();
            int n2 = new Random().nextInt(4);
            int n3 = 0;
            while (n3 < n2) {
                N n4 = new N();
                if (n4.iA() != null) {
                    arrayList.add(n4);
                }
                ++n3;
            }
            dz.X(arrayList);
            if (arrayList.size() > 0 && a.SR.cd()) {
                bl2 = true;
            }
        }
        if (bl2) {
            S.aY(8);
        } else {
            a.SR.ax();
        }
    }

    private void mH() {
        this.va.addActionListener(new hs(this));
        this.zK.addActionListener(new ht(this));
        this.HS.addActionListener(new hu(this));
        this.La.addActionListener(new hv(this));
        this.Lc.addActionListener(new hm(this));
        this.Lb.addActionListener(new hn(this));
    }

    private void qV() {
        at at2 = null;
        if (this.KY != null) {
            at2 = this.KY.hy();
        }
        this.HS.setCursor(new Cursor(3));
        S.a(this.w, at2);
        this.HS.setCursor(new Cursor(12));
    }

    public void rr() {
        ah ah2 = null;
        if (a.SR.aN().size() > 0) {
            ah2 = (ah)a.SR.aN().get(0);
        }
        if (ah2 != null && ah2.jZ().booleanValue()) {
            String string = ah2.ka().dS();
            int n2 = -1;
            n2 = JOptionPane.showConfirmDialog(this.Br, String.valueOf(string) + " deseja ser demitido do " + ah2.getNome(), "Pedido de demiss\u00e3o", 0);
            if (n2 == 0) {
                al al2 = ah2.ka();
                al al3 = ah2.kE();
                S.a(al2, al3, ah2, 0);
            }
        }
    }

    private void cC(int n2) {
        if (this.KN.size() > 0) {
            if (this.w == 1) {
                this.e((Z)this.KN.get(n2));
            }
        } else if (this.KM.size() > 0) {
            if (this.w == 3) {
                this.a((w)this.KM.get(n2));
            }
        } else if (this.cQ.size() > 0) {
            this.x((at)this.cQ.get(n2));
        }
        this.f(0, true);
    }

    private void rZ() {
        ak ak2 = new ak();
        this.va.setPreferredSize(new Dimension(10, 25));
        this.va.setRenderer(ak2);
        this.va.setMaximumRowCount(24);
        this.w = 0;
        this.cP.clear();
        this.cP.addAll(((best.a)a.SR.R().get(a.SR.J())).t());
        KT = 0;
        if (this.cP.size() > 0) {
            if (((at)this.cP.get(0)).b() == 1) {
                this.pB();
                KT = 1;
                this.w = 1;
            } else if (((at)this.cP.get(0)).b() == 3) {
                this.sb();
                this.w = 3;
            } else {
                this.w = ((at)this.cP.get(0)).b();
                this.sa();
            }
        }
    }

    private void sa() {
        int n2;
        this.cQ.clear();
        int n3 = 0;
        while (n3 < this.cP.size()) {
            this.va.addItem(this.cP.get(n3));
            this.cQ.add((at)this.cP.get(n3));
            ++n3;
        }
        n3 = 0;
        int n4 = s.dL();
        if (n4 >= 0 && n4 < this.cQ.size()) {
            n3 = n4;
        }
        if (this.w == 2) {
            n2 = 0;
            while (n2 < this.cQ.size()) {
                if (this.cQ.get(n2) == s.dN()) {
                    n3 = n2;
                    break;
                }
                ++n2;
            }
        }
        if (this.w == 4) {
            n2 = 0;
            while (n2 < this.cQ.size()) {
                if (((at)this.cQ.get(n2)).gg() == s.dL()) {
                    n3 = n2;
                    break;
                }
                ++n2;
            }
        }
        try {
            this.va.setSelectedIndex(n3);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.x((at)this.cQ.get(n3));
    }

    public void x(at at2) {
        this.nt();
        boolean bl2 = true;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < a.SR.S().size()) {
            if (((I)a.SR.S().get(n4)).hy() == at2) {
                u u2;
                n2 = -1;
                if (n2 != n3) {
                    bl2 = true;
                }
                if (bl2) {
                    u2 = new u();
                    u2.D(((I)a.SR.S().get(n4)).ij());
                    this.a(u2);
                    bl2 = false;
                    n3 = n2;
                }
                u2 = new u();
                u2.n((I)a.SR.S().get(n4));
                this.a(u2);
            }
            ++n4;
        }
        JViewport jViewport = this.wi.getViewport();
        jViewport.setView(this.xb);
    }

    private void sb() {
        int n2;
        this.KM.clear();
        int n3 = 0;
        while (n3 < a.SR.aE().size()) {
            n2 = 0;
            while (n2 < this.cP.size()) {
                if (((at)this.cP.get(n2)).ir() == a.SR.aE().get(n3) && !this.cQ.contains(a.SR.aE().get(n3))) {
                    this.va.addItem(a.SR.aE().get(n3));
                    this.KM.add((w)a.SR.aE().get(n3));
                }
                ++n2;
            }
            ++n3;
        }
        n3 = s.dL();
        n2 = this.KM.size() - 1;
        if (n3 >= 0) {
            int n4 = 0;
            while (n4 < this.KM.size()) {
                if (((w)this.KM.get(n4)).getEstado() == n3) {
                    n2 = n4;
                    break;
                }
                ++n4;
            }
        }
        this.va.setSelectedIndex(n2);
        this.a((w)this.KM.get(n2));
    }

    private void pB() {
        int n2;
        this.KN.clear();
        int n3 = 0;
        while (n3 < a.SR.N().size()) {
            n2 = 0;
            while (n2 < this.cP.size()) {
                if (((at)this.cP.get(n2)).iq() == a.SR.N().get(n3) && !this.KN.contains(a.SR.N().get(n3))) {
                    try {
                        this.va.addItem(a.SR.N().get(n3));
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    this.KN.add((Z)a.SR.N().get(n3));
                }
                ++n2;
            }
            ++n3;
        }
        n3 = s.dL();
        n2 = this.KN.size() - 1;
        if (n3 >= 0) {
            int n4 = 0;
            while (n4 < this.KN.size()) {
                if (((Z)this.KN.get(n4)).jc() == n3) {
                    n2 = n4;
                    this.KR = (Z)this.KN.get(n4);
                    break;
                }
                ++n4;
            }
        }
        try {
            this.va.setSelectedIndex(n2);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.e((Z)this.KN.get(n2));
    }

    public void a(w w2) {
        this.nt();
        boolean bl2 = true;
        int n2 = 0;
        int n3 = 0;
        ArrayList<I> arrayList = new ArrayList<I>();
        int n4 = 0;
        while (n4 < a.SR.S().size()) {
            if (((I)a.SR.S().get(n4)).hy() instanceof o && ((o)((I)a.SR.S().get(n4)).hy()).yj() == w2) {
                arrayList.add((I)a.SR.S().get(n4));
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < arrayList.size()) {
            u u2;
            n2 = ((I)arrayList.get(n4)).hy().ip();
            if (n2 != n3) {
                bl2 = true;
            }
            if (bl2) {
                u2 = new u();
                u2.D(((I)arrayList.get(n4)).ij());
                this.a(u2);
                bl2 = false;
                n3 = n2;
            }
            u2 = new u();
            u2.n((I)arrayList.get(n4));
            this.a(u2);
            ++n4;
        }
        JViewport jViewport = this.wi.getViewport();
        jViewport.setView(this.xb);
    }

    private int sc() {
        int n2 = 0;
        while (n2 < this.vK.size()) {
            if (((z)this.vK.get(n2)).tR() != null && (((z)this.vK.get(n2)).tR().hc().jZ().booleanValue() || ((z)this.vK.get(n2)).tR().hd().jZ().booleanValue())) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public void dz(int n2) {
        int n3 = 0;
        n3 = n2 == 0 ? this.KV + 1 : this.KV - 1;
        if (n3 < 0) {
            n3 = 0;
        }
        if (n3 >= this.KU.size()) {
            n3 = this.KU.size() - 1;
        }
        this.f(n3, true);
        this.se();
    }

    public void f(int n2, boolean bl2) {
        int n3 = n2;
        while (n3 < this.KU.size()) {
            if (((V)this.KU.get(n3)).tR() != null) {
                if (bl2) {
                    this.i(((V)this.KU.get(n3)).tR());
                }
                if (this.KV >= 0 && this.KV < this.KU.size()) {
                    ((V)this.KU.get(this.KV)).e(this.KX);
                }
                ((V)this.KU.get(n3)).e(this.KW);
                this.KV = n3;
                break;
            }
            ++n3;
        }
    }

    public void a(V v2, I i2) {
        this.xb.requestFocusInWindow();
        if (this.KV >= 0 && this.KV < this.KU.size()) {
            ((V)this.KU.get(this.KV)).e(this.KX);
        }
        int n2 = 0;
        while (n2 < this.KU.size()) {
            if (v2 == this.KU.get(n2)) {
                this.KV = n2;
                break;
            }
            ++n2;
        }
        if (i2 != null) {
            this.i(i2);
        }
        v2.e(this.KW);
    }

    public void e(Z z2) {
        this.nt();
        boolean bl2 = true;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < a.SR.S().size()) {
            if (((I)a.SR.S().get(n4)).hy().iq() == z2) {
                u u2;
                n2 = ((I)a.SR.S().get(n4)).hy().ip();
                if (n2 != n3) {
                    bl2 = true;
                }
                if (bl2) {
                    bl2 = false;
                    n3 = n2;
                    u2 = new u();
                    u2.D(((I)a.SR.S().get(n4)).ij());
                    this.a(u2);
                }
                u2 = new u();
                u2.n((I)a.SR.S().get(n4));
                this.a(u2);
            }
            ++n4;
        }
        JViewport jViewport = this.wi.getViewport();
        jViewport.setView(this.xb);
    }

    public void sd() {
        int n2 = 0;
        while (n2 < a.SR.S().size()) {
            if (((I)a.SR.S().get(n2)).hc().jZ().booleanValue() || ((I)a.SR.S().get(n2)).hd().jZ().booleanValue()) {
                this.KS = (I)a.SR.S().get(n2);
                break;
            }
            ++n2;
        }
        if (this.KS != null) {
            n2 = -1;
            int n3 = 0;
            while (n3 < this.cQ.size()) {
                if (this.cQ.get(n3) == this.KS.hy()) {
                    n2 = n3;
                    break;
                }
                ++n3;
            }
            if (n2 >= 0 && n2 < this.va.getItemCount()) {
                this.va.setSelectedIndex(n2);
            }
            this.i(this.KS);
        } else {
            this.i(((V)this.KU.get(0)).tR());
        }
        n2 = 0;
        while (n2 < this.KU.size()) {
            if (((V)this.KU.get(n2)).tR() != null && ((V)this.KU.get(n2)).tR() == this.KS) {
                this.f(n2, false);
                this.se();
                break;
            }
            this.f(0, false);
            ++n2;
        }
    }

    private void se() {
        Point point = this.wi.getViewport().getViewPosition();
        point.y = this.KV * 26;
        this.wi.getViewport().setViewPosition(point);
    }

    public void i(I i2) {
        if (i2 != null && i2 != this.KY) {
            this.KY = i2;
            this.zO.setForeground(i2.hc().kC());
            this.zO.setBackground(i2.hc().kB());
            this.zP.setForeground(i2.hd().kC());
            this.zP.setBackground(i2.hd().kB());
            if (i2.ev() != null) {
                this.Cg.setText(i2.ev().dS());
                this.Dz.setText(C.a(i2.hN(), 0));
                this.Dy.setText(Integer.toString(i2.hU()));
                this.Dy.setToolTipText(i2.hV());
            } else if (i2.il() != null) {
                this.Cg.setText(i2.il().dS());
                this.Dz.setText(C.a(i2.hN(), 0));
                this.Dy.setText(Integer.toString(i2.hU()));
                this.Dy.setToolTipText(i2.hV());
            } else {
                if (i2.ik() != null) {
                    this.Cg.setText(i2.ik());
                } else if (i2.hc().lp()) {
                    this.Cg.setText(i2.hc().getNome());
                }
                this.Dz.setText("n/i");
                this.Dy.setText("n/i");
            }
            int[] nArray = i2.hQ();
            if (nArray[0] >= 0 && nArray[1] >= 0) {
                this.Ll.setText("P:" + Integer.toString(nArray[0]) + "x" + Integer.toString(nArray[1]));
            } else {
                this.Ll.setText("");
            }
            this.Lm.setText(String.valueOf(i2.hu()) + " x " + i2.hw());
            this.zO.setText(String.valueOf(i2.hc().getNome()) + " ");
            this.zP.setText(" " + i2.hd().getNome());
            if (i2.hc().jY() != null) {
                this.Fq.setIcon(i2.hc().kP());
            } else {
                this.Fq.setIcon(i2.hc().K(true));
            }
            if (i2.hd().jY() != null) {
                this.yu.setIcon(i2.hd().kP());
            } else {
                this.yu.setIcon(i2.hd().K(true));
            }
            this.k(i2);
            this.a(i2, 1);
            this.a(i2, 2);
            this.Lr.addNotify();
            this.Ls.addNotify();
            this.j(i2);
        }
    }

    private void j(I i2) {
        this.KO.clear();
        ArrayList<A> arrayList = null;
        ArrayList<A> arrayList2 = null;
        Object var4_4 = null;
        ArrayList<A> arrayList3 = null;
        int n2 = 0;
        while (n2 < i2.hE().size()) {
            ((A)i2.hE().get(n2)).p(true);
            ++n2;
        }
        n2 = 0;
        while (n2 < i2.hE().size()) {
            if (((A)i2.hE().get(n2)).b() == 1) {
                if (arrayList == null) {
                    arrayList = new ArrayList<A>();
                }
                arrayList.add((A)i2.hE().get(n2));
            } else if (((A)i2.hE().get(n2)).b() >= 2 && ((A)i2.hE().get(n2)).b() <= 4) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<A>();
                }
                arrayList2.add((A)i2.hE().get(n2));
            } else if (((A)i2.hE().get(n2)).b() == 5) {
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<A>();
                }
                arrayList3.add((A)i2.hE().get(n2));
            }
            ++n2;
        }
        if (arrayList != null) {
            this.KO.add(new A(91, true));
            this.KO.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.KO.add(new A(92, true));
            this.KO.addAll(arrayList2);
        }
        if (arrayList3 != null) {
            this.KO.add(new A(95, true));
            this.KO.addAll(arrayList3);
        }
        this.DG.addNotify();
    }

    private void k(I i2) {
        this.Ln.setText(Integer.toString(i2.hz()[0]));
        this.Lo.setText(Integer.toString(i2.hz()[1]));
        this.Lp.setText(Integer.toString(i2.hA()[0]));
        this.Lq.setText(Integer.toString(i2.hA()[1]));
        this.Lh.setText(String.valueOf(Integer.toString(i2.hZ()[0])) + "(" + Integer.toString(i2.ia()[0]) + ")");
        this.Li.setText(String.valueOf(Integer.toString(i2.hZ()[1])) + "(" + Integer.toString(i2.ia()[1]) + ")");
        this.Le.setText(Integer.toString(i2.hB()[0]));
        this.Lf.setText(Integer.toString(i2.hB()[1]));
        this.Lj.setText(Integer.toString(i2.hC()[0]));
        this.Lk.setText(Integer.toString(i2.hC()[1]));
    }

    private void a(I i2, int n2) {
        i i3;
        ah ah2;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (n2 == 1) {
            arrayList2 = this.KP;
            arrayList = i2.hl();
            ah2 = i2.hc();
        } else {
            arrayList2 = this.KQ;
            arrayList = i2.hm();
            ah2 = i2.hd();
        }
        arrayList2.clear();
        int n3 = 0;
        while (n3 < arrayList.size()) {
            i3 = new i();
            i3.h((F)arrayList.get(n3));
            arrayList2.add(i3);
            ++n3;
        }
        Collections.sort(arrayList2, KZ);
        i i4 = new i();
        i4.an(true);
        arrayList2.add(i4);
        i3 = new i();
        i3.ao(true);
        arrayList2.add(i3);
        int n4 = 0;
        while (n4 < i2.hE().size()) {
            if (((A)i2.hE().get(n4)).b() == 6 && ((A)i2.hE().get(n4)).cu() == ah2) {
                i i5 = new i();
                i5.h(((A)i2.hE().get(n4)).ep());
                i5.ap(true);
                i5.K(((A)i2.hE().get(n4)).eq());
                arrayList2.add(i5);
                i i6 = new i();
                i6.h(((A)i2.hE().get(n4)).eo());
                i6.aq(true);
                arrayList2.add(i6);
            }
            ++n4;
        }
    }

    private int a(ArrayList arrayList, F f2) {
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (((i)arrayList.get(n2)).fb().equals(f2)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public static String h(I i2) {
        String string = null;
        if (i2.hy().b() == 3) {
            string = String.valueOf(i2.hy().getNome()) + " " + i2.hy().ip();
        }
        return string;
    }

    public static int sf() {
        return KT;
    }

    private void mJ() {
        this.va = new JComboBox();
        this.wi = new JScrollPane();
        this.zf = new JScrollPane();
        this.Lr = new JTable();
        this.zg = new JScrollPane();
        this.Ls = new JTable();
        this.zK = new JButton();
        this.Ll = new JLabel();
        this.Lm = new JLabel();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.Lo = new JLabel();
        this.Ln = new JLabel();
        this.Lp = new JLabel();
        this.Lq = new JLabel();
        this.Li = new JLabel();
        this.Lh = new JLabel();
        this.Lf = new JLabel();
        this.Le = new JLabel();
        this.Lg = new JLabel();
        this.Lk = new JLabel();
        this.Lj = new JLabel();
        this.ut = new JScrollPane();
        this.DG = new JTable();
        this.zO = new JLabel();
        this.Cg = new JLabel();
        this.zP = new JLabel();
        this.Dz = new JLabel();
        this.Dy = new JLabel();
        this.Fq = new JLabel();
        this.yu = new JLabel();
        this.Lb = new JButton();
        this.La = new JButton();
        this.HS = new JButton();
        this.Lc = new JButton();
        this.Ld = new JLabel();
        this.setBackground(new Color(12, 54, 77));
        this.setPreferredSize(new Dimension(1024, 735));
        this.setLayout(new b());
        this.add((Component)this.va, new components.a(19, 20, 300, 30));
        this.wi.setHorizontalScrollBarPolicy(31);
        this.add((Component)this.wi, new components.a(19, 60, 300, 585));
        this.zf.setViewportView(this.Lr);
        this.add((Component)this.zf, new components.a(330, 150, 230, 490));
        this.zg.setViewportView(this.Ls);
        this.add((Component)this.zg, new components.a(778, 150, 230, 490));
        this.zK.setText("Continuar >>");
        this.add((Component)this.zK, new components.a(870, 670, 140, 40));
        this.Ll.setForeground(new Color(255, 255, 255));
        this.Ll.setHorizontalAlignment(0);
        this.Ll.setText("");
        this.add((Component)this.Ll, new components.a(610, 70, 120, -1));
        this.Lm.setFont(new Font("Tahoma", 1, 24));
        this.Lm.setForeground(new Color(255, 255, 255));
        this.Lm.setHorizontalAlignment(0);
        this.Lm.setText("0 x 0");
        this.add((Component)this.Lm, new components.a(550, 30, 250, -1));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(0);
        this.uh.setText("finaliza\u00e7\u00f5es");
        this.add((Component)this.uh, new components.a(610, 542, 110, -1));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(0);
        this.a_.setText("erros passes");
        this.add((Component)this.a_, new components.a(620, 620, 90, -1));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(0);
        this.ur.setText("posse de bola");
        this.add((Component)this.ur, new components.a(620, 514, 90, -1));
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setHorizontalAlignment(0);
        this.us.setText("no gol (fora)");
        this.add((Component)this.us, new components.a(610, 568, 100, -1));
        this.Lo.setForeground(new Color(255, 255, 255));
        this.Lo.setText("58%");
        this.Lo.setToolTipText("");
        this.add((Component)this.Lo, new components.a(722, 514, 30, -1));
        this.Ln.setForeground(new Color(255, 255, 255));
        this.Ln.setHorizontalAlignment(0);
        this.Ln.setText("58%");
        this.Ln.setToolTipText("");
        this.add((Component)this.Ln, new components.a(580, 513, -1, -1));
        this.Lp.setForeground(new Color(255, 255, 255));
        this.Lp.setHorizontalAlignment(0);
        this.Lp.setText("12");
        this.Lp.setToolTipText("");
        this.add((Component)this.Lp, new components.a(580, 542, 20, -1));
        this.Lq.setForeground(new Color(255, 255, 255));
        this.Lq.setHorizontalAlignment(0);
        this.Lq.setText("12");
        this.Lq.setToolTipText("");
        this.add((Component)this.Lq, new components.a(722, 542, 30, -1));
        this.Li.setForeground(new Color(255, 255, 255));
        this.Li.setHorizontalAlignment(0);
        this.Li.setText("12(10)");
        this.Li.setToolTipText("");
        this.add((Component)this.Li, new components.a(720, 568, -1, -1));
        this.Lh.setForeground(new Color(255, 255, 255));
        this.Lh.setText("12(10)");
        this.Lh.setToolTipText("");
        this.add((Component)this.Lh, new components.a(576, 568, -1, -1));
        this.Lf.setForeground(new Color(255, 255, 255));
        this.Lf.setHorizontalAlignment(0);
        this.Lf.setText("1");
        this.Lf.setToolTipText("");
        this.add((Component)this.Lf, new components.a(720, 596, 30, -1));
        this.Le.setForeground(new Color(255, 255, 255));
        this.Le.setHorizontalAlignment(0);
        this.Le.setText("2");
        this.Le.setToolTipText("");
        this.add((Component)this.Le, new components.a(580, 596, 20, -1));
        this.Lg.setForeground(new Color(255, 255, 255));
        this.Lg.setHorizontalAlignment(0);
        this.Lg.setText("desarmes");
        this.add((Component)this.Lg, new components.a(610, 596, 110, -1));
        this.Lk.setForeground(new Color(255, 255, 255));
        this.Lk.setHorizontalAlignment(0);
        this.Lk.setText("12");
        this.Lk.setToolTipText("");
        this.add((Component)this.Lk, new components.a(722, 620, 30, -1));
        this.Lj.setForeground(new Color(255, 255, 255));
        this.Lj.setHorizontalAlignment(0);
        this.Lj.setText("12");
        this.Lj.setToolTipText("");
        this.add((Component)this.Lj, new components.a(580, 620, 20, -1));
        this.ut.setBorder(null);
        this.ut.setViewportView(this.DG);
        this.add((Component)this.ut, new components.a(570, 180, 196, 320));
        this.zO.setBackground(new Color(0, 51, 204));
        this.zO.setFont(new Font("Tahoma", 1, 14));
        this.zO.setForeground(new Color(255, 255, 255));
        this.zO.setHorizontalAlignment(4);
        this.zO.setText("");
        this.zO.setOpaque(true);
        this.add((Component)this.zO, new components.a(330, 120, 230, 30));
        this.Cg.setForeground(new Color(255, 255, 255));
        this.Cg.setText("");
        this.add((Component)this.Cg, new components.a(620, 120, 130, -1));
        this.zP.setBackground(new Color(153, 0, 0));
        this.zP.setFont(new Font("Tahoma", 1, 14));
        this.zP.setForeground(new Color(255, 255, 255));
        this.zP.setHorizontalAlignment(2);
        this.zP.setText("");
        this.zP.setOpaque(true);
        this.add((Component)this.zP, new components.a(778, 120, 230, 30));
        this.Dz.setForeground(new Color(255, 255, 255));
        this.Dz.setText("");
        this.add((Component)this.Dz, new components.a(690, 150, 60, -1));
        this.Dy.setForeground(new Color(255, 255, 255));
        this.Dy.setText("120 236");
        this.add((Component)this.Dy, new components.a(620, 150, 50, -1));
        this.Fq.setHorizontalAlignment(4);
        this.add((Component)this.Fq, new components.a(450, 20, 60, 60));
        this.add((Component)this.yu, new components.a(830, 20, 60, 60));
        this.Lb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconfire.png")));
        this.add((Component)this.Lb, new components.a(210, 670, 50, 40));
        this.La.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
        this.add((Component)this.La, new components.a(30, 670, 50, 40));
        this.HS.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon04.png")));
        this.add((Component)this.HS, new components.a(90, 670, 50, 40));
        this.Lc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_green.png")));
        this.add((Component)this.Lc, new components.a(150, 670, 50, 40));
        this.Ld.setHorizontalAlignment(4);
        this.Ld.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/results04.png")));
        this.Ld.setMaximumSize(new Dimension(60, 60));
        this.Ld.setMinimumSize(new Dimension(60, 60));
        this.Ld.setPreferredSize(new Dimension(60, 60));
        this.add((Component)this.Ld, new components.a(0, 0, 1024, 750));
    }

    static /* synthetic */ Timer ph() {
        return Dk;
    }

    static /* synthetic */ void a(hk hk2) {
        hk2.nx();
    }

    static /* synthetic */ JComboBox b(hk hk2) {
        return hk2.va;
    }

    static /* synthetic */ void a(hk hk2, int n2) {
        hk2.cC(n2);
    }

    static /* synthetic */ void c(hk hk2) {
        hk2.qV();
    }

    static /* synthetic */ JButton d(hk hk2) {
        return hk2.La;
    }

    static /* synthetic */ JButton e(hk hk2) {
        return hk2.Lc;
    }

    static /* synthetic */ Z f(hk hk2) {
        return hk2.KR;
    }
}

