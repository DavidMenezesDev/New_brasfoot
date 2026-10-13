/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aa;
import a.bv;
import a.bw;
import a.bx;
import a.by;
import b.d;
import best.D;
import best.ae;
import best.p;
import components.Y;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class bu
extends JPanel {
    int As;
    int At;
    int Au;
    int Av;
    private JButton vb;
    private JButton vc;
    private JPanel Aw;

    public bu() {
        this.mJ();
        this.vb.addActionListener(new bv(this));
        this.vc.addActionListener(new bw(this));
    }

    public void nY() {
        this.Aw.addMouseListener(new bx(this));
        this.Aw.addMouseMotionListener(new by(this));
    }

    private void a(MouseEvent mouseEvent) {
        this.As = mouseEvent.getX();
        this.At = mouseEvent.getY();
        this.Au = this.As;
        this.Av = this.At;
    }

    public static void nZ() {
        if (d.vF().equals(ae.jG())) {
            D.m(ae.getNome());
            D.eS();
            D.eT();
            aa aa2 = new aa();
            p.dv();
            if (p.du() < 8) {
                p.n(true);
            }
        }
    }

    private void b(MouseEvent mouseEvent) {
        this.Au = mouseEvent.getX();
        this.Av = mouseEvent.getY();
    }

    private void c(MouseEvent mouseEvent) {
        this.As = mouseEvent.getX();
        this.At = mouseEvent.getY();
    }

    private void mJ() {
        this.Aw = new Y();
        this.vb = new JButton();
        this.vc = new JButton();
        this.setBackground(new Color(51, 102, 0));
        this.vb.setText("jButton1");
        this.vc.setText("jButton2");
        this.Aw.setPreferredSize(new Dimension(512, 662));
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.Aw, -2, -1, -2).addGap(74, 74, 74).addComponent(this.vb).addGap(83, 83, 83).addComponent(this.vc).addGap(0, 85, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vb).addComponent(this.vc)).addComponent(this.Aw, -2, -1, -2)).addGap(0, 38, Short.MAX_VALUE)));
    }

    static /* synthetic */ JPanel a(bu bu2) {
        return bu2.Aw;
    }

    static /* synthetic */ void a(bu bu2, MouseEvent mouseEvent) {
        bu2.b(mouseEvent);
    }

    static /* synthetic */ void b(bu bu2, MouseEvent mouseEvent) {
        bu2.c(mouseEvent);
    }

    static /* synthetic */ void c(bu bu2, MouseEvent mouseEvent) {
        bu2.a(mouseEvent);
    }
}

