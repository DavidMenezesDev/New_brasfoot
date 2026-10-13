/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dA;
import a.dB;
import a.dC;
import a.dD;
import a.dE;
import a.dF;
import best.C;
import best.F;
import best.N;
import best.ac;
import best.ah;
import best.aq;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class dz
extends JPanel {
    private JFrame Br = null;
    private JDialog FT;
    private int index = 0;
    private int FU = 0;
    private ah FV = null;
    private int FW = 0;
    private ArrayList FX = new ArrayList();
    public static ArrayList FY = new ArrayList();
    int FZ = 0;
    int Ga = -1;
    private static BufferedImage DH = null;
    private JLabel Gb;
    private JLabel Gc;
    private JLabel Gd;
    private JLabel Ge;
    private JTextField Gf;
    private JLabel ug;
    private JLabel uh;
    private JLabel ur;
    private JPanel vd;
    private JPanel we;
    private JPanel wf;
    private JLabel Gg;
    private JLabel Fq;
    private JLabel yA;
    private JLabel Gh;
    private JLabel Gi;
    private JLabel Gj;
    private JLabel Gk;
    private JLabel Gl;
    private JLabel Gm;

    public dz(JFrame jFrame) {
        this.Br = jFrame;
        this.mJ();
        this.mH();
        this.index = 0;
        int n2 = 0;
        while (n2 < c.a.SR.aN().size()) {
            if (((ah)c.a.SR.aN().get(n2)).kb() > 0L && ((ah)c.a.SR.aN().get(n2)).kw() < 35) {
                this.FX.add((ah)c.a.SR.aN().get(n2));
            }
            ++n2;
        }
        this.FV = (ah)this.FX.get(0);
        this.a((N)FY.get(0));
        this.pQ();
        this.mY();
        this.Gb.requestFocusInWindow();
    }

    private void mY() {
        this.a(this);
        this.a(this.Gb);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("st", new dA(this));
    }

    public dz(JDialog jDialog) {
        this.FT = jDialog;
        this.mJ();
        this.mH();
        this.index = 0;
        int n2 = 0;
        while (n2 < c.a.SR.aN().size()) {
            if (((ah)c.a.SR.aN().get(n2)).kb() > 0L && ((ah)c.a.SR.aN().get(n2)).kw() < 35) {
                this.FX.add((ah)c.a.SR.aN().get(n2));
            }
            ++n2;
        }
        this.FV = (ah)this.FX.get(0);
        this.FV = (ah)this.FX.get(0);
        this.a((N)FY.get(0));
        this.pQ();
    }

    private void pQ() {
        this.Gg.setIcon(this.FV.kU());
        this.Gg.setText(String.valueOf(this.FV.ka().dS()) + " (" + this.FV.getNome() + ") " + "dinheiro em caixa: " + C.c(this.FV.kb()));
    }

    private void a(N n2) {
        this.Gd.setVisible(false);
        this.Gl.setText("");
        this.Gc.setVisible(true);
        this.Ge.setVisible(true);
        this.Gf.setVisible(true);
        this.yA.setText("");
        this.Gf.setText("1");
        if (this.index == FY.size() - 1) {
            this.uh.setVisible(false);
            this.Gd.setVisible(false);
        } else {
            this.uh.setVisible(true);
            this.uh.setText("Pr\u00f3ximo leil\u00e3o: " + aq.rI[((N)FY.get(this.index + 1)).iA().getPosicao()] + " - " + ((N)FY.get(this.index + 1)).iA().getNome());
        }
        F f2 = n2.iA();
        this.FW = (int)Math.round((double)f2.fk() * 0.5);
        this.Gi.setText("Lance m\u00ednimo: " + C.c(this.FW));
        this.Gk.setText(String.valueOf(f2.fg().getNome()) + " est\u00e1 leiloando o jogador:");
        this.Fq.setIcon(n2.iA().fg().kP());
        this.Gj.setText(" " + aq.rI[n2.iA().getPosicao()] + "(" + aq.rK[n2.iA().getLado()] + ") - " + n2.iA().getNome());
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + n2.iA().getPais() + ".png"));
        this.Gm.setIcon(imageIcon);
        this.Gm.setText(ac.bl(n2.iA().getPais()));
        int[] nArray = new int[6];
        nArray = f2.gw();
        String string = "";
        if (f2.fP() && f2.fo() > ((best.a)c.a.SR.R().get(c.a.SR.J())).a().getTime().getTime()) {
            string = "Fim contus\u00e3o: " + best.a.a(f2.fo());
        }
        String string2 = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;" + Integer.toString(f2.fi()) + "&nbsp;&nbsp;&nbsp;";
        if (c.a.SR.isHabilidadeIndividual()) {
            string2 = "<html>\n<body><p style=\\\"padding:5; font-size:13\\\">\n&nbsp;&nbsp;&nbsp;&nbsp;<b>Gol:</b>" + Integer.toString(f2.gK()) + " <b>Des:</b> " + Integer.toString(f2.gN()) + " <b>Arm:</b> " + Integer.toString(f2.gO()) + " <b>Fin:</b> " + Integer.toString(f2.gP()) + " <b>Vel:</b> " + Integer.toString(f2.gJ()) + " <b>T\u00e9c:</b> " + Integer.toString(f2.gL()) + " <br><br><b>Pas:</b>" + Integer.toString(f2.gM()) + "&nbsp;&nbsp;&nbsp;";
        }
        String string3 = String.valueOf(string2) + "<b>Idade:</b>" + Integer.toString(f2.getIdade()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n" + "<b>Jogos:" + "</b>&nbsp;" + Integer.toString(nArray[0]) + "&nbsp;&nbsp;&nbsp;" + "<b>Gols:" + "</b>" + Integer.toString(nArray[1]) + "&nbsp;&nbsp;&nbsp;" + "<b>" + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>" + "Sal\u00e1rio:" + "</b>&nbsp;" + C.c(f2.fj()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>Caracter\u00edsticas :" + aq.qM[f2.getCr1()] + "/" + aq.qM[f2.getCr2()] + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + string + "<b><br>\n</p>\n</body></html>\n";
        this.Gh.setText(string3);
    }

    private void mH() {
        dB dB2 = new dB(this);
        this.Gb.addMouseListener(dB2);
        dC dC2 = new dC(this);
        this.Gc.addMouseListener(dC2);
        dD dD2 = new dD(this);
        this.Ge.addMouseListener(dD2);
        dE dE2 = new dE(this);
        this.Gd.addMouseListener(dE2);
        this.Gf.getDocument().addDocumentListener(new dF(this));
    }

    private void oK() {
        String string = String.valueOf(this.Gf.getText().toString()) + "000";
        if (!string.equals("") && string.matches("\\d+") && dz.B(string) && Integer.parseInt(string) >= 0) {
            this.Gl.setText(C.c(Integer.parseInt(string)));
            if ((long)Integer.parseInt(string) > this.FV.kb()) {
                this.Gl.setText("Sem dinheiro para essa oferta");
            }
        } else {
            this.Gl.setText("valor inv\u00e1lido");
        }
    }

    public static boolean B(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        return true;
    }

    private void pR() {
        String string = String.valueOf(this.Gf.getText().toString()) + "000";
        if (!string.equals("") && string.matches("\\d+") && dz.B(string) && Integer.parseInt(string) > 0) {
            int n2 = Integer.parseInt(string);
            if (this.FV.kw() >= 35) {
                this.Gl.setText("N\u00e3o h\u00e1 vagas no time");
            } else if ((long)n2 < this.FV.kb()) {
                this.dg(n2);
            } else {
                this.Gl.setText("Oferta maior que seu dinheiro em caixa");
            }
        } else {
            this.Gl.setText("valor inv\u00e1lido");
        }
    }

    private void dg(int n2) {
        if (n2 > this.FZ) {
            this.FZ = n2;
            this.Ga = this.FU;
        }
        this.pS();
    }

    private void pS() {
        if (this.FU + 1 >= this.FX.size()) {
            this.pT();
        } else {
            ++this.FU;
            this.FV = (ah)this.FX.get(this.FU);
            this.pQ();
        }
    }

    private void pT() {
        this.Gc.setVisible(false);
        this.Ge.setVisible(false);
        this.Gf.setVisible(false);
        this.Gl.setText("vendido ao:");
        int n2 = new Random().nextInt(100);
        double d2 = 0.45;
        if (n2 > 60) {
            d2 = 0.62;
        } else if (n2 > 80) {
            d2 = 0.82;
        }
        int n3 = (int)Math.round((double)this.FW * 2.5);
        int n4 = (int)Math.round((double)this.FW * d2);
        n4 = n4 + this.FZ + this.FW;
        if (this.FZ < this.FW) {
            this.FZ = n4;
            this.e(((N)FY.get(this.index)).iA(), ((N)FY.get(this.index)).iz());
        } else {
            ah ah2 = null;
            if (this.Ga < this.FX.size()) {
                ah2 = (ah)this.FX.get(this.Ga);
                if (this.FZ < n3 && n2 > 50 && ((N)FY.get(this.index)).iz() != null) {
                    ah2 = null;
                    this.FZ = n4;
                    this.e(((N)FY.get(this.index)).iA(), ((N)FY.get(this.index)).iz());
                } else {
                    this.e(((N)FY.get(this.index)).iA(), ah2);
                }
            } else {
                this.FZ = n4;
                this.e(((N)FY.get(this.index)).iA(), ((N)FY.get(this.index)).iz());
            }
        }
        if (this.index + 1 < FY.size()) {
            this.Gd.setVisible(true);
        }
    }

    private void e(F f2, ah ah2) {
        if (ah2 == null) {
            this.yA.setText("n\u00e3o houve compradores");
        } else {
            this.yA.setText(String.valueOf(ah2.getNome()) + " por " + C.c(this.FZ));
            f2.a(ah2, this.FZ, false, false, false);
        }
    }

    private void pU() {
        this.pS();
    }

    private void pV() {
        ++this.index;
        if (this.index < FY.size()) {
            this.FU = 0;
            this.FV = (ah)this.FX.get(0);
            this.FZ = 0;
            this.Ga = -1;
            this.a((N)FY.get(this.index));
            this.pQ();
        }
    }

    private void nx() {
        c.a.SR.ax();
    }

    private void mJ() {
        this.we = new JPanel();
        this.Fq = new JLabel();
        this.Gk = new JLabel();
        this.Gm = new JLabel();
        this.Gj = new JLabel();
        this.vd = new JPanel();
        this.Gh = new JLabel();
        this.wf = new JPanel();
        this.ur = new JLabel();
        this.Gl = new JLabel();
        this.Gf = new JTextField();
        this.yA = new JLabel();
        this.Gg = new JLabel();
        this.Ge = new JLabel();
        this.Gc = new JLabel();
        this.Gd = new JLabel();
        this.Gi = new JLabel();
        this.uh = new JLabel();
        this.Gb = new JLabel();
        this.ug = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setLayout(new b());
        this.we.setBackground(new Color(71, 148, 50));
        this.we.setBorder(BorderFactory.createLineBorder(new Color(65, 130, 46), 2));
        this.we.setLayout(new b());
        this.we.add((Component)this.Fq, new a(70, 90, 60, 60));
        this.Gk.setFont(new Font("Tahoma", 0, 18));
        this.Gk.setHorizontalAlignment(0);
        this.Gk.setForeground(new Color(255, 255, 51));
        this.Gk.setText("Cruzeiro est\u00e1 leiloando jogador");
        this.we.add((Component)this.Gk, new a(150, 40, 550, 34));
        this.Gm.setHorizontalAlignment(4);
        this.Gm.setText("jLabel8");
        this.we.add((Component)this.Gm, new a(470, 100, 150, -1));
        this.Gj.setBackground(new Color(255, 255, 255));
        this.Gj.setFont(new Font("Tahoma", 1, 12));
        this.Gj.setText("jLabel2");
        this.Gj.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Gj.setOpaque(true);
        this.we.add((Component)this.Gj, new a(250, 95, 379, 26));
        this.vd.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.vd.setOpaque(false);
        this.vd.setLayout(new b());
        this.Gh.setFont(new Font("Tahoma", 0, 12));
        this.Gh.setText("<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Idade:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>Jogos:</b>&nbsp;100&nbsp;&nbsp;&nbsp;<b>Gols:</b>23&nbsp;&nbsp;&nbsp;<b>Cart\u00f5es:</b>23<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:</b>&nbsp;5 milh\u00f5es 300 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Sal\u00e1rio:</b>&nbsp; 230 mil<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Marca\u00e7\u00e3o/desarme<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Contrato at\u00e9:</b>&nbsp; 20/12/2015<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>suspenso<br>\n</p>\n</body></html>\n");
        this.Gh.setVerticalAlignment(1);
        this.vd.add((Component)this.Gh, new a(10, 10, 410, 180));
        this.we.add((Component)this.vd, new a(220, 120, 430, -1));
        this.wf.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.wf.setOpaque(false);
        this.wf.setLayout(new b());
        this.ur.setFont(new Font("Tahoma", 0, 12));
        this.ur.setText("Fa\u00e7a sua oferta em milhares de $ ");
        this.wf.add((Component)this.ur, new a(20, 80, 240, -1));
        this.Gl.setFont(new Font("Tahoma", 1, 12));
        this.Gl.setHorizontalAlignment(0);
        this.Gl.setText("Sua oferta:");
        this.wf.add((Component)this.Gl, new a(10, 160, 420, -1));
        this.wf.add((Component)this.Gf, new a(130, 120, 160, 30));
        this.yA.setFont(new Font("Tahoma", 1, 14));
        this.yA.setForeground(new Color(255, 255, 51));
        this.yA.setHorizontalAlignment(0);
        this.yA.setText("jLabel6");
        this.wf.add((Component)this.yA, new a(10, 180, 440, 20));
        this.Gg.setFont(new Font("Tahoma", 1, 14));
        this.Gg.setText("jLabel7");
        this.wf.add((Component)this.Gg, new a(20, 50, 600, -1));
        this.Ge.setBackground(new Color(65, 130, 46));
        this.Ge.setForeground(new Color(255, 255, 102));
        this.Ge.setHorizontalAlignment(0);
        this.Ge.setText("N\u00e3o Ofertar");
        this.Ge.setToolTipText("");
        this.Ge.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
        this.Ge.setOpaque(true);
        this.wf.add((Component)this.Ge, new a(450, 120, 90, 30));
        this.Gc.setBackground(new Color(65, 130, 46));
        this.Gc.setForeground(new Color(255, 255, 102));
        this.Gc.setHorizontalAlignment(0);
        this.Gc.setText("Ofertar");
        this.Gc.setToolTipText("");
        this.Gc.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
        this.Gc.setOpaque(true);
        this.wf.add((Component)this.Gc, new a(340, 120, 90, 30));
        this.Gd.setBackground(new Color(65, 130, 46));
        this.Gd.setForeground(new Color(255, 255, 102));
        this.Gd.setHorizontalAlignment(0);
        this.Gd.setText("Ver pr\u00f3ximo leil\u00e3o");
        this.Gd.setToolTipText("");
        this.Gd.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
        this.Gd.setOpaque(true);
        this.wf.add((Component)this.Gd, new a(390, 70, 150, 40));
        this.Gi.setFont(new Font("Tahoma", 1, 14));
        this.Gi.setForeground(new Color(255, 255, 153));
        this.Gi.setHorizontalAlignment(0);
        this.Gi.setText("Lance inicial:");
        this.wf.add((Component)this.Gi, new a(100, 20, 440, -1));
        this.we.add((Component)this.wf, new a(120, 310, 640, 210));
        this.uh.setFont(new Font("Tahoma", 1, 12));
        this.uh.setText("Pr\u00f3ximo jogador em leil\u00e3o:");
        this.we.add((Component)this.uh, new a(130, 530, 450, -1));
        this.Gb.setBackground(new Color(65, 130, 46));
        this.Gb.setForeground(new Color(255, 255, 102));
        this.Gb.setHorizontalAlignment(0);
        this.Gb.setText("Continuar Jogo >>");
        this.Gb.setToolTipText("");
        this.Gb.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204)));
        this.Gb.setOpaque(true);
        this.we.add((Component)this.Gb, new a(610, 540, 150, 40));
        this.add((Component)this.we, new a(30, 60, 870, 610));
        this.ug.setBackground(new Color(65, 130, 46));
        this.ug.setFont(new Font("Tahoma", 1, 18));
        this.ug.setForeground(new Color(255, 255, 51));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Venda de jogador em leil\u00e3o");
        this.ug.setOpaque(true);
        this.add((Component)this.ug, new a(210, 30, 503, 30));
    }

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

    public static void X(ArrayList arrayList) {
        FY = arrayList;
    }

    static /* synthetic */ void a(dz dz2) {
        dz2.nx();
    }

    static /* synthetic */ void b(dz dz2) {
        dz2.pR();
    }

    static /* synthetic */ void c(dz dz2) {
        dz2.pU();
    }

    static /* synthetic */ void d(dz dz2) {
        dz2.pV();
    }

    static /* synthetic */ void e(dz dz2) {
        dz2.oK();
    }
}

