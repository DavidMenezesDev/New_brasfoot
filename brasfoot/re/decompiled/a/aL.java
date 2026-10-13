/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aM;
import a.aN;
import a.aO;
import b.an;
import b.p;
import best.I;
import best.T;
import best.Z;
import best.ac;
import best.ad;
import best.ah;
import best.aq;
import best.n;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class aL
extends JPanel {
    private ArrayList yj = new ArrayList();
    private ArrayList yk = new ArrayList();
    private ArrayList yl = new ArrayList();
    private JDialog ub;
    private ah ym = null;
    private ah yn = null;
    private T yo = null;
    private boolean yp = false;
    private JButton vm;
    private JButton yq;
    private JComboBox yr;
    private JComboBox ys;
    private JLabel ug;
    private JScrollPane ut;
    private JLabel yt;
    private JLabel yu;
    private JLabel yv;
    private JLabel yw;
    private JLabel yx;
    private JLabel yy;
    private JLabel yz;
    private JLabel yA;
    private JLabel yB;
    private JLabel yC;
    private JLabel yD;
    private JLabel yE;
    private JLabel yF;
    private JLabel yG;
    private JLabel yH;
    private JLabel yI;
    private JTable vN;

    public aL(JDialog jDialog, ah ah2, ah ah3, boolean bl2) {
        this.ub = jDialog;
        this.ym = ah2;
        this.yn = ah3;
        this.yp = bl2;
        this.mJ();
        int n2 = 0;
        int n3 = 0;
        if (!bl2) {
            int n4 = 0;
            while (n4 < c.a.SR.P().size()) {
                this.yr.addItem(((ah)c.a.SR.P().get(n4)).getNome());
                if (c.a.SR.P().get(n4) == ah2) {
                    n2 = n4;
                }
                ++n4;
            }
        } else {
            int n5 = 0;
            while (n5 < ac.jz()) {
                int n6 = ((ad)n.cY().get(n5)).getPais();
                Z z2 = c.a.SR.s(n6);
                if (z2.jl()) {
                    this.yr.addItem(z2.jo());
                    this.yl.add(z2.jo());
                    if (z2.jo() == this.ym) {
                        n2 = n3;
                    }
                    ++n3;
                }
                ++n5;
            }
        }
        this.yr.setMaximumRowCount(20);
        this.ys.setMaximumRowCount(20);
        this.yr.setSelectedIndex(n2);
        this.R(true);
        this.mS();
        this.S(false);
        this.mH();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.vm.addActionListener(new aM(this));
        this.yq.addActionListener(new aN(this));
        this.yr.addActionListener(new aO(this));
    }

    private void R(boolean bl2) {
        if (!bl2) {
            if (!this.yp) {
                this.ym = (ah)c.a.SR.P().get(this.yr.getSelectedIndex());
            } else if (this.yl.size() > 0) {
                this.ym = (ah)this.yl.get(this.yr.getSelectedIndex());
            }
        }
        int n2 = -1;
        ah ah2 = null;
        this.yk.clear();
        this.ys.removeAllItems();
        int n3 = 0;
        while (n3 < c.a.SR.bd().size()) {
            ah2 = ((T)c.a.SR.bd().get(n3)).y(this.ym);
            if (ah2 != null) {
                this.yk.add(ah2);
            }
            ++n3;
        }
        Collections.sort(this.yk, h.a.VS);
        n3 = 0;
        while (n3 < this.yk.size()) {
            this.ys.addItem(((ah)this.yk.get(n3)).getNome());
            if (bl2 && this.yk.get(n3) == this.yn) {
                n2 = n3;
            }
            ++n3;
        }
        if (n2 >= 0) {
            this.ys.setSelectedIndex(n2);
        }
    }

    private void S(boolean bl2) {
        if (bl2) {
            this.ym = !this.yp ? (ah)c.a.SR.P().get(this.yr.getSelectedIndex()) : (ah)this.yl.get(this.yr.getSelectedIndex());
            if (this.ys.getItemCount() > 0 && this.ys.getSelectedIndex() < this.yk.size()) {
                this.yn = (ah)this.yk.get(this.ys.getSelectedIndex());
            }
        }
        if (this.ym != this.yn) {
            this.yo = null;
            int n2 = 0;
            while (n2 < c.a.SR.bd().size()) {
                if (((T)c.a.SR.bd().get(n2)).a(this.ym, this.yn)) {
                    this.yo = (T)c.a.SR.bd().get(n2);
                    break;
                }
                ++n2;
            }
            this.yA.setText(this.ym.getNome());
            this.yB.setText(this.yn.getNome());
            this.yv.setIcon(this.ym.kP());
            this.yu.setIcon(this.yn.kP());
            if (this.yo != null) {
                if (this.yo != null) {
                    this.yG.setText(this.yo.iN());
                    this.yE.setText(this.yo.iO());
                    this.yC.setText(this.yo.be(this.ym.lk()));
                    this.yD.setText(this.yo.be(this.yn.lk()));
                    this.yw.setText(this.yo.bf(this.ym.lk()));
                    this.yx.setText(this.yo.bf(this.yn.lk()));
                    String[] stringArray = this.yo.bg(this.ym.lk());
                    this.yy.setText(stringArray[0]);
                    String[] stringArray2 = this.yo.bg(this.yn.lk());
                    this.yz.setText(stringArray2[0]);
                }
                this.yj.clear();
                int n3 = 0;
                while (n3 < c.a.SR.R().size()) {
                    int n4 = 0;
                    while (n4 < ((best.a)c.a.SR.R().get(n3)).h().size()) {
                        if (((I)((best.a)c.a.SR.R().get(n3)).h().get(n4)).hc() == this.ym && ((I)((best.a)c.a.SR.R().get(n3)).h().get(n4)).hd() == this.yn || ((I)((best.a)c.a.SR.R().get(n3)).h().get(n4)).hd() == this.ym && ((I)((best.a)c.a.SR.R().get(n3)).h().get(n4)).hc() == this.yn) {
                            this.yj.add((I)((best.a)c.a.SR.R().get(n3)).h().get(n4));
                        }
                        ++n4;
                    }
                    ++n3;
                }
                this.vN.addNotify();
            } else {
                this.yj.clear();
                this.yG.setText("0 jogos");
                this.yE.setText("");
                this.yC.setText("");
                this.yD.setText("");
                this.yw.setText("");
                this.yx.setText("");
                this.yy.setText("");
                this.yz.setText("");
            }
        }
    }

    private void mS() {
        p p2 = new p(this.yj);
        this.vN.setModel(p2);
        int[] nArray = new int[]{90, 120, 55, 120, 170};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vN.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vN.setAutoResizeMode(3);
        this.vN.setRowHeight(20);
        this.vN.setShowGrid(false);
        this.vN.setDefaultRenderer(I.class, new an());
        this.vN.setAutoCreateRowSorter(false);
        this.vN.getTableHeader().setReorderingAllowed(false);
        this.vN.setIntercellSpacing(new Dimension(0, 0));
        this.vN.setCellSelectionEnabled(false);
        this.vN.setSelectionMode(0);
        this.vN.setRowSelectionAllowed(true);
        this.vN.setSelectionBackground(Color.YELLOW);
        this.vN.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.yt = new JLabel();
        this.yr = new JComboBox();
        this.ug = new JLabel();
        this.ys = new JComboBox();
        this.yq = new JButton();
        this.vm = new JButton();
        this.yA = new JLabel();
        this.yB = new JLabel();
        this.yE = new JLabel();
        this.ut = new JScrollPane();
        this.vN = new JTable();
        this.yF = new JLabel();
        this.yu = new JLabel();
        this.yv = new JLabel();
        this.yx = new JLabel();
        this.yG = new JLabel();
        this.yC = new JLabel();
        this.yD = new JLabel();
        this.yH = new JLabel();
        this.yw = new JLabel();
        this.yy = new JLabel();
        this.yz = new JLabel();
        this.yI = new JLabel();
        this.yt.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setLayout(new b());
        this.add((Component)this.yr, new a(110, 400, 170, -1));
        this.ug.setFont(new Font("Tahoma", 1, 11));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("x");
        this.add((Component)this.ug, new a(300, 400, -1, -1));
        this.add((Component)this.ys, new a(330, 400, 170, -1));
        this.yq.setText("mostrar");
        this.add((Component)this.yq, new a(520, 400, -1, -1));
        this.vm.setText("x");
        this.add((Component)this.vm, new a(540, 20, 60, 31));
        this.yA.setForeground(new Color(255, 255, 255));
        this.yA.setHorizontalAlignment(0);
        this.yA.setText("jLabel2");
        this.add((Component)this.yA, new a(70, 20, 220, -1));
        this.yB.setForeground(new Color(255, 255, 255));
        this.yB.setHorizontalAlignment(0);
        this.yB.setText("jLabel3");
        this.add((Component)this.yB, new a(312, 20, 190, -1));
        this.yE.setForeground(new Color(255, 255, 255));
        this.yE.setHorizontalAlignment(0);
        this.yE.setText("10 empates");
        this.add((Component)this.yE, new a(250, 70, 90, -1));
        this.ut.setViewportView(this.vN);
        this.add((Component)this.ut, new a(20, 230, 580, 128));
        this.yF.setFont(new Font("Tahoma", 1, 14));
        this.yF.setForeground(new Color(255, 255, 255));
        this.yF.setHorizontalAlignment(4);
        this.yF.setText("Maior vit\u00f3ria:");
        this.add((Component)this.yF, new a(10, 150, 190, -1));
        this.yu.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.add((Component)this.yu, new a(380, 40, -1, -1));
        this.yv.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.add((Component)this.yv, new a(150, 40, -1, -1));
        this.yx.setForeground(new Color(255, 255, 255));
        this.yx.setHorizontalAlignment(2);
        this.yx.setText("");
        this.add((Component)this.yx, new a(380, 120, 100, -1));
        this.yG.setForeground(new Color(255, 255, 255));
        this.yG.setHorizontalAlignment(0);
        this.yG.setText("");
        this.yG.setToolTipText("");
        this.add((Component)this.yG, new a(240, 50, 100, -1));
        this.yC.setFont(new Font("Tahoma", 1, 14));
        this.yC.setForeground(new Color(255, 255, 255));
        this.yC.setHorizontalAlignment(4);
        this.yC.setText("");
        this.add((Component)this.yC, new a(90, 100, 110, -1));
        this.yD.setFont(new Font("Tahoma", 1, 14));
        this.yD.setForeground(new Color(255, 255, 255));
        this.yD.setHorizontalAlignment(2);
        this.yD.setText("");
        this.add((Component)this.yD, new a(380, 100, 110, -1));
        this.yH.setForeground(new Color(255, 255, 255));
        this.yH.setText("Jogos na temporada");
        this.add((Component)this.yH, new a(250, 210, 151, -1));
        this.yw.setForeground(new Color(255, 255, 255));
        this.yw.setHorizontalAlignment(4);
        this.yw.setText("");
        this.add((Component)this.yw, new a(80, 120, 120, -1));
        this.yy.setForeground(new Color(255, 255, 255));
        this.yy.setHorizontalAlignment(4);
        this.yy.setText("");
        this.add((Component)this.yy, new a(10, 170, 190, -1));
        this.yz.setForeground(new Color(255, 255, 255));
        this.yz.setHorizontalAlignment(2);
        this.yz.setText("");
        this.add((Component)this.yz, new a(380, 170, 220, -1));
        this.yI.setFont(new Font("Tahoma", 1, 14));
        this.yI.setForeground(new Color(255, 255, 255));
        this.yI.setHorizontalAlignment(2);
        this.yI.setText("Maior vit\u00f3ria:");
        this.add((Component)this.yI, new a(380, 150, 190, -1));
    }

    static /* synthetic */ JDialog a(aL aL2) {
        return aL2.ub;
    }

    static /* synthetic */ void a(aL aL2, boolean bl2) {
        aL2.S(bl2);
    }

    static /* synthetic */ JComboBox b(aL aL2) {
        return aL2.yr;
    }

    static /* synthetic */ void b(aL aL2, boolean bl2) {
        aL2.R(bl2);
    }
}

