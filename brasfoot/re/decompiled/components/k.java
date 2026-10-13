/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class k
extends JPanel {
    private JSeparator BE;
    private JSeparator BF;
    private JLabel Ot;
    private JLabel Ou;
    private JLabel Ov;
    private JLabel Ow;

    public k() {
        this.mJ();
        this.at(false);
    }

    private void at(boolean bl2) {
        this.BE.setVisible(bl2);
        this.BF.setVisible(bl2);
        this.Ow.setVisible(bl2);
        this.Ou.setVisible(bl2);
        this.Ot.setVisible(bl2);
        this.Ov.setVisible(bl2);
    }

    public void a(String string, String string2, int n2, ImageIcon imageIcon) {
        this.Ov.setText(string);
        this.Ow.setIcon(imageIcon);
        this.Ot.setText(string2);
        this.Ou.setText(Integer.toString(n2));
        this.at(true);
        if (n2 < 100) {
            this.Ou.setFont(new Font("Tahoma", 1, 14));
        }
    }

    private void mJ() {
        this.Ou = new JLabel();
        this.Ow = new JLabel();
        this.Ov = new JLabel();
        this.BE = new JSeparator();
        this.BF = new JSeparator();
        this.Ot = new JLabel();
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(595, 110));
        this.setLayout(new b());
        this.Ou.setBackground(new Color(52, 78, 130));
        this.Ou.setFont(new Font("Tahoma", 0, 14));
        this.Ou.setForeground(new Color(255, 255, 255));
        this.Ou.setHorizontalAlignment(0);
        this.Ou.setText("199");
        this.Ou.setOpaque(true);
        this.add((Component)this.Ou, new a(172, 145, 28, 20));
        this.Ow.setBackground(new Color(232, 236, 235));
        this.Ow.setHorizontalAlignment(0);
        this.Ow.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trgen.png")));
        this.add((Component)this.Ow, new a(0, 40, 87, -1));
        this.Ov.setBackground(new Color(255, 255, 255));
        this.Ov.setFont(new Font("Tahoma", 1, 12));
        this.Ov.setForeground(new Color(36, 104, 43));
        this.Ov.setText("Brasileiro - 1\u00aa divis\u00e3o");
        this.add((Component)this.Ov, new a(10, 10, 190, -1));
        this.add((Component)this.BE, new a(0, 30, 200, -1));
        this.BF.setOrientation(1);
        this.BF.setPreferredSize(new Dimension(1, 0));
        this.add((Component)this.BF, new a(90, 30, -1, 139));
        this.Ot.setHorizontalAlignment(2);
        this.Ot.setText("");
        this.Ot.setVerticalAlignment(1);
        this.add((Component)this.Ot, new a(95, 35, 105, 130));
    }
}

