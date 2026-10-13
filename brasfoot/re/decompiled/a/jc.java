/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jd;
import a.je;
import a.jf;
import a.jg;
import a.jh;
import best.C;
import best.F;
import components.an;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class jc
extends JPanel {
    private JDialog ub;
    private F CY;
    private int w = 1;
    private int Nk = 0;
    private int Nl = 0;
    private int oq = 0;
    private static boolean Nm = false;
    private JButton uC;
    private ButtonGroup Kl;
    private JRadioButton Km;
    private JRadioButton Kn;
    private JTextField uE;
    private JButton vb;
    private JLabel ug;
    private JLabel uh;
    private JLabel us;
    private JPanel vd;
    private JLabel Nn;
    private JLabel uH;
    private JLabel uI;

    public jc(JDialog jDialog, F f2) {
        this.ub = jDialog;
        this.CY = f2;
        Nm = false;
        this.mJ();
        this.mH();
        this.mK();
    }

    private void a(int n2) {
        this.w = n2;
        if (this.w == 1) {
            this.uI.setText("Pre\u00e7o inicial: (em milhares de $)");
            this.vb.setText("Iniciar leil\u00e3o");
        } else {
            this.uI.setText("Pre\u00e7o fixado: (em milhares de $)");
            this.vb.setText("Fixar pre\u00e7o");
        }
    }

    private void mK() {
        this.uI.setText("Pre\u00e7o inicial: (em milhares de $)");
        this.Kl.add(this.Km);
        this.Kl.add(this.Kn);
        this.uh.setText(this.CY.getNome());
        this.oq = this.CY.fk();
        this.uE.setText(String.valueOf(Math.round(this.CY.fk() / 1000)));
        this.uH.setText(C.c(this.CY.fk()));
        this.Km.addActionListener(new jd(this));
        this.Kn.addActionListener(new je(this));
        this.Km.setSelected(true);
        this.uE.getDocument().addDocumentListener(new jf(this));
        int n2 = this.CY.fR();
        this.Nl = n2 <= 0 ? 0 : (n2 > 0 && n2 <= 30 ? 12 : (n2 <= 60 ? 20 : (n2 <= 90 ? 22 : (n2 <= 180 ? 25 : (n2 <= 722 ? 30 : 35)))));
        this.Nk = Math.round(this.CY.fk() * this.Nl / 100);
        this.Nn.setText("Multa estimada deste jogador: " + Integer.toString(this.Nl) + "% da venda");
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
        if (!string.equals("") && string.matches("\\d+") && jc.B(string) && Integer.parseInt(string) >= 0) {
            this.uH.setText(C.c(Integer.parseInt(string)));
        } else {
            this.uH.setText("valor inv\u00e1lido");
        }
    }

    public void mH() {
        this.uC.addActionListener(new jg(this));
        this.vb.addActionListener(new jh(this));
    }

    private void dD(int n2) {
        this.CY.c(true);
        this.CY.ag(n2);
        this.ub.dispose();
    }

    private void dE(int n2) {
        this.CY.ag(n2);
        int n3 = n2;
        if (n2 < this.CY.fk()) {
            double d2 = 0.1;
            if (new Random().nextInt(100) > 50) {
                d2 = 0.15;
            }
            n3 = (int)Math.round((double)this.CY.fk() * d2);
            n3 = this.CY.fk() - n3;
            if (n3 < n2) {
                n3 = n2;
            }
        }
        this.ub.dispose();
        new an(this.CY, n3, true, false);
        Nm = true;
    }

    private void qX() {
        String string = String.valueOf(this.uE.getText().toString()) + "000";
        if (!string.equals("") && string.matches("\\d+") && jc.B(string) && Integer.parseInt(string) >= 0) {
            if (this.w == 1) {
                this.dE(Integer.parseInt(string));
            } else {
                this.dD(Integer.parseInt(string));
            }
        } else {
            JOptionPane.showMessageDialog(this.ub, "O pre\u00e7o do jogador n\u00e3o \u00e9 v\u00e1lido.", "Erro", 0);
        }
    }

    private void mJ() {
        this.Kl = new ButtonGroup();
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.uh = new JLabel();
        this.Km = new JRadioButton();
        this.Kn = new JRadioButton();
        this.uI = new JLabel();
        this.uE = new JTextField();
        this.uH = new JLabel();
        this.vb = new JButton();
        this.uC = new JButton();
        this.us = new JLabel();
        this.Nn = new JLabel();
        this.setBackground(new Color(42, 64, 29));
        this.vd.setBackground(new Color(84, 127, 59));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Vender Jogador");
        this.uh.setFont(new Font("Tahoma", 0, 12));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(0);
        this.uh.setText("Nome do Jogador");
        this.Km.setBackground(new Color(255, 254, 176));
        this.Km.setFont(new Font("Tahoma", 0, 12));
        this.Km.setForeground(new Color(255, 255, 255));
        this.Km.setText("Vender jogador em leil\u00e3o");
        this.Km.setOpaque(false);
        this.Kn.setBackground(new Color(255, 254, 176));
        this.Kn.setFont(new Font("Tahoma", 0, 12));
        this.Kn.setForeground(new Color(255, 255, 255));
        this.Kn.setText("Colocar \u00e0 venda esperando comprador ");
        this.Kn.setOpaque(false);
        this.uI.setForeground(new Color(255, 255, 255));
        this.uI.setHorizontalAlignment(2);
        this.uI.setText("Pre\u00e7o inicial:");
        this.uH.setForeground(new Color(255, 255, 255));
        this.uH.setHorizontalAlignment(2);
        this.uH.setText("Pre\u00e7o inicial:");
        this.vb.setText("Iniciar leilao");
        this.uC.setText("Cancelar");
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setHorizontalAlignment(2);
        this.us.setText("Jogadores com contrato pagam multa de rescis\u00e3o. ");
        this.Nn.setForeground(new Color(255, 255, 255));
        this.Nn.setHorizontalAlignment(2);
        this.Nn.setText("Multa estimada:");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.uh, -1, -1, Short.MAX_VALUE).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uE).addComponent(this.Kn, -1, -1, Short.MAX_VALUE).addComponent(this.Km, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.us, -2, 302, -2).addComponent(this.uI, -2, 264, -2).addComponent(this.uH, -2, 237, -2).addComponent(this.Nn, -2, 254, -2)).addGap(0, 0, Short.MAX_VALUE)))).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGap(41, 41, 41).addComponent(this.vb, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.uC, -2, 115, -2).addGap(9, 9, 9))).addGap(24, 24, 24)).addGroup(groupLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.ug, -2, 341, -2).addContainerGap(-1, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uh).addGap(18, 18, 18).addComponent(this.Km).addGap(34, 34, 34).addComponent(this.Kn).addGap(28, 28, 28).addComponent(this.uI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uE, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uH).addGap(43, 43, 43).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vb).addComponent(this.uC)).addGap(18, 18, 18).addComponent(this.us).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Nn).addContainerGap(24, Short.MAX_VALUE)));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(20, 20, 20).addComponent(this.vd, -2, -1, -2).addContainerGap(20, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(20, 20, 20).addComponent(this.vd, -2, -1, -2).addContainerGap(25, Short.MAX_VALUE)));
    }

    public static boolean sN() {
        return Nm;
    }

    static /* synthetic */ void a(jc jc2, int n2) {
        jc2.a(n2);
    }

    static /* synthetic */ void a(jc jc2) {
        jc2.oK();
    }

    static /* synthetic */ JDialog b(jc jc2) {
        return jc2.ub;
    }

    static /* synthetic */ void c(jc jc2) {
        jc2.qX();
    }
}

