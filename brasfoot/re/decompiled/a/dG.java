/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dH;
import a.dI;
import a.dK;
import best.ac;
import best.ad;
import best.p;
import components.a;
import components.b;
import est.ConfigLigaType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class dG
extends JPanel {
    private ArrayList du = new ArrayList();
    private int pais;
    private int gF;
    private ConfigLigaType[] Go = new ConfigLigaType[5];
    private int[] CQ = new int[5];
    private JDialog ub = null;
    private JButton uC;
    private JCheckBox Gp;
    private JButton vb;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JScrollPane ut;
    private JLabel vf;
    private dK Gq;
    private dK Gr;
    private dK Gs;
    private dK Gt;

    public dG(int n2, int n3, JDialog jDialog) {
        this.pais = n2;
        this.ub = jDialog;
        this.mJ();
        this.vb.addActionListener(new dH(this));
        this.uC.addActionListener(new dI(this));
        this.gF = n3;
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + n2 + ".png"));
        String string = "Configurar Ligas - " + ac.valueOf("P" + n2).getNome() + " - " + Integer.toString(this.gF) + " times";
        this.vf.setText(string);
        this.vf.setIcon(imageIcon);
        int n4 = 0;
        while (n4 < c.a.SR.bG.size()) {
            if (((ConfigLigaType)c.a.SR.bG.get(n4)).getPais() == n2) {
                this.du.add((ConfigLigaType)c.a.SR.bG.get(n4));
            }
            ++n4;
        }
        n4 = 0;
        while (n4 <= 4) {
            this.Go[n4] = null;
            ++n4;
        }
        if (this.du.size() > 0) {
            n4 = 1;
            while (n4 <= 4) {
                int n5 = 0;
                while (n5 < this.du.size()) {
                    if (((ConfigLigaType)this.du.get(n5)).getDivisao() == n4) {
                        this.Go[n4] = (ConfigLigaType)this.du.get(n5);
                    }
                    ++n5;
                }
                ++n4;
            }
        }
        n4 = 1;
        while (n4 <= 4) {
            if (this.Go[n4] == null) {
                ConfigLigaType configLigaType = new ConfigLigaType();
                configLigaType.setnTimes(20);
                configLigaType.setnRebaixados(4);
                configLigaType.setPais(n2);
                configLigaType.setDivisao(n4);
                configLigaType.setFormula(0);
                configLigaType.setNome2(ad.br(n2));
                c.a.SR.bG.add(configLigaType);
                this.Go[n4] = configLigaType;
                configLigaType.setRebaixadosDireto(4);
                configLigaType.setVagasSobemPeloMataMata(0);
                configLigaType.setVersaoArquivo(22);
            }
            ++n4;
        }
        this.du.clear();
        n4 = 1;
        while (n4 <= 4) {
            this.CQ[n4] = this.Go[n4].getnTimes();
            ++n4;
        }
        if (this.pais != 29) {
            this.Gp.setVisible(false);
        } else {
            this.Gp.setVisible(true);
            if (c.a.vM().isNovoFormatoCopa()) {
                this.Gp.setSelected(true);
            } else {
                this.Gp.setSelected(false);
            }
        }
        this.Gq.a(this.Go[1], this.Go[2]);
        this.Gr.a(this.Go[2], this.Go[3]);
        this.Gs.a(this.Go[3], this.Go[4]);
        this.Gt.a(this.Go[4], null);
        this.oJ();
    }

    public void nH() {
        this.Gq.nH();
        this.Gr.nH();
        this.Gs.nH();
        this.Gt.nH();
        p.a(this.Go, this.pais);
        if (this.pais == 29) {
            c.a.vM().setNovoFormatoCopa(this.Gp.isSelected());
            c.a.vJ();
        }
        this.ub.dispose();
    }

    public void oJ() {
        if (this.gF >= this.CQ[1]) {
            this.Gq.db(1);
        } else {
            this.Gq.db(2);
        }
        if (this.gF >= this.CQ[1] + this.CQ[2]) {
            this.Gr.db(1);
        } else {
            this.Gr.db(3);
        }
        if (this.gF >= this.CQ[1] + this.CQ[2] + this.CQ[3]) {
            this.Gs.db(1);
        } else {
            this.Gs.db(3);
        }
        if (this.gF >= this.CQ[1] + this.CQ[2] + this.CQ[3] + this.CQ[4]) {
            this.Gt.db(1);
        } else {
            this.Gt.db(3);
        }
    }

    public void J(int n2, int n3) {
        this.CQ[n2] = n3;
    }

    public void af(int n2, int n3) {
        if (n2 == 1) {
            this.Gr.fv(n3);
            this.Gr.aP(false);
        } else if (n2 == 2) {
            this.Gs.fv(n3);
            this.Gs.aP(false);
        } else if (n2 == 3) {
            this.Gt.fv(n3);
            this.Gt.aP(false);
        }
    }

    private void mJ() {
        this.vf = new JLabel();
        this.vb = new JButton();
        this.uC = new JButton();
        this.Gp = new JCheckBox();
        this.Gq = new dK(1, this);
        this.Gr = new dK(2, this);
        this.Gs = new dK(3, this);
        this.Gt = new dK(4, this);
        this.ug = new JLabel();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.ut = new JScrollPane();
        this.setBackground(new Color(204, 204, 204));
        this.setToolTipText("");
        this.setLayout(new b());
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setForeground(new Color(0, 75, 106));
        this.vf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
        this.vf.setText("Configurar Ligas - Brasil - 120 times");
        this.add((Component)this.vf, new a(50, 10, 310, -1));
        this.vb.setFont(new Font("Tahoma", 0, 12));
        this.vb.setText("Salvar");
        this.vb.setToolTipText("");
        this.add((Component)this.vb, new a(610, 10, 170, 30));
        this.uC.setFont(new Font("Tahoma", 0, 12));
        this.uC.setText("Cancelar altera\u00e7\u00f5es");
        this.uC.setToolTipText("");
        this.add((Component)this.uC, new a(390, 10, 170, 30));
        this.Gp.setBackground(new Color(0, 0, 0));
        this.Gp.setForeground(new Color(0, 75, 106));
        this.Gp.setText("Usar novo formato na Copa BRA");
        this.Gp.setHorizontalAlignment(2);
        this.Gp.setOpaque(false);
        this.add((Component)this.Gp, new a(70, 30, 262, 20));
        this.add((Component)this.Gt, new a(50, 550, 730, 160));
        this.add((Component)this.Gq, new a(50, 50, 731, 147));
        this.add((Component)this.Gr, new a(50, 210, 730, 160));
        this.add((Component)this.Gs, new a(50, 380, 730, 160));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(0, 75, 106));
        this.ug.setText("4");
        this.ug.setToolTipText("");
        this.add((Component)this.ug, new a(30, 570, -1, 20));
        this.uh.setFont(new Font("Tahoma", 1, 14));
        this.uh.setForeground(new Color(0, 75, 106));
        this.uh.setText("1");
        this.uh.setToolTipText("");
        this.add((Component)this.uh, new a(30, 60, -1, 20));
        this.a_.setFont(new Font("Tahoma", 1, 14));
        this.a_.setForeground(new Color(0, 75, 106));
        this.a_.setText("2");
        this.a_.setToolTipText("");
        this.add((Component)this.a_, new a(30, 230, -1, 20));
        this.ur.setFont(new Font("Tahoma", 1, 14));
        this.ur.setForeground(new Color(0, 75, 106));
        this.ur.setText("3");
        this.ur.setToolTipText("");
        this.add((Component)this.ur, new a(30, 400, -1, 20));
        this.add((Component)this.ut, new a(-30, -10, -1, -1));
    }

    static /* synthetic */ JDialog a(dG dG2) {
        return dG2.ub;
    }
}

