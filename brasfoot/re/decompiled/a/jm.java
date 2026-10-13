/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jn;
import a.jo;
import best.C;
import best.F;
import best.ah;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class jm
extends JPanel {
    private F uz = null;
    private ah Nu = null;
    private static boolean Nv = false;
    private JDialog ub;
    private int Nw = 0;
    private boolean Nx = false;
    private JButton vb;
    private JButton vc;
    private JLabel ug;
    private JPanel vd;
    private JPanel wf;
    private JLabel MN;
    private JLabel MO;
    private JLabel uu;

    public jm(JDialog jDialog, F f2, ah ah2, int n2, boolean bl2) {
        this.Nw = n2;
        this.ub = jDialog;
        Nv = false;
        this.Nx = bl2;
        this.uz = f2;
        this.Nu = ah2;
        this.mJ();
        this.ag(bl2);
        this.mH();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 2));
    }

    public void mH() {
        this.vb.addActionListener(new jn(this));
        this.vc.addActionListener(new jo(this));
    }

    private void qX() {
        if (!this.Nx) {
            this.uz.a(this.Nu, this.Nw, false, false, false);
        } else {
            this.uz.q(this.Nu);
        }
        Nv = true;
        this.ub.dispose();
    }

    private void ag(boolean bl2) {
        int[] nArray = new int[6];
        this.MO.setText("<html><b>" + this.uz.getNome() + " - " + aq.rI[this.uz.getPosicao()] + "</b></html>");
        this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + this.uz.getPais() + ".png")));
        this.uu.setText(String.valueOf(this.Nu.getNome()) + " oferece: " + C.c(this.Nw));
        this.uu.setIcon(this.Nu.kU());
        if (bl2) {
            this.ug.setText("Proposta de empr\u00e9stimo");
            this.uu.setText(String.valueOf(this.Nu.getNome()) + " quer emprestado:");
            this.vb.setText("Aceitar");
        }
        nArray = this.uz.gw();
        String string = "";
        if (this.uz.fP() && this.uz.fo() > ((best.a)a.SR.R().get(a.SR.J())).a().getTime().getTime()) {
            string = "Fim contus\u00e3o: " + best.a.a(this.uz.fo());
        }
        String string2 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;" + Integer.toString(this.uz.fi()) + "&nbsp;&nbsp;&nbsp;";
        if (a.SR.isHabilidadeIndividual()) {
            string2 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\"><b>Gol:</b>" + Integer.toString(this.uz.gK()) + " <b>Des:</b>" + Integer.toString(this.uz.gN()) + " <b>Arm:</b>" + Integer.toString(this.uz.gO()) + " <b>Fin:</b>" + Integer.toString(this.uz.gP()) + "<br><br><b>Vel:</b>" + Integer.toString(this.uz.gJ()) + " <b>Tec:</b>" + Integer.toString(this.uz.gL()) + " <b>Pas:</b>" + Integer.toString(this.uz.gM()) + "&nbsp;&nbsp;&nbsp;";
        }
        String string3 = String.valueOf(string2) + "<br><br><b>Idade:</b>" + Integer.toString(this.uz.getIdade()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n" + "<b>Jogos:" + "</b>&nbsp;" + Integer.toString(nArray[0]) + "&nbsp;&nbsp;&nbsp;" + "<b>Gols:" + "</b>" + Integer.toString(nArray[1]) + "&nbsp;&nbsp;&nbsp;" + "<b>" + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Valor:" + "</b>&nbsp;" + C.c(this.uz.fk()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>" + "Sal\u00e1rio:" + "</b>&nbsp;" + C.c(this.uz.fj()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + aq.qM[this.uz.getCr1()] + "/" + aq.qM[this.uz.getCr2()] + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + string + "<b><br>\n</p>\n</body></html>\n";
        this.MN.setText(string3);
    }

    private void mJ() {
        this.vd = new JPanel();
        this.wf = new JPanel();
        this.MO = new JLabel();
        this.MN = new JLabel();
        this.ug = new JLabel();
        this.uu = new JLabel();
        this.vb = new JButton();
        this.vc = new JButton();
        this.setBackground(new Color(42, 64, 29));
        this.vd.setBackground(new Color(84, 127, 59));
        this.MO.setFont(new Font("Tahoma", 0, 12));
        this.MO.setHorizontalAlignment(2);
        this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
        this.MO.setText("Marquinhos Paran\u00e1 - M");
        this.MN.setFont(new Font("Tahoma", 0, 12));
        this.MN.setText("<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Idade:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>Jogos:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Gols:</b>23&nbsp;&nbsp;&nbsp;<b>Cart\u00f5es:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:</b>&nbsp;5 milh\u00f5es 300 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Sal\u00e1rio:</b>&nbsp; 230 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Marca\u00e7\u00e3o/desarme<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Contrato at\u00e9:</b>&nbsp; 20/12/2015<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>suspenso<br>\n</p>\n</body></html>\n");
        this.MN.setVerticalAlignment(1);
        GroupLayout groupLayout = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.MN, -1, 325, Short.MAX_VALUE).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addComponent(this.MO, -1, -1, Short.MAX_VALUE).addGap(25, 25, 25)))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.MO).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.MN).addGap(16, 16, 16)));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Oferta de compra");
        this.uu.setForeground(new Color(255, 255, 255));
        this.uu.setText("quer comprar o jogado:");
        this.vb.setText("Vender");
        this.vc.setText("Recusar proposta");
        GroupLayout groupLayout2 = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.wf, -1, -1, Short.MAX_VALUE).addComponent(this.ug, -1, -1, Short.MAX_VALUE).addComponent(this.uu, -1, -1, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.vb, -2, 144, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vc, -2, 145, -2))).addContainerGap(15, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.uu).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.wf, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vb).addComponent(this.vc)).addContainerGap()));
        GroupLayout groupLayout3 = new GroupLayout(this);
        this.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addContainerGap()));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addContainerGap()));
    }

    public static boolean sO() {
        return Nv;
    }

    static /* synthetic */ void a(jm jm2) {
        jm2.qX();
    }

    static /* synthetic */ JDialog b(jm jm2) {
        return jm2.ub;
    }
}

