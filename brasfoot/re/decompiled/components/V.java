/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.hk;
import best.I;
import components.W;
import components.a;
import components.b;
import components.u;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class V
extends JPanel {
    hk QS = null;
    I zz = null;
    private MouseAdapter QT;
    private JLabel Lm;
    private JLabel zO;
    private JLabel zP;
    private JLabel QU;

    public V(u u2, hk hk2) {
        this.QS = hk2;
        this.zz = u2.tR();
        if (u2.tR() != null) {
            this.mJ();
            this.mH();
            this.b(u2);
        } else {
            this.ui();
            this.QU.setText(u2.sT());
        }
    }

    private void mH() {
        this.QT = new W(this);
        this.zO.addMouseListener(this.QT);
        this.zP.addMouseListener(this.QT);
        this.Lm.addMouseListener(this.QT);
    }

    private void us() {
        this.QS.a(this, this.zz);
    }

    public void e(Color color) {
        this.setBackground(color);
    }

    private void b(u u2) {
        this.zO.setText(u2.tR().hc().getNome());
        this.zO.setIcon(u2.tR().hc().kU());
        this.zP.setText(u2.tR().hd().getNome());
        this.zP.setIcon(u2.tR().hd().kU());
        this.Lm.setText(String.valueOf(u2.tR().hu()) + " x " + u2.tR().hw() + " ");
    }

    private void mJ() {
        this.zO = new JLabel();
        this.Lm = new JLabel();
        this.zP = new JLabel();
        this.setBackground(new Color(228, 227, 227));
        this.setPreferredSize(new Dimension(295, 25));
        this.setLayout(new b());
        this.zO.setFont(new Font("Arial", 0, 12));
        this.zO.setHorizontalAlignment(4);
        this.zO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
        this.zO.setText("");
        this.zO.setHorizontalTextPosition(2);
        this.add((Component)this.zO, new a(0, 0, 128, 25));
        this.Lm.setBackground(new Color(0, 0, 0));
        this.Lm.setFont(new Font("Arial", 0, 12));
        this.Lm.setHorizontalAlignment(0);
        this.Lm.setText("0 x 0");
        this.add((Component)this.Lm, new a(129, 0, 40, 25));
        this.zP.setFont(new Font("Arial", 0, 12));
        this.zP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
        this.zP.setText("");
        this.add((Component)this.zP, new a(169, 0, 128, 25));
    }

    private void ui() {
        this.QU = new JLabel();
        this.setBackground(new Color(0, 102, 153));
        this.setPreferredSize(new Dimension(295, 25));
        this.setLayout(new b());
        this.QU.setFont(new Font("Arial", 1, 12));
        this.QU.setForeground(new Color(255, 255, 255));
        this.QU.setHorizontalAlignment(0);
        this.QU.setText("");
        this.add((Component)this.QU, new a(-3, 0, 300, 25));
    }

    public I tR() {
        return this.zz;
    }

    static /* synthetic */ void a(V v2) {
        v2.us();
    }
}

