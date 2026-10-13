/*
 * Decompiled with CFR 0.152.
 */
package forms;

import best.ah;
import c.a;
import forms.i;
import forms.j;
import forms.k;
import forms.l;
import forms.m;
import forms.n;
import forms.o;
import forms.p;
import forms.q;
import forms.r;
import forms.s;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import sun.java2d.SunGraphicsEnvironment;

public class h {
    private JWindow WW;
    private JFrame WX;
    private JPanel WY;
    private BufferedImage WZ = null;
    private JLabel Xa;

    public void wT() {
        this.xs();
        this.xt();
        this.xu();
        this.xv();
        this.xw();
        this.xx();
        this.xy();
        this.xz();
        this.xb();
        this.xA();
        this.xB();
        this.xC();
        this.xD();
        this.xE();
        this.xa();
    }

    private void xr() {
        this.WW = new JWindow();
        Rectangle rectangle = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.WW.setSize(rectangle.width, rectangle.height);
        this.WW.setVisible(true);
    }

    private void xs() {
        this.WX = new JFrame("Brasfoot");
        this.WX.setLayout(new BorderLayout());
        this.WX.setDefaultCloseOperation(3);
    }

    private void xa() {
        this.WX.setUndecorated(true);
        this.WX.pack();
        GraphicsConfiguration graphicsConfiguration = this.WX.getGraphicsConfiguration();
        Rectangle rectangle = SunGraphicsEnvironment.getUsableBounds(graphicsConfiguration.getDevice());
        this.WX.setMaximizedBounds(new Rectangle(0, 0, rectangle.width, rectangle.height));
        this.WX.setVisible(true);
    }

    private void xt() {
        this.WY = new JPanel();
        this.WX.add(this.WY);
    }

    private void xu() {
        try {
            if (this.getClass().getResource("/arquivos/2016.jpg") != null) {
                this.WZ = ImageIO.read(this.getClass().getResource("/arquivos/2016.jpg"));
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.Xa = new JLabel();
        if (this.WZ != null) {
            this.Xa.setIcon(new ImageIcon(this.WZ));
            this.Xa.setLayout(new FlowLayout());
        } else {
            BufferedImage bufferedImage = new BufferedImage(256, 256, 1);
            this.Xa.setIcon(new ImageIcon(bufferedImage));
            this.Xa.setLayout(new FlowLayout());
        }
        this.WY.add(this.Xa);
    }

    private void xv() {
        JButton jButton = new JButton("Passa Dia");
        jButton.addActionListener(new i(this));
        this.Xa.add(jButton);
    }

    private void Bc() {
        String string = "Torneio Teste";
        String string2 = "Sert\u00e3ozinho";
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 <= 7) {
            arrayList.add((ah)a.SR.P().get(n2));
            ++n2;
        }
        if (a.SR.yn() != null) {
            a.SR.yn().a(arrayList, 0, string, string2, false);
        }
    }

    private void xw() {
        JButton jButton = new JButton("Processa teste");
        jButton.addActionListener(new l(this));
        this.Xa.add(jButton);
    }

    private void xx() {
        JButton jButton = new JButton("save");
        jButton.addActionListener(new m(this, jButton));
        this.Xa.add(jButton);
    }

    private void xy() {
        JButton jButton = new JButton("load");
        jButton.addActionListener(new n(this));
        this.Xa.add(jButton);
    }

    private void xz() {
        JButton jButton = new JButton("conversor");
        jButton.addActionListener(new o(this));
        this.Xa.add(jButton);
    }

    private void xb() {
        JButton jButton = new JButton("Inicializa Jogo");
        jButton.addActionListener(new p(this));
        this.Xa.add(jButton);
    }

    private void xA() {
        JButton jButton = new JButton("i");
        jButton.addActionListener(new q(this));
        this.WY.add(jButton);
    }

    private void xB() {
        JButton jButton = new JButton("e");
        jButton.addActionListener(new r(this));
        this.WY.add(jButton);
    }

    private void xC() {
        JButton jButton = new JButton("r");
        jButton.addActionListener(new s(this));
        this.WY.add(jButton);
    }

    private void xD() {
        JButton jButton = new JButton("Sair");
        jButton.addActionListener(new j(this));
        this.WY.add(jButton);
    }

    private void K(ah ah2) {
        if (a.SR.bs() != null) {
            a.SR.bs().setTc(ah2.ka().dS());
            a.SR.bs().setN(ah2.getNome());
            a.SR.bs().setA(a.SR.H() + a.SR.iU());
            a.SR.bs().setI("");
        }
    }

    private void xE() {
        JButton jButton = new JButton("Add Hum");
        jButton.addActionListener(new k(this));
        this.WY.add(jButton);
    }

    public static void c(JFrame jFrame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int n2 = (int)((dimension.getWidth() - (double)jFrame.getWidth()) / 2.0);
        int n3 = (int)((dimension.getHeight() - (double)jFrame.getHeight()) / 2.0);
        jFrame.setLocation(n2, n3);
    }

    static /* synthetic */ void a(h h3) {
        h3.Bc();
    }

    static /* synthetic */ JWindow b(h h3) {
        return h3.WW;
    }

    static /* synthetic */ void a(h h3, ah ah2) {
        h3.K(ah2);
    }
}

