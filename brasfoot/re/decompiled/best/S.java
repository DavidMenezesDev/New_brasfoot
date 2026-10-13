/*
 * Decompiled with CFR 0.152.
 */
package best;

import a.aP;
import a.ay;
import a.bV;
import a.bl;
import a.cR;
import a.d;
import a.dJ;
import a.dN;
import a.dV;
import a.da;
import a.dg;
import a.di;
import a.dk;
import a.dm;
import a.dz;
import a.eg;
import a.fB;
import a.gE;
import a.gO;
import a.h;
import a.hF;
import a.hU;
import a.hk;
import a.hz;
import a.iA;
import a.iu;
import a.jH;
import best.F;
import best.Z;
import best.ah;
import best.al;
import best.at;
import best.n;
import components.E;
import f.B;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sun.java2d.SunGraphicsEnvironment;

public class S {
    private static JScrollPane gH;
    private static E gI;
    private static JFrame cC;
    private static boolean gJ;
    private static hU gK;
    private static bV gL;
    private static dV gM;
    private static eg gN;
    private static da gO;
    private static hk gP;
    private static cR gQ;
    private static dz gR;
    private static jH Jn;
    private static int gS;
    private static int gT;
    private static JDialog gU;

    static {
        cC = new JFrame();
        gJ = false;
        gS = 0;
        gT = 0;
        gU = null;
    }

