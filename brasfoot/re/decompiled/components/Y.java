/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.Z;
import components.a;
import components.b;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Y
extends JPanel {
    int As;
    int At;
    int Au;
    int Av;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JLayeredPane MH;

    public Y() {
        this.mJ();
    }

    public void X(boolean bl2) {
        this.uh.setVisible(bl2);
    }

    private void mJ() {
        this.MH = new JLayeredPane();
        this.a_ = new JLabel();
        this.uh = new JLabel();
        this.ug = new JLabel();
        this.setPreferredSize(new Dimension(512, 662));
        this.MH.addMouseListener(new Z(this));
        this.MH.setLayout(new b());
        this.a_.setIcon(new ImageIcon(this.getClass().getResource("/aicons/alpha2.png")));
        this.a_.setToolTipText("");
        this.MH.add((Component)this.a_, new a(0, 0, 510, 660));
        this.MH.setLayer(this.a_, JLayeredPane.DRAG_LAYER);
        this.uh.setIcon(new ImageIcon(this.getClass().getResource("/aicons/alpha.png")));
        this.MH.add((Component)this.uh, new a(0, 0, 510, 660));
        this.MH.setLayer(this.uh, JLayeredPane.POPUP_LAYER);
        this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campo.png")));
        this.MH.add((Component)this.ug, new a(0, 0, -1, -1));
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.MH));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.MH));
    }

    private void h(MouseEvent mouseEvent) {
    }

    static /* synthetic */ void a(Y y2, MouseEvent mouseEvent) {
        y2.h(mouseEvent);
    }
}

