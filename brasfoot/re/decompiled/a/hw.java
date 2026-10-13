/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hx;
import a.hy;
import b.K;
import b.aE;
import best.Z;
import best.ac;
import best.ad;
import best.ah;
import best.aj;
import best.al;
import best.aq;
import best.at;
import best.j;
import components.a;
import components.af;
import components.ay;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

public class hw
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private JPanel xb = null;
    private Z Lu = null;
    private ArrayList Lv = new ArrayList();
    private int xh = 0;
    private int xi = 0;
    private ArrayList Lw = new ArrayList();
    private JButton vm;
    private JLabel ug;
    private JScrollPane ut;
    private JTable Lx;

    public hw(JDialog jDialog, ah ah2) {
        this.uk = ah2;
        this.ub = jDialog;
        this.Lu = c.a.SR.s(ah2.getPais());
        this.mJ();
        if (ah2 != null) {
            this.ug.setIcon(ah2.x(30, 30));
            this.ug.setText("Retrospecto - " + ah2.getNome());
        }
        this.mH();
        this.sg();
        this.mG();
        JViewport jViewport = this.ut.getViewport();
        jViewport.setView(this.xb);
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        this.ut.setBorder(BorderFactory.createEmptyBorder());
    }

    private String h(int n2, int n3, int n4) {
        String string = "";
        string = aq.tz[n2];
        at at2 = null;
        int n5 = this.uk.getPais();
        if (n2 == 9) {
            string = n3 == 70 ? "Classificat\u00f3rio Eurocopa" : aq.tz[n2];
        } else if (n2 == 1 && n3 == 1098) {
            string = aq.abX[0];
        } else if (n2 == 1) {
            string = String.valueOf(ad.bu(n5)) + " (" + Integer.toString(n4) + "\u00aa div.)";
        } else if (n2 == 2) {
            string = "Copa " + ad.bq(n5) + " " + ac.bl(n5);
        } else if (n2 == 3) {
            string = n3 >= 0 && n3 < aq.rZ.length ? String.valueOf(aq.rZ[n3]) + " (" + Integer.toString(n4) + "\u00aa div.)" : String.valueOf(string) + " (" + Integer.toString(n4) + "\u00aa div.)";
        } else if (n2 == 4 || n2 == 6 || n2 == 12) {
            at2 = c.a.SR.c(n2, n3);
        } else if (n2 == 10) {
            string = aq.pY[n3];
        } else if (n2 == 7) {
            string = aq.aeF[n3];
        }
        if (at2 != null) {
            return at2.getNome();
        }
        return string;
    }

    private void nt() {
        this.Lw.clear();
        this.xb = new JPanel(new b());
        this.xh = 0;
        this.xi = 0;
        this.a(0, null);
    }

    private void a(int n2, af af2) {
        ay ay2;
        int n3 = 0;
        if (n2 == 1) {
            ay2 = new ay(1, af2, this);
        } else if (n2 == 2) {
            ay2 = new ay(2, af2, this);
            n3 = 5;
        } else {
            ay2 = new ay(0, null, this);
        }
        this.xb.setBackground(aq.E(c.a.vM().getCorTema(), 1));
        this.xb.add((Component)ay2, new a(0, this.xh, 690, 25));
        this.Lw.add(ay2);
        this.xh = this.xh + 26 + n3;
    }

    public void a(ay ay2) {
        int n2 = 1;
        while (n2 < this.Lw.size()) {
            if (ay2 != this.Lw.get(n2)) {
                ((ay)this.Lw.get(n2)).aI(false);
            }
            ++n2;
        }
        ay2.aI(true);
    }

    private void sg() {
        int n2;
        this.Lv.clear();
        this.nt();
        ArrayList<hy> arrayList = new ArrayList<hy>();
        int n3 = this.uk.lk();
        int n4 = 0;
        while (n4 < c.a.SR.L().size()) {
            n2 = 0;
            while (n2 < ((al)c.a.SR.L().get(n4)).lO().size()) {
                if (((j)((al)c.a.SR.L().get(n4)).lO().get(n2)).ct() == n3) {
                    arrayList.add(new hy(this, ((j)((al)c.a.SR.L().get(n4)).lO().get(n2)).H(), ((al)c.a.SR.L().get(n4)).dS()));
                }
                ++n2;
            }
            ++n4;
        }
        n4 = 0;
        n2 = 0;
        int[] nArray = new int[6];
        String string = "";
        int n5 = this.uk.le().size() - 1;
        while (n5 >= 0) {
            n4 = ((aj)this.uk.le().get(n5)).H();
            af af2 = new af();
            af2.k(((aj)this.uk.le().get(n5)).H());
            af2.M(this.h(((aj)this.uk.le().get(n5)).b(), ((aj)this.uk.le().get(n5)).el(), ((aj)this.uk.le().get(n5)).getDivisao()));
            af2.h(((aj)this.uk.le().get(n5)).w());
            nArray[0] = nArray[0] + af2.w();
            af2.dS(((aj)this.uk.le().get(n5)).cm());
            nArray[1] = nArray[1] + af2.cm();
            af2.dT(((aj)this.uk.le().get(n5)).co());
            nArray[2] = nArray[2] + af2.co();
            af2.dU(((aj)this.uk.le().get(n5)).ls());
            nArray[4] = nArray[4] + af2.ls();
            af2.dV(((aj)this.uk.le().get(n5)).lt());
            nArray[5] = nArray[5] + af2.lt();
            af2.U(((aj)this.uk.le().get(n5)).d(this.Lu));
            af2.ce(((aj)this.uk.le().get(n5)).lw());
            af2.aD(((aj)this.uk.le().get(n5)).lz());
            af2.aB(((aj)this.uk.le().get(n5)).lx());
            af2.aC(((aj)this.uk.le().get(n5)).ly());
            this.Lv.add(af2);
            string = "";
            this.a(1, af2);
            if (n5 - 1 < 0) {
                n2 = 1;
            }
            if (n2 == 0 && n4 != ((aj)this.uk.le().get(n5 - 1)).H()) {
                n2 = 1;
            }
            if (n2 != 0) {
                af af3 = new af();
                af3.ar(true);
                af3.k(((aj)this.uk.le().get(n5)).H());
                af3.h(nArray[0]);
                af3.dS(nArray[1]);
                af3.dT(nArray[2]);
                af3.dU(nArray[4]);
                af3.dV(nArray[5]);
                this.Lv.add(af3);
                n2 = 0;
                nArray[0] = 0;
                nArray[1] = 0;
                nArray[2] = 0;
                nArray[3] = 0;
                nArray[4] = 0;
                nArray[5] = 0;
                String string2 = null;
                int n6 = 0;
                while (n6 < arrayList.size()) {
                    if (((hy)arrayList.get((int)n6)).ae == ((aj)this.uk.le().get(n5)).H()) {
                        string2 = string2 == null ? ((hy)arrayList.get((int)n6)).nome : String.valueOf(string2) + ", " + ((hy)arrayList.get((int)n6)).nome;
                    }
                    ++n6;
                }
                af3.T(string2);
                this.a(2, af3);
            }
            --n5;
        }
    }

    private void mH() {
        this.vm.addActionListener(new hx(this));
    }

    private void mS() {
        K k2 = new K(this.Lv);
        this.Lx.setModel(k2);
        int[] nArray = new int[]{40, 120, 120, 30, 30, 30, 30, 30, 30, 200};
        int[] nArray2 = new int[]{40, 220, 220, 30, 30, 30, 30, 30, 30, 400};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Lx.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        n2 = 0;
        while (n2 < nArray2.length) {
            this.Lx.getColumnModel().getColumn(n2).setMaxWidth(nArray2[n2]);
            ++n2;
        }
        this.Lx.setAutoResizeMode(3);
        this.Lx.setRowHeight(20);
        this.Lx.setShowGrid(false);
        this.Lx.setDefaultRenderer(af.class, new aE());
        this.Lx.setAutoCreateRowSorter(false);
        this.Lx.getTableHeader().setReorderingAllowed(false);
        this.Lx.setIntercellSpacing(new Dimension(0, 0));
        this.Lx.setCellSelectionEnabled(false);
        this.Lx.setSelectionMode(0);
        this.Lx.setRowSelectionAllowed(true);
        this.Lx.setSelectionBackground(Color.YELLOW);
        this.Lx.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.ug = new JLabel();
        this.ut = new JScrollPane();
        this.Lx = new JTable();
        this.vm = new JButton();
        this.setBackground(new Color(0, 68, 105));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setPreferredSize(new Dimension(797, 740));
        this.setLayout(new b());
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Retrospecto");
        this.add((Component)this.ug, new a(23, 20, -1, -1));
        this.ut.setBackground(new Color(204, 204, 204));
        this.ut.setHorizontalScrollBarPolicy(31);
        this.ut.setViewportView(this.Lx);
        this.add((Component)this.ut, new a(23, 58, 690, 600));
        this.vm.setText("X");
        this.add((Component)this.vm, new a(660, 10, 50, -1));
    }

    static /* synthetic */ JDialog a(hw hw2) {
        return hw2.ub;
    }
}

