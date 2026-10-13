/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bc;
import a.bd;
import a.be;
import a.bf;
import best.ah;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class bb
extends JPanel {
    private JDialog ub;
    private ah zu;
    private JButton ud;
    private JButton zn;
    private JLabel ug;
    private JLabel uh;
    private JLabel vx;
    private JLabel zv;
    private JLabel zw;
    private JLabel zx;

    public bb(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.zu = ah2;
        this.mJ();
        this.zx.setText(ah2.getNome());
        this.zw.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.zv.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.zw.setBackground(ah2.kC());
        this.zv.setBackground(ah2.kB());
        this.nI();
        this.mH();
    }

    private void nI() {
        this.zx.setForeground(this.zw.getBackground());
        this.zx.setBackground(this.zv.getBackground());
    }

    private void a(Object object) {
        Color color;
        JLabel jLabel = (JLabel)object;
        Color color2 = jLabel.getBackground();
        Color color3 = this.getBackground();
        if (!color3.equals(color = JColorChooser.showDialog(jLabel, "", color2))) {
            jLabel.setBackground(color);
            this.nI();
        }
    }

    public void mH() {
        this.zn.addActionListener(new bc(this));
        this.ud.addActionListener(new bd(this));
        this.zw.addMouseListener(new be(this));
        this.zv.addMouseListener(new bf(this));
    }

    private void nH() {
        this.zu.d(this.zw.getBackground());
        this.zu.c(this.zv.getBackground());
    }

    private void mJ() {
        this.zn = new JButton();
        this.ug = new JLabel();
        this.zw = new JLabel();
        this.zv = new JLabel();
        this.uh = new JLabel();
        this.ud = new JButton();
        this.vx = new JLabel();
        this.zx = new JLabel();
        this.setBackground(new Color(241, 241, 227));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setLayout(new b());
        this.zn.setText("salvar");
        this.add((Component)this.zn, new a(30, 250, 108, 30));
        this.ug.setFont(new Font("Tahoma", 0, 14));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Cores do Time");
        this.add((Component)this.ug, new a(30, 20, 250, -1));
        this.zw.setBackground(new Color(255, 0, 102));
        this.zw.setMinimumSize(new Dimension(20, 20));
        this.zw.setCursor(new Cursor(12));
        this.zw.setOpaque(true);
        this.zw.setPreferredSize(new Dimension(20, 20));
        this.add((Component)this.zw, new a(70, 80, 69, 61));
        this.zv.setBackground(new Color(255, 0, 102));
        this.zv.setMinimumSize(new Dimension(20, 20));
        this.zv.setCursor(new Cursor(12));
        this.zv.setOpaque(true);
        this.zv.setPreferredSize(new Dimension(20, 20));
        this.add((Component)this.zv, new a(170, 80, 69, 60));
        this.uh.setText("Cor de Fundo:");
        this.add((Component)this.uh, new a(170, 60, -1, -1));
        this.ud.setText("cancelar");
        this.add((Component)this.ud, new a(160, 250, 108, 30));
        this.vx.setText("Cor de Texto:");
        this.add((Component)this.vx, new a(70, 60, -1, -1));
        this.zx.setBackground(new Color(255, 0, 102));
        this.zx.setFont(new Font("Arial", 0, 12));
        this.zx.setHorizontalAlignment(0);
        this.zx.setText("");
        this.zx.setMinimumSize(new Dimension(20, 20));
        this.zx.setOpaque(true);
        this.zx.setPreferredSize(new Dimension(20, 20));
        this.add((Component)this.zx, new a(30, 160, 240, 60));
    }

    static /* synthetic */ void a(bb bb2) {
        bb2.nH();
    }

    static /* synthetic */ JDialog b(bb bb2) {
        return bb2.ub;
    }

    static /* synthetic */ void a(bb bb2, Object object) {
        bb2.a(object);
    }
}

