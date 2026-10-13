/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cl;
import a.cr;
import a.cs;
import a.ct;
import best.B;
import best.C;
import best.ah;
import best.aq;
import best.v;
import c.a;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;

public class cq
extends JPanel {
    private JDialog ub;
    private cl Cn = null;
    private v dH;
    private ah zu = null;
    private int[] Co = new int[]{18000, 80000, 9000, 700};
    private int[] Cp = new int[4];
    private int[] Cq = new int[4];
    private int[] Cr = new int[4];
    private boolean Cs = true;
    private int Ct = 0;
    private Calendar dI = Calendar.getInstance();
    private JButton ud;
    private JButton Cu;
    private JButton Cv;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JLabel vx;
    private JPanel vd;
    private JLabel Cw;
    private JLabel Cx;
    private JLabel Cy;
    private JLabel Cz;
    private JLabel zh;
    private JSpinner CA;
    private JSpinner CB;
    private JSpinner CC;
    private JSpinner CD;

    public cq(JDialog jDialog, v v2, ah ah2, cl cl2) {
        this.ub = jDialog;
        this.dH = v2;
        this.zu = ah2;
        this.Cn = cl2;
        if (a.SR.H() >= 2) {
            this.Co = aq.pa[1];
        } else if (a.SR.H() >= 6) {
            this.Co = aq.pa[2];
        } else if (a.SR.H() >= 10) {
            this.Co = aq.pa[3];
        }
        this.mJ();
        this.mH();
        this.Cq = v2.dT();
        JSpinner[] jSpinnerArray = new JSpinner[]{this.CA, this.CB, this.CC, this.CD};
        int n2 = 0;
        while (n2 < 4) {
            this.Cp[n2] = this.Co[n2] - this.Cq[n2];
            this.a(jSpinnerArray[n2], this.Cp[n2]);
            ++n2;
        }
        String[] stringArray = new String[]{"Geral", "Arquibancada", "Cadeira", "Camarote"};
        JLabel[] jLabelArray = new JLabel[]{this.uh, this.ur, this.a_, this.us};
        JLabel[] jLabelArray2 = new JLabel[]{this.Cw, this.Cx, this.Cy, this.Cz};
        int n3 = 0;
        while (n3 < 4) {
            jLabelArray[n3].setText(String.valueOf(stringArray[n3]) + "  (atual:" + Integer.toString(this.Cq[n3]) + ")");
            jLabelArray2[n3].setText("M\u00e1ximo mais: " + Integer.toString(this.Cp[n3]));
            ++n3;
        }
        this.Cv.setVisible(false);
        this.zh.setText("");
    }

    private void a(JSpinner jSpinner, int n2) {
        if (n2 <= 0) {
            jSpinner.setEnabled(false);
            jSpinner.setValue(0);
        } else {
            jSpinner.setModel(new SpinnerNumberModel(0, 0, n2, 1));
        }
    }

    public void mH() {
        this.ud.addActionListener(new cr(this));
        this.Cu.addActionListener(new cs(this));
        this.Cv.addActionListener(new ct(this));
    }

    private boolean oH() {
        this.Ct = 0;
        this.Cv.setVisible(false);
        int[] nArray = new int[]{(Integer)this.CA.getValue(), (Integer)this.CB.getValue(), (Integer)this.CC.getValue(), (Integer)this.CD.getValue()};
        this.Cr = nArray;
        if (this.Cr[0] + this.Cr[1] + this.Cr[2] + this.Cr[3] == 0) {
            return false;
        }
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.Cr.length) {
            this.Ct += this.I(n3, this.Cr[n3]);
            n2 += this.Cr[n3];
            ++n3;
        }
        this.Ct += 100000;
        n3 = this.cZ(n2);
        Calendar calendar = ((best.a)a.SR.R().get(a.SR.J())).a();
        this.dI.set(calendar.get(1), calendar.get(2), calendar.get(5));
        this.dI.add(5, n3);
        DateFormat dateFormat = DateFormat.getDateInstance();
        String string = dateFormat.format(this.dI.getTime());
        this.zh.setText("<html> Custo da obra: " + C.c(this.Ct) + "<br>Previs\u00e3o de t\u00e9rmino: " + string);
        this.Cv.setVisible(true);
        return true;
    }

    private void oI() {
        if (this.zu.kb() < (long)this.Ct) {
            JOptionPane.showMessageDialog(this.ub, "Sem dinheiro para essa expans\u00e3o", "Expans\u00e3o", 2);
        } else {
            B b2 = new B();
            b2.a(this.dH);
            b2.c(this.dI);
            b2.c(this.Cr);
            a.SR.bw().add(b2);
            this.zu.w(this.Ct, 7);
            this.ub.dispose();
            this.Cn.oB();
        }
    }

    private int cZ(int n2) {
        if (n2 < 1000) {
            return 15;
        }
        if (n2 < 10000) {
            return 20;
        }
        if (n2 < 30000) {
            return 30;
        }
        return 40;
    }

    private int I(int n2, int n3) {
        int[][] nArrayArray = new int[][]{{80, 160, 240, 500, 700}, {120, 380, 640, 700, 1400}, {300, 600, 750, 800, 1200}, {1500, 3500, 4000, 6000, 6400}};
        boolean bl2 = false;
        int[][] nArrayArray2 = new int[][]{{1000, 2500, 3500, 10000, 18000}, {5000, 15000, 30000, 60000, 80000}, {1000, 2000, 3000, 5000, 9000}, {100, 200, 500, 600, 700}};
        int n4 = this.Cq[n2] + n3;
        int n5 = 4;
        int n6 = 0;
        while (n6 < nArrayArray2[n2].length) {
            if (n4 <= nArrayArray2[n2][n6]) {
                n5 = n6;
                break;
            }
            ++n6;
        }
        return nArrayArray[n2][n5] * n3;
    }

    private void mJ() {
        this.ug = new JLabel();
        this.vd = new JPanel();
        this.CC = new JSpinner();
        this.CA = new JSpinner();
        this.CB = new JSpinner();
        this.CD = new JSpinner();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.vx = new JLabel();
        this.Cw = new JLabel();
        this.Cy = new JLabel();
        this.Cx = new JLabel();
        this.Cz = new JLabel();
        this.zh = new JLabel();
        this.Cu = new JButton();
        this.ud = new JButton();
        this.Cv = new JButton();
        this.setBackground(new Color(42, 64, 29));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Expans\u00e3o do est\u00e1dio");
        this.vd.setBackground(new Color(204, 204, 204));
        this.vx.setFont(new Font("Tahoma", 1, 11));
        this.vx.setHorizontalAlignment(0);
        this.vx.setText("Digite o n\u00famero de lugares para construir:");
        this.vx.setToolTipText("");
        this.zh.setForeground(new Color(0, 102, 0));
        this.zh.setHorizontalAlignment(0);
        this.zh.setText("Custo total:");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Cw, -1, -1, Short.MAX_VALUE).addComponent(this.Cx, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.CA, -2, 104, -2).addGap(0, 64, Short.MAX_VALUE)).addComponent(this.uh, -1, -1, Short.MAX_VALUE).addComponent(this.ur, -1, -1, Short.MAX_VALUE)).addGap(18, 18, 18)).addGroup(groupLayout.createSequentialGroup().addComponent(this.CB, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE))).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(this.CC, -2, 104, -2).addGap(62, 62, 62)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Cz, -1, -1, Short.MAX_VALUE).addComponent(this.a_, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.CD, -2, 104, -2).addGap(0, 0, Short.MAX_VALUE)).addComponent(this.us, -1, -1, Short.MAX_VALUE)).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addComponent(this.Cy, -1, -1, Short.MAX_VALUE).addContainerGap()))).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zh, -1, -1, Short.MAX_VALUE).addComponent(this.vx, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE)).addContainerGap()))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.vx).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.a_).addComponent(this.uh)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.CC, -2, -1, -2).addComponent(this.CA, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Cw).addComponent(this.Cy)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ur).addComponent(this.us)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.CB, -2, -1, -2).addComponent(this.CD, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Cx).addComponent(this.Cz)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE).addComponent(this.zh, -2, 36, -2)));
        this.Cu.setText("Pedir Or\u00e7amento");
        this.ud.setText("X");
        this.Cv.setText("Iniciar constru\u00e7\u00e3o");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(84, 84, 84).addComponent(this.ug, -2, 245, -2).addGap(18, 18, 18).addComponent(this.ud, -2, 59, -2).addContainerGap(30, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.vd, -2, -1, -2).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Cv, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Cu, -2, 160, -2))).addGap(34, 34, 34)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(13, 13, 13).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ud, -2, 27, -2).addComponent(this.ug, -2, 36, -2)).addGap(18, 18, 18).addComponent(this.vd, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Cv).addComponent(this.Cu)).addContainerGap(32, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(cq cq2) {
        return cq2.ub;
    }

    static /* synthetic */ boolean b(cq cq2) {
        return cq2.oH();
    }

    static /* synthetic */ void c(cq cq2) {
        cq2.oI();
    }
}