    public S(boolean bl2) {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/ball.png"));
        cC.setIconImage(imageIcon.getImage());
        cC.setTitle("Brasfoot");
        gI = new E(null, 0);
        GraphicsConfiguration graphicsConfiguration = cC.getGraphicsConfiguration();
        Rectangle rectangle = SunGraphicsEnvironment.getUsableBounds(graphicsConfiguration.getDevice());
        cC.setMaximizedBounds(new Rectangle(0, 0, rectangle.width, rectangle.height));
        System.out.println("screen size:" + rectangle.width + "  " + rectangle.height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int n2 = (int)dimension.getWidth();
        int n3 = (int)dimension.getHeight();
        System.out.println("screen size:" + n2 + "  " + n3);
        gS = rectangle.width;
        gT = rectangle.height;
        cC.setExtendedState((cC.getExtendedState() & 6) == 6 ? 0 : 6);
        cC.setUndecorated(true);
        cC.setDefaultCloseOperation(3);
        cC.setLayout(new BorderLayout());
        if (gS <= 1020 || gT <= 700) {
            gJ = true;
        }
        if (bl2) {
            gK = new hU(cC);
            gI.add((Component)gK, "Center");
            gI.setBackground(new Color(36, 91, 45));
            if (gJ) {
                gH = new JScrollPane();
                cC.add((Component)gH, "Center");
                gH.setViewportView(gI);
            } else {
                cC.add((Component)gI, "Center");
            }
        }
        n.a(cC);
        cC.pack();
        cC.setVisible(true);
    }

    public static JPanel aY(int n2) {
        gI = null;
        gI = n2 == 8 ? new E(null, 0) : new E(null, 0);
        gI.setBackground(new Color(36, 91, 45));
        if (n2 == 0) {
            gK = new hU(cC);
            gI.add((Component)gK, "Center");
            gI.setBackground(new Color(36, 91, 45));
        } else if (n2 == 1) {
            gL = new bV(cC);
            gI.add((Component)gL, "Center");
        } else if (n2 == 2) {
            gM = null;
            gP = null;
            gN = new eg(cC);
            gN.setPreferredSize(new Dimension(gS, gT));
            gI.add((Component)gN, "Center");
        } else if (n2 == 3) {
            gK = new hU(cC);
            gI.add((Component)gK, "Center");
        } else if (n2 == 4) {
            gM = null;
            gM = new dV(cC, gT);
            gM.setPreferredSize(new Dimension(1024, gT));
            gI.add((Component)gM, "Center");
        } else if (n2 == 5) {
            gP = null;
            gP = new hk(cC);
            gP.setPreferredSize(new Dimension(1024, 748));
            gI.add((Component)gP, "Center");
        } else if (n2 == 6) {
            gQ = null;
            gQ = new cR(cC);
            gQ.setPreferredSize(new Dimension(1024, 718));
            gI.add((Component)gQ, "Center");
        } else if (n2 == 7) {
            gO = new da(cC);
            gO.setPreferredSize(new Dimension(941, 718));
            gI.add((Component)gO, "Center");
        } else if (n2 == 8) {
            gR = new dz(cC);
            gR.setPreferredSize(new Dimension(941, 718));
            gI.add((Component)gR, "Center");
        } else if (n2 == 10) {
            Jn = new jH(cC);
            Jn.setPreferredSize(new Dimension(742, 577));
            gI.add((Component)Jn, "Center");
        }
        S.aZ(n2);
        if (n2 == 4) {
            return gM;
        }
        if (n2 == 5) {
            return gP;
        }
        return null;
    }

    private static void aZ(int n2) {
        cC.getContentPane().removeAll();
        if (gJ) {
            gH = new JScrollPane();
            cC.add((Component)gH, "Center");
            gH.setViewportView(gI);
        } else {
            cC.add((Component)gI, "Center");
        }
        cC.revalidate();
        cC.repaint();
        if (n2 == 1 && gL != null) {
            gL.on();
        }
        if (n2 == 2 && gN != null) {
            gN.on();
        }
        if (n2 == 5 && gP != null) {
            gP.on();
        }
        cC.setVisible(true);
    }

    public static hU iE() {
        return gK;
    }

    public static eg iF() {
        return gN;
    }

    public static JFrame db() {
        return cC;
    }

    public static void a(ah ah2, at at2, int n2) {
        JDialog jDialog = new JDialog(cC);
        dJ dJ2 = new dJ(jDialog, ah2, at2, n2);
        jDialog.add(dJ2);
        jDialog.setSize(306, 413);
        jDialog.setPreferredSize(new Dimension(306, 413));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(ArrayList arrayList, al al2, int n2) {
        JDialog jDialog = new JDialog(cC);
        gO gO2 = new gO(jDialog, arrayList, al2, n2);
        jDialog.add(gO2);
        jDialog.setSize(774, 724);
        jDialog.setPreferredSize(new Dimension(774, 724));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void l(al al2) {
        JDialog jDialog = new JDialog(cC);
        gE gE2 = new gE(jDialog, al2);
        jDialog.add(gE2);
        jDialog.setSize(711, 670);
        jDialog.setPreferredSize(new Dimension(711, 670));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void K(ArrayList arrayList) {
        JDialog jDialog = new JDialog(cC);
        bl bl2 = new bl(jDialog, arrayList);
        jDialog.add(bl2);
        jDialog.setSize(608, 304);
        jDialog.setPreferredSize(new Dimension(608, 304));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(al al2, al al3, ah ah2, int n2) {
        JDialog jDialog = new JDialog(cC);
        dm dm2 = new dm(jDialog, al2, al3, ah2, n2);
        jDialog.add(dm2);
        jDialog.setSize(475, 282);
        jDialog.setPreferredSize(new Dimension(475, 282));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void cX() {
        JDialog jDialog = new JDialog();
        dN dN2 = new dN(jDialog);
        jDialog.add(dN2);
        jDialog.setSize(407, 354);
        jDialog.setPreferredSize(new Dimension(407, 354));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(String string, boolean bl2) {
        JDialog jDialog;
        gU = jDialog = new JDialog();
        hz hz2 = new hz(jDialog, string, bl2);
        jDialog.add(hz2);
        jDialog.setSize(353, 103);
        jDialog.setPreferredSize(new Dimension(353, 103));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void iG() {
        JDialog jDialog = new JDialog(cC);
        hF hF2 = new hF(jDialog);
        jDialog.add(hF2);
        jDialog.setSize(799, 664);
        jDialog.setPreferredSize(new Dimension(799, 664));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(ah ah2, boolean bl2) {
        JDialog jDialog = new JDialog(cC);
        aP aP2 = new aP(jDialog, ah2, bl2);
        jDialog.add(aP2);
        jDialog.setSize(948, 706);
        jDialog.setPreferredSize(new Dimension(948, 706));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(F f2, JDialog jDialog) {
        JDialog jDialog2 = new JDialog(cC);
        dk dk2 = new dk(jDialog2, f2);
        jDialog2.add(dk2);
        jDialog2.setSize(786, 600);
        jDialog2.setPreferredSize(new Dimension(786, 600));
        jDialog2.setModal(true);
        jDialog2.setResizable(false);
        jDialog2.setLocationRelativeTo(null);
        jDialog2.setUndecorated(true);
        jDialog2.setVisible(true);
    }

    public static void v(ah ah2) {
        JDialog jDialog = new JDialog(cC);
        di di2 = new di(jDialog, ah2);
        jDialog.add(di2);
        int n2 = 886;
        int n3 = 762;
        int n4 = di2.pG();
        if (n4 < 5) {
            n3 = 219;
        } else if (n4 < 9) {
            n3 = 399;
        } else if (n4 < 13) {
            n3 = 579;
        }
        jDialog.setSize(n2, n3);
        jDialog.setPreferredSize(new Dimension(n2, n3));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(int n2, at at2) {
        JDialog jDialog = new JDialog(cC);
        ay ay2 = new ay(jDialog, at2);
        jDialog.add(ay2);
        jDialog.setSize(833, 735);
        jDialog.setPreferredSize(new Dimension(833, 735));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void b(int n2, at at2) {
        JDialog jDialog = new JDialog(cC);
        a.al al2 = new a.al(jDialog, n2, at2);
        jDialog.add(al2);
        int n3 = gT;
        if (n3 > 800) {
            n3 = 800;
        }
        jDialog.setSize(883, n3);
        jDialog.setPreferredSize(new Dimension(883, n3));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void e(al al2) {
        JDialog jDialog = new JDialog(cC);
        dg dg2 = new dg(jDialog, al2);
        jDialog.add(dg2);
        jDialog.setSize(971, 646);
        jDialog.setPreferredSize(new Dimension(971, 646));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(B b2, Z z2, int n2) {
        JDialog jDialog = new JDialog(cC);
        iu iu2 = new iu(jDialog, b2, z2, n2);
        jDialog.add(iu2);
        jDialog.setSize(372, 657);
        jDialog.setPreferredSize(new Dimension(372, 657));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(JTable jTable) {
        JDialog jDialog = new JDialog(cC);
        fB fB2 = new fB(jDialog, jTable);
        jDialog.add(fB2);
        jDialog.setSize(867, 620);
        jDialog.setPreferredSize(new Dimension(867, 620));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void w(ah ah2) {
        JDialog jDialog = new JDialog(cC);
        h h3 = new h(jDialog, ah2);
        jDialog.add(h3);
        jDialog.setSize(565, 575);
        jDialog.setPreferredSize(new Dimension(565, 575));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void x(ah ah2) {
        JDialog jDialog = new JDialog(cC);
        d d2 = new d(jDialog, ah2);
        jDialog.add(d2);
        jDialog.setSize(565, 575);
        jDialog.setPreferredSize(new Dimension(565, 575));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static void a(ah ah2, ah ah3, boolean bl2) {
        GraphicsConfiguration graphicsConfiguration = cC.getGraphicsConfiguration();
        Rectangle rectangle = SunGraphicsEnvironment.getUsableBounds(graphicsConfiguration.getDevice());
        cC.setMaximizedBounds(new Rectangle(0, 0, rectangle.width, rectangle.height));
        gS = rectangle.width;
        gT = rectangle.height;
        int n2 = 1024;
        int n3 = 718;
        if (gS >= 1366) {
            n2 = 1200;
        }
        if (gT >= 768) {
            n3 = 740;
        }
        JDialog jDialog = new JDialog(cC);
        iA iA2 = new iA(jDialog, ah2, ah3, bl2);
        jDialog.add(iA2);
        jDialog.setSize(n2, n3);
        jDialog.setPreferredSize(new Dimension(n2, n3));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public static JDialog iH() {
        return gU;
    }

    public static boolean iI() {
        return gJ;
    }
}

