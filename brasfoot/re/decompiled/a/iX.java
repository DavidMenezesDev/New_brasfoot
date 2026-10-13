/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iY;
import a.iZ;
import a.ja;
import a.jb;
import best.C;
import best.F;
import best.ah;
import best.aq;
import components.a;
import components.an;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class iX
extends JPanel {
    private JDialog ub;
    private an Nc;
    private F uz;
    private ArrayList Nd;
    private ArrayList Ne;
    private int index = 0;
    private JButton zK;
    private JButton Nf;
    private JButton Ng;
    private JTextField uE;
    private JLabel ug;
    private JPanel vd;
    private JPanel we;
    private JPanel wf;
    private JLabel MN;
    private JLabel MO;
    private JLabel Nh;
    private JLabel uH;
    private JLabel zO;
    private JLabel zP;
    private JLabel Ni;

    public iX(JDialog jDialog, an an2) {
        this.ub = jDialog;
        this.Nc = an2;
        this.uz = an2.x();
        this.mJ();
        this.mK();
        this.mH();
        if (an2.vc()) {
            this.sJ();
        } else {
            this.sK();
        }
        this.uH.setText("");
    }

    private void sJ() {
        this.uE.setVisible(false);
        this.Nf.setVisible(false);
        this.Ng.setVisible(false);
        this.uH.setVisible(false);
        this.zP.setVisible(false);
        if (this.Nc.ve() != null) {
            this.Ni.setIcon(this.Nc.ve().x(30, 30));
            this.Ni.setText("<html>Comprador: " + this.Nc.ve().getNome() + " vendido por " + C.c(this.Nc.vd()) + "</html>");
        } else {
            this.Ni.setText("N\u00e3o houve compradores - tente com um pre\u00e7o menor...");
        }
    }

    private void sK() {
        this.Nd = new ArrayList();
        this.Ne = new ArrayList();
        int n2 = 0;
        while (n2 < c.a.SR.aN().size()) {
            if (c.a.SR.aN().get(n2) != this.uz.fg() && ((ah)c.a.SR.aN().get(n2)).kb() > (long)this.Nc.lY()) {
                this.Nd.add((ah)c.a.SR.aN().get(n2));
            }
            ++n2;
        }
        this.sL();
    }

    private void sL() {
        this.zP.setText(String.valueOf(((ah)this.Nd.get(this.index)).ka().dS()) + ", dinheiro em caixa:" + C.c(((ah)this.Nd.get(this.index)).kb()));
        this.zP.setIcon(((ah)this.Nd.get(this.index)).kU());
    }

    private void mK() {
        int[] nArray = new int[6];
        this.MO.setText("<html><b>" + this.uz.getNome() + " - " + aq.rI[this.uz.getPosicao()] + "</b></html>");
        this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + this.uz.getPais() + ".png")));
        this.Nh.setText(C.c(this.uz.fl()));
        this.zO.setText(this.uz.fg().getNome());
        this.zO.setIcon(this.uz.fg().kU());
        nArray = this.uz.gw();
        String string = "";
        if (this.uz.fP()) {
            string = "Fim contus\u00e3o: " + best.a.a(this.uz.fo());
        }
        String string2 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;" + Integer.toString(this.uz.fi()) + "&nbsp;&nbsp;&nbsp;";
        if (c.a.SR.isHabilidadeIndividual()) {
            string2 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n&nbsp;&nbsp;&nbsp;&nbsp;<b>Gol:</b>" + Integer.toString(this.uz.gK()) + " <b>Des:</b>" + Integer.toString(this.uz.gN()) + " <b>Arm:</b>" + Integer.toString(this.uz.gO()) + " <b>Fin:</b>" + Integer.toString(this.uz.gP()) + " <b>Vel:</b>" + Integer.toString(this.uz.gJ()) + " <b>T\u00e9c:</b>" + Integer.toString(this.uz.gL()) + " <b>Pas:</b>" + Integer.toString(this.uz.gM()) + "&nbsp;&nbsp;&nbsp;";
        }
        String string3 = String.valueOf(string2) + "<b>Idade:</b>" + Integer.toString(this.uz.getIdade()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n" + "<b>Jogos:" + "</b>&nbsp;" + Integer.toString(nArray[0]) + "&nbsp;&nbsp;&nbsp;" + "<b>Gols:" + "</b>" + Integer.toString(nArray[1]) + "&nbsp;&nbsp;&nbsp;" + "<b>" + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:" + "</b>&nbsp;" + C.c(this.uz.fk()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>" + "Sal\u00e1rio:" + "</b>&nbsp;" + C.c(this.uz.fj()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + aq.qM[this.uz.getCr1()] + "/" + aq.qM[this.uz.getCr2()] + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + string + "<b><br>\n</p>\n</body></html>\n";
        this.MN.setText(string3);
    }

    public void mH() {
        this.zK.addActionListener(new iY(this));
        this.Nf.addActionListener(new iZ(this));
        this.Ng.addActionListener(new ja(this));
        this.uE.getDocument().addDocumentListener(new jb(this));
    }

    public static boolean B(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        return true;
    }

    private void oK() {
        String string = String.valueOf(this.uE.getText().toString()) + "000";
        if (!string.equals("") && string.matches("\\d+") && iX.B(string) && Integer.parseInt(string) >= 0) {
            this.uH.setText(C.c(Integer.parseInt(string)));
        } else {
            this.uH.setText("valor inv\u00e1lido");
        }
    }

    private void pR() {
        int n2 = 0;
        String string = String.valueOf(this.uE.getText().toString()) + "000";
        if (!string.equals("") && string.matches("\\d+") && iX.B(string) && Integer.parseInt(string) >= 0) {
            n2 = Integer.parseInt(string);
            if (((ah)this.Nd.get(this.index)).kb() >= (long)n2) {
                this.dC(n2);
            } else {
                this.uH.setText("lance maior que valor em caixa");
            }
        } else {
            this.uH.setText("valor inv\u00e1lido");
        }
    }

    private void sM() {
        this.dC(0);
    }

    private void dC(int n2) {
        this.Ne.add(n2);
        if (this.index + 1 < this.Nd.size()) {
            ++this.index;
            this.sL();
        } else {
            this.nO();
        }
    }

    private void nO() {
        int n2 = 0;
        int n3 = 0;
        ah ah2 = null;
        int n4 = 0;
        if (this.Ne.size() > 0) {
            n3 = (Integer)this.Ne.get(0);
            int n5 = 0;
            while (n5 < this.Ne.size()) {
                if ((Integer)this.Ne.get(n5) > n3) {
                    n2 = n5;
                }
                ++n5;
            }
            if (n2 < this.Nd.size()) {
                ah2 = (ah)this.Nd.get(n2);
                n4 = (Integer)this.Ne.get(n2);
            }
        }
        if (n4 > 0) {
            if (this.Nc.ve() == null) {
                this.Nc.I(ah2);
                this.Nc.ei(n4);
            } else if (n4 > this.Nc.vd()) {
                this.Nc.I(ah2);
                this.Nc.ei(n4);
            }
        }
        this.sJ();
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.wf = new JPanel();
        this.MO = new JLabel();
        this.MN = new JLabel();
        this.we = new JPanel();
        this.zO = new JLabel();
        this.zP = new JLabel();
        this.Nh = new JLabel();
        this.Ni = new JLabel();
        this.uE = new JTextField();
        this.uH = new JLabel();
        this.Nf = new JButton();
        this.zK = new JButton();
        this.Ng = new JButton();
        this.setBackground(new Color(42, 64, 29));
        this.setLayout(new b());
        this.vd.setBackground(new Color(84, 127, 59));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(2);
        this.ug.setText("Venda de jogador em leil\u00e3o");
        this.MO.setFont(new Font("Tahoma", 0, 12));
        this.MO.setHorizontalAlignment(2);
        this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
        this.MO.setText("Marquinhos Paran\u00e1 - M");
        this.MN.setFont(new Font("Tahoma", 0, 11));
        this.MN.setText("<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Idade:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>Jogos:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Gols:</b>23&nbsp;&nbsp;&nbsp;<b>Cart\u00f5es:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:</b>&nbsp;5 milh\u00f5es 300 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Sal\u00e1rio:</b>&nbsp; 230 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Marca\u00e7\u00e3o/desarme<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Contrato at\u00e9:</b>&nbsp; 20/12/2015<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>suspenso<br>\n</p>\n</body></html>\n");
        this.MN.setVerticalAlignment(1);
        GroupLayout groupLayout = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.MN, -1, 325, Short.MAX_VALUE).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addComponent(this.MO, -1, -1, Short.MAX_VALUE).addGap(25, 25, 25)))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.MO).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.MN).addGap(16, 16, 16)));
        this.we.setOpaque(false);
        GroupLayout groupLayout2 = new GroupLayout(this.we);
        this.we.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 367, Short.MAX_VALUE));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 112, Short.MAX_VALUE));
        this.zO.setForeground(new Color(255, 255, 255));
        this.zO.setHorizontalAlignment(2);
        this.zO.setText("Time 1 est\u00e1 vendendo o jogador");
        this.zP.setForeground(new Color(255, 255, 255));
        this.zP.setText("Dinheiro em caixa:");
        this.Nh.setFont(new Font("Tahoma", 1, 11));
        this.Nh.setForeground(new Color(255, 255, 255));
        this.Nh.setText("Lance m\u00ednimo:");
        this.Ni.setForeground(new Color(255, 255, 255));
        this.Ni.setHorizontalAlignment(2);
        this.Ni.setText("<html>Fa\u00e7a sua oferta em milhares de $, por exemplo: 300 equivale \u00e0 300 mil, 1200 \u00e0 1 milh\u00e3o e duzentos etc</html>");
        this.uH.setForeground(new Color(255, 255, 255));
        this.uH.setHorizontalAlignment(2);
        this.uH.setText("Pre\u00e7o inicial:");
        this.Nf.setText("Ofertar");
        this.zK.setText("continuar >>");
        this.Ng.setText("Pular");
        GroupLayout groupLayout3 = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(101, 101, 101).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Nh, -2, 314, -2).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(groupLayout3.createSequentialGroup().addComponent(this.ug, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.zK)).addComponent(this.wf, GroupLayout.Alignment.LEADING, -2, -1, -2)).addComponent(this.Ng, GroupLayout.Alignment.TRAILING, -2, 77, -2)).addContainerGap(-1, Short.MAX_VALUE)).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zO, -2, 196, -2).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zP, -2, 411, -2).addGroup(groupLayout3.createSequentialGroup().addComponent(this.uE, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Nf, -2, 79, -2)).addComponent(this.uH, -2, 313, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.we, -2, -1, -2)).addComponent(this.Ni, -2, 355, -2)).addGap(0, 0, Short.MAX_VALUE)))));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(23, 23, 23).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.zK)).addGap(3, 3, 3).addComponent(this.zO).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Nh).addGap(8, 8, 8).addComponent(this.wf, -2, -1, -2).addGap(18, 18, 18).addComponent(this.Ni, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uE, -2, -1, -2).addComponent(this.Nf).addComponent(this.Ng)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uH).addGap(25, 25, 25).addComponent(this.zP)).addComponent(this.we, -2, -1, -2)).addContainerGap(-1, Short.MAX_VALUE)));
        this.add((Component)this.vd, new a(30, 20, 550, -1));
    }

    static /* synthetic */ JDialog a(iX iX2) {
        return iX2.ub;
    }

    static /* synthetic */ void b(iX iX2) {
        iX2.pR();
    }

    static /* synthetic */ void c(iX iX2) {
        iX2.sM();
    }

    static /* synthetic */ void d(iX iX2) {
        iX2.oK();
    }
}

