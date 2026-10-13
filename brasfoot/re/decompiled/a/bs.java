/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bt;
import best.F;
import best.ah;
import best.aq;
import components.H;
import components.a;
import components.b;
import components.t;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

public class bs
extends JPanel {
    private ah zu = null;
    private ah Af = null;
    private F yK = null;
    private JDialog ub;
    private static boolean Ag = false;
    private JPanel xb = null;
    private JPanel Ah = null;
    private ArrayList Ai = new ArrayList();
    private ArrayList Aj = new ArrayList();
    private int xh = 0;
    private int xi = 0;
    private int Ak = 0;
    private int Al = 0;
    private JButton Am;
    private JLabel uh;
    private JLabel a_;
    private JScrollPane ut;
    private JScrollPane wi;
    private JLabel An;
    private JLabel Ao;
    private JTable Ap;
    private JTable Aq;

    public bs(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.Af = ah2;
        Ag = false;
        this.mJ();
        this.mH();
        this.nS();
        this.nT();
        this.nW();
        this.mG();
    }

    private void nt() {
        this.Ai.clear();
        this.xb = new JPanel(new b());
        this.xh = 0;
        this.xi = 0;
    }

    private void nR() {
        this.Aj.clear();
        this.Ah = new JPanel(new b());
        this.Ak = 0;
        this.Al = 0;
    }

    public void nS() {
        this.nt();
        this.nU();
        ArrayList arrayList = c.a.SR.e(this.Af);
        int n2 = 0;
        while (n2 < arrayList.size()) {
            this.Ai.add((t)arrayList.get(n2));
            this.a((t)arrayList.get(n2));
            ++n2;
        }
        JViewport jViewport = this.ut.getViewport();
        jViewport.setView(this.xb);
    }

    public void nT() {
        this.nR();
        this.nV();
        ArrayList arrayList = c.a.SR.f(this.Af);
        int n2 = 0;
        while (n2 < arrayList.size()) {
            this.Aj.add((t)arrayList.get(n2));
            this.b((t)arrayList.get(n2));
            ++n2;
        }
        JViewport jViewport = this.wi.getViewport();
        jViewport.setView(this.Ah);
    }

    private void nU() {
        H h3 = new H(2, this, null);
        this.xb.setBackground(aq.E(c.a.vM().getCorTema(), 1));
        this.xb.add((Component)h3, new a(0, this.xh, 690, 36));
        this.xh += 36;
    }

    private void a(t t2) {
        int n2 = 0;
        H h3 = new H(1, this, t2);
        this.xb.add((Component)h3, new a(0, this.xh, 690, 36));
        this.xh = this.xh + 36 + n2;
    }

    private void nV() {
        H h3 = new H(3, this, null);
        this.Ah.setBackground(aq.E(c.a.vM().getCorTema(), 1));
        this.Ah.add((Component)h3, new a(0, this.Ak, 690, 36));
        this.Ak += 36;
    }

    private void b(t t2) {
        H h3 = new H(4, this, t2);
        this.Ah.add((Component)h3, new a(0, this.Ak, 690, 36));
        this.Ak += 36;
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        this.ut.setBorder(BorderFactory.createEmptyBorder());
        this.wi.setBorder(BorderFactory.createEmptyBorder());
    }

    public void mH() {
        this.Am.addActionListener(new bt(this));
    }

    public void a(t t2, int n2) {
        if (t2.tN()) {
            Ag = true;
            c.a.SR.d(t2.x());
            if (n2 == 1) {
                this.nS();
            } else {
                this.nT();
            }
            this.nW();
        } else {
            JOptionPane.showMessageDialog(this.ub, "N\u00e3o h\u00e1 vagas no time de origem", "", 2);
        }
    }

    private void nW() {
        this.An.setText("vagas dispon\u00edveis: " + Integer.toString(this.Ai.size()) + "/" + Integer.toString(4));
        this.Ao.setText("limite de empr\u00e9stimos: " + Integer.toString(this.Aj.size()) + "/" + Integer.toString(10));
    }

    private void mJ() {
        this.ut = new JScrollPane();
        this.Ap = new JTable();
        this.uh = new JLabel();
        this.wi = new JScrollPane();
        this.Aq = new JTable();
        this.a_ = new JLabel();
        this.Ao = new JLabel();
        this.Am = new JButton();
        this.An = new JLabel();
        this.setBackground(new Color(0, 68, 105));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setPreferredSize(new Dimension(797, 740));
        this.setLayout(new b());
        this.ut.setBackground(new Color(204, 204, 204));
        this.ut.setHorizontalScrollBarPolicy(31);
        this.ut.setViewportView(this.Ap);
        this.add((Component)this.ut, new a(23, 48, 690, 180));
        this.uh.setFont(new Font("Tahoma", 1, 14));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText("Seus jogadores emprestados em outros times");
        this.add((Component)this.uh, new a(28, 267, 380, -1));
        this.wi.setBackground(new Color(204, 204, 204));
        this.wi.setHorizontalScrollBarPolicy(31);
        this.wi.setViewportView(this.Aq);
        this.add((Component)this.wi, new a(23, 290, 690, 280));
        this.a_.setFont(new Font("Tahoma", 1, 14));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setText("Jogadores emprestados no seu time");
        this.add((Component)this.a_, new a(28, 25, 360, -1));
        this.Ao.setFont(new Font("Tahoma", 1, 12));
        this.Ao.setForeground(new Color(255, 255, 153));
        this.Ao.setHorizontalAlignment(4);
        this.Ao.setText("limite de empr\u00e9stimos: 0/10");
        this.add((Component)this.Ao, new a(520, 270, 190, -1));
        this.Am.setText("X");
        this.add((Component)this.Am, new a(660, 10, 50, -1));
        this.An.setFont(new Font("Tahoma", 1, 12));
        this.An.setForeground(new Color(255, 255, 153));
        this.An.setText("vagas dispon\u00edveis: 0/4");
        this.add((Component)this.An, new a(510, 28, 140, -1));
    }

    public static boolean nX() {
        return Ag;
    }

    static /* synthetic */ JDialog a(bs bs2) {
        return bs2.ub;
    }
}

