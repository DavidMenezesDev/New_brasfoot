/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gm;
import a.gn;
import a.go;
import a.gp;
import components.D;
import components.G;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class gl
extends JPanel {
    private int JX = 1;
    int As;
    int At;
    int Au;
    int Av;
    private JButton vb;
    private JButton vc;
    private JPanel xb;
    private JPanel JY;

    public gl() {
        this.mJ();
        this.vb.addActionListener(new gm(this));
        this.vc.addActionListener(new gn(this));
        this.JY.setVisible(false);
        this.mH();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/campo.png"));
        Image image = imageIcon.getImage();
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, null);
    }

    public void af(boolean bl2) {
        this.JY.setVisible(bl2);
    }

    public void mH() {
        this.xb.addMouseListener(new go(this));
        this.xb.addMouseMotionListener(new gp(this));
    }

    private void e(MouseEvent mouseEvent) {
        this.As = mouseEvent.getX();
        this.At = mouseEvent.getY();
        this.Au = this.As;
        this.Av = this.At;
        this.JY.setVisible(true);
    }

    private void f(MouseEvent mouseEvent) {
        this.Au = mouseEvent.getX();
        this.Av = mouseEvent.getY();
    }

    private void g(MouseEvent mouseEvent) {
        this.As = mouseEvent.getX();
        this.At = mouseEvent.getY();
        this.JY.setVisible(false);
        this.rM();
    }

    public void rM() {
        this.xb.setVisible(false);
        this.xb = new G(3);
        this.xb.setVisible(true);
    }

    private void mJ() {
        this.xb = new G(2);
        this.JY = new D();
        this.vc = new JButton();
        this.vb = new JButton();
        this.JY.setOpaque(false);
        this.xb.setOpaque(false);
        GroupLayout groupLayout = new GroupLayout(this.JY);
        this.JY.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 512, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 662, Short.MAX_VALUE));
        this.xb.setBackground(new Color(0, 153, 153));
        GroupLayout groupLayout2 = new GroupLayout(this.xb);
        this.xb.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 512, Short.MAX_VALUE));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 662, Short.MAX_VALUE));
        this.vc.setText("jButton2");
        this.vb.setText("jButton1");
        GroupLayout groupLayout3 = new GroupLayout(this);
        this.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.xb, -1, -1, Short.MAX_VALUE).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(147, 147, 147).addComponent(this.vb).addGap(72, 72, 72).addComponent(this.vc).addContainerGap(147, Short.MAX_VALUE))).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JY, -1, -1, Short.MAX_VALUE)));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.xb, -1, -1, Short.MAX_VALUE).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(319, 319, 319).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vc).addComponent(this.vb)).addContainerGap(320, Short.MAX_VALUE))).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JY, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE)));
    }

    static /* synthetic */ JPanel a(gl gl2) {
        return gl2.xb;
    }

    static /* synthetic */ void a(gl gl2, MouseEvent mouseEvent) {
        gl2.f(mouseEvent);
    }

    static /* synthetic */ void b(gl gl2, MouseEvent mouseEvent) {
        gl2.g(mouseEvent);
    }

    static /* synthetic */ void c(gl gl2, MouseEvent mouseEvent) {
        gl2.e(mouseEvent);
    }
}

