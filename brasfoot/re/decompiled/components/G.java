/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class G
extends JPanel {
    private int w;

    public G(int n2) {
        this.w = n2;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        ImageIcon imageIcon = null;
        if (this.w == 2) {
            imageIcon = new ImageIcon(this.getClass().getResource("/aicons/alpha2.png"));
        } else if (this.w == 3) {
            imageIcon = new ImageIcon(this.getClass().getResource("/aicons/alpha3.png"));
        }
        Image image = imageIcon.getImage();
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, null);
    }
}

