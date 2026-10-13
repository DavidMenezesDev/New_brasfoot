/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class E
extends JPanel {
    private static BufferedImage DH = null;
    private static int Qf = 0;
    private static String Qg = null;

    public E(String string, int n2) {
        Qf = n2;
        Qg = string;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        if (Qf == 0) {
            try {
                DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f01.jpg"));
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Dimension dimension = this.getSize();
            super.paintComponent(graphics);
            graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
        } else if (Qf == 8) {
            try {
                DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f02.jpg"));
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Dimension dimension = this.getSize();
            super.paintComponent(graphics);
            graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
        } else if (Qf == 1) {
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D)graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int n2 = this.getWidth();
            int n3 = this.getHeight();
            Color color = Color.RED;
            Color color2 = Color.GREEN;
            GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, color, 0.0f, n3, color2);
            graphics2D.setPaint(gradientPaint);
            graphics2D.fillRect(0, 0, n2, n3);
        } else if (Qf == 3) {
            try {
                DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f03.png"));
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Dimension dimension = this.getSize();
            super.paintComponent(graphics);
            graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
        }
    }
}

