/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class D
extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/alpha.png"));
        Image image = imageIcon.getImage();
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, null);
    }
}

