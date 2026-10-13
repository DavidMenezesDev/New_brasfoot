/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.eg;
import best.C;
import best.F;
import best.I;
import best.aq;
import best.at;
import components.a;
import components.b;
import components.n;
import components.o;
import components.p;
import components.q;
import components.r;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class m
extends JPanel {
    eg Oy;
    private JLabel Oz;
    private JLabel OA;
    private JButton vb;
    private JButton vc;
    private JButton GP;
    private JButton OB;
    private JButton OC;
    private JToolBar.Separator OD;
    private JToolBar.Separator OE;
    private JToolBar.Separator OF;
    private JToolBar.Separator OG;
    private JToolBar Iv;
    private JLabel OH;
    private JLabel OI;
    private JLabel OJ;
    private JLabel OK;
    private JLabel OL;
    private JLabel OM;
    private JLabel ON;
    private JLabel OO;
    private JLabel OP;
    private JLabel yA;
    private JLabel yB;
    private JLabel yE;
    private JLabel OQ;
    private JLabel OR;
    private JLabel OS;
    private JLabel OT;
    private JLabel OU;
    private JLabel OV;
    private JLabel OW;
    private JLabel OX;
    private JLabel uF;
    private JLabel Ec;
    private JLabel OY;
    private JLabel OZ;
    private JLabel Pa;
    private JLabel Pb;

    public m(eg eg2) {
        this.Oy = eg2;
        this.mJ();
        this.mH();
        this.GP.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/sell1d.png")));
        this.vc.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/contractd.png")));
        this.OB.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/retiredisabled.png")));
        this.vb.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/sell2d.png")));
        this.GP.setForeground(new Color(123, 134, 222));
        this.setBackground(eg2.qp().kB());
        this.Iv.setBackground(eg2.qp().kB());
        this.Iv.setBorder(BorderFactory.createLineBorder(eg2.qp().kB()));
        Component[] componentArray = this.getComponents();
        int n2 = componentArray.length;
        int n3 = 0;
        while (n3 < n2) {
            Component component = componentArray[n3];
            if (component instanceof JLabel) {
                component.setForeground(eg2.qp().kC());
            }
            ++n3;
        }
        this.uF.setOpaque(true);
        this.uF.setBackground(eg2.qp().kC());
        this.uF.setForeground(eg2.qp().kB());
        this.OM.setOpaque(true);
        this.OM.setBackground(eg2.qp().kC());
        this.OM.setForeground(eg2.qp().kB());
        this.OZ.setFont(new Font("Tahoma", 0, 11));
        this.OK.setFont(new Font("Tahoma", 0, 11));
        this.OL.setFont(new Font("Tahoma", 0, 11));
        this.OT.setFont(new Font("Tahoma", 0, 11));
        this.yB.setFont(new Font("Tahoma", 0, 11));
        this.yA.setFont(new Font("Tahoma", 0, 11));
        this.Pb.setFont(new Font("Tahoma", 0, 11));
        this.OY.setFont(new Font("Tahoma", 0, 11));
        this.OS.setFont(new Font("Tahoma", 0, 11));
        this.OP.setFont(new Font("Tahoma", 0, 11));
        this.OJ.setFont(new Font("Tahoma", 0, 11));
        this.OX.setFont(new Font("Tahoma", 0, 11));
        this.OQ.setFont(new Font("Tahoma", 0, 11));
        this.ON.setFont(new Font("Tahoma", 0, 11));
        this.OH.setFont(new Font("Tahoma", 0, 11));
        this.OV.setFont(new Font("Tahoma", 0, 11));
        this.OR.setFont(new Font("Tahoma", 0, 11));
        this.OO.setFont(new Font("Tahoma", 0, 11));
        this.OI.setFont(new Font("Tahoma", 0, 11));
        this.OW.setFont(new Font("Tahoma", 0, 11));
    }

    public void oJ() {
        this.setBackground(this.Oy.qp().kB());
        this.Iv.setBorder(BorderFactory.createLineBorder(this.Oy.qp().kB()));
        Component[] componentArray = this.getComponents();
        int n2 = componentArray.length;
        int n3 = 0;
        while (n3 < n2) {
            Component component = componentArray[n3];
            if (component instanceof JLabel) {
                component.setForeground(this.Oy.qp().kC());
            }
            ++n3;
        }
        this.uF.setOpaque(true);
        this.uF.setBackground(this.Oy.qp().kC());
        this.uF.setForeground(this.Oy.qp().kB());
        this.OM.setOpaque(true);
        this.OM.setBackground(this.Oy.qp().kC());
        this.OM.setForeground(this.Oy.qp().kB());
    }

    public void a(F f2, I i2, at at2, boolean bl2) {
        Object object;
        Object object2;
        String string = f2.fQ();
        String string2 = "Contrato at\u00e9:";
        if (f2.gl().booleanValue()) {
            string2 = "Emprestado at\u00e9:";
        }
        String string3 = "";
        if (f2.fP() && f2.fo() > ((best.a)c.a.SR.R().get(c.a.SR.J())).a().getTime().getTime()) {
            string3 = "Fim contus\u00e3o: " + best.a.a(f2.fo());
        }
        String string4 = "";
        if (i2 != null && at2 != null) {
            object2 = f2.e(i2.hy());
            if (object2 == null) {
                object2 = new int[2];
            }
            if (f2.c(at2)) {
                object = "";
                if (object2[0] >= 3) {
                    object = "3 cart\u00f5es amarelos";
                }
                if (object2[1] == 1) {
                    object = "1 jogo";
                } else if (object2[1] > 1) {
                    object = String.valueOf(Integer.toString(object2[1])) + " jogos";
                }
                string4 = "Suspenso " + (String)object;
            }
        }
        if (bl2) {
            string2 = "";
            string = "";
        }
        object2 = new ImageIcon(this.getClass().getResource("/aflags/" + f2.getPais() + ".png"));
        this.uF.setIcon((Icon)object2);
        this.uF.setText(f2.getNome());
        this.OT.setText(String.valueOf(aq.rH[f2.getPosicao()]) + " - Lado " + aq.rL[f2.getLado()] + " - " + Integer.toString(f2.getIdade()) + " anos");
        this.OM.setText("F:" + Integer.toString(f2.fi()));
        if (c.a.SR.isHabilidadeIndividual()) {
            this.OM.setVisible(false);
        }
        object = new int[6];
        object = f2.gw();
        this.OQ.setText(Integer.toString((int)object[0]));
        this.OS.setText(Integer.toString(f2.gu()));
        this.OR.setText(Integer.toString(f2.i(at2)));
        this.ON.setText(Integer.toString((int)object[1]));
        this.OP.setText(Integer.toString(f2.gt()));
        this.OO.setText(Integer.toString(f2.gA()));
        this.OH.setText(Integer.toString((int)object[5]));
        this.OI.setText(Integer.toString(f2.j(at2)));
        this.OJ.setText(Integer.toString(f2.gs()));
        this.OX.setText(f2.gn());
        this.OV.setText(f2.gx());
        this.OW.setText(f2.k(at2));
        this.Pb.setText(C.c(f2.fk()));
        this.OY.setText(C.c(f2.fj()));
        this.yA.setText(String.valueOf(string3) + " " + string4);
        this.yB.setText(String.valueOf(string2) + " " + string);
    }

    private void mH() {
        this.vb.addActionListener(new n(this));
        this.OC.addActionListener(new o(this));
        this.OB.addActionListener(new p(this));
        this.vc.addActionListener(new q(this));
        this.GP.addActionListener(new r(this));
    }

    public void g(int n2, boolean bl2) {
        if (n2 == 1) {
            this.vb.setVisible(bl2);
        }
    }

    public void h(int n2, boolean bl2) {
        if (n2 == 1) {
            this.vb.setEnabled(bl2);
        } else if (n2 == 2) {
            this.vc.setEnabled(bl2);
        } else if (n2 == 3) {
            this.GP.setEnabled(bl2);
        } else if (n2 == 4) {
            this.OB.setEnabled(bl2);
        } else if (n2 == 5) {
            this.OC.setEnabled(bl2);
        }
    }

    private void mJ() {
        this.Iv = new JToolBar();
        this.GP = new JButton();
        this.OD = new JToolBar.Separator();
        this.vc = new JButton();
        this.OE = new JToolBar.Separator();
        this.OB = new JButton();
        this.OF = new JToolBar.Separator();
        this.vb = new JButton();
        this.OG = new JToolBar.Separator();
        this.OC = new JButton();
        this.uF = new JLabel();
        this.OM = new JLabel();
        this.OT = new JLabel();
        this.yB = new JLabel();
        this.OA = new JLabel();
        this.Oz = new JLabel();
        this.OZ = new JLabel();
        this.OU = new JLabel();
        this.Pa = new JLabel();
        this.Ec = new JLabel();
        this.yA = new JLabel();
        this.yE = new JLabel();
        this.OX = new JLabel();
        this.OJ = new JLabel();
        this.OS = new JLabel();
        this.OP = new JLabel();
        this.OV = new JLabel();
        this.OH = new JLabel();
        this.ON = new JLabel();
        this.OQ = new JLabel();
        this.Pb = new JLabel();
        this.OY = new JLabel();
        this.OK = new JLabel();
        this.OL = new JLabel();
        this.OW = new JLabel();
        this.OI = new JLabel();
        this.OO = new JLabel();
        this.OR = new JLabel();
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(240, 110));
        this.setLayout(new b());
        this.Iv.setBackground(new Color(0, 0, 0));
        this.Iv.setFloatable(false);
        this.Iv.setRollover(true);
        this.Iv.setFont(new Font("Tahoma", 0, 12));
        this.Iv.setOpaque(false);
        this.Iv.setPreferredSize(new Dimension(122, 20));
        this.GP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/sell1.png")));
        this.GP.setToolTipText("Vender");
        this.GP.setBorderPainted(false);
        this.GP.setFocusable(false);
        this.GP.setHorizontalTextPosition(0);
        this.GP.setOpaque(false);
        this.GP.setVerticalTextPosition(3);
        this.Iv.add(this.GP);
        this.Iv.add(this.OD);
        this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/contract.png")));
        this.vc.setToolTipText("Contrato");
        this.vc.setBorderPainted(false);
        this.vc.setFocusable(false);
        this.vc.setHorizontalTextPosition(0);
        this.vc.setOpaque(false);
        this.vc.setVerticalTextPosition(3);
        this.Iv.add(this.vc);
        this.OE.setAutoscrolls(true);
        this.Iv.add(this.OE);
        this.OB.setIcon(new ImageIcon(this.getClass().getResource("/aicons/retire.png")));
        this.OB.setToolTipText("Aposentar");
        this.OB.setBorderPainted(false);
        this.OB.setFocusable(false);
        this.OB.setHorizontalTextPosition(0);
        this.OB.setMaximumSize(new Dimension(31, 31));
        this.OB.setOpaque(false);
        this.OB.setRequestFocusEnabled(false);
        this.OB.setVerticalTextPosition(3);
        this.Iv.add(this.OB);
        this.Iv.add(this.OF);
        this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/sell2.png")));
        this.vb.setToolTipText("Retirar da Venda");
        this.vb.setBorderPainted(false);
        this.vb.setFocusable(false);
        this.vb.setHorizontalTextPosition(0);
        this.vb.setMaximumSize(new Dimension(31, 31));
        this.vb.setMinimumSize(new Dimension(31, 31));
        this.vb.setOpaque(false);
        this.vb.setPreferredSize(new Dimension(31, 31));
        this.vb.setVerticalTextPosition(3);
        this.Iv.add(this.vb);
        this.Iv.add(this.OG);
        this.OC.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon22.png")));
        this.OC.setToolTipText("Estat\u00edsticas");
        this.OC.setBorderPainted(false);
        this.OC.setFocusable(false);
        this.OC.setHorizontalTextPosition(0);
        this.OC.setMaximumSize(new Dimension(31, 31));
        this.OC.setMinimumSize(new Dimension(31, 31));
        this.OC.setOpaque(false);
        this.OC.setPreferredSize(new Dimension(31, 31));
        this.OC.setVerticalTextPosition(3);
        this.Iv.add(this.OC);
        this.add((Component)this.Iv, new a(10, 30, 270, 28));
        this.uF.setFont(new Font("Tahoma", 1, 12));
        this.uF.setText("Jo\u00e3o Silva Clemntino Abade");
        this.add((Component)this.uF, new a(10, 5, 220, 20));
        this.OM.setFont(new Font("Tahoma", 1, 12));
        this.OM.setText("F:100");
        this.add((Component)this.OM, new a(230, 5, 40, 20));
        this.OT.setFont(new Font("Tahoma", 0, 12));
        this.OT.setText("Meia - Lado Direito - 32 anos");
        this.add((Component)this.OT, new a(10, 70, 260, -1));
        this.yB.setHorizontalAlignment(2);
        this.yB.setText("Infor temporada");
        this.add((Component)this.yB, new a(10, 90, 260, -1));
        this.OA.setFont(new Font("Tahoma", 1, 11));
        this.OA.setHorizontalAlignment(4);
        this.OA.setText("Gols:");
        this.add((Component)this.OA, new a(0, 185, 80, -1));
        this.Oz.setFont(new Font("Tahoma", 1, 11));
        this.Oz.setHorizontalAlignment(4);
        this.Oz.setText("Assist\u00eancias:");
        this.add((Component)this.Oz, new a(0, 200, 80, -1));
        this.OZ.setText("Temporada");
        this.add((Component)this.OZ, new a(70, 155, -1, -1));
        this.OU.setFont(new Font("Tahoma", 1, 11));
        this.OU.setHorizontalAlignment(4);
        this.OU.setText("Nota M\u00e9dia:");
        this.add((Component)this.OU, new a(0, 215, 80, -1));
        this.Pa.setFont(new Font("Tahoma", 1, 11));
        this.Pa.setHorizontalAlignment(4);
        this.Pa.setText("Valor:");
        this.add((Component)this.Pa, new a(5, 130, 40, -1));
        this.Ec.setFont(new Font("Tahoma", 1, 11));
        this.Ec.setHorizontalAlignment(4);
        this.Ec.setText("Sal\u00e1rio:");
        this.add((Component)this.Ec, new a(145, 130, 50, -1));
        this.yA.setHorizontalAlignment(2);
        this.yA.setText("Infor temporada");
        this.add((Component)this.yA, new a(10, 110, 260, -1));
        this.yE.setFont(new Font("Tahoma", 1, 11));
        this.yE.setHorizontalAlignment(4);
        this.yE.setText("Jogos:");
        this.yE.setPreferredSize(new Dimension(80, 14));
        this.add((Component)this.yE, new a(0, 170, 80, 15));
        this.OX.setText("0");
        this.add((Component)this.OX, new a(100, 215, 40, -1));
        this.OJ.setText("0");
        this.add((Component)this.OJ, new a(100, 200, 40, -1));
        this.OS.setText("0");
        this.add((Component)this.OS, new a(100, 170, 40, -1));
        this.OP.setText("0");
        this.add((Component)this.OP, new a(100, 185, 40, -1));
        this.OV.setText("0");
        this.add((Component)this.OV, new a(160, 215, 30, -1));
        this.OH.setText("0");
        this.add((Component)this.OH, new a(160, 200, 30, -1));
        this.ON.setText("0");
        this.add((Component)this.ON, new a(160, 185, 30, -1));
        this.OQ.setText("0");
        this.add((Component)this.OQ, new a(160, 170, 30, -1));
        this.Pb.setText("jLabel24");
        this.add((Component)this.Pb, new a(50, 130, 100, -1));
        this.OY.setText("jLabel30");
        this.add((Component)this.OY, new a(200, 130, 80, -1));
        this.OK.setText("Carreira");
        this.add((Component)this.OK, new a(140, 155, -1, -1));
        this.OL.setText("Competi\u00e7\u00e3o atual");
        this.add((Component)this.OL, new a(190, 155, -1, -1));
        this.OW.setText("0");
        this.add((Component)this.OW, new a(220, 215, 30, -1));
        this.OI.setText("0");
        this.add((Component)this.OI, new a(220, 200, 30, -1));
        this.OO.setText("0");
        this.add((Component)this.OO, new a(220, 185, 30, -1));
        this.OR.setText("0");
        this.add((Component)this.OR, new a(220, 170, 30, -1));
    }
}

