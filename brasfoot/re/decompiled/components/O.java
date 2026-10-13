/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.aJ;
import best.Z;
import best.ac;
import best.ad;
import best.aq;
import best.n;
import components.P;
import components.Q;
import components.R;
import components.S;
import components.T;
import components.U;
import components.a;
import components.aa;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class O
extends JPanel {
    public JDialog ub;
    private int w;
    private String pU = "Qualquer";
    public JButton vm;
    public JCheckBox Qq;
    public JCheckBox Qr;
    public JCheckBox Qs;
    public JCheckBox Qt;
    public JComboBox Qu;
    public JComboBox Qv;
    public JComboBox Qw;
    public JComboBox Qx;
    public JComboBox BD;
    public JComboBox Nq;
    public JComboBox Qy;
    public JTextField uf;
    public JLabel Bj;
    public JLabel vw;
    public JLabel zb;
    public JLabel zc;
    public JLabel uh;
    public JLabel a_;
    public JLabel ur;
    public JLabel vx;
    public JLabel vy;
    public JLabel vz;
    public JLabel Qz;
    public JLabel QA;
    public aa QB;
    public aa QC;
    public JLabel Ei;
    public JLabel Jw;
    public JLabel Jx;
    public JLabel Jy;
    public JLabel Jz;
    public JLabel JA;
    public JLabel JB;
    public JLabel JC;
    public JLabel QD;
    public JLabel QE;
    public JLabel QF;
    public JLabel QG;
    public JLabel QH;
    public JLabel QI;
    public JLabel QJ;
    public aa QK;
    public aa QL;
    public aa QM;
    public aa QN;
    public aa QO;
    public aa QP;
    public aa QQ;

    public O(JDialog jDialog, int n2) {
        this.ub = jDialog;
        this.w = n2;
        if (n2 == 1) {
            this.mJ();
        } else if (n2 == 2) {
            this.rS();
        } else if (n2 == 3) {
            this.uq();
        } else if (n2 == 4) {
            this.ur();
        }
    }

    public void rR() {
        this.uf.setText("");
        this.Nq.setSelectedIndex(0);
        this.Qx.setSelectedIndex(0);
        this.uk();
        this.Qy.setSelectedIndex(0);
        this.Qv.setSelectedIndex(0);
        this.Qw.setSelectedIndex(0);
        this.BD.setSelectedIndex(0);
        this.Qu.setSelectedIndex(0);
        this.Qs.setSelected(false);
        this.Qt.setSelected(false);
        if (this.Qq != null) {
            this.Qq.setSelected(false);
        }
        if (this.Qr != null) {
            this.Qr.setSelected(false);
        }
    }

    public void mG() {
        if (this.w == 1 || this.w == 4) {
            this.setBackground(aq.E(c.a.vM().getCorTema(), 2));
            this.QC.setBackground(aq.E(c.a.vM().getCorTema(), 2));
            this.QB.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        } else {
            this.uj();
        }
    }

    private void uj() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        this.QC.setBackground(aq.E(c.a.vM().getCorTema(), 2));
        aa[] aaArray = new aa[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};
        int n2 = 0;
        while (n2 < aaArray.length) {
            aaArray[n2].setBackground(aq.E(c.a.vM().getCorTema(), 2));
            ++n2;
        }
    }

    public void uk() {
        if (this.w == 1 || this.w == 4) {
            this.QC.setMinimum(16);
            this.QC.setMaximum(45);
            this.QC.setValue(16);
            this.QC.dP(45);
            this.QB.setMinimum(1);
            this.QB.setMaximum(100);
            this.QB.setValue(1);
            this.QB.dP(100);
        } else {
            this.up();
        }
    }

    public void mK() {
        this.uk();
        this.um();
        this.mH();
        String[] stringArray = new String[]{"1 mil => 100 mil", "101 mil => 500 mil", "501 mil => 1 milh\u00e3o", "1 milh\u00e3o => 3 milh\u00f5es", "3 milh\u00f5es => 5 milh\u00f5es", "5 milh\u00f5es => 10 milh\u00f5es", "mais 10 milh\u00f5es"};
        this.Nq.addItem(this.pU);
        int n2 = 0;
        while (n2 < aq.rH.length) {
            this.Nq.addItem(aq.rH[n2]);
            ++n2;
        }
        this.Nq.setSelectedIndex(0);
        this.Qx.addItem(this.pU);
        n2 = 0;
        while (n2 < aq.rK.length) {
            this.Qx.addItem(aq.rK[n2]);
            ++n2;
        }
        this.Qx.setSelectedIndex(0);
        this.Qy.addItem(this.pU);
        n2 = 0;
        while (n2 < stringArray.length) {
            this.Qy.addItem(stringArray[n2]);
            ++n2;
        }
        this.Qy.setSelectedIndex(0);
        this.Qv.addItem(this.pU);
        n2 = 0;
        while (n2 < aq.qM.length) {
            this.Qv.addItem(aq.qM[n2]);
            ++n2;
        }
        this.Qv.setSelectedIndex(0);
        this.Qw.addItem(this.pU);
        n2 = 0;
        while (n2 < aq.qM.length) {
            this.Qw.addItem(aq.qM[n2]);
            ++n2;
        }
        this.Qw.setSelectedIndex(0);
        if (this.w == 1 || this.w == 2) {
            this.BD.addItem(this.pU);
            n2 = 0;
            while (n2 < ac.jz()) {
                this.BD.addItem(((ad)n.cY().get(n2)).getNome());
                ++n2;
            }
        }
        aJ aJ2 = new aJ();
        aJ2.setPreferredSize(new Dimension(10, 25));
        this.BD.setRenderer(aJ2);
        this.BD.setMaximumRowCount(12);
        if (this.BD.getItemCount() > 0) {
            this.BD.setSelectedIndex(0);
        }
        this.Qu.addItem(this.pU);
        int n3 = 0;
        while (n3 < c.a.SR.N().size()) {
            this.Qu.addItem(((Z)c.a.SR.N().get(n3)).jp());
            ++n3;
        }
        aJ aJ3 = new aJ();
        aJ3.setPreferredSize(new Dimension(10, 25));
        this.Qu.setRenderer(aJ3);
        this.Qu.setMaximumRowCount(12);
        this.Qu.setSelectedIndex(0);
        this.mG();
    }

    private void ul() {
        if (this.ub != null) {
            this.ub.dispose();
        }
    }

    public void mH() {
        if (this.w == 1 || this.w == 4) {
            if (this.vm != null) {
                this.vm.addActionListener(new P(this));
            }
            this.QC.addChangeListener(new Q(this));
            this.QB.addChangeListener(new R(this));
        } else {
            this.uo();
        }
    }

    public void um() {
        if (this.w == 1 || this.w == 4) {
            this.Qz.setText(String.valueOf(String.valueOf(this.QB.getValue())) + " - " + String.valueOf(this.QB.uv()));
            String string = String.valueOf(this.QC.uv());
            if (this.QC.uv() == this.QC.getMaximum()) {
                string = String.valueOf(string) + "+";
            }
            this.QA.setText(String.valueOf(String.valueOf(this.QC.getValue())) + " - " + string);
        } else {
            this.un();
        }
    }

    private void un() {
        String string = String.valueOf(this.QC.uv());
        if (this.QC.uv() == this.QC.getMaximum()) {
            string = String.valueOf(string) + "+";
        }
        this.QA.setText(String.valueOf(String.valueOf(this.QC.getValue())) + " - " + string);
        aa[] aaArray = new aa[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};
        JLabel[] jLabelArray = new JLabel[]{this.QG, this.QE, this.QJ, this.QF, this.QD, this.QI, this.QH};
        int n2 = 0;
        while (n2 < jLabelArray.length) {
            jLabelArray[n2].setText(String.valueOf(String.valueOf(aaArray[n2].getValue())) + " - " + String.valueOf(aaArray[n2].uv()));
            ++n2;
        }
    }

    public void uo() {
        this.QC.addChangeListener(new S(this));
        aa[] aaArray = new aa[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};
        int n2 = 0;
        while (n2 < aaArray.length) {
            aaArray[n2].addChangeListener(new T(this));
            ++n2;
        }
        if (this.vm != null) {
            this.vm.addActionListener(new U(this));
        }
    }

    private void up() {
        aa[] aaArray = new aa[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};
        this.QC.setMinimum(16);
        this.QC.setMaximum(45);
        this.QC.setValue(16);
        this.QC.dP(45);
        int n2 = 0;
        while (n2 < aaArray.length) {
            aaArray[n2].setMinimum(1);
            aaArray[n2].setMaximum(100);
            aaArray[n2].setValue(1);
            aaArray[n2].dP(100);
            ++n2;
        }
    }

    public void mJ() {
        this.uf = new JTextField();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.Nq = new JComboBox();
        this.ur = new JLabel();
        this.Qx = new JComboBox();
        this.vx = new JLabel();
        this.QC = new aa();
        this.vw = new JLabel();
        this.Qu = new JComboBox();
        this.BD = new JComboBox();
        this.Bj = new JLabel();
        this.vz = new JLabel();
        this.Qv = new JComboBox();
        this.Qw = new JComboBox();
        this.Qy = new JComboBox();
        this.vy = new JLabel();
        this.Qs = new JCheckBox();
        this.Qt = new JCheckBox();
        this.Qq = new JCheckBox();
        this.Qr = new JCheckBox();
        this.zb = new JLabel();
        this.QA = new JLabel();
        this.QB = new aa();
        this.vm = new JButton();
        this.zc = new JLabel();
        this.Qz = new JLabel();
        this.setBackground(new Color(0, 102, 51));
        this.setLayout(new b());
        this.add((Component)this.uf, new a(40, 30, 310, -1));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(2);
        this.uh.setText("Nome:");
        this.add((Component)this.uh, new a(40, 10, 80, -1));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Posi\u00e7\u00e3o:");
        this.add((Component)this.a_, new a(40, 65, 80, -1));
        this.add((Component)this.Nq, new a(40, 85, 130, -1));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Lado:");
        this.add((Component)this.ur, new a(200, 65, 90, -1));
        this.add((Component)this.Qx, new a(200, 85, 150, -1));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(2);
        this.vx.setText("Idade:");
        this.add((Component)this.vx, new a(200, 130, 40, 17));
        this.add((Component)this.QC, new a(200, 150, 150, -1));
        this.vw.setForeground(new Color(255, 255, 255));
        this.vw.setHorizontalAlignment(2);
        this.vw.setText("Atuando no:");
        this.add((Component)this.vw, new a(570, 65, 91, -1));
        this.add((Component)this.Qu, new a(570, 85, 150, -1));
        this.add((Component)this.BD, new a(400, 85, 150, -1));
        this.Bj.setForeground(new Color(255, 255, 255));
        this.Bj.setHorizontalAlignment(2);
        this.Bj.setText("Nacionalidade:");
        this.add((Component)this.Bj, new a(400, 65, 110, -1));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(2);
        this.vz.setText("Caracter\u00edstica 2");
        this.add((Component)this.vz, new a(570, 10, 110, -1));
        this.add((Component)this.Qv, new a(400, 30, 150, -1));
        this.add((Component)this.Qw, new a(570, 30, 150, -1));
        this.add((Component)this.Qy, new a(400, 150, 150, -1));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setHorizontalAlignment(2);
        this.vy.setText("Valor:");
        this.add((Component)this.vy, new a(400, 130, 91, -1));
        this.Qs.setForeground(new Color(255, 255, 255));
        this.Qs.setText("estrela");
        this.Qs.setOpaque(false);
        this.add((Component)this.Qs, new a(580, 130, 80, -1));
        this.Qt.setForeground(new Color(255, 255, 255));
        this.Qt.setText("Top Mundial");
        this.Qt.setOpaque(false);
        this.add((Component)this.Qt, new a(670, 130, 100, -1));
        this.Qq.setForeground(new Color(255, 255, 255));
        this.Qq.setText("\u00c0 venda");
        this.Qq.setOpaque(false);
        this.add((Component)this.Qq, new a(580, 160, 80, -1));
        this.Qr.setForeground(new Color(255, 255, 255));
        this.Qr.setText("Empr\u00e9stimo");
        this.Qr.setOpaque(false);
        this.add((Component)this.Qr, new a(670, 160, 100, -1));
        this.zb.setForeground(new Color(255, 255, 255));
        this.zb.setHorizontalAlignment(2);
        this.zb.setText("For\u00e7a:");
        this.add((Component)this.zb, new a(40, 130, 60, -1));
        this.QA.setForeground(new Color(255, 255, 255));
        this.QA.setHorizontalAlignment(4);
        this.QA.setText("10");
        this.add((Component)this.QA, new a(290, 130, 60, -1));
        this.add((Component)this.QB, new a(40, 150, 140, -1));
        this.vm.setText("X");
        this.add((Component)this.vm, new a(737, 10, 50, -1));
        this.zc.setForeground(new Color(255, 255, 255));
        this.zc.setHorizontalAlignment(2);
        this.zc.setText("Caracter\u00edstica 1");
        this.add((Component)this.zc, new a(400, 10, 110, -1));
        this.Qz.setForeground(new Color(255, 255, 255));
        this.Qz.setHorizontalAlignment(4);
        this.Qz.setText("10");
        this.add((Component)this.Qz, new a(120, 130, 60, -1));
    }

    public void rS() {
        this.uf = new JTextField();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.Nq = new JComboBox();
        this.ur = new JLabel();
        this.Qx = new JComboBox();
        this.vx = new JLabel();
        this.QC = new aa();
        this.vw = new JLabel();
        this.Qu = new JComboBox();
        this.BD = new JComboBox();
        this.Bj = new JLabel();
        this.vz = new JLabel();
        this.Qv = new JComboBox();
        this.Qw = new JComboBox();
        this.Qy = new JComboBox();
        this.vy = new JLabel();
        this.Qs = new JCheckBox();
        this.Qt = new JCheckBox();
        this.Qq = new JCheckBox();
        this.Qr = new JCheckBox();
        this.QA = new JLabel();
        this.Jw = new JLabel();
        this.QN = new aa();
        this.Ei = new JLabel();
        this.QG = new JLabel();
        this.vm = new JButton();
        this.QL = new aa();
        this.Jx = new JLabel();
        this.QE = new JLabel();
        this.QQ = new aa();
        this.Jy = new JLabel();
        this.QJ = new JLabel();
        this.QM = new aa();
        this.Jz = new JLabel();
        this.QF = new JLabel();
        this.QK = new aa();
        this.JA = new JLabel();
        this.QD = new JLabel();
        this.QP = new aa();
        this.JB = new JLabel();
        this.QI = new JLabel();
        this.QO = new aa();
        this.QH = new JLabel();
        this.JC = new JLabel();
        this.setBackground(new Color(0, 102, 51));
        this.setLayout(new b());
        this.add((Component)this.uf, new a(30, 40, 310, -1));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(2);
        this.uh.setText("Nome:");
        this.add((Component)this.uh, new a(30, 20, 80, -1));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Posi\u00e7\u00e3o:");
        this.add((Component)this.a_, new a(30, 80, 80, -1));
        this.add((Component)this.Nq, new a(30, 100, 150, -1));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Lado:");
        this.add((Component)this.ur, new a(200, 80, 90, -1));
        this.add((Component)this.Qx, new a(200, 100, 150, -1));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(2);
        this.vx.setText("Idade:");
        this.add((Component)this.vx, new a(30, 130, 40, 17));
        this.add((Component)this.QC, new a(30, 150, 150, -1));
        this.vw.setForeground(new Color(255, 255, 255));
        this.vw.setHorizontalAlignment(2);
        this.vw.setText("Atuando no:");
        this.add((Component)this.vw, new a(200, 230, 91, -1));
        this.add((Component)this.Qu, new a(200, 250, 150, -1));
        this.add((Component)this.BD, new a(30, 250, 150, -1));
        this.Bj.setForeground(new Color(255, 255, 255));
        this.Bj.setHorizontalAlignment(2);
        this.Bj.setText("Nacionalidade:");
        this.add((Component)this.Bj, new a(30, 230, 110, -1));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(2);
        this.vz.setText("Caracter\u00edstica 2");
        this.add((Component)this.vz, new a(200, 180, 110, -1));
        this.add((Component)this.Qv, new a(30, 200, 150, -1));
        this.add((Component)this.Qw, new a(200, 200, 150, -1));
        this.add((Component)this.Qy, new a(200, 150, 150, -1));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setHorizontalAlignment(2);
        this.vy.setText("Valor:");
        this.add((Component)this.vy, new a(200, 130, 91, -1));
        this.Qs.setForeground(new Color(255, 255, 255));
        this.Qs.setText("estrela");
        this.Qs.setOpaque(false);
        this.add((Component)this.Qs, new a(400, 250, 70, -1));
        this.Qt.setForeground(new Color(255, 255, 255));
        this.Qt.setText("Top Mundial");
        this.Qt.setOpaque(false);
        this.add((Component)this.Qt, new a(480, 250, 100, -1));
        this.Qq.setForeground(new Color(255, 255, 255));
        this.Qq.setText("\u00c0 venda");
        this.Qq.setOpaque(false);
        this.add((Component)this.Qq, new a(580, 250, 80, -1));
        this.Qr.setForeground(new Color(255, 255, 255));
        this.Qr.setText("Empr\u00e9stimo");
        this.Qr.setOpaque(false);
        this.add((Component)this.Qr, new a(670, 250, 110, -1));
        this.QA.setForeground(new Color(255, 255, 255));
        this.QA.setHorizontalAlignment(4);
        this.QA.setText("10");
        this.add((Component)this.QA, new a(120, 130, 60, -1));
        this.Jw.setForeground(new Color(255, 255, 255));
        this.Jw.setHorizontalAlignment(2);
        this.Jw.setText("Caracter\u00edstica 1");
        this.add((Component)this.Jw, new a(30, 180, 110, -1));
        this.add((Component)this.QN, new a(400, 40, 150, -1));
        this.Ei.setForeground(new Color(255, 255, 255));
        this.Ei.setHorizontalAlignment(2);
        this.Ei.setText("Goleiro");
        this.add((Component)this.Ei, new a(400, 20, 40, 17));
        this.QG.setForeground(new Color(255, 255, 255));
        this.QG.setHorizontalAlignment(4);
        this.QG.setText("10");
        this.add((Component)this.QG, new a(490, 20, 60, -1));
        this.vm.setText("X");
        this.add((Component)this.vm, new a(740, 20, 50, -1));
        this.add((Component)this.QL, new a(570, 40, 150, -1));
        this.Jx.setForeground(new Color(255, 255, 255));
        this.Jx.setHorizontalAlignment(2);
        this.Jx.setText("Desarme");
        this.add((Component)this.Jx, new a(570, 20, 80, 20));
        this.QE.setForeground(new Color(255, 255, 255));
        this.QE.setHorizontalAlignment(4);
        this.QE.setText("10");
        this.add((Component)this.QE, new a(660, 20, 60, 10));
        this.add((Component)this.QQ, new a(400, 100, 150, -1));
        this.Jy.setForeground(new Color(255, 255, 255));
        this.Jy.setHorizontalAlignment(2);
        this.Jy.setText("Velocidade");
        this.add((Component)this.Jy, new a(400, 80, 70, 17));
        this.QJ.setForeground(new Color(255, 255, 255));
        this.QJ.setHorizontalAlignment(4);
        this.QJ.setText("10");
        this.add((Component)this.QJ, new a(490, 80, 60, -1));
        this.add((Component)this.QM, new a(570, 100, 150, -1));
        this.Jz.setForeground(new Color(255, 255, 255));
        this.Jz.setHorizontalAlignment(2);
        this.Jz.setText("Finaliza\u00e7\u00e3o");
        this.add((Component)this.Jz, new a(570, 80, 80, 20));
        this.QF.setForeground(new Color(255, 255, 255));
        this.QF.setHorizontalAlignment(4);
        this.QF.setText("10");
        this.add((Component)this.QF, new a(660, 80, 60, 10));
        this.add((Component)this.QK, new a(400, 160, 150, -1));
        this.JA.setForeground(new Color(255, 255, 255));
        this.JA.setHorizontalAlignment(2);
        this.JA.setText("Arma\u00e7\u00e3o");
        this.add((Component)this.JA, new a(400, 130, 70, 17));
        this.QD.setForeground(new Color(255, 255, 255));
        this.QD.setHorizontalAlignment(4);
        this.QD.setText("10");
        this.add((Component)this.QD, new a(490, 130, 60, -1));
        this.add((Component)this.QP, new a(570, 160, 150, -1));
        this.JB.setForeground(new Color(255, 255, 255));
        this.JB.setHorizontalAlignment(2);
        this.JB.setText("T\u00e9cnica");
        this.add((Component)this.JB, new a(570, 130, 60, 20));
        this.QI.setForeground(new Color(255, 255, 255));
        this.QI.setHorizontalAlignment(4);
        this.QI.setText("10");
        this.add((Component)this.QI, new a(660, 130, 60, 10));
        this.add((Component)this.QO, new a(400, 220, 150, -1));
        this.QH.setForeground(new Color(255, 255, 255));
        this.QH.setHorizontalAlignment(4);
        this.QH.setText("10");
        this.add((Component)this.QH, new a(490, 200, 60, -1));
        this.JC.setForeground(new Color(255, 255, 255));
        this.JC.setHorizontalAlignment(2);
        this.JC.setText("Passe");
        this.add((Component)this.JC, new a(400, 200, 50, 17));
    }

    private void uq() {
        this.uf = new JTextField();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.Nq = new JComboBox();
        this.ur = new JLabel();
        this.Qx = new JComboBox();
        this.vx = new JLabel();
        this.QC = new aa();
        this.vw = new JLabel();
        this.Qu = new JComboBox();
        this.BD = new JComboBox();
        this.Bj = new JLabel();
        this.vz = new JLabel();
        this.Qv = new JComboBox();
        this.Qw = new JComboBox();
        this.Qy = new JComboBox();
        this.vy = new JLabel();
        this.Qs = new JCheckBox();
        this.Qt = new JCheckBox();
        this.QA = new JLabel();
        this.Jw = new JLabel();
        this.QN = new aa();
        this.Ei = new JLabel();
        this.QG = new JLabel();
        this.QL = new aa();
        this.Jx = new JLabel();
        this.QE = new JLabel();
        this.QQ = new aa();
        this.Jy = new JLabel();
        this.QJ = new JLabel();
        this.QM = new aa();
        this.Jz = new JLabel();
        this.QF = new JLabel();
        this.QK = new aa();
        this.JA = new JLabel();
        this.QD = new JLabel();
        this.QP = new aa();
        this.JB = new JLabel();
        this.QI = new JLabel();
        this.QO = new aa();
        this.QH = new JLabel();
        this.JC = new JLabel();
        this.setBackground(new Color(0, 102, 51));
        this.setLayout(new b());
        this.add((Component)this.uf, new a(30, 30, 320, -1));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(2);
        this.uh.setText("Nome:");
        this.add((Component)this.uh, new a(30, 10, 80, -1));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Posi\u00e7\u00e3o:");
        this.add((Component)this.a_, new a(30, 60, 80, -1));
        this.add((Component)this.Nq, new a(30, 80, 150, -1));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Lado:");
        this.add((Component)this.ur, new a(200, 60, 90, -1));
        this.add((Component)this.Qx, new a(200, 80, 150, -1));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(2);
        this.vx.setText("Idade:");
        this.add((Component)this.vx, new a(30, 115, 40, 17));
        this.add((Component)this.QC, new a(30, 135, 150, -1));
        this.vw.setForeground(new Color(255, 255, 255));
        this.vw.setHorizontalAlignment(2);
        this.vw.setText("Atuando no:");
        this.add((Component)this.vw, new a(200, 215, 91, -1));
        this.add((Component)this.Qu, new a(200, 235, 150, -1));
        this.add((Component)this.BD, new a(30, 235, 150, -1));
        this.Bj.setForeground(new Color(255, 255, 255));
        this.Bj.setHorizontalAlignment(2);
        this.Bj.setText("Nacionalidade:");
        this.add((Component)this.Bj, new a(30, 215, 110, -1));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(2);
        this.vz.setText("Caracter\u00edstica 2");
        this.add((Component)this.vz, new a(200, 165, 110, -1));
        this.add((Component)this.Qv, new a(30, 185, 150, -1));
        this.add((Component)this.Qw, new a(200, 185, 150, -1));
        this.add((Component)this.Qy, new a(200, 130, 150, -1));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setHorizontalAlignment(2);
        this.vy.setText("Valor:");
        this.add((Component)this.vy, new a(200, 110, 91, -1));
        this.Qs.setForeground(new Color(255, 255, 255));
        this.Qs.setText("estrela");
        this.Qs.setOpaque(false);
        this.add((Component)this.Qs, new a(620, 200, 80, -1));
        this.Qt.setForeground(new Color(255, 255, 255));
        this.Qt.setText("Top Mundial");
        this.Qt.setOpaque(false);
        this.add((Component)this.Qt, new a(620, 230, 100, -1));
        this.QA.setForeground(new Color(255, 255, 255));
        this.QA.setHorizontalAlignment(4);
        this.QA.setText("10");
        this.add((Component)this.QA, new a(120, 115, 60, -1));
        this.Jw.setForeground(new Color(255, 255, 255));
        this.Jw.setHorizontalAlignment(2);
        this.Jw.setText("Caracter\u00edstica 1");
        this.add((Component)this.Jw, new a(30, 165, 110, -1));
        this.add((Component)this.QN, new a(430, 40, 150, -1));
        this.Ei.setForeground(new Color(255, 255, 255));
        this.Ei.setHorizontalAlignment(2);
        this.Ei.setText("Goleiro");
        this.add((Component)this.Ei, new a(430, 20, -1, -1));
        this.QG.setForeground(new Color(255, 255, 255));
        this.QG.setHorizontalAlignment(4);
        this.QG.setText("10");
        this.add((Component)this.QG, new a(530, 20, 50, -1));
        this.add((Component)this.QL, new a(620, 40, 150, -1));
        this.Jx.setForeground(new Color(255, 255, 255));
        this.Jx.setHorizontalAlignment(2);
        this.Jx.setText("Desarme");
        this.add((Component)this.Jx, new a(620, 20, -1, -1));
        this.QE.setForeground(new Color(255, 255, 255));
        this.QE.setHorizontalAlignment(4);
        this.QE.setText("10");
        this.add((Component)this.QE, new a(720, 20, 50, -1));
        this.add((Component)this.QQ, new a(430, 100, 150, -1));
        this.Jy.setForeground(new Color(255, 255, 255));
        this.Jy.setHorizontalAlignment(2);
        this.Jy.setText("Velocidade");
        this.add((Component)this.Jy, new a(430, 80, -1, -1));
        this.QJ.setForeground(new Color(255, 255, 255));
        this.QJ.setHorizontalAlignment(4);
        this.QJ.setText("10");
        this.add((Component)this.QJ, new a(530, 80, 50, -1));
        this.add((Component)this.QM, new a(620, 100, 150, -1));
        this.Jz.setForeground(new Color(255, 255, 255));
        this.Jz.setHorizontalAlignment(2);
        this.Jz.setText("Finaliza\u00e7\u00e3o");
        this.add((Component)this.Jz, new a(620, 80, -1, -1));
        this.QF.setForeground(new Color(255, 255, 255));
        this.QF.setHorizontalAlignment(4);
        this.QF.setText("10");
        this.add((Component)this.QF, new a(720, 80, 50, -1));
        this.add((Component)this.QK, new a(430, 160, 150, -1));
        this.JA.setForeground(new Color(255, 255, 255));
        this.JA.setHorizontalAlignment(2);
        this.JA.setText("Arma\u00e7\u00e3o");
        this.add((Component)this.JA, new a(430, 140, -1, -1));
        this.QD.setForeground(new Color(255, 255, 255));
        this.QD.setHorizontalAlignment(4);
        this.QD.setText("10");
        this.add((Component)this.QD, new a(530, 140, 50, -1));
        this.add((Component)this.QP, new a(620, 160, 150, -1));
        this.JB.setForeground(new Color(255, 255, 255));
        this.JB.setHorizontalAlignment(2);
        this.JB.setText("T\u00e9cnica");
        this.add((Component)this.JB, new a(620, 140, -1, -1));
        this.QI.setForeground(new Color(255, 255, 255));
        this.QI.setHorizontalAlignment(4);
        this.QI.setText("10");
        this.add((Component)this.QI, new a(720, 140, 50, -1));
        this.add((Component)this.QO, new a(430, 230, 150, -1));
        this.QH.setForeground(new Color(255, 255, 255));
        this.QH.setHorizontalAlignment(4);
        this.QH.setText("10");
        this.add((Component)this.QH, new a(530, 210, 50, -1));
        this.JC.setForeground(new Color(255, 255, 255));
        this.JC.setHorizontalAlignment(2);
        this.JC.setText("Passe");
        this.add((Component)this.JC, new a(430, 210, -1, -1));
    }

    private void ur() {
        this.uf = new JTextField();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.Nq = new JComboBox();
        this.ur = new JLabel();
        this.Qx = new JComboBox();
        this.vx = new JLabel();
        this.QC = new aa();
        this.vw = new JLabel();
        this.Qu = new JComboBox();
        this.BD = new JComboBox();
        this.Bj = new JLabel();
        this.vz = new JLabel();
        this.Qv = new JComboBox();
        this.Qw = new JComboBox();
        this.Qy = new JComboBox();
        this.vy = new JLabel();
        this.Qs = new JCheckBox();
        this.Qt = new JCheckBox();
        this.zb = new JLabel();
        this.QA = new JLabel();
        this.QB = new aa();
        this.zc = new JLabel();
        this.Qz = new JLabel();
        this.setBackground(new Color(0, 102, 51));
        this.setLayout(new b());
        this.add((Component)this.uf, new a(40, 50, 310, -1));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(2);
        this.uh.setText("Nome:");
        this.add((Component)this.uh, new a(40, 30, 80, -1));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Posi\u00e7\u00e3o:");
        this.add((Component)this.a_, new a(40, 85, 80, -1));
        this.add((Component)this.Nq, new a(40, 105, 130, -1));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Lado:");
        this.add((Component)this.ur, new a(200, 85, 90, -1));
        this.add((Component)this.Qx, new a(200, 105, 150, -1));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(2);
        this.vx.setText("Idade:");
        this.add((Component)this.vx, new a(200, 145, 40, 17));
        this.add((Component)this.QC, new a(200, 170, 150, -1));
        this.vw.setForeground(new Color(255, 255, 255));
        this.vw.setHorizontalAlignment(2);
        this.vw.setText("Atuando no:");
        this.add((Component)this.vw, new a(610, 85, 91, -1));
        this.add((Component)this.Qu, new a(610, 105, 150, -1));
        this.add((Component)this.BD, new a(420, 105, 150, -1));
        this.Bj.setForeground(new Color(255, 255, 255));
        this.Bj.setHorizontalAlignment(2);
        this.Bj.setText("Nacionalidade:");
        this.add((Component)this.Bj, new a(420, 85, 110, -1));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(2);
        this.vz.setText("Caracter\u00edstica 2");
        this.add((Component)this.vz, new a(610, 30, 110, -1));
        this.add((Component)this.Qv, new a(420, 50, 150, -1));
        this.add((Component)this.Qw, new a(610, 50, 150, -1));
        this.add((Component)this.Qy, new a(420, 165, 150, -1));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setHorizontalAlignment(2);
        this.vy.setText("Valor:");
        this.add((Component)this.vy, new a(420, 145, 91, -1));
        this.Qs.setForeground(new Color(255, 255, 255));
        this.Qs.setText("estrela");
        this.Qs.setOpaque(false);
        this.add((Component)this.Qs, new a(610, 165, 80, -1));
        this.Qt.setForeground(new Color(255, 255, 255));
        this.Qt.setText("Top Mundial");
        this.Qt.setOpaque(false);
        this.add((Component)this.Qt, new a(700, 165, 100, -1));
        this.zb.setForeground(new Color(255, 255, 255));
        this.zb.setHorizontalAlignment(2);
        this.zb.setText("For\u00e7a:");
        this.add((Component)this.zb, new a(40, 145, 60, -1));
        this.QA.setForeground(new Color(255, 255, 255));
        this.QA.setHorizontalAlignment(4);
        this.QA.setText("10");
        this.add((Component)this.QA, new a(290, 145, 60, -1));
        this.add((Component)this.QB, new a(40, 170, 140, -1));
        this.zc.setForeground(new Color(255, 255, 255));
        this.zc.setHorizontalAlignment(2);
        this.zc.setText("Caracter\u00edstica 1");
        this.add((Component)this.zc, new a(420, 30, 110, -1));
        this.Qz.setForeground(new Color(255, 255, 255));
        this.Qz.setHorizontalAlignment(4);
        this.Qz.setText("10");
        this.add((Component)this.Qz, new a(120, 145, 60, -1));
    }

    static /* synthetic */ void a(O o2) {
        o2.ul();
    }
}

