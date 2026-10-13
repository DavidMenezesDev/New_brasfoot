/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.bs;
import best.S;
import best.aq;
import components.I;
import components.J;
import components.a;
import components.b;
import components.t;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class H
extends JPanel {
    bs Qj = null;
    t Qk;
    int w = -1;
    private JButton Ql;
    private JButton Qm;
    private JLabel Qn;
    private JLabel uF;
    private JLabel zO;

    public H(int n2, bs bs2, t t2) {
        this.Qj = bs2;
        this.Qk = t2;
        this.w = n2;
        if (n2 == 1) {
            this.mJ();
            this.uF.setText(String.valueOf(aq.rI[t2.x().getPosicao()]) + " - " + t2.x().getNome());
            this.Qn.setText(best.a.a(t2.tO()));
            if (t2.tP() != null) {
                this.zO.setText(t2.tP().getNome());
                this.zO.setIcon(t2.tP().kU());
            }
            this.mH();
        } else if (n2 == 4) {
            this.ui();
            this.mJ();
            this.uF.setText(String.valueOf(aq.rI[t2.x().getPosicao()]) + " - " + t2.x().getNome());
            this.Qn.setText(best.a.a(t2.tO()));
            if (t2.x().fg() != null) {
                this.zO.setText(t2.x().fg().getNome());
                this.zO.setIcon(t2.x().fg().kU());
            }
            this.mH();
        } else if (n2 == 2 || n2 == 3) {
            this.ui();
            if (n2 == 3) {
                this.zO.setText("Jogando no time");
            }
        }
    }

    private void mH() {
        this.Ql.addActionListener(new I(this));
        this.Qm.addActionListener(new J(this));
    }

    private void uh() {
        this.setCursor(new Cursor(3));
        S.a(this.Qk.x(), null);
        this.setCursor(new Cursor(12));
    }

    private void qG() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(this.Qj, "Deseja cancelar o empr\u00e9stimo do jogador " + this.Qk.x().getNome() + "?", "Confirmar", 0);
        if (n2 == 0) {
            this.Qj.a(this.Qk, this.w);
        }
    }

    private void mJ() {
        this.Qn = new JLabel();
        this.uF = new JLabel();
        this.Qm = new JButton();
        this.Ql = new JButton();
        this.zO = new JLabel();
        this.setBackground(new Color(228, 227, 227));
        this.setPreferredSize(new Dimension(690, 36));
        this.setLayout(new b());
        this.Qn.setFont(new Font("Arial", 1, 12));
        this.Qn.setText("Fase Qualificat\u00f3ria R1");
        this.add((Component)this.Qn, new a(380, 0, 160, 40));
        this.uF.setFont(new Font("Arial", 1, 12));
        this.uF.setText("Jo\u00e3o da Silva");
        this.add((Component)this.uF, new a(10, 0, 150, 40));
        this.Qm.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/r_eli.png")));
        this.add((Component)this.Qm, new a(615, 5, -1, 25));
        this.Ql.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon22small.png")));
        this.add((Component)this.Ql, new a(550, 5, -1, 25));
        this.zO.setFont(new Font("Arial", 1, 12));
        this.zO.setText("Fase Qualificat\u00f3ria R1");
        this.add((Component)this.zO, new a(170, 0, 190, 40));
    }

    private void ui() {
        this.Qn = new JLabel();
        this.uF = new JLabel();
        this.zO = new JLabel();
        this.setBackground(new Color(0, 0, 0));
        this.setPreferredSize(new Dimension(690, 36));
        this.setLayout(new b());
        this.Qn.setFont(new Font("Arial", 1, 12));
        this.Qn.setForeground(new Color(255, 255, 255));
        this.Qn.setText("Data fim do empr\u00e9stimo");
        this.add((Component)this.Qn, new a(380, 0, 160, 40));
        this.uF.setFont(new Font("Arial", 1, 12));
        this.uF.setForeground(new Color(255, 255, 255));
        this.uF.setText("Jogador");
        this.add((Component)this.uF, new a(10, 0, 150, 40));
        this.zO.setFont(new Font("Arial", 1, 12));
        this.zO.setForeground(new Color(255, 255, 255));
        this.zO.setText("Time a que pertence");
        this.add((Component)this.zO, new a(170, 0, 190, 40));
    }

    static /* synthetic */ void a(H h3) {
        h3.uh();
    }

    static /* synthetic */ void b(H h3) {
        h3.qG();
    }
}

