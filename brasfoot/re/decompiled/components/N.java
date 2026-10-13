/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class N
extends JPanel {
    private static BufferedImage DH = null;

    @Override
    protected void paintComponent(Graphics graphics) {
        try {
            DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f02.jpg"));
        }
        catch (IOException iOException) {
            // empty catch block
        }
        Dimension dimension = this.getSize();
        super.paintComponent(graphics);
        graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
    }
}

