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

public class F
extends JPanel {
    private static BufferedImage DH = null;
    private static int Qf = 0;
    private static String Qg = null;
    private static Color Qh = null;
    private static Color Qi = null;

    public F(String string, int n2, Color color, Color color2) {
        Qf = n2;
        Qg = string;
        Qh = color;
        Qi = color2;
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
        } else if (Qf == 2) {
            try {
                DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f03.png"));
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Dimension dimension = this.getSize();
            super.paintComponent(graphics);
            graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
            int n4 = 2;
            if (Qh.getRGB() == Color.WHITE.getRGB()) {
                Qh = Color.DARK_GRAY;
                n4 = 2;
            }
            graphics.setColor(Qh);
            graphics.drawRect(0, 0, dimension.width, n4);
            graphics.fillRect(0, 0, dimension.width, n4);
        } else if (Qf == 4) {
            try {
                DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f04.png"));
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Dimension dimension = this.getSize();
            super.paintComponent(graphics);
            graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
            int n5 = 2;
            if (Qh.getRGB() == Color.WHITE.getRGB()) {
                Qh = Color.DARK_GRAY;
                n5 = 2;
            }
            graphics.setColor(Qh);
        }
    }
}

